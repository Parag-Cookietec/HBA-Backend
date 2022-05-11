package gov.ifms.gst.service.impl;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.repository.LuLookUpInfoRepository;
import gov.ifms.gst.converter.PenalIntrestDTLConvertor;
import gov.ifms.gst.converter.PenalIntrestEntryConvertor;
import gov.ifms.gst.dto.GSTBankWisePenalInterestDto;
import gov.ifms.gst.dto.ManualEntryLstResDto;
import gov.ifms.gst.dto.PenalInterestLstResDto;
import gov.ifms.gst.dto.PenalIntrestEntryDto;
import gov.ifms.gst.entity.*;
import gov.ifms.gst.pagination.GstSearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.*;
import gov.ifms.gst.service.GSTPenalInterestService;
import gov.ifms.gst.util.DateUtil;
import gov.ifms.gst.util.GSTConstant;
import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class GSTPenalInterestServiceImpl implements GSTPenalInterestService {

    @Autowired
    private PenalIntrestEntryConvertor convertor;

    @Autowired
    private PenalIntrestDTLConvertor dtlConvertor;

    @Autowired
    private PanelIntrestEntryRepository repository;

    @Autowired
    private PanelIntrestDTLRepository intrestDTLRepository;

    @Autowired
    private GSTBankRateMasterRepository bankRateMasterRepository;

    @Autowired
    private LuLookUpInfoRepository luLookUpInfoRepository;

    @Autowired
    private GstSaDaChallanMappingRepository gstSaDaChallanMappingRepository;

    @Autowired
    private GSTCINFileDataRepository gstcinFileDataRepository;

    @Autowired
    private GstWfActionConfigService gstWfActionConfigService;

    @Autowired
    private GstSearchCriteria searchCriteria;

    @Override
    public GSTBankWisePenalInterestDto getBankwisePenalInterestUsingMonthAndYear(Long bankId, Long monthId, Long yearId) {

        EDPLuLookUpInfoEntity monthLookUpInfo = luLookUpInfoRepository.findBylookUpInfoId(monthId);
        EDPLuLookUpInfoEntity yearLookUpInfo = luLookUpInfoRepository.findBylookUpInfoId(yearId);

        LocalDate fromDate = LocalDate.of(yearLookUpInfo.getLookUpInfoValue(), monthLookUpInfo.getLookUpInfoValue(), 01);

        List<GstSaDaChallanMapping> gstSaDaChallanMappings = gstSaDaChallanMappingRepository.
                findByBankIdAndRbiFileTranxnAcceptanceDttmLessThanEqualAndRbiFileTranxnAcceptanceDttmGreaterThanEqual(bankId,
                        GSTUtility.convertStringToDate(LocalDate.of(yearLookUpInfo.getLookUpInfoValue(), monthLookUpInfo.getLookUpInfoValue(),
                                fromDate.lengthOfMonth()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                        GSTUtility.convertStringToDate(fromDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

        Double penalInterestAmount = 0.0;

        for (GstSaDaChallanMapping mapping : gstSaDaChallanMappings) {
            LocalDate txnDt = DateUtil.convertToLocalDate(mapping.getRbiFileTranxn().getTransactionDttm());
            LocalDate accDt = DateUtil.convertToLocalDate(mapping.getRbiFileTranxn().getAcceptanceDttm());

            //If buffer of T+1 exceeds
            if (txnDt.plusDays(2).isBefore(accDt)) {
                penalInterestAmount = penalInterestAmount + calculatePenalInterestOfTxn(yearLookUpInfo.getLookUpInfoValue(), monthLookUpInfo.getLookUpInfoValue(), fromDate, mapping.getRbiFileTranxn(), txnDt, accDt);
            }
        }

        Double sumOfCurrRecvAmount = intrestDTLRepository.getSumOfCurrRecvAmount(yearLookUpInfo.getLookUpInfoId(), monthLookUpInfo.getLookUpInfoId(), bankId);

        GSTBankWisePenalInterestDto gstBankWisePenalInterestDto = new GSTBankWisePenalInterestDto(yearLookUpInfo.getLookUpInfoValue().longValue(),
                monthLookUpInfo.getLookUpInfoValue().longValue(), Double.parseDouble(String.format("%.2f", penalInterestAmount)),
                Double.parseDouble(String.format("%.2f", sumOfCurrRecvAmount != null?sumOfCurrRecvAmount:0.00)), Double.parseDouble(String.format("%.2f", sumOfCurrRecvAmount != null? penalInterestAmount - sumOfCurrRecvAmount:penalInterestAmount)));
        return gstBankWisePenalInterestDto;
    }


    private Double calculatePenalInterestOfTxn(int month, int year, LocalDate fromDate, GstRbiFilesTranxn txn, LocalDate txnDt, LocalDate accDt) {

        SpecificationImpl<GSTBankRateMaster> bankRateMasterspecImpl = new SpecificationImpl<>();
        bankRateMasterspecImpl.with("effectiveToDate", ">", DateUtil.convertToDate(txnDt.plusDays(1)));
        bankRateMasterspecImpl.with("effectiveFromDate", "<=", DateUtil.convertToDate(accDt));

        List<GSTBankRateMaster> gstBankRateMasters = bankRateMasterRepository.findAll(bankRateMasterspecImpl.build());

        Double claimAmount = 0.0;

        for (GSTBankRateMaster bnkRtMstr : gstBankRateMasters) {

            Double calculatedInterestOnSGST = calculateInterestAmount(fromDate, txn.getTotalTransAmt(), txnDt, accDt, bnkRtMstr);

            if(calculatedInterestOnSGST < 500){

                EODCINFileData eodcinFileData = gstcinFileDataRepository.findByCinNo(txn.getEndToEndId()).get();

                Double calculatedInterestOnTotalGST = calculateInterestAmount(fromDate, eodcinFileData.getTotalAmt(), txnDt, accDt, bnkRtMstr);

                if (calculatedInterestOnTotalGST > 500){
                    claimAmount = claimAmount + calculatedInterestOnSGST;
                }
            }else {
                claimAmount = claimAmount + calculatedInterestOnSGST;
            }
        }

        return claimAmount;
    }

    private Double calculateInterestAmount(LocalDate fromDate, Double amt, LocalDate txnDt, LocalDate accDt, GSTBankRateMaster bnkRtMstr) {
        LocalDate claimFromDate;
        LocalDate claimToDate;

        if (bnkRtMstr.getEffectiveFromDate().isBefore(txnDt.plusDays(2)))
            claimFromDate = txnDt.plusDays(2);
        else
            claimFromDate = bnkRtMstr.getEffectiveFromDate();

        if (bnkRtMstr.getEffectiveToDate().isAfter(accDt))
            claimToDate = accDt;
        else
            claimToDate = bnkRtMstr.getEffectiveToDate();

        int daysOfDelay = claimToDate.compareTo(claimFromDate);

        Double interestRate = (daysOfDelay <= 5 && amt <= 100000) || amt > 100000  ? bnkRtMstr.getBankRate() : (bnkRtMstr.getBankRate() + bnkRtMstr.getAdditionalRate());

        return (amt * (interestRate / (12 * 100)) * (Double.valueOf(daysOfDelay) / Double.valueOf(fromDate.lengthOfMonth())));
    }

//	@Override
//	public GSTPenalInterestDto savePenalInterest(PanelIntrestEntryDto dto) {
//		return convertor.toDTO(repository.save(convertor.toEntity(dto)));
//
//
    // TODO Putting dummy data for now, need to replace with actual data
//		GSTPenalInterestDto dtoResult = new GSTPenalInterestDto();
//		dtoResult.setId((long) 1001);
//		dtoResult.setBankId((long) 2001);
//		return dtoResult;
//	}

    /**
     * @return
     */
    @Override
    public PagebleDTO<PenalIntrestEntryDto> listingPenalInterest(PageDetails pageDetail) throws CustomException {

        try {
            PageRequest pageable = null;
            SpecificationImpl<PenalIntrestEntry> spec = new SpecificationImpl<>();
            spec.with("activeStatus", ":", 1);
            pageable = pageDetail.getPageDetails(pageDetail);
            Specification<PenalIntrestEntry> dataSpec = searchCriteria.getPenalSearchSpecificationDetail(spec,
                    pageDetail.getJsonArr());
            Page<PenalIntrestEntry> page = repository.findAll(dataSpec, pageable);
            return new PagebleDTO(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                    convertor.toDTO(page.getContent()));
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    @Override
    public PenalIntrestEntryDto savePenalInterest(PenalIntrestEntryDto dto) throws CustomException {

        try {
            EDPLuLookUpInfoEntity challanCashModeOfReceipt = luLookUpInfoRepository.findByLookUpInfoName("Challan/Cash");

            if (challanCashModeOfReceipt.getLookUpInfoId() != dto.getReceiptModeId() &&
                    repository.countByChqCeferenceNo(dto.getChqCeferenceNo()) > 0 && dto.getId()==0l) {
                throw new CustomException(400, "Cheque/Draft/Reference Number should be unique.");
            }

            PenalIntrestEntry penalIntrestEntry = convertor.toEntity(dto);
            if (penalIntrestEntry.getReferenceNo() == null) {
                try {
                    penalIntrestEntry.setReferenceNo(getTransactionNo());
                    penalIntrestEntry.setReferenceDt(new Date());
                } catch (CustomException e) {
                    e.printStackTrace();
                }
            }
            List<PenalIntrestDTL> penalIntrestDTLList = dtlConvertor.toEntity(dto.getPenalDetailsList());
            penalIntrestDTLList.forEach(entry -> entry.setPenalIntrestEntry(penalIntrestEntry));
            penalIntrestEntry.setPenalIntrestDTLList(penalIntrestDTLList);
            Long menuId = dto.getMenuId();
            dto = convertor.toDTO(repository.save(penalIntrestEntry));
            if(menuId!=null && dto.getId()!=0l){
                gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(menuId, dto.getId()));
            }
        }catch (CustomException e){
            throw e;
        }catch (Exception e){
            throw new CustomException(500, "Failed to save the PenalInterest");
        }
        return dto;
    }

    @Override
    public PenalIntrestEntryDto getById(Long id) {
        PenalIntrestEntry penalIntrestEntry = repository.findById(id).get();
        return convertor.toDTO(penalIntrestEntry);
    }

    @Override
    public void deleteById(Long id) {
        PenalIntrestEntry penalIntrestEntry = repository.findById(id).get();
        penalIntrestEntry.setActiveStatus(0);
        repository.save(penalIntrestEntry);
    }

    private String getTransactionNo() throws CustomException {
        Map<String, Object> map = new LinkedHashMap<>();

        map.put(Constant.TRN_SCREEN, PenalIntrestEntry.TRN_SCREEN_PES);
        String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
        List<Object[]> nextSequenceNumber = repository.callStoredProcedure(procName, map);
        if (!Utils.isEmpty(nextSequenceNumber)) {
            return (String) nextSequenceNumber.get(0)[0];
        } else {
            throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
        }
    }

    @Override
    public PagebleDTO<PenalInterestLstResDto> getPenalInterestWfList(PageDetails pageDetail) throws CustomException {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
        map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
        List<SearchParam> searchParams = pageDetail.getJsonArr();
        if (searchParams != null && !searchParams.isEmpty()) {
            searchParams.forEach(search -> map.put(GstDBConstants.getPenalInterestListing().get(search.getKey()),
                    search.getValue()));
        }
        GstDBConstants.getPenalInterestListing()
                .entrySet().stream()
                .filter(e -> !map.containsKey(e.getValue()))
                .forEach(e -> map.put(e.getValue(),""));

        String procName = GstDBConstants.GST_SCHEMA.concat(Constant.DOT.concat(GstDBConstants.SP_PENAL_INTEREST_ENTRY_LISTING));
        List<PenalInterestLstResDto> objectSp = this.callStoreProc(procName, map, PenalInterestLstResDto.class);
        long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
        return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
    }

    /**
     * Call store proc.
     *
     * @param <T>      the generic type
     * @param procName the proc name
     * @param map      the map
     * @param view     the view
     *
     * @return the list
     * @throws CustomException the custom exception
     */
    private <T> List<T> callStoreProc(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
        List<Object[]> objectSp = repository.callStoredProcedure(procName, map);
        return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
    }
}

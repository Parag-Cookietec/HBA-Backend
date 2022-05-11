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
import gov.ifms.gst.converter.AccManualEntryConverter;
import gov.ifms.gst.converter.CreditEntryConverter;
import gov.ifms.gst.converter.DebitEntryConverter;
import gov.ifms.gst.dto.*;
import gov.ifms.gst.entity.*;
import gov.ifms.gst.pagination.ManualEntrySearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.*;
import gov.ifms.gst.service.ManualEntryService;
import gov.ifms.gst.util.GSTConstant;
import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ManualEntryServiceImpl implements ManualEntryService {

    @Autowired
    private AccManualEntryConverter hdrConverter;

    @Autowired
    private CreditEntryConverter crEntryConverter;

    @Autowired
    private DebitEntryConverter drEntryConverter;

    @Autowired
    private TPAOAccManualEntryHdrRepository hdrRepository;

    @Autowired
    private MsMajorHeadRepository msMajorHeadRepository;

    @Autowired
    private MsSubMajorHeadRepository msSubMajorHeadRepository;

    @Autowired
    private MsMinorHeadRepository msMinorHeadRepository;

    @Autowired
    private MsSubHeadRepository msSubHeadRepository;

    @Autowired
    private MsDetailHeadRepository msDetailHeadRepository;

    @Autowired
    private MsObjectHeadRepository msObjectHeadRepository;

    @Autowired
    private GSTCINFileDataRepository gstcinFileDataRepository;

    @Autowired
    private GstWfActionConfigService gstWfActionConfigService;

    @Autowired
    private ManualEntrySearchCriteria searchCriteria;

    @Autowired
    private LuLookUpInfoRepository luLookUpInfoRepository;

    @Override
    public List<ManualEntryTypeDto> getTypeList() {

        ArrayList<ManualEntryTypeDto> dtoList = new ArrayList<ManualEntryTypeDto>();

        List<EDPLuLookUpInfoEntity> edpLuLookUpInfoEntities = luLookUpInfoRepository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(522L, 1);

        edpLuLookUpInfoEntities.forEach(it -> {
            dtoList.add(new ManualEntryTypeDto(it.getLookUpInfoId(), it.getLookUpInfoName()));
        });

        return dtoList;
    }

    @Override
    public List<HeadDto> getMajorHeadList() {
        List<HeadDto> headDtos = new ArrayList<>();
        List<MsMajorHeadEntity> msMajorHeadEntityList = msMajorHeadRepository.findAll();
		List<MsMajorHeadEntity> msMajorHeadEntityListFiltered = msMajorHeadEntityList.stream()
        														.filter(Objects::nonNull)
        														.filter(e -> e.getMajorHeadCode().equals("8658") || e.getMajorHeadCode().equals("8670") || e.getMajorHeadCode().equals("8675") || e.getMajorHeadCode().equals("0006"))
        														.collect(Collectors.toList());

        for (MsMajorHeadEntity msMajorHeadEntity : msMajorHeadEntityListFiltered) {
            headDtos.add(new HeadDto(msMajorHeadEntity.getMajorHeadId(),
                    msMajorHeadEntity.getMajorHeadName(), msMajorHeadEntity.getMajorHeadCode(),
                    msMajorHeadEntity.getMajorHeadCodeName(), msMajorHeadEntity.getMajorHeadDesc()));
        }
        return headDtos;
    }

    @Override
    public List<HeadDto> getSubMajorHeadList(HeadwiseDetailDto dto) {
        List<HeadDto> headDtos = new ArrayList<>();
        List<MsSubMajorHeadEntity> MsSubMajorHeadEntitys = msSubMajorHeadRepository
                .findByMajorHeadEntityMajorHeadIdOrderBySubMajorHeadCode(dto.getMajorheadId());
        for (MsSubMajorHeadEntity MsSubMajorHeadEntity : MsSubMajorHeadEntitys) {
            HeadDto headDto = new HeadDto();
            headDto.setId(MsSubMajorHeadEntity.getSubMajorHeadId());
            headDto.setName(MsSubMajorHeadEntity.getSubmajorHeadName());
            headDto.setCode(MsSubMajorHeadEntity.getSubMajorHeadCode());
            headDto.setCodeName(MsSubMajorHeadEntity.getSubMajorHeadCodeNames());
            headDto.setDescription(MsSubMajorHeadEntity.getSubMajorHeadDesc());
            headDtos.add(headDto);
        }
        return headDtos;
    }

    @Override
    public List<HeadDto> getMinorHeadList(HeadwiseDetailDto dto) {
        List<HeadDto> headDtos = new ArrayList<>();
        List<MsMinorHeadEntity> MsMinorHeadEntitys = msMinorHeadRepository
                .findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdOrderByMinorHeadCode(
                        dto.getMajorheadId(), dto.getSubmajorheadId());
        for (MsMinorHeadEntity MsMinorHeadEntity : MsMinorHeadEntitys) {
            HeadDto headDto = new HeadDto();
            headDto.setId(MsMinorHeadEntity.getMinorHeadId());
            headDto.setCode(MsMinorHeadEntity.getMinorHeadCode());
            headDto.setName(MsMinorHeadEntity.getMinorHeadName());
            headDto.setCodeName(MsMinorHeadEntity.getMinorHeadCodeName());
            headDto.setDescription(MsMinorHeadEntity.getMinorHeadDesc());
            headDtos.add(headDto);
        }
        return headDtos;
    }

    @Override
    public List<HeadDto> getSubHeadList(HeadwiseDetailDto dto) {
        List<HeadDto> headDtos = new ArrayList<>();
        List<MsSubHeadEntity> MsSubHeadEntitys = msSubHeadRepository
                .findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdOrderBySubHeadCodeAsc(
                        dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId());
        for (MsSubHeadEntity MsSubHeadEntity : MsSubHeadEntitys) {
            HeadDto headDto = new HeadDto();
            headDto.setId(MsSubHeadEntity.getSubHeadId());
            headDto.setName(MsSubHeadEntity.getSubHeadName());
            headDto.setCode(MsSubHeadEntity.getSubHeadCode());
            headDto.setCodeName(MsSubHeadEntity.getSubHeadCodeName());
            headDto.setDescription(MsSubHeadEntity.getSubHeadDesc());
            headDtos.add(headDto);
        }
        return headDtos;
    }

    @Override
    public List<HeadDto> getDetailsHeadList(HeadwiseDetailDto dto) {
        List<HeadDto> headDtos = new ArrayList<>();
        List<MsDetailHeadEntity> MsDetailHeadEntitys = msDetailHeadRepository
                .findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndSubHeadEntitySubHeadIdOrderByDetailHeadCode(
                        dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId(),
                        dto.getSubheadId());
        for (MsDetailHeadEntity MsDetailHeadEntity : MsDetailHeadEntitys) {
            HeadDto headDto = new HeadDto();
            headDto.setId(MsDetailHeadEntity.getDetailHeadId());
            headDto.setName(MsDetailHeadEntity.getDetailHeadName());
            headDto.setCode(MsDetailHeadEntity.getDetailHeadCode());
            headDto.setCodeName(MsDetailHeadEntity.getDetailHeadCodeName());
            headDto.setDescription(MsDetailHeadEntity.getDetailHeadDesc());
            headDtos.add(headDto);
        }
        return headDtos;
    }

    @Override
    public List<HeadDto> getObjectHeadList() {

        Pageable pageable = PageRequest.of(0, 5);
        List<HeadDto> headDtos = new ArrayList<>();
        Page<MsObjectHeadEntity> msObjectHeadEntityPage = msObjectHeadRepository.findAll(pageable);
        for (MsObjectHeadEntity msObjectHeadEntity : msObjectHeadEntityPage.getContent()) {
            headDtos.add(new HeadDto(msObjectHeadEntity.getObjectId(),
                    msObjectHeadEntity.getObjectName(), msObjectHeadEntity.getObjectCode(),
                    msObjectHeadEntity.getObjectCodeName(), msObjectHeadEntity.getObjectDesc()));
        }
        return headDtos;
    }

    @Override
    public ManualEntryDto saveOrUpdate(ManualEntryDto dto) throws CustomException {

        Optional<EODCINFileData> eodcinFileDataOptional = gstcinFileDataRepository.findByCinNo(dto.cinNo);

        if (!eodcinFileDataOptional.isPresent() || (eodcinFileDataOptional.isPresent() && eodcinFileDataOptional.get().getSgstTotal().equals(dto.getTotalDebitAmt()))) {

            AccManualEntryHdr hrdEntity = hdrConverter.toEntity(dto);
            hrdEntity.setReferenceDt(new Date());
            hrdEntity.setManualEntryDt(new Date());
            if (hrdEntity.getReferenceNo() == null) {
                try {
                    hrdEntity.setReferenceNo(getTransactionNo());
                    hrdEntity.setReferenceDt(new Date());
                } catch (CustomException e) {
                    e.printStackTrace();
                }
            }
            List<AccManualEntryCr> creditEntries = crEntryConverter.toEntity(dto.getCreditEntries());
            creditEntries.forEach(entry -> entry.setAccManualHdr(hrdEntity));
            hrdEntity.setCreditEntries(creditEntries);
            List<AccManualEntryDr> debitEntries = drEntryConverter.toEntity(dto.getDebitEntries());
            debitEntries.forEach(entry -> entry.setAccManualHdr(hrdEntity));
            hrdEntity.setDebitEntries(debitEntries);
            Long menuId = dto.getMenuId();
            dto = hdrConverter.toDTO(hdrRepository.save(hrdEntity));
            if (menuId != null && dto.getId() != null) {
                gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(menuId, dto.getId()));
            }
            return dto;
        } else {
            throw new CustomException(400, "Total of Debit/Credit does not match SGST Total of GST entry");
        }
    }

    @Override
    public PagebleDTO<ManualEntryDto> getManualEntryList(PageDetails pageDetail) throws CustomException {

        PageRequest pageable = null;
        SpecificationImpl<AccManualEntryHdr> spec = new SpecificationImpl<>();
        spec.with("activeStatus", ":", 1);
        pageable = pageDetail.getPageDetails(pageDetail);
        Specification<AccManualEntryHdr> dataSpec = searchCriteria.getManualEntrySpecificationDetail(spec,
                pageDetail.getJsonArr());
        Page<AccManualEntryHdr> page = hdrRepository.findAll(dataSpec, pageable);
        return new PagebleDTO(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                hdrConverter.toDTO(page.getContent()));
    }

    @Override
    public ManualEntryDto getById(Long id) {

        return hdrConverter.toDTO(hdrRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        AccManualEntryHdr accManualEntryHdr = hdrRepository.findById(id).get();
        accManualEntryHdr.setActiveStatus(0);
        hdrRepository.save(accManualEntryHdr);
    }

    @Override
    public PagebleDTO<ManualEntryLstResDto> getManualEntryWfList(PageDetails pageDetail) throws CustomException {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
        map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
        List<SearchParam> searchParams = pageDetail.getJsonArr();
        if (searchParams != null && !searchParams.isEmpty()) {
            searchParams.forEach(search -> map.put(GstDBConstants.getManAccEntrListing().get(search.getKey()),
                    search.getValue()));
        }
        GstDBConstants.getManAccEntrListing()
                .entrySet().stream()
                .filter(e -> !map.containsKey(e.getValue()))
                .forEach(e -> map.put(e.getValue(), ""));

        String procName = GstDBConstants.GST_SCHEMA.concat(Constant.DOT.concat(GstDBConstants.SP_ACC_MANUAL_ENTRY_LISTING));
        List<ManualEntryLstResDto> objectSp = this.callStoreProc(procName, map, ManualEntryLstResDto.class);
        long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
        return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
    }

    private String getTransactionNo() throws CustomException {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.TRN_SCREEN, AccManualEntryHdr.TRN_SCREEN_MES);
        String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
        List<Object[]> nextSequenceNumber = hdrRepository.callStoredProcedure(procName, map);
        if (!Utils.isEmpty(nextSequenceNumber)) {
            return (String) nextSequenceNumber.get(0)[0];
        } else {
            throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
        }
    }

    /**
     * Call store proc.
     *
     * @param <T>      the generic type
     * @param procName the proc name
     * @param map      the map
     * @param view     the view
     * @return the list
     * @throws CustomException the custom exception
     */
    private <T> List<T> callStoreProc(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
        List<Object[]> objectSp = hdrRepository.callStoredProcedure(procName, map);
        return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
    }
}

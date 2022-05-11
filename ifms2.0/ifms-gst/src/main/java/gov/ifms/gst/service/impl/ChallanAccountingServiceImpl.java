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
import gov.ifms.gst.converter.AccDebitEntryConvertor;
import gov.ifms.gst.converter.AccountCreditEntryConvertor;
import gov.ifms.gst.dto.*;
import gov.ifms.gst.entity.*;
import gov.ifms.gst.pagination.ChallanSearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.*;
import gov.ifms.gst.service.ChallanAccountingService;
import gov.ifms.gst.util.DateUtil;
import gov.ifms.gst.util.GSTConstant;
import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.workflow.dto.WfActionConfigSubmitTrnDto;
import gov.ifms.gst.workflow.dto.WfActionConfigTrnDto;
import gov.ifms.gst.workflow.dto.WfUserDetails;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChallanAccountingServiceImpl implements ChallanAccountingService {

    @Autowired
    private TPAORbiFilesTranxnRepository tpaoRbiFilesTranxnRepo;

    @Autowired
    private RBIFileTranxnRepository rbiFileTranxnRepository;

    @Autowired
    private GSTCINFileDataRepository gstcinFileDataRepository;

    @Autowired
    private AccountCreditEntryConvertor creditEntryConvertor;

    @Autowired
    private AccDebitEntryConvertor debitEntryConvertor;

    @Autowired
    private RBIAccHdrRepository rbiAccHdrRepository;

    @Autowired
    private AccountingCreditEntryRepository creditEntryRepository;

    @Autowired
    private AccDebitEntryRepository debitEntryRepository;

    @Autowired
    private ChallanSearchCriteria searchCriteria;

    @Autowired
    private GenerateMoeHdrRepository moeHdrRepository;

    @Autowired
    private LuLookUpInfoRepository luLookUpInfoRepository;

    @Autowired
    private MsGstPartyRepository msGstPartyRepository;

    @Autowired
    private GSTMsBankRepository gstMsBankRepository;

    private ConcurrentHashMap<String, EntryConfig> config;
    private ConcurrentHashMap<Integer, String> bankHeadMap;

    @Autowired
    private GstWfActionConfigService gstWfActionConfigService;

    @PostConstruct
    private void init() {

        config = new ConcurrentHashMap<>();
        config.put("RAT", new EntryConfig(628, "0006", 1930, "00", 2284, "500", "01", 6528, 0, null, "RECEIPTS AWAITING TRANSFER (RAT)"));
        config.put("CREDIT_PUB", new EntryConfig(612, "8658", 1155, "00", 1631, "108", "01", 3963, 0, null, "SUSPENSE ACCOUNTS - "));
        config.put("CREDIT_PVT", new EntryConfig(612, "8658", 1155, "00", 1543, "138", "01", 3972, 0, null, "SUSPENSE ACCOUNTS - "));
        config.put("DEBIT", new EntryConfig(618, "8675", 1161, "00", 1985, "106", "05", 3991, 0, null, "DEPOSIT WITH RESERVE BANK - "));

        bankHeadMap = new ConcurrentHashMap<>();
        bankHeadMap.put(24, "02:Allahabad Bank:Pub");
        bankHeadMap.put(27, "03:Andhra Bank:Pub");
        bankHeadMap.put(2, "04:Bank of Baroda:Pub");
        bankHeadMap.put(12, "04:Bank of Baroda:Pub");
        bankHeadMap.put(11, "05:Dena Bank:Pub");
        bankHeadMap.put(4, "06:Bank of India:Pub");
        bankHeadMap.put(22, "06:Bank of India:Pub");
        bankHeadMap.put(54, "07:Central Bank of India:Pub");
        bankHeadMap.put(53, "08:Canara Bank:Pub");
        bankHeadMap.put(30, "09:Corporation Bank:Pub");
        bankHeadMap.put(31, "10:IDBI Bank:Pub");
        bankHeadMap.put(55, "11:Indian Bank:Pub");
        bankHeadMap.put(9, "12:Indian Overseas Bank:Pub");
        bankHeadMap.put(33, "13:Bank of Maharashtra:Pub");
        bankHeadMap.put(23, "14:Oriental Bank of Commerce:Pub");
        bankHeadMap.put(46, "15:Punjab and Sind Bank:Pub");
        bankHeadMap.put(13, "16:Punjab National Bank:Pub");
        bankHeadMap.put(1, "17:State bank of India:Pub");
        bankHeadMap.put(15, "17:State bank of India:Pub");
        bankHeadMap.put(16, "18:Syndicate Bank:Pub");
        bankHeadMap.put(17, "19:Union Bank of India:Pub");
        bankHeadMap.put(10, "19:Union Bank of India:Pub");
        bankHeadMap.put(20, "20:Uco Bank:Pub");
        bankHeadMap.put(18, "21:United Bank of India:Pub");
        bankHeadMap.put(21, "22:Vijaya Bank:Pub");
        bankHeadMap.put(6, "41:HDFC Bank:Pvt");
        bankHeadMap.put(34, "41:HDFC Bank:Pvt");
        bankHeadMap.put(35, "42:ICICI Bank:Pvt");
        bankHeadMap.put(81, "43:Jammu & Kashmir Bank:Pvt");
        bankHeadMap.put(5, "44:Axis Bank:Pvt");
        bankHeadMap.put(32, "44:Axis Bank:Pvt");

    }


    @Override
    public PagebleDTO<GstRbiFilesTranxn> getChallanList(PageDetails pageDetail) throws CustomException {
        PageRequest pageable = null;
        SpecificationImpl<GstRbiFilesTranxn> spec = new SpecificationImpl<>();
        pageable = pageDetail.getPageDetails(pageDetail);
        Specification<GstRbiFilesTranxn> dataSpec = searchCriteria.getRbiFileTranxnSpecificationDetail(spec,
                pageDetail.getJsonArr());

        Page<GstRbiFilesTranxn> page = tpaoRbiFilesTranxnRepo.findAll(dataSpec, pageable);

        List<AccountScreenChallanDto> accountScreenChallanDtoList = new ArrayList<>();

        for (GstRbiFilesTranxn gstRbiFilesTranxn : page.getContent()) {

            Optional<EODCINFileData> optionalEODCINFileData = gstcinFileDataRepository.findByCinNo(gstRbiFilesTranxn.getEndToEndId());
            EODCINFileData eodcinFileData = optionalEODCINFileData.isPresent() ? optionalEODCINFileData.get() : null;


            MsGstParty msGstParty = null;

            if (eodcinFileData != null)
                msGstParty = msGstPartyRepository.findByGstin(eodcinFileData.getGstinTmpidNo());

            accountScreenChallanDtoList.add(new AccountScreenChallanDto(gstRbiFilesTranxn.getId(),
                    gstRbiFilesTranxn.getEndToEndId(), gstRbiFilesTranxn.getTransactionDttm(),
                    gstRbiFilesTranxn.getTransactionAmt(), gstRbiFilesTranxn.getRbiFileHdr().getFileRecvDt(),
                    gstRbiFilesTranxn.getTransactionDttm(), msGstParty != null ? msGstParty.getFirmName() : "-", "-", "Created", gstRbiFilesTranxn.getGstSaDaChallanMapping().getBankId()));
        }

        return new PagebleDTO(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                accountScreenChallanDtoList);
    }

    @Override
    public AccountScreenChallanDto getById(Long id) {
        GstRbiFilesTranxn gstRbiFilesTranxn = tpaoRbiFilesTranxnRepo.findById(id).get();

        Optional<EODCINFileData> optionalEODCINFileData = gstcinFileDataRepository.findByCinNo(gstRbiFilesTranxn.getEndToEndId());
        EODCINFileData eodcinFileData = optionalEODCINFileData.isPresent() ? optionalEODCINFileData.get() : null;


        MsGstParty msGstParty = null;

        if (eodcinFileData != null)
            msGstParty = msGstPartyRepository.findByGstin(eodcinFileData.getGstinTmpidNo());

        return new AccountScreenChallanDto(gstRbiFilesTranxn.getId(),
                gstRbiFilesTranxn.getEndToEndId(), gstRbiFilesTranxn.getTransactionDttm(),
                gstRbiFilesTranxn.getTotalTransAmt(), gstRbiFilesTranxn.getRbiFileHdr().getFileRecvDt(),
                gstRbiFilesTranxn.getTransactionDttm(), msGstParty != null ? msGstParty.getFirmName() : "-", "-", "Created", gstRbiFilesTranxn.getGstSaDaChallanMapping().getBankId());
    }

    @Override
    public ReconcileDetailsDto getReconcileDetails(Long id) {

        GstRbiFilesTranxn gstRbiFilesTranxn = tpaoRbiFilesTranxnRepo.findById(id).get();

        Optional<EODCINFileData> optionalEODCINFileData = gstcinFileDataRepository.findByCinNo(gstRbiFilesTranxn.getEndToEndId());
        EODCINFileData eodcinFileData = optionalEODCINFileData.isPresent() ? optionalEODCINFileData.get() : null;

        MsGstParty msGstParty = null;

        if (eodcinFileData != null)
            msGstParty = msGstPartyRepository.findByGstin(eodcinFileData.getGstinTmpidNo());

        ReconcileDetailsDto reconcileDetailsDto = new ReconcileDetailsDto();

        reconcileDetailsDto.setGstDetails(eodcinFileData != null ? new GSTAccountHdrDto() : null);
        if (reconcileDetailsDto.getGstDetails() != null) {
            reconcileDetailsDto.getGstDetails().setPartyName(msGstParty != null ? msGstParty.getFirmName() : "-");
            reconcileDetailsDto.getGstDetails().setCinNo(eodcinFileData.getCinNo());
            reconcileDetailsDto.getGstDetails().setGstin(eodcinFileData.getGstinTmpidNo());
            reconcileDetailsDto.getGstDetails().setPaymentDt(DateUtil.convertToLocalDate(eodcinFileData.getPaymentDt()));
            reconcileDetailsDto.getGstDetails().setSgstTax(eodcinFileData.getSgstTax());
            reconcileDetailsDto.getGstDetails().setSgstIntr(eodcinFileData.getSgstIntr());
            reconcileDetailsDto.getGstDetails().setSgstFee(eodcinFileData.getSgstFee());
            reconcileDetailsDto.getGstDetails().setSgstOth(eodcinFileData.getSgstOth());
            reconcileDetailsDto.getGstDetails().setSgstPnlty(eodcinFileData.getSgstPenalty());
            reconcileDetailsDto.getGstDetails().setSgstTotal(eodcinFileData.getSgstTotal());
        }

        reconcileDetailsDto.setAccountScreenChallanDto(new AccountScreenChallanDto(gstRbiFilesTranxn.getId(),
                gstRbiFilesTranxn.getEndToEndId(), gstRbiFilesTranxn.getTransactionDttm(),
                gstRbiFilesTranxn.getTotalTransAmt(), gstRbiFilesTranxn.getRbiFileHdr().getFileRecvDt(),
                gstRbiFilesTranxn.getTransactionDttm(), msGstParty != null ? msGstParty.getFirmName() : "-", "-", "Created", gstRbiFilesTranxn.getGstSaDaChallanMapping().getBankId()));

        reconcileDetailsDto.getAccountScreenChallanDto().setCpinNo(eodcinFileData != null ? eodcinFileData.getCpinNo() : 0);

        reconcileDetailsDto = evaluate(reconcileDetailsDto);

        return reconcileDetailsDto;
    }

    @Transactional
    @Override
    public ReconcileDetailsDto saveOrUpdate(ReconcileDetailsDto dto) {

        AccountScreenChallanDto challanDto = dto.getAccountScreenChallanDto();
        try {
            if (dto.getAccountHdrId() == null) {

                RBIAccHdr rbiAccHdr = new RBIAccHdr(challanDto.getCin(),
                        getTransactionNo(RBIAccHdr.TRN_SCREEN_RAH), new Date(),
                        challanDto.getGovCreditDate(), challanDto.getAmount(), null,
                        challanDto.getScrollDate(), dto.getGstDetails().getIsEntryMatched());

                List<AccountCreditEntry> creditEntries = creditEntryConvertor.toEntity(dto.getAccountingEntriesDto().getCreditEntries());
                List<AccDebitEntry> debitEntries = debitEntryConvertor.toEntity(dto.getAccountingEntriesDto().getDebitEntries());

                RBIAccHdr rbiAccHdrObj = rbiAccHdrRepository.save(rbiAccHdr);
                creditEntryRepository.saveAll(creditEntries);
                debitEntryRepository.saveAll(debitEntries);
                dto.setAccountHdrId(String.valueOf(rbiAccHdrObj.getId()));

                GenerateMoeHdr moeHdr = generateMoe(dto);
                if (moeHdr != null)
                    moeHdrRepository.save(moeHdr);

                int rbiAccHdrWFCount = rbiAccHdrRepository.getWFdata(rbiAccHdrObj.getId(), 1);
                if (rbiAccHdrWFCount == 0 && dto.getAccountingEntriesDto().getIsEntryMatched() != 'Y') {
                    gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(952, rbiAccHdrObj.getId()));
                }

                if (dto.getAccountingEntriesDto().getIsEntryMatched() == 'Y') {
                    WfActionConfigSubmitTrnDto wfActionConfigSubmitTrnDto = getWfActionConfigSubmitTrnDto(dto);
                    gstWfActionConfigService.submitWfActConfigTrn(wfActionConfigSubmitTrnDto);
                }

            } else {

                if (dto.getAccountingEntriesDto().getIsEntryMatched() == 'Y') {
                    WfActionConfigSubmitTrnDto wfActionConfigSubmitTrnDto = getWfActionConfigSubmitTrnDto(dto);
                    gstWfActionConfigService.submitWfActConfigTrn(wfActionConfigSubmitTrnDto);
                }
            }

        } catch (CustomException | SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    private WfActionConfigSubmitTrnDto getWfActionConfigSubmitTrnDto(ReconcileDetailsDto dto) {
        WfActionConfigSubmitTrnDto wfActionConfigSubmitTrnDto = new WfActionConfigSubmitTrnDto();
        List<WfActionConfigTrnDto> wfDetails = new ArrayList<>();
        WfActionConfigTrnDto wfActionConfigTrnDto = new WfActionConfigTrnDto();
        wfActionConfigTrnDto.setTrnId(Long.parseLong(dto.getAccountHdrId()));
        wfActionConfigTrnDto.setActionConfigId(258L);
        wfActionConfigTrnDto.setRemarks("Approve");

        WfUserDetails assignedBy = new WfUserDetails();
        assignedBy.setOfficeId(1397L);
        assignedBy.setPostId(37940L);
        assignedBy.setPouId(6892L);
        assignedBy.setUserId("JGep5LDln+g=");
        assignedBy.setWfRoleId(199L);
        wfActionConfigTrnDto.setAssignedBy(assignedBy);

        WfUserDetails assignedTo = new WfUserDetails();
        assignedTo.setOfficeId(1397L);
        assignedTo.setPostId(37937L);
        assignedTo.setPouId(6889L);
        assignedTo.setUserId("nE8riU2aMUE=");
        assignedTo.setWfRoleId(201L);
        wfActionConfigTrnDto.setAssignedTo(assignedTo);
        wfDetails.add(wfActionConfigTrnDto);
        wfActionConfigSubmitTrnDto.setWfDetails(wfDetails);
        return wfActionConfigSubmitTrnDto;
    }

    private GenerateMoeHdr generateMoe(ReconcileDetailsDto dto) throws CustomException {
        GenerateMoeHdr generateMoeHdr = null;
        if (dto.getGstDetails() == null ||
                (dto.getGstDetails() != null && (dto.getGstDetails().getSgstTotal() < dto.getAccountScreenChallanDto().getAmount() ||
                        dto.getGstDetails().getSgstTotal() > dto.getAccountScreenChallanDto().getAmount()))) {
            generateMoeHdr = new GenerateMoeHdr();
            generateMoeHdr.setBANK_ID(dto.getAccountScreenChallanDto().getBankId());
            generateMoeHdr.setPARTY_NAME(dto.getAccountScreenChallanDto().getPartyName());
            generateMoeHdr.setGSTIN_TMPID_NO(dto.getGstDetails().getGstin());
            generateMoeHdr.setCPIN_NO(dto.getAccountScreenChallanDto().getCpinNo());
            generateMoeHdr.setCIN_NO(dto.getGstDetails().getCinNo());
            generateMoeHdr.setMOE_RAISED_DT(new Date());
            generateMoeHdr.setGST_AMOUNT(dto.getGstDetails().getSgstTotal());
            generateMoeHdr.setRBI_AMOUNT(dto.getAccountScreenChallanDto().getAmount());
            generateMoeHdr.setGOVT_CREDIT_DT(dto.getAccountScreenChallanDto().getGovCreditDate());
            generateMoeHdr.setReferenceNo(getTransactionNo(GenerateMoeHdr.TRN_SCREEN_LBAO));
            generateMoeHdr.setReferenceDt(LocalDateTime.now());
            generateMoeHdr.setMOE_STATUS("Created");
            generateMoeHdr.setActiveStatus(1);

            Optional<GSTMsBankEntity> msBankEntity = gstMsBankRepository.findById(dto.getAccountScreenChallanDto().getBankId());
            if (msBankEntity.isPresent())
                generateMoeHdr.setBANK_NAME(msBankEntity.get().getBankName());

            if (dto.getGstDetails() == null) {
                EDPLuLookUpInfoEntity notRecvFromGstn = luLookUpInfoRepository.findByLookUpInfoName("Not Received from GSTN");
                generateMoeHdr.setMOE_REASON(notRecvFromGstn);
                generateMoeHdr.setMOE_GENERATED_AMOUNT(dto.getAccountScreenChallanDto().getAmount());
            } else if (dto.getGstDetails() != null && dto.getGstDetails().getSgstTotal() < dto.getAccountScreenChallanDto().getAmount()) {
                EDPLuLookUpInfoEntity amountGreater = luLookUpInfoRepository.findByLookUpInfoName("Amount Greater");
                generateMoeHdr.setMOE_REASON(amountGreater);
                generateMoeHdr.setMOE_GENERATED_AMOUNT(dto.getAccountScreenChallanDto().getAmount() - dto.getGstDetails().getSgstTotal());
            } else if (dto.getGstDetails() != null && dto.getGstDetails().getSgstTotal() > dto.getAccountScreenChallanDto().getAmount()) {
                EDPLuLookUpInfoEntity amountLess = luLookUpInfoRepository.findByLookUpInfoName("Amount less");
                generateMoeHdr.setMOE_REASON(amountLess);
                generateMoeHdr.setMOE_GENERATED_AMOUNT(dto.getGstDetails().getSgstTotal() - dto.getAccountScreenChallanDto().getAmount());
            }
        }
        return generateMoeHdr;
    }

    private ReconcileDetailsDto evaluate(ReconcileDetailsDto reconcileDetailsDto) {

        GSTAccountHdrDto accountHdrDto = reconcileDetailsDto.getGstDetails();
        AccountScreenChallanDto accountScreenChallanDto = reconcileDetailsDto.getAccountScreenChallanDto();
        AccountingEntriesDto accountingEntriesDto = new AccountingEntriesDto();
        accountingEntriesDto.setIsEntryMatched('N');

        String[] bankHeadDetails = new String[3];

        if (bankHeadMap.get(accountScreenChallanDto.getBankId().intValue()) != null) {
            bankHeadDetails = bankHeadMap.get(accountScreenChallanDto.getBankId().intValue()).split(":");
        }

        if (accountHdrDto == null) {

            EntryConfig creditEntryConfig = config.get("RAT");
            EntryConfig debitEntryConfig = config.get("DEBIT");

            try {
                List<AccountCreditEntryDto> creditEntries = new ArrayList<>();
                creditEntries.add(new AccountCreditEntryDto(getTransactionNo(AccDebitEntry.TRN_SCREEN_ABE), new Date(), accountScreenChallanDto.getCin(), creditEntryConfig.getMajorheadId(), creditEntryConfig.getMajorhead(), creditEntryConfig.getSubmajorheadId(), creditEntryConfig.getSubmajorhead(), creditEntryConfig.getMinorheadId(), creditEntryConfig.getMinorhead(), creditEntryConfig.getSubhead(), creditEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "Receipts Awaiting Transfer (RAT)", accountScreenChallanDto.getAmount()));
                accountingEntriesDto.setCreditEntries(creditEntries);

                List<AccDebitEntryDto> debitEntries = new ArrayList<>();
                debitEntries.add(new AccDebitEntryDto(getTransactionNo(AccountCreditEntry.TRN_SCREEN_ACE), new Date(), accountScreenChallanDto.getCin(), debitEntryConfig.getMajorheadId(), debitEntryConfig.getMajorhead(), debitEntryConfig.getSubmajorheadId(), debitEntryConfig.getSubmajorhead(), debitEntryConfig.getMinorheadId(), debitEntryConfig.getMinorhead(), debitEntryConfig.getSubhead(), debitEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "DEPOSIT WITH RESERVE BANK - " + bankHeadDetails[1], accountScreenChallanDto.getAmount()));
                accountingEntriesDto.setDebitEntries(debitEntries);
            } catch (CustomException e) {
                e.printStackTrace();
            }
        } else if (accountHdrDto != null && accountHdrDto.getSgstTotal().equals(reconcileDetailsDto.getAccountScreenChallanDto().getAmount())) {
            accountHdrDto.setIsEntryMatched('Y');
            accountingEntriesDto.setIsEntryMatched('Y');

            EntryConfig creditEntryConfig = bankHeadDetails[2].equals("Pvt") ? config.get("CREDIT_PVT") : config.get("CREDIT_PUB");
            EntryConfig debitEntryConfig = config.get("DEBIT");

            try {
                List<AccountCreditEntryDto> creditEntries = new ArrayList<>();
                creditEntries.add(new AccountCreditEntryDto(getTransactionNo(AccDebitEntry.TRN_SCREEN_ABE), new Date(), accountScreenChallanDto.getCin(), creditEntryConfig.getMajorheadId(), creditEntryConfig.getMajorhead(), creditEntryConfig.getSubmajorheadId(), creditEntryConfig.getSubmajorhead(), creditEntryConfig.getMinorheadId(), creditEntryConfig.getMinorhead(), creditEntryConfig.getSubhead(), creditEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "SUSPENSE ACCOUNTS - " + bankHeadDetails[1], accountScreenChallanDto.getAmount()));
                accountingEntriesDto.setCreditEntries(creditEntries);

                List<AccDebitEntryDto> debitEntries = new ArrayList<>();
                debitEntries.add(new AccDebitEntryDto(getTransactionNo(AccountCreditEntry.TRN_SCREEN_ACE), new Date(), accountScreenChallanDto.getCin(), debitEntryConfig.getMajorheadId(), debitEntryConfig.getMajorhead(), debitEntryConfig.getSubmajorheadId(), debitEntryConfig.getSubmajorhead(), debitEntryConfig.getMinorheadId(), debitEntryConfig.getMinorhead(), debitEntryConfig.getSubhead(), debitEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "DEPOSIT WITH RESERVE BANK - " + bankHeadDetails[1], accountScreenChallanDto.getAmount()));
                accountingEntriesDto.setDebitEntries(debitEntries);
            } catch (CustomException e) {
                e.printStackTrace();
            }
        } else if (accountHdrDto != null && accountHdrDto.getSgstTotal() < reconcileDetailsDto.getAccountScreenChallanDto().getAmount()) {
            try {

                EntryConfig creditEntryConfig = bankHeadDetails[2].equals("Pvt") ? config.get("CREDIT_PVT") : config.get("CREDIT_PUB");
                EntryConfig ratEntryConfig = config.get("RAT");
                EntryConfig debitEntryConfig = config.get("DEBIT");

                List<AccountCreditEntryDto> creditEntries = new ArrayList<>();
                creditEntries.add(new AccountCreditEntryDto(getTransactionNo(AccDebitEntry.TRN_SCREEN_ABE), new Date(), accountScreenChallanDto.getCin(), creditEntryConfig.getMajorheadId(), creditEntryConfig.getMajorhead(), creditEntryConfig.getSubmajorheadId(), creditEntryConfig.getSubmajorhead(), creditEntryConfig.getMinorheadId(), creditEntryConfig.getMinorhead(), creditEntryConfig.getSubhead(), creditEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "SUSPENSE ACCOUNTS - " + bankHeadDetails[1], accountHdrDto.getSgstTotal()));
                creditEntries.add(new AccountCreditEntryDto(getTransactionNo(AccDebitEntry.TRN_SCREEN_ABE), new Date(), accountScreenChallanDto.getCin(), ratEntryConfig.getMajorheadId(), ratEntryConfig.getMajorhead(), ratEntryConfig.getSubmajorheadId(), ratEntryConfig.getSubmajorhead(), ratEntryConfig.getMinorheadId(), ratEntryConfig.getMinorhead(), ratEntryConfig.getSubhead(), ratEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "RECEIPTS AWAITING TRANSFER (RAT)", accountScreenChallanDto.getAmount() - accountHdrDto.getSgstTotal()));
                accountingEntriesDto.setCreditEntries(creditEntries);

                List<AccDebitEntryDto> debitEntries = new ArrayList<>();
                debitEntries.add(new AccDebitEntryDto(getTransactionNo(AccountCreditEntry.TRN_SCREEN_ACE), new Date(), accountScreenChallanDto.getCin(), debitEntryConfig.getMajorheadId(), debitEntryConfig.getMajorhead(), debitEntryConfig.getSubmajorheadId(), debitEntryConfig.getSubmajorhead(), debitEntryConfig.getMinorheadId(), debitEntryConfig.getMinorhead(), debitEntryConfig.getSubhead(), debitEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "DEPOSIT WITH RESERVE BANK - " + bankHeadDetails[1], accountScreenChallanDto.getAmount()));
                accountingEntriesDto.setDebitEntries(debitEntries);
            } catch (CustomException e) {
                e.printStackTrace();
            }
        } else if (accountHdrDto != null && accountHdrDto.getSgstTotal() > reconcileDetailsDto.getAccountScreenChallanDto().getAmount()) {
            EntryConfig creditEntryConfig = bankHeadDetails[2].equals("Pvt") ? config.get("CREDIT_PVT") : config.get("CREDIT_PUB");
            EntryConfig debitEntryConfig = config.get("DEBIT");
            try {
                List<AccountCreditEntryDto> creditEntries = new ArrayList<>();
                creditEntries.add(new AccountCreditEntryDto(getTransactionNo(AccDebitEntry.TRN_SCREEN_ABE), new Date(), accountScreenChallanDto.getCin(), creditEntryConfig.getMajorheadId(), creditEntryConfig.getMajorhead(), creditEntryConfig.getSubmajorheadId(), creditEntryConfig.getSubmajorhead(), creditEntryConfig.getMinorheadId(), creditEntryConfig.getMinorhead(), creditEntryConfig.getSubhead(), creditEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "SUSPENSE ACCOUNTS - " + bankHeadDetails[1], accountScreenChallanDto.getAmount()));
                accountingEntriesDto.setCreditEntries(creditEntries);

                List<AccDebitEntryDto> debitEntries = new ArrayList<>();
                debitEntries.add(new AccDebitEntryDto(getTransactionNo(AccountCreditEntry.TRN_SCREEN_ACE), new Date(), accountScreenChallanDto.getCin(), debitEntryConfig.getMajorheadId(), debitEntryConfig.getMajorhead(), debitEntryConfig.getSubmajorheadId(), debitEntryConfig.getSubmajorhead(), debitEntryConfig.getMinorheadId(), debitEntryConfig.getMinorhead(), debitEntryConfig.getSubhead(), debitEntryConfig.getSubheadId(), 00, bankHeadDetails[0], "DEPOSIT WITH RESERVE BANK - " + bankHeadDetails[1], accountScreenChallanDto.getAmount()));
                accountingEntriesDto.setDebitEntries(debitEntries);
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }

        reconcileDetailsDto.setAccountingEntriesDto(accountingEntriesDto);

        return reconcileDetailsDto;
    }

    private String getTransactionNo(String trnScreen) throws CustomException {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.TRN_SCREEN, trnScreen);
        String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
        List<Object[]> nextSequenceNumber = rbiFileTranxnRepository.callStoredProcedure(procName, map);
        if (!Utils.isEmpty(nextSequenceNumber)) {
            return (String) nextSequenceNumber.get(0)[0];
        } else {
            throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
        }
    }


	@Override
	public PagebleDTO<GSTChallanAccountingListingDTO> getChallanAccountingListing(PageDetails pageDetail) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getChallanAccountingListing().get(search.getKey()),
					search.getValue()));
		}
		GstDBConstants.getChallanAccountingListing()
				.entrySet().stream()
				.filter(e -> !map.containsKey(e.getValue()))
				.forEach(e -> map.put(e.getValue(),null));
		String procName = GstDBConstants.GST_SCHEMA.concat(Constant.DOT.concat(GstDBConstants.SP_CHALLAN_ACCOUNTING_LISTING));
		List<GSTChallanAccountingListingDTO> objectSp = null;
		try {
			objectSp = this.callStoreProc(procName, map, GSTChallanAccountingListingDTO.class);
		} catch (CustomException e1) {
			e1.printStackTrace();
		}
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
		List<Object[]> objectSp = rbiFileTranxnRepository.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}

}

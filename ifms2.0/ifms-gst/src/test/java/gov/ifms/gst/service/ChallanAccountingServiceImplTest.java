package gov.ifms.gst.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.repository.LuLookUpInfoRepository;
import gov.ifms.gst.dto.*;
import gov.ifms.gst.entity.*;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.AccDebitEntryConvertor;
import gov.ifms.gst.converter.AccountCreditEntryConvertor;
import gov.ifms.gst.converter.GSTAccountHdrConvertor;
import gov.ifms.gst.converter.RBIFileTranxnConvertor;
import gov.ifms.gst.pagination.ChallanSearchCriteria;
import gov.ifms.gst.repository.*;
import gov.ifms.gst.service.impl.ChallanAccountingServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/**
 * The Class ChallanAccountingServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class ChallanAccountingServiceImplTest {

    /**
     * Sets the up.
     */
    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * The service impl.
     */
    @InjectMocks
    private ChallanAccountingServiceImpl service;

    @Mock
    private TPAORbiFilesTranxnRepository tpaoRbiFilesTranxnRepo;

    @Mock
    private RBIFileTranxnRepository rbiFileTranxnRepository;

    @Mock
    private GSTAccountHdrRepository gstAccountHdrRepository;

    @Mock
    private GSTCINFileDataRepository gstcinFileDataRepository;

    @Mock
    private RBIFileTranxnConvertor rbiFileTranxnConvertor;

    @Mock
    private GSTAccountHdrConvertor gstAccountHdrConvertor;

    @Mock
    private AccountCreditEntryConvertor creditEntryConvertor;

    @Mock
    private AccDebitEntryConvertor debitEntryConvertor;

    @Mock
    private RBIAccHdrRepository rbiAccHdrRepository;

    @Mock
    private AccountingCreditEntryRepository creditEntryRepository;

    @Mock
    private AccDebitEntryRepository debitEntryRepository;

    @Mock
    private ChallanSearchCriteria searchCriteria;

    @Mock
    SpecificationImpl<GstRbiFilesTranxn> spec;

    @Mock
    Page<GstRbiFilesTranxn> page;

    @Mock
    GstRbiFilesTranxn gstRbiFilesTranxn;

    @Mock
    GstRbiFilesHdr gstRbiFilesHdr;

    @Mock
    GstSaDaChallanMapping gstSaDaChallanMapping;

    @Mock
    EODCINFileData eodcinFileData;

    @Mock
    private MsGstPartyRepository msGstPartyRepository;

    @Mock
    private MsGstParty msGstParty;

    @Mock
    private ConcurrentHashMap<Integer, String> bankHeadMap;

    @Mock
    private ConcurrentHashMap<String, EntryConfig> config;

    @Mock
    private ReconcileDetailsDto reconcileDetailsDto;

    @Mock
    private AccountScreenChallanDto challanDto;

    @Mock
    private GSTAccountHdrDto accountHdrDto;

    @Mock
    private AccountingEntriesDto accountingEntriesDto;

    @Mock
    private GSTMsBankRepository gstMsBankRepository;

    @Mock
    private GSTMsBankEntity gstMsBankEntity;

    @Mock
    private LuLookUpInfoRepository luLookUpInfoRepository;

    @Mock
    private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

    @Mock
    private GenerateMoeHdrRepository moeHdrRepository;

    /**
     * The page detail.
     */
    @Mock
    private PageDetails pageDetail;

    @Mock
    private PageRequest pageable;

    /**
     * Test get account close req dtl.
     *
     * @throws CustomException
     */
    @Test
    void testGetChallanList() throws CustomException {

        when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
        SearchParam searchParam = new SearchParam();
        searchParam.setKey(JunitConstants.STRING_TYPE);
        searchParam.setValue(JunitConstants.STRING_TYPE);
        List<SearchParam> list = new ArrayList<>();
        list.add(searchParam);

        when(pageDetail.getJsonArr()).thenReturn(list);
        when(searchCriteria.getRbiFileTranxnSpecificationDetail(any(SpecificationImpl.class), anyList())).thenReturn(spec);
        List<GstRbiFilesTranxn> gstRbiFilesTranxns = new ArrayList<>();
        gstRbiFilesTranxns.add(gstRbiFilesTranxn);
        when(tpaoRbiFilesTranxnRepo.findAll(spec, pageable)).thenReturn(page);
        when(page.getContent()).thenReturn(gstRbiFilesTranxns);
        when(gstRbiFilesTranxn.getId()).thenReturn(JunitConstants.LONG_TYPE);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstRbiFilesTranxn.getTransactionDttm()).thenReturn(JunitConstants.DATE);
        when(gstRbiFilesTranxn.getTransactionAmt()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(gstRbiFilesTranxn.getRbiFileHdr()).thenReturn(gstRbiFilesHdr);
        when(gstRbiFilesHdr.getFileRecvDt()).thenReturn(JunitConstants.DATE);
        when(gstRbiFilesTranxn.getGstSaDaChallanMapping()).thenReturn(gstSaDaChallanMapping);
        when(gstSaDaChallanMapping.getBankId()).thenReturn(JunitConstants.LONG_TYPE);

        when(page.getTotalPages()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getSize()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);

        assertNotNull(service.getChallanList(pageDetail));

    }

    @Test
    void testGetById() throws CustomException{

        Optional<GstRbiFilesTranxn> gstRbiFilesTranxnOptional = Optional.of(gstRbiFilesTranxn);
        when(tpaoRbiFilesTranxnRepo.findById(JunitConstants.LONG_TYPE)).thenReturn(gstRbiFilesTranxnOptional);


        Optional<EODCINFileData> optionalEODCINFileData = Optional.of(eodcinFileData);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstcinFileDataRepository.findByCinNo(JunitConstants.STRING_ABC)).thenReturn(optionalEODCINFileData);

        when(eodcinFileData.getGstinTmpidNo()).thenReturn(JunitConstants.STRING_ABC);
        when(msGstPartyRepository.findByGstin(JunitConstants.STRING_ABC)).thenReturn(msGstParty);

        when(gstRbiFilesTranxn.getId()).thenReturn(JunitConstants.LONG_TYPE);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstRbiFilesTranxn.getTransactionDttm()).thenReturn(JunitConstants.DATE);
        when(gstRbiFilesTranxn.getTotalTransAmt()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(gstRbiFilesTranxn.getRbiFileHdr()).thenReturn(gstRbiFilesHdr);
        when(gstRbiFilesHdr.getFileRecvDt()).thenReturn(JunitConstants.DATE);
        when(gstRbiFilesTranxn.getTransactionDttm()).thenReturn(JunitConstants.DATE);
        when(msGstParty.getFirmName()).thenReturn(JunitConstants.STRING_ABC);

        when(gstRbiFilesTranxn.getGstSaDaChallanMapping()).thenReturn(gstSaDaChallanMapping);
        when(gstSaDaChallanMapping.getBankId()).thenReturn(JunitConstants.LONG_TYPE);

        assertNotNull(service.getById(JunitConstants.LONG_TYPE));

    }

    @Test
    void testGetReconcileDetails() throws CustomException{

        Optional<GstRbiFilesTranxn> gstRbiFilesTranxnOptional = Optional.of(gstRbiFilesTranxn);
        when(tpaoRbiFilesTranxnRepo.findById(JunitConstants.LONG_TYPE)).thenReturn(gstRbiFilesTranxnOptional);

        Optional<EODCINFileData> optionalEODCINFileData = Optional.of(eodcinFileData);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstcinFileDataRepository.findByCinNo(JunitConstants.STRING_ABC)).thenReturn(optionalEODCINFileData);

        when(eodcinFileData.getGstinTmpidNo()).thenReturn(JunitConstants.STRING_ABC);
        when( msGstPartyRepository.findByGstin(JunitConstants.STRING_ABC)).thenReturn(msGstParty);

        when(msGstParty.getFirmName()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getCinNo()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getGstinTmpidNo()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getPaymentDt()).thenReturn(JunitConstants.DATE);
        when(eodcinFileData.getSgstTax()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstFee()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstIntr()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstOth()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstPenalty()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstTotal()).thenReturn(JunitConstants.DOUBLE_VAL);

        when(gstRbiFilesTranxn.getId()).thenReturn(JunitConstants.LONG_TYPE);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstRbiFilesTranxn.getTransactionDttm()).thenReturn(JunitConstants.DATE);
        when(gstRbiFilesTranxn.getTotalTransAmt()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(gstRbiFilesTranxn.getRbiFileHdr()).thenReturn(gstRbiFilesHdr);
        when(gstRbiFilesHdr.getFileRecvDt()).thenReturn(JunitConstants.DATE);

        when(gstRbiFilesTranxn.getGstSaDaChallanMapping()).thenReturn(gstSaDaChallanMapping);
        when(gstSaDaChallanMapping.getBankId()).thenReturn(JunitConstants.LONG_TYPE);

        when(eodcinFileData.getCpinNo()).thenReturn(JunitConstants.LONG_TYPE);

        //In evaluate function
        when(bankHeadMap.get(JunitConstants.INTEGER_TYPE)).thenReturn("17:State bank of India:Pub");
        when(config.get("RAT")).thenReturn(new EntryConfig(628, "0006", 1930, "00", 2284, "500", "01", 6528, 0, null, "RECEIPTS AWAITING TRANSFER (RAT)"));
        when(config.get("CREDIT_PUB")).thenReturn(new EntryConfig(612, "8658", 1155, "00", 1631, "108", "01", 3963, 0, null, "SUSPENSE ACCOUNTS - "));
        when(config.get("CREDIT_PVT")).thenReturn(new EntryConfig(612, "8658", 1155, "00", 1543, "138", "01", 3972, 0, null, "SUSPENSE ACCOUNTS - "));
        when(config.get("DEBIT")).thenReturn(new EntryConfig(618, "8675", 1161, "00", 1985, "106", "05", 3991, 0, null, "DEPOSIT WITH RESERVE BANK - "));

        List<Object[]> transSeq = Arrays.asList(new String[][]{new String[]{"abc"}});
        when(rbiFileTranxnRepository.callStoredProcedure(anyString(), anyMap())).thenReturn(transSeq);

        assertNotNull(service.getReconcileDetails(JunitConstants.LONG_TYPE));

    }

    @Test
    void testGetReconcileDetailsAmountLess() throws CustomException{

        Optional<GstRbiFilesTranxn> gstRbiFilesTranxnOptional = Optional.of(gstRbiFilesTranxn);
        when(tpaoRbiFilesTranxnRepo.findById(JunitConstants.LONG_TYPE)).thenReturn(gstRbiFilesTranxnOptional);

        Optional<EODCINFileData> optionalEODCINFileData = Optional.of(eodcinFileData);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstcinFileDataRepository.findByCinNo(JunitConstants.STRING_ABC)).thenReturn(optionalEODCINFileData);

        when(eodcinFileData.getGstinTmpidNo()).thenReturn(JunitConstants.STRING_ABC);
        when( msGstPartyRepository.findByGstin(JunitConstants.STRING_ABC)).thenReturn(msGstParty);

        when(msGstParty.getFirmName()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getCinNo()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getGstinTmpidNo()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getPaymentDt()).thenReturn(JunitConstants.DATE);
        when(eodcinFileData.getSgstTax()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstFee()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstIntr()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstOth()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstPenalty()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstTotal()).thenReturn(100.0);

        when(gstRbiFilesTranxn.getId()).thenReturn(JunitConstants.LONG_TYPE);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstRbiFilesTranxn.getTransactionDttm()).thenReturn(JunitConstants.DATE);
        when(gstRbiFilesTranxn.getTotalTransAmt()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(gstRbiFilesTranxn.getRbiFileHdr()).thenReturn(gstRbiFilesHdr);
        when(gstRbiFilesHdr.getFileRecvDt()).thenReturn(JunitConstants.DATE);

        when(gstRbiFilesTranxn.getGstSaDaChallanMapping()).thenReturn(gstSaDaChallanMapping);
        when(gstSaDaChallanMapping.getBankId()).thenReturn(JunitConstants.LONG_TYPE);

        when(eodcinFileData.getCpinNo()).thenReturn(JunitConstants.LONG_TYPE);

        //In evaluate function
        when(bankHeadMap.get(JunitConstants.INTEGER_TYPE)).thenReturn("17:State bank of India:Pub");
        when(config.get("RAT")).thenReturn(new EntryConfig(628, "0006", 1930, "00", 2284, "500", "01", 6528, 0, null, "RECEIPTS AWAITING TRANSFER (RAT)"));
        when(config.get("CREDIT_PUB")).thenReturn(new EntryConfig(612, "8658", 1155, "00", 1631, "108", "01", 3963, 0, null, "SUSPENSE ACCOUNTS - "));
        when(config.get("CREDIT_PVT")).thenReturn(new EntryConfig(612, "8658", 1155, "00", 1543, "138", "01", 3972, 0, null, "SUSPENSE ACCOUNTS - "));
        when(config.get("DEBIT")).thenReturn(new EntryConfig(618, "8675", 1161, "00", 1985, "106", "05", 3991, 0, null, "DEPOSIT WITH RESERVE BANK - "));

        List<Object[]> transSeq = Arrays.asList(new String[][]{new String[]{"abc"}});
        when(rbiFileTranxnRepository.callStoredProcedure(anyString(), anyMap())).thenReturn(transSeq);

        assertNotNull(service.getReconcileDetails(JunitConstants.LONG_TYPE));

    }

    @Test
    void testGetReconcileDetailsAmountGreater() throws CustomException{

        Optional<GstRbiFilesTranxn> gstRbiFilesTranxnOptional = Optional.of(gstRbiFilesTranxn);
        when(tpaoRbiFilesTranxnRepo.findById(JunitConstants.LONG_TYPE)).thenReturn(gstRbiFilesTranxnOptional);

        Optional<EODCINFileData> optionalEODCINFileData = Optional.of(eodcinFileData);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstcinFileDataRepository.findByCinNo(JunitConstants.STRING_ABC)).thenReturn(optionalEODCINFileData);

        when(eodcinFileData.getGstinTmpidNo()).thenReturn(JunitConstants.STRING_ABC);
        when( msGstPartyRepository.findByGstin(JunitConstants.STRING_ABC)).thenReturn(msGstParty);

        when(msGstParty.getFirmName()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getCinNo()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getGstinTmpidNo()).thenReturn(JunitConstants.STRING_ABC);
        when(eodcinFileData.getPaymentDt()).thenReturn(JunitConstants.DATE);
        when(eodcinFileData.getSgstTax()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstFee()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstIntr()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstOth()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstPenalty()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(eodcinFileData.getSgstTotal()).thenReturn(100.0);

        when(gstRbiFilesTranxn.getId()).thenReturn(JunitConstants.LONG_TYPE);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstRbiFilesTranxn.getTransactionDttm()).thenReturn(JunitConstants.DATE);
        when(gstRbiFilesTranxn.getTotalTransAmt()).thenReturn(200.0);
        when(gstRbiFilesTranxn.getRbiFileHdr()).thenReturn(gstRbiFilesHdr);
        when(gstRbiFilesHdr.getFileRecvDt()).thenReturn(JunitConstants.DATE);

        when(gstRbiFilesTranxn.getGstSaDaChallanMapping()).thenReturn(gstSaDaChallanMapping);
        when(gstSaDaChallanMapping.getBankId()).thenReturn(JunitConstants.LONG_TYPE);

        when(eodcinFileData.getCpinNo()).thenReturn(JunitConstants.LONG_TYPE);

        //In evaluate function
        when(bankHeadMap.get(JunitConstants.INTEGER_TYPE)).thenReturn("17:State bank of India:Pub");
        when(config.get("RAT")).thenReturn(new EntryConfig(628, "0006", 1930, "00", 2284, "500", "01", 6528, 0, null, "RECEIPTS AWAITING TRANSFER (RAT)"));
        when(config.get("CREDIT_PUB")).thenReturn(new EntryConfig(612, "8658", 1155, "00", 1631, "108", "01", 3963, 0, null, "SUSPENSE ACCOUNTS - "));
        when(config.get("CREDIT_PVT")).thenReturn(new EntryConfig(612, "8658", 1155, "00", 1543, "138", "01", 3972, 0, null, "SUSPENSE ACCOUNTS - "));
        when(config.get("DEBIT")).thenReturn(new EntryConfig(618, "8675", 1161, "00", 1985, "106", "05", 3991, 0, null, "DEPOSIT WITH RESERVE BANK - "));

        List<Object[]> transSeq = Arrays.asList(new String[][]{new String[]{"abc"}});
        when(rbiFileTranxnRepository.callStoredProcedure(anyString(), anyMap())).thenReturn(transSeq);

        assertNotNull(service.getReconcileDetails(JunitConstants.LONG_TYPE));

    }

    @Test
    void testGetReconcileDetailsAmountGstDetailsNotAvailable() throws CustomException{

        Optional<GstRbiFilesTranxn> gstRbiFilesTranxnOptional = Optional.of(gstRbiFilesTranxn);
        when(tpaoRbiFilesTranxnRepo.findById(JunitConstants.LONG_TYPE)).thenReturn(gstRbiFilesTranxnOptional);

        when(gstRbiFilesTranxn.getId()).thenReturn(JunitConstants.LONG_TYPE);
        when(gstRbiFilesTranxn.getEndToEndId()).thenReturn(JunitConstants.STRING_ABC);
        when(gstRbiFilesTranxn.getTransactionDttm()).thenReturn(JunitConstants.DATE);
        when(gstRbiFilesTranxn.getTotalTransAmt()).thenReturn(200.0);
        when(gstRbiFilesTranxn.getRbiFileHdr()).thenReturn(gstRbiFilesHdr);
        when(gstRbiFilesHdr.getFileRecvDt()).thenReturn(JunitConstants.DATE);

        when(gstRbiFilesTranxn.getGstSaDaChallanMapping()).thenReturn(gstSaDaChallanMapping);
        when(gstSaDaChallanMapping.getBankId()).thenReturn(JunitConstants.LONG_TYPE);

        when(eodcinFileData.getCpinNo()).thenReturn(JunitConstants.LONG_TYPE);

        //In evaluate function
        when(bankHeadMap.get(JunitConstants.INTEGER_TYPE)).thenReturn("17:State bank of India:Pub");
        when(config.get("RAT")).thenReturn(new EntryConfig(628, "0006", 1930, "00", 2284, "500", "01", 6528, 0, null, "RECEIPTS AWAITING TRANSFER (RAT)"));
        when(config.get("CREDIT_PUB")).thenReturn(new EntryConfig(612, "8658", 1155, "00", 1631, "108", "01", 3963, 0, null, "SUSPENSE ACCOUNTS - "));
        when(config.get("CREDIT_PVT")).thenReturn(new EntryConfig(612, "8658", 1155, "00", 1543, "138", "01", 3972, 0, null, "SUSPENSE ACCOUNTS - "));
        when(config.get("DEBIT")).thenReturn(new EntryConfig(618, "8675", 1161, "00", 1985, "106", "05", 3991, 0, null, "DEPOSIT WITH RESERVE BANK - "));

        List<Object[]> transSeq = Arrays.asList(new String[][]{new String[]{"abc"}});
        when(rbiFileTranxnRepository.callStoredProcedure(anyString(), anyMap())).thenReturn(transSeq);

        assertNotNull(service.getReconcileDetails(JunitConstants.LONG_TYPE));

    }

    @Test
    void testSaveOrUpdate(){

        when(reconcileDetailsDto.getAccountScreenChallanDto()).thenReturn(challanDto);
        when(challanDto.getCin()).thenReturn(JunitConstants.STRING_ABC);
        when(challanDto.getGovCreditDate()).thenReturn(JunitConstants.DATE);
        when(challanDto.getAmount()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(challanDto.getScrollDate()).thenReturn(JunitConstants.DATE);
        when(reconcileDetailsDto.getGstDetails()).thenReturn(accountHdrDto);
        when(accountHdrDto.getIsEntryMatched()).thenReturn('Y');

        List<AccountCreditEntryDto> creditEntries = new ArrayList<>();
        creditEntries.add(new AccountCreditEntryDto(JunitConstants.generateTrnNo(AccDebitEntry.TRN_SCREEN_ABE), new Date(), JunitConstants.STRING_ABC,JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE, 00,JunitConstants.STRING_ABC, "SUSPENSE ACCOUNTS - SBI", 100.0));
        accountingEntriesDto.setCreditEntries(creditEntries);
        List<AccDebitEntryDto> debitEntries = new ArrayList<>();
        debitEntries.add(new AccDebitEntryDto(JunitConstants.generateTrnNo(AccDebitEntry.TRN_SCREEN_ABE), new Date(), JunitConstants.STRING_ABC,JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE, 00,JunitConstants.STRING_ABC, "DEPOSIT WITH RESERVE BANK - SBI", 100.0));
        accountingEntriesDto.setDebitEntries(debitEntries);

        when(reconcileDetailsDto.getAccountingEntriesDto()).thenReturn(accountingEntriesDto);

        List<Object[]> transSeq = Arrays.asList(new String[][]{new String[]{"abc"}});
        when(rbiFileTranxnRepository.callStoredProcedure(anyString(), anyMap())).thenReturn(transSeq);

        when(reconcileDetailsDto.getAccountScreenChallanDto()).thenReturn(challanDto);
        when(challanDto.getBankId()).thenReturn(JunitConstants.LONG_TYPE);
        Optional<GSTMsBankEntity> optionalGSTMsBankEntity = Optional.of(gstMsBankEntity);
        when(gstMsBankRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(optionalGSTMsBankEntity);

        when(luLookUpInfoRepository.findByLookUpInfoName("Amount Greater")).thenReturn(edpLuLookUpInfoEntity);
        when(challanDto.getAmount()).thenReturn(20000.0);
        when(reconcileDetailsDto.getGstDetails()).thenReturn(accountHdrDto);
        when(accountHdrDto.getSgstTotal()).thenReturn(500.0);


        when(gstMsBankEntity.getBankName()).thenReturn(JunitConstants.STRING_ABC);

        assertNull(service.saveOrUpdate(reconcileDetailsDto));

    }


}

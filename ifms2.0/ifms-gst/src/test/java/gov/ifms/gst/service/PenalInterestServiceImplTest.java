package gov.ifms.gst.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.repository.LuLookUpInfoRepository;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.*;
import gov.ifms.gst.dto.GSTBankWisePenalInterestDto;
import gov.ifms.gst.dto.ManualEntryDto;
import gov.ifms.gst.dto.PenalIntrestEntryDto;
import gov.ifms.gst.entity.*;
import gov.ifms.gst.pagination.GstSearchCriteria;
import gov.ifms.gst.pagination.ManualEntrySearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.*;
import gov.ifms.gst.service.impl.GSTPenalInterestServiceImpl;
import gov.ifms.gst.service.impl.ManualEntryServiceImpl;
import gov.ifms.gst.util.DateUtil;
import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
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
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

/**
 * The Class PenalInterestServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class PenalInterestServiceImplTest {

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
    private GSTPenalInterestServiceImpl service;

    @Mock
    private PenalIntrestEntryConvertor convertor;

    @Mock
    private PenalIntrestDTLConvertor dtlConvertor;

    @Mock
    private PanelIntrestEntryRepository repository;

    @Mock
    private PanelIntrestDTLRepository intrestDTLRepository;

    @Mock
    private GSTBankRateMasterRepository bankRateMasterRepository;

    @Mock
    private LuLookUpInfoRepository luLookUpInfoRepository;

    @Mock
    private GstSaDaChallanMappingRepository gstSaDaChallanMappingRepository;

    @Mock
    private GSTCINFileDataRepository gstcinFileDataRepository;

    @Mock
    private GstWfActionConfigService gstWfActionConfigService;

    @Mock
    private GstSearchCriteria searchCriteria;

    @Mock
    private SpecificationImpl<PenalIntrestEntry> spec;

    @Mock
    private Page<PenalIntrestEntry> page;

    @Mock
    private PenalIntrestEntry penalIntrestEntry;

    @Mock
    private EDPLuLookUpInfoEntity challanCashModeOfReceipt;

    @Mock
    private PenalIntrestEntryDto penalIntrestEntryDto;

    @Mock
    private PenalIntrestDTL penalIntrestDTL;

    @Mock
    private EDPLuLookUpInfoEntity monthLookUpInfo;

    @Mock
    private EDPLuLookUpInfoEntity yearLookUpInfo;

    @Mock
    private GstSaDaChallanMapping gstSaDaChallanMapping;

    @Mock
    private GstRbiFilesTranxn gstRbiFilesTranxn;

    @Mock
    private GSTBankRateMaster gstBankRateMaster;

    /**
     * The page detail.
     */
    @Mock
    private PageDetails pageDetail;

    @Mock
    private PageRequest pageable;

    @Test
    void testListingPenalInterest() throws CustomException {

        when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
        SearchParam searchParam = new SearchParam();
        searchParam.setKey(JunitConstants.STRING_TYPE);
        searchParam.setValue(JunitConstants.STRING_TYPE);
        List<SearchParam> list = new ArrayList<>();
        list.add(searchParam);

        when(pageDetail.getJsonArr()).thenReturn(list);
        when(searchCriteria.getPenalSearchSpecificationDetail(any(SpecificationImpl.class), anyList())).thenReturn(spec);
        List<PenalIntrestEntry> penalIntrestEntries = new ArrayList<>();
        penalIntrestEntries.add(penalIntrestEntry);
        when(repository.findAll(spec, pageable)).thenReturn(page);
        when(page.getContent()).thenReturn(penalIntrestEntries);

        when(page.getTotalPages()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getSize()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);

        assertNotNull(service.listingPenalInterest(pageDetail));
    }

    @Test
    void testSavePenalInterest() throws CustomException {

        when(luLookUpInfoRepository.findByLookUpInfoName("Challan/Cash")).thenReturn(challanCashModeOfReceipt);
        when(challanCashModeOfReceipt.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
        when(penalIntrestEntryDto.getReceiptModeId()).thenReturn(JunitConstants.LONG_TYPE);
        when(penalIntrestEntryDto.getChqCeferenceNo()).thenReturn(JunitConstants.STRING_ABC);
        when(repository.countByChqCeferenceNo(JunitConstants.STRING_ABC)).thenReturn(JunitConstants.INTEGER_TYPE);
        when(penalIntrestEntryDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
        when(repository.callStoredProcedure(any(), anyMap())).thenReturn(Arrays.asList(new String[][]{ new String[]{JunitConstants.STRING_ABC}}));

        when(convertor.toEntity(penalIntrestEntryDto)).thenReturn(penalIntrestEntry);

        List<PenalIntrestDTL> penalIntrestDTLList = new ArrayList<>();
        penalIntrestDTLList.add(penalIntrestDTL);
        when(dtlConvertor.toEntity(penalIntrestEntryDto.getPenalDetailsList())).thenReturn(penalIntrestDTLList);
        when(penalIntrestEntryDto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
        when(repository.save(penalIntrestEntry)).thenReturn(penalIntrestEntry);
        when(convertor.toDTO(penalIntrestEntry)).thenReturn(penalIntrestEntryDto);
        when(gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(1L, 1L))).thenReturn(JunitConstants.INT_TYPE);

        assertNotNull(service.savePenalInterest(penalIntrestEntryDto));

    }

    @Test
    void testGetById() throws CustomException {

        Optional<PenalIntrestEntry> penalIntrestEntryOptional = Optional.of(penalIntrestEntry);
        when(repository.findById(JunitConstants.LONG_TYPE)).thenReturn(penalIntrestEntryOptional);
        when(convertor.toDTO(penalIntrestEntry)).thenReturn(penalIntrestEntryDto);

        assertNotNull(service.getById(JunitConstants.LONG_TYPE));

    }

    @Test
    void testDeleteById() throws CustomException {
        Optional<PenalIntrestEntry> penalIntrestEntryOptional = Optional.of(penalIntrestEntry);
        when(repository.findById(JunitConstants.LONG_TYPE)).thenReturn(penalIntrestEntryOptional);

        service.deleteById(JunitConstants.LONG_TYPE);

        verify(repository, atLeast(1)).save(penalIntrestEntry);

    }

    @Test
    void testGetBankwisePenalInterestUsingMonthAndYear(){

        when(luLookUpInfoRepository.findBylookUpInfoId(JunitConstants.LONG_TYPE)).thenReturn(monthLookUpInfo);
        when(luLookUpInfoRepository.findBylookUpInfoId(JunitConstants.LONG_TYPE_ZER)).thenReturn(yearLookUpInfo);
        when(yearLookUpInfo.getLookUpInfoValue()).thenReturn(2021);
        when(monthLookUpInfo.getLookUpInfoValue()).thenReturn(8);
        LocalDate fromDate = LocalDate.of(2021, 8, 01);
        when(gstSaDaChallanMappingRepository.
                findByBankIdAndRbiFileTranxnAcceptanceDttmLessThanEqualAndRbiFileTranxnAcceptanceDttmGreaterThanEqual(JunitConstants.LONG_TYPE,
                        GSTUtility.convertStringToDate(LocalDate.of(yearLookUpInfo.getLookUpInfoValue(), monthLookUpInfo.getLookUpInfoValue(),
                                31).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                        GSTUtility.convertStringToDate(fromDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))).thenReturn(Arrays.asList(new GstSaDaChallanMapping[]{gstSaDaChallanMapping}));

        when(gstSaDaChallanMapping.getRbiFileTranxn()).thenReturn(gstRbiFilesTranxn);
        when(gstRbiFilesTranxn.getTransactionDttm()).thenReturn(new Date());
        LocalDate accDt = DateUtil.convertToLocalDate(new Date()).plusDays(3);
        when(gstRbiFilesTranxn.getAcceptanceDttm()).thenReturn(DateUtil.convertToDate(accDt));
        when(bankRateMasterRepository.findAll(any(Specification.class))).thenReturn(Arrays.asList(new GSTBankRateMaster[]{gstBankRateMaster}));
        when(gstRbiFilesTranxn.getTotalTransAmt()).thenReturn(50000000.0);
        when(gstBankRateMaster.getEffectiveFromDate()).thenReturn(LocalDate.now());
        when(gstBankRateMaster.getEffectiveToDate()).thenReturn(LocalDate.now().plusDays(4));
        when(gstBankRateMaster.getBankRate()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(gstBankRateMaster.getAdditionalRate()).thenReturn(JunitConstants.DOUBLE_VAL);

        GSTBankWisePenalInterestDto gstBankWisePenalInterestDto = service.getBankwisePenalInterestUsingMonthAndYear(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE_ZER);

        assertNotNull(gstBankWisePenalInterestDto);
    }

}

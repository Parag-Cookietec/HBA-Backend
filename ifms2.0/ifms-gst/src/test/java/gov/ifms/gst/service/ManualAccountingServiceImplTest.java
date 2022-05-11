package gov.ifms.gst.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.*;
import gov.ifms.gst.dto.HeadwiseDetailDto;
import gov.ifms.gst.dto.ManualEntryDto;
import gov.ifms.gst.entity.*;
import gov.ifms.gst.pagination.ChallanSearchCriteria;
import gov.ifms.gst.pagination.ManualEntrySearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.*;
import gov.ifms.gst.service.impl.ChallanAccountingServiceImpl;
import gov.ifms.gst.service.impl.ManualEntryServiceImpl;
import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

/**
 * The Class ManualAccountingServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class ManualAccountingServiceImplTest {

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
    private ManualEntryServiceImpl service;

    @Mock
    private AccManualEntryConverter hdrConverter;

    @Mock
    private CreditEntryConverter crEntryConverter;

    @Mock
    private DebitEntryConverter drEntryConverter;

    @Mock
    private TPAOAccManualEntryHdrRepository hdrRepository;

    @Mock
    private MsMajorHeadRepository msMajorHeadRepository;

    @Mock
    private MsSubMajorHeadRepository msSubMajorHeadRepository;

    @Mock
    private MsMinorHeadRepository msMinorHeadRepository;

    @Mock
    private MsSubHeadRepository msSubHeadRepository;

    @Mock
    private MsDetailHeadRepository msDetailHeadRepository;

    @Mock
    private MsObjectHeadRepository msObjectHeadRepository;

    @Mock
    private GSTCINFileDataRepository gstcinFileDataRepository;

    @Mock
    private GstWfActionConfigService gstWfActionConfigService;

    @Mock
    private ManualEntrySearchCriteria searchCriteria;

    @Mock
    private SpecificationImpl<AccManualEntryHdr> spec;

    @Mock
    private Page<AccManualEntryHdr> page;

    @Mock
    private AccManualEntryHdr accManualEntryHdr;

    @Mock
    private ManualEntryDto manualEntryDto;

    @Mock
    private MsMajorHeadEntity msMajorHeadEntity;

    @Mock
    private MsSubMajorHeadEntity msSubMajorHeadEntity;

    @Mock
    private MsMinorHeadEntity msMinorHeadEntity;

    @Mock
    private MsSubHeadEntity msSubHeadEntity;

    @Mock
    private MsDetailHeadEntity msDetailHeadEntity;

    @Mock
    private MsObjectHeadEntity msObjectHeadEntity;

    @Mock
    private AccManualEntryCr manualEntryCr;

    @Mock
    private AccManualEntryDr manualEntryDr;

    private HeadwiseDetailDto dto;

    @Mock
    private Page<MsObjectHeadEntity> msObjectHeadEntityPage;

    @Mock
    private EODCINFileData eodcinFileData;

    /**
     * The page detail.
     */
    @Mock
    private PageDetails pageDetail;

    @Mock
    private PageRequest pageable;

    @BeforeEach
    void beforeEachTest(){
        dto = new HeadwiseDetailDto();
        dto.setMajorheadId(JunitConstants.LONG_TYPE);
        dto.setSubmajorheadId(JunitConstants.LONG_TYPE);
        dto.setMinorheadId(JunitConstants.LONG_TYPE);
        dto.setDetailheadId(JunitConstants.LONG_TYPE);
        dto.setSubheadId(JunitConstants.LONG_TYPE);
    }

    @Test
    void testGetChallanList() throws CustomException {

        when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
        SearchParam searchParam = new SearchParam();
        searchParam.setKey(JunitConstants.STRING_TYPE);
        searchParam.setValue(JunitConstants.STRING_TYPE);
        List<SearchParam> list = new ArrayList<>();
        list.add(searchParam);

        when(pageDetail.getJsonArr()).thenReturn(list);
        when(searchCriteria.getManualEntrySpecificationDetail(any(SpecificationImpl.class), anyList())).thenReturn(spec);
        List<AccManualEntryHdr> accManualEntryHdrs = new ArrayList<>();
        accManualEntryHdrs.add(accManualEntryHdr);
        when(hdrRepository.findAll(spec, pageable)).thenReturn(page);
        when(page.getContent()).thenReturn(accManualEntryHdrs);

        when(page.getTotalPages()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getSize()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);

        assertNotNull(service.getManualEntryList(pageDetail));

    }

    @Test
    void testSaveOrUpdate() throws CustomException {

        Optional<EODCINFileData> eodcinFileDataOptional = Optional.empty();
        when(gstcinFileDataRepository.findByCinNo(JunitConstants.STRING_ABC)).thenReturn(eodcinFileDataOptional);
        when(hdrConverter.toEntity(manualEntryDto)).thenReturn(accManualEntryHdr);
        when(hdrRepository.callStoredProcedure(any(), anyMap())).thenReturn(Arrays.asList(new String[][]{ new String[]{JunitConstants.STRING_ABC}}));
        List<AccManualEntryCr> creditEntries = Arrays.asList(new AccManualEntryCr[]{manualEntryCr});
        List<AccManualEntryDr> debitEntries = Arrays.asList(new AccManualEntryDr[]{manualEntryDr});
        when(crEntryConverter.toEntity(manualEntryDto.getCreditEntries())).thenReturn(creditEntries);
        when(drEntryConverter.toEntity(manualEntryDto.getDebitEntries())).thenReturn(debitEntries);
        doNothing().when(manualEntryCr).setAccManualHdr(accManualEntryHdr);
        doNothing().when(accManualEntryHdr).setCreditEntries(creditEntries);
        doNothing().when(manualEntryDr).setAccManualHdr(accManualEntryHdr);
        doNothing().when(accManualEntryHdr).setDebitEntries(debitEntries);
        when(manualEntryDto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
        when(hdrRepository.save(accManualEntryHdr)).thenReturn(accManualEntryHdr);
        when(gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(1L, 1L))).thenReturn(JunitConstants.INT_TYPE);
        when(hdrConverter.toDTO(accManualEntryHdr)).thenReturn(manualEntryDto);

        assertNotNull(service.saveOrUpdate(manualEntryDto));
    }

    @Test
    void testGetChallanById() throws CustomException {

        Optional<AccManualEntryHdr> accManualEntryHdrOptional = Optional.of(accManualEntryHdr);
        when(hdrRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(accManualEntryHdrOptional);
        when(hdrConverter.toDTO(accManualEntryHdr)).thenReturn(manualEntryDto);

        assertNotNull(service.getById(JunitConstants.LONG_TYPE));

    }

    @Test
    void testDeleteById() throws CustomException {
        Optional<AccManualEntryHdr> accManualEntryHdrOptional = Optional.of(accManualEntryHdr);
        when(hdrRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(accManualEntryHdrOptional);

        service.deleteById(JunitConstants.LONG_TYPE);

        verify(hdrRepository, atLeast(1)).save(accManualEntryHdr);

    }

    @Test
    void testGetTypeList() throws CustomException {
        assertNotNull(service.getTypeList());
    }

    @Test
    void testGetMajorHeadList() throws CustomException {
        List<MsMajorHeadEntity> msMajorHeadEntityList = new ArrayList<>();
        msMajorHeadEntityList.add(msMajorHeadEntity);

        when(msMajorHeadRepository.findAll()).thenReturn(msMajorHeadEntityList);
        when(msMajorHeadEntity.getMajorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
        when(msMajorHeadEntity.getMajorHeadName()).thenReturn(JunitConstants.STRING_ABC);
        when(msMajorHeadEntity.getMajorHeadCode()).thenReturn(JunitConstants.STRING_ABC);
        when(msMajorHeadEntity.getMajorHeadCodeName()).thenReturn(JunitConstants.STRING_ABC);
        when(msMajorHeadEntity.getMajorHeadDesc()).thenReturn(JunitConstants.STRING_ABC);

        assertNotNull(service.getMajorHeadList());

    }


    @Test
    void testGetSubMajorHeadList() throws CustomException {
        List<MsSubMajorHeadEntity> msSubMajorHeadEntities = new ArrayList<>();
        msSubMajorHeadEntities.add(msSubMajorHeadEntity);

        when(msSubMajorHeadRepository.findByMajorHeadEntityMajorHeadIdOrderBySubMajorHeadCode(dto.getMajorheadId())).thenReturn(msSubMajorHeadEntities);
        when(msSubMajorHeadEntity.getSubMajorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
        when(msSubMajorHeadEntity.getSubmajorHeadName()).thenReturn(JunitConstants.STRING_ABC);
        when(msSubMajorHeadEntity.getSubMajorHeadCode()).thenReturn(JunitConstants.STRING_ABC);
        when(msSubMajorHeadEntity.getSubMajorHeadCodeNames()).thenReturn(JunitConstants.STRING_ABC);
        when(msSubMajorHeadEntity.getSubMajorHeadDesc()).thenReturn(JunitConstants.STRING_ABC);

        assertNotNull(service.getSubMajorHeadList(dto));

    }

    @Test
    void testGetMinorHeadList() throws CustomException {
        List<MsMinorHeadEntity> minorHeadEntities = new ArrayList<>();
        minorHeadEntities.add(msMinorHeadEntity);

        when(msMinorHeadRepository
                .findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdOrderByMinorHeadCode(
                        dto.getMajorheadId(), dto.getSubmajorheadId())).thenReturn(minorHeadEntities);
        when(msMinorHeadEntity.getMinorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
        when(msMinorHeadEntity.getMinorHeadCode()).thenReturn(JunitConstants.STRING_ABC);
        when(msMinorHeadEntity.getMinorHeadName()).thenReturn(JunitConstants.STRING_ABC);
        when(msMinorHeadEntity.getMinorHeadCodeName()).thenReturn(JunitConstants.STRING_ABC);
        when(msMinorHeadEntity.getMinorHeadDesc()).thenReturn(JunitConstants.STRING_ABC);

        assertNotNull(service.getMinorHeadList(dto));

    }

    @Test
    void testSubHeadList() throws CustomException {
        List<MsSubHeadEntity> msSubHeadEntities = new ArrayList<>();
        msSubHeadEntities.add(msSubHeadEntity);

        when(msSubHeadRepository
                .findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdOrderBySubHeadCodeAsc(
                dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId())).thenReturn(msSubHeadEntities);
        when(msSubHeadEntity.getSubHeadId()).thenReturn(JunitConstants.LONG_TYPE);
        when(msSubHeadEntity.getSubHeadCode()).thenReturn(JunitConstants.STRING_ABC);
        when(msSubHeadEntity.getSubHeadName()).thenReturn(JunitConstants.STRING_ABC);
        when(msSubHeadEntity.getSubHeadCodeName()).thenReturn(JunitConstants.STRING_ABC);
        when(msSubHeadEntity.getSubHeadDesc()).thenReturn(JunitConstants.STRING_ABC);

        assertNotNull(service.getSubHeadList(dto));

    }

    @Test
    void testGetDetailsHeadList() throws CustomException {
        List<MsDetailHeadEntity> msDetailHeadEntities = new ArrayList<>();
        msDetailHeadEntities.add(msDetailHeadEntity);

        when(msDetailHeadRepository
                .findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndSubHeadEntitySubHeadIdOrderByDetailHeadCode(
                        dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId(),
                        dto.getSubheadId())).thenReturn(msDetailHeadEntities);
        when(msDetailHeadEntity.getDetailHeadId()).thenReturn(JunitConstants.LONG_TYPE);
        when(msDetailHeadEntity.getDetailHeadCode()).thenReturn(JunitConstants.STRING_ABC);
        when(msDetailHeadEntity.getDetailHeadName()).thenReturn(JunitConstants.STRING_ABC);
        when(msDetailHeadEntity.getDetailHeadCodeName()).thenReturn(JunitConstants.STRING_ABC);
        when(msDetailHeadEntity.getDetailHeadDesc()).thenReturn(JunitConstants.STRING_ABC);

        assertNotNull(service.getDetailsHeadList(dto));

    }

    @Test
    void testGetObjectHeadList() throws CustomException {
        List<MsObjectHeadEntity> msObjectHeadEntities = new ArrayList<>();
        msObjectHeadEntities.add(msObjectHeadEntity);

        when(msObjectHeadEntityPage.getContent()).thenReturn(msObjectHeadEntities);
        when(msObjectHeadRepository.findAll(pageable)).thenReturn(msObjectHeadEntityPage);
        when(msObjectHeadEntity.getObjectId()).thenReturn(JunitConstants.LONG_TYPE);
        when(msObjectHeadEntity.getObjectCode()).thenReturn(JunitConstants.STRING_ABC);
        when(msObjectHeadEntity.getObjectName()).thenReturn(JunitConstants.STRING_ABC);
        when(msObjectHeadEntity.getObjectCodeName()).thenReturn(JunitConstants.STRING_ABC);
        when(msObjectHeadEntity.getObjectDesc()).thenReturn(JunitConstants.STRING_ABC);

        assertNotNull(service.getDetailsHeadList(dto));

    }
}

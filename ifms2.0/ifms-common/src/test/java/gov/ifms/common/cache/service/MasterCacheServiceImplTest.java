package gov.ifms.common.cache.service;

import gov.ifms.common.cache.dto.*;
import gov.ifms.common.cache.repository.CacheRepository;
import gov.ifms.common.cache.util.CacheQueryConstant;
import gov.ifms.common.exception.CustomException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MasterCacheServiceImplTest {


    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    MasterCacheServiceImpl masterCacheService;

    @Mock
    CacheRepository cacheRepository;

    @Mock
    List<MsFyCacheDto> cacheDtoList;

    @Mock
    List<MsBPNCacheDto> msBPNCacheDtoList;
    @Mock
    List<MsDeptCacheDto> msDeptCacheDtos;
    @Mock
    MsDeptCacheDto msDepartmentCacheDtos;
    @Mock
    MsDeptCacheDto msDeptCacheDto;
    @Mock
    List<LkDeptDemandCacheDto> lkDeptDemandCacheDtos;
    @Mock
    List<MsDeptCacheDto> msDeptCacheDtoList;
    @Mock
    List<MsDemandCacheDto> msDemandCacheDtoList;
    @Mock
    List<MsSectorHeadCacheDto>  msSectorHeadCacheDtoList;
    @Mock
    List<MsSubSectorCacheDto>  msSubSectorCacheDtoList;
    @Mock
    List<MsSubMajorHeadCacheDto>  msSubMajorHeadCacheDtoList;
    @Mock
    List<MsMinorHeadCacheDto> msMinorHeadCacheDtoList;
    @Mock
    List<MsSubHeadCacheDto> msSubHeadCacheDtoList;
    @Mock
    List<MsDetailHeadCacheDto>  msDetailHeadCacheDtoList;
    @Mock
    List<MsObjectHeadCacheDto> msObjectHeadCacheDtoList;
    @Mock
    List<MsObjectHeadCacheDto> msObjectHeadCacheDtoLists;
    @Mock
    List<MsMinisterInChargeCacheDto> ministerInChargeCacheDtoList;
    @Mock
    List<MsMinisterInChargeCacheDto> ministerInChargeCacheDtoLists;
    @Mock
    List<MsDistrictCacheDto> msDistrictCacheDtoList;
    @Mock
    List<MsDistrictCacheDto> msDistrictsCacheDtos;
    @Mock
    MsDistrictCacheDto msDistrictCacheDtos;
    @Mock
    List<MsStateCacheDto> msStatesCacheDtos;
    @Mock
    MsStateCacheDto msStateCacheDtos;
    @Mock
    List<MsTalukaCacheDto> msTalukasCacheDtos;
    @Mock
    MsTalukaCacheDto msTalukaCacheDto;
    @Mock
    List<MsDesignationCacheDto> msDesignationsCacheDtos;
    @Mock
    MsDesignationCacheDto msDesignationCacheDto;
    @Mock
    List<LkLookUpInfoCacheDto> lkLookUpInfoCacheDtoList;
    @Mock
    List<LkLookUpInfoCacheDto> lkLookUpInfoCacheDtoLists;
    @Mock
    List<LkLookUpInfoCacheDto> lookUpInfoCacheDtoListss;

    @Mock
   List<MsMajorHeadCacheDto>  msMajorHeadCacheDtoList;
    
    @Mock
    List<MsSubMajorHeadCacheDto> msSubMajorHeadCacheDtolist;


    @Test
    void getAllFyMaster() throws CustomException {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(cacheDtoList);
        masterCacheService.getAllFyMaster();
    }

    @Test
    void getAllBPNMaster() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msBPNCacheDtoList);
        masterCacheService.getAllBPNMaster();
    }

    @Test
    void getAllDeptMaster() throws CustomException {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDeptCacheDtoList);
        masterCacheService.getAllDeptMaster();
    }

    @Test
    void getDeptByIdMaster() {
        when(cacheRepository.executeTypedHQLQuerySingle(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDepartmentCacheDtos);
        masterCacheService.getDeptByIdMaster(1L);
    }

    @Test
    void getDemandByDeptId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDemandCacheDtoList);
        masterCacheService.getDemandByDeptId(1L);
    }


    @Test
    void getDeptByDemandId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDeptCacheDtos);
        masterCacheService.getDeptByDemandId(1L);
    }

    @Test
    void getDemandByBpnId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDemandCacheDtoList);
        masterCacheService.getDemandByBpnId(1L);
    }

    @Test
    void getSectorHead() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msSectorHeadCacheDtoList);
        masterCacheService.getSectorHead();
    }

    @Test
    void getSubSectorBySectorHeadId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msSubSectorCacheDtoList);
        masterCacheService.getSubSectorBySectorHeadId(1l);
    }

    @Test
    void getSubMajorHeadByMajorHeadId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msSubMajorHeadCacheDtoList);
        masterCacheService.getSubMajorHeadByMajorHeadId(1l);
    }

    @Test
    void getMinorHeadBySubMajorHeadId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msMinorHeadCacheDtoList);
        masterCacheService.getMinorHeadBySubMajorHeadId(1l);
    }

    @Test
    void getSubHeadByMinorHeadId() throws CustomException {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msSubHeadCacheDtoList);
        masterCacheService.getSubHeadByMinorHeadId(1l);
    }

    @Test
    void getDetailHeadBySubHeadId() throws CustomException {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDetailHeadCacheDtoList);
        masterCacheService.getDetailHeadBySubHeadId(1l);
    }

    @Test
    void getObjectHead() throws CustomException {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msObjectHeadCacheDtoLists);
        masterCacheService.getObjectHead();
    }

    @Test
    void getObjectHeadByObjectClassId() throws CustomException {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msObjectHeadCacheDtoList);
        masterCacheService.getObjectHeadByObjectClassId(5l);
    }

    @Test
    void getMinisterByDemandId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(ministerInChargeCacheDtoList);
        masterCacheService.getMinisterByDemandId(5l);
    }

    @Test
    void getMinisterByPOUId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(ministerInChargeCacheDtoLists);
        masterCacheService.getMinisterByPOUId(5l);
    }

    @Test
    void getStates() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msStatesCacheDtos);
        masterCacheService.getStates();
    }

    @Test
    void getStateByStateId() {
        when(cacheRepository.executeTypedHQLQuerySingle(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msStateCacheDtos);
        masterCacheService.getStateByStateId(7L);
    }

    @Test
    void getDistrictByDistrictId() {
        when(cacheRepository.executeTypedHQLQuerySingle(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDistrictCacheDtos);
        masterCacheService.getDistrictByDistrictId(5l);
    }

    @Test
    void getDistrictOnlyGUJState() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDistrictsCacheDtos);
        masterCacheService.getDistrictOnlyGUJState();
    }
    
    @Test
    void getDistrictsByStateId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDistrictsCacheDtos);
        masterCacheService.getDistrictsByStateId(7L);
    }
    
    @Test
    void getTalukasByDistrictId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msTalukasCacheDtos);
        masterCacheService.getTalukasByDistrictId(1L);
    }
    
    @Test
    void getTalukasByTalukaId() {
        when(cacheRepository.executeTypedHQLQuerySingle(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msTalukaCacheDto);
        masterCacheService.getTalukaByTalukaId(108L);
    }
    
    @Test
    void getDesignations() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDesignationsCacheDtos);
        masterCacheService.getDesignations();
    }
    
    @Test
    void getDesignationByDesignationId() {
        when(cacheRepository.executeTypedHQLQuerySingle(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msDesignationCacheDto);
        masterCacheService.getDesignationByDesignationId(2011L);
    }

    

    @Test
    void getLookupInfoByParentLookupId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(lookUpInfoCacheDtoListss);
        masterCacheService.getLookupInfoByParentLookupId(2l);
    }

    @Test
    void getLookupInfoByParentLookupName() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(lkLookUpInfoCacheDtoList);
        masterCacheService.getLookupInfoByParentLookupName("Location Type");
    }

    @Test
    void getLookupInfoId() {
        when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(lkLookUpInfoCacheDtoLists);
        masterCacheService.getLookupInfoId(1L);
    }
    
    @Test
    void getMajorHeadByDemandId() throws CustomException {
    	when(cacheRepository.executeTypedHQLQuery(Mockito.anyString(), Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(msMajorHeadCacheDtoList);
    	masterCacheService.getMajorHeadByDemandId(1L);
    }
  
    
    
    
}
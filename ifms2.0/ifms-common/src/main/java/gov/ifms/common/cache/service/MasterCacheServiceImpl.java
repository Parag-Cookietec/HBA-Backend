package gov.ifms.common.cache.service;


import gov.ifms.common.cache.dto.*;
import gov.ifms.common.cache.repository.CacheRepository;
import gov.ifms.common.cache.util.CacheQueryConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class MasterCacheServiceImpl implements MasterCacheService {

    @Autowired
    private CacheRepository cacheRepository;

    @Override
    @Cacheable(value = "fyCache")
    public List<MsFyCacheDto> getAllFyMaster()  {
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getAllFy(), CacheQueryConstant.getActiveStatusMap(), MsFyCacheDto.class);
    }

    @Cacheable(value = "bpnCache")
    @Override
    public List<MsBPNCacheDto> getAllBPNMaster(){
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getAllBPN(), CacheQueryConstant.getActiveStatusMap(), MsBPNCacheDto.class);
    }

    @Cacheable(value = "deptCache")
    @Override
    public List<MsDeptCacheDto> getAllDeptMaster() throws CustomException {
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getAllDept(), CacheQueryConstant.getActiveStatusMap(), MsDeptCacheDto.class);
    }

    @Override
    @Cacheable(value = "deptCachebyId" ,key = "#id")
    public MsDeptCacheDto getDeptByIdMaster(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("departmentId",id);
        return cacheRepository.executeTypedHQLQuerySingle(CacheQueryConstant.getDeptById(), map, MsDeptCacheDto.class);
    }

    @Override
    @Cacheable(value = "demandCachebydeptId" ,key = "#id")
    public List<LkDeptDemandCacheDto> getDemandByDeptId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("departmentId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getLKDemandByDeptId(), map, LkDeptDemandCacheDto.class);
    }

    @Override
    @Cacheable(value = "deptCachebyDemandId" ,key = "#id")
    public List<MsDeptCacheDto> getDeptByDemandId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("demandId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getLKDeptByDemandId(), map, MsDeptCacheDto.class);
    }

    @Override
    @Cacheable(value = "demandByBpnId" ,key = "#id")
    public List<MsDemandCacheDto> getDemandByBpnId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("bpnId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getDemandByBpnId(), map, MsDemandCacheDto.class);
    }

    @Override
    @Cacheable(value = "sectorHead")
    public List<MsSectorHeadCacheDto> getSectorHead() {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getSectorHead(), map, MsSectorHeadCacheDto.class);
    }

    @Override
    @Cacheable(value = "subSectorCacheBySectorHeadId" ,key = "#id")
    public List<MsSubSectorCacheDto> getSubSectorBySectorHeadId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("sectorHeadId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getSubSectorBySectorHeadId(), map, MsSubSectorCacheDto.class);
    }

    @Override
    @Cacheable(value = "subMajorHeadCacheByMajorHeadId" ,key = "#id")
    public List<MsSubMajorHeadCacheDto> getSubMajorHeadByMajorHeadId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("majorHeadId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getSubMajorHeadByMajorHeadId(), map, MsSubMajorHeadCacheDto.class);
    }



    @Override
    @Cacheable(value = "subMinorHeadBySubMajorHeadId" ,key = "#id")
    public List<MsMinorHeadCacheDto> getMinorHeadBySubMajorHeadId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("subMajorHeadId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getMinorHeadBySubMajorHeadId(), map, MsMinorHeadCacheDto.class);
    }

    @Override
    @Cacheable(value = "subHeadByMinorHeadId" ,key = "#minorHeadId")
    public List<MsSubHeadCacheDto> getSubHeadByMinorHeadId(Long minorHeadId) throws CustomException {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("minorHeadId",minorHeadId);
        List<Object[]> objects = cacheRepository.executeHQLQuery(CacheQueryConstant.getSubHeadByMinorHeadId(), map);
        return  !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects , MsSubHeadCacheDto.class) : Collections.emptyList();
    }

    @Override
    @Cacheable(value = "detailHeadBySubHeadId" , key = "#id")
    public List<MsDetailHeadCacheDto> getDetailHeadBySubHeadId(Long id) throws CustomException {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("subHeadId",id);
        List<Object[]> objects = cacheRepository.executeHQLQuery(CacheQueryConstant.getDetailHeadBySubHeadId(), map);
        return  !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects , MsDetailHeadCacheDto.class) : Collections.emptyList();
    }

    @Override
    @Cacheable(value = "objectHead")
    public List<MsObjectHeadCacheDto> getObjectHead() throws CustomException {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        List<Object[]> objects = cacheRepository.executeHQLQuery(CacheQueryConstant.getObjectHead(), map);
        return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects , MsObjectHeadCacheDto.class) : Collections.emptyList();
    }

    @Override
    @Cacheable(value = "objectHeadByObjectClassId" ,key = "#id")
    public List<MsObjectHeadCacheDto> getObjectHeadByObjectClassId(Long id) throws CustomException {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("objectClassId",id);
        List<Object[]> objects = cacheRepository.executeHQLQuery(CacheQueryConstant.getObjectHeadByObjectClassId(), map);
        return !Utils.isEmpty(objects) ?  NativeQueryResultsMapper.map(objects , MsObjectHeadCacheDto.class) : Collections.emptyList();
    }


    @Override
    @Cacheable(value = "ministerByDemandId" ,key = "#demandId")
    public List<MsMinisterInChargeCacheDto> getMinisterByDemandId(Long demandId) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("demandId",demandId);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getMinisterByDemandId(), map, MsMinisterInChargeCacheDto.class);
    }

    @Override
    @Cacheable(value = "ministerByLkPOUId" ,key = "#lkPOUId")
    public List<MsMinisterInChargeCacheDto> getMinisterByPOUId(Long lkPOUId) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("lkPOUId",lkPOUId);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getMinisterByPOUId(), map, MsMinisterInChargeCacheDto.class);
    }

    @Override
    public List<MsStateCacheDto> getStates() {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getState(), map, MsStateCacheDto.class);
    }

    @Override
    public MsStateCacheDto getStateByStateId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("stateId",id);
        return cacheRepository.executeTypedHQLQuerySingle(CacheQueryConstant.getStateByStateId(), map, MsStateCacheDto.class);
    }

    @Override
    @Cacheable(value = "districtByDistrictId" ,key = "#id")
    public MsDistrictCacheDto getDistrictByDistrictId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("districtId",id);
        return cacheRepository.executeTypedHQLQuerySingle(CacheQueryConstant.getDistrictByDistrictId(), map, MsDistrictCacheDto.class);
    }

    @Override
    @Cacheable(value = "districtGUJState")
    public List<MsDistrictCacheDto> getDistrictOnlyGUJState() {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("stateId", Constant.STATE_GUJ_ID);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getDistrictOnlyGUJState(), map, MsDistrictCacheDto.class);
    }

    @Override
    @Cacheable(value = "districtsByStateId" ,key = "#id")
    public List<MsDistrictCacheDto> getDistrictsByStateId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("stateId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getDistrictByStateId(), map, MsDistrictCacheDto.class);
    }

    @Override
    @Cacheable(value = "talukasByDistrictId" ,key = "#id")
    public List<MsTalukaCacheDto> getTalukasByDistrictId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("districtId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getTalukaByDistrictId(), map, MsTalukaCacheDto.class);
    }

    @Override
    @Cacheable(value = "talukaByTalukaId" ,key = "#id")
    public MsTalukaCacheDto getTalukaByTalukaId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("talukaId",id);
        return cacheRepository.executeTypedHQLQuerySingle(CacheQueryConstant.getTalukaByTalukaId(), map, MsTalukaCacheDto.class);
    }

    @Override
    @Cacheable(value = "designations")
    public List<MsDesignationCacheDto> getDesignations() {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getDesignation(), map, MsDesignationCacheDto.class);
    }

    @Override
    @CacheEvict(value = "designations" ,allEntries = true)
    public boolean evictDesignationsCache() {return  Boolean.TRUE; }

    @Override
    @Cacheable(value = "designationByDesignationId" ,key = "#id")
    public MsDesignationCacheDto getDesignationByDesignationId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("designationId",id);
        return cacheRepository.executeTypedHQLQuerySingle(CacheQueryConstant.getDesignationByDesignationId(), map, MsDesignationCacheDto.class);
    }

    @Override
    @Cacheable(value = "lookupInfoByPlookupId" ,key = "#id")
    public List<LkLookUpInfoCacheDto> getLookupInfoByParentLookupId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("lookUpId", id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getLookupInfoByParentLookupId(), map, LkLookUpInfoCacheDto.class);
    }

    @Override
    @Cacheable(value = "lookupInfoByPlookupName" ,key = "#fieldValue")
    public List<LkLookUpInfoCacheDto> getLookupInfoByParentLookupName(String fieldValue) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("lookUpName", fieldValue);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getLookupInfoByParentLookupName(), map, LkLookUpInfoCacheDto.class);
    }

    @Override
    @Cacheable(value = "lookupInfoId" ,key = "#id")
    public List<LkLookUpInfoCacheDto> getLookupInfoId(Long id) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("lookUpInfoId", id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getLookupInfoId(), map, LkLookUpInfoCacheDto.class);
    }

    @Override
    @CacheEvict(value = "subHeadByMinorHeadId" ,allEntries = true)
    public boolean evictSubHeadCache() {
        return  Boolean.TRUE;
    }

    @Override
    @CacheEvict(value = "detailHeadBySubHeadId" ,allEntries = true)
    public boolean evictDetailHeadCache() {
        return Boolean.TRUE;
    }

    @Override
    @Cacheable(value = "wfStatusCacheByOfcMenuId" , key="#dto.hashCode()")
    public List<String> getWfStatus(CommonDto dto) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("menuId", dto.getMenuId());
        map.put("officeTypeId", dto.getOfficeTypeId());
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getWfStatus(), map, String.class);
    }

    @Override
    @Cacheable(value = "trnStatusCacheByOfcMenuId" , key="#dto.hashCode()")
    public List<String> getTrnStatus(CommonDto dto) {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("menuId", dto.getMenuId());
        map.put("officeTypeId", dto.getOfficeTypeId());
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getTrnStatus(), map, String.class);
    }

    @Override
    @Cacheable(value = "majorHeadByDemandId" ,key = "#id")
    public List<MsMajorHeadCacheDto> getMajorHeadByDemandId(Long id) throws CustomException {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("demandId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getMajorHeadByDemandId(), map, MsMajorHeadCacheDto.class);
    }
    
    @Override
    @Cacheable(value = "officeByDistrictId" ,key = "#id")
    public List<MsOfficeCacheDto> getOfficeByDistrictId(Long id) throws CustomException {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("districtId",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getOffByDistrictId(), map, MsOfficeCacheDto.class);
    }
    
    
    @Override
    @Cacheable(value = "getDemandByDemandCode",key = "#id")
    public List<MsDemandCacheDto> getDemandByDemandCode(String id) throws CustomException {
        Map<String, Object> map = CacheQueryConstant.getActiveStatusMap();
        map.put("demandCode",id);
        return cacheRepository.executeTypedHQLQuery(CacheQueryConstant.getDemandByDemandCode(), map, MsDemandCacheDto.class);
    }
}

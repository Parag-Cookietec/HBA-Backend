package gov.ifms.common.cache.service;

import gov.ifms.common.cache.dto.*;
import gov.ifms.common.exception.CustomException;

import java.util.List;

public interface MasterCacheService {

	List<MsFyCacheDto> getAllFyMaster();

	List<MsBPNCacheDto> getAllBPNMaster();

	List<MsDeptCacheDto> getAllDeptMaster() throws CustomException;

	MsDeptCacheDto getDeptByIdMaster(Long id);

	List<LkDeptDemandCacheDto> getDemandByDeptId(Long id);

	List<MsDeptCacheDto> getDeptByDemandId(Long id);

	List<MsDemandCacheDto> getDemandByBpnId(Long id);

	List<MsSectorHeadCacheDto> getSectorHead();

	List<MsSubSectorCacheDto> getSubSectorBySectorHeadId(Long id);

	List<MsSubMajorHeadCacheDto> getSubMajorHeadByMajorHeadId(Long id);

	List<MsMinorHeadCacheDto> getMinorHeadBySubMajorHeadId(Long id);

	List<MsSubHeadCacheDto> getSubHeadByMinorHeadId(Long id) throws CustomException;

	List<MsDetailHeadCacheDto> getDetailHeadBySubHeadId(Long id) throws CustomException;

	List<MsObjectHeadCacheDto> getObjectHead() throws CustomException;

	List<MsObjectHeadCacheDto> getObjectHeadByObjectClassId(Long id) throws CustomException;

	List<MsMinisterInChargeCacheDto> getMinisterByDemandId(Long id);

	List<MsMinisterInChargeCacheDto> getMinisterByPOUId(Long id);

	List<MsStateCacheDto> getStates();

	MsStateCacheDto getStateByStateId(Long id);

	MsDistrictCacheDto getDistrictByDistrictId(Long id);

	List<MsDistrictCacheDto> getDistrictOnlyGUJState();

	List<MsDistrictCacheDto> getDistrictsByStateId(Long id);

	List<MsTalukaCacheDto> getTalukasByDistrictId(Long id);

	MsTalukaCacheDto getTalukaByTalukaId(Long id);

	List<MsDesignationCacheDto> getDesignations();

	boolean evictDesignationsCache();

	MsDesignationCacheDto getDesignationByDesignationId(Long id);

	List<LkLookUpInfoCacheDto> getLookupInfoByParentLookupId(Long id);

	List<LkLookUpInfoCacheDto> getLookupInfoByParentLookupName(String fieldValue);

	List<LkLookUpInfoCacheDto> getLookupInfoId(Long id);

	boolean evictSubHeadCache();

	boolean evictDetailHeadCache();

	List<String> getWfStatus(CommonDto dto);

	List<String> getTrnStatus(CommonDto dto);

	List<MsMajorHeadCacheDto> getMajorHeadByDemandId(Long id) throws CustomException;

	public List<MsOfficeCacheDto> getOfficeByDistrictId(Long id) throws CustomException;

	List<MsDemandCacheDto> getDemandByDemandCode(String id) throws CustomException;
}

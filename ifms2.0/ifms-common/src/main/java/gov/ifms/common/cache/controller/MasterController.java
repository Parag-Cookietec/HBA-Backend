package gov.ifms.common.cache.controller;

import gov.ifms.common.cache.dto.CommonDto;
import gov.ifms.common.cache.service.MasterCacheService;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.FieldDto;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URLConstant.MASTERS_URL)
public class MasterController {

	@Autowired
	private MasterCacheService masterCacheService;

	/**
	 *
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_ALL_FY)
	public ResponseEntity<ApiResponse> getAllFinancialYearMaster() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, masterCacheService.getAllFyMaster());
	}

	/**
	 *
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_ALL_BPN)
	public ResponseEntity<ApiResponse> getBPNMaster() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, masterCacheService.getAllBPNMaster());
	}

	/**
	 *
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.GET_ALL_DEPT)
	public ResponseEntity<ApiResponse> getAllDept() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getAllDeptMaster());
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_DEPT_ID)
	public ResponseEntity<ApiResponse> getDeptById(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDeptByIdMaster(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_DEMAND_BY_DEPT_ID)
	public ResponseEntity<ApiResponse> getDemandByDeptId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDemandByDeptId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_DEPT_BY_DEMAND_ID)
	public ResponseEntity<ApiResponse> getDeptByDemandId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDeptByDemandId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_DEMAND_BY_BPN_ID)
	public ResponseEntity<ApiResponse> getDemandByBpnId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDemandByBpnId(idDto.getId()));
	}

	/**
	 *
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_SECTOR_HEAD)
	public ResponseEntity<ApiResponse> getSectorHead() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, masterCacheService.getSectorHead());
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_SUB_SECTOR_BY_SECTOR_HEAD_ID)
	public ResponseEntity<ApiResponse> getSubSectorBySectorHeadId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getSubSectorBySectorHeadId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_SUB_MAJORHEAD_BY_MAJOR_HEAD_ID)
	public ResponseEntity<ApiResponse> getSubMajorHeadByMajorHeadId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getSubMajorHeadByMajorHeadId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_MINORHEAD_BY_SUB_MAJORHEAD_ID)
	public ResponseEntity<ApiResponse> getMinorHeadBySubMajorHeadId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getMinorHeadBySubMajorHeadId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_SUBHEAD_BY_MINORHEAD_ID)
	public ResponseEntity<ApiResponse> getSubHeadByMinorHeadId(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getSubHeadByMinorHeadId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.GET_DETAILHEAD_BY_SUBHEAD_ID)
	public ResponseEntity<ApiResponse> getDetailHeadBySubHeadId(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDetailHeadBySubHeadId(idDto.getId()));
	}

	/**
	 *
	 * @return
	 * @throws CustomException
	 */

	@Trace
	@PostMapping(URLConstant.GET_OBJECTHEAD)
	public ResponseEntity<ApiResponse> getObjectHead() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, masterCacheService.getObjectHead());
	}

	/**
	 *
	 * @param idDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.GET_OBJECTHEAD_BY_OBJECTCLASS_ID)
	public ResponseEntity<ApiResponse> getObjectHeadByObjectClassId(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getObjectHeadByObjectClassId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_MINISTER_BY_DEMAND_ID)
	public ResponseEntity<ApiResponse> getMinisterByDemandId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getMinisterByDemandId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_MINISTER_BY_POUID)
	public ResponseEntity<ApiResponse> getMinisterByPOUId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getMinisterByPOUId(idDto.getId()));
	}

	/**
	 *
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_STATES)
	public ResponseEntity<ApiResponse> getStates() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, masterCacheService.getStates());
	}

	/**
	 * API to fetch state by stateId and use cache for retrieve data.
	 * 
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_STATE_BY_STATE_ID)
	public ResponseEntity<ApiResponse> getStateByStateId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getStateByStateId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_DISTRICT_BY_DISTRICT_ID)
	public ResponseEntity<ApiResponse> getDistrictByDistrictId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDistrictByDistrictId(idDto.getId()));
	}

	/**
	 *
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_DISTRICT_ONLY_GUJSTATE)
	public ResponseEntity<ApiResponse> getDistrictOnlyGUJState() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDistrictOnlyGUJState());
	}

	/**
	 * API to fetch all districts by stateId and use cache for retrieve data.
	 * 
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_DISTRICTS_BY_STATE_ID)
	public ResponseEntity<ApiResponse> getDistrictsByStateId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDistrictsByStateId(idDto.getId()));
	}

	/**
	 * API to fetch all talukas by districtId and use cache for retrieve data.
	 * 
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_TALUKAS_BY_DISTRICT_ID)
	public ResponseEntity<ApiResponse> getTalukasByDistrictId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getTalukasByDistrictId(idDto.getId()));
	}

	/**
	 * API to fetch taluka by talukaId and use cache for retrieve data.
	 * 
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_TALUKA_BY_TALUKA_ID)
	public ResponseEntity<ApiResponse> getTalukaByTalukaId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getTalukaByTalukaId(idDto.getId()));
	}

	/**
	 * API to fetch all designations and use cache for retrieve data.
	 * 
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_DESIGNATIONS)
	public ResponseEntity<ApiResponse> getDesignations() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, masterCacheService.getDesignations());
	}

	/**
	 * API to fetch designation by id and use cache for retrieve data.
	 * 
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_DESIGNATION_BY_DESIGNATION_ID)
	public ResponseEntity<ApiResponse> getDesignationByDesignationId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDesignationByDesignationId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_LOOKUPINFO_BY_PARENTLOOKUP_ID)
	public ResponseEntity<ApiResponse> getLookupInfoByParentLookupId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getLookupInfoByParentLookupId(idDto.getId()));
	}

	/**
	 *
	 * @param fieldDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_LOOKUPINFO_BY_PARENTLOOKUP_NAME)
	public ResponseEntity<ApiResponse> getLookupInfoByParentLookupName(@RequestBody FieldDto fieldDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getLookupInfoByParentLookupName(fieldDto.getFieldValue()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_LOOKUPINFO_ID)
	public ResponseEntity<ApiResponse> getLookupInfoId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getLookupInfoId(idDto.getId()));
	}

	/**
	 *
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.EVICT_CACHE_MS_SUB_HEAD)
	public ResponseEntity<ApiResponse> evictSubHeadCache() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE,
				masterCacheService.evictSubHeadCache());
	}

	/**
	 *
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.EVICT_CACHE_MS_DETAIL_HEAD)
	public ResponseEntity<ApiResponse> evictDetailHeadCache() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE,
				masterCacheService.evictDetailHeadCache());
	}

	/**
	 *
	 * @param dto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_WF_STATUS_V_2)
	public ResponseEntity<ApiResponse> getWfStatus(@RequestBody CommonDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, masterCacheService.getWfStatus(dto));
	}

	/**
	 *
	 * @param dto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.GET_WF_TRN_STATUS_V_2)
	public ResponseEntity<ApiResponse> getTrnStatus(@RequestBody CommonDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, masterCacheService.getTrnStatus(dto));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.GET_MAJOR_HEAD_BY_DEMAND_ID)
	public ResponseEntity<ApiResponse> getMajorHeadByDemandId(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getMajorHeadByDemandId(idDto.getId()));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.GET_OFF_BY_DISTRICT_ID)
	public ResponseEntity<ApiResponse> getOfficeByDistrictId(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getOfficeByDistrictId(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.GET_DEMAND_BY_DEMAND_CODE)
	public ResponseEntity<ApiResponse> getDemandbyDemandCode(@RequestBody String demandCode) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				masterCacheService.getDemandByDemandCode(demandCode));
	}

}

package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IntIdDto;
import gov.ifms.common.dto.SearchDto;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPLuLookUpInfoDto;
import gov.ifms.edp.dto.EdpLookupTypeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.service.EDPLuLookUpInfoService;

/**
 * The Class EDPLuLookUpInfoController.
 * 
 * @version 1.0.
 * @created 2019/08/29 18:24:43.
 *
 */

@RestController
@RequestMapping(URLConstant.URL_EDP_LOOKUP_INFO)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPLuLookUpInfoController {

	/** The service. */
	@Autowired
	private EDPLuLookUpInfoService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPLuLookUpInfoConverter converter;

	/**
	 * Fetch LuLookUpInfos by given LuLookUpInfos id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getLuLookUpInfo(@RequestBody IntIdDto id) {
		EDPLuLookUpInfoEntity entity = service.getLuLookUpInfo(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));

	}

	/**
	 * creates a new LuLookUpInfos.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createLuLookUpInfo(@RequestBody EDPLuLookUpInfoDto dto) {

		EDPLuLookUpInfoEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateLuLookUpInfo(entity)));

	}

	/**
	 * Update the LuLookUpInfos.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateLuLookUpInfo(@RequestBody EDPLuLookUpInfoDto dto) {

		EDPLuLookUpInfoEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateLuLookUpInfo(entity)));
	}

	/**
	 * Fetch all the LuLookUpInfos items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLuLookUpInfoDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getLuLookUpInfos(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPLuLookUpInfoDto> data = service.edpLuLookUpInfoAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, data);
	}

	/**
	 * This method is used to find look up info by object type.
	 *
	 * @return List of ClueDto
	 */
	@Trace
	@PostMapping(URLConstant.GET_REVENUE_CAPITAL)
	public ResponseEntity<ApiResponse> getRevenueCapitalByDemandId() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, service.findByLookUpId());
	}

	/**
	 * This method is used to find look up info by object type.
	 *
	 * @param clueDto the clue dto
	 * @return List of ClueDto
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_LOOKUP_INFO_BY_NAME)
	public ResponseEntity<ApiResponse> getByLookUpInfoName(@RequestBody ClueDto clueDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				converter.toDTO(service.findByLookUpName(clueDto.getName())));
	}
	
	/**
     * Gets the by parent lookup name.
     *
     * @param lookupTypeSet the lookup type set
     * @return the by parent lookup name
     */
    @Trace
    @PostMapping(URLConstant.GET_BY_PARENT_NAME)
    public ResponseEntity<ApiResponse> getByParentLookupName(@RequestBody EdpLookupTypeDto edpLookupTypeDto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
                service.getLookUpInfoByParentLookUp(edpLookupTypeDto.getLookupTypes()));
    }
    
    @Trace
    @PostMapping(URLConstant.GET_BY_PARENT_ID)
    public ResponseEntity<ApiResponse> getByParentLookupId(@RequestBody SearchDto dto) {
    	return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
    			service.getLookUpInfoByParentLookUpId(dto));
    }
}

package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsModuleInfoConverter;
import gov.ifms.edp.dto.EDPMsModuleInfoDto;
import gov.ifms.edp.entity.EDPMsModuleInfoEntity;
import gov.ifms.edp.service.EDPMsModuleInfoService;

/**
 * The Class EDPMsModuleInfoController.
 * 
 * @version 1.0.
 * @created 2019/08/29 17:19:17.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_MODULE_INFO)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsModuleInfoController {
		
	/** The service. */
	@Autowired
	private EDPMsModuleInfoService service;
	
	/** The  converter. */
	@Trace
	@Autowired
	private EDPMsModuleInfoConverter converter;
	
	
	
	
	
	/**
	 * Fetch MsModuleInfos by given MsModuleInfos id 
	 * 
	 * @param   id
	 * @return  dto
	 */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsModuleInfo(@RequestBody IdDto id){
		EDPMsModuleInfoEntity entity = service.getMsModuleInfo(id.getId());
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_FETCH,
				this.converter.toDTO(entity));
		
	}
	
	/**
	 * creates a new MsModuleInfos
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsModuleInfo( @RequestBody EDPMsModuleInfoDto dto){
		
		EDPMsModuleInfoEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsModuleInfo(entity)));
		
	}
	
	/**
	 * Update the MsModuleInfos
	 * 
	 * @param  dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsModuleInfo( @RequestBody EDPMsModuleInfoDto dto){
		
		EDPMsModuleInfoEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsModuleInfo(entity)));
	}
	
	
	
	/**
	 * Fetch all the MsModuleInfos items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsModuleInfoDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getMsModuleInfos(@RequestBody PageDetails pageDetail){
		PagebleDTO<EDPMsModuleInfoDto> data = service.edpMsModuleInfoAsMethodNameSearch(pageDetail);
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,data);
	}
	
	/**
	 * Gets the ms module infos.
	 *
	 * @param id the id
	 * @return the ms module infos
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_MODULE_ID)
    public ResponseEntity<ApiResponse> getMsModuleInfos(@RequestBody IdDto id)
	{
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				converter.toDTO(service.getMsModuleInfoByModuleId(id.getId())));
	}
}

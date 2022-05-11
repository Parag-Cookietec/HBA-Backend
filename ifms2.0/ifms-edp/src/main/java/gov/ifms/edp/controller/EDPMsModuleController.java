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
import gov.ifms.edp.converter.EDPMsModuleConverter;
import gov.ifms.edp.dto.EDPMsModuleDto;
import gov.ifms.edp.entity.EDPMsModuleEntity;
import gov.ifms.edp.service.EDPMsModuleService;

/**
 * The Class EDPMsModuleController.
 * 
 * @version 1.0.
 * @created 2019/08/29 17:17:15.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_MODULE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsModuleController {
	
	
	/** The service. */
	@Autowired
	private EDPMsModuleService service;
	
	/** The  converter. */
	@Trace
	@Autowired
	private EDPMsModuleConverter converter;
	
	/**
	 * Fetch MsModules by given MsModules id 
	 * 
	 * @param   id
	 * @return  dto
	 */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsModule(@RequestBody IdDto id){
		EDPMsModuleEntity entity = service.getMsModule(id.getId());
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_FETCH,
				this.converter.toDTO(entity));
		
	}
	
	/**
	 * creates a new MsModules
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsModule( @RequestBody EDPMsModuleDto dto){
		
		EDPMsModuleEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsModule(entity)));
		
	}
	
	/**
	 * Update the MsModules
	 * 
	 * @param  dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsModule( @RequestBody EDPMsModuleDto dto){
		
		EDPMsModuleEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsModule(entity)));
	}
	
	
	/**
	 * Fetch all the MsModules items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsModuleDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getMsModules(@RequestBody PageDetails pageDetail){
		PagebleDTO<EDPMsModuleDto> data = service.edpMsModuleAsMethodNameSearch(pageDetail);
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,data);
	}
	
	/**
	 * Gets the ms modules.
	 *
	 * @return the ms modules
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_MODULE)
    public ResponseEntity<ApiResponse> getMsModules()
	{
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,converter.toDTO(service.getMsModules()));
	}
	
}

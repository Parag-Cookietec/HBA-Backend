package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import  gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsAccountHeadConverter;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPMsAccountHeadDto;
import gov.ifms.edp.entity.EDPMsAccountHeadEntity;
import gov.ifms.edp.service.EDPMsAccountHeadService;

/**
 * The Class EDPMsAccountHeadController.
 * 
 * @version 1.0.
 * @created 2019/08/31 12:54:53.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_ACCOUNT_HEAD)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsAccountHeadController {
	
	/** The service. */
	@Autowired
	private EDPMsAccountHeadService service;
	
	/** The  converter. */
	@Trace
	@Autowired
	private EDPMsAccountHeadConverter converter;
	
	/**
	 * Fetch MsAccountHeads by given MsAccountHeads id 
	 * 
	 * @param   id
	 * @return  dto
	 */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsAccountHead(@RequestBody EDPIdDto id){
		EDPMsAccountHeadEntity entity = service.getMsAccountHead(id.getId());
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_FETCH,
				this.converter.toDTO(entity));
		
	}
	
	/**
	 * creates a new MsAccountHeads
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsAccountHead( @RequestBody EDPMsAccountHeadDto dto){
		
		EDPMsAccountHeadEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsAccountHead(entity)));
		
	}
	
	/**
	 * Update the MsAccountHeads
	 * 
	 * @param  dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsAccountHead( @RequestBody EDPMsAccountHeadDto dto){
		
		EDPMsAccountHeadEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK,MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsAccountHead(entity)));
	}
	
	
	/**
	 * Fetch all the MsAccountHeads items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsAccountHeadDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getMsAccountHeads(@RequestBody PageDetails pageDetail){
		PagebleDTO<EDPMsAccountHeadDto> data = service.edpMsAccountHeadAsMethodNameSearch(pageDetail);
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,data);
	}
	
}
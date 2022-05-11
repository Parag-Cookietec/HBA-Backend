package gov.ifms.workflow.controller;

import javax.validation.Valid;

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
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.workflow.converter.TrnBudWfConverter;
import gov.ifms.workflow.dto.TrnBudWfDto;
import gov.ifms.workflow.service.TrnBudWfService;

/**
 * The Class TrnBudWfController.
 * 
 * @version 1.0.
 * @created 2019/09/20 17:45:45.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_WORKFLOW_TRN_BUD_WF)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TrnBudWfController {
	
	/** The service. */
	@Autowired
	private TrnBudWfService service;
	
	/** The  converter. */
	@Trace
	@Autowired
	private TrnBudWfConverter converter;
	
	
	
	/**
	 * Fetch all the TrnBudWfs
	 * 
	 * @param   
	 * @return List<TrnBudWfEntity>
	 */
	@Trace
	@PostMapping(URLConstant.GET_ALL)
    public ResponseEntity<ApiResponse> getTrnBudWfs(){
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,converter.toDTO(service.getTrnBudWfs()));
	}
	
	/**
	 * Fetch TrnBudWf by given TrnBudWf id 
	 * 
	 * @param   id
	 * @return  dto
	 */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getTrnBudWf(@RequestBody IdDto id){
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.WORKFLOW_MSG_FETCH,converter.toDTO(service.getTrnBudWf(id.getId())));
	}
	
	/**
	 * creates a new TrnBudWf
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createTrnBudWf(@Valid @RequestBody TrnBudWfDto dto){
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.BUDGET_MSG_CREATE, converter.toView(service.saveOrUpdateTrnBudWfSp(converter.toEntity(dto)).get(0)));
	}
	
	/**
	 * Update the TrnBudWf
	 * 
	 * @param  dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateTrnBudWf(@Valid @RequestBody TrnBudWfDto dto){
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.BUDGET_MSG_CREATE,converter.toDTO(service.saveOrUpdateTrnBudWf(converter.toEntity(dto))));
	}
	
	/**
	 * Fetch all the TrnBudWf items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<TrnBudWfEntity>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> trnBudWfAsMethodNameSearch(@RequestBody PageDetails pageDetail)
	{
		PagebleDTO<TrnBudWfDto> data = service.trnBudWfAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST, data);
	}
}

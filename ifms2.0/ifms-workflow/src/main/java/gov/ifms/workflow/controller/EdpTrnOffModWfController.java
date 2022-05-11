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
import gov.ifms.workflow.converter.EdpTrnOffModWfConverter;
import gov.ifms.workflow.dto.EdpTrnOffModWfDto;
import gov.ifms.workflow.service.EdpTrnOffModWfService;


/**
 * The Class EdpTrnOffModWfController.
 */
@RestController
@RequestMapping(URLConstant.URL_WORKFLOW_TRN_EDP_WF)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EdpTrnOffModWfController {
	
	/** The service. */
	@Autowired
	private EdpTrnOffModWfService service;
	
	/** The  converter. */
	@Trace
	@Autowired
	private EdpTrnOffModWfConverter converter;
	
	/**
	 * Gets the trn edp wfs.
	 *
	 * @return the trn edp wfs
	 */
	@Trace
	@PostMapping(URLConstant.GET_ALL)
    public ResponseEntity<ApiResponse> getTrnEdpWfs(){
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,converter.toDTO(service.getTrnEdpWfs()));
	}
	
    /**
     * Gets the trn edp wf.
     *
     * @param id the id
     * @return the trn edp wf
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getTrnEdpWf(@RequestBody IdDto id){
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.WORKFLOW_MSG_FETCH,converter.toDTO(service.getTrnEdpWf(id.getId())));
	}
	
	/**
	 * Creates the trn edp wf.
	 *
	 * @param dto the dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createTrnEdpWf(@Valid @RequestBody EdpTrnOffModWfDto dto){
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.BUDGET_MSG_CREATE, converter.toView(service.saveOrUpdateTrnEdpWfSp(dto)));
	}
	
	/**
	 * Update trn edp wf.
	 *
	 * @param dto the dto
	 * @return the response entity
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateTrnEdpWf(@Valid @RequestBody EdpTrnOffModWfDto dto){
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.BUDGET_MSG_CREATE,converter.toDTO(service.saveOrUpdateTrnEdpWf(converter.toEntity(dto))));
	}
	
	/**
	 * Trn edp wf as method name search.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> trnEdpWfAsMethodNameSearch(@RequestBody PageDetails pageDetail)
	{
		PagebleDTO<EdpTrnOffModWfDto> data = service.trnEdpWfAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST, data);
	}
}

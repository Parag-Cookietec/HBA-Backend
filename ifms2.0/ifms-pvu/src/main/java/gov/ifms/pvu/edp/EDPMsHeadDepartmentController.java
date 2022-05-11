package gov.ifms.pvu.edp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;

import javax.validation.Valid;
import java.util.List;


/**
 * The Class EDPMsHeadDepartmentController.
 * 
 * @version v 1.0.
 * @created 2020/01/15 15:35:39.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MSHEADDEPARTMENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsHeadDepartmentController {
	
	/** The logger. */
	private final Logger  LOGGER=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The service. */
	@Autowired
	private EDPMsHeadDepartmentService service;
	
	/** The  converter. */
	@Autowired
	private EDPMsHeadDepartmentConverter converter;
	
	/**
	 * Fetch MsHeadDepartments by given MsHeadDepartments id 
	 * 
	 * @param   id
	 * @return  dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsHeadDepartment(@RequestBody IdDto id) {
        EDPMsHeadDepartmentEntity entity = service.getMsHeadDepartment(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, this.converter.toDTO(entity));
    }
	
	
	/**
	 * creates a new MsHeadDepartments
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsHeadDepartment( @RequestBody EDPMsHeadDepartmentDto dto) {
        EDPMsHeadDepartmentEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsHeadDepartment(entity)));
    }
	
	/**
	 * Update the MsHeadDepartments
	 * 
	 * @param  dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsHeadDepartment(@RequestBody EDPMsHeadDepartmentDto dto) {
        EDPMsHeadDepartmentEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsHeadDepartment(entity)));
	}

	/**+
	 *
	 * @param id
	 * @return
	 * @throws CustomException
	 */


	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsHeadDepartments(@RequestBody IdDto id )throws CustomException {
		List<EDPMsHeadDepartmentDto> entity = service.getMsHeadDepartments(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, entity);

	}
	
}

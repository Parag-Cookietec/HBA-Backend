package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsSubModuleConverter;
import gov.ifms.edp.service.EDPMsSubModuleService;


/**
 * The Class EDPMsSubModuleController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_SUB_MODULE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsSubModuleController {

	/** The sub module service. */
	@Autowired
	private EDPMsSubModuleService subModuleService;

	/** The sub module converter. */
	@Autowired
	private EDPMsSubModuleConverter subModuleConverter;

	/**
	 * Fetch MsModules by given MsModules id .
	 *
	 * @param id the id
	 * @return  dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_SUB_MODULE_ID)
	public ResponseEntity<ApiResponse> getSubModulesByModuleId(@RequestBody IdDto id) throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				subModuleConverter.toDTO(subModuleService.getMsSubModule(id.getId())));

	}

}

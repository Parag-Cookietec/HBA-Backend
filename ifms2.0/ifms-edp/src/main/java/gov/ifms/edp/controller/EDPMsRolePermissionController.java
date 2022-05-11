package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.service.EDPMsRolePermissionsService;

/**
 * The Class EDPMsRolePermissionController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MST_ROLE_PERMISSION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsRolePermissionController {

	/** The edp ms role permissions service. */
	@Autowired
	private EDPMsRolePermissionsService edpMsRolePermissionsService;

	/**
	 * Gets the ms role permission.
	 *
	 * @return the ms role permission
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsRolePermission() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				edpMsRolePermissionsService.getAll());
	}
}

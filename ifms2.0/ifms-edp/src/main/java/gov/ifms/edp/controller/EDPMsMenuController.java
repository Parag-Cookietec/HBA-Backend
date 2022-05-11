package gov.ifms.edp.controller;

import java.util.List;

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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsMenuConverter;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.service.EDPMsMenuService;

/**
 * The Class EDPMsMenuController.
 * 
 * @version 1.0.
 * @created 2019/08/29 17:40:15.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_MENU)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsMenuController {

	/** The service. */
	@Autowired
	private EDPMsMenuService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsMenuConverter converter;

	/**
	 * Fetch MsMenus by given MsMenus id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsMenu(@RequestBody IdDto id) {
		EDPMsMenuEntity entity = service.getMsMenu(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));

	}

	/**
	 * Added by Shaunak
	 * 
	 * Fetch MsMenus by given Module id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_MENUS_BY_MODULE_ID)
	public ResponseEntity<ApiResponse> getMsMenuByModuleId(@RequestBody IdDto id) {
		List<EDPMsMenuEntity> list = service.getMsMenuByModuleId(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(list));
	}

	/**
	 * creates a new MsMenus.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsMenu(@RequestBody EDPMsMenuDto dto) {

		EDPMsMenuEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsMenu(entity)));

	}

	/**
	 * Update the MsMenus.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsMenu(@RequestBody EDPMsMenuDto dto) {

		EDPMsMenuEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsMenu(entity)));
	}

	/**
	 * Fetch all the MsMenus items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return the ms menus
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public PagebleDTO<EDPMsMenuDto> getMsMenus(@RequestBody PageDetails pageDetail) {
		return service.edpMsMenuAsMethodNameSearch(pageDetail);
	}

	/**
	 * Fetch permissions based on menu Id.
	 *
	 * @param postId the post id
	 * @return the permissions by menu id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PERMISSIONS_BY_POST_ID)
	public ResponseEntity<ApiResponse> getPermissionsByMenuId(@RequestBody IdDto postId) throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getPermissionByMenuAndPostId(postId.getId()));

	}

	
	/**
	 * Gets the ms menu by sub module id.
	 *
	 * @param id the id
	 * @return the ms menu by sub module id
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_MENUS_BY_SUBMODULE_ID)
	public ResponseEntity<ApiResponse> getMsMenuBySubModuleId(@RequestBody IdDto id) {
		List<EDPMsMenuEntity> list = service.getMsMenuBySubModuleId(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(list));
	}
}

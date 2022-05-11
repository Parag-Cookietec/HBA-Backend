package gov.ifms.pvu.controller;

import java.util.List;

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
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUDepartmentCategoryConverter;
import gov.ifms.pvu.dto.PVUDepartmentCategoryDto;
import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;
import gov.ifms.pvu.service.PVUDepartmentCategoryService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUDepartmentCategoryController.
 *
 * @version v 1.0.
 * @created 2019/12/31 16:57:07.
 */
@RestController
@RequestMapping(PvuConstant.URL_PVU_DEPARTMENTCATEGORY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUDepartmentCategoryController {

	/**
	 * The service.
	 */
	@Autowired
	private PVUDepartmentCategoryService service;

	/**
	 * The converter.
	 */
	@Autowired
	private PVUDepartmentCategoryConverter converter;

	/**
	 * Fetch DepartmentCategorys by given DepartmentCategorys id
	 *
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getDepartmentCategory(@RequestBody IdDto id) {
		PVUDepartmentCategoryEntity entity = service.getDepartmentCategory(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new DepartmentCategorys
	 *
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createDepartmentCategory(@RequestBody PVUDepartmentCategoryDto dto) {
		PVUDepartmentCategoryEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateDepartmentCategory(entity)));
	}

	/**
	 * Update the DepartmentCategorys
	 *
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateDepartmentCategory(@RequestBody PVUDepartmentCategoryDto dto) {
		PVUDepartmentCategoryEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateDepartmentCategory(entity)));
	}

	/**
	 * Fetch all the DepartmentCategorys items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUDepartmentCategoryDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAllDepartmentCategory() {
		List<PVUDepartmentCategoryEntity> entity = service.getAllDepartmentCategory();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, entity);
	}

}

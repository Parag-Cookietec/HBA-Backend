package gov.ifms.pvu.controller;

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
import gov.ifms.pvu.converter.PVUMsCourseConverter;
import gov.ifms.pvu.dto.PVUMsCourseDto;
import gov.ifms.pvu.entity.PVUMsCourseEntity;
import gov.ifms.pvu.service.PVUMsCourseService;

/**
 * The Class PVUMsCourseController.
 * 
 * @version v 1.0.
 * @created 2020/01/01 02:52:33.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_MSCOURSE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUMsCourseController {

	/** The service. */
	@Autowired
	private PVUMsCourseService service;

	/** The converter. */
	@Autowired
	private PVUMsCourseConverter converter;

	/**
	 * Fetch MsCourses by given MsCourses id .
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsCourse(@RequestBody IdDto id) {
		PVUMsCourseEntity entity = service.getMsCourse(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new MsCourses.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsCourse(@RequestBody PVUMsCourseDto dto) {
		PVUMsCourseEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsCourse(entity)));
	}

	/**
	 * Update the MsCourses.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsCourse(@RequestBody PVUMsCourseDto dto) {
		PVUMsCourseEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsCourse(entity)));
	}

	/**
	 * Gets the ms courses.
	 *
	 * @param pageDetail the page detail
	 * @return the ms courses
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsCourses(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUMsCourseDto> data = service.getMsCourses(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, data);
	}

}

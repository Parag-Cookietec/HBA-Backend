package gov.ifms.gst.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.DifferenceDto;
import gov.ifms.gst.dto.GSTFileSummeryDto;
import gov.ifms.gst.dto.GSTNDto;
import gov.ifms.gst.service.impl.GSTFileSummeryServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_FILE_SUMMERY_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GSTFileSummeryController {

	@Autowired
	private GSTFileSummeryServiceImpl service;

	/**
	 * Fetch GST File Accounting by given id
	 * 
	 * @param id
	 * @return dto
	 * 
	 */
	
	@Trace
	@PostMapping(URLConstant.URL_SEARCH_BY_NAME)
	public ResponseEntity<ApiResponse> serachByName(
			@RequestParam(name = "pageNumber", defaultValue = "0") String pageNumber,
			@RequestBody GSTFileSummeryDto dtos) {
		List<GSTFileSummeryDto> dto = service.serachByName(Integer.valueOf(pageNumber), dtos);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_SEARCH_BY_LISTOF_NAME)
	public ResponseEntity<ApiResponse> serachBy(@RequestBody GSTFileSummeryDto dto) {
		List<GSTFileSummeryDto> dtos = service.serachBy(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dtos);
	}

	@Trace
	@PostMapping(URLConstant.URL_SEARCH_BY_DATE)
	public ResponseEntity<ApiResponse> serachByDate(@RequestBody GSTNDto dtos) {
		List<GSTNDto> dto = null;
		try {
			dto = service.searchByDateThroughGstn(dtos);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_SEARCH_DIFFRENCE)
	public ResponseEntity<ApiResponse> search(@RequestBody GSTNDto dtos) throws ParseException {
		DifferenceDto dto = service.diffrence(dtos);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

}

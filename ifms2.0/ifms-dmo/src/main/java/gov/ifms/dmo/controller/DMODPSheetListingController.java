package gov.ifms.dmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMODPSheetSearchHDRPostDto;
import gov.ifms.dmo.service.DMODPSheetListingService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.DMO_DPSHEET_LIST_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMODPSheetListingController {

	@Autowired
	private DMODPSheetListingService dpSheetListService;

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_SEARCH)
	public ResponseEntity<ApiResponse> searchDPSheet(@RequestBody DMODPSheetSearchHDRPostDto pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST,
				dpSheetListService.searchDPSheet(pageDetail));
	}

}

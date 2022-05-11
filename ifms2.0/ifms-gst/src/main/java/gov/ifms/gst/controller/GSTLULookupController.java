package gov.ifms.gst.controller;

import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.GSTLULookupDto;
import gov.ifms.gst.service.GSTLULookupService;
import gov.ifms.gst.util.GstURLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 
@RestController
@RequestMapping(GstURLConstant.URL_LOOKUP_TYPE_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GSTLULookupController {
	
	@Autowired
	GSTLULookupService lookupService;
	
	@Trace
	@PostMapping(GstURLConstant.URL_PENAL_INTEREST_LU_LOOKUP_RETRIEVE)
	public ResponseEntity<ApiResponse> getLookUpList(@RequestBody GSTLULookupDto lookUpDto) throws CustomException {
		List<GSTLULookupDto> list = lookupService.fetchLookUpData(lookUpDto);
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, "No records found!", list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, "Records retrived!", list);
	}


}

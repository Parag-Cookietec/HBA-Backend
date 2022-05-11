package gov.ifms.edp.controller;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filenet.api.core.Document;
import com.filenet.api.util.Id;

import gov.ifms.common.attachment.dto.AttachmentDownloadDto;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.FilenetUtility;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.EDPBulkEmployeeCreationDto;
import gov.ifms.edp.service.EDPUserCreationServiceImpl;

@RestController
@RequestMapping(URLConstant.URL_EDP_USER_CREATION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPUserCreationController {

	/**
	 * Submit excel.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException
	 */

	@Autowired
	private EDPUserCreationServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> saveBulkEmpCreationTransaction(
			@RequestBody EDPBulkEmployeeCreationDto edpBulkEmployeeCreationDto) throws CustomException, IOException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_SUBMIT,
				service.saveBulkEmployeeCreationTransaction(edpBulkEmployeeCreationDto));
	}





	@Trace
	@PostMapping(URLConstant.URL_BEC_SUBMIT)
	public ResponseEntity<Resource> downloadAttachmentFilenet(@RequestBody IdDto id, final HttpServletRequest request)
			throws CustomException, IOException {
		try {

			final InputStreamResource inputStreamResource = new InputStreamResource(
					service.submitBulkEmployeeData(id.getId()));
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(Constant.FILE_CONTENT_TYPE))
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename=IFMS_BEC_" + Instant.now().getEpochSecond() + ".xlsx")
					.body(inputStreamResource);

		} catch (Exception ex) {
			// logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

}

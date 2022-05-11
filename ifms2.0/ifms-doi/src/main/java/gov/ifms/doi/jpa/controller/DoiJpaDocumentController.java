/**
 * 
 */
package gov.ifms.doi.jpa.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_COMMON_DOCUMENT_DELETE;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_COMMON_DOCUMENT_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_COMMON_DOCUMENT_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DOCUMENT_BASE_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DOCUMENT_LIST_BY_LOSS_CAUSE_AND_SCHEMEID;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_LOSSCAUSE_DOCUMENT_DELETE;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_LOSSCAUSE_DOCUMENT_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_LOSSCAUSE_DOCUMENT_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_SCHEME_DOCUMENT_DELETE;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_SCHEME_DOCUMENT_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_SCHEME_DOCUMENT_LISTING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.dto.DoiJpaCommonDocumentDTO;
import gov.ifms.doi.jpa.dto.DoiJpaLossCauseDocumentDTO;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeDocumentDTO;
import gov.ifms.doi.jpa.service.DoiJpaDocumentService;

/**
 * @author Rudra
 *
 */
@RestController
@RequestMapping(DOI_JPA_DOCUMENT_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoiJpaDocumentController {
	@Autowired
	DoiJpaDocumentService service;

	@Trace
	@PostMapping(DOI_JPA_COMMON_DOCUMENT_LISTING)
	public ResponseEntity<ApiResponse> jpaCommonDocument() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.jpaCommonDocument());
	}

	@Trace
	@PostMapping(DOI_JPA_SCHEME_DOCUMENT_LISTING)
	public ResponseEntity<ApiResponse> jpaSchemeDocument() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.jpaSchemeDocument());
	}

	@Trace
	@PostMapping(DOI_JPA_LOSSCAUSE_DOCUMENT_LISTING)
	public ResponseEntity<ApiResponse> jpaLossCauseDocument() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.jpaLossCauseDocument());
	}

	@Trace
	@PostMapping(DOI_JPA_COMMON_DOCUMENT_ENTRY)
	public ResponseEntity<ApiResponse> jpaCommonDocumentSaveOrUpdate(@RequestBody DoiJpaCommonDocumentDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				service.jpaCommonDocumentSaveOrUpdate(dto));
	}

	@Trace
	@PostMapping(DOI_JPA_SCHEME_DOCUMENT_ENTRY)
	public ResponseEntity<ApiResponse> jpaSchemeDocumentSaveOrUpdate(@RequestBody DoiJpaSchemeDocumentDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				service.jpaSchemeDocumentSaveOrUpdate(dto));
	}

	@Trace
	@PostMapping(DOI_JPA_LOSSCAUSE_DOCUMENT_ENTRY)
	public ResponseEntity<ApiResponse> jpaLossCauseDocumentSaveOrUpdate(@RequestBody DoiJpaLossCauseDocumentDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				service.jpaLossCauseDocumentSaveOrUpdate(dto));
	}

	@Trace
	@DeleteMapping(value = DOI_JPA_COMMON_DOCUMENT_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> jpaCommonDocumentDelete(@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE,
				service.jpaCommonDocumentDelete(pathVariable));
	}

	@Trace
	@DeleteMapping(value = DOI_JPA_SCHEME_DOCUMENT_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> jpaSchemeDocumentDelete(@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE,
				service.jpaSchemeDocumentDelete(pathVariable));
	}

	@Trace
	@DeleteMapping(value = DOI_JPA_LOSSCAUSE_DOCUMENT_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> jpaLossCauseDocumentDelete(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE,
				service.jpaLossCauseDocumentDelete(pathVariable));
	}
	
	
	@Trace
	@GetMapping(value = DOI_JPA_DOCUMENT_LIST_BY_LOSS_CAUSE_AND_SCHEMEID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDocumentListForClaim(
			@RequestParam(name = "lossCauseId") Long lossCauseId,@RequestParam(name = "schemeId") Long schemeId ) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE,
				service.jpaLossCauseDocumentList(lossCauseId,schemeId));
	}
	
}

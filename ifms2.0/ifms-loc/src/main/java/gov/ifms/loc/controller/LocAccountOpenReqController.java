package gov.ifms.loc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.loc.converter.LocAccountOpenReqHdrConverter;
import gov.ifms.loc.converter.LocAccountOpenReqSdConverter;
import gov.ifms.loc.dto.LocAccOpenReqDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqAgDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqAgSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqBankSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqDivisionSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqHdrDto;
import gov.ifms.loc.dto.LocAccountOpenReqSdDto;
import gov.ifms.loc.dto.LocCircleDto;
import gov.ifms.loc.dto.LocMasterIdDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.dto.LocTreasuryDto;
import gov.ifms.loc.dto.LocTreasuryParamDto;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.entity.LocAccountOpenReqSdEntity;
import gov.ifms.loc.service.LocAccountOpenReqService;
import gov.ifms.loc.util.LocBaseConstant;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocURLConstant;

/**
 * The Class LocAccountOpenReqController.
 *
 * @version 1.0.
 * @created 2020/12/22 12:52:20.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_ACCOUNTOPENREQ)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocAccountOpenReqController extends LocBaseConstant {

	/**
	 * The service.
	 */
	@Autowired
	private LocAccountOpenReqService service;

	/**
	 * The converter.
	 */
	@Autowired
	private LocAccountOpenReqHdrConverter hdrConverter;

	/**
	 * The converter.
	 */
	@Autowired
	private LocAccountOpenReqSdConverter sdConverter;

	/**
	 * Fetch AccountOpenReqHdrs by given AccountOpenReqHdrs id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ACT_OPN_REQ_HDR_BY_ID)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAccountOpenReqHdr(@RequestBody IdDto id) {
		LocAccountOpenReqHdrEntity entity = service.getAccountOpenReqHdr(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				this.hdrConverter.toDTO(entity));
	}

	/**
	 * Creates the account open req hdr.
	 *
	 * @param locActOpnReqHdrDto the loc act opn req hdr dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_POST_ACT_OPN_REQ_HDR)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> createAccountOpenReqHdr(
			@Valid @RequestBody LocAccountOpenReqHdrDto locActOpnReqHdrDto) throws CustomException {
		LocAccountOpenReqHdrDto data = service.createLocAccReqHdr(locActOpnReqHdrDto);
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE, data);
	}

	/**
	 * Update the AccountOpenReqHdrs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_PUT_ACT_OPN_REQ_HDR_BY_ID)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> updateAccountOpenReqHdr(@RequestBody LocAccountOpenReqHdrDto dto) {
		LocAccountOpenReqHdrEntity entity = hdrConverter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_UPDATE,
				hdrConverter.toDTO(service.saveOrUpdateAccountOpenReqHdr(entity)));
	}

	/**
	 * Fetch all the AccountOpenReqHdrs items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<LocAccountOpenReqHdrDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ALL_ACT_OPN_REQ_HDR)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAccountOpenReqHdrs(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<LocAccountOpenReqHdrDto> data = service.getAccountOpenReqHdrs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, data);
	}

	/**
	 * Fetch AccountOpenReqSds by given AccountOpenReqSds id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ACT_OPN_REQ_SD_BY_ID)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAccountOpenReqSd(@RequestBody IdDto id) {
		LocAccountOpenReqSdEntity entity = service.getAccountOpenReqSd(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				this.sdConverter.toDTO(entity));
	}

	/**
	 * creates a new AccountOpenReqSds.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_POST_ACT_OPN_REQ_SD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> createAccountOpenReqSd(@Valid @RequestBody LocAccountOpenReqSdDto dto) {
		LocAccountOpenReqSdEntity entity = sdConverter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
				sdConverter.toDTO(service.saveOrUpdateAccountOpenReqSd(entity)));
	}

	/**
	 * Update the AccountOpenReqSds.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_PUT_ACT_OPN_REQ_SD_BY_ID)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> updateAccountOpenReqSd(@RequestBody LocAccountOpenReqSdDto dto) {
		LocAccountOpenReqSdEntity entity = sdConverter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_UPDATE,
				sdConverter.toDTO(service.saveOrUpdateAccountOpenReqSd(entity)));
	}

	/**
	 * Fetch all the AccountOpenReqSds items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<LocAccountOpenReqSdDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ALL_ACT_OPN_REQ_SD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAccountOpenReqSds(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<LocAccountOpenReqSdDto> data = service.getAccountOpenReqSds(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, data);
	}

	/**
	 * Fetch all the Circle items.
	 *
	 * @return List<LocCircleDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ALL_CIRCLE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAllCircle() throws CustomException {
		List<LocCircleDto> data = service.getAllCircle();
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, data);
	}

	/**
	 * Get Treasury By DistrictId And DepartmentId.
	 *
	 * @param locTreasuryParamDto the loc treasury param dto
	 * @return List<LocCircleDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_TREASURY_DETAILS)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getTreasuryByDistrictIdAndDepartmentId(
			@Valid @RequestBody LocTreasuryParamDto locTreasuryParamDto) throws CustomException {
		LocTreasuryDto data = service.getTreasuryByDistrictIdAndDepartmentId(locTreasuryParamDto);
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, data);
	}

	/**
	 * Gets the account open req dtl.
	 *
	 * @param locAccountOpenReqDtlDto the loc account open req dtl dto
	 * @return the account open req dtl
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ACT_OPN_REQ_DTL_BY_ID)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAccountOpenReqDtl(
			@RequestBody LocAccountOpenReqDtlDto locAccountOpenReqDtlDto) {
		LocAccOpenReqDtlDto entity = service.getAccountOpenReqDtl(locAccountOpenReqDtlDto.getLcOpenReqHdrId(),
				locAccountOpenReqDtlDto.getIsEditable());
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, entity);
	}

	/**
	 * Gets the major head.
	 *
	 * @return the major head
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_MAJORHEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getMajorHead() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getMajorHead());
	}

	/**
	 * Gets the sub major head.
	 *
	 * @param dto the dto
	 * @return the sub major head
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SUBMAJORHEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getSubMajorHead(@RequestBody LocMasterIdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getSubMajorHead(dto));
	}

	/**
	 * Gets the minor head.
	 *
	 * @param dto the dto
	 * @return the minor head
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_MINORHEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getMinorHead(@RequestBody LocMasterIdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getMinorHead(dto));
	}

	/**
	 * Gets the sub head.
	 *
	 * @param dto the dto
	 * @return the sub head
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SUBHEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getSubHead(@RequestBody LocMasterIdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.getSubHead(dto));
	}

	/**
	 * Gets the sub head.
	 *
	 * @param dto the dto
	 * @return the sub head
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_DETAILHEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getDetailHead(@RequestBody LocMasterIdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getDetailHead(dto));
	}

	/**
	 * Save Ag Office Details.
	 *
	 * @param dto the dto
	 * @return the sub head
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_POST_AG_DETAIL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> createAgOfficeDetail(@RequestBody LocAccountOpenReqAgSdDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.createAgOfficeDetail(dto));
	}

	/**
	 * Gets the ag office detail.
	 *
	 * @param locAccOpenReqAgDtlDto the loc acc open req ag dtl dto
	 * @return the ag office detail
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_AG_DETAIL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAgOfficeDetail(@RequestBody LocAccountOpenReqAgDtlDto locAccOpenReqAgDtlDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service
				.getAgOfficeDetail(locAccOpenReqAgDtlDto.getLcOpenReqHdrId(), locAccOpenReqAgDtlDto.getIsEditable()));
	}

	/**
	 * Gets the ag office wf detail.
	 *
	 * @param id the id
	 * @return the ag office wf detail
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_AG_WF_DETAIL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAgOfficeWfDetail(@RequestBody IdDto id) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getLocOpenReqSubmitDetails(id.getId()));
	}

	/**
	 * Gets the loc open req view details.
	 *
	 * @param pageDetails the page details
	 * @return the loc open req view details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_OPEN_REQ_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getLocOpenReqViewDetails(@Valid @RequestBody PageDetails pageDetails)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getLocOpenReqViewDetails(pageDetails));
	}

	/**
	 * Gets the loc open req ag view details.
	 *
	 * @param pageDetails the page details
	 * @return the loc open req ag view details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_OPEN_REQ_AG_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getLocOpenReqAgViewDetails(@Valid @RequestBody PageDetails pageDetails)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getLocOpenReqAgViewDetails(pageDetails));
	}

	/**
	 * Gets the loc open req bank view details.
	 *
	 * @param pageDetails the page details
	 * @return the loc open req bank view details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_OPEN_REQ_BANK_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getLocOpenReqBankViewDetails(@Valid @RequestBody PageDetails pageDetails)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getLocOpenReqBankViewDetails(pageDetails));
	}

	/**
	 * Gets the loc open req divi view details.
	 *
	 * @param pageDetails the page details
	 * @return the loc open req divi view details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_OPEN_REQ_DIVI_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getLocOpenReqDiviViewDetails(@Valid @RequestBody PageDetails pageDetails)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getLocOpenReqDiviViewDetails(pageDetails));
	}

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_SUBMIT_OPEN_REQ)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> submitData(@RequestBody LocSubmitWfDto submitWfDto) throws CustomException {
		try {
			service.submitData(submitWfDto);
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Gets the open listing data.
	 *
	 * @param pageDetail the page detail
	 * @return the open listing data
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_OPEN_LISITNG)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getOpenListingData(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getOpenListingData(pageDetail));
	}

	/**
	 * Gets the open request param.
	 *
	 * @return the open request param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getOpenRequestParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getRequestParam());
	}

	/**
	 * Validate ag office detail.
	 *
	 * @param locAccOpenReqAgDtlDto the loc acc open req ag dtl dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_VALIDATE_AG_DTL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> validateAgOfficeDetail(
			@RequestBody LocAccountOpenReqAgDtlDto locAccOpenReqAgDtlDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.validateAgOfficeDetail(locAccOpenReqAgDtlDto));
	}

	/**
	 * Gets the all bank details.
	 *
	 * @param dto the dto
	 * @return list of all banks
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ALL_BANK_DETAILS)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAllBankDetails(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAllBankDetails(dto));
	}

	/**
	 * Creates the bank office detail.
	 *
	 * @param dto the dto
	 * @return the newly created entity in dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_POST_BANK_DETAIL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> createBankOfficeDetail(@RequestBody LocAccountOpenReqBankSdDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.createBankOfficeDetail(dto));
	}

	/**
	 * Gets the bank office detail.
	 *
	 * @param dto the dto
	 * @return the bank office detail
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_BANK_DETAIL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getBankOfficeDetail(@RequestBody LocAccountOpenReqBankSdDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getBankOfficeDetail(dto.getLcOpenReqHdrId(), dto.getIsEditable()));
	}

	/**
	 * Creates the division office detail.
	 *
	 * @param dto the dto
	 * @return the newly created entity in dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_POST_DIVISION_DETAIL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> createDivisionOfficeDetail(@RequestBody LocAccountOpenReqDivisionSdDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.createDivisionOfficeDetail(dto));
	}

	/**
	 * Gets the divi office detail.
	 *
	 * @param dto the dto
	 * @return the divi office detail
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_DIVISION_DETAIL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getDiviOfficeDetail(@RequestBody LocAccountOpenReqDivisionSdDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getDivisionOfficeDetail(dto.getLcOpenReqHdrId(), dto.getIsEditable()));
	}

	/**
	 * Divsion validation.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_DIVISION_VALIDATION)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> divsionValidation(@RequestBody LocAccountOpenReqHdrDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getDivisionValidation(dto));
	}

	/**
	 * Fetch all the Circle items mapped to Login department.
	 *
	 * @param dto the dto
	 * @return List<LocCircleDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_CIRCLE_BY_DEPARTMENT_ID)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAllCircleByDepartmentId(@RequestBody IdDto dto) throws CustomException {
		List<LocCircleDto> data = service.getCircleByDepartment(dto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, data);
	}

	/**
	 * Delete by id.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_DELETE_ACT_OPN_REQ_HDR_BY_ID)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto dto) throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, service.deleteById(dto));
	}

	/**
	 * Print the Check book
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_AUTH_LETTER_PRINT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAuthLetter(@RequestBody IdDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.genAuthLetter(dto));
	}
}

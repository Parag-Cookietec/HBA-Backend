package gov.ifms.pvu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUFixToRegularPayConConverter;
import gov.ifms.pvu.converter.PVUMsPayBandConverter;
import gov.ifms.pvu.converter.PVUMsPayScaleConverter;
import gov.ifms.pvu.dto.FixpayToRegularRequestDto;
import gov.ifms.pvu.dto.PVUFixToRegularPayConDto;
import gov.ifms.pvu.entity.PVUFixToRegularPayConEntity;
import gov.ifms.pvu.service.PVUFixPayToRegularService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUFixPayToRegularController.
 *
 * @version v 1.0.
 * @created 2021/04/10
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_FIXPAY_TO_REG)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUFixPayToRegularController {

	@Autowired
	private PVUFixPayToRegularService service;

	@Autowired
	private PVUMsPayScaleConverter payScaleConvertor;

	@Autowired
	private PVUMsPayBandConverter payBandConverter;

	/** The converter. */
	@Autowired
	private PVUFixToRegularPayConConverter converter;

	/**
	 * Fetch all the Fix To Reg Pay List with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EMDMasterDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_GET_FIXTOREG_LIST)
	public ResponseEntity<ApiResponse> getFixToRegPayList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH_LIST,
				this.service.getFixToRegPayList(pageDetail));
	}

	@Trace
	@PostMapping(PvuConstant.URL_GET_PAYSCALE_FOR_FIXTOREG)
	public ResponseEntity<ApiResponse> getFifthPayScale(@RequestBody FixpayToRegularRequestDto reuest) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH_LIST,
				this.payScaleConvertor.toDTO(this.service.getFifthPayScale(reuest)));
	}

	@Trace
	@PostMapping(PvuConstant.URL_GET_PAYBAND_FOR_FIXTOREG)
	public ResponseEntity<ApiResponse> getSixthPayBand(@RequestBody FixpayToRegularRequestDto reuest) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH_LIST,
				this.payBandConverter.toDTO(this.service.getSixthPayBandValue(reuest)));
	}

	@Trace
	@PostMapping(PvuConstant.URL_GET_GRADEPAY_FOR_FIXTOREG)
	public ResponseEntity<ApiResponse> getSixthPayGradpayAndPayBandValue(
			@RequestBody FixpayToRegularRequestDto reuest) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH_LIST,
				this.service.getSixthGradePayValueAndEnterypayValue(reuest));
	}

	/**
	 * creates a new FixToRegularPayCons
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_FIX_TO_REG_SAVE)
	public ResponseEntity<ApiResponse> createFixToRegularPayCon(@RequestBody PVUFixToRegularPayConDto dto)
			throws CustomException {
		PVUFixToRegularPayConEntity entities = converter.toEntity(dto);
		String msg = (Status.DRAFT.toString().equals(dto.getAction())) ? MsgConstant.BUDGET_MSG_CREATE
				: MsgConstant.BUDGET_MSG_SUBMIT;
		return ResponseUtil.getResponse(HttpStatus.OK, msg,
				converter.toDTO(service.saveOrUpdateFixToRegularPayCon(entities, dto.getAction())));
	}

	/**
	 * Fetch FixToRegularPayCons by given FixToRegularPayCons id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_F2R_GET_BY_ID)
	public ResponseEntity<ApiResponse> getFixToRegularPayCon(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				service.getFixToRegularPayCon(id.getId()));
	}

	/**
	 * Deletes the FixToRegularPayCons for the given id
	 * 
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_F2R_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteFixToRegularPayCon(@RequestBody StatusDto statusDto) {
		service.deleteFixToRegularPayCon(statusDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}

	@Trace
	@PostMapping(PvuConstant.URL_GET_PAYLEVEL_FOR_FIXTOREG)
	public ResponseEntity<ApiResponse> getPayLevel(@RequestBody FixpayToRegularRequestDto reuest) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH_LIST,
				this.service.getSevenPayLevel(reuest));
	}

	@Trace
	@PostMapping(PvuConstant.URL_GET_CELLVALUE_FOR_FIXTOREG)
	public ResponseEntity<ApiResponse> getCellValueFromPayLevel(@RequestBody FixpayToRegularRequestDto reuest) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH_LIST,
				this.service.getPayCellValue(reuest));
	}

	@Trace
	@PostMapping(PvuConstant.URL_CHK_EMP_INI_FOR_FTR)
	public ResponseEntity<ApiResponse> checkEmployeeAlreadyinitiated(@RequestBody IdDto idt) throws CustomException {
		this.service.checkEmployeeAlreadyinitiated(idt.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH_LIST);
	}

	@Trace
	@PostMapping(PvuConstant.URL_GET_STATUS)
	public ResponseEntity<ApiResponse> getStatus() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH_LIST, this.service.getStatus());
	}

}

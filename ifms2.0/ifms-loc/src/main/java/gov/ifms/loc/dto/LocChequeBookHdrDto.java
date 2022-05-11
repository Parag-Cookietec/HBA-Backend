package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;

/**
 * The Class LocChequeBookHdrDto.
 *
 * @version v 1.0
 * @created 2021/01/16 14:03:50
 */
public class LocChequeBookHdrDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@NotNull
	private Long id;

	/**
	 * The ref no.
	 */
	@NotNull
	private String refNo;

	/**
	 * The ref date.
	 */
	@NotNull
	private Date refDate;

	/**
	 * The cheque type.
	 */
	@NotNull
	private Long chequeTypeId;

	/**
	 * The div id.
	 */
	@NotNull
	private Long divId;

	/**
	 * The bank branch id.
	 */
	@NotNull
	private Long bankBranchId;

	/**
	 * The bank acc no.
	 */
	@NotNull
	private String bankAccNo;

	/**
	 * The req type.
	 */
	@NotNull
	private Long reqTypeId;

	/**
	 * The status id.
	 */
	@NotNull
	private Long statusId;

	/**
	 * The wf id.
	 */
	@NotNull
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/**
	 * The div code.
	 */
	private String divCode;

	/**
	 * The div name.
	 */
	private String divName;

	/**
	 * The bank name.
	 */
	private String bankName;

	/**
	 * The req type name.
	 */
	private String reqTypeName;

	/**
	 * The cheque type name.
	 */
	private String chequeTypeName;

	/**
	 * The cheque book sd dto.
	 */
	private List<LocChequeBookSdDto> chequeBookSdDto;

	/**
	 * The cheque view edit sd dto.
	 */
	private LocChequeBookSdDto chequeViewEditSdDto;
	/**
	 * The wf user req dto.
	 */
	private List<WfUserReqSDDto> wfUserReqDto;

	/**
	 * LocChequeBookHdrDto Constructor.
	 */
	public LocChequeBookHdrDto() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the ref no.
	 *
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Sets the ref no.
	 *
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Gets the ref date.
	 *
	 * @return the refDate
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the refDate to set
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the cheque type id.
	 *
	 * @return the chequeTypeId
	 */
	public Long getChequeTypeId() {
		return chequeTypeId;
	}

	/**
	 * Sets the cheque type id.
	 *
	 * @param chequeTypeId the chequeTypeId to set
	 */
	public void setChequeTypeId(Long chequeTypeId) {
		this.chequeTypeId = chequeTypeId;
	}

	/**
	 * Gets the div id.
	 *
	 * @return the divId
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the divId to set
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the bank branch id.
	 *
	 * @return the bankBranchId
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * Sets the bank branch id.
	 *
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * Gets the bank acc no.
	 *
	 * @return the bankAccNo
	 */
	public String getBankAccNo() {
		return bankAccNo;
	}

	/**
	 * Sets the bank acc no.
	 *
	 * @param bankAccNo the bankAccNo to set
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * Gets the req type id.
	 *
	 * @return the reqTypeId
	 */
	public Long getReqTypeId() {
		return reqTypeId;
	}

	/**
	 * Sets the req type id.
	 *
	 * @param reqTypeId the reqTypeId to set
	 */
	public void setReqTypeId(Long reqTypeId) {
		this.reqTypeId = reqTypeId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the cheque book sd dto.
	 *
	 * @return the chequeBookSdDto
	 */
	public List<LocChequeBookSdDto> getChequeBookSdDto() {
		return chequeBookSdDto;
	}

	/**
	 * Sets the cheque book sd dto.
	 *
	 * @param chequeBookSdDto the chequeBookSdDto to set
	 */
	public void setChequeBookSdDto(List<LocChequeBookSdDto> chequeBookSdDto) {
		this.chequeBookSdDto = chequeBookSdDto;
	}

	/**
	 * Gets the cheque view edit sd dto.
	 *
	 * @return the chequeViewEditSdDto
	 */
	public LocChequeBookSdDto getChequeViewEditSdDto() {
		return chequeViewEditSdDto;
	}

	/**
	 * Sets the cheque view edit sd dto.
	 *
	 * @param chequeViewEditSdDto the chequeViewEditSdDto to set
	 */
	public void setChequeViewEditSdDto(LocChequeBookSdDto chequeViewEditSdDto) {
		this.chequeViewEditSdDto = chequeViewEditSdDto;
	}

	/**
	 * Gets the wf user req dto.
	 *
	 * @return the wfUserReqDto
	 */
	public List<WfUserReqSDDto> getWfUserReqDto() {
		return wfUserReqDto;
	}

	/**
	 * Sets the wf user req dto.
	 *
	 * @param wfUserReqDto the wfUserReqDto to set
	 */
	public void setWfUserReqDto(List<WfUserReqSDDto> wfUserReqDto) {
		this.wfUserReqDto = wfUserReqDto;
	}

	/**
	 * Gets the div code.
	 *
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the divName
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the divName to set
	 */
	public void setDivName(String divName) {
		this.divName = divName;
	}

	/**
	 * Gets the bank name.
	 *
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Sets the bank name.
	 *
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the reqTypeName
	 */
	public String getReqTypeName() {
		return reqTypeName;
	}

	/**
	 * @param reqTypeName the reqTypeName to set
	 */
	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	/**
	 * @return the chequeTypeName
	 */
	public String getChequeTypeName() {
		return chequeTypeName;
	}

	/**
	 * @param chequeTypeName the chequeTypeName to set
	 */
	public void setChequeTypeName(String chequeTypeName) {
		this.chequeTypeName = chequeTypeName;
	}

}

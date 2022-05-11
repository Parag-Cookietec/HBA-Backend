package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;

/**
 * The Class LocChequeToChequeHDRDto.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:27:48
 *
 */
public class LocChequeToChequeHDRDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The referance number. */
	private String referanceNumber;

	/** The referance date. */
	private Date referanceDate;

	/** The status id. */
	private Long statusId;

	/** The status desc. */
	private String statusDesc;

	/** The missing cheque no. */
	private String missingChequeNo;

	/** The reason. */
	private String reason;

	/** The lc adviceid. */
	private Long lcAdviceid;

	/** The wf id. */
	private Long wfId;

	/** The wf role id. */
	private Long wfRoleId;

	/** The missing cheque date. */
	private Date missingChequeDate;

	/** The missing cheque amt. */
	private Double missingChequeAmt;

	/** The cheque tocheque sd dto. */
	private List<LocChequeToChequeDetailSdDto> chequeTochequeSdDto;

	/** The wf user req dto. */
	private WfUserReqSDDto wfUserReqDto;

	/**
	 * LocChequeToChequeHDRDto Constructor.
	 */
	public LocChequeToChequeHDRDto() {
		super();
	}

	/**
	 * Gets the missing cheque date.
	 *
	 * @return the missing cheque date
	 */
	public Date getMissingChequeDate() {
		return missingChequeDate;
	}

	/**
	 * Sets the missing cheque date.
	 *
	 * @param missingChequeDate the new missing cheque date
	 */
	public void setMissingChequeDate(Date missingChequeDate) {
		this.missingChequeDate = missingChequeDate;
	}

	/**
	 * Gets the missing cheque amt.
	 *
	 * @return the missing cheque amt
	 */
	public Double getMissingChequeAmt() {
		return missingChequeAmt;
	}

	/**
	 * Sets the missing cheque amt.
	 *
	 * @param missingChequeAmt the new missing cheque amt
	 */
	public void setMissingChequeAmt(Double missingChequeAmt) {
		this.missingChequeAmt = missingChequeAmt;
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
	 * Gets the referance number.
	 *
	 * @return the referanceNumber
	 */
	public String getReferanceNumber() {
		return referanceNumber;
	}

	/**
	 * Sets the referance number.
	 *
	 * @param referanceNumber the referanceNumber to set
	 */
	public void setReferanceNumber(String referanceNumber) {
		this.referanceNumber = referanceNumber;
	}

	/**
	 * Gets the referance date.
	 *
	 * @return the referanceDate
	 */
	public Date getReferanceDate() {
		return referanceDate;
	}

	/**
	 * Sets the referance date.
	 *
	 * @param referanceDate the referanceDate to set
	 */
	public void setReferanceDate(Date referanceDate) {
		this.referanceDate = referanceDate;
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
	 * Gets the status desc.
	 *
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * Sets the status desc.
	 *
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * Gets the missing cheque no.
	 *
	 * @return the missing cheque no
	 */
	public String getMissingChequeNo() {
		return missingChequeNo;
	}

	/**
	 * Sets the missing cheque no.
	 *
	 * @param missingChequeNo the new missing cheque no
	 */
	public void setMissingChequeNo(String missingChequeNo) {
		this.missingChequeNo = missingChequeNo;
	}

	/**
	 * Gets the reason.
	 *
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets the reason.
	 *
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * Gets the lc adviceid.
	 *
	 * @return the lcAdviceid
	 */
	public Long getLcAdviceid() {
		return lcAdviceid;
	}

	/**
	 * Sets the lc adviceid.
	 *
	 * @param lcAdviceid the lcAdviceid to set
	 */
	public void setLcAdviceid(Long lcAdviceid) {
		this.lcAdviceid = lcAdviceid;
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
	 * Gets the cheque tocheque sd dto.
	 *
	 * @return the cheque tocheque sd dto
	 */
	public List<LocChequeToChequeDetailSdDto> getChequeTochequeSdDto() {
		return chequeTochequeSdDto;
	}

	/**
	 * Sets the cheque tocheque sd dto.
	 *
	 * @param chequeTochequeSdDto the new cheque tocheque sd dto
	 */
	public void setChequeTochequeSdDto(List<LocChequeToChequeDetailSdDto> chequeTochequeSdDto) {
		this.chequeTochequeSdDto = chequeTochequeSdDto;
	}

	/**
	 * Gets the wf user req dto.
	 *
	 * @return the wf user req dto
	 */
	public WfUserReqSDDto getWfUserReqDto() {
		return wfUserReqDto;
	}

	/**
	 * Sets the wf user req dto.
	 *
	 * @param wfUserReqDto the new wf user req dto
	 */
	public void setWfUserReqDto(WfUserReqSDDto wfUserReqDto) {
		this.wfUserReqDto = wfUserReqDto;
	}

}

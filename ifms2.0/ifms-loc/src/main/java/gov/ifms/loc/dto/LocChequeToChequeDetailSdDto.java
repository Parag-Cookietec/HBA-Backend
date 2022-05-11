package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocChequeToChequeDetailSdDto.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:21:51
 *
 */
public class LocChequeToChequeDetailSdDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The cheque no. */
	private String chequeNo;

	/** The cheque date. */
	private Date chequeDate;

	/** The cheque amt. */
	private Double chequeAmt;

	/** The cheque to chequeid. */
	private Long hdrId;

	/** The wfid. */
	private Long wfid;

	/** The wf role id. */
	private Long wfRoleId;

	/** The status id. */
	private Long statusId;

	private String partyName;

	/**
	 * LocChequeToChequeDetailSdDto Constructor.
	 */
	public LocChequeToChequeDetailSdDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public Double getChequeAmt() {
		return chequeAmt;
	}

	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

	public Long getHdrId() {
		return hdrId;
	}

	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	public Long getWfid() {
		return wfid;
	}

	public void setWfid(Long wfid) {
		this.wfid = wfid;
	}

	public Long getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (!(o instanceof LocChequeToChequeDetailSdDto)) return false;
		if (!super.equals(o)) return false;
		LocChequeToChequeDetailSdDto that = (LocChequeToChequeDetailSdDto) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getChequeNo(), that.getChequeNo()) && Objects.equals(getChequeDate(), that.getChequeDate()) && Objects.equals(getChequeAmt(), that.getChequeAmt()) && Objects.equals(getHdrId(), that.getHdrId()) && Objects.equals(getWfid(), that.getWfid()) && Objects.equals(getWfRoleId(), that.getWfRoleId()) && Objects.equals(getStatusId(), that.getStatusId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getChequeNo(), getChequeDate(), getChequeAmt(), getHdrId(), getWfid(), getWfRoleId(), getStatusId());
	}
}

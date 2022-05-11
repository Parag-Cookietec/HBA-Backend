package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


/**
 * The Class EDPBrDtlHdrDto.
 */
public class EDPTedpBrDtlDto extends BaseDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The tedp br hdr id. */
	private Long tedpBrHdrId;

	/** The trn no. */
	private String trnNo;
	
	/** The request type. */
	private Long requestType;

	/** The request type name. */
	private String requestTypeName;

	/** The status id. */
	private Long statusId;

	/** The from post office user id. */
	private Long fromPouId;

	/** The to post office user id. */
	private Long toPouId;

	/** The branches to be mapped. */
	private List<Long> branchesToBeMapped;

	/** The from user branch. */
	private EDPBrDtlDto fromUserBranch;

	/** The to user branch. */
	private EDPBrDtlDto toUserBranch;

	/**
	 * Gets the tedp br hdr id.
	 *
	 * @return the tedp br hdr id
	 */
	public Long getTedpBrHdrId() {
		return tedpBrHdrId;
	}

	/**
	 * Sets the tedp br hdr id.
	 *
	 * @param tedpBrHdrId the new tedp br hdr id
	 */
	public void setTedpBrHdrId(Long tedpBrHdrId) {
		this.tedpBrHdrId = tedpBrHdrId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trn no
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the new trn no
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the request type.
	 *
	 * @return the request type
	 */
	public Long getRequestType() {
		return requestType;
	}

	/**
	 * Sets the request type.
	 *
	 * @param requestType the new request type
	 */
	public void setRequestType(Long requestType) {
		this.requestType = requestType;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the from pou id.
	 *
	 * @return the from pou id
	 */
	public Long getFromPouId() {
		return fromPouId;
	}

	/**
	 * Sets the from pou id.
	 *
	 * @param fromPouId the new from pou id
	 */
	public void setFromPouId(Long fromPouId) {
		this.fromPouId = fromPouId;
	}

	/**
	 * Gets the to pou id.
	 *
	 * @return the to pou id
	 */
	public Long getToPouId() {
		return toPouId;
	}

	/**
	 * Sets the to pou id.
	 *
	 * @param toPouId the new to pou id
	 */
	public void setToPouId(Long toPouId) {
		this.toPouId = toPouId;
	}

	/**
	 * Gets the branches to be mapped.
	 *
	 * @return the branches to be mapped
	 */
	public List<Long> getBranchesToBeMapped() {
		return branchesToBeMapped;
	}

	/**
	 * Sets the branches to be mapped.
	 *
	 * @param branchesToBeMapped the new branches to be mapped
	 */
	public void setBranchesToBeMapped(List<Long> branchesToBeMapped) {
		this.branchesToBeMapped = branchesToBeMapped;
	}

	/**
	 * Gets the from user branch.
	 *
	 * @return the from user branch
	 */
	public EDPBrDtlDto getFromUserBranch() {
		return fromUserBranch;
	}

	/**
	 * Sets the from user branch.
	 *
	 * @param fromUserBranch the new from user branch
	 */
	public void setFromUserBranch(EDPBrDtlDto fromUserBranch) {
		this.fromUserBranch = fromUserBranch;
	}

	/**
	 * Gets the to user branch.
	 *
	 * @return the to user branch
	 */
	public EDPBrDtlDto getToUserBranch() {
		return toUserBranch;
	}

	/**
	 * Sets the to user branch.
	 *
	 * @param toUserBranch the new to user branch
	 */
	public void setToUserBranch(EDPBrDtlDto toUserBranch) {
		this.toUserBranch = toUserBranch;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(branchesToBeMapped, fromPouId, fromUserBranch, requestType,
				requestTypeName, statusId, tedpBrHdrId, toPouId, toUserBranch, trnNo);
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPTedpBrDtlDto)) {
			return false;
		}
		EDPTedpBrDtlDto other = (EDPTedpBrDtlDto) obj;
		return Objects.equals(branchesToBeMapped, other.branchesToBeMapped)
				&& Objects.equals(fromPouId, other.fromPouId) && Objects.equals(fromUserBranch, other.fromUserBranch)
				&& Objects.equals(requestType, other.requestType)
				&& Objects.equals(requestTypeName, other.requestTypeName) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(tedpBrHdrId, other.tedpBrHdrId) && Objects.equals(toPouId, other.toPouId)
				&& Objects.equals(toUserBranch, other.toUserBranch) && Objects.equals(trnNo, other.trnNo);
	}

	/**
	 * Gets the request type name.
	 *
	 * @return the request type name
	 */
	public String getRequestTypeName() {
		return requestTypeName;
	}

	/**
	 * Sets the request type name.
	 *
	 * @param requestTypeName the new request type name
	 */
	public void setRequestTypeName(String requestTypeName) {
		this.requestTypeName = requestTypeName;
	}
		
}

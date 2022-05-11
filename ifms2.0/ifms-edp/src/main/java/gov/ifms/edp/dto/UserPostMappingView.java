package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The Class UserPostMappingView.
 */
public class UserPostMappingView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn no. */
	private String trnNo;

	/** The trn date. */
	private Date trnDate;

	/** The from emp no. */
	private Long fromEmpNo;

	/** The to emp no. */
	private Long toEmpNo;

	/** The edp usr po trns id. */
	private Long edpUsrPoTrnsId;

	/** The transfered post detail. */
	private List<UserPostMappingViewDetail> transferedPostDetail;

	/**
	 * Gets the transfered post detail.
	 *
	 * @return the transferedPostDetail
	 */
	public List<UserPostMappingViewDetail> getTransferedPostDetail() {
		return transferedPostDetail;
	}

	/**
	 * Sets the transfered post detail.
	 *
	 * @param transferedPostDetail the transferedPostDetail to set
	 */
	public void setTransferedPostDetail(List<UserPostMappingViewDetail> transferedPostDetail) {
		this.transferedPostDetail = transferedPostDetail;
	}

	/**
	 * Gets the edp usr po trns id.
	 *
	 * @return the edpUsrPoTrnsId
	 */
	public Long getEdpUsrPoTrnsId() {
		return edpUsrPoTrnsId;
	}

	/**
	 * Sets the edp usr po trns id.
	 *
	 * @param edpUsrPoTrnsId the edpUsrPoTrnsId to set
	 */
	public void setEdpUsrPoTrnsId(Long edpUsrPoTrnsId) {
		this.edpUsrPoTrnsId = edpUsrPoTrnsId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUsrPoTrnsId, fromEmpNo, toEmpNo, transferedPostDetail, trnDate, trnNo);
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
		if (!(obj instanceof UserPostMappingView)) {
			return false;
		}
		UserPostMappingView other = (UserPostMappingView) obj;
		return Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId) && Objects.equals(fromEmpNo, other.fromEmpNo)
				&& Objects.equals(toEmpNo, other.toEmpNo)
				&& Objects.equals(transferedPostDetail, other.transferedPostDetail)
				&& Objects.equals(trnDate, other.trnDate) && Objects.equals(trnNo, other.trnNo);
	}

	/**
	 * Gets the trn date.
	 *
	 * @return the trnDate
	 */
	public Date getTrnDate() {
		return trnDate;
	}

	/**
	 * Sets the trn date.
	 *
	 * @param trnDate the trnDate to set
	 */
	public void setTrnDate(Date trnDate) {
		this.trnDate = trnDate;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the from emp no.
	 *
	 * @return the fromEmpNo
	 */
	public Long getFromEmpNo() {
		return fromEmpNo;
	}

	/**
	 * Sets the from emp no.
	 *
	 * @param fromEmpNo the fromEmpNo to set
	 */
	public void setFromEmpNo(Long fromEmpNo) {
		this.fromEmpNo = fromEmpNo;
	}

	/**
	 * Gets the to emp no.
	 *
	 * @return the toEmpNo
	 */
	public Long getToEmpNo() {
		return toEmpNo;
	}

	/**
	 * Sets the to emp no.
	 *
	 * @param toEmpNo the toEmpNo to set
	 */
	public void setToEmpNo(Long toEmpNo) {
		this.toEmpNo = toEmpNo;
	}

}

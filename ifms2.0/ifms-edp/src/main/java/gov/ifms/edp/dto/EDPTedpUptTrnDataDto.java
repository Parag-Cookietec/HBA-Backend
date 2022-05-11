package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPTedpUptTrnDataDto.
 * 
 * @version 1.0
 * @created 2020/07/08 13:14:11
 *
 */
public class EDPTedpUptTrnDataDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long tedpUpdTrnDataId;

	private Long tedpUptHdrId;

	private Long lkPostOfficeId;

	private Long fromEmpId;

	private Long toEmpId;

	private Long isPrimaryPost;

	/**
	 * EDPTedpUptTrnDataDto Constructor
	 */
	public EDPTedpUptTrnDataDto() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(tedpUpdTrnDataId, tedpUptHdrId, lkPostOfficeId, fromEmpId, toEmpId, isPrimaryPost);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPTedpUptTrnDataDto)) {
			return false;
		}

		EDPTedpUptTrnDataDto other = (EDPTedpUptTrnDataDto) obj;

		return Objects.equals(tedpUpdTrnDataId, other.tedpUpdTrnDataId)
				&& Objects.equals(tedpUptHdrId, other.tedpUptHdrId)
				&& Objects.equals(lkPostOfficeId, other.lkPostOfficeId) && Objects.equals(fromEmpId, other.fromEmpId)
				&& Objects.equals(toEmpId, other.toEmpId) && Objects.equals(isPrimaryPost, other.isPrimaryPost);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "EDPTedpUptTrnDataDto [tedpUpdTrnDataId = " + tedpUpdTrnDataId + ",tedpUptHdrId = " + tedpUptHdrId
				+ ",lkPostOfficeId = " + lkPostOfficeId + ",fromEmpId = " + fromEmpId + ",toEmpId = " + toEmpId
				+ ",isPrimaryPost = " + isPrimaryPost + ",]";
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the tedpUpdTrnDataId
	 */
	public Long getTedpUpdTrnDataId() {
		return tedpUpdTrnDataId;
	}

	/**
	 * @param tedpUpdTrnDataId the tedpUpdTrnDataId to set
	 */
	public void setTedpUpdTrnDataId(Long tedpUpdTrnDataId) {
		this.tedpUpdTrnDataId = tedpUpdTrnDataId;
	}

	/**
	 * @return the tedpUptHdrId
	 */
	public Long getTedpUptHdrId() {
		return tedpUptHdrId;
	}

	/**
	 * @param tedpUptHdrId the tedpUptHdrId to set
	 */
	public void setTedpUptHdrId(Long tedpUptHdrId) {
		this.tedpUptHdrId = tedpUptHdrId;
	}

	/**
	 * @return the lkPostOfficeId
	 */
	public Long getLkPostOfficeId() {
		return lkPostOfficeId;
	}

	/**
	 * @param lkPostOfficeId the lkPostOfficeId to set
	 */
	public void setLkPostOfficeId(Long lkPostOfficeId) {
		this.lkPostOfficeId = lkPostOfficeId;
	}

	/**
	 * @return the fromEmpId
	 */
	public Long getFromEmpId() {
		return fromEmpId;
	}

	/**
	 * @param fromEmpId the fromEmpId to set
	 */
	public void setFromEmpId(Long fromEmpId) {
		this.fromEmpId = fromEmpId;
	}

	/**
	 * @return the toEmpId
	 */
	public Long getToEmpId() {
		return toEmpId;
	}

	/**
	 * @param toEmpId the toEmpId to set
	 */
	public void setToEmpId(Long toEmpId) {
		this.toEmpId = toEmpId;
	}

	/**
	 * @return the isPrimaryPost
	 */
	public Long getIsPrimaryPost() {
		return isPrimaryPost;
	}

	/**
	 * @param isPrimaryPost the isPrimaryPost to set
	 */
	public void setIsPrimaryPost(Long isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
	}

}

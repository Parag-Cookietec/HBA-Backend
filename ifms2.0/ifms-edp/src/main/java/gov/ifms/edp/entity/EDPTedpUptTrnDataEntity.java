package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPTedpUptTrnDataEntity.
 * 
 * @version 1.0
 * @created 2020/07/08 13:14:11
 *
 */
@Entity
@Table(name = "TEDP_UPT_TRN_DATA" , schema = Constant.EDP_SCHEMA)
public class EDPTedpUptTrnDataEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_UPD_TRN_DATA_ID")
	private Long tedpUpdTrnDataId;

	@Column(name = "TEDP_UPT_HDR_ID")
	private Long tedpUptHdrId;

	@Column(name = "LK_POST_OFFICE_ID")
	private Long lkPostOfficeId;

	@Column(name = "FROM_EMP_ID")
	private Long fromEmpId;

	@Column(name = "TO_EMP_ID")
	private Long toEmpId;

	@Column(name = "IS_PRIMARY_POST")
	private Long isPrimaryPost;

	/**
	 * EDPTedpUptTrnDataDto Constructor
	 */
	public EDPTedpUptTrnDataEntity() {
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
		if (!(obj instanceof EDPTedpUptTrnDataEntity)) {
			return false;
		}

		EDPTedpUptTrnDataEntity other = (EDPTedpUptTrnDataEntity) obj;

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
		return "EDPTedpUptTrnDataEntity [tedpUpdTrnDataId = " + tedpUpdTrnDataId + ",tedpUptHdrId = " + tedpUptHdrId
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

package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPTedpBrHdrEntity.
 */
@Entity
@Table(name = "TEDP_BR_HDR", schema = Constant.EDP_SCHEMA)
public class EDPTedpBrHdrEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tedp br hdr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_BR_HDR_ID")
	private Long tedpBrHdrId;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;
	
	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The request type. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REQUEST_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity requestType;

	/**
	 * Gets the tedp br hdr id.
	 *
	 * @return the tedpBrHdrId
	 */
	public Long getTedpBrHdrId() {
		return tedpBrHdrId;
	}

	/**
	 * Sets the tedp br hdr id.
	 *
	 * @param tedpBrHdrId the tedpBrHdrId to set
	 */
	public void setTedpBrHdrId(Long tedpBrHdrId) {
		this.tedpBrHdrId = tedpBrHdrId;
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
	 * Gets the request type.
	 *
	 * @return the requestType
	 */
	public EDPLuLookUpInfoEntity getRequestType() {
		return requestType;
	}

	/**
	 * Sets the request type.
	 *
	 * @param requestType the requestType to set
	 */
	public void setRequestType(EDPLuLookUpInfoEntity requestType) {
		this.requestType = requestType;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}
	
	/**
	 * Instantiates a new EDP tedp br hdr entity.
	 */
	public EDPTedpBrHdrEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP tedp br hdr entity.
	 *
	 * @param tedpBrHdrId the tedp br hdr id
	 */
	public EDPTedpBrHdrEntity(Long tedpBrHdrId) {
		super();
		this.tedpBrHdrId = tedpBrHdrId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(requestType, statusId, tedpBrHdrId, trnNo);
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPTedpBrHdrEntity)) {
			return false;
		}
		EDPTedpBrHdrEntity other = (EDPTedpBrHdrEntity) obj;
		return Objects.equals(requestType, other.requestType) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(tedpBrHdrId, other.tedpBrHdrId) && Objects.equals(trnNo, other.trnNo);
	}

}

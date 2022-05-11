package gov.ifms.doi.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_JPA_CLAIM_RETURN", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJpaClaimReturnEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLAIM_RETURN_ID")
	private long claimReturnId;

	@Column(name="FIELD_NAME", length=50)
	private String fieldName;

	@Column(name="FIELD_REMARKS", length=100)
	private String fieldRemarks;

	@Column(name="FIELD_TYPE_ID", nullable=false)
	private long fieldTypeId;

	@Column(name="FIELD_UPDATED_VALUE", length=100)
	private String fieldUpdatedValue;

	@Column(name="\"RETURN_STATUS\"", length=30)
	private String returnStatus;

	@Column(name="SEND_BY_OFFICER_ID")
	private long sendByOfficerId;

	@Column(name="SEND_BY_OFFICER_NAME", length=100)
	private String sendByOfficerName;

	@Temporal(TemporalType.DATE)
	@Column(name="SENT_BACK_DT")
	private Date sentBackDt;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATION_DT")
	private Date updationDt;

	//bi-directional many-to-one association to TdoiJpaClaimEntry
	@ManyToOne
	@JoinColumn(name="JPA_CLAIM_ID", nullable=false)
	private DoiJPAClaimEntryEntity doiJpaClaimEntry;

	/**
	 * @return the claimReturnId
	 */
	public long getClaimReturnId() {
		return claimReturnId;
	}

	/**
	 * @param claimReturnId the claimReturnId to set
	 */
	public void setClaimReturnId(long claimReturnId) {
		this.claimReturnId = claimReturnId;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the fieldRemarks
	 */
	public String getFieldRemarks() {
		return fieldRemarks;
	}

	/**
	 * @param fieldRemarks the fieldRemarks to set
	 */
	public void setFieldRemarks(String fieldRemarks) {
		this.fieldRemarks = fieldRemarks;
	}

	/**
	 * @return the fieldTypeId
	 */
	public long getFieldTypeId() {
		return fieldTypeId;
	}

	/**
	 * @param fieldTypeId the fieldTypeId to set
	 */
	public void setFieldTypeId(long fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}

	/**
	 * @return the fieldUpdatedValue
	 */
	public String getFieldUpdatedValue() {
		return fieldUpdatedValue;
	}

	/**
	 * @param fieldUpdatedValue the fieldUpdatedValue to set
	 */
	public void setFieldUpdatedValue(String fieldUpdatedValue) {
		this.fieldUpdatedValue = fieldUpdatedValue;
	}

	/**
	 * @return the returnStatus
	 */
	public String getReturnStatus() {
		return returnStatus;
	}

	/**
	 * @param returnStatus the returnStatus to set
	 */
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	/**
	 * @return the sendByOfficerId
	 */
	public long getSendByOfficerId() {
		return sendByOfficerId;
	}

	/**
	 * @param sendByOfficerId the sendByOfficerId to set
	 */
	public void setSendByOfficerId(long sendByOfficerId) {
		this.sendByOfficerId = sendByOfficerId;
	}

	/**
	 * @return the sendByOfficerName
	 */
	public String getSendByOfficerName() {
		return sendByOfficerName;
	}

	/**
	 * @param sendByOfficerName the sendByOfficerName to set
	 */
	public void setSendByOfficerName(String sendByOfficerName) {
		this.sendByOfficerName = sendByOfficerName;
	}

	/**
	 * @return the sentBackDt
	 */
	public Date getSentBackDt() {
		return sentBackDt;
	}

	/**
	 * @param sentBackDt the sentBackDt to set
	 */
	public void setSentBackDt(Date sentBackDt) {
		this.sentBackDt = sentBackDt;
	}

	/**
	 * @return the updationDt
	 */
	public Date getUpdationDt() {
		return updationDt;
	}

	/**
	 * @param updationDt the updationDt to set
	 */
	public void setUpdationDt(Date updationDt) {
		this.updationDt = updationDt;
	}

	/**
	 * @return the doiJpaClaimEntry
	 */
	public DoiJPAClaimEntryEntity getDoiJpaClaimEntry() {
		return doiJpaClaimEntry;
	}

	/**
	 * @param doiJpaClaimEntry the doiJpaClaimEntry to set
	 */
	public void setDoiJpaClaimEntry(DoiJPAClaimEntryEntity doiJpaClaimEntry) {
		this.doiJpaClaimEntry = doiJpaClaimEntry;
	}

}
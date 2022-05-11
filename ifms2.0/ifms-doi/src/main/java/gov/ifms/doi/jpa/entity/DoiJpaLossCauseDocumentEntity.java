/**
 * 
 */
package gov.ifms.doi.jpa.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.edp.entity.BaseEntity;

/**
 * @author Rudra
 *
 */
@Entity
@Table(name = "MDOI_JPA_LOSS_CAUSE_DOCUMENT", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJpaLossCauseDocumentEntity extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6484570911382844576L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOSS_CAUSE_DOC_ID")
	private Long id;
	
	@Column(name = "CAUSE_TYPE_ID")
	private Long causeOfLoss;
	
	@Column(name = "CAUSE_TYPE")
	private String causeTypeName;
	
	@Column(name = "DOCUMENT_NAME")
	private String causeDocument;
	
	@Column(name = "IS_REQUIRED")
	//@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean causeRequirement;
	
	@Column(name = "DOCUMENT_STATUS")
	private String status;
	
	@Column(name = "REFERENCE_NO")
	private String refNo;
	
	@Column(name = "REFERENCE_DT")
	private Date refDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCauseOfLoss() {
		return causeOfLoss;
	}

	public void setCauseOfLoss(Long causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}

	public String getCauseTypeName() {
		return causeTypeName;
	}

	public void setCauseTypeName(String causeTypeName) {
		this.causeTypeName = causeTypeName;
	}

	public String getCauseDocument() {
		return causeDocument;
	}

	public void setCauseDocument(String causeDocument) {
		this.causeDocument = causeDocument;
	}

	public boolean isCauseRequirement() {
		return causeRequirement;
	}

	public void setCauseRequirement(boolean causeRequirement) {
		this.causeRequirement = causeRequirement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}
}

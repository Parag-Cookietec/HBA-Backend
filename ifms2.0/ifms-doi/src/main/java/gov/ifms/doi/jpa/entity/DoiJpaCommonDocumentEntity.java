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

import org.hibernate.annotations.Type;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.edp.entity.BaseEntity;

/**
 * @author Rudra
 *
 */
@Entity
@Table(name = "MDOI_JPA_COMMON_DOCUMENT", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJpaCommonDocumentEntity extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6484570911382844576L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMM_DOCUMNT_ID")
	private Long id;
	
	@Column(name = "DOCUMENT_NAME" , nullable = false)
	private String document;
	
	@Column(name = "IS_REQUIRED" , nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean requirement;
	
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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public boolean isRequirement() {
		return requirement;
	}

	public void setRequirement(boolean requirement) {
		this.requirement = requirement;
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

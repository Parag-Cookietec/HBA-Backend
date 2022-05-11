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
@Table(name = "MDOI_JPA_SCHEME_DOCUMENT", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJpaSchemeDocumentEntity extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6484570911382844576L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCHEME_DOCUMNT_ID")
	private Long id;
	
	@Column(name = "SCHEME_TYPE_ID")
	private Long scheme;
	
	@Column(name = "SCHEME_NAME")
	private String schemeName;
	
	@Column(name = "POLICY_NUMBER")
	private String policy;
	
	@Column(name = "DOCUMENT_NAME")
	private String schemeDocument;
	
	@Column(name = "IS_REQUIRED")
	//@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean documentRequirement;
	
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

	public Long getScheme() {
		return scheme;
	}

	public void setScheme(Long scheme) {
		this.scheme = scheme;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getSchemeDocument() {
		return schemeDocument;
	}

	public void setSchemeDocument(String schemeDocument) {
		this.schemeDocument = schemeDocument;
	}

	public boolean isDocumentRequirement() {
		return documentRequirement;
	}

	public void setDocumentRequirement(boolean documentRequirement) {
		this.documentRequirement = documentRequirement;
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

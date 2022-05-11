/**
 * 
 */
package gov.ifms.doi.jpa.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

/**
 * @author Rudra
 *
 */
public class DoiJpaSchemeDocumentDTO extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1518634908295683132L;

	private Long id;
	private Long scheme;
	private String schemeName;
	private String policy;
	private String schemeDocument;
	private boolean documentRequirement;
	private String status;
	private String refNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date refDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the scheme
	 */
	public Long getScheme() {
		return scheme;
	}

	/**
	 * @param scheme the scheme to set
	 */
	public void setScheme(Long scheme) {
		this.scheme = scheme;
	}

	/**
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * @param schemeName the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	/**
	 * @return the policy
	 */
	public String getPolicy() {
		return policy;
	}

	/**
	 * @param policy the policy to set
	 */
	public void setPolicy(String policy) {
		this.policy = policy;
	}

	/**
	 * @return the schemeDocument
	 */
	public String getSchemeDocument() {
		return schemeDocument;
	}

	/**
	 * @param schemeDocument the schemeDocument to set
	 */
	public void setSchemeDocument(String schemeDocument) {
		this.schemeDocument = schemeDocument;
	}

	/**
	 * @return the documentRequirement
	 */
	public boolean isDocumentRequirement() {
		return documentRequirement;
	}

	/**
	 * @param documentRequirement the documentRequirement to set
	 */
	public void setDocumentRequirement(boolean documentRequirement) {
		this.documentRequirement = documentRequirement;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * @return the refDate
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

}

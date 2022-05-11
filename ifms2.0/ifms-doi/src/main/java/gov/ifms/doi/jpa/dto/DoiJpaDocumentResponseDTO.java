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
public class DoiJpaDocumentResponseDTO extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6664062080379997465L;
	private Long id;
	private String document;
	private boolean requirement;
	private String status;
	private String refNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date refDate;
	private boolean isSchemeDoc = false;
	private boolean isLossCauseDoc = false;

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
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * @return the requirement
	 */
	public boolean isRequirement() {
		return requirement;
	}

	/**
	 * @param requirement the requirement to set
	 */
	public void setRequirement(boolean requirement) {
		this.requirement = requirement;
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

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	/**
	 * @return the isSchemeDoc
	 */
	public boolean isSchemeDoc() {
		return isSchemeDoc;
	}

	/**
	 * @param isSchemeDoc the isSchemeDoc to set
	 */
	public void setSchemeDoc(boolean isSchemeDoc) {
		this.isSchemeDoc = isSchemeDoc;
	}

	/**
	 * @return the isLossCauseDoc
	 */
	public boolean isLossCauseDoc() {
		return isLossCauseDoc;
	}

	/**
	 * @param isLossCauseDoc the isLossCauseDoc to set
	 */
	public void setLossCauseDoc(boolean isLossCauseDoc) {
		this.isLossCauseDoc = isLossCauseDoc;
	}

}

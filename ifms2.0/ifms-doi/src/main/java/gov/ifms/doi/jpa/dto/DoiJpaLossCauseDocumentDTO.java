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
public class DoiJpaLossCauseDocumentDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3967813253412440426L;

	private Long id;
	private Long causeOfLoss;
	private String causeTypeName;
	private String causeDocument;
	private boolean causeRequirement;
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
	 * @return the causeOfLoss
	 */
	public Long getCauseOfLoss() {
		return causeOfLoss;
	}

	/**
	 * @param causeOfLoss the causeOfLoss to set
	 */
	public void setCauseOfLoss(Long causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}

	/**
	 * @return the causeTypeName
	 */
	public String getCauseTypeName() {
		return causeTypeName;
	}

	/**
	 * @param causeTypeName the causeTypeName to set
	 */
	public void setCauseTypeName(String causeTypeName) {
		this.causeTypeName = causeTypeName;
	}

	/**
	 * @return the causeDocument
	 */
	public String getCauseDocument() {
		return causeDocument;
	}

	/**
	 * @param causeDocument the causeDocument to set
	 */
	public void setCauseDocument(String causeDocument) {
		this.causeDocument = causeDocument;
	}

	/**
	 * @return the causeRequirement
	 */
	public boolean isCauseRequirement() {
		return causeRequirement;
	}

	/**
	 * @param causeRequirement the causeRequirement to set
	 */
	public void setCauseRequirement(boolean causeRequirement) {
		this.causeRequirement = causeRequirement;
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

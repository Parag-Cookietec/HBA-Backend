package gov.ifms.common.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class TemplatePostDTO {
	
	@NotNull(message = "Menu Id may not be null")
	private Long menuId;
	
	@NotNull(message = "Event Category may not be null")
	private String eventCategory;
	
	@NotNull(message = "Event Name may not be null")
	private String eventName;
	
	@NotNull(message = "Is Email may not be null")
	private Integer isEmail;
	
	private String emailSubject;
	
	private String emailBody;
	
	@NotNull(message = "Is Sms may not be null")
	private Integer isSms;
	
	private String smsBody;
	
	@NotNull(message = "Is SN may not be null")
	private Integer isSn;
	
	private String snBody;
	
	@NotNull(message = "Is Todo may not be null")
	private Integer isTodo;
	
	@NotNull(message = "Procedure Name may not be null")
	private String procedureName;
	
	@NotNull(message = "Active Status may not be null")
	private Integer activeStatus;
	
	private Long createdBy;
	
	private Date createdDate;
	
	private Long createdByPost;
	
	private Long updatedBy;
	
	private Date updatedDate;
	
	private Long updatedByPost;

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(Integer isEmail) {
		this.isEmail = isEmail;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public Integer getIsSms() {
		return isSms;
	}

	public void setIsSms(Integer isSms) {
		this.isSms = isSms;
	}

	public String getSmsBody() {
		return smsBody;
	}

	public void setSmsBody(String smsBody) {
		this.smsBody = smsBody;
	}

	public Integer getIsSn() {
		return isSn;
	}

	public void setIsSn(Integer isSn) {
		this.isSn = isSn;
	}

	public String getSnBody() {
		return snBody;
	}

	public void setSnBody(String snBody) {
		this.snBody = snBody;
	}

	public Integer getIsTodo() {
		return isTodo;
	}

	public void setIsTodo(Integer isTodo) {
		this.isTodo = isTodo;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedByPost() {
		return createdByPost;
	}

	public void setCreatedByPost(Long createdByPost) {
		this.createdByPost = createdByPost;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getUpdatedByPost() {
		return updatedByPost;
	}

	public void setUpdatedByPost(Long updatedByPost) {
		this.updatedByPost = updatedByPost;
	}

}

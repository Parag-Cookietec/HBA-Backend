package gov.ifms.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TNF_TEMPLATE", schema = Constant.EDP_SCHEMA)
public class NotificationTemplate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TNF_TMP_ID")
	private Long tnfTmpId;
	
	@Column(name = "MENU_ID")
	private Long menuId;
	
	@Column(name = "EVENT_CATEGORY")
	private String eventCategory;
	
	@Column(name = "EVENT_NAME")
	private String eventName;
	
	@Column(name = "IS_EMAIL")
	private Integer isEmail;
	
	@Column(name = "EMAIL_SUBJECT")
	private String emailSubject;
	
	@Column(name = "EMAIL_BODY")
	private String emailBody;
	
	@Column(name = "IS_SMS")
	private Integer isSms;
	
	@Column(name = "SMS_BODY")
	private String smsBody;
	
	@Column(name = "IS_SN")
	private Integer isSn;
	
	@Column(name = "SN_BODY")
	private String snBody;
	
	@Column(name = "IS_TODO")
	private Integer isTodo;
	
	@Column(name = "PROCEDURE_NAME")
	private String procedureName;
	
	/** The active status. */
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus = 1;
	
	@Column(name = "CREATED_BY", updatable = false)
	private Long createdBy;
	
	/** The created date. */
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;
	
	/** The created by post. */
	@Column(name = "CREATED_BY_POST", updatable = false)
	private Long createdByPost;
	
	/** The updated by. */
	@Column(name = "UPDATED_BY")
	private Long updatedBy;
	
	/** The updated date. */
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	
	/** The updated by post. */
	@Column(name = "UPDATED_BY_POST")
	private Long updatedByPost;

	public Long getTnfTmpId() {
		return tnfTmpId;
	}

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

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
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

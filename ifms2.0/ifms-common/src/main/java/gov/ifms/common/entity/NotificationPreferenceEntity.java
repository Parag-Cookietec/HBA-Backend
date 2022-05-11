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
@Table(name = "TNF_PREFERENCE", schema = Constant.EDP_SCHEMA)
public class NotificationPreferenceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TNF_PRFNC_ID")
	private Long tnfPrfncId;
	
	/** The user id . */
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "IS_SMS")
	private Integer isSms;
	
	@Column(name = "IS_EMAIL")
	private Integer isEmail;
	
	@Column(name = "IS_SN")
	private Integer isSn;
	
	/** The menu id. */
	@Column(name = "MENU_ID")
	private Long menuId;
	
//	@OneToOne(fetch = FetchType.EAGER,optional = false)
//	@JoinColumn(name ="MENU_ID",nullable = false)
//	private EDPMsMenuEntity menuId;
	
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

	public NotificationPreferenceEntity() {
		super();
	}

	public NotificationPreferenceEntity(Long userId, Integer isSms, Integer isEmail, Integer isSn,
			Long menuId, int activeStatus,Long createdBy, Date createdDate,Long createdByPost, 
			Long updatedBy, Date updatedDate,Long updatedByPost) {
		super();
		this.userId = userId;
		this.isSms = isSms;
		this.isEmail = isEmail;
		this.isSn = isSn;
		this.menuId = menuId;
		this.activeStatus = activeStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.createdByPost = createdByPost;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.updatedByPost = updatedByPost;
	}

	public Long getTnfPrfncId() {
		return tnfPrfncId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getIsSms() {
		return isSms;
	}

	public void setIsSms(Integer isSms) {
		this.isSms = isSms;
	}

	public Integer getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(Integer isEmail) {
		this.isEmail = isEmail;
	}

	public Integer getIsSn() {
		return isSn;
	}

	public void setIsSn(Integer isSn) {
		this.isSn = isSn;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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

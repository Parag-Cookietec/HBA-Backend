package gov.ifms.edp.oauth.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.entity.EDPMsModuleInfoEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;

/**
 * The Class OAuthLkPostUserRoleMenuModule.
 */

@Entity
@Table(name = "LK_POST_USER_ROLE_MENU_MODULE", schema = Constant.OAUTH_SCHEMA)
public class OAuthLkPostUserRoleMenuModule extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post user role menu module id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_USER_ROLE_MENU_MODULE_ID")
	private long postUserRoleMenuModuleId;

	/** The financtial year id. */
	@Column(name = "FINANCIAL_YEAR_ID")
	private String financtialYearId;

	/** The edp ms posts. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID")
	private EDPMsPostEntity edpMsPosts;

	/** The edp ms users. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private EDPMsUserEntity edpMsUsers;

	/** The edp ms role activity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ACTIVITY_ID")
	private EDPMsRolePermissionsEntity edpMsRoleActivity;

	/** The menu entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID")
	private EDPMsMenuEntity menuEntity;

	/** The edp ms module info. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULE_INFO_ID")
	private EDPMsModuleInfoEntity edpMsModuleInfo;

	/** The is primary post. */
	@Column(name = "IS_PRIMARY_POST")
	private int isPrimaryPost;

	/**
	 * Instantiates a new o auth lk post user role menu module.
	 */
	public OAuthLkPostUserRoleMenuModule() {
	}

	/**
	 * Instantiates a new o auth lk post user role menu module.
	 *
	 * @param postUserRoleMenuModuleId the post user role menu module id
	 * @param financtialYearId         the financtial year id
	 * @param edpMsPosts               the edp ms posts
	 * @param edpMsUsers               the edp ms users
	 * @param edpMsRoleActivity        the edp ms role activity
	 * @param edpMsModuleInfo          the edp ms module info
	 * @param isPrimaryPost            the is primary post
	 */
	public OAuthLkPostUserRoleMenuModule(long postUserRoleMenuModuleId, String financtialYearId,
			EDPMsPostEntity edpMsPosts, EDPMsUserEntity edpMsUsers, EDPMsRolePermissionsEntity edpMsRoleActivity,
			EDPMsModuleInfoEntity edpMsModuleInfo, int isPrimaryPost) {
		super();
		this.postUserRoleMenuModuleId = postUserRoleMenuModuleId;
		this.financtialYearId = financtialYearId;
		this.edpMsPosts = edpMsPosts;
		this.edpMsUsers = edpMsUsers;
		this.edpMsRoleActivity = edpMsRoleActivity;
		this.edpMsModuleInfo = edpMsModuleInfo;
		this.isPrimaryPost = isPrimaryPost;
	}

	/**
	 * Instantiates a new o auth lk post user role menu module.
	 *
	 * @param financtialYearId  the financtial year id
	 * @param edpMsPosts        the edp ms posts
	 * @param edpMsUsers        the edp ms users
	 * @param edpMsRoleActivity the edp ms role activity
	 * @param edpMsModuleInfo   the edp ms module info
	 * @param isPrimaryPost     the is primary post
	 */
	public OAuthLkPostUserRoleMenuModule(String financtialYearId, EDPMsPostEntity edpMsPosts,
			EDPMsUserEntity edpMsUsers, EDPMsRolePermissionsEntity edpMsRoleActivity,
			EDPMsModuleInfoEntity edpMsModuleInfo, int isPrimaryPost) {
		super();
		this.financtialYearId = financtialYearId;
		this.edpMsPosts = edpMsPosts;
		this.edpMsUsers = edpMsUsers;
		this.edpMsRoleActivity = edpMsRoleActivity;
		this.edpMsModuleInfo = edpMsModuleInfo;
		this.isPrimaryPost = isPrimaryPost;
	}

	/**
	 * Gets the checks if is primary post.
	 *
	 * @return the checks if is primary post
	 */
	public int getIsPrimaryPost() {
		return isPrimaryPost;
	}

	/**
	 * Sets the checks if is primary post.
	 *
	 * @param isPrimaryPost the new checks if is primary post
	 */
	public void setIsPrimaryPost(int isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
	}

	/**
	 * Gets the post user role menu module id.
	 *
	 * @return the post user role menu module id
	 */
	public long getPostUserRoleMenuModuleId() {
		return postUserRoleMenuModuleId;
	}

	/**
	 * Sets the post user role menu module id.
	 *
	 * @param postUserRoleMenuModuleId the new post user role menu module id
	 */
	public void setPostUserRoleMenuModuleId(long postUserRoleMenuModuleId) {
		this.postUserRoleMenuModuleId = postUserRoleMenuModuleId;
	}

	/**
	 * Gets the financtial year id.
	 *
	 * @return the financtial year id
	 */
	public String getFinanctialYearId() {
		return financtialYearId;
	}

	/**
	 * Sets the financtial year id.
	 *
	 * @param financtialYearId the new financtial year id
	 */
	public void setFinanctialYearId(String financtialYearId) {
		this.financtialYearId = financtialYearId;
	}

	/**
	 * Gets the edp ms posts.
	 *
	 * @return the edp ms posts
	 */
	public EDPMsPostEntity getEdpMsPosts() {
		return edpMsPosts;
	}

	/**
	 * Sets the edp ms posts.
	 *
	 * @param edpMsPosts the new edp ms posts
	 */
	public void setEdpMsPosts(EDPMsPostEntity edpMsPosts) {
		this.edpMsPosts = edpMsPosts;
	}

	/**
	 * Gets the edp ms users.
	 *
	 * @return the edp ms users
	 */
	public EDPMsUserEntity getEdpMsUsers() {
		return edpMsUsers;
	}

	/**
	 * Sets the edp ms users.
	 *
	 * @param edpMsUsers the new edp ms users
	 */
	public void setEdpMsUsers(EDPMsUserEntity edpMsUsers) {
		this.edpMsUsers = edpMsUsers;
	}

	/**
	 * Gets the edp ms role activity.
	 *
	 * @return the edp ms role activity
	 */
	public EDPMsRolePermissionsEntity getEdpMsRoleActivity() {
		return edpMsRoleActivity;
	}

	/**
	 * Sets the edp ms role activity.
	 *
	 * @param edpMsRoleActivity the new edp ms role activity
	 */
	public void setEdpMsRoleActivity(EDPMsRolePermissionsEntity edpMsRoleActivity) {
		this.edpMsRoleActivity = edpMsRoleActivity;
	}

	/**
	 * Gets the edp ms module info.
	 *
	 * @return the edp ms module info
	 */
	public EDPMsModuleInfoEntity getEdpMsModuleInfo() {
		return edpMsModuleInfo;
	}

	/**
	 * Sets the edp ms module info.
	 *
	 * @param edpMsModuleInfo the new edp ms module info
	 */
	public void setEdpMsModuleInfo(EDPMsModuleInfoEntity edpMsModuleInfo) {
		this.edpMsModuleInfo = edpMsModuleInfo;
	}

	/**
	 * Gets the menu entity.
	 *
	 * @return the menu entity
	 */
	public EDPMsMenuEntity getMenuEntity() {
		return menuEntity;
	}

	/**
	 * Sets the menu entity.
	 *
	 * @param menuEntity the new menu entity
	 */
	public void setMenuEntity(EDPMsMenuEntity menuEntity) {
		this.menuEntity = menuEntity;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpMsModuleInfo, edpMsPosts, edpMsRoleActivity, edpMsUsers, financtialYearId, isPrimaryPost,
				menuEntity, postUserRoleMenuModuleId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OAuthLkPostUserRoleMenuModule)) {
			return false;
		}
		OAuthLkPostUserRoleMenuModule other = (OAuthLkPostUserRoleMenuModule) obj;
		return Objects.equals(edpMsModuleInfo, other.edpMsModuleInfo) && Objects.equals(edpMsPosts, other.edpMsPosts)
				&& Objects.equals(edpMsRoleActivity, other.edpMsRoleActivity)
				&& Objects.equals(edpMsUsers, other.edpMsUsers)
				&& Objects.equals(financtialYearId, other.financtialYearId) && isPrimaryPost == other.isPrimaryPost
				&& Objects.equals(menuEntity, other.menuEntity)
				&& postUserRoleMenuModuleId == other.postUserRoleMenuModuleId;
	}

}

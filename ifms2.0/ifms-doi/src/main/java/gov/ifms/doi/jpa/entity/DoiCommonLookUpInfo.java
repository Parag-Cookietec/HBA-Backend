package gov.ifms.doi.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

@Entity
@Table(name = "LU_LOOKUP_INFO", schema = DoiJPAConstants.MASTER_V1_SCHEMA)
public class DoiCommonLookUpInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOOKUP_INFO_ID", updatable = false)
	private Long lookupInfoId;

	@Column(name = "LOOKUP_INFO_VALUE")
	private String lookupInfoValue;

	@Column(name = "LOOKUP_INFO_NAME")
	private String lookupInfoName;

	@Column(name = "LOOKUP_INFO_NAME_GUJ")
	private String lookupInfoNameGuj;

	@Column(name = "LOOKUP_INFO_DESCRIPTION")
	private String lookupInfoDescription;

	@Column(name = "LOOKUP_INFO_DESCRIPTION_GUJ")
	private String lookupInfoDescriptionGuj;

	@Column(name = "PARENT_LOOKUP_ID")
	private Long parentLookupId;

	@Column(name = "ORDER_ID")
	private String orderId;

	/**
	 * @return the lookupInfoId
	 */
	public Long getLookupInfoId() {
		return lookupInfoId;
	}

	/**
	 * @param lookupInfoId the lookupInfoId to set
	 */
	public void setLookupInfoId(Long lookupInfoId) {
		this.lookupInfoId = lookupInfoId;
	}

	/**
	 * @return the lookupInfoValue
	 */
	public String getLookupInfoValue() {
		return lookupInfoValue;
	}

	/**
	 * @param lookupInfoValue the lookupInfoValue to set
	 */
	public void setLookupInfoValue(String lookupInfoValue) {
		this.lookupInfoValue = lookupInfoValue;
	}

	/**
	 * @return the lookupInfoName
	 */
	public String getLookupInfoName() {
		return lookupInfoName;
	}

	/**
	 * @param lookupInfoName the lookupInfoName to set
	 */
	public void setLookupInfoName(String lookupInfoName) {
		this.lookupInfoName = lookupInfoName;
	}

	/**
	 * @return the lookupInfoNameGuj
	 */
	public String getLookupInfoNameGuj() {
		return lookupInfoNameGuj;
	}

	/**
	 * @param lookupInfoNameGuj the lookupInfoNameGuj to set
	 */
	public void setLookupInfoNameGuj(String lookupInfoNameGuj) {
		this.lookupInfoNameGuj = lookupInfoNameGuj;
	}

	/**
	 * @return the lookupInfoDescription
	 */
	public String getLookupInfoDescription() {
		return lookupInfoDescription;
	}

	/**
	 * @param lookupInfoDescription the lookupInfoDescription to set
	 */
	public void setLookupInfoDescription(String lookupInfoDescription) {
		this.lookupInfoDescription = lookupInfoDescription;
	}

	/**
	 * @return the lookupInfoDescriptionGuj
	 */
	public String getLookupInfoDescriptionGuj() {
		return lookupInfoDescriptionGuj;
	}

	/**
	 * @param lookupInfoDescriptionGuj the lookupInfoDescriptionGuj to set
	 */
	public void setLookupInfoDescriptionGuj(String lookupInfoDescriptionGuj) {
		this.lookupInfoDescriptionGuj = lookupInfoDescriptionGuj;
	}

	/**
	 * @return the parentLookupId
	 */
	public Long getParentLookupId() {
		return parentLookupId;
	}

	/**
	 * @param parentLookupId the parentLookupId to set
	 */
	public void setParentLookupId(Long parentLookupId) {
		this.parentLookupId = parentLookupId;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}

package gov.ifms.doi.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

@Entity
@Table(name = "LU_LOOKUP", schema = DoiJPAConstants.MASTER_V1_SCHEMA)
public class DoiCommonLookUp extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOOKUP_ID", updatable = false)
	private Long lookupId;

	@Column(name = "LOOKUP_NAME")
	private String lookupName;

	@Column(name = "LOOKUP_NAME_GUJ")
	private String lookupNameGuj;

	@Column(name = "LOOKUP_DESCRIPTION")
	private String lookupDescription;

	@Column(name = "LOOKUP_DESCRIPTION_GUJ")
	private String lookupDescriptionGuj;

	/**
	 * @return the lookupId
	 */
	public Long getLookupId() {
		return lookupId;
	}

	/**
	 * @param lookupId the lookupId to set
	 */
	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	/**
	 * @return the lookupName
	 */
	public String getLookupName() {
		return lookupName;
	}

	/**
	 * @param lookupName the lookupName to set
	 */
	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	/**
	 * @return the lookupNameGuj
	 */
	public String getLookupNameGuj() {
		return lookupNameGuj;
	}

	/**
	 * @param lookupNameGuj the lookupNameGuj to set
	 */
	public void setLookupNameGuj(String lookupNameGuj) {
		this.lookupNameGuj = lookupNameGuj;
	}

	/**
	 * @return the lookupDescription
	 */
	public String getLookupDescription() {
		return lookupDescription;
	}

	/**
	 * @param lookupDescription the lookupDescription to set
	 */
	public void setLookupDescription(String lookupDescription) {
		this.lookupDescription = lookupDescription;
	}

	/**
	 * @return the lookupDescriptionGuj
	 */
	public String getLookupDescriptionGuj() {
		return lookupDescriptionGuj;
	}

	/**
	 * @param lookupDescriptionGuj the lookupDescriptionGuj to set
	 */
	public void setLookupDescriptionGuj(String lookupDescriptionGuj) {
		this.lookupDescriptionGuj = lookupDescriptionGuj;
	}

}

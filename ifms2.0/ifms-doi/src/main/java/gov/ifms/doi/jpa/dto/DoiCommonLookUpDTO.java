package gov.ifms.doi.jpa.dto;

public class DoiCommonLookUpDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long lookupId;

	private String lookupName;

	private String lookupNameGuj;

	private String lookupDescription;

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

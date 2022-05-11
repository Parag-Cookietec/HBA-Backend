package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPPostOfficeDetailsDto.
 */
public class EDPPostOfficeDetailsDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The district. */
	private ClueDto district;

	/** The ddo no. */
	private String ddoNo;

	/** The cardex no. */
	private Long cardexNo;

	/** The ddo office. */
	private String ddoOffice;

	/** The designations. */
	private List<ClueDto> designations;

	/** The office id. */
	private Long officeId;

	/** The vacant post. */
	private List<ClueDto> vacantPost;

	

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public ClueDto getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the district to set
	 */
	public void setDistrict(ClueDto district) {
		this.district = district;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo office.
	 *
	 * @return the ddoOffice
	 */
	public String getDdoOffice() {
		return ddoOffice;
	}

	/**
	 * Sets the ddo office.
	 *
	 * @param ddoOffice the ddoOffice to set
	 */
	public void setDdoOffice(String ddoOffice) {
		this.ddoOffice = ddoOffice;
	}

	/**
	 * Gets the designations.
	 *
	 * @return the designations
	 */
	public List<ClueDto> getDesignations() {
		return designations;
	}

	/**
	 * Sets the designations.
	 *
	 * @param designations the designations to set
	 */
	public void setDesignations(List<ClueDto> designations) {
		this.designations = designations;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the vacant post.
	 *
	 * @return the vacantPost
	 */
	public List<ClueDto> getVacantPost() {
		return vacantPost;
	}

	/**
	 * Sets the vacant post.
	 *
	 * @param vacantPost the vacantPost to set
	 */
	public void setVacantPost(List<ClueDto> vacantPost) {
		this.vacantPost = vacantPost;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cardexNo, ddoNo, ddoOffice, designations, district, officeId, vacantPost);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPPostOfficeDetailsDto other = (EDPPostOfficeDetailsDto) obj;
		return  Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(ddoOffice, other.ddoOffice)
				&& Objects.equals(designations, other.designations) && Objects.equals(district, other.district)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(vacantPost, other.vacantPost);
	}

}

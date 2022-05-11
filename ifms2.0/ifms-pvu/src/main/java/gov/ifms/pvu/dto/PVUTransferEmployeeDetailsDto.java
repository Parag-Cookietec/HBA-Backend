package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;

import gov.ifms.edp.dto.EDPSDTDto;

/**
 * The Class PVUTransferEmployeeDetailsDto.
 */
public class PVUTransferEmployeeDetailsDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lst SDT data. */
	private List<EDPSDTDto> noonType;

	/** The reason for trasfer. */
	private List<EDPSDTDto> reasonForTrasfer;
	
	/** The district. */
	private List<EDPSDTDto> district;
	
	/** The designation. */
	private List<EDPSDTDto> designation;
	
	/**
	 * Gets the noon type.
	 *
	 * @return the noon type
	 */
	public List<EDPSDTDto> getNoonType() {
		return noonType;
	}

	/**
	 * Sets the noon type.
	 *
	 * @param noonType the new noon type
	 */
	public void setNoonType(List<EDPSDTDto> noonType) {
		this.noonType = noonType;
	}

	/**
	 * Gets the reason for trasfer.
	 *
	 * @return the reason for trasfer
	 */
	public List<EDPSDTDto> getReasonForTrasfer() {
		return reasonForTrasfer;
	}

	/**
	 * Sets the reason for trasfer.
	 *
	 * @param reasonForTrasfer the new reason for trasfer
	 */
	public void setReasonForTrasfer(List<EDPSDTDto> reasonForTrasfer) {
		this.reasonForTrasfer = reasonForTrasfer;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public List<EDPSDTDto> getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the new district
	 */
	public void setDistrict(List<EDPSDTDto> district) {
		this.district = district;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public List<EDPSDTDto> getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the new designation
	 */
	public void setDesignation(List<EDPSDTDto> designation) {
		this.designation = designation;
	}
}

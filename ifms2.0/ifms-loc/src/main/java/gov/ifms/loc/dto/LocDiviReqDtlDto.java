package gov.ifms.loc.dto;

public interface LocDiviReqDtlDto {

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	Long getHdrId();
	
	/**
	 * Gets the  sd/Dtl id.
	 *
	 * @return the  sd/Dtl id
	 */
	Long getDtlId();

	
	/**
	 * Gets the division code.
	 *
	 * @return the division code
	 */
	String getDivisionCode();
	
	/**
	 * Gets the division remarks.
	 *
	 * @return the division remarks
	 */
	String getDivisionRemarks();
	
}

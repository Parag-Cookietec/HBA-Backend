package gov.ifms.loc.dto;

import java.util.Date;

public interface LocAdvicePrepDtlDto {
	
	/**
	 * Gets the hdr ID.
	 *
	 * @return the hdr ID
	 *//*
		 * Long getHdrId();
		 */

	/** The lc cheque Amt. */
	Long getChequeAmount();

	/** The cheque Date */
	Date getChequeDate();

	/** The cheque Number */
	String getChequeNo();

	/** The lc cheque Amt. */
	String getPartyName();
}

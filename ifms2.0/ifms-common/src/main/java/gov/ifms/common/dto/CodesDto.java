package gov.ifms.common.dto;

import java.io.Serializable;

/**
 * The Class CodesDto.
 */
public class CodesDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	/** The bpn code. */
	private String bpnCode;
	
	/** The demand code. */
	private String demandCode;
	
	/** The major head code. */
	private String majorHeadCode;
	
	/** The sub major head code. */
	private String subMajorHeadCode;
	
	/** The minor head code. */
	private String minorHeadCode;
	
	/** The sub head code. */
	private String subHeadCode;
	
	/** The rev cap type. */
	private long revCapType;
	
	/**
	 * Gets the bpn code.
	 *
	 * @return the bpn code
	 */
	public String getBpnCode() {
		return bpnCode;
	}
	
	/**
	 * Sets the bpn code.
	 *
	 * @param bpnCode the new bpn code
	 */
	public void setBpnCode(String bpnCode) {
		this.bpnCode = bpnCode;
	}
	
	/**
	 * Gets the demand code.
	 *
	 * @return the demand code
	 */
	public String getDemandCode() {
		return demandCode;
	}
	
	/**
	 * Sets the demand code.
	 *
	 * @param demandCode the new demand code
	 */
	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}
	
	/**
	 * Gets the major head code.
	 *
	 * @return the major head code
	 */
	public String getMajorHeadCode() {
		return majorHeadCode;
	}
	
	/**
	 * Sets the major head code.
	 *
	 * @param majorHeadCode the new major head code
	 */
	public void setMajorHeadCode(String majorHeadCode) {
		this.majorHeadCode = majorHeadCode;
	}
	
	/**
	 * Gets the sub major head code.
	 *
	 * @return the sub major head code
	 */
	public String getSubMajorHeadCode() {
		return subMajorHeadCode;
	}
	
	/**
	 * Sets the sub major head code.
	 *
	 * @param subMajorHeadCode the new sub major head code
	 */
	public void setSubMajorHeadCode(String subMajorHeadCode) {
		this.subMajorHeadCode = subMajorHeadCode;
	}
	
	/**
	 * Gets the minor head code.
	 *
	 * @return the minor head code
	 */
	public String getMinorHeadCode() {
		return minorHeadCode;
	}
	
	/**
	 * Sets the minor head code.
	 *
	 * @param minorHeadCode the new minor head code
	 */
	public void setMinorHeadCode(String minorHeadCode) {
		this.minorHeadCode = minorHeadCode;
	}
	
	/**
	 * Gets the sub head code.
	 *
	 * @return the sub head code
	 */
	public String getSubHeadCode() {
		return subHeadCode;
	}
	
	/**
	 * Sets the sub head code.
	 *
	 * @param subHeadCode the new sub head code
	 */
	public void setSubHeadCode(String subHeadCode) {
		this.subHeadCode = subHeadCode;
	}
	
	/**
	 * Gets the rev cap type.
	 *
	 * @return the rev cap type
	 */
	public long getRevCapType() {
		return revCapType;
	}
	
	/**
	 * Sets the rev cap type.
	 *
	 * @param revCapType the new rev cap type
	 */
	public void setRevCapType(long revCapType) {
		this.revCapType = revCapType;
	}
	
}

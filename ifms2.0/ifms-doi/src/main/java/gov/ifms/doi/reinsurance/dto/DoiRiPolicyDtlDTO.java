package gov.ifms.doi.reinsurance.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Rudra
 *
 */
public class DoiRiPolicyDtlDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6436361585390590482L;

	private long riPolicyDtlId;

	private Date challanDt;

	private String challanNo;

	private double premShareAmt;

	private String remarks;

	private String riLocation;

	private String riName;

	private double riSharePc;

	private DoiRiPolicyHdrDTO doiRiPolicyHdr;

	/**
	 * @return the riPolicyDtlId
	 */
	public long getRiPolicyDtlId() {
		return riPolicyDtlId;
	}

	/**
	 * @param riPolicyDtlId the riPolicyDtlId to set
	 */
	public void setRiPolicyDtlId(long riPolicyDtlId) {
		this.riPolicyDtlId = riPolicyDtlId;
	}

	/**
	 * @return the challanDt
	 */
	public Date getChallanDt() {
		return challanDt;
	}

	/**
	 * @param challanDt the challanDt to set
	 */
	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	/**
	 * @return the challanNo
	 */
	public String getChallanNo() {
		return challanNo;
	}

	/**
	 * @param challanNo the challanNo to set
	 */
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	/**
	 * @return the premShareAmt
	 */
	public double getPremShareAmt() {
		return premShareAmt;
	}

	/**
	 * @param premShareAmt the premShareAmt to set
	 */
	public void setPremShareAmt(double premShareAmt) {
		this.premShareAmt = premShareAmt;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the riLocation
	 */
	public String getRiLocation() {
		return riLocation;
	}

	/**
	 * @param riLocation the riLocation to set
	 */
	public void setRiLocation(String riLocation) {
		this.riLocation = riLocation;
	}

	/**
	 * @return the riName
	 */
	public String getRiName() {
		return riName;
	}

	/**
	 * @param riName the riName to set
	 */
	public void setRiName(String riName) {
		this.riName = riName;
	}

	/**
	 * @return the riSharePc
	 */
	public double getRiSharePc() {
		return riSharePc;
	}

	/**
	 * @param riSharePc the riSharePc to set
	 */
	public void setRiSharePc(double riSharePc) {
		this.riSharePc = riSharePc;
	}

	/**
	 * @return the doiRiPolicyHdr
	 */
	public DoiRiPolicyHdrDTO getDoiRiPolicyHdr() {
		return doiRiPolicyHdr;
	}

	/**
	 * @param doiRiPolicyHdr the doiRiPolicyHdr to set
	 */
	public void setDoiRiPolicyHdr(DoiRiPolicyHdrDTO doiRiPolicyHdr) {
		this.doiRiPolicyHdr = doiRiPolicyHdr;
	}

}
package gov.ifms.doi.reinsurance.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Rudra
 *
 */
public class DoiRiClaimDtlDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8546595466595370902L;

	private long riClaimDtlId;

	private Date challanDt;

	private String challanNo;

	private String remarks;

	private double riClaimAmt;

	private String riCompanyName;

	private double riSharePerc;

	private DoiRiClaimHdrDTO doiRiClaimHdr;

	/**
	 * @return the riClaimDtlId
	 */
	public long getRiClaimDtlId() {
		return riClaimDtlId;
	}

	/**
	 * @param riClaimDtlId the riClaimDtlId to set
	 */
	public void setRiClaimDtlId(long riClaimDtlId) {
		this.riClaimDtlId = riClaimDtlId;
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
	 * @return the riClaimAmt
	 */
	public double getRiClaimAmt() {
		return riClaimAmt;
	}

	/**
	 * @param riClaimAmt the riClaimAmt to set
	 */
	public void setRiClaimAmt(double riClaimAmt) {
		this.riClaimAmt = riClaimAmt;
	}

	/**
	 * @return the riCompanyName
	 */
	public String getRiCompanyName() {
		return riCompanyName;
	}

	/**
	 * @param riCompanyName the riCompanyName to set
	 */
	public void setRiCompanyName(String riCompanyName) {
		this.riCompanyName = riCompanyName;
	}

	/**
	 * @return the riSharePerc
	 */
	public double getRiSharePerc() {
		return riSharePerc;
	}

	/**
	 * @param riSharePerc the riSharePerc to set
	 */
	public void setRiSharePerc(double riSharePerc) {
		this.riSharePerc = riSharePerc;
	}

	/**
	 * @return the doiRiClaimHdr
	 */
	public DoiRiClaimHdrDTO getDoiRiClaimHdr() {
		return doiRiClaimHdr;
	}

	/**
	 * @param doiRiClaimHdr the doiRiClaimHdr to set
	 */
	public void setDoiRiClaimHdr(DoiRiClaimHdrDTO doiRiClaimHdr) {
		this.doiRiClaimHdr = doiRiClaimHdr;
	}

}
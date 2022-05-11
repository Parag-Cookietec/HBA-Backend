/**
 * 
 */
package gov.ifms.doi.legalentry.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Rudra
 *
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DOIJpaLegalOthrPaymentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8674879287230050469L;
	
	private long othrPaymntsId;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date chequeDt;

	private long chequeNum;

	private String commissionType;

	private long ddNum;

	private double paymentAmount;

	private long paymentModeId;

	private String referenceNo;

	private String remarks;

	/**
	 * 
	 */
	public DOIJpaLegalOthrPaymentDTO() {
		super();
	}

	/**
	 * @return the othrPaymntsId
	 */
	public long getOthrPaymntsId() {
		return othrPaymntsId;
	}

	/**
	 * @param othrPaymntsId the othrPaymntsId to set
	 */
	public void setOthrPaymntsId(long othrPaymntsId) {
		this.othrPaymntsId = othrPaymntsId;
	}

	/**
	 * @return the chequeDt
	 */
	public Date getChequeDt() {
		return chequeDt;
	}

	/**
	 * @param chequeDt the chequeDt to set
	 */
	public void setChequeDt(Date chequeDt) {
		this.chequeDt = chequeDt;
	}

	/**
	 * @return the chequeNum
	 */
	public long getChequeNum() {
		return chequeNum;
	}

	/**
	 * @param chequeNum the chequeNum to set
	 */
	public void setChequeNum(long chequeNum) {
		this.chequeNum = chequeNum;
	}

	/**
	 * @return the commissionType
	 */
	public String getCommissionType() {
		return commissionType;
	}

	/**
	 * @param commissionType the commissionType to set
	 */
	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}

	/**
	 * @return the ddNum
	 */
	public long getDdNum() {
		return ddNum;
	}

	/**
	 * @param ddNum the ddNum to set
	 */
	public void setDdNum(long ddNum) {
		this.ddNum = ddNum;
	}

	/**
	 * @return the paymentAmount
	 */
	public double getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the paymentModeId
	 */
	public long getPaymentModeId() {
		return paymentModeId;
	}

	/**
	 * @param paymentModeId the paymentModeId to set
	 */
	public void setPaymentModeId(long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
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
	
}

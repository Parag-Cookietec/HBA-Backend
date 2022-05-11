package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class DMONSSFLoanMatchPayableDto.
 * 
 * @version 2.0
 * @created 2021/07/20 15:19:32
 *
 */
public class DMONSSFLoanMatchPayableDto implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The NSSF loan RePayment Id **/
	private Long id;
	
	/** The Memo No.**/
	private String memoNo;
	
	/** The Advice No.**/
	private String adviceNo;
	
	/** The Install Due Date**/
	private LocalDate installDueDate;
	
	/** The Principal Amount.**/
	private Double principalAmount;
	
	/** The Interest Amount.**/
	private Double intrestAmount;
	
	/** The Outstanding Amount.**/
	private Double outstandingAmount;
	
	/** The unpaid Amount.**/
	private Double unpaidAmount;
	
	/** The closing balance Amount.**/
	private Double closingBalAmount;
	
	/** The Is Install Paid Amount.**/
	private Double installPaidAmount;
	
	/** The Is Install Paid.**/
	private int isInstallPaid;
	
	/** The Is Install Paid Date.**/
	private LocalDate installPaidDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	public LocalDate getInstallDueDate() {
		return installDueDate;
	}

	public void setInstallDueDate(LocalDate installDueDate) {
		this.installDueDate = installDueDate;
	}

	public Double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(Double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public Double getIntrestAmount() {
		return intrestAmount;
	}

	public void setIntrestAmount(Double intrestAmount) {
		this.intrestAmount = intrestAmount;
	}

	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Double getUnpaidAmount() {
		return unpaidAmount;
	}

	public void setUnpaidAmount(Double unpaidAmount) {
		this.unpaidAmount = unpaidAmount;
	}

	public Double getClosingBalAmount() {
		return closingBalAmount;
	}

	public void setClosingBalAmount(Double closingBalAmount) {
		this.closingBalAmount = closingBalAmount;
	}

	public Double getInstallPaidAmount() {
		return installPaidAmount;
	}

	public void setInstallPaidAmount(Double installPaidAmount) {
		this.installPaidAmount = installPaidAmount;
	}

	public int getIsInstallPaid() {
		return isInstallPaid;
	}

	public void setIsInstallPaid(int isInstallPaid) {
		this.isInstallPaid = isInstallPaid;
	}

	public LocalDate getInstallPaidDate() {
		return installPaidDate;
	}

	public void setInstallPaidDate(LocalDate installPaidDate) {
		this.installPaidDate = installPaidDate;
	}
	
	
}


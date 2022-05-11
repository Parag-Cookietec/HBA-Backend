package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * The Class DMONSSFLoanRepaymentScheduleDto.
 * 
 * @version 2.0
 * @created 2021/07/20 15:19:32
 *
 */
public class DMONSSFLoanRepaymentScheduleDto implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The NSSF loan RePayment Id **/
	private Long id;
	
	/** The NSSF loan Finance Year Id  **/
	private Long financeYearId;
	
	/** The Install Due Date**/
	private LocalDate installDueDate;
	
	/** The Is Install Paid Date.**/
	private LocalDate installPaidDate;
	
	/** The Opening Balance Amount.**/
	private Double openingBalanceAmount;
	
	/** The Principal Amount.**/
	private Double principalAmount;
	
	/** The Interest Amount.**/
	private Double intrestAmount;
	
	/** The closing balance Amount.**/
	private Double closingBalAmount;
	
	/** The Loan Number **/
	private String loanNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFinanceYearId() {
		return financeYearId;
	}

	public void setFinanceYearId(Long financeYearId) {
		this.financeYearId = financeYearId;
	}

	public LocalDate getInstallDueDate() {
		return installDueDate;
	}

	public void setInstallDueDate(LocalDate installDueDate) {
		this.installDueDate = installDueDate;
	}

	public Double getOpeningBalanceAmount() {
		return openingBalanceAmount;
	}

	public void setOpeningBalanceAmount(Double openingBalanceAmount) {
		this.openingBalanceAmount = openingBalanceAmount;
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

	public Double getClosingBalAmount() {
		return closingBalAmount;
	}

	public void setClosingBalAmount(Double closingBalAmount) {
		this.closingBalAmount = closingBalAmount;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public LocalDate getInstallPaidDate() {
		return installPaidDate;
	}

	public void setInstallPaidDate(LocalDate installPaidDate) {
		this.installPaidDate = installPaidDate;
	}


}

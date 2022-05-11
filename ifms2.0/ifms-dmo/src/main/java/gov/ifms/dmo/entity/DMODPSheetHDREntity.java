package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.util.Constant;

/**
 * The Class DMODPSheetHDREntity.
 * 
 * @version 2.0
 * @created 2021/07/10 15:19:32
 *
 */
@Entity
@Table(name = "TDMO_DP_SHEET_HDR", schema = Constant.DMO_SCHEMA)
public class DMODPSheetHDREntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DP_SHEET_HDR_ID")
	private Long dpSheetId;

	@Column(name = "DP_SHEET_RECV_DT")
	private LocalDate dpSheetReciveDate;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "entity")
	private List<DMODPSheetEntryEntity> entities = new ArrayList<>();

	@Column(name = "GOG_CODE")
	private int gogCode;

	@Column(name = "MEMO_NO")
	private String memoNo;

	@Column(name = "REFERENCE_NO")
	private String refNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime refDate;

	@Column(name = "OPEN_BAL_CR")
	private Double openBalCr = 0d;

	@Column(name = "OPEN_BAL_DR")
	private Double openBalDr = 0d;

	@Column(name = "PAD_MUMB_GST_CR")
	private Double padMumbGstCr = 0d;

	@Column(name = "PAD_MUMB_GST_DR")
	private Double padMumbGstDr = 0d;

	@Column(name = "AGENCY_BANK_CR")
	private Double agencyBankCr = 0d;

	@Column(name = "AGENCY_BANK_DR")
	private Double agencyBankDr = 0d;

	@Column(name = "PAD_TRANS_CR")
	private Double padTransCr = 0d;

	@Column(name = "PAD_TRANS_DR")
	private Double padTransDr = 0d;

	@Column(name = "PAD_MUMB_LOAN_CR")
	private Double padMumbLoanCr = 0d;

	@Column(name = "PAD_MUMB_LOAN_DR")
	private Double padMumbLoanDr = 0d;

	@Column(name = "PRE_PART_DEC_TAX")
	private Double prePartDecTax = 0d;

	@Column(name = "NET_IGA_ADJUSTMNT")
	private Double netIgaAdjustment = 0d;

	@Column(name = "TOT_IGA_CR")
	private Double totIgaCr = 0d;

	@Column(name = "TOT_IGA_DR")
	private Double totIgaDr = 0d;

	@Column(name = "WMA_ADVANCES")
	private Double wmaAdvances = 0d;

	@Column(name = "MATURITY_TBILL")
	private Double maturityTBill = 0d;

	@Column(name = "REDISCOUNT_TBILL")
	private Double rediscountTBill = 0d;

	@Column(name = "TBILL_INVESTMENT")
	private Double tBillInvestment = 0d;

	@Column(name = "WMA_REPAYMENT")
	private Double wmaRepayment = 0d;

	@Column(name = "TBILL_HOLDINGS")
	private Double tBillHoldings = 0d;

	@Column(name = "WMA_OUTSTANDING")
	private Double wmaOutstandings = 0d;

	@Column(name = "SPL_DRAW_LIMIT")
	private Double splDrawLimit = 0d;

	@Column(name = "NORML_WMA_LIMIT")
	private Double normalWmaLimit = 0d;

	@Column(name = "AVAIL_OD_AMT")
	private Double availOdAmt = 0d;

	@Column(name = "TOT_SHEET_AMT")
	private Double totSheetAmt = 0d;

	@Column(name = "CLOS_MIN_BAL")
	private Double closMinBal = 0d;

	@Column(name = "TBILL_14D_BAL")
	private Double tBill14DBal = 0d;

	@Column(name = "IS_PROCESSED")
	private int isProcessed;

	@Column(name = "FINANCIAL_YEAR")
	private String financialYear;

	@Column(name = "DP_SHEET_DT")
	private LocalDate dpSheetDate;

	public DMODPSheetHDREntity() {
		super();
	}

	public DMODPSheetHDREntity(Long id) {
		super();
		this.dpSheetId = id;
	}

	public Long getDpSheetId() {
		return dpSheetId;
	}

	public void setDpSheetId(Long dpSheetId) {
		this.dpSheetId = dpSheetId;
	}

	public LocalDate getDpSheetReciveDate() {
		return dpSheetReciveDate;
	}

	public void setDpSheetReciveDate(LocalDate dpSheetReciveDate) {
		this.dpSheetReciveDate = dpSheetReciveDate;
	}

	public List<DMODPSheetEntryEntity> getEntities() {
		if (entities == null) {
			entities = new ArrayList<>(0);
		}
		return entities;
	}

	public void setEntities(List<DMODPSheetEntryEntity> entities) {
		this.entities = entities;
	}

	public int getGogCode() {
		return gogCode;
	}

	public void setGogCode(int gogCode) {
		this.gogCode = gogCode;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	public Double getOpenBalCr() {
		return openBalCr;
	}

	public void setOpenBalCr(Double openBalCr) {
		this.openBalCr = openBalCr;
	}

	public Double getOpenBalDr() {
		return openBalDr;
	}

	public void setOpenBalDr(Double openBalDr) {
		this.openBalDr = openBalDr;
	}

	public Double getPadMumbGstCr() {
		return padMumbGstCr;
	}

	public void setPadMumbGstCr(Double padMumbGstCr) {
		this.padMumbGstCr = padMumbGstCr;
	}

	public Double getPadMumbGstDr() {
		return padMumbGstDr;
	}

	public void setPadMumbGstDr(Double padMumbGstDr) {
		this.padMumbGstDr = padMumbGstDr;
	}

	public Double getAgencyBankCr() {
		return agencyBankCr;
	}

	public void setAgencyBankCr(Double agencyBankCr) {
		this.agencyBankCr = agencyBankCr;
	}

	public Double getAgencyBankDr() {
		return agencyBankDr;
	}

	public void setAgencyBankDr(Double agencyBankDr) {
		this.agencyBankDr = agencyBankDr;
	}

	public Double getPadTransCr() {
		return padTransCr;
	}

	public void setPadTransCr(Double padTransCr) {
		this.padTransCr = padTransCr;
	}

	public Double getPadTransDr() {
		return padTransDr;
	}

	public void setPadTransDr(Double padTransDr) {
		this.padTransDr = padTransDr;
	}

	public Double getPadMumbLoanCr() {
		return padMumbLoanCr;
	}

	public void setPadMumbLoanCr(Double padMumbLoanCr) {
		this.padMumbLoanCr = padMumbLoanCr;
	}

	public Double getPadMumbLoanDr() {
		return padMumbLoanDr;
	}

	public void setPadMumbLoanDr(Double padMumbLoanDr) {
		this.padMumbLoanDr = padMumbLoanDr;
	}

	public Double getPrePartDecTax() {
		return prePartDecTax;
	}

	public void setPrePartDecTax(Double prePartDecTax) {
		this.prePartDecTax = prePartDecTax;
	}

	public Double getNetIgaAdjustment() {
		return netIgaAdjustment;
	}

	public void setNetIgaAdjustment(Double netIgaAdjustment) {
		this.netIgaAdjustment = netIgaAdjustment;
	}

	public Double getTotIgaCr() {
		return totIgaCr;
	}

	public void setTotIgaCr(Double totIgaCr) {
		this.totIgaCr = totIgaCr;
	}

	public Double getTotIgaDr() {
		return totIgaDr;
	}

	public void setTotIgaDr(Double totIgaDr) {
		this.totIgaDr = totIgaDr;
	}

	public Double getWmaAdvances() {
		return wmaAdvances;
	}

	public void setWmaAdvances(Double wmaAdvances) {
		this.wmaAdvances = wmaAdvances;
	}

	public Double getMaturityTBill() {
		return maturityTBill;
	}

	public void setMaturityTBill(Double maturityTBill) {
		this.maturityTBill = maturityTBill;
	}

	public Double getRediscountTBill() {
		return rediscountTBill;
	}

	public void setRediscountTBill(Double rediscountTBill) {
		this.rediscountTBill = rediscountTBill;
	}

	public Double gettBillInvestment() {
		return tBillInvestment;
	}

	public void settBillInvestment(Double tBillInvestment) {
		this.tBillInvestment = tBillInvestment;
	}

	public Double getWmaRepayment() {
		return wmaRepayment;
	}

	public void setWmaRepayment(Double wmaRepayment) {
		this.wmaRepayment = wmaRepayment;
	}

	public Double gettBillHoldings() {
		return tBillHoldings;
	}

	public void settBillHoldings(Double tBillHoldings) {
		this.tBillHoldings = tBillHoldings;
	}

	public Double getWmaOutstandings() {
		return wmaOutstandings;
	}

	public void setWmaOutstandings(Double wmaOutstandings) {
		this.wmaOutstandings = wmaOutstandings;
	}

	public Double getSplDrawLimit() {
		return splDrawLimit;
	}

	public void setSplDrawLimit(Double splDrawLimit) {
		this.splDrawLimit = splDrawLimit;
	}

	public Double getNormalWmaLimit() {
		return normalWmaLimit;
	}

	public void setNormalWmaLimit(Double normalWmaLimit) {
		this.normalWmaLimit = normalWmaLimit;
	}

	public Double getAvailOdAmt() {
		return availOdAmt;
	}

	public void setAvailOdAmt(Double availOdAmt) {
		this.availOdAmt = availOdAmt;
	}

	public Double getTotSheetAmt() {
		return totSheetAmt;
	}

	public void setTotSheetAmt(Double totSheetAmt) {
		this.totSheetAmt = totSheetAmt;
	}

	public Double getClosMinBal() {
		return closMinBal;
	}

	public void setClosMinBal(Double closMinBal) {
		this.closMinBal = closMinBal;
	}

	public Double gettBill14DBal() {
		return tBill14DBal;
	}

	public void settBill14DBal(Double tBill14DBal) {
		this.tBill14DBal = tBill14DBal;
	}

	public int getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(int isProcessed) {
		this.isProcessed = isProcessed;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public LocalDate getDpSheetDate() {
		return dpSheetDate;
	}

	public void setDpSheetDate(LocalDate dpSheetDate) {
		this.dpSheetDate = dpSheetDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencyBankCr, agencyBankDr, availOdAmt, closMinBal, dpSheetDate, dpSheetReciveDate,
				entities, financialYear, gogCode, dpSheetId, isProcessed, maturityTBill, memoNo, netIgaAdjustment,
				normalWmaLimit, openBalCr, openBalDr, padMumbGstCr, padMumbGstDr, padMumbLoanCr, padMumbLoanDr,
				padTransCr, padTransDr, prePartDecTax, rediscountTBill, refDate, refNo, splDrawLimit, tBill14DBal,
				tBillHoldings, tBillInvestment, totIgaCr, totIgaDr, totSheetAmt, wmaAdvances, wmaOutstandings,
				wmaRepayment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DMODPSheetHDREntity other = (DMODPSheetHDREntity) obj;
		return Objects.equals(agencyBankCr, other.agencyBankCr) && Objects.equals(agencyBankDr, other.agencyBankDr)
				&& Objects.equals(availOdAmt, other.availOdAmt) && Objects.equals(closMinBal, other.closMinBal)
				&& Objects.equals(dpSheetDate, other.dpSheetDate)
				&& Objects.equals(dpSheetReciveDate, other.dpSheetReciveDate)
				&& Objects.equals(entities, other.entities) && Objects.equals(financialYear, other.financialYear)
				&& gogCode == other.gogCode && Objects.equals(dpSheetId, other.dpSheetId)
				&& isProcessed == other.isProcessed && Objects.equals(maturityTBill, other.maturityTBill)
				&& Objects.equals(memoNo, other.memoNo) && Objects.equals(netIgaAdjustment, other.netIgaAdjustment)
				&& Objects.equals(normalWmaLimit, other.normalWmaLimit) && Objects.equals(openBalCr, other.openBalCr)
				&& Objects.equals(openBalDr, other.openBalDr) && Objects.equals(padMumbGstCr, other.padMumbGstCr)
				&& Objects.equals(padMumbGstDr, other.padMumbGstDr)
				&& Objects.equals(padMumbLoanCr, other.padMumbLoanCr)
				&& Objects.equals(padMumbLoanDr, other.padMumbLoanDr) && Objects.equals(padTransCr, other.padTransCr)
				&& Objects.equals(padTransDr, other.padTransDr) && Objects.equals(prePartDecTax, other.prePartDecTax)
				&& Objects.equals(rediscountTBill, other.rediscountTBill) && Objects.equals(refDate, other.refDate)
				&& Objects.equals(refNo, other.refNo) && Objects.equals(splDrawLimit, other.splDrawLimit)
				&& Objects.equals(tBill14DBal, other.tBill14DBal) && Objects.equals(tBillHoldings, other.tBillHoldings)
				&& Objects.equals(tBillInvestment, other.tBillInvestment) && Objects.equals(totIgaCr, other.totIgaCr)
				&& Objects.equals(totIgaDr, other.totIgaDr) && Objects.equals(totSheetAmt, other.totSheetAmt)
				&& Objects.equals(wmaAdvances, other.wmaAdvances)
				&& Objects.equals(wmaOutstandings, other.wmaOutstandings)
				&& Objects.equals(wmaRepayment, other.wmaRepayment);
	}

}

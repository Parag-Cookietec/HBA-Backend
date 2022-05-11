package gov.ifms.gst.dto;

import java.util.List;

public class EODCINFileReportDto {

	public List<EODCINFileDataDto> eodCinFileData;
	private String bankCd;
	private Double totalSgstTax = 0.00;
	private Double totalSgstIntr = 0.00;
	private Double totalSgstFee = 0.00;
	private Double totalSgstPenalty = 0.00;
	private Double totalSgstOth = 0.00;
	private Double totalSgstTotal = 0.00;
	public List<EODCINFileDataDto> getEodCinFileData() {
		return eodCinFileData;
	}
	public void setEodCinFileData(List<EODCINFileDataDto> eodCinFileData) {
		this.eodCinFileData = eodCinFileData;
	}
	public Double getTotalSgstTax() {
		return totalSgstTax;
	}
	public void setTotalSgstTax(Double totalSgstTax) {
		this.totalSgstTax = totalSgstTax;
	}
	public Double getTotalSgstIntr() {
		return totalSgstIntr;
	}
	public void setTotalSgstIntr(Double totalSgstIntr) {
		this.totalSgstIntr = totalSgstIntr;
	}
	public Double getTotalSgstFee() {
		return totalSgstFee;
	}
	public void setTotalSgstFee(Double totalSgstFee) {
		this.totalSgstFee = totalSgstFee;
	}
	public Double getTotalSgstPenalty() {
		return totalSgstPenalty;
	}
	public void setTotalSgstPenalty(Double totalSgstPenalty) {
		this.totalSgstPenalty = totalSgstPenalty;
	}
	public Double getTotalSgstOth() {
		return totalSgstOth;
	}
	public void setTotalSgstOth(Double totalSgstOth) {
		this.totalSgstOth = totalSgstOth;
	}
	public String getBankCd() {
		return bankCd;
	}
	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}
	public Double getTotalSgstTotal() {
		return totalSgstTotal;
	}
	public void setTotalSgstTotal(Double totalSgstTotal) {
		this.totalSgstTotal = totalSgstTotal;
	}

}

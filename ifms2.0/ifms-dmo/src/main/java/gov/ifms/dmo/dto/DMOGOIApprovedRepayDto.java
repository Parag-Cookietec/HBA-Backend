package gov.ifms.dmo.dto;

import java.util.ArrayList;
import java.util.List;

public class DMOGOIApprovedRepayDto {

	private Long schemeWiseTotal;
	private Double schemeTotalPayPri;
	private Double totalPayPri;
	private Double grandTotalPayPri;
	private Double schemeTotalPayInt;
	private Double totalPayInt;
	private Double grandTotalPayInt;
	private Double schemeTotalPaidPri;
	private Double totalPaidPri;
	private Double grandTotalPaidPri;
	private Double schemeTotalPaidInt;
	private Double totalPaidInt;
	private Double grandTotalPaidInt;
	private List<DMOGOILoanDataDto> dmogoiLoanDataDtos = new ArrayList<>();
	private List<DMODPDataDto> dmodpDataDtos = new ArrayList<>();
	public Long getSchemeWiseTotal() {
		return schemeWiseTotal;
	}
	public void setSchemeWiseTotal(Long schemeWiseTotal) {
		this.schemeWiseTotal = schemeWiseTotal;
	}
	public Double getSchemeTotalPayPri() {
		return schemeTotalPayPri;
	}
	public void setSchemeTotalPayPri(Double schemeTotalPayPri) {
		this.schemeTotalPayPri = schemeTotalPayPri;
	}
	public Double getTotalPayPri() {
		return totalPayPri;
	}
	public void setTotalPayPri(Double totalPayPri) {
		this.totalPayPri = totalPayPri;
	}
	public Double getGrandTotalPayPri() {
		return grandTotalPayPri;
	}
	public void setGrandTotalPayPri(Double grandTotalPayPri) {
		this.grandTotalPayPri = grandTotalPayPri;
	}
	public Double getSchemeTotalPayInt() {
		return schemeTotalPayInt;
	}
	public void setSchemeTotalPayInt(Double schemeTotalPayInt) {
		this.schemeTotalPayInt = schemeTotalPayInt;
	}
	public Double getTotalPayInt() {
		return totalPayInt;
	}
	public void setTotalPayInt(Double totalPayInt) {
		this.totalPayInt = totalPayInt;
	}
	public Double getGrandTotalPayInt() {
		return grandTotalPayInt;
	}
	public void setGrandTotalPayInt(Double grandTotalPayInt) {
		this.grandTotalPayInt = grandTotalPayInt;
	}
	public Double getSchemeTotalPaidPri() {
		return schemeTotalPaidPri;
	}
	public void setSchemeTotalPaidPri(Double schemeTotalPaidPri) {
		this.schemeTotalPaidPri = schemeTotalPaidPri;
	}
	public Double getTotalPaidPri() {
		return totalPaidPri;
	}
	public void setTotalPaidPri(Double totalPaidPri) {
		this.totalPaidPri = totalPaidPri;
	}
	public Double getGrandTotalPaidPri() {
		return grandTotalPaidPri;
	}
	public void setGrandTotalPaidPri(Double grandTotalPaidPri) {
		this.grandTotalPaidPri = grandTotalPaidPri;
	}
	public Double getSchemeTotalPaidInt() {
		return schemeTotalPaidInt;
	}
	public void setSchemeTotalPaidInt(Double schemeTotalPaidInt) {
		this.schemeTotalPaidInt = schemeTotalPaidInt;
	}
	public Double getTotalPaidInt() {
		return totalPaidInt;
	}
	public void setTotalPaidInt(Double totalPaidInt) {
		this.totalPaidInt = totalPaidInt;
	}
	public Double getGrandTotalPaidInt() {
		return grandTotalPaidInt;
	}
	public void setGrandTotalPaidInt(Double grandTotalPaidInt) {
		this.grandTotalPaidInt = grandTotalPaidInt;
	}
	public List<DMOGOILoanDataDto> getDmogoiLoanDataDtos() {
		return dmogoiLoanDataDtos;
	}
	public void setDmogoiLoanDataDtos(List<DMOGOILoanDataDto> dmogoiLoanDataDtos) {
		this.dmogoiLoanDataDtos = dmogoiLoanDataDtos;
	}
	public List<DMODPDataDto> getDmodpDataDtos() {
		return dmodpDataDtos;
	}
	public void setDmodpDataDtos(List<DMODPDataDto> dmodpDataDtos) {
		this.dmodpDataDtos = dmodpDataDtos;
	}
	
	
}

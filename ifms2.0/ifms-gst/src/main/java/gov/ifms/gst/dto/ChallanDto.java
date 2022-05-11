package gov.ifms.gst.dto;

import gov.ifms.gst.entity.ChallanDistributionSADA;

public class ChallanDto {
	private ChallanDistributionSADA challan;
	private String employeee;

	public ChallanDistributionSADA getChallan() {
		return challan;
	}

	public void setChallan(ChallanDistributionSADA challan) {
		this.challan = challan;
	}

	public String getEmployeee() {
		return employeee;
	}

	public void setEmployeee(String employeee) {
		this.employeee = employeee;
	}
}

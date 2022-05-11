package gov.ifms.pvu.dto;

public class PayBandIdAndEnteryPayValueDto {

	String deptId;
	
	String payBand;

	String enteryPay;

	String gradePay;

	
	
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPayBand() {
		return payBand;
	}

	public void setPayBand(String payBand) {
		this.payBand = payBand;
	}

	public String getEnteryPay() {
		return enteryPay;
	}

	public void setEnteryPay(String enteryPay) {
		this.enteryPay = enteryPay;
	}

	public String getGradePay() {
		return gradePay;
	}

	public void setGradePay(String gradePay) {
		this.gradePay = gradePay;
	}

	public PayBandIdAndEnteryPayValueDto() {
	}

	public PayBandIdAndEnteryPayValueDto( String enteryPay, String gradePay,String payBand,String deptId) {
		this.payBand = payBand;
		this.enteryPay = enteryPay;
		this.gradePay = gradePay;
		this.deptId=deptId;
	}

}

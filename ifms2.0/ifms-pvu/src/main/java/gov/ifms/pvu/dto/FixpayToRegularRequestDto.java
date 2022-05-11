package gov.ifms.pvu.dto;

public class FixpayToRegularRequestDto {
	
	Long deptCatId;
	
	Long fixPay;
	
	Long fixPayId;
	
	Long payBandId;
	
	Long gradepayid;
	
	Long payLevel;

	public Long getFixPayId() {
		return fixPayId;
	}

	public void setFixPayId(Long fixPayId) {
		this.fixPayId = fixPayId;
	}

	public Long getDeptCatId() {
		return deptCatId;
	}

	public void setDeptCatId(Long deptCatId) {
		this.deptCatId = deptCatId;
	}

	public Long getFixPay() {
		return fixPay;
	}

	public void setFixPay(Long fixPay) {
		this.fixPay = fixPay;
	}

	public Long getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(Long payBandId) {
		this.payBandId = payBandId;
	}

	public Long getGradepayid() {
		return gradepayid;
	}

	public void setGradepayid(Long gradepayid) {
		this.gradepayid = gradepayid;
	}

	public Long getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(Long payLevel) {
		this.payLevel = payLevel;
	}
	
	

}

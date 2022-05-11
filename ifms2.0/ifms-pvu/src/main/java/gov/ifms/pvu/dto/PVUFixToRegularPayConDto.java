package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUFixToRegularPayConDto.
 * 
 * @version 1.0
 * @created 2021/04/11 14:05:32
 *
 */
public class PVUFixToRegularPayConDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long fixRegDsId;

	private Long officeId;

	private Long empId;

	private Long fyId;

	private String trnNo;

	private Date refDate;

	private String convOrderNo;

	private Date convEffDate;

	private Date convOrderDate;

	private Long empPayType;

	private Long cFixPay;

	private Long payComm;

	private Double basicPay;

	private Long payLevel;

	private Long cellId;

	private Long gradePay;

	private Long payBand;

	private Long payBandValue;

	private Long payScale;

	private Date nextIncrDate;

	private long statusId;
	
	private String action;
	
	private Long basicPayComm6;
	
	private String officeName;
	
	private Long employeeNo;
	
	private Date nxtIncrDate6;


	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public Long getcFixPay() {
		return cFixPay;
	}

	public void setcFixPay(Long cFixPay) {
		this.cFixPay = cFixPay;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * PVUFixToRegularPayConDto Constructor
	 */
	public PVUFixToRegularPayConDto() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(fixRegDsId, officeId, empId, fyId, trnNo, refDate, convOrderNo, convEffDate, convOrderDate,
				empPayType, cFixPay, payComm, basicPay, payLevel, cellId, gradePay, payBand, payBandValue, payScale,
				nextIncrDate, statusId);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUFixToRegularPayConDto)) {
			return false;
		}

		PVUFixToRegularPayConDto other = (PVUFixToRegularPayConDto) obj;

		return Objects.equals(fixRegDsId, other.fixRegDsId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(empId, other.empId) && Objects.equals(fyId, other.fyId)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(refDate, other.refDate)
				&& Objects.equals(convOrderNo, other.convOrderNo) && Objects.equals(convEffDate, other.convEffDate)
				&& Objects.equals(convOrderDate, other.convOrderDate) && Objects.equals(empPayType, other.empPayType)
				&& Objects.equals(cFixPay, other.cFixPay) && Objects.equals(payComm, other.payComm)
				&& Objects.equals(basicPay, other.basicPay) && Objects.equals(payLevel, other.payLevel)
				&& Objects.equals(cellId, other.cellId) && Objects.equals(gradePay, other.gradePay)
				&& Objects.equals(payBand, other.payBand) && Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(payScale, other.payScale) && Objects.equals(nextIncrDate, other.nextIncrDate)
				&& statusId == other.statusId;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "PVUFixToRegularPayConDto [fixRegDsId = " + fixRegDsId + ",officeId = " + officeId + ",empId = " + empId
				+ ",fyId = " + fyId + ",trnNo = " + trnNo + ",refDate = " + refDate + ",convOrderNo = " + convOrderNo
				+ ",convEffDate = " + convEffDate + ",convOrderDate = " + convOrderDate + ",empPayType = " + empPayType
				+ ",cFixPay = " + cFixPay + ",payComm = " + payComm + ",basicPay = " + basicPay + ",payLevel = "
				+ payLevel + ",cellId = " + cellId + ",gradePay = " + gradePay + ",payBand = " + payBand
				+ ",payBandValue = " + payBandValue + ",payScale = " + payScale + ",nextIncrDate = " + nextIncrDate
				+ ",statusId = " + statusId + ",]";
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the fixRegDsId
	 */
	public Long getFixRegDsId() {
		return fixRegDsId;
	}

	/**
	 * @param fixRegDsId the fixRegDsId to set
	 */
	public void setFixRegDsId(Long fixRegDsId) {
		this.fixRegDsId = fixRegDsId;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the fyId
	 */
	public Long getFyId() {
		return fyId;
	}

	/**
	 * @param fyId the fyId to set
	 */
	public void setFyId(Long fyId) {
		this.fyId = fyId;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the refDate
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	/**
	 * @return the convOrderNo
	 */
	public String getConvOrderNo() {
		return convOrderNo;
	}

	/**
	 * @param convOrderNo the convOrderNo to set
	 */
	public void setConvOrderNo(String convOrderNo) {
		this.convOrderNo = convOrderNo;
	}

	/**
	 * @return the convEffDate
	 */
	public Date getConvEffDate() {
		return convEffDate;
	}

	/**
	 * @param convEffDate the convEffDate to set
	 */
	public void setConvEffDate(Date convEffDate) {
		this.convEffDate = convEffDate;
	}

	/**
	 * @return the convOrderDate
	 */
	public Date getConvOrderDate() {
		return convOrderDate;
	}

	/**
	 * @param convOrderDate the convOrderDate to set
	 */
	public void setConvOrderDate(Date convOrderDate) {
		this.convOrderDate = convOrderDate;
	}

	/**
	 * @return the empPayType
	 */
	public Long getEmpPayType() {
		return empPayType;
	}

	/**
	 * @param empPayType the empPayType to set
	 */
	public void setEmpPayType(Long empPayType) {
		this.empPayType = empPayType;
	}

	/**
	 * @return the cFixPay
	 */
	public Long getCFixPay() {
		return cFixPay;
	}

	/**
	 * @param cFixPay the cFixPay to set
	 */
	public void setCFixPay(Long cFixPay) {
		this.cFixPay = cFixPay;
	}

	/**
	 * @return the payComm
	 */
	public Long getPayComm() {
		return payComm;
	}

	/**
	 * @param payComm the payComm to set
	 */
	public void setPayComm(Long payComm) {
		this.payComm = payComm;
	}

	/**
	 * @return the basicPay
	 */
	public Double getBasicPay() {
		return basicPay;
	}

	/**
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * @return the payLevel
	 */
	public Long getPayLevel() {
		return payLevel;
	}

	/**
	 * @param payLevel the payLevel to set
	 */
	public void setPayLevel(Long payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * @return the cellId
	 */
	public Long getCellId() {
		return cellId;
	}

	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(Long cellId) {
		this.cellId = cellId;
	}

	/**
	 * @return the gradePay
	 */
	public Long getGradePay() {
		return gradePay;
	}

	/**
	 * @param gradePay the gradePay to set
	 */
	public void setGradePay(Long gradePay) {
		this.gradePay = gradePay;
	}

	/**
	 * @return the payBand
	 */
	public Long getPayBand() {
		return payBand;
	}

	/**
	 * @param payBand the payBand to set
	 */
	public void setPayBand(Long payBand) {
		this.payBand = payBand;
	}

	/**
	 * @return the payBandValue
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * @return the payScale
	 */
	public Long getPayScale() {
		return payScale;
	}

	/**
	 * @param payScale the payScale to set
	 */
	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	/**
	 * @return the nextIncrDate
	 */
	public Date getNextIncrDate() {
		return nextIncrDate;
	}

	/**
	 * @param nextIncrDate the nextIncrDate to set
	 */
	public void setNextIncrDate(Date nextIncrDate) {
		this.nextIncrDate = nextIncrDate;
	}

	/**
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the basicPayComm6
	 */
	public Long getBasicPayComm6() {
		return basicPayComm6;
	}

	/**
	 * @param basicPayComm6 the basicPayComm6 to set
	 */
	public void setBasicPayComm6(Long basicPayComm6) {
		this.basicPayComm6 = basicPayComm6;
	}

	/**
	 * @return the nxtIncrDate6
	 */
	public Date getNxtIncrDate6() {
		return nxtIncrDate6;
	}

	/**
	 * @param nxtIncrDate6 the nxtIncrDate6 to set
	 */
	public void setNxtIncrDate6(Date nxtIncrDate6) {
		this.nxtIncrDate6 = nxtIncrDate6;
	}

	
}

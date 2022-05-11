package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;


/**
 * The Class PVUMsPayCellDto.
 *
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 */
@NativeQueryResultEntity
public class PVUReversionPayLelevView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private long empId;

	/** The cell id. */
	@NativeQueryResultColumn(index = 1)
	private String event_name;

	/** The pay band id. */
	@NativeQueryResultColumn(index = 2)
	private String dateJoin;

	/** The grade pay id. */
	@NativeQueryResultColumn(index = 3)
	private String eventDate;

	/** The pay level id. */
	@NativeQueryResultColumn(index = 4)
	private long basicPay;

	/** The cell value. */
	@NativeQueryResultColumn(index = 5)
	private long payComm;

	/** The cell value. */
	@NativeQueryResultColumn(index = 6)
	private String cellId;

	/** The cell value. */
	@NativeQueryResultColumn(index = 7)
	private String paylevel;

	/** The cell value. */
	@NativeQueryResultColumn(index = 8)
	private String gradePay;

	/** The pay band value. */
	@NativeQueryResultColumn(index = 9)
	private String payBandValue;

	/** The pay band. */
	@NativeQueryResultColumn(index = 10)
	private String payBand;

	/** The c id. */
	@NativeQueryResultColumn(index = 11)
	private String cId;

	/** The pay level id. */
	@NativeQueryResultColumn(index = 12)
	private String payLevelId;

	/** The grad pay id. */
	@NativeQueryResultColumn(index = 13)
	private String gradPayId;

	/** The pay band id. */
	@NativeQueryResultColumn(index = 14)
	private String payBandId;

	/** The class id. */
	@NativeQueryResultColumn(index = 15)
	private String classId;

	/** The designation id. */
	@NativeQueryResultColumn(index = 16)
	private String designationId;

	/** The pay scal id. */
	@NativeQueryResultColumn(index = 17)
	private String payScalId;

	/** The pay scal value. */
	@NativeQueryResultColumn(index = 18)
	private String payScalValue;
	
	/** The actual basic pay. */
	@NativeQueryResultColumn(index = 19)
	private String actualBasicPay;

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the event name
	 */
	public String getEvent_name() {
		return event_name;
	}

	/**
	 * Sets the event name.
	 *
	 * @param event_name the new event name
	 */
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	/**
	 * Gets the date join.
	 *
	 * @return the date join
	 */
	public String getDateJoin() {
		return dateJoin;
	}

	/**
	 * Sets the date join.
	 *
	 * @param dateJoin the new date join
	 */
	public void setDateJoin(String dateJoin) {
		this.dateJoin = dateJoin;
	}

	/**
	 * Gets the event date.
	 *
	 * @return the event date
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * Sets the event date.
	 *
	 * @param eventDate the new event date
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basic pay
	 */
	public long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the new basic pay
	 */
	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the pay comm.
	 *
	 * @return the pay comm
	 */
	public long getPayComm() {
		return payComm;
	}

	/**
	 * Sets the pay comm.
	 *
	 * @param payComm the new pay comm
	 */
	public void setPayComm(long payComm) {
		this.payComm = payComm;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cell id
	 */
	public String getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the new cell id
	 */
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the paylevel.
	 *
	 * @return the paylevel
	 */
	public String getPaylevel() {
		return paylevel;
	}

	/**
	 * Sets the paylevel.
	 *
	 * @param paylevel the new paylevel
	 */
	public void setPaylevel(String paylevel) {
		this.paylevel = paylevel;
	}

	/**
	 * Gets the grade pay.
	 *
	 * @return the grade pay
	 */
	public String getGradePay() {
		return gradePay;
	}

	/**
	 * Sets the grade pay.
	 *
	 * @param gradePay the new grade pay
	 */
	public void setGradePay(String gradePay) {
		this.gradePay = gradePay;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the pay band value
	 */
	public String getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the new pay band value
	 */
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the c id.
	 *
	 * @return the c id
	 */
	public String getcId() {
		return cId;
	}

	/**
	 * Sets the c id.
	 *
	 * @param cId the new c id
	 */
	public void setcId(String cId) {
		this.cId = cId;
	}

	/**
	 * Gets the pay level id.
	 *
	 * @return the pay level id
	 */
	public String getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level id.
	 *
	 * @param payLevelId the new pay level id
	 */
	public void setPayLevelId(String payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the grad pay id.
	 *
	 * @return the grad pay id
	 */
	public String getGradPayId() {
		return gradPayId;
	}

	/**
	 * Sets the grad pay id.
	 *
	 * @param gradPayId the new grad pay id
	 */
	public void setGradPayId(String gradPayId) {
		this.gradPayId = gradPayId;
	}

	/**
	 * Gets the pay band.
	 *
	 * @return the pay band
	 */
	public String getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the new pay band
	 */
	public void setPayBand(String payBand) {
		this.payBand = payBand;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the pay band id
	 */
	public String getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the new pay band id
	 */
	public void setPayBandId(String payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Gets the class id.
	 *
	 * @return the class id
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the new class id
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designation id
	 */
	public String getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the new designation id
	 */
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the pay scal id.
	 *
	 * @return the payScalId
	 */
	public String getPayScalId() {
		return payScalId;
	}

	/**
	 * Sets the pay scal id.
	 *
	 * @param payScalId the payScalId to set
	 */
	public void setPayScalId(String payScalId) {
		this.payScalId = payScalId;
	}

	/**
	 * Gets the pay scal value.
	 *
	 * @return the payScalValue
	 */
	public String getPayScalValue() {
		return payScalValue;
	}

	/**
	 * Sets the pay scal value.
	 *
	 * @param payScalValue the payScalValue to set
	 */
	public void setPayScalValue(String payScalValue) {
		this.payScalValue = payScalValue;
	}

	/**
	 * Gets the actual basic pay.
	 *
	 * @return the actual basic pay
	 */
	public String getActualBasicPay() {
		return actualBasicPay;
	}

	/**
	 * Sets the actual basic pay.
	 *
	 * @param actualBasicPay the new actual basic pay
	 */
	public void setActualBasicPay(String actualBasicPay) {
		this.actualBasicPay = actualBasicPay;
	}
	
	

}

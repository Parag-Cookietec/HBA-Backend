package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAdviceVerifyAuthSearchParam.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocAdviceVerifyAuthSearchParam implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The wf status.
	 */
	@NativeQueryResultColumn(index = 0)
	private String wfStatus;

	/**
	 * The status id.
	 */
	@NativeQueryResultColumn(index = 1)
	private Long statusId;

	/**
	 * The status name.
	 */
	@NativeQueryResultColumn(index = 2)
	private String statusName;

	/** The div id. */
	@NativeQueryResultColumn(index = 3)
	private Long divId;

	/** The div code. */
	@NativeQueryResultColumn(index = 4)
	private String divCode;

	/** The div name. */
	@NativeQueryResultColumn(index = 5)
	private String divName;

	/** The circle id. */
	@NativeQueryResultColumn(index = 6)
	private Long circleId;

	/** The circle name. */
	@NativeQueryResultColumn(index = 7)
	private String circleName;

	/** The circle code. */
	@NativeQueryResultColumn(index = 8)
	private String circleCode;

	/** The dept id. */
	@NativeQueryResultColumn(index = 9)
	private Long deptId;

	/** The dept name. */
	@NativeQueryResultColumn(index = 10)
	private String deptName;

	/** The payment id. */
	@NativeQueryResultColumn(index = 11)
	private Long paymentId;

	/** The payment name. */
	@NativeQueryResultColumn(index = 12)
	private String paymentName;
	/**
	 * The wf list.
	 */
	private List<LocAdviceVerifyAuthSearchParam> wfList;

	/**
	 * The status list.
	 */
	private List<LocAdviceVerifyAuthSearchParam> statusList;

	/** The circle code list. */
	private List<LocAdviceVerifyAuthSearchParam> circleCodeList;

	/** The circle name list. */
	private List<LocAdviceVerifyAuthSearchParam> circleNameList;

	/** The div code list. */
	private List<LocAdviceVerifyAuthSearchParam> divCodeList;

	/** The div name list. */
	private List<LocAdviceVerifyAuthSearchParam> divNameList;

	/** The dept list. */
	private List<LocAdviceVerifyAuthSearchParam> deptList;

	/** The payment type list. */
	private List<LocAdviceVerifyAuthSearchParam> paymentTypeList;

	/**
	 * Gets the wf status.
	 *
	 * @return the wf status
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the new wf status
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the status name.
	 *
	 * @return the status name
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * Sets the status name.
	 *
	 * @param statusName the new status name
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * Gets the wf list.
	 *
	 * @return the wf list
	 */
	public List<LocAdviceVerifyAuthSearchParam> getWfList() {
		return wfList;
	}

	/**
	 * Sets the wf list.
	 *
	 * @param wfList the new wf list
	 */
	public void setWfList(List<LocAdviceVerifyAuthSearchParam> wfList) {
		this.wfList = wfList;
	}

	/**
	 * Gets the status list.
	 *
	 * @return the status list
	 */
	public List<LocAdviceVerifyAuthSearchParam> getStatusList() {
		return statusList;
	}

	/**
	 * Sets the status list.
	 *
	 * @param statusList the new status list
	 */
	public void setStatusList(List<LocAdviceVerifyAuthSearchParam> statusList) {
		this.statusList = statusList;
	}

	/**
	 * Gets the div id.
	 *
	 * @return the div id
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the div code.
	 *
	 * @return the div code
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the new div code
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the div name
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the new div name
	 */
	public void setDivName(String divName) {
		this.divName = divName;
	}

	/**
	 * Gets the circle id.
	 *
	 * @return the circle id
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * Sets the circle id.
	 *
	 * @param circleId the new circle id
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	/**
	 * Gets the circle name.
	 *
	 * @return the circle name
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * Sets the circle name.
	 *
	 * @param circleName the new circle name
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	/**
	 * Gets the circle code.
	 *
	 * @return the circle code
	 */
	public String getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the new circle code
	 */
	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * Gets the dept id.
	 *
	 * @return the dept id
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * Sets the dept id.
	 *
	 * @param deptId the new dept id
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * Gets the dept name.
	 *
	 * @return the dept name
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * Sets the dept name.
	 *
	 * @param deptName the new dept name
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * Gets the payment id.
	 *
	 * @return the payment id
	 */
	public Long getPaymentId() {
		return paymentId;
	}

	/**
	 * Sets the payment id.
	 *
	 * @param paymentId the new payment id
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * Gets the payment name.
	 *
	 * @return the payment name
	 */
	public String getPaymentName() {
		return paymentName;
	}

	/**
	 * Sets the payment name.
	 *
	 * @param paymentName the new payment name
	 */
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	/**
	 * Gets the circle code list.
	 *
	 * @return the circle code list
	 */
	public List<LocAdviceVerifyAuthSearchParam> getCircleCodeList() {
		return circleCodeList;
	}

	/**
	 * Sets the circle code list.
	 *
	 * @param circleCodeList the new circle code list
	 */
	public void setCircleCodeList(List<LocAdviceVerifyAuthSearchParam> circleCodeList) {
		this.circleCodeList = circleCodeList;
	}

	/**
	 * Gets the circle name list.
	 *
	 * @return the circle name list
	 */
	public List<LocAdviceVerifyAuthSearchParam> getCircleNameList() {
		return circleNameList;
	}

	/**
	 * Sets the circle name list.
	 *
	 * @param circleNameList the new circle name list
	 */
	public void setCircleNameList(List<LocAdviceVerifyAuthSearchParam> circleNameList) {
		this.circleNameList = circleNameList;
	}

	/**
	 * Gets the div code list.
	 *
	 * @return the div code list
	 */
	public List<LocAdviceVerifyAuthSearchParam> getDivCodeList() {
		return divCodeList;
	}

	/**
	 * Sets the div code list.
	 *
	 * @param divCodeList the new div code list
	 */
	public void setDivCodeList(List<LocAdviceVerifyAuthSearchParam> divCodeList) {
		this.divCodeList = divCodeList;
	}

	/**
	 * Gets the div name list.
	 *
	 * @return the div name list
	 */
	public List<LocAdviceVerifyAuthSearchParam> getDivNameList() {
		return divNameList;
	}

	/**
	 * Sets the div name list.
	 *
	 * @param divNameList the new div name list
	 */
	public void setDivNameList(List<LocAdviceVerifyAuthSearchParam> divNameList) {
		this.divNameList = divNameList;
	}

	/**
	 * Gets the dept list.
	 *
	 * @return the dept list
	 */
	public List<LocAdviceVerifyAuthSearchParam> getDeptList() {
		return deptList;
	}

	/**
	 * Sets the dept list.
	 *
	 * @param deptList the new dept list
	 */
	public void setDeptList(List<LocAdviceVerifyAuthSearchParam> deptList) {
		this.deptList = deptList;
	}

	/**
	 * Gets the payment type list.
	 *
	 * @return the payment type list
	 */
	public List<LocAdviceVerifyAuthSearchParam> getPaymentTypeList() {
		return paymentTypeList;
	}

	/**
	 * Sets the payment type list.
	 *
	 * @param paymentTypeList the new payment type list
	 */
	public void setPaymentTypeList(List<LocAdviceVerifyAuthSearchParam> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}
}

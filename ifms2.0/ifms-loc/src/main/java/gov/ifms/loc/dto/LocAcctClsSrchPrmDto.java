package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAcctClsSrchPrmDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocAcctClsSrchPrmDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The div id.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long divId;

	/**
	 * The div code.
	 */
	@NativeQueryResultColumn(index = 1)
	private String divCode;

	/**
	 * The div name.
	 */
	@NativeQueryResultColumn(index = 2)
	private String divName;

	/**
	 * The circle id.
	 */
	@NativeQueryResultColumn(index = 3)
	private Long circleId;

	/**
	 * The circle code.
	 */
	@NativeQueryResultColumn(index = 4)
	private String circleCode;

	/**
	 * The circle name.
	 */
	@NativeQueryResultColumn(index = 5)
	private String circleName;

	/**
	 * The status id.
	 */
	@NativeQueryResultColumn(index = 6)
	private Long statusId;

	/**
	 * The div name id.
	 */
	private Long divNameId;

	/**
	 * The circle name id.
	 */
	private Long circleNameId;

	/**
	 * The status name.
	 */
	@NativeQueryResultColumn(index = 7)
	private String statusName;

	/**
	 * The wf status.
	 */
	@NativeQueryResultColumn(index = 8)
	private String wfStatus;

	/** The district id. */
	@NativeQueryResultColumn(index = 9)
	private Long districtId;

	/** The district name. */
	@NativeQueryResultColumn(index = 10)
	private String districtName;

	/** The dept id. */
	@NativeQueryResultColumn(index = 11)
	private Long deptId;

	/** The dept name. */
	@NativeQueryResultColumn(index = 12)
	private String deptName;

	/**
	 * The div code list.
	 */
	private List<LocAcctClsSrchPrmDto> divCodeList;

	/**
	 * The div name list.
	 */
	private List<LocAcctClsSrchPrmDto> divNameList;

	/**
	 * The circle code list.
	 */
	private List<LocAcctClsSrchPrmDto> circleCodeList;

	/**
	 * The circle name list.
	 */
	private List<LocAcctClsSrchPrmDto> circleNameList;

	/**
	 * The status list.
	 */
	private List<LocAcctClsSrchPrmDto> statusList;

	/**
	 * The wf status list.
	 */
	private List<LocAcctClsSrchPrmDto> wfStatusList;

	/** The dist list. */
	private List<LocAcctClsSrchPrmDto> distList;

	/** The dept list. */
	private List<LocAcctClsSrchPrmDto> deptList;

	/**
	 * Gets the div code.
	 *
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the divName
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the divName to set
	 */
	public void setDivName(String divName) {
		this.divName = divName;
	}

	/**
	 * Gets the circle code.
	 *
	 * @return the circleCode
	 */
	public String getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the circleCode to set
	 */
	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * Gets the circle name.
	 *
	 * @return the circleName
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * Sets the circle name.
	 *
	 * @param circleName the circleName to set
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the status name.
	 *
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * Sets the status name.
	 *
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Gets the div code list.
	 *
	 * @return the divCodeList
	 */
	public List<LocAcctClsSrchPrmDto> getDivCodeList() {
		return divCodeList;
	}

	/**
	 * Sets the div code list.
	 *
	 * @param divCodeList the divCodeList to set
	 */
	public void setDivCodeList(List<LocAcctClsSrchPrmDto> divCodeList) {
		this.divCodeList = divCodeList;
	}

	/**
	 * Gets the div name list.
	 *
	 * @return the divNameList
	 */
	public List<LocAcctClsSrchPrmDto> getDivNameList() {
		return divNameList;
	}

	/**
	 * Sets the div name list.
	 *
	 * @param divNameList the divNameList to set
	 */
	public void setDivNameList(List<LocAcctClsSrchPrmDto> divNameList) {
		this.divNameList = divNameList;
	}

	/**
	 * Gets the circle code list.
	 *
	 * @return the circleCodeList
	 */
	public List<LocAcctClsSrchPrmDto> getCircleCodeList() {
		return circleCodeList;
	}

	/**
	 * Sets the circle code list.
	 *
	 * @param circleCodeList the circleCodeList to set
	 */
	public void setCircleCodeList(List<LocAcctClsSrchPrmDto> circleCodeList) {
		this.circleCodeList = circleCodeList;
	}

	/**
	 * Gets the circle name list.
	 *
	 * @return the circleNameList
	 */
	public List<LocAcctClsSrchPrmDto> getCircleNameList() {
		return circleNameList;
	}

	/**
	 * Sets the circle name list.
	 *
	 * @param circleNameList the circleNameList to set
	 */
	public void setCircleNameList(List<LocAcctClsSrchPrmDto> circleNameList) {
		this.circleNameList = circleNameList;
	}

	/**
	 * Gets the status list.
	 *
	 * @return the statusList
	 */
	public List<LocAcctClsSrchPrmDto> getStatusList() {
		return statusList;
	}

	/**
	 * Sets the status list.
	 *
	 * @param statusList the statusList to set
	 */
	public void setStatusList(List<LocAcctClsSrchPrmDto> statusList) {
		this.statusList = statusList;
	}

	/**
	 * Gets the wf status list.
	 *
	 * @return the wfStatusList
	 */
	public List<LocAcctClsSrchPrmDto> getWfStatusList() {
		return wfStatusList;
	}

	/**
	 * Sets the wf status list.
	 *
	 * @param wfStatusList the wfStatusList to set
	 */
	public void setWfStatusList(List<LocAcctClsSrchPrmDto> wfStatusList) {
		this.wfStatusList = wfStatusList;
	}

	/**
	 * Gets the div id.
	 *
	 * @return the divId
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the divId to set
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the circle id.
	 *
	 * @return the circleId
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * Sets the circle id.
	 *
	 * @param circleId the circleId to set
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	/**
	 * Gets the div name id.
	 *
	 * @return the divNameId
	 */
	public Long getDivNameId() {
		return divNameId;
	}

	/**
	 * Sets the div name id.
	 *
	 * @param divNameId the divNameId to set
	 */
	public void setDivNameId(Long divNameId) {
		this.divNameId = divNameId;
	}

	/**
	 * Gets the circle name id.
	 *
	 * @return the circleNameId
	 */
	public Long getCircleNameId() {
		return circleNameId;
	}

	/**
	 * Sets the circle name id.
	 *
	 * @param circleNameId the circleNameId to set
	 */
	public void setCircleNameId(Long circleNameId) {
		this.circleNameId = circleNameId;
	}

	/**
	 * Gets the dist list.
	 *
	 * @return the dist list
	 */
	public List<LocAcctClsSrchPrmDto> getDistList() {
		return distList;
	}

	/**
	 * Sets the dist list.
	 *
	 * @param distList the new dist list
	 */
	public void setDistList(List<LocAcctClsSrchPrmDto> distList) {
		this.distList = distList;
	}

	/**
	 * Gets the dept list.
	 *
	 * @return the dept list
	 */
	public List<LocAcctClsSrchPrmDto> getDeptList() {
		return deptList;
	}

	/**
	 * Sets the dept list.
	 *
	 * @param deptList the new dept list
	 */
	public void setDeptList(List<LocAcctClsSrchPrmDto> deptList) {
		this.deptList = deptList;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the district name
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the new district name
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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
}

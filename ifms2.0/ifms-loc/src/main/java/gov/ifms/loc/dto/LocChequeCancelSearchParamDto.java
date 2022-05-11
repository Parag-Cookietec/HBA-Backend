package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChequeCancelSearchParamDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocChequeCancelSearchParamDto implements Serializable {

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

	/**
	 * The wf list.
	 */
	private List<LocChequeCancelSearchParamDto> wfList;

	/**
	 * The status list.
	 */
	private List<LocChequeCancelSearchParamDto> statusList;

	/** The div name list. */
	private List<LocChequeCancelSearchParamDto> divNameList;

	/** The div code list. */
	private List<LocChequeCancelSearchParamDto> divCodeList;

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
	 * Gets the wf list.
	 *
	 * @return the wfList
	 */
	public List<LocChequeCancelSearchParamDto> getWfList() {
		return wfList;
	}

	/**
	 * Sets the wf list.
	 *
	 * @param wfList the wfList to set
	 */
	public void setWfList(List<LocChequeCancelSearchParamDto> wfList) {
		this.wfList = wfList;
	}

	/**
	 * Gets the status list.
	 *
	 * @return the statusList
	 */
	public List<LocChequeCancelSearchParamDto> getStatusList() {
		return statusList;
	}

	/**
	 * Sets the status list.
	 *
	 * @param statusList the statusList to set
	 */
	public void setStatusList(List<LocChequeCancelSearchParamDto> statusList) {
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
	 * Gets the div name list.
	 *
	 * @return the div name list
	 */
	public List<LocChequeCancelSearchParamDto> getDivNameList() {
		return divNameList;
	}

	/**
	 * Sets the div name list.
	 *
	 * @param divNameList the new div name list
	 */
	public void setDivNameList(List<LocChequeCancelSearchParamDto> divNameList) {
		this.divNameList = divNameList;
	}

	/**
	 * Gets the div code list.
	 *
	 * @return the div code list
	 */
	public List<LocChequeCancelSearchParamDto> getDivCodeList() {
		return divCodeList;
	}

	/**
	 * Sets the div code list.
	 *
	 * @param divCodeList the new div code list
	 */
	public void setDivCodeList(List<LocChequeCancelSearchParamDto> divCodeList) {
		this.divCodeList = divCodeList;
	}
}

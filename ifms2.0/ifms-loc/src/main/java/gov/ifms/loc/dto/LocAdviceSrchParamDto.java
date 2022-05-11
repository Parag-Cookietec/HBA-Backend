
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
public class LocAdviceSrchParamDto implements Serializable {

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

	/**
	 * The wf list.
	 */
	private List<LocAdviceSrchParamDto> wfList;

	/**
	 * The status list.
	 */
	private List<LocAdviceSrchParamDto> statusList;

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
	public List<LocAdviceSrchParamDto> getWfList() {
		return wfList;
	}

	/**
	 * Sets the wf list.
	 *
	 * @param wfList the new wf list
	 */
	public void setWfList(List<LocAdviceSrchParamDto> wfList) {
		this.wfList = wfList;
	}

	/**
	 * Gets the status list.
	 *
	 * @return the status list
	 */
	public List<LocAdviceSrchParamDto> getStatusList() {
		return statusList;
	}

	/**
	 * Sets the status list.
	 *
	 * @param statusList the new status list
	 */
	public void setStatusList(List<LocAdviceSrchParamDto> statusList) {
		this.statusList = statusList;
	}
}

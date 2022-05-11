package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;


/**
 * The Class LocChequeToChequeSearchDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocChequeToChequeSearchDto implements Serializable {
	

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
	private List<LocChequeToChequeSearchDto> wfList;

	/**
	 * The status list.
	 */
	private List<LocChequeToChequeSearchDto> statusList;

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<LocChequeToChequeSearchDto> getWfList() {
		return wfList;
	}

	public void setWfList(List<LocChequeToChequeSearchDto> wfList) {
		this.wfList = wfList;
	}

	public List<LocChequeToChequeSearchDto> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<LocChequeToChequeSearchDto> statusList) {
		this.statusList = statusList;
	}

	
	

}

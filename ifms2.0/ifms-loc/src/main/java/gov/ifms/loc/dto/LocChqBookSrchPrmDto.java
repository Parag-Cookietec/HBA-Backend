package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChqBookParamDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocChqBookSrchPrmDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The req type id.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long reqTypeId;

	/**
	 * The req type name.
	 */
	@NativeQueryResultColumn(index = 1)
	private String reqTypeName;

	/**
	 * The cheque type id.
	 */
	@NativeQueryResultColumn(index = 2)
	private Long chequeTypeId;

	/**
	 * The cheque type name.
	 */
	@NativeQueryResultColumn(index = 3)
	private String chequeTypeName;

	/**
	 * The status id.
	 */
	@NativeQueryResultColumn(index = 4)
	private Long statusId;

	/**
	 * The status name.
	 */
	@NativeQueryResultColumn(index = 5)
	private String statusName;

	/**
	 * The wf id.
	 */
	@NativeQueryResultColumn(index = 6)
	private Long wfId;

	/**
	 * The wf name.
	 */
	@NativeQueryResultColumn(index = 7)
	private String wfName;

	/** The div id. */
	@NativeQueryResultColumn(index = 8)
	private Long divId;

	/** The div code. */
	@NativeQueryResultColumn(index = 9)
	private String divCode;

	/** The div name. */
	@NativeQueryResultColumn(index = 10)
	private String divName;

	/** The div code list. */
	private List<LocChqBookSrchPrmDto> divCodeList;

	/** The div name list. */
	private List<LocChqBookSrchPrmDto> divNameList;

	/**
	 * The req type list.
	 */
	private List<LocChqBookSrchPrmDto> reqTypeList;

	/**
	 * The cheque type list.
	 */
	private List<LocChqBookSrchPrmDto> chequeTypeList;

	/**
	 * The status list.
	 */
	private List<LocChqBookSrchPrmDto> statusList;

	/**
	 * The wf list.
	 */
	private List<LocChqBookSrchPrmDto> wfList;

	/**
	 * Gets the req type id.
	 *
	 * @return the reqTypeId
	 */
	public Long getReqTypeId() {
		return reqTypeId;
	}

	/**
	 * Sets the req type id.
	 *
	 * @param reqTypeId the reqTypeId to set
	 */
	public void setReqTypeId(Long reqTypeId) {
		this.reqTypeId = reqTypeId;
	}

	/**
	 * Gets the req type name.
	 *
	 * @return the reqTypeName
	 */
	public String getReqTypeName() {
		return reqTypeName;
	}

	/**
	 * Sets the req type name.
	 *
	 * @param reqTypeName the reqTypeName to set
	 */
	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	/**
	 * Gets the cheque type id.
	 *
	 * @return the chequeTypeId
	 */
	public Long getChequeTypeId() {
		return chequeTypeId;
	}

	/**
	 * Sets the cheque type id.
	 *
	 * @param chequeTypeId the chequeTypeId to set
	 */
	public void setChequeTypeId(Long chequeTypeId) {
		this.chequeTypeId = chequeTypeId;
	}

	/**
	 * Gets the cheque type name.
	 *
	 * @return the chequeTypeName
	 */
	public String getChequeTypeName() {
		return chequeTypeName;
	}

	/**
	 * Sets the cheque type name.
	 *
	 * @param chequeTypeName the chequeTypeName to set
	 */
	public void setChequeTypeName(String chequeTypeName) {
		this.chequeTypeName = chequeTypeName;
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
	 * Gets the req type list.
	 *
	 * @return the reqTypeList
	 */
	public List<LocChqBookSrchPrmDto> getReqTypeList() {
		return reqTypeList;
	}

	/**
	 * Sets the req type list.
	 *
	 * @param reqTypeList the reqTypeList to set
	 */
	public void setReqTypeList(List<LocChqBookSrchPrmDto> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}

	/**
	 * Gets the cheque type list.
	 *
	 * @return the chequeTypeList
	 */
	public List<LocChqBookSrchPrmDto> getChequeTypeList() {
		return chequeTypeList;
	}

	/**
	 * Sets the cheque type list.
	 *
	 * @param chequeTypeList the chequeTypeList to set
	 */
	public void setChequeTypeList(List<LocChqBookSrchPrmDto> chequeTypeList) {
		this.chequeTypeList = chequeTypeList;
	}

	/**
	 * Gets the status list.
	 *
	 * @return the statusList
	 */
	public List<LocChqBookSrchPrmDto> getStatusList() {
		return statusList;
	}

	/**
	 * Sets the status list.
	 *
	 * @param statusList the statusList to set
	 */
	public void setStatusList(List<LocChqBookSrchPrmDto> statusList) {
		this.statusList = statusList;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf name.
	 *
	 * @return the wfName
	 */
	public String getWfName() {
		return wfName;
	}

	/**
	 * Sets the wf name.
	 *
	 * @param wfName the wfName to set
	 */
	public void setWfName(String wfName) {
		this.wfName = wfName;
	}

	/**
	 * Gets the wf list.
	 *
	 * @return the wfList
	 */
	public List<LocChqBookSrchPrmDto> getWfList() {
		return wfList;
	}

	/**
	 * Sets the wf list.
	 *
	 * @param wfList the wfList to set
	 */
	public void setWfList(List<LocChqBookSrchPrmDto> wfList) {
		this.wfList = wfList;
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
	 * Gets the div code list.
	 *
	 * @return the div code list
	 */
	public List<LocChqBookSrchPrmDto> getDivCodeList() {
		return divCodeList;
	}

	/**
	 * Sets the div code list.
	 *
	 * @param divCodeList the new div code list
	 */
	public void setDivCodeList(List<LocChqBookSrchPrmDto> divCodeList) {
		this.divCodeList = divCodeList;
	}

	/**
	 * Gets the div name list.
	 *
	 * @return the div name list
	 */
	public List<LocChqBookSrchPrmDto> getDivNameList() {
		return divNameList;
	}

	/**
	 * Sets the div name list.
	 *
	 * @param divNameList the new div name list
	 */
	public void setDivNameList(List<LocChqBookSrchPrmDto> divNameList) {
		this.divNameList = divNameList;
	}
}

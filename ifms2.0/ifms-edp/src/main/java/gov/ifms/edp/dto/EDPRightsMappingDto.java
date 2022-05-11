package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import gov.ifms.common.base.DTO;

/**
 * The Class EDPRightsMappingDto.
 */
public class EDPRightsMappingDto extends DTO implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The tusr rg map id. */
	private Long tusrRgMapId; 
	
	/** The trn no. */
	private String trnNo;
	
	/** The emp id. */
	@NotNull
	private Long empId;
	
	/** The lk po off user id. */
	@NotNull
	private Long lkPoOffUserId;
	
	/** The ui data list. */
	private List<EDPRightsMappingDataDto> uiDataList;
	
	/** The data list. */
	private List<EDPRightsMappingDataDto> dataList;
	
	/** The menu id. */
	private Long menuId; 
	
	/** The has objection. */
	private boolean hasObjection;

	/** The objection remarks. */
	private String objectionRemarks;

	/** The is objection required. */
	private boolean isObjectionRequired;
	
	/** The is wf in request. */
	private boolean wfInRequest;
	
	/** The is wf submite. */
	private boolean wfSubmit;
	
	/** The wf save drft api call. */
	private boolean wfSaveDrftApiCall;

	/**
	 * Gets the tusr rg map id.
	 *
	 * @return the tusrRgMapId
	 */
	public Long getTusrRgMapId() {
		return tusrRgMapId;
	}

	/**
	 * Sets the tusr rg map id.
	 *
	 * @param tusrRgMapId the tusrRgMapId to set
	 */
	public void setTusrRgMapId(Long tusrRgMapId) {
		this.tusrRgMapId = tusrRgMapId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the lk po off user id.
	 *
	 * @return the lkPoOffUserId
	 */
	public Long getLkPoOffUserId() {
		return lkPoOffUserId;
	}

	/**
	 * Sets the lk po off user id.
	 *
	 * @param lkPoOffUserId the lkPoOffUserId to set
	 */
	public void setLkPoOffUserId(Long lkPoOffUserId) {
		this.lkPoOffUserId = lkPoOffUserId;
	}

	/**
	 * Gets the data list.
	 *
	 * @return the dataList
	 */
	public List<EDPRightsMappingDataDto> getDataList() {
		return dataList;
	}

	/**
	 * Sets the data list.
	 *
	 * @param dataList the dataList to set
	 */
	public void setDataList(List<EDPRightsMappingDataDto> dataList) {
		this.dataList = dataList;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @return the uiDataList
	 */
	public List<EDPRightsMappingDataDto> getUiDataList() {
		return uiDataList;
	}

	/**
	 * @param uiDataList the uiDataList to set
	 */
	public void setUiDataList(List<EDPRightsMappingDataDto> uiDataList) {
		this.uiDataList = uiDataList;
	}

	/**
	 * @return the hasObjection
	 */
	public boolean isHasObjection() {
		return hasObjection;
	}

	/**
	 * @param hasObjection the hasObjection to set
	 */
	public void setHasObjection(boolean hasObjection) {
		this.hasObjection = hasObjection;
	}

	/**
	 * @return the objectionRemarks
	 */
	public String getObjectionRemarks() {
		return objectionRemarks;
	}

	/**
	 * @param objectionRemarks the objectionRemarks to set
	 */
	public void setObjectionRemarks(String objectionRemarks) {
		this.objectionRemarks = objectionRemarks;
	}

	/**
	 * @return the isObjectionRequired
	 */
	public boolean isObjectionRequired() {
		return isObjectionRequired;
	}

	/**
	 * @param isObjectionRequired the isObjectionRequired to set
	 */
	public void setObjectionRequired(boolean isObjectionRequired) {
		this.isObjectionRequired = isObjectionRequired;
	}

	/**
	 * @return the wfInRequest
	 */
	public boolean isWfInRequest() {
		return wfInRequest;
	}

	/**
	 * @param wfInRequest the wfInRequest to set
	 */
	public void setWfInRequest(boolean wfInRequest) {
		this.wfInRequest = wfInRequest;
	}

	/**
	 * @return the wfSubmit
	 */
	public boolean isWfSubmit() {
		return wfSubmit;
	}

	/**
	 * @param wfSubmit the wfSubmit to set
	 */
	public void setWfSubmit(boolean wfSubmit) {
		this.wfSubmit = wfSubmit;
	}

	/**
	 * @return the wfSaveDrftApiCall
	 */
	public boolean isWfSaveDrftApiCall() {
		return wfSaveDrftApiCall;
	}

	/**
	 * @param wfSaveDrftApiCall the wfSaveDrftApiCall to set
	 */
	public void setWfSaveDrftApiCall(boolean wfSaveDrftApiCall) {
		this.wfSaveDrftApiCall = wfSaveDrftApiCall;
	}
	
	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataList, empId, hasObjection, isObjectionRequired, lkPoOffUserId,
				menuId, objectionRemarks, trnNo, tusrRgMapId, uiDataList, wfInRequest, wfSaveDrftApiCall, wfSubmit);
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPRightsMappingDto)) {
			return false;
		}
		EDPRightsMappingDto other = (EDPRightsMappingDto) obj;
		return Objects.equals(dataList, other.dataList) && Objects.equals(empId, other.empId)
				&& hasObjection == other.hasObjection && isObjectionRequired == other.isObjectionRequired
				&& Objects.equals(lkPoOffUserId, other.lkPoOffUserId) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(objectionRemarks, other.objectionRemarks) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(tusrRgMapId, other.tusrRgMapId) && Objects.equals(uiDataList, other.uiDataList)
				&& wfInRequest == other.wfInRequest && wfSaveDrftApiCall == other.wfSaveDrftApiCall
				&& wfSubmit == other.wfSubmit;
	}
}

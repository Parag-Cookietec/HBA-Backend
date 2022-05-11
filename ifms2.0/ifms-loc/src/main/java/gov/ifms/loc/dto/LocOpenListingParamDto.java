package gov.ifms.loc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.List;


/**
 * The Class LocOpenListingParamDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocOpenListingParamDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;


    /**
     * The status id.
     */
    @NativeQueryResultColumn(index = 0)
    private Long statusId;

    /**
     * The status name.
     */
    @NativeQueryResultColumn(index = 1)
    private String statusName;

    /**
     * The wf id.
     */
    @NativeQueryResultColumn(index = 2)
    private Long wfId;

    /**
     * The wf name.
     */
    @NativeQueryResultColumn(index = 3)
    private String wfName;

    /**
     * The office id.
     */
    @NativeQueryResultColumn(index = 4)
    private Long officeId;

    /**
     * The office name.
     */
    @NativeQueryResultColumn(index = 5)
    private String officeName;

    /** The dept id. */
    @NativeQueryResultColumn(index = 6)
    private Long deptId;
    
    /** The dept name. */
    @NativeQueryResultColumn(index = 7)
    private String deptName;
    
    /** The district id. */
    @NativeQueryResultColumn(index = 8)
    private Long districtId;
    
    /** The district name. */
    @NativeQueryResultColumn(index = 9)
    private String districtName;
    
    /** The circle id. */
    @NativeQueryResultColumn(index = 10)
    private Long circleId;
    
    /** The circle name. */
    @NativeQueryResultColumn(index = 11)
    private String circleName;
    
    /** The circle code. */
    @NativeQueryResultColumn(index = 12)
    private String circleCode;


    /**
     * The wf list.
     */
    private List<LocOpenListingParamDto> wfList;

    /**
     * The status list.
     */
    private List<LocOpenListingParamDto> statusList;

    /**
     * The office list.
     */
    private List<LocOpenListingParamDto> officeList;

    /** The dept list. */
    private List<LocOpenListingParamDto> deptList;
    
    /** The circle name list. */
    private List<LocOpenListingParamDto> circleNameList;
    
    /** The circle code list. */
    private List<LocOpenListingParamDto> circleCodeList;
    
    /** The district list. */
    private List<LocOpenListingParamDto> districtList;

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
    public List<LocOpenListingParamDto> getWfList() {
        return wfList;
    }

    /**
     * Sets the wf list.
     *
     * @param wfList the wfList to set
     */
    public void setWfList(List<LocOpenListingParamDto> wfList) {
        this.wfList = wfList;
    }

    /**
     * Gets the status list.
     *
     * @return the statusList
     */
    public List<LocOpenListingParamDto> getStatusList() {
        return statusList;
    }

    /**
     * Sets the status list.
     *
     * @param statusList the statusList to set
     */
    public void setStatusList(List<LocOpenListingParamDto> statusList) {
        this.statusList = statusList;
    }

    /**
     * Gets the office id.
     *
     * @return the officeId
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * Sets the office id.
     *
     * @param officeId the officeId to set
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * Gets the office name.
     *
     * @return the officeName
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * Sets the office name.
     *
     * @param officeName the officeName to set
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    /**
     * Gets the office list.
     *
     * @return the officeList
     */
    public List<LocOpenListingParamDto> getOfficeList() {
        return officeList;
    }

    /**
     * Sets the office list.
     *
     * @param officeList the officeList to set
     */
    public void setOfficeList(List<LocOpenListingParamDto> officeList) {
        this.officeList = officeList;
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
     * Gets the dept list.
     *
     * @return the dept list
     */
    public List<LocOpenListingParamDto> getDeptList() {
        return deptList;
    }

    /**
     * Sets the dept list.
     *
     * @param deptList the new dept list
     */
    public void setDeptList(List<LocOpenListingParamDto> deptList) {
        this.deptList = deptList;
    }

    /**
     * Gets the circle name list.
     *
     * @return the circle name list
     */
    public List<LocOpenListingParamDto> getCircleNameList() {
        return circleNameList;
    }

    /**
     * Sets the circle name list.
     *
     * @param circleNameList the new circle name list
     */
    public void setCircleNameList(List<LocOpenListingParamDto> circleNameList) {
        this.circleNameList = circleNameList;
    }

    /**
     * Gets the circle code list.
     *
     * @return the circle code list
     */
    public List<LocOpenListingParamDto> getCircleCodeList() {
        return circleCodeList;
    }

    /**
     * Sets the circle code list.
     *
     * @param circleCodeList the new circle code list
     */
    public void setCircleCodeList(List<LocOpenListingParamDto> circleCodeList) {
        this.circleCodeList = circleCodeList;
    }

    /**
     * Gets the district list.
     *
     * @return the district list
     */
    public List<LocOpenListingParamDto> getDistrictList() {
        return districtList;
    }

    /**
     * Sets the district list.
     *
     * @param districtList the new district list
     */
    public void setDistrictList(List<LocOpenListingParamDto> districtList) {
        this.districtList = districtList;
    }
}

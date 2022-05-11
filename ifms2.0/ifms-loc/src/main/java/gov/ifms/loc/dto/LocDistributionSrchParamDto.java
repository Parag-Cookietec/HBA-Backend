package gov.ifms.loc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.List;

/**
 * The Class LocDistributionSrchParamDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocDistributionSrchParamDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The entry type.
     */
    @NativeQueryResultColumn(index = 0)
    private String entryType;

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
     * The wf status.
     */
    @NativeQueryResultColumn(index = 3)
    private String wfStatus;

    /**
     * The circle id.
     */
    @NativeQueryResultColumn(index = 4)
    private Long circleId;

    /**
     * The circle code.
     */
    @NativeQueryResultColumn(index = 5)
    private String circleCode;

    /**
     * The circle name.
     */
    @NativeQueryResultColumn(index = 6)
    private String circleName;

    /**
     * The div id.
     */
    @NativeQueryResultColumn(index = 7)
    private Long divId;

    /**
     * The div code.
     */
    @NativeQueryResultColumn(index = 8)
    private String divCode;

    /**
     * The div name.
     */
    @NativeQueryResultColumn(index = 9)
    private String divName;

    /**
     * The fin year id.
     */
    @NativeQueryResultColumn(index = 10)
    private Long finYearId;

    /**
     * The fin year.
     */
    @NativeQueryResultColumn(index = 11)
    private String finYear;

    /**
     * The is cur fin year.
     */
    @NativeQueryResultColumn(index = 12)
    private Long isCurFinYear;

    /**
     * The circle name id.
     */
    private Long circleNameId;

    /**
     * The div name id.
     */
    private Long divNameId;

    /**
     * The wf list.
     */
    private List<LocDistributionSrchParamDto> wfList;

    /**
     * The entry type list.
     */
    private List<LocDistributionSrchParamDto> entryTypeList;

    /**
     * The circle code list.
     */
    private List<LocDistributionSrchParamDto> circleCodeList;

    /**
     * The circle name list.
     */
    private List<LocDistributionSrchParamDto> circleNameList;

    /**
     * The div code list.
     */
    private List<LocDistributionSrchParamDto> divCodeList;

    /**
     * The div name list.
     */
    private List<LocDistributionSrchParamDto> divNameList;

    /**
     * The status list.
     */
    private List<LocDistributionSrchParamDto> statusList;

    /**
     * The fin year list.
     */
    private List<LocDistributionSrchParamDto> finYearList;

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
     * Gets the circle code.
     *
     * @return the circleCode
     */
    public String getCircleCode() {
        return circleCode;
    }

    /**
     * Gets the entry type.
     *
     * @return the entryType
     */
    public String getEntryType() {
        return entryType;
    }

    /**
     * Sets the entry type.
     *
     * @param entryType the entryType to set
     */
    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    /**
     * Gets the entry type list.
     *
     * @return the entryTypeList
     */
    public List<LocDistributionSrchParamDto> getEntryTypeList() {
        return entryTypeList;
    }

    /**
     * Sets the entry type list.
     *
     * @param entryTypeList the entryTypeList to set
     */
    public void setEntryTypeList(List<LocDistributionSrchParamDto> entryTypeList) {
        this.entryTypeList = entryTypeList;
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
     * Gets the wf list.
     *
     * @return the wfList
     */
    public List<LocDistributionSrchParamDto> getWfList() {
        return wfList;
    }

    /**
     * Sets the wf list.
     *
     * @param wfList the wfList to set
     */
    public void setWfList(List<LocDistributionSrchParamDto> wfList) {
        this.wfList = wfList;
    }

    /**
     * Gets the circle code list.
     *
     * @return the circleCodeList
     */
    public List<LocDistributionSrchParamDto> getCircleCodeList() {
        return circleCodeList;
    }

    /**
     * Sets the circle code list.
     *
     * @param circleCodeList the circleCodeList to set
     */
    public void setCircleCodeList(List<LocDistributionSrchParamDto> circleCodeList) {
        this.circleCodeList = circleCodeList;
    }

    /**
     * Gets the circle name list.
     *
     * @return the circleNameList
     */
    public List<LocDistributionSrchParamDto> getCircleNameList() {
        return circleNameList;
    }

    /**
     * Sets the circle name list.
     *
     * @param circleNameList the circleNameList to set
     */
    public void setCircleNameList(List<LocDistributionSrchParamDto> circleNameList) {
        this.circleNameList = circleNameList;
    }

    /**
     * Gets the div code list.
     *
     * @return the divCodeList
     */
    public List<LocDistributionSrchParamDto> getDivCodeList() {
        return divCodeList;
    }

    /**
     * Sets the div code list.
     *
     * @param divCodeList the divCodeList to set
     */
    public void setDivCodeList(List<LocDistributionSrchParamDto> divCodeList) {
        this.divCodeList = divCodeList;
    }

    /**
     * Gets the div name list.
     *
     * @return the divNameList
     */
    public List<LocDistributionSrchParamDto> getDivNameList() {
        return divNameList;
    }

    /**
     * Sets the div name list.
     *
     * @param divNameList the divNameList to set
     */
    public void setDivNameList(List<LocDistributionSrchParamDto> divNameList) {
        this.divNameList = divNameList;
    }

    /**
     * Gets the status list.
     *
     * @return the statusList
     */
    public List<LocDistributionSrchParamDto> getStatusList() {
        return statusList;
    }

    /**
     * Sets the status list.
     *
     * @param statusList the statusList to set
     */
    public void setStatusList(List<LocDistributionSrchParamDto> statusList) {
        this.statusList = statusList;
    }

    /**
     * Gets the fin year id.
     *
     * @return the fin year id
     */
    public Long getFinYearId() {
        return finYearId;
    }

    /**
     * Sets the fin year id.
     *
     * @param finYearId the new fin year id
     */
    public void setFinYearId(Long finYearId) {
        this.finYearId = finYearId;
    }

    /**
     * Gets the fin year.
     *
     * @return the fin year
     */
    public String getFinYear() {
        return finYear;
    }

    /**
     * Sets the fin year.
     *
     * @param finYear the new fin year
     */
    public void setFinYear(String finYear) {
        this.finYear = finYear;
    }

    /**
     * Gets the fin year list.
     *
     * @return the fin year list
     */
    public List<LocDistributionSrchParamDto> getFinYearList() {
        return finYearList;
    }

    /**
     * Sets the fin year list.
     *
     * @param finYearList the new fin year list
     */
    public void setFinYearList(List<LocDistributionSrchParamDto> finYearList) {
        this.finYearList = finYearList;
    }

    /**
     * Gets the checks if is cur fin year.
     *
     * @return the checks if is cur fin year
     */
    public Long getIsCurFinYear() {
        return isCurFinYear;
    }

    /**
     * Sets the checks if is cur fin year.
     *
     * @param isCurFinYear the new checks if is cur fin year
     */
    public void setIsCurFinYear(Long isCurFinYear) {
        this.isCurFinYear = isCurFinYear;
    }
}

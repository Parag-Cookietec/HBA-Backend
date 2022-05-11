package gov.ifms.workflow.dto;

import gov.ifms.common.attachment.dto.AttachmentCommonDto;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.util.Date;
import java.util.List;

@NativeQueryResultEntity
public class WfHSTDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The trn id. */
    @NativeQueryResultColumn(index = 0)
    public long trnId;

    /** The user name. */
    @NativeQueryResultColumn(index = 1)
    public String userName;

    /** The post name. */
    @NativeQueryResultColumn(index = 2)
    public String postName;

    /** The created date. */
    @NativeQueryResultColumn(index = 3)
    public Date createdDate;

    /** The wf name. */
    @NativeQueryResultColumn(index = 4)
    public String wfName;

    /** The wf status. */
    @NativeQueryResultColumn(index = 5)
    public String wfStatus;

    /** The wf trn status. */
    @NativeQueryResultColumn(index = 6)
    public String wfTrnStatus;

    /** The remark. */
    @NativeQueryResultColumn(index = 7)
    public String remark;

    /** The office name. */
    @NativeQueryResultColumn(index = 8)
    public String officeName;

    /** The designation name. */
    @NativeQueryResultColumn(index = 9)
    public String designationName;

    /** The wf role name. */
    @NativeQueryResultColumn(index = 10)
    public String wfRoleName;

    @NativeQueryResultColumn(index = 11)
    public Long wfRoleId;

    @NativeQueryResultColumn(index = 12)
    public String wfId;

    List<AttachmentCommonDto> attachmentCommonDtoList;

    public List<AttachmentCommonDto> getAttachmentCommonDtoList() {
        return attachmentCommonDtoList;
    }

    public void setAttachmentCommonDtoList(List<AttachmentCommonDto> attachmentCommonDtoList) {
        this.attachmentCommonDtoList = attachmentCommonDtoList;
    }

    public long getTrnId() {
        return trnId;
    }

    public void setTrnId(long trnId) {
        this.trnId = trnId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getWfName() {
        return wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName;
    }

    public String getWfStatus() {
        return wfStatus;
    }

    public void setWfStatus(String wfStatus) {
        this.wfStatus = wfStatus;
    }

    public String getWfTrnStatus() {
        return wfTrnStatus;
    }

    public void setWfTrnStatus(String wfTrnStatus) {
        this.wfTrnStatus = wfTrnStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getWfRoleName() {
        return wfRoleName;
    }

    public void setWfRoleName(String wfRoleName) {
        this.wfRoleName = wfRoleName;
    }

    public Long getWfRoleId() {
        return wfRoleId;
    }

    public void setWfRoleId(Long wfRoleId) {
        this.wfRoleId = wfRoleId;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }
}

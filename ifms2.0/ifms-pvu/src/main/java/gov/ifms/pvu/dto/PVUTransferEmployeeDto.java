package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * The Class PVUTransferEmployeeDto.
 *
 * @version v 1.0
 * @created 2019/12/21 23:26:24
 */
public class PVUTransferEmployeeDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The transfer employee id.
     */
    private long id;

    /**
     * The transfer id.
     */
    private long transferId;

    /**
     * The emp id.
     */
    @Min(value = 0)
    private long employeeId;

    private long employeeNo;

    /**
     * The district id.
     */
    private long districtId;

    /**
     * The cardex no.
     */
    private long cardexNo;

    /**
     * The ddo code.
     */
    private long ddoCode;

    /**
     * The office id.
     */
    private long officeId;

    /**
     * The sub office id.
     */
    private long subOfficeId;

    /**
     * The joining sub office id.
     */
    private long joiningSubOfficeId;

    /**
     * The relieving date.
     */
    private Date relievingDate;

    /**
     * The actual joining date.
     */
    private Date actualJoiningDate;

    /**
     * The transfer noon type.
     */
    private long transferNoonType;

    /**
     * The joining noon type.
     */
    private long joiningNoonType;

    /**
     * The reason for transfer.
     */
    private long reasonForTransfer;

    /**
     * The transfer remarks.
     */
    private String transferRemarks;

    /**
     * The joining remarks.
     */
    private String joiningRemarks;

    /**
     * The status id.
     */
    private long statusId;

    /**
     * The transfer order no.
     */
    private String transferOrderNo;

    /**
     * The transfer order date.
     */
    private LocalDate transferOrderDate;

    private String officeName;

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public long getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(long employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the transfer employee id.
     *
     * @param id the transferEmployeeId to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the transfer id.
     *
     * @return the transferId
     */
    public long getTransferId() {
        return transferId;
    }

    /**
     * Sets the transfer id.
     *
     * @param transferId the transferId to set
     */
    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the district id.
     *
     * @return the districtId
     */
    public long getDistrictId() {
        return districtId;
    }

    /**
     * Sets the district id.
     *
     * @param districtId the districtId to set
     */
    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

    /**
     * Gets the cardex no.
     *
     * @return the cardexNo
     */
    public long getCardexNo() {
        return cardexNo;
    }

    /**
     * Sets the cardex no.
     *
     * @param cardexNo the cardexNo to set
     */
    public void setCardexNo(long cardexNo) {
        this.cardexNo = cardexNo;
    }

    /**
     * Gets the ddo code.
     *
     * @return the ddoCode
     */
    public long getDdoCode() {
        return ddoCode;
    }

    /**
     * Sets the ddo code.
     *
     * @param ddoCode the ddoCode to set
     */
    public void setDdoCode(long ddoCode) {
        this.ddoCode = ddoCode;
    }

    /**
     * Gets the office id.
     *
     * @return the officeId
     */
    public long getOfficeId() {
        return officeId;
    }

    /**
     * Sets the office id.
     *
     * @param officeId the officeId to set
     */
    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    /**
     * Gets the sub office id.
     *
     * @return the subOfficeId
     */
    public long getSubOfficeId() {
        return subOfficeId;
    }

    /**
     * Sets the sub office id.
     *
     * @param subOfficeId the subOfficeId to set
     */
    public void setSubOfficeId(long subOfficeId) {
        this.subOfficeId = subOfficeId;
    }

    /**
     * Gets the joining sub office id.
     *
     * @return the joiningSubOfficeId
     */
    public long getJoiningSubOfficeId() {
        return joiningSubOfficeId;
    }

    /**
     * Sets the joining sub office id.
     *
     * @param joiningSubOfficeId the joiningSubOfficeId to set
     */
    public void setJoiningSubOfficeId(long joiningSubOfficeId) {
        this.joiningSubOfficeId = joiningSubOfficeId;
    }

    /**
     * Gets the relieving date.
     *
     * @return the relievingDate
     */
    public Date getRelievingDate() {
        return relievingDate;
    }

    /**
     * Sets the relieving date.
     *
     * @param relievingDate the relievingDate to set
     */
    public void setRelievingDate(Date relievingDate) {
        this.relievingDate = relievingDate;
    }

    /**
     * Gets the actual joining date.
     *
     * @return the actualJoiningDate
     */
    public Date getActualJoiningDate() {
        return actualJoiningDate;
    }

    /**
     * Sets the actual joining date.
     *
     * @param actualJoiningDate the actualJoiningDate to set
     */
    public void setActualJoiningDate(Date actualJoiningDate) {
        this.actualJoiningDate = actualJoiningDate;
    }

    /**
     * Gets the transfer noon type.
     *
     * @return the transferNoonType
     */
    public long getTransferNoonType() {
        return transferNoonType;
    }

    /**
     * Sets the transfer noon type.
     *
     * @param transferNoonType the transferNoonType to set
     */
    public void setTransferNoonType(long transferNoonType) {
        this.transferNoonType = transferNoonType;
    }

    /**
     * Gets the joining noon type.
     *
     * @return the joiningNoonType
     */
    public long getJoiningNoonType() {
        return joiningNoonType;
    }

    /**
     * Sets the joining noon type.
     *
     * @param joiningNoonType the joiningNoonType to set
     */
    public void setJoiningNoonType(long joiningNoonType) {
        this.joiningNoonType = joiningNoonType;
    }

    /**
     * Gets the reason for transfer.
     *
     * @return the reasonForTransfer
     */
    public long getReasonForTransfer() {
        return reasonForTransfer;
    }

    /**
     * Sets the reason for transfer.
     *
     * @param reasonForTransfer the reasonForTransfer to set
     */
    public void setReasonForTransfer(long reasonForTransfer) {
        this.reasonForTransfer = reasonForTransfer;
    }

    /**
     * Gets the transfer remarks.
     *
     * @return the transferRemarks
     */
    public String getTransferRemarks() {
        return transferRemarks;
    }

    /**
     * Sets the transfer remarks.
     *
     * @param transferRemarks the transferRemarks to set
     */
    public void setTransferRemarks(String transferRemarks) {
        this.transferRemarks = transferRemarks;
    }

    /**
     * Gets the joining remarks.
     *
     * @return the joiningRemarks
     */
    public String getJoiningRemarks() {
        return joiningRemarks;
    }

    /**
     * Sets the joining remarks.
     *
     * @param joiningRemarks the joiningRemarks to set
     */
    public void setJoiningRemarks(String joiningRemarks) {
        this.joiningRemarks = joiningRemarks;
    }

    /**
     * Gets the status id.
     *
     * @return the statusId
     */
    public long getStatusId() {
        return statusId;
    }

    /**
     * Sets the status id.
     *
     * @param statusId the statusId to set
     */
    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    /**
     * PVUTransferEmployeeDto Constructor.
     */
    public PVUTransferEmployeeDto() {
        super();
    }

    public String getTransferOrderNo() {
        return transferOrderNo;
    }

    public void setTransferOrderNo(String transferOrderNo) {
        this.transferOrderNo = transferOrderNo;
    }

    public LocalDate getTransferOrderDate() {
        return transferOrderDate;
    }

    public void setTransferOrderDate(LocalDate transferOrderDate) {
        this.transferOrderDate = transferOrderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PVUTransferEmployeeDto)) return false;
        PVUTransferEmployeeDto that = (PVUTransferEmployeeDto) o;
        return getId() == that.getId() &&
                getTransferId() == that.getTransferId() &&
                getEmployeeId() == that.getEmployeeId() &&
                getDistrictId() == that.getDistrictId() &&
                getCardexNo() == that.getCardexNo() &&
                getDdoCode() == that.getDdoCode() &&
                getOfficeId() == that.getOfficeId() &&
                getSubOfficeId() == that.getSubOfficeId() &&
                getJoiningSubOfficeId() == that.getJoiningSubOfficeId() &&
                getTransferNoonType() == that.getTransferNoonType() &&
                getJoiningNoonType() == that.getJoiningNoonType() &&
                getReasonForTransfer() == that.getReasonForTransfer() &&
                getStatusId() == that.getStatusId() &&
                Objects.equals(getRelievingDate(), that.getRelievingDate()) &&
                Objects.equals(getActualJoiningDate(), that.getActualJoiningDate()) &&
                Objects.equals(getTransferRemarks(), that.getTransferRemarks()) &&
                Objects.equals(getJoiningRemarks(), that.getJoiningRemarks()) &&
                Objects.equals(getTransferOrderNo(), that.getTransferOrderNo()) &&
                Objects.equals(getTransferOrderDate(), that.getTransferOrderDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTransferId(), getEmployeeId(), getDistrictId(), getCardexNo(), getDdoCode(), getOfficeId(), getSubOfficeId(), getJoiningSubOfficeId(), getRelievingDate(), getActualJoiningDate(), getTransferNoonType(), getJoiningNoonType(), getReasonForTransfer(), getTransferRemarks(), getJoiningRemarks(), getStatusId(), getTransferOrderNo(), getTransferOrderDate());
    }

    @Override
    public String toString() {
        return "PVUTransferEmployeeDto{" +
                "id=" + id +
                ", transferId=" + transferId +
                ", employeeId=" + employeeId +
                ", districtId=" + districtId +
                ", cardexNo=" + cardexNo +
                ", ddoCode=" + ddoCode +
                ", officeId=" + officeId +
                ", subOfficeId=" + subOfficeId +
                ", joiningSubOfficeId=" + joiningSubOfficeId +
                ", relievingDate=" + relievingDate +
                ", actualJoiningDate=" + actualJoiningDate +
                ", transferNoonType=" + transferNoonType +
                ", joiningNoonType=" + joiningNoonType +
                ", reasonForTransfer=" + reasonForTransfer +
                ", transferRemarks='" + transferRemarks + '\'' +
                ", joiningRemarks='" + joiningRemarks + '\'' +
                ", statusId=" + statusId +
                ", transferOrderNo='" + transferOrderNo + '\'' +
                ", transferOrderDate=" + transferOrderDate +
                '}';
    }
}

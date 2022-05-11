package gov.ifms.common.scheduler.entity;


import gov.ifms.common.util.Constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "MS_CMN_SCHEDULER" , schema = Constant.EDP_MASTER_SCHEMA )
public class MsCMNSchedulerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHEDULER_ID")
    private long schedulerId;

    @Column(name = "SCHEDULER_NAME")
    private String schedulerName;

    @Column(name = "SCHEDULER_TYPE")
    private int schedulerType;

    @Column(name = "CONFIG_VAL")
    private String configVal;

    @Column(name = "SCHEDULER_DESC")
    private String schedulerDesc;

    @Column(name = "CREATED_BY", updatable = false)
    private long createdBy;

    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;


    @Column(name = "UPDATED_BY")
    private long updatedBy;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;


    @Column(name = "ACTIVE_STATUS")
    private int activeStatus = 1;


    public long getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(long schedulerId) {
        this.schedulerId = schedulerId;
    }

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public int getSchedulerType() {
        return schedulerType;
    }

    public void setSchedulerType(int schedulerType) {
        this.schedulerType = schedulerType;
    }

    public String getConfigVal() {
        return configVal;
    }

    public void setConfigVal(String configVal) {
        this.configVal = configVal;
    }

    public String getSchedulerDesc() {
        return schedulerDesc;
    }

    public void setSchedulerDesc(String schedulerDesc) {
        this.schedulerDesc = schedulerDesc;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsCMNSchedulerEntity that = (MsCMNSchedulerEntity) o;
        return schedulerId == that.schedulerId &&
                schedulerType == that.schedulerType &&
                createdBy == that.createdBy &&
                updatedBy == that.updatedBy &&
                activeStatus == that.activeStatus &&
                Objects.equals(schedulerName, that.schedulerName) &&
                Objects.equals(configVal, that.configVal) &&
                Objects.equals(schedulerDesc, that.schedulerDesc) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(updatedDate, that.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedulerId, schedulerName, schedulerType, configVal, schedulerDesc, createdBy, createdDate, updatedBy, updatedDate, activeStatus);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsCMNSchedulerEntity.class.getSimpleName() + "[", "]")
                .add("schedulerId=" + schedulerId)
                .add("schedulerName='" + schedulerName + "'")
                .add("schedulerType=" + schedulerType)
                .add("configVal='" + configVal + "'")
                .add("schedulerDesc='" + schedulerDesc + "'")
                .add("createdBy=" + createdBy)
                .add("createdDate=" + createdDate)
                .add("updatedBy=" + updatedBy)
                .add("updatedDate=" + updatedDate)
                .add("activeStatus=" + activeStatus)
                .toString();
    }
}

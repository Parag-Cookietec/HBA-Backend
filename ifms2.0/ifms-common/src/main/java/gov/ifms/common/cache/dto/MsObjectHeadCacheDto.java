package gov.ifms.common.cache.dto;


import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.util.Objects;
import java.util.StringJoiner;

@NativeQueryResultEntity
public class MsObjectHeadCacheDto {

    @NativeQueryResultColumn(index = 0)
    private long objectId;

    @NativeQueryResultColumn(index = 1)
    private String objectName;

    @NativeQueryResultColumn(index = 2)
    private String objectNameGuj;

    @NativeQueryResultColumn(index = 3)
    private String objectCode;

    @NativeQueryResultColumn(index = 4)
    private String objectCodeGuj;

    @NativeQueryResultColumn(index = 5)
    private String objectCodeName;

    @NativeQueryResultColumn(index = 6)
    private long iSGaidId;

    @NativeQueryResultColumn(index = 7)
    private long isCnmId;

    @NativeQueryResultColumn(index = 8)
    private long isBrekUpNeededId;

    @NativeQueryResultColumn(index = 9)
    private long objectClassId;

    @NativeQueryResultColumn(index = 10)
    private long isRecoveryId;

    @NativeQueryResultColumn(index = 11)
    private long  giaBreakupId;

    @NativeQueryResultColumn(index = 12)
    private long isReceipt;


    public MsObjectHeadCacheDto() {
        super();
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectNameGuj() {
        return objectNameGuj;
    }

    public void setObjectNameGuj(String objectNameGuj) {
        this.objectNameGuj = objectNameGuj;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    public String getObjectCodeGuj() {
        return objectCodeGuj;
    }

    public void setObjectCodeGuj(String objectCodeGuj) {
        this.objectCodeGuj = objectCodeGuj;
    }

    public String getObjectCodeName() {
        return objectCodeName;
    }

    public void setObjectCodeName(String objectCodeName) {
        this.objectCodeName = objectCodeName;
    }

    public long getiSGaidId() {
        return iSGaidId;
    }

    public void setiSGaidId(long iSGaidId) {
        this.iSGaidId = iSGaidId;
    }

    public long getIsCnmId() {
        return isCnmId;
    }

    public void setIsCnmId(long isCnmId) {
        this.isCnmId = isCnmId;
    }

    public long getIsBrekUpNeededId() {
        return isBrekUpNeededId;
    }

    public void setIsBrekUpNeededId(long isBrekUpNeededId) {
        this.isBrekUpNeededId = isBrekUpNeededId;
    }

    public long getObjectClassId() {
        return objectClassId;
    }

    public void setObjectClassId(long objectClassId) {
        this.objectClassId = objectClassId;
    }

    public long getIsRecoveryId() {
        return isRecoveryId;
    }

    public void setIsRecoveryId(long isRecoveryId) {
        this.isRecoveryId = isRecoveryId;
    }

    public long getGiaBreakupId() {
        return giaBreakupId;
    }

    public void setGiaBreakupId(long giaBreakupId) {
        this.giaBreakupId = giaBreakupId;
    }

    public long getIsReceipt() {
        return isReceipt;
    }

    public void setIsReceipt(long isReceipt) {
        this.isReceipt = isReceipt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsObjectHeadCacheDto.class.getSimpleName() + "[", "]")
                .add("objectId=" + objectId)
                .add("objectName='" + objectName + "'")
                .add("objectNameGuj='" + objectNameGuj + "'")
                .add("objectCode='" + objectCode + "'")
                .add("objectCodeGuj='" + objectCodeGuj + "'")
                .add("objectCodeName='" + objectCodeName + "'")
                .add("iSGaidId=" + iSGaidId)
                .add("isCnmId=" + isCnmId)
                .add("isBrekUpNeededId=" + isBrekUpNeededId)
                .add("objectClassId=" + objectClassId)
                .add("isRecoveryId=" + isRecoveryId)
                .add("giaBreakupId=" + giaBreakupId)
                .add("isReceipt=" + isReceipt)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsObjectHeadCacheDto that = (MsObjectHeadCacheDto) o;
        return objectId == that.objectId &&
                iSGaidId == that.iSGaidId &&
                isCnmId == that.isCnmId &&
                isBrekUpNeededId == that.isBrekUpNeededId &&
                objectClassId == that.objectClassId &&
                isRecoveryId == that.isRecoveryId &&
                giaBreakupId == that.giaBreakupId &&
                isReceipt == that.isReceipt &&
                Objects.equals(objectName, that.objectName) &&
                Objects.equals(objectNameGuj, that.objectNameGuj) &&
                Objects.equals(objectCode, that.objectCode) &&
                Objects.equals(objectCodeGuj, that.objectCodeGuj) &&
                Objects.equals(objectCodeName, that.objectCodeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, objectName, objectNameGuj, objectCode, objectCodeGuj, objectCodeName, iSGaidId, isCnmId, isBrekUpNeededId, objectClassId, isRecoveryId, giaBreakupId, isReceipt);
    }
}

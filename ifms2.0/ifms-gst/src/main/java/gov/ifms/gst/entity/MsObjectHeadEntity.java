package gov.ifms.gst.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MS_OBJECTHEAD", schema = Constant.BUDGET_MASTER_SCHEMA, uniqueConstraints = @UniqueConstraint(columnNames = {
		"OBJECT_ID" }))
public class MsObjectHeadEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The detail head id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OBJECT_ID")
	private Long objectId;

	/** The detail head name. */
	@Column(name = "OBJECT_NAME")
	private String objectName;

	/** The detail head name guj. */
	@Column(name = "OBJECT_NAME_GUJ")
	private String objectNameGuj;

	/** The detail head desc. */
	@Column(name = "OBJECT_DESC")
	private String objectDesc;

	/** The detail head desc guj. */
	@Column(name = "OBJECT_DESC_GUJ")
	private String objectDescGuj;

	/** The detail head code. */
	@Column(name = "OBJECT_CODE")
	private String objectCode;

	/** The detail head code guj. */
	@Column(name = "OBJECT_CODE_GUJ")
	private String objectCodeGuj;

	/** The detail head code name. */
	@Column(name = "OBJECT_CODE_NAME")
	private String objectCodeName;

	/** The detail head type id. */
	@Column(name = "OBJECT_TYPE_ID")
	private Long objectTypeId;

	/** The parent detail head id. */
	@Column(name = "PARENT_OBJECT_ID")
	private long parentObjectId;

	@Column(name = "IS_GAID_ID")
	private String isGaidId;

	@Column(name = "IS_CNM_ID")
	private String isCnmId;

	@Column(name = "IS_BREAKUPNEEDED_ID")
	private String isBreakupneededId;

	@Column(name = "OBJECTCLASS_ID")
	private String objectClassId;

	@Column(name = "IS_RECOVERY_ID")
	private String isRecoveryId;

	@Column(name = "GIA_BREAKUP_ID")
	private String giaBreakupId;

	@Column(name = "IS_RECEIPT")
	private String isReceipt;

    @Column(name = "IS_PRI")
    private String isPri;

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
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

    public String getObjectDesc() {
        return objectDesc;
    }

    public void setObjectDesc(String objectDesc) {
        this.objectDesc = objectDesc;
    }

    public String getObjectDescGuj() {
        return objectDescGuj;
    }

    public void setObjectDescGuj(String objectDescGuj) {
        this.objectDescGuj = objectDescGuj;
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

    public Long getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Long objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public long getParentObjectId() {
        return parentObjectId;
    }

    public void setParentObjectId(long parentObjectId) {
        this.parentObjectId = parentObjectId;
    }

    public String getIsGaidId() {
        return isGaidId;
    }

    public void setIsGaidId(String isGaidId) {
        this.isGaidId = isGaidId;
    }

    public String getIsCnmId() {
        return isCnmId;
    }

    public void setIsCnmId(String isCnmId) {
        this.isCnmId = isCnmId;
    }

    public String getIsBreakupneededId() {
        return isBreakupneededId;
    }

    public void setIsBreakupneededId(String isBreakupneededId) {
        this.isBreakupneededId = isBreakupneededId;
    }

    public String getObjectClassId() {
        return objectClassId;
    }

    public void setObjectClassId(String objectClassId) {
        this.objectClassId = objectClassId;
    }

    public String getIsRecoveryId() {
        return isRecoveryId;
    }

    public void setIsRecoveryId(String isRecoveryId) {
        this.isRecoveryId = isRecoveryId;
    }

    public String getGiaBreakupId() {
        return giaBreakupId;
    }

    public void setGiaBreakupId(String giaBreakupId) {
        this.giaBreakupId = giaBreakupId;
    }

    public String getIsReceipt() {
        return isReceipt;
    }

    public void setIsReceipt(String isReceipt) {
        this.isReceipt = isReceipt;
    }

    public String getIsPri() {
        return isPri;
    }

    public void setIsPri(String isPri) {
        this.isPri = isPri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsObjectHeadEntity that = (MsObjectHeadEntity) o;
        return parentObjectId == that.parentObjectId && Objects.equals(objectId, that.objectId) && Objects.equals(objectName, that.objectName) && Objects.equals(objectNameGuj, that.objectNameGuj) && Objects.equals(objectDesc, that.objectDesc) && Objects.equals(objectDescGuj, that.objectDescGuj) && Objects.equals(objectCode, that.objectCode) && Objects.equals(objectCodeGuj, that.objectCodeGuj) && Objects.equals(objectCodeName, that.objectCodeName) && Objects.equals(objectTypeId, that.objectTypeId) && Objects.equals(isGaidId, that.isGaidId) && Objects.equals(isCnmId, that.isCnmId) && Objects.equals(isBreakupneededId, that.isBreakupneededId) && Objects.equals(objectClassId, that.objectClassId) && Objects.equals(isRecoveryId, that.isRecoveryId) && Objects.equals(giaBreakupId, that.giaBreakupId) && Objects.equals(isReceipt, that.isReceipt) && Objects.equals(isPri, that.isPri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, objectName, objectNameGuj, objectDesc, objectDescGuj, objectCode, objectCodeGuj, objectCodeName, objectTypeId, parentObjectId, isGaidId, isCnmId, isBreakupneededId, objectClassId, isRecoveryId, giaBreakupId, isReceipt, isPri);
    }
}

package gov.ifms.loc.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocMsObjectClassEntity.
 *
 * @version 1.0
 * @created 2019/10/18 10:47:05
 */
@Entity
@Table(name = "MS_OBJECTCLASS", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsObjectClassEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** The object class id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OBJECTCLASS_ID")
    private Long objectClassId;

    /** The object class name. */
    @Column(name = "OBJECTCLASS_NAME")
    private String objectClassName;

    /** The object class name guj. */
    @Column(name = "OBJECTCLASS_NAME_GUJ")
    private String objectClassNameGuj;

    /** The object class desc. */
    @Column(name = "OBJECTCLASS_DESC")
    private String objectClassDesc;

    /** The object class desc guj. */
    @Column(name = "OBJECTCLASS_DESC_GUJ")
    private String objectClassDescGuj;

    /** The object class code. */
    @Column(name = "OBJECTCLASS_CODE")
    private String objectClassCode;

    /** The object class code guj. */
    @Column(name = "OBJECTCLASS_CODE_GUJ")
    private String objectClassCodeGuj;

    /** The object class code name. */
    @Column(name = "OBJECTCLASS_CODE_NAME")
    private String objectClassCodeName;

    /** The object class type id. */
    @Column(name = "OBJECTCLASS_TYPE_ID")
    private Long objectClassTypeId;

    /** The object code. */
    @Column(name = "OBJECT_CODE")
    private String objectCode;

    /** The parent object class id. */
    @Column(name = "PARENT_OBJCLASS_ID")
    private Long parentObjectClassId;

    /**
     * BudgetMsObjectClassDto Constructor
     */
    public LocMsObjectClassEntity() {
        super();
    }

    /**
     * Instantiates a new budget ms object class entity.
     *
     * @param objectClassId the object class id
     */
    public LocMsObjectClassEntity(Long objectClassId) {
        this.objectClassId = objectClassId;
    }

    /**
     * hascode method
     */
    @Override
    public int hashCode() {
        return Objects.hash(objectClassId, objectClassName, objectClassNameGuj, objectClassDesc, objectClassDescGuj,
                objectClassCode, objectClassCodeGuj, objectClassCodeName, objectClassTypeId, objectCode,
                parentObjectClassId);
    }

    /**
     * equals method
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LocMsObjectClassEntity)) {
            return false;
        }

        LocMsObjectClassEntity other = (LocMsObjectClassEntity) obj;

        return Objects.equals(objectClassId, other.objectClassId)
                && Objects.equals(objectClassName, other.objectClassName)
                && Objects.equals(objectClassNameGuj, other.objectClassNameGuj)
                && Objects.equals(objectClassDesc, other.objectClassDesc)
                && Objects.equals(objectClassDescGuj, other.objectClassDescGuj)
                && Objects.equals(objectClassCode, other.objectClassCode)
                && Objects.equals(objectClassCodeGuj, other.objectClassCodeGuj)
                && Objects.equals(objectClassCodeName, other.objectClassCodeName)
                && Objects.equals(objectClassTypeId, other.objectClassTypeId)
                && Objects.equals(objectCode, other.objectCode)
                && Objects.equals(parentObjectClassId, other.parentObjectClassId);
    }

    /**
     * toString method
     */
    @Override
    public String toString() {
        return "LocMsObjectClassEntity [objectClassId = " + objectClassId + ",objectClassName = " + objectClassName
                + ",objectClassNameGuj = " + objectClassNameGuj + ",objectClassDesc = " + objectClassDesc
                + ",objectClassDescGuj = " + objectClassDescGuj + ",objectClassCode = " + objectClassCode
                + ",objectClassCodeGuj = " + objectClassCodeGuj + ",objectClassCodeName = " + objectClassCodeName
                + ",objectClassTypeId = " + objectClassTypeId + ",objectCode = " + objectCode
                + ",parentObjectClassId = " + parentObjectClassId + ",]";
    }


    /**
     * @return the objectClassId
     */
    public Long getObjectClassId() {
        return objectClassId;
    }

    /**
     * @param objectClassId the objectClassId to set
     */
    public void setObjectClassId(Long objectClassId) {
        this.objectClassId = objectClassId;
    }

    /**
     * @return the objectClassName
     */
    public String getObjectClassName() {
        return objectClassName;
    }

    /**
     * @param objectClassName the objectClassName to set
     */
    public void setObjectClassName(String objectClassName) {
        this.objectClassName = objectClassName;
    }

    /**
     * @return the objectClassNameGuj
     */
    public String getObjectClassNameGuj() {
        return objectClassNameGuj;
    }

    /**
     * @param objectClassNameGuj the objectClassNameGuj to set
     */
    public void setObjectClassNameGuj(String objectClassNameGuj) {
        this.objectClassNameGuj = objectClassNameGuj;
    }

    /**
     * @return the objectClassDesc
     */
    public String getObjectClassDesc() {
        return objectClassDesc;
    }

    /**
     * @param objectClassDesc the objectClassDesc to set
     */
    public void setObjectClassDesc(String objectClassDesc) {
        this.objectClassDesc = objectClassDesc;
    }

    /**
     * @return the objectClassDescGuj
     */
    public String getObjectClassDescGuj() {
        return objectClassDescGuj;
    }

    /**
     * @param objectClassDescGuj the objectClassDescGuj to set
     */
    public void setObjectClassDescGuj(String objectClassDescGuj) {
        this.objectClassDescGuj = objectClassDescGuj;
    }

    /**
     * @return the objectClassCode
     */
    public String getObjectClassCode() {
        return objectClassCode;
    }

    /**
     * @param objectClassCode the objectClassCode to set
     */
    public void setObjectClassCode(String objectClassCode) {
        this.objectClassCode = objectClassCode;
    }

    /**
     * @return the objectClassCodeGuj
     */
    public String getObjectClassCodeGuj() {
        return objectClassCodeGuj;
    }

    /**
     * @param objectClassCodeGuj the objectClassCodeGuj to set
     */
    public void setObjectClassCodeGuj(String objectClassCodeGuj) {
        this.objectClassCodeGuj = objectClassCodeGuj;
    }

    /**
     * @return the objectClassCodeName
     */
    public String getObjectClassCodeName() {
        return objectClassCodeName;
    }

    /**
     * @param objectClassCodeName the objectClassCodeName to set
     */
    public void setObjectClassCodeName(String objectClassCodeName) {
        this.objectClassCodeName = objectClassCodeName;
    }

    /**
     * @return the objectClassTypeId
     */
    public Long getObjectClassTypeId() {
        return objectClassTypeId;
    }

    /**
     * @param objectClassTypeId the objectClassTypeId to set
     */
    public void setObjectClassTypeId(Long objectClassTypeId) {
        this.objectClassTypeId = objectClassTypeId;
    }


    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    /**
     * @return the parentObjectClassId
     */
    public Long getParentObjectClassId() {
        return parentObjectClassId;
    }

    /**
     * @param parentObjectClassId the parentObjectClassId to set
     */
    public void setParentObjectClassId(Long parentObjectClassId) {
        this.parentObjectClassId = parentObjectClassId;
    }

}

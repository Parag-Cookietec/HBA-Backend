package gov.ifms.pvu.edp;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * The Class EDPMsHeadDepartmentEntity.
 *
 * @version v 1.0
 * @created 2020/01/15 15:35:39
 */
@Entity
@Table(name = "MS_HOD", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsHeadDepartmentEntity extends BaseEntity implements Serializable {


    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOD_ID")
    private Long hodId;

    @Column(name = "HOD_NAME")
    private String hodName;

    @Column(name = "HOD_NAME_GUJ")
    private String hodnameGuj;

    @Column(name = "HOD_DESC")
    private String hodDesc;

    @Column(name = "HOD_DESC_GUJ")
    private String hodDescGuj;

    @Column(name = "HOD_CODE")
    private String hodCode;

    @Column(name = "HOD_CODE_GUJ")
    private String hodCodeGuj;

    @Column(name = "HOD_SHORT_NAME")
    private String hodShortName;

    @Column(name = "HOD_SHORT_NAME_GUJ")
    private String hodShortNameGuj;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private EDPMsDepartmentEntity departmentId;


    /**
     * EDPMsHeadDepartmentEntity Constructor
     */
    public EDPMsHeadDepartmentEntity() {
        super();
    }

    public EDPMsHeadDepartmentEntity(long hodNameId) {
        this.hodId = hodNameId;
    }

    /**
     * hascode method
     */
    @Override
    public int hashCode() {
        return Objects.hash(hodId, hodName, hodnameGuj, hodDesc, hodDescGuj, hodCode, hodCodeGuj, hodShortName, hodShortNameGuj, departmentId);
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
        if (!(obj instanceof EDPMsHeadDepartmentEntity)) {
            return false;
        }

        EDPMsHeadDepartmentEntity other = (EDPMsHeadDepartmentEntity) obj;

        return Objects.equals(hodId, other.hodId)
                && Objects.equals(hodName, other.hodName)
                && Objects.equals(hodnameGuj, other.hodnameGuj)
                && Objects.equals(hodDesc, other.hodDesc)
                && Objects.equals(hodDescGuj, other.hodDescGuj)
                && Objects.equals(hodCode, other.hodCode)
                && Objects.equals(hodCodeGuj, other.hodCodeGuj)
                && Objects.equals(hodShortName, other.hodShortName)
                && Objects.equals(hodShortNameGuj, other.hodShortNameGuj)
                && Objects.equals(departmentId, other.departmentId)
                ;
    }

    /**
     * toString method
     */
    @Override
    public String toString() {
        return "EDPMsHeadDepartmentEntity [hodId = " + hodId + ",hodName = " + hodName + ",hodnameGuj = " + hodnameGuj + ",hodDesc = " + hodDesc + ",hodDescGuj = " + hodDescGuj + ",hodCode = " + hodCode + ",hodCodeGuj = " + hodCodeGuj + ",hodShortName = " + hodShortName + ",hodShortNameGuj = " + hodShortNameGuj + ",departmentId = " + departmentId + ",]";
    }

    /**
     * getter setter
     */

    /**
     * @return the hodId
     */
    public Long getHodId() {
        return hodId;
    }

    /**
     * @param hodId the hodId to set
     */
    public void setHodId(Long hodId) {
        this.hodId = hodId;
    }

    /**
     * @return the hodName
     */
    public String getHodName() {
        return hodName;
    }

    /**
     * @param hodName the hodName to set
     */
    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    /**
     * @return the hodnameGuj
     */
    public String getHodnameGuj() {
        return hodnameGuj;
    }

    /**
     * @param hodnameGuj the hodnameGuj to set
     */
    public void setHodnameGuj(String hodnameGuj) {
        this.hodnameGuj = hodnameGuj;
    }

    /**
     * @return the hodDesc
     */
    public String getHodDesc() {
        return hodDesc;
    }

    /**
     * @param hodDesc the hodDesc to set
     */
    public void setHodDesc(String hodDesc) {
        this.hodDesc = hodDesc;
    }

    /**
     * @return the hodDescGuj
     */
    public String getHodDescGuj() {
        return hodDescGuj;
    }

    /**
     * @param hodDescGuj the hodDescGuj to set
     */
    public void setHodDescGuj(String hodDescGuj) {
        this.hodDescGuj = hodDescGuj;
    }

    /**
     * @return the hodCode
     */
    public String getHodCode() {
        return hodCode;
    }

    /**
     * @param hodCode the hodCode to set
     */
    public void setHodCode(String hodCode) {
        this.hodCode = hodCode;
    }

    /**
     * @return the hodCodeGuj
     */
    public String getHodCodeGuj() {
        return hodCodeGuj;
    }

    /**
     * @param hodCodeGuj the hodCodeGuj to set
     */
    public void setHodCodeGuj(String hodCodeGuj) {
        this.hodCodeGuj = hodCodeGuj;
    }

    /**
     * @return the hodShortName
     */
    public String getHodShortName() {
        return hodShortName;
    }

    /**
     * @param hodShortName the hodShortName to set
     */
    public void setHodShortName(String hodShortName) {
        this.hodShortName = hodShortName;
    }

    /**
     * @return the hodShortNameGuj
     */
    public String getHodShortNameGuj() {
        return hodShortNameGuj;
    }

    /**
     * @param hodShortNameGuj the hodShortNameGuj to set
     */
    public void setHodShortNameGuj(String hodShortNameGuj) {
        this.hodShortNameGuj = hodShortNameGuj;
    }

    /**
     * @return the departmentId
     */
    public EDPMsDepartmentEntity getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(EDPMsDepartmentEntity departmentId) {
        this.departmentId = departmentId;
    }
}

package gov.ifms.loc.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class BudgetMsDivisionEntity.
 *
 * @version 1.0
 * @created 2019/10/17 15:12:56
 */
@Entity
@Table(name = "MS_DIVISION", schema = Constant.EDP_MASTER_SCHEMA)
public class LocMsDivisonEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The divison id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIVISION_ID")
    private long divisonId;

    /**
     * The division name.
     */
    @Column(name = "DIVISION_NAME")
    private String divisionName;

    /**
     * The division name guj.
     */
    @Column(name = "DIVISION_NAME_GUJ")
    private String divisionNameGuj;

    /**
     * The division description.
     */
    @Column(name = "DIVISION_DESCRIPTION")
    private String divisionDescription;

    /**
     * The division description guj.
     */
    @Column(name = "DIVISION_DESCRIPTION_GUJ")
    private String divisionDescriptionGuj;

    /**
     * The division type id.
     */
    @Column(name = "DIVISION_TYPE_ID")
    private long divisionTypeId;

    /**
     * The parent division id.
     */
    @Column(name = "PARENT_DIVISION_ID")
    private long parentDivisionId;

    /**
     * The disirict id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
    private EDPMsDistrictEntity disirictId;

    /**
     * The department id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private EDPMsDepartmentEntity departmentId;

    /**
     * The div code.
     */
    @Column(name = "DIVISION_CD")
    private String divCode;

    /**
     * Gets the divison id.
     *
     * @return the divison id
     */
    public long getDivisonId() {
        return divisonId;
    }

    /**
     * Sets the divison id.
     *
     * @param divisonId the new divison id
     */
    public void setDivisonId(long divisonId) {
        this.divisonId = divisonId;
    }

    /**
     * Gets the division name.
     *
     * @return the division name
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Sets the division name.
     *
     * @param divisionName the new division name
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    /**
     * Gets the division name guj.
     *
     * @return the division name guj
     */
    public String getDivisionNameGuj() {
        return divisionNameGuj;
    }

    /**
     * Sets the division name guj.
     *
     * @param divisionNameGuj the new division name guj
     */
    public void setDivisionNameGuj(String divisionNameGuj) {
        this.divisionNameGuj = divisionNameGuj;
    }

    /**
     * Gets the division description.
     *
     * @return the division description
     */
    public String getDivisionDescription() {
        return divisionDescription;
    }

    /**
     * Sets the division description.
     *
     * @param divisionDescription the new division description
     */
    public void setDivisionDescription(String divisionDescription) {
        this.divisionDescription = divisionDescription;
    }

    /**
     * Gets the division description guj.
     *
     * @return the division description guj
     */
    public String getDivisionDescriptionGuj() {
        return divisionDescriptionGuj;
    }

    /**
     * Sets the division description guj.
     *
     * @param divisionDescriptionGuj the new division description guj
     */
    public void setDivisionDescriptionGuj(String divisionDescriptionGuj) {
        this.divisionDescriptionGuj = divisionDescriptionGuj;
    }

    /**
     * Gets the division type id.
     *
     * @return the division type id
     */
    public long getDivisionTypeId() {
        return divisionTypeId;
    }

    /**
     * Sets the division type id.
     *
     * @param divisionTypeId the new division type id
     */
    public void setDivisionTypeId(long divisionTypeId) {
        this.divisionTypeId = divisionTypeId;
    }

    /**
     * Gets the parent division id.
     *
     * @return the parent division id
     */
    public long getParentDivisionId() {
        return parentDivisionId;
    }

    /**
     * Sets the parent division id.
     *
     * @param parentDivisionId the new parent division id
     */
    public void setParentDivisionId(long parentDivisionId) {
        this.parentDivisionId = parentDivisionId;
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
     * BudgetMsDivisionDto Constructor.
     */
    public LocMsDivisonEntity() {
        super();
    }

    public LocMsDivisonEntity(Long id) {
        this.divisonId = id;
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

    /**
     * Gets the disirict id.
     *
     * @return the disirict id
     */
    public EDPMsDistrictEntity getDisirictId() {
        return disirictId;
    }

    /**
     * Sets the disirict id.
     *
     * @param disirictId the new disirict id
     */
    public void setDisirictId(EDPMsDistrictEntity disirictId) {
        this.disirictId = disirictId;
    }

    /**
     * @return the divCode
     */
    public String getDivCode() {
        return divCode;
    }

    /**
     * @param divCode the divCode to set
     */
    public void setDivCode(String divCode) {
        this.divCode = divCode;
    }

    /**
     * hascode method.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(divisonId, divisionName, divisionNameGuj, divisionDescription, divisionDescriptionGuj,
                divisionTypeId, parentDivisionId, disirictId);
    }

    /**
     * equals method.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LocMsDivisonEntity)) {
            return false;
        }

        LocMsDivisonEntity other = (LocMsDivisonEntity) obj;

        return Objects.equals(divisonId, other.divisonId) && Objects.equals(divisionName, other.divisionName)
                && Objects.equals(divisionNameGuj, other.divisionNameGuj)
                && Objects.equals(divisionDescription, other.divisionDescription)
                && Objects.equals(divisionDescriptionGuj, other.divisionDescriptionGuj)
                && Objects.equals(divisionTypeId, other.divisionTypeId)
                && Objects.equals(parentDivisionId, other.parentDivisionId)
                && Objects.equals(disirictId, other.disirictId);
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "BudgetMsDivisionEntity [divisionId = " + divisonId + ",divisonId = " + divisonId + ",divisionName = "
                + divisionName + ",divisionNameGuj = " + divisionNameGuj + ",divisionDescription = "
                + divisionDescription + ",divisionDescriptionGuj = " + divisionDescriptionGuj + ",divisionTypeId = "
                + divisionTypeId + ",parentDivisionId = " + parentDivisionId + ",districtId = " + disirictId + ",]";
    }

    /**
     * Instantiates a new loc ms divison entity.
     *
     * @param divisonId the divison id
     */
    public LocMsDivisonEntity(long divisonId) {
        super();
        this.divisonId = divisonId;
    }

}

package gov.ifms.loc.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Class LocMsDemandEntity.
 */
@Entity
@Table(name = "MS_DEMAND", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsDemandEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The demand id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEMAND_ID")
    private long demandId;

    /**
     * The demand name.
     */
    @Column(name = "DEMAND_NAME")
    private String demandName;

    /**
     * The demand name guj.
     */
    @Column(name = "DEMAND_NAME_GUJ")
    private String demandNameGuj;

    /**
     * The demand desc.
     */
    @Column(name = "DEMAND_DESC")
    private String demandDesc;

    /**
     * The demand desc guj.
     */
    @Column(name = "DEMAND_DESC_GUJ")
    private String demandDescGuj;

    /**
     * The demand code.
     */
    @Column(name = "DEMAND_CODE")
    private String demandCode;

    /**
     * The demand code guj.
     */
    @Column(name = "DEMAND_CODE_GUJ")
    private String demandCodeGuj;

    /**
     * The demand code name.
     */
    @Column(name = "DEMAND_CODE_NAME")
    private String demandCodeName;

    /**
     * The demand type id.
     */
    @Column(name = "DEMAND_TYPE_ID")
    private Long demandTypeId;

    /**
     * The parent demand id.
     */
    @Column(name = "PARENT_DEMAND_ID")
    private long parentDemandId;

    /**
     * The loc ms BPN entity.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BPN_ID", referencedColumnName = "BPN_ID", insertable = false, updatable = false)
    private LocMsBPNEntity locMsBPNEntity;

    /**
     * The look up info entity.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IS_COMMON_DEMAND_ID", referencedColumnName = "LOOKUP_INFO_ID")
    private EDPLuLookUpInfoEntity lookUpInfoEntity;

    /**
     * Instantiates a new loc ms demand entity.
     */
    public LocMsDemandEntity() {
        super();
    }

    /**
     * Gets the demand id.
     *
     * @return the demand id
     */
    public long getDemandId() {
        return demandId;
    }

    /**
     * Sets the demand id.
     *
     * @param demandId the new demand id
     */
    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }

    /**
     * Gets the demand name.
     *
     * @return the demand name
     */
    public String getDemandName() {
        return demandName;
    }

    /**
     * Sets the demand name.
     *
     * @param demandName the new demand name
     */
    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    /**
     * Gets the demand name guj.
     *
     * @return the demand name guj
     */
    public String getDemandNameGuj() {
        return demandNameGuj;
    }

    /**
     * Sets the demand name guj.
     *
     * @param demandNameGuj the new demand name guj
     */
    public void setDemandNameGuj(String demandNameGuj) {
        this.demandNameGuj = demandNameGuj;
    }

    /**
     * Gets the demand desc.
     *
     * @return the demand desc
     */
    public String getDemandDesc() {
        return demandDesc;
    }

    /**
     * Sets the demand desc.
     *
     * @param demandDesc the new demand desc
     */
    public void setDemandDesc(String demandDesc) {
        this.demandDesc = demandDesc;
    }

    /**
     * Gets the demand desc guj.
     *
     * @return the demand desc guj
     */
    public String getDemandDescGuj() {
        return demandDescGuj;
    }

    /**
     * Sets the demand desc guj.
     *
     * @param demandDescGuj the new demand desc guj
     */
    public void setDemandDescGuj(String demandDescGuj) {
        this.demandDescGuj = demandDescGuj;
    }

    /**
     * Gets the demand code.
     *
     * @return the demand code
     */
    public String getDemandCode() {
        return demandCode;
    }

    /**
     * Sets the demand code.
     *
     * @param demandCode the new demand code
     */
    public void setDemandCode(String demandCode) {
        this.demandCode = demandCode;
    }

    /**
     * Gets the demand code guj.
     *
     * @return the demand code guj
     */
    public String getDemandCodeGuj() {
        return demandCodeGuj;
    }

    /**
     * Sets the demand code guj.
     *
     * @param demandCodeGuj the new demand code guj
     */
    public void setDemandCodeGuj(String demandCodeGuj) {
        this.demandCodeGuj = demandCodeGuj;
    }

    /**
     * Gets the demand code name.
     *
     * @return the demand code name
     */
    public String getDemandCodeName() {
        return demandCodeName;
    }

    /**
     * Sets the demand code name.
     *
     * @param demandCodeName the new demand code name
     */
    public void setDemandCodeName(String demandCodeName) {
        this.demandCodeName = demandCodeName;
    }

    /**
     * Gets the demand type id.
     *
     * @return the demand type id
     */
    public Long getDemandTypeId() {
        return demandTypeId;
    }

    /**
     * Sets the demand type id.
     *
     * @param demandTypeId the new demand type id
     */
    public void setDemandTypeId(Long demandTypeId) {
        this.demandTypeId = demandTypeId;
    }

    /**
     * Gets the parent demand id.
     *
     * @return the parent demand id
     */
    public long getParentDemandId() {
        return parentDemandId;
    }

    /**
     * Sets the parent demand id.
     *
     * @param parentDemandId the new parent demand id
     */
    public void setParentDemandId(long parentDemandId) {
        this.parentDemandId = parentDemandId;
    }

    /**
     * Gets the budget ms BPN entity.
     *
     * @return the budget ms BPN entity
     */
    public LocMsBPNEntity getBudgetMsBPNEntity() {
        return locMsBPNEntity;
    }

    /**
     * Sets the budget ms BPN entity.
     *
     * @param locMsBPNEntity the new budget ms BPN entity
     */
    public void setBudgetMsBPNEntity(LocMsBPNEntity locMsBPNEntity) {
        this.locMsBPNEntity = locMsBPNEntity;
    }

    /**
     * Gets the look up info entity.
     *
     * @return the look up info entity
     */
    public EDPLuLookUpInfoEntity getLookUpInfoEntity() {
        return lookUpInfoEntity;
    }

    /**
     * Sets the look up info entity.
     *
     * @param lookUpInfoEntity the new look up info entity
     */
    public void setLookUpInfoEntity(EDPLuLookUpInfoEntity lookUpInfoEntity) {
        this.lookUpInfoEntity = lookUpInfoEntity;
    }

    /**
     * Instantiates a new loc ms demand entity.
     *
     * @param demandId the demand id
     */
    public LocMsDemandEntity(long demandId) {
        this.demandId = demandId;
    }
}
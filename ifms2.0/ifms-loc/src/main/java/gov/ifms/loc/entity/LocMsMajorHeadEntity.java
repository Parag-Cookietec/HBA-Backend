package gov.ifms.loc.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class BudgetMajorHeadEntity.
 *
 * @version 1.0
 * @created 2019/08/21 17:26:33
 */
@Entity
@Table(name = "MS_MAJORHEAD", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsMajorHeadEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * The major head id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAJORHEAD_ID")
    private Long majorHeadId;

    /**
     * The major head name.
     */
    @Column(name = "MAJORHEAD_NAME")
    private String majorHeadName;

    /**
     * The major head name guj.
     */
    @Column(name = "MAJORHEAD_NAME_GUJ")
    private String majorHeadNameGuj;

    /**
     * The major head desc.
     */
    @Column(name = "MAJORHEAD_DESC")
    private String majorHeadDesc;

    /**
     * The major head desc guj.
     */
    @Column(name = "MAJORHEAD_DESC_GUJ")
    private String majorHeadDescGuj;

    /**
     * The major head code.
     */
    @Column(name = "MAJORHEAD_CODE")
    private String majorHeadCode;

    /**
     * The major head code guj.
     */
    @Column(name = "MAJORHEAD_CODE_GUJ")
    private String majorHeadCodeGuj;

    /**
     * The major head code name.
     */
    @Column(name = "MAJORHEAD_CODE_NAME")
    private String majorHeadCodeName;

    /**
     * The major head type id.
     */
    @Column(name = "MAJORHEAD_TYPE_ID")
    private long majorHeadTypeId;

    /**
     * The major head accnt type.
     */
    @Column(name = "MAJORHEAD_ACCNT_TYPE")
    private String majorHeadAccntType;

    /**
     * The major head sub type.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAJORHEAD_SUB_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
    private EDPLuLookUpInfoEntity majorHeadSubType;

    /**
     * The parent major head id.
     */
    @Column(name = "PARENT_MAJORHEAD_ID")
    private Long parentMajorHeadId;

    /**
     * The sector head code.
     */
    @Column(name = "SECTORHEAD_CODE")
    private Long sectorHeadCode;

    /**
     * The sub sector code.
     */
    @Column(name = "SUB_SECTOR_CODE")
    private Long subSectorCode;

    /**
     * The sub sub sector code.
     */
    @Column(name = "SUB_SUB_SECTOR_CODE")
    private Long subSubSectorCode;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEMAND_ID", referencedColumnName = "DEMAND_ID")
    private LocMsDemandEntity budgetMsDemandEntities;

    /**
     * Instantiates a new loc ms major head entity.
     */
    public LocMsMajorHeadEntity() {
        super();
    }

    /**
     * Instantiates a new loc ms major head entity.
     *
     * @param majorHeadId the major head id
     */
    public LocMsMajorHeadEntity(Long majorHeadId) {
        super();
        this.majorHeadId = majorHeadId;
    }

    /**
     * Instantiates a new loc ms major head entity.
     *
     * @param majorHeadId   the major head id
     * @param majorHeadCode the major head code
     */
    public LocMsMajorHeadEntity(Long majorHeadId, String majorHeadCode) {
        super();
        this.majorHeadId = majorHeadId;
        this.majorHeadCode = majorHeadCode;
    }

    /**
     * Gets the major head id.
     *
     * @return the major head id
     */
    public Long getMajorHeadId() {
        return majorHeadId;
    }

    /**
     * Sets the major head id.
     *
     * @param majorHeadId the new major head id
     */
    public void setMajorHeadId(Long majorHeadId) {
        this.majorHeadId = majorHeadId;
    }

    /**
     * @return the majorHeadName
     */
    public String getMajorHeadName() {
        return majorHeadName;
    }

    /**
     * @return the majorHeadSubType
     */
    public EDPLuLookUpInfoEntity getMajorHeadSubType() {
        return majorHeadSubType;
    }

    /**
     * @param majorHeadSubType the majorHeadSubType to set
     */
    public void setMajorHeadSubType(EDPLuLookUpInfoEntity majorHeadSubType) {
        this.majorHeadSubType = majorHeadSubType;
    }

    /**
     * @param majorHeadName the majorHeadName to set
     */
    public void setMajorHeadName(String majorHeadName) {
        this.majorHeadName = majorHeadName;
    }

    /**
     * @return the majorHeadNameGuj
     */
    public String getMajorHeadNameGuj() {
        return majorHeadNameGuj;
    }

    /**
     * @param majorHeadNameGuj the majorHeadNameGuj to set
     */
    public void setMajorHeadNameGuj(String majorHeadNameGuj) {
        this.majorHeadNameGuj = majorHeadNameGuj;
    }

    /**
     * @return the majorHeadDesc
     */
    public String getMajorHeadDesc() {
        return majorHeadDesc;
    }

    /**
     * @param majorHeadDesc the majorHeadDesc to set
     */
    public void setMajorHeadDesc(String majorHeadDesc) {
        this.majorHeadDesc = majorHeadDesc;
    }

    /**
     * @return the majorHeadDescGuj
     */
    public String getMajorHeadDescGuj() {
        return majorHeadDescGuj;
    }

    /**
     * @param majorHeadDescGuj the majorHeadDescGuj to set
     */
    public void setMajorHeadDescGuj(String majorHeadDescGuj) {
        this.majorHeadDescGuj = majorHeadDescGuj;
    }

    /**
     * @return the majorHeadCode
     */
    public String getMajorHeadCode() {
        return majorHeadCode;
    }

    /**
     * @param majorHeadCode the majorHeadCode to set
     */
    public void setMajorHeadCode(String majorHeadCode) {
        this.majorHeadCode = majorHeadCode;
    }

    /**
     * @return the majorHeadCodeGuj
     */
    public String getMajorHeadCodeGuj() {
        return majorHeadCodeGuj;
    }

    /**
     * @param majorHeadCodeGuj the majorHeadCodeGuj to set
     */
    public void setMajorHeadCodeGuj(String majorHeadCodeGuj) {
        this.majorHeadCodeGuj = majorHeadCodeGuj;
    }

    /**
     * @return the majorHeadCodeName
     */
    public String getMajorHeadCodeName() {
        return majorHeadCodeName;
    }

    /**
     * @param majorHeadCodeName the majorHeadCodeName to set
     */
    public void setMajorHeadCodeName(String majorHeadCodeName) {
        this.majorHeadCodeName = majorHeadCodeName;
    }

    public LocMsDemandEntity getBudgetMsDemandEntities(){
        return budgetMsDemandEntities;
    }

    public void setBudgetMsDemandEntities(LocMsDemandEntity budgetMsDemandEntities){
        this.budgetMsDemandEntities = budgetMsDemandEntities;
    }

    /**
     * Instantiates a new loc ms major head entity.
     *
     * @param tempMajorHeadCode the temp major head code
     */
    public LocMsMajorHeadEntity(String tempMajorHeadCode) {
        this.majorHeadCode = tempMajorHeadCode;
    }

    /**
     * Gets the major head type id.
     *
     * @return the major head type id
     */
    public long getMajorHeadTypeId() {
        return majorHeadTypeId;
    }

    /**
     * Sets the major head type id.
     *
     * @param majorHeadTypeId the new major head type id
     */
    public void setMajorHeadTypeId(long majorHeadTypeId) {
        this.majorHeadTypeId = majorHeadTypeId;
    }

    /**
     * Gets the major head accnt type.
     *
     * @return the major head accnt type
     */
    public String getMajorHeadAccntType() {
        return majorHeadAccntType;
    }

    /**
     * Sets the major head accnt type.
     *
     * @param majorHeadAccntType the new major head accnt type
     */
    public void setMajorHeadAccntType(String majorHeadAccntType) {
        this.majorHeadAccntType = majorHeadAccntType;
    }

    /**
     * @return the parentMajorHeadId
     */
    public Long getParentMajorHeadId() {
        return parentMajorHeadId;
    }

    /**
     * @param parentMajorHeadId the parentMajorHeadId to set
     */
    public void setParentMajorHeadId(Long parentMajorHeadId) {
        this.parentMajorHeadId = parentMajorHeadId;
    }

    /**
     * @return the sectorHeadCode
     */
    public Long getSectorHeadCode() {
        return sectorHeadCode;
    }

    /**
     * @param sectorHeadCode the sectorHeadCode to set
     */
    public void setSectorHeadCode(Long sectorHeadCode) {
        this.sectorHeadCode = sectorHeadCode;
    }

    /**
     * @return the subSectorCode
     */
    public Long getSubSectorCode() {
        return subSectorCode;
    }

    /**
     * @param subSectorCode the subSectorCode to set
     */
    public void setSubSectorCode(Long subSectorCode) {
        this.subSectorCode = subSectorCode;
    }

    /**
     * @return the subSubSectorCode
     */
    public Long getSubSubSectorCode() {
        return subSubSectorCode;
    }

    /**
     * @param subSubSectorCode the subSubSectorCode to set
     */
    public void setSubSubSectorCode(Long subSubSectorCode) {
        this.subSubSectorCode = subSubSectorCode;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof LocMsMajorHeadEntity)) return false;
        LocMsMajorHeadEntity that = (LocMsMajorHeadEntity) o;
        return getMajorHeadTypeId() == that.getMajorHeadTypeId() && Objects.equals(getMajorHeadId(), that.getMajorHeadId()) && Objects.equals(getMajorHeadName(), that.getMajorHeadName()) && Objects.equals(getMajorHeadNameGuj(), that.getMajorHeadNameGuj()) && Objects.equals(getMajorHeadDesc(), that.getMajorHeadDesc()) && Objects.equals(getMajorHeadDescGuj(), that.getMajorHeadDescGuj()) && Objects.equals(getMajorHeadCode(), that.getMajorHeadCode()) && Objects.equals(getMajorHeadCodeGuj(), that.getMajorHeadCodeGuj()) && Objects.equals(getMajorHeadCodeName(), that.getMajorHeadCodeName()) && Objects.equals(getMajorHeadAccntType(), that.getMajorHeadAccntType()) && Objects.equals(getMajorHeadSubType(), that.getMajorHeadSubType()) && Objects.equals(getParentMajorHeadId(), that.getParentMajorHeadId()) && Objects.equals(getSectorHeadCode(), that.getSectorHeadCode()) && Objects.equals(getSubSectorCode(), that.getSubSectorCode()) && Objects.equals(getSubSubSectorCode(), that.getSubSubSectorCode()) && Objects.equals(getBudgetMsDemandEntities(), that.getBudgetMsDemandEntities());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getMajorHeadId(), getMajorHeadName(), getMajorHeadNameGuj(), getMajorHeadDesc(), getMajorHeadDescGuj(), getMajorHeadCode(), getMajorHeadCodeGuj(), getMajorHeadCodeName(), getMajorHeadTypeId(), getMajorHeadAccntType(), getMajorHeadSubType(), getParentMajorHeadId(), getSectorHeadCode(), getSubSectorCode(), getSubSubSectorCode(), getBudgetMsDemandEntities());
    }

    @Override
    public String toString(){
        return "LocMsMajorHeadEntity{" +
                "majorHeadId=" + majorHeadId +
                ", majorHeadName='" + majorHeadName + '\'' +
                ", majorHeadNameGuj='" + majorHeadNameGuj + '\'' +
                ", majorHeadDesc='" + majorHeadDesc + '\'' +
                ", majorHeadDescGuj='" + majorHeadDescGuj + '\'' +
                ", majorHeadCode='" + majorHeadCode + '\'' +
                ", majorHeadCodeGuj='" + majorHeadCodeGuj + '\'' +
                ", majorHeadCodeName='" + majorHeadCodeName + '\'' +
                ", majorHeadTypeId=" + majorHeadTypeId +
                ", majorHeadAccntType='" + majorHeadAccntType + '\'' +
                ", majorHeadSubType=" + majorHeadSubType +
                ", parentMajorHeadId=" + parentMajorHeadId +
                ", sectorHeadCode=" + sectorHeadCode +
                ", subSectorCode=" + subSectorCode +
                ", subSubSectorCode=" + subSubSectorCode +
                ", budgetMsDemandEntities=" + budgetMsDemandEntities +
                '}';
    }
}

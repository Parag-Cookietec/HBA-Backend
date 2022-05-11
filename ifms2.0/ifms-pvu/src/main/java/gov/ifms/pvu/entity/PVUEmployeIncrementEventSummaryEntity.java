package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
* The Class PVUIncrementEventSummaryEntity.
*
* @version v 1.0
* @created 2020/01/10 15:30:02
*
*/
@Entity
@Table(name = "T_PVU_IN_SMRY_NEW_PRP", schema = Constant.PVU_SCHEMA)
public class PVUEmployeIncrementEventSummaryEntity extends BaseEntity implements Serializable {

   /**  The serialVersionUID. */
   private static final long serialVersionUID = 1L;

   /** The in smry id. */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "T_PVU_IN_SMRY_ID")
   private long inSmryId;

   /** The in event id. */
   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "T_PVU_IN_EVNT_ID", nullable = false, referencedColumnName = "T_PVU_IN_EVNT_ID")
   private PVUIncrementEventEntity inEventId;

    @Column(name = "CLASS_1_TOTAL_COUNT")
    private long classOneTotalCount;
    @Column(name = "CLASS_2_TOTAL_COUNT")
    private long classTwoTotalCount;
    @Column(name = "CLASS_3_TOTAL_COUNT")
    private long classThreeTotalCount;
    @Column(name = "CLASS_4_TOTAL_COUNT")
    private long classFourTotalCount;
    @Column(name = "NO_GRADE_TOTAL_COUNT")
    private long noGradeTotalCount;

    @Column(name = "CLASS_1_ELG_COUNT")
    private long classOneElgCount;
    @Column(name = "CLASS_2_ELG_COUNT")
    private long classTwoElgCount;
    @Column(name = "CLASS_3_ELG_COUNT")
    private long classThreeElgCount;
    @Column(name = "CLASS_4_ELG_COUNT")
    private long classFourElgCount;
    @Column(name = "NO_GRADE_ELG_COUNT")
    private long noGradeElgCount;

    @Column(name = "CLASS_1_INELG_COUNT")
    private long classOneINElgCount;
    @Column(name = "CLASS_2_INELG_COUNT")
    private long classTwoINElgCount;
    @Column(name = "CLASS_3_INELG_COUNT")
    private long classThreeINElgCount;
    @Column(name = "CLASS_4_INELG_COUNT")
    private long classFourINElgCount;
    @Column(name = "NO_GRADE_INELG_COUNT")
    private long noGradeINElgCount;

    /** The class one incl count. */
   @Column(name = "CLASS_1_INCL_COUNT")
   private long classOneInclCount;
   /** The class two incl count. */
   @Column(name = "CLASS_2_INCL_COUNT")
   private long classTwoInclCount;
   /** The class three incl count. */
   @Column(name = "CLASS_3_INCL_COUNT")
   private long classThreeInclCount;
   /** The class four incl count. */
   @Column(name = "CLASS_4_INCL_COUNT")
   private long classFourInclCount;
    @Column(name = "NO_GRADE_INCL_COUNT")
    private long noGradeInclCount;

    /** The class one excl count. */
   @Column(name = "CLASS_1_EXCL_COUNT")
   private long classOneExclCount;
   /** The class two excl count. */
   @Column(name = "CLASS_2_EXCL_COUNT")
   private long classTwoExclCount;
   /** The class three excl count. */
   @Column(name = "CLASS_3_EXCL_COUNT")
   private long classThreeExclCount;
   /** The class four excl count. */
   @Column(name = "CLASS_4_EXCL_COUNT")
   private long classFourExclCount;
   @Column(name = "NO_GRADE_EXCL_COUNT")
   private long noGradeExclCount;

    /** The class one incl count. */
    @Column(name = "CLASS_1_PROC_COUNT")
    private long classOneProcCount;
    /** The class two incl count. */
    @Column(name = "CLASS_2_PROC_COUNT")
    private long classTwoProcCount;
    /** The class three incl count. */
    @Column(name = "CLASS_3_PROC_COUNT")
    private long classThreeProcCount;
    /** The class four incl count. */
    @Column(name = "CLASS_4_PROC_COUNT")
    private long classFourProcCount;
    @Column(name = "NO_GRADE_PROC_COUNT")
    private long noGradeProcCount;

    /** The class one incl count. */
    @Column(name = "CLASS_1_FAIL_COUNT")
    private long classOneFailCount;
    /** The class two incl count. */
    @Column(name = "CLASS_2_FAIL_COUNT")
    private long classTwoFailCount;
    /** The class three incl count. */
    @Column(name = "CLASS_3_FAIL_COUNT")
    private long classThreeFailCount;
    /** The class four incl count. */
    @Column(name = "CLASS_4_FAIL_COUNT")
    private long classFourFailCount;
    @Column(name = "NO_GRADE_FAIL_COUNT")
    private long noGradeFailCount;

   /** The remarks. */
   @Column(name = "REMARKS")
   private String remarks;

   /** The status id. */
   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "STATUS_ID", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
   private EDPLuLookUpInfoEntity statusId;

   /**
    * PVUIncrementEventSummaryEntity Constructor.
    */
   public PVUEmployeIncrementEventSummaryEntity() {
       super();
   }

   public PVUEmployeIncrementEventSummaryEntity(Long inSmryId) {
       this.inSmryId = inSmryId;
   }

   /**
    * Gets the in smry id.
    *
    * @return the inSmryId
    */
   public long getInSmryId() {
       return inSmryId;
   }

   /**
    * Sets the in smry id.
    *
    * @param inSmryId the inSmryId to set
    */
   public void setInSmryId(long inSmryId) {
       this.inSmryId = inSmryId;
   }

   /**
    * Gets the in event id.
    *
    * @return the inEventId
    */
   public PVUIncrementEventEntity getInEventId() {
       return inEventId;
   }

   /**
    * Sets the in event id.
    *
    * @param inEventId the inEventId to set
    */
   public void setInEventId(PVUIncrementEventEntity inEventId) {
       this.inEventId = inEventId;
   }

   /**
    * Gets the class one incl count.
    *
    * @return the classOneInclCount
    */
   public long getClassOneInclCount() {
       return classOneInclCount;
   }

   /**
    * Sets the class one incl count.
    *
    * @param classOneInclCount the classOneInclCount to set
    */
   public void setClassOneInclCount(long classOneInclCount) {
       this.classOneInclCount = classOneInclCount;
   }

   /**
    * Gets the class two incl count.
    *
    * @return the classTwoInclCount
    */
   public long getClassTwoInclCount() {
       return classTwoInclCount;
   }

   /**
    * Sets the class two incl count.
    *
    * @param classTwoInclCount the classTwoInclCount to set
    */
   public void setClassTwoInclCount(long classTwoInclCount) {
       this.classTwoInclCount = classTwoInclCount;
   }

   /**
    * Gets the class three incl count.
    *
    * @return the classThreeInclCount
    */
   public long getClassThreeInclCount() {
       return classThreeInclCount;
   }

   /**
    * Sets the class three incl count.
    *
    * @param classThreeInclCount the classThreeInclCount to set
    */
   public void setClassThreeInclCount(long classThreeInclCount) {
       this.classThreeInclCount = classThreeInclCount;
   }

   /**
    * Gets the class four incl count.
    *
    * @return the classFourInclCount
    */
   public long getClassFourInclCount() {
       return classFourInclCount;
   }

   /**
    * Sets the class four incl count.
    *
    * @param classFourInclCount the classFourInclCount to set
    */
   public void setClassFourInclCount(long classFourInclCount) {
       this.classFourInclCount = classFourInclCount;
   }

   /**
    * Gets the class one excl count.
    *
    * @return the classOneExclCount
    */
   public long getClassOneExclCount() {
       return classOneExclCount;
   }

   /**
    * Sets the class one excl count.
    *
    * @param classOneExclCount the classOneExclCount to set
    */
   public void setClassOneExclCount(long classOneExclCount) {
       this.classOneExclCount = classOneExclCount;
   }

   /**
    * Gets the class two excl count.
    *
    * @return the classTwoExclCount
    */
   public long getClassTwoExclCount() {
       return classTwoExclCount;
   }

   /**
    * Sets the class two excl count.
    *
    * @param classTwoExclCount the classTwoExclCount to set
    */
   public void setClassTwoExclCount(long classTwoExclCount) {
       this.classTwoExclCount = classTwoExclCount;
   }

   /**
    * Gets the class three excl count.
    *
    * @return the classThreeExclCount
    */
   public long getClassThreeExclCount() {
       return classThreeExclCount;
   }

   /**
    * Sets the class three excl count.
    *
    * @param classThreeExclCount the classThreeExclCount to set
    */
   public void setClassThreeExclCount(long classThreeExclCount) {
       this.classThreeExclCount = classThreeExclCount;
   }

   /**
    * Gets the class four excl count.
    *
    * @return the classFourExclCount
    */
   public long getClassFourExclCount() {
       return classFourExclCount;
   }

   /**
    * Sets the class four excl count.
    *
    * @param classFourExclCount the classFourExclCount to set
    */
   public void setClassFourExclCount(long classFourExclCount) {
       this.classFourExclCount = classFourExclCount;
   }

   /**
    * Gets the remarks.
    *
    * @return the remarks
    */
   public String getRemarks() {
       return remarks;
   }

   /**
    * Sets the remarks.
    *
    * @param remarks the remarks to set
    */
   public void setRemarks(String remarks) {
       this.remarks = remarks;
   }

   /**
    * Gets the status id.
    *
    * @return the statusId
    */
   public EDPLuLookUpInfoEntity getStatusId() {
       return statusId;
   }

   /**
    * Sets the status id.
    *
    * @param statusId the statusId to set
    */
   public void setStatusId(EDPLuLookUpInfoEntity statusId) {
       this.statusId = statusId;
   }

    public long getClassOneTotalCount() {
        return classOneTotalCount;
    }

    public void setClassOneTotalCount(long classOneTotalCount) {
        this.classOneTotalCount = classOneTotalCount;
    }

    public long getClassTwoTotalCount() {
        return classTwoTotalCount;
    }

    public void setClassTwoTotalCount(long classTwoTotalCount) {
        this.classTwoTotalCount = classTwoTotalCount;
    }

    public long getClassThreeTotalCount() {
        return classThreeTotalCount;
    }

    public void setClassThreeTotalCount(long classThreeTotalCount) {
        this.classThreeTotalCount = classThreeTotalCount;
    }

    public long getClassFourTotalCount() {
        return classFourTotalCount;
    }

    public void setClassFourTotalCount(long classFourTotalCount) {
        this.classFourTotalCount = classFourTotalCount;
    }

    public long getNoGradeTotalCount() {
        return noGradeTotalCount;
    }

    public void setNoGradeTotalCount(long noGradeTotalCount) {
        this.noGradeTotalCount = noGradeTotalCount;
    }

    public long getClassOneElgCount() {
        return classOneElgCount;
    }

    public void setClassOneElgCount(long classOneElgCount) {
        this.classOneElgCount = classOneElgCount;
    }

    public long getClassTwoElgCount() {
        return classTwoElgCount;
    }

    public void setClassTwoElgCount(long classTwoElgCount) {
        this.classTwoElgCount = classTwoElgCount;
    }

    public long getClassThreeElgCount() {
        return classThreeElgCount;
    }

    public void setClassThreeElgCount(long classThreeElgCount) {
        this.classThreeElgCount = classThreeElgCount;
    }

    public long getClassFourElgCount() {
        return classFourElgCount;
    }

    public void setClassFourElgCount(long classFourElgCount) {
        this.classFourElgCount = classFourElgCount;
    }

    public long getNoGradeElgCount() {
        return noGradeElgCount;
    }

    public void setNoGradeElgCount(long noGradeElgCount) {
        this.noGradeElgCount = noGradeElgCount;
    }

    public long getClassOneINElgCount() {
        return classOneINElgCount;
    }

    public void setClassOneINElgCount(long classOneINElgCount) {
        this.classOneINElgCount = classOneINElgCount;
    }

    public long getClassTwoINElgCount() {
        return classTwoINElgCount;
    }

    public void setClassTwoINElgCount(long classTwoINElgCount) {
        this.classTwoINElgCount = classTwoINElgCount;
    }

    public long getClassThreeINElgCount() {
        return classThreeINElgCount;
    }

    public void setClassThreeINElgCount(long classThreeINElgCount) {
        this.classThreeINElgCount = classThreeINElgCount;
    }

    public long getClassFourINElgCount() {
        return classFourINElgCount;
    }

    public void setClassFourINElgCount(long classFourINElgCount) {
        this.classFourINElgCount = classFourINElgCount;
    }

    public long getNoGradeINElgCount() {
        return noGradeINElgCount;
    }

    public void setNoGradeINElgCount(long noGradeINElgCount) {
        this.noGradeINElgCount = noGradeINElgCount;
    }

    public long getNoGradeInclCount() {
        return noGradeInclCount;
    }

    public void setNoGradeInclCount(long noGradeInclCount) {
        this.noGradeInclCount = noGradeInclCount;
    }

    public long getNoGradeExclCount() {
        return noGradeExclCount;
    }

    public void setNoGradeExclCount(long noGradeExclCount) {
        this.noGradeExclCount = noGradeExclCount;
    }

    public long getClassOneProcCount() {
        return classOneProcCount;
    }

    public void setClassOneProcCount(long classOneProcCount) {
        this.classOneProcCount = classOneProcCount;
    }

    public long getClassTwoProcCount() {
        return classTwoProcCount;
    }

    public void setClassTwoProcCount(long classTwoProcCount) {
        this.classTwoProcCount = classTwoProcCount;
    }

    public long getClassThreeProcCount() {
        return classThreeProcCount;
    }

    public void setClassThreeProcCount(long classThreeProcCount) {
        this.classThreeProcCount = classThreeProcCount;
    }

    public long getClassFourProcCount() {
        return classFourProcCount;
    }

    public void setClassFourProcCount(long classFourProcCount) {
        this.classFourProcCount = classFourProcCount;
    }

    public long getNoGradeProcCount() {
        return noGradeProcCount;
    }

    public void setNoGradeProcCount(long noGradeProcCount) {
        this.noGradeProcCount = noGradeProcCount;
    }

    public long getClassOneFailCount() {
        return classOneFailCount;
    }

    public void setClassOneFailCount(long classOneFailCount) {
        this.classOneFailCount = classOneFailCount;
    }

    public long getClassTwoFailCount() {
        return classTwoFailCount;
    }

    public void setClassTwoFailCount(long classTwoFailCount) {
        this.classTwoFailCount = classTwoFailCount;
    }

    public long getClassThreeFailCount() {
        return classThreeFailCount;
    }

    public void setClassThreeFailCount(long classThreeFailCount) {
        this.classThreeFailCount = classThreeFailCount;
    }

    public long getClassFourFailCount() {
        return classFourFailCount;
    }

    public void setClassFourFailCount(long classFourFailCount) {
        this.classFourFailCount = classFourFailCount;
    }

    public long getNoGradeFailCount() {
        return noGradeFailCount;
    }

    public void setNoGradeFailCount(long noGradeFailCount) {
        this.noGradeFailCount = noGradeFailCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PVUEmployeIncrementEventSummaryEntity)) return false;
        PVUEmployeIncrementEventSummaryEntity that = (PVUEmployeIncrementEventSummaryEntity) o;
        return getInSmryId() == that.getInSmryId() &&
                getClassOneTotalCount() == that.getClassOneTotalCount() &&
                getClassTwoTotalCount() == that.getClassTwoTotalCount() &&
                getClassThreeTotalCount() == that.getClassThreeTotalCount() &&
                getClassFourTotalCount() == that.getClassFourTotalCount() &&
                getNoGradeTotalCount() == that.getNoGradeTotalCount() &&
                getClassOneElgCount() == that.getClassOneElgCount() &&
                getClassTwoElgCount() == that.getClassTwoElgCount() &&
                getClassThreeElgCount() == that.getClassThreeElgCount() &&
                getClassFourElgCount() == that.getClassFourElgCount() &&
                getNoGradeElgCount() == that.getNoGradeElgCount() &&
                getClassOneINElgCount() == that.getClassOneINElgCount() &&
                getClassTwoINElgCount() == that.getClassTwoINElgCount() &&
                getClassThreeINElgCount() == that.getClassThreeINElgCount() &&
                getClassFourINElgCount() == that.getClassFourINElgCount() &&
                getNoGradeINElgCount() == that.getNoGradeINElgCount() &&
                getClassOneInclCount() == that.getClassOneInclCount() &&
                getClassTwoInclCount() == that.getClassTwoInclCount() &&
                getClassThreeInclCount() == that.getClassThreeInclCount() &&
                getClassFourInclCount() == that.getClassFourInclCount() &&
                getNoGradeInclCount() == that.getNoGradeInclCount() &&
                getClassOneExclCount() == that.getClassOneExclCount() &&
                getClassTwoExclCount() == that.getClassTwoExclCount() &&
                getClassThreeExclCount() == that.getClassThreeExclCount() &&
                getClassFourExclCount() == that.getClassFourExclCount() &&
                getNoGradeExclCount() == that.getNoGradeExclCount() &&
                getClassOneProcCount() == that.getClassOneProcCount() &&
                getClassTwoProcCount() == that.getClassTwoProcCount() &&
                getClassThreeProcCount() == that.getClassThreeProcCount() &&
                getClassFourProcCount() == that.getClassFourProcCount() &&
                getNoGradeProcCount() == that.getNoGradeProcCount() &&
                getClassOneFailCount() == that.getClassOneFailCount() &&
                getClassTwoFailCount() == that.getClassTwoFailCount() &&
                getClassThreeFailCount() == that.getClassThreeFailCount() &&
                getClassFourFailCount() == that.getClassFourFailCount() &&
                getNoGradeFailCount() == that.getNoGradeFailCount() &&
                Objects.equals(getInEventId(), that.getInEventId()) &&
                Objects.equals(getRemarks(), that.getRemarks()) &&
                Objects.equals(getStatusId(), that.getStatusId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInSmryId(), getInEventId(), getClassOneTotalCount(), getClassTwoTotalCount(), getClassThreeTotalCount(), getClassFourTotalCount(), getNoGradeTotalCount(), getClassOneElgCount(), getClassTwoElgCount(), getClassThreeElgCount(), getClassFourElgCount(), getNoGradeElgCount(), getClassOneINElgCount(), getClassTwoINElgCount(), getClassThreeINElgCount(), getClassFourINElgCount(), getNoGradeINElgCount(), getClassOneInclCount(), getClassTwoInclCount(), getClassThreeInclCount(), getClassFourInclCount(), getNoGradeInclCount(), getClassOneExclCount(), getClassTwoExclCount(), getClassThreeExclCount(), getClassFourExclCount(), getNoGradeExclCount(), getClassOneProcCount(), getClassTwoProcCount(), getClassThreeProcCount(), getClassFourProcCount(), getNoGradeProcCount(), getClassOneFailCount(), getClassTwoFailCount(), getClassThreeFailCount(), getClassFourFailCount(), getNoGradeFailCount(), getRemarks(), getStatusId());
    }

    @Override
    public String toString() {
        return "PVUEmployeeIncrementEventSummaryEntity{" +
                "inSmryId=" + inSmryId +
                ", inEventId=" + inEventId +
                ", classOneTotalCount=" + classOneTotalCount +
                ", classTwoTotalCount=" + classTwoTotalCount +
                ", classThreeTotalCount=" + classThreeTotalCount +
                ", classFourTotalCount=" + classFourTotalCount +
                ", noGradeTotalCount=" + noGradeTotalCount +
                ", classOneElgCount=" + classOneElgCount +
                ", classTwoElgCount=" + classTwoElgCount +
                ", classThreeElgCount=" + classThreeElgCount +
                ", classFourElgCount=" + classFourElgCount +
                ", noGradeElgCount=" + noGradeElgCount +
                ", classOneINElgCount=" + classOneINElgCount +
                ", classTwoINElgCount=" + classTwoINElgCount +
                ", classThreeINElgCount=" + classThreeINElgCount +
                ", classFourINElgCount=" + classFourINElgCount +
                ", noGradeINElgCount=" + noGradeINElgCount +
                ", classOneInclCount=" + classOneInclCount +
                ", classTwoInclCount=" + classTwoInclCount +
                ", classThreeInclCount=" + classThreeInclCount +
                ", classFourInclCount=" + classFourInclCount +
                ", noGradeInclCount=" + noGradeInclCount +
                ", classOneExclCount=" + classOneExclCount +
                ", classTwoExclCount=" + classTwoExclCount +
                ", classThreeExclCount=" + classThreeExclCount +
                ", classFourExclCount=" + classFourExclCount +
                ", noGradeExclCount=" + noGradeExclCount +
                ", classOneProcCount=" + classOneProcCount +
                ", classTwoProcCount=" + classTwoProcCount +
                ", classThreeProcCount=" + classThreeProcCount +
                ", classFourProcCount=" + classFourProcCount +
                ", noGradeProcCount=" + noGradeProcCount +
                ", classOneFailCount=" + classOneFailCount +
                ", classTwoFailCount=" + classTwoFailCount +
                ", classThreeFailCount=" + classThreeFailCount +
                ", classFourFailCount=" + classFourFailCount +
                ", noGradeFailCount=" + noGradeFailCount +
                ", remarks='" + remarks + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}

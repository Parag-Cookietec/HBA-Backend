package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

@NativeQueryResultEntity
public class PVURegularIncrementSuccessCountView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The primary id. */
    @NativeQueryResultColumn(index = 0)
    private Long T_PVU_IN_EMP_SD_ID;

    /** The increment event id. */
    @NativeQueryResultColumn(index = 1)
    private Long T_PVU_IN_EVNT_ID;

    /** The emp id. */
    @NativeQueryResultColumn(index = 2)
    private Long EMP_ID;

    /** The current pay level. */
    @NativeQueryResultColumn(index = 3)
    private Long C_PAY_LEVEL;

    @NativeQueryResultColumn(index = 4)
    private Long C_CELL_ID;

    @NativeQueryResultColumn(index = 5)
    private Long C_GRADE;

    @NativeQueryResultColumn(index = 6)
    private Long C_SCALE;

    @NativeQueryResultColumn(index = 7)
    private Long C_PAY_BAND;

    @NativeQueryResultColumn(index = 8)
    private Long C_PAY_BAND_VALUE;

    /** The cur grade pay. */
    @NativeQueryResultColumn(index = 9)
    private Long C_GRADE_PAY;

    /** The cur basic pay. */
    @NativeQueryResultColumn(index = 10)
    private Long C_BASIC_PAY;

    /** The revised pay level. */
    @NativeQueryResultColumn(index = 11)
    private Long R_PAY_LEVEL;

    /** The revised cell id. */
    @NativeQueryResultColumn(index = 12)
    private Long R_CELL_ID;

    @NativeQueryResultColumn(index = 13)
    private Long R_GRADE;

    /** The revised grade. */
    @NativeQueryResultColumn(index = 14)
    private Long R_SCALE;

    /** The revised pay band. */
    @NativeQueryResultColumn(index = 15)
    private Long R_PAY_BAND;

    /** The revised pay band value. */
    @NativeQueryResultColumn(index = 16)
    private Long R_PAY_BAND_VALUE;

    @NativeQueryResultColumn(index = 17)
    private Long R_GRADE_PAY;

    /** The revised basic pay. */
    @NativeQueryResultColumn(index = 18)
    private Long R_BASIC_PAY;

    /** The revised effective. */
    @NativeQueryResultColumn(index = 19)
    private Date R_EFF_DATE;

    @NativeQueryResultColumn(index = 20)
    private Date R_DATE_OF_INC;

    /** The difference amount. */
    @NativeQueryResultColumn(index = 21)
    private Long DIFF_AMT;

    /** The reason for exclude. */
    @NativeQueryResultColumn(index = 22)
    private Long REASON_FOR_EXCLUDE;

    @NativeQueryResultColumn(index = 23)
    private Long STOP_INCREMENT_TYPE;

    @NativeQueryResultColumn(index = 24)
    private Date FROM_DATE;

    @NativeQueryResultColumn(index = 25)
    private Date TO_DATE;

    @NativeQueryResultColumn(index = 26)
    private Date DATE_NXT_INC;

    @NativeQueryResultColumn(index = 27)
    private Long CLASS_ID;

    @NativeQueryResultColumn(index = 28)
    private Long DESIGNATION_ID;

    @NativeQueryResultColumn(index = 29)
    private String REMARKS;

    @NativeQueryResultColumn(index = 30)
    private Long CREATED_BY;

    @NativeQueryResultColumn(index = 31)
    private Date CREATED_DATE;

    @NativeQueryResultColumn(index = 32)
    private Long CREATED_BY_POST;

    @NativeQueryResultColumn(index = 33)
    private Long UPDATED_BY;

    @NativeQueryResultColumn(index = 34)
    private Date UPDATED_DATE;

    @NativeQueryResultColumn(index = 35)
    private Long UPDATED_BY_POST;

    @NativeQueryResultColumn(index = 36)
    private Long ACTIVE_STATUS;

    @NativeQueryResultColumn(index = 37)
    private Long STATUS_ID;

    @NativeQueryResultColumn(index = 38)
    private Date SUS_START_DATE;

    @NativeQueryResultColumn(index = 39)
    private Date SUS_END_DATE;

    @NativeQueryResultColumn(index = 40)
    private Date EOL_START_DATE;

    @NativeQueryResultColumn(index = 41)
    private Date EOL_END_DATE;

    @NativeQueryResultColumn(index = 42)
    private Long SYSTEM_EXCL;

    @NativeQueryResultColumn(index = 43)
    private String INCREMENT_TYPE;

    @NativeQueryResultColumn(index = 44)
    private Long EMP_TYPE;

    @NativeQueryResultColumn(index = 45)
    private String GPF;

    @NativeQueryResultColumn(index = 46)
    private Long IS_ELIGIBLE;

    @NativeQueryResultColumn(index = 47)
    private Long IS_INCLUDED;

    @NativeQueryResultColumn(index = 48)
    private Long DEPT_CAT;

    @NativeQueryResultColumn(index = 49)
    private Long LAST_PAY_SCALE;

    @NativeQueryResultColumn(index = 50)
    private Long WHL_IS_ELIGIBLE;

    @NativeQueryResultColumn(index = 51)
    private Long LAST_PAY_LEVEL;

    @NativeQueryResultColumn(index = 52)
    private Long LAST_GRD_PAY;

    @NativeQueryResultColumn(index = 53)
    private Long EMPLOYEE_NO;

    @NativeQueryResultColumn(index = 54)
    private String EMPLOYEE_NAME;

    @NativeQueryResultColumn(index = 55)
    private Date DATE_JOINING;

    public Long getEMPLOYEE_NO() {
        return EMPLOYEE_NO;
    }

    public void setEMPLOYEE_NO(Long EMPLOYEE_NO) {
        this.EMPLOYEE_NO = EMPLOYEE_NO;
    }

    public String getEMPLOYEE_NAME() {
        return EMPLOYEE_NAME;
    }

    public void setEMPLOYEE_NAME(String EMPLOYEE_NAME) {
        this.EMPLOYEE_NAME = EMPLOYEE_NAME;
    }

    public Date getDATE_JOINING() {
        return DATE_JOINING;
    }

    public void setDATE_JOINING(Date DATE_JOINING) {
        this.DATE_JOINING = DATE_JOINING;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getT_PVU_IN_EMP_SD_ID() {
        return T_PVU_IN_EMP_SD_ID;
    }

    public void setT_PVU_IN_EMP_SD_ID(Long t_PVU_IN_EMP_SD_ID) {
        T_PVU_IN_EMP_SD_ID = t_PVU_IN_EMP_SD_ID;
    }

    public Long getT_PVU_IN_EVNT_ID() {
        return T_PVU_IN_EVNT_ID;
    }

    public void setT_PVU_IN_EVNT_ID(Long t_PVU_IN_EVNT_ID) {
        T_PVU_IN_EVNT_ID = t_PVU_IN_EVNT_ID;
    }

    public Long getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(Long EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public Long getC_PAY_LEVEL() {
        return C_PAY_LEVEL;
    }

    public void setC_PAY_LEVEL(Long c_PAY_LEVEL) {
        C_PAY_LEVEL = c_PAY_LEVEL;
    }

    public Long getC_CELL_ID() {
        return C_CELL_ID;
    }

    public void setC_CELL_ID(Long c_CELL_ID) {
        C_CELL_ID = c_CELL_ID;
    }

    public Long getC_GRADE() {
        return C_GRADE;
    }

    public void setC_GRADE(Long c_GRADE) {
        C_GRADE = c_GRADE;
    }

    public Long getC_SCALE() {
        return C_SCALE;
    }

    public void setC_SCALE(Long c_SCALE) {
        C_SCALE = c_SCALE;
    }

    public Long getC_PAY_BAND() {
        return C_PAY_BAND;
    }

    public void setC_PAY_BAND(Long c_PAY_BAND) {
        C_PAY_BAND = c_PAY_BAND;
    }

    public Long getC_PAY_BAND_VALUE() {
        return C_PAY_BAND_VALUE;
    }

    public void setC_PAY_BAND_VALUE(Long c_PAY_BAND_VALUE) {
        C_PAY_BAND_VALUE = c_PAY_BAND_VALUE;
    }

    public Long getC_GRADE_PAY() {
        return C_GRADE_PAY;
    }

    public void setC_GRADE_PAY(Long c_GRADE_PAY) {
        C_GRADE_PAY = c_GRADE_PAY;
    }

    public Long getC_BASIC_PAY() {
        return C_BASIC_PAY;
    }

    public void setC_BASIC_PAY(Long c_BASIC_PAY) {
        C_BASIC_PAY = c_BASIC_PAY;
    }

    public Long getR_PAY_LEVEL() {
        return R_PAY_LEVEL;
    }

    public void setR_PAY_LEVEL(Long r_PAY_LEVEL) {
        R_PAY_LEVEL = r_PAY_LEVEL;
    }

    public Long getR_CELL_ID() {
        return R_CELL_ID;
    }

    public void setR_CELL_ID(Long r_CELL_ID) {
        R_CELL_ID = r_CELL_ID;
    }

    public Long getR_GRADE() {
        return R_GRADE;
    }

    public void setR_GRADE(Long r_GRADE) {
        R_GRADE = r_GRADE;
    }

    public Long getR_SCALE() {
        return R_SCALE;
    }

    public void setR_SCALE(Long r_SCALE) {
        R_SCALE = r_SCALE;
    }

    public Long getR_PAY_BAND() {
        return R_PAY_BAND;
    }

    public void setR_PAY_BAND(Long r_PAY_BAND) {
        R_PAY_BAND = r_PAY_BAND;
    }

    public Long getR_PAY_BAND_VALUE() {
        return R_PAY_BAND_VALUE;
    }

    public void setR_PAY_BAND_VALUE(Long r_PAY_BAND_VALUE) {
        R_PAY_BAND_VALUE = r_PAY_BAND_VALUE;
    }

    public Long getR_GRADE_PAY() {
        return R_GRADE_PAY;
    }

    public void setR_GRADE_PAY(Long r_GRADE_PAY) {
        R_GRADE_PAY = r_GRADE_PAY;
    }

    public Long getR_BASIC_PAY() {
        return R_BASIC_PAY;
    }

    public void setR_BASIC_PAY(Long r_BASIC_PAY) {
        R_BASIC_PAY = r_BASIC_PAY;
    }

    public Date getR_EFF_DATE() {
        return R_EFF_DATE;
    }

    public void setR_EFF_DATE(Date r_EFF_DATE) {
        R_EFF_DATE = r_EFF_DATE;
    }

    public Date getR_DATE_OF_INC() {
        return R_DATE_OF_INC;
    }

    public void setR_DATE_OF_INC(Date r_DATE_OF_INC) {
        R_DATE_OF_INC = r_DATE_OF_INC;
    }

    public Long getDIFF_AMT() {
        return DIFF_AMT;
    }

    public void setDIFF_AMT(Long DIFF_AMT) {
        this.DIFF_AMT = DIFF_AMT;
    }

    public Long getREASON_FOR_EXCLUDE() {
        return REASON_FOR_EXCLUDE;
    }

    public void setREASON_FOR_EXCLUDE(Long REASON_FOR_EXCLUDE) {
        this.REASON_FOR_EXCLUDE = REASON_FOR_EXCLUDE;
    }

    public Long getSTOP_INCREMENT_TYPE() {
        return STOP_INCREMENT_TYPE;
    }

    public void setSTOP_INCREMENT_TYPE(Long STOP_INCREMENT_TYPE) {
        this.STOP_INCREMENT_TYPE = STOP_INCREMENT_TYPE;
    }

    public Date getFROM_DATE() {
        return FROM_DATE;
    }

    public void setFROM_DATE(Date FROM_DATE) {
        this.FROM_DATE = FROM_DATE;
    }

    public Date getTO_DATE() {
        return TO_DATE;
    }

    public void setTO_DATE(Date TO_DATE) {
        this.TO_DATE = TO_DATE;
    }

    public Date getDATE_NXT_INC() {
        return DATE_NXT_INC;
    }

    public void setDATE_NXT_INC(Date DATE_NXT_INC) {
        this.DATE_NXT_INC = DATE_NXT_INC;
    }

    public Long getCLASS_ID() {
        return CLASS_ID;
    }

    public void setCLASS_ID(Long CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }

    public Long getDESIGNATION_ID() {
        return DESIGNATION_ID;
    }

    public void setDESIGNATION_ID(Long DESIGNATION_ID) {
        this.DESIGNATION_ID = DESIGNATION_ID;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }

    public Long getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(Long CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    public Long getCREATED_BY_POST() {
        return CREATED_BY_POST;
    }

    public void setCREATED_BY_POST(Long CREATED_BY_POST) {
        this.CREATED_BY_POST = CREATED_BY_POST;
    }

    public Long getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(Long UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    public Date getUPDATED_DATE() {
        return UPDATED_DATE;
    }

    public void setUPDATED_DATE(Date UPDATED_DATE) {
        this.UPDATED_DATE = UPDATED_DATE;
    }

    public Long getUPDATED_BY_POST() {
        return UPDATED_BY_POST;
    }

    public void setUPDATED_BY_POST(Long UPDATED_BY_POST) {
        this.UPDATED_BY_POST = UPDATED_BY_POST;
    }

    public Long getACTIVE_STATUS() {
        return ACTIVE_STATUS;
    }

    public void setACTIVE_STATUS(Long ACTIVE_STATUS) {
        this.ACTIVE_STATUS = ACTIVE_STATUS;
    }

    public Long getSTATUS_ID() {
        return STATUS_ID;
    }

    public void setSTATUS_ID(Long STATUS_ID) {
        this.STATUS_ID = STATUS_ID;
    }

    public Date getSUS_START_DATE() {
        return SUS_START_DATE;
    }

    public void setSUS_START_DATE(Date SUS_START_DATE) {
        this.SUS_START_DATE = SUS_START_DATE;
    }

    public Date getSUS_END_DATE() {
        return SUS_END_DATE;
    }

    public void setSUS_END_DATE(Date SUS_END_DATE) {
        this.SUS_END_DATE = SUS_END_DATE;
    }

    public Date getEOL_START_DATE() {
        return EOL_START_DATE;
    }

    public void setEOL_START_DATE(Date EOL_START_DATE) {
        this.EOL_START_DATE = EOL_START_DATE;
    }

    public Date getEOL_END_DATE() {
        return EOL_END_DATE;
    }

    public void setEOL_END_DATE(Date EOL_END_DATE) {
        this.EOL_END_DATE = EOL_END_DATE;
    }

    public Long getSYSTEM_EXCL() {
        return SYSTEM_EXCL;
    }

    public void setSYSTEM_EXCL(Long SYSTEM_EXCL) {
        this.SYSTEM_EXCL = SYSTEM_EXCL;
    }

    public String getINCREMENT_TYPE() {
        return INCREMENT_TYPE;
    }

    public void setINCREMENT_TYPE(String INCREMENT_TYPE) {
        this.INCREMENT_TYPE = INCREMENT_TYPE;
    }

    public Long getEMP_TYPE() {
        return EMP_TYPE;
    }

    public void setEMP_TYPE(Long EMP_TYPE) {
        this.EMP_TYPE = EMP_TYPE;
    }

    public String getGPF() {
        return GPF;
    }

    public void setGPF(String GPF) {
        this.GPF = GPF;
    }

    public Long getIS_ELIGIBLE() {
        return IS_ELIGIBLE;
    }

    public void setIS_ELIGIBLE(Long IS_ELIGIBLE) {
        this.IS_ELIGIBLE = IS_ELIGIBLE;
    }

    public Long getIS_INCLUDED() {
        return IS_INCLUDED;
    }

    public void setIS_INCLUDED(Long IS_INCLUDED) {
        this.IS_INCLUDED = IS_INCLUDED;
    }

    public Long getDEPT_CAT() {
        return DEPT_CAT;
    }

    public void setDEPT_CAT(Long DEPT_CAT) {
        this.DEPT_CAT = DEPT_CAT;
    }

    public Long getLAST_PAY_SCALE() {
        return LAST_PAY_SCALE;
    }

    public void setLAST_PAY_SCALE(Long LAST_PAY_SCALE) {
        this.LAST_PAY_SCALE = LAST_PAY_SCALE;
    }

    public Long getWHL_IS_ELIGIBLE() {
        return WHL_IS_ELIGIBLE;
    }

    public void setWHL_IS_ELIGIBLE(Long WHL_IS_ELIGIBLE) {
        this.WHL_IS_ELIGIBLE = WHL_IS_ELIGIBLE;
    }

    public Long getLAST_PAY_LEVEL() {
        return LAST_PAY_LEVEL;
    }

    public void setLAST_PAY_LEVEL(Long LAST_PAY_LEVEL) {
        this.LAST_PAY_LEVEL = LAST_PAY_LEVEL;
    }

    public Long getLAST_GRD_PAY() {
        return LAST_GRD_PAY;
    }

    public void setLAST_GRD_PAY(Long LAST_GRD_PAY) {
        this.LAST_GRD_PAY = LAST_GRD_PAY;
    }
}

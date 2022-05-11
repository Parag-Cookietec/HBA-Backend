package gov.ifms.pvu.dto.response;

import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The type Pvu common api dto.
 */
@NativeQueryResultEntity
public class PVUCommonEmployeeApiDto {

    @NativeQueryResultColumn(index = 0)
    private String eventDate;

    @NativeQueryResultColumn(index = 1)
    private String employeeName;

    @NativeQueryResultColumn(index = 2)
    private String deptName;

    @NativeQueryResultColumn(index = 3)
    private String designationName;

    @NativeQueryResultColumn(index = 4)
    private String retirementDate;

    @NativeQueryResultColumn(index = 5)
    private String officeName;

    @NativeQueryResultColumn(index = 6)
    private String dateNxtIncr;

    @NativeQueryResultColumn(index = 7)
    private String empBasicPay;

    @NativeQueryResultColumn(index = 8)
    private String dateJoining;

    @NativeQueryResultColumn(index = 9)
    private String employeeNo;

    @NativeQueryResultColumn(index = 10)
    private String employeeId;

    @NativeQueryResultColumn(index = 11)
    private String employeeClass;

    @NativeQueryResultColumn(index = 12)
    private String cellId;

    @NativeQueryResultColumn(index = 13)
    private String payBandValue;

    @NativeQueryResultColumn(index = 14)
    private String payScale;

    @NativeQueryResultColumn(index = 15)
    private String payBandId;

    @NativeQueryResultColumn(index = 16)
    private String payLevelId;

    @NativeQueryResultColumn(index = 17)
    private String gradePayId;

    @NativeQueryResultColumn(index = 18)
    private String payBandName;

    @NativeQueryResultColumn(index = 19)
    private String gradePayName;

    @NativeQueryResultColumn(index = 20)
    private String payLevelName;

    @NativeQueryResultColumn(index = 21)
    private String designationId;

    @NativeQueryResultColumn(index = 22)
    private String classId;

    @NativeQueryResultColumn(index = 23)
    private String cellName;

    @NativeQueryResultColumn(index = 24)
    private Long payCommId;

    @NativeQueryResultColumn(index = 25)
    private String payCommName;

    @NativeQueryResultColumn(index = 26)
    private String eventDateSix;

    @NativeQueryResultColumn(index = 27)
    private String employeeNameSix;

    @NativeQueryResultColumn(index = 28)
    private String deptNameSix;

    @NativeQueryResultColumn(index = 29)
    private String designationNameSix;

    @NativeQueryResultColumn(index = 30)
    private String retirementDateSix;

    @NativeQueryResultColumn(index = 31)
    private String officeNameSix;

    @NativeQueryResultColumn(index = 32)
    private String dateNxtIncrSix;

    @NativeQueryResultColumn(index = 33)
    private String empBasicPaySix;

    @NativeQueryResultColumn(index = 34)
    private String dateJoiningSix;

    @NativeQueryResultColumn(index = 35)
    private String employeeNoSix;

    @NativeQueryResultColumn(index = 36)
    private String employeeIdSix;

    @NativeQueryResultColumn(index = 37)
    private String employeeClassSix;

    @NativeQueryResultColumn(index = 38)
    private String cellIdSix;

    @NativeQueryResultColumn(index = 39)
    private String payBandValueSix;

    @NativeQueryResultColumn(index = 40)
    private String payScaleSix;

    @NativeQueryResultColumn(index = 41)
    private String payBandIdSix;

    @NativeQueryResultColumn(index = 42)
    private String payLevelIdSix;

    @NativeQueryResultColumn(index = 43)
    private String gradePayIdSix;

    @NativeQueryResultColumn(index = 44)
    private String payBandNameSix;

    @NativeQueryResultColumn(index = 45)
    private String gradePayNameSix;

    @NativeQueryResultColumn(index = 46)
    private String payLevelNameSix;

    @NativeQueryResultColumn(index = 47)
    private String designationIdSix;

    @NativeQueryResultColumn(index = 48)
    private String classIdSix;

    @NativeQueryResultColumn(index = 49)
    private String cellNameSix;

    @NativeQueryResultColumn(index = 50)
    private Long payCommIdSix;

    @NativeQueryResultColumn(index = 51)
    private String payCommNameSix;

    @NativeQueryResultColumn(index = 52)
    private String eventDateFive;

    @NativeQueryResultColumn(index = 53)
    private String employeeNameFive;

    @NativeQueryResultColumn(index = 54)
    private String deptNameFive;

    @NativeQueryResultColumn(index = 55)
    private String designationNameFive;

    @NativeQueryResultColumn(index = 56)
    private String retirementDateFive;

    @NativeQueryResultColumn(index = 57)
    private String officeNameFive;

    @NativeQueryResultColumn(index = 58)
    private String dateNxtIncrFive;

    @NativeQueryResultColumn(index = 59)
    private String empBasicPayFive;

    @NativeQueryResultColumn(index = 60)
    private String dateJoiningFive;

    @NativeQueryResultColumn(index = 61)
    private String employeeNoFive;

    @NativeQueryResultColumn(index = 62)
    private String employeeIdFive;

    @NativeQueryResultColumn(index = 63)
    private String employeeClassFive;

    @NativeQueryResultColumn(index = 64)
    private String cellIdFive;

    @NativeQueryResultColumn(index = 65)
    private String payBandValueFive;

    @NativeQueryResultColumn(index = 66)
    private String payScaleFive;

    @NativeQueryResultColumn(index = 67)
    private String payBandIdFive;

    @NativeQueryResultColumn(index = 68)
    private String payLevelIdFive;

    @NativeQueryResultColumn(index = 69)
    private String gradePayIdFive;

    @NativeQueryResultColumn(index = 70)
    private String payBandNameFive;

    @NativeQueryResultColumn(index = 71)
    private String gradePayNameFive;

    @NativeQueryResultColumn(index = 72)
    private String payLevelNameFive;

    @NativeQueryResultColumn(index = 73)
    private String designationIdFive;

    @NativeQueryResultColumn(index = 74)
    private String classIdFive;

    @NativeQueryResultColumn(index = 75)
    private String cellNameFive;

    @NativeQueryResultColumn(index = 76)
    private Long payCommIdFive;

    @NativeQueryResultColumn(index = 77)
    private String payCommNameFive;

    /**
     * Gets pay band name.
     *
     * @return the pay band name
     */
    public String getPayBandName() {
        return payBandName;
    }

    /**
     * Sets pay band name.
     *
     * @param payBandName the pay band name
     */
    public void setPayBandName(String payBandName) {
        this.payBandName = payBandName;
    }

    /**
     * Gets grade pay name.
     *
     * @return the grade pay name
     */
    public String getGradePayName() {
        return gradePayName;
    }

    /**
     * Sets grade pay name.
     *
     * @param gradePayName the grade pay name
     */
    public void setGradePayName(String gradePayName) {
        this.gradePayName = gradePayName;
    }

    /**
     * Gets pay level name.
     *
     * @return the pay level name
     */
    public String getPayLevelName() {
        return payLevelName;
    }

    /**
     * Sets pay level name.
     *
     * @param payLevelName the pay level name
     */
    public void setPayLevelName(String payLevelName) {
        this.payLevelName = payLevelName;
    }

    /**
     * Gets pay scale.
     *
     * @return the pay scale
     */
    public String getPayScale() {
        return payScale;
    }

    /**
     * Sets pay scale.
     *
     * @param payScale the pay scale
     */
    public void setPayScale(String payScale) {
        this.payScale = payScale;
    }

    /**
     * Gets pay band id.
     *
     * @return the pay band id
     */
    public String getPayBandId() {
        return payBandId;
    }

    /**
     * Sets pay band id.
     *
     * @param payBandId the pay band id
     */
    public void setPayBandId(String payBandId) {
        this.payBandId = payBandId;
    }

    /**
     * Gets grade pay id.
     *
     * @return the grade pay id
     */
    public String getGradePayId() {
        return gradePayId;
    }

    /**
     * Sets grade pay id.
     *
     * @param gradePayId the grade pay id
     */
    public void setGradePayId(String gradePayId) {
        this.gradePayId = gradePayId;
    }

    /**
     * Gets pay level id.
     *
     * @return the pay level id
     */
    public String getPayLevelId() {
        return payLevelId;
    }

    /**
     * Sets pay level id.
     *
     * @param payLevelId the pay level id
     */
    public void setPayLevelId(String payLevelId) {
        this.payLevelId = payLevelId;
    }

    /**
     * Gets pay band value.
     *
     * @return the pay band value
     */
    public String getPayBandValue() {
        return payBandValue;
    }

    /**
     * Sets pay band value.
     *
     * @param payBandValue the pay band value
     */
    public void setPayBandValue(String payBandValue) {
        this.payBandValue = payBandValue;
    }

    /**
     * Gets employee class.
     *
     * @return the employee class
     */
    public String getEmployeeClass() {
        return employeeClass;
    }

    /**
     * Gets cell id.
     *
     * @return the cell id
     */
    public String getCellId() {
        return cellId;
    }

    /**
     * Sets cell id.
     *
     * @param cellId the cell id
     */
    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    /**
     * Sets employee class.
     *
     * @param employeeClass the employee class
     */
    public void setEmployeeClass(String employeeClass) {
        this.employeeClass = employeeClass;
    }

    /**
     * Gets employee no.
     *
     * @return the employee no
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * Sets employee no.
     *
     * @param employeeNo the employee no
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets employee id.
     *
     * @param employeeId the employee id
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets designation id.
     *
     * @return the designation id
     */
    public String getDesignationId() {
        return designationId;
    }

    /**
     * Sets designation id.
     *
     * @param designationId the designation id
     */
    public void setDesignationId(String designationId) {
        this.designationId = designationId;
    }

    /**
     * Gets class id.
     *
     * @return the class id
     */
    public String getClassId() {
        return classId;
    }

    /**
     * Sets class id.
     *
     * @param classId the class id
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * Getter for property 'cellName'.
     *
     * @return Value for property 'cellName'.
     */
    public String getCellName() {
        return cellName;
    }

    /**
     * Setter for property 'cellName'.
     *
     * @param cellName Value to set for property 'cellName'.
     */
    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getEmployeeNameSix() {
        return employeeNameSix;
    }

    public void setEmployeeNameSix(String employeeNameSix) {
        this.employeeNameSix = employeeNameSix;
    }

    public String getDeptNameSix() {
        return deptNameSix;
    }

    public void setDeptNameSix(String deptNameSix) {
        this.deptNameSix = deptNameSix;
    }

    public String getDesignationNameSix() {
        return designationNameSix;
    }

    public void setDesignationNameSix(String designationNameSix) {
        this.designationNameSix = designationNameSix;
    }

    public String getRetirementDateSix() {
        return retirementDateSix;
    }

    public void setRetirementDateSix(String retirementDateSix) {
        this.retirementDateSix = retirementDateSix;
    }

    public String getOfficeNameSix() {
        return officeNameSix;
    }

    public void setOfficeNameSix(String officeNameSix) {
        this.officeNameSix = officeNameSix;
    }

    public String getDateNxtIncrSix() {
        return dateNxtIncrSix;
    }

    public void setDateNxtIncrSix(String dateNxtIncrSix) {
        this.dateNxtIncrSix = dateNxtIncrSix;
    }

    public String getEmpBasicPaySix() {
        return empBasicPaySix;
    }

    public void setEmpBasicPaySix(String empBasicPaySix) {
        this.empBasicPaySix = empBasicPaySix;
    }

    public String getDateJoiningSix() {
        return dateJoiningSix;
    }

    public void setDateJoiningSix(String dateJoiningSix) {
        this.dateJoiningSix = dateJoiningSix;
    }

    public String getEmployeeNoSix() {
        return employeeNoSix;
    }

    public void setEmployeeNoSix(String employeeNoSix) {
        this.employeeNoSix = employeeNoSix;
    }

    public String getEmployeeIdSix() {
        return employeeIdSix;
    }

    public void setEmployeeIdSix(String employeeIdSix) {
        this.employeeIdSix = employeeIdSix;
    }

    public String getEmployeeClassSix() {
        return employeeClassSix;
    }

    public void setEmployeeClassSix(String employeeClassSix) {
        this.employeeClassSix = employeeClassSix;
    }

    public String getCellIdSix() {
        return cellIdSix;
    }

    public void setCellIdSix(String cellIdSix) {
        this.cellIdSix = cellIdSix;
    }

    public String getPayBandValueSix() {
        return payBandValueSix;
    }

    public void setPayBandValueSix(String payBandValueSix) {
        this.payBandValueSix = payBandValueSix;
    }

    public String getPayScaleSix() {
        return payScaleSix;
    }

    public void setPayScaleSix(String payScaleSix) {
        this.payScaleSix = payScaleSix;
    }

    public String getPayBandIdSix() {
        return payBandIdSix;
    }

    public void setPayBandIdSix(String payBandIdSix) {
        this.payBandIdSix = payBandIdSix;
    }

    public String getPayLevelIdSix() {
        return payLevelIdSix;
    }

    public void setPayLevelIdSix(String payLevelIdSix) {
        this.payLevelIdSix = payLevelIdSix;
    }

    public String getGradePayIdSix() {
        return gradePayIdSix;
    }

    public void setGradePayIdSix(String gradePayIdSix) {
        this.gradePayIdSix = gradePayIdSix;
    }

    public String getPayBandNameSix() {
        return payBandNameSix;
    }

    public void setPayBandNameSix(String payBandNameSix) {
        this.payBandNameSix = payBandNameSix;
    }

    public String getGradePayNameSix() {
        return gradePayNameSix;
    }

    public void setGradePayNameSix(String gradePayNameSix) {
        this.gradePayNameSix = gradePayNameSix;
    }

    public String getPayLevelNameSix() {
        return payLevelNameSix;
    }

    public void setPayLevelNameSix(String payLevelNameSix) {
        this.payLevelNameSix = payLevelNameSix;
    }

    public String getDesignationIdSix() {
        return designationIdSix;
    }

    public void setDesignationIdSix(String designationIdSix) {
        this.designationIdSix = designationIdSix;
    }

    public String getClassIdSix() {
        return classIdSix;
    }

    public void setClassIdSix(String classIdSix) {
        this.classIdSix = classIdSix;
    }

    public String getCellNameSix() {
        return cellNameSix;
    }

    public void setCellNameSix(String cellNameSix) {
        this.cellNameSix = cellNameSix;
    }

    public Long getPayCommIdSix() {
        return payCommIdSix;
    }

    public void setPayCommIdSix(Long payCommIdSix) {
        this.payCommIdSix = payCommIdSix;
    }

    public String getPayCommNameSix() {
        return payCommNameSix;
    }

    public void setPayCommNameSix(String payCommNameSix) {
        this.payCommNameSix = payCommNameSix;
    }

    public String getEventDateFive() {
        return eventDateFive;
    }

    public void setEventDateFive(String eventDateFive) {
        this.eventDateFive = eventDateFive;
    }

    public String getEmployeeNameFive() {
        return employeeNameFive;
    }

    public void setEmployeeNameFive(String employeeNameFive) {
        this.employeeNameFive = employeeNameFive;
    }

    public String getDeptNameFive() {
        return deptNameFive;
    }

    public void setDeptNameFive(String deptNameFive) {
        this.deptNameFive = deptNameFive;
    }

    public String getDesignationNameFive() {
        return designationNameFive;
    }

    public void setDesignationNameFive(String designationNameFive) {
        this.designationNameFive = designationNameFive;
    }

    public String getRetirementDateFive() {
        return retirementDateFive;
    }

    public void setRetirementDateFive(String retirementDateFive) {
        this.retirementDateFive = retirementDateFive;
    }

    public String getOfficeNameFive() {
        return officeNameFive;
    }

    public void setOfficeNameFive(String officeNameFive) {
        this.officeNameFive = officeNameFive;
    }

    public String getDateNxtIncrFive() {
        return dateNxtIncrFive;
    }

    public void setDateNxtIncrFive(String dateNxtIncrFive) {
        this.dateNxtIncrFive = dateNxtIncrFive;
    }

    public String getEmpBasicPayFive() {
        return empBasicPayFive;
    }

    public void setEmpBasicPayFive(String empBasicPayFive) {
        this.empBasicPayFive = empBasicPayFive;
    }

    public String getDateJoiningFive() {
        return dateJoiningFive;
    }

    public void setDateJoiningFive(String dateJoiningFive) {
        this.dateJoiningFive = dateJoiningFive;
    }

    public String getEmployeeNoFive() {
        return employeeNoFive;
    }

    public void setEmployeeNoFive(String employeeNoFive) {
        this.employeeNoFive = employeeNoFive;
    }

    public String getEmployeeIdFive() {
        return employeeIdFive;
    }

    public void setEmployeeIdFive(String employeeIdFive) {
        this.employeeIdFive = employeeIdFive;
    }

    public String getEmployeeClassFive() {
        return employeeClassFive;
    }

    public void setEmployeeClassFive(String employeeClassFive) {
        this.employeeClassFive = employeeClassFive;
    }

    public String getCellIdFive() {
        return cellIdFive;
    }

    public void setCellIdFive(String cellIdFive) {
        this.cellIdFive = cellIdFive;
    }

    public String getPayBandValueFive() {
        return payBandValueFive;
    }

    public void setPayBandValueFive(String payBandValueFive) {
        this.payBandValueFive = payBandValueFive;
    }

    public String getPayScaleFive() {
        return payScaleFive;
    }

    public void setPayScaleFive(String payScaleFive) {
        this.payScaleFive = payScaleFive;
    }

    public String getPayBandIdFive() {
        return payBandIdFive;
    }

    public void setPayBandIdFive(String payBandIdFive) {
        this.payBandIdFive = payBandIdFive;
    }

    public String getPayLevelIdFive() {
        return payLevelIdFive;
    }

    public void setPayLevelIdFive(String payLevelIdFive) {
        this.payLevelIdFive = payLevelIdFive;
    }

    public String getGradePayIdFive() {
        return gradePayIdFive;
    }

    public void setGradePayIdFive(String gradePayIdFive) {
        this.gradePayIdFive = gradePayIdFive;
    }

    public String getPayBandNameFive() {
        return payBandNameFive;
    }

    public void setPayBandNameFive(String payBandNameFive) {
        this.payBandNameFive = payBandNameFive;
    }

    public String getGradePayNameFive() {
        return gradePayNameFive;
    }

    public void setGradePayNameFive(String gradePayNameFive) {
        this.gradePayNameFive = gradePayNameFive;
    }

    public String getPayLevelNameFive() {
        return payLevelNameFive;
    }

    public void setPayLevelNameFive(String payLevelNameFive) {
        this.payLevelNameFive = payLevelNameFive;
    }

    public String getDesignationIdFive() {
        return designationIdFive;
    }

    public void setDesignationIdFive(String designationIdFive) {
        this.designationIdFive = designationIdFive;
    }

    public String getClassIdFive() {
        return classIdFive;
    }

    public void setClassIdFive(String classIdFive) {
        this.classIdFive = classIdFive;
    }

    public String getCellNameFive() {
        return cellNameFive;
    }

    public void setCellNameFive(String cellNameFive) {
        this.cellNameFive = cellNameFive;
    }

    public Long getPayCommIdFive() {
        return payCommIdFive;
    }

    public void setPayCommIdFive(Long payCommIdFive) {
        this.payCommIdFive = payCommIdFive;
    }

    public String getPayCommNameFive() {
        return payCommNameFive;
    }

    public void setPayCommNameFive(String payCommNameFive) {
        this.payCommNameFive = payCommNameFive;
    }

    public String getEventDateSix() {
        return eventDateSix;
    }

    public void setEventDateSix(String eventDateSix) {
        this.eventDateSix = eventDateSix;
    }


    /**
     * The type Exam dto.
     */


    public static class EXAMDto {

        private String examName;

        private String examBody;

        private Date examPassingDate;

        private String examStatus;

        /**
         * Gets exam name.
         *
         * @return the exam name
         */
        public String getExamName() {
            return examName;
        }

        /**
         * Sets exam name.
         *
         * @param examName the exam name
         */
        public void setExamName(String examName) {
            this.examName = examName;
        }

        /**
         * Gets exam body.
         *
         * @return the exam body
         */
        public String getExamBody() {
            return examBody;
        }

        /**
         * Sets exam body.
         *
         * @param examBody the exam body
         */
        public void setExamBody(String examBody) {
            this.examBody = examBody;
        }

        /**
         * Gets exam passing date.
         *
         * @return the exam passing date
         */
        public Date getExamPassingDate() {
            return examPassingDate;
        }

        /**
         * Sets exam passing date.
         *
         * @param examPassingDate the exam passing date
         */
        public void setExamPassingDate(Date examPassingDate) {
            this.examPassingDate = examPassingDate;
        }

        /**
         * Gets exam status.
         *
         * @return the exam status
         */
        public String getExamStatus() {
            return examStatus;
        }

        /**
         * Sets exam status.
         *
         * @param examStatus the exam status
         */
        public void setExamStatus(String examStatus) {
            this.examStatus = examStatus;
        }

        /**
         * Instantiates a new Exam dto.
         *
         * @param examName        the exam name
         * @param examBody        the exam body
         * @param examPassingDate the exam passing date
         * @param examStatus      the exam status
         */
        public EXAMDto(String examName, String examBody, Date examPassingDate, String examStatus) {
            this.examName = examName;
            this.examBody = examBody;
            this.examPassingDate = examPassingDate;
            this.examStatus = examStatus;
        }

        /**
         * Create exam dto.
         *
         * @param examName      the exam name
         * @param examBody      the exam body
         * @param dateOfPassing the date of passing
         * @param examStatus    the exam status
         * @return the exam dto
         */
        public static EXAMDto create(String examName, String examBody, Date dateOfPassing, String examStatus) {
            return new EXAMDto(examName, examBody, dateOfPassing, examStatus);
        }
    }

    /**
     * Gets event date.
     *
     * @return the event date
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * Sets event date.
     *
     * @param eventDate the event date
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Gets employee name.
     *
     * @return the employee name
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets employee name.
     *
     * @param employeeName the employee name
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Gets lookup info name.
     *
     * @return the lookup info name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Sets lookup info name.
     *
     * @param deptName the lookup info name
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * Gets designation name.
     *
     * @return the designation name
     */
    public String getDesignationName() {
        return designationName;
    }

    /**
     * Sets designation name.
     *
     * @param designationName the designation name
     */
    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    /**
     * Gets retirement date.
     *
     * @return the retirement date
     */
    public String getRetirementDate() {
        return retirementDate;
    }

    /**
     * Sets retirement date.
     *
     * @param retirementDate the retirement date
     */
    public void setRetirementDate(String retirementDate) {
        this.retirementDate = retirementDate;
    }

    /**
     * Gets office name.
     *
     * @return the office name
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * Sets office name.
     *
     * @param officeName the office name
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    /**
     * Gets date nxt incr.
     *
     * @return the date nxt incr
     */
    public String getDateNxtIncr() {
        return dateNxtIncr;
    }

    /**
     * Sets date nxt incr.
     *
     * @param dateNxtIncr the date nxt incr
     */
    public void setDateNxtIncr(String dateNxtIncr) {
        this.dateNxtIncr = dateNxtIncr;
    }

    /**
     * Gets emp basic pay.
     *
     * @return the emp basic pay
     */
    public String getEmpBasicPay() {
        return empBasicPay;
    }

    /**
     * Sets emp basic pay.
     *
     * @param empBasicPay the emp basic pay
     */
    public void setEmpBasicPay(String empBasicPay) {
        this.empBasicPay = empBasicPay;
    }

    /**
     * Gets date joining.
     *
     * @return the date joining
     */
    public String getDateJoining() {
        return dateJoining;
    }

    /**
     * Sets date joining.
     *
     * @param dateJoining the date joining
     */
    public void setDateJoining(String dateJoining) {
        this.dateJoining = dateJoining;
    }

    /**
     * Getter for property 'payCommId'.
     *
     * @return Value for property 'payCommId'.
     */
    public Long getPayCommId() {
        return payCommId;
    }

    /**
     * Setter for property 'payCommId'.
     *
     * @param payCommId Value to set for property 'payCommId'.
     */
    public void setPayCommId(Long payCommId) {
        this.payCommId = payCommId;
    }

    /**
     * Getter for property 'payCommName'.
     *
     * @return Value for property 'payCommName'.
     */
    public String getPayCommName() {
        return payCommName;
    }

    /**
     * Setter for property 'payCommName'.
     *
     * @param payCommName Value to set for property 'payCommName'.
     */
    public void setPayCommName(String payCommName) {
        this.payCommName = payCommName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PVUCommonEmployeeApiDto)) return false;
        PVUCommonEmployeeApiDto that = (PVUCommonEmployeeApiDto) o;
        return Objects.equals(getEventDate(), that.getEventDate()) &&
                Objects.equals(getEmployeeName(), that.getEmployeeName()) &&
                Objects.equals(getDeptName(), that.getDeptName()) &&
                Objects.equals(getDesignationName(), that.getDesignationName()) &&
                Objects.equals(getRetirementDate(), that.getRetirementDate()) &&
                Objects.equals(getOfficeName(), that.getOfficeName()) &&
                Objects.equals(getDateNxtIncr(), that.getDateNxtIncr()) &&
                Objects.equals(getEmpBasicPay(), that.getEmpBasicPay()) &&
                Objects.equals(getDateJoining(), that.getDateJoining()) &&
                Objects.equals(getEmployeeNo(), that.getEmployeeNo()) &&
                Objects.equals(getEmployeeId(), that.getEmployeeId()) &&
                Objects.equals(getEmployeeClass(), that.getEmployeeClass()) &&
                Objects.equals(getCellId(), that.getCellId()) &&
                Objects.equals(getPayBandValue(), that.getPayBandValue()) &&
                Objects.equals(getPayScale(), that.getPayScale()) &&
                Objects.equals(getPayBandId(), that.getPayBandId()) &&
                Objects.equals(getPayLevelId(), that.getPayLevelId()) &&
                Objects.equals(getGradePayId(), that.getGradePayId()) &&
                Objects.equals(getPayBandName(), that.getPayBandName()) &&
                Objects.equals(getGradePayName(), that.getGradePayName()) &&
                Objects.equals(getPayLevelName(), that.getPayLevelName()) &&
                Objects.equals(getDesignationId(), that.getDesignationId()) &&
                Objects.equals(getClassId(), that.getClassId()) &&
                Objects.equals(getCellName(), that.getCellName()) &&
                Objects.equals(getPayCommId(), that.getPayCommId()) &&
                Objects.equals(getPayCommName(), that.getPayCommName()) &&
                Objects.equals(getEventDateSix(), that.getEventDateSix()) &&
                Objects.equals(getEmployeeNameSix(), that.getEmployeeNameSix()) &&
                Objects.equals(getDeptNameSix(), that.getDeptNameSix()) &&
                Objects.equals(getDesignationNameSix(), that.getDesignationNameSix()) &&
                Objects.equals(getRetirementDateSix(), that.getRetirementDateSix()) &&
                Objects.equals(getOfficeNameSix(), that.getOfficeNameSix()) &&
                Objects.equals(getDateNxtIncrSix(), that.getDateNxtIncrSix()) &&
                Objects.equals(getEmpBasicPaySix(), that.getEmpBasicPaySix()) &&
                Objects.equals(getDateJoiningSix(), that.getDateJoiningSix()) &&
                Objects.equals(getEmployeeNoSix(), that.getEmployeeNoSix()) &&
                Objects.equals(getEmployeeIdSix(), that.getEmployeeIdSix()) &&
                Objects.equals(getEmployeeClassSix(), that.getEmployeeClassSix()) &&
                Objects.equals(getCellIdSix(), that.getCellIdSix()) &&
                Objects.equals(getPayBandValueSix(), that.getPayBandValueSix()) &&
                Objects.equals(getPayScaleSix(), that.getPayScaleSix()) &&
                Objects.equals(getPayBandIdSix(), that.getPayBandIdSix()) &&
                Objects.equals(getPayLevelIdSix(), that.getPayLevelIdSix()) &&
                Objects.equals(getGradePayIdSix(), that.getGradePayIdSix()) &&
                Objects.equals(getPayBandNameSix(), that.getPayBandNameSix()) &&
                Objects.equals(getGradePayNameSix(), that.getGradePayNameSix()) &&
                Objects.equals(getPayLevelNameSix(), that.getPayLevelNameSix()) &&
                Objects.equals(getDesignationIdSix(), that.getDesignationIdSix()) &&
                Objects.equals(getClassIdSix(), that.getClassIdSix()) &&
                Objects.equals(getCellNameSix(), that.getCellNameSix()) &&
                Objects.equals(getPayCommIdSix(), that.getPayCommIdSix()) &&
                Objects.equals(getPayCommNameSix(), that.getPayCommNameSix()) &&
                Objects.equals(getEventDateFive(), that.getEventDateFive()) &&
                Objects.equals(getEmployeeNameFive(), that.getEmployeeNameFive()) &&
                Objects.equals(getDeptNameFive(), that.getDeptNameFive()) &&
                Objects.equals(getDesignationNameFive(), that.getDesignationNameFive()) &&
                Objects.equals(getRetirementDateFive(), that.getRetirementDateFive()) &&
                Objects.equals(getOfficeNameFive(), that.getOfficeNameFive()) &&
                Objects.equals(getDateNxtIncrFive(), that.getDateNxtIncrFive()) &&
                Objects.equals(getEmpBasicPayFive(), that.getEmpBasicPayFive()) &&
                Objects.equals(getDateJoiningFive(), that.getDateJoiningFive()) &&
                Objects.equals(getEmployeeNoFive(), that.getEmployeeNoFive()) &&
                Objects.equals(getEmployeeIdFive(), that.getEmployeeIdFive()) &&
                Objects.equals(getEmployeeClassFive(), that.getEmployeeClassFive()) &&
                Objects.equals(getCellIdFive(), that.getCellIdFive()) &&
                Objects.equals(getPayBandValueFive(), that.getPayBandValueFive()) &&
                Objects.equals(getPayScaleFive(), that.getPayScaleFive()) &&
                Objects.equals(getPayBandIdFive(), that.getPayBandIdFive()) &&
                Objects.equals(getPayLevelIdFive(), that.getPayLevelIdFive()) &&
                Objects.equals(getGradePayIdFive(), that.getGradePayIdFive()) &&
                Objects.equals(getPayBandNameFive(), that.getPayBandNameFive()) &&
                Objects.equals(getGradePayNameFive(), that.getGradePayNameFive()) &&
                Objects.equals(getPayLevelNameFive(), that.getPayLevelNameFive()) &&
                Objects.equals(getDesignationIdFive(), that.getDesignationIdFive()) &&
                Objects.equals(getClassIdFive(), that.getClassIdFive()) &&
                Objects.equals(getCellNameFive(), that.getCellNameFive()) &&
                Objects.equals(getPayCommIdFive(), that.getPayCommIdFive()) &&
                Objects.equals(getPayCommNameFive(), that.getPayCommNameFive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventDate(), getEmployeeName(), getDeptName(), getDesignationName(), getRetirementDate(), getOfficeName(), getDateNxtIncr(), getEmpBasicPay(), getDateJoining(), getEmployeeNo(), getEmployeeId(), getEmployeeClass(), getCellId(), getPayBandValue(), getPayScale(), getPayBandId(), getPayLevelId(), getGradePayId(), getPayBandName(), getGradePayName(), getPayLevelName(), getDesignationId(), getClassId(), getCellName(), getPayCommId(), getPayCommName(), getEventDateSix(), getEmployeeNameSix(), getDeptNameSix(), getDesignationNameSix(), getRetirementDateSix(), getOfficeNameSix(), getDateNxtIncrSix(), getEmpBasicPaySix(), getDateJoiningSix(), getEmployeeNoSix(), getEmployeeIdSix(), getEmployeeClassSix(), getCellIdSix(), getPayBandValueSix(), getPayScaleSix(), getPayBandIdSix(), getPayLevelIdSix(), getGradePayIdSix(), getPayBandNameSix(), getGradePayNameSix(), getPayLevelNameSix(), getDesignationIdSix(), getClassIdSix(), getCellNameSix(), getPayCommIdSix(), getPayCommNameSix(), getEventDateFive(), getEmployeeNameFive(), getDeptNameFive(), getDesignationNameFive(), getRetirementDateFive(), getOfficeNameFive(), getDateNxtIncrFive(), getEmpBasicPayFive(), getDateJoiningFive(), getEmployeeNoFive(), getEmployeeIdFive(), getEmployeeClassFive(), getCellIdFive(), getPayBandValueFive(), getPayScaleFive(), getPayBandIdFive(), getPayLevelIdFive(), getGradePayIdFive(), getPayBandNameFive(), getGradePayNameFive(), getPayLevelNameFive(), getDesignationIdFive(), getClassIdFive(), getCellNameFive(), getPayCommIdFive(), getPayCommNameFive());
    }
}

package gov.ifms.pvu.dto.response;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.util.Date;
import java.util.Objects;
@NativeQueryResultEntity
public class PVUCommonHigherPayDto {

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
    private String payScaleName;

    @NativeQueryResultColumn(index = 27)
    private Long departmentCategoryId;

    @NativeQueryResultColumn(index = 28)
    private String departmentCategoryName;

    @NativeQueryResultColumn(index = 29)
    private Long currentDetailsEventId;
    
    @NativeQueryResultColumn(index = 30)
    private Long empType;

    @NativeQueryResultColumn(index = 31)
    private Long payType;
    
    @NativeQueryResultColumn(index = 32)
    private String fixProbationalPayDate;
    
    @NativeQueryResultColumn(index = 33)
    private String conversionDateToRegular;

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
        public static gov.ifms.pvu.dto.response.PVUCommonHigherPayDto.EXAMDto create(String examName, String examBody, Date dateOfPassing, String examStatus) {
            return new gov.ifms.pvu.dto.response.PVUCommonHigherPayDto.EXAMDto(examName, examBody, dateOfPassing, examStatus);
        }
    }


    public static class PromotionDto {

        private Date eventEffectiveDate;

        private String designationName;

        private String scale;

        public Date getEventEffectiveDate() {
            return eventEffectiveDate;
        }

        public void setEventEffectiveDate(Date eventEffectiveDate) {
            this.eventEffectiveDate = eventEffectiveDate;
        }

        public String getDesignationName() {
            return designationName;
        }

        public void setDesignationName(String designationName) {
            this.designationName = designationName;
        }

        public String getScale() {
            return scale;
        }

        public void setScale(String scale) {
            this.scale = scale;
        }

        /**
         * Instantiates a new Exam dto.
         *
         * @param eventEffectiveDate the exam name
         * @param designationName    the exam body
         * @param scale              the exam passing date
         */
        public PromotionDto(Date eventEffectiveDate, String designationName, String scale) {
            this.eventEffectiveDate = eventEffectiveDate;
            this.designationName = designationName;
            this.scale = scale;
        }


        public static PVUCommonHigherPayDto.PromotionDto create(Date eventEffectiveDate, String designationName, String scale) {
            return new PromotionDto(eventEffectiveDate, designationName, scale);
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

        /**
         * Getter for property 'payScaleName'.
         *
         * @return Value for property 'payScaleName'.
         */
        public String getPayScaleName() {
            return payScaleName;
        }

        /**
         * Setter for property 'payScaleName'.
         *
         * @param payScaleName Value to set for property 'payScaleName'.
         */
        public void setPayScaleName(String payScaleName) {
            this.payScaleName = payScaleName;
        }

        /**
         * Getter for property 'departmentCategoryId'.
         *
         * @return Value for property 'departmentCategoryId'.
         */
        public Long getDepartmentCategoryId() {
            return departmentCategoryId;
        }

        /**
         * Setter for property 'departmentCategoryId'.
         *
         * @param departmentCategoryId Value to set for property 'departmentCategoryId'.
         */
        public void setDepartmentCategoryId(Long departmentCategoryId) {
            this.departmentCategoryId = departmentCategoryId;
        }

        /**
         * Getter for property 'departmentCategoryName'.
         *
         * @return Value for property 'departmentCategoryName'.
         */
        public String getDepartmentCategoryName() {
            return departmentCategoryName;
        }

        /**
         * Setter for property 'departmentCategoryName'.
         *
         * @param departmentCategoryName Value to set for property 'departmentCategoryName'.
         */
        public void setDepartmentCategoryName(String departmentCategoryName) {
            this.departmentCategoryName = departmentCategoryName;
        }

        /**
         * Getter for property 'currentDetailsEventId'.
         *
         * @return Value for property 'currentDetailsEventId'.
         */
        public Long getCurrentDetailsEventId() {
            return currentDetailsEventId;
        }

        /**
         * Setter for property 'currentDetailsEventId'.
         *
         * @param currentDetailsEventId Value to set for property 'currentDetailsEventId'.
         */
        public void setCurrentDetailsEventId(Long currentDetailsEventId) {
            this.currentDetailsEventId = currentDetailsEventId;
        }
        
        

        /**
		 * @return the fixProbationalPayDate
		 */
		public String getFixProbationalPayDate() {
			return fixProbationalPayDate;
		}

		/**
		 * @param fixProbationalPayDate the fixProbationalPayDate to set
		 */
		public void setFixProbationalPayDate(String fixProbationalPayDate) {
			this.fixProbationalPayDate = fixProbationalPayDate;
		}

		/**
		 * @return the conversionDateToRegular
		 */
		public String getConversionDateToRegular() {
			return conversionDateToRegular;
		}

		/**
		 * @param conversionDateToRegular the conversionDateToRegular to set
		 */
		public void setConversionDateToRegular(String conversionDateToRegular) {
			this.conversionDateToRegular = conversionDateToRegular;
		}
		
		

		/**
		 * @return the empType
		 */
		public Long getEmpType() {
			return empType;
		}

		/**
		 * @param empType the empType to set
		 */
		public void setEmpType(Long empType) {
			this.empType = empType;
		}

		/**
		 * @return the payType
		 */
		public Long getPayType() {
			return payType;
		}

		/**
		 * @param payType the payType to set
		 */
		public void setPayType(Long payType) {
			this.payType = payType;
		}

		@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof gov.ifms.pvu.dto.response.PVUCommonApiDto)) return false;
            gov.ifms.pvu.dto.response.PVUCommonHigherPayDto that = (gov.ifms.pvu.dto.response.PVUCommonHigherPayDto) o;
            return Objects.equals(eventDate, that.eventDate) &&
                    Objects.equals(employeeName, that.employeeName) &&
                    Objects.equals(deptName, that.deptName) &&
                    Objects.equals(designationName, that.designationName) &&
                    Objects.equals(retirementDate, that.retirementDate) &&
                    Objects.equals(officeName, that.officeName) &&
                    Objects.equals(dateNxtIncr, that.dateNxtIncr) &&
                    Objects.equals(empBasicPay, that.empBasicPay) &&
                    Objects.equals(dateJoining, that.dateJoining) &&
                    Objects.equals(employeeNo, that.employeeNo) &&
                    Objects.equals(employeeId, that.employeeId) &&
                    Objects.equals(employeeClass, that.employeeClass) &&
                    Objects.equals(cellId, that.cellId) &&
                    Objects.equals(payBandValue, that.payBandValue) &&
                    Objects.equals(payScale, that.payScale) &&
                    Objects.equals(payBandId, that.payBandId) &&
                    Objects.equals(payLevelId, that.payLevelId) &&
                    Objects.equals(gradePayId, that.gradePayId) &&
                    Objects.equals(payBandName, that.payBandName) &&
                    Objects.equals(gradePayName, that.gradePayName) &&
                    Objects.equals(payLevelName, that.payLevelName) &&
                    Objects.equals(designationId, that.designationId) &&
                    Objects.equals(classId, that.classId) &&
                    Objects.equals(departmentCategoryId, that.departmentCategoryId) &&
                    Objects.equals(departmentCategoryName, that.departmentCategoryName) &&
                    Objects.equals(cellName, that.cellName) &&
                    Objects.equals(payCommId, that.payCommId) &&
                    Objects.equals(payScaleName, that.payScaleName) &&
                    Objects.equals(currentDetailsEventId, that.currentDetailsEventId) &&
                    Objects.equals(payCommName, that.payCommName) &&
                    Objects.equals(fixProbationalPayDate, that.fixProbationalPayDate) &&
                    Objects.equals(conversionDateToRegular, that.conversionDateToRegular) &&
                    Objects.equals(payType, that.payType) &&
                    Objects.equals(empType, that.empType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(eventDate, employeeName,
                    deptName, payScaleName, designationName,departmentCategoryId,
                    retirementDate, officeName, dateNxtIncr, empBasicPay, dateJoining, employeeNo,
                    employeeId, employeeClass, cellId, payBandValue, payScale,
                    payBandId, payLevelId, gradePayId, payBandName, gradePayName,
                    payLevelName,
                    currentDetailsEventId,
                    departmentCategoryName,
                    designationId, classId, cellName, payCommId, payCommName, 
                    fixProbationalPayDate, conversionDateToRegular, payType, empType);
        }
    }



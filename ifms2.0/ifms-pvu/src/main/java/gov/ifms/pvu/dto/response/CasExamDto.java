package gov.ifms.pvu.dto.response;

import java.util.Date;

public class CasExamDto {

    private String examName;

    private String examBody;

    private Date examPassingDate;

    private String examStatus;

    private String courseName;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Instantiates a new Exam dto.
     *
     * @param examName        the exam name
     * @param examBody        the exam body
     * @param examPassingDate the exam passing date
     * @param examStatus      the exam status
     */
    public CasExamDto(String examName, String examBody, Date examPassingDate, String examStatus,String courseName) {
        this.examName = examName;
        this.examBody = examBody;
        this.examPassingDate = examPassingDate;
        this.examStatus = examStatus;
        this.courseName=courseName;
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
    public static CasExamDto create(String examName, String examBody, Date dateOfPassing, String examStatus,String courseName) {
        return new CasExamDto(examName, examBody, dateOfPassing, examStatus,courseName);
    }
}

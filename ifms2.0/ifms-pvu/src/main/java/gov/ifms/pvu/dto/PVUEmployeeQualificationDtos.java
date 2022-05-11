package gov.ifms.pvu.dto;

import java.util.List;

/**
 * The Class PVUEmployeeQualificationDtos.
 */
public class PVUEmployeeQualificationDtos {

    /**
     * The pvu employe qualification dto.
     */
    private List<PVUEmployeQualificationDto> pvuEmployeQualificationDto;

    /**
     * The pvu employe dept exam details dto.
     */
    private List<PVUEmployeDeptExamDetailsDto> pvuEmployeDeptExamDetailsDto;

    /**
     * The pvu employe dept exam details dto.
     */
    private PVUEmployeDeptExamDetailsDto exemptedDeptExam;

    /** The exempted ccc exam. */
    private PVUEmployeCCCExamDetailDto exemptedCccExam;

    /** The exempted dept exam flag. */
    private boolean exemptedDeptExamFlag;

    /** The exempted ccc exam flag. */
    private boolean exemptedCccExamFlag;

    /**
     * The pvu employe CCC exam detail dto.
     */
    private List<PVUEmployeCCCExamDetailDto> pvuEmployeCCCExamDetailDto;

    /**
     * The pvu employe CCC exam detail dto.
     */

    /**
     * The pvu employe lang exam dto.
     */
    private List<PVUEmployeLangExamDto> pvuEmployeLangExamDto;

    /**
     * Instantiates a new PVU employee qualification dtos.
     */
    public PVUEmployeeQualificationDtos() {
        super();
    }

    /**
     * Gets the pvu employe qualification dto.
     *
     * @return the pvu employe qualification dto
     */
    public List<PVUEmployeQualificationDto> getPvuEmployeQualificationDto() {
        return pvuEmployeQualificationDto;
    }

    /**
     * Sets the pvu employe qualification dto.
     *
     * @param pvuEmployeQualificationDto the new pvu employe qualification dto
     */
    public void setPvuEmployeQualificationDto(List<PVUEmployeQualificationDto> pvuEmployeQualificationDto) {
        this.pvuEmployeQualificationDto = pvuEmployeQualificationDto;
    }

    /**
     * Gets the pvu employe dept exam details dto.
     *
     * @return the pvu employe dept exam details dto
     */
    public List<PVUEmployeDeptExamDetailsDto> getPvuEmployeDeptExamDetailsDto() {
        return pvuEmployeDeptExamDetailsDto;
    }

    /**
     * Sets the pvu employe dept exam details dto.
     *
     * @param pvuEmployeDeptExamDetailsDto the new pvu employe dept exam details dto
     */
    public void setPvuEmployeDeptExamDetailsDto(List<PVUEmployeDeptExamDetailsDto> pvuEmployeDeptExamDetailsDto) {
        this.pvuEmployeDeptExamDetailsDto = pvuEmployeDeptExamDetailsDto;
    }

    /**
     * Gets the pvu employe CCC exam detail dto.
     *
     * @return the pvu employe CCC exam detail dto
     */
    public List<PVUEmployeCCCExamDetailDto> getPvuEmployeCCCExamDetailDto() {
        return pvuEmployeCCCExamDetailDto;
    }

    /**
     * Sets the pvu employe CCC exam detail dto.
     *
     * @param pvuEmployeCCCExamDetailDto the new pvu employe CCC exam detail dto
     */
    public void setPvuEmployeCCCExamDetailDto(List<PVUEmployeCCCExamDetailDto> pvuEmployeCCCExamDetailDto) {
        this.pvuEmployeCCCExamDetailDto = pvuEmployeCCCExamDetailDto;
    }

    /**
     * Gets the pvu employe lang exam dto.
     *
     * @return the pvu employe lang exam dto
     */
    public List<PVUEmployeLangExamDto> getPvuEmployeLangExamDto() {
        return pvuEmployeLangExamDto;
    }

    /**
     * Sets the pvu employe lang exam dto.
     *
     * @param pvuEmployeLangExamDto the new pvu employe lang exam dto
     */
    public void setPvuEmployeLangExamDto(List<PVUEmployeLangExamDto> pvuEmployeLangExamDto) {
        this.pvuEmployeLangExamDto = pvuEmployeLangExamDto;
    }

    /**
     * Gets the exempted dept exam.
     *
     * @return the exempted dept exam
     */
    public PVUEmployeDeptExamDetailsDto getExemptedDeptExam() {
        return exemptedDeptExam;
    }

    /**
     * Sets the exempted dept exam.
     *
     * @param exemptedDeptExam the new exempted dept exam
     */
    public void setExemptedDeptExam(PVUEmployeDeptExamDetailsDto exemptedDeptExam) {
        this.exemptedDeptExam = exemptedDeptExam;
    }

    /**
     * Gets the exempted ccc exam.
     *
     * @return the exempted ccc exam
     */
    public PVUEmployeCCCExamDetailDto getExemptedCccExam() {
        return exemptedCccExam;
    }

    /**
     * Sets the exempted ccc exam.
     *
     * @param exemptedCccExam the new exempted ccc exam
     */
    public void setExemptedCccExam(PVUEmployeCCCExamDetailDto exemptedCccExam) {
        this.exemptedCccExam = exemptedCccExam;
    }

    /**
     * Checks if is exempted dept exam flag.
     *
     * @return true, if is exempted dept exam flag
     */
    public boolean isExemptedDeptExamFlag() {
        return exemptedDeptExamFlag;
    }

    /**
     * Sets the exempted dept exam flag.
     *
     * @param exemptedDeptExamFlag the new exempted dept exam flag
     */
    public void setExemptedDeptExamFlag(boolean exemptedDeptExamFlag) {
        this.exemptedDeptExamFlag = exemptedDeptExamFlag;
    }

    /**
     * Checks if is exempted ccc exam flag.
     *
     * @return true, if is exempted ccc exam flag
     */
    public boolean isExemptedCccExamFlag() {
        return exemptedCccExamFlag;
    }

    /**
     * Sets the exempted ccc exam flag.
     *
     * @param exemptedCccExamFlag the new exempted ccc exam flag
     */
    public void setExemptedCccExamFlag(boolean exemptedCccExamFlag) {
        this.exemptedCccExamFlag = exemptedCccExamFlag;
    }
}

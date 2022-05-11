package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class PVUEmployeeQualificationDtos.
 */
public class PVUEmployeeQualificationUpdateDtos implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The pvu employe qualification dto.
	 */
	private List<PVUEmployeQualificationDto> pvuEmployeQualificationDto;

	/**
	 * The pvu employe dept exam details dto.
	 */
	private List<PVUEmployeDeptExamDetailsEditableDto> pvuEmployeDeptExamDetailsDto;

	/**
	 * The pvu employe dept exam details dto.
	 */
	private PVUEmployeDeptExamDetailsEditableDto exemptedDeptExam;

	
	/** The exempted ccc exam. */
	private PVUEmployeCCCExamDetailEditableDto exemptedCccExam;
	
	
	private List<PVUEmployeCCCExamDetailEditableDto> pvuEmployeCCCExamDetailDto;
	
	
	/**
	 * The pvu employe lang exam dto.
	 */
	private List<PVUEmployeLangExamEditableDto> pvuEmployeLangExamDto;


	/** The exempted dept exam flag. */
	private boolean exemptedDeptExamFlag;

	/** The exempted ccc exam flag. */
	private boolean exemptedCccExamFlag;

	


	/**
	 * @return the pvuEmployeQualificationDto
	 */
	public List<PVUEmployeQualificationDto> getPvuEmployeQualificationDto() {
		return pvuEmployeQualificationDto;
	}

	/**
	 * @param pvuEmployeQualificationDto the pvuEmployeQualificationDto to set
	 */
	public void setPvuEmployeQualificationDto(List<PVUEmployeQualificationDto> pvuEmployeQualificationDto) {
		this.pvuEmployeQualificationDto = pvuEmployeQualificationDto;
	}
/**
	 * @return the pvuEmployeDeptExamDetailsDto
	 */
	public List<PVUEmployeDeptExamDetailsEditableDto> getPvuEmployeDeptExamDetailsDto() {
		return pvuEmployeDeptExamDetailsDto;
	}

	/**
	 * @param pvuEmployeDeptExamDetailsDto the pvuEmployeDeptExamDetailsDto to set
	 */
	public void setPvuEmployeDeptExamDetailsDto(List<PVUEmployeDeptExamDetailsEditableDto> pvuEmployeDeptExamDetailsDto) {
		this.pvuEmployeDeptExamDetailsDto = pvuEmployeDeptExamDetailsDto;
	}

	/**
	 * @return the exemptedDeptExam
	 */
	public PVUEmployeDeptExamDetailsEditableDto getExemptedDeptExam() {
		return exemptedDeptExam;
	}

	/**
	 * @param exemptedDeptExam the exemptedDeptExam to set
	 */
	public void setExemptedDeptExam(PVUEmployeDeptExamDetailsEditableDto exemptedDeptExam) {
		this.exemptedDeptExam = exemptedDeptExam;
	}

	/**
	 * @return the exemptedDeptExamFlag
	 */
	public boolean isExemptedDeptExamFlag() {
		return exemptedDeptExamFlag;
	}

	/**
	 * @param exemptedDeptExamFlag the exemptedDeptExamFlag to set
	 */
	public void setExemptedDeptExamFlag(boolean exemptedDeptExamFlag) {
		this.exemptedDeptExamFlag = exemptedDeptExamFlag;
	}

	/**
	 * @return the exemptedCccExam
	 */
	public PVUEmployeCCCExamDetailEditableDto getExemptedCccExam() {
		return exemptedCccExam;
	}

	/**
	 * @param exemptedCccExam the exemptedCccExam to set
	 */
	public void setExemptedCccExam(PVUEmployeCCCExamDetailEditableDto exemptedCccExam) {
		this.exemptedCccExam = exemptedCccExam;
	}

	/**
	 * @return the exemptedCccExamFlag
	 */
	public boolean isExemptedCccExamFlag() {
		return exemptedCccExamFlag;
	}

	/**
	 * @param exemptedCccExamFlag the exemptedCccExamFlag to set
	 */
	public void setExemptedCccExamFlag(boolean exemptedCccExamFlag) {
		this.exemptedCccExamFlag = exemptedCccExamFlag;
	}

	/**
	 * @return the pvuEmployeCCCExamDetailDto
	 */
	public List<PVUEmployeCCCExamDetailEditableDto> getPvuEmployeCCCExamDetailDto() {
		return pvuEmployeCCCExamDetailDto;
	}

	/**
	 * @param pvuEmployeCCCExamDetailDto the pvuEmployeCCCExamDetailDto to set
	 */
	public void setPvuEmployeCCCExamDetailDto(List<PVUEmployeCCCExamDetailEditableDto> pvuEmployeCCCExamDetailDto) {
		this.pvuEmployeCCCExamDetailDto = pvuEmployeCCCExamDetailDto;
	}

	/**
	 * @return the pvuEmployeLangExamDto
	 */
	public List<PVUEmployeLangExamEditableDto> getPvuEmployeLangExamDto() {
		return pvuEmployeLangExamDto;
	}

	/**
	 * @param pvuEmployeLangExamDto the pvuEmployeLangExamDto to set
	 */
	public void setPvuEmployeLangExamDto(List<PVUEmployeLangExamEditableDto> pvuEmployeLangExamDto) {
		this.pvuEmployeLangExamDto = pvuEmployeLangExamDto;
	}

}

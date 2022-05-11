package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "MDMO_DEPT_MINISTRY", schema = Constant.DMO_SCHEMA)
public class DMODEPTMinistry extends BaseEntity implements Serializable{
	
	
	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The is DEPT_MINISTRY_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPT_MINISTRY_ID")
	private Long id;
	
	/** The is DEPT_MINISTRY_NAME. */
	@Column(name = "DEPT_MINISTRY_NAME")
	private String deptMinistryName;
	
	/** The is DEPT_MINISTRY_GUJ. */
	@Column(name = "DEPT_MINISTRY_GUJ")
	private String deptMinistryGuj;
	
	/** The is EFFECTIVE_FRM_DT. */
	@Column(name = "EFFECTIVE_FRM_DT")
	private LocalDate effectiveFrmDt;
	
	/** The is EFFECTIVE_TO_DT. */
	@Column(name = "EFFECTIVE_TO_DT")
	private LocalDate effectiveToDt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the deptMinistryName
	 */
	public String getDeptMinistryName() {
		return deptMinistryName;
	}

	/**
	 * @param deptMinistryName the deptMinistryName to set
	 */
	public void setDeptMinistryName(String deptMinistryName) {
		this.deptMinistryName = deptMinistryName;
	}

	/**
	 * @return the deptMinistryGuj
	 */
	public String getDeptMinistryGuj() {
		return deptMinistryGuj;
	}

	/**
	 * @param deptMinistryGuj the deptMinistryGuj to set
	 */
	public void setDeptMinistryGuj(String deptMinistryGuj) {
		this.deptMinistryGuj = deptMinistryGuj;
	}

	/**
	 * @return the effectiveFrmDt
	 */
	public LocalDate getEffectiveFrmDt() {
		return effectiveFrmDt;
	}

	/**
	 * @param effectiveFrmDt the effectiveFrmDt to set
	 */
	public void setEffectiveFrmDt(LocalDate effectiveFrmDt) {
		this.effectiveFrmDt = effectiveFrmDt;
	}

	/**
	 * @return the effectiveToDt
	 */
	public LocalDate getEffectiveToDt() {
		return effectiveToDt;
	}

	/**
	 * @param effectiveToDt the effectiveToDt to set
	 */
	public void setEffectiveToDt(LocalDate effectiveToDt) {
		this.effectiveToDt = effectiveToDt;
	}
	

}

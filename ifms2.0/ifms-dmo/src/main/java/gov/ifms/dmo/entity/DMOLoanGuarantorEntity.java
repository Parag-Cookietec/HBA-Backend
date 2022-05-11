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
@Table(name = "MDMO_LOAN_GUARANTOR", schema = Constant.DMO_SCHEMA)
public class DMOLoanGuarantorEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The is LOAN_GUARANTOR_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOAN_GUARANTOR_ID")
	private Long id;
	
	/** The is DEPARTMENT_ID. */
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	/** The is DEPARTMENT_NAME. */
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	
	/** The is ORGANIZATION_NAME. */
	@Column(name = "ORGANIZATION_NAME")
	private String organizationName;
	
	/** The is START_FRM_DT. */
	@Column(name = "START_FRM_DT")
	private LocalDate startFrmDt;
	
	/** The is END_TO_DT. */
	@Column(name = "END_TO_DT")
	private LocalDate endToDt;

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
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the startFrmDt
	 */
	public LocalDate getStartFrmDt() {
		return startFrmDt;
	}

	/**
	 * @param startFrmDt the startFrmDt to set
	 */
	public void setStartFrmDt(LocalDate startFrmDt) {
		this.startFrmDt = startFrmDt;
	}

	/**
	 * @return the endToDt
	 */
	public LocalDate getEndToDt() {
		return endToDt;
	}

	/**
	 * @param endToDt the endToDt to set
	 */
	public void setEndToDt(LocalDate endToDt) {
		this.endToDt = endToDt;
	}
	
}

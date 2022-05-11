package gov.ifms.pvu.dto;

public class EmployeeChangeType {

	private long empId;
	private long emptype;
	private long empAddtype;
	private long empNomitype;
	private long empQualitype;
	private long empDptDtltype;
	private long empLangtype;
	private long empccetype;
	private long empDpttype;
	private long empRole;
	private long empWorkFlow = -1L;
	private long empHis;
	private long empconstant = 1;


	/**
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * @return the emptype
	 */
	public long getEmptype() {
		return emptype;
	}

	/**
	 * @param emptype the emptype to set
	 */
	public void setEmptype(long emptype) {
		this.emptype = emptype;
	}

	/**
	 * @return the empAddtype
	 */
	public long getEmpAddtype() {
		return empAddtype;
	}

	/**
	 * @param empAddtype the empAddtype to set
	 */
	public void setEmpAddtype(long empAddtype) {
		this.empAddtype = empAddtype;
	}

	/**
	 * @return the empNomitype
	 */
	public long getEmpNomitype() {
		return empNomitype;
	}

	/**
	 * @param empNomitype the empNomitype to set
	 */
	public void setEmpNomitype(long empNomitype) {
		this.empNomitype = empNomitype;
	}

	/**
	 * @return the empQualitype
	 */
	public long getEmpQualitype() {
		return empQualitype;
	}

	/**
	 * @param empQualitype the empQualitype to set
	 */
	public void setEmpQualitype(long empQualitype) {
		this.empQualitype = empQualitype;
	}

	/**
	 * @return the empDptDtltype
	 */
	public long getEmpDptDtltype() {
		return empDptDtltype;
	}

	/**
	 * @param empDptDtltype the empDptDtltype to set
	 */
	public void setEmpDptDtltype(long empDptDtltype) {
		this.empDptDtltype = empDptDtltype;
	}

	/**
	 * @return the empLangtype
	 */
	public long getEmpLangtype() {
		return empLangtype;
	}

	/**
	 * @param empLangtype the empLangtype to set
	 */
	public void setEmpLangtype(long empLangtype) {
		this.empLangtype = empLangtype;
	}

	/**
	 * @return the empccetype
	 */
	public long getEmpccetype() {
		return empccetype;
	}

	/**
	 * @param empccetype the empccetype to set
	 */
	public void setEmpccetype(long empccetype) {
		this.empccetype = empccetype;
	}

	/**
	 * @return the empDpttype
	 */
	public long getEmpDpttype() {
		return empDpttype;
	}

	/**
	 * @param empDpttype the empDpttype to set
	 */
	public void setEmpDpttype(long empDpttype) {
		this.empDpttype = empDpttype;
	}

	/**
	 * @return the empRole
	 */
	public long getEmpRole() {
		return empRole;
	}

	/**
	 * @param empRole the empRole to set
	 */
	public void setEmpRole(long empRole) {
		this.empRole = empRole;
	}

	/**
	 * @return the empWorkFlow
	 */
	public long getEmpWorkFlow() {
		return empWorkFlow;
	}

	/**
	 * @param empWorkFlow the empWorkFlow to set
	 */
	public void setEmpWorkFlow(long empWorkFlow) {
		this.empWorkFlow = empWorkFlow;
	}

	/**
	 * @return the empHis
	 */
	public long getEmpHis() {
		return empHis;
	}

	/**
	 * @param empHis the empHis to set
	 */
	public void setEmpHis(long empHis) {
		this.empHis = empHis;
	}

	public long getEmpconstant() {
		return empconstant;
	}

	public void setEmpconstant(long empconstant) {
		this.empconstant = empconstant;
	}

	@Override
	public String toString() {
		return "EmployeeChangeType [empId=" + empId + ", emptype=" + emptype + ", empAddtype=" + empAddtype
				+ ", empNomitype=" + empNomitype + ", empQualitype=" + empQualitype + ", empDptDtltype=" + empDptDtltype
				+ ", empLangtype=" + empLangtype + ", empccetype=" + empccetype + ", empDpttype=" + empDpttype
				+ ", empRole=" + empRole + ", empWorkFlow=" + empWorkFlow + ", empHis=" + empHis + "]";
	}

}

package gov.ifms.gst.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsPerformanceMonitoringReportDto {

	@NativeQueryResultColumn(index = 0)
	private String subAccnt;
	@NativeQueryResultColumn(index = 1)
	private String empName;
	@NativeQueryResultColumn(index = 2)
	private String crecvChallanAllotedMatch;
	@NativeQueryResultColumn(index = 3)
	private String crecvChallanAllotedRAT;
	@NativeQueryResultColumn(index = 4)
	private String crecvChallanAllotedRATClr;
	@NativeQueryResultColumn(index = 5)
	private String crecvChallanAllotedMoe;
	@NativeQueryResultColumn(index = 6)
	private String crecvChallanTrnsInMatch;
	@NativeQueryResultColumn(index = 7)
	private String crecvChallanTrnsInRAT;
	@NativeQueryResultColumn(index = 8)
	private String crecvChallanTrnsInRATClr;
	@NativeQueryResultColumn(index = 9)
	private String crecvChallanTrnsInMoe;
	@NativeQueryResultColumn(index = 10)
	private String crecvOldRatClrMatch;
	@NativeQueryResultColumn(index = 11)
	private String crecvOldRatClrRAT;
	@NativeQueryResultColumn(index = 12)
	private String crecvOldRatClrRATClr;
	@NativeQueryResultColumn(index = 13)
	private String crecvOldRatClrMoe;
	@NativeQueryResultColumn(index = 14)
	private String crecvChallanTrnsOutMatch;
	@NativeQueryResultColumn(index = 15)
	private String crecvChallanTrnsOutRAT;
	@NativeQueryResultColumn(index = 16)
	private String crecvChallanTrnsOutRATClr;
	@NativeQueryResultColumn(index = 17)
	private String crecvChallanTrnsOutMoe;
	@NativeQueryResultColumn(index = 18)
	private String cpostChallanAllotedMatch;
	@NativeQueryResultColumn(index = 19)
	private String cpostChallanAllotedRAT;
	@NativeQueryResultColumn(index = 20)
	private String cpostChallanAllotedRATClr;
	@NativeQueryResultColumn(index = 21)
	private String cpostChallanAllotedMoe;
	@NativeQueryResultColumn(index = 22)
	private String cpostChallanTrnsInMatch;
	@NativeQueryResultColumn(index = 23)
	private String cpostChallanTrnsInRAT;
	@NativeQueryResultColumn(index = 24)
	private String cpostChallanTrnsInRATClr;
	@NativeQueryResultColumn(index = 25)
	private String cpostChallanTrnsInMoe;
	@NativeQueryResultColumn(index = 26)
	private String cpostOldRatClrMatch;
	@NativeQueryResultColumn(index = 27)
	private String cpostOldRatClrRAT;
	@NativeQueryResultColumn(index = 28)
	private String cpostOldRatClrRATClr;
	@NativeQueryResultColumn(index = 29)
	private String cpostOldRatClrMoe;
	@NativeQueryResultColumn(index = 30)
	private String cpendChallanAllotedMatch;
	@NativeQueryResultColumn(index = 31)
	private String cpendChallanAllotedRAT;
	@NativeQueryResultColumn(index = 32)
	private String cpendChallanAllotedRATClr;
	@NativeQueryResultColumn(index = 33)
	private String cpendChallanAllotedMoe;
	@NativeQueryResultColumn(index = 34)
	private String cpendChallanTrnsInMatch;
	@NativeQueryResultColumn(index = 35)
	private String cpendChallanTrnsInRAT;
	@NativeQueryResultColumn(index = 36)
	private String cpendChallanTrnsInRATClr;
	@NativeQueryResultColumn(index = 37)
	private String cpendChallanTrnsInMoe;
	@NativeQueryResultColumn(index = 38)
	private String cpendOldRatClrMatch;
	@NativeQueryResultColumn(index = 39)
	private String cpendOldRatClrRAT;
	@NativeQueryResultColumn(index = 40)
	private String cpendOldRatClrRATClr;
	@NativeQueryResultColumn(index = 41)
	private String cpendOldRatClrMoe;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GstReportDtlsPerformanceMonitoringReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the subAccnt
	 */
	public String getSubAccnt() {
		return subAccnt;
	}

	/**
	 * @param subAccnt the subAccnt to set
	 */
	public void setSubAccnt(String subAccnt) {
		this.subAccnt = subAccnt;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the crecvChallanAllotedMatch
	 */
	public String getCrecvChallanAllotedMatch() {
		return crecvChallanAllotedMatch;
	}

	/**
	 * @param crecvChallanAllotedMatch the crecvChallanAllotedMatch to set
	 */
	public void setCrecvChallanAllotedMatch(String crecvChallanAllotedMatch) {
		this.crecvChallanAllotedMatch = crecvChallanAllotedMatch;
	}

	/**
	 * @return the crecvChallanAllotedRAT
	 */
	public String getCrecvChallanAllotedRAT() {
		return crecvChallanAllotedRAT;
	}

	/**
	 * @param crecvChallanAllotedRAT the crecvChallanAllotedRAT to set
	 */
	public void setCrecvChallanAllotedRAT(String crecvChallanAllotedRAT) {
		this.crecvChallanAllotedRAT = crecvChallanAllotedRAT;
	}

	/**
	 * @return the crecvChallanAllotedRATClr
	 */
	public String getCrecvChallanAllotedRATClr() {
		return crecvChallanAllotedRATClr;
	}

	/**
	 * @param crecvChallanAllotedRATClr the crecvChallanAllotedRATClr to set
	 */
	public void setCrecvChallanAllotedRATClr(String crecvChallanAllotedRATClr) {
		this.crecvChallanAllotedRATClr = crecvChallanAllotedRATClr;
	}

	/**
	 * @return the crecvChallanAllotedMoe
	 */
	public String getCrecvChallanAllotedMoe() {
		return crecvChallanAllotedMoe;
	}

	/**
	 * @param crecvChallanAllotedMoe the crecvChallanAllotedMoe to set
	 */
	public void setCrecvChallanAllotedMoe(String crecvChallanAllotedMoe) {
		this.crecvChallanAllotedMoe = crecvChallanAllotedMoe;
	}

	/**
	 * @return the crecvChallanTrnsInMatch
	 */
	public String getCrecvChallanTrnsInMatch() {
		return crecvChallanTrnsInMatch;
	}

	/**
	 * @param crecvChallanTrnsInMatch the crecvChallanTrnsInMatch to set
	 */
	public void setCrecvChallanTrnsInMatch(String crecvChallanTrnsInMatch) {
		this.crecvChallanTrnsInMatch = crecvChallanTrnsInMatch;
	}

	/**
	 * @return the crecvChallanTrnsInRAT
	 */
	public String getCrecvChallanTrnsInRAT() {
		return crecvChallanTrnsInRAT;
	}

	/**
	 * @param crecvChallanTrnsInRAT the crecvChallanTrnsInRAT to set
	 */
	public void setCrecvChallanTrnsInRAT(String crecvChallanTrnsInRAT) {
		this.crecvChallanTrnsInRAT = crecvChallanTrnsInRAT;
	}

	/**
	 * @return the crecvChallanTrnsInRATClr
	 */
	public String getCrecvChallanTrnsInRATClr() {
		return crecvChallanTrnsInRATClr;
	}

	/**
	 * @param crecvChallanTrnsInRATClr the crecvChallanTrnsInRATClr to set
	 */
	public void setCrecvChallanTrnsInRATClr(String crecvChallanTrnsInRATClr) {
		this.crecvChallanTrnsInRATClr = crecvChallanTrnsInRATClr;
	}

	/**
	 * @return the crecvChallanTrnsInMoe
	 */
	public String getCrecvChallanTrnsInMoe() {
		return crecvChallanTrnsInMoe;
	}

	/**
	 * @param crecvChallanTrnsInMoe the crecvChallanTrnsInMoe to set
	 */
	public void setCrecvChallanTrnsInMoe(String crecvChallanTrnsInMoe) {
		this.crecvChallanTrnsInMoe = crecvChallanTrnsInMoe;
	}

	/**
	 * @return the crecvOldRatClrMatch
	 */
	public String getCrecvOldRatClrMatch() {
		return crecvOldRatClrMatch;
	}

	/**
	 * @param crecvOldRatClrMatch the crecvOldRatClrMatch to set
	 */
	public void setCrecvOldRatClrMatch(String crecvOldRatClrMatch) {
		this.crecvOldRatClrMatch = crecvOldRatClrMatch;
	}

	/**
	 * @return the crecvOldRatClrRAT
	 */
	public String getCrecvOldRatClrRAT() {
		return crecvOldRatClrRAT;
	}

	/**
	 * @param crecvOldRatClrRAT the crecvOldRatClrRAT to set
	 */
	public void setCrecvOldRatClrRAT(String crecvOldRatClrRAT) {
		this.crecvOldRatClrRAT = crecvOldRatClrRAT;
	}

	/**
	 * @return the crecvOldRatClrRATClr
	 */
	public String getCrecvOldRatClrRATClr() {
		return crecvOldRatClrRATClr;
	}

	/**
	 * @param crecvOldRatClrRATClr the crecvOldRatClrRATClr to set
	 */
	public void setCrecvOldRatClrRATClr(String crecvOldRatClrRATClr) {
		this.crecvOldRatClrRATClr = crecvOldRatClrRATClr;
	}

	/**
	 * @return the crecvOldRatClrMoe
	 */
	public String getCrecvOldRatClrMoe() {
		return crecvOldRatClrMoe;
	}

	/**
	 * @param crecvOldRatClrMoe the crecvOldRatClrMoe to set
	 */
	public void setCrecvOldRatClrMoe(String crecvOldRatClrMoe) {
		this.crecvOldRatClrMoe = crecvOldRatClrMoe;
	}

	/**
	 * @return the crecvChallanTrnsOutMatch
	 */
	public String getCrecvChallanTrnsOutMatch() {
		return crecvChallanTrnsOutMatch;
	}

	/**
	 * @param crecvChallanTrnsOutMatch the crecvChallanTrnsOutMatch to set
	 */
	public void setCrecvChallanTrnsOutMatch(String crecvChallanTrnsOutMatch) {
		this.crecvChallanTrnsOutMatch = crecvChallanTrnsOutMatch;
	}

	/**
	 * @return the crecvChallanTrnsOutRAT
	 */
	public String getCrecvChallanTrnsOutRAT() {
		return crecvChallanTrnsOutRAT;
	}

	/**
	 * @param crecvChallanTrnsOutRAT the crecvChallanTrnsOutRAT to set
	 */
	public void setCrecvChallanTrnsOutRAT(String crecvChallanTrnsOutRAT) {
		this.crecvChallanTrnsOutRAT = crecvChallanTrnsOutRAT;
	}

	/**
	 * @return the crecvChallanTrnsOutRATClr
	 */
	public String getCrecvChallanTrnsOutRATClr() {
		return crecvChallanTrnsOutRATClr;
	}

	/**
	 * @param crecvChallanTrnsOutRATClr the crecvChallanTrnsOutRATClr to set
	 */
	public void setCrecvChallanTrnsOutRATClr(String crecvChallanTrnsOutRATClr) {
		this.crecvChallanTrnsOutRATClr = crecvChallanTrnsOutRATClr;
	}

	/**
	 * @return the crecvChallanTrnsOutMoe
	 */
	public String getCrecvChallanTrnsOutMoe() {
		return crecvChallanTrnsOutMoe;
	}

	/**
	 * @param crecvChallanTrnsOutMoe the crecvChallanTrnsOutMoe to set
	 */
	public void setCrecvChallanTrnsOutMoe(String crecvChallanTrnsOutMoe) {
		this.crecvChallanTrnsOutMoe = crecvChallanTrnsOutMoe;
	}

	/**
	 * @return the cpostChallanAllotedMatch
	 */
	public String getCpostChallanAllotedMatch() {
		return cpostChallanAllotedMatch;
	}

	/**
	 * @param cpostChallanAllotedMatch the cpostChallanAllotedMatch to set
	 */
	public void setCpostChallanAllotedMatch(String cpostChallanAllotedMatch) {
		this.cpostChallanAllotedMatch = cpostChallanAllotedMatch;
	}

	/**
	 * @return the cpostChallanAllotedRAT
	 */
	public String getCpostChallanAllotedRAT() {
		return cpostChallanAllotedRAT;
	}

	/**
	 * @param cpostChallanAllotedRAT the cpostChallanAllotedRAT to set
	 */
	public void setCpostChallanAllotedRAT(String cpostChallanAllotedRAT) {
		this.cpostChallanAllotedRAT = cpostChallanAllotedRAT;
	}

	/**
	 * @return the cpostChallanAllotedRATClr
	 */
	public String getCpostChallanAllotedRATClr() {
		return cpostChallanAllotedRATClr;
	}

	/**
	 * @param cpostChallanAllotedRATClr the cpostChallanAllotedRATClr to set
	 */
	public void setCpostChallanAllotedRATClr(String cpostChallanAllotedRATClr) {
		this.cpostChallanAllotedRATClr = cpostChallanAllotedRATClr;
	}

	/**
	 * @return the cpostChallanAllotedMoe
	 */
	public String getCpostChallanAllotedMoe() {
		return cpostChallanAllotedMoe;
	}

	/**
	 * @param cpostChallanAllotedMoe the cpostChallanAllotedMoe to set
	 */
	public void setCpostChallanAllotedMoe(String cpostChallanAllotedMoe) {
		this.cpostChallanAllotedMoe = cpostChallanAllotedMoe;
	}

	/**
	 * @return the cpostChallanTrnsInMatch
	 */
	public String getCpostChallanTrnsInMatch() {
		return cpostChallanTrnsInMatch;
	}

	/**
	 * @param cpostChallanTrnsInMatch the cpostChallanTrnsInMatch to set
	 */
	public void setCpostChallanTrnsInMatch(String cpostChallanTrnsInMatch) {
		this.cpostChallanTrnsInMatch = cpostChallanTrnsInMatch;
	}

	/**
	 * @return the cpostChallanTrnsInRAT
	 */
	public String getCpostChallanTrnsInRAT() {
		return cpostChallanTrnsInRAT;
	}

	/**
	 * @param cpostChallanTrnsInRAT the cpostChallanTrnsInRAT to set
	 */
	public void setCpostChallanTrnsInRAT(String cpostChallanTrnsInRAT) {
		this.cpostChallanTrnsInRAT = cpostChallanTrnsInRAT;
	}

	/**
	 * @return the cpostChallanTrnsInRATClr
	 */
	public String getCpostChallanTrnsInRATClr() {
		return cpostChallanTrnsInRATClr;
	}

	/**
	 * @param cpostChallanTrnsInRATClr the cpostChallanTrnsInRATClr to set
	 */
	public void setCpostChallanTrnsInRATClr(String cpostChallanTrnsInRATClr) {
		this.cpostChallanTrnsInRATClr = cpostChallanTrnsInRATClr;
	}

	/**
	 * @return the cpostChallanTrnsInMoe
	 */
	public String getCpostChallanTrnsInMoe() {
		return cpostChallanTrnsInMoe;
	}

	/**
	 * @param cpostChallanTrnsInMoe the cpostChallanTrnsInMoe to set
	 */
	public void setCpostChallanTrnsInMoe(String cpostChallanTrnsInMoe) {
		this.cpostChallanTrnsInMoe = cpostChallanTrnsInMoe;
	}

	/**
	 * @return the cpostOldRatClrMatch
	 */
	public String getCpostOldRatClrMatch() {
		return cpostOldRatClrMatch;
	}

	/**
	 * @param cpostOldRatClrMatch the cpostOldRatClrMatch to set
	 */
	public void setCpostOldRatClrMatch(String cpostOldRatClrMatch) {
		this.cpostOldRatClrMatch = cpostOldRatClrMatch;
	}

	/**
	 * @return the cpostOldRatClrRAT
	 */
	public String getCpostOldRatClrRAT() {
		return cpostOldRatClrRAT;
	}

	/**
	 * @param cpostOldRatClrRAT the cpostOldRatClrRAT to set
	 */
	public void setCpostOldRatClrRAT(String cpostOldRatClrRAT) {
		this.cpostOldRatClrRAT = cpostOldRatClrRAT;
	}

	/**
	 * @return the cpostOldRatClrRATClr
	 */
	public String getCpostOldRatClrRATClr() {
		return cpostOldRatClrRATClr;
	}

	/**
	 * @param cpostOldRatClrRATClr the cpostOldRatClrRATClr to set
	 */
	public void setCpostOldRatClrRATClr(String cpostOldRatClrRATClr) {
		this.cpostOldRatClrRATClr = cpostOldRatClrRATClr;
	}

	/**
	 * @return the cpostOldRatClrMoe
	 */
	public String getCpostOldRatClrMoe() {
		return cpostOldRatClrMoe;
	}

	/**
	 * @param cpostOldRatClrMoe the cpostOldRatClrMoe to set
	 */
	public void setCpostOldRatClrMoe(String cpostOldRatClrMoe) {
		this.cpostOldRatClrMoe = cpostOldRatClrMoe;
	}

	/**
	 * @return the cpendChallanAllotedMatch
	 */
	public String getCpendChallanAllotedMatch() {
		return cpendChallanAllotedMatch;
	}

	/**
	 * @param cpendChallanAllotedMatch the cpendChallanAllotedMatch to set
	 */
	public void setCpendChallanAllotedMatch(String cpendChallanAllotedMatch) {
		this.cpendChallanAllotedMatch = cpendChallanAllotedMatch;
	}

	/**
	 * @return the cpendChallanAllotedRAT
	 */
	public String getCpendChallanAllotedRAT() {
		return cpendChallanAllotedRAT;
	}

	/**
	 * @param cpendChallanAllotedRAT the cpendChallanAllotedRAT to set
	 */
	public void setCpendChallanAllotedRAT(String cpendChallanAllotedRAT) {
		this.cpendChallanAllotedRAT = cpendChallanAllotedRAT;
	}

	/**
	 * @return the cpendChallanAllotedRATClr
	 */
	public String getCpendChallanAllotedRATClr() {
		return cpendChallanAllotedRATClr;
	}

	/**
	 * @param cpendChallanAllotedRATClr the cpendChallanAllotedRATClr to set
	 */
	public void setCpendChallanAllotedRATClr(String cpendChallanAllotedRATClr) {
		this.cpendChallanAllotedRATClr = cpendChallanAllotedRATClr;
	}

	/**
	 * @return the cpendChallanAllotedMoe
	 */
	public String getCpendChallanAllotedMoe() {
		return cpendChallanAllotedMoe;
	}

	/**
	 * @param cpendChallanAllotedMoe the cpendChallanAllotedMoe to set
	 */
	public void setCpendChallanAllotedMoe(String cpendChallanAllotedMoe) {
		this.cpendChallanAllotedMoe = cpendChallanAllotedMoe;
	}

	/**
	 * @return the cpendChallanTrnsInMatch
	 */
	public String getCpendChallanTrnsInMatch() {
		return cpendChallanTrnsInMatch;
	}

	/**
	 * @param cpendChallanTrnsInMatch the cpendChallanTrnsInMatch to set
	 */
	public void setCpendChallanTrnsInMatch(String cpendChallanTrnsInMatch) {
		this.cpendChallanTrnsInMatch = cpendChallanTrnsInMatch;
	}

	/**
	 * @return the cpendChallanTrnsInRAT
	 */
	public String getCpendChallanTrnsInRAT() {
		return cpendChallanTrnsInRAT;
	}

	/**
	 * @param cpendChallanTrnsInRAT the cpendChallanTrnsInRAT to set
	 */
	public void setCpendChallanTrnsInRAT(String cpendChallanTrnsInRAT) {
		this.cpendChallanTrnsInRAT = cpendChallanTrnsInRAT;
	}

	/**
	 * @return the cpendChallanTrnsInRATClr
	 */
	public String getCpendChallanTrnsInRATClr() {
		return cpendChallanTrnsInRATClr;
	}

	/**
	 * @param cpendChallanTrnsInRATClr the cpendChallanTrnsInRATClr to set
	 */
	public void setCpendChallanTrnsInRATClr(String cpendChallanTrnsInRATClr) {
		this.cpendChallanTrnsInRATClr = cpendChallanTrnsInRATClr;
	}

	/**
	 * @return the cpendChallanTrnsInMoe
	 */
	public String getCpendChallanTrnsInMoe() {
		return cpendChallanTrnsInMoe;
	}

	/**
	 * @param cpendChallanTrnsInMoe the cpendChallanTrnsInMoe to set
	 */
	public void setCpendChallanTrnsInMoe(String cpendChallanTrnsInMoe) {
		this.cpendChallanTrnsInMoe = cpendChallanTrnsInMoe;
	}

	/**
	 * @return the cpendOldRatClrMatch
	 */
	public String getCpendOldRatClrMatch() {
		return cpendOldRatClrMatch;
	}

	/**
	 * @param cpendOldRatClrMatch the cpendOldRatClrMatch to set
	 */
	public void setCpendOldRatClrMatch(String cpendOldRatClrMatch) {
		this.cpendOldRatClrMatch = cpendOldRatClrMatch;
	}

	/**
	 * @return the cpendOldRatClrRAT
	 */
	public String getCpendOldRatClrRAT() {
		return cpendOldRatClrRAT;
	}

	/**
	 * @param cpendOldRatClrRAT the cpendOldRatClrRAT to set
	 */
	public void setCpendOldRatClrRAT(String cpendOldRatClrRAT) {
		this.cpendOldRatClrRAT = cpendOldRatClrRAT;
	}

	/**
	 * @return the cpendOldRatClrRATClr
	 */
	public String getCpendOldRatClrRATClr() {
		return cpendOldRatClrRATClr;
	}

	/**
	 * @param cpendOldRatClrRATClr the cpendOldRatClrRATClr to set
	 */
	public void setCpendOldRatClrRATClr(String cpendOldRatClrRATClr) {
		this.cpendOldRatClrRATClr = cpendOldRatClrRATClr;
	}

	/**
	 * @return the cpendOldRatClrMoe
	 */
	public String getCpendOldRatClrMoe() {
		return cpendOldRatClrMoe;
	}

	/**
	 * @param cpendOldRatClrMoe the cpendOldRatClrMoe to set
	 */
	public void setCpendOldRatClrMoe(String cpendOldRatClrMoe) {
		this.cpendOldRatClrMoe = cpendOldRatClrMoe;
	}
}

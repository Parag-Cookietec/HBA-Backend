package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUJoiningEmployeeView.
 */
@NativeQueryResultEntity
public class PVUJoiningEmployeeView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The c 0. */
	@NativeQueryResultColumn(index = 0)
	private long transDetailId;

	/** The trans no. */
	@NativeQueryResultColumn(index = 1)
	private String transNo;

	/** The emp id. */
	@NativeQueryResultColumn(index = 2)
	private String empNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 3)
	private String empName;

	/** The designation. */
	@NativeQueryResultColumn(index = 4)
	private String designation;

	/** The office name. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;

	/** The office name. */
	@NativeQueryResultColumn(index = 6)
	private String relivingDate;

	/** The c 4. */
	@NativeQueryResultColumn(index = 7)
	private long transferEmpId;

	/** The c 5. */
	@NativeQueryResultColumn(index = 8)
	private String submitted;

	public long getTransDetailId() {
		return transDetailId;
	}

	public void setTransDetailId(long transDetailId) {
		this.transDetailId = transDetailId;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getRelivingDate() {
		return relivingDate;
	}

	public void setRelivingDate(String relivingDate) {
		this.relivingDate = relivingDate;
	}

	public long getTransferEmpId() {
		return transferEmpId;
	}

	public void setTransferEmpId(long transferEmpId) {
		this.transferEmpId = transferEmpId;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}
}

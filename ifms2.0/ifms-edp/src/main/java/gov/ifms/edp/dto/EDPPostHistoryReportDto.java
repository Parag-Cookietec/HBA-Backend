package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class EDPPostHistoryReportDto implements Serializable {

	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The designation id. */
    @NativeQueryResultColumn(index = 0)
    private String postName;
    
    @NativeQueryResultColumn(index = 1)
    private Long empNo;
    
    @NativeQueryResultColumn(index = 2)
    private String userName;
    
    @NativeQueryResultColumn(index = 3)
    private String fromDAte;

    @NativeQueryResultColumn(index = 4)
    private String toDate;
    
    @NativeQueryResultColumn(index = 5)
    private int count;

	/**
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the fromDAte
	 */
	public String getFromDAte() {
		return fromDAte;
	}

	/**
	 * @param fromDAte the fromDAte to set
	 */
	public void setFromDAte(String fromDAte) {
		this.fromDAte = fromDAte;
	}

	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(count, empNo, fromDAte, postName, toDate, userName);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPPostHistoryReportDto)) {
			return false;
		}
		EDPPostHistoryReportDto other = (EDPPostHistoryReportDto) obj;
		return count == other.count && Objects.equals(empNo, other.empNo) && Objects.equals(fromDAte, other.fromDAte)
				&& Objects.equals(postName, other.postName) && Objects.equals(toDate, other.toDate)
				&& Objects.equals(userName, other.userName);
	}
    
}

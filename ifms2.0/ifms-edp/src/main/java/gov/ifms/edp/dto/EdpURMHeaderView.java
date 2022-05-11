package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EdpURMHeaderView.
 */
@NativeQueryResultEntity
public class EdpURMHeaderView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn no. */
	@NativeQueryResultColumn(index = 0)
	private String trnNo;

	/** The trn date. */
	@NativeQueryResultColumn(index = 1)
	private String trnDate;

	/** The district. */
	@NativeQueryResultColumn(index = 2)
	private String district;

	/** The ddo office. */
	@NativeQueryResultColumn(index = 3)
	private String ddoOffice;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 4)
	private String cardexNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 5)
	private String ddoNo;

	/** The emp no. */
	@NativeQueryResultColumn(index = 6)
	private String empNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 7)
	private String empName;

	/** The status. */
	@NativeQueryResultColumn(index = 8)
	private String status;

	/** The remark. */
	@NativeQueryResultColumn(index = 9)
	private String remark;

	/** The transaction id. */
	@NativeQueryResultColumn(index = 10)
	private String transactionId;

	/** The record count. */
	@NativeQueryResultColumn(index = 11)
	private long lkPostOffId;

	/** The record count. */
	@NativeQueryResultColumn(index = 12)
	private String districtId;
	
	/** The record count. */
	@NativeQueryResultColumn(index = 13)
	private String recordCount;
	
	@NativeQueryResultColumn(index = 14)
	private String postName;
	
	@NativeQueryResultColumn(index = 15)
	private String lyingWith;

	@NativeQueryResultColumn(index = 16)
	private String wfStatus;
	
	/** The status. */
	@NativeQueryResultColumn(index = 17)
	private String trnStatus;
	
	/** The is editable. */
	@NativeQueryResultColumn(index = 18)
	private int isEditable;
	
	
	
	/**
	 * Gets the trn no.
	 *
	 * @return the trn no
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the new trn no
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the trn date.
	 *
	 * @return the trn date
	 */
	public String getTrnDate() {
		return trnDate;
	}

	/**
	 * Sets the trn date.
	 *
	 * @param trnDate the new trn date
	 */
	public void setTrnDate(String trnDate) {
		this.trnDate = trnDate;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the new district
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo office.
	 *
	 * @return the ddo office
	 */
	public String getDdoOffice() {
		return ddoOffice;
	}

	/**
	 * Sets the ddo office.
	 *
	 * @param ddoOffice the new ddo office
	 */
	public void setDdoOffice(String ddoOffice) {
		this.ddoOffice = ddoOffice;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the emp no
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the new emp no
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the emp name
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the new emp name
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the transaction id.
	 *
	 * @param transactionId the new transaction id
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Gets the record count.
	 *
	 * @return the record count
	 */
	public String getRecordCount() {
		return recordCount;
	}

	/**
	 * Sets the record count.
	 *
	 * @param recordCount the new record count
	 */
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	public long getLkPostOffId() {
		return lkPostOffId;
	}

	public void setLkPostOffId(long lkPostOffId) {
		this.lkPostOffId = lkPostOffId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

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
	 * @return the lyingWith
	 */
	public String getLyingWith() {
		return lyingWith;
	}

	/**
	 * @param lyingWith the lyingWith to set
	 */
	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	/**
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * @return the isEditable
	 */
	public int getIsEditable() {
		return isEditable;
	}

	/**
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
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
		return Objects.hash(cardexNo, ddoNo, ddoOffice, district, districtId, empName, empNo, isEditable, lkPostOffId,
				lyingWith, postName, recordCount, remark, status, transactionId, trnDate, trnNo, trnStatus, wfStatus);
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
		if (!(obj instanceof EdpURMHeaderView)) {
			return false;
		}
		EdpURMHeaderView other = (EdpURMHeaderView) obj;
		return Objects.equals(cardexNo, other.cardexNo) && Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(ddoOffice, other.ddoOffice) && Objects.equals(district, other.district)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(empName, other.empName)
				&& Objects.equals(empNo, other.empNo) && isEditable == other.isEditable
				&& lkPostOffId == other.lkPostOffId && Objects.equals(lyingWith, other.lyingWith)
				&& Objects.equals(postName, other.postName) && Objects.equals(recordCount, other.recordCount)
				&& Objects.equals(remark, other.remark) && Objects.equals(status, other.status)
				&& Objects.equals(transactionId, other.transactionId) && Objects.equals(trnDate, other.trnDate)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(trnStatus, other.trnStatus)
				&& Objects.equals(wfStatus, other.wfStatus);
	}
	
	
	
}

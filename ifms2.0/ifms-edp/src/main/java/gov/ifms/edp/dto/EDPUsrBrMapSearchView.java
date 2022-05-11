package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUsrBrMapSearchView.
 */
@NativeQueryResultEntity
public class EDPUsrBrMapSearchView implements Serializable {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po trns header id. */
	@NativeQueryResultColumn(index = 0)
	private Long tedpBrHdrId;

	/** The ref no. */
	@NativeQueryResultColumn(index = 1)
	private String refNo;
	
	/** The ref date. */
	@NativeQueryResultColumn(index = 2)
	private Date refDate;

	/** The ddo office. */
	@NativeQueryResultColumn(index = 3)
	private String districtName;
	
	/** The cardex no. */
	@NativeQueryResultColumn(index = 4)
	private String ddoNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 5)
	private String cardexNo;

	/** The district name. */
	@NativeQueryResultColumn(index = 6)
	private String ddoOffice;

	/** The request type. */
	@NativeQueryResultColumn(index = 7)
	private String requestType;

	/** The from employee no. */
	@NativeQueryResultColumn(index = 8)
	private String fromEmployeeNo;

	/** The from employee name. */
	@NativeQueryResultColumn(index = 9)
	private String fromPostName;

	/** The to employee name. */
	@NativeQueryResultColumn(index = 10)
	private String toEmployeeNo;

	/** The to employee no. */
	@NativeQueryResultColumn(index = 11)
	private String toPostName;	

	/** The lying with. */
	@NativeQueryResultColumn(index = 12)
	private String lyingWith;	

	/** The status. */
	@NativeQueryResultColumn(index = 13)
	private String status;	

	/** The status id. */
	@NativeQueryResultColumn(index = 14)
	private Long statusId;	

	/** The count. */
	@NativeQueryResultColumn(index = 15)
	private int count;

	/** The upd date. */
	@NativeQueryResultColumn(index = 16)
	private Date updDate;

	/** The from employee name. */
	@NativeQueryResultColumn(index = 17)
	private String fromEmployeeName;
	
	/** The to employee name. */
	@NativeQueryResultColumn(index = 18)
	private String toEmployeeName;

	/**
	 * Gets the tedp br hdr id.
	 *
	 * @return the tedp br hdr id
	 */
	public Long getTedpBrHdrId() {
		return tedpBrHdrId;
	}

	/**
	 * Sets the tedp br hdr id.
	 *
	 * @param tedpBrHdrId the new tedp br hdr id
	 */
	public void setTedpBrHdrId(Long tedpBrHdrId) {
		this.tedpBrHdrId = tedpBrHdrId;
	}

	/**
	 * Gets the ref no.
	 *
	 * @return the ref no
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Sets the ref no.
	 *
	 * @param refNo the new ref no
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Gets the ref date.
	 *
	 * @return the ref date
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the new ref date
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the district name
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the new district name
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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
	 * Gets the request type.
	 *
	 * @return the request type
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * Sets the request type.
	 *
	 * @param requestType the new request type
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * Gets the from employee no.
	 *
	 * @return the from employee no
	 */
	public String getFromEmployeeNo() {
		return fromEmployeeNo;
	}

	/**
	 * Sets the from employee no.
	 *
	 * @param fromEmployeeNo the new from employee no
	 */
	public void setFromEmployeeNo(String fromEmployeeNo) {
		this.fromEmployeeNo = fromEmployeeNo;
	}

	/**
	 * Gets the from post name.
	 *
	 * @return the from post name
	 */
	public String getFromPostName() {
		return fromPostName;
	}

	/**
	 * Sets the from post name.
	 *
	 * @param fromPostName the new from post name
	 */
	public void setFromPostName(String fromPostName) {
		this.fromPostName = fromPostName;
	}

	/**
	 * Gets the to employee no.
	 *
	 * @return the to employee no
	 */
	public String getToEmployeeNo() {
		return toEmployeeNo;
	}

	/**
	 * Sets the to employee no.
	 *
	 * @param toEmployeeNo the new to employee no
	 */
	public void setToEmployeeNo(String toEmployeeNo) {
		this.toEmployeeNo = toEmployeeNo;
	}

	/**
	 * Gets the to post name.
	 *
	 * @return the to post name
	 */
	public String getToPostName() {
		return toPostName;
	}

	/**
	 * Sets the to post name.
	 *
	 * @param toPostName the new to post name
	 */
	public void setToPostName(String toPostName) {
		this.toPostName = toPostName;
	}

	/**
	 * Gets the lying with.
	 *
	 * @return the lying with
	 */
	public String getLyingWith() {
		return lyingWith;
	}

	/**
	 * Sets the lying with.
	 *
	 * @param lyingWith the new lying with
	 */
	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
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
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Gets the upd date.
	 *
	 * @return the upd date
	 */
	public Date getUpdDate() {
		return updDate;
	}

	/**
	 * Sets the upd date.
	 *
	 * @param updDate the new upd date
	 */
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	/**
	 * Gets the from employee name.
	 *
	 * @return the from employee name
	 */
	public String getFromEmployeeName() {
		return fromEmployeeName;
	}

	/**
	 * Sets the from employee name.
	 *
	 * @param fromEmployeeName the new from employee name
	 */
	public void setFromEmployeeName(String fromEmployeeName) {
		this.fromEmployeeName = fromEmployeeName;
	}

	/**
	 * Gets the to employee name.
	 *
	 * @return the to employee name
	 */
	public String getToEmployeeName() {
		return toEmployeeName;
	}

	/**
	 * Sets the to employee name.
	 *
	 * @param toEmployeeName the new to employee name
	 */
	public void setToEmployeeName(String toEmployeeName) {
		this.toEmployeeName = toEmployeeName;
	}
	
}

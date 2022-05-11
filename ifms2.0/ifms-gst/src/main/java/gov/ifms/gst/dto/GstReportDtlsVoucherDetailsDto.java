/**
 * 
 */
package gov.ifms.gst.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * @author EULIndia
 *
 */
public class GstReportDtlsVoucherDetailsDto {

	@NativeQueryResultColumn(index = 0)
	private String voucherNo;
	@NativeQueryResultColumn(index = 1)
	private Date voucherDate;
	@NativeQueryResultColumn(index = 2)
	private Integer totalFile;
	@NativeQueryResultColumn(index = 3)
	private Integer totalChallans ;
	@NativeQueryResultColumn(index = 4)
	private Integer totalAmount;
	@NativeQueryResultColumn(index = 5)
	private String sadaName ;
	@NativeQueryResultColumn(index = 6)
	private String status;

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	public GstReportDtlsVoucherDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * @param voucherNo
	 * @param voucherDate
	 * @param totalFile
	 * @param totalChallans
	 * @param totalAmount
	 * @param sadaName
	 * @param status
	 */
	public GstReportDtlsVoucherDetailsDto(String voucherNo, Date voucherDate, Integer totalFile, Integer totalChallans,
			Integer totalAmount, String sadaName, String status) {
		super();
		this.voucherNo = voucherNo;
		this.voucherDate = voucherDate;
		this.totalFile = totalFile;
		this.totalChallans = totalChallans;
		this.totalAmount = totalAmount;
		this.sadaName = sadaName;
		this.status = status;
	}

	/**
	 * @return the voucherNo
	 */
	public String getVoucherNo() {
		return voucherNo;
	}

	/**
	 * @param voucherNo the voucherNo to set
	 */
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	/**
	 * @return the voucherDate
	 */
	public Date getVoucherDate() {
		return voucherDate;
	}

	/**
	 * @param voucherDate the voucherDate to set
	 */
	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}

	/**
	 * @return the totalFile
	 */
	public Integer getTotalFile() {
		return totalFile;
	}

	/**
	 * @param totalFile the totalFile to set
	 */
	public void setTotalFile(Integer totalFile) {
		this.totalFile = totalFile;
	}

	/**
	 * @return the totalChallans
	 */
	public Integer getTotalChallans() {
		return totalChallans;
	}

	/**
	 * @param totalChallans the totalChallans to set
	 */
	public void setTotalChallans(Integer totalChallans) {
		this.totalChallans = totalChallans;
	}

	/**
	 * @return the totalAmount
	 */
	public Integer getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the sadaName
	 */
	public String getSadaName() {
		return sadaName;
	}

	/**
	 * @param sadaName the sadaName to set
	 */
	public void setSadaName(String sadaName) {
		this.sadaName = sadaName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}	
}

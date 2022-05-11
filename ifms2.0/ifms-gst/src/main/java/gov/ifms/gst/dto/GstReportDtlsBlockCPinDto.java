package gov.ifms.gst.dto;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsBlockCPinDto {

	@NativeQueryResultColumn(index = 0)
	private BigInteger cpin;
	@NativeQueryResultColumn(index = 1)
	private Date cpinDate;
	@NativeQueryResultColumn(index = 2)
	private Double sgstTotal;
	@NativeQueryResultColumn(index = 3)
	private Timestamp blockCpinRequestDate;
	@NativeQueryResultColumn(index = 4)
	private Timestamp actualCPinRequestDate;
	@NativeQueryResultColumn(index = 5)
	private String sadaName;
	@NativeQueryResultColumn(index = 6)
	private String status;

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsBlockCPinDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cpin
	 * @param cpinDate
	 * @param sgstTotal
	 * @param blockCpinRequestDate
	 * @param actualCPinRequestDate
	 * @param sadaName
	 * @param status
	 */
	public GstReportDtlsBlockCPinDto(BigInteger cpin, Date cpinDate, Double sgstTotal, Timestamp blockCpinRequestDate,
			Timestamp actualCPinRequestDate, String sadaName, String status) {
		super();
		this.cpin = cpin;
		this.cpinDate = cpinDate;
		this.sgstTotal = sgstTotal;
		this.blockCpinRequestDate = blockCpinRequestDate;
		this.actualCPinRequestDate = actualCPinRequestDate;
		this.sadaName = sadaName;
		this.status = status;
	}

	/**
	 * @return the cpin
	 */
	public BigInteger getCpin() {
		return cpin;
	}

	/**
	 * @param cpin the cpin to set
	 */
	public void setCpin(BigInteger cpin) {
		this.cpin = cpin;
	}

	/**
	 * @return the cpinDate
	 */
	public Date getCpinDate() {
		return cpinDate;
	}

	/**
	 * @param cpinDate the cpinDate to set
	 */
	public void setCpinDate(Date cpinDate) {
		this.cpinDate = cpinDate;
	}

	/**
	 * @return the sgstTotal
	 */
	public Double getSgstTotal() {
		return sgstTotal;
	}

	/**
	 * @param sgstTotal the sgstTotal to set
	 */
	public void setSgstTotal(Double sgstTotal) {
		this.sgstTotal = sgstTotal;
	}

	/**
	 * @return the blockCpinRequestDate
	 */
	public Timestamp getBlockCpinRequestDate() {
		return blockCpinRequestDate;
	}

	/**
	 * @param blockCpinRequestDate the blockCpinRequestDate to set
	 */
	public void setBlockCpinRequestDate(Timestamp blockCpinRequestDate) {
		this.blockCpinRequestDate = blockCpinRequestDate;
	}

	/**
	 * @return the actualCPinRequestDate
	 */
	public Timestamp getActualCPinRequestDate() {
		return actualCPinRequestDate;
	}

	/**
	 * @param actualCPinRequestDate the actualCPinRequestDate to set
	 */
	public void setActualCPinRequestDate(Timestamp actualCPinRequestDate) {
		this.actualCPinRequestDate = actualCPinRequestDate;
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

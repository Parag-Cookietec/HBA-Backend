package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocChqToChqDto.
 */
public class LocChqToChqDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 0)
	private Long lcAdviceId;

	/** The cheque NO. */
	@NativeQueryResultColumn(index = 1)
	private String chequeNO;

	/** The div code. */
	@NativeQueryResultColumn(index = 2)
	private String divCode;

	/** The cheque amt. */
	@NativeQueryResultColumn(index = 3)
	private Double chequeAmt;

	/** The cheque date. */
	@NativeQueryResultColumn(index = 4)
	private Date chequeDate;

	/** The in favour. */
	@NativeQueryResultColumn(index = 5)
	private String partyName;

	/** The advice no. */
	@NativeQueryResultColumn(index = 6)
	private String adviceNo;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 7)
	private Long cardexNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 8)
	private String ddoNo;

	/** The district id. */
	@NativeQueryResultColumn(index = 9)
	private Long districtId;

	/** The dept id. */
	@NativeQueryResultColumn(index = 10)
	private Long deptId;

	/** The office id. */
	@NativeQueryResultColumn(index = 11)
	private Long officeId;

	/** The div id. */
	@NativeQueryResultColumn(index = 12)
	private Long divId;

	/** The remarks. */
	@NativeQueryResultColumn(index = 13)
	private String remarks;

	/** The ref no. */
	@NativeQueryResultColumn(index = 14)
	private String refNo;

	/** The ref date. */
	@NativeQueryResultColumn(index = 15)
	private Date refDate;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 16)
	private Long hdrId;

	/** The cheque srch data. */
	private LocChequeToChequeSrchData chequeSrchData;

	/** The chq list. */
	private List<LocChqToChqEditViewDto> chqList;

	/**
	 * Gets the lc advice id.
	 *
	 * @return the lc advice id
	 */
	public Long getLcAdviceId() {
		return lcAdviceId;
	}

	/**
	 * Sets the lc advice id.
	 *
	 * @param lcAdviceId the new lc advice id
	 */
	public void setLcAdviceId(Long lcAdviceId) {
		this.lcAdviceId = lcAdviceId;
	}

	/**
	 * Gets the cheque NO.
	 *
	 * @return the cheque NO
	 */
	public String getChequeNO() {
		return chequeNO;
	}

	/**
	 * Sets the cheque NO.
	 *
	 * @param chequeNO the new cheque NO
	 */
	public void setChequeNO(String chequeNO) {
		this.chequeNO = chequeNO;
	}

	/**
	 * Gets the div code.
	 *
	 * @return the div code
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the new div code
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the cheque amt.
	 *
	 * @return the cheque amt
	 */
	public Double getChequeAmt() {
		return chequeAmt;
	}

	/**
	 * Sets the cheque amt.
	 *
	 * @param chequeAmt the new cheque amt
	 */
	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

	/**
	 * Gets the cheque date.
	 *
	 * @return the cheque date
	 */
	public Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Sets the cheque date.
	 *
	 * @param chequeDate the new cheque date
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Gets the party name.
	 *
	 * @return the party name
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * Sets the party name.
	 *
	 * @param partyName the new party name
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * Gets the advice no.
	 *
	 * @return the advice no
	 */
	public String getAdviceNo() {
		return adviceNo;
	}

	/**
	 * Sets the advice no.
	 *
	 * @param adviceNo the new advice no
	 */
	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
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
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the dept id.
	 *
	 * @return the dept id
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * Sets the dept id.
	 *
	 * @param deptId the new dept id
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the div id.
	 *
	 * @return the div id
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the cheque srch data.
	 *
	 * @return the cheque srch data
	 */
	public LocChequeToChequeSrchData getChequeSrchData() {
		return chequeSrchData;
	}

	/**
	 * Sets the cheque srch data.
	 *
	 * @param chequeSrchData the new cheque srch data
	 */
	public void setChequeSrchData(LocChequeToChequeSrchData chequeSrchData) {
		this.chequeSrchData = chequeSrchData;
	}

	/**
	 * Gets the chq list.
	 *
	 * @return the chq list
	 */
	public List<LocChqToChqEditViewDto> getChqList() {
		return chqList;
	}

	/**
	 * Sets the chq list.
	 *
	 * @param chqList the new chq list
	 */
	public void setChqList(List<LocChqToChqEditViewDto> chqList) {
		this.chqList = chqList;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the new remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}
}

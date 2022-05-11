package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAccCloseReqHdrDto.
 */
@NativeQueryResultEntity
public class LocAccCloseReqHdrDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The hdr id.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;

	/** The to off name. */
	@NativeQueryResultColumn(index = 1)
	private String toOffName;

	/** The div off add. */
	@NativeQueryResultColumn(index = 2)
	private String divOffAdd;

	/** The dpt name. */
	@NativeQueryResultColumn(index = 3)
	private String dptName;

	/** The hod name. */
	@NativeQueryResultColumn(index = 4)
	private String hodName;

	/** The off name. */
	@NativeQueryResultColumn(index = 5)
	private String offName;

	/** The dis name. */
	@NativeQueryResultColumn(index = 6)
	private String disName;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 7)
	private Long cardexNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 8)
	private Long ddoNo;

	/** The div code. */
	@NativeQueryResultColumn(index = 9)
	private String divCode;

	/** The divison name. */
	@NativeQueryResultColumn(index = 10)
	private String divisionName;

	/** The circle code. */
	@NativeQueryResultColumn(index = 11)
	private String circleCode;

	/** The Circle name. */
	@NativeQueryResultColumn(index = 12)
	private String circleName;

	/** The auth no. */
	@NativeQueryResultColumn(index = 13)
	private String authNo;

	/** The auth dt. */
	@NativeQueryResultColumn(index = 14)
	private Date authDt;

	/** The major head. */
	@NativeQueryResultColumn(index = 15)
	private String majorHead;

	/** The major head. */
	@NativeQueryResultColumn(index = 16)
	private String majorHeadName;

	/** The sub major. */
	@NativeQueryResultColumn(index = 17)
	private String subMajor;

	/** The sub major name. */
	@NativeQueryResultColumn(index = 18)
	private String subMajorName;

	/** The minor head. */
	@NativeQueryResultColumn(index = 19)
	private String minorHead;

	/** The minor head name. */
	@NativeQueryResultColumn(index = 20)
	private String minorHeadName;

	/** The sub head. */
	@NativeQueryResultColumn(index = 21)
	private String subHead;

	/** The sub head name. */
	@NativeQueryResultColumn(index = 22)
	private String subHeadName;

	/** The detail head. */
	@NativeQueryResultColumn(index = 23)
	private String detailHead;

	/** The detail head name. */
	@NativeQueryResultColumn(index = 24)
	private String detailHeadName;

	/** The bank name. */
	@NativeQueryResultColumn(index = 25)
	private String bankName;

	/** The branch name. */
	@NativeQueryResultColumn(index = 26)
	private String branchName;

	/** The branch code. */
	@NativeQueryResultColumn(index = 27)
	private String branchCode;

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

	/**
	 * Gets the to off name.
	 *
	 * @return the to off name
	 */
	public String getToOffName() {
		return toOffName;
	}

	/**
	 * Sets the to off name.
	 *
	 * @param toOffName the new to off name
	 */
	public void setToOffName(String toOffName) {
		this.toOffName = toOffName;
	}

	/**
	 * Gets the div off add.
	 *
	 * @return the div off add
	 */
	public String getDivOffAdd() {
		return divOffAdd;
	}

	/**
	 * Sets the div off add.
	 *
	 * @param divOffAdd the new div off add
	 */
	public void setDivOffAdd(String divOffAdd) {
		this.divOffAdd = divOffAdd;
	}

	/**
	 * Gets the dpt name.
	 *
	 * @return the dpt name
	 */
	public String getDptName() {
		return dptName;
	}

	/**
	 * Sets the dpt name.
	 *
	 * @param dptName the new dpt name
	 */
	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	/**
	 * Gets the hod name.
	 *
	 * @return the hod name
	 */
	public String getHodName() {
		return hodName;
	}

	/**
	 * Sets the hod name.
	 *
	 * @param hodName the new hod name
	 */
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	/**
	 * Gets the off name.
	 *
	 * @return the off name
	 */
	public String getOffName() {
		return offName;
	}

	/**
	 * Sets the off name.
	 *
	 * @param offName the new off name
	 */
	public void setOffName(String offName) {
		this.offName = offName;
	}

	/**
	 * Gets the dis name.
	 *
	 * @return the dis name
	 */
	public String getDisName() {
		return disName;
	}

	/**
	 * Sets the dis name.
	 *
	 * @param disName the new dis name
	 */
	public void setDisName(String disName) {
		this.disName = disName;
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
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
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
	 * Gets the circle code.
	 *
	 * @return the circle code
	 */
	public String getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the new circle code
	 */
	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * Gets the auth no.
	 *
	 * @return the auth no
	 */
	public String getAuthNo() {
		return authNo;
	}

	/**
	 * Sets the auth no.
	 *
	 * @param authNo the new auth no
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}

	/**
	 * Gets the auth dt.
	 *
	 * @return the auth dt
	 */
	public Date getAuthDt() {
		return authDt;
	}

	/**
	 * Sets the auth dt.
	 *
	 * @param authDt the new auth dt
	 */
	public void setAuthDt(Date authDt) {
		this.authDt = authDt;
	}

	/**
	 * Gets the major head.
	 *
	 * @return the major head
	 */
	public String getMajorHead() {
		return majorHead;
	}

	/**
	 * Sets the major head.
	 *
	 * @param majorHead the new major head
	 */
	public void setMajorHead(String majorHead) {
		this.majorHead = majorHead;
	}

	/**
	 * Gets the sub major.
	 *
	 * @return the sub major
	 */
	public String getSubMajor() {
		return subMajor;
	}

	/**
	 * Sets the sub major.
	 *
	 * @param subMajor the new sub major
	 */
	public void setSubMajor(String subMajor) {
		this.subMajor = subMajor;
	}

	/**
	 * Gets the minor head.
	 *
	 * @return the minor head
	 */
	public String getMinorHead() {
		return minorHead;
	}

	/**
	 * Sets the minor head.
	 *
	 * @param minorHead the new minor head
	 */
	public void setMinorHead(String minorHead) {
		this.minorHead = minorHead;
	}

	/**
	 * Gets the sub head.
	 *
	 * @return the sub head
	 */
	public String getSubHead() {
		return subHead;
	}

	/**
	 * Sets the sub head.
	 *
	 * @param subHead the new sub head
	 */
	public void setSubHead(String subHead) {
		this.subHead = subHead;
	}

	/**
	 * Gets the detail head.
	 *
	 * @return the detail head
	 */
	public String getDetailHead() {
		return detailHead;
	}

	/**
	 * Sets the detail head.
	 *
	 * @param detailHead the new detail head
	 */
	public void setDetailHead(String detailHead) {
		this.detailHead = detailHead;
	}

	/**
	 * Gets the bank name.
	 *
	 * @return the bank name
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Sets the bank name.
	 *
	 * @param bankName the new bank name
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Gets the branch name.
	 *
	 * @return the branch name
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the new branch name
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the branch code.
	 *
	 * @return the branch code
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * Sets the branch code.
	 *
	 * @param branchCode the new branch code
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * Gets the division name.
	 *
	 * @return the division name
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * Sets the division name.
	 *
	 * @param divisionName the new division name
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * Gets the circle name.
	 *
	 * @return the circle name
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * Sets the circle name.
	 *
	 * @param circleName the new circle name
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	/**
	 * Gets the major head name.
	 *
	 * @return the major head name
	 */
	public String getMajorHeadName() {
		return majorHeadName;
	}

	/**
	 * Sets the major head name.
	 *
	 * @param majorHeadName the new major head name
	 */
	public void setMajorHeadName(String majorHeadName) {
		this.majorHeadName = majorHeadName;
	}

	/**
	 * Gets the sub major name.
	 *
	 * @return the sub major name
	 */
	public String getSubMajorName() {
		return subMajorName;
	}

	/**
	 * Sets the sub major name.
	 *
	 * @param subMajorName the new sub major name
	 */
	public void setSubMajorName(String subMajorName) {
		this.subMajorName = subMajorName;
	}

	/**
	 * Gets the minor head name.
	 *
	 * @return the minor head name
	 */
	public String getMinorHeadName() {
		return minorHeadName;
	}

	/**
	 * Sets the minor head name.
	 *
	 * @param minorHeadName the new minor head name
	 */
	public void setMinorHeadName(String minorHeadName) {
		this.minorHeadName = minorHeadName;
	}

	/**
	 * Gets the sub head name.
	 *
	 * @return the sub head name
	 */
	public String getSubHeadName() {
		return subHeadName;
	}

	/**
	 * Sets the sub head name.
	 *
	 * @param subHeadName the new sub head name
	 */
	public void setSubHeadName(String subHeadName) {
		this.subHeadName = subHeadName;
	}

	/**
	 * Gets the detail head name.
	 *
	 * @return the detail head name
	 */
	public String getDetailHeadName() {
		return detailHeadName;
	}

	/**
	 * Sets the detail head name.
	 *
	 * @param detailHeadName the new detail head name
	 */
	public void setDetailHeadName(String detailHeadName) {
		this.detailHeadName = detailHeadName;
	}

}

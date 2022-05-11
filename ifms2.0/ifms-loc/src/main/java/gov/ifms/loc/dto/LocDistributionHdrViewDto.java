package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The Class LocDistributionHdrViewDto.
 */
@NativeQueryResultEntity
public class LocDistributionHdrViewDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The hdr id.
     */
    @NativeQueryResultColumn(index = 0)
    private Long hdrId;

    /**
     * The lc no.
     */
    @NativeQueryResultColumn(index = 1)
    private String lcNo;

    /**
     * The div code.
     */
    @NativeQueryResultColumn(index = 2)
    private String divCode;

    /**
     * The div name.
     */
    @NativeQueryResultColumn(index = 3)
    private String divName;

    /**
     * The lc issue date.
     */
    @NativeQueryResultColumn(index = 4)
    private Date lcIssueDate;

    /**
     * The entry type.
     */
    @NativeQueryResultColumn(index = 5)
    private String entryType;

    /**
     * The lc valid from.
     */
    @NativeQueryResultColumn(index = 6)
    private Date lcValidFrom;

    /**
     * The lc valid to.
     */
    @NativeQueryResultColumn(index = 7)
    private Date lcValidTo;

    /**
     * The inward no.
     */
    @NativeQueryResultColumn(index = 8)
    private String inwardNo;

    /**
     * The inward date.
     */
    @NativeQueryResultColumn(index = 9)
    private Date inwardDate;

    /**
     * The circle code.
     */
    @NativeQueryResultColumn(index = 10)
    private String circleCode;

    /**
     * The circle name.
     */
    @NativeQueryResultColumn(index = 11)
    private String circleName;

    /**
     * The party ref no.
     */
    @NativeQueryResultColumn(index = 12)
    private String partyRefNo;

    /**
     * The party ref date.
     */
    @NativeQueryResultColumn(index = 13)
    private Date partyRefDate;

    /**
     * The grant order no.
     */
    @NativeQueryResultColumn(index = 14)
    private String grantOrderNo;

    /**
     * The grant order date.
     */
    @NativeQueryResultColumn(index = 15)
    private Date grantOrderDate;

    /**
     * The new balance lc amt.
     */
    @NativeQueryResultColumn(index = 16)
    private Double newBalanceLcAmt;

    /**
     * The balance lc amt.
     */
    @NativeQueryResultColumn(index = 17)
    private Double balanceLcAmt;

    /**
     * The raise obj flag.
     */
    @NativeQueryResultColumn(index = 18)
    private String raiseObjFlag;

    /**
     * The obj remarks.
     */
    @NativeQueryResultColumn(index = 19)
    private String objRemarks;

    /**
     * The office id.
     */
    @NativeQueryResultColumn(index = 20)
    private Long officeId;

    /**
     * The cardex no.
     */
    @NativeQueryResultColumn(index = 21)
    private String cardexNo;

    /**
     * The ddo no.
     */
    @NativeQueryResultColumn(index = 22)
    private String ddoNo;

    /**
     * The fin year.
     */
    @NativeQueryResultColumn(index = 23)
    private String finYear;

    /** The dist code. */
    @NativeQueryResultColumn(index = 24)
    private String distCode;

    
    /** The dist code name. */
    @NativeQueryResultColumn(index = 25)
    private String distCodeName;

    /** The to office name. */
    @NativeQueryResultColumn(index = 26)
    private String toOfficeName;

    /**
     * The distribution dtl dto.
     */
    private List<LocDistributionDtlViewDto> distributionDtlDto;

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
     * Gets the lc no.
     *
     * @return the lc no
     */
    public String getLcNo() {
        return lcNo;
    }

    /**
     * Sets the lc no.
     *
     * @param lcNo the new lc no
     */
    public void setLcNo(String lcNo) {
        this.lcNo = lcNo;
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
     * Gets the div name.
     *
     * @return the div name
     */
    public String getDivName() {
        return divName;
    }

    /**
     * Sets the div name.
     *
     * @param divName the new div name
     */
    public void setDivName(String divName) {
        this.divName = divName;
    }

    /**
     * Gets the lc issue date.
     *
     * @return the lc issue date
     */
    public Date getLcIssueDate() {
        return lcIssueDate;
    }

    /**
     * Sets the lc issue date.
     *
     * @param lcIssueDate the new lc issue date
     */
    public void setLcIssueDate(Date lcIssueDate) {
        this.lcIssueDate = lcIssueDate;
    }

    /**
     * Gets the entry type.
     *
     * @return the entry type
     */
    public String getEntryType() {
        return entryType;
    }

    /**
     * Sets the entry type.
     *
     * @param entryType the new entry type
     */
    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    /**
     * Gets the lc valid from.
     *
     * @return the lc valid from
     */
    public Date getLcValidFrom() {
        return lcValidFrom;
    }

    /**
     * Sets the lc valid from.
     *
     * @param lcValidFrom the new lc valid from
     */
    public void setLcValidFrom(Date lcValidFrom) {
        this.lcValidFrom = lcValidFrom;
    }

    /**
     * Gets the lc valid to.
     *
     * @return the lc valid to
     */
    public Date getLcValidTo() {
        return lcValidTo;
    }

    /**
     * Sets the lc valid to.
     *
     * @param lcValidTo the new lc valid to
     */
    public void setLcValidTo(Date lcValidTo) {
        this.lcValidTo = lcValidTo;
    }

    /**
     * Gets the inward no.
     *
     * @return the inward no
     */
    public String getInwardNo() {
        return inwardNo;
    }

    /**
     * Sets the inward no.
     *
     * @param inwardNo the new inward no
     */
    public void setInwardNo(String inwardNo) {
        this.inwardNo = inwardNo;
    }

    /**
     * Gets the inward date.
     *
     * @return the inward date
     */
    public Date getInwardDate() {
        return inwardDate;
    }

    /**
     * Sets the inward date.
     *
     * @param inwardDate the new inward date
     */
    public void setInwardDate(Date inwardDate) {
        this.inwardDate = inwardDate;
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
     * Gets the party ref no.
     *
     * @return the party ref no
     */
    public String getPartyRefNo() {
        return partyRefNo;
    }

    /**
     * Sets the party ref no.
     *
     * @param partyRefNo the new party ref no
     */
    public void setPartyRefNo(String partyRefNo) {
        this.partyRefNo = partyRefNo;
    }

    /**
     * Gets the party ref date.
     *
     * @return the party ref date
     */
    public Date getPartyRefDate() {
        return partyRefDate;
    }

    /**
     * Sets the party ref date.
     *
     * @param partyRefDate the new party ref date
     */
    public void setPartyRefDate(Date partyRefDate) {
        this.partyRefDate = partyRefDate;
    }

    /**
     * Gets the grant order no.
     *
     * @return the grant order no
     */
    public String getGrantOrderNo() {
        return grantOrderNo;
    }

    /**
     * Sets the grant order no.
     *
     * @param grantOrderNo the new grant order no
     */
    public void setGrantOrderNo(String grantOrderNo) {
        this.grantOrderNo = grantOrderNo;
    }

    /**
     * Gets the grant order date.
     *
     * @return the grant order date
     */
    public Date getGrantOrderDate() {
        return grantOrderDate;
    }

    /**
     * Sets the grant order date.
     *
     * @param grantOrderDate the new grant order date
     */
    public void setGrantOrderDate(Date grantOrderDate) {
        this.grantOrderDate = grantOrderDate;
    }

    /**
     * Gets the new balance lc amt.
     *
     * @return the new balance lc amt
     */
    public Double getNewBalanceLcAmt() {
        return newBalanceLcAmt;
    }

    /**
     * Sets the new balance lc amt.
     *
     * @param newBalanceLcAmt the new new balance lc amt
     */
    public void setNewBalanceLcAmt(Double newBalanceLcAmt) {
        this.newBalanceLcAmt = newBalanceLcAmt;
    }

    /**
     * Gets the balance lc amt.
     *
     * @return the balance lc amt
     */
    public Double getBalanceLcAmt() {
        return balanceLcAmt;
    }

    /**
     * Sets the balance lc amt.
     *
     * @param balanceLcAmt the new balance lc amt
     */
    public void setBalanceLcAmt(Double balanceLcAmt) {
        this.balanceLcAmt = balanceLcAmt;
    }

    /**
     * Gets the raise obj flag.
     *
     * @return the raise obj flag
     */
    public String getRaiseObjFlag() {
        return raiseObjFlag;
    }

    /**
     * Sets the raise obj flag.
     *
     * @param raiseObjFlag the new raise obj flag
     */
    public void setRaiseObjFlag(String raiseObjFlag) {
        this.raiseObjFlag = raiseObjFlag;
    }

    /**
     * Gets the obj remarks.
     *
     * @return the obj remarks
     */
    public String getObjRemarks() {
        return objRemarks;
    }

    /**
     * Sets the obj remarks.
     *
     * @param objRemarks the new obj remarks
     */
    public void setObjRemarks(String objRemarks) {
        this.objRemarks = objRemarks;
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
     * Gets the fin year.
     *
     * @return the fin year
     */
    public String getFinYear() {
        return finYear;
    }

    /**
     * Sets the fin year.
     *
     * @param finYear the new fin year
     */
    public void setFinYear(String finYear) {
        this.finYear = finYear;
    }

    /**
     * Gets the distribution dtl dto.
     *
     * @return the distribution dtl dto
     */
    public List<LocDistributionDtlViewDto> getDistributionDtlDto() {
        return distributionDtlDto;
    }

    /**
     * Sets the distribution dtl dto.
     *
     * @param distributionDtlDto the new distribution dtl dto
     */
    public void setDistributionDtlDto(List<LocDistributionDtlViewDto> distributionDtlDto) {
        this.distributionDtlDto = distributionDtlDto;
    }

	/**
	 * Gets the dist code.
	 *
	 * @return the dist code
	 */
	public String getDistCode() {
		return distCode;
	}

	/**
	 * Sets the dist code.
	 *
	 * @param distCode the new dist code
	 */
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	/**
	 * Gets the dist code name.
	 *
	 * @return the dist code name
	 */
	public String getDistCodeName() {
		return distCodeName;
	}

	/**
	 * Gets the to office name.
	 *
	 * @return the to office name
	 */
	public String getToOfficeName() {
		return toOfficeName;
	}

	/**
	 * Sets the to office name.
	 *
	 * @param toOfficeName the new to office name
	 */
	public void setToOfficeName(String toOfficeName) {
		this.toOfficeName = toOfficeName;
	}

	/**
	 * Sets the dist code name.
	 *
	 * @param distCodeName the new dist code name
	 */
	public void setDistCodeName(String distCodeName) {
		this.distCodeName = distCodeName;
	}
}

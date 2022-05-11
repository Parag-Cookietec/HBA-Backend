package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPOfficeCreationSummaryReportDto.
 */
@NativeQueryResultEntity
public class EDPOfficeCreationSummaryReportDto implements Serializable {

	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The designation id. */
    @NativeQueryResultColumn(index = 0)
    private String trnNo;
    
    @NativeQueryResultColumn(index = 1)
    private String trnDate;
    
    @NativeQueryResultColumn(index = 2)
    private String uniqueId;
    
    @NativeQueryResultColumn(index = 3)
    private String district;
    
    @NativeQueryResultColumn(index = 4)
    private String ddoNo;
    
    @NativeQueryResultColumn(index = 5)
    private String cardexNo;
    
    @NativeQueryResultColumn(index = 6)
    private String officeName;
    
    @NativeQueryResultColumn(index = 7)
    private String designationOfDdo;
    
    @NativeQueryResultColumn(index = 8)
    private String department;
    
    @NativeQueryResultColumn(index = 9)
    private String hod;
    
    @NativeQueryResultColumn(index = 10)
    private String officeType;
    
    @NativeQueryResultColumn(index = 11)
    private String ddoType;
    
    @NativeQueryResultColumn(index = 12)
    private String pvu;
    
    @NativeQueryResultColumn(index = 13)
    private String isCo;
    
    @NativeQueryResultColumn(index = 14)
    private String coOfficeName;
    
    @NativeQueryResultColumn(index = 15)
    private String mappedTo;
    
    @NativeQueryResultColumn(index = 16)
    private String startDate;
    
    @NativeQueryResultColumn(index = 17)
    private String endDate;
    
    @NativeQueryResultColumn(index = 18)
    private String officeStatus;
    
    @NativeQueryResultColumn(index = 19)
    private String billType;
    
    @NativeQueryResultColumn(index = 20)
    private String lyingWith;
    
    @NativeQueryResultColumn(index = 21)
    private String trnStatus;
    
    @NativeQueryResultColumn(index = 22)
    private String workFlowStatus;
    
    @NativeQueryResultColumn(index = 23)
    private int count;
    
    @NativeQueryResultColumn(index = 24)
    private Long officeId;

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the trnDate
	 */
	public String getTrnDate() {
		return trnDate;
	}

	/**
	 * @param trnDate the trnDate to set
	 */
	public void setTrnDate(String trnDate) {
		this.trnDate = trnDate;
	}

	/**
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the cardexNo
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the designationOfDdo
	 */
	public String getDesignationOfDdo() {
		return designationOfDdo;
	}

	/**
	 * @param designationOfDdo the designationOfDdo to set
	 */
	public void setDesignationOfDdo(String designationOfDdo) {
		this.designationOfDdo = designationOfDdo;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the hod
	 */
	public String getHod() {
		return hod;
	}

	/**
	 * @param hod the hod to set
	 */
	public void setHod(String hod) {
		this.hod = hod;
	}

	/**
	 * @return the officeType
	 */
	public String getOfficeType() {
		return officeType;
	}

	/**
	 * @param officeType the officeType to set
	 */
	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	/**
	 * @return the ddoType
	 */
	public String getDdoType() {
		return ddoType;
	}

	/**
	 * @param ddoType the ddoType to set
	 */
	public void setDdoType(String ddoType) {
		this.ddoType = ddoType;
	}

	/**
	 * @return the pvu
	 */
	public String getPvu() {
		return pvu;
	}

	/**
	 * @param pvu the pvu to set
	 */
	public void setPvu(String pvu) {
		this.pvu = pvu;
	}

	/**
	 * @return the isCo
	 */
	public String getIsCo() {
		return isCo;
	}

	/**
	 * @param isCo the isCo to set
	 */
	public void setIsCo(String isCo) {
		this.isCo = isCo;
	}

	/**
	 * @return the coOfficeName
	 */
	public String getCoOfficeName() {
		return coOfficeName;
	}

	/**
	 * @param coOfficeName the coOfficeName to set
	 */
	public void setCoOfficeName(String coOfficeName) {
		this.coOfficeName = coOfficeName;
	}

	/**
	 * @return the mappedTo
	 */
	public String getMappedTo() {
		return mappedTo;
	}

	/**
	 * @param mappedTo the mappedTo to set
	 */
	public void setMappedTo(String mappedTo) {
		this.mappedTo = mappedTo;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the officeStatus
	 */
	public String getOfficeStatus() {
		return officeStatus;
	}

	/**
	 * @param officeStatus the officeStatus to set
	 */
	public void setOfficeStatus(String officeStatus) {
		this.officeStatus = officeStatus;
	}

	/**
	 * @return the billType
	 */
	public String getBillType() {
		return billType;
	}

	/**
	 * @param billType the billType to set
	 */
	public void setBillType(String billType) {
		this.billType = billType;
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
	 * @return the workFlowStatus
	 */
	public String getWorkFlowStatus() {
		return workFlowStatus;
	}

	/**
	 * @param workFlowStatus the workFlowStatus to set
	 */
	public void setWorkFlowStatus(String workFlowStatus) {
		this.workFlowStatus = workFlowStatus;
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
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
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
		return Objects.hash(billType, cardexNo, coOfficeName, count, ddoNo, ddoType, department, designationOfDdo,
				district, endDate, hod, isCo, lyingWith, mappedTo, officeId, officeName, officeStatus, officeType, pvu,
				startDate, trnDate, trnNo, trnStatus, uniqueId, workFlowStatus);
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
		if (!(obj instanceof EDPOfficeCreationSummaryReportDto)) {
			return false;
		}
		EDPOfficeCreationSummaryReportDto other = (EDPOfficeCreationSummaryReportDto) obj;
		return Objects.equals(billType, other.billType) && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(coOfficeName, other.coOfficeName) && count == other.count
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(ddoType, other.ddoType)
				&& Objects.equals(department, other.department)
				&& Objects.equals(designationOfDdo, other.designationOfDdo) && Objects.equals(district, other.district)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(hod, other.hod)
				&& Objects.equals(isCo, other.isCo) && Objects.equals(lyingWith, other.lyingWith)
				&& Objects.equals(mappedTo, other.mappedTo) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(officeStatus, other.officeStatus)
				&& Objects.equals(officeType, other.officeType) && Objects.equals(pvu, other.pvu)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(trnDate, other.trnDate)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(trnStatus, other.trnStatus)
				&& Objects.equals(uniqueId, other.uniqueId) && Objects.equals(workFlowStatus, other.workFlowStatus);
	}
    
}

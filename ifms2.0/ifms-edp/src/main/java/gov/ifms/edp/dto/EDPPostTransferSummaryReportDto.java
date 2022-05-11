package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPPostTransferSummaryReportDto.
 */
@NativeQueryResultEntity
public class EDPPostTransferSummaryReportDto implements Serializable {

		/** The Constant serialVersionUID. */
	    private static final long serialVersionUID = 1L;

	    /** The designation id. */
	    @NativeQueryResultColumn(index = 0)
	    private String trnNo;
	    
	    /** The trn date. */
    	@NativeQueryResultColumn(index = 1)
	    private String trnDate;
	    
	    /** The district name. */
    	@NativeQueryResultColumn(index = 2)
	    private String districtName;
	    
	    /** The ddo no. */
    	@NativeQueryResultColumn(index = 3)
	    private String ddoNo;
	    
	    /** The cardex no. */
    	@NativeQueryResultColumn(index = 4)
	    private String cardexNo;
	    
	    /** The office name. */
    	@NativeQueryResultColumn(index = 5)
	    private String officeName;
	    
	    /** The post name. */
    	@NativeQueryResultColumn(index = 6)
	    private String postName;
	    
	    /** The employee name. */
    	@NativeQueryResultColumn(index = 7)
	    private String transferFrom;
	    
	    /** The transfer from. */
    	@NativeQueryResultColumn(index = 8)
	    private String transferTo;
	    
	    /** The transfer to. */
    	@NativeQueryResultColumn(index = 9)
	    private String lyingWith;
	    
	    /** The lying with. */
    	@NativeQueryResultColumn(index = 10)
	    private String trnStatus;

	    /** The workflow name. */
    	@NativeQueryResultColumn(index = 11)
	    private String workflowStatus;
	    
	    /** The trn status. */
    	@NativeQueryResultColumn(index = 12)
	    private int count;
	    
		/**
		 * Gets the trn no.
		 *
		 * @return the trnNo
		 */
		public String getTrnNo() {
			return trnNo;
		}

		/**
		 * Sets the trn no.
		 *
		 * @param trnNo the trnNo to set
		 */
		public void setTrnNo(String trnNo) {
			this.trnNo = trnNo;
		}

		/**
		 * Gets the trn date.
		 *
		 * @return the trnDate
		 */
		public String getTrnDate() {
			return trnDate;
		}

		/**
		 * Sets the trn date.
		 *
		 * @param trnDate the trnDate to set
		 */
		public void setTrnDate(String trnDate) {
			this.trnDate = trnDate;
		}

		/**
		 * Gets the district name.
		 *
		 * @return the districtName
		 */
		public String getDistrictName() {
			return districtName;
		}

		/**
		 * Sets the district name.
		 *
		 * @param districtName the districtName to set
		 */
		public void setDistrictName(String districtName) {
			this.districtName = districtName;
		}

		/**
		 * Gets the ddo no.
		 *
		 * @return the ddoNo
		 */
		public String getDdoNo() {
			return ddoNo;
		}

		/**
		 * Sets the ddo no.
		 *
		 * @param ddoNo the ddoNo to set
		 */
		public void setDdoNo(String ddoNo) {
			this.ddoNo = ddoNo;
		}

		/**
		 * Gets the cardex no.
		 *
		 * @return the cardexNo
		 */
		public String getCardexNo() {
			return cardexNo;
		}

		/**
		 * Sets the cardex no.
		 *
		 * @param cardexNo the cardexNo to set
		 */
		public void setCardexNo(String cardexNo) {
			this.cardexNo = cardexNo;
		}

		/**
		 * Gets the office name.
		 *
		 * @return the officeName
		 */
		public String getOfficeName() {
			return officeName;
		}

		/**
		 * Sets the office name.
		 *
		 * @param officeName the officeName to set
		 */
		public void setOfficeName(String officeName) {
			this.officeName = officeName;
		}

		/**
		 * Gets the post name.
		 *
		 * @return the postName
		 */
		public String getPostName() {
			return postName;
		}

		/**
		 * Sets the post name.
		 *
		 * @param postName the postName to set
		 */
		public void setPostName(String postName) {
			this.postName = postName;
		}

		/**
		 * Gets the transfer from.
		 *
		 * @return the transferFrom
		 */
		public String getTransferFrom() {
			return transferFrom;
		}

		/**
		 * Sets the transfer from.
		 *
		 * @param transferFrom the transferFrom to set
		 */
		public void setTransferFrom(String transferFrom) {
			this.transferFrom = transferFrom;
		}

		/**
		 * Gets the transfer to.
		 *
		 * @return the transferTo
		 */
		public String getTransferTo() {
			return transferTo;
		}

		/**
		 * Sets the transfer to.
		 *
		 * @param transferTo the transferTo to set
		 */
		public void setTransferTo(String transferTo) {
			this.transferTo = transferTo;
		}

		/**
		 * Gets the lying with.
		 *
		 * @return the lyingWith
		 */
		public String getLyingWith() {
			return lyingWith;
		}

		/**
		 * Sets the lying with.
		 *
		 * @param lyingWith the lyingWith to set
		 */
		public void setLyingWith(String lyingWith) {
			this.lyingWith = lyingWith;
		}


		/**
		 * Gets the trn status.
		 *
		 * @return the trnStatus
		 */
		public String getTrnStatus() {
			return trnStatus;
		}

		/**
		 * Sets the trn status.
		 *
		 * @param trnStatus the trnStatus to set
		 */
		public void setTrnStatus(String trnStatus) {
			this.trnStatus = trnStatus;
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
		 * @param count the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}

		/**
		 * Gets the serialversionuid.
		 *
		 * @return the serialversionuid
		 */
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		/**
		 * @return the workflowStatus
		 */
		public String getWorkflowStatus() {
			return workflowStatus;
		}

		/**
		 * @param workflowStatus the workflowStatus to set
		 */
		public void setWorkflowStatus(String workflowStatus) {
			this.workflowStatus = workflowStatus;
		}

		/**
		 * Hash code.
		 *
		 * @return the int
		 */
		@Override
		public int hashCode() {
			return Objects.hash(cardexNo, count, ddoNo, districtName, lyingWith, officeName, postName, transferFrom,
					transferTo, trnDate, trnNo, trnStatus, workflowStatus);
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
			if (!(obj instanceof EDPPostTransferSummaryReportDto)) {
				return false;
			}
			EDPPostTransferSummaryReportDto other = (EDPPostTransferSummaryReportDto) obj;
			return Objects.equals(cardexNo, other.cardexNo) && count == other.count
					&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(districtName, other.districtName)
					&& Objects.equals(lyingWith, other.lyingWith) && Objects.equals(officeName, other.officeName)
					&& Objects.equals(postName, other.postName) && Objects.equals(transferFrom, other.transferFrom)
					&& Objects.equals(transferTo, other.transferTo) && Objects.equals(trnDate, other.trnDate)
					&& Objects.equals(trnNo, other.trnNo) && Objects.equals(trnStatus, other.trnStatus)
					&& Objects.equals(workflowStatus, other.workflowStatus);
		}

}

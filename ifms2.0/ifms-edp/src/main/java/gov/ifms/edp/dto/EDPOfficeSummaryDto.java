package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPOfficeSummaryDto.
 */
@NativeQueryResultEntity
public class EDPOfficeSummaryDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The count. */
	//@NativeQueryResultColumn(index = 0)
	private int count;

	/** The district name. */
	@NativeQueryResultColumn(index = 1)
	private String districtName;

	/** The ddotype. */
	//@NativeQueryResultColumn(index = 2)
	private int ddotype;

	/** The district code. */
	@NativeQueryResultColumn(index = 5)
	private String districtCode;

	/** The district id. */
	@NativeQueryResultColumn(index = 0)
	private String districtId;

	/** The ddo count. */
	@NativeQueryResultColumn(index = 2)
	private int ddoCount;

	/** The non DDO count. */
	@NativeQueryResultColumn(index = 3)
	private int nonDDOCount;

	/** The panchayat count. */
	@NativeQueryResultColumn(index = 4)
	private int panchayatCount;

	/** The ddo id. */
	private int ddoId = 68;
	
	/** The non DDO id. */
	private int nonDDOId = 69;
	
	/** The panchayat id. */
	private int panchayatId = 70;
	
	/** Total count */
	@NativeQueryResultColumn(index = 6)
	private int total;

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(count, ddoCount, ddoId, ddotype, districtCode, districtId, districtName, nonDDOCount,
				nonDDOId, panchayatCount, panchayatId);
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
		if (!(obj instanceof EDPOfficeSummaryDto)) {
			return false;
		}
		EDPOfficeSummaryDto other = (EDPOfficeSummaryDto) obj;
		return count == other.count && ddoCount == other.ddoCount && ddoId == other.ddoId && ddotype == other.ddotype
				&& Objects.equals(districtCode, other.districtCode) && Objects.equals(districtId, other.districtId)
				&& Objects.equals(districtName, other.districtName) && nonDDOCount == other.nonDDOCount
				&& nonDDOId == other.nonDDOId && panchayatCount == other.panchayatCount
				&& panchayatId == other.panchayatId;
	}

	/**
	 * Gets the ddo count.
	 *
	 * @return the ddo count
	 */
	public int getDdoCount() {
		return ddoCount;
	}

	/**
	 * Sets the ddo count.
	 *
	 * @param ddoCount the new ddo count
	 */
	public void setDdoCount(int ddoCount) {
		this.ddoCount = ddoCount;
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
	 * Gets the ddotype.
	 *
	 * @return the ddotype
	 */
	public int getDdotype() {
		return ddotype;
	}

	/**
	 * Sets the ddotype.
	 *
	 * @param ddotype the new ddotype
	 */
	public void setDdotype(int ddotype) {
		this.ddotype = ddotype;
	}

	/**
	 * Gets the district code.
	 *
	 * @return the district code
	 */
	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * Sets the district code.
	 *
	 * @param districtCode the new district code
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public String getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
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
	 * Gets the non DDO count.
	 *
	 * @return the non DDO count
	 */
	public int getNonDDOCount() {
		return nonDDOCount;
	}

	/**
	 * Sets the non DDO count.
	 *
	 * @param nonDDoCount the new non DDO count
	 */
	public void setNonDDOCount(int nonDDoCount) {
		this.nonDDOCount = nonDDoCount;
	}

	/**
	 * Gets the panchayat count.
	 *
	 * @return the panchayat count
	 */
	public int getPanchayatCount() {
		return panchayatCount;
	}

	/**
	 * Sets the panchayat count.
	 *
	 * @param panchayatCount the new panchayat count
	 */
	public void setPanchayatCount(int panchayatCount) {
		this.panchayatCount = panchayatCount;
	}

	/**
	 * Gets the ddo id.
	 *
	 * @return the ddoId
	 */
	public int getDdoId() {
		return ddoId;
	}

	/**
	 * Sets the ddo id.
	 *
	 * @param ddoId the ddoId to set
	 */
	public void setDdoId(int ddoId) {
		this.ddoId = ddoId;
	}

	/**
	 * Gets the non DDO id.
	 *
	 * @return the nonDDOId
	 */
	public int getNonDDOId() {
		return nonDDOId;
	}

	/**
	 * Sets the non DDO id.
	 *
	 * @param nonDDOId the nonDDOId to set
	 */
	public void setNonDDOId(int nonDDOId) {
		this.nonDDOId = nonDDOId;
	}

	/**
	 * Gets the panchayat id.
	 *
	 * @return the panchayatId
	 */
	public int getPanchayatId() {
		return panchayatId;
	}

	/**
	 * Sets the panchayat id.
	 *
	 * @param panchayatId the panchayatId to set
	 */
	public void setPanchayatId(int panchayatId) {
		this.panchayatId = panchayatId;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	
}

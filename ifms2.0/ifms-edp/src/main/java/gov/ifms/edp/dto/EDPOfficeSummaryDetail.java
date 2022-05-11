package gov.ifms.edp.dto;

import java.util.Map;
import java.util.Objects;

public class EDPOfficeSummaryDetail {

	private String districtCode;

	private String districtName;

	private Map<String, Integer> summaryCounts;

	@Override
	public int hashCode() {
		return Objects.hash(districtCode, districtName, summaryCounts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EDPOfficeSummaryDetail)) {
			return false;
		}
		EDPOfficeSummaryDetail other = (EDPOfficeSummaryDetail) obj;
		return Objects.equals(districtCode, other.districtCode) && Objects.equals(districtName, other.districtName)
				&& Objects.equals(summaryCounts, other.summaryCounts);
	}

	/**
	 * @return the districtCode
	 */
	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the summaryCounts
	 */
	public Map<String, Integer> getSummaryCounts() {
		return summaryCounts;
	}

	/**
	 * @param summaryCounts the summaryCounts to set
	 */
	public void setSummaryCounts(Map<String, Integer> summaryCounts) {
		this.summaryCounts = summaryCounts;
	}

}

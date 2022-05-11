package gov.ifms.pvu.dto.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The Class RopConfigurationDto.
 */
public class RopConfigurationDto {

	private long id;
	
	private Long ropType;
	
	private BigDecimal withNpa;
	
	private BigDecimal withoutNpa;
	
	private Date effectiveDate;
	
	private String masterTable;

	public RopConfigurationDto() {
		super();
	}

	public RopConfigurationDto(Long ropType, Date effectiveDate) {
		this.ropType = ropType;
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the ropType
	 */
	public Long getRopType() {
		return ropType;
	}

	/**
	 * @param ropType the ropType to set
	 */
	public void setRopType(Long ropType) {
		this.ropType = ropType;
	}

	/**
	 * @return the withNpa
	 */
	public BigDecimal getWithNpa() {
		return withNpa;
	}

	/**
	 * @param withNpa the withNpa to set
	 */
	public void setWithNpa(BigDecimal withNpa) {
		this.withNpa = withNpa;
	}

	/**
	 * @return the withoutNpa
	 */
	public BigDecimal getWithoutNpa() {
		return withoutNpa;
	}

	/**
	 * @param withoutNpa the withoutNpa to set
	 */
	public void setWithoutNpa(BigDecimal withoutNpa) {
		this.withoutNpa = withoutNpa;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the masterTable
	 */
	public String getMasterTable() {
		return masterTable;
	}

	/**
	 * @param masterTable the masterTable to set
	 */
	public void setMasterTable(String masterTable) {
		this.masterTable = masterTable;
	}
	
	
}

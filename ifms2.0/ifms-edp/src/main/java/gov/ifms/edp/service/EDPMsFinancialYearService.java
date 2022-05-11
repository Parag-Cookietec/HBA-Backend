package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.edp.entity.EDPMsFinancialYearEntity;

/**
 * The Interface EDPMsFinancialYearService.
 */
public interface EDPMsFinancialYearService {
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<EDPMsFinancialYearEntity> getAll();

	/**
	 * Gets the last ten year.
	 *
	 * @return the last ten year
	 */
	public List<EDPMsFinancialYearEntity> getLastTenYear();
}

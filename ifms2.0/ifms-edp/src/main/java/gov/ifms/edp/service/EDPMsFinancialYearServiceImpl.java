package gov.ifms.edp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;




/**
 * The Class EDPMsFinancialYearServiceImpl.
 */
@Service
public class EDPMsFinancialYearServiceImpl implements EDPMsFinancialYearService{
	
	/** The repository. */
	@Autowired
	private EDPMsFinancialYearRepository repository;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@Override
	@Cacheable(value = "edpmsFinancialYear")
	public List<EDPMsFinancialYearEntity> getAll() {
		return repository.findAll();
	}

	/**
	 * Gets the last ten year.
	 *
	 * @return the last ten year
	 */
	@Override
	public List<EDPMsFinancialYearEntity> getLastTenYear() {
		return repository.findFirst10ByActiveStatusOrderByFinancialYearIdDesc(Constant.ACTIVE_STATUS);
	}
	

}

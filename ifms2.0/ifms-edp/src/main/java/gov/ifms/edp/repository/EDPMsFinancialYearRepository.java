package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.dto.EDPMsFinancialYearDto;
/**
 * The Interface EDPMsFinancialYearRepository.
 */
@Repository
@Transactional
public interface EDPMsFinancialYearRepository
		extends JpaRepository<EDPMsFinancialYearEntity, Long>, JpaSpecificationExecutor<EDPMsFinancialYearEntity> {

	/**
	 * Find by is current year look up info value.
	 *
	 * @param value the value
	 * @return the EDP ms financial year entity
	 */
	EDPMsFinancialYearEntity findByIsCurrentYearLookUpInfoValue(Integer value);

	/**
	 * Find by is current year look up info name.
	 *
	 * @param value the value
	 * @return the EDP ms financial year entity
	 */
	EDPMsFinancialYearEntity findByIsCurrentYearLookUpInfoName(String value);

	/**
	 * Find by fy start.
	 *
	 * @param value the value
	 * @return the EDP ms financial year entity
	 */
	EDPMsFinancialYearEntity findByFyStart(int value);

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsFinancialYearEntity> findByActiveStatus(int activeStatus);
	List<EDPMsFinancialYearEntity> findAllByActiveStatusOrderByFyStart(int activeStatus);

	/**
	 * Find first 10 by active status order by id desc.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsFinancialYearEntity> findFirst10ByActiveStatusOrderByFinancialYearIdDesc(int activeStatus);

	/**
	 * Find financial years and active status.
	 *
	 * @param activeStatus the active status
	 * @param n the n
	 * @return the list
	 */
	@Query(value = "SELECT  mfy.FINANCIAL_YEAR_ID,mfy.FY,mfy.IS_CURRENT_YEAR FROM MASTER_V1.MS_FINANCIAL_YEAR mfy WHERE mfy.FY_START "
			+ "<=(SELECT mfy1.FY_START FROM MASTER_V1.MS_FINANCIAL_YEAR mfy1 WHERE mfy1.IS_CURRENT_YEAR = 2 AND mfy1.ACTIVE_STATUS = :activeStatus ) "
			+ "AND mfy.ACTIVE_STATUS = :activeStatus ORDER BY mfy.FY_START DESC FETCH FIRST :n ROWS ONLY", nativeQuery = true)
	List<Object[]> findByFinancialYearsAndActiveStatus(int activeStatus, Integer n);

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @param sort         the sort
	 * @return the list
	 */
	List<EDPMsFinancialYearEntity> findByActiveStatus(int activeStatus, Sort sort);
	
	/*
	 * @Query(value =
	 * "FROM EDPMsFinancialYearEntity f WHERE f.fyStart <= (SELECT mfy.fyStart + 1 FROM EDPMsFinancialYearEntity mfy WHERE mfy.isCurrentYear.lookUpInfoId = 2) order by f.fyStart desc FETCH FIRST 10 ROWS ONLY"
	 * ) List<EDPMsFinancialYearEntity> findlastTenYears();
	 */
	
	@Query(value="select new gov.ifms.edp.dto.EDPMsFinancialYearDto(efye.financialYearId,efye.fyStart,efye.fyEnd,efye.fy, elie.lookUpInfoValue) from EDPMsFinancialYearEntity efye JOIN EDPLuLookUpInfoEntity elie on efye.isCurrentYear=elie.lookUpInfoId")
    public List<EDPMsFinancialYearDto> getFinancialYearList();
}

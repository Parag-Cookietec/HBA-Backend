/*
 * 
 */
package gov.ifms.loc.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.loc.entity.LocMsMajorHeadEntity;

/**
 * The Class BudgetMsMajorHeadController.
 * 
 * @version 1.0
 * @created 2019/08/29 15:55:14
 */
@Repository
public interface LocMsMajorHeadRepository
		extends JpaRepository<LocMsMajorHeadEntity, Long>, JpaSpecificationExecutor<LocMsMajorHeadEntity> {

	/**
	 * Fetch all major head by demand id and active status
	 * 
	 * @param demandId
	 * @param activeStatus {@link Integer}
	 * @return list of
	 */
	List<LocMsMajorHeadEntity> findByBudgetMsDemandEntitiesDemandIdAndActiveStatusOrderByMajorHeadCode(Long demandId, int activeStatus);

	/**
	 * Fetch all code and id
	 * 
	 * @return List<ClueDto>
	 */
	@Query(value = "select bmde.majorHeadId,bmde.majorHeadCode,bmde.majorHeadDesc from LocMsMajorHeadEntity bmde")
	public List<Object[]> findCodeAndId();

	/**
	 * Find major header by type.
	 *
	 * @param majorHeadType the major head type
	 * @param demandCodes   the demand codes
	 * @return the list
	 */
	@Query(value = "select bmde.majorHeadId,bmde.majorHeadCode,bmde.majorHeadName,bmde.majorHeadCodeName from LocMsMajorHeadEntity bmde where bmde.majorHeadTypeId = :majorHeadType and bmde.activeStatus=1 and bmde.budgetMsDemandEntities.demandCode in :demandCodes order by bmde.majorHeadCode")
	List<Object[]> findMajorHeaderByType(@Param("majorHeadType") long majorHeadType,
			@Param("demandCodes") Set<String> demandCodes);

	/**
	 * Find major head by type.
	 *
	 * @param majorHeadType the major head type
	 * @return the list
	 */
	@Query(value = "select bmde.majorHeadId,bmde.majorHeadCode,bmde.majorHeadName,bmde.majorHeadCodeName from LocMsMajorHeadEntity bmde where bmde.majorHeadTypeId = :majorHeadType and bmde.activeStatus=1 order by bmde.majorHeadCode")
	List<Object[]> findMajorHeadByType(@Param("majorHeadType") long majorHeadType);

	/**
	 * Find major heades in demand ids.
	 *
	 * @param demandIds the demand ids
	 * @return the list
	 */
	@Query(value = "select bmde.majorHeadId,bmde.majorHeadCode,bmde.majorHeadName,bmde.majorHeadCodeName,bmde.budgetMsDemandEntities.demandId from LocMsMajorHeadEntity bmde where  bmde.activeStatus=1 and bmde.budgetMsDemandEntities.demandId in :demandIds order by bmde.majorHeadCode")
	List<Object[]> findMajorHeadesInDemandIds(@Param("demandIds") List<Long> demandIds);

	/**
	 * Gets the major heades by demand id.
	 *
	 * @param demandId the demand id
	 * @param majorHeadCode the major head code
	 * @param activeStatus the active status
	 * @return the major heades by demand id
	 */
	@Query(value = "SELECT mh FROM LocMsMajorHeadEntity mh WHERE mh.budgetMsDemandEntities.demandId = :demandId AND mh.majorHeadCode > :majorHeadCode AND mh.activeStatus = :activeStatus")
	List<LocMsMajorHeadEntity> getMajorHeadesByDemandId(@Param("demandId") Long demandId,
			@Param("majorHeadCode") String majorHeadCode, @Param("activeStatus") Integer activeStatus);

}

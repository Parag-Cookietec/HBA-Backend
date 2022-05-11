package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import gov.ifms.loc.entity.LocMsMinorHeadEntity;

/**
 * The Class BudgetMsMinorHeadController.
 * 
 * @version 1.0
 * @created 2019/08/29 16:00:31
 */
public interface LocMsMinorHeadRepository
		extends JpaRepository<LocMsMinorHeadEntity, Long>, JpaSpecificationExecutor<LocMsMinorHeadEntity> {
	LocMsMinorHeadEntity findByMinorHeadId(long minorHead);

	/**
	 * Fetch all code and id
	 * 
	 * @return List<ClueDto>
	 */
	@Query(value = "select bmde.minorHeadId,bmde.minorHeadCode,bmde.minorHeadDesc from LocMsMinorHeadEntity bmde")
	public List<Object[]> findCodeAndId();

	/**
	 * Find by demand id and major head entity major head id and sub major head entity sub major head id and active status order by minor head code.
	 *
	 * @param demandId the demand id
	 * @param majorHeadId the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<LocMsMinorHeadEntity> findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndActiveStatusOrderByMinorHeadCode(
			Long demandId, Long majorHeadId, Long subMajorHeadId, int activeStatus);
	
	/**
	 * Find by major head entity major head id and sub major head entity sub major head id.
	 *
	 * @param majorHeadid the major headid
	 * @param submajorHeadid the submajor headid
	 * @return the list
	 */
	List<LocMsMinorHeadEntity> findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadId(Long majorHeadid, Long submajorHeadid);

}

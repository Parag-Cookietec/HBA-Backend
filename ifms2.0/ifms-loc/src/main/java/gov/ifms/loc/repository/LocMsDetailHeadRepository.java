package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import gov.ifms.loc.entity.LocMsDetailHeadEntity;

/**
 * The Class BudgetMsDetailHeadController.
 * 
 * @version 1.0
 * @created 2019/08/29 15:46:37
 */
public interface LocMsDetailHeadRepository
		extends JpaRepository<LocMsDetailHeadEntity, Long>, JpaSpecificationExecutor<LocMsDetailHeadEntity> {

	
	
	/**
	 * Fetch all code and id
	 * 
	 * @return List<ClueDto>
	 */
	@Query(value = "select bmde.detailHeadId,bmde.detailHeadCode,bmde.detailHeadDesc from LocMsDetailHeadEntity bmde")
	public List<Object[]> findCodeAndId();
	
	/**
	 * Find by detail head id.
	 *
	 * @param detailHeadId the detail head id
	 * @return the loc ms detail head entity
	 */
	LocMsDetailHeadEntity findByDetailHeadId(long detailHeadId);

	/**
	 * Find by demand id and major head entity major head id and sub major head entity sub major head id and minor head entity minor head id and sub head entity sub head id and and active status order by detail head code.
	 *
	 * @param demandId the demand id
	 * @param majorHeadId the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param minorHeadId the minor head id
	 * @param subHeadId the sub head id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<LocMsDetailHeadEntity> findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndSubHeadEntitySubHeadIdAndAndActiveStatusOrderByDetailHeadCode(
			Long demandId, Long majorHeadId, Long subMajorHeadId, Long minorHeadId, Long subHeadId, int activeStatus);
	
	
	/**
	 * Find by major head entity major head id and sub major head entity sub major head id and minor head entity minor head id and sub head entity sub head id.
	 *
	 * @param majorId the major id
	 * @param submajorId the submajor id
	 * @param minorid the minorid
	 * @param subheadId the subhead id
	 * @return the list
	 */
	List<LocMsDetailHeadEntity> findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndSubHeadEntitySubHeadId(Long majorId, Long submajorId, Long minorid,Long subheadId);
}

package gov.ifms.loc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import gov.ifms.loc.entity.LocMsSubHeadEntity;

/**
 * The Class BudgetMsSubHeadController.
 * 
 * @version 1.0
 * @created 2019/08/29 16:16:22
 */
public interface LocMsSubHeadRepository
		extends JpaRepository<LocMsSubHeadEntity, Long>, JpaSpecificationExecutor<LocMsSubHeadEntity> {

	/**
	 * Fetch all code and id
	 * 
	 * @return List<ClueDto>
	 */
	@Query(value = "select bmde.subHeadId,bmde.subHeadCode,bmde.subHeadDesc from LocMsSubHeadEntity bmde")
	public List<Object[]> findCodeAndId();

	/**
	 * Find by major head entity major head id.
	 *
	 * @param majorHeadId the major head id
	 * @return the list
	 */
	List<LocMsSubHeadEntity> findByMajorHeadEntityMajorHeadId(Long majorHeadId);


	/**
	 * Find by demand id and major head entity major head id and sub major head entity sub major head id and minor head entity minor head id and active status order by sub head code.
	 *
	 * @param demandId the demand id
	 * @param majorHeadId the major head id
	 * @param subMajorHjeadId the sub major hjead id
	 * @param minorHeadId the minor head id
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<LocMsSubHeadEntity> findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndActiveStatusOrderBySubHeadCode(
			Long demandId, Long majorHeadId, Long subMajorHjeadId, Long minorHeadId, int activeStatus);

	/**
	 * Find by demand id and major head entity major head id and sub major head entity sub major head id and minor head entity minor head id and active status order by sub head code asc.
	 *
	 * @param demandId the demand id
	 * @param majorHeadId the major head id
	 * @param subMajorHjeadId the sub major hjead id
	 * @param minorHeadId the minor head id
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<LocMsSubHeadEntity> findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndActiveStatusOrderBySubHeadCodeAsc(
			Long demandId, Long majorHeadId, Long subMajorHjeadId, Long minorHeadId, int activeStatus);

	/**
	 * Find by major head entity major head id and sub major head entity sub major head id and minor head entity minor head id.
	 *
	 * @param majorHeadId the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param minorHeadId the minor head id
	 * @return the list
	 */
	List<LocMsSubHeadEntity>   findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadId(Long majorHeadId,Long subMajorHeadId, Long minorHeadId);
	
	/**
	 * Find by sub head id.
	 *
	 * @param subHeadId the sub head id
	 * @return the optional
	 */
	public Optional<LocMsSubHeadEntity> findBySubHeadIdAndActiveStatus(long subHeadId, int activeStatus);

}

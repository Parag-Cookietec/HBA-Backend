package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import gov.ifms.loc.entity.LocMsSubMajorHeadEntity;

/**
 * The Class BudgetMsSubMajorHeadController.
 * 
 * @version 1.0
 * @created 2019/08/29 17:14:12
 */
public interface LocMsSubMajorHeadRepository
		extends JpaRepository<LocMsSubMajorHeadEntity, Long>, JpaSpecificationExecutor<LocMsSubMajorHeadEntity> {

	/**
	 * This method is used to find all sub major head
	 * 
	 * @param spec
	 * @param pageable
	 * @return Page<BudgetMsSubMajorHeadEntity>
	 */
	@Query("select smh.subMajorHeadId, smh.submajorHeadName,smh.majorHeadEntity.majorHeadCode from LocMsSubMajorHeadEntity smh")
	Page<LocMsSubMajorHeadEntity> findAllSubMajorHeads(@Nullable Specification<LocMsSubMajorHeadEntity> spec,
			Pageable pageable);

	/**
	 * 
	 * @param bpnCode
	 * @param demandCode
	 * @param majorHeadCode
	 * @param activeStatus
	 * @return List<BudgetMsSubMajorHeadEntity>
	 */
	List<LocMsSubMajorHeadEntity> findByDemandIdAndMajorHeadEntityMajorHeadIdAndActiveStatusOrderBySubMajorHeadCode(
			Long demandId, Long majorHeadId, int activeStatus);

	/**
	 * Fetch all code and id
	 * 
	 * @return List<ClueDto>
	 */
	@Query(value = "select bmde.subMajorHeadId,bmde.subMajorHeadCode,bmde.subMajorHeadDesc from LocMsSubMajorHeadEntity bmde")
	public List<Object[]> findCodeAndId();

	/**
	 * Find by major head entity major head id.
	 *
	 * @param id the id
	 * @return the list
	 */
	List<LocMsSubMajorHeadEntity> findByMajorHeadEntityMajorHeadId(Long id);

}

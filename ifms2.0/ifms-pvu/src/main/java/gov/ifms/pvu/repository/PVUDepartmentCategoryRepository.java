package gov.ifms.pvu.repository;

import java.util.List;

import gov.ifms.edp.dto.IdNameDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;

/**
 * The Class PVUDepartmentCategoryController.
 * 
 * @version v 1.0
 * @created 2019/12/31 16:57:07
 */

@Repository
@Transactional
public interface PVUDepartmentCategoryRepository extends JpaRepository<PVUDepartmentCategoryEntity, Long>,
		JpaSpecificationExecutor<PVUDepartmentCategoryEntity> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<PVUDepartmentCategoryEntity> findAll();

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @param sort 
	 * @return the list
	 */
	List<PVUDepartmentCategoryEntity> findByActiveStatus(int activeStatus, Sort sort);

	@Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.deptCategoryId,e.departmentCategoryName) from PVUDepartmentCategoryEntity e where e.deptCategoryId = :id")
	IdNameDto getOnlyIdAndName(@Param("id") Long id);
}

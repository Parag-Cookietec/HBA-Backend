package gov.ifms.pvu.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;

/**
 * The Class PVUEmployeLangExamController.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:55:09
 */

@Repository
@Transactional
public interface PVUEmployeLangExamRepository
		extends JpaRepository<PVUEmployeLangExamEntity, Long>, JpaSpecificationExecutor<PVUEmployeLangExamEntity> {

	/**
	 * Find PVU employe lang exam entity bypvu employe entity emp id and active status.
	 *
	 * @param id the id
	 * @param activeStatus 
	 * @return the list
	 */
	List<PVUEmployeLangExamEntity> findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(Long id, int activeStatus);

	/**
	 * Update active status byemp lang exam id.
	 *
	 * @param empLangExamId the emp lang exam id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update PVUEmployeLangExamEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where empLangExamId = :empLangExamId")
	public int updateActiveStatusByempLangExamId(@Param("empLangExamId") long empLangExamId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

}

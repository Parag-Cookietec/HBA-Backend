package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeHistoryEntity;


/**
 * The Class PVUEmployeHistoryController.
 * 
 * @version v 1.0
 * @created 2019/11/29 17:29:29
 */

@Repository
@Transactional
public interface PVUEmployeHistoryRepository
		extends JpaRepository<PVUEmployeHistoryEntity, Long>, JpaSpecificationExecutor<PVUEmployeHistoryEntity> {

	/**
	 * Find PVU employe history entity bypvu employe entity emp id.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<PVUEmployeHistoryEntity>findPVUEmployeHistoryEntityBypvuEmployeEntityEmpId(long id);



	/**
	 * Sets the delete status.
	 *
	 * @param id the id
	 * @param status the status
	 */
	@Modifying(clearAutomatically = true)
	@Query("UPDATE PVUEmployeHistoryEntity t set t.activeStatus= :status where t.id= :id")
	void setDeleteStatus(@Param("id") long id, @Param("status") int status);

}

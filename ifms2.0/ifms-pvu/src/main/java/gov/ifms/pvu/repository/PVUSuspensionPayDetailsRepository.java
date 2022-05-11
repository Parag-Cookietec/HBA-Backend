package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gov.ifms.pvu.entity.PVUSuspensionPayDetailsEntity;


/**
 * The Class PVUSuspensionPayDetailsController.
 * 
 * @version v 1.0
 * @created 2019/12/19 12:16:05
 */

@Repository
@Transactional
public interface PVUSuspensionPayDetailsRepository extends JpaRepository<PVUSuspensionPayDetailsEntity, Long>,
		JpaSpecificationExecutor<PVUSuspensionPayDetailsEntity> {

	@Modifying(clearAutomatically = true)
	@Query("UPDATE PVUSuspensionPayDetailsEntity as entity  SET entity.status.lookUpInfoId = :statusId WHERE entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id);

	int deleteById(@Param("id") long id );

}

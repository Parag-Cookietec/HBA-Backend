package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsUserPassHistEntity;

/**
 * The Interface EDPMsUserPassHistRepository.
 */
@Repository
@Transactional
public interface EDPMsUserPassHistRepository extends JpaRepository<EDPMsUserPassHistEntity, Long>, JpaSpecificationExecutor<EDPMsUserPassHistEntity> {

	/**
	 * Find top 3 by user id user id order by created date desc.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	List<EDPMsUserPassHistEntity> findTop3ByUserIdUserIdOrderByCreatedDateDesc(long userId);

}

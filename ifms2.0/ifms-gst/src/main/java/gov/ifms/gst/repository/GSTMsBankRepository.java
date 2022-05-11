package gov.ifms.gst.repository;

import gov.ifms.gst.entity.GSTMsBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Interface GSTMsBankRepository.
 */
@Repository
@Transactional
public interface GSTMsBankRepository extends JpaRepository<GSTMsBankEntity,Long> ,
                  JpaSpecificationExecutor<GSTMsBankEntity> {

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<GSTMsBankEntity> findByActiveStatus(int activeStatus);

}

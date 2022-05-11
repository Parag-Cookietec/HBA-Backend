package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocChequeCancelAttEntity;

/**
 * The Class LOCLocChequeCancelAttController.
 * 
 * @version v 1.0
 * @created 2021/03/05 17:59:59
 */

@Repository
@Transactional
public interface LocChequeCancelAttRepository
		extends JpaRepository<LocChequeCancelAttEntity, Long>, JpaSpecificationExecutor<LocChequeCancelAttEntity> {

}

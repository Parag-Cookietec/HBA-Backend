package gov.ifms.common.repository;

import gov.ifms.common.dao.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;

import gov.ifms.common.entity.NotificationTransactionEntity;

import java.util.Map;

/**
 * @author IFMS 2.0
 *
 */
public interface NotificationTransactionRepository extends JpaRepository<NotificationTransactionEntity, Long> ,GenericDao {

}

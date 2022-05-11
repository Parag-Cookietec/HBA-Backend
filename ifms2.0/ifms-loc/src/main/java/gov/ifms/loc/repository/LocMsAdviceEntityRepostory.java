/**
 * 
 */
package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocMsAdviceDtlEntity;

/**
 * @author swath
 *
 */
public interface LocMsAdviceEntityRepostory  extends JpaRepository<LocMsAdviceDtlEntity, Long>,
JpaSpecificationExecutor<LocMsAdviceDtlEntity>, GenericDao {

}

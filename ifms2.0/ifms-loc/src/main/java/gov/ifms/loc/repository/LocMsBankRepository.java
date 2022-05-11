package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocMsBankEntity;

/**
 * The Interface ReceiptMsBankRepository.
 */
@Repository
@Transactional
public interface LocMsBankRepository
		extends JpaRepository<LocMsBankEntity, Long>, JpaSpecificationExecutor<LocMsBankEntity>, GenericDao {

}

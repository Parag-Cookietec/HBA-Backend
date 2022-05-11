package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPTedpBrCrDtlItrEntity;


/**
 * The Interface EDPTedpBrCrDtlItrRepository.
 */
@Repository
@Transactional
public interface EDPTedpBrCrDtlItrRepository
		extends JpaRepository<EDPTedpBrCrDtlItrEntity, Long>, JpaSpecificationExecutor<EDPTedpBrCrDtlItrEntity>, GenericDao {

	
}
package gov.ifms.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.workflow.entity.PvuLkTrnEmpCrWfEntity;

/**
 * The Class PvuLkWfRepository.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
public interface PvuLkWfRepository
		extends JpaRepository<PvuLkTrnEmpCrWfEntity, Long>, JpaSpecificationExecutor<PvuLkTrnEmpCrWfEntity>{
}

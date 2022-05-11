package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLkUserMenuEntity;

/**
 * The Interface EDPLkPuoMenuRolesRepository.
 */
@Repository
@Transactional
public interface EDPLkPuoMenuRolesRepository
		extends JpaRepository<EDPLkUserMenuEntity, Long>, JpaSpecificationExecutor<EDPLkUserMenuEntity> {

}

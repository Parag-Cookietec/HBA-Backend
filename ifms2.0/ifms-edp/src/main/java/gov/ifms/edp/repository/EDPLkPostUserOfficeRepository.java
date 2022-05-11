package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLkPostOfficeEntity;

/**
 * The Class EDPLkPostUserOfficeRepository.
 * 
 * @version 1.0
 * @created 2019/09/11 16:43:32
 */
@Repository
@Transactional
public interface EDPLkPostUserOfficeRepository
		extends JpaRepository<EDPLkPostOfficeEntity, Long>, JpaSpecificationExecutor<EDPLkPostOfficeEntity> {


}

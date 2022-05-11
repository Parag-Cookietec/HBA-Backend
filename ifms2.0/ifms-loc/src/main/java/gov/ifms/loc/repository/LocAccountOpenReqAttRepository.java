package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAccountOpenReqAttEntity;

/**
 * The Class BudgetSubHeadAttachController.
 * 
 * @version 1.0
 * @created 2020/09/09 09:12:26
 */
@Repository
@Transactional
public interface LocAccountOpenReqAttRepository
		extends JpaRepository<LocAccountOpenReqAttEntity, Long>, JpaSpecificationExecutor<LocAccountOpenReqAttEntity> {

}

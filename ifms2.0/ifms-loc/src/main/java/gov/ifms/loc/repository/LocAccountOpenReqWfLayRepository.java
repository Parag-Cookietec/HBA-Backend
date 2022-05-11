package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAccountOpenReqWfLayEntity;


/**
 * The Class BudgetSubHeadWrkflwController.
 * 
 * @version 1.0
 * @created 2020/09/09 09:21:24
 */
@Repository
@Transactional
public interface LocAccountOpenReqWfLayRepository
		extends JpaRepository<LocAccountOpenReqWfLayEntity, Long>, JpaSpecificationExecutor<LocAccountOpenReqWfLayEntity> {

}

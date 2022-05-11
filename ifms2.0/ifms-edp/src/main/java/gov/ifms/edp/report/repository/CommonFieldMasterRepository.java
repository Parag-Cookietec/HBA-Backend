package gov.ifms.edp.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.report.entity.CommonFieldMasterEntity;

/**
 * The Class CommonFieldMasterController.
 * 
 * @version 1.0
 * @created 2021/02/23 13:41:52
 */
@Repository
@Transactional
public interface CommonFieldMasterRepository extends JpaRepository<CommonFieldMasterEntity,Long> , 
                  JpaSpecificationExecutor<CommonFieldMasterEntity> {

	/**
	 * Find by report id.
	 *
	 * @param reportId the report id
	 * @return the list
	 */
	List<CommonFieldMasterEntity> findByReportIdReportId(Long reportId);
	
	/**
	 * Find by report id alias.
	 *
	 * @param alias the alias
	 * @return the list
	 */
	List<CommonFieldMasterEntity> findByReportIdAlias(String alias);
	
}

package gov.ifms.edp.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.report.entity.CommonDesignMasterEntity;

/**
 * The Class CommonDesignMasterController.
 * 
 * @version 1.0
 * @created 2021/02/23 13:37:15
 */
@Repository
@Transactional
public interface CommonDesignMasterRepository extends JpaRepository<CommonDesignMasterEntity,Long> , 
                  JpaSpecificationExecutor<CommonDesignMasterEntity> {

	/**
	 * Find by report id.
	 *
	 * @param reportId the report id
	 * @return the list
	 */
	List<CommonDesignMasterEntity> findByReportIdReportId(Long reportId);
	
}

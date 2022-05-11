package gov.ifms.edp.report.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.report.entity.CommonReportMasterEntity;

/**
 * The Class CommonReportMasterController.
 * 
 * @version 1.0
 * @created 2021/02/23 13:34:48
 */
@Repository
@Transactional
public interface CommonReportMasterRepository extends JpaRepository<CommonReportMasterEntity,Long> , 
                  JpaSpecificationExecutor<CommonReportMasterEntity>, GenericDao {

	/**
	 * Find by alias and menu id.
	 *
	 * @param alias the alias
	 * @param menuId the menu id
	 * @return the optional
	 */
	Optional<CommonReportMasterEntity> findByAliasAndMenuId(String alias, Long menuId);
	
}

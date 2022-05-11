package gov.ifms.edp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPMsBillEntity;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Class EDPMsBillController.
 * 
 * @version 1.0
 * @created 2020/01/29 17:03:45
 */
@Repository 
@Transactional
public interface EDPReportRepository
		extends JpaRepository<EDPMsBillEntity, Long>, JpaSpecificationExecutor<EDPMsBillEntity>,GenericDao {
	
	@Query(value = EDPNativeSQLUtil.GET_EDP_WF_TRN_STATUS_BY_MENU_ID_QUERY  ,nativeQuery = true )
	List<Object[]> getWfStatusAndTrnStatus(@Param("menuId")Long menuId);
	
}

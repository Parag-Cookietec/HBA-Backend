package gov.ifms.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.workflow.entity.LkMenuTblInfoEntity;

/**
 * The Class LkMenuTblInfoRepository.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
public interface LkMenuTblInfoRepository
		extends JpaRepository<LkMenuTblInfoEntity, Long>, JpaSpecificationExecutor<LkMenuTblInfoEntity>{
	/**
	 * Find By MenuId And ActiveStatus And EventIdIsNull
	 *
	 * @param menuId
	 * @param activeStatus
	 * @return the entity
	 */
	LkMenuTblInfoEntity findByMenuIdAndActiveStatusAndEventIdIsNull(long menuId,int activeStatus);

	/**
	 * Find By MenuId And ActiveStatus And EventId
	 *
	 * @param menuId
	 * @param activeStatus
	 * @param eventId
	 * @return the entity
	 */
	LkMenuTblInfoEntity findByMenuIdAndActiveStatusAndEventId(Long menuId, int activeStatus, Long eventId);
	
	@Query(value = "select tbl from LkMenuTblInfoEntity tbl where tbl.menuId in (select wfActConf.edpMsMenuEntity.menuId from WfActionConfigEntity wfActConf where wfActConf.actionconfigId = :actionConfigId and wfActConf.activeStatus = :activeStatus)")
	LkMenuTblInfoEntity getTableAndSchemaByWfActConfig(@Param("actionConfigId") Long actionConfigId, @Param("activeStatus") int activeStatus);
}

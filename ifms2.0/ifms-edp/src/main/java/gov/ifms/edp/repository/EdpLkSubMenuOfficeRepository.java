package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EdpLkSubMenuOfficeTypeEntity;


public interface EdpLkSubMenuOfficeRepository 
extends JpaRepository<EdpLkSubMenuOfficeTypeEntity, Long>, JpaSpecificationExecutor<EdpLkSubMenuOfficeTypeEntity>, GenericDao{

	List<EdpLkSubMenuOfficeTypeEntity> findByModOffTypeIdLkModOffIdAndActiveStatusAndSubModuleIdNotNull(Long modOffId, int activeStatus);
	
	EdpLkSubMenuOfficeTypeEntity findByModOffTypeIdLkModOffIdAndSubModuleIdSubModuleIdAndMenuIdMenuIdAndActiveStatus(Long modOffId, Long subModuleId, Long menuId, int activeStatus);
}

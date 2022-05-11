package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.edp.entity.EDPLkModuleOfficeEntity;


public interface EDPLkModuleOfficeRepository 
extends JpaRepository<EDPLkModuleOfficeEntity, Long>, JpaSpecificationExecutor<EDPLkModuleOfficeEntity>{

	EDPLkModuleOfficeEntity findByModuleIdModuleIDAndOfficeTypeIdLookUpInfoIdAndOfficeCategoryIdLookUpInfoIdAndActiveStatus(Long moduleId, Long officeTypeId, Long categoryId, int activeStatus);
	
	EDPLkModuleOfficeEntity findByModuleIdModuleIDAndOfficeTypeIdLookUpInfoIdAndOfficeCategoryIdLookUpInfoIdIsNullAndActiveStatus(Long moduleId, Long officeTypeId, int activeStatus);

}

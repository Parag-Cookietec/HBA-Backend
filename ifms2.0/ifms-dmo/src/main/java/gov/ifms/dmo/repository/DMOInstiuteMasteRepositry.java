package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.entity.DMOInstiuteMasterEntity;
@Repository
public interface DMOInstiuteMasteRepositry extends JpaRepository<DMOInstiuteMasterEntity, Long>,
JpaSpecificationExecutor<DMOInstiuteMasterEntity> {

}

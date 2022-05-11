package gov.ifms.dmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.entity.DMOSecurityMasterEntity;

@Repository
@Transactional
public interface DMOSecurityMasterRepository
		extends JpaRepository<DMOSecurityMasterEntity, Long>, JpaSpecificationExecutor<DMOSecurityMasterEntity> {

	List<DMOSecurityMasterEntity> findAllByActiveStatus(int activeStatus);

}

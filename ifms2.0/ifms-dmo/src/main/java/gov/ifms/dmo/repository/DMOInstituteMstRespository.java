package gov.ifms.dmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.entity.DMOInstituteMstEntity;

@Repository
@Transactional
public interface DMOInstituteMstRespository
		extends JpaRepository<DMOInstituteMstEntity, Long>, JpaSpecificationExecutor<DMOInstituteMstEntity> {

	List<DMOInstituteMstEntity> findByActiveStatusOrderByInstituteNameAsc(int activeStatus);

}

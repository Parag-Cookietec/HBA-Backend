package gov.ifms.edp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPBECUserEntity;

@Repository
@Transactional
public interface EDPBECDataRepository
		extends JpaRepository<EDPBECUserEntity, Long>, JpaSpecificationExecutor<EDPBECUserEntity> {

	public List<EDPBECUserEntity> findByPan(String pan);

	@Modifying
	@Query(value = "update EDPBECUserEntity set  activeStatus=0  where pan = :pan")
	public void updateByPan(@Param("pan") String pan);

	List<EDPBECUserEntity> findByPanIn(List<String> pan);
	
	List<EDPBECUserEntity> findByIdIn(List<Long> ids);
	
	List<EDPBECUserEntity> findByPanAndActiveStatus(String pan ,Long activeStatus );
}

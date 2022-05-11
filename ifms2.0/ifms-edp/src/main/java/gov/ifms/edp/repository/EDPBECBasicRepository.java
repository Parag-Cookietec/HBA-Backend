package gov.ifms.edp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPBulkEmpCreationBasicEntity;

@Repository
@Transactional
public interface EDPBECBasicRepository
		extends CrudRepository<EDPBulkEmpCreationBasicEntity, Long>, JpaSpecificationExecutor<EDPBulkEmpCreationBasicEntity>, GenericDao {

//	@Modifying
//	@Query(value = "update EDPBulkEmpCreationBasicEntity set  activeStatus=0  where pan = :pan")
//	public void updateByPan(@Param("pan") String pan);
	@Modifying
	@Query(value = "update EDPBulkEmpCreationBasicEntity set  activeStatus=0  where pan = :pan")
	public void updateByPan(@Param("pan") String pan);

	public List<EDPBulkEmpCreationBasicEntity> findByPanIn(List<String> pan);

	@Query(value = "INSERT INTO EDPBECBasicEntity (SALUTATION,CASE_NO,FIRST_NAME,MIDDLE_NAME,LAST_NAME,DESIGNATION,DOB,PAN,MOBILENO,WORKFLOW1,WORKFLOW2,WORKFLOW3,DISTRICTNAME,DDONO,CARDEXNO) VALUES"
			+ "(:salutation, :caseNo,:fistName,:middleName,:lastName,:designation,:dob,:pan,:mobileNo,:wf1,:wf2,:wf3,:districtName,:ddoNo,:cardexNo )", nativeQuery = true)
	public void saveBECData(@Param("salutation") String salutation, @Param("caseNo") String caseNo,
			@Param("fistName") String fistName, @Param("middleName") String middleName,
			@Param("lastName") String lastName, @Param("designation") String designation, @Param("dob") String dob,
			@Param("mobileNo") String mobileNo, @Param("pan") String pan, @Param("wf1") String wf1,
			@Param("wf2") String wf2, @Param("wf3") String wf3, @Param("districtName") String districtName,
			@Param("ddoNo") String ddoNo, @Param("cardexNo") String cardexNo);
	
	public Optional<EDPBulkEmpCreationBasicEntity> findByPanAndIsCreateAndActiveStatus(String pan,int isCreate,Long activeStatus);

}

//@Repository
//public interface EDPBECBasicRepository  extends CrudRepository<EDPBulkEmpCreationBasicEntity, Long> {
//
//	@Modifying
//	@Query(value = "update EDPBulkEmpCreationBasicEntity set  activeStatus=0  where pan = :pan")
//	public void updateByPan(@Param("pan") String pan);
//
//	public List<EDPBulkEmpCreationBasicEntity> findByPanIn(List<String> pan);
//
//}

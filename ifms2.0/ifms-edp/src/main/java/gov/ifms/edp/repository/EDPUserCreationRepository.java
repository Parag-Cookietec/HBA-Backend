package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPBulkEmployeeCreationEntity;

@Repository
@Transactional
public interface EDPUserCreationRepository extends JpaRepository<EDPBulkEmployeeCreationEntity, Long>,
		JpaSpecificationExecutor<EDPBulkEmployeeCreationEntity>, GenericDao {

	@Modifying
	@Query(value = "update EDPBulkEmployeeCreationEntity set  trnNo=:trnNo  where becId = :becId")
	public void updateTrnNoByBulkEmpCreationId(@Param("becId") long becId, @Param("trnNo") String trnNo);


	@Query(value = "INSERT INTO PVU.DUMMYEMPSTAGING2 (SALUTATION,CASE_NO,FIRST_NAME,MIDDLE_NAME,LAST_NAME,DESIGNATION,DOB,PAN,MOBILENO,WORKFLOW1,WORKFLOW2,WORKFLOW3,DISTRICTNAME,DDONO,CARDEXNO) VALUES"
			+ "(:salutation, :caseNo,:fistName,:middleName,:lastName,:designation,:dob,:pan,:mobileNo,:wf1,:wf2,:wf3,:districtName,:ddoNo,:cardexNo )", nativeQuery = true)
	public void saveBECData(@Param("salutation") String salutation, @Param("caseNo") String caseNo,
			@Param("fistName") String fistName, @Param("middleName") String middleName,
			@Param("lastName") String lastName, @Param("designation") String designation, @Param("dob") String dob,
			@Param("mobileNo") String mobileNo, @Param("pan") String pan, @Param("wf1") String wf1,
			@Param("wf2") String wf2, @Param("wf3") String wf3, @Param("districtName") String districtName,
			@Param("ddoNo") String ddoNo, @Param("cardexNo") String cardexNo);

//	@Modifying
//	@Query(value = "update PVU.DUMMYEMPSTAGING2 e set  e.ACTIVE_STATUS=1  where e.PAN = :pan")
//	public void updateByPan(@Param("pan") String pan);
	
	@Procedure("EDP.BULK_EMP_CREATION")
	public String callBulkEmpCreationProc();

	@Procedure("EDP.BULK_EMP_CREATION_INTERNAL")
	public String callBulkEmpCreationInternalProc();
	//call MIGRATION_EDP.NEW_USER_CREATION(:IN_USER_DESC,:IN_USER_CODE,:IN_DESIGNATION_ID,:IN_OFFICE_ID,:IN_IS_PRIMARY_POST,?)
	//@Query(value = "CALL FIND_CARS_AFTER_YEAR(:year_in);", nativeQuery = true)
//	@Query(value = "call MIGRATION_EDP.NEW_USER_CREATION(:in_user_desc,:in_user_code,:in_designation_id,:in_designation_id,:in_is_primary_post,?", nativeQuery = true)
//	Object spNewUserCreation(@Param("IN_USER_DESC") String in_user_desc,
//			@Param("IN_USER_CODE") String in_user_code,
//			@Param("IN_DESIGNATION_ID") Integer in_designation_id,
//			@Param("IN_OFFICE_ID") Integer in_office_id,
//			@Param("IN_IS_PRIMARY_POST") Integer in_is_primary_post);
}

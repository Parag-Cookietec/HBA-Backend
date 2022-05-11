package gov.ifms.pvu.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.dto.PVUEmployeeTypeDto;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeEntity;

@Transactional
@Repository
public interface PVUEmployeTypeChangeRepository extends JpaRepository<PVUEmployeTypeChangeEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeTypeChangeEntity>, GenericDao {

	@Query(value = "SELECT me.EMPLOYEE_NO AS empNo,me.EMPLOYEE_NAME ||' '|| me.MIDDLE_GUARDIAN_NAME ||' '|| me.SURNAME AS empName ,mo.OFFICE_ID AS officeId,mo.OFFICE_NAME_DISP AS officeName,\r\n"
			+ "tedd.EMP_TYPE AS empTypeId,lli.LOOKUP_INFO_NAME AS empTypeName ,tedd.DATE_JOINING AS doj,tedd.DESIGNATION_ID AS desigId,md.DESIGNATION_NAME AS desigName,tedd.CLASS AS empClassId,lli2.LOOKUP_INFO_NAME AS empClassName\r\n"
			+ ",lli3.LOOKUP_INFO_NAME AS empPayTypeName,tedd.EMP_PAY_TYPE AS currentPayType FROM PVU.T_EMP_DPT_DTL tedd \r\n"
			+ "INNER JOIN MASTER_V1.MS_EMPLOYEE me ON me.EMP_ID =tedd.EMP_ID \r\n"
			+ "LEFT JOIN MASTER_V1.MS_OFFICE mo ON mo.OFFICE_ID =me.OFFICE_ID \r\n"
			+ "LEFT JOIN MASTER_V1.LU_LOOKUP_INFO lli ON lli.LOOKUP_INFO_ID =tedd.EMP_TYPE \r\n"
			+ "LEFT JOIN MASTER_V1.LU_LOOKUP_INFO lli2 ON lli2.LOOKUP_INFO_ID =tedd.CLASS \r\n"
			+ "LEFT JOIN MASTER_V1.LU_LOOKUP_INFO lli3 ON lli3.LOOKUP_INFO_ID =tedd.EMP_PAY_TYPE \r\n "
			+ "LEFT JOIN MASTER_V1.MS_DESIGNATION md ON md.DESIGNATION_ID =tedd.DESIGNATION_ID\r\n"
			+ "WHERE  me.EMP_ID = ?1 OR me.EMPLOYEE_NO = ?1", nativeQuery = true)
	PVUEmployeeTypeDto getEmpDetails(Long id);

	@Query(value = "SELECT count(*) FROM PVU.T_PVU_ADHC_PROB_REGLR WHERE TRN_NO LIKE ?", nativeQuery = true)
	Long getyearCount(String fy);

	PVUEmployeTypeChangeEntity findByEmpId(Long empNo);

	@Modifying
	@Query(value = "UPDATE PVU.T_PVU_ADHC_PROB_REGLR_SD SET ACTIVE_STATUS = 0 WHERE PVU_ADHC_PROB_REGLR_SD_ID = ?", nativeQuery = true)
	void deleteEmpTypeChange(Long id);

	PVUEmployeTypeChangeEntity findByTpvuRegPrboSdId(Long id);

	@Query(value = "SELECT FINANCIAL_YEAR_ID FROM MASTER_V1.MS_FINANCIAL_YEAR mfy WHERE FY =?", nativeQuery = true)
	Long findFYYearId(String fyYear);

	@Query(value = "SELECT EOL AS EOL,SUSPENSION AS suspension,TRANSFER AS transfer,\"INCREMENT\" AS incremnt,TRN_ID AS transNo FROM PVU.T_EMP_EVNT_STATUS tees WHERE EMP_ID =?1", nativeQuery = true)
	PVUEmployeeTypeDto validateAdhoc(Long empId);

}

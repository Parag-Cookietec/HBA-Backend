package gov.ifms.pvu.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.dto.response.PVUDepartmentQueryDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * The Class PVUEmployeeDepartmentController.
 *
 * @version v 1.0
 * @created 2019/11/21 14:17:25
 */

@Repository
@Transactional
public interface PVUEmployeDepartmentRepository
        extends JpaRepository<PVUEmployeDepartmentEntity, Long>, JpaSpecificationExecutor<PVUEmployeDepartmentEntity> , GenericDao {

    /**
     * Find one by pvu employe entity emp id.
     *
     * @param empId the emp id
     * @return the PVU employe department entity
     */
    PVUEmployeDepartmentEntity findOneByPvuEmployeEntityEmpId(Long empId);

    /**
     * Find one by pvu employe entity emp id.
     *
     * @param empId the emp id
     * @return the PVU employe department entity
     */
    PVUEmployeDepartmentEntity findFirstByPvuEmployeEntityEmpId(Long empId);

    /**
     * Find one by pvu employe entity emp id.
     *
     * @param empId the emp id
     * @return the PVU employe department entity
     */
    Optional<PVUEmployeDepartmentEntity> findFirstByPvuEmployeEntityEmployeeCode(Long empId);

    /**
     * Find one by pvu employe entity emp id.
     *
     * @param empId the emp id
     * @return the PVU employe department entity
     */
    Optional<PVUEmployeDepartmentEntity> findByPvuEmployeEntityEmpId(Long empId);

    @Query(value = "SELECT new gov.ifms.pvu.dto.response.PVUDepartmentQueryDto(e.dateOfJoiningGOG,e.dateOfRetirement) from PVUEmployeDepartmentEntity e where e.pvuEmployeEntity.empId = :id")
    PVUDepartmentQueryDto getDateOfJoiningGOGAndDateOfRetirement(@Param("id") Long id);
}

package gov.ifms.pvu.repository;

import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * The Class PVUEmployeDeptExamDetailsController.
 *
 * @version v 1.0
 * @created 2019/11/27 06:15:41
 */

@Repository
@Transactional
public interface PVUEmployeDeptExamDetailsRepository extends JpaRepository<PVUEmployeDeptExamDetailsEntity, Long>,
        JpaSpecificationExecutor<PVUEmployeDeptExamDetailsEntity> {

    /**
     * Find PVU employe dept exam details entity bypvu employe entity emp id and active status.
     *
     * @param id           the id
     * @param activeStatus the active status
     * @return the list
     */
    List<PVUEmployeDeptExamDetailsEntity> findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(Long id, int activeStatus);

    /**
     * Update active status by emp dept exam detail id.
     *
     * @param empDeptExamDetailId the emp dept exam detail id
     * @param activeStatus        the active status
     * @param updatedBy           the updated by
     * @param updatedDate         the updated date
     * @return the int
     */
    @Modifying
    @Query(value = "update PVUEmployeDeptExamDetailsEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where empDeptExamDetailId = :empDeptExamDetailId")
    public int updateActiveStatusByEmpDeptExamDetailId(@Param("empDeptExamDetailId") long empDeptExamDetailId, @Param("activeStatus") int activeStatus,
                                                       @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

    /**
     * Update active status by emp dept exam detail id.
     *
     * @param employeeId the employeeId
     *                   //     * @param activeStatus the active status
     * @param notIn      the notIn id
     * @return the int
     */
    @Modifying
    @Query(value = "UPDATE PVUEmployeDeptExamDetailsEntity ent SET ent.activeStatus= :activeStatus  WHERE ent.pvuEmployeEntity.empId= :employeeId AND " +
            " ent.empDeptExamDetailId NOT IN (:notIn) ")
    void updateWithStatusActiveStatusByEmpId(@Param("activeStatus") int activeStatus, @Param("employeeId") long employeeId, @Param("notIn") List<Long> notIn);


}

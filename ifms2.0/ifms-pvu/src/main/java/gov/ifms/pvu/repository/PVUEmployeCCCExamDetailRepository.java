package gov.ifms.pvu.repository;

import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
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
 * The Class PVUEmployeCCCExamDetailController.
 *
 * @version v 1.0
 * @created 2019/11/27 23:30:53
 */

@Repository
@Transactional
public interface PVUEmployeCCCExamDetailRepository extends JpaRepository<PVUEmployeCCCExamDetailEntity, Long>,
        JpaSpecificationExecutor<PVUEmployeCCCExamDetailEntity> {

    /**
     * Find PVU employe CCC exam detail entity bypvu employe entity emp id and active status.
     *
     * @param id           the id
     * @param activeStatus the active status
     * @return the list
     */
    List<PVUEmployeCCCExamDetailEntity> findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(Long id, int activeStatus);

    /**
     * Update active status by emp CCC exam detail id.L̥
     *
     * @param empCCCExamDetailId the emp CCC exam detail id
     * @param activeStatus       the active statusL̥
     * @param updatedBy          the updated by
     * @param updatedDate        the updated date
     * @return the int
     */
    @Modifying
    @Query(value = "update PVUEmployeCCCExamDetailEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where empCCCExamDetailId = :empCCCExamDetailId")
    public int updateActiveStatusByEmpCCCExamDetailId(@Param("empCCCExamDetailId") long empCCCExamDetailId, @Param("activeStatus") int activeStatus,
                                                      @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

    /**
     * Update active status by emp dept exam detail id.
     *
     * @param employeeId   the employeeId
//     * @param activeStatus the active status
     * @param notIn        the notIn id
     * @return the int
     */
    @Modifying
    @Query(value = "UPDATE PVUEmployeCCCExamDetailEntity ent SET ent.activeStatus= :activeStatus  WHERE ent.pvuEmployeEntity.empId= :employeeId AND " +
            " ent.empCCCExamDetailId NOT IN (:notIn) ")
    void updateWithStatusActiveStatusByEmpId(@Param("activeStatus") int activeStatus, @Param("employeeId") long employeeId, @Param("notIn") List<Long> notIn);

    List<PVUEmployeCCCExamDetailEntity> findAllBypvuEmployeEntityEmpId(long empid);

}

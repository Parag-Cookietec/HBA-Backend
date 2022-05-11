package gov.ifms.pvu.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeForgoEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The Class PVUEmployeSuspensionRepository.
 */
@Repository
@Transactional
public interface PVUEmployeSuspensionRepository extends JpaRepository<PVUEmployeSuspensionEntity, Long>,
        JpaSpecificationExecutor<PVUEmployeSuspensionEntity>, GenericDao {

    /**
     * Update status id for PVUEmployeSuspensionEntity.
     *
     * @param statusId the status id
     * @param id       the id
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE PVUEmployeSuspensionEntity AS entity SET entity.status.lookUpInfoId = :statusId WHERE entity.id = :id")
    void updateStatusId(@Param("statusId") long statusId, @Param("id") long id);



    @Modifying
    @Query(value = "update PVUEmployeSuspensionEntity set activeStatus = :activeStatus , updatedBy = :updatedBy , "
            + "updatedDate = :updatedDate where id = :stEventId")
    public int updateActiveStatus(@Param("stEventId") long stEventId, @Param("activeStatus") int activeStatus,
                                  @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

    /**
     * Find with pay details entity by id optional.
     *
     * @param aLong the a long
     * @return the optional
     */
    @EntityGraph(value = "PVUEmployeSuspensionEntity.payDetailsEntity")
    Optional<PVUEmployeSuspensionEntity> findWithPayDetailsEntityById(Long aLong);

    /**
     * Find all by employee emp id and status look up info id and sus start date less than equal and sus end date greater than equal list.
     *
     * @param empId    the emp id
     * @param statusId the status id
     * @param start1   the start 1
     * @param end1     the end 1
     * @return the list
     */
    List<PVUEmployeSuspensionEntity> findAllByEmployeeEmpIdAndStatusLookUpInfoIdAndSusStartDateLessThanEqualAndSusEndDateGreaterThanEqual(long empId, long statusId, LocalDate start1, LocalDate end1);

    /**
     * Find all by employee emp id and status look up info id and sus start date less than equal and sus end date greater than equal and id not list.
     *
     * @param empId    the emp id
     * @param statusId the status id
     * @param start1   the start 1
     * @param end1     the end 1
     * @param id       the id
     * @return the list
     */
    List<PVUEmployeSuspensionEntity> findAllByEmployeeEmpIdAndStatusLookUpInfoIdAndSusStartDateLessThanEqualAndSusEndDateGreaterThanEqualAndIdNotAndPayCommissionLookUpInfoIdAndActiveStatusIs(long empId, long statusId, LocalDate start1, LocalDate end1, long id,long payId,int activeStatus);

    /**
     * Find one by trans no optional.
     *
     * @param trnNo the trn no
     * @return the optional
     */
    Optional<PVUEmployeSuspensionEntity> findOneByTrnNo(String trnNo);

    @Query(value = "SELECT nvl(sum(NO_OF_DAY_IN_SUS),0) FROM PVU.T_PVU_SUS_CRT SUS WHERE EMP_ID=:empId AND ACTIVE_STATUS=1", nativeQuery = true)
    Long getTotalSuspensionDaysByEmpId(@Param("empId") Long empId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE PVUEmployeSuspensionEntity AS entity SET entity.isFinalClosure = :isFinalFlag WHERE entity.id = :id")
    void updateFinalFlag(@Param("isFinalFlag") boolean finalFlag, @Param("id") long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE PVUEmployeSuspensionEntity AS entity SET entity.isFinalEnd = :isFinalFlag WHERE entity.id = :id")
    void updateFinalEndFlag(@Param("isFinalFlag") boolean finalFlag, @Param("id") long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE PVUEmployeSuspensionEntity AS entity SET entity.isCloseSubmit = :isClosureFlag WHERE entity.id = :id")
    void updateClosureSubmittedFlag(@Param("isClosureFlag") boolean finalFlag, @Param("id") long id);
    
    PVUEmployeSuspensionEntity findByTrnNo(@Param("trnNo") String trnNo);
}

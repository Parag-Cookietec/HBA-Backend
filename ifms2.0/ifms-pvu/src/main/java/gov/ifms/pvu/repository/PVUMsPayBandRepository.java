package gov.ifms.pvu.repository;

import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class PVUMsPayBandRepository.
 *
 * @version v 1.0
 * @created 2019/12/23 14:46:10
 */

@Repository
@Transactional
public interface PVUMsPayBandRepository extends JpaRepository<PVUMsPayBandEntity, Long>,
        JpaSpecificationExecutor<PVUMsPayBandEntity> {

    @Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.id,e.payBandDispVal) from PVUMsPayBandEntity e where e.id = :id")
    IdNameDto getOnlyIdAndName(@Param("id") Long id);
    
    @Query(value = "SELECT distinct PAY_BAND_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus AND FIX_PAY_VALUE=:fixPayValue order by PAY_BAND_ID asc ",nativeQuery = true)
    List<Long> getPayBandIdByDepartmentCategoryAndFixPay(Long departmentCategoryId, int activeStatus, Long fixPayValue);
    
    @Query(value = "SELECT distinct PAY_BAND_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus and GRADE_PAY_DISP_VAL between 1300 and 4400 order by PAY_BAND_ID asc ",nativeQuery = true)
    List<Long> getPayBandIdByDepartmentCategory(Long departmentCategoryId, int activeStatus);
    
    List<PVUMsPayBandEntity> findAllByIdIn(List<Long> payBandId,Sort sort);
    
    @Query(value = "SELECT distinct GRADE_PAY_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus AND FIX_PAY_VALUE=:fixPayValue and PAY_BAND_ID=:payBandId order by GRADE_PAY_ID asc  ",nativeQuery = true)
    List<Long> getGradePayIdByDepartmentCategoryAndFixPay(Long departmentCategoryId, int activeStatus, Long fixPayValue,Long payBandId);
    
    @Query(value = "SELECT distinct GRADE_PAY_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus and GRADE_PAY_DISP_VAL between 1300 and 4400 and PAY_BAND_ID=:payBandId order by GRADE_PAY_ID asc ",nativeQuery = true)
    List<Long> getGradePayIdByDepartmentCategory(Long departmentCategoryId, int activeStatus,Long payBandId);
    
    @Query(value = "SELECT distinct PAY_BAND_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus AND FIX_PAY_VALUE=:fixPayValue AND PAY_LVL_ID =:paylvlId order by PAY_BAND_ID asc ",nativeQuery = true)
    List<Long> getPayBandIdByDepartmentCategoryAndFixPayAndPayLevelId(Long departmentCategoryId, int activeStatus, Long fixPayValue,Long paylvlId);
    
    @Query(value = "SELECT distinct PAY_BAND_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus and GRADE_PAY_DISP_VAL between 1300 and 4400  AND PAY_LVL_ID =:paylvlId order by PAY_BAND_ID asc ",nativeQuery = true)
    List<Long> getPayBandIdByDepartmentCategoryAndPayLevelId(Long departmentCategoryId, int activeStatus,Long paylvlId);
    
    
    @Query(value = "SELECT distinct GRADE_PAY_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus AND FIX_PAY_VALUE=:fixPayValue and PAY_BAND_ID=:payBandId AND PAY_LVL_ID =:payLvl  order by GRADE_PAY_ID asc  ",nativeQuery = true)
    List<Long> getGradePayIdByDepartmentCategoryAndFixPayAndPaylvl(Long departmentCategoryId, int activeStatus, Long fixPayValue,Long payBandId,Long payLvl);

    @Query(value = "SELECT distinct GRADE_PAY_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus and GRADE_PAY_DISP_VAL between 1300 and 4400 and PAY_BAND_ID=:payBandId AND PAY_LVL_ID =:payLvl order by GRADE_PAY_ID asc ",nativeQuery = true)
    List<Long> getGradePayIdByDepartmentCategoryAndPaylvl(Long departmentCategoryId, int activeStatus,Long payBandId,Long payLvl);

}

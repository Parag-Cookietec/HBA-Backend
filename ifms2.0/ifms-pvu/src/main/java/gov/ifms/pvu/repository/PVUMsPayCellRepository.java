package gov.ifms.pvu.repository;

import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The Class PVUMsPayCellRepository.
 */
@Repository
@Transactional
public interface PVUMsPayCellRepository
        extends JpaRepository<PVUMsPayCellEntity, Long>, JpaSpecificationExecutor<PVUMsPayCellEntity> {

    /**
     * Find one by pay level id and cell id.
     *
     * @param payLevelId the pay level id
     * @param cellId     the cell id
     * @return the optional
     */
    Optional<PVUMsPayCellEntity> findOneByPayLevelIdAndCellId(Long payLevelId, int cellId);

    /**
     * Find one by pay level id and cell value.
     *
     * @param payLevelId the pay level id
     * @param cellValue  the cell value
     * @return the optional
     */
    Optional<PVUMsPayCellEntity> findOneByPayLevelIdAndCellValue(Long payLevelId, Long cellValue);

    /**
     * Find top 1 by pay level id and cell value greater than equal order by cell
     * value.
     *
     * @param payLevelId   the pay level id
     * @param newCellValue the new cell value
     * @return the optional
     */
    Optional<PVUMsPayCellEntity> findTop1ByPayLevelIdAndCellValueGreaterThanEqualOrderByCellValue(Long payLevelId,
                                                                                                  Long newCellValue);

    /**
     * Find top 1 by pay level id and cell value less than equal order by cell value
     * desc.
     *
     * @param payLevelId the pay level id
     * @param cellValue  the cell value
     * @return the optional
     */
    Optional<PVUMsPayCellEntity> findTop1ByPayLevelIdAndCellValueLessThanEqualOrderByCellValueDesc(Long payLevelId,
                                                                                                   long cellValue);

    /**
     * Find one by pay level id and id.
     *
     * @param payLevelId the pay level id
     * @param cellId     the cell id
     * @return the optional
     */
    Optional<PVUMsPayCellEntity> findOneByPayLevelIdAndId(Long payLevelId, Long cellId);

    /**
     * Gets the id by department category.
     *
     * @param deptId the dept id
     * @return the id by department category
     */
    @Query(value = "SELECT DISTINCT PAY_LVL_ID FROM MASTER_V1.MS_PAY_CONVERSION WHERE DEPT_ID =:deptId AND PAY_LVL_ID IS NOT NULL", nativeQuery = true)
    List<Long> getIdByDepartmentCategory(@Param("deptId") Long deptId);

    /**
     * Find all by pay level id in.
     *
     * @param payCells the pay cells
     * @return the list
     */
    List<PVUMsPayCellEntity> findAllByPayLevelIdIn(List<Long> payCells);

    /**
     * Gets the min cell value by level id.
     *
     * @param levelId the level id
     * @return the min cell value by level id
     */
    @Query(value = "SELECT min(CELL_VALUE) FROM MASTER_V1.MS_PAY_CELL WHERE PAY_LEVEL_ID =:levelId", nativeQuery = true)
    List<Long> getMinCellValueByLevelId(@Param("levelId") Long levelId);

    /**
     * Gets the max cell value by level id.
     *
     * @param levelId the level id
     * @return the max cell value by level id
     */
    @Query(value = "SELECT max(CELL_VALUE) FROM MASTER_V1.MS_PAY_CELL WHERE PAY_LEVEL_ID =:levelId", nativeQuery = true)
    List<Long> getMaxCellValueByLevelId(@Param("levelId") Long levelId);

    Optional<PVUMsPayCellEntity> findTop1ByPayLevelIdAndCellValueGreaterThanEqualOrderByCellValueAsc(Long payLevelId, long cellValue);

    @Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.id, CAST(e.cellId AS string)) from PVUMsPayCellEntity e where e.id = :id")
    IdNameDto getOnlyIdAndName(@Param("id") Long id);
    
    
    @Query(value = "select distinct ms_pay.PAY_LVL_ID from MASTER_V1.MS_PAY_CONVERSION MS_PAY, pvu.T_EMP_EVENTS EMP_event\r\n" + 
		      "  where ms_pay.PAY_LVL_ID = emp_event.EMP_PAY_LEVEL AND MS_PAY.DEPT_ID = :deptId AND EMP_event.EMP_ID = :employeeId\r\n" + 
		       "  AND ms_pay.PAY_LVL_ID IS NOT NULL  AND EMP_event.EVNT_NAME = 'Employee Creation' ", nativeQuery = true)
     List<Long> getIdByDepartmentCategoryEmp(@Param("deptId") Long deptId, @Param("employeeId") Long employeeId );
    
    List<PVUMsPayCellEntity> findAllByPayLevelId(Long payCells);
    
    @Query(value = "SELECT mpl.PAY_LEVEL_ID, mpl.order_no, mpl.PAY_LEVEL_VALUE, mpc.PAY_CELL_ID, mpc.CELL_ID , mpc.CELL_VALUE \r\n" + 
    		"FROM MASTER_V1.MS_PAY_CELL mpc,MASTER_V1.MS_PAY_LEVEL mpl WHERE mpl.PAY_LEVEL_ID IN (:payLevelId) AND mpc.PAY_LEVEL_ID = mpl.PAY_LEVEL_ID",nativeQuery = true)
    List<Object[]> getCellsByLevel(@Param("payLevelId")  List<Long>  payLevelId);

}

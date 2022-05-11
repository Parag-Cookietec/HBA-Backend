package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPTrnPouBrMapEntity;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Interface EDPTrnPouBrMapRepository.
 */
@Repository
@Transactional
public interface EDPTrnPouBrMapRepository extends JpaRepository<EDPTrnPouBrMapEntity,Long> , JpaSpecificationExecutor<EDPTrnPouBrMapEntity>{
	
	/**
	 * Find by edp lk po off user id lk po off user id and active staus.
	 *
	 * @param pouId the pou id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPTrnPouBrMapEntity> findByEdpLkPoOffUserIdLkPoOffUserIdAndActiveStatus(Long pouId, int activeStatus);

	@Query(value = EDPNativeSQLUtil.GET_MAPPED_BRANCH_FOR_POU, nativeQuery = true)
	List<Long> getMappedBranchesForPou(@Param("toPouId")Long toPouId,@Param("fromPouId") Long fromPouId,  @Param("activeStatus")int activeStatus);
	
	@Modifying
	@Query(value = "update EDPTrnPouBrMapEntity set edpLkPoOffUserId.lkPoOffUserId = :pouId, updatedBy=:updatedBy,"
			+ " updatedDate=:updatedDate, updatedByPost = :updatedByPost where trnPouBrMapId in (:brMapId)")
	int updateBrMapEntityById(@Param("pouId")Long pouId, @Param("brMapId")Set<Long> brMapId, @Param("updatedBy") Long updatedBy,
			 @Param("updatedDate") Date updatedDate,  @Param("updatedByPost") Long updatedByPost);

	EDPTrnPouBrMapEntity findByEdpLkPoOffUserIdLkPoOffUserIdAndTrFromPOUIdLkPoOffUserIdAndEdpMsBranchEntityBranchIdAndActiveStatus(Long toPouId, Long fromPouId, Long branchId, int activeStatus);
	
	@Query("Select e.trnPouBrMapId from EDPTrnPouBrMapEntity e where e.trFromPOUId.lkPoOffUserId = :fromPouId and e.edpMsBranchEntity.branchId in (:branchId) and e.activeStatus = :activeStatus")
	Set<Long> findIdByFromPouIdAndBranchId(@Param("fromPouId")Long fromPouId,@Param("branchId") List<Long> branchId,@Param("activeStatus") int activeStatus);

	List<EDPTrnPouBrMapEntity> findByTrFromPOUIdLkPoOffUserIdAndEdpLkPoOffUserIdLkPoOffUserIdAndEdpMsBranchEntityBranchIdInAndActiveStatus(Long fromPouId, Long toPouId, List<Long> branchId, int activeStatus);
}

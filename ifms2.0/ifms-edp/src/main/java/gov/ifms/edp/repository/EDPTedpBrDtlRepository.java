package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPTedpBrDtlEntity;

public interface EDPTedpBrDtlRepository extends JpaRepository<EDPTedpBrDtlEntity, Long>, JpaSpecificationExecutor<EDPTedpBrDtlEntity>, GenericDao {

	Optional<EDPTedpBrDtlEntity> findByFromPouIdLkPoOffUserIdAndToPouIdAndTedpBrHdrIdStatusIdLookUpInfoIdAndActiveStatus(Long fromPouId, Long toPouId, Long statusId, int activeStatus);
	
	List<EDPTedpBrDtlEntity> findByTedpBrHdrIdTedpBrHdrId(Long tedpBrHdrId);
	
	@Modifying
	@Query(value = "update EDPTedpBrDtlEntity set activeStatus = :activeStatus where tedpBrHdrId.tedpBrHdrId = :hdrId and branchId.branchId in (:branchId)")
	public int updateActiveStatusByHdrIdAndBranch(@Param("activeStatus")int activeStatus,@Param("hdrId") Long hdrId,@Param("branchId") List<Long> branchId);

	@Modifying
	@Query(value = "update EDPTedpBrDtlEntity set activeStatus = :activeStatus, updatedBy=:updatedBy, " + 
			"updatedDate=:updatedDate,updatedByPost = :updatedByPost where tedpBrHdrId.tedpBrHdrId = :hdrId")
	public int deactivateByHdrId(@Param("activeStatus")int activeStatus,@Param("hdrId") Long hdrId, @Param("updatedBy") Long updatedBy,
			 @Param("updatedDate") Date updatedDate,  @Param("updatedByPost") Long updatedByPost);

}
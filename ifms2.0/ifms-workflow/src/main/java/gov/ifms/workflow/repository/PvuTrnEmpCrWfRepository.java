package gov.ifms.workflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.workflow.dao.WfSpRepo;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.PvuTrnEmpCrWfEntity;

/**
 * The Class PvuTrnEmpCrWfRepository.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
public interface PvuTrnEmpCrWfRepository
		extends JpaRepository<PvuTrnEmpCrWfEntity, Long>, JpaSpecificationExecutor<PvuTrnEmpCrWfEntity>, WfSpRepo {

	/**
	 * findByTrnIdAndActiveStatus
	 *
	 * @param edpTrnOffId
	 * @param activeStatus
	 * @return
	 */
	Optional<PvuTrnEmpCrWfEntity> findByTrnIdAndActiveStatus(long edpTrnOffId,int activeStatus);

	/**
	 * findReworkActionUPO
	 *
	 * @param trnId
	 * @param menuId
	 * @param nextWfRoleId
	 * @return the list
	 */
	@Query(value = "SELECT new gov.ifms.workflow.dto.WfUserDto(pou.userId.userId, pou.userId.userName , trnPvu.assignByPostId, trnPvu.assignByOfficeId) FROM PvuTrnEmpCrWfEntity trnPvu,EDPLkPoOffUserEntity pou WHERE trnPvu.assignByOfficeId = pou.lkPostOfficeId.officeEntity.officeId AND trnPvu.assignByPostId = pou.lkPostOfficeId.postEntity.postId AND trnPvu.pvuTrnEmpCrWfId = (SELECT MAX(tPvu.pvuTrnEmpCrWfId) FROM PvuTrnEmpCrWfEntity tPvu WHERE tPvu.trnId = :trnId AND tPvu.menuId = :menuId AND tPvu.assignByWfRoleId = :nextWfRoleId)")
	List<WfUserDto> findReworkActionUPO(@Param("trnId") long trnId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId);
}

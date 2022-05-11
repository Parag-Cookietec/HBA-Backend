package gov.ifms.workflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.workflow.dao.WfSpRepo;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.EdpTrnOffModWfEntity;

/**
 * The Class EdpTrnOffModWfRepository.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
public interface EdpTrnOffModWfRepository
		extends JpaRepository<EdpTrnOffModWfEntity, Long>, JpaSpecificationExecutor<EdpTrnOffModWfEntity>, WfSpRepo {
	/**
	 * Find By EdpTrnOffId And ActiveStatus
	 *
	 * @param edpTrnOffId
	 * @param activeStatus
	 * @return the entity
	 */
	Optional<EdpTrnOffModWfEntity> findByEdpTrnOffIdAndActiveStatus(long edpTrnOffId,int activeStatus);

	/**
	 * Find ActiveTrn By UPO
	 *
	 * @param edpTrnOffId
	 * @param activeStatus
	 * @param assignedToUserId
	 * @param assignedToPostId
	 * @param assignedToOfficeId
	 * @param wfRoleIds
	 * @param menuId
	 * @return the list
	 */
	@Query(value = "SELECT new gov.ifms.workflow.dto.WfUserDto(trnEdp.assignedByUserId, (SELECT u.userName from EDPMsUserEntity u WHERE u.userId=trnEdp.assignedByUserId), trnEdp.assignedByPostId, trnEdp.assignedByOfficeId) FROM EdpTrnOffModWfEntity trnEdp WHERE trnEdp.edpTrnOffId = :edpTrnOffId AND trnEdp.activeStatus = :activeStatus AND trnEdp.assignedToUserId = :assignedToUserId AND trnEdp.assignedToPostId = :assignedToPostId AND trnEdp.assignedToOfficeId = :assignedToOfficeId AND trnEdp.assignedToWfRoleId in (:wfRoleIds) AND trnEdp.menuId = :menuId")
	List<WfUserDto> findActiveTrnByUPO(@Param("edpTrnOffId") long edpTrnOffId,@Param("activeStatus") int activeStatus, @Param("assignedToUserId") long assignedToUserId,@Param("assignedToPostId") long assignedToPostId,@Param("assignedToOfficeId") long assignedToOfficeId,@Param("wfRoleIds") List<Long> wfRoleIds, @Param("menuId") long menuId);
}

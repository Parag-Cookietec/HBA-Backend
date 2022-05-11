package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPUsrPoTrnsAttEntity;

/**
 * The Interface EDPUsrPoTrnsAttRepository.
 */
@Repository
@Transactional
public interface EDPUsrPoTrnsAttRepository
		extends JpaRepository<EDPUsrPoTrnsAttEntity, Long>, JpaSpecificationExecutor<EDPUsrPoTrnsAttEntity> {

	/**
	 * Find all by edp usr po tran att id and edp usr po trns headr id edp usr po trns header id and active status.
	 *
	 * @param attachmentId the attachment id
	 * @param edpUsrPoTrnsHeadrId the edp usr po trns headr id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPUsrPoTrnsAttEntity> findAllByEdpUsrPoTranAttIdAndEdpUsrPoTrnsHeadrIdEdpUsrPoTrnsHeaderIdAndActiveStatus(
			Long attachmentId, Long edpUsrPoTrnsHeadrId, int activeStatus);

	/**
	 * Find all by edp usr po trns headr id edp usr po trns header id and active status.
	 *
	 * @param edpUsrPoTrnsHearerId the edp usr po trns hearer id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPUsrPoTrnsAttEntity> findAllByEdpUsrPoTrnsHeadrIdEdpUsrPoTrnsHeaderIdAndActiveStatus(
			Long edpUsrPoTrnsHearerId, int activeStatus);
	
}

package gov.ifms.edp.oauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.oauth.entity.OAuthMsUserSessionsEntity;

/**
 * The Interface OAuthMsUserSessionsRepository.
 *
 * @author db2admin
 */
@Repository
@Transactional
public interface OAuthMsUserSessionsRepository
		extends JpaRepository<OAuthMsUserSessionsEntity, Long>, JpaSpecificationExecutor<OAuthMsUserSessionsEntity> {

	/**
	 * Find by session id.
	 *
	 * @param sessionId the session id
	 * @return the o auth ms user sessions entity
	 */
	Optional<OAuthMsUserSessionsEntity> findBySessionId(String sessionId);

	/**
	 * Count by session id and active status.
	 *
	 * @param sessionId  the session id
	 * @param activeCode the active code
	 * @return the long
	 */
	int countBySessionIdAndActiveStatus(String sessionId, int activeCode);
}

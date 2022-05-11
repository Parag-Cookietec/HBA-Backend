package gov.ifms.edp.oauth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.oauth.entity.OAuthLkPostUserRoleMenuModule;

/**
 * The Interface OAuthLkPostUserRoleMenuEndpointsRepository.
 */
@Repository
@Transactional
public interface OAuthLkPostUserRoleMenuEndpointsRepository
		extends JpaRepository<OAuthLkPostUserRoleMenuModule, Long>, JpaSpecificationExecutor<OAuthLkPostUserRoleMenuModule> {
	
	/**
	 * Find by edp ms users user id.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	List<OAuthLkPostUserRoleMenuModule> findByEdpMsUsersUserId(Long userId);
	
}

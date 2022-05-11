package gov.ifms.edp.oauth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.oauth.entity.OAuthMsUserEndpointsEntity;

/**
 * The Interface OAuthMsUserEndpointsRepository.
 *
 * @author db2admin
 */
@Repository
@Transactional
public interface OAuthMsUserEndpointsRepository
		extends JpaRepository<OAuthMsUserEndpointsEntity, Long>, JpaSpecificationExecutor<OAuthMsUserEndpointsEntity> {

	/**
	 * Find by edp ms module entity module ID in.
	 *
	 * @param activeStatus the active status
	 * @param ids the ids
	 * @return the list
	 */
	List<OAuthMsUserEndpointsEntity> findByActiveStatusAndMenuId(int activeStatus, Long ids);
	
	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<OAuthMsUserEndpointsEntity> findByActiveStatus(int activeStatus);
	
}

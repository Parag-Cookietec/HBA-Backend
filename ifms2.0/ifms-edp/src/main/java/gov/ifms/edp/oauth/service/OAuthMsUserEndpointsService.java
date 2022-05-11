package gov.ifms.edp.oauth.service;

import java.util.List;

import gov.ifms.edp.oauth.entity.OAuthMsUserEndpointsEntity;

/**
 * The Interface OAuthMsUserEndpointsService.
 */
public interface OAuthMsUserEndpointsService {

	/**
	 * Gets the all endpoints.
	 *
	 * @return the all endpoints
	 */
	List<OAuthMsUserEndpointsEntity> getAllEndpoints();

	/**
	 * Gets the endpoints by module id.
	 *
	 * @param idList the id list
	 * @return the endpoints by module id
	 */
	List<OAuthMsUserEndpointsEntity> getEndpointsByMenuId(Long idList);
}

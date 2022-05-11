package gov.ifms.edp.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.edp.oauth.entity.OAuthMsUserEndpointsEntity;
import gov.ifms.edp.oauth.repository.OAuthMsUserEndpointsRepository;
import gov.ifms.edp.oauth.util.OAuthConstant;

/**
 * The Class OAuthMsUserEndpointsServiceImpl.
 */
@Service
public class OAuthMsUserEndpointsServiceImpl implements OAuthMsUserEndpointsService {

	/** The oauth ms user endpoints repository. */
	@Autowired
	private OAuthMsUserEndpointsRepository oauthMsUserEndpointsRepository;

	/**
	 * Returns all EndPoint of the OAuthMsUserEndpointsEntity type.
	 * 
	 * @return all OAuthMsUserEndpointsEntity
	 */
	@Override
	public List<OAuthMsUserEndpointsEntity> getAllEndpoints() {
		return oauthMsUserEndpointsRepository.findAll();
	}

	/**
	 * Gets the endpoints by module id.
	 *
	 * @param idList the id list
	 * @return the endpoints by module id
	 */
	@Override
	public List<OAuthMsUserEndpointsEntity> getEndpointsByMenuId(Long idList) {
		return oauthMsUserEndpointsRepository.findByActiveStatusAndMenuId(OAuthConstant.ACTIVE_STATUS, idList);
	}

}

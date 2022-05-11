package gov.ifms.doi.jpa.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.converter.DoiJPAMasterPolicyConverter;
import gov.ifms.doi.jpa.dto.DoiJPASchemePolicyDTO;
import gov.ifms.doi.jpa.entity.DoiJPASchemeMaster;
import gov.ifms.doi.jpa.repository.DoiJPASchemeMasterRepository;
import gov.ifms.doi.jpa.service.ConfigService;
import gov.ifms.doi.jpa.service.DoiJPAMasterPolicyService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private DoiJPASchemeMasterRepository jpaRepository;

	@Autowired
	private DoiJPAMasterPolicyService doiJPAMasterPolicyService;

	@Autowired
	DoiJPAMasterPolicyConverter converter;

	@Autowired
	EntityManager em;

	/**
	 * 
	 */
	@Override
	public List<DoiJPASchemePolicyDTO> getSchemePolicyList() {
		List<DoiJPASchemeMaster> schemeList = jpaRepository.findAllActive();
		List<DoiJPASchemePolicyDTO> responseList = new ArrayList<>();
		for (DoiJPASchemeMaster scheme : schemeList) {
			DoiJPASchemePolicyDTO response = new DoiJPASchemePolicyDTO();
			response.setSchemeId(scheme.getSchemeId());
			response.setSchemeNameEnglish(scheme.getSchemeName());
			response.setSchemeNameGujrati(scheme.getSchemeNameGuj());
			response.setSchemeShortName(scheme.getSchemeShortname());
			response.setNodelOfficeName(scheme.getNodalOffice());
			response.setNodelOfficeId(scheme.getNodelOfficeId());
			response.setClaimAmount(scheme.getClaimAmount());
			response.setRemarks(scheme.getRemarks());
			response.setSchemeStatusId(scheme.getSchemeStatusId());
			response.setSchemeStatus(scheme.getStatus());
			response.setReferenceNo(scheme.getReferenceNo());
			response.setReferenceDate(scheme.getReferenceDate());
			response.setPolicies(doiJPAMasterPolicyService.findBySchemeId(scheme.getSchemeId()));
			responseList.add(response);
		}
		return responseList;
	}
}

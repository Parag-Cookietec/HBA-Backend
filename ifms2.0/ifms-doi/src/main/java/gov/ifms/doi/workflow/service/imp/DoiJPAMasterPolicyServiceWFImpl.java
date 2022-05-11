package gov.ifms.doi.workflow.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.workflow.converter.DoiJPAMasterPolicyWFConverter;
import gov.ifms.doi.workflow.dto.DoiJpaMasterPolicyWFDTO;
import gov.ifms.doi.workflow.repository.DoiJPAMasterPolicyWFRepository;
import gov.ifms.doi.workflow.service.DoiJPAMasterPolicyWFService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class DoiJPAMasterPolicyServiceWFImpl implements DoiJPAMasterPolicyWFService {

	@Autowired
	private DoiJPAMasterPolicyWFRepository doiJPAMasterPolicyRepository;
	@Autowired
	DoiJPAMasterPolicyWFConverter converter;

	/**
	 * Convert given DoiJpaMasterPolicyDTO to DoiJPAMasterPolicy Saves a given
	 * DoiJPAMasterPolicy. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPAMasterPolicy
	 */
	@Override
	public List<DoiJpaMasterPolicyWFDTO> saveOrUpdate(DoiJpaMasterPolicyWFDTO dto) {
		doiJPAMasterPolicyRepository.save(converter.toEntity(dto));
		return this.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<DoiJpaMasterPolicyWFDTO> findAll() {
		return converter.toDTO(doiJPAMasterPolicyRepository.findAll());
	}

	/*
	 * @Override public List<DoiJPAMasterPolicyWF> findBySchemeId(Long schemeId) {
	 * return doiJPAMasterPolicyRepository.findBySchemeId(schemeId); }
	 */
}

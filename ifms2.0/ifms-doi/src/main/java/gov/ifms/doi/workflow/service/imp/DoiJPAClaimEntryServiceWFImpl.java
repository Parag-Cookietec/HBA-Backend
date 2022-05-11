package gov.ifms.doi.workflow.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.workflow.converter.DoiJPAClaimEntryWFConverter;
import gov.ifms.doi.workflow.dto.DoiJpaClaimEntryWFDTO;
import gov.ifms.doi.workflow.repository.DoiJPAclaimEntryWFRepository;
import gov.ifms.doi.workflow.service.DoiJPAClaimEntryWFService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class DoiJPAClaimEntryServiceWFImpl implements DoiJPAClaimEntryWFService {

	@Autowired
	private DoiJPAclaimEntryWFRepository doiJPAclaimEntryWFRepository;
	@Autowired
	DoiJPAClaimEntryWFConverter converter;

	/**
	 * Convert given DoiJpaMasterPolicyDTO to DoiJPAMasterPolicy Saves a given
	 * DoiJPAMasterPolicy. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPAMasterPolicy
	 */
	@Override
	public List<DoiJpaClaimEntryWFDTO> saveOrUpdate(DoiJpaClaimEntryWFDTO dto) {
		doiJPAclaimEntryWFRepository.save(converter.toEntity(dto));
		return this.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<DoiJpaClaimEntryWFDTO> findAll() {
		return converter.toDTO(doiJPAclaimEntryWFRepository.findAll());
	}

	/*
	 * @Override public List<DoiJPAMasterPolicyWF> findBySchemeId(Long schemeId) {
	 * return doiJPAMasterPolicyRepository.findBySchemeId(schemeId); }
	 */
}

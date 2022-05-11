package gov.ifms.doi.workflow.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.coinsurance.repository.DoiCoinsClaimRepository;
import gov.ifms.doi.workflow.converter.DoiCoinsClaimEntryWFConverter;
import gov.ifms.doi.workflow.dto.DoiCoinsClaimHdrWfDTO;
import gov.ifms.doi.workflow.entity.DoiCoinsClaimHdrWfEntity;
import gov.ifms.doi.workflow.repository.DoiCoinsClaimEntryWFRepository;
import gov.ifms.doi.workflow.service.DoiCoinsClaimEntryWFService;

/**
 * 
 * @author Rudra
 *
 */
@Service
public class DoiCoinsClaimEntryServiceWFImpl implements DoiCoinsClaimEntryWFService {

	@Autowired
	private DoiCoinsClaimEntryWFRepository doiCoinsClaimEntryWFRepository;
	
	@Autowired
	private DoiCoinsClaimRepository doiCoinsClaimRepository;
	
	@Autowired
	DoiCoinsClaimEntryWFConverter converter;

	/**
	 * Convert given DoiCoinsClaimHdrWfDTO to DoiCoinsClaimHdrWfEntity Saves a given
	 * DoiJPAMasterPolicy. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiCoinsClaimHdrWfEntity
	 */
	@Override
	public List<DoiCoinsClaimHdrWfDTO> saveOrUpdate(DoiCoinsClaimHdrWfDTO dto) {
		DoiCoinsClaimHdrWfEntity entity = converter.toEntity(dto);
		entity.setDoiCoinsClaimHdrEntity(doiCoinsClaimRepository.findByCoinsClaimId(dto.getCoinsClaimId()));
		doiCoinsClaimEntryWFRepository.save(entity);
		return this.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<DoiCoinsClaimHdrWfDTO> findAll() {
		return converter.toDTO(doiCoinsClaimEntryWFRepository.findAll());
	}

	
}

package gov.ifms.doi.workflow.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.legalentry.repository.DOIJPALegalDetailsEntryRepository;
import gov.ifms.doi.workflow.converter.DoiJPALegalEntryWFConverter;
import gov.ifms.doi.workflow.dto.DOIJpaLegalEntryWFDTO;
import gov.ifms.doi.workflow.entity.DOIJpaLegalEntryWFEntity;
import gov.ifms.doi.workflow.repository.DoiJPALegalEntryWFRepository;
import gov.ifms.doi.workflow.service.DoiJPALegalEntryWFService;

/**
 * 
 * @author Rudra
 *
 */
@Service
public class DoiJPALegalEntryServiceWFImpl implements DoiJPALegalEntryWFService {

	@Autowired
	private DoiJPALegalEntryWFRepository doiJPALegalEntryWFRepository;
	
	@Autowired
	private DOIJPALegalDetailsEntryRepository jpaLegalEntryRepo;
	
	@Autowired
	DoiJPALegalEntryWFConverter converter;

	/**
	 * Convert given DOIJpaLegalEntryWFDTO to DOIJpaLegalEntryWFEntity Saves a given
	 * DoiJPAMasterPolicy. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DOIJpaLegalEntryWFEntity
	 */
	@Override
	public List<DOIJpaLegalEntryWFDTO> saveOrUpdate(DOIJpaLegalEntryWFDTO dto) {
		DOIJpaLegalEntryWFEntity entity = converter.toEntity(dto);
		entity.setDoiJpaLegalEntry(jpaLegalEntryRepo.findByLegalEntryId(dto.getLegalEntryId()));
		doiJPALegalEntryWFRepository.save(entity);
		return this.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<DOIJpaLegalEntryWFDTO> findAll() {
		return converter.toDTO(doiJPALegalEntryWFRepository.findAll());
	}

}

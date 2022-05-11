package gov.ifms.doi.workflow.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.coinsurance.repository.DoiCoinsPolicyRepository;
import gov.ifms.doi.workflow.converter.DoiCoinsPolicyEntryWFConverter;
import gov.ifms.doi.workflow.dto.DoiCoinsPolicyHdrWfDTO;
import gov.ifms.doi.workflow.entity.DoiCoinsPolicyHdrWfEntity;
import gov.ifms.doi.workflow.repository.DoiCoinsPolicyEntryWFRepository;
import gov.ifms.doi.workflow.service.DoiCoinsPolicyEntryWFService;

/**
 * 
 * @author Rudra
 *
 */
@Service
public class DoiCoinsPolicyEntryServiceWFImpl implements DoiCoinsPolicyEntryWFService {

	@Autowired
	private DoiCoinsPolicyEntryWFRepository doiCoinsPolicyEntryWFRepository;
	
	@Autowired
	private DoiCoinsPolicyRepository coinsPolicyRepository;
	
	@Autowired
	DoiCoinsPolicyEntryWFConverter converter;

	/**
	 * Convert given DoiCoinsPolicyHdrWfDTO to DoiCoinsPolicyHdrWfEntity Saves a given
	 * DoiJPAMasterPolicy. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiCoinsPolicyHdrWfEntity
	 */
	@Override
	public List<DoiCoinsPolicyHdrWfDTO> saveOrUpdate(DoiCoinsPolicyHdrWfDTO dto) {
		DoiCoinsPolicyHdrWfEntity entity = converter.toEntity(dto);
		entity.setDoiCoinsPolicyHdrEntity(coinsPolicyRepository.findByCoinsPolicyHdrId(dto.getCoinsPolicyHdrId()));
		doiCoinsPolicyEntryWFRepository.save(entity);
		return this.findAll();
	}

	/**
	 * 
	 */
	@Override
	public List<DoiCoinsPolicyHdrWfDTO> findAll() {
		return converter.toDTO(doiCoinsPolicyEntryWFRepository.findAll());
	}

}

package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslAviationConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslAviationDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslAviationRepository;
import gov.ifms.doi.db.service.TdoiDbPropslAviationService;

@Service
public class TdoiDbPropslAviationServiceImpl implements TdoiDbPropslAviationService {

	@Autowired
	TdoiDbPropslAviationRepository repository;

	@Autowired
	TdoiDbPropslAviationConverter converter;

	@Override
	public List<TdoiDbPropslAviationDTO> saveOrUpdate(TdoiDbPropslAviationDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslAviationDTO> findAllByCriteria(TdoiDbPropslAviationDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslAviationDTO> findAllByStatus(TdoiDbPropslAviationDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslAviationDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


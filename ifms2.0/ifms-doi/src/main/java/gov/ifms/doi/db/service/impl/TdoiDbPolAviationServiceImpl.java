package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolAviationConverter;
import gov.ifms.doi.db.dto.TdoiDbPolAviationDTO;
import gov.ifms.doi.db.repository.TdoiDbPolAviationRepository;
import gov.ifms.doi.db.service.TdoiDbPolAviationService;

@Service
public class TdoiDbPolAviationServiceImpl implements TdoiDbPolAviationService {

	@Autowired
	TdoiDbPolAviationRepository repository;

	@Autowired
	TdoiDbPolAviationConverter converter;

	@Override
	public List<TdoiDbPolAviationDTO> saveOrUpdate(TdoiDbPolAviationDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolAviationDTO> findAllByCriteria(TdoiDbPolAviationDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolAviationDTO> findAllByStatus(TdoiDbPolAviationDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolAviationDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}

	@Override
	public TdoiDbPolAviationDTO addAviationPolicy(TdoiDbPolAviationDTO dto) {
		repository.save(converter.toEntity(dto));
		return dto;
	}


}


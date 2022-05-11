package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslBurglaryConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslBurglaryDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslBurglaryRepository;
import gov.ifms.doi.db.service.TdoiDbPropslBurglaryService;

@Service
public class TdoiDbPropslBurglaryServiceImpl implements TdoiDbPropslBurglaryService {

	@Autowired
	TdoiDbPropslBurglaryRepository repository;

	@Autowired
	TdoiDbPropslBurglaryConverter converter;

	@Override
	public List<TdoiDbPropslBurglaryDTO> saveOrUpdate(TdoiDbPropslBurglaryDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslBurglaryDTO> findAllByCriteria(TdoiDbPropslBurglaryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslBurglaryDTO> findAllByStatus(TdoiDbPropslBurglaryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslBurglaryDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolBurglaryConverter;
import gov.ifms.doi.db.dto.TdoiDbPolBurglaryDTO;
import gov.ifms.doi.db.repository.TdoiDbPolBurglaryRepository;
import gov.ifms.doi.db.service.TdoiDbPolBurglaryService;

@Service
public class TdoiDbPolBurglaryServiceImpl implements TdoiDbPolBurglaryService {

	@Autowired
	TdoiDbPolBurglaryRepository repository;

	@Autowired
	TdoiDbPolBurglaryConverter converter;

	@Override
	public List<TdoiDbPolBurglaryDTO> saveOrUpdate(TdoiDbPolBurglaryDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolBurglaryDTO> findAllByCriteria(TdoiDbPolBurglaryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolBurglaryDTO> findAllByStatus(TdoiDbPolBurglaryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolBurglaryDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


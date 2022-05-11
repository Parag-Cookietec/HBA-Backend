package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolBurglaryWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPolBurglaryWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPolBurglaryWfRepository;
import gov.ifms.doi.db.service.TdoiDbPolBurglaryWfService;

@Service
public class TdoiDbPolBurglaryWfServiceImpl implements TdoiDbPolBurglaryWfService {

	@Autowired
	TdoiDbPolBurglaryWfRepository repository;

	@Autowired
	TdoiDbPolBurglaryWfConverter converter;

	@Override
	public List<TdoiDbPolBurglaryWfDTO> saveOrUpdate(TdoiDbPolBurglaryWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolBurglaryWfDTO> findAllByCriteria(TdoiDbPolBurglaryWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolBurglaryWfDTO> findAllByStatus(TdoiDbPolBurglaryWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolBurglaryWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


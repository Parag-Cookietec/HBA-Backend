package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslBurglaryWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslBurglaryWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslBurglaryWfRepository;
import gov.ifms.doi.db.service.TdoiDbPropslBurglaryWfService;

@Service
public class TdoiDbPropslBurglaryWfServiceImpl implements TdoiDbPropslBurglaryWfService {

	@Autowired
	TdoiDbPropslBurglaryWfRepository repository;

	@Autowired
	TdoiDbPropslBurglaryWfConverter converter;

	@Override
	public List<TdoiDbPropslBurglaryWfDTO> saveOrUpdate(TdoiDbPropslBurglaryWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslBurglaryWfDTO> findAllByCriteria(TdoiDbPropslBurglaryWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslBurglaryWfDTO> findAllByStatus(TdoiDbPropslBurglaryWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslBurglaryWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


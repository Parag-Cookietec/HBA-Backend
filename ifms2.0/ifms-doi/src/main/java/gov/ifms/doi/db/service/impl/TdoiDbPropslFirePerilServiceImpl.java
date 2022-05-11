package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslFirePerilConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslFirePerilDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslFirePerilRepository;
import gov.ifms.doi.db.service.TdoiDbPropslFirePerilService;

@Service
public class TdoiDbPropslFirePerilServiceImpl implements TdoiDbPropslFirePerilService {

	@Autowired
	TdoiDbPropslFirePerilRepository repository;

	@Autowired
	TdoiDbPropslFirePerilConverter converter;

	@Override
	public List<TdoiDbPropslFirePerilDTO> saveOrUpdate(TdoiDbPropslFirePerilDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslFirePerilDTO> findAllByCriteria(TdoiDbPropslFirePerilDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslFirePerilDTO> findAllByStatus(TdoiDbPropslFirePerilDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslFirePerilDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


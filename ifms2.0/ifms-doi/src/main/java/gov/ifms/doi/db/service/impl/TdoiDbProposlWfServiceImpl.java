package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbProposlWfConverter;
import gov.ifms.doi.db.dto.TdoiDbProposlWfDTO;
import gov.ifms.doi.db.repository.TdoiDbProposlWfRepository;
import gov.ifms.doi.db.service.TdoiDbProposlWfService;

@Service
public class TdoiDbProposlWfServiceImpl implements TdoiDbProposlWfService {

	@Autowired
	TdoiDbProposlWfRepository repository;

	@Autowired
	TdoiDbProposlWfConverter converter;

	@Override
	public List<TdoiDbProposlWfDTO> saveOrUpdate(TdoiDbProposlWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbProposlWfDTO> findAllByCriteria(TdoiDbProposlWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbProposlWfDTO> findAllByStatus(TdoiDbProposlWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbProposlWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


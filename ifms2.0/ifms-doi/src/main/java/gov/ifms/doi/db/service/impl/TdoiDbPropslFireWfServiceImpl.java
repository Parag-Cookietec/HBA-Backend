package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslFireWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslFireWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslFireWfRepository;
import gov.ifms.doi.db.service.TdoiDbPropslFireWfService;

@Service
public class TdoiDbPropslFireWfServiceImpl implements TdoiDbPropslFireWfService {

	@Autowired
	TdoiDbPropslFireWfRepository repository;

	@Autowired
	TdoiDbPropslFireWfConverter converter;

	@Override
	public List<TdoiDbPropslFireWfDTO> saveOrUpdate(TdoiDbPropslFireWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslFireWfDTO> findAllByCriteria(TdoiDbPropslFireWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslFireWfDTO> findAllByStatus(TdoiDbPropslFireWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslFireWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


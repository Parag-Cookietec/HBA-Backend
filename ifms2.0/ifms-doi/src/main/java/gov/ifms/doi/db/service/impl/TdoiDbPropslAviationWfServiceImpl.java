package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslAviationWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslAviationWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslAviationWfRepository;
import gov.ifms.doi.db.service.TdoiDbPropslAviationWfService;

@Service
public class TdoiDbPropslAviationWfServiceImpl implements TdoiDbPropslAviationWfService {

	@Autowired
	TdoiDbPropslAviationWfRepository repository;

	@Autowired
	TdoiDbPropslAviationWfConverter converter;

	@Override
	public List<TdoiDbPropslAviationWfDTO> saveOrUpdate(TdoiDbPropslAviationWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslAviationWfDTO> findAllByCriteria(TdoiDbPropslAviationWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslAviationWfDTO> findAllByStatus(TdoiDbPropslAviationWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslAviationWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


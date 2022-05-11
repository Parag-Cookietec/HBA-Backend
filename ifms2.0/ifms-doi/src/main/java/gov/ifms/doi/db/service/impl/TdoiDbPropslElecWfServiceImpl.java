package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslElecWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslElecWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslElecWfRepository;
import gov.ifms.doi.db.service.TdoiDbPropslElecWfService;

@Service
public class TdoiDbPropslElecWfServiceImpl implements TdoiDbPropslElecWfService {

	@Autowired
	TdoiDbPropslElecWfRepository repository;

	@Autowired
	TdoiDbPropslElecWfConverter converter;

	@Override
	public List<TdoiDbPropslElecWfDTO> saveOrUpdate(TdoiDbPropslElecWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslElecWfDTO> findAllByCriteria(TdoiDbPropslElecWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslElecWfDTO> findAllByStatus(TdoiDbPropslElecWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslElecWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


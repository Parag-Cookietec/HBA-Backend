package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbFireSumInsuredConverter;
import gov.ifms.doi.db.dto.TdoiDbFireSumInsuredDTO;
import gov.ifms.doi.db.repository.TdoiDbFireSumInsuredRepository;
import gov.ifms.doi.db.service.TdoiDbFireSumInsuredService;

@Service
public class TdoiDbFireSumInsuredServiceImpl implements TdoiDbFireSumInsuredService {

	@Autowired
	TdoiDbFireSumInsuredRepository repository;

	@Autowired
	TdoiDbFireSumInsuredConverter converter;

	@Override
	public List<TdoiDbFireSumInsuredDTO> saveOrUpdate(TdoiDbFireSumInsuredDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbFireSumInsuredDTO> findAllByCriteria(TdoiDbFireSumInsuredDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbFireSumInsuredDTO> findAllByStatus(TdoiDbFireSumInsuredDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbFireSumInsuredDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


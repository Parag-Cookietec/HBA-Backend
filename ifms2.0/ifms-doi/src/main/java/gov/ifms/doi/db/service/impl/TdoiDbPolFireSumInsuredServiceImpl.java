package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolFireSumInsuredConverter;
import gov.ifms.doi.db.dto.TdoiDbPolFireSumInsuredDTO;
import gov.ifms.doi.db.repository.TdoiDbPolFireSumInsuredRepository;
import gov.ifms.doi.db.service.TdoiDbPolFireSumInsuredService;

@Service
public class TdoiDbPolFireSumInsuredServiceImpl implements TdoiDbPolFireSumInsuredService {

	@Autowired
	TdoiDbPolFireSumInsuredRepository repository;

	@Autowired
	TdoiDbPolFireSumInsuredConverter converter;

	@Override
	public List<TdoiDbPolFireSumInsuredDTO> saveOrUpdate(TdoiDbPolFireSumInsuredDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolFireSumInsuredDTO> findAllByCriteria(TdoiDbPolFireSumInsuredDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolFireSumInsuredDTO> findAllByStatus(TdoiDbPolFireSumInsuredDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolFireSumInsuredDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


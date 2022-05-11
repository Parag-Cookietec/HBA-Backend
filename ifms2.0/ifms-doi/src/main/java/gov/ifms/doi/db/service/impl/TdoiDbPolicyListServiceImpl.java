package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolicyListConverter;
import gov.ifms.doi.db.dto.TdoiDbPolicyListDTO;
import gov.ifms.doi.db.repository.TdoiDbPolicyListRepository;
import gov.ifms.doi.db.service.TdoiDbPolicyListService;

@Service
public class TdoiDbPolicyListServiceImpl implements TdoiDbPolicyListService {

	@Autowired
	TdoiDbPolicyListRepository repository;

	@Autowired
	TdoiDbPolicyListConverter converter;

	@Override
	public List<TdoiDbPolicyListDTO> saveOrUpdate(TdoiDbPolicyListDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolicyListDTO> findAllByCriteria(TdoiDbPolicyListDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolicyListDTO> findAllByStatus(TdoiDbPolicyListDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolicyListDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}

	@Override
	public List<TdoiDbPolicyListDTO> findAll() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


}


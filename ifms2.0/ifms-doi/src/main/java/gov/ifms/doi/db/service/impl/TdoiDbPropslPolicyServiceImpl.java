package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslPolicyConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslPolicyDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslPolicyRepository;
import gov.ifms.doi.db.service.TdoiDbPropslPolicyService;

@Service
public class TdoiDbPropslPolicyServiceImpl implements TdoiDbPropslPolicyService {

	@Autowired
	TdoiDbPropslPolicyRepository repository;

	@Autowired
	TdoiDbPropslPolicyConverter converter;

	@Override
	public List<TdoiDbPropslPolicyDTO> saveOrUpdate(TdoiDbPropslPolicyDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslPolicyDTO> findAllByCriteria(TdoiDbPropslPolicyDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslPolicyDTO> findAllByStatus(TdoiDbPropslPolicyDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslPolicyDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


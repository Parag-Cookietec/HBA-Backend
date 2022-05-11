package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbFirePastPolicyConverter;
import gov.ifms.doi.db.dto.TdoiDbFirePastPolicyDTO;
import gov.ifms.doi.db.repository.TdoiDbFirePastPolicyRepository;
import gov.ifms.doi.db.service.TdoiDbFirePastPolicyService;

@Service
public class TdoiDbFirePastPolicyServiceImpl implements TdoiDbFirePastPolicyService {

	@Autowired
	TdoiDbFirePastPolicyRepository repository;

	@Autowired
	TdoiDbFirePastPolicyConverter converter;

	@Override
	public List<TdoiDbFirePastPolicyDTO> saveOrUpdate(TdoiDbFirePastPolicyDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbFirePastPolicyDTO> findAllByCriteria(TdoiDbFirePastPolicyDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbFirePastPolicyDTO> findAllByStatus(TdoiDbFirePastPolicyDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbFirePastPolicyDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


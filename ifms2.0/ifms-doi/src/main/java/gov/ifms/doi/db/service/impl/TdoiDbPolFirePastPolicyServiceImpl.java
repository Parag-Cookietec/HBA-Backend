package gov.ifms.doi.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolFirePastPolicyConverter;
import gov.ifms.doi.db.dto.TdoiDbPolFirePastPolicyDTO;
import gov.ifms.doi.db.entity.TdoiDbPolFirePastPolicyEntity;
import gov.ifms.doi.db.repository.TdoiDbPolFirePastPolicyRepository;
import gov.ifms.doi.db.service.TdoiDbPolFirePastPolicyService;

@Service
public class TdoiDbPolFirePastPolicyServiceImpl implements TdoiDbPolFirePastPolicyService {

	@Autowired
	TdoiDbPolFirePastPolicyRepository repository;

	@Autowired
	TdoiDbPolFirePastPolicyConverter converter;

	@Override
	public TdoiDbPolFirePastPolicyDTO saveOrUpdate(TdoiDbPolFirePastPolicyDTO dto) {
		TdoiDbPolFirePastPolicyEntity entity = repository.save(converter.toEntity(dto));
		return converter.toDtoFromEntity(entity);
	}


	@Override
	public List<TdoiDbPolFirePastPolicyDTO> findAllByCriteria() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolFirePastPolicyDTO> findAllByStatus() {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public TdoiDbPolFirePastPolicyDTO softDeleteById(Long id) {
		TdoiDbPolFirePastPolicyEntity tdoiDbPolFirePastPolicyEntity  =  repository.findBypastPolicyId(id);
		if(tdoiDbPolFirePastPolicyEntity!= null )
		{
		repository.softDeleteById(id);
		}
		return converter.toDtoFromEntity(tdoiDbPolFirePastPolicyEntity);
		
	}


}


package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbClaimPropDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbClaimPropDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbClaimPropDtlRepository;
import gov.ifms.doi.db.service.TdoiDbClaimPropDtlService;

@Service
public class TdoiDbClaimPropDtlServiceImpl implements TdoiDbClaimPropDtlService {

	@Autowired
	TdoiDbClaimPropDtlRepository repository;

	@Autowired
	TdoiDbClaimPropDtlConverter converter;

	@Override
	public List<TdoiDbClaimPropDtlDTO> saveOrUpdate(TdoiDbClaimPropDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbClaimPropDtlDTO> findAllByCriteria(TdoiDbClaimPropDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbClaimPropDtlDTO> findAllByStatus(TdoiDbClaimPropDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbClaimPropDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


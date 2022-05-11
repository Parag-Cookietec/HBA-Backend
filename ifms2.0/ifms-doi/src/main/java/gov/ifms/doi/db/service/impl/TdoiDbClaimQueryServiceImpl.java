package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbClaimQueryConverter;
import gov.ifms.doi.db.dto.TdoiDbClaimQueryDTO;
import gov.ifms.doi.db.repository.TdoiDbClaimQueryRepository;
import gov.ifms.doi.db.service.TdoiDbClaimQueryService;

@Service
public class TdoiDbClaimQueryServiceImpl implements TdoiDbClaimQueryService {

	@Autowired
	TdoiDbClaimQueryRepository repository;

	@Autowired
	TdoiDbClaimQueryConverter converter;

	@Override
	public List<TdoiDbClaimQueryDTO> saveOrUpdate(TdoiDbClaimQueryDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbClaimQueryDTO> findAllByCriteria(TdoiDbClaimQueryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbClaimQueryDTO> findAllByStatus(TdoiDbClaimQueryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbClaimQueryDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


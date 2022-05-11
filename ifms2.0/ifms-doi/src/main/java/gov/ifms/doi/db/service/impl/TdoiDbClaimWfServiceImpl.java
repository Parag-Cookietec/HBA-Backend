package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbClaimWfConverter;
import gov.ifms.doi.db.dto.TdoiDbClaimWfDTO;
import gov.ifms.doi.db.repository.TdoiDbClaimWfRepository;
import gov.ifms.doi.db.service.TdoiDbClaimWfService;

@Service
public class TdoiDbClaimWfServiceImpl implements TdoiDbClaimWfService {

	@Autowired
	TdoiDbClaimWfRepository repository;

	@Autowired
	TdoiDbClaimWfConverter converter;

	@Override
	public List<TdoiDbClaimWfDTO> saveOrUpdate(TdoiDbClaimWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbClaimWfDTO> findAllByCriteria(TdoiDbClaimWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbClaimWfDTO> findAllByStatus(TdoiDbClaimWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbClaimWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


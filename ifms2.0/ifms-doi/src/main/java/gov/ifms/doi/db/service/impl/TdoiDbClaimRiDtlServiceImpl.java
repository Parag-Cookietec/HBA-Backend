package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbClaimRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbClaimRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbClaimRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbClaimRiDtlService;

@Service
public class TdoiDbClaimRiDtlServiceImpl implements TdoiDbClaimRiDtlService {

	@Autowired
	TdoiDbClaimRiDtlRepository repository;

	@Autowired
	TdoiDbClaimRiDtlConverter converter;

	@Override
	public List<TdoiDbClaimRiDtlDTO> saveOrUpdate(TdoiDbClaimRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbClaimRiDtlDTO> findAllByCriteria(TdoiDbClaimRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbClaimRiDtlDTO> findAllByStatus(TdoiDbClaimRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbClaimRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


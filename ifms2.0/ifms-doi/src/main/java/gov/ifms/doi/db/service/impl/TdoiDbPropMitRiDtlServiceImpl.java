package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropMitRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPropMitRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPropMitRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPropMitRiDtlService;

@Service
public class TdoiDbPropMitRiDtlServiceImpl implements TdoiDbPropMitRiDtlService {

	@Autowired
	TdoiDbPropMitRiDtlRepository repository;

	@Autowired
	TdoiDbPropMitRiDtlConverter converter;

	@Override
	public List<TdoiDbPropMitRiDtlDTO> saveOrUpdate(TdoiDbPropMitRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropMitRiDtlDTO> findAllByCriteria(TdoiDbPropMitRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropMitRiDtlDTO> findAllByStatus(TdoiDbPropMitRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropMitRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


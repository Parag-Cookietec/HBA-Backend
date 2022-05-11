package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropFireRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPropFireRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPropFireRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPropFireRiDtlService;

@Service
public class TdoiDbPropFireRiDtlServiceImpl implements TdoiDbPropFireRiDtlService {

	@Autowired
	TdoiDbPropFireRiDtlRepository repository;

	@Autowired
	TdoiDbPropFireRiDtlConverter converter;

	@Override
	public List<TdoiDbPropFireRiDtlDTO> saveOrUpdate(TdoiDbPropFireRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropFireRiDtlDTO> findAllByCriteria(TdoiDbPropFireRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropFireRiDtlDTO> findAllByStatus(TdoiDbPropFireRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropFireRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


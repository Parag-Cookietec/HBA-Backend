package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropAviationRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPropAviationRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPropAviationRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPropAviationRiDtlService;

@Service
public class TdoiDbPropAviationRiDtlServiceImpl implements TdoiDbPropAviationRiDtlService {

	@Autowired
	TdoiDbPropAviationRiDtlRepository repository;

	@Autowired
	TdoiDbPropAviationRiDtlConverter converter;

	@Override
	public List<TdoiDbPropAviationRiDtlDTO> saveOrUpdate(TdoiDbPropAviationRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropAviationRiDtlDTO> findAllByCriteria(TdoiDbPropAviationRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropAviationRiDtlDTO> findAllByStatus(TdoiDbPropAviationRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropAviationRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


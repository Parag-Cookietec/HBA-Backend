package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropElecRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPropElecRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPropElecRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPropElecRiDtlService;

@Service
public class TdoiDbPropElecRiDtlServiceImpl implements TdoiDbPropElecRiDtlService {

	@Autowired
	TdoiDbPropElecRiDtlRepository repository;

	@Autowired
	TdoiDbPropElecRiDtlConverter converter;

	@Override
	public List<TdoiDbPropElecRiDtlDTO> saveOrUpdate(TdoiDbPropElecRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropElecRiDtlDTO> findAllByCriteria(TdoiDbPropElecRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropElecRiDtlDTO> findAllByStatus(TdoiDbPropElecRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropElecRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


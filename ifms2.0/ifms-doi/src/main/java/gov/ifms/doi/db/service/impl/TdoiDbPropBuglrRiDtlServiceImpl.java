package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropBuglrRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPropBuglrRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPropBuglrRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPropBuglrRiDtlService;

@Service
public class TdoiDbPropBuglrRiDtlServiceImpl implements TdoiDbPropBuglrRiDtlService {

	@Autowired
	TdoiDbPropBuglrRiDtlRepository repository;

	@Autowired
	TdoiDbPropBuglrRiDtlConverter converter;

	@Override
	public List<TdoiDbPropBuglrRiDtlDTO> saveOrUpdate(TdoiDbPropBuglrRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropBuglrRiDtlDTO> findAllByCriteria(TdoiDbPropBuglrRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropBuglrRiDtlDTO> findAllByStatus(TdoiDbPropBuglrRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropBuglrRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


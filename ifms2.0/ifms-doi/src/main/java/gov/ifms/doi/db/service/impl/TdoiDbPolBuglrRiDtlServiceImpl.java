package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolBuglrRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPolBuglrRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPolBuglrRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPolBuglrRiDtlService;

@Service
public class TdoiDbPolBuglrRiDtlServiceImpl implements TdoiDbPolBuglrRiDtlService {

	@Autowired
	TdoiDbPolBuglrRiDtlRepository repository;

	@Autowired
	TdoiDbPolBuglrRiDtlConverter converter;

	@Override
	public List<TdoiDbPolBuglrRiDtlDTO> saveOrUpdate(TdoiDbPolBuglrRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolBuglrRiDtlDTO> findAllByCriteria(TdoiDbPolBuglrRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolBuglrRiDtlDTO> findAllByStatus(TdoiDbPolBuglrRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolBuglrRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


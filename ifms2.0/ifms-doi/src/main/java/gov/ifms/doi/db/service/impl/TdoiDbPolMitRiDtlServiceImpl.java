package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolMitRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPolMitRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPolMitRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPolMitRiDtlService;

@Service
public class TdoiDbPolMitRiDtlServiceImpl implements TdoiDbPolMitRiDtlService {

	@Autowired
	TdoiDbPolMitRiDtlRepository repository;

	@Autowired
	TdoiDbPolMitRiDtlConverter converter;

	@Override
	public List<TdoiDbPolMitRiDtlDTO> saveOrUpdate(TdoiDbPolMitRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolMitRiDtlDTO> findAllByCriteria(TdoiDbPolMitRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolMitRiDtlDTO> findAllByStatus(TdoiDbPolMitRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolMitRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


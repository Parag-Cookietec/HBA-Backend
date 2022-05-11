package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolAviationRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPolAviationRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPolAviationRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPolAviationRiDtlService;

@Service
public class TdoiDbPolAviationRiDtlServiceImpl implements TdoiDbPolAviationRiDtlService {

	@Autowired
	TdoiDbPolAviationRiDtlRepository repository;

	@Autowired
	TdoiDbPolAviationRiDtlConverter converter;

	@Override
	public List<TdoiDbPolAviationRiDtlDTO> saveOrUpdate(TdoiDbPolAviationRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolAviationRiDtlDTO> findAllByCriteria(TdoiDbPolAviationRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolAviationRiDtlDTO> findAllByStatus(TdoiDbPolAviationRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolAviationRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


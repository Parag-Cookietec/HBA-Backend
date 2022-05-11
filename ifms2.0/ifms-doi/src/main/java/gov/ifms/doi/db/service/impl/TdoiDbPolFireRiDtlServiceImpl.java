package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolFireRiDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPolFireRiDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPolFireRiDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPolFireRiDtlService;

@Service
public class TdoiDbPolFireRiDtlServiceImpl implements TdoiDbPolFireRiDtlService {

	@Autowired
	TdoiDbPolFireRiDtlRepository repository;

	@Autowired
	TdoiDbPolFireRiDtlConverter converter;

	@Override
	public List<TdoiDbPolFireRiDtlDTO> saveOrUpdate(TdoiDbPolFireRiDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolFireRiDtlDTO> findAllByCriteria(TdoiDbPolFireRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolFireRiDtlDTO> findAllByStatus(TdoiDbPolFireRiDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolFireRiDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


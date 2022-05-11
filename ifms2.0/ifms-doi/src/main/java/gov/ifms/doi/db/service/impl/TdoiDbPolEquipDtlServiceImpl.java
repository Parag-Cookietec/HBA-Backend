package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolEquipDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPolEquipDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPolEquipDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPolEquipDtlService;

@Service
public class TdoiDbPolEquipDtlServiceImpl implements TdoiDbPolEquipDtlService {

	@Autowired
	TdoiDbPolEquipDtlRepository repository;

	@Autowired
	TdoiDbPolEquipDtlConverter converter;

	@Override
	public List<TdoiDbPolEquipDtlDTO> saveOrUpdate(TdoiDbPolEquipDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolEquipDtlDTO> findAllByCriteria(TdoiDbPolEquipDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolEquipDtlDTO> findAllByStatus(TdoiDbPolEquipDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolEquipDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


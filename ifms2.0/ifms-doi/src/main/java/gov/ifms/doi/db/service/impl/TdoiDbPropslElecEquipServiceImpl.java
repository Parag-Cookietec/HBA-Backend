package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslElecEquipConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslElecEquipDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslElecEquipRepository;
import gov.ifms.doi.db.service.TdoiDbPropslElecEquipService;

@Service
public class TdoiDbPropslElecEquipServiceImpl implements TdoiDbPropslElecEquipService {

	@Autowired
	TdoiDbPropslElecEquipRepository repository;

	@Autowired
	TdoiDbPropslElecEquipConverter converter;

	@Override
	public List<TdoiDbPropslElecEquipDTO> saveOrUpdate(TdoiDbPropslElecEquipDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslElecEquipDTO> findAllByCriteria(TdoiDbPropslElecEquipDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslElecEquipDTO> findAllByStatus(TdoiDbPropslElecEquipDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslElecEquipDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


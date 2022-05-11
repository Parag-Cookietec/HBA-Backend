package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolElecEquipConverter;
import gov.ifms.doi.db.dto.TdoiDbPolElecEquipDTO;
import gov.ifms.doi.db.entity.TdoiDbPolElecEquipEntity;
import gov.ifms.doi.db.repository.TdoiDbPolElecEquipRepository;
import gov.ifms.doi.db.service.TdoiDbPolElecEquipService;

@Service
public class TdoiDbPolElecEquipServiceImpl implements TdoiDbPolElecEquipService {

	@Autowired
	TdoiDbPolElecEquipRepository repository;

	@Autowired
	TdoiDbPolElecEquipConverter converter;

	@Override
	public TdoiDbPolElecEquipDTO saveOrUpdate(TdoiDbPolElecEquipDTO dto) {
		
	 repository.save(converter.toEntity(dto));
		return dto;
	}


	@Override
	public List<TdoiDbPolElecEquipDTO> findAllByCriteria() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolElecEquipDTO> findAllByStatus() {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public  TdoiDbPolElecEquipDTO softDeleteById(Long id) {
		   TdoiDbPolElecEquipEntity entity = repository.findBydbElecEquipId(id)	;
		repository.softDeleteById(id);
			return  converter.toDtoFromEntity(entity) ;
	}


}


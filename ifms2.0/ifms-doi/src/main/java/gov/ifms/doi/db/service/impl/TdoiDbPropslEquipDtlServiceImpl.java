package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslEquipDtlConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslEquipDtlDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslEquipDtlRepository;
import gov.ifms.doi.db.service.TdoiDbPropslEquipDtlService;

@Service
public class TdoiDbPropslEquipDtlServiceImpl implements TdoiDbPropslEquipDtlService {

	@Autowired
	TdoiDbPropslEquipDtlRepository repository;

	@Autowired
	TdoiDbPropslEquipDtlConverter converter;

	@Override
	public List<TdoiDbPropslEquipDtlDTO> saveOrUpdate(TdoiDbPropslEquipDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslEquipDtlDTO> findAllByCriteria(TdoiDbPropslEquipDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslEquipDtlDTO> findAllByStatus(TdoiDbPropslEquipDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslEquipDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


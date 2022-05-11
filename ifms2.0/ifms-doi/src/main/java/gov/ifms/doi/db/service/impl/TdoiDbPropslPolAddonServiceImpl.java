package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslPolAddonConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslPolAddonDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslPolAddonRepository;
import gov.ifms.doi.db.service.TdoiDbPropslPolAddonService;

@Service
public class TdoiDbPropslPolAddonServiceImpl implements TdoiDbPropslPolAddonService {

	@Autowired
	TdoiDbPropslPolAddonRepository repository;

	@Autowired
	TdoiDbPropslPolAddonConverter converter;

	@Override
	public List<TdoiDbPropslPolAddonDTO> saveOrUpdate(TdoiDbPropslPolAddonDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropslPolAddonDTO> findAllByCriteria(TdoiDbPropslPolAddonDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslPolAddonDTO> findAllByStatus(TdoiDbPropslPolAddonDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslPolAddonDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


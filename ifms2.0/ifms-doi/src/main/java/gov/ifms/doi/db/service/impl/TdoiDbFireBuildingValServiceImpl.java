package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbFireBuildingValConverter;
import gov.ifms.doi.db.dto.TdoiDbFireBuildingValDTO;
import gov.ifms.doi.db.repository.TdoiDbFireBuildingValRepository;
import gov.ifms.doi.db.service.TdoiDbFireBuildingValService;

@Service
public class TdoiDbFireBuildingValServiceImpl implements TdoiDbFireBuildingValService {

	@Autowired
	TdoiDbFireBuildingValRepository repository;

	@Autowired
	TdoiDbFireBuildingValConverter converter;

	@Override
	public List<TdoiDbFireBuildingValDTO> saveOrUpdate(TdoiDbFireBuildingValDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbFireBuildingValDTO> findAllByCriteria(TdoiDbFireBuildingValDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbFireBuildingValDTO> findAllByStatus(TdoiDbFireBuildingValDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbFireBuildingValDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


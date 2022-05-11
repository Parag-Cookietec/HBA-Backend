package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolFireBuildingValConverter;
import gov.ifms.doi.db.dto.TdoiDbPolFireBuildingValDTO;
import gov.ifms.doi.db.repository.TdoiDbPolFireBuildingValRepository;
import gov.ifms.doi.db.service.TdoiDbPolFireBuildingValService;

@Service
public class TdoiDbPolFireBuildingValServiceImpl implements TdoiDbPolFireBuildingValService {

	@Autowired
	TdoiDbPolFireBuildingValRepository repository;

	@Autowired
	TdoiDbPolFireBuildingValConverter converter;

	@Override
	public List<TdoiDbPolFireBuildingValDTO> saveOrUpdate(TdoiDbPolFireBuildingValDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolFireBuildingValDTO> findAllByCriteria(TdoiDbPolFireBuildingValDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolFireBuildingValDTO> findAllByStatus(TdoiDbPolFireBuildingValDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolFireBuildingValDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


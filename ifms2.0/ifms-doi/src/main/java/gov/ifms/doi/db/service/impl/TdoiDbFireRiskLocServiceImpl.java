package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbFireRiskLocConverter;
import gov.ifms.doi.db.dto.TdoiDbFireRiskLocDTO;
import gov.ifms.doi.db.repository.TdoiDbFireRiskLocRepository;
import gov.ifms.doi.db.service.TdoiDbFireRiskLocService;

@Service
public class TdoiDbFireRiskLocServiceImpl implements TdoiDbFireRiskLocService {

	@Autowired
	TdoiDbFireRiskLocRepository repository;

	@Autowired
	TdoiDbFireRiskLocConverter converter;

	@Override
	public List<TdoiDbFireRiskLocDTO> saveOrUpdate(TdoiDbFireRiskLocDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbFireRiskLocDTO> findAllByCriteria(TdoiDbFireRiskLocDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbFireRiskLocDTO> findAllByStatus(TdoiDbFireRiskLocDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbFireRiskLocDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


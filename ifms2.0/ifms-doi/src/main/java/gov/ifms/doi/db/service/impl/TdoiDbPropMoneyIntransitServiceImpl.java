package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropMoneyIntransitConverter;
import gov.ifms.doi.db.dto.TdoiDbPropMoneyIntransitDTO;
import gov.ifms.doi.db.repository.TdoiDbPropMoneyIntransitRepository;
import gov.ifms.doi.db.service.TdoiDbPropMoneyIntransitService;

@Service
public class TdoiDbPropMoneyIntransitServiceImpl implements TdoiDbPropMoneyIntransitService {

	@Autowired
	TdoiDbPropMoneyIntransitRepository repository;

	@Autowired
	TdoiDbPropMoneyIntransitConverter converter;

	@Override
	public List<TdoiDbPropMoneyIntransitDTO> saveOrUpdate(TdoiDbPropMoneyIntransitDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropMoneyIntransitDTO> findAllByCriteria(TdoiDbPropMoneyIntransitDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropMoneyIntransitDTO> findAllByStatus(TdoiDbPropMoneyIntransitDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropMoneyIntransitDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


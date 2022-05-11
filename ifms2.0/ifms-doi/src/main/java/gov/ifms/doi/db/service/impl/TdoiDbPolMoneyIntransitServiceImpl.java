package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolMoneyIntransitConverter;
import gov.ifms.doi.db.dto.TdoiDbPolMoneyIntransitDTO;
import gov.ifms.doi.db.repository.TdoiDbPolMoneyIntransitRepository;
import gov.ifms.doi.db.service.TdoiDbPolMoneyIntransitService;

@Service
public class TdoiDbPolMoneyIntransitServiceImpl implements TdoiDbPolMoneyIntransitService {

	@Autowired
	TdoiDbPolMoneyIntransitRepository repository;

	@Autowired
	TdoiDbPolMoneyIntransitConverter converter;

	@Override
	public List<TdoiDbPolMoneyIntransitDTO> saveOrUpdate(TdoiDbPolMoneyIntransitDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolMoneyIntransitDTO> findAllByCriteria(TdoiDbPolMoneyIntransitDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolMoneyIntransitDTO> findAllByStatus(TdoiDbPolMoneyIntransitDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolMoneyIntransitDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


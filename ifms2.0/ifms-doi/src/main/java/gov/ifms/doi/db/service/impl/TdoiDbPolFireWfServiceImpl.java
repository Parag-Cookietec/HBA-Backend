package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolFireWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPolFireWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPolFireWfRepository;
import gov.ifms.doi.db.service.TdoiDbPolFireWfService;

@Service
public class TdoiDbPolFireWfServiceImpl implements TdoiDbPolFireWfService {

	@Autowired
	TdoiDbPolFireWfRepository repository;

	@Autowired
	TdoiDbPolFireWfConverter converter;

	@Override
	public List<TdoiDbPolFireWfDTO> saveOrUpdate(TdoiDbPolFireWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolFireWfDTO> findAllByCriteria(TdoiDbPolFireWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolFireWfDTO> findAllByStatus(TdoiDbPolFireWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolFireWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


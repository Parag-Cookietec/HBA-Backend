package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolAviationWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPolAviationWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPolAviationWfRepository;
import gov.ifms.doi.db.service.TdoiDbPolAviationWfService;

@Service
public class TdoiDbPolAviationWfServiceImpl implements TdoiDbPolAviationWfService {

	@Autowired
	TdoiDbPolAviationWfRepository repository;

	@Autowired
	TdoiDbPolAviationWfConverter converter;

	@Override
	public List<TdoiDbPolAviationWfDTO> saveOrUpdate(TdoiDbPolAviationWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolAviationWfDTO> findAllByCriteria(TdoiDbPolAviationWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolAviationWfDTO> findAllByStatus(TdoiDbPolAviationWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolAviationWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


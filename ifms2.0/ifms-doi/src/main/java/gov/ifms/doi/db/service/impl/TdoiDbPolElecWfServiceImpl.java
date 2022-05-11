package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolElecWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPolElecWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPolElecWfRepository;
import gov.ifms.doi.db.service.TdoiDbPolElecWfService;

@Service
public class TdoiDbPolElecWfServiceImpl implements TdoiDbPolElecWfService {

	@Autowired
	TdoiDbPolElecWfRepository repository;

	@Autowired
	TdoiDbPolElecWfConverter converter;

	@Override
	public List<TdoiDbPolElecWfDTO> saveOrUpdate(TdoiDbPolElecWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolElecWfDTO> findAllByCriteria(TdoiDbPolElecWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolElecWfDTO> findAllByStatus(TdoiDbPolElecWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolElecWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


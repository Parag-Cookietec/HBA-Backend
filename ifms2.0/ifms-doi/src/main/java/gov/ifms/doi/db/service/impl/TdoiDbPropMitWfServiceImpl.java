package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropMitWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPropMitWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPropMitWfRepository;
import gov.ifms.doi.db.service.TdoiDbPropMitWfService;

@Service
public class TdoiDbPropMitWfServiceImpl implements TdoiDbPropMitWfService {

	@Autowired
	TdoiDbPropMitWfRepository repository;

	@Autowired
	TdoiDbPropMitWfConverter converter;

	@Override
	public List<TdoiDbPropMitWfDTO> saveOrUpdate(TdoiDbPropMitWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropMitWfDTO> findAllByCriteria(TdoiDbPropMitWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropMitWfDTO> findAllByStatus(TdoiDbPropMitWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropMitWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


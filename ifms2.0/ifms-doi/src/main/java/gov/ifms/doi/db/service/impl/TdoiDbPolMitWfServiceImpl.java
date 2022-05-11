package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolMitWfConverter;
import gov.ifms.doi.db.dto.TdoiDbPolMitWfDTO;
import gov.ifms.doi.db.repository.TdoiDbPolMitWfRepository;
import gov.ifms.doi.db.service.TdoiDbPolMitWfService;

@Service
public class TdoiDbPolMitWfServiceImpl implements TdoiDbPolMitWfService {

	@Autowired
	TdoiDbPolMitWfRepository repository;

	@Autowired
	TdoiDbPolMitWfConverter converter;

	@Override
	public List<TdoiDbPolMitWfDTO> saveOrUpdate(TdoiDbPolMitWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolMitWfDTO> findAllByCriteria(TdoiDbPolMitWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolMitWfDTO> findAllByStatus(TdoiDbPolMitWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolMitWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


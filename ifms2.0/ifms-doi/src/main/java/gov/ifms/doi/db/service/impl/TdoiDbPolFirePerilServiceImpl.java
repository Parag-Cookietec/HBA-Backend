package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolFirePerilConverter;
import gov.ifms.doi.db.dto.TdoiDbPolFirePerilDTO;
import gov.ifms.doi.db.repository.TdoiDbPolFirePerilRepository;
import gov.ifms.doi.db.service.TdoiDbPolFirePerilService;

@Service
public class TdoiDbPolFirePerilServiceImpl implements TdoiDbPolFirePerilService {

	@Autowired
	TdoiDbPolFirePerilRepository repository;

	@Autowired
	TdoiDbPolFirePerilConverter converter;

	@Override
	public List<TdoiDbPolFirePerilDTO> saveOrUpdate(TdoiDbPolFirePerilDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolFirePerilDTO> findAllByCriteria(TdoiDbPolFirePerilDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolFirePerilDTO> findAllByStatus(TdoiDbPolFirePerilDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolFirePerilDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


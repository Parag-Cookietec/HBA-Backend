package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaProposlWfConverter;
import gov.ifms.doi.hba.dto.TdoiHbaProposlWfDTO;
import gov.ifms.doi.hba.repository.TdoiHbaProposlWfRepository;
import gov.ifms.doi.hba.service.TdoiHbaProposlWfService;

@Service
public class TdoiHbaProposlWfServiceImpl implements TdoiHbaProposlWfService {

	@Autowired
	TdoiHbaProposlWfRepository repository;

	@Autowired
	TdoiHbaProposlWfConverter converter;

	@Override
	public List<TdoiHbaProposlWfDTO> saveOrUpdate(TdoiHbaProposlWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiHbaProposlWfDTO> findAllByCriteria(TdoiHbaProposlWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaProposlWfDTO> findAllByStatus(TdoiHbaProposlWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaProposlWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


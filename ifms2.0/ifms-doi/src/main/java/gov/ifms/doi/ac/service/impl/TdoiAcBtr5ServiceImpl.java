package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcBtr5Converter;
import gov.ifms.doi.ac.dto.TdoiAcBtr5DTO;
import gov.ifms.doi.ac.repository.TdoiAcBtr5Repository;
import gov.ifms.doi.ac.service.TdoiAcBtr5Service;

@Service
public class TdoiAcBtr5ServiceImpl implements TdoiAcBtr5Service {

	@Autowired
	TdoiAcBtr5Repository repository;

	@Autowired
	TdoiAcBtr5Converter converter;

	@Override
	public List<TdoiAcBtr5DTO> saveOrUpdate(TdoiAcBtr5DTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcBtr5DTO> findAllByCriteria(TdoiAcBtr5DTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcBtr5DTO> findAllByStatus(TdoiAcBtr5DTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcBtr5DTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


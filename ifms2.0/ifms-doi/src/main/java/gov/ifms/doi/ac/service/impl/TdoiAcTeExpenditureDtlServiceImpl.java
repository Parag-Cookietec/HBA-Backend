package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcTeExpenditureDtlConverter;
import gov.ifms.doi.ac.dto.TdoiAcTeExpenditureDtlDTO;
import gov.ifms.doi.ac.repository.TdoiAcTeExpenditureDtlRepository;
import gov.ifms.doi.ac.service.TdoiAcTeExpenditureDtlService;

@Service
public class TdoiAcTeExpenditureDtlServiceImpl implements TdoiAcTeExpenditureDtlService {

	@Autowired
	TdoiAcTeExpenditureDtlRepository repository;

	@Autowired
	TdoiAcTeExpenditureDtlConverter converter;

	@Override
	public List<TdoiAcTeExpenditureDtlDTO> saveOrUpdate(TdoiAcTeExpenditureDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcTeExpenditureDtlDTO> findAllByCriteria(TdoiAcTeExpenditureDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcTeExpenditureDtlDTO> findAllByStatus(TdoiAcTeExpenditureDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcTeExpenditureDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


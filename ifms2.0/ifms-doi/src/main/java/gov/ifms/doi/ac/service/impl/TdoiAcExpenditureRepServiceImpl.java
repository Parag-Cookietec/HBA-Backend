package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcExpenditureRepConverter;
import gov.ifms.doi.ac.dto.TdoiAcExpenditureRepDTO;
import gov.ifms.doi.ac.repository.TdoiAcExpenditureRepRepository;
import gov.ifms.doi.ac.service.TdoiAcExpenditureRepService;

@Service
public class TdoiAcExpenditureRepServiceImpl implements TdoiAcExpenditureRepService {

	@Autowired
	TdoiAcExpenditureRepRepository repository;

	@Autowired
	TdoiAcExpenditureRepConverter converter;

	@Override
	public List<TdoiAcExpenditureRepDTO> saveOrUpdate(TdoiAcExpenditureRepDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcExpenditureRepDTO> findAllByCriteria(TdoiAcExpenditureRepDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcExpenditureRepDTO> findAllByStatus(TdoiAcExpenditureRepDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcExpenditureRepDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


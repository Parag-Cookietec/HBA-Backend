package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropMitInsuranceConverter;
import gov.ifms.doi.db.dto.TdoiDbPropMitInsuranceDTO;
import gov.ifms.doi.db.repository.TdoiDbPropMitInsuranceRepository;
import gov.ifms.doi.db.service.TdoiDbPropMitInsuranceService;

@Service
public class TdoiDbPropMitInsuranceServiceImpl implements TdoiDbPropMitInsuranceService {

	@Autowired
	TdoiDbPropMitInsuranceRepository repository;

	@Autowired
	TdoiDbPropMitInsuranceConverter converter;

	@Override
	public List<TdoiDbPropMitInsuranceDTO> saveOrUpdate(TdoiDbPropMitInsuranceDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropMitInsuranceDTO> findAllByCriteria(TdoiDbPropMitInsuranceDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropMitInsuranceDTO> findAllByStatus(TdoiDbPropMitInsuranceDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropMitInsuranceDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


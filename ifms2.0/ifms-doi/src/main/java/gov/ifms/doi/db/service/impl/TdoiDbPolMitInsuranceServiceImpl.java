package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolMitInsuranceConverter;
import gov.ifms.doi.db.dto.TdoiDbPolMitInsuranceDTO;
import gov.ifms.doi.db.repository.TdoiDbPolMitInsuranceRepository;
import gov.ifms.doi.db.service.TdoiDbPolMitInsuranceService;

@Service
public class TdoiDbPolMitInsuranceServiceImpl implements TdoiDbPolMitInsuranceService {

	@Autowired
	TdoiDbPolMitInsuranceRepository repository;

	@Autowired
	TdoiDbPolMitInsuranceConverter converter;

	@Override
	public List<TdoiDbPolMitInsuranceDTO> saveOrUpdate(TdoiDbPolMitInsuranceDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolMitInsuranceDTO> findAllByCriteria(TdoiDbPolMitInsuranceDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolMitInsuranceDTO> findAllByStatus(TdoiDbPolMitInsuranceDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolMitInsuranceDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


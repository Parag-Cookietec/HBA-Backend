package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropAviationAircraftConverter;
import gov.ifms.doi.db.dto.TdoiDbPropAviationAircraftDTO;
import gov.ifms.doi.db.repository.TdoiDbPropAviationAircraftRepository;
import gov.ifms.doi.db.service.TdoiDbPropAviationAircraftService;

@Service
public class TdoiDbPropAviationAircraftServiceImpl implements TdoiDbPropAviationAircraftService {

	@Autowired
	TdoiDbPropAviationAircraftRepository repository;

	@Autowired
	TdoiDbPropAviationAircraftConverter converter;

	@Override
	public List<TdoiDbPropAviationAircraftDTO> saveOrUpdate(TdoiDbPropAviationAircraftDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPropAviationAircraftDTO> findAllByCriteria(TdoiDbPropAviationAircraftDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropAviationAircraftDTO> findAllByStatus(TdoiDbPropAviationAircraftDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropAviationAircraftDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


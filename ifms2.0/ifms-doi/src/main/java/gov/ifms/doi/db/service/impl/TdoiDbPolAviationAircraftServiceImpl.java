package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPolAviationAircraftConverter;
import gov.ifms.doi.db.dto.TdoiDbPolAviationAircraftDTO;
import gov.ifms.doi.db.repository.TdoiDbPolAviationAircraftRepository;
import gov.ifms.doi.db.service.TdoiDbPolAviationAircraftService;

@Service
public class TdoiDbPolAviationAircraftServiceImpl implements TdoiDbPolAviationAircraftService {

	@Autowired
	TdoiDbPolAviationAircraftRepository repository;

	@Autowired
	TdoiDbPolAviationAircraftConverter converter;

	@Override
	public List<TdoiDbPolAviationAircraftDTO> saveOrUpdate(TdoiDbPolAviationAircraftDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbPolAviationAircraftDTO> findAllByCriteria(TdoiDbPolAviationAircraftDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPolAviationAircraftDTO> findAllByStatus(TdoiDbPolAviationAircraftDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPolAviationAircraftDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


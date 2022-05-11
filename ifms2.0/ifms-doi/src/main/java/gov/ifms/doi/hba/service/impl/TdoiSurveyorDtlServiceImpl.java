package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiSurveyorDtlConverter;
import gov.ifms.doi.hba.dto.TdoiSurveyorDtlDTO;
import gov.ifms.doi.hba.repository.TdoiSurveyorDtlRepository;
import gov.ifms.doi.hba.service.TdoiSurveyorDtlService;

@Service
public class TdoiSurveyorDtlServiceImpl implements TdoiSurveyorDtlService {

	@Autowired
	TdoiSurveyorDtlRepository repository;

	@Autowired
	TdoiSurveyorDtlConverter converter;

	@Override
	public List<TdoiSurveyorDtlDTO> saveOrUpdate(TdoiSurveyorDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria();
	}


	@Override
	public List<TdoiSurveyorDtlDTO> findAllByCriteria() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}

	@Override
	public List<TdoiSurveyorDtlDTO> findAllByCriteria(TdoiSurveyorDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}

	@Override
	public List<TdoiSurveyorDtlDTO> findAllByStatus(TdoiSurveyorDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiSurveyorDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


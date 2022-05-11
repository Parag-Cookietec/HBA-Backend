package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiSurveyorBillWfConverter;
import gov.ifms.doi.hba.dto.TdoiSurveyorBillWfDTO;
import gov.ifms.doi.hba.repository.TdoiSurveyorBillWfRepository;
import gov.ifms.doi.hba.service.TdoiSurveyorBillWfService;

@Service
public class TdoiSurveyorBillWfServiceImpl implements TdoiSurveyorBillWfService {

	@Autowired
	TdoiSurveyorBillWfRepository repository;

	@Autowired
	TdoiSurveyorBillWfConverter converter;

	@Override
	public List<TdoiSurveyorBillWfDTO> saveOrUpdate(TdoiSurveyorBillWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiSurveyorBillWfDTO> findAllByCriteria(TdoiSurveyorBillWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiSurveyorBillWfDTO> findAllByStatus(TdoiSurveyorBillWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiSurveyorBillWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


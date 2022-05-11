package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiSurveyorBillDtlConverter;
import gov.ifms.doi.hba.dto.TdoiSurveyorBillDtlDTO;
import gov.ifms.doi.hba.repository.TdoiSurveyorBillDtlRepository;
import gov.ifms.doi.hba.service.TdoiSurveyorBillDtlService;

@Service
public class TdoiSurveyorBillDtlServiceImpl implements TdoiSurveyorBillDtlService {

	@Autowired
	TdoiSurveyorBillDtlRepository repository;

	@Autowired
	TdoiSurveyorBillDtlConverter converter;

	@Override
	public List<TdoiSurveyorBillDtlDTO> saveOrUpdate(TdoiSurveyorBillDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiSurveyorBillDtlDTO> findAllByCriteria(TdoiSurveyorBillDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiSurveyorBillDtlDTO> findAllByStatus(TdoiSurveyorBillDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiSurveyorBillDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


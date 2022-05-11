package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcChallanDtlConverter;
import gov.ifms.doi.ac.dto.TdoiAcChallanDtlDTO;
import gov.ifms.doi.ac.repository.TdoiAcChallanDtlRepository;
import gov.ifms.doi.ac.service.TdoiAcChallanDtlService;

@Service
public class TdoiAcChallanDtlServiceImpl implements TdoiAcChallanDtlService {

	@Autowired
	TdoiAcChallanDtlRepository repository;

	@Autowired
	TdoiAcChallanDtlConverter converter;

	@Override
	public List<TdoiAcChallanDtlDTO> saveOrUpdate(TdoiAcChallanDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcChallanDtlDTO> findAllByCriteria(TdoiAcChallanDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcChallanDtlDTO> findAllByStatus(TdoiAcChallanDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcChallanDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


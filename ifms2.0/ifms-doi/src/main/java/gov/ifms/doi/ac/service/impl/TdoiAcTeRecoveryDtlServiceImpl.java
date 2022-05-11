package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcTeRecoveryDtlConverter;
import gov.ifms.doi.ac.dto.TdoiAcTeRecoveryDtlDTO;
import gov.ifms.doi.ac.repository.TdoiAcTeRecoveryDtlRepository;
import gov.ifms.doi.ac.service.TdoiAcTeRecoveryDtlService;

@Service
public class TdoiAcTeRecoveryDtlServiceImpl implements TdoiAcTeRecoveryDtlService {

	@Autowired
	TdoiAcTeRecoveryDtlRepository repository;

	@Autowired
	TdoiAcTeRecoveryDtlConverter converter;

	@Override
	public List<TdoiAcTeRecoveryDtlDTO> saveOrUpdate(TdoiAcTeRecoveryDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcTeRecoveryDtlDTO> findAllByCriteria(TdoiAcTeRecoveryDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcTeRecoveryDtlDTO> findAllByStatus(TdoiAcTeRecoveryDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcTeRecoveryDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


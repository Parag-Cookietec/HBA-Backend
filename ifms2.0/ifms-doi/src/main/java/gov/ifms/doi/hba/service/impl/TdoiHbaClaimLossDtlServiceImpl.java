package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaClaimLossDtlConverter;
import gov.ifms.doi.hba.dto.TdoiHbaClaimLossDtlDTO;
import gov.ifms.doi.hba.repository.TdoiHbaClaimLossDtlRepository;
import gov.ifms.doi.hba.service.TdoiHbaClaimLossDtlService;

@Service
public class TdoiHbaClaimLossDtlServiceImpl implements TdoiHbaClaimLossDtlService {

	@Autowired
	TdoiHbaClaimLossDtlRepository repository;

	@Autowired
	TdoiHbaClaimLossDtlConverter converter;

	@Override
	public List<TdoiHbaClaimLossDtlDTO> saveOrUpdate(TdoiHbaClaimLossDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiHbaClaimLossDtlDTO> findAllByCriteria(TdoiHbaClaimLossDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaClaimLossDtlDTO> findAllByStatus(TdoiHbaClaimLossDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaClaimLossDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


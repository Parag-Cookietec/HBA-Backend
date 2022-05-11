package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaClaimWfConverter;
import gov.ifms.doi.hba.dto.TdoiHbaClaimWfDTO;
import gov.ifms.doi.hba.repository.TdoiHbaClaimWfRepository;
import gov.ifms.doi.hba.service.TdoiHbaClaimWfService;

@Service
public class TdoiHbaClaimWfServiceImpl implements TdoiHbaClaimWfService {

	@Autowired
	TdoiHbaClaimWfRepository repository;

	@Autowired
	TdoiHbaClaimWfConverter converter;

	@Override
	public List<TdoiHbaClaimWfDTO> saveOrUpdate(TdoiHbaClaimWfDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiHbaClaimWfDTO> findAllByCriteria(TdoiHbaClaimWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaClaimWfDTO> findAllByStatus(TdoiHbaClaimWfDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaClaimWfDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


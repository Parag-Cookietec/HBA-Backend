package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaClaimRejectConverter;
import gov.ifms.doi.hba.dto.TdoiHbaClaimRejectDTO;
import gov.ifms.doi.hba.repository.TdoiHbaClaimRejectRepository;
import gov.ifms.doi.hba.service.TdoiHbaClaimRejectService;

@Service
public class TdoiHbaClaimRejectServiceImpl implements TdoiHbaClaimRejectService {

	@Autowired
	TdoiHbaClaimRejectRepository repository;

	@Autowired
	TdoiHbaClaimRejectConverter converter;

	@Override
	public List<TdoiHbaClaimRejectDTO> saveOrUpdate(TdoiHbaClaimRejectDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiHbaClaimRejectDTO> findAllByCriteria(TdoiHbaClaimRejectDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaClaimRejectDTO> findAllByStatus(TdoiHbaClaimRejectDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaClaimRejectDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


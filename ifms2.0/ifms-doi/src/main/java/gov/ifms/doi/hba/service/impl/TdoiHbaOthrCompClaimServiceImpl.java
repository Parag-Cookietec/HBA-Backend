package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaOthrCompClaimConverter;
import gov.ifms.doi.hba.dto.TdoiHbaOthrCompClaimDTO;
import gov.ifms.doi.hba.repository.TdoiHbaOthrCompClaimRepository;
import gov.ifms.doi.hba.service.TdoiHbaOthrCompClaimService;

@Service
public class TdoiHbaOthrCompClaimServiceImpl implements TdoiHbaOthrCompClaimService {

	@Autowired
	TdoiHbaOthrCompClaimRepository repository;

	@Autowired
	TdoiHbaOthrCompClaimConverter converter;

	@Override
	public List<TdoiHbaOthrCompClaimDTO> saveOrUpdate(TdoiHbaOthrCompClaimDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiHbaOthrCompClaimDTO> findAllByCriteria(TdoiHbaOthrCompClaimDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaOthrCompClaimDTO> findAllByStatus(TdoiHbaOthrCompClaimDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaOthrCompClaimDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


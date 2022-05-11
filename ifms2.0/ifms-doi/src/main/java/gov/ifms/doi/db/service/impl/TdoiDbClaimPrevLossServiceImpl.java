package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbClaimPrevLossConverter;
import gov.ifms.doi.db.dto.TdoiDbClaimPrevLossDTO;
import gov.ifms.doi.db.repository.TdoiDbClaimPrevLossRepository;
import gov.ifms.doi.db.service.TdoiDbClaimPrevLossService;

@Service
public class TdoiDbClaimPrevLossServiceImpl implements TdoiDbClaimPrevLossService {

	@Autowired
	TdoiDbClaimPrevLossRepository repository;

	@Autowired
	TdoiDbClaimPrevLossConverter converter;

	@Override
	public List<TdoiDbClaimPrevLossDTO> saveOrUpdate(TdoiDbClaimPrevLossDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiDbClaimPrevLossDTO> findAllByCriteria(TdoiDbClaimPrevLossDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbClaimPrevLossDTO> findAllByStatus(TdoiDbClaimPrevLossDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbClaimPrevLossDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


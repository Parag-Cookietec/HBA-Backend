package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcDeadStockRegisterConverter;
import gov.ifms.doi.ac.dto.TdoiAcDeadStockRegisterDTO;
import gov.ifms.doi.ac.repository.TdoiAcDeadStockRegisterRepository;
import gov.ifms.doi.ac.service.TdoiAcDeadStockRegisterService;

@Service
public class TdoiAcDeadStockRegisterServiceImpl implements TdoiAcDeadStockRegisterService {

	@Autowired
	TdoiAcDeadStockRegisterRepository repository;

	@Autowired
	TdoiAcDeadStockRegisterConverter converter;

	@Override
	public List<TdoiAcDeadStockRegisterDTO> saveOrUpdate(TdoiAcDeadStockRegisterDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcDeadStockRegisterDTO> findAllByCriteria(TdoiAcDeadStockRegisterDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcDeadStockRegisterDTO> findAllByStatus(TdoiAcDeadStockRegisterDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcDeadStockRegisterDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


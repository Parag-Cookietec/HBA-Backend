package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcChallanRegisterConverter;
import gov.ifms.doi.ac.dto.TdoiAcChallanRegisterDTO;
import gov.ifms.doi.ac.repository.TdoiAcChallanRegisterRepository;
import gov.ifms.doi.ac.service.TdoiAcChallanRegisterService;

@Service
public class TdoiAcChallanRegisterServiceImpl implements TdoiAcChallanRegisterService {

	@Autowired
	TdoiAcChallanRegisterRepository repository;

	@Autowired
	TdoiAcChallanRegisterConverter converter;

	@Override
	public List<TdoiAcChallanRegisterDTO> saveOrUpdate(TdoiAcChallanRegisterDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcChallanRegisterDTO> findAllByCriteria(TdoiAcChallanRegisterDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcChallanRegisterDTO> findAllByStatus(TdoiAcChallanRegisterDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcChallanRegisterDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


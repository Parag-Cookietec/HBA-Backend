package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcChequeRegisterConverter;
import gov.ifms.doi.ac.dto.TdoiAcChequeRegisterDTO;
import gov.ifms.doi.ac.repository.TdoiAcChequeRegisterRepository;
import gov.ifms.doi.ac.service.TdoiAcChequeRegisterService;

@Service
public class TdoiAcChequeRegisterServiceImpl implements TdoiAcChequeRegisterService {

	@Autowired
	TdoiAcChequeRegisterRepository repository;

	@Autowired
	TdoiAcChequeRegisterConverter converter;

	@Override
	public List<TdoiAcChequeRegisterDTO> saveOrUpdate(TdoiAcChequeRegisterDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcChequeRegisterDTO> findAllByCriteria(TdoiAcChequeRegisterDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcChequeRegisterDTO> findAllByStatus(TdoiAcChequeRegisterDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcChequeRegisterDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


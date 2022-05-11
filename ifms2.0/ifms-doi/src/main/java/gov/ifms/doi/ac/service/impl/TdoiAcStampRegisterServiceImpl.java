package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcStampRegisterConverter;
import gov.ifms.doi.ac.dto.TdoiAcStampRegisterDTO;
import gov.ifms.doi.ac.repository.TdoiAcStampRegisterRepository;
import gov.ifms.doi.ac.service.TdoiAcStampRegisterService;

@Service
public class TdoiAcStampRegisterServiceImpl implements TdoiAcStampRegisterService {

	@Autowired
	TdoiAcStampRegisterRepository repository;

	@Autowired
	TdoiAcStampRegisterConverter converter;

	@Override
	public List<TdoiAcStampRegisterDTO> saveOrUpdate(TdoiAcStampRegisterDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcStampRegisterDTO> findAllByCriteria(TdoiAcStampRegisterDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcStampRegisterDTO> findAllByStatus(TdoiAcStampRegisterDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcStampRegisterDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


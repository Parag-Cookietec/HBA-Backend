package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcTransferEntryConverter;
import gov.ifms.doi.ac.dto.TdoiAcTransferEntryDTO;
import gov.ifms.doi.ac.repository.TdoiAcTransferEntryRepository;
import gov.ifms.doi.ac.service.TdoiAcTransferEntryService;

@Service
public class TdoiAcTransferEntryServiceImpl implements TdoiAcTransferEntryService {

	@Autowired
	TdoiAcTransferEntryRepository repository;

	@Autowired
	TdoiAcTransferEntryConverter converter;

	@Override
	public List<TdoiAcTransferEntryDTO> saveOrUpdate(TdoiAcTransferEntryDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcTransferEntryDTO> findAllByCriteria(TdoiAcTransferEntryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcTransferEntryDTO> findAllByStatus(TdoiAcTransferEntryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcTransferEntryDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


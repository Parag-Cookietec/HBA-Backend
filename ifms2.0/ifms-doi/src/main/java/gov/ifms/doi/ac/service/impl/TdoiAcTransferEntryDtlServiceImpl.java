package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcTransferEntryDtlConverter;
import gov.ifms.doi.ac.dto.TdoiAcTransferEntryDtlDTO;
import gov.ifms.doi.ac.repository.TdoiAcTransferEntryDtlRepository;
import gov.ifms.doi.ac.service.TdoiAcTransferEntryDtlService;

@Service
public class TdoiAcTransferEntryDtlServiceImpl implements TdoiAcTransferEntryDtlService {

	@Autowired
	TdoiAcTransferEntryDtlRepository repository;

	@Autowired
	TdoiAcTransferEntryDtlConverter converter;

	@Override
	public List<TdoiAcTransferEntryDtlDTO> saveOrUpdate(TdoiAcTransferEntryDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcTransferEntryDtlDTO> findAllByCriteria(TdoiAcTransferEntryDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcTransferEntryDtlDTO> findAllByStatus(TdoiAcTransferEntryDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcTransferEntryDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


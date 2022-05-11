package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcCashbookReceiptConverter;
import gov.ifms.doi.ac.dto.TdoiAcCashbookReceiptDTO;
import gov.ifms.doi.ac.repository.TdoiAcCashbookReceiptRepository;
import gov.ifms.doi.ac.service.TdoiAcCashbookReceiptService;

@Service
public class TdoiAcCashbookReceiptServiceImpl implements TdoiAcCashbookReceiptService {

	@Autowired
	TdoiAcCashbookReceiptRepository repository;

	@Autowired
	TdoiAcCashbookReceiptConverter converter;

	@Override
	public List<TdoiAcCashbookReceiptDTO> saveOrUpdate(TdoiAcCashbookReceiptDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcCashbookReceiptDTO> findAllByCriteria(TdoiAcCashbookReceiptDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcCashbookReceiptDTO> findAllByStatus(TdoiAcCashbookReceiptDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcCashbookReceiptDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


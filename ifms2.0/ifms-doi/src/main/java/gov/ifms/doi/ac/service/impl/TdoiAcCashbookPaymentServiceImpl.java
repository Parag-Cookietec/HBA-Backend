package gov.ifms.doi.ac.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.ac.converter.TdoiAcCashbookPaymentConverter;
import gov.ifms.doi.ac.dto.TdoiAcCashbookPaymentDTO;
import gov.ifms.doi.ac.repository.TdoiAcCashbookPaymentRepository;
import gov.ifms.doi.ac.service.TdoiAcCashbookPaymentService;

@Service
public class TdoiAcCashbookPaymentServiceImpl implements TdoiAcCashbookPaymentService {

	@Autowired
	TdoiAcCashbookPaymentRepository repository;

	@Autowired
	TdoiAcCashbookPaymentConverter converter;

	@Override
	public List<TdoiAcCashbookPaymentDTO> saveOrUpdate(TdoiAcCashbookPaymentDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<TdoiAcCashbookPaymentDTO> findAllByCriteria(TdoiAcCashbookPaymentDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiAcCashbookPaymentDTO> findAllByStatus(TdoiAcCashbookPaymentDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiAcCashbookPaymentDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


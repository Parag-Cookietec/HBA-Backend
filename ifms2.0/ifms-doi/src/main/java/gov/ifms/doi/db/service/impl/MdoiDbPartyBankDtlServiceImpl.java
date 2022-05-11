package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.MdoiDbPartyBankDtlConverter;
import gov.ifms.doi.db.dto.MdoiDbPartyBankDtlDTO;
import gov.ifms.doi.db.repository.MdoiDbPartyBankDtlRepository;
import gov.ifms.doi.db.service.MdoiDbPartyBankDtlService;

@Service
public class MdoiDbPartyBankDtlServiceImpl implements MdoiDbPartyBankDtlService {

	@Autowired
	MdoiDbPartyBankDtlRepository repository;

	@Autowired
	MdoiDbPartyBankDtlConverter converter;

	@Override
	public List<MdoiDbPartyBankDtlDTO> saveOrUpdate(MdoiDbPartyBankDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<MdoiDbPartyBankDtlDTO> findAllByCriteria(MdoiDbPartyBankDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<MdoiDbPartyBankDtlDTO> findAllByStatus(MdoiDbPartyBankDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<MdoiDbPartyBankDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


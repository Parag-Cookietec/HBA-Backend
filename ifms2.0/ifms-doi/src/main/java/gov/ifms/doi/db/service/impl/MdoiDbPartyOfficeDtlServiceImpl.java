package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.MdoiDbPartyOfficeDtlConverter;
import gov.ifms.doi.db.dto.MdoiDbPartyOfficeDtlDTO;
import gov.ifms.doi.db.repository.MdoiDbPartyOfficeDtlRepository;
import gov.ifms.doi.db.service.MdoiDbPartyOfficeDtlService;

@Service
public class MdoiDbPartyOfficeDtlServiceImpl implements MdoiDbPartyOfficeDtlService {

	@Autowired
	MdoiDbPartyOfficeDtlRepository repository;

	@Autowired
	MdoiDbPartyOfficeDtlConverter converter;

	@Override
	public List<MdoiDbPartyOfficeDtlDTO> saveOrUpdate(MdoiDbPartyOfficeDtlDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<MdoiDbPartyOfficeDtlDTO> findAllByCriteria(MdoiDbPartyOfficeDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<MdoiDbPartyOfficeDtlDTO> findAllByStatus(MdoiDbPartyOfficeDtlDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<MdoiDbPartyOfficeDtlDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


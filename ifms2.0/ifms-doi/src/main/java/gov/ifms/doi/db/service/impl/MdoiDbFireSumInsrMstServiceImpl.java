package gov.ifms.doi.db.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.MdoiDbFireSumInsrMstConverter;
import gov.ifms.doi.db.dto.MdoiDbFireSumInsrMstDTO;
import gov.ifms.doi.db.repository.MdoiDbFireSumInsrMstRepository;
import gov.ifms.doi.db.service.MdoiDbFireSumInsrMstService;

@Service
public class MdoiDbFireSumInsrMstServiceImpl implements MdoiDbFireSumInsrMstService {

	@Autowired
	MdoiDbFireSumInsrMstRepository repository;

	@Autowired
	MdoiDbFireSumInsrMstConverter converter;

	@Override
	public List<MdoiDbFireSumInsrMstDTO> saveOrUpdate(MdoiDbFireSumInsrMstDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria(dto);
	}


	@Override
	public List<MdoiDbFireSumInsrMstDTO> findAllByCriteria(MdoiDbFireSumInsrMstDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<MdoiDbFireSumInsrMstDTO> findAllByStatus(MdoiDbFireSumInsrMstDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<MdoiDbFireSumInsrMstDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}


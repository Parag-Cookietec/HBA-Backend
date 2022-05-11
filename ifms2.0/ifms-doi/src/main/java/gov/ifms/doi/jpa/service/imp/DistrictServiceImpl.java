package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.converter.DistrictConverter;
import gov.ifms.doi.jpa.dto.DistrictDTO;
import gov.ifms.doi.jpa.repository.DistrictRepository;
import gov.ifms.doi.jpa.service.DistrictService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	DistrictRepository districtRepository;

	@Autowired
	DistrictConverter converter;

	@Override
	public List<DistrictDTO> getDistrictList() {
		return converter.toDtoListFromEntityList(districtRepository.getDistrictList());
	}

	@Override
	public DistrictDTO getDistrictById(Long districtId) {
		return converter.toDtoFromEntity(districtRepository.getOne(districtId));
	}

	@Override
	public List<DistrictDTO> getDistrictByStateId(Long stateId) {
		return converter.toDtoListFromEntityList(districtRepository.getDistrictByStateId(stateId));
	}

}

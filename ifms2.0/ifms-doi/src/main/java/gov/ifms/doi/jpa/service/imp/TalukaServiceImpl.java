package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.converter.TalukaConverter;
import gov.ifms.doi.jpa.dto.TalukaDTO;
import gov.ifms.doi.jpa.repository.TalukaRepository;
import gov.ifms.doi.jpa.service.TalukaService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class TalukaServiceImpl implements TalukaService {

	@Autowired
	TalukaRepository districtRepository;

	@Autowired
	TalukaConverter converter;

	@Override
	public List<TalukaDTO> getTalukaListByDistrictId(Long districtId) {
		if (districtId == null || districtId == 0) {
			return converter.toDtoListFromEntityList(districtRepository.getAllActive());
		}
		return converter.toDtoListFromEntityList(districtRepository.getTalukaListByDistrict(districtId));
	}

	@Override
	public TalukaDTO getTalukaById(Long talukaId) {
		return converter.toDtoFromEntity(districtRepository.getOne(talukaId));
	}

}

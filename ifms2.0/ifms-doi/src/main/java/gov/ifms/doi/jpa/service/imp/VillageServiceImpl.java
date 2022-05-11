package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.converter.VillageConverter;
import gov.ifms.doi.jpa.dto.VillageDTO;
import gov.ifms.doi.jpa.repository.VillageRepository;
import gov.ifms.doi.jpa.service.VillageService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class VillageServiceImpl implements VillageService {

	@Autowired
	VillageRepository districtRepository;

	@Autowired
	VillageConverter converter;

	@Override
	public List<VillageDTO> getVillageListByTalukaId(Long talukaId) {
		if (talukaId == null || talukaId == 0) {
			return converter.toDtoListFromEntityList(districtRepository.getAllActiveVillages());
		}
		return converter.toDtoListFromEntityList(districtRepository.getVillageListByTalukaId(talukaId));
	}

	@Override
	public VillageDTO getVillageById(Long villageId) {
		return converter.toDtoFromEntity(districtRepository.getOne(villageId));
	}

}

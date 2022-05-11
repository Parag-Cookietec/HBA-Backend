package gov.ifms.doi.jpa.service.imp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import gov.ifms.common.util.Constant;
import gov.ifms.doi.jpa.dto.LuLookUpDTO;
import gov.ifms.doi.jpa.service.CommonLuLookUpService;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPLuLookUpRepository;

@Service
public class CommonLuLookUpServiceImpl implements CommonLuLookUpService {

	/** The e DP lu look up repository. */
	@Autowired
	@Lazy
	private EDPLuLookUpRepository eDPLuLookUpRepository;

	/** The EDPLuLookUpInfoAsMethodName repository. */
	@Autowired
	@Lazy
	private EDPLuLookUpInfoRepository repository;

	@Override
	public List<LuLookUpDTO> findByLookUpId(LuLookUpDTO lookUpDTO) {
		EDPLuLookUpEntity eDPLuLookUpEntity = eDPLuLookUpRepository.findByLookUpName(lookUpDTO.getName());
		List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = repository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(
				eDPLuLookUpEntity.getLookUpId(), Constant.ACTIVE_STATUS);
		eDPLuLookUpInfoEntities = eDPLuLookUpInfoEntities.stream().filter(l->l.getLookUpInfoDescription().equals(lookUpDTO.getName())).collect(Collectors.toList());
		return eDPLuLookUpInfoEntities.stream().sorted(Comparator.comparing(EDPLuLookUpInfoEntity::getLookUpInfoName))
				.map(eDPLuLookUpInfoEntity -> {
					LuLookUpDTO clueDto = new LuLookUpDTO();
					clueDto.setId(eDPLuLookUpInfoEntity.getLookUpInfoId());
					clueDto.setName(eDPLuLookUpInfoEntity.getLookUpInfoName());
					clueDto.setCode(eDPLuLookUpInfoEntity.getLookUpInfoName());
					clueDto.setCodeName(eDPLuLookUpInfoEntity.getLookUpInfoName());
					return clueDto;
				}).collect(Collectors.toList());
	}

}

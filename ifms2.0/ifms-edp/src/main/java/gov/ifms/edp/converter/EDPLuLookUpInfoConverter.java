package gov.ifms.edp.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPLuLookUpInfoDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;

/**
 * The Class EDPLuLookUpInfoConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 18:24:43
 *
 */
@Component
public class EDPLuLookUpInfoConverter implements BaseConverter<EDPLuLookUpInfoEntity, EDPLuLookUpInfoDto> {

	/** The edp lu look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLuLookUpInfo entity
	 */
	@Override
	public EDPLuLookUpInfoEntity toEntity(EDPLuLookUpInfoDto dto) {
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLuLookUpInfo dto
	 */
	@Override
	public EDPLuLookUpInfoDto toDTO(EDPLuLookUpInfoEntity entity) {
		EDPLuLookUpInfoDto dto = new EDPLuLookUpInfoDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPLuLookUpInfoEntity> list) {
		return list.stream().map(entityInList -> {
			ClueDto dto = new ClueDto();
			dto.setId(entityInList.getLookUpInfoId());
			dto.setName(entityInList.getLookUpInfoName());
			return dto;
		}).collect(Collectors.toList());
	}

	/**
	 * Id to EDP lu look UP info entity.
	 *
	 * @param id the id
	 * @return the EDP lu look up info entity
	 */
	public EDPLuLookUpInfoEntity idToEDPLuLookUPInfoEntity(long id) {
		Optional<EDPLuLookUpInfoEntity> entity = edpLuLookUpInfoRepository.findById(id);
		if (entity.isPresent())
			return entity.get();
		else
			throw new EntityNotFoundException("edp id Should not be null");

	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDto(List<EDPLuLookUpInfoEntity> list) {
		return list.stream().map(entityInList -> {
			EDPSDTDto edpsdtDto = new EDPSDTDto();
			edpsdtDto.setId(entityInList.getLookUpInfoId());
			edpsdtDto.setName(entityInList.getLookUpInfoName());
			return edpsdtDto; 
		}).collect(Collectors.toList());
	}

	
	public List<ClueDto> toOfficeDto(List<EDPMsOfficeEntity> list) {
		return list.stream().map(entityInList -> {
			ClueDto dto = new ClueDto();
			dto.setId(entityInList.getOfficeId());
			dto.setName(entityInList.getOfficeNameAlias());
			return dto;
		}).collect(Collectors.toList());
	}
}

package gov.ifms.pvu.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.base.Status;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.dto.PVUFixToRegularPayConDto;
import gov.ifms.pvu.entity.PVUFixToRegularPayConEntity;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUFixToRegularPayConConverter class.
 * 
 * @version 1.0
 * @created 2021/04/11 14:05:32
 *
 */
@Component
public class PVUFixToRegularPayConConverter
		implements BaseConverter<PVUFixToRegularPayConEntity, PVUFixToRegularPayConDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUFixToRegularPayCon entity
	 */
	@Override
	public PVUFixToRegularPayConEntity toEntity(PVUFixToRegularPayConDto dto) {
		PVUFixToRegularPayConEntity entity = new PVUFixToRegularPayConEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setStatusId(
				Status.DRAFT.toString().equals(dto.getAction()) ? PvuConstant.SAVE_AS_DRAFT_ID : PvuConstant.APPROVED_ID);
		return entity;
	}

	/**
	 * To Entity List.
	 *
	 * @param list dtos
	 * @return the List<PVUFixToRegularPayConEntity>
	 */
	public List<PVUFixToRegularPayConEntity> toEntityList(List<PVUFixToRegularPayConDto> dtos) {
		return dtos.stream().map(dto -> {
			PVUFixToRegularPayConEntity entity = new PVUFixToRegularPayConEntity();
			BeanUtils.copyProperties(dto, entity);
			return entity;
		}).collect(Collectors.toList());

	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUFixToRegularPayCon dto
	 */
	@Override
	public PVUFixToRegularPayConDto toDTO(PVUFixToRegularPayConEntity entity) {
		PVUFixToRegularPayConDto dto = new PVUFixToRegularPayConDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setOfficeName(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeName());
		if (entity.getRefDate()!= null) {			
			dto.setRefDate(entity.getRefDate());
		}
		return dto;
	}
	
	public PVUFixToRegularPayConDto toCustomDTO(PVUFixToRegularPayConEntity entity,Long employeeNo) {
		PVUFixToRegularPayConDto dto = new PVUFixToRegularPayConDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setOfficeName(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeName());
		dto.setEmployeeNo(employeeNo);
		return dto;
	}

	/**
	 * To DTO List.
	 *
	 * @param list entities
	 * @return the List<PVUFixToRegularPayConDto>
	 */
	public List<PVUFixToRegularPayConDto> toDtoList(List<PVUFixToRegularPayConEntity> entities) {
		return entities.stream().map(entity -> {
			PVUFixToRegularPayConDto dto = new PVUFixToRegularPayConDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).collect(Collectors.toList());

	}

}

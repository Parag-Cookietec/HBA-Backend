package gov.ifms.loc.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocChequeBookSdDto;
import gov.ifms.loc.entity.LocChequeBookDtlEntity;
import gov.ifms.loc.entity.LocChequeBookSdEntity;

/**
 * The Class LOCChequeBookDtlConverter class.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:08:08
 *
 */
@Component
public class LocChequeBookSdConverter implements BaseConverter<LocChequeBookSdEntity, LocChequeBookSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LOCChequeBookDtl entity
	 */
	@Override
	public LocChequeBookSdEntity toEntity(LocChequeBookSdDto dto) {
		LocChequeBookSdEntity entity = new LocChequeBookSdEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LOCChequeBookDtl dto
	 */
	@Override
	public LocChequeBookSdDto toDTO(LocChequeBookSdEntity entity) {
		LocChequeBookSdDto dto = new LocChequeBookSdDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Dtlto sd DTO.
	 *
	 * @param entity the entity
	 * @return the list
	 */
	public List<LocChequeBookSdDto> dtltoSdDTO(List<LocChequeBookDtlEntity> entity) {
		List<LocChequeBookSdDto> dtoList = new ArrayList<>();
		for (LocChequeBookDtlEntity dtlEntity : entity) {
			LocChequeBookSdDto dto = new LocChequeBookSdDto();
			BeanUtils.copyProperties(dtlEntity, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

}

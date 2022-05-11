package gov.ifms.loc.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocChequeCancelDtlSdDto;
import gov.ifms.loc.dto.LocChequeCancelEditViewDtlDto;
import gov.ifms.loc.entity.LocAdvicePartHeadwisedetaisEntity;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;
import gov.ifms.loc.entity.LocChequeCancelDtlSdEntity;
import gov.ifms.loc.entity.LocChequeCancelHdrEntity;

/**
 * The Class LocChequeCancelDtlSdConverter class.
 *
 * @version v 1.0
 * @created 2021/03/06 17:39:31
 */
@Component
public class LocChequeCancelDtlSdConverter
		implements BaseConverter<LocChequeCancelDtlSdEntity, LocChequeCancelDtlSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChequeCancelDtlSd entity
	 */
	@Override
	public LocChequeCancelDtlSdEntity toEntity(LocChequeCancelDtlSdDto dto) {
		LocChequeCancelDtlSdEntity entity = new LocChequeCancelDtlSdEntity();
		if (null != dto.getHdrId()) {
			entity.setHdrId(new LocChequeCancelHdrEntity(dto.getHdrId()));
		}
		if (null != dto.getHeadWiseId()) {
			entity.setHeadWiseId(new LocAdvicePartHeadwisedetaisEntity(dto.getHeadWiseId()));
		}
		if (null != dto.getAdviceId()) {
			entity.setAdviceId(new LocAdvicePrepHdrEntity(dto.getAdviceId()));
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChequeCancelDtlSd dto
	 */
	@Override
	public LocChequeCancelDtlSdDto toDTO(LocChequeCancelDtlSdEntity entity) {
		LocChequeCancelDtlSdDto dto = new LocChequeCancelDtlSdDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Dtlto sd DTO.
	 *
	 * @param entity the entity
	 * @return the list
	 */
	public List<LocChequeCancelEditViewDtlDto> dtltoSdDTO(List<LocChequeCancelDtlSdEntity> entity) {
		List<LocChequeCancelEditViewDtlDto> dtoList = new ArrayList<>();
		for (LocChequeCancelDtlSdEntity dtlEntity : entity) {
			LocChequeCancelEditViewDtlDto dto = new LocChequeCancelEditViewDtlDto();
			BeanUtils.copyProperties(dtlEntity, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

}

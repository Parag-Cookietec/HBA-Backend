package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.dto.PVUEmployeIncrementEventSummaryDto;
import gov.ifms.pvu.dto.PVUIncrementEventSummaryDto;
import gov.ifms.pvu.entity.PVUEmployeIncrementEventSummaryEntity;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.entity.PVUIncrementEventSummaryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class PVUIncrementEventSummaryConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/10 15:30:02
 *
 */
@Component
public class PVUEmployeIncrementEventSummaryConverter
		implements BaseConverter<PVUEmployeIncrementEventSummaryEntity, PVUEmployeIncrementEventSummaryDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUIncrementEventSummary entity
	 */
	@Override
	public PVUEmployeIncrementEventSummaryEntity toEntity(PVUEmployeIncrementEventSummaryDto dto) {
		PVUEmployeIncrementEventSummaryEntity entity = new PVUEmployeIncrementEventSummaryEntity();
		if (!Utils.isEmpty(dto.getInEventId())) {
			entity.setInEventId(new PVUIncrementEventEntity(dto.getInEventId()));
		}

		entity.setClassOneInclCount(dto.getClassOneInclCount());
		entity.setClassTwoInclCount(dto.getClassTwoInclCount());
		entity.setClassThreeInclCount(dto.getClassThreeInclCount());
		entity.setClassFourInclCount(dto.getClassFourInclCount());
		entity.setClassOneExclCount(dto.getClassOneExclCount());
		entity.setClassTwoExclCount(dto.getClassTwoExclCount());
		entity.setClassThreeExclCount(dto.getClassThreeExclCount());
		entity.setClassFourExclCount(dto.getClassFourExclCount());
		entity.setRemarks(dto.getRemarks());

		if (!Utils.isEmpty(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}

		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUIncrementEventSummary dto
	 */
	@Override
	public PVUEmployeIncrementEventSummaryDto toDTO(PVUEmployeIncrementEventSummaryEntity entity) {
		PVUEmployeIncrementEventSummaryDto dto = new PVUEmployeIncrementEventSummaryDto();
		if (!Utils.isEmpty(entity.getInEventId())) {
			dto.setInEventId(entity.getInEventId().getInEventId());
		}
		
		dto.setClassOneInclCount(entity.getClassOneInclCount());
		dto.setClassTwoInclCount(entity.getClassTwoInclCount());
		dto.setClassThreeInclCount(entity.getClassThreeInclCount());
		dto.setClassFourInclCount(entity.getClassFourInclCount());
		dto.setClassOneExclCount(entity.getClassOneExclCount());
		dto.setClassTwoExclCount(entity.getClassTwoExclCount());
		dto.setClassThreeExclCount(entity.getClassThreeExclCount());
		dto.setClassFourExclCount(entity.getClassFourExclCount());
		dto.setRemarks(entity.getRemarks());

		if (!Utils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}

		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

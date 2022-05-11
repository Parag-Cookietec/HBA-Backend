package gov.ifms.pvu.converter;

import java.util.List;
import java.util.stream.Collectors;

import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.util.PvuUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUSuspensionPayDetailsDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUSuspensionPayDetailsConverter class.
 * 
 * @version v 1.0
 * @created 2019/12/19 12:16:05
 *
 */
@Component
public class PVUSuspensionPayDetailsConverter implements BaseConverter<PVUSuspensionPayDetailsEntity,PVUSuspensionPayDetailsDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUSuspensionPayDetails entity
	 */
	@Override
	public PVUSuspensionPayDetailsEntity toEntity(PVUSuspensionPayDetailsDto dto) {
		PVUSuspensionPayDetailsEntity entity = new PVUSuspensionPayDetailsEntity();	
		entity.setSuspension(new PVUEmployeSuspensionEntity(dto.getSuspensionId()));
		if (dto.getStatusId() != 0) {
			entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		BeanUtils.copyProperties(dto, entity,"createdDate");
		if (dto.getPayableGradePayAmt() > 0 && dto.getPayablePayBandAmt() > 0) {
			entity.setPayableBasicPayAmt(dto.getPayableGradePayAmt() + dto.getPayablePayBandAmt());
		}
		if (PvuUtils.hasLength(dto.getCellId())) {
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}

		if (PvuUtils.hasLength(dto.getPayBandId())) {
			entity.setPayBandId(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		if (PvuUtils.hasLength(dto.getGradePayId())) {
			entity.setGradePayId(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		if (PvuUtils.hasLength(dto.getPayLevelId())) {
			entity.setPayLevelId(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if (PvuUtils.hasLength(dto.getPayScale())) {
			entity.setPayScale(new PVUMsPayScaleEntity(dto.getPayScale()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUSuspensionPayDetails  dto
	 */
	@Override
	public PVUSuspensionPayDetailsDto toDTO(PVUSuspensionPayDetailsEntity entity) {
		PVUSuspensionPayDetailsDto dto = new PVUSuspensionPayDetailsDto();
		dto.setSuspensionId(entity.getSuspension().getId());
		if (entity.getStatus() != null) {
			dto.setStatusId(entity.getStatus().getLookUpInfoId());
		}
		BeanUtils.copyProperties(entity, dto);
		if (entity.getPayLevelId() != null) {
			dto.setPayLevelId(entity.getPayLevelId().getId());
		}
		if (entity.getPayBandId() != null) {
			dto.setPayBandId(entity.getPayBandId().getId());
		}
		if (entity.getGradePayId() != null) {
			dto.setGradePayId(entity.getGradePayId().getId());
		}
		if (entity.getCellId() != null) {
			dto.setCellId(entity.getCellId().getId());
		}
		if (entity.getPayScale() != null) {
			dto.setPayScale(entity.getPayScale().getPayScaleId());
		}
		return dto;
	}

	@Override
	public List<PVUSuspensionPayDetailsEntity> toEntity(List<PVUSuspensionPayDetailsDto> list ) {
		return list.stream().map(this::toEntity).collect(Collectors.toList());
	}
	@Override
	public List<PVUSuspensionPayDetailsDto> toDTO(List<PVUSuspensionPayDetailsEntity> list ) {
		return list.stream().map(this::toDTO).collect(Collectors.toList());
	}
	

	
}

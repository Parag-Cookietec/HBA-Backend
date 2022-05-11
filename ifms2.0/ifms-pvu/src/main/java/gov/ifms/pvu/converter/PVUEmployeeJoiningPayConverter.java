package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUEmployeeJoiningPayDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeeJoiningPayEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUEmployeeJoiningPayConverter class.
 * 
 * @version v 1.0
 * @created 2020/05/15 11:25:19
 *
 */
@Component
public class PVUEmployeeJoiningPayConverter
		implements BaseConverter<PVUEmployeeJoiningPayEntity, PVUEmployeeJoiningPayDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeeJoiningPay entity
	 */
	@Override
	public PVUEmployeeJoiningPayEntity toEntity(PVUEmployeeJoiningPayDto dto) {
		PVUEmployeeJoiningPayEntity entity = new PVUEmployeeJoiningPayEntity();
		if (dto.getCellId() != null) {
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}
		if (dto.getGradePayId() != null) {
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		if (dto.getJoinPayCommId() != null) {
			entity.setPayCommissionJoiningTime(new EDPLuLookUpInfoEntity(dto.getJoinPayCommId()));
		}
		if(dto.getPayBandId() != null) {
			entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		if(dto.getPayLevelId() != null) {
			entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if(dto.getEmpId() != null) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeeJoiningPay dto
	 */
	@Override
	public PVUEmployeeJoiningPayDto toDTO(PVUEmployeeJoiningPayEntity entity) {
		PVUEmployeeJoiningPayDto dto = new PVUEmployeeJoiningPayDto();
		if (entity.getCellId() != null) {
			dto.setCellId(entity.getCellId().getId());
			dto.setCellValue(entity.getCellId().getCellValue());
		}
		if (entity.getGradePay() != null) {
			dto.setGradePayId(entity.getGradePay().getId());
			dto.setGradePayName(entity.getGradePay().getGradePayValue());
		}
		if (entity.getPayCommissionJoiningTime() != null) {
			dto.setJoinPayCommId(entity.getPayCommissionJoiningTime().getLookUpInfoId());
			dto.setJoinPayCommName(entity.getPayCommissionJoiningTime().getLookUpInfoName());
		}
		if(entity.getPayBand() != null) {
			dto.setPayBandId(entity.getPayBand().getId());
			dto.setPayBandName(entity.getPayBand().getPayBandDispVal());
		}
		if(entity.getPayLevel() != null) {
			dto.setPayLevelId(entity.getPayLevel().getId());
			dto.setPayLevelName(entity.getPayLevel().getPayLevelValue());
		}
		if(entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

package gov.ifms.pvu.converter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsStateEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.pvu.dto.PVUEmployeAddressDto;
import gov.ifms.pvu.dto.PVUEmployeAddressUpdateDto;
import gov.ifms.pvu.entity.PVUEmployeAddressEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;

/**
 * The Class PVUEmployeAddressConverter class.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
@Component
public class PVUEmployeAddressConverter implements BaseConverter<PVUEmployeAddressEntity, PVUEmployeAddressDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeAddress entity
	 */
	@Override
	public PVUEmployeAddressEntity toEntity(PVUEmployeAddressDto dto) {
		PVUEmployeAddressEntity entity = new PVUEmployeAddressEntity();
		BeanUtils.copyProperties(dto, entity);
		setEntityIdToObject(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeAddress dto
	 */
	@Override
	public PVUEmployeAddressDto toDTO(PVUEmployeAddressEntity entity) {
		PVUEmployeAddressDto dto = new PVUEmployeAddressDto();
		BeanUtils.copyProperties(entity, dto);
		setDtoObjectToId(entity, dto);
		return dto;
	}

	/**
	 * Sets the entity id to object.
	 *
	 * @param dto    the dto
	 * @param entity the entity
	 */
	public void setEntityIdToObject(PVUEmployeAddressDto dto, PVUEmployeAddressEntity entity) {
		if(dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getCurState() != 0) {
			entity.setCurState(new EDPMsStateEntity(dto.getCurState()));
		}
		if(dto.getCurDistrict() != 0) {
			entity.setCurDistrict(new EDPMsDistrictEntity(dto.getCurDistrict()));
		}
		if(dto.getCurTaluka() != 0) {
			entity.setCurTaluka(new EDPMsTalukaEntity(dto.getCurTaluka()));
		}
		if (dto.getCurOtherTaluka().equalsIgnoreCase(Constant.ZERO_STR)) {
			entity.setCurOtherTaluka("");
		}
		if(dto.getPerState() != 0) {
			entity.setPerState(new EDPMsStateEntity(dto.getPerState()));
		}
		if(dto.getPerDistrict() != 0) {
			entity.setPerDistrict(new EDPMsDistrictEntity(dto.getPerDistrict()));
		}
		if(dto.getPerTaluka() != 0) {
			entity.setPerTaluka(new EDPMsTalukaEntity(dto.getPerTaluka()));
		}
		if (dto.getPerOtherTaluka().equalsIgnoreCase(Constant.ZERO_STR)) {
			entity.setPerOtherTaluka("");
		}
		if(dto.getNatState() != 0) {
			entity.setNatState(new EDPMsStateEntity(dto.getNatState()));	
		}
		if(dto.getNatDistrict() != 0) {
			entity.setNatDistrict(new EDPMsDistrictEntity(dto.getNatDistrict()));
		}
		if(dto.getNatTaluka() != 0) {
			entity.setNatTaluka(new EDPMsTalukaEntity(dto.getNatTaluka()));	
		}
		if (dto.getNatOtherTaluka().equalsIgnoreCase(Constant.ZERO_STR)) {
			entity.setNatOtherTaluka("");
		}
		if(dto.getCurOfficeDist() != 0) {
			entity.setCurOfficeDist(new EDPLuLookUpInfoEntity(dto.getCurOfficeDist()));
		}
		if(dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
	}

	/**
	 * Sets the dto object to id.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 */
	private void setDtoObjectToId(PVUEmployeAddressEntity entity, PVUEmployeAddressDto dto) {
		if(entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getCurState() != null) {
			dto.setCurState(entity.getCurState().getStateId());
			dto.setCurStateName(entity.getCurState().getStateName());
		}
		if(entity.getCurDistrict() != null) {
			dto.setCurDistrict(entity.getCurDistrict().getDistrictId());
			dto.setCurDistrictName(entity.getCurDistrict().getDistrictName());
		}
		if(entity.getCurTaluka() != null) {
			dto.setCurTaluka(entity.getCurTaluka().getTalukaId());
			dto.setCurTalukaName(entity.getCurTaluka().getTalukaName());
		}
		if(entity.getPerState() != null) {
			dto.setPerState(entity.getPerState().getStateId());
			dto.setPerStateName(entity.getPerState().getStateName());
		}
		if(entity.getPerDistrict() != null) {
			dto.setPerDistrict(entity.getPerDistrict().getDistrictId());
			dto.setPerDistrictName(entity.getPerDistrict().getDistrictName());
		}
		if(entity.getPerTaluka() != null) {
			dto.setPerTaluka(entity.getPerTaluka().getTalukaId());
			dto.setPerTalukaName(entity.getPerTaluka().getTalukaName());
		}
		if(entity.getNatState() != null) {
			dto.setNatState(entity.getNatState().getStateId());
			dto.setNatStateName(entity.getNatState().getStateName());
		}
		if(entity.getNatDistrict() != null) {
			dto.setNatDistrict(entity.getNatDistrict().getDistrictId());
			dto.setNatDistrictName(entity.getNatDistrict().getDistrictName());
		}
		if(entity.getNatTaluka() != null) {
			dto.setNatTaluka(entity.getNatTaluka().getTalukaId());
			dto.setNatTalukaName(entity.getNatTaluka().getTalukaName());
		}
		if(entity.getCurOfficeDist() != null) {
			dto.setCurOfficeDist(entity.getCurOfficeDist().getLookUpInfoId());
			dto.setCurOfficeDistName(entity.getCurOfficeDist().getLookUpInfoName());
		}
		if(entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
	}

	
	public void setEditFiledEntityById(PVUEmployeAddressDto dto, PVUEmployeAddressEntity entity) {
		if (dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if (dto.getCurState() != 0) {
			entity.setCurState(new EDPMsStateEntity(dto.getCurState()));
		}
		if (dto.getCurDistrict() != 0) {
			entity.setCurDistrict(new EDPMsDistrictEntity(dto.getCurDistrict()));
		}
		if (dto.getCurTaluka() != 0) {
			entity.setCurTaluka(new EDPMsTalukaEntity(dto.getCurTaluka()));
		}
		if (dto.getCurOtherTaluka().equalsIgnoreCase(Constant.ZERO_STR)) {
			entity.setCurOtherTaluka("");
		}
		if (dto.getPerState() != 0) {
			entity.setPerState(new EDPMsStateEntity(dto.getPerState()));
		}
		if (dto.getPerDistrict() != 0) {
			entity.setPerDistrict(new EDPMsDistrictEntity(dto.getPerDistrict()));
		}
		if (dto.getPerTaluka() != 0) {
			entity.setPerTaluka(new EDPMsTalukaEntity(dto.getPerTaluka()));
		}
		if (dto.getPerOtherTaluka().equalsIgnoreCase(Constant.ZERO_STR)) {
			entity.setPerOtherTaluka("");
		}
		if (dto.getNatState() != 0) {
			entity.setNatState(new EDPMsStateEntity(dto.getNatState()));
		}
		if (dto.getNatDistrict() != 0) {
			entity.setNatDistrict(new EDPMsDistrictEntity(dto.getNatDistrict()));
		}
		if (dto.getNatTaluka() != 0) {
			entity.setNatTaluka(new EDPMsTalukaEntity(dto.getNatTaluka()));
		}
		if (dto.getNatOtherTaluka().equalsIgnoreCase(Constant.ZERO_STR)) {
			entity.setNatOtherTaluka("");
		}
		addressEmployee(dto, entity);
	}

	private void addressEmployee(PVUEmployeAddressDto dto, PVUEmployeAddressEntity entity) {
		if (dto.getCurOfficeDist() != 0) {
			entity.setCurOfficeDist(new EDPLuLookUpInfoEntity(dto.getCurOfficeDist()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getChangeType() != 0) {
			entity.setChangeType(dto.getChangeType());
		}
		if (dto.getPerPinCode() != 0) {
			entity.setPerPinCode(dto.getPerPinCode());
		}
		if (dto.getNatPinCode() != 0) {
			entity.setNatPinCode(dto.getNatPinCode());
		}
		if (dto.getPerPinCode() != 0) {
			entity.setPerPinCode(dto.getPerPinCode());
		}
		if (dto.getCurPinCode() != 0) {
			entity.setCurPinCode(dto.getCurPinCode());
		}
		if (dto.getCurAddress1() != null) {
			entity.setCurAddress1(dto.getCurAddress1());
		}
		if (dto.getCurAddress2() != null) {
			entity.setCurAddress2(dto.getCurAddress2());
		}
		if (dto.getNatAddress1() != null) {
			entity.setNatAddress1(dto.getNatAddress1());
		}
		otherAddress(dto, entity);
		entity.setUpdatedDate(new Date());
	}

	private void otherAddress(PVUEmployeAddressDto dto, PVUEmployeAddressEntity entity) {
		if (dto.getNatAddress2() != null) {
			entity.setNatAddress2(dto.getNatAddress2());
		}
		if (dto.getPerAddress1()!= null) {
			entity.setPerAddress1(dto.getPerAddress1());
		}
		if (dto.getPerAddress2()!= null) {
			entity.setPerAddress2(dto.getPerAddress2());
		}
		if (dto.getPerCity()!= null) {
			entity.setPerCity(dto.getPerCity());
		}
		if (dto.getCurCity()!= null) {
			entity.setCurCity(dto.getCurCity());
		}
		if (dto.getNatCity()!= null) {
			entity.setNatCity(dto.getNatCity());
		}
		if (dto.getCurOtherTaluka() != null) {
			entity.setCurOtherTaluka(dto.getCurOtherTaluka());
		}
		if (dto.getNatOtherTaluka() != null) {
			entity.setNatOtherTaluka(dto.getNatOtherTaluka());
		}
		if (dto.getPerOtherTaluka() != null) {
			entity.setPerOtherTaluka(dto.getPerOtherTaluka());
		}
	}

	
}

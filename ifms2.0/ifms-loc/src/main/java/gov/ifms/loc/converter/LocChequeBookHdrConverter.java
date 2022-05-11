package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.loc.dto.LocChequeBookHdrDto;
import gov.ifms.loc.entity.LocChequeBookHdrEntity;
import gov.ifms.loc.entity.LocMsDivisonEntity;

/**
 * The Class LocChequeBookHdrConverter class.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:03:50
 *
 */
@Component
public class LocChequeBookHdrConverter implements BaseConverter<LocChequeBookHdrEntity, LocChequeBookHdrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChequeBookHdr entity
	 */
	@Override
	public LocChequeBookHdrEntity toEntity(LocChequeBookHdrDto dto) {
		LocChequeBookHdrEntity entity = new LocChequeBookHdrEntity();
		if (null != dto.getReqTypeId()) {
			entity.setReqTypeId(new EDPLuLookUpInfoEntity(dto.getReqTypeId()));
		}
		if (null != dto.getChequeTypeId()) {
			entity.setChequeTypeId(new EDPLuLookUpInfoEntity(dto.getChequeTypeId()));
		}
		if (null != dto.getBankBranchId()) {
			entity.setBankBranchId(new EDPMsBankIfscEntity(dto.getBankBranchId()));
		}
		if (null != dto.getDivId()) {
			entity.setDivId(new LocMsDivisonEntity(dto.getDivId()));
		}
		if (null != dto.getChequeTypeId()) {
			entity.setChequeTypeId(new EDPLuLookUpInfoEntity(dto.getChequeTypeId()));
		}
		if (null != dto.getReqTypeId()) {
			entity.setReqTypeId(new EDPLuLookUpInfoEntity(dto.getReqTypeId()));
		}

		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChequeBookHdr dto
	 */
	@Override
	public LocChequeBookHdrDto toDTO(LocChequeBookHdrEntity entity) {
		LocChequeBookHdrDto dto = new LocChequeBookHdrDto();
		dto.setReqTypeId(entity.getReqTypeId().getLookUpInfoId());
		dto.setChequeTypeId(entity.getChequeTypeId().getLookUpInfoId());
		dto.setDivId(entity.getDivId().getDivisonId());
		dto.setBankBranchId(entity.getBankBranchId().getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

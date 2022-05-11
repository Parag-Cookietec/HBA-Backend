package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.base.Status;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPTedpBrDtlDto;
import gov.ifms.edp.dto.EDPTedpBrHdrDto;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPTedpBrCrDtlEntity;
import gov.ifms.edp.entity.EDPTedpBrDtlEntity;
import gov.ifms.edp.entity.EDPTedpBrHdrEntity;
import gov.ifms.edp.util.EDPConstant;


/**
 * The Class EDPTedpBrHdrConverter.
 */
@Component
public class EDPTedpBrHdrConverter implements BaseConverter<EDPTedpBrHdrEntity,EDPTedpBrHdrDto> {


	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP tedp br hdr entity
	 */
	@Override
	public EDPTedpBrHdrEntity toEntity(EDPTedpBrHdrDto dto) {
		EDPTedpBrHdrEntity entity = new EDPTedpBrHdrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	
	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP tedp br hdr dto
	 */
	@Override
	public EDPTedpBrHdrDto toDTO(EDPTedpBrHdrEntity entity) {
		EDPTedpBrHdrDto dto = new EDPTedpBrHdrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Hdr dto to hdr entity.
	 *
	 * @param dto the dto
	 * @return the EDP tedp br hdr entity
	 */
	public EDPTedpBrHdrEntity hdrDtoToHdrEntity(EDPTedpBrHdrDto dto) {
		EDPTedpBrHdrEntity entity = new EDPTedpBrHdrEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getRequestType())
			entity.setRequestType(new EDPLuLookUpInfoEntity(dto.getRequestType()));
		if(dto.getFormAction() == Status.SUBMITTED)
			entity.setStatusId(new EDPLuLookUpInfoEntity(EDPConstant.STATUS_APPROVE_ID));
		else 
			entity.setStatusId(new EDPLuLookUpInfoEntity(Constant.SAVE_AS_DRAFT_STATUS_ID));
		return entity;
	}
	
	/**
	 * Hdr dto to br cr dtl entity.
	 *
	 * @param dto the dto
	 * @return the EDP tedp br cr dtl entity
	 */
	public EDPTedpBrCrDtlEntity hdrDtoToBrCrDtlEntity(EDPTedpBrHdrDto dto) {
		EDPTedpBrCrDtlEntity dtlEntity = new EDPTedpBrCrDtlEntity();
		dtlEntity.setTedpBrHdrId(new EDPTedpBrHdrEntity(dto.getTedpBrHdrId()));
		dtlEntity.setBranchName(dto.getBranchName());
		dtlEntity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		dtlEntity.setBranchTypeId(new EDPLuLookUpInfoEntity(dto.getBranchType()));
		if(null != dto.getBranchId())
			dtlEntity.setBranchId(new EDPMsBranchEntity(dto.getBranchId()));
		return dtlEntity;
	}

	public EDPTedpBrHdrEntity brMapDtoToEntity(EDPTedpBrDtlDto dto) {
		EDPTedpBrHdrEntity entity = new EDPTedpBrHdrEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getRequestType())
			entity.setRequestType(new EDPLuLookUpInfoEntity(dto.getRequestType()));
		if(dto.getFormAction() == Status.SUBMITTED)
			entity.setStatusId(new EDPLuLookUpInfoEntity(EDPConstant.STATUS_APPROVE_ID));
		else 
			entity.setStatusId(new EDPLuLookUpInfoEntity(Constant.SAVE_AS_DRAFT_STATUS_ID));
		return entity;
	}
	
	public EDPTedpBrDtlEntity hdrDtoToBrDtlEntity( EDPTedpBrDtlDto dto) {
		EDPTedpBrDtlEntity dtlEntity = new EDPTedpBrDtlEntity();
		dtlEntity.setTedpBrHdrId(new EDPTedpBrHdrEntity(dto.getTedpBrHdrId()));
		dtlEntity.setFromPouId(new EDPLkPoOffUserEntity(dto.getFromPouId()));
		dtlEntity.setToPouId(EDPConstant.BRANCH_TRANSFER_REQ_TYPE_ID.equals(dto.getRequestType()) ? 
				new EDPLkPoOffUserEntity(dto.getToPouId())
				:new EDPLkPoOffUserEntity(dto.getFromPouId())) ;
		return dtlEntity;
	}
}

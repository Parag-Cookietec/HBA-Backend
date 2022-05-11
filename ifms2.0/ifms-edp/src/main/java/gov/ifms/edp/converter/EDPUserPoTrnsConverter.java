package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPUsrPoTrnsDetailDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsHeaderDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsHeaderEntity;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPUserPoTrnsConverter class.
 * 
 * @version 1.0
 * @created 2020/01/02 14:26:15
 *
 */
@Component
public class EDPUserPoTrnsConverter implements BaseConverter<EDPUsrPoTrnsEntity, EDPUsrPoTrnsDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPUserPoTrns entity
	 */
	@Override
	public EDPUsrPoTrnsEntity toEntity(EDPUsrPoTrnsDetailDto dto) {
		EDPUsrPoTrnsEntity entity = new EDPUsrPoTrnsEntity();
		if (dto.getEdpUsrPoTrnsHeaderId() != null && dto.getEdpUsrPoTrnsHeaderId() != 0) {
			entity.setEdpUsrPoTrnsHeaderId(new EDPUsrPoTrnsHeaderEntity(dto.getEdpUsrPoTrnsHeaderId()));
		}
		if (dto.getPostOfficeId() != null && dto.getPostOfficeId() != 0) {
			entity.setPostOfficeId(new EDPLkPostOfficeEntity(dto.getPostOfficeId()));
		}
		entity.setPostOfficeId(new EDPLkPostOfficeEntity(dto.getPostOfficeId()));
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPUserPoTrns dto
	 */
	@Override
	public EDPUsrPoTrnsDetailDto toDTO(EDPUsrPoTrnsEntity entity) {
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		dto.setEdpUsrPoTrnsHeaderId(entity.getEdpUsrPoTrnsHeaderId().getEdpUsrPoTrnsHeaderId());
		dto.setPostOfficeId(entity.getPostOfficeId().getPostOfficeId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * Trns detail dto to new EDP usr po trns entity.
	 *
	 * @param dto the dto
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @return the EDP usr po trns entity
	 */
	public EDPUsrPoTrnsEntity trnsDetailDtoToNewEDPUsrPoTrnsEntity(EDPUsrPoTrnsDetailDto dto, EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto) {
		EDPUsrPoTrnsEntity entity = new EDPUsrPoTrnsEntity();
		entity.setEdpUsrPoTrnsHeaderId(new EDPUsrPoTrnsHeaderEntity(edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId()));
		entity.setPostOfficeId(new EDPLkPostOfficeEntity(dto.getPostOfficeId()));
		if(null != edpUsrPoTrnsHeaderDto.getFromUserId()) {
			entity.setFromUserId(new EDPMsUserEntity(edpUsrPoTrnsHeaderDto.getFromUserId()));
		}
		if(null != edpUsrPoTrnsHeaderDto.getToEmpId()) {
			entity.setToEmpId(new EDPEmployeEntity(edpUsrPoTrnsHeaderDto.getToEmpId()));
		}
		if(null != edpUsrPoTrnsHeaderDto.getToUserId()) {
			entity.setToUserId(new EDPMsUserEntity(edpUsrPoTrnsHeaderDto.getToUserId()));
		}
		if(null != dto.getWillBePrimary() && dto.getWillBePrimary()) {
			entity.setWillBePrimary(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		} else if (null != dto.getWillBePrimary()) {
			entity.setWillBePrimary(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
		}
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}
	
	/**
	 * Trns detail dto to EDP usr po trns entity.
	 *
	 * @param edpUsrPoTrnsDetailDto the edp usr po trns detail dto
	 * @param savedEntity the saved entity
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @return the EDP usr po trns entity
	 */
	public EDPUsrPoTrnsEntity trnsDetailDtoToEDPUsrPoTrnsEntity(EDPUsrPoTrnsDetailDto dto, 
			EDPUsrPoTrnsEntity entity, EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto) {
		entity.setPostOfficeId(new EDPLkPostOfficeEntity(dto.getPostOfficeId()));
		entity.setFromUserId(null != edpUsrPoTrnsHeaderDto.getFromUserId() 
							? new EDPMsUserEntity(edpUsrPoTrnsHeaderDto.getFromUserId()):null);
		entity.setToEmpId(null != edpUsrPoTrnsHeaderDto.getToEmpId()
							?new EDPEmployeEntity(edpUsrPoTrnsHeaderDto.getToEmpId()):null);
		entity.setToUserId(null != edpUsrPoTrnsHeaderDto.getToUserId()
							?new EDPMsUserEntity(edpUsrPoTrnsHeaderDto.getToUserId()):null);
		if(null != dto.getWillBePrimary() && dto.getWillBePrimary()) {
			entity.setWillBePrimary(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		} else if (null != dto.getWillBePrimary()) {
			entity.setWillBePrimary(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
		} else {
			entity.setWillBePrimary(null);
		}
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}
}

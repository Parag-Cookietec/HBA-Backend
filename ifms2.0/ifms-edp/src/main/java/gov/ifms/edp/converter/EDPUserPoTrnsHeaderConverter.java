package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPUsrPoTrnsHeaderDto;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsHeaderEntity;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPUserPoTrnsHeaderConverter.
 */
@Component
public class EDPUserPoTrnsHeaderConverter implements BaseConverter<EDPUsrPoTrnsHeaderEntity, EDPUsrPoTrnsHeaderDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPUserPoTrns entity
	 */
	@Override
	public EDPUsrPoTrnsHeaderEntity toEntity(EDPUsrPoTrnsHeaderDto dto) {
		EDPUsrPoTrnsHeaderEntity entity = new EDPUsrPoTrnsHeaderEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		if(null != dto.getStatusId())
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		if(null != dto.getHasObjection() && dto.getHasObjection()) {
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		}else if(null != dto.getHasObjection()) {
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));			
		}
		if(dto.isWfInRequest()) {
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		}else {
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));			
		}
		if(null != dto.getInitiatedBy()) {
			entity.setInitiatedBy(new EDPLkPoOffUserEntity(dto.getInitiatedBy()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPUserPoTrns dto
	 */
	@Override
	public EDPUsrPoTrnsHeaderDto toDTO(EDPUsrPoTrnsHeaderEntity entity) {
		EDPUsrPoTrnsHeaderDto dto = new EDPUsrPoTrnsHeaderDto();
		dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

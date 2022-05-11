package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsRolePermissionsDto;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsRolePermissionsConverter.
 */
@Component
public class EDPMsRolePermissionsConverter
		implements BaseConverter<EDPMsRolePermissionsEntity, EDPMsRolePermissionsDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP ms role permissions entity
	 */
	@Override
	public EDPMsRolePermissionsEntity toEntity(EDPMsRolePermissionsDto dto) {
		EDPMsRolePermissionsEntity entity = new EDPMsRolePermissionsEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP ms role permissions dto
	 */
	@Override
	public EDPMsRolePermissionsDto toDTO(EDPMsRolePermissionsEntity entity) {
		EDPMsRolePermissionsDto dto = new EDPMsRolePermissionsDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public ClueDto toClueDTO(EDPMsRolePermissionsEntity entity) {
		ClueDto dto = new ClueDto();
		dto.setRoleName(entity.getRoleName());
		return dto;
	}

	/**
	 * Creates the EDP ms role permissions dto from obj.
	 *
	 * @return the EDP ms role permissions dto
	 */
	public EDPMsRolePermissionsDto createEDPMsRolePermissionsDtoFromObj(Object[] object) {
		EDPMsRolePermissionsDto dto = new EDPMsRolePermissionsDto();
		dto.setRoleActivityId(EDPUtility.convertObjectToLong(object[0]));
		dto.setRoleName(EDPUtility.convertObjectToString(object[1]));
		
		dto.setRoleNameGuj(null!= object[2]?EDPUtility.convertObjectToString(object[2]):null);
		dto.setRoleDescription(null!= object[3]?EDPUtility.convertObjectToString(object[3]):null);
		dto.setRoleDescriptionGuj(null!= object[4]?EDPUtility.convertObjectToString(object[4]):null);
		dto.setRoleCodeName(null!= object[6]?EDPUtility.convertObjectToString(object[6]):null);
		
		dto.setRoleCode(EDPUtility.convertObjectToString(object[5]));		
		dto.setRoelTypeId(EDPUtility.convertObjectToInt(object[7]));
		dto.setParentRoleId(EDPUtility.convertObjectToInt(object[8]));
		dto.setCreatedBy(EDPUtility.convertObjectToLong(object[9]));
		dto.setCreatedDate(EDPUtility.convertObjectToDate(object[10]));
		dto.setCreatedByPost(EDPUtility.convertObjectToLong(object[11]));
		dto.setUpdatedBy(EDPUtility.convertObjectToLong(object[12]));
		dto.setUpdatedDate(EDPUtility.convertObjectToDate(object[13]));
		dto.setUpdatedByPost(EDPUtility.convertObjectToLong(object[14]));
		dto.setActiveStatus(EDPUtility.convertObjectToInt(object[15]));
		return dto;
	}


}

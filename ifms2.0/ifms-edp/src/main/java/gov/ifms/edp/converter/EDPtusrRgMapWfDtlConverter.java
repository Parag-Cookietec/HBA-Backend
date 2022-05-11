package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPtusrRgMapWfDtlDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPtusrRgMapDtlEntity;
import gov.ifms.edp.entity.EDPtusrRgMapWfDtlEntity;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPtusrRgMapWfDtlConverter class.
 * 
 * @version 1.0
 * @created 2020/07/16 09:34:26
 *
 */
@Component
public class EDPtusrRgMapWfDtlConverter implements BaseConverter<EDPtusrRgMapWfDtlEntity,EDPtusrRgMapWfDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPtusrRgMapWfDtl entity
	 */
	@Override
	public EDPtusrRgMapWfDtlEntity toEntity(EDPtusrRgMapWfDtlDto dto) {
		EDPtusrRgMapWfDtlEntity entity = new EDPtusrRgMapWfDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPtusrRgMapWfDtl  dto
	 */
	@Override
	public EDPtusrRgMapWfDtlDto toDTO(EDPtusrRgMapWfDtlEntity entity) {
		EDPtusrRgMapWfDtlDto dto = new EDPtusrRgMapWfDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Rights mapping data dtoto entity.
	 *
	 * @param wfDataDto the wf data dto
	 * @param dtlEntity the dtl entity
	 * @return the list
	 */
	public List<EDPtusrRgMapWfDtlEntity> rightsMappingDataDtotoEntity(List<ClueDto> wfDataDto,List<ClueDto> olfWfRole,EDPtusrRgMapDtlEntity dtlEntity) {
		String oldWfRoleName = olfWfRole.stream().map(ClueDto::getName).collect(Collectors.joining(Constant.COMMA));
		return wfDataDto.stream().map(dto->rightsMappingDataDtotoEntity(dto,oldWfRoleName,dtlEntity)).collect(Collectors.toList());
	}
	
	/**
	 * Rights mapping data dtoto entity.
	 *
	 * @param dataDto the data dto
	 * @param dtlEntity the dtl entity
	 * @return the ED ptusr rg map wf dtl entity
	 */
	public EDPtusrRgMapWfDtlEntity rightsMappingDataDtotoEntity(ClueDto dataDto,String oldWfRoleName,EDPtusrRgMapDtlEntity dtlEntity) {
		EDPtusrRgMapWfDtlEntity wfEntity = new EDPtusrRgMapWfDtlEntity();
		wfEntity.setTusrRgMapDtlId(dtlEntity);
		wfEntity.setWfRoleId(dataDto.getId());
		if(dataDto.getIsWfRoleRemoved())
			wfEntity.setIsRemoved(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		else
			wfEntity.setIsRemoved(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
		wfEntity.setOldWfRoleId(oldWfRoleName);
		return wfEntity;
	}

	/**
	 * Rights mapping data dtoto entity to saved entity.
	 *
	 * @param clueDto the clue dto
	 * @param oldWfRoleList the old wf role list
	 * @param wfSavedEntity the wf saved entity
	 * @param savedEntity the saved entity
	 * @return the ED ptusr rg map wf dtl entity
	 */
	public EDPtusrRgMapWfDtlEntity rightsMappingDataDtotoEntityToSavedEntity(ClueDto clueDto, List<ClueDto> oldWfRoleList, EDPtusrRgMapWfDtlEntity wfSavedEntity, EDPtusrRgMapDtlEntity savedEntity) {
		String oldWfRoleName = oldWfRoleList.stream().map(ClueDto::getName).collect(Collectors.joining(Constant.COMMA));
		wfSavedEntity.setTusrRgMapDtlId(savedEntity);
		wfSavedEntity.setWfRoleId(clueDto.getId());
		if(clueDto.getIsWfRoleRemoved())
			wfSavedEntity.setIsRemoved(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		else
			wfSavedEntity.setIsRemoved(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
		wfSavedEntity.setOldWfRoleId(oldWfRoleName);
		wfSavedEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		return wfSavedEntity;
	}
	
	/**
	 * Convert saved entity to new entity.
	 *
	 * @return the ED ptusr rg map wf dtl entity
	 */
	public EDPtusrRgMapWfDtlEntity convertSavedEntityToNewEntity(EDPtusrRgMapWfDtlEntity savedEntity,EDPtusrRgMapWfDtlEntity newEntity) {
		savedEntity.setTusrRgMapDtlId(newEntity.getTusrRgMapDtlId());
		savedEntity.setWfRoleId(newEntity.getWfRoleId());
		savedEntity.setIsRemoved(newEntity.getIsRemoved());
		savedEntity.setOldWfRoleId(newEntity.getOldWfRoleId());
		savedEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		return savedEntity;
	}
}

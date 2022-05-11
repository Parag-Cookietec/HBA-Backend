package gov.ifms.edp.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPBillObjectClassMapDto;
import gov.ifms.edp.entity.EDPBillObjectClassMapEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class EDPBillObjectClassMapConverter.
 */
@Component
public class EDPBillObjectClassMapConverter implements BaseConverter<EDPBillObjectClassMapEntity,EDPBillObjectClassMapDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPTBillObjectMap entity
	 */
	@Override
	public EDPBillObjectClassMapEntity toEntity(EDPBillObjectClassMapDto dto) {
		EDPBillObjectClassMapEntity entity = new EDPBillObjectClassMapEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	
	
	
	/**
	 * To list of entity.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<EDPBillObjectClassMapEntity> toListOfEntity(EDPBillObjectClassMapDto dto) {
		List<EDPBillObjectClassMapEntity> entityList = new ArrayList<>();
		dto.getObjectClassId().forEach(classId -> {
			EDPBillObjectClassMapEntity entity = new EDPBillObjectClassMapEntity();
			entity.setBillTypeId(new EDPLuLookUpInfoEntity(dto.getBillTypeId()));
			entity.setObjectClassId(classId);
			entityList.add(entity);
		});
		return entityList;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPTBillObjectMap  dto
	 */
	@Override
	public EDPBillObjectClassMapDto toDTO(EDPBillObjectClassMapEntity entity) {
		EDPBillObjectClassMapDto dto = new EDPBillObjectClassMapDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
	/**
	 * List to DTO.
	 *
	 * @param entitylist the entitylist
	 * @return the EDP bill object class map dto
	 */
	public EDPBillObjectClassMapDto listToDTO(List<EDPBillObjectClassMapEntity> entitylist) {
		EDPBillObjectClassMapDto dto = new EDPBillObjectClassMapDto();
		if(CollectionUtils.isNotEmpty(entitylist)) {
			EDPBillObjectClassMapEntity entity=entitylist.get(0);
			dto.setBillObjmapId(entity.getBillObjmapId());
			dto.setBillTypeId(entity.getBillTypeId().getLookUpInfoId());
			dto.setObjectClassId(entitylist.stream().map(EDPBillObjectClassMapEntity::getObjectClassId).collect(Collectors.toList()));
		}
		return dto;
	}
	
}

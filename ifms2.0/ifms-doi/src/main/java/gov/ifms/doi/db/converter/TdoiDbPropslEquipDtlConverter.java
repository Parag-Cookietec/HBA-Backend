package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslEquipDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslEquipDtlEntity;

@Component
public class TdoiDbPropslEquipDtlConverter{

	public TdoiDbPropslEquipDtlEntity toEntity(TdoiDbPropslEquipDtlDTO dto) {
		TdoiDbPropslEquipDtlEntity entity = new TdoiDbPropslEquipDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslEquipDtlDTO> toDtoListFromEntityList(List<TdoiDbPropslEquipDtlEntity> entityList) {
		List<TdoiDbPropslEquipDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslEquipDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslEquipDtlDTO toDtoFromEntity(TdoiDbPropslEquipDtlEntity entity) {
		TdoiDbPropslEquipDtlDTO dto=new TdoiDbPropslEquipDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


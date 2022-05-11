package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslElecEquipDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslElecEquipEntity;

@Component
public class TdoiDbPropslElecEquipConverter{

	public TdoiDbPropslElecEquipEntity toEntity(TdoiDbPropslElecEquipDTO dto) {
		TdoiDbPropslElecEquipEntity entity = new TdoiDbPropslElecEquipEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslElecEquipDTO> toDtoListFromEntityList(List<TdoiDbPropslElecEquipEntity> entityList) {
		List<TdoiDbPropslElecEquipDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslElecEquipEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslElecEquipDTO toDtoFromEntity(TdoiDbPropslElecEquipEntity entity) {
		TdoiDbPropslElecEquipDTO dto=new TdoiDbPropslElecEquipDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


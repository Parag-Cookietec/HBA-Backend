package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolElecEquipDTO;

import gov.ifms.doi.db.entity.TdoiDbPolElecEquipEntity;

@Component
public class TdoiDbPolElecEquipConverter{

	public TdoiDbPolElecEquipEntity toEntity(TdoiDbPolElecEquipDTO dto) {
		TdoiDbPolElecEquipEntity entity = new TdoiDbPolElecEquipEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolElecEquipDTO> toDtoListFromEntityList(List<TdoiDbPolElecEquipEntity> entityList) {
		List<TdoiDbPolElecEquipDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolElecEquipEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolElecEquipDTO toDtoFromEntity(TdoiDbPolElecEquipEntity entity) {
		TdoiDbPolElecEquipDTO dto=new TdoiDbPolElecEquipDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


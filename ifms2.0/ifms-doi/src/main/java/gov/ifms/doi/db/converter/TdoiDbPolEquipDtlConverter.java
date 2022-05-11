package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolEquipDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPolEquipDtlEntity;

@Component
public class TdoiDbPolEquipDtlConverter{

	public TdoiDbPolEquipDtlEntity toEntity(TdoiDbPolEquipDtlDTO dto) {
		TdoiDbPolEquipDtlEntity entity = new TdoiDbPolEquipDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolEquipDtlDTO> toDtoListFromEntityList(List<TdoiDbPolEquipDtlEntity> entityList) {
		List<TdoiDbPolEquipDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolEquipDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolEquipDtlDTO toDtoFromEntity(TdoiDbPolEquipDtlEntity entity) {
		TdoiDbPolEquipDtlDTO dto=new TdoiDbPolEquipDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


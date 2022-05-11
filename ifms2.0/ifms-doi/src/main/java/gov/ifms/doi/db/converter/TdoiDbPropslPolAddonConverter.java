package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslPolAddonDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslPolAddonEntity;

@Component
public class TdoiDbPropslPolAddonConverter{

	public TdoiDbPropslPolAddonEntity toEntity(TdoiDbPropslPolAddonDTO dto) {
		TdoiDbPropslPolAddonEntity entity = new TdoiDbPropslPolAddonEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslPolAddonDTO> toDtoListFromEntityList(List<TdoiDbPropslPolAddonEntity> entityList) {
		List<TdoiDbPropslPolAddonDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslPolAddonEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslPolAddonDTO toDtoFromEntity(TdoiDbPropslPolAddonEntity entity) {
		TdoiDbPropslPolAddonDTO dto=new TdoiDbPropslPolAddonDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslFirePerilDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslFirePerilEntity;

@Component
public class TdoiDbPropslFirePerilConverter{

	public TdoiDbPropslFirePerilEntity toEntity(TdoiDbPropslFirePerilDTO dto) {
		TdoiDbPropslFirePerilEntity entity = new TdoiDbPropslFirePerilEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslFirePerilDTO> toDtoListFromEntityList(List<TdoiDbPropslFirePerilEntity> entityList) {
		List<TdoiDbPropslFirePerilDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslFirePerilEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslFirePerilDTO toDtoFromEntity(TdoiDbPropslFirePerilEntity entity) {
		TdoiDbPropslFirePerilDTO dto=new TdoiDbPropslFirePerilDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


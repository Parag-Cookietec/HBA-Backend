package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslAviationDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslAviationEntity;

@Component
public class TdoiDbPropslAviationConverter{

	public TdoiDbPropslAviationEntity toEntity(TdoiDbPropslAviationDTO dto) {
		TdoiDbPropslAviationEntity entity = new TdoiDbPropslAviationEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslAviationDTO> toDtoListFromEntityList(List<TdoiDbPropslAviationEntity> entityList) {
		List<TdoiDbPropslAviationDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslAviationEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslAviationDTO toDtoFromEntity(TdoiDbPropslAviationEntity entity) {
		TdoiDbPropslAviationDTO dto=new TdoiDbPropslAviationDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


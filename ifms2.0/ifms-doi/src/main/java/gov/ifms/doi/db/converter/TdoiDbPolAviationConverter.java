package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolAviationDTO;

import gov.ifms.doi.db.entity.TdoiDbPolAviationEntity;

@Component
public class TdoiDbPolAviationConverter{

	public TdoiDbPolAviationEntity toEntity(TdoiDbPolAviationDTO dto) {
		TdoiDbPolAviationEntity entity = new TdoiDbPolAviationEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolAviationDTO> toDtoListFromEntityList(List<TdoiDbPolAviationEntity> entityList) {
		List<TdoiDbPolAviationDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolAviationEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolAviationDTO toDtoFromEntity(TdoiDbPolAviationEntity entity) {
		TdoiDbPolAviationDTO dto=new TdoiDbPolAviationDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


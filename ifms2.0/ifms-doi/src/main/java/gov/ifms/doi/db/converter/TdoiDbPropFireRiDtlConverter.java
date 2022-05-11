package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropFireRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPropFireRiDtlEntity;

@Component
public class TdoiDbPropFireRiDtlConverter{

	public TdoiDbPropFireRiDtlEntity toEntity(TdoiDbPropFireRiDtlDTO dto) {
		TdoiDbPropFireRiDtlEntity entity = new TdoiDbPropFireRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropFireRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPropFireRiDtlEntity> entityList) {
		List<TdoiDbPropFireRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropFireRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropFireRiDtlDTO toDtoFromEntity(TdoiDbPropFireRiDtlEntity entity) {
		TdoiDbPropFireRiDtlDTO dto=new TdoiDbPropFireRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


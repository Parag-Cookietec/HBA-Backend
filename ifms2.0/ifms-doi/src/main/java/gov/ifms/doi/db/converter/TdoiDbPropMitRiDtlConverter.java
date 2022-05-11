package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropMitRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPropMitRiDtlEntity;

@Component
public class TdoiDbPropMitRiDtlConverter{

	public TdoiDbPropMitRiDtlEntity toEntity(TdoiDbPropMitRiDtlDTO dto) {
		TdoiDbPropMitRiDtlEntity entity = new TdoiDbPropMitRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropMitRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPropMitRiDtlEntity> entityList) {
		List<TdoiDbPropMitRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropMitRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropMitRiDtlDTO toDtoFromEntity(TdoiDbPropMitRiDtlEntity entity) {
		TdoiDbPropMitRiDtlDTO dto=new TdoiDbPropMitRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


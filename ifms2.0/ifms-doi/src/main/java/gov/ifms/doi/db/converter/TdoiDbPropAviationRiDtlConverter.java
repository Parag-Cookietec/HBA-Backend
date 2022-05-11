package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropAviationRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPropAviationRiDtlEntity;

@Component
public class TdoiDbPropAviationRiDtlConverter{

	public TdoiDbPropAviationRiDtlEntity toEntity(TdoiDbPropAviationRiDtlDTO dto) {
		TdoiDbPropAviationRiDtlEntity entity = new TdoiDbPropAviationRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropAviationRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPropAviationRiDtlEntity> entityList) {
		List<TdoiDbPropAviationRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropAviationRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropAviationRiDtlDTO toDtoFromEntity(TdoiDbPropAviationRiDtlEntity entity) {
		TdoiDbPropAviationRiDtlDTO dto=new TdoiDbPropAviationRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


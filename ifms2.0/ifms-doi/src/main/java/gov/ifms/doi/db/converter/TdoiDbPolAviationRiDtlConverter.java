package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolAviationRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPolAviationRiDtlEntity;

@Component
public class TdoiDbPolAviationRiDtlConverter{

	public TdoiDbPolAviationRiDtlEntity toEntity(TdoiDbPolAviationRiDtlDTO dto) {
		TdoiDbPolAviationRiDtlEntity entity = new TdoiDbPolAviationRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolAviationRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPolAviationRiDtlEntity> entityList) {
		List<TdoiDbPolAviationRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolAviationRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolAviationRiDtlDTO toDtoFromEntity(TdoiDbPolAviationRiDtlEntity entity) {
		TdoiDbPolAviationRiDtlDTO dto=new TdoiDbPolAviationRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


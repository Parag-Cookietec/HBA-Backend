package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolMitRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPolMitRiDtlEntity;

@Component
public class TdoiDbPolMitRiDtlConverter{

	public TdoiDbPolMitRiDtlEntity toEntity(TdoiDbPolMitRiDtlDTO dto) {
		TdoiDbPolMitRiDtlEntity entity = new TdoiDbPolMitRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolMitRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPolMitRiDtlEntity> entityList) {
		List<TdoiDbPolMitRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolMitRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolMitRiDtlDTO toDtoFromEntity(TdoiDbPolMitRiDtlEntity entity) {
		TdoiDbPolMitRiDtlDTO dto=new TdoiDbPolMitRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


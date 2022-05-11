package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolBuglrRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPolBuglrRiDtlEntity;

@Component
public class TdoiDbPolBuglrRiDtlConverter{

	public TdoiDbPolBuglrRiDtlEntity toEntity(TdoiDbPolBuglrRiDtlDTO dto) {
		TdoiDbPolBuglrRiDtlEntity entity = new TdoiDbPolBuglrRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolBuglrRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPolBuglrRiDtlEntity> entityList) {
		List<TdoiDbPolBuglrRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolBuglrRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolBuglrRiDtlDTO toDtoFromEntity(TdoiDbPolBuglrRiDtlEntity entity) {
		TdoiDbPolBuglrRiDtlDTO dto=new TdoiDbPolBuglrRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


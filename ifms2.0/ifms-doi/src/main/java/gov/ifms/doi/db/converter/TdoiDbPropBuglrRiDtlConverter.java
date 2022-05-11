package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropBuglrRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPropBuglrRiDtlEntity;

@Component
public class TdoiDbPropBuglrRiDtlConverter{

	public TdoiDbPropBuglrRiDtlEntity toEntity(TdoiDbPropBuglrRiDtlDTO dto) {
		TdoiDbPropBuglrRiDtlEntity entity = new TdoiDbPropBuglrRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropBuglrRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPropBuglrRiDtlEntity> entityList) {
		List<TdoiDbPropBuglrRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropBuglrRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropBuglrRiDtlDTO toDtoFromEntity(TdoiDbPropBuglrRiDtlEntity entity) {
		TdoiDbPropBuglrRiDtlDTO dto=new TdoiDbPropBuglrRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


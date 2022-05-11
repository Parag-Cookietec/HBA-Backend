package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropElecRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPropElecRiDtlEntity;

@Component
public class TdoiDbPropElecRiDtlConverter{

	public TdoiDbPropElecRiDtlEntity toEntity(TdoiDbPropElecRiDtlDTO dto) {
		TdoiDbPropElecRiDtlEntity entity = new TdoiDbPropElecRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropElecRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPropElecRiDtlEntity> entityList) {
		List<TdoiDbPropElecRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropElecRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropElecRiDtlDTO toDtoFromEntity(TdoiDbPropElecRiDtlEntity entity) {
		TdoiDbPropElecRiDtlDTO dto=new TdoiDbPropElecRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcTeExpenditureDtlDTO;

import gov.ifms.doi.ac.entity.TdoiAcTeExpenditureDtlEntity;

@Component
public class TdoiAcTeExpenditureDtlConverter{

	public TdoiAcTeExpenditureDtlEntity toEntity(TdoiAcTeExpenditureDtlDTO dto) {
		TdoiAcTeExpenditureDtlEntity entity = new TdoiAcTeExpenditureDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcTeExpenditureDtlDTO> toDtoListFromEntityList(List<TdoiAcTeExpenditureDtlEntity> entityList) {
		List<TdoiAcTeExpenditureDtlDTO> dtoList = new ArrayList<>();
		for (TdoiAcTeExpenditureDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcTeExpenditureDtlDTO toDtoFromEntity(TdoiAcTeExpenditureDtlEntity entity) {
		TdoiAcTeExpenditureDtlDTO dto=new TdoiAcTeExpenditureDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


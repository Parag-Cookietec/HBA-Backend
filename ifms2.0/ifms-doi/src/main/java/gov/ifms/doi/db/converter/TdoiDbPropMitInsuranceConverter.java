package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropMitInsuranceDTO;

import gov.ifms.doi.db.entity.TdoiDbPropMitInsuranceEntity;

@Component
public class TdoiDbPropMitInsuranceConverter{

	public TdoiDbPropMitInsuranceEntity toEntity(TdoiDbPropMitInsuranceDTO dto) {
		TdoiDbPropMitInsuranceEntity entity = new TdoiDbPropMitInsuranceEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropMitInsuranceDTO> toDtoListFromEntityList(List<TdoiDbPropMitInsuranceEntity> entityList) {
		List<TdoiDbPropMitInsuranceDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropMitInsuranceEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropMitInsuranceDTO toDtoFromEntity(TdoiDbPropMitInsuranceEntity entity) {
		TdoiDbPropMitInsuranceDTO dto=new TdoiDbPropMitInsuranceDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolMitInsuranceDTO;

import gov.ifms.doi.db.entity.TdoiDbPolMitInsuranceEntity;

@Component
public class TdoiDbPolMitInsuranceConverter{

	public TdoiDbPolMitInsuranceEntity toEntity(TdoiDbPolMitInsuranceDTO dto) {
		TdoiDbPolMitInsuranceEntity entity = new TdoiDbPolMitInsuranceEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolMitInsuranceDTO> toDtoListFromEntityList(List<TdoiDbPolMitInsuranceEntity> entityList) {
		List<TdoiDbPolMitInsuranceDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolMitInsuranceEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolMitInsuranceDTO toDtoFromEntity(TdoiDbPolMitInsuranceEntity entity) {
		TdoiDbPolMitInsuranceDTO dto=new TdoiDbPolMitInsuranceDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolicyListDTO;

import gov.ifms.doi.db.entity.TdoiDbPolicyListEntity;

@Component
public class TdoiDbPolicyListConverter{

	public TdoiDbPolicyListEntity toEntity(TdoiDbPolicyListDTO dto) {
		TdoiDbPolicyListEntity entity = new TdoiDbPolicyListEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolicyListDTO> toDtoListFromEntityList(List<TdoiDbPolicyListEntity> entityList) {
		List<TdoiDbPolicyListDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolicyListEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolicyListDTO toDtoFromEntity(TdoiDbPolicyListEntity entity) {
		TdoiDbPolicyListDTO dto=new TdoiDbPolicyListDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbFirePastPolicyDTO;

import gov.ifms.doi.db.entity.TdoiDbFirePastPolicyEntity;

@Component
public class TdoiDbFirePastPolicyConverter{

	public TdoiDbFirePastPolicyEntity toEntity(TdoiDbFirePastPolicyDTO dto) {
		TdoiDbFirePastPolicyEntity entity = new TdoiDbFirePastPolicyEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbFirePastPolicyDTO> toDtoListFromEntityList(List<TdoiDbFirePastPolicyEntity> entityList) {
		List<TdoiDbFirePastPolicyDTO> dtoList = new ArrayList<>();
		for (TdoiDbFirePastPolicyEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbFirePastPolicyDTO toDtoFromEntity(TdoiDbFirePastPolicyEntity entity) {
		TdoiDbFirePastPolicyDTO dto=new TdoiDbFirePastPolicyDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


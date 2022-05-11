package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslPolicyDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslPolicyEntity;

@Component
public class TdoiDbPropslPolicyConverter {

	public TdoiDbPropslPolicyEntity toEntity(TdoiDbPropslPolicyDTO dto) {
		TdoiDbPropslPolicyEntity entity = new TdoiDbPropslPolicyEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<TdoiDbPropslPolicyDTO> toDtoListFromEntityList(List<TdoiDbPropslPolicyEntity> entityList) {
		List<TdoiDbPropslPolicyDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslPolicyEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
		return dtoList;
	}

	public TdoiDbPropslPolicyDTO toDtoFromEntity(TdoiDbPropslPolicyEntity entity) {
		TdoiDbPropslPolicyDTO dto = new TdoiDbPropslPolicyDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

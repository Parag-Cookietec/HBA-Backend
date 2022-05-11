package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolFirePastPolicyDTO;

import gov.ifms.doi.db.entity.TdoiDbPolFirePastPolicyEntity;

@Component
public class TdoiDbPolFirePastPolicyConverter{

	public TdoiDbPolFirePastPolicyEntity toEntity(TdoiDbPolFirePastPolicyDTO dto) {
		TdoiDbPolFirePastPolicyEntity entity = new TdoiDbPolFirePastPolicyEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolFirePastPolicyDTO> toDtoListFromEntityList(List<TdoiDbPolFirePastPolicyEntity> entityList) {
		List<TdoiDbPolFirePastPolicyDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolFirePastPolicyEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolFirePastPolicyDTO toDtoFromEntity(TdoiDbPolFirePastPolicyEntity entity) {
		TdoiDbPolFirePastPolicyDTO dto=new TdoiDbPolFirePastPolicyDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


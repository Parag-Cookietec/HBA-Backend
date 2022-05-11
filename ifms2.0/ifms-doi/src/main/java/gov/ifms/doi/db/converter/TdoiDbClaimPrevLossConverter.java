package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbClaimPrevLossDTO;

import gov.ifms.doi.db.entity.TdoiDbClaimPrevLossEntity;

@Component
public class TdoiDbClaimPrevLossConverter{

	public TdoiDbClaimPrevLossEntity toEntity(TdoiDbClaimPrevLossDTO dto) {
		TdoiDbClaimPrevLossEntity entity = new TdoiDbClaimPrevLossEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbClaimPrevLossDTO> toDtoListFromEntityList(List<TdoiDbClaimPrevLossEntity> entityList) {
		List<TdoiDbClaimPrevLossDTO> dtoList = new ArrayList<>();
		for (TdoiDbClaimPrevLossEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbClaimPrevLossDTO toDtoFromEntity(TdoiDbClaimPrevLossEntity entity) {
		TdoiDbClaimPrevLossDTO dto=new TdoiDbClaimPrevLossDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


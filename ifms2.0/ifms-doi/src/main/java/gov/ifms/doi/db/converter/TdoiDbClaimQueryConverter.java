package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbClaimQueryDTO;

import gov.ifms.doi.db.entity.TdoiDbClaimQueryEntity;

@Component
public class TdoiDbClaimQueryConverter{

	public TdoiDbClaimQueryEntity toEntity(TdoiDbClaimQueryDTO dto) {
		TdoiDbClaimQueryEntity entity = new TdoiDbClaimQueryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbClaimQueryDTO> toDtoListFromEntityList(List<TdoiDbClaimQueryEntity> entityList) {
		List<TdoiDbClaimQueryDTO> dtoList = new ArrayList<>();
		for (TdoiDbClaimQueryEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbClaimQueryDTO toDtoFromEntity(TdoiDbClaimQueryEntity entity) {
		TdoiDbClaimQueryDTO dto=new TdoiDbClaimQueryDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


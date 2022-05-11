package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbClaimPropDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbClaimPropDtlEntity;

@Component
public class TdoiDbClaimPropDtlConverter{

	public TdoiDbClaimPropDtlEntity toEntity(TdoiDbClaimPropDtlDTO dto) {
		TdoiDbClaimPropDtlEntity entity = new TdoiDbClaimPropDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbClaimPropDtlDTO> toDtoListFromEntityList(List<TdoiDbClaimPropDtlEntity> entityList) {
		List<TdoiDbClaimPropDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbClaimPropDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbClaimPropDtlDTO toDtoFromEntity(TdoiDbClaimPropDtlEntity entity) {
		TdoiDbClaimPropDtlDTO dto=new TdoiDbClaimPropDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


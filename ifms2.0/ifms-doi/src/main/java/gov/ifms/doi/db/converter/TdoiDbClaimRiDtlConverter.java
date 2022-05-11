package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbClaimRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbClaimRiDtlEntity;

@Component
public class TdoiDbClaimRiDtlConverter{

	public TdoiDbClaimRiDtlEntity toEntity(TdoiDbClaimRiDtlDTO dto) {
		TdoiDbClaimRiDtlEntity entity = new TdoiDbClaimRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbClaimRiDtlDTO> toDtoListFromEntityList(List<TdoiDbClaimRiDtlEntity> entityList) {
		List<TdoiDbClaimRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbClaimRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbClaimRiDtlDTO toDtoFromEntity(TdoiDbClaimRiDtlEntity entity) {
		TdoiDbClaimRiDtlDTO dto=new TdoiDbClaimRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


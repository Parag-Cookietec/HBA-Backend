package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbClaimEntryDTO;

import gov.ifms.doi.db.entity.TdoiDbClaimEntryEntity;

@Component
public class TdoiDbClaimEntryConverter{

	public TdoiDbClaimEntryEntity toEntity(TdoiDbClaimEntryDTO dto) {
		TdoiDbClaimEntryEntity entity = new TdoiDbClaimEntryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbClaimEntryDTO> toDtoListFromEntityList(List<TdoiDbClaimEntryEntity> entityList) {
		List<TdoiDbClaimEntryDTO> dtoList = new ArrayList<>();
		for (TdoiDbClaimEntryEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbClaimEntryDTO toDtoFromEntity(TdoiDbClaimEntryEntity entity) {
		TdoiDbClaimEntryDTO dto=new TdoiDbClaimEntryDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


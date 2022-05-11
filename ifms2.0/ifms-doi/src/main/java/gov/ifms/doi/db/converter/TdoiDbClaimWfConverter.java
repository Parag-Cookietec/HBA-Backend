package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbClaimWfDTO;

import gov.ifms.doi.db.entity.TdoiDbClaimWfEntity;

@Component
public class TdoiDbClaimWfConverter{

	public TdoiDbClaimWfEntity toEntity(TdoiDbClaimWfDTO dto) {
		TdoiDbClaimWfEntity entity = new TdoiDbClaimWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbClaimWfDTO> toDtoListFromEntityList(List<TdoiDbClaimWfEntity> entityList) {
		List<TdoiDbClaimWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbClaimWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbClaimWfDTO toDtoFromEntity(TdoiDbClaimWfEntity entity) {
		TdoiDbClaimWfDTO dto=new TdoiDbClaimWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


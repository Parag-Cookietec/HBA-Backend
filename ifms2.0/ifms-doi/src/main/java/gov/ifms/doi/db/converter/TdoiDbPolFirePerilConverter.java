package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolFirePerilDTO;

import gov.ifms.doi.db.entity.TdoiDbPolFirePerilEntity;

@Component
public class TdoiDbPolFirePerilConverter{

	public TdoiDbPolFirePerilEntity toEntity(TdoiDbPolFirePerilDTO dto) {
		TdoiDbPolFirePerilEntity entity = new TdoiDbPolFirePerilEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolFirePerilDTO> toDtoListFromEntityList(List<TdoiDbPolFirePerilEntity> entityList) {
		List<TdoiDbPolFirePerilDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolFirePerilEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolFirePerilDTO toDtoFromEntity(TdoiDbPolFirePerilEntity entity) {
		TdoiDbPolFirePerilDTO dto=new TdoiDbPolFirePerilDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


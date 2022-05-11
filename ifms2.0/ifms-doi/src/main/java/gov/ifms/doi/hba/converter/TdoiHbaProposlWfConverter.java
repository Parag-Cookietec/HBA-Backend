package gov.ifms.doi.hba.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.hba.dto.TdoiHbaProposlWfDTO;

import gov.ifms.doi.hba.entity.TdoiHbaProposlWfEntity;

@Component
public class TdoiHbaProposlWfConverter{

	public TdoiHbaProposlWfEntity toEntity(TdoiHbaProposlWfDTO dto) {
		TdoiHbaProposlWfEntity entity = new TdoiHbaProposlWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiHbaProposlWfDTO> toDtoListFromEntityList(List<TdoiHbaProposlWfEntity> entityList) {
		List<TdoiHbaProposlWfDTO> dtoList = new ArrayList<>();
		for (TdoiHbaProposlWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiHbaProposlWfDTO toDtoFromEntity(TdoiHbaProposlWfEntity entity) {
		TdoiHbaProposlWfDTO dto=new TdoiHbaProposlWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcBtr5DTO;

import gov.ifms.doi.ac.entity.TdoiAcBtr5Entity;

@Component
public class TdoiAcBtr5Converter{

	public TdoiAcBtr5Entity toEntity(TdoiAcBtr5DTO dto) {
		TdoiAcBtr5Entity entity = new TdoiAcBtr5Entity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcBtr5DTO> toDtoListFromEntityList(List<TdoiAcBtr5Entity> entityList) {
		List<TdoiAcBtr5DTO> dtoList = new ArrayList<>();
		for (TdoiAcBtr5Entity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcBtr5DTO toDtoFromEntity(TdoiAcBtr5Entity entity) {
		TdoiAcBtr5DTO dto=new TdoiAcBtr5DTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


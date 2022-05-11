package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbFireSumInsuredDTO;

import gov.ifms.doi.db.entity.TdoiDbFireSumInsuredEntity;

@Component
public class TdoiDbFireSumInsuredConverter{

	public TdoiDbFireSumInsuredEntity toEntity(TdoiDbFireSumInsuredDTO dto) {
		TdoiDbFireSumInsuredEntity entity = new TdoiDbFireSumInsuredEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbFireSumInsuredDTO> toDtoListFromEntityList(List<TdoiDbFireSumInsuredEntity> entityList) {
		List<TdoiDbFireSumInsuredDTO> dtoList = new ArrayList<>();
		for (TdoiDbFireSumInsuredEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbFireSumInsuredDTO toDtoFromEntity(TdoiDbFireSumInsuredEntity entity) {
		TdoiDbFireSumInsuredDTO dto=new TdoiDbFireSumInsuredDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


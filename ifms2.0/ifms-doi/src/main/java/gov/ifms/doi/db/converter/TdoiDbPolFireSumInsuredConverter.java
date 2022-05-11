package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolFireSumInsuredDTO;

import gov.ifms.doi.db.entity.TdoiDbPolFireSumInsuredEntity;

@Component
public class TdoiDbPolFireSumInsuredConverter{

	public TdoiDbPolFireSumInsuredEntity toEntity(TdoiDbPolFireSumInsuredDTO dto) {
		TdoiDbPolFireSumInsuredEntity entity = new TdoiDbPolFireSumInsuredEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolFireSumInsuredDTO> toDtoListFromEntityList(List<TdoiDbPolFireSumInsuredEntity> entityList) {
		List<TdoiDbPolFireSumInsuredDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolFireSumInsuredEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolFireSumInsuredDTO toDtoFromEntity(TdoiDbPolFireSumInsuredEntity entity) {
		TdoiDbPolFireSumInsuredDTO dto=new TdoiDbPolFireSumInsuredDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


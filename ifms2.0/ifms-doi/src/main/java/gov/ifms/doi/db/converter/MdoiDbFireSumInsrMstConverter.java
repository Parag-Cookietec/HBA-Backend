package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.MdoiDbFireSumInsrMstDTO;

import gov.ifms.doi.db.entity.MdoiDbFireSumInsrMstEntity;

@Component
public class MdoiDbFireSumInsrMstConverter{

	public MdoiDbFireSumInsrMstEntity toEntity(MdoiDbFireSumInsrMstDTO dto) {
		MdoiDbFireSumInsrMstEntity entity = new MdoiDbFireSumInsrMstEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<MdoiDbFireSumInsrMstDTO> toDtoListFromEntityList(List<MdoiDbFireSumInsrMstEntity> entityList) {
		List<MdoiDbFireSumInsrMstDTO> dtoList = new ArrayList<>();
		for (MdoiDbFireSumInsrMstEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public MdoiDbFireSumInsrMstDTO toDtoFromEntity(MdoiDbFireSumInsrMstEntity entity) {
		MdoiDbFireSumInsrMstDTO dto=new MdoiDbFireSumInsrMstDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


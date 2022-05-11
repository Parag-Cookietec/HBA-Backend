package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolMoneyIntransitDTO;

import gov.ifms.doi.db.entity.TdoiDbPolMoneyIntransitEntity;

@Component
public class TdoiDbPolMoneyIntransitConverter{

	public TdoiDbPolMoneyIntransitEntity toEntity(TdoiDbPolMoneyIntransitDTO dto) {
		TdoiDbPolMoneyIntransitEntity entity = new TdoiDbPolMoneyIntransitEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolMoneyIntransitDTO> toDtoListFromEntityList(List<TdoiDbPolMoneyIntransitEntity> entityList) {
		List<TdoiDbPolMoneyIntransitDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolMoneyIntransitEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolMoneyIntransitDTO toDtoFromEntity(TdoiDbPolMoneyIntransitEntity entity) {
		TdoiDbPolMoneyIntransitDTO dto=new TdoiDbPolMoneyIntransitDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


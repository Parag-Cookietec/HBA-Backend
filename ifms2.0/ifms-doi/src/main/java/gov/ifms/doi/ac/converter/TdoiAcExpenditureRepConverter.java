package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcExpenditureRepDTO;

import gov.ifms.doi.ac.entity.TdoiAcExpenditureRepEntity;

@Component
public class TdoiAcExpenditureRepConverter{

	public TdoiAcExpenditureRepEntity toEntity(TdoiAcExpenditureRepDTO dto) {
		TdoiAcExpenditureRepEntity entity = new TdoiAcExpenditureRepEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcExpenditureRepDTO> toDtoListFromEntityList(List<TdoiAcExpenditureRepEntity> entityList) {
		List<TdoiAcExpenditureRepDTO> dtoList = new ArrayList<>();
		for (TdoiAcExpenditureRepEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcExpenditureRepDTO toDtoFromEntity(TdoiAcExpenditureRepEntity entity) {
		TdoiAcExpenditureRepDTO dto=new TdoiAcExpenditureRepDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


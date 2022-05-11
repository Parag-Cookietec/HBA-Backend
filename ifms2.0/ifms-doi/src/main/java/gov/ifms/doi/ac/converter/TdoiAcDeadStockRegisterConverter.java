package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcDeadStockRegisterDTO;

import gov.ifms.doi.ac.entity.TdoiAcDeadStockRegisterEntity;

@Component
public class TdoiAcDeadStockRegisterConverter{

	public TdoiAcDeadStockRegisterEntity toEntity(TdoiAcDeadStockRegisterDTO dto) {
		TdoiAcDeadStockRegisterEntity entity = new TdoiAcDeadStockRegisterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcDeadStockRegisterDTO> toDtoListFromEntityList(List<TdoiAcDeadStockRegisterEntity> entityList) {
		List<TdoiAcDeadStockRegisterDTO> dtoList = new ArrayList<>();
		for (TdoiAcDeadStockRegisterEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcDeadStockRegisterDTO toDtoFromEntity(TdoiAcDeadStockRegisterEntity entity) {
		TdoiAcDeadStockRegisterDTO dto=new TdoiAcDeadStockRegisterDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


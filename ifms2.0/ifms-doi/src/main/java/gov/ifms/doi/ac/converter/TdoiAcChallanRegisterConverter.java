package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcChallanRegisterDTO;

import gov.ifms.doi.ac.entity.TdoiAcChallanRegisterEntity;

@Component
public class TdoiAcChallanRegisterConverter{

	public TdoiAcChallanRegisterEntity toEntity(TdoiAcChallanRegisterDTO dto) {
		TdoiAcChallanRegisterEntity entity = new TdoiAcChallanRegisterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcChallanRegisterDTO> toDtoListFromEntityList(List<TdoiAcChallanRegisterEntity> entityList) {
		List<TdoiAcChallanRegisterDTO> dtoList = new ArrayList<>();
		for (TdoiAcChallanRegisterEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcChallanRegisterDTO toDtoFromEntity(TdoiAcChallanRegisterEntity entity) {
		TdoiAcChallanRegisterDTO dto=new TdoiAcChallanRegisterDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcChequeRegisterDTO;

import gov.ifms.doi.ac.entity.TdoiAcChequeRegisterEntity;

@Component
public class TdoiAcChequeRegisterConverter{

	public TdoiAcChequeRegisterEntity toEntity(TdoiAcChequeRegisterDTO dto) {
		TdoiAcChequeRegisterEntity entity = new TdoiAcChequeRegisterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcChequeRegisterDTO> toDtoListFromEntityList(List<TdoiAcChequeRegisterEntity> entityList) {
		List<TdoiAcChequeRegisterDTO> dtoList = new ArrayList<>();
		for (TdoiAcChequeRegisterEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcChequeRegisterDTO toDtoFromEntity(TdoiAcChequeRegisterEntity entity) {
		TdoiAcChequeRegisterDTO dto=new TdoiAcChequeRegisterDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


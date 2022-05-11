package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcCashbookPaymentDTO;

import gov.ifms.doi.ac.entity.TdoiAcCashbookPaymentEntity;

@Component
public class TdoiAcCashbookPaymentConverter{

	public TdoiAcCashbookPaymentEntity toEntity(TdoiAcCashbookPaymentDTO dto) {
		TdoiAcCashbookPaymentEntity entity = new TdoiAcCashbookPaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcCashbookPaymentDTO> toDtoListFromEntityList(List<TdoiAcCashbookPaymentEntity> entityList) {
		List<TdoiAcCashbookPaymentDTO> dtoList = new ArrayList<>();
		for (TdoiAcCashbookPaymentEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcCashbookPaymentDTO toDtoFromEntity(TdoiAcCashbookPaymentEntity entity) {
		TdoiAcCashbookPaymentDTO dto=new TdoiAcCashbookPaymentDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


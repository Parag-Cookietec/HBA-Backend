package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcCashbookReceiptDTO;

import gov.ifms.doi.ac.entity.TdoiAcCashbookReceiptEntity;

@Component
public class TdoiAcCashbookReceiptConverter{

	public TdoiAcCashbookReceiptEntity toEntity(TdoiAcCashbookReceiptDTO dto) {
		TdoiAcCashbookReceiptEntity entity = new TdoiAcCashbookReceiptEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcCashbookReceiptDTO> toDtoListFromEntityList(List<TdoiAcCashbookReceiptEntity> entityList) {
		List<TdoiAcCashbookReceiptDTO> dtoList = new ArrayList<>();
		for (TdoiAcCashbookReceiptEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcCashbookReceiptDTO toDtoFromEntity(TdoiAcCashbookReceiptEntity entity) {
		TdoiAcCashbookReceiptDTO dto=new TdoiAcCashbookReceiptDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcChallanDtlDTO;

import gov.ifms.doi.ac.entity.TdoiAcChallanDtlEntity;

@Component
public class TdoiAcChallanDtlConverter{

	public TdoiAcChallanDtlEntity toEntity(TdoiAcChallanDtlDTO dto) {
		TdoiAcChallanDtlEntity entity = new TdoiAcChallanDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcChallanDtlDTO> toDtoListFromEntityList(List<TdoiAcChallanDtlEntity> entityList) {
		List<TdoiAcChallanDtlDTO> dtoList = new ArrayList<>();
		for (TdoiAcChallanDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcChallanDtlDTO toDtoFromEntity(TdoiAcChallanDtlEntity entity) {
		TdoiAcChallanDtlDTO dto=new TdoiAcChallanDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


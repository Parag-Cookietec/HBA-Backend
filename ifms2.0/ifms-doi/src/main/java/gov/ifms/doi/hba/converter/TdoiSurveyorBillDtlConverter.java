package gov.ifms.doi.hba.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.hba.dto.TdoiSurveyorBillDtlDTO;

import gov.ifms.doi.hba.entity.TdoiSurveyorBillDtlEntity;

@Component
public class TdoiSurveyorBillDtlConverter{

	public TdoiSurveyorBillDtlEntity toEntity(TdoiSurveyorBillDtlDTO dto) {
		TdoiSurveyorBillDtlEntity entity = new TdoiSurveyorBillDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiSurveyorBillDtlDTO> toDtoListFromEntityList(List<TdoiSurveyorBillDtlEntity> entityList) {
		List<TdoiSurveyorBillDtlDTO> dtoList = new ArrayList<>();
		for (TdoiSurveyorBillDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiSurveyorBillDtlDTO toDtoFromEntity(TdoiSurveyorBillDtlEntity entity) {
		TdoiSurveyorBillDtlDTO dto=new TdoiSurveyorBillDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


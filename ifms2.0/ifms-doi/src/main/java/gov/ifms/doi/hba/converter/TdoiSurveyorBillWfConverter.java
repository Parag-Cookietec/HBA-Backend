package gov.ifms.doi.hba.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.hba.dto.TdoiSurveyorBillWfDTO;

import gov.ifms.doi.hba.entity.TdoiSurveyorBillWfEntity;

@Component
public class TdoiSurveyorBillWfConverter{

	public TdoiSurveyorBillWfEntity toEntity(TdoiSurveyorBillWfDTO dto) {
		TdoiSurveyorBillWfEntity entity = new TdoiSurveyorBillWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiSurveyorBillWfDTO> toDtoListFromEntityList(List<TdoiSurveyorBillWfEntity> entityList) {
		List<TdoiSurveyorBillWfDTO> dtoList = new ArrayList<>();
		for (TdoiSurveyorBillWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiSurveyorBillWfDTO toDtoFromEntity(TdoiSurveyorBillWfEntity entity) {
		TdoiSurveyorBillWfDTO dto=new TdoiSurveyorBillWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


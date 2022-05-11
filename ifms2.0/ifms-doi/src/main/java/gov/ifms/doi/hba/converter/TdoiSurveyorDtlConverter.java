package gov.ifms.doi.hba.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.hba.dto.TdoiSurveyorDtlDTO;

import gov.ifms.doi.hba.entity.TdoiSurveyorDtlEntity;

@Component
public class TdoiSurveyorDtlConverter{

	public TdoiSurveyorDtlEntity toEntity(TdoiSurveyorDtlDTO dto) {
		TdoiSurveyorDtlEntity entity = new TdoiSurveyorDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiSurveyorDtlDTO> toDtoListFromEntityList(List<TdoiSurveyorDtlEntity> entityList) {
		List<TdoiSurveyorDtlDTO> dtoList = new ArrayList<>();
		for (TdoiSurveyorDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiSurveyorDtlDTO toDtoFromEntity(TdoiSurveyorDtlEntity entity) {
		TdoiSurveyorDtlDTO dto=new TdoiSurveyorDtlDTO();
		//TODO: facing hibernate org.hibernate.exception.SQLGrammarException due to this. Resolve it later
		// so setting this to null
		if(entity.getTdoiSurveyorBillDtls()!=null && entity.getTdoiSurveyorBillDtls().size()>0){
			entity.getTdoiSurveyorBillDtls().forEach(s->s.setTdoiSurveyorBillWfs(null));
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


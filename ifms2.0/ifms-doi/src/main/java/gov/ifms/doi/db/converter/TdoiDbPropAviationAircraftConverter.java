package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropAviationAircraftDTO;

import gov.ifms.doi.db.entity.TdoiDbPropAviationAircraftEntity;

@Component
public class TdoiDbPropAviationAircraftConverter{

	public TdoiDbPropAviationAircraftEntity toEntity(TdoiDbPropAviationAircraftDTO dto) {
		TdoiDbPropAviationAircraftEntity entity = new TdoiDbPropAviationAircraftEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropAviationAircraftDTO> toDtoListFromEntityList(List<TdoiDbPropAviationAircraftEntity> entityList) {
		List<TdoiDbPropAviationAircraftDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropAviationAircraftEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropAviationAircraftDTO toDtoFromEntity(TdoiDbPropAviationAircraftEntity entity) {
		TdoiDbPropAviationAircraftDTO dto=new TdoiDbPropAviationAircraftDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


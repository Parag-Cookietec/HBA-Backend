package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolAviationAircraftDTO;

import gov.ifms.doi.db.entity.TdoiDbPolAviationAircraftEntity;

@Component
public class TdoiDbPolAviationAircraftConverter{

	public TdoiDbPolAviationAircraftEntity toEntity(TdoiDbPolAviationAircraftDTO dto) {
		TdoiDbPolAviationAircraftEntity entity = new TdoiDbPolAviationAircraftEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolAviationAircraftDTO> toDtoListFromEntityList(List<TdoiDbPolAviationAircraftEntity> entityList) {
		List<TdoiDbPolAviationAircraftDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolAviationAircraftEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolAviationAircraftDTO toDtoFromEntity(TdoiDbPolAviationAircraftEntity entity) {
		TdoiDbPolAviationAircraftDTO dto=new TdoiDbPolAviationAircraftDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


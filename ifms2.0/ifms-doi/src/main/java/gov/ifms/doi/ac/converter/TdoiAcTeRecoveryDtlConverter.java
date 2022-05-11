package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcTeRecoveryDtlDTO;

import gov.ifms.doi.ac.entity.TdoiAcTeRecoveryDtlEntity;

@Component
public class TdoiAcTeRecoveryDtlConverter{

	public TdoiAcTeRecoveryDtlEntity toEntity(TdoiAcTeRecoveryDtlDTO dto) {
		TdoiAcTeRecoveryDtlEntity entity = new TdoiAcTeRecoveryDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcTeRecoveryDtlDTO> toDtoListFromEntityList(List<TdoiAcTeRecoveryDtlEntity> entityList) {
		List<TdoiAcTeRecoveryDtlDTO> dtoList = new ArrayList<>();
		for (TdoiAcTeRecoveryDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcTeRecoveryDtlDTO toDtoFromEntity(TdoiAcTeRecoveryDtlEntity entity) {
		TdoiAcTeRecoveryDtlDTO dto=new TdoiAcTeRecoveryDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


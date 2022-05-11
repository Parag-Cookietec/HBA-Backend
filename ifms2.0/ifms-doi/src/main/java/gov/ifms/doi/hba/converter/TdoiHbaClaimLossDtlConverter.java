package gov.ifms.doi.hba.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.hba.dto.TdoiHbaClaimLossDtlDTO;

import gov.ifms.doi.hba.entity.TdoiHbaClaimLossDtlEntity;

@Component
public class TdoiHbaClaimLossDtlConverter{

	public TdoiHbaClaimLossDtlEntity toEntity(TdoiHbaClaimLossDtlDTO dto) {
		TdoiHbaClaimLossDtlEntity entity = new TdoiHbaClaimLossDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiHbaClaimLossDtlDTO> toDtoListFromEntityList(List<TdoiHbaClaimLossDtlEntity> entityList) {
		List<TdoiHbaClaimLossDtlDTO> dtoList = new ArrayList<>();
		for (TdoiHbaClaimLossDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiHbaClaimLossDtlDTO toDtoFromEntity(TdoiHbaClaimLossDtlEntity entity) {
		TdoiHbaClaimLossDtlDTO dto=new TdoiHbaClaimLossDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


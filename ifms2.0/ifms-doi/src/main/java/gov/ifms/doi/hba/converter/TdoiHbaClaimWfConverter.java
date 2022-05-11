package gov.ifms.doi.hba.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.hba.dto.TdoiHbaClaimWfDTO;

import gov.ifms.doi.hba.entity.TdoiHbaClaimWfEntity;

@Component
public class TdoiHbaClaimWfConverter{

	public TdoiHbaClaimWfEntity toEntity(TdoiHbaClaimWfDTO dto) {
		TdoiHbaClaimWfEntity entity = new TdoiHbaClaimWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiHbaClaimWfDTO> toDtoListFromEntityList(List<TdoiHbaClaimWfEntity> entityList) {
		List<TdoiHbaClaimWfDTO> dtoList = new ArrayList<>();
		for (TdoiHbaClaimWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiHbaClaimWfDTO toDtoFromEntity(TdoiHbaClaimWfEntity entity) {
		TdoiHbaClaimWfDTO dto=new TdoiHbaClaimWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


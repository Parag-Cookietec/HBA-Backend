package gov.ifms.doi.hba.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.hba.dto.TdoiHbaOthrCompClaimDTO;

import gov.ifms.doi.hba.entity.TdoiHbaOthrCompClaimEntity;

@Component
public class TdoiHbaOthrCompClaimConverter{

	public TdoiHbaOthrCompClaimEntity toEntity(TdoiHbaOthrCompClaimDTO dto) {
		TdoiHbaOthrCompClaimEntity entity = new TdoiHbaOthrCompClaimEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiHbaOthrCompClaimDTO> toDtoListFromEntityList(List<TdoiHbaOthrCompClaimEntity> entityList) {
		List<TdoiHbaOthrCompClaimDTO> dtoList = new ArrayList<>();
		for (TdoiHbaOthrCompClaimEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiHbaOthrCompClaimDTO toDtoFromEntity(TdoiHbaOthrCompClaimEntity entity) {
		TdoiHbaOthrCompClaimDTO dto=new TdoiHbaOthrCompClaimDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


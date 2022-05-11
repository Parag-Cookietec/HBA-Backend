package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcStampRegisterDTO;

import gov.ifms.doi.ac.entity.TdoiAcStampRegisterEntity;

@Component
public class TdoiAcStampRegisterConverter{

	public TdoiAcStampRegisterEntity toEntity(TdoiAcStampRegisterDTO dto) {
		TdoiAcStampRegisterEntity entity = new TdoiAcStampRegisterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcStampRegisterDTO> toDtoListFromEntityList(List<TdoiAcStampRegisterEntity> entityList) {
		List<TdoiAcStampRegisterDTO> dtoList = new ArrayList<>();
		for (TdoiAcStampRegisterEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcStampRegisterDTO toDtoFromEntity(TdoiAcStampRegisterEntity entity) {
		TdoiAcStampRegisterDTO dto=new TdoiAcStampRegisterDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


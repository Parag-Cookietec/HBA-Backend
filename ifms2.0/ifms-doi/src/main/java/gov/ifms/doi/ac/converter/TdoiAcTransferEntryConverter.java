package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcTransferEntryDTO;

import gov.ifms.doi.ac.entity.TdoiAcTransferEntryEntity;

@Component
public class TdoiAcTransferEntryConverter{

	public TdoiAcTransferEntryEntity toEntity(TdoiAcTransferEntryDTO dto) {
		TdoiAcTransferEntryEntity entity = new TdoiAcTransferEntryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcTransferEntryDTO> toDtoListFromEntityList(List<TdoiAcTransferEntryEntity> entityList) {
		List<TdoiAcTransferEntryDTO> dtoList = new ArrayList<>();
		for (TdoiAcTransferEntryEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcTransferEntryDTO toDtoFromEntity(TdoiAcTransferEntryEntity entity) {
		TdoiAcTransferEntryDTO dto=new TdoiAcTransferEntryDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


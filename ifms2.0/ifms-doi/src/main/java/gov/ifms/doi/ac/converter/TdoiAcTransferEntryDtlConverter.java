package gov.ifms.doi.ac.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.ac.dto.TdoiAcTransferEntryDtlDTO;

import gov.ifms.doi.ac.entity.TdoiAcTransferEntryDtlEntity;

@Component
public class TdoiAcTransferEntryDtlConverter{

	public TdoiAcTransferEntryDtlEntity toEntity(TdoiAcTransferEntryDtlDTO dto) {
		TdoiAcTransferEntryDtlEntity entity = new TdoiAcTransferEntryDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiAcTransferEntryDtlDTO> toDtoListFromEntityList(List<TdoiAcTransferEntryDtlEntity> entityList) {
		List<TdoiAcTransferEntryDtlDTO> dtoList = new ArrayList<>();
		for (TdoiAcTransferEntryDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiAcTransferEntryDtlDTO toDtoFromEntity(TdoiAcTransferEntryDtlEntity entity) {
		TdoiAcTransferEntryDtlDTO dto=new TdoiAcTransferEntryDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


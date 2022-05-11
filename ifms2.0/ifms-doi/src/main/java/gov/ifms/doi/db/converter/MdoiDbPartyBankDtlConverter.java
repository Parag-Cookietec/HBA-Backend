package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.MdoiDbPartyBankDtlDTO;

import gov.ifms.doi.db.entity.MdoiDbPartyBankDtlEntity;

@Component
public class MdoiDbPartyBankDtlConverter{

	public MdoiDbPartyBankDtlEntity toEntity(MdoiDbPartyBankDtlDTO dto) {
		MdoiDbPartyBankDtlEntity entity = new MdoiDbPartyBankDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<MdoiDbPartyBankDtlDTO> toDtoListFromEntityList(List<MdoiDbPartyBankDtlEntity> entityList) {
		List<MdoiDbPartyBankDtlDTO> dtoList = new ArrayList<>();
		for (MdoiDbPartyBankDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public MdoiDbPartyBankDtlDTO toDtoFromEntity(MdoiDbPartyBankDtlEntity entity) {
		MdoiDbPartyBankDtlDTO dto=new MdoiDbPartyBankDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	



}


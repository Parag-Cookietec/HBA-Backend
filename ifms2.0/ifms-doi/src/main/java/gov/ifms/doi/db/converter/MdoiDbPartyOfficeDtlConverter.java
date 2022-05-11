package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.MdoiDbPartyOfficeDtlDTO;

import gov.ifms.doi.db.entity.MdoiDbPartyOfficeDtlEntity;

@Component
public class MdoiDbPartyOfficeDtlConverter{

	public MdoiDbPartyOfficeDtlEntity toEntity(MdoiDbPartyOfficeDtlDTO dto) {
		MdoiDbPartyOfficeDtlEntity entity = new MdoiDbPartyOfficeDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<MdoiDbPartyOfficeDtlDTO> toDtoListFromEntityList(List<MdoiDbPartyOfficeDtlEntity> entityList) {
		List<MdoiDbPartyOfficeDtlDTO> dtoList = new ArrayList<>();
		for (MdoiDbPartyOfficeDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public MdoiDbPartyOfficeDtlDTO toDtoFromEntity(MdoiDbPartyOfficeDtlEntity entity) {
		MdoiDbPartyOfficeDtlDTO dto=new MdoiDbPartyOfficeDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


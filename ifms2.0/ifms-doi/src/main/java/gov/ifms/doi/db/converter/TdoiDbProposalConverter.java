package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbProposalDTO;

import gov.ifms.doi.db.entity.TdoiDbProposalEntity;

@Component
public class TdoiDbProposalConverter{

	public TdoiDbProposalEntity toEntity(TdoiDbProposalDTO dto) {
		TdoiDbProposalEntity entity = new TdoiDbProposalEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbProposalDTO> toDtoListFromEntityList(List<TdoiDbProposalEntity> entityList) {
		List<TdoiDbProposalDTO> dtoList = new ArrayList<>();
		for (TdoiDbProposalEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbProposalDTO toDtoFromEntity(TdoiDbProposalEntity entity) {
		TdoiDbProposalDTO dto=new TdoiDbProposalDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


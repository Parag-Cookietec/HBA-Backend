package gov.ifms.doi.hba.converter;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.hba.dto.TdoiHbaProposalDTO;

import gov.ifms.doi.hba.entity.TdoiHbaProposalEntity;

@Component
public class TdoiHbaProposalConverter{

	public TdoiHbaProposalEntity toEntity(TdoiHbaProposalDTO dto) {
		TdoiHbaProposalEntity entity = new TdoiHbaProposalEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(1);
		entity.setCreatedDate(new Date());
		entity.setUpdatedBy(dto.getCreatedBy());
		entity.setUpdatedDate(new Date());
		entity.setUpdatedByPost(dto.getUpdatedByPost());
		return entity;
	}


	public List<TdoiHbaProposalDTO> toDtoListFromEntityList(List<TdoiHbaProposalEntity> entityList) {
		List<TdoiHbaProposalDTO> dtoList = new ArrayList<>();
		for (TdoiHbaProposalEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiHbaProposalDTO toDtoFromEntity(TdoiHbaProposalEntity entity) {
		TdoiHbaProposalDTO dto=new TdoiHbaProposalDTO();
		//TODO: facing hibernate org.hibernate.exception.SQLGrammarException due to this. Resolve it later
		// so setting this to null
		entity.setTdoiHbaProposlWfs(null);
		if(entity.getTdoiHbaClaimEntries()!=null && entity.getTdoiHbaClaimEntries().size()>0){
			entity.getTdoiHbaClaimEntries().forEach(e->e.setTdoiHbaClaimWfs(null));
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


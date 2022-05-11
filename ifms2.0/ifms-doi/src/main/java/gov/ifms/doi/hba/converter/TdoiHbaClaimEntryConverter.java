package gov.ifms.doi.hba.converter;

import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryDTO;
import gov.ifms.doi.hba.entity.TdoiHbaClaimEntryEntity;
import gov.ifms.doi.hba.entity.TdoiHbaProposalEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TdoiHbaClaimEntryConverter{

	public TdoiHbaClaimEntryEntity toEntity(TdoiHbaClaimEntryDTO dto) {
		TdoiHbaClaimEntryEntity entity = new TdoiHbaClaimEntryEntity();
		if(dto.getTdoiHbaProposal().getHbaProposalId()>0L){
			entity.setTdoiHbaProposal(new TdoiHbaProposalEntity(dto.getTdoiHbaProposal().getHbaProposalId()));
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<TdoiHbaClaimEntryDTO> toDtoListFromEntityList(List<TdoiHbaClaimEntryEntity> entityList) {
		List<TdoiHbaClaimEntryDTO> dtoList = new ArrayList<>();
		for (TdoiHbaClaimEntryEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
		return dtoList;
	}


	public TdoiHbaClaimEntryDTO toDtoFromEntity(TdoiHbaClaimEntryEntity entity) {
		TdoiHbaClaimEntryDTO dto=new TdoiHbaClaimEntryDTO();
		//TODO: facing hibernate org.hibernate.exception.SQLGrammarException due to this. Resolve it later
		// so setting this to null
		entity.setTdoiHbaClaimWfs(null);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


package gov.ifms.doi.hba.converter;

import gov.ifms.doi.hba.dto.TdoiHbaClaimRejectDTO;
import gov.ifms.doi.hba.entity.TdoiHbaClaimEntryEntity;
import gov.ifms.doi.hba.entity.TdoiHbaClaimRejectEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TdoiHbaClaimRejectConverter{

	public TdoiHbaClaimRejectEntity toEntity(TdoiHbaClaimRejectDTO dto) {
		TdoiHbaClaimRejectEntity entity = new TdoiHbaClaimRejectEntity();
		if(dto.getTdoiHbaClaimEntry().getHbaClaimId()>0L){
			entity.setTdoiHbaClaimEntry(new TdoiHbaClaimEntryEntity(dto.getTdoiHbaClaimEntry().getHbaClaimId()));
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiHbaClaimRejectDTO> toDtoListFromEntityList(List<TdoiHbaClaimRejectEntity> entityList) {
		List<TdoiHbaClaimRejectDTO> dtoList = new ArrayList<>();
		for (TdoiHbaClaimRejectEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiHbaClaimRejectDTO toDtoFromEntity(TdoiHbaClaimRejectEntity entity) {
		TdoiHbaClaimRejectDTO dto=new TdoiHbaClaimRejectDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}


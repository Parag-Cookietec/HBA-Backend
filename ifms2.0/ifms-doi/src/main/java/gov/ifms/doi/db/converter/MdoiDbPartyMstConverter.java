package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import gov.ifms.doi.db.dto.MdoiDbPartyBankDtlDTO;
import gov.ifms.doi.db.dto.MdoiDbPartyOfficeDtlDTO;
import gov.ifms.doi.db.entity.MdoiDbPartyBankDtlEntity;
import gov.ifms.doi.db.entity.MdoiDbPartyOfficeDtlEntity;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.MdoiDbPartyMstDTO;

import gov.ifms.doi.db.entity.MdoiDbPartyMstEntity;

@Component
public class MdoiDbPartyMstConverter{

	public MdoiDbPartyMstEntity toEntity(MdoiDbPartyMstDTO dto) {
		MdoiDbPartyMstEntity entity = new MdoiDbPartyMstEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getMdoiDbPartyBankDtls()!=null && !dto.getMdoiDbPartyBankDtls().isEmpty()){
			List<MdoiDbPartyBankDtlEntity> bankDtlEntities = new ArrayList<>();
			for(MdoiDbPartyBankDtlDTO bankDtlDTO:dto.getMdoiDbPartyBankDtls()){
				MdoiDbPartyBankDtlEntity bankDtlEntity = new MdoiDbPartyBankDtlEntity();
				BeanUtils.copyProperties(bankDtlDTO, bankDtlEntity);
				bankDtlEntity.setMdoiDbPartyMst(entity);
				bankDtlEntities.add(bankDtlEntity);
			}
			entity.setMdoiDbPartyBankDtls(bankDtlEntities);
		}
		if(dto.getMdoiDbPartyOfficeDtls()!=null && !dto.getMdoiDbPartyOfficeDtls().isEmpty()){
			List<MdoiDbPartyOfficeDtlEntity> officeDtlEntities = new ArrayList<>();
			for(MdoiDbPartyOfficeDtlDTO officeDtlDTO:dto.getMdoiDbPartyOfficeDtls()){
				MdoiDbPartyOfficeDtlEntity officeDtlEntity = new MdoiDbPartyOfficeDtlEntity();
				BeanUtils.copyProperties(officeDtlDTO, officeDtlEntity);
				officeDtlEntity.setMdoiDbPartyMst(entity);
				officeDtlEntities.add(officeDtlEntity);
			}
			entity.setMdoiDbPartyOfficeDtls(officeDtlEntities);
		}
		return entity;
	}


	public List<MdoiDbPartyMstDTO> toDtoListFromEntityList(List<MdoiDbPartyMstEntity> entityList) {
		List<MdoiDbPartyMstDTO> dtoList = new ArrayList<>();
		for (MdoiDbPartyMstEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public MdoiDbPartyMstDTO toDtoFromEntity(MdoiDbPartyMstEntity entity) {
		MdoiDbPartyMstDTO dto=new MdoiDbPartyMstDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}


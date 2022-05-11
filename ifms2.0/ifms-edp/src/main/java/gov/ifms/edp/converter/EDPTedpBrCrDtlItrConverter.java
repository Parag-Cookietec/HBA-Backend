package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPTedpBrCrDtlItrDto;
import gov.ifms.edp.dto.EDPTedpBrHdrDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPTedpBrCrDtlEntity;
import gov.ifms.edp.entity.EDPTedpBrCrDtlItrEntity;
import gov.ifms.edp.entity.EDPTedpBrHdrEntity;


/**
 * The Class EDPTedpBrHdrConverter.
 */
@Component
public class EDPTedpBrCrDtlItrConverter implements BaseConverter<EDPTedpBrCrDtlItrEntity,EDPTedpBrCrDtlItrDto> {


	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP tedp br hdr entity
	 */
	@Override
	public EDPTedpBrCrDtlItrEntity toEntity(EDPTedpBrCrDtlItrDto dto) {
		EDPTedpBrCrDtlItrEntity entity = new EDPTedpBrCrDtlItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	
	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP tedp br hdr dto
	 */
	@Override
	public EDPTedpBrCrDtlItrDto toDTO(EDPTedpBrCrDtlItrEntity entity) {
		EDPTedpBrCrDtlItrDto dto = new EDPTedpBrCrDtlItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


	/**
	 * Dtl entity to itr entity.
	 *
	 * @param dto the dto
	 * @param dtlEntity the dtl entity
	 * @return the EDP tedp br cr dtl itr entity
	 */
	public EDPTedpBrCrDtlItrEntity dtlEntityToItrEntity(EDPTedpBrHdrDto dto,EDPTedpBrCrDtlEntity dtlEntity) {
		EDPTedpBrCrDtlItrEntity itrEntity = new EDPTedpBrCrDtlItrEntity();
		itrEntity.setTedpBrCrDtlId(dtlEntity);
		itrEntity.setTedpBrHdrId(new EDPTedpBrHdrEntity(dto.getTedpBrHdrId()));
		itrEntity.setBranchName(dto.getBranchName());
		itrEntity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		itrEntity.setBranchTypeId(new EDPLuLookUpInfoEntity(dto.getBranchType()));
		if(null != dto.getBranchId())
			itrEntity.setBranchId(new EDPMsBranchEntity(dto.getBranchId()));
		return itrEntity;
	}
}

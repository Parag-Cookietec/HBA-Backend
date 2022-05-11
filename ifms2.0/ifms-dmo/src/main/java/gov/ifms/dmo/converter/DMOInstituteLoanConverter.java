package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOInstitutionalLoanDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOInstitutionalLoanEntity;

@Component
public class DMOInstituteLoanConverter implements BaseConverter<DMOInstitutionalLoanEntity, DMOInstitutionalLoanDto>{

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the DMOGOILoanEntity entity
	 */
	@Override
	public DMOInstitutionalLoanEntity toEntity(DMOInstitutionalLoanDto dto) {
		DMOInstitutionalLoanEntity entity = new DMOInstitutionalLoanEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getDpSheetId()) {
			entity.setDpSheetId(new DMODPSheetEntryEntity(dto.getDpSheetId()));
		}
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the DMOGOILoanPostDto dto
	 */
	@Override
	public DMOInstitutionalLoanDto toDTO(DMOInstitutionalLoanEntity entity) {
		DMOInstitutionalLoanDto dto = new DMOInstitutionalLoanDto();
		if(!ObjectUtils.isEmpty(entity.getDpSheetId())){
			dto.setDpSheetId(entity.getDpSheetId().getDpSheetDtlId());
		}		
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}

package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOInstitutionalLoanMemoDto;
import gov.ifms.dmo.entity.DMOInstitutionalLoanMemoEntity;

@Component
public class DMOInstituteLoanMemoConverter implements BaseConverter<DMOInstitutionalLoanMemoEntity, DMOInstitutionalLoanMemoDto>{

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the DMOGOILoanEntity entity
	 */
	@Override
	public DMOInstitutionalLoanMemoEntity toEntity(DMOInstitutionalLoanMemoDto dto) {
		DMOInstitutionalLoanMemoEntity entity = new DMOInstitutionalLoanMemoEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the DMOInstitutionalLoanMemoDto dto
	 */
	@Override
	public DMOInstitutionalLoanMemoDto toDTO(DMOInstitutionalLoanMemoEntity entity) {
		DMOInstitutionalLoanMemoDto dto = new DMOInstitutionalLoanMemoDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setDpSheetEntity(entity.getDpSheetEntity().getDpSheetDtlId());
		dto.setInstituteLoanId(entity.getIntLoanId().getId());
		return dto;
	}
}

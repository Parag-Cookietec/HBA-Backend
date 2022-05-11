package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;

@Component
public class DMOMarketLoanConverter implements BaseConverter<DMOMarketLoanEntity, DMOMarketLoanDto>{


	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the DMOMarketLoanEntity entity
	 */
	@Override
	public DMOMarketLoanEntity toEntity(DMOMarketLoanDto dto) {
		DMOMarketLoanEntity entity = new DMOMarketLoanEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getDpSheetId()) {
			entity.setDpSheetId(new DMODPSheetEntryEntity(dto.getDpSheetId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the DMOMarketLoanDto dto
	 */
	@Override
	public DMOMarketLoanDto toDTO(DMOMarketLoanEntity entity) {
		DMOMarketLoanDto dto = new DMOMarketLoanDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

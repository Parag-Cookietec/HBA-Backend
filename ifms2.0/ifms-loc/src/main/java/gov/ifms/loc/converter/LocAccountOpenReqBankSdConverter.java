package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocAccountOpenReqBankSdDto;
import gov.ifms.loc.entity.LocAccountOpenReqBankSdEntity;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.entity.LocMsBankEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocAccountOpenReqBankSdConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 16:35:39
 *
 */
@Component
public class LocAccountOpenReqBankSdConverter implements BaseConverter<LocAccountOpenReqBankSdEntity,LocAccountOpenReqBankSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqBankSd entity
	 */
	@Override
	public LocAccountOpenReqBankSdEntity toEntity(LocAccountOpenReqBankSdDto dto) {
		LocAccountOpenReqBankSdEntity entity = new LocAccountOpenReqBankSdEntity();
		BeanUtils.copyProperties(dto, entity);
		if (null != dto.getLcOpenReqHdrId()) {
			entity.setLcOpenReqHdrId(new LocAccountOpenReqHdrEntity(dto.getLcOpenReqHdrId()));
		}
		if(null != dto.getBankId()) {
			entity.setBankId(new LocMsBankEntity(dto.getBankId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqBankSd  dto
	 */
	@Override
	public LocAccountOpenReqBankSdDto toDTO(LocAccountOpenReqBankSdEntity entity) {
		LocAccountOpenReqBankSdDto dto = new LocAccountOpenReqBankSdDto();
		BeanUtils.copyProperties(entity, dto);
		if (null != entity.getLcOpenReqHdrId()) {
			dto.setLcOpenReqHdrId(entity.getLcOpenReqHdrId().getLcOpenReqHdrId());
		}
		if(null != entity.getBankId()) {
			dto.setBankId(entity.getBankId().getbankId());
		}
		return dto;
	}
	
}

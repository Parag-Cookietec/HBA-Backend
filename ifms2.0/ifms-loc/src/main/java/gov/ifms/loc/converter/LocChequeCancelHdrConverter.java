package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocChequeCancelHdrDto;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;
import gov.ifms.loc.entity.LocChequeCancelHdrEntity;
import gov.ifms.loc.entity.LocMsBankEntity;
import gov.ifms.loc.entity.LocMsDivisonEntity;

/**
 * The Class LocChequeCancelHdrConverter class.
 *
 * @version v 1.0
 * @created 2021/03/05 17:12:26
 */
@Component
public class LocChequeCancelHdrConverter implements BaseConverter<LocChequeCancelHdrEntity, LocChequeCancelHdrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChequeCancelHdr entity
	 */
	@Override
	public LocChequeCancelHdrEntity toEntity(LocChequeCancelHdrDto dto) {
		LocChequeCancelHdrEntity entity = new LocChequeCancelHdrEntity();
		if (null != dto.getDivId()) {
			entity.setDivId(new LocMsDivisonEntity(dto.getDivId()));
		}
		if (null != dto.getBankID()) {
			entity.setBankId(new LocMsBankEntity(dto.getBankID()));
		}
		if (null != dto.getLcAdviceid()) {
			entity.setLcAdviceid(new LocAdvicePrepHdrEntity(dto.getLcAdviceid()));
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChequeCancelHdr dto
	 */
	@Override
	public LocChequeCancelHdrDto toDTO(LocChequeCancelHdrEntity entity) {
		LocChequeCancelHdrDto dto = new LocChequeCancelHdrDto();
		dto.setDivId(entity.getDivId().getDivisonId());
		dto.setBankID(entity.getBankId().getbankId());
		dto.setLcAdviceid(entity.getLcAdviceid().getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

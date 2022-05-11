package gov.ifms.loc.converter;

import gov.ifms.loc.entity.LocChequeToChequeHDREntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocChequeToChequeDetailSdDto;
import gov.ifms.loc.entity.LocChequeToChequeDetailSdEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocChequeToChequeDetailSdConverter class.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:21:51
 *
 */
@Component
public class LocChequeToChequeDetailSdConverter implements BaseConverter<LocChequeToChequeDetailSdEntity,LocChequeToChequeDetailSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChequeToChequeDetailSd entity
	 */
	@Override
	public LocChequeToChequeDetailSdEntity toEntity(LocChequeToChequeDetailSdDto dto) {
		LocChequeToChequeDetailSdEntity entity = new LocChequeToChequeDetailSdEntity();
		if(null!=dto.getHdrId())
		{
			entity.setHdrId(new LocChequeToChequeHDREntity(dto.getHdrId()));
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChequeToChequeDetailSd  dto
	 */
	@Override
	public LocChequeToChequeDetailSdDto toDTO(LocChequeToChequeDetailSdEntity entity) {
		LocChequeToChequeDetailSdDto dto = new LocChequeToChequeDetailSdDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}

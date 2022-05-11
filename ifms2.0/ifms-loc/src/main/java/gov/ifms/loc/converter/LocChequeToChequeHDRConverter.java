package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocChequeToChequeHDRDto;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;
import gov.ifms.loc.entity.LocChequeToChequeHDREntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocChequeToChequeHDRConverter class.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:27:48
 *
 */
@Component
public class LocChequeToChequeHDRConverter implements BaseConverter<LocChequeToChequeHDREntity,LocChequeToChequeHDRDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChequeToChequeHDR entity
	 */
	@Override
	public LocChequeToChequeHDREntity toEntity(LocChequeToChequeHDRDto dto) {
		LocChequeToChequeHDREntity entity = new LocChequeToChequeHDREntity();
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
	 * @return the LocChequeToChequeHDR  dto
	 */
	@Override
	public LocChequeToChequeHDRDto toDTO(LocChequeToChequeHDREntity entity) {
		LocChequeToChequeHDRDto dto = new LocChequeToChequeHDRDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}

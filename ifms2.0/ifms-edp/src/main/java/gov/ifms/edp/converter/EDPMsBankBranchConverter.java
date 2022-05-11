package gov.ifms.edp.converter;

import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsBankBranchDto;
import gov.ifms.edp.entity.EDPMsBankBranchEntity;
import gov.ifms.edp.entity.EDPMsBankEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class EDPMsBankBranchConverter.
 */
@Component
public class EDPMsBankBranchConverter implements BaseConverter<EDPMsBankBranchEntity,EDPMsBankBranchDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP ms bank branch entity
	 */
	@Override
	public EDPMsBankBranchEntity toEntity(EDPMsBankBranchDto dto) {
		EDPMsBankBranchEntity entity = new EDPMsBankBranchEntity();
		BeanUtils.copyProperties(dto, entity);
		if (null != dto.getBankId()) {
			entity.setBankId(new EDPMsBankEntity(dto.getBankId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP ms bank branch dto
	 */
	@Override
	public EDPMsBankBranchDto toDTO(EDPMsBankBranchEntity entity) {
		EDPMsBankBranchDto dto = new EDPMsBankBranchDto();
		BeanUtils.copyProperties(entity, dto);
		if (null != entity.getBankId()) {
			dto.setBankId(entity.getBankId().getBankId());
		}
		return dto;
	}

	public List<EDPSDTDto> toEDPSDTDto(List<EDPMsBankBranchEntity> list) {
		return list.stream().map(entityList -> new EDPSDTDto(entityList.getBankBranchId(), entityList.getBranchName(),
				entityList.getIfscCode(), entityList.getBranchAddress())).collect(Collectors.toList());
	}

}

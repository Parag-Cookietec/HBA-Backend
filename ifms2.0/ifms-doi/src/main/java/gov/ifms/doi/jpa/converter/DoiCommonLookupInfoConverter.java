package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.jpa.dto.DoiCommonLookUpInfoDTO;
import gov.ifms.doi.jpa.entity.DoiCommonLookUpInfo;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Component
public class DoiCommonLookupInfoConverter implements BaseConverter<DoiCommonLookUpInfo, DoiCommonLookUpInfoDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiCommonLookUpInfo toEntity(DoiCommonLookUpInfoDTO dto) {
		DoiCommonLookUpInfo entity = new DoiCommonLookUpInfo();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DoiCommonLookUpInfoDTO toDTO(DoiCommonLookUpInfo entity) {
		DoiCommonLookUpInfoDTO dto = new DoiCommonLookUpInfoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<DoiCommonLookUpInfoDTO> toDTOList(List<DoiCommonLookUpInfo> entityList) {
		List<DoiCommonLookUpInfoDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)));
		return dtoList;
	}
}

package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.jpa.dto.DoiCommonLookUpDTO;
import gov.ifms.doi.jpa.entity.DoiCommonLookUp;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Component
public class DoiCommonLookupConverter implements BaseConverter<DoiCommonLookUp, DoiCommonLookUpDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiCommonLookUp toEntity(DoiCommonLookUpDTO dto) {
		DoiCommonLookUp entity = new DoiCommonLookUp();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DoiCommonLookUpDTO toDTO(DoiCommonLookUp entity) {
		DoiCommonLookUpDTO dto = new DoiCommonLookUpDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<DoiCommonLookUpDTO> toDTOList(List<DoiCommonLookUp> entityList) {
		List<DoiCommonLookUpDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)));
		return dtoList;
	}
}

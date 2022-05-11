package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeMasterDTO;
import gov.ifms.doi.jpa.entity.DoiJPASchemeMaster;

/**
 * 
 * @author Sagar Patil
 *
 */
@Component
public class DoiJPASchemeMasterConverter implements BaseConverter<DoiJPASchemeMaster, DoiJpaSchemeMasterDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiJPASchemeMaster toEntity(DoiJpaSchemeMasterDTO dto) {
		DoiJPASchemeMaster entity = new DoiJPASchemeMaster();
		BeanUtils.copyProperties(dto, entity);
		return entity;

	}

	@Override
	public DoiJpaSchemeMasterDTO toDTO(DoiJPASchemeMaster entity) {
		DoiJpaSchemeMasterDTO dto = new DoiJpaSchemeMasterDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	

	public List<DoiJpaSchemeMasterDTO> toDTOList(List<DoiJPASchemeMaster> entityList) {
		List<DoiJpaSchemeMasterDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)) );
		return dtoList;
	}

}

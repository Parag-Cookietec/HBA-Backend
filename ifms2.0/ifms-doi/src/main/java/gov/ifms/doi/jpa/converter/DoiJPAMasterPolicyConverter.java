package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.jpa.dto.DoiJpaMasterPolicyDTO;
import gov.ifms.doi.jpa.entity.DoiJPAMasterPolicy;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Component
public class DoiJPAMasterPolicyConverter implements BaseConverter<DoiJPAMasterPolicy, DoiJpaMasterPolicyDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiJPAMasterPolicy toEntity(DoiJpaMasterPolicyDTO dto) {
		DoiJPAMasterPolicy entity = new DoiJPAMasterPolicy();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DoiJpaMasterPolicyDTO toDTO(DoiJPAMasterPolicy entity) {
		DoiJpaMasterPolicyDTO dto = new DoiJpaMasterPolicyDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DoiJpaMasterPolicyDTO> toDTO(List<DoiJPAMasterPolicy> entityList) {
		List<DoiJpaMasterPolicyDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)));
		return dtoList;
	}
	
	public List<DoiJpaMasterPolicyDTO> toDTOList(List<DoiJPAMasterPolicy> entityList) {
		List<DoiJpaMasterPolicyDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)) );
		return dtoList;
	}

}

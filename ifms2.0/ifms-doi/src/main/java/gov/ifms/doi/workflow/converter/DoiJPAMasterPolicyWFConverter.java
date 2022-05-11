package gov.ifms.doi.workflow.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.workflow.dto.DoiJpaMasterPolicyWFDTO;
import gov.ifms.doi.workflow.entity.DoiJPAMasterPolicyWF;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Component
public class DoiJPAMasterPolicyWFConverter implements BaseConverter<DoiJPAMasterPolicyWF, DoiJpaMasterPolicyWFDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiJPAMasterPolicyWF toEntity(DoiJpaMasterPolicyWFDTO dto) {
		DoiJPAMasterPolicyWF entity = new DoiJPAMasterPolicyWF();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DoiJpaMasterPolicyWFDTO toDTO(DoiJPAMasterPolicyWF entity) {
		DoiJpaMasterPolicyWFDTO dto = new DoiJpaMasterPolicyWFDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DoiJpaMasterPolicyWFDTO> toDTO(List<DoiJPAMasterPolicyWF> entityList) {
		List<DoiJpaMasterPolicyWFDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)));
		return dtoList;
	}

}

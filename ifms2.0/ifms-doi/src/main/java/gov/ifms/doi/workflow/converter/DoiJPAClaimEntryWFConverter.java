package gov.ifms.doi.workflow.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.workflow.dto.DoiJpaClaimEntryWFDTO;
import gov.ifms.doi.workflow.entity.DoiJpaClaimEntryWF;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Component
public class DoiJPAClaimEntryWFConverter implements BaseConverter<DoiJpaClaimEntryWF, DoiJpaClaimEntryWFDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiJpaClaimEntryWF toEntity(DoiJpaClaimEntryWFDTO dto) {
		DoiJpaClaimEntryWF entity = new DoiJpaClaimEntryWF();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DoiJpaClaimEntryWFDTO toDTO(DoiJpaClaimEntryWF entity) {
		DoiJpaClaimEntryWFDTO dto = new DoiJpaClaimEntryWFDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DoiJpaClaimEntryWFDTO> toDTO(List<DoiJpaClaimEntryWF> entityList) {
		List<DoiJpaClaimEntryWFDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)));
		return dtoList;
	}

}

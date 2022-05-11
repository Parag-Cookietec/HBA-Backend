package gov.ifms.doi.workflow.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.workflow.dto.DoiCoinsPolicyHdrWfDTO;
import gov.ifms.doi.workflow.entity.DoiCoinsPolicyHdrWfEntity;

/**
 * 
 * @author Rudra
 *
 */
@Component
public class DoiCoinsPolicyEntryWFConverter implements BaseConverter<DoiCoinsPolicyHdrWfEntity, DoiCoinsPolicyHdrWfDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiCoinsPolicyHdrWfEntity toEntity(DoiCoinsPolicyHdrWfDTO dto) {
		DoiCoinsPolicyHdrWfEntity entity = new DoiCoinsPolicyHdrWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DoiCoinsPolicyHdrWfDTO toDTO(DoiCoinsPolicyHdrWfEntity entity) {
		DoiCoinsPolicyHdrWfDTO dto = new DoiCoinsPolicyHdrWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DoiCoinsPolicyHdrWfDTO> toDTO(List<DoiCoinsPolicyHdrWfEntity> entityList) {
		List<DoiCoinsPolicyHdrWfDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)));
		return dtoList;
	}

}

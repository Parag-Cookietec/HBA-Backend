package gov.ifms.doi.workflow.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.workflow.dto.DoiCoinsClaimHdrWfDTO;
import gov.ifms.doi.workflow.entity.DoiCoinsClaimHdrWfEntity;

/**
 * 
 * @author Rudra
 *
 */
@Component
public class DoiCoinsClaimEntryWFConverter implements BaseConverter<DoiCoinsClaimHdrWfEntity, DoiCoinsClaimHdrWfDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiCoinsClaimHdrWfEntity toEntity(DoiCoinsClaimHdrWfDTO dto) {
		DoiCoinsClaimHdrWfEntity entity = new DoiCoinsClaimHdrWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DoiCoinsClaimHdrWfDTO toDTO(DoiCoinsClaimHdrWfEntity entity) {
		DoiCoinsClaimHdrWfDTO dto = new DoiCoinsClaimHdrWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DoiCoinsClaimHdrWfDTO> toDTO(List<DoiCoinsClaimHdrWfEntity> entityList) {
		List<DoiCoinsClaimHdrWfDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)));
		return dtoList;
	}

}

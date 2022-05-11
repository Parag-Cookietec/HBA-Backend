package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.jpa.dto.DoiJPAClaimEntryDTO;
import gov.ifms.doi.jpa.dto.DoiJpaClaimEntryListingDTO;
import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Component
public class DoiJPAClaimEntryConverter implements BaseConverter<DoiJPAClaimEntryEntity, DoiJPAClaimEntryDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DoiJPAClaimEntryEntity toEntity(DoiJPAClaimEntryDTO dto) {
		DoiJPAClaimEntryEntity entity = new DoiJPAClaimEntryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DoiJPAClaimEntryDTO toDTO(DoiJPAClaimEntryEntity entity) {
		DoiJPAClaimEntryDTO dto = new DoiJPAClaimEntryDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	


public DoiJpaClaimEntryListingDTO toResponseDTO(DoiJPAClaimEntryEntity entity) {
	DoiJpaClaimEntryListingDTO dto = new DoiJpaClaimEntryListingDTO();
	BeanUtils.copyProperties(entity, dto);
	return dto;
}
	public List<DoiJPAClaimEntryDTO> toDTOList(List<DoiJPAClaimEntryEntity> entityList) {
		List<DoiJPAClaimEntryDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)) );
		return dtoList;
	}
	
	public List<DoiJpaClaimEntryListingDTO> toResponseDTOList(List<DoiJPAClaimEntryEntity> entityList) {
		List<DoiJpaClaimEntryListingDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toResponseDTO(entity)) );
		return dtoList;
	}
}

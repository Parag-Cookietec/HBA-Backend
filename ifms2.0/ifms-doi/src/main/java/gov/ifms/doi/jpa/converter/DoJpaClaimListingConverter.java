/**
 * 
 */
package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.doi.jpa.dto.DoiJpaClaimListingResponseDTO;
import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;

/**
 * @author Rudra
 *
 */
@Component
public class DoJpaClaimListingConverter {

	public DoiJpaClaimListingResponseDTO toEntity(DoiJPAClaimEntryEntity entity) {
		DoiJpaClaimListingResponseDTO dto = new DoiJpaClaimListingResponseDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<DoiJpaClaimListingResponseDTO> toDtoListFromEntityList(List<DoiJPAClaimEntryEntity> responseEntityList) {
		List<DoiJpaClaimListingResponseDTO> responseDtoList = new ArrayList<>();
		for(DoiJPAClaimEntryEntity entity : responseEntityList) {
			responseDtoList.add(toDtoFromEntity(entity));
		}
		return responseDtoList;
	}

	private DoiJpaClaimListingResponseDTO toDtoFromEntity(DoiJPAClaimEntryEntity entity) {
		DoiJpaClaimListingResponseDTO responseDto = new DoiJpaClaimListingResponseDTO();
		BeanUtils.copyProperties(entity, responseDto);
		return responseDto;
	}
}

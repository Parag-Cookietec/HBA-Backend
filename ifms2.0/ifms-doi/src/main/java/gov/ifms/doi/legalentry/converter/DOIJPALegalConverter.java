/**
 * 
 */
package gov.ifms.doi.legalentry.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.doi.legalentry.dto.DOIJPALegalDetailEntryDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalDetailEntryResponseDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalEntryForRequestDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalEntryListingRespDTO;
import gov.ifms.doi.legalentry.dto.DOIJpaLegalDtlDTO;
import gov.ifms.doi.legalentry.dto.DOIJpaLegalOthrPaymentDTO;
import gov.ifms.doi.legalentry.entity.DOIJPALegalDetailEntryEntity;
import gov.ifms.doi.legalentry.entity.DOIJpaLegalDtlEntity;
import gov.ifms.doi.legalentry.entity.DOIJpaLegalOthrPaymentEntity;

/**
 * @author Rudra
 *
 */
@Component
public class DOIJPALegalConverter {

	public DOIJPALegalDetailEntryEntity toLegalDetailEntryEntity(DOIJPALegalDetailEntryDTO dto) {
		DOIJPALegalDetailEntryEntity entity = new DOIJPALegalDetailEntryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public DOIJpaLegalDtlEntity toLegalDetailsEntity(DOIJPALegalEntryForRequestDTO dto) {
		DOIJpaLegalDtlEntity entity = new DOIJpaLegalDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<DOIJpaLegalDtlEntity> toLegalDetailsEntityList(List<DOIJpaLegalDtlDTO> dtolist) {
		return dtolist.stream().map(this::toLegalDetailsEntity).collect(Collectors.toList());
	}

	public DOIJpaLegalDtlEntity toLegalDetailsEntity(DOIJpaLegalDtlDTO dto) {
		DOIJpaLegalDtlEntity entity = new DOIJpaLegalDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<DOIJpaLegalOthrPaymentEntity> toOtherPaymentEntityList(List<DOIJpaLegalOthrPaymentDTO> dtolist) {
		return dtolist.stream().map(this::toOtherPaymentEntity).collect(Collectors.toList());
	}

	public DOIJpaLegalOthrPaymentEntity toOtherPaymentEntity(DOIJpaLegalOthrPaymentDTO dto) {
		DOIJpaLegalOthrPaymentEntity entity = new DOIJpaLegalOthrPaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<DOIJPALegalEntryListingRespDTO> toEntryListingRespDTOList(List<DOIJpaLegalDtlEntity> entities) {
		return entities.stream().map(this::toEntryListingRespDTO).collect(Collectors.toList());
	}

	public DOIJPALegalEntryListingRespDTO toEntryListingRespDTO(DOIJpaLegalDtlEntity entity) {
		DOIJPALegalEntryListingRespDTO dto = new DOIJPALegalEntryListingRespDTO();
		BeanUtils.copyProperties(entity.getDoiJpaLegalEntry(), dto);
		BeanUtils.copyProperties(entity, dto);
		dto.setInwardDt(entity.getDoiJpaLegalEntry().getInwardDt());
		dto.setInwardNo(entity.getDoiJpaLegalEntry().getInwardNo());
		return dto;
	}

	public DOIJPALegalDetailEntryDTO toJPALegalDetailEntryDTO(DOIJPALegalDetailEntryEntity entity) {
		DOIJPALegalDetailEntryDTO dto = new DOIJPALegalDetailEntryDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setJpaLegalDtlDTO(toLegalDetailsDTOList(entity.getDoiJpaLegalDtls()));
		return dto;
	}
	
	public DOIJPALegalDetailEntryResponseDTO toJpaLegalEntryDto(DOIJpaLegalDtlEntity doiJpaLegalDtlEntity)
	{		DOIJPALegalDetailEntryResponseDTO dto = new DOIJPALegalDetailEntryResponseDTO();
	        BeanUtils.copyProperties(doiJpaLegalDtlEntity, dto);
	return dto;
		
	}
	public DOIJPALegalEntryListingRespDTO toJpaLegalEntryRespDto(DOIJPALegalDetailEntryEntity entity)
	{		DOIJPALegalEntryListingRespDTO dto = new DOIJPALegalEntryListingRespDTO();
	        BeanUtils.copyProperties(entity, dto);
	return dto;
		
	}
	
	
	public List<DOIJPALegalEntryListingRespDTO> toJpaLegalEntryDtoList(List<DOIJPALegalDetailEntryEntity> entityList)
	{		List<DOIJPALegalEntryListingRespDTO> dtolist = new ArrayList<DOIJPALegalEntryListingRespDTO>();
	       for(DOIJPALegalDetailEntryEntity entity : entityList)
	       {
	    	   dtolist.add(toJpaLegalEntryRespDto(entity));
	       }
	return dtolist;
		
	}
	
	public List<DOIJpaLegalDtlDTO> toLegalDetailsDTOList(List<DOIJpaLegalDtlEntity> entities) {
		return entities.stream().map(this::toLegalDetailsDTO).collect(Collectors.toList());
	}
	
	public DOIJpaLegalDtlDTO toLegalDetailsDTO(DOIJpaLegalDtlEntity entity) {
		DOIJpaLegalDtlDTO dto = new DOIJpaLegalDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setDoiJpaLegalOthrPaymentDTO(toOtherPaymentDTOList(entity.getdOIJpaLegalOthrPaymentEntities()));
		return dto;
	}
	
	public List<DOIJpaLegalOthrPaymentDTO> toOtherPaymentDTOList(List<DOIJpaLegalOthrPaymentEntity> entities) {
		return entities.stream().map(this::toOtherPaymentDTO).collect(Collectors.toList());
	}
	
	public DOIJpaLegalOthrPaymentDTO toOtherPaymentDTO(DOIJpaLegalOthrPaymentEntity entity) {
		DOIJpaLegalOthrPaymentDTO dto = new DOIJpaLegalOthrPaymentDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}

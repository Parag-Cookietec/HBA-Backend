package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSMainTransactionDto;
import gov.ifms.dmo.dto.DMODPSTransactionDto;
import gov.ifms.dmo.entity.DMODPSTransactionSubTypeEntity;
import gov.ifms.dmo.entity.DMODPSTransactionTypeEntity;


/**
 * The Class DMODPSTransactionConverter class.
 * 
 * @version 1.0
 * @created 2021/07/11 17:17:15
 *
 */
@Component
public class DMODPSTransactionConverter implements BaseConverter<DMODPSTransactionTypeEntity,DMODPSMainTransactionDto>{


	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the DMODPSMainTransactionDto  dto
	 */
	@Override
	public DMODPSMainTransactionDto toDTO(DMODPSTransactionTypeEntity entity) {
		DMODPSMainTransactionDto dto = new DMODPSMainTransactionDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To MainTransactionDto DTO.
	 *
	 * @param transactionsEntityList the MainTransaction entity list
	 * @return the list
	 */
	public List<DMODPSMainTransactionDto> toMainTransactionDTO(List<DMODPSTransactionTypeEntity> transactionsEntityList) {
		return transactionsEntityList.stream()
				.map(entityInList -> new DMODPSMainTransactionDto(entityInList.getId(),entityInList.getTransactionType()))
				.collect(Collectors.toList());
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the DMODPSTransactionTypeEntity entity
	 */
	@Override
	public DMODPSTransactionTypeEntity toEntity(DMODPSMainTransactionDto dto) {
		DMODPSTransactionTypeEntity entity = new DMODPSTransactionTypeEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	
	/**
	 * To DMODPSTransactionDto DTO.
	 *
	 * @param SubTypeEntities the subTypeTransaction entity list
	 * @return the list
	 */
	public List<DMODPSTransactionDto> toSubTypetransaction(List<DMODPSTransactionSubTypeEntity> subTypeEntities) {
		return subTypeEntities.stream()
				.map(entity -> new DMODPSTransactionDto(entity.getId(), entity.getTransactionType()))
				.collect(Collectors.toList());
	}

	

}

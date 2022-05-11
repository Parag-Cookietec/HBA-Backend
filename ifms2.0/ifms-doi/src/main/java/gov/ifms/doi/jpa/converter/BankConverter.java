/**
 * 
 */
package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.doi.jpa.dto.BankDTO;
import gov.ifms.doi.jpa.entity.BankEntity;

/**
 * @author Sagar JAdjav
 *
 */
@Component
public class BankConverter {

	public BankEntity toEntity(BankDTO dto) {
		BankEntity entity = new BankEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<BankDTO> toDtoListFromEntityList(List<BankEntity> entityList) {
		List<BankDTO> dtoList = new ArrayList<>();
		for (BankEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
		return dtoList;
	}

	public BankDTO toDtoFromEntity(BankEntity entity) {
		BankDTO dto = new BankDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

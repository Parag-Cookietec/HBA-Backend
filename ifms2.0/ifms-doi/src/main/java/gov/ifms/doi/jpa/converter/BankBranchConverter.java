/**
 * 
 */
package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.doi.jpa.dto.BankBranchDTO;
import gov.ifms.doi.jpa.entity.BankBranchEntity;

/**
 * @author Sagar JAdjav
 *
 */
@Component
public class BankBranchConverter {

	public BankBranchEntity toEntity(BankBranchDTO dto) {
		BankBranchEntity entity = new BankBranchEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<BankBranchDTO> toDtoListFromEntityList(List<BankBranchEntity> entityList) {
		List<BankBranchDTO> dtoList = new ArrayList<>();
		for (BankBranchEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
		return dtoList;
	}

	public BankBranchDTO toDtoFromEntity(BankBranchEntity entity) {
		BankBranchDTO dto = new BankBranchDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

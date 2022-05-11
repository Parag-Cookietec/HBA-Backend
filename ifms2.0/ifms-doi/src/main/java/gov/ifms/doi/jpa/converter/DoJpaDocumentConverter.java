/**
 * 
 */
package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.doi.jpa.dto.DoiJpaCommonDocumentDTO;
import gov.ifms.doi.jpa.dto.DoiJpaLossCauseDocumentDTO;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeDocumentDTO;
import gov.ifms.doi.jpa.entity.DoiJpaCommonDocumentEntity;
import gov.ifms.doi.jpa.entity.DoiJpaLossCauseDocumentEntity;
import gov.ifms.doi.jpa.entity.DoiJpaSchemeDocumentEntity;

/**
 * @author Rudra
 *
 */
@Component
public class DoJpaDocumentConverter {

	public DoiJpaCommonDocumentEntity toCommonDocumentEntity(DoiJpaCommonDocumentDTO dto) {
		DoiJpaCommonDocumentEntity entity = new DoiJpaCommonDocumentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public List<DoiJpaCommonDocumentDTO> commonDocEntityListToDTOList(List<DoiJpaCommonDocumentEntity> entityList) {
		ArrayList<DoiJpaCommonDocumentDTO> dtoList = new ArrayList<>();
		for(DoiJpaCommonDocumentEntity entity : entityList) {
			dtoList.add(commonDocToDTO(entity));
		}
		return dtoList;
	}
	
	public DoiJpaCommonDocumentDTO commonDocToDTO(DoiJpaCommonDocumentEntity entity) {
		DoiJpaCommonDocumentDTO dto = new DoiJpaCommonDocumentDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DoiJpaSchemeDocumentEntity toSchemeDocumentEntity(DoiJpaSchemeDocumentDTO dto) {
		DoiJpaSchemeDocumentEntity entity = new DoiJpaSchemeDocumentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public List<DoiJpaSchemeDocumentDTO> schemeEntityListToDTOList(List<DoiJpaSchemeDocumentEntity> entityList) {
		ArrayList<DoiJpaSchemeDocumentDTO> dtoList = new ArrayList<>();
		for(DoiJpaSchemeDocumentEntity entity : entityList) {
			dtoList.add(schemeToDTO(entity));
		}
		return dtoList;
	}
	
	public DoiJpaSchemeDocumentDTO schemeToDTO(DoiJpaSchemeDocumentEntity entity) {
		DoiJpaSchemeDocumentDTO dto = new DoiJpaSchemeDocumentDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DoiJpaLossCauseDocumentEntity toLossCauseDocumentEntity(DoiJpaLossCauseDocumentDTO dto) {
		DoiJpaLossCauseDocumentEntity entity = new DoiJpaLossCauseDocumentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public List<DoiJpaLossCauseDocumentDTO> lossCauseEntityListToDTOList(List<DoiJpaLossCauseDocumentEntity> entityList) {
		ArrayList<DoiJpaLossCauseDocumentDTO> dtoList = new ArrayList<>();
		for(DoiJpaLossCauseDocumentEntity entity : entityList) {
			dtoList.add(lossCauseDocToDTO(entity));
		}
		return dtoList;
	}
	
	public DoiJpaLossCauseDocumentDTO lossCauseDocToDTO(DoiJpaLossCauseDocumentEntity entity) {
		DoiJpaLossCauseDocumentDTO dto = new DoiJpaLossCauseDocumentDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}

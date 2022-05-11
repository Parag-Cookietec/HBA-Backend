package gov.ifms.workflow.converter;


import gov.ifms.common.util.EncryptDecryptUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.workflow.dto.PvuTrnEmpCrWfDto;
import gov.ifms.workflow.entity.PvuTrnEmpCrWfEntity;



/**
 * The Class PvuTrnEmpCrWfConverter.
 */
@Component
public class PvuTrnEmpCrWfConverter implements BaseConverter<PvuTrnEmpCrWfEntity,PvuTrnEmpCrWfDto> {
	
	@Autowired
	EncryptDecryptUtil securityUtil;

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the trn edp wf entity
	 */
	@Override
	public PvuTrnEmpCrWfEntity toEntity(PvuTrnEmpCrWfDto dto) {
		PvuTrnEmpCrWfEntity entity = new PvuTrnEmpCrWfEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setAssignByUserId(Long.parseLong(securityUtil.decrypt(dto.getAssignByUserId())));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the trn edp wf dto
	 */
	@Override
	public PvuTrnEmpCrWfDto toDTO(PvuTrnEmpCrWfEntity entity) {
		PvuTrnEmpCrWfDto dto = new PvuTrnEmpCrWfDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setAssignByUserId(securityUtil.encrypt(String.valueOf(entity.getAssignByUserId())));
		return dto;
	}

	/**
	 * To view.
	 *
	 * @param trnId
	 * @return the trn edp wf dto
	 */
	public PvuTrnEmpCrWfDto toView(Long trnId) {
		PvuTrnEmpCrWfDto dto = new PvuTrnEmpCrWfDto();
		dto.setPvuTrnEmpCrWfId(trnId);
		return dto; 
		
	}
	
}

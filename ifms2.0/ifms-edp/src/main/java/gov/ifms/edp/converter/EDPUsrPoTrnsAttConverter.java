package gov.ifms.edp.converter;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPUsrPoTrnsAttDto;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsAttEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsHeaderEntity;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPUsrPoTrnsAttConverter class.
 * 
 * @version 1.0
 * @created 2020/01/02 14:43:21
 *
 */
@Component
public class EDPUsrPoTrnsAttConverter implements BaseConverter<EDPUsrPoTrnsAttEntity,EDPUsrPoTrnsAttDto> {

	@Autowired
	private EDPEmployeRepository employeRepository;
	
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPUsrPoTrnsAtt entity
	 */
	@Override
	public EDPUsrPoTrnsAttEntity toEntity(EDPUsrPoTrnsAttDto dto) {
		EDPUsrPoTrnsAttEntity entity = new EDPUsrPoTrnsAttEntity();
		entity.setAttachmentId(new EDPMsAttachmentEntity(dto.getAttachmentId()));
		entity.setEdpUsrPoTrnsHeadrId(new EDPUsrPoTrnsHeaderEntity(dto.getEdpUsrPoTrnsHeadrId()));
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPUsrPoTrnsAtt  dto
	 */
	@Override
	public EDPUsrPoTrnsAttDto toDTO(EDPUsrPoTrnsAttEntity entity) {
		List<Object[]> employeeInfo = employeRepository.getEmployeeInfoForLogin(entity.getUploadedBy().getUserCode());
		EDPUsrPoTrnsAttDto dto = new EDPUsrPoTrnsAttDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setAttachmentName(entity.getAttachmentId().getAttachmentName());
		dto.setUploadedByName(EDPUtility.getEmployeeNameFromEmployeeInfo(employeeInfo));
		dto.setAttachmentId(entity.getAttachmentId().getAttachmentId());
		dto.setUploadedFileSize(entity.getUploadedFileSize());
		dto.setFile(null);
		return dto;
	}
	
}

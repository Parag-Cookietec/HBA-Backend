package gov.ifms.edp.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPOfficeAttachmentDto;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPOfficeAttachmentEntity;

/**
 * The Class EDPOfficeAttachementConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 15:19:32
 *
 */
@Component
public class EDPOfficeAttachementConverter implements BaseConverter<EDPOfficeAttachmentEntity, EDPOfficeAttachmentDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP office attachment entity
	 */
	@Override
	public EDPOfficeAttachmentEntity toEntity(EDPOfficeAttachmentDto dto) {
		EDPOfficeAttachmentEntity entity = new EDPOfficeAttachmentEntity();
		entity.setAttachmentId(new EDPMsAttachmentEntity(dto.getAttachmentId()));
		entity.setUploadedBy(new EDPMsUserEntity(dto.getUploadedBy()));
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP office attachment dto
	 */
	@Override
	public EDPOfficeAttachmentDto toDTO(EDPOfficeAttachmentEntity entity) {
		EDPOfficeAttachmentDto dto = new EDPOfficeAttachmentDto();
		dto.setAttachmentId(entity.getAttachmentId().getAttachmentId());
		dto.setAttachmentName(entity.getAttachmentId().getAttachmentName());
		dto.setUploadedBy(entity.getUploadedBy().getUserId());
		dto.setUploadedByName(entity.getUploadedBy().getUserName());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<EDPOfficeAttachmentDto> toListView(List<Object[]> list) {
		List<EDPOfficeAttachmentDto> attList = new ArrayList<>();
		list.forEach(attch -> {
			EDPOfficeAttachmentDto edpOfficeAttachmentDto = new EDPOfficeAttachmentDto();
			edpOfficeAttachmentDto.setOfcAttactmentId(getLongValue(attch[0]));
			edpOfficeAttachmentDto.setOfficeId(getLongValue(attch[1]));
			edpOfficeAttachmentDto.setAttachmentId(getLongValue(attch[2]));
			edpOfficeAttachmentDto.setFileName((getStringValue(attch[4])));
			edpOfficeAttachmentDto.setUploadedFileName(getStringValue(attch[6]));
			edpOfficeAttachmentDto.setUploadedBy(getLongValue(attch[8]));
			edpOfficeAttachmentDto.setPathUploadFile(getStringValue(attch[5]));
			edpOfficeAttachmentDto.setUploadedFileSize(getLongValue(attch[16]));
			edpOfficeAttachmentDto.setUploadedByName(getStringValue(attch[17]));
			attList.add(edpOfficeAttachmentDto);
		});
		return attList;
	}

	/**
	 * Gets the string value.
	 *
	 * @param obj the obj
	 * @return the string value
	 */
	private String getStringValue(Object obj) {
		String value = String.valueOf(obj);
		if (value == null || value.equals("null")) {
			return "";
		} else {
			return value;
		}

	}

	/**
	 * Gets the long value.
	 *
	 * @param obj the obj
	 * @return the long value
	 */
	private Long getLongValue(Object obj) {
		String value = String.valueOf(obj);
		if (value == null || value.equals("null")) {
			return 0l;
		} else {
			return Long.valueOf(value);
		}

	}

	public List<EDPOfficeAttachmentDto> convertToView(List<Object[]> officeAttachment) {
		List<EDPOfficeAttachmentDto> attList = new ArrayList<>();
		officeAttachment.forEach(attch -> {
			EDPOfficeAttachmentDto edpOfficeAttachmentDto = new EDPOfficeAttachmentDto();
			edpOfficeAttachmentDto.setOfcAttactmentId(getLongValue(attch[1]));
			edpOfficeAttachmentDto.setOfficeId(getLongValue(attch[2]));
			edpOfficeAttachmentDto.setAttachmentId(getLongValue(attch[3]));
			edpOfficeAttachmentDto.setFileName((getStringValue(attch[5])));
			edpOfficeAttachmentDto.setPathUploadFile(getStringValue(attch[6]));
			edpOfficeAttachmentDto.setUploadedFileName(getStringValue(attch[7]));
			edpOfficeAttachmentDto.setUploadedBy(getLongValue(attch[8]));
			edpOfficeAttachmentDto.setUploadedFileSize(getLongValue(attch[17]));
			edpOfficeAttachmentDto.setUploadedByName(getStringValue(attch[19]));
			attList.add(edpOfficeAttachmentDto);
		});
		return attList;
	}
}

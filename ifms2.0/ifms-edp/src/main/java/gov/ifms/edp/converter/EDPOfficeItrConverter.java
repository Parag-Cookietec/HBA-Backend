package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOfficeItrDto;
import gov.ifms.edp.dto.EDPOfficeItrView;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPOfficeItrEntity;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPOfficeItrConverter.
 */
@Component
public class EDPOfficeItrConverter implements BaseConverter<EDPOfficeItrEntity, EDPOfficeItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPEdpOfficeItr entity
	 */
	@Override
	public EDPOfficeItrEntity toEntity(EDPOfficeItrDto dto) {
		EDPOfficeItrEntity entity = new EDPOfficeItrEntity();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPEdpOfficeItr dto
	 */
	@Override
	public EDPOfficeItrDto toDTO(EDPOfficeItrEntity entity) {
		EDPOfficeItrDto dto = new EDPOfficeItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To list view.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPOfficeItrView> toListView(List<Object[]> list) {

		return list.stream().map(this::toView).collect(Collectors.toList());

	}

	/**
	 * To view.
	 *
	 * @param object the object
	 * @return the EDP office itr view
	 */
	public EDPOfficeItrView toView(Object[] object) {

		EDPOfficeItrView view = new EDPOfficeItrView();
		view.setRequestNo(getStringValue(object[0]));
		view.setDistrictId(getLongValue(object[1]));
		view.setLocationName(getStringValue(object[2]));
		view.setDesignationDDOId(getLongValue(String.valueOf(object[3])));
		view.setDesignationName(getStringValue(object[4]));
		view.setEdpOfficeName(getStringValue(object[5]));

		view.setCreatedDate(EDPUtility.getDateValue(String.valueOf(object[6])));
		view.setRequestToUserId(getLongValue(object[7]));
		view.setRequestToUserName(getStringValue(object[8]));
		view.setOfficeId(getLongValue(object[11]));
		view.setCardexNo(getLongValue(object[12]));
		view.setDdoNo(getStringValue(object[13]));
		view.setOfficeTypeId(getLongValue(object[14]));
		view.setStatus(getStringValue(object[15]));
		view.setLyingWith(getStringValue(object[16]));
		view.setWfStatus(getStringValue(object[17]));
		view.setTrnStatus(getStringValue(object[18]));
		view.setIsEditable(getLongValue(object[19]));
		return view;
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

	/**
	 * To entity.
	 *
	 * @param officeEntity the office entity
	 * @return the EDP office itr entity
	 */
	public EDPOfficeItrEntity toEntity(EDPMsOfficeEntity officeEntity) {
		EDPOfficeItrEntity entity = new EDPOfficeItrEntity();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		BeanUtils.copyProperties(officeEntity, entity);
		return entity;
	}

	
	/**
	 * To office dto.
	 *
	 * @return the EDP ms office dto
	 */
	public EDPMsOfficeDto toOfficeDto(EDPOfficeItrEntity entity) {
		EDPMsOfficeDto dto = new EDPMsOfficeDto();
		BeanUtils.copyProperties(entity, dto);
		if(null!=entity.getDistrictId()) {
			dto.setDistrictId(entity.getDistrictId().getDistrictId());
			dto.setDistrictName(entity.getDistrictId().getDistrictName());
			dto.setDistName(entity.getDistrictId().getDistrictName());
		}
		if(null!=entity.getDepartmentId()) {
			dto.setDepartmentId(entity.getDepartmentId().getDepartmentId());
			dto.setDeptName(entity.getDepartmentId().getDepartmentName());
		}
		if(null!=entity.getOfficeTypeId()) {
			dto.setOfficeTypeId(entity.getOfficeTypeId().getLookUpInfoId());
			dto.setOfficeTypeName(entity.getOfficeTypeId().getLookUpInfoName());
		}
		if(null!=entity.getTalukaId()) {
			dto.setTalukaId(entity.getTalukaId().getTalukaId());
			dto.setTalukaName(entity.getTalukaId().getTalukaName());
		}

		if (entity.getOfficeTrnEntity() != null) {
			dto.setTrnId(entity.getOfficeTrnEntity().getUpdOffcTrnId());
		}

		return dto;
	}
}

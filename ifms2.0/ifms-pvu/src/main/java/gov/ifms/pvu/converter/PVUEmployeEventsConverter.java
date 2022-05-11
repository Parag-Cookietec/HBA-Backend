package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.dto.PVUEmployeEventsDto;
import gov.ifms.pvu.util.PvuConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class PVUEmployeEventsConverter class.
 * 
 * @version v 1.0
 * @created 2019/12/03 03:14:53
 *
 */
@Component
public class PVUEmployeEventsConverter implements BaseConverter<PVUEmployeEventsEntity, PVUEmployeEventsDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeEvents entity
	 */
	@Override
	public PVUEmployeEventsEntity toEntity(PVUEmployeEventsDto dto) {
		PVUEmployeEventsEntity entity = new PVUEmployeEventsEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeEvents dto
	 */
	@Override
	public PVUEmployeEventsDto toDTO(PVUEmployeEventsEntity entity) {
		PVUEmployeEventsDto dto = new PVUEmployeEventsDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<SearchParam> toPVUObjCommon(PVUCommonApiDto dto) {
		List<SearchParam> postDetails = new ArrayList<>();
		postDetails.add(SearchParam.create("employeeNo", dto.getEmployeeNo()));
		postDetails.add(SearchParam.create("employeeName", dto.getEmployeeName()));
		postDetails.add(SearchParam.create("employeeClass", dto.getEmployeeClass()));
		postDetails.add(SearchParam.create("designationName", dto.getDesignationName()));
		if (dto.getPayCommId().equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			postDetails.add(SearchParam.create("payLevelName", dto.getPayLevelName()));
			postDetails.add(SearchParam.create("cellId", dto.getCellId().toString()));
			postDetails.add(SearchParam.create("cellId", dto.getCellId().toString()));
		} else if (dto.getPayCommId().equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			postDetails.add(SearchParam.create("payBandName", String.valueOf(dto.getPayBandName())));
			postDetails.add(SearchParam.create("payBandValue", String.valueOf(dto.getPayBandValue())));
			postDetails.add(SearchParam.create("gradePayName", String.valueOf(dto.getGradePayName())));
		} else if (dto.getPayCommId().equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			postDetails.add(SearchParam.create("payScaleName", dto.getPayScaleName()));
		}
		postDetails.add(SearchParam.create("empBasicPay", String.valueOf(dto.getEmpBasicPay())));
		postDetails.add(SearchParam.create("dateJoining", dto.getDateJoining()));
		postDetails.add(SearchParam.create("retirementDate", dto.getRetirementDate()));
		postDetails.add(SearchParam.create("officeName", dto.getOfficeName()));
		postDetails.add(SearchParam.create("dateNxtIncr", dto.getDateNxtIncr()));
		postDetails.add(SearchParam.create("eventEffectiveDate", dto.getEventDate()));
		postDetails.add(SearchParam.create("eventOrderDate", dto.getEventDate()));
		postDetails.add(SearchParam.create("benefitEffectiveDate", dto.getEventDate()));
		postDetails.add(SearchParam.create("eventOrderNo", dto.getEventDate()));
		postDetails.add(SearchParam.create("remarks", ""));
		
	return postDetails;
	}


}

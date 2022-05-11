package gov.ifms.pvu.converter;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.pvu.dto.PVUEmployeeEOLeaveDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeeEOLeaveConverter class.
 * 
 * @version v 1.0
 * @created 2019/11/30 10:42:45
 *
 */
@Component
public class PVUEmployeeEOLeaveConverter implements BaseConverter<PVUEmployeeEOLeaveEntity, PVUEmployeeEOLeaveDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeeEOLeave entity
	 */
	@Override
	public PVUEmployeeEOLeaveEntity toEntity(PVUEmployeeEOLeaveDto dto) {
		PVUEmployeeEOLeaveEntity entity = new PVUEmployeeEOLeaveEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getEmpId() != 0) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmpId()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getOfficeId() != 0) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		if (dto.getPostId() != 0) {
			entity.setPostId(new EDPMsPostEntity(dto.getPostId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeeEOLeave dto
	 */
	@Override
	public PVUEmployeeEOLeaveDto toDTO(PVUEmployeeEOLeaveEntity entity) {
		PVUEmployeeEOLeaveDto dto = new PVUEmployeeEOLeaveDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getEmpId() != null) {
			dto.setEmpId(entity.getEmpId().getEmpId());
			if ((entity.getEmpId() != null) && (entity.getEmpId().getEmployeeCode() != null)) {
				dto.setEmployeeNo(entity.getEmpId().getEmployeeCode());
			}
			/*
			 * if(entity.getOfficeId() !=null) {
			 * dto.setOfficeId(entity.getOfficeId().getOfficeId()); }
			 */
		}
		if (entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (entity.getOfficeId() != null) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		}
		if (entity.getPostId() != null) {
			dto.setPostId(entity.getPostId().getPostId());
		}
		return dto;
	}

	public VelocityContext populateVContext(PVUEmployeeEOLeaveEntity entity) {
		VelocityContext context = new VelocityContext();

		context.put("EVENT_NAME", PvuConstant.EVENT_CODE_EOL);
		context.put("TRANSACION_NO", entity.getTransNo() == null ? "" : entity.getTransNo());
		context.put("TRANSACION_DATE", Utils.getDateString(entity.getUpdatedDate()));
		context.put("EMPLOYEE_NO", entity.getEmpId().getEmployeeCode());
		context.put("LEAVE_START_DATE", PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getStartDate()));
		context.put("LEAVE_END_DATE", PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEndDate()));

		String srSaluation = "";
		if (!Utils.isEmpty(entity.getEmpId().getSalutation())) {
			srSaluation = entity.getEmpId().getSalutation().getLookUpInfoName();
		}
		context.put("EMPLOYEE_NAME", srSaluation + " " + entity.getEmpId().getEmployeeName() + " "
				+ entity.getEmpId().getEmployeeMiddleName() + " " + entity.getEmpId().getEmployeeSurname());

		return context;

	}

	public VelocityContext populateVContextPrintComments(PVUEmployeeEOLeaveEntity entity,
			PVUEmployeDepartmentEntity dep) {
		VelocityContext context = new VelocityContext();
		context.put("EVENT_NAME", PvuConstant.EVENT_CODE_EOL);

		context.put("EMPLOYEE_NAME", entity.getEmpId().getEmployeeName());
		context.put("EMPLOYEE_DESIGNATION", dep.getDesignationId().getDesignationName());
		context.put("EMPOYEE_CLASS", dep.getEmpClass().getLookUpInfoName());
		String srSaluation = "";
		if (!Utils.isEmpty(entity.getEmpId().getSalutation())) {
			srSaluation = entity.getEmpId().getSalutation().getLookUpInfoName();
		}
		context.put("EMPLOYEE_NAME", srSaluation + " " + entity.getEmpId().getEmployeeName() + " "
				+ entity.getEmpId().getEmployeeMiddleName() + " " + entity.getEmpId().getEmployeeSurname());

		context.put("DOJ", PvuUtils.getDateToStringDMYFormatValueNew(String.valueOf(dep.getDateOfJoiningGOG())));
		context.put("DOR", PvuUtils.getDateToStringDMYFormatValueNew(String.valueOf(dep.getDateOfRetirement())));

		return context;
	}

}

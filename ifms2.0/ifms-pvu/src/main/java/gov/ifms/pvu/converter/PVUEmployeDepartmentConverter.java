package gov.ifms.pvu.converter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.dto.PVUEmployeDepartmentDto;
import gov.ifms.pvu.dto.PVUEmployeDepartmentEditabelDto;
import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;

/**
 * The Class PVUEmployeDepartmentConverter class.
 *
 * @version v 1.0
 * @created 2019/11/21 14:17:25
 */
@Component
public class PVUEmployeDepartmentConverter
		implements BaseConverter<PVUEmployeDepartmentEntity, PVUEmployeDepartmentDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeeDepartment entity
	 */
	@Override
	public PVUEmployeDepartmentEntity toEntity(PVUEmployeDepartmentDto dto) {
		PVUEmployeDepartmentEntity entity = new PVUEmployeDepartmentEntity();
		BeanUtils.copyProperties(dto, entity);

		if (dto.getDepartmentalCategory() != 0) {
			entity.setDepartmentalCategory(new PVUDepartmentCategoryEntity(dto.getDepartmentalCategory()));
		}
		setEmpIdTypeStatusClassPayTypeFromDtoToEntity(dto, entity);
		if (dto.getActiveStatus() != 0) {
			entity.setActiveStatus(dto.getActiveStatus());
		}
		if (dto.getDesignationId() != 0) {
			EDPMsDesignationEntity designationId = new EDPMsDesignationEntity();
			designationId.setDesignationId(dto.getDesignationId());
			entity.setDesignationId(designationId);
		}
		if (dto.getPayCommissionJoiningTime() != 0) {
			entity.setPayCommissionJoiningTime(new EDPLuLookUpInfoEntity(dto.getPayCommissionJoiningTime()));
		}
		if (dto.getParentHeadDeptId() != 0) {
			entity.setParentHeadDept(new EDPMsDepartmentEntity(dto.getParentHeadDeptId()));
		}
		if (dto.getPresentOffice() != 0) {
			entity.setPresentOffice(new EDPMsOfficeEntity(dto.getPresentOffice()));
		}
		if (dto.getDistrictId() != 0) {
			entity.setDistrictId(new EDPMsDistrictEntity(dto.getDistrictId()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getSubOffice() != 0) {
			entity.setSubOffice(new EDPMsSubOfficeEntity(dto.getSubOffice()));
		}
		if (dto.getHodNameId() != 0) {
			entity.setHodName(new EDPMsOfficeEntity(dto.getHodNameId()));
		}
		if (dto.getTaluka() != 0) {
			entity.setTaluka(new EDPMsTalukaEntity(dto.getTaluka()));
		}
		if (dto.getIsNPA() != 0) {
			entity.setIsNPA(new EDPLuLookUpInfoEntity(dto.getIsNPA()));
		}
		if (dto.getDeputOfficeId() != 0) {
			entity.setDeputOfficeId(new EDPMsOfficeEntity(dto.getDeputOfficeId()));
		}
		if (dto.getDeputDistrictId() != 0) {
			entity.setDeputDistrictId(new EDPMsDistrictEntity(dto.getDeputDistrictId()));
		}
		return entity;
	}

	/**
	 * @param dto
	 * @param entity
	 */
	private void setEmpIdTypeStatusClassPayTypeFromDtoToEntity(PVUEmployeDepartmentDto dto, PVUEmployeDepartmentEntity entity) {
		if (dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if (dto.getEmpStatus() != 0) {
			entity.setEmpStatus(new EDPLuLookUpInfoEntity(dto.getEmpStatus()));
		}
		if (dto.getEmpClass() != 0) {
			entity.setEmpClass(new EDPLuLookUpInfoEntity(dto.getEmpClass()));
		}
		if (dto.getEmpType() != 0) {
			entity.setEmpType(new EDPLuLookUpInfoEntity(dto.getEmpType()));
		}
		if (dto.getEmpPayType() != 0) {
			entity.setEmpPayType(new EDPLuLookUpInfoEntity(dto.getEmpPayType()));
		}
		if (dto.getDeputation()!= 0) {
			entity.setDeputation(new EDPLuLookUpInfoEntity(dto.getDeputation()));
		}
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeeDepartment dto
	 */
	@Override
	public PVUEmployeDepartmentDto toDTO(PVUEmployeDepartmentEntity entity) {
		PVUEmployeDepartmentDto dto = new PVUEmployeDepartmentDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getDepartmentalCategory() != null) {
			dto.setDepartmentalCategory(entity.getDepartmentalCategory().getDeptCategoryId());
			dto.setDepartmentalCategoryName(entity.getDepartmentalCategory().getDepartmentCategoryName());
		}
		setEmpIdStatusClassTypePayTypeActiveStatusFromEntityToDto(entity, dto);
		if (entity.getDesignationId() != null) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
			dto.setDesignationName(entity.getDesignationId().getDesignationName());
		}
		if (entity.getPayCommissionJoiningTime() != null) {
			dto.setPayCommissionJoiningTime(entity.getPayCommissionJoiningTime().getLookUpInfoId());
			dto.setPayCommissionJoiningTimeName(entity.getPayCommissionJoiningTime().getLookUpInfoName());
		}
		if (entity.getPresentOffice() != null) {
			dto.setPresentOffice(entity.getPresentOffice().getOfficeId());
			dto.setPresentOfficeName(entity.getPresentOffice().getOfficeName());
		}
		if (entity.getParentHeadDept() != null) {
			dto.setParentHeadDeptId(entity.getParentHeadDept().getDepartmentId());
			dto.setParentHeadDeptName(entity.getParentHeadDept().getDepartmentName());
		}
		if (entity.getDistrictId() != null) {
			dto.setDistrictId(entity.getDistrictId().getDistrictId());
			dto.setDistrictName(entity.getDistrictId().getDistrictName());
		}
		if (entity.getStatus() != null) {
			dto.setStatusId(entity.getStatus().getLookUpInfoId());
		}
		if (entity.getSubOffice() != null) {
			dto.setSubOffice(entity.getSubOffice().getSubOfficeId());
			dto.setSubOfficeName(entity.getSubOffice().getSubOfficeName());
		}
		if (entity.getHodName() != null) {
			dto.setHodNameId(entity.getHodName().getOfficeId());
			dto.setHodName(entity.getHodName().getOfficeName());
		}
		if (entity.getTaluka() != null) {
			dto.setTaluka(entity.getTaluka().getTalukaId());
			dto.setTalukaName(entity.getTaluka().getTalukaName());
		}
		if (entity.getIsNPA() != null) {
			dto.setIsNPA(entity.getIsNPA().getLookUpInfoId());
			dto.setIsNPAName(entity.getIsNPA().getLookUpInfoName());
		}
		if (entity.getDeputCardexNo() != null) {
			dto.setDeputCardexNo(dto.getDeputCardexNo().trim());
		}
		if (entity.getDeputDdoCode() != null) {
			dto.setDeputDdoCode(dto.getDeputDdoCode().trim());
		}
		return dto;
	}

	/**
	 * @param entity
	 * @param dto
	 */
	private void setEmpIdStatusClassTypePayTypeActiveStatusFromEntityToDto(PVUEmployeDepartmentEntity entity,
			PVUEmployeDepartmentDto dto) {
		if (entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if (entity.getEmpStatus() != null) {
			dto.setEmpStatus(entity.getEmpStatus().getLookUpInfoId());
			dto.setEmpStatusName(entity.getEmpStatus().getLookUpInfoName());
		}
		if (entity.getEmpClass() != null) {
			dto.setEmpClass(entity.getEmpClass().getLookUpInfoId());
			dto.setEmpClassName(entity.getEmpClass().getLookUpInfoName());
		}
		if (entity.getEmpType() != null) {
			dto.setEmpType(entity.getEmpType().getLookUpInfoId());
			dto.setEmpTypeName(entity.getEmpType().getLookUpInfoName());
		}
		if (entity.getEmpPayType() != null) {
			dto.setEmpPayType(entity.getEmpPayType().getLookUpInfoId());
			dto.setEmpPayTypeName(entity.getEmpPayType().getLookUpInfoName());
		}
		if (entity.getJoinEmpPayType() != null) {
			dto.setJoinEmpPayType(entity.getJoinEmpPayType().getLookUpInfoId());
			dto.setJoinEmpPayTypeName(entity.getJoinEmpPayType().getLookUpInfoName());
		}
		if (entity.getActiveStatus() != 0) {
			dto.setActiveStatus(entity.getActiveStatus());
		}
		if (entity.getDeputOfficeId() != null) {
			dto.setDeputOfficeId(entity.getDeputOfficeId().getOfficeId());
			dto.setDeputOfficeName(entity.getDeputOfficeId().getOfficeName());
		}
		if (entity.getDeputDistrictId() != null) {
			dto.setDeputDistrictId(entity.getDeputDistrictId().getDistrictId());
			dto.setDeputDistrictName(entity.getDeputDistrictId().getDistrictName());
		}

		if (entity.getDeputation()!= null) {
			dto.setDeputation(entity.getDeputation().getLookUpInfoId());
			dto.setEmpDeputationName(entity.getDeputation().getLookUpInfoName());
		}
	}

	public PVUEmployeDepartmentEntity toEditEntity(PVUEmployeDepartmentEntity entity,PVUEmployeDepartmentEditabelDto dto) {
		if (dto.getDepartmentalCategory() != 0) {
			entity.setDepartmentalCategory(new PVUDepartmentCategoryEntity(dto.getDepartmentalCategory()));
		}
		setEmpIdTypeStatusClassPayTypeFromDtoToEditEntity(dto, entity);
		if (dto.getActiveStatus() != 0) {
			entity.setActiveStatus(dto.getActiveStatus());
		}
		if (dto.getDesignationId() != 0) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId())); 
		}
		if (dto.getStatusId() != 0) {
			entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getHodNameId() != 0) {
			entity.setHodName(new EDPMsOfficeEntity(dto.getHodNameId()));
		}
		
		if (dto.getDateOfJoiningGOG() != null) {
			entity.setDateOfJoiningGOG(EDPUtility.getDateValue(dto.getDateOfJoiningGOG()));
		}
		if (dto.getDateOfRetirement() != null) {
			entity.setDateOfRetirement(EDPUtility.getDateValue(dto.getDateOfRetirement()));
		}
		if (dto.getSubOffice() != 0) {
			entity.setSubOffice(new EDPMsSubOfficeEntity(dto.getSubOffice()));
		}
		if (dto.getFixPayDate() != null) {
			entity.setFixPayDate(EDPUtility.getDateValue(dto.getFixPayDate()));
		}
		if (dto.getStation() != null) {
			entity.setStation(dto.getStation());
		}
		if (dto.getTaluka() != 0) {
			entity.setTaluka(new EDPMsTalukaEntity(dto.getTaluka()));
		}
		if (dto.getIsNPA() != 0) {
			entity.setIsNPA(new EDPLuLookUpInfoEntity(dto.getIsNPA()));
		}
		if (dto.getChangeType() != 0) {
			entity.setChangeType(dto.getChangeType());
			entity.setUpdatedDate(new Date());
		}
		return entity;
	}

	/**
	 * @param dto
	 * @param entity
	 */
	private void setEmpIdTypeStatusClassPayTypeFromDtoToEditEntity(PVUEmployeDepartmentEditabelDto dto,
			PVUEmployeDepartmentEntity entity) {
		
		if (dto.getEmpStatus() != 0) {
			entity.setEmpStatus(new EDPLuLookUpInfoEntity(dto.getEmpStatus()));
		}
		if (dto.getEmpClass() != 0) {
			entity.setEmpClass(new EDPLuLookUpInfoEntity(dto.getEmpClass()));
		}
		if (dto.getEmpType() != 0) {
			entity.setEmpType(new EDPLuLookUpInfoEntity(dto.getEmpType()));
		}
		if (dto.getPpanNo() != null) {
			entity.setPpanNo(dto.getPpanNo());
		}
		if (dto.getPpoNo()!= null) {
			entity.setPpoNo(dto.getPpoNo());
		}
		if (dto.getPranAccNo()!= null) {
			entity.setPranAccNo(dto.getPranAccNo());
		}
		if (dto.getGpfNo()!= null) {
			entity.setGpfNo(dto.getGpfNo());
		}
		if (dto.getParentHeadDeptId()!= 0) {
			entity.setParentHeadDept(new EDPMsDepartmentEntity(dto.getParentHeadDeptId()));
		}
		if (dto.getDeputationEndDate() != null && !dto.getDeputationEndDate().equals("0")) {
			entity.setDeputationEndDate(EDPUtility.getDateValue(dto.getDeputationEndDate()));
		}else{
			entity.setDeputationEndDate(null);
		}
		if (dto.getDeputationStartDate() != null && !dto.getDeputationStartDate().equals("0")) {
			entity.setDeputationStartDate(EDPUtility.getDateValue(dto.getDeputationStartDate()));
		}else{
			entity.setDeputationStartDate(null);
		}
		if (dto.getDeathTerminationDate() != null && !dto.getDeathTerminationDate().equals("0")) {
			entity.setDeathTerminationDate(EDPUtility.getDateValue(dto.getDeathTerminationDate()));
		}else{
			entity.setDeathTerminationDate(null);
		}
		if (dto.getEmpPayType() != 0) {
			entity.setEmpPayType(new EDPLuLookUpInfoEntity(dto.getEmpPayType()));
		}
		extractedDepution(dto,entity);
	}

	private void extractedDepution(PVUEmployeDepartmentEditabelDto dto,PVUEmployeDepartmentEntity entity) {
		if (dto.getDeputation()!= 0) {
			entity.setDeputation(new EDPLuLookUpInfoEntity(dto.getDeputation()));
		}
		if (dto.getDeputOfficeId() != 0) {
			entity.setDeputOfficeId(new EDPMsOfficeEntity(dto.getDeputOfficeId()));
		}else {
			entity.setDeputOfficeId(null);
		}
		if (dto.getDeputDistrictId() != 0) {
			entity.setDeputDistrictId(new EDPMsDistrictEntity(dto.getDeputDistrictId()));
		}else {
			entity.setDeputDistrictId(null);
		}
		if (dto.getDeputDdoCode() != null && !dto.getDeputDdoCode().equals('0')) {
			entity.setDeputDdoCode(dto.getDeputDdoCode().trim() );
		}else{
			entity.setDeputDdoCode(null);
		}

		if (dto.getDeputCardexNo()!= null &&  !dto.getDeputCardexNo().equals('0')) {
			entity.setDeputCardexNo(dto.getDeputCardexNo().trim());
		}else{
			entity.setDeputCardexNo(null);
		}
	}

}

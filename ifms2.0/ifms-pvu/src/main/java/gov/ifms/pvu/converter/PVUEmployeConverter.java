package gov.ifms.pvu.converter;

import java.util.Date;

import gov.ifms.pvu.util.PvuConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.dto.PVUEmployeDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeConverter class.
 *
 * @version v 1.0
 * @created 2019/11/20 12:05:07
 *
 */
@Component
public class PVUEmployeConverter implements BaseConverter<PVUEmployeEntity, PVUEmployeDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmploye entity
	 */
	@Override
	public PVUEmployeEntity toEntity(PVUEmployeDto dto) {
		PVUEmployeEntity entity = new PVUEmployeEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getEmployeeMiddleName().equalsIgnoreCase(Constant.ZERO_STR)) {
			entity.setEmployeeMiddleName("");
		}
		if (dto.getEmployeeSurname().equalsIgnoreCase(Constant.ZERO_STR)) {
			entity.setEmployeeSurname("");
		}
		if(dto.getOfficeId() != 0) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		if(dto.getNationality() != 0) {
			entity.setNationality(new EDPLuLookUpInfoEntity(dto.getNationality()));
		}
		if(dto.getSalutation() != 0) {
			entity.setSalutation(new EDPLuLookUpInfoEntity(dto.getSalutation()));
		}
		if(dto.getBloodGroup() != 0) {
			entity.setBloodGroup(new EDPLuLookUpInfoEntity(dto.getBloodGroup()));
		}
		employeeEditOne(entity, dto);
		if(!StringUtils.isEmpty(dto.getDateOfBirth())) {
			entity.setDateOfBirth(EDPUtility.getDateValue(dto.getDateOfBirth()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmploye dto
	 */
	@Override
	public PVUEmployeDto toDTO(PVUEmployeEntity entity) {
		PVUEmployeDto dto = new PVUEmployeDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getOfficeId() != null) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
			dto.setOfficeName(entity.getOfficeId().getOfficeName());
		}
		if(entity.getNationality() != null) {
			dto.setNationality(entity.getNationality().getLookUpInfoId());
			dto.setNationalityName(entity.getNationality().getLookUpInfoName());
		}
		if(entity.getSalutation() != null) {
			dto.setSalutation(entity.getSalutation().getLookUpInfoId());
			dto.setSalutationName(entity.getSalutation().getLookUpInfoName());
		}
		if(entity.getBloodGroup() != null) {
			dto.setBloodGroup(entity.getBloodGroup().getLookUpInfoId());
			dto.setBloodGroupName(entity.getBloodGroup().getLookUpInfoName());
		}
		if(entity.getPhType() != null) {
			dto.setPhType(entity.getPhType().getLookUpInfoId());
			dto.setPhTypeName(entity.getPhType().getLookUpInfoName());
		}
		if(entity.getGender() != null) {
			dto.setGender(entity.getGender().getLookUpInfoId());
			dto.setGenderName(entity.getGender().getLookUpInfoName());
		}
		if(entity.getMaritalStatus() != null) {
			dto.setMaritalStatus(entity.getMaritalStatus().getLookUpInfoId());
			dto.setMaritalStatusName(entity.getMaritalStatus().getLookUpInfoName());
		}
		if(entity.getCategory() != null) {
			dto.setCategory(entity.getCategory().getLookUpInfoId());
			dto.setCategoryName(entity.getCategory().getLookUpInfoName());
		}
		if(entity.getPhStatus() != null) {
			dto.setPhStatus(entity.getPhStatus().getLookUpInfoId());
			dto.setPhStatusName(entity.getPhStatus().getLookUpInfoName());
		}
		if(entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
			dto.setStatusName(entity.getStatusId().getLookUpInfoName());
		}
		if(entity.getPassportExpiryDate() != null) {
			dto.setPassportExpiryDate(PvuUtils.getDateToStringValue(entity.getPassportExpiryDate()));
		}
		if(entity.getDateOfMedFitnessCert() != null) {
			dto.setDateOfMedFitnessCert(PvuUtils.getDateToStringValue(entity.getDateOfMedFitnessCert()));
		}
		if(entity.getDateOfBirth() != null) {
			dto.setDateOfBirth(PvuUtils.getDateToStringValue(entity.getDateOfBirth()));
		}
		if(entity.getEmpSrcType() == 1){
			dto.setEmpSrcType(entity.getEmpSrcType());
			dto.setStatusName(PvuConstant.SAVED_AS_DRAFT);
			dto.setStatusId(PvuConstant.SAVE_AS_DRAFT_ID);
		}
		return dto;
	}
	
	public PVUEmployeEntity toUpdateEntity(PVUEmployeEntity entity , PVUEmployeDto dto) {
		if (dto.getEmployeeMiddleName()!= null) {
			entity.setEmployeeMiddleName(dto.getEmployeeMiddleName());
		}
		if (dto.getEmployeeName()!= null) { 
			entity.setEmployeeName(dto.getEmployeeName());
		}
		if (dto.getEmployeeSurname() != null) {
			entity.setEmployeeSurname(dto.getEmployeeSurname());
		}
		if(dto.getNationality() != 0) { 
			entity.setNationality(new EDPLuLookUpInfoEntity(dto.getNationality()));
		}
		if(dto.getSalutation() != 0) {
			entity.setSalutation(new EDPLuLookUpInfoEntity(dto.getSalutation()));
		}
		if(dto.getBloodGroup() != 0) {
			entity.setBloodGroup(new EDPLuLookUpInfoEntity(dto.getBloodGroup()));
		}
		employeeEditOne(entity, dto);
		if(!StringUtils.isEmpty(dto.getDateOfBirth())) {
			entity.setDateOfBirth(EDPUtility.getDateValue(dto.getDateOfBirth()));
		}
		if (dto.getOtherPhCategory() != null) {
			entity.setOtherPhCategory(dto.getOtherPhCategory());
		}
		employeeEditFiled(entity, dto);
		entity.setUpdatedDate(new Date());
		return entity;
	}

	private void employeeEditOne(PVUEmployeEntity entity, PVUEmployeDto dto) {
		if(dto.getGender() != 0) {
			entity.setGender(new EDPLuLookUpInfoEntity(dto.getGender()));
		}
		if(dto.getMaritalStatus() != 0) {
			entity.setMaritalStatus(new EDPLuLookUpInfoEntity(dto.getMaritalStatus()));
		}
		if(dto.getCategory() != 0) {
			entity.setCategory(new EDPLuLookUpInfoEntity(dto.getCategory()));
		}
		if(dto.getPhStatus() != 0) {
			entity.setPhStatus(new EDPLuLookUpInfoEntity(dto.getPhStatus()));
		}
		if(dto.getPhType() != 0) {
			entity.setPhType(new EDPLuLookUpInfoEntity(dto.getPhType()));
		}
		if(dto.getStatusId() != 0) { 
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if(!StringUtils.isEmpty(dto.getPassportExpiryDate())) {
			entity.setPassportExpiryDate(EDPUtility.getDateValue(dto.getPassportExpiryDate()));
		}
		if(!StringUtils.isEmpty(dto.getDateOfMedFitnessCert())) {
			entity.setDateOfMedFitnessCert(EDPUtility.getDateValue(dto.getDateOfMedFitnessCert()));
		}
	}

	private void employeeEditFiled(PVUEmployeEntity entity, PVUEmployeDto dto) {
		if(!StringUtils.isEmpty(dto.getChangeType())) {
			entity.setChangeType(dto.getChangeType());
		}
		if (dto.getFatherName() != null) {
			entity.setFatherName(dto.getFatherName());
		}
		if (dto.getMotherName()!= null) {
			entity.setMotherName(dto.getMotherName());
		}
		if (dto.getMobileNo()!= null) {
			entity.setMobileNo(dto.getMobileNo());
		}
		if (dto.getEmailID() != null) {
			entity.setEmailID(dto.getEmailID());
		}
		if (dto.getReligion() != null) {
			entity.setReligion(dto.getReligion());
		}
		if (dto.getCaste() != null) {
			entity.setCaste(dto.getCaste());
		}
		if(dto.getBloodGroup() != 0) {
			entity.setBloodGroup(new EDPLuLookUpInfoEntity(dto.getBloodGroup()));
		}
		if (dto.getIdentificationMark() != null) {
			entity.setIdentificationMark(dto.getIdentificationMark());
		}
		if (dto.getHeight() != null) {
			entity.setHeight(dto.getHeight());
		}
		if (dto.getElectionCardNo()!= null) {
			entity.setElectionCardNo(dto.getElectionCardNo());
		}
		if (dto.getAadhaarNo() != null) {
			entity.setAadhaarNo(dto.getAadhaarNo());
		}
		if (dto.getPanNo() != null) {
			entity.setPanNo(dto.getPanNo());
		}
		if (dto.getPassportNo() != null) {
			entity.setPassportNo(dto.getPassportNo());
		}
		if (dto.getBuckleNo() != null) {
			entity.setBuckleNo(dto.getBuckleNo());
		}
	}
	
}

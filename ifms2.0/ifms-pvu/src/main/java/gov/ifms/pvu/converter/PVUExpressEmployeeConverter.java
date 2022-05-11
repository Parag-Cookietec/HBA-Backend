package gov.ifms.pvu.converter;

import com.google.common.base.Strings;
import freemarker.template.SimpleDate;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.dto.response.PVUExpressEmployeeDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * The Class PVUEmployeConverter class.
 *
 * @version v 1.0
 * @created 2019/11/20 12:05:07
 *
 */
@Component
public class PVUExpressEmployeeConverter implements BaseConverter<PVUEmployeEntity, PVUExpressEmployeeDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmploye entity
	 */
	@Override
	public PVUEmployeEntity toEntity(PVUExpressEmployeeDto dto) {
		PVUEmployeEntity entity = new PVUEmployeEntity();
		EDPMsPostDto loginUserDet = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		entity.setOfficeId(new EDPMsOfficeEntity(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeId()));
		if(dto.getEmpPayTypeId().equals(PvuConstant.EMP_PAY_TYPE_REGULAR)){
			entity.setCaseNo(dto.getCaseNo());
		}
		entity.setSalutation(new EDPLuLookUpInfoEntity(dto.getSalutationId()));
		entity.setEmployeeName(dto.getEmpFirstName());
		entity.setEmployeeMiddleName(dto.getEmpMiddleName());
		entity.setEmployeeSurname(dto.getEmpLastName());
		entity.setDateOfBirth(PvuUtils.getDateFromStringWithFormat(dto.getDateOfBirth(),PvuUtils.DATE_FORMAT_DD_MM_YYYY1));
		entity.setMobileNo(dto.getMobileNo());
		entity.setPanNo(dto.getPanNo());
		entity.setRemarks(PvuConstant.EXP_EMP_CREATION_REMARKS);
		entity.setStatusId(new EDPLuLookUpInfoEntity(Constant.LU_APPROVED_LOOKUP_INFO_ID));
		entity.setOfficeName(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeName());
		entity.setEmpSrcType(PvuConstant.EXP_EMP_SRC_TYPE);
		return entity;
	}

	public PVUEmployeDepartmentEntity toPvuDptEntity(PVUExpressEmployeeDto dto,long employeeId) {
		PVUEmployeDepartmentEntity deptEntity = new PVUEmployeDepartmentEntity();
		EDPMsPostDto loginUserDet = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		deptEntity.setPvuEmployeEntity(new PVUEmployeEntity(employeeId));
		deptEntity.setEmpPayType(new EDPLuLookUpInfoEntity(dto.getEmpPayTypeId()));
		deptEntity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		deptEntity.setDistrictId(new EDPMsDistrictEntity(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getDistrictId()));
		deptEntity.setCardexNo(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getCardexno().toString());
		deptEntity.setDdoCode(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getDdoNo());
		deptEntity.setPresentOffice(new EDPMsOfficeEntity(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeId()));
		return deptEntity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmploye dto
	 */
	@Override
	public PVUExpressEmployeeDto toDTO(PVUEmployeEntity entity) {
		PVUExpressEmployeeDto dto = new PVUExpressEmployeeDto();
		if(entity.getDateOfBirth() != null) {
			dto.setEmployeeNo(entity.getEmployeeName());
		}
		return dto;
	}

	public PVUExpressEmployeeDto toDTO(PVUEmployeEntity entity,Long payTypeId,Long desgId) {
		PVUExpressEmployeeDto dto = new PVUExpressEmployeeDto();
		dto.setEmpPayTypeId(payTypeId);
		dto.setSalutationId(entity.getSalutation()!=null?entity.getSalutation().getLookUpInfoId():null);
		dto.setEmpFirstName(Strings.isNullOrEmpty(entity.getEmployeeName())?null: entity.getEmployeeName());
		dto.setEmpMiddleName(Strings.isNullOrEmpty(entity.getEmployeeMiddleName())?null: entity.getEmployeeMiddleName());
		dto.setEmpLastName(Strings.isNullOrEmpty(entity.getEmployeeSurname())?null: entity.getEmployeeSurname());
		dto.setDesignationId(desgId);
		dto.setPanNo(Strings.isNullOrEmpty(entity.getPanNo())?null: entity.getPanNo());
		dto.setMobileNo(Strings.isNullOrEmpty(entity.getMobileNo())?null: entity.getMobileNo());
		dto.setDateOfBirth(entity.getDateOfBirth()!=null?new SimpleDateFormat(PvuUtils.DATE_FORMAT_DD_MM_YYYY1).format(entity.getDateOfBirth()):null);
		if(entity.getEmployeeCode() != null) {
			dto.setEmployeeNo(entity.getEmployeeCode().toString());
		}
		dto.setCaseNo(entity.getCaseNo());
		return dto;
	}
}

package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPTrnUpdDsgnDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnEntity;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPTrnUpdDsgnConverter.
 */
@Component
public class EDPTrnUpdDsgnConverter implements BaseConverter<EDPTrnUpdDsgnEntity,EDPTrnUpdDsgnDto>  {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP trn upd dsgn entity
	 */
	@Override
	public EDPTrnUpdDsgnEntity toEntity(EDPTrnUpdDsgnDto dto) {
		EDPTrnUpdDsgnEntity entity = new EDPTrnUpdDsgnEntity();
		BeanUtils.copyProperties(dto,entity);
		if(dto.getOfficeId()!=null)
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if(dto.getEmpId()!=null)
			entity.setEmpId(new EDPEmployeEntity(dto.getEmpId()));
		if(dto.getActivePostId()!=null)
			entity.setActivePostId(new EDPMsPostEntity(dto.getActivePostId()));
		if(dto.getDesignationId() != null)
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		if(null!=dto.getStatusId())
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));

		if(dto.isObjection()) 
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		else
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));			

		if(null != dto.getWfInRequest() && dto.getWfInRequest().equals(Boolean.TRUE))
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		else if(null != dto.getWfInRequest() && dto.getWfInRequest().equals(Boolean.FALSE))
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));			

		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP trn upd dsgn dto
	 */
	@Override
	public EDPTrnUpdDsgnDto toDTO(EDPTrnUpdDsgnEntity entity) {
		EDPTrnUpdDsgnDto dto = new EDPTrnUpdDsgnDto();
		if(null !=entity.getOfficeId())
		{
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
			dto.setOfficeName(entity.getOfficeId().getOfficeName());
			dto.setCardexNo(entity.getOfficeId().getCardexno());
			dto.setDdoNumber(entity.getOfficeId().getDdoNo());
			dto.setCardexNo(entity.getOfficeId().getCardexno());
			dto.setDdoNumber(entity.getOfficeId().getDdoNo());
			if(null != entity.getOfficeId().getDistrictId())
			{
				dto.setDistrictId(entity.getOfficeId().getDistrictId().getDistrictId());
				dto.setDistrictName(entity.getOfficeId().getDistrictId().getDistrictName());
			}
		}
		if(null !=entity.getPostId())
		{
			dto.setPostId(entity.getPostId().getPostId());
			dto.setPostName(entity.getPostId().getPostName());
		}
		if(null!=entity.getDesignationId())
		{
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
			dto.setDesignationName(entity.getDesignationId().getDesignationName());
		}
		if(null!=entity.getActivePostId())
		{
			dto.setActivePostId(entity.getActivePostId().getPostId());
			dto.setActivePostName(entity.getActivePostId().getPostName());
		}
		if(null!=entity.getEmpId())
		{
			dto.setEmpId(entity.getEmpId().getEmpId());
			dto.setEmpName(EDPUtility.getEmployeeNameFromEmployeeEntity(entity.getEmpId()));
			dto.setEmpNo(String.valueOf(entity.getEmpId().getEmployeeCode()));
		}
		if(null !=entity.getStatusId())
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		dto.setObjection(entity.getHasObjection().getLookUpInfoId() == EDPConstant.LOOKUP_INFO_YES);
		dto.setWfInRequest(entity.getWfInRequest().getLookUpInfoId() == EDPConstant.LOOKUP_INFO_YES);
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}

}

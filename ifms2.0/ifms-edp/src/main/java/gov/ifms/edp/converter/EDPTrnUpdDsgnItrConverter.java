package gov.ifms.edp.converter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPTrnUpdDsgnDto;
import gov.ifms.edp.dto.EDPTrnUpdDsgnItrDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnItrEntity;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPTrnUpdDsgnItrConverter.
 */
@Component
public class EDPTrnUpdDsgnItrConverter implements BaseConverter<EDPTrnUpdDsgnItrEntity,EDPTrnUpdDsgnItrDto>  {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP trn upd dsgn itr entity
	 */
	@Override
	public EDPTrnUpdDsgnItrEntity toEntity(EDPTrnUpdDsgnItrDto dto) {
		EDPTrnUpdDsgnItrEntity entity = new EDPTrnUpdDsgnItrEntity();
		entity.setTedpUpdDsgnId(new EDPTrnUpdDsgnEntity(dto.getTedpUpdDsgnId()));
		entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		entity.setEmpId(new EDPEmployeEntity(dto.getEmpId()));
		entity.setActivePostId(new EDPMsPostEntity(dto.getActivePostId()));
		entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		entity.setPostId(new EDPMsPostEntity(dto.getPostId()));
		entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP trn upd dsgn itr dto
	 */
	@Override
	public EDPTrnUpdDsgnItrDto toDTO(EDPTrnUpdDsgnItrEntity entity) {
		EDPTrnUpdDsgnItrDto dto = new EDPTrnUpdDsgnItrDto();
		dto.setOfficeId(entity.getOfficeId().getOfficeId());
		dto.setOfficeName(entity.getOfficeId().getOfficeName());
		dto.setDistrictName(entity.getOfficeId().getDistrictId().getDistrictName());
		dto.setCardexNo(entity.getOfficeId().getCardexno());
		dto.setDdoNumber(entity.getOfficeId().getDdoNo());
		dto.setEmpId(entity.getEmpId().getEmpId());
		dto.setEmpName(entity.getEmpId().getEmployeeName());
		dto.setEmpNo(entity.getEmpId().getEmployeeName());
		dto.setActivePostId(entity.getActivePostId().getPostId());
		dto.setActivePostName(entity.getPostId().getPostName());
		dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		dto.setStatusName(entity.getStatusId().getLookUpInfoName());
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}

	/**
	 * Edp trn upd dsgn entity to entity.
	 *
	 * @param trnEntity the trn entity
	 * @return the EDP trn upd dsgn itr entity
	 */
	public EDPTrnUpdDsgnItrEntity edpTrnUpdDsgnEntityToEntity(EDPTrnUpdDsgnEntity trnEntity,EDPTrnUpdDsgnDto dto) {
		EDPTrnUpdDsgnItrEntity entity = new EDPTrnUpdDsgnItrEntity();
		BeanUtils.copyProperties(trnEntity, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setTedpUpdDsgnId(trnEntity);
		entity.setStatusId(trnEntity.getStatusId());
		if(dto.getPostId()!=null)
			entity.setPostId(new EDPMsPostEntity(dto.getPostId()));
		if(dto.getActivePostId()!=null)
			entity.setActivePostId(new EDPMsPostEntity(dto.getActivePostId()));
		if(dto.getOfficeId()!=null)
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if(dto.getEmpId()!=null)
			entity.setEmpId(new EDPEmployeEntity(dto.getEmpId()));
		if(dto.getDesignationId()!=null)
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		if(dto.getStatusId()!=null)
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		
		if(dto.isObjection()) 
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		else
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));			
		
		if(null != dto.getWfInRequest()  && dto.getWfInRequest().equals(Boolean.TRUE)) 
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		else if(null != dto.getWfInRequest()  && dto.getWfInRequest().equals(Boolean.FALSE))
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));			

		entity.setTrnNo(trnEntity.getTrnNo());
		entity.setCreatedBy(trnEntity.getCreatedBy());
		entity.setCreatedByPost(trnEntity.getCreatedByPost());
		entity.setCreatedDate(new Date());
		entity.setUpdatedBy(trnEntity.getUpdatedBy());
		entity.setUpdatedByPost(trnEntity.getUpdatedByPost());
		entity.setUpdatedDate(new Date());
		return entity;
	}

}

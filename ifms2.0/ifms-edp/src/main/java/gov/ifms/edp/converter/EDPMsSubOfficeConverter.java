package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;

/**
 * The Class EDPMsSubOfficeConverter class.
 * 
 * @version 1.0
 * @created 2019/12/05 12:35:58
 *
 */
@Component
public class EDPMsSubOfficeConverter implements BaseConverter<EDPMsSubOfficeEntity,EDPMsSubOfficeDto> {
	
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsSubOffice entity
	 */
	@Override
	public EDPMsSubOfficeEntity toEntity(EDPMsSubOfficeDto dto) {
		EDPMsSubOfficeEntity entity = new EDPMsSubOfficeEntity();
		if(null!=dto.getOfficeId())
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if(null!=dto.getDepartmentId())
			entity.setDeptId(new EDPMsDepartmentEntity(dto.getDepartmentId()));
		if(null!=dto.getTalukaId())
			entity.setTaluka(new EDPMsTalukaEntity(dto.getTalukaId()));
		if(null!=dto.getDistrictId())
			entity.setDistrict(new EDPMsDistrictEntity(dto.getDistrictId()));
		if(null!=dto.getHodId()) {
			entity.setHodId(new EDPMsOfficeEntity(dto.getHodId()));
		}
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsSubOffice  dto
	 */
	@Override
	public EDPMsSubOfficeDto toDTO(EDPMsSubOfficeEntity entity) {
		EDPMsSubOfficeDto dto = new EDPMsSubOfficeDto();
		if(null!=entity.getOfficeId()) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
			dto.setOfficeName(entity.getOfficeId().getOfficeName());
		}
		if(null!=entity.getDeptId()) {
			dto.setDepartmentId(entity.getDeptId().getDepartmentId());
			dto.setDepartmentName(entity.getDeptId().getDepartmentName());
		}
		if(null!=entity.getTaluka()){
			dto.setTalukaId(entity.getTaluka().getTalukaId());
			dto.setTalukaName(entity.getTaluka().getTalukaName());
		}
		if(null!=entity.getDistrict()) {
			dto.setDistrictId(entity.getDistrict().getDistrictId());
			dto.setDistrictName(entity.getDistrict().getDistrictName());
		}
		if(null!=entity.getHodId()) {
			dto.setHodId(entity.getHodId().getOfficeId());
			dto.setHodName(entity.getHodId().getOfficeName());
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}

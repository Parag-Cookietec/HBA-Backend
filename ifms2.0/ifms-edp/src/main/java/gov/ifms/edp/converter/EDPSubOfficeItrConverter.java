package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.dto.EDPSubOfficeItrDto;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;

/**
 * The Class EDPSubOfficeItrConverter.
 */
@Component
public class EDPSubOfficeItrConverter implements BaseConverter<EDPSubOfficeItrEntity, EDPSubOfficeItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPsubOfficeItr entity
	 */
	@Override
	public EDPSubOfficeItrEntity toEntity(EDPSubOfficeItrDto dto) {
		EDPSubOfficeItrEntity entity = new EDPSubOfficeItrEntity();
		if (null != dto.getOfficeId())
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if (null != dto.getDepartmentId())
			entity.setDeptId(new EDPMsDepartmentEntity(dto.getDepartmentId()));
		if (null != dto.getTalukaId())
			entity.setTaluka(new EDPMsTalukaEntity(dto.getTalukaId()));
		if (null != dto.getDistrictId())
			entity.setDistrict(new EDPMsDistrictEntity(dto.getDistrictId()));
		if (null != dto.getHodId()) {
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
	 * @return the EDPsubOfficeItr dto
	 */
	@Override
	public EDPSubOfficeItrDto toDTO(EDPSubOfficeItrEntity entity) {
		EDPSubOfficeItrDto dto = new EDPSubOfficeItrDto();
		if (null != entity.getOfficeId()) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
			dto.setOfficeName(entity.getOfficeId().getOfficeName());
		}
		if (null != entity.getDeptId()) {
			dto.setDepartmentId(entity.getDeptId().getDepartmentId());
			dto.setDepartmentName(entity.getDeptId().getDepartmentName());
		}
		if (null != entity.getTaluka()) {
			dto.setTalukaId(entity.getTaluka().getTalukaId());
			dto.setTalukaName(entity.getTaluka().getTalukaName());
		}
		if (null != entity.getDistrict()) {
			dto.setDistrictId(entity.getDistrict().getDistrictId());
			dto.setDistrictName(entity.getDistrict().getDistrictName());
		}
		if (null != entity.getHodId()) {
			dto.setHodId(entity.getHodId().getOfficeId());
			dto.setHodName(entity.getHodId().getOfficeName());
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To entity.
	 *
	 * @param subOfficeEntity the sub office entity
	 * @return the EDP sub office itr entity
	 */
	public EDPSubOfficeItrEntity toEntity(EDPMsSubOfficeEntity subOfficeEntity) {
		EDPSubOfficeItrEntity entity = new EDPSubOfficeItrEntity();
		if (null != subOfficeEntity.getOfficeId())
			entity.setOfficeId(subOfficeEntity.getOfficeId());
		if (null != subOfficeEntity.getDeptId())
			entity.setDeptId(subOfficeEntity.getDeptId());
		if (null != subOfficeEntity.getTaluka())
			entity.setTaluka(subOfficeEntity.getTaluka());
		if (null != subOfficeEntity.getDistrict())
			entity.setDistrict(subOfficeEntity.getDistrict());
		if (null != subOfficeEntity.getIsUpdate())
			entity.setIsUpdate(subOfficeEntity.getIsUpdate());
		BeanUtils.copyProperties(subOfficeEntity, entity);
		return entity;
	}

	/**
	 * To DT os.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	public List<EDPMsSubOfficeDto> toDTOs(List<EDPSubOfficeItrEntity> entities) {
		return entities.stream().map(this::toSubOfficeDto).collect(Collectors.toList());
	}

	/**
	 * To sub office dto.
	 *
	 * @param entity the entity
	 * @return the EDP ms sub office dto
	 */
	public EDPMsSubOfficeDto toSubOfficeDto(EDPSubOfficeItrEntity entity) {
		EDPMsSubOfficeDto dto = new EDPMsSubOfficeDto();
		if (null != entity.getOfficeId()) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
			dto.setOfficeName(entity.getOfficeId().getOfficeName());
		}
		if (null != entity.getDeptId()) {
			dto.setDepartmentId(entity.getDeptId().getDepartmentId());
			dto.setDepartmentName(entity.getDeptId().getDepartmentName());
		}
		if (null != entity.getTaluka()) {
			dto.setTalukaId(entity.getTaluka().getTalukaId());
			dto.setTalukaName(entity.getTaluka().getTalukaName());
		}
		if (null != entity.getDistrict()) {
			dto.setDistrictId(entity.getDistrict().getDistrictId());
			dto.setDistrictName(entity.getDistrict().getDistrictName());
		}
		if (null != entity.getHodId()) {
			dto.setHodId(entity.getHodId().getOfficeId());
			dto.setHodName(entity.getHodId().getOfficeName());
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To entity.
	 *
	 * @param subOfficeItrEntity the sub office entity
	 * @return the EDP sub office itr entity
	 */
	public EDPMsSubOfficeEntity toItrEntity(EDPSubOfficeItrEntity subOfficeItrEntity) {
		EDPMsSubOfficeEntity entity = new EDPMsSubOfficeEntity();
		if (null != subOfficeItrEntity.getOfficeId())
			entity.setOfficeId(subOfficeItrEntity.getOfficeId());
		if (null != subOfficeItrEntity.getDeptId())
			entity.setDeptId(subOfficeItrEntity.getDeptId());
		if (null != subOfficeItrEntity.getTaluka())
			entity.setTaluka(subOfficeItrEntity.getTaluka());
		if (null != subOfficeItrEntity.getDistrict())
			entity.setDistrict(subOfficeItrEntity.getDistrict());
		if (null != subOfficeItrEntity.getIsUpdate())
			entity.setIsUpdate(subOfficeItrEntity.getIsUpdate());
		if (null != subOfficeItrEntity.getSubOfficeCode()) {
			entity.setSubOfficeCode(subOfficeItrEntity.getSubOfficeCode());
		}
		if (null != subOfficeItrEntity.getDeptId()) {
			entity.setDeptId(new EDPMsDepartmentEntity(subOfficeItrEntity.getDeptId().getDepartmentId()));
		}
		if(null!=subOfficeItrEntity.getOfficeTrnEntity()) {
			entity.setOfficeTrnId(subOfficeItrEntity.getOfficeTrnEntity().getUpdOffcTrnId());
		}
		BeanUtils.copyProperties(subOfficeItrEntity, entity);
		return entity;
	}
	

	/**
	 * To entity.
	 *
	 * @param subOfficeItrEntity the sub office entity
	 * @return the EDP sub office itr entity
	 */
	public EDPSubOfficeItrEntity toSubOffItrEntity(EDPMsSubOfficeEntity subOfficeItrEntity) {
		EDPSubOfficeItrEntity entity = new EDPSubOfficeItrEntity();
		if (null != subOfficeItrEntity.getOfficeId())
			entity.setOfficeId(subOfficeItrEntity.getOfficeId());
		if (null != subOfficeItrEntity.getDeptId())
			entity.setDeptId(subOfficeItrEntity.getDeptId());
		if (null != subOfficeItrEntity.getTaluka())
			entity.setTaluka(subOfficeItrEntity.getTaluka());
		if (null != subOfficeItrEntity.getDistrict())
			entity.setDistrict(subOfficeItrEntity.getDistrict());
		if (null != subOfficeItrEntity.getIsUpdate())
			entity.setIsUpdate(subOfficeItrEntity.getIsUpdate());
		if (null != subOfficeItrEntity.getSubOfficeCode()) {
			entity.setSubOfficeCode(subOfficeItrEntity.getSubOfficeCode());
		}
		if (null != subOfficeItrEntity.getDeptId()) {
			entity.setDeptId(new EDPMsDepartmentEntity(subOfficeItrEntity.getDeptId().getDepartmentId()));
		}
		BeanUtils.copyProperties(subOfficeItrEntity, entity);
		return entity;
	}
}

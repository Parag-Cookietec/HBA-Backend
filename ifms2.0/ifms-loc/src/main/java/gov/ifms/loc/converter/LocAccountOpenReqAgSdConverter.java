package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqAgSdDto;
import gov.ifms.loc.entity.LocAccountOpenReqAgSdEntity;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.entity.LocMsDetailHeadEntity;
import gov.ifms.loc.entity.LocMsMajorHeadEntity;
import gov.ifms.loc.entity.LocMsMinorHeadEntity;
import gov.ifms.loc.entity.LocMsSubHeadEntity;
import gov.ifms.loc.entity.LocMsSubMajorHeadEntity;

/**
 * The Class LocAccountOpenReqAgSdConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 21:17:12
 *
 */
@Component
public class LocAccountOpenReqAgSdConverter
		implements BaseConverter<LocAccountOpenReqAgSdEntity, LocAccountOpenReqAgSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the loc account open req ag sd entity
	 */
	@Override
	public LocAccountOpenReqAgSdEntity toEntity(LocAccountOpenReqAgSdDto dto) {
		LocAccountOpenReqAgSdEntity entity = new LocAccountOpenReqAgSdEntity();
		BeanUtils.copyProperties(dto, entity);
		setDtoToEntity(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the loc account open req ag sd dto
	 */
	@Override
	public LocAccountOpenReqAgSdDto toDTO(LocAccountOpenReqAgSdEntity entity) {
		LocAccountOpenReqAgSdDto dto = new LocAccountOpenReqAgSdDto();
		BeanUtils.copyProperties(entity, dto);
		setEntityToDto(entity,dto);
		return dto;
	}
	
	/**
	 * Sets the dto to entity.
	 *
	 * @param dto the dto
	 * @param entity the entity
	 */
	private void setDtoToEntity(LocAccountOpenReqAgSdDto dto, LocAccountOpenReqAgSdEntity entity) {
		if(null != dto.getLcOpenReqHdrId()) {
			entity.setLcOpenReqHdrId(new LocAccountOpenReqHdrEntity(dto.getLcOpenReqHdrId()));
		}
		if(null != dto.getMajorHeadId()) {
			entity.setMajorHeadId(new LocMsMajorHeadEntity(dto.getMajorHeadId()));
		}
		if(null != dto.getSubMajorHeadId()) {
			entity.setSubmajorheadId(new LocMsSubMajorHeadEntity(dto.getSubMajorHeadId()));
		}
		if(null != dto.getSubHeadId()) {
			entity.setSubheadId(new LocMsSubHeadEntity(dto.getSubHeadId()));
		}
		if(null != dto.getDetailHeadId()) {
			entity.setDetailheadId(new LocMsDetailHeadEntity(dto.getDetailHeadId()));
		}
		if(null != dto.getMinorHeadId()) {
			entity.setMinorheadId(new LocMsMinorHeadEntity(dto.getMinorHeadId()));
		}
	}
	
	/**
	 * Sets the entity to dto.
	 *
	 * @param entity the entity
	 * @param dto the dto
	 */
	private void setEntityToDto(LocAccountOpenReqAgSdEntity  entity,LocAccountOpenReqAgSdDto dto) {
		if(null != entity.getLcOpenReqHdrId()) {
			dto.setLcOpenReqHdrId(entity.getLcOpenReqHdrId().getLcOpenReqHdrId());
		}
		if(null != entity.getMajorHeadId()) {
			dto.setMajorHeadId(entity.getMajorHeadId().getMajorHeadId());
		}
		if(null != entity.getSubmajorheadId()) {
			dto.setSubMajorHeadId(entity.getSubmajorheadId().getSubMajorHeadId());
		}
		if(null != entity.getSubheadId()) {
			dto.setSubHeadId(entity.getSubheadId().getSubHeadId());
		}
		if(null != entity.getDetailheadId()) {
			dto.setDetailHeadId(entity.getDetailheadId().getDetailHeadId());
		}
		if(null != entity.getMinorheadId()) {
			dto.setMinorHeadId(entity.getMinorheadId().getMinorHeadId());
		}
	}

}

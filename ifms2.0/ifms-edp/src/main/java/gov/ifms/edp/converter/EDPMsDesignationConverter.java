package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsDesignationConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 18:35:30
 *
 */
@Component
public class EDPMsDesignationConverter implements BaseConverter<EDPMsDesignationEntity, EDPMsDesignationDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsDesignation entity
	 */
	@Override
	public EDPMsDesignationEntity toEntity(EDPMsDesignationDto dto) {
		EDPMsDesignationEntity entity = new EDPMsDesignationEntity();
		entity.setDesignationId(dto.getDesignationId());
		entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if (null != dto.getStatusId())
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		if (dto.isWfInRequest()) {
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		} else {
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
		}
		if (null != dto.getHasObjection() && dto.getHasObjection()) {
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
			entity.setObjectionRemarks(dto.getObjectionRemarks());
		} else if (null != dto.getHasObjection()) {
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
			entity.setObjectionRemarks(null);
		}else {
			entity.setObjectionRemarks(null);
			
		}
		if (null != dto.getInitiatedBy())
			entity.setInitiatedBy(new EDPLkPoOffUserEntity(dto.getInitiatedBy()));
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsDesignation dto
	 */
	@Override
	public EDPMsDesignationDto toDTO(EDPMsDesignationEntity entity) {
		EDPMsDesignationDto dto = new EDPMsDesignationDto();
		BeanUtils.copyProperties(entity, dto);
		if (null != entity.getOfficeId()) {
			EDPMsOfficeEntity officeDto = entity.getOfficeId();
			if (null != officeDto.getDistrictId()) {
				dto.setDistrictName(officeDto.getDistrictId().getDistrictName());
				dto.setDistrictId(officeDto.getDistrictId().getDistrictId());
			}
			dto.setDdoNumber(officeDto.getDdoNo());
			dto.setCardexNo(officeDto.getCardexno());
			dto.setOfficeName(officeDto.getOfficeName());
			dto.setOfficeId(officeDto.getOfficeId());
		}
		if (null != entity.getStatusId())
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		dto.setHasObjection(null != entity.getHasObjection() && entity.getHasObjection()
				.getLookUpInfoId() == new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES).getLookUpInfoId()?Boolean.TRUE:Boolean.FALSE);
		if (null != entity.getInitiatedBy())
			dto.setInitiatedBy(entity.getInitiatedBy().getLkPoOffUserId());
		dto.setWfInRequest(null != entity.getWfInRequest() && entity.getWfInRequest()
				.getLookUpInfoId() == new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES).getLookUpInfoId()?Boolean.TRUE:Boolean.FALSE);
		dto.setTrnDate(entity.getCreatedDate());
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsDesignationEntity> list) {
		return list.stream().map(entityInList -> {
			ClueDto dto = new ClueDto();
			dto.setId(entityInList.getDesignationId());
			dto.setName(entityInList.getDesignationName());
			return dto;
		}).collect(Collectors.toList());
	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDto(List<EDPMsDesignationEntity> list) {
		return list
				.stream().map(entityInList -> new EDPSDTDto(entityInList.getDesignationId(),
						entityInList.getDesignationName(), entityInList.getDesignationCode()))
				.collect(Collectors.toList());
	}

}

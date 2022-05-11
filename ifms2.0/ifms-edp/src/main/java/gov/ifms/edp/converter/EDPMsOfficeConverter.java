package gov.ifms.edp.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsOfficeConverter class.
 *
 * @version 1.0
 * @created 2019/08/29 17:31:41
 */
@Component
public class EDPMsOfficeConverter implements BaseConverter<EDPMsOfficeEntity, EDPMsOfficeDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsOffice entity
	 */
	@Override
	public EDPMsOfficeEntity toEntity(EDPMsOfficeDto dto) {
		EDPMsOfficeEntity entity = new EDPMsOfficeEntity();
		if (null != dto.getDepartmentId()) {
			entity.setDepartmentId(new EDPMsDepartmentEntity(dto.getDepartmentId()));
		}
		if (null != dto.getOfficeTypeId()) {
			entity.setOfficeTypeId(new EDPLuLookUpInfoEntity(dto.getOfficeTypeId()));
		}
		if (null != dto.getDistrictId()) {
			entity.setDistrictId(new EDPMsDistrictEntity(dto.getDistrictId()));
		}
		if (null != dto.getTalukaId()) {
			entity.setTalukaId(new EDPMsTalukaEntity(dto.getTalukaId()));
		}
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		BeanUtils.copyProperties(dto, entity);

		if (null != dto.getTreasuryType() && dto.getTreasuryType() != 0) {
			setTreasuryOff(dto, entity);
		} else {
			entity.setIsSubTreasury(EDPConstant.LOOKUP_INFO_NO_SHORT);
			entity.setIsTreasury(EDPConstant.LOOKUP_INFO_NO_SHORT);
		}

		return entity;
	}

	/**
	 * sets to pao offices column values
	 * 
	 * @param dto
	 * @param entity
	 */
	private void setTreasuryOff(EDPMsOfficeDto dto, EDPMsOfficeEntity entity) {
		if (EDPConstant.EDP_TREASURY_TYPE.equals(dto.getTreasuryType())) {
			entity.setIsTreasury(EDPConstant.LOOKUP_INFO_YES_SHORT);
			entity.setOfficeSubType(EDPConstant.EDP_OFF_SUB_TYPE_TO);
			entity.setIsSubTreasury(EDPConstant.LOOKUP_INFO_NO_SHORT);
		} else if (EDPConstant.EDP_SUB_TREASURY_TYPE.equals(dto.getTreasuryType())) {
			entity.setIsSubTreasury(EDPConstant.LOOKUP_INFO_YES_SHORT);
			entity.setOfficeSubType(EDPConstant.EDP_OFF_SUB_TYPE_STO);
			entity.setIsTreasury(EDPConstant.LOOKUP_INFO_NO_SHORT);
		} else if (EDPConstant.EDP_PAO_TYPE.equals(dto.getTreasuryType())) {
			entity.setOfficeSubType(EDPConstant.EDP_OFF_SUB_TYPE_PAO);
			entity.setIsSubTreasury(EDPConstant.LOOKUP_INFO_NO_SHORT);
			entity.setIsTreasury(EDPConstant.LOOKUP_INFO_NO_SHORT);
		} else if (EDPConstant.EDP_PENSION_AND_PAY_TYPE.equals(dto.getTreasuryType())) {
			entity.setOfficeSubType(EDPConstant.EDP_OFF_SUB_TYPE_PENSION_PAY);
			entity.setIsSubTreasury(EDPConstant.LOOKUP_INFO_NO_SHORT);
			entity.setIsTreasury(EDPConstant.LOOKUP_INFO_NO_SHORT);
		}
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsOffice dto
	 */
	@Override
	public EDPMsOfficeDto toDTO(EDPMsOfficeEntity entity) {
		EDPMsOfficeDto dto = new EDPMsOfficeDto();
		if (null != entity.getDistrictId()) {
			dto.setDistrictId(entity.getDistrictId().getDistrictId());
			dto.setDistrictName(entity.getDistrictId().getDistrictName());
			dto.setDistName(entity.getDistrictId().getDistrictName());
		}
		if (null != entity.getDepartmentId()) {
			dto.setDepartmentId(entity.getDepartmentId().getDepartmentId());
			dto.setDeptName(entity.getDepartmentId().getDepartmentName());
		}
		if (null != entity.getOfficeTypeId()) {
			dto.setOfficeTypeId(entity.getOfficeTypeId().getLookUpInfoId());
			dto.setOfficeTypeName(entity.getOfficeTypeId().getLookUpInfoName());
		}
		if (null != entity.getTalukaId()) {
			dto.setTalukaId(entity.getTalukaId().getTalukaId());
			dto.setTalukaName(entity.getTalukaId().getTalukaName());
		}

		if (entity.getOfficeTrnEntity() != null) {
			dto.setTrnId(entity.getOfficeTrnEntity().getUpdOffcTrnId());
		}

		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsOfficeEntity> list) {
		return list.stream().map(entityInList -> {
			EDPMsOfficeDto officeDto = toDTO(entityInList);
			return toClueDTO(officeDto);
		}).collect(Collectors.toList());
	}

	/**
	 * To clue DTO.
	 *
	 * @param entity the entity
	 * @return the clue dto
	 */
	public ClueDto toClueDTO(EDPMsOfficeDto entity) {
		ClueDto dto = new ClueDto();
		dto.setId(entity.getOfficeId());
		dto.setName(entity.getOfficeName());
		return dto;
	}

	public Map<Long, List<Map<Long, List<String>>>> toEDPSDTDto(List<EDPMsOfficeEntity> list) {
		Map<Long, List<EDPMsOfficeEntity>> byCardex = list.stream()
				.collect(Collectors.groupingBy(EDPMsOfficeEntity::getCardexno));
		return list.stream().collect(Collectors.groupingBy(e -> e.getDistrictId().getDistrictId(),
				Collectors.mapping(a -> convert(a, convertIn(byCardex.get(a.getCardexno()))), Collectors.toList())));

	}

	private List<String> convertIn(List<EDPMsOfficeEntity> edpMsOfficeEntities) {
		return edpMsOfficeEntities.stream().map(EDPMsOfficeEntity::getDdoNo).collect(Collectors.toList());
	}

	private Map<Long, List<String>> convert(EDPMsOfficeEntity office, List<String> edpMsOfficeEntities) {
		Map<Long, List<String>> response = new HashMap<>();
		response.put(office.getCardexno(), edpMsOfficeEntities);
		return response;
	}

	/**
	 * To EDPSDT dtos.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDtos(List<EDPMsOfficeEntity> list) {
		return list.stream().filter(ent -> Objects.nonNull(ent.getDepartmentId()))
				.map(entityInList -> new EDPSDTDto(entityInList.getOfficeId(), entityInList.getOfficeName(),
						entityInList.getOfficeCode(), entityInList.getDepartmentId().getDepartmentId()))
				.collect(Collectors.toList());
	}

	public List<EDPMsOfficeDto> toOfficeIdAndOfficeName(List<EDPMsOfficeEntity> list) {
		return list.stream().map(office -> new EDPMsOfficeDto(office.getOfficeId(), office.getOfficeName()))
				.collect(Collectors.toList());
	}

	public List<ClueDto> toDdoCardexAndStatus(List<EDPMsOfficeEntity> list) {
		return list.stream().map(entity -> {
			ClueDto dto = new ClueDto();
			dto.setId(entity.getOfficeId());
			dto.setName(entity.getOfficeName());
			dto.setDdoNo(entity.getDdoNo());
			dto.setCardexNo(entity.getCardexno());
			return dto;
		}).collect(Collectors.toList());
	}

}

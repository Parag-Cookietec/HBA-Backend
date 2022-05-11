package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsBranchDto;
import gov.ifms.edp.dto.EDPTedpBrHdrDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class EDPMsBranchConverter.
 */
@Component
public class EDPMsBranchConverter implements BaseConverter<EDPMsBranchEntity, EDPMsBranchDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP ms branch entity
	 */
	@Override
	public EDPMsBranchEntity toEntity(EDPMsBranchDto dto) {
		EDPMsBranchEntity entity = new EDPMsBranchEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getOfficeId())
			entity.setEdpMsOffice(new EDPMsOfficeEntity(dto.getOfficeId()));
		if(null != dto.getBranchTypeId())
			entity.setBranchTypeId(new EDPLuLookUpInfoEntity(dto.getBranchTypeId()));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP ms branch dto
	 */
	@Override
	public EDPMsBranchDto toDTO(EDPMsBranchEntity entity) {
		EDPMsBranchDto dto = new EDPMsBranchDto();
		if (null != entity.getBranchTypeId()) {
			dto.setBranchTypeId(entity.getBranchTypeId().getLookUpInfoId());
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param branchlist the branchlist
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsBranchEntity> branchlist) {
		return branchlist.stream().map(this::toClueDTO).collect(Collectors.toList());
	}

	/**
	 * To clue DTO.
	 *
	 * @param branch the branch
	 * @return the clue dto
	 */
	public ClueDto toClueDTO(EDPMsBranchEntity branch) {
		ClueDto dto = new ClueDto();
		dto.setId(branch.getBranchId());
		dto.setName(branch.getBranchName());
		if(null != branch.getBranchCode())
			dto.setCode(branch.getBranchCode());
		if(null != branch.getBranchCodeName())
			dto.setCodeName(branch.getBranchCodeName());
		if(null != branch.getParentBranchId())
			dto.setParentId(branch.getParentBranchId());
		return dto;
	}
	
	/**
	 * Hdr dto to branch entity.
	 * @param hdrDto 
	 *
	 * @return the EDP ms branch entity
	 */
	public EDPMsBranchEntity hdrDtoToBranchEntity(EDPTedpBrHdrDto hdrDto) {
		EDPMsBranchEntity branchEntity = new EDPMsBranchEntity();
		branchEntity.setBranchName(hdrDto.getBranchName());
		branchEntity.setBranchTypeId(new EDPLuLookUpInfoEntity(hdrDto.getBranchType()));
		branchEntity.setEdpMsOffice(new EDPMsOfficeEntity(hdrDto.getOfficeId()));
		return branchEntity;
	}
}

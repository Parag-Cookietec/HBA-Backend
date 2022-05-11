package gov.ifms.edp.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPPostItrEntity;
import gov.ifms.edp.repository.EDPMsPostRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.NaturalOrderComparator;

/**
 * The Class EDPMsPostConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 17:22:45
 *
 */
@Component
public class EDPMsPostConverter implements BaseConverter<EDPMsPostEntity, EDPMsPostDto> {

	/** The edp ms post repository. */
	@Autowired
	private EDPMsPostRepository edpMsPostRepository;

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsPost entity
	 */
	@Override
	public EDPMsPostEntity toEntity(EDPMsPostDto dto) {
		EDPMsPostEntity entity = new EDPMsPostEntity();
		BeanUtils.copyProperties(dto, entity);
		if (null != dto.getDesignationId()) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}
		if (null != dto.getStatusId()) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.isHasObjection()) {
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		} else if (!dto.isHasObjection()) {
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
		}
		if (null != dto.getInitiatedBy()) {
			entity.setInitiatedBy(new EDPLkPoOffUserEntity(dto.getInitiatedBy()));
		}
		if(null!=dto.getWfInRequest() && dto.getWfInRequest().equals(Boolean.TRUE))
		{
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(2l));
		}
		else
		{
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(1l));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsPost dto
	 */
	@Override
	public EDPMsPostDto toDTO(EDPMsPostEntity entity) {
		EDPMsPostDto dto = new EDPMsPostDto();
		BeanUtils.copyProperties(entity, dto);
		if (null != entity.getDesignationId()) 
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		
		dto.setWfInRequest(null!=entity.getWfInRequest() && entity.getWfInRequest().getLookUpInfoId()==EDPConstant.LOOKUP_INFO_YES?Boolean.TRUE:Boolean.FALSE);
		
		if (null != entity.getInitiatedBy())
			dto.setInitiatedBy(entity.getInitiatedBy().getLkPoOffUserId());
		if (null != entity.getHasObjection()
				&& entity.getHasObjection().getLookUpInfoId() == EDPConstant.LOOKUP_INFO_YES)
			dto.setHasObjection(true);
		else if (null != entity.getHasObjection())
			dto.setHasObjection(false);
		dto.setTrnDate(entity.getCreatedDate());
		return dto;
	}

	/**
	 * Id to EDP ms post entity.
	 *
	 * @param id the id
	 * @return the EDP ms post entity
	 */
	public EDPMsPostEntity idToEDPMsPostEntity(long id) {
		Optional<EDPMsPostEntity> entity = this.edpMsPostRepository.findById(id);
		if (entity.isPresent())
			return entity.get();
		else
			throw new EntityNotFoundException("bpn id Should not be null");

	}

	/**
	 * Entity list to dto list.
	 *
	 * @param dtoList the dto list
	 * @return the list
	 */
	public List<EDPMsPostDto> entityListToDtoList(List<EDPMsPostEntity> dtoList) {
		return dtoList.stream().map(this::toDTO).collect(Collectors.toList());
	}

	/**
	 * Dto list to entity list.
	 *
	 * @param entityList the entity list
	 * @return the list
	 */
	public List<EDPMsPostEntity> dtoListToEntityList(List<EDPMsPostDto> entityList) {
		return entityList.stream().map(this::toEntity).collect(Collectors.toList());
	}

	/**
	 * To clue DTO.
	 *
	 * @param obj the obj
	 * @return the clue dto
	 */
	public ClueDto objectToClueDTO(Object[] obj) {
		ClueDto dto = new ClueDto();
		if (null != obj[1]) {
			dto.setId(Long.parseLong(obj[1].toString()));
		}
		if (null != obj[2]) {
			dto.setName(obj[2].toString());
		}
		if (null != obj[5]) {
			dto.setUserName(obj[5].toString());
		} else {
			dto.setUserName(EDPConstant.NOT_MAP_USER);
		}
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param entity the entity
	 * @return the clue dto
	 */
	public ClueDto toClueDTO(EDPMsPostEntity entity) {
		ClueDto dto = new ClueDto();
		dto.setId(entity.getPostId());
		dto.setName(entity.getPostName());
		dto.setCode(entity.getPostCode());
		dto.setCodeName(entity.getPostCodeName());
		if (null != entity.getDesignationId())
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsPostEntity> list) {
		return list.stream().map(this::toClueDTO).sorted(new NaturalOrderComparator(Boolean.TRUE))
				.collect(Collectors.toList());
	}

	/**
	 * To clue DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<ClueDto> objectToClueDTO(List<Object[]> list) {
		return list.stream().map(this::objectToClueDTO).sorted(new NaturalOrderComparator(Boolean.TRUE))
				.collect(Collectors.toList());
	}

	/**
	 * To itr entity.
	 *
	 * @param dto the dto
	 * @return the EDP post itr entity
	 */
	public EDPPostItrEntity toItrEntity(EDPMsPostDto dto) {
		EDPPostItrEntity entity = new EDPPostItrEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setPostId(dto.getPostId());
		if (null != dto.getDesignationId()) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}
		if (null != dto.getStatusId()) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (null != dto.getOfficeId()) {
			entity.setOfficeId(dto.getOfficeId());
		}
		return entity;
	}

	/**
	 * To designation clue DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<ClueDto> toDesignationClueDTO(List<EDPMsDesignationEntity> list) {
		return list.stream().map(this::toClueDTO).collect(Collectors.toList());
	}

	/**
	 * To clue DTO.
	 *
	 * @param entity the entity
	 * @return the clue dto
	 */
	public ClueDto toClueDTO(EDPMsDesignationEntity entity) {
		ClueDto dto = new ClueDto();
		dto.setId(entity.getDesignationId());
		dto.setName(entity.getDesignationName());
		return dto;
	}
}

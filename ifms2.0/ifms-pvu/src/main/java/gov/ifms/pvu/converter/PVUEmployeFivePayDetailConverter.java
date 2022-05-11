package gov.ifms.pvu.converter;

import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUEmployeFivePayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeFivePayDetailEntity;

/**
 * The Class PVUEmployeFivePayDetailConverter class.
 *
 * @version v 1.0
 * @created 2019/12/10 18:06:31
 *
 */
@Component
public class PVUEmployeFivePayDetailConverter implements BaseConverter<PVUEmployeFivePayDetailEntity,PVUEmployeFivePayDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeFivePayDetailEntity entity
	 */
	@Override
	public PVUEmployeFivePayDetailEntity toEntity(PVUEmployeFivePayDetailDto dto) {
		if(dto == null){
			return null;
		}
		PVUEmployeFivePayDetailEntity entity = new PVUEmployeFivePayDetailEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId()!=0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getPayScale()!=0) {
			entity.setPayScale(new PVUMsPayScaleEntity(dto.getPayScale()));
		}
		if(dto.getStatusId()!=0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeFivePayDetailEntity  dto
	 */
	@Override
	public PVUEmployeFivePayDetailDto toDTO(PVUEmployeFivePayDetailEntity entity) {
		if(entity == null){
			return null;
		}
		PVUEmployeFivePayDetailDto dto = new PVUEmployeFivePayDetailDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity()!=null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getPayScale()!=null) {
			dto.setPayScale(entity.getPayScale().getPayScaleId());
			dto.setPayScaleName(entity.getPayScale().getPayScaleDispVal());
		}
		if(entity.getStatusId()!=null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}

		return dto;
	}

}

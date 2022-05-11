package gov.ifms.pvu.converter;

import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUEmployeFourthPayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeFourthPayDetailEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class PVUEmployeFourthPayDetailConverter class.
 *
 * @version v 1.0
 * @created 2019/12/10 18:00:08
 *
 */
@Component
public class PVUEmployeFourthPayDetailConverter implements BaseConverter<PVUEmployeFourthPayDetailEntity,PVUEmployeFourthPayDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeFourthPayDetailEntity entity
	 */
	@Override
	public PVUEmployeFourthPayDetailEntity toEntity(PVUEmployeFourthPayDetailDto dto) {
		if(dto == null){
			return null;
		}
		PVUEmployeFourthPayDetailEntity entity = new PVUEmployeFourthPayDetailEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId()!=0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getStatusId()!=0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if(dto.getPayScale()!=0) {
			entity.setPayScale(new PVUMsPayScaleEntity(dto.getPayScale()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeFourthPayDetailEntity  dto
	 */
	@Override
	public PVUEmployeFourthPayDetailDto toDTO(PVUEmployeFourthPayDetailEntity entity) {
		if(entity == null){
			return null;
		}
		PVUEmployeFourthPayDetailDto dto = new PVUEmployeFourthPayDetailDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity()!=null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getStatusId()!=null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if(entity.getPayScale()!=null) {
			dto.setPayScale(entity.getPayScale().getPayScaleId());
			dto.setPayScaleName(entity.getPayScale().getPayScaleDispVal());
		}
		return dto;
	}

}

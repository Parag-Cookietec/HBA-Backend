package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUEmployeSevenPayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeSevenPayDetailEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class PVUEmployeSevenPayDetailConverter class.
 *
 * @version v 1.0
 * @created 2019/11/26 14:21:09
 *
 */
@Component
public class PVUEmployeSevenPayDetailConverter
		implements BaseConverter<PVUEmployeSevenPayDetailEntity, PVUEmployeSevenPayDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmploye7PayDetail entity
	 */
	@Override
	public PVUEmployeSevenPayDetailEntity toEntity(PVUEmployeSevenPayDetailDto dto) {
		if(dto == null){
			return null;
		}

		PVUEmployeSevenPayDetailEntity entity = new PVUEmployeSevenPayDetailEntity();
		BeanUtils.copyProperties(dto, entity);
       if(dto.getEmpId()!=0) {
		   entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
	   }
       if(dto.getPayLevel()!=0) {
		   entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevel()));
	   }
       if(dto.getCellId()!=0) {
		   entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
	   }
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmploye7PayDetail dto
	 */
	@Override
	public PVUEmployeSevenPayDetailDto toDTO(PVUEmployeSevenPayDetailEntity entity) {
		if(entity == null){
			return null;
		}

		PVUEmployeSevenPayDetailDto dto = new PVUEmployeSevenPayDetailDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity()!=null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getPayLevel()!=null) {
			dto.setPayLevel(entity.getPayLevel().getId());
			dto.setPayLevelName(entity.getPayLevel().getPayLevelValue());
		}
		if(entity.getCellId()!= null) {
			dto.setCellId(entity.getCellId().getId());
			dto.setCellValue(entity.getCellId().getCellValue());
		}
		
		return dto;
	}

}

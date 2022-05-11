package gov.ifms.edp.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.edp.dto.EDPMsFinancialYearDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

/**
 * The Class EDPMsFinancialYearConverter.
 */
@Component
public class EDPMsFinancialYearConverter  implements BaseConverter<EDPMsFinancialYearEntity, EDPMsFinancialYearDto>{

	
	/** The edp ms financial year repository. */
	@Autowired
	private EDPMsFinancialYearRepository edpMsFinancialYearRepository;
	
	
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP ms financial year entity
	 */
	@Override
	public EDPMsFinancialYearEntity toEntity(EDPMsFinancialYearDto dto) {
		EDPMsFinancialYearEntity entity = new EDPMsFinancialYearEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP ms financial year dto
	 */
	@Override
	public EDPMsFinancialYearDto toDTO(EDPMsFinancialYearEntity entity) {
		EDPMsFinancialYearDto dto = new EDPMsFinancialYearDto();
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}
	
	/**
	 * Convert to dtos.
	 *
	 * @param enties the enties
	 * @return the list
	 */
	public List<EDPMsFinancialYearDto> convertToDtos(List<EDPMsFinancialYearEntity> enties){
		return enties.stream().map(entity -> {
			EDPMsFinancialYearDto dto = toDTO(entity);
			if(null != entity.getIsCurrentYear())
				dto.setIsCurrentYear(entity.getIsCurrentYear().getLookUpInfoValue());
			return dto;
		}).collect(Collectors.toList());
	}
	
	/**
	 * Id to ms financial year entity.
	 *
	 * @param id the id
	 * @return the EDP ms financial year entity
	 */
	public EDPMsFinancialYearEntity idToMsFinancialYearEntity(long id) {
		Optional<EDPMsFinancialYearEntity> entity = this.edpMsFinancialYearRepository.findById(id);
		if (entity.isPresent())
			return entity.get();
		else
			throw new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND);

	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDto(List<EDPMsFinancialYearEntity> list) {
		
		return list.stream().map(entityInList -> new EDPSDTDto(entityInList.getFinancialYearId(), String.valueOf(entityInList.getFyStart()),entityInList.getFyShort())).collect(Collectors.toList());
	}

}

package gov.ifms.pvu.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.dto.PVURevisionOfPayEmployeeDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVURevisionOfPayEmployeeEntity;

/**
 * The Class PVURevisionOfPayEmployeeConverter class.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
@Component
public class PVURevisionOfPayEmployeeConverter implements BaseConverter<PVURevisionOfPayEmployeeEntity, PVURevisionOfPayEmployeeDto> {

	 /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(PVURevisionOfPayEmployeeConverter.class.getName());

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the PVURevisionOfPayEmployee entity
     */
    @Override
	public PVURevisionOfPayEmployeeEntity toEntity(PVURevisionOfPayEmployeeDto dto) {
		PVURevisionOfPayEmployeeEntity entity = new PVURevisionOfPayEmployeeEntity();
		try {
			BeanUtils.copyProperties(dto, entity);
			if (dto.getStatusId() != 0) {
				entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
			}
			if (dto.getPayCommFor() != 0) {
				entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommFor()));
			}
			if (dto.getEmployeeId() != 0) {
				entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));
			}
			if (dto.getSevenPayLevel() != 0) {
				entity.setRevPayLevel(new PVUMsPayLevelEntity(dto.getSevenPayLevel()));
			}
			if (dto.getSevenPayCellId() != 0) {
				entity.setRevCell(new PVUMsPayCellEntity(dto.getSevenPayCellId()));
			}
			if (dto.getSixPayBand() != 0) {
				entity.setRevPayBand(new PVUMsPayBandEntity(dto.getSixPayBand()));
			}
			if (dto.getSixGradePay() != 0) {
				entity.setRevGradePay(new PVUMsGradePayEntity(dto.getSixGradePay()));
			}
			if (dto.getReasonForExcludeId() != 0) {
				entity.setReasonForExclude(new EDPLuLookUpInfoEntity(dto.getReasonForExcludeId()));
			}
		} catch (Exception ex) {
			LOG.error(ex.toString());
		}

		return entity;
	}

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the PVURevisionOfPayEmployee  dto
     */
    @Override
    public PVURevisionOfPayEmployeeDto toDTO(PVURevisionOfPayEmployeeEntity entity) {
        PVURevisionOfPayEmployeeDto dto = new PVURevisionOfPayEmployeeDto();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getStatus() != null) {
            dto.setStatusId(entity.getStatus().getLookUpInfoId());
        }
        if (entity.getPayComm() != null) {
            dto.setPayCommFor(entity.getPayComm().getLookUpInfoId());
        }
        if (entity.getEmployee() != null) {
            dto.setEmployeeId(entity.getEmployee().getEmpId());
        }
        if (entity.getRevPayLevel() != null) {
            dto.setSevenPayLevel(entity.getRevPayLevel().getId());
        }
        if (entity.getRevCell() != null) {
            dto.setSevenPayCellId(entity.getRevCell().getId());
        }
        if (entity.getRevPayBand() != null) {
            dto.setSixPayBand(entity.getRevPayBand().getId());
        }
        if (entity.getRevGradePay() != null) {
            dto.setSixGradePay(entity.getRevGradePay().getId());
        }
        if (entity.getReasonForExclude() != null) {
            dto.setReasonForExcludeId(entity.getReasonForExclude().getLookUpInfoId());
        }
        if (entity.getRevisionOfPay() != null) {
            dto.setRevisionOfPayId(entity.getRevisionOfPay().getId());
        }
        return dto;
    }

}

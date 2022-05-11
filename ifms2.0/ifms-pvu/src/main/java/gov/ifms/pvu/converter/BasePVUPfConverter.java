package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.common.PVUCurrentDto;
import gov.ifms.pvu.common.PVUCurrentEntity;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.util.PvuUtils;

public abstract class BasePVUPfConverter<E extends PVUCurrentEntity, D extends PVUCurrentDto> implements BaseConverter<E, D> {

    abstract E createEntity();

    abstract D createDTO();

    E toCurrentDetailsEntity(D dto) {
        E entity = createEntity();
        return toCurrentEntity(entity, dto);
    }

    D toCurrentDetailsDTO(E entity) {
        D dto = createDTO();
        return toCurrentDTO(entity, dto);
    }

    private E toCurrentEntity(E entity, D dto) {
        entity.setcBasicPay(dto.getcBasicPay());
        if (Utils.isNonEmpty(dto.getcCellId())) {
            entity.setcCell(new PVUMsPayCellEntity(dto.getcCellId()));
        }
        if (Utils.isNonEmpty(dto.getcClassId())) {
            entity.setcClass(new EDPLuLookUpInfoEntity(dto.getcClassId()));
        }

        if (Utils.isNonEmpty(dto.getcDesignationId())) {
            entity.setcDesignation(new EDPMsDesignationEntity(dto.getcDesignationId()));
        }

        entity.setcDateOfNextIncrement(dto.getcDateOfNextIncrement());
        entity.setcDateOfJoining(dto.getcDateOfJoining());
        entity.setcDateOfRetirement(dto.getcDateOfRetirement());
        if (Utils.isNonEmpty(dto.getcGradePayId()) && dto.getcGradePayId() >0) {
            entity.setcGradePay(new PVUMsGradePayEntity(dto.getcGradePayId()));
        }
        if (Utils.isNonEmpty(dto.getcPayBandId()) &&  dto.getcPayBandId() > 0) {
            entity.setcPayBand(new PVUMsPayBandEntity(dto.getcPayBandId()));
        }
        if (Utils.isNonEmpty(dto.getcPayLevelId()) && dto.getcPayLevelId() > 0) {

            entity.setcPayLevel(new PVUMsPayLevelEntity(dto.getcPayLevelId()));
        }
        if (Utils.isNonEmpty(dto.getcPayScaleId()) && dto.getcPayScaleId() > 0 ) {
            entity.setcPayScale(new PVUMsPayScaleEntity(dto.getcPayScaleId()));
        }
        if (Utils.isNonEmpty(dto.getcOfficeId()) && dto.getcOfficeId() > 0) {
            entity.setcOfficeId(new EDPMsOfficeEntity(dto.getcOfficeId()));
        }
        entity.setcPayBandValue(dto.getcPayBandValue());
        entity.setCurrentDetailsEventId(dto.getCurrentDetailsEventId());

        return entity;
    }

	private D toCurrentDTO(E entity, D dto) {
		dto.setcBasicPay(entity.getcBasicPay());
		dto.setcDateOfNextIncrement(entity.getcDateOfNextIncrement());
		dto.setcDateOfJoining(entity.getcDateOfJoining());
		dto.setcDateOfRetirement(entity.getcDateOfRetirement());
		dto.setcPayBandValue(entity.getcPayBandValue());
		dto.setCurrentDetailsEventId(entity.getCurrentDetailsEventId());
		dto.setcEmployeeName(PvuUtils.concatName(
				entity.getEmployee().getSalutation() != null ? entity.getEmployee().getSalutation().getLookUpInfoName()
						: "",
				entity.getEmployee().getEmployeeName(), entity.getEmployee().getEmployeeMiddleName(),
				entity.getEmployee().getEmployeeSurname()));
		if (Utils.isNonEmpty(entity.getcCell())) {
			dto.setcCellId(entity.getcCell().getId());
			if (Utils.isNonEmpty(entity.getcCell().getCellId())) {
				dto.setcCellName(entity.getcCell().getCellId());
			}
		}

		if (Utils.isNonEmpty(entity.getcClass())) {
			dto.setcClassId(entity.getcClass().getLookUpInfoId());
			if (Utils.isNonEmpty(entity.getcClass().getLookUpInfoName())) {
				dto.setcClassName(entity.getcClass().getLookUpInfoName());
			}
		}
		if (Utils.isNonEmpty(entity.getcDesignation())) {
			dto.setcDesignationId(entity.getcDesignation().getDesignationId());
			if (Utils.isNonEmpty(entity.getcDesignation().getDesignationName())) {
				dto.setcDesignationName(entity.getcDesignation().getDesignationName());
			}
		}

		return toCurrentDTOs(entity, dto);

	}

	private D toCurrentDTOs(E entity, D dto) {
		if (Utils.isNonEmpty(entity.getcGradePay())) {
			dto.setcGradePayId(entity.getcGradePay().getId());
			if (Utils.isNonEmpty(entity.getcGradePay().getGradePayValue())) {
				dto.setcGradePayName(entity.getcGradePay().getGradePayValue());
			}
		}

		if (Utils.isNonEmpty(entity.getcPayBand())) {
			dto.setcPayBandId(entity.getcPayBand().getId());
			if (Utils.isNonEmpty(entity.getcPayBand().getPayBandDispVal())) {
				dto.setcPayBandName(entity.getcPayBand().getPayBandDispVal());
			}
		}

		if (Utils.isNonEmpty(entity.getcPayLevel())) {
			dto.setcPayLevelId(entity.getcPayLevel().getId());
			if (Utils.isNonEmpty(entity.getcPayLevel().getId())) {
				dto.setcPayLevelName(entity.getcPayLevel().getPayLevelValue());
			}
		}

		if (Utils.isNonEmpty(entity.getcPayScale())) {
			dto.setcPayScaleId(entity.getcPayScale().getPayScaleId());
			if (Utils.isNonEmpty(entity.getcPayScale().getPayScaleDispVal())) {
				dto.setcPayScaleName(entity.getcPayScale().getPayScaleDispVal());
			}
		}

		if (Utils.isNonEmpty(entity.getcOfficeId())) {
			dto.setcOfficeId(entity.getcOfficeId().getOfficeId());
			if (Utils.isNonEmpty(entity.getcOfficeId().getOfficeId())) {
				dto.setcOfficeName(entity.getcOfficeId().getOfficeName());
			}
		}
		return dto;
	}


}

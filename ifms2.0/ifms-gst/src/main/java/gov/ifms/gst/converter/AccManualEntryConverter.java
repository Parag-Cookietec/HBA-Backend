package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.dto.ManualEntryDto;
import gov.ifms.gst.entity.AccManualEntryHdr;
import gov.ifms.gst.util.GSTConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class AccManualEntryConverter.
 *
 * @version v 1.0.
 * @created
 *
 */
@Component
public class AccManualEntryConverter implements BaseConverter<AccManualEntryHdr, ManualEntryDto> {

	@Autowired
	CreditEntryConverter creditEntryConverter;

	@Autowired
	DebitEntryConverter debitEntryConverter;

	@Override
	public AccManualEntryHdr toEntity(ManualEntryDto dto) {
		AccManualEntryHdr entity = new AccManualEntryHdr();
		BeanUtils.copyProperties(dto, entity);
		entity.setType(new EDPLuLookUpInfoEntity(dto.typeId));
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		entity.setEntryStatus(GSTConstant.ME_CREATED_STATUS);
		entity.setEntryStatusId(GSTConstant.ME_CREATED_STATUS_ID);
		return entity;
	}

	@Override
	public ManualEntryDto toDTO(AccManualEntryHdr entity) {
		ManualEntryDto dto = new ManualEntryDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		dto.setTypeId(entity.getType().getLookUpInfoId());
		dto.setType(entity.getType().getLookUpInfoName());
		if(!entity.creditEntries.isEmpty()){
			dto.setCreditEntries(creditEntryConverter.toDTO(entity.creditEntries));
		}
		if(!entity.debitEntries.isEmpty()){
			dto.setDebitEntries(debitEntryConverter.toDTO(entity.debitEntries));
		}
		return dto;
	}
}

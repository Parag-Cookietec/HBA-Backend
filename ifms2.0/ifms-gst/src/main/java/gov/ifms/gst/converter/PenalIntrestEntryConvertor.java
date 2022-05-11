package gov.ifms.gst.converter;

import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.util.GSTConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.PenalIntrestEntryDto;
import gov.ifms.gst.entity.PenalIntrestEntry;

@Component
public class PenalIntrestEntryConvertor implements BaseConverter<PenalIntrestEntry, PenalIntrestEntryDto> {

	@Autowired
	private PenalIntrestDTLConvertor dtlConvertor;

	@Override
	public PenalIntrestEntry toEntity(PenalIntrestEntryDto dto) {
		PenalIntrestEntry entity = new PenalIntrestEntry();
		BeanUtils.copyProperties(dto, entity);
		entity.setReceiptMode(new EDPLuLookUpInfoEntity(dto.getReceiptModeId()));
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setEntryStatusId(GSTConstant.PI_CREATED_STATUS_ID);
		entity.setEntryStatus(GSTConstant.PI_CREATED_STATUS);
		entity.setId(dto.getId());
		return entity;
	}

	@Override
	public PenalIntrestEntryDto toDTO(PenalIntrestEntry entity) {
		PenalIntrestEntryDto dto = new PenalIntrestEntryDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		if(!entity.penalIntrestDTLList.isEmpty()){
			dto.setPenalDetailsList(dtlConvertor.toDTO(entity.penalIntrestDTLList));
		}
		dto.setReceiptModeId(entity.getReceiptMode().getLookUpInfoId());
		dto.setReceiptModeText(entity.getReceiptMode().getLookUpInfoName());
		return dto;
	}
}

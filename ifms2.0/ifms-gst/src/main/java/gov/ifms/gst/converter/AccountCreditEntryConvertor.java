package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.AccountCreditEntryDto;
import gov.ifms.gst.entity.AccountCreditEntry;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountCreditEntryConvertor implements BaseConverter<AccountCreditEntry, AccountCreditEntryDto> {
	@Override
	public AccountCreditEntry toEntity(AccountCreditEntryDto dto) {
		AccountCreditEntry entity = new AccountCreditEntry();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<AccountCreditEntry> toEntity(List<AccountCreditEntryDto> dpSheetDtos) {
		return dpSheetDtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public AccountCreditEntryDto toDTO(AccountCreditEntry entity) {
		AccountCreditEntryDto dto = new AccountCreditEntryDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<AccountCreditEntryDto> toDTO(List<AccountCreditEntry> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}
}

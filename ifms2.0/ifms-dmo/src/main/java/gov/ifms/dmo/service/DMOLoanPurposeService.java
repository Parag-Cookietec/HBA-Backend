package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOLoanPurposeDto;

import gov.ifms.dmo.entity.DMOLoanPurposeEntity;

public interface DMOLoanPurposeService {
	
	PagebleDTO<DMOLoanPurposeEntity> loanPurposeListing(PageDetails pageDetail) throws CustomException;

	DMOLoanPurposeDto save(DMOLoanPurposeDto dto);

}

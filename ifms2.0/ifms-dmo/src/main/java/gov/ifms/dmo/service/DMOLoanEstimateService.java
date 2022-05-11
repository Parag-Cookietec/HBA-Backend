package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOLoanEstimateDto;
import gov.ifms.dmo.entity.DMOLoanEstimateEntity;

public interface DMOLoanEstimateService {

	PagebleDTO<DMOLoanEstimateEntity> loanEstimateListing(PageDetails pageDetail) throws CustomException;

	DMOLoanEstimateDto save(DMOLoanEstimateDto dto);
}

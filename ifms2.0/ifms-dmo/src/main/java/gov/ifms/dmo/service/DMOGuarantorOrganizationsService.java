package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOGuarantorOrganizationsDto;
import gov.ifms.dmo.entity.DMOLoanGuarantorEntity;

public interface DMOGuarantorOrganizationsService {
	
	DMOGuarantorOrganizationsDto saveOrUpdate(DMOGuarantorOrganizationsDto dto);

	PagebleDTO<DMOLoanGuarantorEntity>  gurantorOrgListing(PageDetails pageDetail) throws CustomException;
	
	

}

package gov.ifms.doi.hba.service;
import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.doi.hba.dto.TdoiHbaProposalDTO;
import gov.ifms.doi.hba.dto.TdoiHbaProposalListingDTO;

public interface TdoiHbaProposalService{
public List<TdoiHbaProposalDTO> saveOrUpdate(TdoiHbaProposalDTO dto);
public List<TdoiHbaProposalDTO> findAllByCriteria();
public List<TdoiHbaProposalDTO> findAllByStatus(TdoiHbaProposalDTO dto);
public List<TdoiHbaProposalDTO> softDeleteById(Long id);
public TdoiHbaProposalDTO getEmployeeDetails(String loanAccountNo) throws CustomException;
public PagebleDTO<TdoiHbaProposalListingDTO> getPolicyProposalListing(PageDetails pageDetails) throws CustomException;
}

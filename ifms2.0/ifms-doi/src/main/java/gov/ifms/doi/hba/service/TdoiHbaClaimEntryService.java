package gov.ifms.doi.hba.service;
import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryDTO;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryListingDTO;
import gov.ifms.doi.hba.dto.TdoiHbaProposalListingDTO;

public interface TdoiHbaClaimEntryService{
public List<TdoiHbaClaimEntryDTO> saveOrUpdate(TdoiHbaClaimEntryDTO dto);
public List<TdoiHbaClaimEntryDTO> findAllByCriteria();
public List<TdoiHbaClaimEntryDTO> findAllByStatus(TdoiHbaClaimEntryDTO dto);
public List<TdoiHbaClaimEntryDTO> softDeleteById(Long id);
public PagebleDTO<TdoiHbaClaimEntryListingDTO> getClaimEntryListing(PageDetails pageDetail) throws CustomException;
}

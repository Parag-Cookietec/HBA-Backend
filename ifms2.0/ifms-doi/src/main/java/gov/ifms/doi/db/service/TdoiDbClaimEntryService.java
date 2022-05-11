package gov.ifms.doi.db.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.doi.db.dto.TdoiDbClaimEntryDTO;
import gov.ifms.doi.db.entity.TdoiDbClaimEntryEntity;

public interface TdoiDbClaimEntryService {
	public TdoiDbClaimEntryDTO saveOrUpdate(TdoiDbClaimEntryDTO dto);

	public List<TdoiDbClaimEntryDTO> findAllByCriteria();

	public List<TdoiDbClaimEntryDTO> findAllByStatus(TdoiDbClaimEntryDTO dto);

	public List<TdoiDbClaimEntryDTO> softDeleteById(Long id);

	public TdoiDbClaimEntryDTO addClaim(TdoiDbClaimEntryDTO dto);

	public List<TdoiDbClaimEntryDTO> fetchClaims();
}

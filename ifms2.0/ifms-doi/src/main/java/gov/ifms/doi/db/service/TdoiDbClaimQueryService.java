package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbClaimQueryDTO;

public interface TdoiDbClaimQueryService {
	public List<TdoiDbClaimQueryDTO> saveOrUpdate(TdoiDbClaimQueryDTO dto);

	public List<TdoiDbClaimQueryDTO> findAllByCriteria(TdoiDbClaimQueryDTO dto);

	public List<TdoiDbClaimQueryDTO> findAllByStatus(TdoiDbClaimQueryDTO dto);

	public List<TdoiDbClaimQueryDTO> softDeleteById(Long id);
}

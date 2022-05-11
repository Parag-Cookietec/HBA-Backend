package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbClaimPrevLossDTO;

public interface TdoiDbClaimPrevLossService {
	public List<TdoiDbClaimPrevLossDTO> saveOrUpdate(TdoiDbClaimPrevLossDTO dto);

	public List<TdoiDbClaimPrevLossDTO> findAllByCriteria(TdoiDbClaimPrevLossDTO dto);

	public List<TdoiDbClaimPrevLossDTO> findAllByStatus(TdoiDbClaimPrevLossDTO dto);

	public List<TdoiDbClaimPrevLossDTO> softDeleteById(Long id);
}

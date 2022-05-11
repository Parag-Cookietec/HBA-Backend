package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbClaimWfDTO;

public interface TdoiDbClaimWfService {
	public List<TdoiDbClaimWfDTO> saveOrUpdate(TdoiDbClaimWfDTO dto);

	public List<TdoiDbClaimWfDTO> findAllByCriteria(TdoiDbClaimWfDTO dto);

	public List<TdoiDbClaimWfDTO> findAllByStatus(TdoiDbClaimWfDTO dto);

	public List<TdoiDbClaimWfDTO> softDeleteById(Long id);
}

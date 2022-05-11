package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbClaimRiDtlDTO;

public interface TdoiDbClaimRiDtlService {
	public List<TdoiDbClaimRiDtlDTO> saveOrUpdate(TdoiDbClaimRiDtlDTO dto);

	public List<TdoiDbClaimRiDtlDTO> findAllByCriteria(TdoiDbClaimRiDtlDTO dto);

	public List<TdoiDbClaimRiDtlDTO> findAllByStatus(TdoiDbClaimRiDtlDTO dto);

	public List<TdoiDbClaimRiDtlDTO> softDeleteById(Long id);
}

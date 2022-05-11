package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbClaimPropDtlDTO;

public interface TdoiDbClaimPropDtlService {
	public List<TdoiDbClaimPropDtlDTO> saveOrUpdate(TdoiDbClaimPropDtlDTO dto);

	public List<TdoiDbClaimPropDtlDTO> findAllByCriteria(TdoiDbClaimPropDtlDTO dto);

	public List<TdoiDbClaimPropDtlDTO> findAllByStatus(TdoiDbClaimPropDtlDTO dto);

	public List<TdoiDbClaimPropDtlDTO> softDeleteById(Long id);
}

package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropMitRiDtlDTO;

public interface TdoiDbPropMitRiDtlService {
	public List<TdoiDbPropMitRiDtlDTO> saveOrUpdate(TdoiDbPropMitRiDtlDTO dto);

	public List<TdoiDbPropMitRiDtlDTO> findAllByCriteria(TdoiDbPropMitRiDtlDTO dto);

	public List<TdoiDbPropMitRiDtlDTO> findAllByStatus(TdoiDbPropMitRiDtlDTO dto);

	public List<TdoiDbPropMitRiDtlDTO> softDeleteById(Long id);
}

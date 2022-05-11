package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropBuglrRiDtlDTO;

public interface TdoiDbPropBuglrRiDtlService {
	public List<TdoiDbPropBuglrRiDtlDTO> saveOrUpdate(TdoiDbPropBuglrRiDtlDTO dto);

	public List<TdoiDbPropBuglrRiDtlDTO> findAllByCriteria(TdoiDbPropBuglrRiDtlDTO dto);

	public List<TdoiDbPropBuglrRiDtlDTO> findAllByStatus(TdoiDbPropBuglrRiDtlDTO dto);

	public List<TdoiDbPropBuglrRiDtlDTO> softDeleteById(Long id);
}

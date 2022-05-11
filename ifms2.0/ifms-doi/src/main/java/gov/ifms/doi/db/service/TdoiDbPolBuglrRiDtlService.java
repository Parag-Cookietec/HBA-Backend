package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolBuglrRiDtlDTO;

public interface TdoiDbPolBuglrRiDtlService {
	public List<TdoiDbPolBuglrRiDtlDTO> saveOrUpdate(TdoiDbPolBuglrRiDtlDTO dto);

	public List<TdoiDbPolBuglrRiDtlDTO> findAllByCriteria(TdoiDbPolBuglrRiDtlDTO dto);

	public List<TdoiDbPolBuglrRiDtlDTO> findAllByStatus(TdoiDbPolBuglrRiDtlDTO dto);

	public List<TdoiDbPolBuglrRiDtlDTO> softDeleteById(Long id);
}

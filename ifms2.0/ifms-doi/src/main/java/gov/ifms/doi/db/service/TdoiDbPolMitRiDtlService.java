package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolMitRiDtlDTO;

public interface TdoiDbPolMitRiDtlService {
	public List<TdoiDbPolMitRiDtlDTO> saveOrUpdate(TdoiDbPolMitRiDtlDTO dto);

	public List<TdoiDbPolMitRiDtlDTO> findAllByCriteria(TdoiDbPolMitRiDtlDTO dto);

	public List<TdoiDbPolMitRiDtlDTO> findAllByStatus(TdoiDbPolMitRiDtlDTO dto);

	public List<TdoiDbPolMitRiDtlDTO> softDeleteById(Long id);
}

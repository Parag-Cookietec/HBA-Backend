package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolAviationRiDtlDTO;

public interface TdoiDbPolAviationRiDtlService {
	public List<TdoiDbPolAviationRiDtlDTO> saveOrUpdate(TdoiDbPolAviationRiDtlDTO dto);

	public List<TdoiDbPolAviationRiDtlDTO> findAllByCriteria(TdoiDbPolAviationRiDtlDTO dto);

	public List<TdoiDbPolAviationRiDtlDTO> findAllByStatus(TdoiDbPolAviationRiDtlDTO dto);

	public List<TdoiDbPolAviationRiDtlDTO> softDeleteById(Long id);
}

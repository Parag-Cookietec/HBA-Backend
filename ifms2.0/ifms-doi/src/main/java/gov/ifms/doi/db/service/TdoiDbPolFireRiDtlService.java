package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolFireRiDtlDTO;

public interface TdoiDbPolFireRiDtlService {
	public List<TdoiDbPolFireRiDtlDTO> saveOrUpdate(TdoiDbPolFireRiDtlDTO dto);

	public List<TdoiDbPolFireRiDtlDTO> findAllByCriteria(TdoiDbPolFireRiDtlDTO dto);

	public List<TdoiDbPolFireRiDtlDTO> findAllByStatus(TdoiDbPolFireRiDtlDTO dto);

	public List<TdoiDbPolFireRiDtlDTO> softDeleteById(Long id);
}

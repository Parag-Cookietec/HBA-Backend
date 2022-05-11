package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropFireRiDtlDTO;

public interface TdoiDbPropFireRiDtlService {
	public List<TdoiDbPropFireRiDtlDTO> saveOrUpdate(TdoiDbPropFireRiDtlDTO dto);

	public List<TdoiDbPropFireRiDtlDTO> findAllByCriteria(TdoiDbPropFireRiDtlDTO dto);

	public List<TdoiDbPropFireRiDtlDTO> findAllByStatus(TdoiDbPropFireRiDtlDTO dto);

	public List<TdoiDbPropFireRiDtlDTO> softDeleteById(Long id);
}

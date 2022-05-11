package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropAviationRiDtlDTO;

public interface TdoiDbPropAviationRiDtlService {
	public List<TdoiDbPropAviationRiDtlDTO> saveOrUpdate(TdoiDbPropAviationRiDtlDTO dto);

	public List<TdoiDbPropAviationRiDtlDTO> findAllByCriteria(TdoiDbPropAviationRiDtlDTO dto);

	public List<TdoiDbPropAviationRiDtlDTO> findAllByStatus(TdoiDbPropAviationRiDtlDTO dto);

	public List<TdoiDbPropAviationRiDtlDTO> softDeleteById(Long id);
}

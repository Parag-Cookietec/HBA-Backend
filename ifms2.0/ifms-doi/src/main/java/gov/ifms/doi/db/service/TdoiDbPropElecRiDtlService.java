package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropElecRiDtlDTO;

public interface TdoiDbPropElecRiDtlService {
	public List<TdoiDbPropElecRiDtlDTO> saveOrUpdate(TdoiDbPropElecRiDtlDTO dto);

	public List<TdoiDbPropElecRiDtlDTO> findAllByCriteria(TdoiDbPropElecRiDtlDTO dto);

	public List<TdoiDbPropElecRiDtlDTO> findAllByStatus(TdoiDbPropElecRiDtlDTO dto);

	public List<TdoiDbPropElecRiDtlDTO> softDeleteById(Long id);
}

package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbFireRiskLocDTO;

public interface TdoiDbFireRiskLocService {
	public List<TdoiDbFireRiskLocDTO> saveOrUpdate(TdoiDbFireRiskLocDTO dto);

	public List<TdoiDbFireRiskLocDTO> findAllByCriteria(TdoiDbFireRiskLocDTO dto);

	public List<TdoiDbFireRiskLocDTO> findAllByStatus(TdoiDbFireRiskLocDTO dto);

	public List<TdoiDbFireRiskLocDTO> softDeleteById(Long id);
}

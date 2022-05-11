package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbFireBuildingValDTO;

public interface TdoiDbFireBuildingValService {
	public List<TdoiDbFireBuildingValDTO> saveOrUpdate(TdoiDbFireBuildingValDTO dto);

	public List<TdoiDbFireBuildingValDTO> findAllByCriteria(TdoiDbFireBuildingValDTO dto);

	public List<TdoiDbFireBuildingValDTO> findAllByStatus(TdoiDbFireBuildingValDTO dto);

	public List<TdoiDbFireBuildingValDTO> softDeleteById(Long id);
}

package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolFireBuildingValDTO;

public interface TdoiDbPolFireBuildingValService {
	public List<TdoiDbPolFireBuildingValDTO> saveOrUpdate(TdoiDbPolFireBuildingValDTO dto);

	public List<TdoiDbPolFireBuildingValDTO> findAllByCriteria(TdoiDbPolFireBuildingValDTO dto);

	public List<TdoiDbPolFireBuildingValDTO> findAllByStatus(TdoiDbPolFireBuildingValDTO dto);

	public List<TdoiDbPolFireBuildingValDTO> softDeleteById(Long id);
}

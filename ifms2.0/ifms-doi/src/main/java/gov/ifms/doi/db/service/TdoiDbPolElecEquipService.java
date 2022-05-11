package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolElecEquipDTO;

public interface TdoiDbPolElecEquipService {
	public TdoiDbPolElecEquipDTO saveOrUpdate(TdoiDbPolElecEquipDTO dto);

	public List<TdoiDbPolElecEquipDTO> findAllByCriteria();

	public List<TdoiDbPolElecEquipDTO> findAllByStatus();

	public TdoiDbPolElecEquipDTO softDeleteById(Long id);
}

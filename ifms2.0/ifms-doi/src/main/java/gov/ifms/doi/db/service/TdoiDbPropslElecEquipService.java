package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslElecEquipDTO;

public interface TdoiDbPropslElecEquipService {
	public List<TdoiDbPropslElecEquipDTO> saveOrUpdate(TdoiDbPropslElecEquipDTO dto);

	public List<TdoiDbPropslElecEquipDTO> findAllByCriteria(TdoiDbPropslElecEquipDTO dto);

	public List<TdoiDbPropslElecEquipDTO> findAllByStatus(TdoiDbPropslElecEquipDTO dto);

	public List<TdoiDbPropslElecEquipDTO> softDeleteById(Long id);
}

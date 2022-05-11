package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslEquipDtlDTO;

public interface TdoiDbPropslEquipDtlService {
	public List<TdoiDbPropslEquipDtlDTO> saveOrUpdate(TdoiDbPropslEquipDtlDTO dto);

	public List<TdoiDbPropslEquipDtlDTO> findAllByCriteria(TdoiDbPropslEquipDtlDTO dto);

	public List<TdoiDbPropslEquipDtlDTO> findAllByStatus(TdoiDbPropslEquipDtlDTO dto);

	public List<TdoiDbPropslEquipDtlDTO> softDeleteById(Long id);
}

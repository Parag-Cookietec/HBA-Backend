package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolEquipDtlDTO;

public interface TdoiDbPolEquipDtlService {
	public List<TdoiDbPolEquipDtlDTO> saveOrUpdate(TdoiDbPolEquipDtlDTO dto);

	public List<TdoiDbPolEquipDtlDTO> findAllByCriteria(TdoiDbPolEquipDtlDTO dto);

	public List<TdoiDbPolEquipDtlDTO> findAllByStatus(TdoiDbPolEquipDtlDTO dto);

	public List<TdoiDbPolEquipDtlDTO> softDeleteById(Long id);
}

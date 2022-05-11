package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropMoneyIntransitDTO;

public interface TdoiDbPropMoneyIntransitService {
	public List<TdoiDbPropMoneyIntransitDTO> saveOrUpdate(TdoiDbPropMoneyIntransitDTO dto);

	public List<TdoiDbPropMoneyIntransitDTO> findAllByCriteria(TdoiDbPropMoneyIntransitDTO dto);

	public List<TdoiDbPropMoneyIntransitDTO> findAllByStatus(TdoiDbPropMoneyIntransitDTO dto);

	public List<TdoiDbPropMoneyIntransitDTO> softDeleteById(Long id);
}

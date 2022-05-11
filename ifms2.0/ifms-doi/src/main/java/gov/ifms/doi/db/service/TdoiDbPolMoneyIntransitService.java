package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolMoneyIntransitDTO;

public interface TdoiDbPolMoneyIntransitService {
	public List<TdoiDbPolMoneyIntransitDTO> saveOrUpdate(TdoiDbPolMoneyIntransitDTO dto);

	public List<TdoiDbPolMoneyIntransitDTO> findAllByCriteria(TdoiDbPolMoneyIntransitDTO dto);

	public List<TdoiDbPolMoneyIntransitDTO> findAllByStatus(TdoiDbPolMoneyIntransitDTO dto);

	public List<TdoiDbPolMoneyIntransitDTO> softDeleteById(Long id);
}

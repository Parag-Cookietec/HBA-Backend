package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolMitWfDTO;

public interface TdoiDbPolMitWfService {
	public List<TdoiDbPolMitWfDTO> saveOrUpdate(TdoiDbPolMitWfDTO dto);

	public List<TdoiDbPolMitWfDTO> findAllByCriteria(TdoiDbPolMitWfDTO dto);

	public List<TdoiDbPolMitWfDTO> findAllByStatus(TdoiDbPolMitWfDTO dto);

	public List<TdoiDbPolMitWfDTO> softDeleteById(Long id);
}

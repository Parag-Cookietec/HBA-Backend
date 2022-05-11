package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolElecWfDTO;

public interface TdoiDbPolElecWfService {
	public List<TdoiDbPolElecWfDTO> saveOrUpdate(TdoiDbPolElecWfDTO dto);

	public List<TdoiDbPolElecWfDTO> findAllByCriteria(TdoiDbPolElecWfDTO dto);

	public List<TdoiDbPolElecWfDTO> findAllByStatus(TdoiDbPolElecWfDTO dto);

	public List<TdoiDbPolElecWfDTO> softDeleteById(Long id);
}

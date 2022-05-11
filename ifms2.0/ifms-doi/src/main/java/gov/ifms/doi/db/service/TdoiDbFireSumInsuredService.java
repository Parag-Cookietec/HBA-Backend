package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbFireSumInsuredDTO;

public interface TdoiDbFireSumInsuredService {
	public List<TdoiDbFireSumInsuredDTO> saveOrUpdate(TdoiDbFireSumInsuredDTO dto);

	public List<TdoiDbFireSumInsuredDTO> findAllByCriteria(TdoiDbFireSumInsuredDTO dto);

	public List<TdoiDbFireSumInsuredDTO> findAllByStatus(TdoiDbFireSumInsuredDTO dto);

	public List<TdoiDbFireSumInsuredDTO> softDeleteById(Long id);
}

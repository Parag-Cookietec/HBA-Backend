package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolFireSumInsuredDTO;

public interface TdoiDbPolFireSumInsuredService {
	public List<TdoiDbPolFireSumInsuredDTO> saveOrUpdate(TdoiDbPolFireSumInsuredDTO dto);

	public List<TdoiDbPolFireSumInsuredDTO> findAllByCriteria(TdoiDbPolFireSumInsuredDTO dto);

	public List<TdoiDbPolFireSumInsuredDTO> findAllByStatus(TdoiDbPolFireSumInsuredDTO dto);

	public List<TdoiDbPolFireSumInsuredDTO> softDeleteById(Long id);
}

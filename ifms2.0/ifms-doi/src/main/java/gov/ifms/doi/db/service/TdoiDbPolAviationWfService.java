package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolAviationWfDTO;

public interface TdoiDbPolAviationWfService {
	public List<TdoiDbPolAviationWfDTO> saveOrUpdate(TdoiDbPolAviationWfDTO dto);

	public List<TdoiDbPolAviationWfDTO> findAllByCriteria(TdoiDbPolAviationWfDTO dto);

	public List<TdoiDbPolAviationWfDTO> findAllByStatus(TdoiDbPolAviationWfDTO dto);

	public List<TdoiDbPolAviationWfDTO> softDeleteById(Long id);
}

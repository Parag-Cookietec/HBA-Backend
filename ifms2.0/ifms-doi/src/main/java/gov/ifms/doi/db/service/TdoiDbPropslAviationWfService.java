package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslAviationWfDTO;

public interface TdoiDbPropslAviationWfService {
	public List<TdoiDbPropslAviationWfDTO> saveOrUpdate(TdoiDbPropslAviationWfDTO dto);

	public List<TdoiDbPropslAviationWfDTO> findAllByCriteria(TdoiDbPropslAviationWfDTO dto);

	public List<TdoiDbPropslAviationWfDTO> findAllByStatus(TdoiDbPropslAviationWfDTO dto);

	public List<TdoiDbPropslAviationWfDTO> softDeleteById(Long id);
}

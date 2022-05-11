package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslElecWfDTO;

public interface TdoiDbPropslElecWfService {
	public List<TdoiDbPropslElecWfDTO> saveOrUpdate(TdoiDbPropslElecWfDTO dto);

	public List<TdoiDbPropslElecWfDTO> findAllByCriteria(TdoiDbPropslElecWfDTO dto);

	public List<TdoiDbPropslElecWfDTO> findAllByStatus(TdoiDbPropslElecWfDTO dto);

	public List<TdoiDbPropslElecWfDTO> softDeleteById(Long id);
}

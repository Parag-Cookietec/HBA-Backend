package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbProposlWfDTO;

public interface TdoiDbProposlWfService {
	public List<TdoiDbProposlWfDTO> saveOrUpdate(TdoiDbProposlWfDTO dto);

	public List<TdoiDbProposlWfDTO> findAllByCriteria(TdoiDbProposlWfDTO dto);

	public List<TdoiDbProposlWfDTO> findAllByStatus(TdoiDbProposlWfDTO dto);

	public List<TdoiDbProposlWfDTO> softDeleteById(Long id);
}

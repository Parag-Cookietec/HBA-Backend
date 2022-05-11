package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslFireWfDTO;

public interface TdoiDbPropslFireWfService {
	public List<TdoiDbPropslFireWfDTO> saveOrUpdate(TdoiDbPropslFireWfDTO dto);

	public List<TdoiDbPropslFireWfDTO> findAllByCriteria(TdoiDbPropslFireWfDTO dto);

	public List<TdoiDbPropslFireWfDTO> findAllByStatus(TdoiDbPropslFireWfDTO dto);

	public List<TdoiDbPropslFireWfDTO> softDeleteById(Long id);
}

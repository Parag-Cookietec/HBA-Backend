package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslBurglaryWfDTO;

public interface TdoiDbPropslBurglaryWfService {
	public List<TdoiDbPropslBurglaryWfDTO> saveOrUpdate(TdoiDbPropslBurglaryWfDTO dto);

	public List<TdoiDbPropslBurglaryWfDTO> findAllByCriteria(TdoiDbPropslBurglaryWfDTO dto);

	public List<TdoiDbPropslBurglaryWfDTO> findAllByStatus(TdoiDbPropslBurglaryWfDTO dto);

	public List<TdoiDbPropslBurglaryWfDTO> softDeleteById(Long id);
}

package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslBurglaryDTO;

public interface TdoiDbPropslBurglaryService {
	public List<TdoiDbPropslBurglaryDTO> saveOrUpdate(TdoiDbPropslBurglaryDTO dto);

	public List<TdoiDbPropslBurglaryDTO> findAllByCriteria(TdoiDbPropslBurglaryDTO dto);

	public List<TdoiDbPropslBurglaryDTO> findAllByStatus(TdoiDbPropslBurglaryDTO dto);

	public List<TdoiDbPropslBurglaryDTO> softDeleteById(Long id);
}

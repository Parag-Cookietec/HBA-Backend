package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolBurglaryDTO;

public interface TdoiDbPolBurglaryService {
	public List<TdoiDbPolBurglaryDTO> saveOrUpdate(TdoiDbPolBurglaryDTO dto);

	public List<TdoiDbPolBurglaryDTO> findAllByCriteria(TdoiDbPolBurglaryDTO dto);

	public List<TdoiDbPolBurglaryDTO> findAllByStatus(TdoiDbPolBurglaryDTO dto);

	public List<TdoiDbPolBurglaryDTO> softDeleteById(Long id);
}

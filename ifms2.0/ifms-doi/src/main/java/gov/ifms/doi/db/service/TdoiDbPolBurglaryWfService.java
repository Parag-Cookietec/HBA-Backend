package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolBurglaryWfDTO;

public interface TdoiDbPolBurglaryWfService {
	public List<TdoiDbPolBurglaryWfDTO> saveOrUpdate(TdoiDbPolBurglaryWfDTO dto);

	public List<TdoiDbPolBurglaryWfDTO> findAllByCriteria(TdoiDbPolBurglaryWfDTO dto);

	public List<TdoiDbPolBurglaryWfDTO> findAllByStatus(TdoiDbPolBurglaryWfDTO dto);

	public List<TdoiDbPolBurglaryWfDTO> softDeleteById(Long id);
}

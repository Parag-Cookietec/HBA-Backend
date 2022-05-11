package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslAviationDTO;

public interface TdoiDbPropslAviationService {
	public List<TdoiDbPropslAviationDTO> saveOrUpdate(TdoiDbPropslAviationDTO dto);

	public List<TdoiDbPropslAviationDTO> findAllByCriteria(TdoiDbPropslAviationDTO dto);

	public List<TdoiDbPropslAviationDTO> findAllByStatus(TdoiDbPropslAviationDTO dto);

	public List<TdoiDbPropslAviationDTO> softDeleteById(Long id);
}

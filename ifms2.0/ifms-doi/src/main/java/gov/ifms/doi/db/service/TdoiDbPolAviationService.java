package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolAviationDTO;

public interface TdoiDbPolAviationService {
	public List<TdoiDbPolAviationDTO> saveOrUpdate(TdoiDbPolAviationDTO dto);

	public List<TdoiDbPolAviationDTO> findAllByCriteria(TdoiDbPolAviationDTO dto);

	public List<TdoiDbPolAviationDTO> findAllByStatus(TdoiDbPolAviationDTO dto);

	public List<TdoiDbPolAviationDTO> softDeleteById(Long id);

	public TdoiDbPolAviationDTO addAviationPolicy(TdoiDbPolAviationDTO dto);
}

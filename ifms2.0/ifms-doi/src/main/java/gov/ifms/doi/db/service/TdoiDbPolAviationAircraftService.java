package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolAviationAircraftDTO;

public interface TdoiDbPolAviationAircraftService {
	public List<TdoiDbPolAviationAircraftDTO> saveOrUpdate(TdoiDbPolAviationAircraftDTO dto);

	public List<TdoiDbPolAviationAircraftDTO> findAllByCriteria(TdoiDbPolAviationAircraftDTO dto);

	public List<TdoiDbPolAviationAircraftDTO> findAllByStatus(TdoiDbPolAviationAircraftDTO dto);

	public List<TdoiDbPolAviationAircraftDTO> softDeleteById(Long id);
}

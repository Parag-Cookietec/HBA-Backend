package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropAviationAircraftDTO;

public interface TdoiDbPropAviationAircraftService {
	public List<TdoiDbPropAviationAircraftDTO> saveOrUpdate(TdoiDbPropAviationAircraftDTO dto);

	public List<TdoiDbPropAviationAircraftDTO> findAllByCriteria(TdoiDbPropAviationAircraftDTO dto);

	public List<TdoiDbPropAviationAircraftDTO> findAllByStatus(TdoiDbPropAviationAircraftDTO dto);

	public List<TdoiDbPropAviationAircraftDTO> softDeleteById(Long id);
}

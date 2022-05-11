package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslFirePerilDTO;

public interface TdoiDbPropslFirePerilService {
	public List<TdoiDbPropslFirePerilDTO> saveOrUpdate(TdoiDbPropslFirePerilDTO dto);

	public List<TdoiDbPropslFirePerilDTO> findAllByCriteria(TdoiDbPropslFirePerilDTO dto);

	public List<TdoiDbPropslFirePerilDTO> findAllByStatus(TdoiDbPropslFirePerilDTO dto);

	public List<TdoiDbPropslFirePerilDTO> softDeleteById(Long id);
}

package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropMitWfDTO;

public interface TdoiDbPropMitWfService {
	public List<TdoiDbPropMitWfDTO> saveOrUpdate(TdoiDbPropMitWfDTO dto);

	public List<TdoiDbPropMitWfDTO> findAllByCriteria(TdoiDbPropMitWfDTO dto);

	public List<TdoiDbPropMitWfDTO> findAllByStatus(TdoiDbPropMitWfDTO dto);

	public List<TdoiDbPropMitWfDTO> softDeleteById(Long id);
}

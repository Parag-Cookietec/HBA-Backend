package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropMitInsuranceDTO;

public interface TdoiDbPropMitInsuranceService {
	public List<TdoiDbPropMitInsuranceDTO> saveOrUpdate(TdoiDbPropMitInsuranceDTO dto);

	public List<TdoiDbPropMitInsuranceDTO> findAllByCriteria(TdoiDbPropMitInsuranceDTO dto);

	public List<TdoiDbPropMitInsuranceDTO> findAllByStatus(TdoiDbPropMitInsuranceDTO dto);

	public List<TdoiDbPropMitInsuranceDTO> softDeleteById(Long id);
}

package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolMitInsuranceDTO;

public interface TdoiDbPolMitInsuranceService {
	public List<TdoiDbPolMitInsuranceDTO> saveOrUpdate(TdoiDbPolMitInsuranceDTO dto);

	public List<TdoiDbPolMitInsuranceDTO> findAllByCriteria(TdoiDbPolMitInsuranceDTO dto);

	public List<TdoiDbPolMitInsuranceDTO> findAllByStatus(TdoiDbPolMitInsuranceDTO dto);

	public List<TdoiDbPolMitInsuranceDTO> softDeleteById(Long id);
}

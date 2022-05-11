package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbFirePastPolicyDTO;

public interface TdoiDbFirePastPolicyService {
	public List<TdoiDbFirePastPolicyDTO> saveOrUpdate(TdoiDbFirePastPolicyDTO dto);

	public List<TdoiDbFirePastPolicyDTO> findAllByCriteria(TdoiDbFirePastPolicyDTO dto);

	public List<TdoiDbFirePastPolicyDTO> findAllByStatus(TdoiDbFirePastPolicyDTO dto);

	public List<TdoiDbFirePastPolicyDTO> softDeleteById(Long id);
}

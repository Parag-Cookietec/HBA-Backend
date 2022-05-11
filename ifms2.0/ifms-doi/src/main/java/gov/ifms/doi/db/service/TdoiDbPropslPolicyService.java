package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslPolicyDTO;

public interface TdoiDbPropslPolicyService {
	public List<TdoiDbPropslPolicyDTO> saveOrUpdate(TdoiDbPropslPolicyDTO dto);

	public List<TdoiDbPropslPolicyDTO> findAllByCriteria(TdoiDbPropslPolicyDTO dto);

	public List<TdoiDbPropslPolicyDTO> findAllByStatus(TdoiDbPropslPolicyDTO dto);

	public List<TdoiDbPropslPolicyDTO> softDeleteById(Long id);
}

package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolicyListDTO;

public interface TdoiDbPolicyListService {
	public List<TdoiDbPolicyListDTO> saveOrUpdate(TdoiDbPolicyListDTO dto);

	public List<TdoiDbPolicyListDTO> findAllByCriteria(TdoiDbPolicyListDTO dto);

	public List<TdoiDbPolicyListDTO> findAllByStatus(TdoiDbPolicyListDTO dto);

	public List<TdoiDbPolicyListDTO> softDeleteById(Long id);

	public List<TdoiDbPolicyListDTO> findAll();
}

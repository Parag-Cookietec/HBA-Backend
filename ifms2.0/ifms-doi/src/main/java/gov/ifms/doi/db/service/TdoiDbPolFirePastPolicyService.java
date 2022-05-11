package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolFirePastPolicyDTO;

public interface TdoiDbPolFirePastPolicyService {
	public TdoiDbPolFirePastPolicyDTO saveOrUpdate(TdoiDbPolFirePastPolicyDTO dto);

	public List<TdoiDbPolFirePastPolicyDTO> findAllByCriteria();

	public List<TdoiDbPolFirePastPolicyDTO> findAllByStatus();

	public TdoiDbPolFirePastPolicyDTO softDeleteById(Long id);
}

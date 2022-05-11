package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolFireWfDTO;

public interface TdoiDbPolFireWfService {
	public List<TdoiDbPolFireWfDTO> saveOrUpdate(TdoiDbPolFireWfDTO dto);

	public List<TdoiDbPolFireWfDTO> findAllByCriteria(TdoiDbPolFireWfDTO dto);

	public List<TdoiDbPolFireWfDTO> findAllByStatus(TdoiDbPolFireWfDTO dto);

	public List<TdoiDbPolFireWfDTO> softDeleteById(Long id);
}

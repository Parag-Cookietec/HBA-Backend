package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPolFirePerilDTO;

public interface TdoiDbPolFirePerilService {
	public List<TdoiDbPolFirePerilDTO> saveOrUpdate(TdoiDbPolFirePerilDTO dto);

	public List<TdoiDbPolFirePerilDTO> findAllByCriteria(TdoiDbPolFirePerilDTO dto);

	public List<TdoiDbPolFirePerilDTO> findAllByStatus(TdoiDbPolFirePerilDTO dto);

	public List<TdoiDbPolFirePerilDTO> softDeleteById(Long id);
}

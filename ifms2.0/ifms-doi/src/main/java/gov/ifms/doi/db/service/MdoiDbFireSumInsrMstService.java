package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.MdoiDbFireSumInsrMstDTO;

public interface MdoiDbFireSumInsrMstService {
	public List<MdoiDbFireSumInsrMstDTO> saveOrUpdate(MdoiDbFireSumInsrMstDTO dto);

	public List<MdoiDbFireSumInsrMstDTO> findAllByCriteria(MdoiDbFireSumInsrMstDTO dto);

	public List<MdoiDbFireSumInsrMstDTO> findAllByStatus(MdoiDbFireSumInsrMstDTO dto);

	public List<MdoiDbFireSumInsrMstDTO> softDeleteById(Long id);
}

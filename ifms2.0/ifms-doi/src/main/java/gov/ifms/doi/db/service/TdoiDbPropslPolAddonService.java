package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbPropslPolAddonDTO;

public interface TdoiDbPropslPolAddonService {
	public List<TdoiDbPropslPolAddonDTO> saveOrUpdate(TdoiDbPropslPolAddonDTO dto);

	public List<TdoiDbPropslPolAddonDTO> findAllByCriteria(TdoiDbPropslPolAddonDTO dto);

	public List<TdoiDbPropslPolAddonDTO> findAllByStatus(TdoiDbPropslPolAddonDTO dto);

	public List<TdoiDbPropslPolAddonDTO> softDeleteById(Long id);
}

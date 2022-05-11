package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.MdoiDbPartyOfficeDtlDTO;

public interface MdoiDbPartyOfficeDtlService {
	public List<MdoiDbPartyOfficeDtlDTO> saveOrUpdate(MdoiDbPartyOfficeDtlDTO dto);

	public List<MdoiDbPartyOfficeDtlDTO> findAllByCriteria(MdoiDbPartyOfficeDtlDTO dto);

	public List<MdoiDbPartyOfficeDtlDTO> findAllByStatus(MdoiDbPartyOfficeDtlDTO dto);

	public List<MdoiDbPartyOfficeDtlDTO> softDeleteById(Long id);
}

package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.MdoiDbPartyBankDtlDTO;

public interface MdoiDbPartyBankDtlService {
	public List<MdoiDbPartyBankDtlDTO> saveOrUpdate(MdoiDbPartyBankDtlDTO dto);

	public List<MdoiDbPartyBankDtlDTO> findAllByCriteria(MdoiDbPartyBankDtlDTO dto);

	public List<MdoiDbPartyBankDtlDTO> findAllByStatus(MdoiDbPartyBankDtlDTO dto);

	public List<MdoiDbPartyBankDtlDTO> softDeleteById(Long id);


}

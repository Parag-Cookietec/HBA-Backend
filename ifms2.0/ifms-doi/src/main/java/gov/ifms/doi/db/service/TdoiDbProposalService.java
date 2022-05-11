package gov.ifms.doi.db.service;

import java.util.List;
import gov.ifms.doi.db.dto.TdoiDbProposalDTO;

public interface TdoiDbProposalService {
	public List<TdoiDbProposalDTO> saveOrUpdate(TdoiDbProposalDTO dto);

	public List<TdoiDbProposalDTO> findAllByCriteria(TdoiDbProposalDTO dto);

	public List<TdoiDbProposalDTO> findAllByStatus(TdoiDbProposalDTO dto);

	public List<TdoiDbProposalDTO> softDeleteById(Long id);
}

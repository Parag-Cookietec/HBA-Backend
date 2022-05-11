package gov.ifms.doi.db.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.doi.db.dto.MdoiDbPartyMstDTO;

public interface MdoiDbPartyMstService {
	MdoiDbPartyMstDTO saveOrUpdate(MdoiDbPartyMstDTO dto);

	List<MdoiDbPartyMstDTO> findAllByCriteria(MdoiDbPartyMstDTO dto);

	PagebleDTO<MdoiDbPartyMstDTO> findAll(PageDetails pageDetails);

	List<MdoiDbPartyMstDTO> findAllByStatus(MdoiDbPartyMstDTO dto);

	List<MdoiDbPartyMstDTO> softDeleteById(Long id);

	MdoiDbPartyMstDTO add(MdoiDbPartyMstDTO dto);

	List<MdoiDbPartyMstDTO> fetch();
}

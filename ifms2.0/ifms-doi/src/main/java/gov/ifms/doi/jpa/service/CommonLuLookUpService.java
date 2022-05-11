package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.LuLookUpDTO;

public interface CommonLuLookUpService {

	List<LuLookUpDTO> findByLookUpId(LuLookUpDTO lookUpDTO);

}

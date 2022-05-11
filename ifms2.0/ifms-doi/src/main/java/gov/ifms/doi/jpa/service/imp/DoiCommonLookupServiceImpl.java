package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gov.ifms.doi.jpa.dto.DoiCommonLookUpDTO;
import gov.ifms.doi.jpa.repository.DoiCommonLookupRepository;
import gov.ifms.doi.jpa.service.DoiCommonLookupService;

public class DoiCommonLookupServiceImpl implements DoiCommonLookupService {

	@Autowired
	DoiCommonLookupRepository doiCommonLookupRepository;
	
	@Override
	public List<DoiCommonLookUpDTO> getByLookUpName(DoiCommonLookUpDTO dto) {
		return null;
	}

}

package gov.ifms.gst.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.dto.GSTLULookupDto;

import java.util.List;

public interface GSTLULookupService{
		List<GSTLULookupDto> fetchLookUpData(GSTLULookupDto lookUpDto) throws CustomException;
}

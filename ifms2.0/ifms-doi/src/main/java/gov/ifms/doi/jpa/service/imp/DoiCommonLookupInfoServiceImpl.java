package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.converter.DoiCommonLookupInfoConverter;
import gov.ifms.doi.jpa.dto.DoiCommonLookUpInfoDTO;
import gov.ifms.doi.jpa.repository.DoiCommonLookupInfoRepository;
import gov.ifms.doi.jpa.service.DoiCommonLookupInfoService;

@Service
public class DoiCommonLookupInfoServiceImpl implements DoiCommonLookupInfoService {

	@Autowired
	DoiCommonLookupInfoRepository doiCommonLookupInfoRepository;

	@Autowired
	DoiCommonLookupInfoConverter doiCommonLookupInfoConverter;

	@Override
	public List<DoiCommonLookUpInfoDTO> getByParentLookUpName(String causeOfLoss) {
		return doiCommonLookupInfoConverter.toDTOList(doiCommonLookupInfoRepository.getByParentLookUpName(causeOfLoss));
	}

	@Override
	public void updateLookupInfoValue(String lookupInfoName, String updatedValue) {
		doiCommonLookupInfoRepository.updateLookupInfoValue(lookupInfoName, updatedValue);
	}
}

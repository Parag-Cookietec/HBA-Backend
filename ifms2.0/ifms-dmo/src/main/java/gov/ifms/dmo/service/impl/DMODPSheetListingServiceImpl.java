package gov.ifms.dmo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.dto.DMODPSheetSearchDto;
import gov.ifms.dmo.dto.DMODPSheetSearchHDRPostDto;
import gov.ifms.dmo.repository.DMODPSheetEntryHRDRepository;
import gov.ifms.dmo.service.DMODPSheetListingService;
import gov.ifms.dmo.utils.DMOConstant;

@Service
public class DMODPSheetListingServiceImpl implements DMODPSheetListingService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private DMODPSheetEntryHRDRepository hrdRepository;

	@Override
	public PagebleDTO<DMODPSheetSearchDto> searchDPSheet(DMODPSheetSearchHDRPostDto dto) throws CustomException {
		try {
			Map<String, Object> spParamMap = new HashMap<>();
			spParamMap.put(DMOConstant.IN_PAGE_INDEX, dto.getPageIndex());
			spParamMap.put(DMOConstant.IN_PAGE_SIZE, dto.getPageElement());
			spParamMap.put(DMOConstant.IN_FY, dto.getFy());
			spParamMap.put(DMOConstant.IN_DP_SHEET_FRM_DT, dto.getDpSheetFrDt());
			spParamMap.put(DMOConstant.IN_DP_SHEET_TO_DT, dto.getDpSheetToDt());
			spParamMap.put(DMOConstant.IN_DP_SHEET_REF_FR_DT, dto.getRefNoFrDt());
			spParamMap.put(DMOConstant.IN_DP_SHEET_REF_TO_DT, dto.getRefNoToDt());
			spParamMap.put(DMOConstant.IN_REF_NO, dto.getRefNo());
			String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.SP_DP_SHEET_HDR_SR));
			List<Object[]> responseList = hrdRepository.callStoredProcedure(procName, spParamMap);
			List<DMODPSheetSearchDto> response = NativeQueryResultsMapper.map(responseList, DMODPSheetSearchDto.class);
			return new PagebleDTO<>(dto.getPageElement(), 0, response.isEmpty() ? 0 : response.get(0).getCount(),
					response);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

}

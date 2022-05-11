package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMODPSheetSearchDto;
import gov.ifms.dmo.dto.DMODPSheetSearchHDRPostDto;
import gov.ifms.dmo.repository.DMODPSheetEntryHRDRepository;
import gov.ifms.dmo.service.impl.DMODPSheetListingServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;

@TestInstance(Lifecycle.PER_CLASS)
class DMODPSheetListingServiceTest {
	@InjectMocks
	private DMODPSheetListingServiceImpl dpSheetListingServiceImpl;

	@Mock
	private DMODPSheetEntryHRDRepository hrdRepository;
	@Mock
	private DMODPSheetSearchHDRPostDto dto;
	@Mock
	private DMODPSheetSearchDto respDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test searchDPSheet(D).")
	void testSearchDPSheet() throws CustomException {
		respDto = new DMODPSheetSearchDto();
		dto = new DMODPSheetSearchHDRPostDto();
		prepareMockReqDto();
		Object[] objArr = spRespObjectArray();
		List<Object[]> responseList = new ArrayList<>();
		responseList.add(objArr);
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
		when(hrdRepository.callStoredProcedure(procName, spParamMap)).thenReturn(responseList);
		PagebleDTO<DMODPSheetSearchDto> pagebleDTO = dpSheetListingServiceImpl.searchDPSheet(dto);
		assertNotNull(pagebleDTO);

	}

	private void prepareMockReqDto() {
		dto.setPageIndex(0);
		dto.setPageElement(1);
		dto.setFy("2021-2022");
		dto.setDpSheetFrDt("2021-08-01");
		dto.setDpSheetToDt("2021-09-01");
		dto.setRefNoFrDt("2021-12-01");
		dto.setRefNoToDt("2021-12-15");
		dto.setRefNo("21-22/DMO/DPS/000110");
	}

	private Object[] spRespObjectArray() {
		Object[] objArr = { "223", "2021-2022", "21-22/DMO/DPS/000110", "2021-12-07-20.29.07.746000", "2021-08-11",
				"011620210811", 1 };
		return objArr;
	}

}

package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
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

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.converter.DMOGuaranteeEntryConverter;
import gov.ifms.dmo.dto.DMOGuaranteeEntryBasePostDto;
import gov.ifms.dmo.dto.DMOGuaranteeEntryPostDto;
import gov.ifms.dmo.entity.DMOGuaranteeEntryEntity;
import gov.ifms.dmo.repository.DMOGuaranteeEntryRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMOGuaranteeEntryServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;

@TestInstance(Lifecycle.PER_CLASS)
class DMOGuaranteeEntryServiceTest {

	@InjectMocks
	DMOGuaranteeEntryServiceImpl dmoGuaranteeEntryService;

	@Mock
	DMOGuaranteeEntryConverter entryConverter;

	@Mock
	DMOGuaranteeEntryRepository dmoGuaranteeEntryRepository;

	@Mock
	DMOGuaranteeEntryEntity gurEntryEntity;

	@Mock
	DMOGuaranteeEntryPostDto dto;

	@Mock
	DMONSSFLoanRepository nssfLoanRepository;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test Guarantee Entry save success.")
	void testSaveGuaranteeEntry() throws CustomException {
		dto = new DMOGuaranteeEntryPostDto();
		dto.setId(1l);
		List<DMOGuaranteeEntryPostDto> postDtos = new ArrayList<DMOGuaranteeEntryPostDto>();
		postDtos.add(dto);
		DMOGuaranteeEntryBasePostDto basePostDto = new DMOGuaranteeEntryBasePostDto();
		basePostDto.setGuaranteeList(postDtos);
		when(entryConverter.toEntity(dto)).thenReturn(gurEntryEntity);
		when(dmoGuaranteeEntryRepository.save(gurEntryEntity)).thenReturn(gurEntryEntity);
		when(entryConverter.toDTO(gurEntryEntity)).thenReturn(dto);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.GE_TRN_SCREEN);
		when(nssfLoanRepository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
				.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.GE_RREF_NO));
		dto.setReferenceDt(LocalDateTime.now());
		dto.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.GE_RREF_NO));
		DMOGuaranteeEntryBasePostDto basePostDtoResp = dmoGuaranteeEntryService
				.saveOrUpdateGuaranteeEntryReceived(basePostDto);
		assertTrue(basePostDtoResp.getGuaranteeList().get(0).getId() > 0);
	}
}

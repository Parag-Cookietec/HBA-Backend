package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.HashMap;
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
import gov.ifms.dmo.converter.DMOGRFCRFAccruedInterestConverter;
import gov.ifms.dmo.dto.DMOGRFCRFAccruedInterestPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFAccruedInterestEntity;
import gov.ifms.dmo.repository.DMOGRFCRFAccruedInterestRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMOGRFCRFAccruedInterestServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;

@TestInstance(Lifecycle.PER_METHOD)
class DMOGRFCRFAccruedInterestServiceTest {

	@InjectMocks
	DMOGRFCRFAccruedInterestServiceImpl accruedInterestServiceImpl;

	@Mock
	DMOGRFCRFAccruedInterestConverter accruedInterestConverter;

	@Mock
	DMONSSFLoanRepository nssfLoanRepository;

	@Mock
	DMOGRFCRFAccruedInterestPostDto dto;

	@Mock
	DMOGRFCRFAccruedInterestEntity accruedInterestEntity;

	@Mock
	DMOGRFCRFAccruedInterestRepository accruedInterestRepository;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test service GRF CRF Accrued Interest Received save success.")
	void save() throws CustomException {
		dto = new DMOGRFCRFAccruedInterestPostDto();
		dto.setId(JunitConstants.LONG_TYPE);
		accruedInterestEntity = new DMOGRFCRFAccruedInterestEntity();
		when(accruedInterestConverter.toEntity(dto)).thenReturn(accruedInterestEntity);
		when(accruedInterestRepository.save(accruedInterestEntity)).thenReturn(accruedInterestEntity);
		when(accruedInterestConverter.toDTO(accruedInterestEntity)).thenReturn(dto);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.RAMI_TRN_SCREEN);
		when(nssfLoanRepository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
				.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.RAMI_REF_NO));
		dto.setReferenceDt(LocalDateTime.now());
		dto.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.RAMI_REF_NO));
		DMOGRFCRFAccruedInterestPostDto respDto = accruedInterestServiceImpl
				.saveOrUpdateGRFCRFAccruedInterestReceived(dto);
		assertEquals(JunitConstants.LONG_TYPE, respDto.getId());
	}
}

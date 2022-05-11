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
import gov.ifms.dmo.converter.DMOGRFCRFInvestmentConverter;
import gov.ifms.dmo.dto.DMOGRFCRFInvestmentPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFInvestmentEntity;
import gov.ifms.dmo.repository.DMOGRFCRFInvestmentRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMOGRFCRFInvestmentServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;

@TestInstance(Lifecycle.PER_CLASS)
class DMOGRFCRFInvestmentServiceTest {

	@Mock
	DMOGRFCRFInvestmentRepository investmentRepository;

	@InjectMocks
	DMOGRFCRFInvestmentServiceImpl investmentServiceImpl;

	@Mock
	DMOGRFCRFInvestmentConverter investmentConverter;

	@Mock
	DMONSSFLoanRepository nssfLoanRepository;

	@Mock
	DMOGRFCRFInvestmentPostDto dto;

	@Mock
	DMOGRFCRFInvestmentEntity investmentEntity;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test service GRF CRF Investment save success.")
	void save() throws CustomException {
		dto = new DMOGRFCRFInvestmentPostDto();
		dto.setId(JunitConstants.LONG_TYPE);
		investmentEntity = new DMOGRFCRFInvestmentEntity();
		when(investmentConverter.toEntity(dto)).thenReturn(investmentEntity);
		when(investmentRepository.save(investmentEntity)).thenReturn(investmentEntity);
		when(investmentConverter.toDTO(investmentEntity)).thenReturn(dto);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.RAFI_TRN_SCREEN);
		when(nssfLoanRepository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
				.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.RAFI_REF_NO));
		dto.setReferenceDt(LocalDateTime.now());
		dto.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.RAFI_REF_NO));
		DMOGRFCRFInvestmentPostDto respDto = investmentServiceImpl.saveOrUpdateGRFCRFAdviceInvestmentReceived(dto);
		assertEquals(JunitConstants.LONG_TYPE, respDto.getId());
	}
}

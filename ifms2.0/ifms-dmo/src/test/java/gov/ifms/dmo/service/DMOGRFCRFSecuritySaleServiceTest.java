package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import gov.ifms.dmo.converter.DMOGRFCRFSecurityDtlConverter;
import gov.ifms.dmo.converter.DMOGRFCRFSecuritySaleConverter;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalePostDto;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalesBasePostDto;
import gov.ifms.dmo.entity.DMOGRFCRFSecurityDtlEntity;
import gov.ifms.dmo.entity.DMOGRFCRFSecuritySaleEntity;
import gov.ifms.dmo.repository.DMOGRFCRFSecurityDtlRespository;
import gov.ifms.dmo.repository.DMOGRFCRFSecuritySaleRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMOGRFCRFSecuritySaleServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;

@TestInstance(Lifecycle.PER_CLASS)
class DMOGRFCRFSecuritySaleServiceTest {

	@InjectMocks
	DMOGRFCRFSecuritySaleServiceImpl securitySaleService;

	@Mock
	DMOGRFCRFSecuritySaleRepository securitySaleRepository;

	@Mock
	DMOGRFCRFSecurityDtlRespository securityDtlRespository;

	@Mock
	DMOGRFCRFSecuritySaleConverter securitySaleConverter;

	@Mock
	DMOGRFCRFSecurityDtlConverter securityDtlConverter;

	@Mock
	DMONSSFLoanRepository nssfLoanRepository;

	@Mock
	DMOGRFCRFSecuritySalesBasePostDto dto;

	@Mock
	DMOGRFCRFSecuritySalePostDto salePostDto;

	@Mock
	DMOGRFCRFSecuritySaleEntity saleEntity;

	@Mock
	DMOGRFCRFSecurityDtlEntity dtlEntity;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test service GRF CRF Security Sales save success.")
	void save() throws CustomException {
		dto = new DMOGRFCRFSecuritySalesBasePostDto();
		salePostDto = new DMOGRFCRFSecuritySalePostDto();
		salePostDto.setId(JunitConstants.LONG_TYPE);
		List<DMOGRFCRFSecuritySalePostDto> salesSec = new ArrayList<DMOGRFCRFSecuritySalePostDto>();
		salesSec.add(salePostDto);
		dto.setSalesSec(salesSec);
		saleEntity = new DMOGRFCRFSecuritySaleEntity();
		dtlEntity = new DMOGRFCRFSecurityDtlEntity();
		List<DMOGRFCRFSecuritySalePostDto> secSalesList = dto.getSalesSec().stream().map(saleSecDto -> {
			when(securitySaleConverter.toEntity(saleSecDto)).thenReturn(saleEntity);
			when(securityDtlConverter.toEntity(saleSecDto)).thenReturn(dtlEntity);
			when(securitySaleRepository.save(saleEntity)).thenReturn(saleEntity);
			dtlEntity.setGrfCrfSecSaleId(saleEntity.getId());
			when(securityDtlRespository.save(dtlEntity)).thenReturn(dtlEntity);
			when(securitySaleConverter.toDTO(saleEntity)).thenReturn(saleSecDto);
			when(securityDtlConverter.toDTO(dtlEntity)).thenReturn(saleSecDto);
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.MLA_TRN_SCREEN);
			when(nssfLoanRepository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
					.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.MLA_REF_NO));
			saleSecDto.setReferenceDt(LocalDateTime.now());
			saleSecDto.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.MLA_REF_NO));
			return saleSecDto;
		}).collect(Collectors.toList());
		DMOGRFCRFSecuritySalesBasePostDto basePostDto = new DMOGRFCRFSecuritySalesBasePostDto();
		basePostDto.setSalesSec(secSalesList);
		DMOGRFCRFSecuritySalesBasePostDto respDto = securitySaleService.saveOrUpdateGRFCRFSecuritySaleReceived(dto);
		assertEquals(JunitConstants.LONG_TYPE, respDto.getSalesSec().get(0).getId());
	}
}

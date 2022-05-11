package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
import gov.ifms.dmo.converter.DMOGRFCRFIntimationConverter;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationSearchPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFIntimationEntity;
import gov.ifms.dmo.repository.DMOGRFCRFIntimationRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMOGRFCRFIntimationServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;

@TestInstance(Lifecycle.PER_METHOD)
class DMOGRFCRFIntimationServiceTest {

	@InjectMocks
	DMOGRFCRFIntimationServiceImpl intimationServiceImpl;

	@Mock
	DMOGRFCRFIntimationPostDto dto;

	@Mock
	DMOGRFCRFIntimationRepository intimationRepository;

	@Mock
	DMOGRFCRFIntimationEntity intimationEntity;

	@Mock
	DMOGRFCRFIntimationConverter intimationConverter;

	@Mock
	DMOGRFCRFIntimationSearchPostDto searchPostDto;

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
	@DisplayName("Test service Intimation save success.")
	void save() throws CustomException {
		dto = new DMOGRFCRFIntimationPostDto();
		dto.setIntimationNo(JunitConstants.STRING_TYPE);
		when(intimationRepository.findByIntimationNo(dto.getIntimationNo())).thenReturn(intimationEntity);
		if (Optional.of(intimationEntity).isPresent()) {
			when(intimationConverter.toEntity(dto)).thenReturn(intimationEntity);
			when(intimationRepository.save(intimationEntity)).thenReturn(intimationEntity);
			when(intimationConverter.toDTO(intimationEntity)).thenReturn(dto);
		}
		DMOGRFCRFIntimationPostDto postDtoResp = intimationServiceImpl.saveOrUpdateGRFCRFLoanIntimationReceived(dto);
		assertEquals(JunitConstants.STRING_TYPE, postDtoResp.getIntimationNo());
	}

	@Test
	@DisplayName("Test service Intimation save success.")
	void save_IntimationEmpty() throws CustomException {
		dto = new DMOGRFCRFIntimationPostDto();
		dto.setIntimationNo(JunitConstants.STRING_TYPE);
		intimationEntity = null;
		when(intimationRepository.findByIntimationNo(dto.getIntimationNo())).thenReturn(intimationEntity);
		if (!Optional.ofNullable(intimationEntity).isPresent()) {
			intimationEntity = new DMOGRFCRFIntimationEntity();
			when(intimationConverter.toEntity(dto)).thenReturn(intimationEntity);
			when(intimationRepository.save(intimationEntity)).thenReturn(intimationEntity);
			when(intimationConverter.toDTO(intimationEntity)).thenReturn(dto);
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.IPS_TRN_SCREEN);
			when(nssfLoanRepository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
					.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.IPS_REF_NO));
			dto.setReferenceDt(LocalDateTime.now());
			dto.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.IPS_REF_NO));
		}
		DMOGRFCRFIntimationPostDto postDtoResp = intimationServiceImpl.saveOrUpdateGRFCRFLoanIntimationReceived(dto);
		assertEquals(JunitConstants.STRING_TYPE, postDtoResp.getIntimationNo());
	}

	@Test
	@DisplayName("Test service Search by Intimation No Purchase or Sales")
	void testSearchIntimationPurchaseSale() throws CustomException {
		dto = new DMOGRFCRFIntimationPostDto();
		dto.setIntimationNo(JunitConstants.STRING_TYPE);
		searchPostDto = new DMOGRFCRFIntimationSearchPostDto();
		searchPostDto.setIntimationNo(JunitConstants.STRING_TYPE);
		intimationEntity = new DMOGRFCRFIntimationEntity();
		String intimationNo = searchPostDto.getIntimationNo();
		intimationEntity.setIntimationNo(intimationNo);
		when(intimationRepository.findByIntimationNo(intimationNo)).thenReturn(intimationEntity);
		if (Optional.of(intimationEntity).isPresent()) {
			when(intimationConverter.toDTO(intimationEntity)).thenReturn(dto);
		}
		DMOGRFCRFIntimationPostDto respIntimationPostDto = intimationServiceImpl
				.searchIntimationPurchaseSales(searchPostDto);
		assertEquals(JunitConstants.STRING_TYPE, respIntimationPostDto.getIntimationNo());
	}
	
	@Test
	@DisplayName("Test getTillDtProgPrinContri()")
	void testGetTillDtProgPrinContri() throws CustomException {
		intimationEntity = new DMOGRFCRFIntimationEntity();
		intimationEntity.setTillDtProgPncpl(new Double(100.00));
		when(intimationRepository.findOneByActiveStatusOrderByIdDesc()).thenReturn(intimationEntity);
		Map<String, Double>  map = intimationServiceImpl.getTillDtProgPrinContri();
		assertEquals(map.get("progPriContriTillDt"), new Double(100.00));
	}
}

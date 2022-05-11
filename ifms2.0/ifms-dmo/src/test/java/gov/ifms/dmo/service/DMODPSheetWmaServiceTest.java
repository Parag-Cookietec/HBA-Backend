package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
import gov.ifms.dmo.converter.DMODPSheetWMAAdvanceConverter;
import gov.ifms.dmo.converter.DMODPSheetWMAInterestConverter;
import gov.ifms.dmo.converter.DMODPSheetWMAPrincipalConverter;
import gov.ifms.dmo.dto.DMODPSheetWMAPostDTO;
import gov.ifms.dmo.entity.DMODPSheetWMAAdvanceEntity;
import gov.ifms.dmo.entity.DMODPSheetWMAInterestEntity;
import gov.ifms.dmo.entity.DMODPSheetWMAPrincipalEntity;
import gov.ifms.dmo.repository.DMODPSheetWMAAdvanceRepository;
import gov.ifms.dmo.repository.DMODPSheetWMAInterestRepository;
import gov.ifms.dmo.repository.DMODPSheetWMAPrincipalRepository;
import gov.ifms.dmo.service.impl.DMODPSheetWmaServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
class DMODPSheetWmaServiceTest {

	@InjectMocks
	private DMODPSheetWmaServiceImpl wmaServiceImpl;
	@Mock
	private DMODPSheetWMAAdvanceRepository wmaAdvanceRepository;
	@Mock
	private DMODPSheetWMAInterestRepository wmaInterestRepository;
	@Mock
	private DMODPSheetWMAPrincipalRepository wmaPrincipalRepository;
	@Mock
	private DMODPSheetWMAAdvanceConverter wmaAdvanceConverter;
	@Mock
	private DMODPSheetWMAPrincipalConverter wmaPrincipalConverter;
	@Mock
	private DMODPSheetWMAInterestConverter wmaInterestConverter;
	@Mock
	private DMODPSheetWMAPostDTO wmaPostDTO;
	@Mock
	private DMODPSheetWMAAdvanceEntity wmaAdvanceEntity;
	@Mock
	private DMODPSheetWMAInterestEntity wmaInterestEntity;
	@Mock
	private DMODPSheetWMAPrincipalEntity wmaPrincipalEntity;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test saveDpSheetWmaAdv() ")
	void testSaveDpSheetWmaAdv() throws CustomException {
		wmaPostDTO = new DMODPSheetWMAPostDTO();
		wmaPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		wmaAdvanceEntity = new DMODPSheetWMAAdvanceEntity();
		when(wmaAdvanceConverter.toEntity(wmaPostDTO)).thenReturn(wmaAdvanceEntity);
		when(wmaAdvanceRepository.save(wmaAdvanceEntity)).thenReturn(wmaAdvanceEntity);
		when(wmaAdvanceConverter.toDTO(wmaAdvanceEntity)).thenReturn(wmaPostDTO);
		DMODPSheetWMAPostDTO dto = wmaServiceImpl.saveDpSheetWmaAdv(wmaPostDTO);
		assertEquals(JunitConstants.LONG_TYPE, dto.getDpSheetDtlId());
	}

	@Test
	@DisplayName("Test saveDpSheetWmaInterest() ")
	void testSaveDpSheetWmaInterest() throws CustomException {
		wmaPostDTO = new DMODPSheetWMAPostDTO();
		wmaPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		wmaInterestEntity = new DMODPSheetWMAInterestEntity();
		when(wmaInterestConverter.toEntity(wmaPostDTO)).thenReturn(wmaInterestEntity);
		when(wmaInterestRepository.save(wmaInterestEntity)).thenReturn(wmaInterestEntity);
		when(wmaInterestConverter.toDTO(wmaInterestEntity)).thenReturn(wmaPostDTO);
		DMODPSheetWMAPostDTO dto = wmaServiceImpl.saveDpSheetWmaInterest(wmaPostDTO);
		assertEquals(JunitConstants.LONG_TYPE, dto.getDpSheetDtlId());
	}

	@Test
	@DisplayName("Test saveDpSheetWmaPrincipal() ")
	void testSaveDpSheetWmaPrincipal() throws CustomException {
		wmaPostDTO = new DMODPSheetWMAPostDTO();
		wmaPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		wmaPrincipalEntity = new DMODPSheetWMAPrincipalEntity();
		when(wmaPrincipalConverter.toEntity(wmaPostDTO)).thenReturn(wmaPrincipalEntity);
		when(wmaPrincipalRepository.save(wmaPrincipalEntity)).thenReturn(wmaPrincipalEntity);
		when(wmaPrincipalConverter.toDTO(wmaPrincipalEntity)).thenReturn(wmaPostDTO);
		DMODPSheetWMAPostDTO dto = wmaServiceImpl.saveDpSheetWmaPrincipal(wmaPostDTO);
		assertEquals(JunitConstants.LONG_TYPE, dto.getDpSheetDtlId());
	}
}

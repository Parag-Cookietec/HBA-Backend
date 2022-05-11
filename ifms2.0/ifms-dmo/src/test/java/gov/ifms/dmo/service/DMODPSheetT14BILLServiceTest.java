package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import gov.ifms.dmo.converter.DMODPSheetT14BILLInvestConverter;
import gov.ifms.dmo.converter.DMODPSheetT14BILLMatureConverter;
import gov.ifms.dmo.converter.DMODPSheetT14BILLReDiscConverter;
import gov.ifms.dmo.dto.DMODPSheetT14BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT14BILLInvestEntity;
import gov.ifms.dmo.entity.DMODPSheetT14BILLMatureEntity;
import gov.ifms.dmo.entity.DMODPSheetT14BILLRediscEntity;
import gov.ifms.dmo.repository.DMODPSheetT14BILLInvestRepository;
import gov.ifms.dmo.repository.DMODPSheetT14BILLMatureRepository;
import gov.ifms.dmo.repository.DMODPSheetT14BILLRediscRepository;
import gov.ifms.dmo.service.impl.DMODPSheetT14BILLServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
class DMODPSheetT14BILLServiceTest {

	@InjectMocks
	DMODPSheetT14BILLServiceImpl sheetT14BILLService;

	@Mock
	private DMODPSheetT14BILLInvestConverter t14BillinvestConverter;

	@Mock
	private DMODPSheetT14BILLMatureConverter t14BillMatureConverter;

	@Mock
	private DMODPSheetT14BILLReDiscConverter t14BillRediscConverter;

	@Mock
	private DMODPSheetT14BILLInvestRepository t14billInvestRepository;

	@Mock
	private DMODPSheetT14BILLMatureRepository t14billMatureRepository;

	@Mock
	private DMODPSheetT14BILLRediscRepository t14billRediscRepository;

	@Mock
	private DMODPSheetT14BILLInvestPostDTO t14billInvestPostDTO;
	@Mock
	private DMODPSheetT14BILLInvestEntity t14billInvestEntity;
	@Mock
	private DMODPSheetT14BILLMatureEntity t14billMatureEntity;
	@Mock
	private DMODPSheetT14BILLRediscEntity t14billRediscEntity;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test saveDpSheetT14BILLInvest() ")
	void testSaveDpSheetT14BILLInvest_S() throws CustomException {
		t14billInvestPostDTO = new DMODPSheetT14BILLInvestPostDTO();
		t14billInvestPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		t14billInvestEntity = new DMODPSheetT14BILLInvestEntity();
		when(t14BillinvestConverter.toEntity(t14billInvestPostDTO)).thenReturn(t14billInvestEntity);
		when(t14billInvestRepository.save(t14billInvestEntity)).thenReturn(t14billInvestEntity);
		when(t14BillinvestConverter.toDTO(t14billInvestEntity)).thenReturn(t14billInvestPostDTO);
		DMODPSheetT14BILLInvestPostDTO dto = sheetT14BILLService.saveDpSheetT14BILLInvest(t14billInvestPostDTO);
		assertEquals(JunitConstants.LONG_TYPE, dto.getDpSheetDtlId());
	}

	@Test
	@DisplayName("Test saveDpSheetT14BILLMaturity() ")
	void testSaveDpSheetT14BILLMaturity() throws CustomException {
		t14billInvestPostDTO = new DMODPSheetT14BILLInvestPostDTO();
		t14billInvestPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		List<DMODPSheetT14BILLInvestPostDTO> listInvestPostDTOs = new ArrayList<DMODPSheetT14BILLInvestPostDTO>();
		listInvestPostDTOs.add(t14billInvestPostDTO);
		t14billInvestPostDTO.setData(listInvestPostDTOs);
		t14billMatureEntity = new DMODPSheetT14BILLMatureEntity();
		List<DMODPSheetT14BILLMatureEntity> t14billMatureEntities = new ArrayList<DMODPSheetT14BILLMatureEntity>();
		t14billMatureEntities.add(t14billMatureEntity);
		when(t14BillMatureConverter.toEntity(t14billInvestPostDTO.getData())).thenReturn(t14billMatureEntities);
		when(t14billMatureRepository.saveAll(t14billMatureEntities)).thenReturn(t14billMatureEntities);
		when(t14BillMatureConverter.toDTO(t14billMatureEntities)).thenReturn(listInvestPostDTOs);
		DMODPSheetT14BILLInvestPostDTO dto = sheetT14BILLService.saveDpSheetT14BILLMaturity(t14billInvestPostDTO);
		assertNotNull(dto);
	}

	@Test
	@DisplayName("Test saveDpSheetT14BILLReDiscount() ")
	void testSaveDpSheetT14BILLReDiscount() throws CustomException {
		t14billInvestPostDTO = new DMODPSheetT14BILLInvestPostDTO();
		t14billInvestPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		List<DMODPSheetT14BILLInvestPostDTO> listInvestPostDTOs = new ArrayList<DMODPSheetT14BILLInvestPostDTO>();
		listInvestPostDTOs.add(t14billInvestPostDTO);
		t14billInvestPostDTO.setData(listInvestPostDTOs);
		t14billRediscEntity = new DMODPSheetT14BILLRediscEntity();
		List<DMODPSheetT14BILLRediscEntity> t14billRediscEntities = new ArrayList<DMODPSheetT14BILLRediscEntity>();
		t14billRediscEntities.add(t14billRediscEntity);
		when(t14BillRediscConverter.toEntity(t14billInvestPostDTO.getData())).thenReturn(t14billRediscEntities);
		when(t14billRediscRepository.saveAll(t14billRediscEntities)).thenReturn(t14billRediscEntities);
		when(t14BillRediscConverter.toDTO(t14billRediscEntities)).thenReturn(listInvestPostDTOs);
		DMODPSheetT14BILLInvestPostDTO dto = sheetT14BILLService.saveDpSheetT14BILLReDiscount(t14billInvestPostDTO);
		assertNotNull(dto);
	}
}

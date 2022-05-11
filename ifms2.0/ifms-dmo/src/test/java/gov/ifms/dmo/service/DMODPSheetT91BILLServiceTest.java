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
import gov.ifms.dmo.converter.DMODPSheetT91BILLInvestConverter;
import gov.ifms.dmo.converter.DMODPSheetT91BILLMatureConverter;
import gov.ifms.dmo.converter.DMODPSheetT91BILLRediscConverter;
import gov.ifms.dmo.dto.DMODPSheetT91BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT91BILLInvestEntity;
import gov.ifms.dmo.entity.DMODPSheetT91BILLMatureEntity;
import gov.ifms.dmo.entity.DMODPSheetT91BILLRediscEntity;
import gov.ifms.dmo.repository.DMODPSheetT91BILLInvestRepository;
import gov.ifms.dmo.repository.DMODPSheetT91BILLMatureRepository;
import gov.ifms.dmo.repository.DMODPSheetT91BILLRediscRepository;
import gov.ifms.dmo.service.impl.DMODPSheetT91BILLServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
class DMODPSheetT91BILLServiceTest {

	@InjectMocks
	private DMODPSheetT91BILLServiceImpl t91billServiceImpl;

	@Mock
	private DMODPSheetT91BILLInvestConverter t91InvestConverter;

	@Mock
	private DMODPSheetT91BILLMatureConverter t91MatureConverter;

	@Mock
	private DMODPSheetT91BILLRediscConverter t91RediscConverter;

	@Mock
	private DMODPSheetT91BILLInvestRepository t91InvestRepository;

	@Mock
	private DMODPSheetT91BILLMatureRepository t91MatureRepository;

	@Mock
	private DMODPSheetT91BILLRediscRepository t91RediscRepository;

	@Mock
	private DMODPSheetT91BILLInvestPostDTO t91billInvestPostDTO;
	@Mock
	private DMODPSheetT91BILLInvestEntity t91billInvestEntity;
	@Mock
	private DMODPSheetT91BILLMatureEntity t91billMatureEntity;
	@Mock
	private DMODPSheetT91BILLRediscEntity t91billRediscEntity;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test saveDpSheetT91BILLInvest() ")
	void testSaveDpSheetT91BILLInvest() throws CustomException {
		t91billInvestPostDTO = new DMODPSheetT91BILLInvestPostDTO();
		t91billInvestPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		t91billInvestEntity = new DMODPSheetT91BILLInvestEntity();
		when(t91InvestConverter.toEntity(t91billInvestPostDTO)).thenReturn(t91billInvestEntity);
		when(t91InvestRepository.save(t91billInvestEntity)).thenReturn(t91billInvestEntity);
		when(t91InvestConverter.toDTO(t91billInvestEntity)).thenReturn(t91billInvestPostDTO);
		DMODPSheetT91BILLInvestPostDTO dto = t91billServiceImpl.saveDpSheetT91BILLInvest(t91billInvestPostDTO);
		assertEquals(JunitConstants.LONG_TYPE, dto.getDpSheetDtlId());
	}

	@Test
	@DisplayName("Test saveDpSheetT91BILLMaturity() ")
	void testSaveDpSheetT91BILLMaturity() throws CustomException {
		t91billInvestPostDTO = new DMODPSheetT91BILLInvestPostDTO();
		t91billInvestPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		List<DMODPSheetT91BILLInvestPostDTO> listInvestPostDTOs = new ArrayList<DMODPSheetT91BILLInvestPostDTO>();
		listInvestPostDTOs.add(t91billInvestPostDTO);
		t91billInvestPostDTO.setData(listInvestPostDTOs);
		t91billMatureEntity = new DMODPSheetT91BILLMatureEntity();
		List<DMODPSheetT91BILLMatureEntity> t14billMatureEntities = new ArrayList<DMODPSheetT91BILLMatureEntity>();
		t14billMatureEntities.add(t91billMatureEntity);
		when(t91MatureConverter.toEntity(t91billInvestPostDTO.getData())).thenReturn(t14billMatureEntities);
		when(t91MatureRepository.saveAll(t14billMatureEntities)).thenReturn(t14billMatureEntities);
		when(t91MatureConverter.toDTO(t14billMatureEntities)).thenReturn(listInvestPostDTOs);
		DMODPSheetT91BILLInvestPostDTO dto = t91billServiceImpl.saveDpSheetT91BILLMaturity(t91billInvestPostDTO);
		assertNotNull(dto);
	}

	@Test
	@DisplayName("Test saveDpSheetT91BILLReDisc() ")
	void testSaveDpSheetT91BILLReDisc() throws CustomException {
		t91billInvestPostDTO = new DMODPSheetT91BILLInvestPostDTO();
		t91billInvestPostDTO.setDpSheetDtlId(JunitConstants.LONG_TYPE);
		List<DMODPSheetT91BILLInvestPostDTO> listInvestPostDTOs = new ArrayList<DMODPSheetT91BILLInvestPostDTO>();
		listInvestPostDTOs.add(t91billInvestPostDTO);
		t91billInvestPostDTO.setData(listInvestPostDTOs);
		t91billRediscEntity = new DMODPSheetT91BILLRediscEntity();
		List<DMODPSheetT91BILLRediscEntity> t91billRediscEntities = new ArrayList<DMODPSheetT91BILLRediscEntity>();
		t91billRediscEntities.add(t91billRediscEntity);
		when(t91RediscConverter.toEntity(t91billInvestPostDTO.getData())).thenReturn(t91billRediscEntities);
		when(t91RediscRepository.saveAll(t91billRediscEntities)).thenReturn(t91billRediscEntities);
		when(t91RediscConverter.toDTO(t91billRediscEntities)).thenReturn(listInvestPostDTOs);
		DMODPSheetT91BILLInvestPostDTO dto = t91billServiceImpl.saveDpSheetT91BILLReDisc(t91billInvestPostDTO);
		assertNotNull(dto);
	}
}

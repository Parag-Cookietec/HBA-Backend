package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.converter.DMODPSheetEntryConverter;
import gov.ifms.dmo.converter.DMODPSheetEntryHDRConverter;
import gov.ifms.dmo.dto.DMODPSheetEntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDRPostDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMODPSheetHDREntity;
import gov.ifms.dmo.repository.DMODPSheetEntryHRDRepository;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.service.impl.DMODPSheetServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;

@TestInstance(Lifecycle.PER_CLASS)
class DMODPSheetServiceTest {

	@InjectMocks
	private DMODPSheetServiceImpl dmodpSheetServiceImpl;
	@Mock
	private DMODPSheetEntryHRDRepository dpSheetEntryHRDRepository;

	@Mock
	private DMODPSheetEntryRepository dpSheetEntryRepository;

	@Mock
	private DMODPSheetEntryHDRConverter hrdConverter;

	@Mock
	private DMODPSheetEntryConverter entityConverter;

	@Mock
	private DMODPSheetHDRPostDto dto;

	@Mock
	private DMODPSheetHDREntryPostDto responseDto;

	@Mock
	private DMODPSheetEntryPostDto dpSheetEntryDto;

	@Mock
	private IdDto idDto;

	@Mock
	private DMODPSheetHDREntity hdrEntity;

	@Mock
	private DMODPSheetEntryEntity dmodpSheetEntryEntity;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test getDPSheetByCodeAndDateAndRcvdDt(D).")
	void testGetDPSheetByCodeAndDateAndRcvdDt() throws CustomException {
		dpSheetEntryDto = new DMODPSheetEntryPostDto();
		dto = new DMODPSheetHDRPostDto();
		dto.setGogCode(JunitConstants.INTEGER_TYPE);
		hdrEntity = new DMODPSheetHDREntity();
		Optional<DMODPSheetHDREntity> hdrEntityOptional = Optional.ofNullable(hdrEntity);
		when(dpSheetEntryHRDRepository.findByGogCodeAndDpSheetDate(dto.getDpSheetDate(), dto.getGogCode(),
				DMOConstant.IS_ACTIVE_STATUS)).thenReturn(hdrEntityOptional);
		when(hrdConverter.toDTO(hdrEntityOptional.get())).thenReturn(responseDto);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.RAFI_TRN_SCREEN);
		Object[] objArr = { dpSheetEntryDto };
		List<Object[]> responseList = new ArrayList<Object[]>();
		responseList.add(objArr);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.SP_DP_SHEET_GET_DTL));
		when(dpSheetEntryHRDRepository.callStoredProcedure(procName, argMap)).thenReturn(responseList);
		PagebleDTO<DMODPSheetHDREntryPostDto> respDto = dmodpSheetServiceImpl.getDPSheetByCodeAndDateAndRcvdDt(dto);
		assertNotNull(respDto);
	}

	@Test
	@DisplayName("Test testGetLatestDPSheet().")
	void testGetLatestDPSheet_S() throws CustomException {
		hdrEntity = new DMODPSheetHDREntity();
		hdrEntity.setGogCode(JunitConstants.INTEGER_TYPE);
		Optional<DMODPSheetHDREntity> hdrEntityOptional = Optional.ofNullable(hdrEntity);
		when(dpSheetEntryHRDRepository.findOneByOrderByIdDesc()).thenReturn(hdrEntityOptional);
		DMODPSheetHDREntryPostDto respDto = dmodpSheetServiceImpl.getLatestDPSheet();
		assertEquals(1, respDto.getGogCode());

	}

	@Test
	@DisplayName("Test testGetLatestDPSheet().")
	void testGetLatestDPSheet_F() throws CustomException {
		hdrEntity = new DMODPSheetHDREntity();
		hdrEntity.setGogCode(JunitConstants.INTEGER_TYPE);
		Optional<DMODPSheetHDREntity> hdrEntityOptional = Optional.ofNullable(null);
		when(dpSheetEntryHRDRepository.findOneByOrderByIdDesc()).thenReturn(hdrEntityOptional);
		DMODPSheetHDREntryPostDto respDto = dmodpSheetServiceImpl.getLatestDPSheet();
		assertNull(respDto);

	}

	@Test
	@DisplayName("Test deleteDpSheetDtl(D).")
	void testDeleteDpSheetDtl_S() throws CustomException {
		idDto = new IdDto();
		idDto.setId(JunitConstants.LONG_TYPE);
		dmodpSheetEntryEntity = new DMODPSheetEntryEntity();
		dmodpSheetEntryEntity.setActiveStatus(0);
		Optional<DMODPSheetEntryEntity> entryOptional = Optional.ofNullable(dmodpSheetEntryEntity);
		when(dpSheetEntryRepository.findById(idDto.getId())).thenReturn(entryOptional);
		when(dpSheetEntryRepository.save(dmodpSheetEntryEntity)).thenReturn(dmodpSheetEntryEntity);
		Object respDto = dmodpSheetServiceImpl.deleteDpSheetDtl(idDto);
		assertEquals("Successfull Delete.", respDto);

	}

	@Test
	@DisplayName("Test deleteDpSheetDtl(D).")
	void testDeleteDpSheetDtl_F() throws CustomException {
		idDto = new IdDto();
		idDto.setId(JunitConstants.LONG_TYPE);
		dmodpSheetEntryEntity = null;
		Optional<DMODPSheetEntryEntity> entryOptional = Optional.ofNullable(dmodpSheetEntryEntity);
		when(dpSheetEntryRepository.findById(idDto.getId())).thenReturn(entryOptional);
		when(dpSheetEntryRepository.save(dmodpSheetEntryEntity)).thenReturn(dmodpSheetEntryEntity);
		Object respDto = dmodpSheetServiceImpl.deleteDpSheetDtl(idDto);
		assertEquals("Failed to delete record.", respDto);

	}

	@Test
	@DisplayName("Test saveAsDraftDPSheet(D).")
	void testSaveAsDraftDPSheet_S() throws CustomException {
		responseDto = new DMODPSheetHDREntryPostDto();
		responseDto.setDpSheetId(JunitConstants.LONG_TYPE);
		dpSheetEntryDto = new DMODPSheetEntryPostDto();
		List<DMODPSheetEntryPostDto> listEntryPostDtos = new ArrayList<DMODPSheetEntryPostDto>();
		listEntryPostDtos.add(dpSheetEntryDto);
		responseDto.setDpSheetDtos(listEntryPostDtos);
		hdrEntity = new DMODPSheetHDREntity();
		dmodpSheetEntryEntity = new DMODPSheetEntryEntity();
		dmodpSheetEntryEntity.setActiveStatus(1);
		Optional<DMODPSheetHDREntity> hdrEntityOptional = Optional.ofNullable(hdrEntity);
		when(dpSheetEntryHRDRepository.findById(responseDto.getDpSheetId())).thenReturn(hdrEntityOptional);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.DPS_TRN_SCREEN);
		when(dpSheetEntryHRDRepository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
				.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.DPS_REF_NO));
		hdrEntity.setRefNo(JunitConstants.generateTrnNo(JunitConstants.DPS_REF_NO));
		Optional<DMODPSheetEntryEntity> entryEntityOptional = Optional.ofNullable(dmodpSheetEntryEntity);
		when(dpSheetEntryRepository.findById(dpSheetEntryDto.getDpSheetDtlId())).thenReturn(entryEntityOptional);
		when(entityConverter.toEntity(dpSheetEntryDto)).thenReturn(entryEntityOptional.get());
		when(dpSheetEntryHRDRepository.save(hdrEntity)).thenReturn(hdrEntity);
		when(hrdConverter.toDTO(hdrEntity)).thenReturn(responseDto);
		List<DMODPSheetEntryPostDto> entryEntitiesDtos = new ArrayList<DMODPSheetEntryPostDto>();
		entryEntitiesDtos.add(dpSheetEntryDto);
		when(entityConverter.toDTO(hdrEntity.getEntities())).thenReturn(entryEntitiesDtos);
		DMODPSheetHDREntryPostDto respDto = dmodpSheetServiceImpl.saveAsDraftDPSheet(responseDto);
		assertEquals(JunitConstants.LONG_TYPE, respDto.getDpSheetId());

	}

	@Test
	@DisplayName("Test saveAsDraftDPSheet(D).")
	void testSaveAsDraftDPSheet_F() throws CustomException {
		responseDto = new DMODPSheetHDREntryPostDto();
		responseDto.setDpSheetId(JunitConstants.LONG_TYPE);
		dpSheetEntryDto = new DMODPSheetEntryPostDto();
		List<DMODPSheetEntryPostDto> listEntryPostDtos = new ArrayList<DMODPSheetEntryPostDto>();
		listEntryPostDtos.add(dpSheetEntryDto);
		responseDto.setDpSheetDtos(listEntryPostDtos);
		hdrEntity = new DMODPSheetHDREntity();
		dmodpSheetEntryEntity = new DMODPSheetEntryEntity();
		dmodpSheetEntryEntity.setActiveStatus(1);
		Optional<DMODPSheetHDREntity> hdrEntityOptional = Optional.ofNullable(null);
		when(dpSheetEntryHRDRepository.findById(responseDto.getDpSheetId())).thenReturn(hdrEntityOptional);
		DMODPSheetHDREntryPostDto respDto = dmodpSheetServiceImpl.saveAsDraftDPSheet(responseDto);
		assertEquals(JunitConstants.LONG_TYPE, respDto.getDpSheetId());

	}
}

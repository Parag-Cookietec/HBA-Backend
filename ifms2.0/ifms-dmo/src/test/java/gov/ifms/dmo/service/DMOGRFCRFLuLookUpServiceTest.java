package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.service.impl.DMOGRFCRFLuLookUpServiceImpl;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPLuLookUpRepository;

@TestInstance(Lifecycle.PER_CLASS)
class DMOGRFCRFLuLookUpServiceTest {

	@InjectMocks
	DMOGRFCRFLuLookUpServiceImpl lookUpService;

	@Mock
	EDPLuLookUpRepository edpLuLookUpRepository;

	@Mock
	EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Mock
	DMOLookUpDto lookUpDto;

	@Mock
	EDPLuLookUpEntity edpLuLookUpEntity;

	@Mock
	EDPLuLookUpInfoEntity lookUpInfoEntity;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test service Fetch Look Up Data.")
	void testFetchLookUpData() throws CustomException {
		edpLuLookUpEntity = new EDPLuLookUpEntity();
		edpLuLookUpEntity.setLookUpId(JunitConstants.LONG_TYPE);
		lookUpInfoEntity = new EDPLuLookUpInfoEntity();
		List<EDPLuLookUpInfoEntity> infoEntities = new ArrayList<EDPLuLookUpInfoEntity>();
		lookUpDto = new DMOLookUpDto();
		lookUpDto.setId(JunitConstants.LONG_TYPE);
		lookUpDto.setName(JunitConstants.STRING_TYPE);
		lookUpInfoEntity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		lookUpInfoEntity.setLookUpInfoName(JunitConstants.STRING_TYPE);
		infoEntities.add(lookUpInfoEntity);
		when(edpLuLookUpRepository.findByLookUpName(lookUpDto.getName())).thenReturn(edpLuLookUpEntity);
		if (Optional.of(edpLuLookUpEntity).isPresent()) {
			when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(
					edpLuLookUpEntity.getLookUpId(), JunitConstants.INTEGER_TYPE)).thenReturn(infoEntities);
		}
		List<DMOLookUpDto> dmoLookUpDtos = lookUpService.fetchLookUpData(lookUpDto);
		assertTrue(dmoLookUpDtos.size() > 0);
	}

	@Test
	@DisplayName("Test service Fetch Look Up Empty Data.")
	void testFetchLookUpData_empty() throws CustomException {
		lookUpInfoEntity = new EDPLuLookUpInfoEntity();
		List<EDPLuLookUpInfoEntity> infoEntities = new ArrayList<EDPLuLookUpInfoEntity>();
		lookUpInfoEntity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		lookUpInfoEntity.setLookUpInfoName(JunitConstants.STRING_TYPE);
		infoEntities.add(lookUpInfoEntity);
		when(edpLuLookUpRepository.findByLookUpName(JunitConstants.STRING_TYPE)).thenReturn(edpLuLookUpEntity);
		edpLuLookUpEntity = null;
		if (!Optional.ofNullable(edpLuLookUpEntity).isPresent()) {
			List<DMOLookUpDto> dmoLookUpDtos = lookUpService.fetchLookUpData(lookUpDto);
			assertTrue(dmoLookUpDtos.isEmpty());
		}
	}
}

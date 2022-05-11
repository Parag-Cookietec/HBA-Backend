package gov.ifms.edp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsHeaderEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsHeaderRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class EDPUserPostMappingWfConditionServiceImplTest {

	@InjectMocks
	private EDPWfConditionServiceImpl service;
	
	@Mock
	private EDPUsrPoTrnsHeaderEntity poTransHeaderEntity;
	
	@Mock
	private EDPLuLookUpInfoRepository lookupInfoRepository;

	@Mock
	private EDPUsrPoTrnsHeaderRepository edpUsrPoTrnsHeaderRepository;

	@Mock
	private EDPMsUserPostMappingService edpMsUserPostMappingService;

	@Mock
	EDPLuLookUpInfoEntity lookupEntity;
	
	@Mock
	EDPLkPoOffUserEntity lkPoOffUserEntity;

	@Mock
	EDPMsOfficeEntity officeEntity;
	
	@Mock
	EDPLkPostOfficeEntity lkPostOfficeEntity;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetPostMappingCondition() {
		/**
		 * ConditionDto conditionDto = new ConditionDto();
		 * conditionDto.setTrnId(JunitConstants.LONG_TYPE);
		 * when(edpMsUserPostMappingService.getByHeaderId(Mockito.anyLong())).thenReturn
		 * (poTransHeaderEntity); when(lookupInfoRepository.
		 * findByLookUpInfoNameAndEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.
		 * anyString(), Mockito.anyString(),
		 * Mockito.anyInt())).thenReturn(lookupEntity);
		 * when(poTransHeaderEntity.getInitiatedBy()).thenReturn(lkPoOffUserEntity);
		 * when(lkPoOffUserEntity.getLkPostOfficeId()).thenReturn(lkPostOfficeEntity);
		 * when(lkPostOfficeEntity.getOfficeEntity()).thenReturn(officeEntity);
		 * assertNotNull(service.getPostMappingCondition(conditionDto));
		 * 
		 * when(officeEntity.getOfficeSubType()).thenReturn(null);
		 * assertNotNull(service.getPostMappingCondition(conditionDto));
		 * 
		 * when(officeEntity.getOfficeDivision()).thenReturn(JunitConstants.STRING_DAT);
		 * assertNotNull(service.getPostMappingCondition(conditionDto));
		 */		
	}
}

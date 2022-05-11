package gov.ifms.edp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class EDPWorkflowAliasServiceImplTest {

	@InjectMocks
	private EDPWorkflowAliasServiceImpl service;
	
	@Mock
	private EDPMsOfficeRepository officeRepository;

	@Mock
	private EDPLuLookUpInfoRepository lookupInfoRepository;

	@Mock
	private EDPMsOfficeEntity officeEntity;
	
	@Mock
	private EDPMsDistrictEntity districtEntity;

	@Mock
	EDPLuLookUpInfoEntity toEntity;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetOfficeDetailsByAlias() {
/**		when(officeRepository.findByOfficeIdAndActiveStatus(Mockito.anyLong(),Mockito.anyInt())).thenReturn(officeEntity);
		when(officeEntity.getDistrictId()).thenReturn(districtEntity);
		when(districtEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookupInfoRepository.findByLookUpInfoNameAndEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt())).thenReturn(toEntity);
		when(toEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);		
		when(officeRepository.findByDistrictIdDistrictIdAndOfficeSubTypeAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt())).thenReturn(officeEntity);
		assertNotNull(service.getOfficeDetailsByAlias( JunitConstants.STRING_TO_PAO_ALIAS, JunitConstants.LONG_TYPE));

		when(officeRepository.findByOfficeDivisionAndActiveStatus(Mockito.anyString(),Mockito.anyInt())).thenReturn(officeEntity);
		assertNotNull(service.getOfficeDetailsByAlias( JunitConstants.STRING_DAT_ALIAS, JunitConstants.LONG_TYPE));
*/
	}
}

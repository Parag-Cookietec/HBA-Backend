package gov.ifms.loc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dto.ConditionDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.service.EDPMsOfficeService;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.entity.LocAccountCloseReqHdrEntity;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.repository.LocAccountCloseReqHdrRepository;
import gov.ifms.loc.repository.LocAccountOpenReqHdrRepository;
import gov.ifms.loc.serviceimpl.LocWfConditionServiceImpl;

/**
 * The Class LocWfConditionServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class LocWfConditionServiceImplTest {

	/** The service. */
	@InjectMocks
	private LocWfConditionServiceImpl service;

	/** The condition dto. */
	@Mock
	private ConditionDto conditionDto;

	/** The lc hdr. */
	@Mock
	private LocAccountOpenReqHdrEntity lcHdr;

	/** The ms office service. */
	@Mock
	private EDPMsOfficeService msOfficeService;

	/** The office dto. */
	@Mock
	private EDPMsOfficeDto officeDto;

	/** The hdr repo. */
	@Mock
	private LocAccountOpenReqHdrRepository hdrRepo;

	/** The office entity. */
	@Mock
	private EDPMsOfficeEntity officeEntity;

	/** The close hdr entity. */
	@Mock
	private LocAccountCloseReqHdrEntity closeHdrEntity;

	/** The close hdr repo. */
	@Mock
	private LocAccountCloseReqHdrRepository closeHdrRepo;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get loc open req condition.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetLocOpenReqCondition() throws CustomException {
		List<String> listString = new ArrayList<String>();
		listString.add("IS_PARENT_CO");
		when(conditionDto.getCondition()).thenReturn(listString);
		when(hdrRepo.getOne(conditionDto.getTrnId())).thenReturn(lcHdr);
		when(msOfficeService.getParentOffice(Mockito.anyLong())).thenReturn(officeDto);
		when(officeDto.getIsCo()).thenReturn(2l);
		when(officeDto.getIsHod()).thenReturn(1l);
		when(lcHdr.getOfficeNameId()).thenReturn(officeEntity);
		when(officeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(conditionDto.getDefaultCondition()).thenReturn(JunitConstants.STRING_ABC);
		assertNotNull(service.getLocOpenReqCondition(conditionDto));
	}

	/**
	 * Test get loc close req condition.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetLocCloseReqCondition() throws CustomException {
		List<String> listString = new ArrayList<String>();
		listString.add("DIVISONCHECK");
		when(conditionDto.getCondition()).thenReturn(listString);
		when(closeHdrRepo.getOne(conditionDto.getTrnId())).thenReturn(closeHdrEntity);
		when(closeHdrRepo.getDivId(Mockito.anyLong())).thenReturn(JunitConstants.LONG_TYPE);

		when(msOfficeService.getParentOffice(Mockito.anyLong())).thenReturn(officeDto);
		when(officeDto.getIsCo()).thenReturn(2l);
		when(officeDto.getIsHod()).thenReturn(2l);
		when(closeHdrEntity.getOfficeId()).thenReturn(officeEntity);
		when(officeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(conditionDto.getDefaultCondition()).thenReturn(JunitConstants.STRING_ABC);
		when(closeHdrRepo.checkDivChqActiveInactive(Mockito.anyLong())).thenReturn(null);
		when(closeHdrRepo.checkDivDistribution(Mockito.anyLong())).thenReturn(null);
		when(closeHdrRepo.checkDivAdvicePrep(Mockito.anyLong())).thenReturn(null);
		assertNotNull(service.getLocCloseReqCondition(conditionDto));
	}
}

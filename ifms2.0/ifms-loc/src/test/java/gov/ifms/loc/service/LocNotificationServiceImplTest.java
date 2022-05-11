package gov.ifms.loc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.notification.LocNotificationFacade;
import gov.ifms.loc.notification.LocNotificationServiceImpl;
import gov.ifms.loc.notification.NotificationPostDTO;
import gov.ifms.loc.repository.LocAccountOpeningReqHdrRepository;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.workflow.repository.LocWfActionConfigRepository;

/**
 * The Class LocAccountOpenReqServiceImplTest.
 */

@TestInstance(Lifecycle.PER_CLASS)
class LocNotificationServiceImplTest {

	/** The service. */
	@InjectMocks
	private LocNotificationServiceImpl serviceImpl;

	/** The hdr repo. */
	@Mock
	private LocAccountOpeningReqHdrRepository hdrRepo;

	/** The Notification Facade. */
	@Mock
	LocNotificationFacade locNotificationFacade;

	/** The wf action Config repo. */
	@Mock
	private LocWfActionConfigRepository wfActionConfigRepo;

	/** The NotificationPost dto. */
	@Mock
	NotificationPostDTO notificationDto;

	/** The submit dto. */
	@Mock
	LocSubmitWfDto submitdDto;

	@Mock
	List<Long> pouIds;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Gets the Creators in assign to office.
	 *
	 * @param assign to officeId,assigntowf roleId
	 * @return pou id
	 */
	@Test
	void testGetPouIdByWfRoleIdOffId() {
		List<Long> list = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L));
		when(hdrRepo.getUSersByWfRoleOfficeId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE)).thenReturn(list);
		assertNotNull(serviceImpl.getPouIdByWfRoleIdOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE));
	}

	/**
	 * Gets All the users in particular transaction.
	 *
	 * @param trnId,menuID
	 * @return pou id
	 * @throws CustomException
	 */
	@Test
	void testGetAllUsersonTransaction() throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("trnId", JunitConstants.LONG_TYPE);
		List<Object> list = new ArrayList<>();
		Object[] object = new Object[3];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getSingleListOfObject(JunitConstants.STRING_TYPE, map)).thenReturn(list);
		map.put("menuId", JunitConstants.LONG_TYPE);
		when(hdrRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(serviceImpl.getAllUsersonTransaction(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE));
	}

	/**
	 * @param submitWfDto
	 * @throws CustomException
	 */
	@Test
	void testSendNotification() throws CustomException {
		when(notificationDto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(notificationDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(notificationDto.getEventCategory()).thenReturn(JunitConstants.STRING_ABC);
		when(notificationDto.getPouId()).thenReturn(JunitConstants.LONG_TYPE_ZER);
		when(notificationDto.getExpiredDate()).thenReturn(JunitConstants.DATE);
		when(notificationDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(notificationDto.getCreatedBy()).thenReturn(JunitConstants.LONG_TYPE);
		when(notificationDto.getBranchId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfActionConfigRepo.getWfAction(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(JunitConstants.STRING_ABC);
		when(notificationDto.getEventName()).thenReturn(JunitConstants.STRING_ABC);
		when(submitdDto.getWfActionId()).thenReturn(LocConstant.APPROVED_ACTION);
		Map<String, Object> map = new HashMap<>();
		map.put("trnId", JunitConstants.LONG_TYPE);
		List<Object> list1 = new ArrayList<>();
		Object[] object = new Object[3];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getSingleListOfObject(JunitConstants.STRING_TYPE, map)).thenReturn(list1);
		map.put("menuId", JunitConstants.LONG_TYPE);
		when(hdrRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		List<Long> list = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L));
		when(serviceImpl.getPouIdByWfRoleIdOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE)).thenReturn(list);
		when(submitdDto.getTrnStatus()).thenReturn(LocConstant.AUTHORIZED);
		assertNotNull(serviceImpl.getAllUsersonTransaction(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE));
		pouIds = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L));
		when(notificationDto.getAssignToPOUId()).thenReturn(JunitConstants.STRING_ABC);
		when(locNotificationFacade.notificationRestAPI(notificationDto)).thenReturn(Boolean.TRUE);
		when(submitdDto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(submitdDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(submitdDto.getAssignToOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(submitdDto.getAssignToWfRoleId()).thenReturn(JunitConstants.LONG_TYPE);
		serviceImpl.sendNotification(submitdDto);

	}

}

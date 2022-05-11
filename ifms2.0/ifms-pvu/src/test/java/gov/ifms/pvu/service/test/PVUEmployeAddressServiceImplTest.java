package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.service.EDPMsUserService;
import gov.ifms.pvu.dto.PVUEmployeAddressDto;
import gov.ifms.pvu.dto.PVUEmployeEventView;
import gov.ifms.pvu.entity.PVUEmployeAddressEntity;
import gov.ifms.pvu.repository.PVUEmployeAddressRepository;
import gov.ifms.pvu.service.PVUEmployeAddressServiceImpl;

class PVUEmployeAddressServiceImplTest {

	@InjectMocks
	private PVUEmployeAddressServiceImpl service;

	@Mock
	private PVUEmployeAddressRepository repository;

	@Mock
	private PVUEmployeAddressEntity entity;
	
	@Mock
	private EDPMsUserService edpMsUserService;

	@Mock
	private PVUEmployeAddressDto dto;
	
	private OAuthUtility oAuthUtility;
	
	@SuppressWarnings("static-access")
	Long CurrentUserUserId() {
		return oAuthUtility.getCurrentUserUserId();

	}
	

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetEmployeAddress() {
		when(repository.getOne(1L)).thenReturn(entity);
		assertNotNull(service.getEmployeAddress(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateEmployeAddress() {
		when(repository.save(entity)).thenReturn(entity);

		assertNotNull(service.saveOrUpdateEmployeAddress(entity));
		verify(repository, times(1)).save(entity);

	}

	@Test
	void testGetEmployeAddresss() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("empNo", "1"));
		jsonArr.add(new SearchParam("empName", "V"));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("officeId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("transNo", " "));
		jsonArr.add(new SearchParam("workflowId", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		IdDto d = new IdDto();
		List<IdDto> lst = new ArrayList<IdDto>();
		d.setId(1l);
		lst.add(d);
		CurrentUserUserId();
		when(edpMsUserService.getDependentUerIdByUserId(1l)).thenReturn(lst);
		assertNotNull(service.getEmployeAddresss(pageDetail));

	}

	@Test
	void testStoreProcPvu() throws CustomException {
		assertNotNull(service.storeProcPvu("PVU_EMPLOYEE_SEARCH_WF_LISTING", new HashMap<>()));
	}

	@Test
	void testGetAllEmployeEvents() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", ""));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("eventsId", ""));
		jsonArr.add(new SearchParam("designationId", ""));
		jsonArr.add(new SearchParam("gpfNo", ""));
		jsonArr.add(new SearchParam("pPan", ""));
		jsonArr.add(new SearchParam("retirementDate", ""));
		jsonArr.add(new SearchParam("empNo", ""));
		jsonArr.add(new SearchParam("empName", ""));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("classId", " "));
		jsonArr.add(new SearchParam("officeId", ""));
		jsonArr.add(new SearchParam("empType", ""));
		jsonArr.add(new SearchParam("statusId", " "));
		jsonArr.add(new SearchParam("workflowId", ""));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		IdDto d = new IdDto();
		List<IdDto> lst = new ArrayList<IdDto>();
		d.setId(1l);
		lst.add(d);
		CurrentUserUserId();
		when(edpMsUserService.getDependentUerIdByUserId(1l)).thenReturn(lst);
		PagebleDTO<PVUEmployeEventView> data = service.getAllEmployeEvents(pageDetail);
		assertNotNull(data);
	}

}
package gov.ifms.workflow.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gov.ifms.common.util.EncryptDecryptUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.workflow.converter.PvuTrnEmpCrWfConverter;
import gov.ifms.workflow.dto.PvuTrnEmpCrWfDto;
import gov.ifms.workflow.entity.PvuTrnEmpCrWfEntity;
import gov.ifms.workflow.repository.PvuTrnEmpCrWfRepository;
import gov.ifms.workflow.repository.WfRepository;
import gov.ifms.workflow.util.WorkFlowConstant;

@TestInstance(Lifecycle.PER_CLASS)
class PvuTrnEmpCrWfServiceImplTest {

	@InjectMocks
	private PvuTrnEmpCrWfServiceImpl service;

	@Mock
	private PvuTrnEmpCrWfRepository repository;

	@Mock
	private WfRepository wfRepo;

	@Mock
	private PvuTrnEmpCrWfConverter converter;

	@Mock
	EncryptDecryptUtil securityUtil;

	@Mock
	private List<PvuTrnEmpCrWfEntity> entity;

	@Mock
	private PvuTrnEmpCrWfEntity singleEntity;

	@Mock
	private Page<PvuTrnEmpCrWfEntity> pageDetail;
	@Mock
	private PageDetails pageDetails;
	@Mock
	private Specification<PvuTrnEmpCrWfEntity> empSpec;
	@Mock
	private PageRequest pageable;
	@Mock
	private SearchCriteria searchCriteria;

	@Mock
	private SpecificationImpl<PvuTrnEmpCrWfEntity> spec;

	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	PagebleDTO<PvuTrnEmpCrWfDto> pageDto;
	
	@Mock
	PvuTrnEmpCrWfDto pvuTrnEmpCrWfDto;

	@Mock
	List<PvuTrnEmpCrWfDto> pvuTrnEmpCrWfDtos;

	@Test
	void testGetTrnEdpWfs() {
		when(repository.findAll()).thenReturn(entity);
		assertNotNull(service.getTrnEdpWfs());
		verify(repository, times(1)).findAll();
	}

	@Test
	void testGetTrnEdpWf() {
		when(repository.getOne(1l)).thenReturn(singleEntity);
		assertNotNull(service.getTrnEdpWf(1l));
		verify(repository, times(1)).getOne(1l);
	}

	@Test
	void testSaveOrUpdateTrnEdpWf() {
		when(repository.save(singleEntity)).thenReturn(singleEntity);
		assertNotNull(service.saveOrUpdateTrnEdpWf(singleEntity));
		verify(repository, times(1)).save(singleEntity);
	}

	@Test
	void testDeleteTrnEdpWf() {
		service.deleteTrnEdpWf(1l);
		verify(repository, times(1)).deleteById(1l);
	}

	@Test
	void testSaveTrnEdpWf() {
		when(repository.saveAll(entity)).thenReturn(entity);
		assertNotNull(service.saveTrnEdpWf(entity));
		verify(repository, times(1)).saveAll(entity);
	}

	
	
	@SuppressWarnings("unchecked")
	@Test
	void testTrnEdpWfAsMethodNameSearch() {
		when(pageDetails.getPageDetails(pageDetails)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(WorkFlowConstant.STRING);
		searchParam.setValue(WorkFlowConstant.STRING);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetails.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetail(spec, list)).thenReturn(empSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class)))
				.thenReturn(pageDetail);
		when(pageDetail.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.trnEdpWfAsMethodNameSearch(pageDetails));
	}

	

	@Test
	void testSaveOrUpdateTrnEdpWfSp() {
		when(pvuTrnEmpCrWfDto.getTrnId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getCurrentWorkflowId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getWfActionId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToActionLevel()).thenReturn(0);
		when(pvuTrnEmpCrWfDto.getAssignToWfRoleId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToUserId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToPostId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToOfficeId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToPOUId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getTrnStatus()).thenReturn("Approve In Progress");
		when(pvuTrnEmpCrWfDto.getWfStatus()).thenReturn("Forward To Verifier");
		when(pvuTrnEmpCrWfDto.getRemarks()).thenReturn("Test Remarks");
		when(pvuTrnEmpCrWfDto.getAssignByPostId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByPostId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByActionLevel()).thenReturn(0);
		when(pvuTrnEmpCrWfDto.getAssignByWfRoleId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByPostId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByOfficeId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByPOUId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getMenuId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getEventId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByUserId()).thenReturn("MuAtEHdI4AY=");
		when(securityUtil.decrypt(pvuTrnEmpCrWfDto.getAssignByUserId())).thenReturn("1");
		assertNotNull(service.saveOrUpdateTrnEdpWfSp(pvuTrnEmpCrWfDto));

	}

	@Test
	void testSaveOrUpdateTrnEdpWfSpList() throws SQLException {
		List<PvuTrnEmpCrWfDto> lstPvuTrnEmpCrWfDtos = new ArrayList<>();
		when(pvuTrnEmpCrWfDto.getTrnId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getCurrentWorkflowId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getWfActionId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToActionLevel()).thenReturn(0);
		when(pvuTrnEmpCrWfDto.getAssignToWfRoleId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToUserId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToPostId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToOfficeId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignToPOUId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getTrnStatus()).thenReturn("Approve In Progress");
		when(pvuTrnEmpCrWfDto.getWfStatus()).thenReturn("Forward To Verifier");
		when(pvuTrnEmpCrWfDto.getRemarks()).thenReturn("Test Remarks");
		when(pvuTrnEmpCrWfDto.getAssignByPostId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByPostId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByActionLevel()).thenReturn(0);
		when(pvuTrnEmpCrWfDto.getAssignByWfRoleId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByPostId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByOfficeId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByPOUId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getMenuId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getEventId()).thenReturn(1l);
		when(pvuTrnEmpCrWfDto.getAssignByUserId()).thenReturn("MuAtEHdI4AY=");
		when(securityUtil.decrypt(pvuTrnEmpCrWfDto.getAssignByUserId())).thenReturn("1");
		lstPvuTrnEmpCrWfDtos.add(pvuTrnEmpCrWfDto);
		assertEquals(false, service.saveOrUpdateTrnEdpWfSpList(lstPvuTrnEmpCrWfDtos));
	}

	@Test
	void testGetCurrentUserPOUId() {
		when(pvuTrnEmpCrWfDto.getAssignByPostId()).thenReturn(1L);
		when(pvuTrnEmpCrWfDto.getAssignToPostId()).thenReturn(2l);
		when(pvuTrnEmpCrWfDto.getAssignByOfficeId()).thenReturn(1L);
		when(pvuTrnEmpCrWfDto.getAssignToOfficeId()).thenReturn(2l);
		when(pvuTrnEmpCrWfDto.getAssignByPOUId()).thenReturn(null);
		when(pvuTrnEmpCrWfDto.getAssignToPOUId()).thenReturn(null);
		assertNotNull(service.setPOUId(pvuTrnEmpCrWfDto));
		Object[] arrayObject = new Object[1];
		arrayObject[0] = 15L;
		when(wfRepo.executeNativeSQLQuerySingleResult(Mockito.anyString(),Mockito.anyMap())).thenReturn(arrayObject);
		service.getCurrentUserPOUId(pvuTrnEmpCrWfDto, Boolean.TRUE);
	}

	@Test
	void testSetPOUId() {
		when(pvuTrnEmpCrWfDto.getAssignByPOUId()).thenReturn(null);
		when(pvuTrnEmpCrWfDto.getAssignToPOUId()).thenReturn(null);
		assertNotNull(service.setPOUId(pvuTrnEmpCrWfDto));
		when(pvuTrnEmpCrWfDto.getAssignByPOUId()).thenReturn(14L);
		when(pvuTrnEmpCrWfDto.getAssignToPOUId()).thenReturn(20L);
		assertNotNull(service.setPOUId(pvuTrnEmpCrWfDto));
	}

}

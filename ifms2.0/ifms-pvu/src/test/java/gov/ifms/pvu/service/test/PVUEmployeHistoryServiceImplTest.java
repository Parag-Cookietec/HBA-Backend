package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.pvu.converter.PVUEmployeHistoryConverter;
import gov.ifms.pvu.dto.PVUEmployeHistoryDto;
import gov.ifms.pvu.entity.PVUEmployeHistoryEntity;
import gov.ifms.pvu.repository.PVUEmployeHistoryRepository;
import gov.ifms.pvu.service.PVUEmployeHistoryServiceImpl;

class PVUEmployeHistoryServiceImplTest {
	@InjectMocks
	private PVUEmployeHistoryServiceImpl  service;
	
	@Mock
	private PVUEmployeHistoryRepository repository;
	
	@Mock
	private PVUEmployeHistoryEntity entity;
	
	@Mock
	Page<PVUEmployeHistoryEntity> page;
	
	@Mock
	List<PVUEmployeHistoryEntity> lst;
	
	@Mock
	List<PVUEmployeHistoryDto> list;
	
	@Mock
	PVUEmployeHistoryConverter converter;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testGetEmployeHistorys() throws CustomException {
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
	        when(repository.findAll(Mockito.any(Specification.class),Mockito.any(PageRequest.class))).thenReturn(page);
	        when(page.getContent()).thenReturn(lst);
	        when(converter.toDTO(lst)).thenReturn(list);
	        PagebleDTO<PVUEmployeHistoryDto> data=service.getEmployeHistorys(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testDeleteStatus() {
		service.deleteStatus(1l, 1);
	}

	@Test
	void testGetEmployeHistory() {
		service.getEmployeHistory(1l);
	}

	@Test
	void testSaveOrUpdateEmployeHistory() {
		service.saveOrUpdateEmployeHistory(lst);
	}

}
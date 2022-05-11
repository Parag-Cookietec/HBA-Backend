package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.pvu.converter.PVUEmployeDeptExamDetailsConverter;
import gov.ifms.pvu.dto.PVUEmployeDeptExamDetailsDto;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.repository.PVUEmployeDeptExamDetailsRepository;
import gov.ifms.pvu.service.PVUEmployeDeptExamDetailsServiceImpl;


class PVUEmployeDeptExamDetailsServiceImplTest {
	@InjectMocks
	private PVUEmployeDeptExamDetailsServiceImpl service;

	@Mock
	private PVUEmployeDeptExamDetailsRepository repository;

	@Mock
	private PVUEmployeDeptExamDetailsEntity entity;

	@Mock
	private PVUEmployeDeptExamDetailsDto dto;

	@Mock
	private PVUEmployeDeptExamDetailsConverter converter;
	
	@Mock
	List<PVUEmployeDeptExamDetailsDto> dtoLst;
	
	@Mock
	List<PVUEmployeDeptExamDetailsEntity> entityLst;
	
	@Mock
	Page<PVUEmployeDeptExamDetailsEntity> page;
	
	@Mock
	List<PVUEmployeDeptExamDetailsEntity> lst;
	
	@Mock
	List<PVUEmployeDeptExamDetailsDto> list;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetEmployeDeptExamDetails() {
		when(repository.getOne(1L)).thenReturn(entity);
		assertNotNull(service.getEmployeDeptExamDetails(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateEmployeDeptExamDetails() {
		when(repository.save(entity)).thenReturn(entity);
		assertEquals(entity, service.saveOrUpdateEmployeDeptExamDetails(entity));
		verify(repository,times(1)).save(entity);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetEmployeDeptExamDetailss() throws CustomException {
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
		assertNotNull(service.getEmployeDeptExamDetailss(pageDetail));
	}

}

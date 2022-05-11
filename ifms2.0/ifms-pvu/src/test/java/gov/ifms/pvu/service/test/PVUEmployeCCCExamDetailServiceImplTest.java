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
import gov.ifms.pvu.converter.PVUEmployeCCCExamDetailConverter;
import gov.ifms.pvu.dto.PVUEmployeCCCExamDetailDto;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.service.PVUEmployeCCCExamDetailServiceImpl;

class PVUEmployeCCCExamDetailServiceImplTest {
	@InjectMocks
	private PVUEmployeCCCExamDetailServiceImpl service;

	@Mock
	private PVUEmployeCCCExamDetailRepository repository;

	@Mock
	private PVUEmployeCCCExamDetailEntity entity;

	@Mock
	private PVUEmployeCCCExamDetailDto dto;

	@Mock
	private PVUEmployeCCCExamDetailConverter converter;
	
	@Mock
	List<PVUEmployeCCCExamDetailDto> dtoLst;
	
	@Mock
	List<PVUEmployeCCCExamDetailEntity> entityLst;
	
	@Mock
	Page<PVUEmployeCCCExamDetailEntity> page;
	
	@Mock
	List<PVUEmployeCCCExamDetailEntity> lst;
	
	@Mock
	List<PVUEmployeCCCExamDetailDto> list;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetEmployeCCCExamDetail() {
		when(repository.getOne(1L)).thenReturn(entity);
		assertNotNull(service.getEmployeCCCExamDetail(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateEmployeCCCExamDetail() {
		when(repository.save(entity)).thenReturn(entity);
		assertEquals(entity, service.saveOrUpdateEmployeCCCExamDetail(entity));
		verify(repository,times(1)).save(entity);
	}


	@SuppressWarnings("unchecked")
	@Test
	void testGetEmployeCCCExamDetails() throws CustomException {
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
		assertNotNull(service.getEmployeCCCExamDetails(pageDetail));
	}
}

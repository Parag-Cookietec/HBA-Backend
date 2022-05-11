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
import gov.ifms.pvu.converter.PVUEmployeDeptAndHodConverter;
import gov.ifms.pvu.dto.PVUEmployeDeptAndHodDto;
import gov.ifms.pvu.entity.PVUEmployeDeptAndHodEntity;
import gov.ifms.pvu.repository.PVUEmployeDeptAndHodRepository;
import gov.ifms.pvu.service.PVUEmployeDeptAndHodServiceImpl;

class PVUEmployeDeptAndHodServiceImplTest {
	@InjectMocks
	private PVUEmployeDeptAndHodServiceImpl service;

	@Mock
	private PVUEmployeDeptAndHodRepository repository;

	@Mock
	private PVUEmployeDeptAndHodEntity entity;

	@Mock
	private PVUEmployeDeptAndHodDto dto;
	
	@Mock
	List<PVUEmployeDeptAndHodEntity> entityLst;
	
@Mock
List<PVUEmployeDeptAndHodDto> dtoLst;

	@Mock
	private PVUEmployeDeptAndHodConverter converter;
	
	@Mock
	Page<PVUEmployeDeptAndHodEntity> page;
	
	@Mock
	List<PVUEmployeDeptAndHodEntity> lst;
	
	@Mock
	List<PVUEmployeDeptAndHodDto> list;
	
	

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetEmployeDeptAndHod() {
		when(repository.findAllByDepartmentId(1l)).thenReturn(entityLst);
		assertNotNull(service.getEmployeDeptAndHod(1L));
		verify(repository, times(1)).findAllByDepartmentId(1L);
	}

	@Test
	void testSaveOrUpdateEmployeDeptAndHod() {
		when(repository.save(entity)).thenReturn(entity);
		assertEquals(entity, service.saveOrUpdateEmployeDeptAndHod(entity));
		verify(repository,times(1)).save(entity);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetEmployeDeptAndHods() throws CustomException {
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
		assertNotNull(service.getEmployeDeptAndHods(pageDetail));
	}

}

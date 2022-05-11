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

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.pvu.converter.PVUDepartmentCategoryConverter;
import gov.ifms.pvu.dto.PVUDepartmentCategoryDto;
import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;
import gov.ifms.pvu.repository.PVUDepartmentCategoryRepository;
import gov.ifms.pvu.service.PVUDepartmentCategoryServiceImpl;

class PVUDepartmentCategoryServiceImplTest {
	@Mock
	private PVUDepartmentCategoryRepository repository;

	@Mock
	private PVUDepartmentCategoryConverter converter;

	@Mock
	private PVUDepartmentCategoryEntity PVUDepartmentCategoryEntity;

	@Mock
	private PVUDepartmentCategoryDto dto;

	@InjectMocks
	private PVUDepartmentCategoryServiceImpl PVUDepartmentCategoryServiceImpl;
	
	@Mock
	private List<PVUDepartmentCategoryEntity> li;
	
	@Mock
	Page<PVUDepartmentCategoryEntity> page;

	@Mock
	List<PVUDepartmentCategoryEntity> lst;

	@Mock
	List<PVUDepartmentCategoryDto> list;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetDepartmentCategory() {
		when(repository.getOne(1l)).thenReturn(PVUDepartmentCategoryEntity);
		assertEquals(PVUDepartmentCategoryEntity, PVUDepartmentCategoryServiceImpl.getDepartmentCategory(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateDepartmentCategory() {
		when(repository.save(PVUDepartmentCategoryEntity)).thenReturn(PVUDepartmentCategoryEntity);
		assertNotNull(PVUDepartmentCategoryServiceImpl.saveOrUpdateDepartmentCategory(PVUDepartmentCategoryEntity));
		verify(repository,times(1)).save(PVUDepartmentCategoryEntity);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetDepartmentCategorys() throws CustomException {
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
	        PagebleDTO<PVUDepartmentCategoryDto> data=PVUDepartmentCategoryServiceImpl.getDepartmentCategorys(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testGetAllDepartmentCategory() {
		when(repository.findAll()).thenReturn(li);
	}

}
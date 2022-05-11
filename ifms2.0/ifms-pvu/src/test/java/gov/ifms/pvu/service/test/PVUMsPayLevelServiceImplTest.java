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
import gov.ifms.pvu.converter.PVUMsPayLevelConverter;
import gov.ifms.pvu.dto.PVUMsPayLevelDto;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.service.PVUMsPayLevelServiceImpl;

class PVUMsPayLevelServiceImplTest {
	@InjectMocks
	private PVUMsPayLevelServiceImpl service;

	@Mock
	private PVUMsPayLevelRepository repository;

	@Mock
	private PVUMsPayLevelEntity entity;

	@Mock
	private PVUMsPayLevelDto dto;

	@Mock
	private PVUMsPayLevelConverter converter;
	@Mock
	List<PVUMsPayLevelDto> dtoLst;
	
	@Mock
	List<PVUMsPayLevelEntity> entityLst;
	
	@Mock
	Page<PVUMsPayLevelEntity> page;
	

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetMsPayLevel() {
		when(repository.getOne(1L)).thenReturn(entity);
		assertNotNull(service.getMsPayLevel(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateMsPayLevel() {
		when(repository.save(entity)).thenReturn(entity);
		assertEquals(entity, service.saveOrUpdateMsPayLevel(entity));
		verify(repository,times(1)).save(entity);
	}


	@Test
	void testGetMsPayLevels() throws CustomException {
//	  SearchParam searchParam = new SearchParam();
//	  searchParam.setKey("key");
//	  searchParam.setValue("value");
	  List<SearchParam> jsonArr = new ArrayList<SearchParam>();
//	  jsonArr.add(searchParam);
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
        when(page.getContent()).thenReturn(entityLst);
        when(converter.toDTO(entityLst)).thenReturn(dtoLst);
        PagebleDTO<PVUMsPayLevelDto> data=service.getMsPayLevels(pageDetail);
		assertNotNull(data);
	
	}

}
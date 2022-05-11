package gov.ifms.pvu.service.test;

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
import gov.ifms.pvu.converter.PVUMsPayScaleConverter;
import gov.ifms.pvu.dto.PVUMsPayScaleDto;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.service.PVUMsPayScaleServiceImpl;

class PVUMsPayScaleServiceImplTest {
	@InjectMocks
	private PVUMsPayScaleServiceImpl  service;
	
	@Mock
	private PVUMsPayScaleRepository repository;
	
	@Mock
	private PVUMsPayScaleEntity entity;
	
	@Mock
	Page<PVUMsPayScaleEntity> page;
	
	@Mock
	List<PVUMsPayScaleEntity> lst;
	
	@Mock
	List<PVUMsPayScaleDto> list;
	
	@Mock
	PVUMsPayScaleConverter converter;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testGetMsPayScale() {
		when(repository.getOne(1L)).thenReturn(entity);
		service.getMsPayScale(1l);
		verify(repository,times(1)).getOne(1l);
	}

	@Test
	void testSaveOrUpdateMsPayScale() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsPayScale(entity));
		verify(repository,times(1)).save(entity);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetMsPayScales() throws CustomException {
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
	        PagebleDTO<PVUMsPayScaleDto> data=service.getMsPayScales(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testGetScaleValue() {
		when(repository.findAll()).thenReturn(lst);
		assertNotNull(service.getScaleValue());
	}

}
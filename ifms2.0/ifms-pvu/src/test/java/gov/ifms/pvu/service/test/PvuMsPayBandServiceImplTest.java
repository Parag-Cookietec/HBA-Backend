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
import gov.ifms.pvu.converter.PVUMsPayBandConverter;
import gov.ifms.pvu.dto.PVUMsPayBandDto;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import gov.ifms.pvu.service.PvuMsPayBandServiceImpl;

class PvuMsPayBandServiceImplTest {
	@InjectMocks
	private PvuMsPayBandServiceImpl  service;
	
	@Mock
	private PVUMsPayBandRepository repository;
	
	@Mock
	private PVUMsPayBandEntity entity;
	
	@Mock
	Page<PVUMsPayBandEntity> page;
	
	@Mock
	List<PVUMsPayBandEntity> lst;
	
	@Mock
	List<PVUMsPayBandDto> list;
	
	@Mock
	PVUMsPayBandConverter converter;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testGetPayBandById() {
		when(repository.getOne(1L)).thenReturn(entity);
		service.getPayBandById(1l);
		verify(repository,times(1)).getOne(1l);
	}

	@Test
	void testSaveOrUpdateMsPayBand() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsPayBand(entity));
		verify(repository,times(1)).save(entity);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetMsPayBands() throws CustomException {
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
        PagebleDTO<PVUMsPayBandDto> data=service.getMsPayBands(pageDetail);
	assertNotNull(data);
	}

}
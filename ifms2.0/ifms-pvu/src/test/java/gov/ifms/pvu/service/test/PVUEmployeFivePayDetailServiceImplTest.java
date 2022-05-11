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
import gov.ifms.pvu.converter.PVUEmployeFivePayDetailConverter;
import gov.ifms.pvu.dto.PVUEmployeFivePayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeFivePayDetailEntity;
import gov.ifms.pvu.repository.PVUEmployeFivePayDetailRepository;
import gov.ifms.pvu.service.PVUEmployeFivePayDetailServiceImpl;

class PVUEmployeFivePayDetailServiceImplTest {
	@InjectMocks
	PVUEmployeFivePayDetailServiceImpl pvuEmployeFivePayDetailServiceImpl;
	
	@Mock
	PVUEmployeFivePayDetailEntity pvuEmployeFivePayDetailEntity;
	
	@Mock
	PVUEmployeFivePayDetailRepository pvuEmployeFivePayDetailRepository;
	
	@Mock
	Page<PVUEmployeFivePayDetailEntity> page;
	
	@Mock
	List<PVUEmployeFivePayDetailEntity> lst;
	
	@Mock
	List<PVUEmployeFivePayDetailDto> list;
	
	@Mock
	PVUEmployeFivePayDetailConverter converter;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testGetPVUEmployeFivePayDetailEntity() {
		when(pvuEmployeFivePayDetailRepository.getOne(1l)).thenReturn(pvuEmployeFivePayDetailEntity);
		assertEquals(pvuEmployeFivePayDetailServiceImpl.getPVUEmployeFivePayDetailEntity(1l), pvuEmployeFivePayDetailEntity);
		verify(pvuEmployeFivePayDetailRepository,times(1)).getOne(1l);
	}

	@Test
	void testSaveOrUpdatePVUEmployeFivePayDetailEntity() {
		when(pvuEmployeFivePayDetailRepository.save(pvuEmployeFivePayDetailEntity)).thenReturn(pvuEmployeFivePayDetailEntity);
		assertEquals(pvuEmployeFivePayDetailServiceImpl.saveOrUpdatePVUEmployeFivePayDetailEntity(pvuEmployeFivePayDetailEntity), pvuEmployeFivePayDetailEntity);
		verify(pvuEmployeFivePayDetailRepository,times(1)).save(pvuEmployeFivePayDetailEntity);
	}

	@Test
	void testGetPVUEmployeFivePayDetailEntitys() throws CustomException {
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
	        when(pvuEmployeFivePayDetailRepository.findAll(Mockito.any(Specification.class),Mockito.any(PageRequest.class))).thenReturn(page);
	        when(page.getContent()).thenReturn(lst);
	        when(converter.toDTO(lst)).thenReturn(list);
	        PagebleDTO<PVUEmployeFivePayDetailDto> data=pvuEmployeFivePayDetailServiceImpl.getPVUEmployeFivePayDetailEntitys(pageDetail);
		assertNotNull(data);
	}

}

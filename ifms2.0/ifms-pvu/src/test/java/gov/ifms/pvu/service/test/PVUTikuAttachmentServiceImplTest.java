package gov.ifms.pvu.service.test;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.converter.PVUTikuAttachmentConverter;
import gov.ifms.pvu.dto.PVUTikuAttachmentDto;
import gov.ifms.pvu.entity.PVUTikuAttachmentEntity;
import gov.ifms.pvu.repository.PVUTikuAttachmentRepository;
import gov.ifms.pvu.service.PVUTikuAttachmentService;

class PVUTikuAttachmentServiceImplTest {
	@InjectMocks
	private PVUTikuAttachmentService service;
	
	@Mock
	private PVUTikuAttachmentRepository repository;
	
	@Mock
	private PVUTikuAttachmentEntity entity;
	
	@Mock
	Page<PVUTikuAttachmentEntity> page;
	
	@Mock
	List<PVUTikuAttachmentEntity> lst;
	
	@Mock
	List<PVUTikuAttachmentDto> list;
	
	@Mock
	PVUTikuAttachmentConverter converter;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testGetTikuAttachment() throws CustomException {
		when(repository.getOne(1L)).thenReturn(entity);
//		service.getTikuAttachment(1l);
		//verify(repository,times(1)).getOne(1l);
	}

	@Test
	void testSaveOrUpdateTikuAttachment() throws CustomException {
		when(repository.save(entity)).thenReturn(entity);
//		assertNotNull(service.saveOrUpdateTikuAttachment(entity));
		// verify(repository,times(1)).save(entity);
	}
/*
	@SuppressWarnings("unchecked")
	@Test
	void testGetTikuAttachments() throws CustomException {
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
//	        PagebleDTO<PVUTikuAttachmentDto> data=service.getTikuAttachments(pageDetail);
//		assertNotNull(data);
	}
*/
}

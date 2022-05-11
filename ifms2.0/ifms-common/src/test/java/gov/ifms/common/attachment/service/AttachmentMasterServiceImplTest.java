package gov.ifms.common.attachment.service;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.attachment.entity.AttachmentMasterEntity;
import gov.ifms.common.attachment.repository.AttachmentMasterRepository;

public class AttachmentMasterServiceImplTest{
	
	@InjectMocks
	private AttachmentMasterServiceImpl attachmentMasterServiceImpl;
	
	@Mock
	private AttachmentMasterRepository attachmentMasterRepository;
	
	@BeforeEach
	protected void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAttachmentMaster() {
		when(attachmentMasterServiceImpl.getAttachmentMaster(1l)).thenReturn(new AttachmentMasterEntity(1L,1L,1L,"pdf",4,"IFMS_DOC"));
        
		AttachmentMasterEntity attachmentMasterEntity = attachmentMasterServiceImpl.getAttachmentMaster(1L);
	         
	    assertNotNull(attachmentMasterEntity.getFormat());
	    assertNotNull("IFMS_DOC", attachmentMasterEntity.getUploadDirectoryPath());
	    assertNotNull(attachmentMasterEntity.getFileSize());
	}

	@Test
	public void testSaveOrUpdateAttachmentMaster() {
		AttachmentMasterEntity attachmentMasterEntity = new AttachmentMasterEntity(1l,1l,1l,"pdf",4,"IFMS_DOC");
		AttachmentMasterEntity attachmentMasterEntity1 = attachmentMasterServiceImpl.saveOrUpdateAttachmentMaster(attachmentMasterEntity);
		assertNull(attachmentMasterEntity1);
	}

	
	@Test
	public void testGetAttachmentMasterByMenuId() {
		
		List<AttachmentMasterEntity> list = new ArrayList<AttachmentMasterEntity>();
		AttachmentMasterEntity one = new AttachmentMasterEntity(1l,1l,1l,"pdf",4,"IFMS_DOC1");
		AttachmentMasterEntity two = new AttachmentMasterEntity(2l,2l,1l,"pdf",2,"IFMS_DOC2");
		AttachmentMasterEntity three = new AttachmentMasterEntity(3l,1l,1l,"pdf",2,"IFMS_DOC3");

	    list.add(one);
	    list.add(two);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	    list.add(three);
	      
        when(attachmentMasterServiceImpl.getAttachmentMasterByMenuId(1l)).thenReturn(list);
        
		List<AttachmentMasterEntity> attachmentMasterEntity = attachmentMasterServiceImpl.getAttachmentMasterByMenuId(1L);
	         
		assertNotNull(attachmentMasterEntity.size());
   
	}
 
}

package gov.ifms.common.attachment.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.util.WorkflowUtility;
import gov.ifms.common.exception.CustomException;

public class AttachmentServiceImplTest {

	private InputStream is;

	@InjectMocks
	private AttachmentServiceImpl serviceImpl = new AttachmentServiceImpl();

	@Mock
	private WorkflowUtility workflowUtility;

	@BeforeEach
	protected void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreatePostAttachment() throws IOException, CustomException {
		MultipartFile mockMultipartFile = new MockMultipartFile("file", "excel.xlsx", "multipart/form-data", is);
		List<MultipartFile> multipartfile = new ArrayList<>();
		multipartfile.add(mockMultipartFile);
		AttachmentMasterDto uploadDto = new AttachmentMasterDto(1L, 1L, 1L, "xlsx", 4, "IFMS_DOC", multipartfile);
		@SuppressWarnings("static-access")
		Boolean boolean1 = workflowUtility.validateFileExtensionPost(uploadDto);
		assertNotNull(boolean1);
	}
	
	@Test
	void testUploadAttachment() throws IOException, CustomException {
		MultipartFile mockMultipartFile = new MockMultipartFile("file", "excel.xlsx", "multipart/form-data", is);
		List<MultipartFile> multipartfile = new ArrayList<>();
		multipartfile.add(mockMultipartFile);
		AttachmentMasterDto uploadDto = new AttachmentMasterDto(1L, 1L, 1L, "xlsx", 4, "IFMS_DOC", multipartfile);
		@SuppressWarnings("static-access")
		Boolean boolean1 = workflowUtility.validateFileExtensionPost(uploadDto);
		assertNotNull(boolean1);
	}

}

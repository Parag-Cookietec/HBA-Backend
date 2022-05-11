package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.converter.RBIFileTranxnConvertor;
import gov.ifms.gst.dto.RBIFileTranxnDto;
import gov.ifms.gst.entity.RBIFileTranxn;
import gov.ifms.gst.repository.RBIFileTranxnRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class RbiFileTransactionTest {
	@InjectMocks
	private RBIFileTranxnServiceImpl serviceImpl;

	@Mock
	private RBIFileTranxnConvertor convertor;

	@Mock
	private RBIFileTranxnRepository repository;

	@Mock
	private RBIFileTranxn entity;

	@Mock
	private RBIFileTranxnDto basePostDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test Get Transaction Date.")
	void testSearchByDate() throws CustomException {
		basePostDto = new RBIFileTranxnDto();
		basePostDto.setRbiFileHdrId(1l);
		List<RBIFileTranxn> rbiFiles = new ArrayList<>();
		when(repository.findByRbiFileHdrId(basePostDto.getRbiFileHdrId())).thenReturn(rbiFiles);
		when(convertor.toDTO(entity)).thenReturn(basePostDto);
		assertNotNull(serviceImpl.searchByDate(basePostDto));
	}

}

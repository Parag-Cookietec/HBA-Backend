package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.dto.CommonDtos;
import gov.ifms.gst.entity.ChallanDistributionSADA;
import gov.ifms.gst.entity.FileAccountingProcessed;
import gov.ifms.gst.entity.GSTBlockCPIN;
import gov.ifms.gst.entity.GSTCPINStatus;
import gov.ifms.gst.entity.LoadBalancerAO;
import gov.ifms.gst.entity.LoadBalancerHA;
import gov.ifms.gst.entity.ScrollDistribute;
import gov.ifms.gst.repository.ChallanDistruSADARepository;
import gov.ifms.gst.repository.FileAccountingProcessedRepository;
import gov.ifms.gst.repository.GSTBlockCPINRepository;
import gov.ifms.gst.repository.GSTCPINStatusRepository;
import gov.ifms.gst.repository.LoadBalancerAORepository;
import gov.ifms.gst.repository.LoadBalancerHARepository;
import gov.ifms.gst.repository.ScrollDistributeRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class CommonUrlServiceTest {

	@InjectMocks
	private CommonServiceImpl serviceImpl;
	@Mock
	private CommonDtos commonDtos;
	@Mock
	private LoadBalancerHARepository repository;
	@Mock
	private LoadBalancerAORepository loadBalancerAORepository;
	@Mock
	private FileAccountingProcessedRepository processRepository;
	@Mock
	private GSTBlockCPINRepository blockCpinRepository;
	@Mock
	private GSTCPINStatusRepository getCpinStatusRepository;
	@Mock
	private ChallanDistruSADARepository challanDistributionRepository;
	@Mock
	private ScrollDistributeRepository scrollDistributionRepository;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test  Get All success.")
	void getTransactionNoForLBHA() throws CustomException {
		String nextSequenceNumber = "";
		String nextSequenceNumbers = null;
		commonDtos = new CommonDtos();
		commonDtos.setModuleName("LBHA");
		if (Objects.equals(commonDtos.getModuleName(), LoadBalancerHA.TRN_SCREEN_LBHA.toString())) {
			when(repository.findByReferenceNo()).thenReturn(nextSequenceNumbers);
			nextSequenceNumber = nextSequenceNumbers;
			getReferenceNo(nextSequenceNumber, commonDtos.getModuleName());
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
		assertNotNull(serviceImpl.getTransactionNo(commonDtos));
	}

	@Test
	@DisplayName("Test  Get All success.")
	void getTransactionNoBMS() throws CustomException {
		String nextSequenceNumber = "";
		commonDtos = new CommonDtos();
		commonDtos.setModuleName("GFAP");
		if (Objects.equals(commonDtos.getModuleName(), FileAccountingProcessed.TRN_SCREEN_BMS.toString())) {
			nextSequenceNumber = processRepository.findByReferenceNo();
			getReferenceNo(nextSequenceNumber, commonDtos.getModuleName());
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
		assertNotNull(serviceImpl.getTransactionNo(commonDtos));
	}

	@Test
	@DisplayName("Test  Get All success.")
	void getTransactionNoBCL() throws CustomException {
		String nextSequenceNumber = "";
		commonDtos = new CommonDtos();
		commonDtos.setModuleName("BCL");
		if (Objects.equals(commonDtos.getModuleName(), GSTBlockCPIN.TRN_SCREEN_GBC.toString())) {
			nextSequenceNumber = blockCpinRepository.findByReferenceNo();
			getReferenceNo(nextSequenceNumber, commonDtos.getModuleName());
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
		assertNotNull(serviceImpl.getTransactionNo(commonDtos));
	}

	@Test
	@DisplayName("Test  Get All success.")
	void getTransactionNoLBAO() throws CustomException {
		String nextSequenceNumber = "";
		commonDtos = new CommonDtos();
		commonDtos.setModuleName("LBAO");
		if (Objects.equals(commonDtos.getModuleName(), LoadBalancerAO.TRN_SCREEN_LBAO.toString())) {
			nextSequenceNumber = loadBalancerAORepository.findByReferenceNo();
			getReferenceNo(nextSequenceNumber, commonDtos.getModuleName());
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
		assertNotNull(serviceImpl.getTransactionNo(commonDtos));
	}

	@Test
	@DisplayName("Test  Get All success.")
	void getTransactionNoCDSA() throws CustomException {
		String nextSequenceNumber = "";
		commonDtos = new CommonDtos();
		commonDtos.setModuleName("CDSA");
		if (Objects.equals(commonDtos.getModuleName(), ChallanDistributionSADA.TRN_SCREEN_RASB.toString())) {
			nextSequenceNumber = challanDistributionRepository.findByReferenceNo();
			getReferenceNo(nextSequenceNumber, commonDtos.getModuleName());
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
		assertNotNull(serviceImpl.getTransactionNo(commonDtos));
	}

	@Test
	@DisplayName("Test  Get All success.")
	void getTransactionNoSD() throws CustomException {
		String nextSequenceNumber = "";
		commonDtos = new CommonDtos();
		commonDtos.setModuleName("SD");
		if (Objects.equals(commonDtos.getModuleName(), ScrollDistribute.TRN_SCREEN_LBAO.toString())) {
			nextSequenceNumber = scrollDistributionRepository.findByReferenceNo();
			getReferenceNo(nextSequenceNumber, commonDtos.getModuleName());
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
		assertNotNull(serviceImpl.getTransactionNo(commonDtos));
	}

	@Test
	@DisplayName("Test  Get All success.")
	void getTransactionNoGCS() throws CustomException {
		String nextSequenceNumber = "";
		commonDtos = new CommonDtos();
		commonDtos.setModuleName("GCS");
		if (Objects.equals(commonDtos.getModuleName(), GSTCPINStatus.TRN_SCREEN_CPIN_STATUS.toString())) {
			nextSequenceNumber = getCpinStatusRepository.findByReferenceNo();
			getReferenceNo(nextSequenceNumber, commonDtos.getModuleName());
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
		assertNotNull(serviceImpl.getTransactionNo(commonDtos));
	}

	private String getReferenceNo(String nextSequenceNumber, String moduleName) {
		if (nextSequenceNumber == null) {
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(Constant.TRN_SCREEN, moduleName);
			when(repository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
					.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.MML_REF_NO));
			nextSequenceNumber = (JunitConstants.generateTrnNo(JunitConstants.MML_REF_NO));
		} else {
			Integer val = Integer.valueOf(nextSequenceNumber.substring(nextSequenceNumber.length() - 6)) + 1;
			nextSequenceNumber = nextSequenceNumber.substring(0, nextSequenceNumber.length() - 6)
					+ String.format("%06d", val);
		}
		return nextSequenceNumber;
	}
}

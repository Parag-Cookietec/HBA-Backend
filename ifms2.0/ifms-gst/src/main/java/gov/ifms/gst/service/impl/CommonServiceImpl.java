package gov.ifms.gst.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.gst.dto.CommonDtos;
import gov.ifms.gst.entity.ChallanDistributionSADA;
import gov.ifms.gst.entity.FileAccountingProcessed;
import gov.ifms.gst.entity.GSTBankRateMaster;
import gov.ifms.gst.entity.GSTBlockCPIN;
import gov.ifms.gst.entity.GSTCPINStatus;
import gov.ifms.gst.entity.LoadBalancerAO;
import gov.ifms.gst.entity.LoadBalancerHA;
import gov.ifms.gst.entity.ScrollDistribute;
import gov.ifms.gst.repository.ChallanDistruSADARepository;
import gov.ifms.gst.repository.FileAccountingProcessedRepository;
import gov.ifms.gst.repository.GSTBankRateMasterRepository;
import gov.ifms.gst.repository.GSTBlockCPINRepository;
import gov.ifms.gst.repository.GSTCPINStatusRepository;
import gov.ifms.gst.repository.LoadBalancerAORepository;
import gov.ifms.gst.repository.LoadBalancerHARepository;
import gov.ifms.gst.repository.ScrollDistributeRepository;
import gov.ifms.gst.util.GSTConstant;

@Service
public class CommonServiceImpl {

	@Autowired
	private LoadBalancerHARepository repository;
	@Autowired
	private LoadBalancerAORepository loadBalancerAORepository;
	@Autowired
	private FileAccountingProcessedRepository processRepository;
	@Autowired
	private GSTBlockCPINRepository blockCpinRepository;
	@Autowired
	private GSTCPINStatusRepository getCpinStatusRepository;
	@Autowired
	private ChallanDistruSADARepository challanDistributionRepository;
	@Autowired
	private ScrollDistributeRepository scrollDistributionRepository;
	@Autowired
	private GSTBankRateMasterRepository bankRateMasterRepository;

	public String getTransactionNo(CommonDtos dto) throws CustomException {
		String nextSequenceNumber = "";
		if (Objects.equals(dto.getModuleName(), LoadBalancerHA.TRN_SCREEN_LBHA.toString())) {
			nextSequenceNumber = repository.findByReferenceNo();
			return getReferenceNo(nextSequenceNumber, dto.getModuleName());
		} else if (Objects.equals(dto.getModuleName(), FileAccountingProcessed.TRN_SCREEN_BMS.toString())) {
			nextSequenceNumber = processRepository.findByReferenceNo();
			return getReferenceNo(nextSequenceNumber, dto.getModuleName());
		} else if (Objects.equals(dto.getModuleName(), GSTBlockCPIN.TRN_SCREEN_GBC.toString())) {
			nextSequenceNumber = blockCpinRepository.findByReferenceNo();
			return getReferenceNo(nextSequenceNumber, dto.getModuleName());
		} else if (Objects.equals(dto.getModuleName(), LoadBalancerAO.TRN_SCREEN_LBAO.toString())) {
			nextSequenceNumber = loadBalancerAORepository.findByReferenceNo();
			return getReferenceNo(nextSequenceNumber, dto.getModuleName());
		} else if (Objects.equals(dto.getModuleName(), ChallanDistributionSADA.TRN_SCREEN_RASB.toString())) {
			nextSequenceNumber = challanDistributionRepository.findByReferenceNo();
			return getReferenceNo(nextSequenceNumber, dto.getModuleName());
		} else if (Objects.equals(dto.getModuleName(), ScrollDistribute.TRN_SCREEN_LBAO.toString())) {
			nextSequenceNumber = scrollDistributionRepository.findByReferenceNo();
			return getReferenceNo(nextSequenceNumber, dto.getModuleName());
		} else if (Objects.equals(dto.getModuleName(), GSTCPINStatus.TRN_SCREEN_CPIN_STATUS.toString())) {
			nextSequenceNumber = getCpinStatusRepository.findByReferenceNo();
			return getReferenceNo(nextSequenceNumber, dto.getModuleName());
		} else if (Objects.equals(dto.getModuleName(), GSTBankRateMaster.TRN_SCREEN_BMS.toString())) {
			nextSequenceNumber = getTransactionNumberForBankMaster();
			return getReferenceNo(nextSequenceNumber, dto.getModuleName());
		}		
		else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

	private String getReferenceNo(String nextSequenceNumber, String moduleName) {
		if (nextSequenceNumber == null) {
			try {
				nextSequenceNumber = readTransactionNo(moduleName);
			} catch (CustomException e) {
				e.printStackTrace();
			}
		} else {
			Integer val = Integer.valueOf(nextSequenceNumber.substring(nextSequenceNumber.length() - 6)) + 1;
			nextSequenceNumber = nextSequenceNumber.substring(0, nextSequenceNumber.length() - 6)
					+ String.format("%06d", val);

		}
		return nextSequenceNumber;
	}
	
	private String getTransactionNumberForBankMaster() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, GSTBankRateMaster.TRN_SCREEN_BMS);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = bankRateMasterRepository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

	private String readTransactionNo(String nextSequenceNumber2) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();

		map.put(Constant.TRN_SCREEN, nextSequenceNumber2);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

}

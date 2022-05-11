package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.converter.DMONSSFLoanConverter;
import gov.ifms.dmo.converter.DMONSSFLoanRePaymentConverter;
import gov.ifms.dmo.dto.DMODPDataDto;
import gov.ifms.dmo.dto.DMOGOIApprovedRepayDto;
import gov.ifms.dmo.dto.DMOGOILoanDataDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMONSSFLoanDto;
import gov.ifms.dmo.dto.DMONSSFLoanHDRRespDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.entity.DMONSSFLoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRePaymentRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMONSSFLoanService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDepartmentRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

/**
 * The Class DMONSSFLoanServiceImpl.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
@Service
public class DMONSSFLoanServiceImpl implements DMONSSFLoanService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMONSSFLoanRepository repository;

	@Autowired
	DMONSSFLoanRePaymentRepository loanRePaymentRepository;

	@Autowired
	DMONSSFLoanConverter converter;

	@Autowired
	DMODPSheetEntryRepository dpSheetRepository;

	@Autowired
	DMONSSFLoanRePaymentConverter repaymentConverter;

	@Autowired
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;

	@Autowired
	EntityManager entityManager;

	@Autowired
	EDPMsDepartmentRepository departmentServiceRepository;

	@Autowired
	EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;
	@Autowired
	DMONSSFLoanRePaymentServiceImpl loanRePaymentServiceImpl;

	/**
	 * Saves a given DMONSSFLoanEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved entity
	 * @throws CustomException
	 */
	@Override
	public DMONSSFLoanPostDto saveOrUpdateNSSFLoanReceived(DMONSSFLoanPostDto dto) throws CustomException {
		DMONSSFLoanEntity entity = converter.toEntity(dto);
		if (repository.findAllByAdviceNo(dto.getAdviceNo()).isPresent()) {
			throw new CustomException(401, "Advice No Is Already Present !!");
		}
		entity.setRefrenceNo(generateTrnNo(DMOConstant.NLR_TRN_SCREEN));
		entity.setRefrenceDate(LocalDateTime.now());
		entity.setLoanFinanceYearId(
				eDPMsFinancialYearRepository.findByFyStart(entity.getLoanReceiptDate().getYear()).getFinancialYearId());
		DMONSSFLoanPostDto loanPostDto = converter.toDTO(repository.save(entity));
		loanRePaymentServiceImpl.save(loanPostDto);
		return loanPostDto;
	}

	private String generateTrnNo(String menuCode) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, menuCode);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
		return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}

	@Override
	public DMONSSFLoanPostDto updateNSSFLoanReceived(DMONSSFLoanPostDto dto) throws CustomException {
		if (!repository.findById(dto.getId()).isPresent()) {
			throw new CustomException(401, "NSSF Is Not Present !!");
		}
		DMONSSFLoanEntity entity = converter.toEntity(dto);
		entity.setRepayments(repository.findById(dto.getId()).get().getRepayments());
		return converter.toDTO(repository.save(entity));
	}

	/**
	 * Retrieves an DMONSSFLoanEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMONSSFLoanEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMONSSFLoanPostDto getNSSFLoanReceived(Long id) {
		return converter.toDTO(repository.getOne(id));
	}

	/**
	 * Fetch all the NSSFLoanApprovedList items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */
	@Override
	public PagebleDTO<DMONSSFLoanHDRRespDto> getNSSFLoanApprovedList(SerachApprovedDto pageDetail)
			throws CustomException {
		try {
			String fromDate = (null != pageDetail.getFromDate()) ? String.valueOf(pageDetail.getFromDate()) : "";
			String toDate = (null != pageDetail.getToDate()) ? String.valueOf(pageDetail.getToDate()) : "";
			String advNo = pageDetail.getAdviceNo();
			Map<String, Object> spParamMap = new HashMap<>();
			spParamMap.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
			spParamMap.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageElement());
			spParamMap.put(DMOConstant.IN_FROM_DT, fromDate);
			spParamMap.put(DMOConstant.IN_TO_DT, toDate);
			spParamMap.put(DMOConstant.IN_ADV_NO, advNo);
			String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.SP_NSSF_LOAN_HDR));
			List<Object[]> responseList = repository.callStoredProcedure(procName, spParamMap);
			List<DMONSSFLoanHDRRespDto> list = NativeQueryResultsMapper.map(responseList, DMONSSFLoanHDRRespDto.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, list.isEmpty() ? 0 : list.get(0).getCount(), list);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(401, "Advice No Is Already Present !!");
		}
	}

	/**
	 * Retrieves all repayments
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMONSSFLoanEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMONSSFLoanDto getAllRepayments(SerachApprovedDto pageDetail) throws CustomException {
		if (!repository.findByAdviceNo(pageDetail.getAdviceNo()).isPresent()) {
			throw new CustomException(401, "Advice No Is Not Present !!");
		}
		DMONSSFLoanEntity entity = repository.findByAdviceNo(pageDetail.getAdviceNo()).get();
		DMONSSFLoanDto dto = repaymentConverter.toRePaymentDTO(entity);
		dto.setDtos(repaymentConverter.toRePaymentDTO(entity.getRepayments()));
		return dto;
	}

	@Override
	public DMOGOIApprovedRepayDto searchRepay(DMOGOISearchDto dto) throws CustomException {
		DMOGOIApprovedRepayDto dtos = new DMOGOIApprovedRepayDto();
		List<DMOGOILoanDataDto> dmogoiLoanDataDtos = new ArrayList<>();
		List<DMODPDataDto> dmodpDataDtos = new ArrayList<>();
		List<DMODPSheetEntryEntity> dpFiltered = new ArrayList<>();
		List<DMONSSFLoanRePaymentEntity> list = loanRePaymentRepository.findAllByAdviceDate(dto.getFromDate(),
				dto.getToDate());
		List<DMODPSheetEntryEntity> dp = dpSheetRepository.findAllByAndAdviceDate(dto.getFromDate(), dto.getToDate());
		if(CollectionUtils.isNotEmpty(dp)) {
			dpFiltered = dp.stream().filter(Objects::nonNull).filter(e -> Long.valueOf(17).equals(e.getTransactTypeId()) || Long.valueOf(18).equals(e.getTransactTypeId()))
					.collect(Collectors.toList());
		}
		Double totalPayIn = 0d;
		Double totalPayPri = 0d;
		Double totalPaidIn = 0d;
		Double totalPaidPri = 0d;
		for (DMONSSFLoanRePaymentEntity re : list) {
			if ((re.getInstallDueDate().isEqual(dto.getFromDate()) || re.getInstallDueDate().isAfter(dto.getFromDate()))
					&& re.getInstallDueDate().isBefore(dto.getToDate())) {
				DMOGOILoanDataDto dataDto = new DMOGOILoanDataDto();
				dataDto.setDueDate(re.getInstallDueDate());
				dataDto.setInterestRate(re.getNssfLoanId().getLoanROI());
				dataDto.setLoanAmount(re.getNssfLoanId().getLoanAmount());
				dataDto.setLoanOutstanding(re.getOutstandingAmount());
				if (re.getIsInstallPaid() == 1) {
					dataDto.setPaidInterest(re.getIntrestAmount());
					dataDto.setPaidPrincipal(re.getPrincipalAmount());
					totalPaidIn = totalPaidIn + dataDto.getPaidInterest();
					totalPaidPri = totalPaidPri + dataDto.getPaidPrincipal();
				}
				dataDto.setPayableInterest(re.getIntrestAmount());
				dataDto.setPayablePrincipal(re.getPrincipalAmount());
				dataDto.setId(re.getId());
				dataDto.setParentId(re.getNssfLoanId().getId());
				totalPayIn = totalPayIn + dataDto.getPayableInterest();
				totalPayPri = totalPayPri + dataDto.getPayablePrincipal();
				dmogoiLoanDataDtos.add(dataDto);
			}
		}
		for (DMODPSheetEntryEntity dpEn : dpFiltered) {
			DMODPDataDto dataDto = new DMODPDataDto();
			dataDto.setAdviceBy(dpEn.getAdviceBy());
			dataDto.setAdviceDate(dpEn.getAdviceDate());
			dataDto.setAdviceNo(dpEn.getAdviceNo());
			dataDto.setDebitAmt(dpEn.getDebitAmt());
			dataDto.setDpDate(dpEn.getAdviceDate());
			dataDto.setMemoNo(dpEn.getMemoNo());
			dataDto.setTransactionDesc(dpEn.getTransactionDesc());
			dataDto.setId(dpEn.getDpSheetDtlId());
			dmodpDataDtos.add(dataDto);
		}
		dtos.setSchemeTotalPayPri(totalPayPri);
		dtos.setTotalPayPri(totalPayPri);
		dtos.setGrandTotalPayPri(dtos.getSchemeTotalPayPri() + dtos.getTotalPayPri());
		dtos.setSchemeTotalPayInt(totalPayIn);
		dtos.setTotalPayInt(totalPayIn);
		dtos.setGrandTotalPayInt(dtos.getSchemeTotalPayInt() + dtos.getTotalPayInt());
		dtos.setSchemeTotalPaidPri(totalPaidPri);
		dtos.setTotalPaidPri(totalPaidPri);
		dtos.setGrandTotalPaidPri(dtos.getSchemeTotalPaidPri() + dtos.getTotalPaidPri());
		dtos.setSchemeTotalPaidInt(totalPaidIn);
		dtos.setTotalPaidInt(totalPaidIn);
		dtos.setGrandTotalPaidInt(dtos.getSchemeTotalPaidInt() + dtos.getTotalPaidInt());
		dtos.setDmodpDataDtos(dmodpDataDtos);
		dtos.setDmogoiLoanDataDtos(dmogoiLoanDataDtos);
		return dtos;
	}
}

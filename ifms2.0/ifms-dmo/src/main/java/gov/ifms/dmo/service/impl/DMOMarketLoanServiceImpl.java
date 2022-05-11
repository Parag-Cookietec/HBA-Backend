package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMOMarketLoanConverter;
import gov.ifms.dmo.converter.DMOMarketLoanRePaymentConverter;
import gov.ifms.dmo.dto.DMODPDataDto;
import gov.ifms.dmo.dto.DMOGOIApprovedRepayDto;
import gov.ifms.dmo.dto.DMOGOILoanDataDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.entity.DMOMarketLoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRePaymentRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.service.DMOMarketLoanService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

/**
 * The Class DMOMarketLoanServiceImpl.
 * 
 * @version v 1.0.
 * @created 2021/08/01 11:40:45.
 *
 */
@Service
public class DMOMarketLoanServiceImpl implements DMOMarketLoanService{

	
	@Autowired
	DMOMarketLoanRepository repository;

	@Autowired
	DMOMarketLoanRePaymentRepository loanRePaymentRepository;
	
	@Autowired
	DMOMarketLoanConverter converter;

	@Autowired
	DMOMarketLoanRePaymentConverter loanRePaymentConverter;
	@Autowired
	DMODPSheetEntryRepository dpSheetRepository;
	@Autowired
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;
	@Autowired
	DMOMarketLoanRePaymentServiceImpl loanRePaymentServiceImpl;
	
	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());
	
	
	/**
	 * Convert given DMOMarketLoanDto to DMOMarketLoanEntity
	 * Saves a given DMOMarketLoanEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved DMOMarketLoanEntity
	 * @throws CustomException 
	 */
	@Override
	public DMOMarketLoanDto saveOrUpdate(DMOMarketLoanDto dto) throws CustomException {
		if (repository.findAllByAdviceNo(dto.getAdviceNo()).isPresent()) {
			throw new CustomException(401, "Advice No Is Already Present !!");
		}
		DMOMarketLoanEntity entity  = converter.toEntity(dto);
		entity.setReferenceDt(LocalDateTime.now());
		entity.setReferenceNo(generateTrnNo(DMOConstant.MML_SCREEN));
		DMOMarketLoanDto loanPostDto =  converter.toDTO(repository.save(entity));
		List<DMOMarketLoanDto> list = loanRePaymentServiceImpl.save(loanPostDto);
		return list.get(0);
	}
	@Override
	public DMOMarketLoanDto updateMarketLoanReceived(DMOMarketLoanDto dto) throws CustomException {
		if (!repository.findById(dto.getId()).isPresent()) {
			throw new CustomException(401, "Market Is Not Present !!");
		}
		DMOMarketLoanEntity entity = converter.toEntity(dto);
		return converter.toDTO(repository.save(entity));
	}
	/**
	 * Retrieves an DMOMarketLoanEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMOMarketLoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMOMarketLoanDto getMarketLoanReceived(Long id) {
		DMOMarketLoanEntity entity =  repository.getOne(id);
		return converter.toDTO(entity);
	}

	/**
	 * Fetch all the findAll List items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */
	@Override
	public PagebleDTO<DMOMarketLoanDto> findAll(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOMarketLoanEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DMOMarketLoanEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DMOMarketLoanEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	/**
	 * Generate trn no.
	 *
	 * @param menuCode the menu code
	 * @return the string
	 */
	private String generateTrnNo(String menuCode) {
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(DMOConstant.TRN_SCREEN, menuCode);
			String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
			List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
			return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}

	@Override
	public List<DMOMarketLoanDto> getApprovedList(SerachApprovedDto pageDetail) throws CustomException{
		try {
	        List<DMOMarketLoanEntity> page = new ArrayList<>();
	        if(null != pageDetail.getAdviceNo() && !"".equals(pageDetail.getAdviceNo())) {
	        	repository.findByAdviceNoAndStatus(pageDetail.getAdviceNo(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement()).ifPresent(a->{
	        		page.add(a);
	        	});
	        }else {
	        	page.addAll(repository.findAllByAdviceDate(pageDetail.getFromDate(), pageDetail.getToDate(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement()));
	        }
	        return converter.toDTO(page);
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(401, "Advice No Is Already Present !!");
		}
	}

	@Override
	public DMOMarketLoanDto getAllRepayments(SerachApprovedDto pageDetail) throws CustomException{
		if (!repository.findByAdviceNo(pageDetail.getAdviceNo()).isPresent()) {
			throw new CustomException(401, "Advice No Is Not Present !!");
		}
		DMOMarketLoanEntity entity = repository.findByAdviceNo(pageDetail.getAdviceNo()).get();
		DMOMarketLoanDto dto = loanRePaymentConverter.toRePaymentDTO(entity);
		dto.setDtos(loanRePaymentConverter.toRePaymentDTO(entity.getRepayments()));
		return dto;
	}

	@Override
	public DMOGOIApprovedRepayDto searchRepay(DMOGOISearchDto dto) throws CustomException{
		DMOGOIApprovedRepayDto dtos = new DMOGOIApprovedRepayDto();
		List<DMOGOILoanDataDto> dmogoiLoanDataDtos = new ArrayList<>();
		List<DMODPDataDto> dmodpDataDtos = new ArrayList<>();
		List<DMODPSheetEntryEntity> dpFiltered = new ArrayList<>();
		List<DMOMarketLoanRePaymentEntity> repay = loanRePaymentRepository.findAllByAdviceDate(dto.getFromDate(), dto.getToDate());
		List<DMODPSheetEntryEntity> dp = dpSheetRepository.findAllByAndAdviceDate(dto.getFromDate(), dto.getToDate());
		if(CollectionUtils.isNotEmpty(dp)) {
			dpFiltered = dp.stream().filter(Objects::nonNull).filter(e -> Long.valueOf(20).equals(e.getTransactTypeId()) || Long.valueOf(21).equals(e.getTransactTypeId()))
					.collect(Collectors.toList());
		}
		Double totalPayIn = 0d;
		Double totalPayPri = 0d;
		Double totalPaidIn = 0d;
		Double totalPaidPri = 0d;
		for (DMOMarketLoanRePaymentEntity re : repay) {
			if ((re.getInstallDueDt().isEqual(dto.getFromDate())
					|| re.getInstallDueDt().isAfter(dto.getFromDate()))
					&& re.getInstallDueDt().isBefore(dto.getToDate())) {
				DMOGOILoanDataDto dataDto = new DMOGOILoanDataDto();
				dataDto.setDueDate(re.getInstallDueDt());
				dataDto.setInterestRate(re.getMarketLoanHdrId().getLoanRoi());
				dataDto.setLoanAmount(re.getMarketLoanHdrId().getLoanAmount());
				dataDto.setLoanOutstanding(re.getOutstandingAmt());
				if (re.getIsInstallPaid() == 1) {
					dataDto.setPaidInterest(re.getInterstAmount());
					dataDto.setPaidPrincipal(re.getPrincipalAmount());
					totalPaidIn = totalPaidIn + dataDto.getPaidInterest();
					totalPaidPri = totalPaidPri + dataDto.getPaidPrincipal();
				}
				dataDto.setPayableInterest(re.getInterstAmount());
				dataDto.setPayablePrincipal(re.getPrincipalAmount());
				dataDto.setId(re.getId());
				dataDto.setParentId(re.getMarketLoanHdrId().getId());
				totalPayIn = totalPayIn + dataDto.getPayableInterest();
				totalPayPri = totalPayPri + dataDto.getPayablePrincipal();
				dmogoiLoanDataDtos.add(dataDto);
			}
		}
		for(DMODPSheetEntryEntity dpEn : dpFiltered) {
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
	@Override
	public PagebleDTO<DMOMarketLoanDto> searchMarket(DMOGOISearchDto dto) {
		List<DMOMarketLoanDto> totalElement = converter.toDTO(repository.findAllByAdviceDate(dto.getFromDate(), dto.getToDate(), (dto.getPageIndex() * dto.getPageElement()), dto.getPageElement()));
		return new PagebleDTO<>(dto.getPageElement(), DMOUtility.checkDecimal((double)totalElement.size() /(double)dto.getPageElement()), totalElement.size(), totalElement);
	}
}

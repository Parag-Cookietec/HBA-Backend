package gov.ifms.dmo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMOMarketLoanConverter;
import gov.ifms.dmo.converter.DMOMarketLoanRePaymentConverter;
import gov.ifms.dmo.dto.DMOGOILoanRePaymentDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.dto.DMOMarketLoanRePaymentDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.entity.DMOMarketLoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRePaymentRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.service.DMOMarketLoanRePaymentService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

/**
 * The Class DMOGOILoanRePaymentServiceImpl.
 * 
 * @version v 2.0.
 * @created 2021/07/20 15:19:32
 *
 */
@Service
public class DMOMarketLoanRePaymentServiceImpl implements DMOMarketLoanRePaymentService {
	
	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOMarketLoanRePaymentRepository repository;
	
	@Autowired
	DMOMarketLoanRepository marketLoanRepository;
	
	@Autowired
	DMODPSheetEntryRepository dpSheetEntryRepository;
	
	@Autowired
	DMOMarketLoanRePaymentConverter converter;

	@Autowired
	DMOMarketLoanConverter loanConverter;
	
	@Autowired
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;
	/**
	 * Fetch all the GOI loan RePayments schedule list items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMOMarketLoanDto>
	 */
	@Override
	public PagebleDTO<DMOMarketLoanDto> findAll(PageDetails pageDetail) throws CustomException{

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOMarketLoanRePaymentEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DMOMarketLoanRePaymentEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DMOMarketLoanRePaymentEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Convert GOILoanRePaymentEntity to DMOGOILoanMatchPayableDto
	 * Retrieves an GOILoanRePaymentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the GOILoanRePaymentEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMOMarketLoanDto findById(Long id) {
		DMOMarketLoanRePaymentEntity entity = repository.getOne(id);
		return converter.toDTO(entity);
	}

	@Override
	public List<DMOMarketLoanDto> save(DMOMarketLoanDto dto) throws CustomException {
		DMOMarketLoanEntity entity = marketLoanRepository.findById(dto.getId()).get();
		DMOMarketLoanDto dtos = loanConverter.toDTO(entity);
		List<DMOMarketLoanRePaymentDto> dtos1  = DMOUtility.rePaymentMarketUtility(dtos);
		int length = dtos1.size();
		for(DMOMarketLoanRePaymentDto dt : dtos1) {
			Integer year = dt.getInstallDueDt().getYear();		
			validateFinancialYear(dt, year);
		}
		entity.setLoanMaturityDt(dtos1.get(length - 1).getInstallDueDt());
		return converter.toDTO(repository.saveAll(converter.toRePaymentEntity(dtos1)));
	}
	
	private void validateFinancialYear(DMOMarketLoanRePaymentDto dto, final Integer year) throws CustomException {
		EDPMsFinancialYearEntity edpMsFinancialYearEntity = eDPMsFinancialYearRepository.findByFyStart(year);
		if(Objects.isNull(edpMsFinancialYearEntity)) {
			logger.error("Repayment can not be saved since no entry for financial year "+year);
			throw new CustomException(401, DMOConstant.REPAYMENT_SCHEDULE_CANOT_BE_CREATED);
		}
		dto.setFinancialYrId(edpMsFinancialYearEntity.getFinancialYearId());
	}	
	
	@Override
	public String update(DMOMarketLoanRePaymentDto dto) {
		DMOMarketLoanRePaymentEntity loanRePaymentEntity = repository.findById(dto.getId()).get();
		loanRePaymentEntity.setIsInstallPaid(1);
		loanRePaymentEntity.setInstallPaidAmt(dto.getPaidAmt());
		loanRePaymentEntity.setInstallPaidDt(dto.getLdSheetRecvDt());
		loanRePaymentEntity.setOutstandingAmt(dto.getOutstandingAmt());
		loanRePaymentEntity.setUnpaidAmt(dto.getUnpaidAmt());
		repository.save(loanRePaymentEntity);
		return "Updated Successfully !!";
	}

	@Override
	public DMOMarketLoanRePaymentDto matchWithPayable(DMOGOISearchDto dto) {
		DMOMarketLoanRePaymentDto paymentDto = new DMOMarketLoanRePaymentDto();
		DMOMarketLoanRePaymentEntity loanRePaymentEntity = repository.findById(dto.getId()).get();
		DMODPSheetEntryEntity entryEntity = dpSheetEntryRepository.findById(dto.getDpId()).get();
		paymentDto.setAdviceNo(entryEntity.getAdviceNo());
		paymentDto.setInstallDueDt(loanRePaymentEntity.getInstallDueDt());
		paymentDto.setPrincipalAmount(loanRePaymentEntity.getPrincipalAmount());
		paymentDto.setInterstAmount(loanRePaymentEntity.getInterstAmount());
		paymentDto.setPaidAmt(entryEntity.getDebitAmt().doubleValue());
		paymentDto.setLdSheetRecvDt(entryEntity.getAdviceDate());
		Double unpaid = paymentDto.getPrincipalAmount() + paymentDto.getInterstAmount() - entryEntity.getDebitAmt();
		paymentDto.setUnpaidAmt(unpaid);
		DMOMarketLoanEntity entity = marketLoanRepository.findById(dto.getParentId()).get();
		Double outstanding = entity.getLoanAmount();
		for(DMOMarketLoanRePaymentEntity re : entity.getRepayments()) {
			if(null != re.getInstallPaidAmt()) {
				outstanding = outstanding - re.getInstallPaidAmt();
			}
		}
		paymentDto.setOutstandingAmt(outstanding);
		paymentDto.setId(loanRePaymentEntity.getId());
		return paymentDto;
	}
}

package gov.ifms.dmo.service.impl;

import java.util.List;
import java.util.Objects;

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
import gov.ifms.dmo.converter.DMONSSFLoanConverter;
import gov.ifms.dmo.converter.DMONSSFLoanRePaymentConverter;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMONSSFLoanDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.dto.DMONSSFLoanRePaymentDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.entity.DMONSSFLoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRePaymentRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMONSSFLoanRePaymentService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

/**
 * The Class DMONSSFLoanRePaymentServiceImpl.
 * 
 * @version v 2.0.
 * @created 2021/07/20 15:19:32
 *
 */
@Service
public class DMONSSFLoanRePaymentServiceImpl implements DMONSSFLoanRePaymentService {
	
	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMONSSFLoanRePaymentRepository repository;
	
	@Autowired
	DMONSSFLoanRepository nssfLoanRepository;
	
	@Autowired
	DMODPSheetEntryRepository dpSheetEntryRepository;
	
	@Autowired
	DMONSSFLoanRePaymentConverter converter;
	@Autowired
	DMONSSFLoanConverter dmonssfLoanConverter;
	@Autowired
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;
	/**
	 * Fetch all the NSSF loan RePayments schedule list items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */
	@Override
	public PagebleDTO<DMONSSFLoanDto> findAll(PageDetails pageDetail) throws CustomException{

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMONSSFLoanRePaymentEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DMONSSFLoanRePaymentEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DMONSSFLoanRePaymentEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Convert NSSFLoanRePaymentEntity to DMONSSFLoanMatchPayableDto
	 * Retrieves an NSSFLoanRePaymentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the NSSFLoanRePaymentEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMONSSFLoanDto findById(Long id) {
		DMONSSFLoanRePaymentEntity entity = repository.getOne(id);
		return converter.toDTO(entity);
	}

	@Override
	public List<DMONSSFLoanRePaymentDto> save(DMONSSFLoanPostDto dto) throws CustomException {
		DMONSSFLoanEntity entity = nssfLoanRepository.findById(dto.getId()).get();
		DMONSSFLoanPostDto dtos = dmonssfLoanConverter.toDTO(entity);
		List<DMONSSFLoanRePaymentDto> list  = DMOUtility.rePaymentUtility(dtos);
		int length = list.size();
		for(DMONSSFLoanRePaymentDto dt : list) {
			EDPMsFinancialYearEntity edpMsFinancialYearEntity = eDPMsFinancialYearRepository.findByFyStart(dt.getInstallDueDate().getYear());
			if(Objects.isNull(edpMsFinancialYearEntity)) {
				logger.error("Repayment can not be saved since no entry for financial year "+dt.getInstallDueDate().getYear());
				throw new CustomException(401, DMOConstant.REPAYMENT_SCHEDULE_CANOT_BE_CREATED);
			}
			dt.setFinanceYearId(edpMsFinancialYearEntity.getFinancialYearId());
		}
		entity.setLoanMaturityDate(list.get(length - 1).getInstallDueDate());
		list = converter.toRePaymentDTO(repository.saveAll(converter.toRePaymentEntity(list)));
		for(DMONSSFLoanRePaymentDto dt : list) {
			dt.setFinanceYr(eDPMsFinancialYearRepository.findById(dt.getFinanceYearId()).get().getFy());
		}
		return list;
	}

	@Override
	public String update(DMONSSFLoanRePaymentDto dto) {
		DMONSSFLoanRePaymentEntity loanRePaymentEntity = repository.findById(dto.getId()).get();
		loanRePaymentEntity.setIsInstallPaid(1);
		loanRePaymentEntity.setInstallPaidAmount(dto.getPaidAmount());
		loanRePaymentEntity.setInstallPaidDate(dto.getDpSheetRecDate());
		loanRePaymentEntity.setOutstandingAmount(dto.getOutstandingAmount());
		loanRePaymentEntity.setUnpaidAmount(dto.getUnpaidAmount());
		repository.save(loanRePaymentEntity);
		return "Updated Successfully !!";
	}

	@Override
	public DMONSSFLoanRePaymentDto matchWithPayable(DMOGOISearchDto dto) {
		DMONSSFLoanRePaymentDto paymentDto = new DMONSSFLoanRePaymentDto();
		DMONSSFLoanRePaymentEntity loanRePaymentEntity = repository.findById(dto.getId()).get();
		DMODPSheetEntryEntity entryEntity = dpSheetEntryRepository.findById(dto.getDpId()).get();
		paymentDto.setAdviceNo(entryEntity.getAdviceNo());
		paymentDto.setInstallDueDate(loanRePaymentEntity.getInstallDueDate());
		paymentDto.setPrincipalAmount(loanRePaymentEntity.getPrincipalAmount());
		paymentDto.setIntrestAmount(loanRePaymentEntity.getIntrestAmount());
		paymentDto.setPaidAmount(entryEntity.getDebitAmt().doubleValue());
		paymentDto.setDpSheetRecDate(entryEntity.getAdviceDate());
		Double unpaid = paymentDto.getPrincipalAmount() + paymentDto.getIntrestAmount() - entryEntity.getDebitAmt();
		paymentDto.setUnpaidAmount(unpaid);
		DMONSSFLoanEntity entity = nssfLoanRepository.findById(dto.getParentId()).get();
		Double outstanding = entity.getLoanAmount();
		for(DMONSSFLoanRePaymentEntity re : entity.getRepayments()) {
			if(null != re.getInstallPaidAmount()) {
				outstanding = outstanding - re.getInstallPaidAmount();
			}
		}
		paymentDto.setOutstandingAmount(outstanding);
		paymentDto.setId(loanRePaymentEntity.getId());
		return paymentDto;
	}

}

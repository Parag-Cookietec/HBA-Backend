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
import gov.ifms.dmo.converter.DMOGOILoanConverter;
import gov.ifms.dmo.converter.DMOGOILoanRePaymentConverter;
import gov.ifms.dmo.dto.DMOGOILoanDto;
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.dto.DMOGOILoanRePaymentDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOGOILoanEntity;
import gov.ifms.dmo.entity.DMOGOILoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMOGOILoanRePaymentRepository;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.service.DMOGOILoanRePaymentService;
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
public class DMOGOILoanRePaymentServiceImpl implements DMOGOILoanRePaymentService {
	
	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOGOILoanRePaymentRepository repository;
	
	@Autowired
	DMOGOILoanRepository goiLoanRepository;
	
	@Autowired
	DMODPSheetEntryRepository dpSheetEntryRepository;
	
	@Autowired
	DMOGOILoanRePaymentConverter converter;

	@Autowired
	DMOGOILoanConverter dmogoiLoanConverter;
	
	@Autowired
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;
	
	/**
	 * Fetch all the GOI loan RePayments schedule list items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMOGOILoanDto>
	 */
	@Override
	public PagebleDTO<DMOGOILoanDto> findAll(PageDetails pageDetail) throws CustomException{

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOGOILoanRePaymentEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DMOGOILoanRePaymentEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DMOGOILoanRePaymentEntity> page = repository.findAll(dataSpec, pageable);
	        
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
	public DMOGOILoanDto findById(Long id) {
		DMOGOILoanRePaymentEntity entity = repository.getOne(id);
		return converter.toDTO(entity);
	}

	@Override
	public List<DMOGOILoanRePaymentDto> save(DMOGOILoanPostDto dmogoiLoanPostDto) throws CustomException {
		DMOGOILoanEntity entity = goiLoanRepository.findById(dmogoiLoanPostDto.getId()).get();
		DMOGOILoanPostDto dto = dmogoiLoanConverter.toDTO(entity);
		List<DMOGOILoanRePaymentDto> dtos  = DMOUtility.rePaymentGOIUtility(dto);
		int length = dtos.size();
		for(DMOGOILoanRePaymentDto dt : dtos) {
			EDPMsFinancialYearEntity edpMsFinancialYearEntity = eDPMsFinancialYearRepository.findByFyStart(dt.getInstallDueDate().getYear());
			if(Objects.isNull(edpMsFinancialYearEntity)) {
				logger.error("Repayment can not be saved since no entry for financial year "+dt.getInstallDueDate().getYear());
				throw new CustomException(401, DMOConstant.REPAYMENT_SCHEDULE_CANOT_BE_CREATED);
			}
			dt.setFinanceYearId(edpMsFinancialYearEntity.getFinancialYearId());
		}
		entity.setLoanMaturityDate(dtos.get(length - 1).getInstallDueDate());
		return converter.toRePaymentDTO(repository.saveAll(converter.toRePaymentEntity(dtos)));
	}

	@Override
	public String update(DMOGOILoanRePaymentDto dto) {
		DMOGOILoanRePaymentEntity loanRePaymentEntity = repository.findById(dto.getId()).get();
		loanRePaymentEntity.setIsInstallPaid(1);
		loanRePaymentEntity.setInstallPaidAmount(dto.getPaidAmount());
		loanRePaymentEntity.setInstallPaidDate(dto.getDpSheetRecDate());
		loanRePaymentEntity.setOutstandingAmount(dto.getOutstandingAmount());
		loanRePaymentEntity.setUnpaidAmount(dto.getUnpaidAmount());
		repository.save(loanRePaymentEntity);
		return "Updated Successfully !!";
	}

	@Override
	public DMOGOILoanRePaymentDto matchWithPayable(DMOGOISearchDto dto) {
		DMOGOILoanRePaymentDto paymentDto = new DMOGOILoanRePaymentDto();
		DMOGOILoanRePaymentEntity loanRePaymentEntity = repository.findById(dto.getId()).get();
		DMODPSheetEntryEntity entryEntity = dpSheetEntryRepository.findById(dto.getDpId()).get();
		paymentDto.setAdviceNo(entryEntity.getAdviceNo());
		paymentDto.setInstallDueDate(loanRePaymentEntity.getInstallDueDate());
		paymentDto.setPrincipalAmount(loanRePaymentEntity.getPrincipalAmount());
		paymentDto.setIntrestAmount(loanRePaymentEntity.getIntrestAmount());
		paymentDto.setPaidAmount(entryEntity.getDebitAmt().doubleValue());
		paymentDto.setDpSheetRecDate(entryEntity.getAdviceDate());
		Double unpaid = paymentDto.getPrincipalAmount() + paymentDto.getIntrestAmount() - entryEntity.getDebitAmt();
		paymentDto.setUnpaidAmount(unpaid);
		DMOGOILoanEntity entity = goiLoanRepository.findById(dto.getParentId()).get();
		Double outstanding = entity.getLoanAmount();
		for(DMOGOILoanRePaymentEntity re : entity.getRepayments()) {
			if(null != re.getInstallPaidAmount()) {
				outstanding = outstanding - re.getInstallPaidAmount();
			}
		}
		paymentDto.setOutstandingAmount(outstanding);
		paymentDto.setId(loanRePaymentEntity.getId());
		return paymentDto;
	}

}

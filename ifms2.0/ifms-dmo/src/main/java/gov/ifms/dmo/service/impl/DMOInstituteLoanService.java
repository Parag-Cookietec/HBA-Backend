package gov.ifms.dmo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.exception.ResourceNotFoundException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMOInstituteLoanConverter;
import gov.ifms.dmo.dto.DMOInstitutionalLoanDto;
import gov.ifms.dmo.entity.DMOInstitutionalLoanEntity;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.repository.DMOInstitutionLoanRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;


/**
 * The Class DMONSSFLoanServiceImpl.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
@Service
public class DMOInstituteLoanService {

	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private DMOInstitutionLoanRepository repository;
	@Autowired
	private DMONSSFLoanRepository dmonssfLoanRepository;
	@Autowired
	private DMOGOILoanRepository dmogoiLoanRepository;
	@Autowired
	private DMOMarketLoanRepository dmoMarketLoanRepository;
	@Autowired
	private EDPMsFinancialYearRepository eDPMsFinancialYearRepository;
	@Autowired
	private DMOInstituteLoanConverter converter;
	
	public DMOInstitutionalLoanDto save(DMOInstitutionalLoanDto dto) throws CustomException {
		if (repository.findAllByRefrenceNo(dto.getRefrenceNo()).isPresent()) {
			throw new CustomException(401, "Refernce No Is Already Present !!");
		}
		if (repository.findByAdviceNo(dto.getAdviceNo()).isPresent()) {
			throw new CustomException(401, "Advice No Is Already Present !!");
		}
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}
	public DMOInstitutionalLoanDto update(DMOInstitutionalLoanDto dto) {
		dto.setLoanFinanceYearId(eDPMsFinancialYearRepository.findByFyStart(dto.getLoanStartDate().getYear()).getFinancialYearId());
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}

	public DMOInstitutionalLoanDto getById(IdDto dto) {
		return converter.toDTO(repository.findById(dto.getId()).get());
	}

	public List<DMOInstitutionalLoanDto> getAll() {
		return converter.toDTO(repository.findAll());
	}

	public List<String> getAllRef() {
		List<String> ref = new ArrayList<>();
		repository.findAll().forEach(a->{
			if(a.getChequeNo() == null && a.getChequeDate() == null) {
				ref.add(a.getRefrenceNo());
			}
		});
		return ref;
	}

	public List<DMOInstitutionalLoanDto> getAllApproved(SerachApprovedDto pageDetail) throws CustomException {
		try {
	        List<DMOInstitutionalLoanEntity> page = new ArrayList<>();
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
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String removeLoan(SerachApprovedDto dto) {
		if(null != dto.getAdviceNo()) {
			if(dto.getTypeOfLoan().equalsIgnoreCase("NSSF")) {
				dmonssfLoanRepository.findByAdviceNo(dto.getAdviceNo()).ifPresent(loan ->{
					loan.setActiveStatus(0);
					loan.setLoanDeleteDate(LocalDate.now());
					dmonssfLoanRepository.save(loan);
				});
			}else if(dto.getTypeOfLoan().equalsIgnoreCase("GOI")) {
				dmogoiLoanRepository.findByAdviceNo(dto.getAdviceNo()).ifPresent(loan ->{
					loan.setActiveStatus(0);
					loan.setLoanDeleteDate(LocalDate.now());
					dmogoiLoanRepository.save(loan);
				});
			}else if(dto.getTypeOfLoan().equalsIgnoreCase("Market")) {
				dmoMarketLoanRepository.findByAdviceNo(dto.getAdviceNo()).ifPresent(loan ->{
					loan.setActiveStatus(0);
					loan.setLoanDeleteDt(LocalDate.now());
					dmoMarketLoanRepository.save(loan);
				});
			}else if(dto.getTypeOfLoan().equalsIgnoreCase("Institution")) {
				repository.findByAdviceNo(dto.getAdviceNo()).ifPresent(loan ->{
					loan.setActiveStatus(0);
					loan.setLoanDeleteDate(LocalDate.now());
					repository.save(loan);
				});
			}
		}
		return "Deleted Successfully!!";
	}

	public DMOInstitutionalLoanDto getByRef(SerachApprovedDto dto) throws ResourceNotFoundException {
		return converter.toDTO(repository.findByRefrenceNo(dto.getReferenceNo()).orElseThrow(() -> new ResourceNotFoundException("Institute Loan Not found")));
	}
	public List<String> getByInstitute(SerachApprovedDto dto) {
		List<String> ref = new ArrayList<>();
		repository.findAllByInstituteId(dto.getInstituteId()).ifPresent(in->{
			in.forEach(a->{
				ref.add(a.getRefrenceNo());
			});
		});
		return ref;
	}
	public String updateLetter(SerachApprovedDto dto) {
		repository.findByRefrenceNo(dto.getReferenceNo()).ifPresent(ref->{
			ref.setLetterNo(dto.getLetterNo());
			ref.setLetterDate(dto.getLetterDate());
			repository.save(ref);
		});
		return "Updated Successfully !!";
	}
	
}

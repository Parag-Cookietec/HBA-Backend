package gov.ifms.dmo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.entity.DMOGOILoanEntity;
import gov.ifms.dmo.entity.DMOInstitutionalLoanEntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.repository.DMOInstituteMstRespository;
import gov.ifms.dmo.repository.DMOInstitutionLoanRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;

/**
 * The Class DMONSSFLoanServiceImpl.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
@Service
public class DMORemoveLoanService {

	@Autowired
	private DMOInstitutionLoanRepository repository;
	@Autowired
	private DMONSSFLoanRepository dmonssfLoanRepository;
	@Autowired
	private DMOGOILoanRepository dmogoiLoanRepository;
	@Autowired
	private DMOMarketLoanRepository dmoMarketLoanRepository;
	@Autowired
	private DMOInstituteMstRespository instituteMstRespository;

	public String removeLoan(SerachApprovedDto dto) {
		if (null != dto.getIds()) {
			if (dto.getTypeOfLoan().equalsIgnoreCase("NSSF")) {
				dmonssfLoanRepository.findAllByIdIn(dto.getIds()).forEach(loan -> {
					loan.setActiveStatus(0);
					loan.setLoanDeleteDate(LocalDate.now());
					dmonssfLoanRepository.save(loan);
				});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("GOI")) {
				dmogoiLoanRepository.findAllByIdIn(dto.getIds()).forEach(loan -> {
					loan.setActiveStatus(0);
					loan.setLoanDeleteDate(LocalDate.now());
					dmogoiLoanRepository.save(loan);
				});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("Market")) {
				dmoMarketLoanRepository.findAllByIdIn(dto.getIds()).forEach(loan -> {
					loan.setActiveStatus(0);
					loan.setLoanDeleteDt(LocalDate.now());
					dmoMarketLoanRepository.save(loan);
				});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("Institution")) {
				repository.findAllByIdIn(dto.getIds()).forEach(loan -> {
					loan.setActiveStatus(0);
					loan.setLoanDeleteDate(LocalDate.now());
					repository.save(loan);
				});
			}
		}
		return dto.getTypeOfLoan() + " Deleted Successfully!!";
	}

	public List<DMOGOILoanPostDto> searchLoan(SerachApprovedDto dto) {
		List<DMOGOILoanPostDto> list = new ArrayList<>();
		if (null == dto.getFromDate()) {
			if (dto.getTypeOfLoan().equalsIgnoreCase("NSSF")) {
				dmonssfLoanRepository.findAllBySanctionOrderNoAndActiveStatus(dto.getSanctionNo(), 1).forEach(loan -> {
					nssfLoan(list, loan);
				});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("GOI")) {
				dmogoiLoanRepository.findAllByLoanPurposeAndNameOfMinistryAndPlanSchemeNameAndActiveStatus(dto.getLoanPurpose(),
						dto.getMinistryId(), dto.getSchemeId(), 1).forEach(loan -> {
							goiLoan(list, loan);
						});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("Market")) {
				dmoMarketLoanRepository.findAllByTransactionDescAndActiveStatus(dto.getTransDesc(), 1).forEach(loan -> {
					marketLoan(list, loan);
				});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("Institution")) {
				repository.findAllByTransactionDescAndActiveStatus(dto.getTransDesc(), 1).forEach(loan -> {
					institutionLoan(list, loan);
				});
			}
		} else {
			if (dto.getTypeOfLoan().equalsIgnoreCase("NSSF")) {
				dmonssfLoanRepository.findAllByAdviceDate(dto.getFromDate(), dto.getToDate(), (dto.getPageIndex() * dto.getPageElement()), dto.getPageElement()).forEach(loan -> {
					nssfLoan(list, loan);
				});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("GOI")) {
				dmogoiLoanRepository.findAllByAdviceDate(dto.getFromDate(), dto.getToDate(), (dto.getPageIndex() * dto.getPageElement()), dto.getPageElement()).forEach(loan -> {
					goiLoan(list, loan);
				});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("Market")) {
				dmoMarketLoanRepository.findAllByAdviceDate(dto.getFromDate(), dto.getToDate(), (dto.getPageIndex() * dto.getPageElement()), dto.getPageElement()).forEach(loan -> {
					marketLoan(list, loan);
				});
			} else if (dto.getTypeOfLoan().equalsIgnoreCase("Institution")) {
				repository.findAllByAdviceDate(dto.getFromDate(), dto.getToDate(), (dto.getPageIndex() * dto.getPageElement()), dto.getPageElement()).forEach(loan -> {
					institutionLoan(list, loan);
				});
			}
		}
		return list;
	}

	private void institutionLoan(List<DMOGOILoanPostDto> list, DMOInstitutionalLoanEntity loan) {
		DMOGOILoanPostDto postDto = new DMOGOILoanPostDto();
		postDto.setId(loan.getId());
		postDto.setAdviceNo(loan.getAdviceNo());
		postDto.setAdviceDate(loan.getAdviceDate());
		postDto.setLoanMaturityDate(loan.getLoanMaturityDate());
		postDto.setLoanAmount(loan.getLoanAmount());
		postDto.setLoanROI(loan.getLoanROI());
		postDto.setLoanTenure(loan.getLoanTenure());
		postDto.setSanctionNo(loan.getLoanAccNumber());
		postDto.setLoanReceiptDate(loan.getLoanReceiptDate());
		list.add(postDto);
	}

	private void marketLoan(List<DMOGOILoanPostDto> list, DMOMarketLoanEntity loan) {
		DMOGOILoanPostDto postDto = new DMOGOILoanPostDto();
		postDto.setId(loan.getId());
		postDto.setAdviceNo(loan.getAdviceNo());
		postDto.setAdviceDate(loan.getAdviceDt());
		postDto.setLoanMaturityDate(loan.getLoanMaturityDt());
		postDto.setLoanAmount(loan.getLoanAmount());
		postDto.setLoanROI(loan.getLoanRoi());
		postDto.setLoanTenure(loan.getLoanTenure());
		postDto.setSanctionNo(loan.getSanctionOrderNo());
		postDto.setLoanReceiptDate(loan.getLoanReceiptDt());
		list.add(postDto);
	}

	private void goiLoan(List<DMOGOILoanPostDto> list, DMOGOILoanEntity loan) {
		DMOGOILoanPostDto postDto = new DMOGOILoanPostDto();
		postDto.setId(loan.getId());
		postDto.setAdviceNo(loan.getAdviceNo());
		postDto.setAdviceDate(loan.getAdviceDate());
		postDto.setLoanMaturityDate(loan.getLoanMaturityDate());
		postDto.setLoanAmount(loan.getLoanAmount());
		postDto.setLoanROI(loan.getLoanROI());
		postDto.setLoanTenure(loan.getLoanTenure());
		postDto.setSanctionNo(loan.getSanctionOrderNo());
		postDto.setLoanReceiptDate(loan.getLoanReceiptDate());
		list.add(postDto);
	}

	private void nssfLoan(List<DMOGOILoanPostDto> list, DMONSSFLoanEntity loan) {
		DMOGOILoanPostDto postDto = new DMOGOILoanPostDto();
		postDto.setId(loan.getId());
		postDto.setAdviceNo(loan.getAdviceNo());
		postDto.setAdviceDate(loan.getAdviceDate());
		postDto.setLoanMaturityDate(loan.getLoanMaturityDate());
		postDto.setLoanAmount(loan.getLoanAmount());
		postDto.setLoanROI(loan.getLoanROI());
		postDto.setLoanTenure(loan.getLoanTenure());
		postDto.setSanctionNo(loan.getSanctionOrderNo());
		postDto.setLoanReceiptDate(loan.getLoanReceiptDate());
		list.add(postDto);
	}

	public Set<String> loanDesc() {
		List<DMOMarketLoanEntity> instituteMstrs = dmoMarketLoanRepository.findAllByActiveStatus(1);
		return instituteMstrs.stream().map(institute -> {
			return institute.getTransactionDesc();
		}).collect(Collectors.toSet());
	}

	public Set<String> tenche(IdDto dto) {
		List<DMOInstitutionalLoanEntity> instituteMstrs = repository.findAllByInstituteIdAndActiveStatus(dto.getId(), 1);
		return instituteMstrs.stream().map(institute -> {
			return institute.getTransactionDesc();
		}).collect(Collectors.toSet());
	}

	public List<DMOLookUpDto> institute() throws CustomException {
		try {
			List<DMOInstitutionalLoanEntity> instituteMstrs = repository.findAllByActiveStatus(1);
			Set<Long> inst = instituteMstrs.stream().map(institute -> {
				return institute.getInstituteId();
			}).collect(Collectors.toSet());

			return inst.stream().map(institute -> {
				DMOLookUpDto dto = new DMOLookUpDto();
				dto.setId(institute);
				dto.setName(instituteMstRespository.findById(institute).get().getInstituteName());
				return dto;
			}).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CustomException(401, ex.getMessage());
		}
	}

	public Set<String> sanctionNo() {
		List<DMONSSFLoanEntity> instituteMstrs = dmonssfLoanRepository.findAllByActiveStatus(1);
		return instituteMstrs.stream().map(institute -> {
			return institute.getSanctionOrderNo();
		}).collect(Collectors.toSet());
	}
}

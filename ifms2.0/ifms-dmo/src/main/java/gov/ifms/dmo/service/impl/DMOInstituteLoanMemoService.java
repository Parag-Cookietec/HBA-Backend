package gov.ifms.dmo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.dmo.converter.DMOInstituteLoanMemoConverter;
import gov.ifms.dmo.dto.DMOInstitutionalLoanMemoDto;
import gov.ifms.dmo.entity.DMOInstitutionalLoanEntity;
import gov.ifms.dmo.entity.DMOInstitutionalLoanMemoDtlEntity;
import gov.ifms.dmo.entity.DMOInstitutionalLoanMemoEntity;
import gov.ifms.dmo.repository.DMOInstitutionLoanMemoDtlRepository;
import gov.ifms.dmo.repository.DMOInstitutionLoanMemoRepository;
import gov.ifms.dmo.repository.DMOInstitutionLoanRepository;

/**
 * The Class DMONSSFLoanServiceImpl.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
@Service
public class DMOInstituteLoanMemoService {

	@Autowired
	private DMOInstitutionLoanRepository institutionLoanRepository;

	@Autowired
	private DMOInstitutionLoanMemoRepository repository;

	@Autowired
	private DMOInstitutionLoanMemoDtlRepository dtlRepository;
	
	@Autowired
	private DMOInstituteLoanMemoConverter dmoInstituteLoanMemoConverter;

	public List<DMOInstitutionalLoanMemoDtlEntity> save(DMOInstitutionalLoanMemoDto dto) {
		DMOInstitutionalLoanEntity dmoInst = institutionLoanRepository.findByRefrenceNo(dto.getRefrenceNo()).orElseThrow(() -> new ResourceNotFoundException("Institute Loan Not found"));
		DMOInstitutionalLoanMemoEntity inst = new DMOInstitutionalLoanMemoEntity();
		inst.setDpSheetEntity(dmoInst.getDpSheetId());
		inst.setDpSheetRecDate(dmoInst.getDpSheetRecDate());
		inst.setMemoDate(dto.getMemoDate());
		inst.setMemoNo(dto.getMemoNo());
		inst.setRefrenceNo(dmoInst.getRefrenceNo());
		inst.setRefrenceDate(dmoInst.getRefrenceDate());
		inst.setIntLoanId(dmoInst);
		repository.save(inst);
		List<DMOInstitutionalLoanMemoDtlEntity> list = new ArrayList<>();
		LocalDate date = dmoInst.getFirstInstallDate();
		int installment = dmoInst.getLoanTenure() * dmoInst.getPrncplInstallYear();
		double interest = (dmoInst.getLoanAmount() * dmoInst.getLoanROI()) / 100;
		double principal = (dmoInst.getLoanAmount() / (dmoInst.getLoanTenure() - dmoInst.getMoratariumPeriod())) / dmoInst.getPrncplInstallYear();
		for (int i = 0; i < installment; i++) {
			DMOInstitutionalLoanMemoDtlEntity repayment = new DMOInstitutionalLoanMemoDtlEntity();
			if (dmoInst.getPrncplInstallYear() > i) {
				repayment.setRepayDueAmount(interest);
			} else {
				repayment.setRepayDueAmount(interest + principal);
			}
			repayment.setLoanAmount(dmoInst.getLoanAmount());
			repayment.setMemoDtlSrNo(i);
			repayment.setInstituteLoanId(dmoInst);
			repayment.setInstituteLoanMemoId(inst);
			repayment.setActiveStatus(1);
			repayment.setRepayDueDate(date);
			dtlRepository.save(repayment);
			list.add(repayment);
			date = date.plusMonths(dmoInst.getPrncplInstallYear() - 1);
		}
		return list;
	}

	public DMOInstitutionalLoanMemoEntity update(DMOInstitutionalLoanMemoDto dto) {
		return repository.save(dmoInstituteLoanMemoConverter.toEntity(dto));
	}

	public String delete(SerachApprovedDto serachApprovedDto) {
		DMOInstitutionalLoanMemoEntity memo = repository.findByMemoNo(serachApprovedDto.getMemoNo()).get();
		memo.setActiveStatus(0);
		repository.save(memo);
		return "Delete Successfully !!";
	}

	public List<DMOInstitutionalLoanMemoEntity> getAll() {
		return repository.findAll();
	}

	public List<String> getAllMemo() {
		List<String> ref = new ArrayList<>();
		repository.findAll().forEach(a->{
			if(a.getActiveStatus() == 1 && a.getChequeNo() == null && a.getChequeDate() == null) {
				ref.add(a.getMemoNo());
			}
		});
		return ref;
	}
	public List<String> getAllMemoDelete() {
		List<String> ref = new ArrayList<>();
		repository.findAll().forEach(a->{
			if(a.getActiveStatus() == 1) {
				ref.add(a.getMemoNo());
			}
		});
		return ref;
	}

	public DMOInstitutionalLoanMemoDto getByMemo(SerachApprovedDto serachApprovedDto) {
		return dmoInstituteLoanMemoConverter.toDTO(repository.findByMemoNo(serachApprovedDto.getMemoNo()).get());
	}
	public List<DMOInstitutionalLoanMemoDtlEntity> getByMemoRepay(SerachApprovedDto serachApprovedDto) {
		List<DMOInstitutionalLoanMemoDtlEntity> dto = new ArrayList<>();
		repository.findByRefrenceNo(serachApprovedDto.getReferenceNo()).get().getRepayments().forEach(a->{
			if((a.getRepayDueDate().isEqual(serachApprovedDto.getFromDate()) || a.getRepayDueDate().isAfter(serachApprovedDto.getFromDate()))
					&& a.getRepayDueDate().isBefore(serachApprovedDto.getToDate())) {
				dto.add(a);
			}
		});
		return dto;
	}

	public List<Long> getAllCheque() {
		List<Long> ref = new ArrayList<>();
		repository.findAll().forEach(a->{
			if(a.getActiveStatus() == 1 && a.getChequeNo() != null && a.getChequeDate() != null && a.getChequePaidDate() == null) {
				ref.add(a.getChequeNo());
			}
		});
		return ref;
	}

	public DMOInstitutionalLoanMemoDto getByCheque(SerachApprovedDto serachApprovedDto) {
		return dmoInstituteLoanMemoConverter.toDTO(repository.findByChequeNo(serachApprovedDto.getChequeNo()).get());
	}

	public String updateByRef(SerachApprovedDto dto) {
		repository.findByRefrenceNo(dto.getReferenceNo()).ifPresent(ref->{
			ref.setMemoNo(dto.getMemoNo());
			ref.setMemoDate(dto.getMemoDate());
			repository.save(ref);
		});
		return "DMO Institutional Loan Memo updated successfully!!";
	}

	public String updateByMemo(SerachApprovedDto dto) {
		repository.findByMemoNo(dto.getMemoNo()).ifPresent(ref->{
			ref.setChequeNo(dto.getChequeNo());
			ref.setChequeDate(dto.getChequeDate());
			ref.setPaymentTypeId(Long.valueOf(dto.getTypeOfPayable()));
			repository.save(ref);
		});
		return "DMO Institutional Loan Memo Cheque updated successfully!!";
	}

	public String updateByCheque(SerachApprovedDto dto) {
		repository.findByChequeNo(dto.getChequeNo()).ifPresent(ref->{
			ref.setChequePaidDate(dto.getChequeDate());
			ref.setPaymentTypeId(Long.valueOf(dto.getTypeOfPayable()));
			repository.save(ref);
		});
		return "DMO Institutional Loan Memo Cheque Date updated successfully!!";
	}

}

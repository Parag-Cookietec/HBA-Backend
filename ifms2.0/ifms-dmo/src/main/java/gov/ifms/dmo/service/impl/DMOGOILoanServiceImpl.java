package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.converter.DMOGOILoanConverter;
import gov.ifms.dmo.converter.DMOGOILoanRePaymentConverter;
import gov.ifms.dmo.dto.DMODPDataDto;
import gov.ifms.dmo.dto.DMOGOIApprovedRepayDto;
import gov.ifms.dmo.dto.DMOGOILoanDataDto;
import gov.ifms.dmo.dto.DMOGOILoanDto;
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOGOILoanEntity;
import gov.ifms.dmo.entity.DMOGOILoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMOGOILoanRePaymentRepository;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.service.DMOGOILoanService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPLuLookUpRepository;
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
public class DMOGOILoanServiceImpl implements DMOGOILoanService {

	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOGOILoanRepository repository;

	@Autowired
	DMOGOILoanRePaymentRepository loanRePaymentRepository;
	
	@Autowired
	DMOGOILoanConverter converter;
	
	@Autowired
	DMODPSheetEntryRepository dpSheetRepository;
	
	@Autowired
	DMOGOILoanRePaymentConverter repaymentConverter;
	
	@Autowired
	EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Autowired
	EDPLuLookUpRepository lookUpRepository;
	
	@Autowired
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	EDPMsDepartmentRepository departmentServiceRepository;
	
	@Autowired
	EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;
	@Autowired
	DMOGOILoanRePaymentServiceImpl loanRePaymentServiceImpl;
	
	/**
	 * Saves a given DMOGOILoanEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved entity
	 * @throws CustomException 
	 */
	@Override
	public DMOGOILoanPostDto saveOrUpdateGOILoanReceived(DMOGOILoanPostDto dto) throws CustomException {
		if (repository.findAllByAdviceNo(dto.getAdviceNo()).isPresent()) {
			throw new CustomException(401, "Advice No Is Already Present !!");
		}
		DMOGOILoanEntity entity = converter.toEntity(dto);
		entity.setRefrenceDate(LocalDateTime.now());
		entity.setRefrenceNo(generateTrnNo(DMOConstant.NLR_TRN_SCREEN));
		entity.setBlockLoanStatus(false);
		if(null != eDPMsFinancialYearRepository.findByFyStart(dto.getLoanStartDate().getYear())){
			entity.setLoanFinanceYearId(eDPMsFinancialYearRepository.findByFyStart(dto.getLoanStartDate().getYear()).getFinancialYearId());
		}
		DMOGOILoanPostDto loanPostDto =  converter.toDTO(repository.save(entity));
		loanRePaymentServiceImpl.save(loanPostDto);
		return loanPostDto;
	}

	/**
	 * Retrieves an DMOGOILoanEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMOGOILoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMOGOILoanPostDto getGOILoanReceived(Long id) {
		return converter.toDTO(repository.getOne(id));
	}

	/**
	 * Fetch all the GOILoanApprovedList items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMOGOILoanDto>
	 */
	@Override
	public List<DMOGOILoanPostDto> getGOILoanApprovedList(SerachApprovedDto pageDetail) throws CustomException{
		try {
	        List<DMOGOILoanEntity> page = new ArrayList<>();
	        if(null != pageDetail.getAdviceNo() && !"".equals(pageDetail.getAdviceNo())) {
	        	repository.findByAdviceNoAndBlockLoanStatus(pageDetail.getAdviceNo(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement()).ifPresent(a->{
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

	/**
	 * Retrieves all repayments
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMOGOILoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMOGOILoanDto getAllRepayments(Long id) {
		DMOGOILoanEntity entity = repository.getOne(id);
		DMOGOILoanDto dto = repaymentConverter.toRePaymentDTO(entity);
		dto.setDtos(repaymentConverter.toRePaymentDTO(entity.getRepayments()));
		return dto;
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
	public String deleteGoi(Long id) {
		repository.findById(id).ifPresent(re->{
			re.setBlockLoanStatus(true);
			repository.save(re);
		});
		return "Deleted Successfully !!";
	}
	
	@Override
	public List<DMOGOILoanPostDto> search(DMOGOISearchDto filter) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<DMOGOILoanEntity> query = cb.createQuery(DMOGOILoanEntity.class);
		Root<DMOGOILoanEntity> root = query.from(DMOGOILoanEntity.class);
		List<Predicate> predicates = new ArrayList<>();
		 if (null != filter.getLoanFinanceYearId()) { 
             Path<Long> exp = root.get("loanFinanceYearId"); 
             predicates.add(cb.equal(exp, filter.getLoanFinanceYearId())); 
        }
        if (null != filter.getLoanPurpose()) { 
             Path<Long> exp = root.get("loanPurpose"); 
             predicates.add(cb.equal(exp, filter.getLoanPurpose())); 
        }
        if (null != filter.getNameOfMinistry()) { 
        	Path<Long> exp = root.get("nameOfMinistry"); 
        	predicates.add(cb.equal(exp, filter.getNameOfMinistry())); 
        }
        if (null != filter.getPlanSchemeName()) { 
        	Path<Long> exp = root.get("planSchemeName"); 
        	predicates.add(cb.equal(exp, filter.getPlanSchemeName())); 
        }
        if (null != filter.getAdviceNo()) { 
        	Path<Long> exp = root.get("adviceNo"); 
        	predicates.add(cb.equal(exp, filter.getAdviceNo())); 
        }
        if (null != filter.getAdviceDate()) { 
        	Path<Long> exp = root.get("adviceDate"); 
        	predicates.add(cb.equal(exp, filter.getAdviceDate())); 
        }
		query.select(root).where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
		List<DMOGOILoanEntity> dto = entityManager.createQuery(query).getResultList();
		return converter.toDTO(dto);
	}
	
	@Override
	public DMOGOIApprovedRepayDto searchRepay(DMOGOISearchDto dto) {
		DMOGOIApprovedRepayDto dtos = new DMOGOIApprovedRepayDto();
		DMOGOISearchDto filter = new DMOGOISearchDto();
		List<DMODPSheetEntryEntity> dpFiltered = new ArrayList<>();
		filter.setAdviceNo(dto.getAdviceNo());
		filter.setAdviceDate(dto.getAdviceDate());
		List<DMOGOILoanDataDto> dmogoiLoanDataDtos = new ArrayList<>();
		List<DMODPDataDto> dmodpDataDtos = new ArrayList<>();
		List<DMOGOILoanRePaymentEntity> repay = new ArrayList<>();
		if(null != dto.getAdviceNo()) {
			repay = loanRePaymentRepository.findAllByAdviceDateAndAdviceNo(dto.getFromDate(), dto.getToDate(), dto.getAdviceNo());
		}else {
			repay = loanRePaymentRepository.findAllByAdviceDate(dto.getFromDate(), dto.getToDate());
		}
		List<DMODPSheetEntryEntity> dp = dpSheetRepository.findAllByAndAdviceDate(dto.getFromDate(), dto.getToDate());
		if(CollectionUtils.isNotEmpty(dp)) {
			dpFiltered = dp.stream().filter(Objects::nonNull).filter(e -> Long.valueOf(27).equals(e.getTransactTypeId()) || Long.valueOf(28).equals(e.getTransactTypeId()))
					.collect(Collectors.toList());
		}
		Double totalPayIn = 0d;
		Double totalPayPri = 0d;
		Double totalPaidIn = 0d;
		Double totalPaidPri = 0d;
		for (DMOGOILoanRePaymentEntity re : repay) {
			if ((re.getInstallDueDate().isEqual(dto.getFromDate())
					|| re.getInstallDueDate().isAfter(dto.getFromDate()))
					&& re.getInstallDueDate().isBefore(dto.getToDate())) {
				DMOGOILoanDataDto dataDto = new DMOGOILoanDataDto();
				dataDto.setDueDate(re.getInstallDueDate());
				dataDto.setInterestRate(re.getIntrestRate());
				dataDto.setLoanAmount(re.getLoanAmount());
				dataDto.setLoanOutstanding(re.getOutstandingAmount());
				dataDto.setNameOfMinistry(departmentServiceRepository.findById(re.getGoiLoanId().getNameOfMinistry()).get().getDepartmentName());
				if (re.getIsInstallPaid() == 1) {
					dataDto.setPaidInterest(re.getIntrestAmount());
					dataDto.setPaidPrincipal(re.getPrincipalAmount());
					totalPaidIn = totalPaidIn + dataDto.getPaidInterest();
					totalPaidPri = totalPaidPri + dataDto.getPaidPrincipal();
				}
				dataDto.setPayableInterest(re.getIntrestAmount());
				dataDto.setPayablePrincipal(re.getPrincipalAmount());
				dataDto.setSrPageNo(re.getGoiLoanId().getSrPageNo());
				dataDto.setId(re.getId());
				dataDto.setParentId(re.getGoiLoanId().getId());
				dataDto.setPlanSchemeName(edpLuLookUpInfoRepository.findById(re.getGoiLoanId().getPlanSchemeName()).get().getLookUpInfoName());
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
	public DMOGOILoanPostDto updateGOILoanReceived(DMOGOILoanPostDto dto) throws CustomException {
		if (!repository.findById(dto.getId()).isPresent()) {
			throw new CustomException(401, "GOI Is Not Present !!");
		}
		DMOGOILoanEntity entity = converter.toEntity(dto);
		entity.setRepayments(repository.findById(dto.getId()).get().getRepayments());
		return converter.toDTO(repository.save(entity));
	}
}

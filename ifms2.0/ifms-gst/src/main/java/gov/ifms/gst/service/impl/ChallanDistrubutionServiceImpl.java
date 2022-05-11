package gov.ifms.gst.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.repository.EDPMsBankRepository;
import gov.ifms.gst.controller.SadaDto;
import gov.ifms.gst.controller.ScrollDto;
import gov.ifms.gst.converter.ChallanDistrubutionConvertor;
import gov.ifms.gst.dto.BankDto;
import gov.ifms.gst.dto.ChallanDistributionSADADto;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.dto.LoadBalancerHADto;
import gov.ifms.gst.entity.ChallanDistributionSADA;
import gov.ifms.gst.entity.SADAChallanMapping;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.repository.ChallanDistruSADARepository;
import gov.ifms.gst.repository.SADAChallanMappingRepository;
import gov.ifms.gst.util.GSTConstant;

@Service
public class ChallanDistrubutionServiceImpl {

	@Autowired
	private ChallanDistrubutionConvertor convertor;

	@Autowired
	private ChallanDistruSADARepository repository;
	@Autowired
	private SADAChallanMappingRepository mappingRepository;

	@Autowired
	private EDPMsBankRepository bankRepository;
	@Autowired
	private EntityManager entityManager;
	public String QUERY_FOR_BANK_NAME = "SELECT count(tsdcm.BANK_ID) AS count_Challan, mb.BANK_NAME, tsdcm.FILE_PROCESS_ID, tsdcm.BANK_ID, ttbcm.BANK_SHORT_CODE "
			+ " FROM EPAO.TPAO_SA_DA_CHALLAN_MAPPING tsdcm JOIN EPAO.TPAO_SCROLL_DISTRIBUTE tsd "
			+ " ON tsd.FILE_PROCESS_ID = tsdcm.FILE_PROCESS_ID  JOIN MASTER_V1.MS_BANK mb  ON tsdcm.BANK_ID = mb.BANK_ID "
			+ " JOIN EPAO.TPAO_TEMP_BANK_CODE_MAPP ttbcm ON ttbcm.MS_BANK_ID = mb.BANK_ID "
			+ " WHERE tsd.CHALLAN_DT >= :fromDate AND tsd.CHALLAN_DT <= :toDate AND tsd.BRANCH_ID = :branchId "
			+ " GROUP BY tsdcm.BANK_ID, mb.BANK_NAME, ttbcm.BANK_SHORT_CODE, tsdcm.FILE_PROCESS_ID ";
	public String QUERY_FOR_SA_DA = "SELECT  me.EMPLOYEE_NO AS empno,\r\n"
			+ " upper(  me.EMPLOYEE_NAME||' '|| me.MIDDLE_GUARDIAN_NAME||' '||me.SURNAME ) AS empname,\r\n"
			+ " post.post_name,\r\n" + "  br.BRANCH_ID, me.EMP_ID " + " FROM MASTER_V1.MS_EMPLOYEE me\r\n"
			+ " INNER JOIN MASTER_V1.MS_USER MSuser\r\n" + " ON MSuser.USER_CODE = me.EMPLOYEE_NO\r\n"
			+ " and MSuser.active_status = 1\r\n" + " INNER JOIN  MASTER_V1.LK_PO_OFF_USER pou\r\n"
			+ " ON pou.USER_ID = MSuser.USER_ID\r\n" + "  and pou.active_status = 1\r\n"
			+ " INNER JOIN  MASTER_V1.LK_POST_OFFICE poffice\r\n"
			+ " ON POFFICE.LK_POST_OFFICE_ID = pou.LK_POST_OFFICE_ID\r\n" + "  and poffice.active_status = 1\r\n"
			+ " inner join master_v1.ms_post post\r\n" + "  on poffice.post_id = post.post_id\r\n"
			+ " and post.active_status = 1\r\n" + " left JOIN  MASTER_V1.TRN_POU_BR_MAP br\r\n"
			+ " ON pou.LK_PO_OFF_USER_ID = br.LK_PO_OFF_USER_ID" + "  AND  pou.LK_PO_OFF_USER_ID = BR.TR_FROM_POU_ID"
			+ " and br.active_status = 1" + " JOIN EPAO.TPAO_SCROLL_DISTRIBUTE tsd ON br.BRANCH_ID = tsd.BRANCH_ID "
			+ " WHERE br.BRANCH_ID IN (:branchId) AND (post.POST_NAME LIKE '%Sub Accountant%' OR post.POST_NAME LIKE '%Deputy Accountant%') ";
	public String QUERY_FOR_SEARCH = "SELECT mb.BANK_NAME, upper(  me.EMPLOYEE_NAME||' '|| me.MIDDLE_GUARDIAN_NAME||' '||me.SURNAME ) AS empname, count(tsdcm.SA_DA_ID), sum(trft.TRANSACTION_AMT), tsdcm.SA_DA_ID,\r\n"
			+ "	tsdcm.FILE_PROCESS_ID, tsdcm.BANK_ID \r\n"
			+ "	FROM epao.TPAO_SCROLL_DISTRIBUTE tsd JOIN EPAO.TPAO_SA_DA_CHALLAN_MAPPING tsdcm ON tsdcm.FILE_PROCESS_ID "
			+ "	JOIN epao.TPAO_RBI_FILES_TRANXN trft ON tsdcm.RBI_FILE_TRANXN_ID = trft.RBI_FILE_TRANXN_ID "
			+ "	JOIN MASTER_V1.MS_EMPLOYEE me ON me.EMPLOYEE_NO  = tsdcm.SA_DA_ID "
			+ "	JOIN MASTER_V1.MS_BANK mb ON mb.BANK_ID  = tsdcm.BANK_ID "
			+ "	WHERE tsd.CHALLAN_DT >= :fromDate AND tsd.CHALLAN_DT <= :toDate ";
	public String QUERY_FOR_SEARCH1 = "AND BANK_NAME = :bankName ";
	public String QUERY_FOR_SEARCH2 = "GROUP BY mb.BANK_NAME , upper(  me.EMPLOYEE_NAME||' '|| me.MIDDLE_GUARDIAN_NAME||' '||me.SURNAME ),"
			+ "	tsdcm.SA_DA_ID, tsdcm.FILE_PROCESS_ID, tsdcm.BANK_ID ";
	public String QUERY_TYPE = "SELECT sum(trft.TRANSACTION_AMT) FROM EPAO.TPAO_RBI_FILES_TRANXN trft WHERE trft.RBI_FILE_TRANXN_ID IN (:mapping) ";

	public PagebleDTO<ChallanDistributionSADADto> getAll(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<ChallanDistributionSADA> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<ChallanDistributionSADA> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<ChallanDistributionSADA> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public ListingDto<ChallanDistributionSADA> search(Integer pageNumber, Integer pageSize,
			ChallanDistributionSADADto dto) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ChallanDistributionSADA> query = cb.createQuery(ChallanDistributionSADA.class);
		Root<ChallanDistributionSADA> root = query.from(ChallanDistributionSADA.class);
		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.isNotEmpty(dto.getBankName())) {
			Path<String> exp = root.get("bankName");
			predicates.add(cb.like(exp, "%" + dto.getBankName() + "%"));
		}
		if (StringUtils.isNotEmpty(dto.getSaDaName())) {
			Path<String> exp = root.get("saDaName");
			predicates.add(cb.like(exp, "%" + dto.getSaDaName() + "%"));
		}
		if (null != dto.getDistributeDt()) {
			LocalDateTime startDate = dto.getDistributeDt().toLocalDate().atTime(java.time.LocalTime.MIDNIGHT);
			LocalDateTime endDate = dto.getDistributeDt().toLocalDate().atTime(java.time.LocalTime.MAX);
			if (null != startDate) {
				Path<LocalDateTime> exp = root.get("distributeDt");
				predicates.add(cb.greaterThanOrEqualTo(exp, startDate));
			}
			if (null != endDate) {
				Path<LocalDateTime> exp = root.get("distributeDt");
				predicates.add(cb.lessThan(exp, endDate));
			}
		}

		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		List<ChallanDistributionSADA> list = entityManager.createQuery(query).setMaxResults(pageSize)
				.setFirstResult(pageNumber * pageSize).getResultList();
		int totalElement = entityManager.createQuery(query).getResultList().size();
		return new ListingDto<>(pageSize, totalElement, list);
	}

	@SuppressWarnings("unchecked")
	public ScrollDto searchsScroll(ChallanDistributionSADADto dto) {

		ScrollDto scrolls = new ScrollDto();
		List<BankDto> bankDto = new ArrayList<>();
		List<ChallanDistributionSADADto> challand = new ArrayList<>();
		Query query = entityManager.createNativeQuery(QUERY_FOR_BANK_NAME);
		query.setParameter("fromDate", dto.getFromDate());
		query.setParameter("toDate", dto.getToDate());
		query.setParameter("branchId", dto.getBranchId());
		List<ChallanDistributionSADADto> challan = (BankMapper.mapper(query.getResultList()));
		Query query1 = entityManager.createNativeQuery(QUERY_FOR_SA_DA);
		query1.setParameter("branchId", dto.getBranchId());
		List<SadaDto> saDa = (BankMapper.mappers(query1.getResultList()));
		challan.forEach(bankName -> {
			BankDto bank = new BankDto();
			bank.setBankName(bankName.getBankName());
			bank.setBankId(bankName.getBankId());
			bank.setBankCd(bankName.getBankCd());
			bankDto.add(bank);
		});

		challan.forEach(challans -> {
			ChallanDistributionSADADto e = new ChallanDistributionSADADto();
			List<ChallanDistributionSADA> challands = repository
					.findByFileProcessIdAndBankName(challans.getFileProcessId(), challans.getBankName());
			if (challands.isEmpty()) {
				e.setBankName(challans.getBankName());
				e.setTotalChallans(challans.getTotalChallans());
				e.setAvailableChallans(e.getTotalChallans());
				e.setFileProcessId(challans.getFileProcessId());

			} else {
				challands.forEach(challandd -> {

					if (null != repository.findByFileProcessIdAndBankName(challans.getFileProcessId(),
							challans.getBankName())) {
						e.setBankName(challans.getBankName());
						e.setTotalChallans(challans.getTotalChallans());
						e.setToBeDitributed((short) (e.getToBeDitributed() + challandd.getToBeDitributed()));
						e.setTotalDitributed(challandd.getTotalDitributed());
						e.setAvailableChallans((short) (challans.getTotalChallans() - e.getToBeDitributed()));
						e.setFileProcessId(challans.getFileProcessId());
					} else {
						e.setBankName(challans.getBankName());
						e.setTotalChallans(challans.getTotalChallans());
						e.setAvailableChallans(
								(short) (challandd.getAvailableChallans() - challans.getAvailableChallans()));
						e.setFileProcessId(challans.getFileProcessId());
					}

				});
			}
			challand.add(e);
		});
		scrolls.setSadaName(saDa);
		scrolls.setBankNames(bankDto);
		scrolls.setChallan(challand);
		return scrolls;

	}

	public String doDistribute(List<ChallanDistributionSADADto> dtos) throws CustomException {
		ChallanDistributionSADADto challanDto = new ChallanDistributionSADADto();
		String refrenceNo;
			refrenceNo = getTransactionNo();
			dtos.forEach(challans -> {
				List<Long> mapping = updateSaDaMapping(challans);
				Query query = entityManager.createNativeQuery(QUERY_TYPE);
				query.setParameter("mapping", mapping);
				Double totalAmount = (Double) (query.getSingleResult());
				challanDto.setReferenceDt(LocalDateTime.now());
				challanDto.setDistributeDt(LocalDateTime.now());
				challanDto.setFileProcessId(challans.getFileProcessId());
				challanDto.setBankName(challans.getBankName());
				challanDto.setAvailableChallans((short) (challans.getTotalChallans() - challans.getToBeDitributed()));
				challanDto.setSaDaName(challans.getSaDaName());
				challanDto.setBankCd(challans.getBankCd());
				challanDto.setBankId(challans.getBankId());
				challanDto.setToBeDitributed(challans.getToBeDitributed());
				challanDto.setTotalDitributed(challans.getTotalDitributed());
				challanDto.setTotalChallans(challans.getTotalChallans());
				challanDto.setSaDaId(challans.getSaDaId());
				challanDto.setTotChallanAmt(totalAmount);
				challanDto.setDistributeStatus("Distributed");
				challanDto.setReferenceNo(refrenceNo);
				convertor.toDTO(repository.save(convertor.toEntity(challanDto)));
			});
		
		return "Challans distributed successfully!!";
	}

	private List<Long> updateSaDaMapping(ChallanDistributionSADADto dtos) {
		List<Long> list = new ArrayList<>();

		List<SADAChallanMapping> yan = mappingRepository.findByfileProcessIdAndBankIdAndSaDaId(dtos.getFileProcessId(),
				dtos.getBankId(), dtos.getHaId());

		if (yan.size() >= dtos.getToBeDitributed()) {
			for (int i = 0; i < dtos.getToBeDitributed(); i++) {
				list.add(yan.get(i).getRbiFileTranxnId());
				yan.get(i).setSaDaId(dtos.getSaDaId());
				mappingRepository.save(yan.get(i));
			}
		}

		return list;
	}

	private String getTransactionNo() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();

		map.put(Constant.TRN_SCREEN, ChallanDistributionSADA.TRN_SCREEN_RASB);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

	@SuppressWarnings("unchecked")
	public ScrollDto searchScroll(LoadBalancerHADto dto) {
		ScrollDto scrolls = new ScrollDto();
		Query query;
		if (dto.getBankName().isEmpty()) {
			query = entityManager.createNativeQuery(QUERY_FOR_SEARCH.concat(QUERY_FOR_SEARCH2));
			query.setParameter("fromDate", dto.getFromDate());
			query.setParameter("toDate", dto.getToDate());
		} else {
			query = entityManager
					.createNativeQuery(QUERY_FOR_SEARCH.concat(QUERY_FOR_SEARCH1).concat(QUERY_FOR_SEARCH2));
			query.setParameter("fromDate", dto.getFromDate());
			query.setParameter("toDate", dto.getToDate());
			query.setParameter("bankName", dto.getBankName());
		}
		List<LoadBalancerHADto> loadBalancer = (BankMapper.mapperForBalancer(query.getResultList()));
		Query query1 = entityManager.createNativeQuery(QUERY_FOR_SA_DA);
		query1.setParameter("branchId", dto.getBranchId());
		List<SadaDto> saDa = (BankMapper.mappers(query1.getResultList()));
		scrolls.setLoadBalancerHa(loadBalancer);
		scrolls.setSadaName(saDa);
		return scrolls;

	}

	@SuppressWarnings("unchecked")
	public ScrollDto bankList(ChallanDistributionSADADto dto) {
		ScrollDto bankList = new ScrollDto();
		List<BankDto> bankLists = new ArrayList<>();
		bankRepository.findAll().forEach(banks -> {
			BankDto bank = new BankDto();
			bank.setBankName(banks.getBankName());
			bank.setBankId(banks.getBankId());
			bankLists.add(bank);
		});
		Query query1 = entityManager.createNativeQuery(QUERY_FOR_SA_DA);
		query1.setParameter("branchId", dto.getBranchId());
		List<SadaDto> saDa = (BankMapper.mappers(query1.getResultList()));
		bankList.setSadaName(saDa);
		bankList.setBankNames(bankLists);
		return bankList;

	}

}

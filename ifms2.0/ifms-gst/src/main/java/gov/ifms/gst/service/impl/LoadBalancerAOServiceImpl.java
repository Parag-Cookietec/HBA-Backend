package gov.ifms.gst.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
import gov.ifms.gst.controller.SadaDto;
import gov.ifms.gst.controller.ScrollDto;
import gov.ifms.gst.converter.LoadBalancerAOConvertor;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.dto.LoadBalancerAODto;
import gov.ifms.gst.entity.LoadBalancerAO;
import gov.ifms.gst.entity.SADAChallanMapping;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.repository.LoadBalancerAORepository;
import gov.ifms.gst.repository.SADAChallanMappingRepository;
import gov.ifms.gst.util.GSTConstant;

@Service
public class LoadBalancerAOServiceImpl {
	@Autowired
	private LoadBalancerAOConvertor convertor;

	@Autowired
	private LoadBalancerAORepository repository;

	@Autowired
	private SADAChallanMappingRepository mappingRepository;
	@Autowired
	private ScrollDistributionServiceImpl distributionServiceImpl;

	@Autowired
	private EntityManager entityManager;
	public String QUERY_FOR_SEARCH = "SELECT mb.BANK_NAME, upper(  me.EMPLOYEE_NAME||' '|| me.MIDDLE_GUARDIAN_NAME||' '||me.SURNAME ) AS empname, count(tsdcm.SA_DA_ID), sum(trft.TRANSACTION_AMT), tsdcm.SA_DA_ID,\r\n"
			+ "	tsdcm.FILE_PROCESS_ID, tsdcm.BANK_ID \r\n"
			+ "	FROM epao.TPAO_SCROLL_DISTRIBUTE tsd JOIN EPAO.TPAO_SA_DA_CHALLAN_MAPPING tsdcm ON tsdcm.FILE_PROCESS_ID "
			+ "	JOIN epao.TPAO_RBI_FILES_TRANXN trft ON tsdcm.RBI_FILE_TRANXN_ID = trft.RBI_FILE_TRANXN_ID "
			+ "	JOIN MASTER_V1.MS_EMPLOYEE me ON me.EMPLOYEE_NO  = tsdcm.SA_DA_ID "
			+ "	JOIN MASTER_V1.MS_BANK mb ON mb.BANK_ID  = tsdcm.BANK_ID "
			+ "	WHERE tsd.CHALLAN_DT >= :fromDate AND tsd.CHALLAN_DT <= :toDate ";
	public String QUERY_FOR_SEARCH3 = " AND tsd.BRANCH_ID = :branchName ";
	public String QUERY_FOR_SEARCH1 = "AND BANK_NAME = :bankName ";
	public String QUERY_FOR_SEARCH2 = "GROUP BY mb.BANK_NAME , upper(  me.EMPLOYEE_NAME||' '|| me.MIDDLE_GUARDIAN_NAME||' '||me.SURNAME ),"
			+ "	tsdcm.SA_DA_ID, tsdcm.FILE_PROCESS_ID, tsdcm.BANK_ID ";

	public PagebleDTO<LoadBalancerAODto> getAll(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<LoadBalancerAO> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<LoadBalancerAO> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<LoadBalancerAO> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public ListingDto<LoadBalancerAO> getSearch(Integer pageNumber, Integer pageSize, LoadBalancerAODto dtos) {
		List<LoadBalancerAO> list = new ArrayList<>();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<LoadBalancerAO> query = cb.createQuery(LoadBalancerAO.class);
		Root<LoadBalancerAO> root = query.from(LoadBalancerAO.class);
		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.isNotEmpty(dtos.getBankName())) {
			Path<String> exp = root.get("bankName");
			predicates.add(cb.like(exp, "%" + dtos.getBankName() + "%"));
		}

		if (0 != dtos.getTotalChallans()) {
			Path<Integer> exp = root.get("totalChallans");
			predicates.add(cb.equal(exp, dtos.getTotalChallans()));
		}
		if (0 != dtos.getTotalChallansTrnf()) {
			Path<Integer> exp = root.get("totalChallansTrnf");
			predicates.add(cb.equal(exp, dtos.getTotalChallansTrnf()));
		}
		if (StringUtils.isNotEmpty(dtos.getFromSaDaName())) {
			Path<String> exp = root.get("fromSaDaName");
			predicates.add(cb.like(cb.upper(exp), "%" + dtos.getFromSaDaName() + "%"));
		}
		if (StringUtils.isNotEmpty(dtos.getToSaDaName())) {
			Path<String> exp = root.get("toSaDaName");
			predicates.add(cb.like(cb.upper(exp), "%" + dtos.getToSaDaName() + "%"));
		}
		if (null != dtos.getTotalAmount()) {
			Path<Double> exp = root.get("totalAmount");
			predicates.add(cb.equal(exp, dtos.getTotalAmount()));
		}
		if (null != dtos.getTotalAmountTrnf()) {
			Path<Double> exp = root.get("totalAmountTrnf");
			predicates.add(cb.equal(exp, dtos.getTotalAmountTrnf()));
		}

		if (StringUtils.isNotEmpty(dtos.getToBranchName())) {
			Path<String> exp = root.get("toBranchName");
			predicates.add(cb.like(exp, "%" + dtos.getToBranchName() + "%"));
		}
		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

		entityManager.createQuery(query).setMaxResults(pageSize).setFirstResult(pageNumber * pageSize).getResultList()
				.forEach(loads -> {
					LoadBalancerAO load = new LoadBalancerAO();
					load.setBankName(loads.getBankName());
					load.setToSaDaName(loads.getToSaDaName());
					load.setFromSaDaName(loads.getFromSaDaName());
					load.setTotalAmount(loads.getTotalAmount());
					load.setTotalChallansTrnf(loads.getTotalChallansTrnf());
					load.setTotalAmountTrnf(loads.getTotalAmountTrnf());
					load.setTotalChallans(load.getTotalChallans());
					load.setToBranchName(load.getToBranchName());
					list.add(load);
				});
		int totalElement = entityManager.createQuery(query).getResultList().size();
		return new ListingDto<>(pageSize, totalElement, list);
	}

	@SuppressWarnings("unchecked")
	public ScrollDto searchChallan(LoadBalancerAODto dto) {
		ScrollDto scrolls = new ScrollDto();
		Query query;
		if (dto.getBankName().isEmpty() && dto.getToBranchId() == 0) {
			query = entityManager.createNativeQuery(QUERY_FOR_SEARCH.concat(QUERY_FOR_SEARCH2));
			query.setParameter("fromDate", dto.getFromDate());
			query.setParameter("toDate", dto.getToDate());
		} else if (dto.getToBranchId() == 0) {
			query = entityManager
					.createNativeQuery(QUERY_FOR_SEARCH.concat(QUERY_FOR_SEARCH1).concat(QUERY_FOR_SEARCH2));
			query.setParameter("fromDate", dto.getFromDate());
			query.setParameter("toDate", dto.getToDate());
			query.setParameter("bankName", dto.getBankName());

		} else if (dto.getBankName().isEmpty()) {
			query = entityManager
					.createNativeQuery(QUERY_FOR_SEARCH.concat(QUERY_FOR_SEARCH3).concat(QUERY_FOR_SEARCH2));
			query.setParameter("fromDate", dto.getFromDate());
			query.setParameter("toDate", dto.getToDate());
			query.setParameter("branchName", dto.getToBranchId());
		} else {
			query = entityManager.createNativeQuery(
					QUERY_FOR_SEARCH.concat(QUERY_FOR_SEARCH1).concat(QUERY_FOR_SEARCH3).concat(QUERY_FOR_SEARCH2));
			query.setParameter("fromDate", dto.getFromDate());
			query.setParameter("toDate", dto.getToDate());
			query.setParameter("bankName", dto.getBankName());
			query.setParameter("branchName", dto.getToBranchId());
		}
		List<LoadBalancerAODto> loadBalancer = (BankMapper.mapperForBalancer(query.getResultList()));
		ChallanDistrubutionServiceImpl challanService = new ChallanDistrubutionServiceImpl();
		Query query1 = entityManager.createNativeQuery(challanService.QUERY_FOR_SA_DA);
		query1.setParameter("branchId", dto.getBranchId());
		List<SadaDto> saDa = (BankMapper.mappers(query1.getResultList()));
		scrolls.setLoadBalancerAo(loadBalancer);
		scrolls.setSadaName(saDa);
		return scrolls;

	}

	public String doDistributeAO(List<LoadBalancerAODto> dto) {
		List<LoadBalancerAODto> load = new ArrayList<>();
		dto.forEach(dtos -> {
			List<Long> mapping = updateSaDaMapping(dtos);
			ChallanDistrubutionServiceImpl serice = new ChallanDistrubutionServiceImpl();
			Query query = entityManager.createNativeQuery(serice.QUERY_TYPE);
			query.setParameter("mapping", mapping);
			Double totalAmount = (Double) (query.getSingleResult());

			if (null != repository.findByFromSaDaIdAndBankIdAndToSaDaId(dtos.getFromSaDaId(), dtos.getBankId(),
					dtos.getToSaDaId())) {
				LoadBalancerAO loadBalancerAO = repository.findByFromSaDaIdAndBankIdAndToSaDaId(dtos.getFromSaDaId(),
						dtos.getBankId(), dtos.getToSaDaId());

				loadBalancerAO.setToSaDaName(loadBalancerAO.getFromSaDaName());
				loadBalancerAO.setToSaDaId(loadBalancerAO.getToSaDaId());
				loadBalancerAO.setTotalChallansTrnf(loadBalancerAO.getTotalChallansTrnf());
				loadBalancerAO.setTotalAmountTrnf(loadBalancerAO.getTotalAmount() - totalAmount);
				loadBalancerAO.setToBranchId(loadBalancerAO.getBankId());
				loadBalancerAO.setToBranchName(loadBalancerAO.getToBranchName());
				convertor.toDTO(repository.save(loadBalancerAO));
			} else {
				try {
					dtos.setReferenceDt(LocalDateTime.now());
					dtos.setReferenceNo(getTransactionNo());
					dtos.setTransferDt(new Date());
					dtos.setTotalAmountTrnf(totalAmount);
					dtos.setTotalAmount(dtos.getTotalAmount());
					dtos.setToBranchId(dtos.getToBranchId());
					dtos.setToBranchName(dtos.getToBranchName());
					convertor.toDTO(repository.save(convertor.toEntity(dtos)));
					load.add(dtos);
				} catch (CustomException e) {
					e.printStackTrace();
				}
			}
		});
		return "Distributed successfully!";
	}

	private List<Long> updateSaDaMapping(LoadBalancerAODto dtos) {
		List<Long> list = new ArrayList<>();
		List<SADAChallanMapping> yan = mappingRepository.findByfileProcessIdAndBankIdAndSaDaId(dtos.getFileProcessId(),
				dtos.getBankId(), dtos.getFromSaDaId());
		if (dtos.getToSaDaId() != 0) {
			if (yan.size() >= dtos.getTotalChallansTrnf()) {
				for (int i = 0; i < dtos.getTotalChallansTrnf(); i++) {
					list.add(yan.get(i).getRbiFileTranxnId());
					yan.get(i).setSaDaId(dtos.getToSaDaId());
					mappingRepository.save(yan.get(i));
				}
			}
		} else {
			Query querys = entityManager.createNativeQuery(distributionServiceImpl.QUERY_FOR_HA);
			querys.setParameter("branchId", dtos.getToBranchId());
			Long haId = ((java.math.BigInteger) querys.getResultList().get(0)).longValue();
			if (yan.size() >= dtos.getTotalChallansTrnf()) {
				for (int i = 0; i < dtos.getTotalChallansTrnf(); i++) {
					list.add(yan.get(i).getRbiFileTranxnId());
					yan.get(i).setSaDaId(haId);
					mappingRepository.save(yan.get(i));
				}
			}
		}

		return list;

	}

	private String getTransactionNo() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();

		map.put(Constant.TRN_SCREEN, LoadBalancerAO.TRN_SCREEN_LBAO);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}
}

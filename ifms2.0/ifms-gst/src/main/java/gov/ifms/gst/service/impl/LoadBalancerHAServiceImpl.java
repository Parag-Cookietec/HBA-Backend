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
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.gst.converter.LoadBalancerHAConvertor;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.dto.LoadBalancerHADto;
import gov.ifms.gst.entity.LoadBalancerHA;
import gov.ifms.gst.entity.SADAChallanMapping;
import gov.ifms.gst.repository.LoadBalancerHARepository;
import gov.ifms.gst.repository.SADAChallanMappingRepository;
import gov.ifms.gst.util.GSTConstant;

@Service
public class LoadBalancerHAServiceImpl {

	@Autowired
	private LoadBalancerHAConvertor convertor;

	@Autowired
	private LoadBalancerHARepository repository;

	@Autowired
	private SADAChallanMappingRepository mappingRepository;
	@Autowired
	private EntityManager entityManager;

	public PagebleDTO<LoadBalancerHADto> getAll(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<LoadBalancerHA> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<LoadBalancerHA> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<LoadBalancerHA> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public ListingDto<LoadBalancerHA> getSearch(Integer pageNumber, Integer pageSize, LoadBalancerHADto dtos) {
		List<LoadBalancerHA> list = new ArrayList<>();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<LoadBalancerHA> query = cb.createQuery(LoadBalancerHA.class);
		Root<LoadBalancerHA> root = query.from(LoadBalancerHA.class);
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
		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

		entityManager.createQuery(query).setMaxResults(pageSize).setFirstResult(pageNumber * pageSize).getResultList()
				.forEach(loads -> {
					LoadBalancerHA load = new LoadBalancerHA();
					load.setBankName(loads.getBankName());
					load.setToSaDaName(loads.getToSaDaName());
					load.setFromSaDaName(loads.getFromSaDaName());
					load.setTotalAmount(loads.getTotalAmount());
					load.setTotalChallansTrnf(loads.getTotalChallansTrnf());
					load.setTotalAmountTrnf(loads.getTotalAmountTrnf());
					load.setTotalChallans(loads.getTotalChallans());
					list.add(load);
				});
		int totalElement = entityManager.createQuery(query).getResultList().size();
		return new ListingDto<>(pageSize, totalElement, list);
	}

	public String doDistributeHa(List<LoadBalancerHADto> dto) {
		List<LoadBalancerHADto> load = new ArrayList<>();
		dto.forEach(dtos -> {
			List<Long> mapping = updateSaDaMapping(dtos);
			ChallanDistrubutionServiceImpl serice = new ChallanDistrubutionServiceImpl();
			Query query = entityManager.createNativeQuery(serice.QUERY_TYPE);
			query.setParameter("mapping", mapping);
			Double totalAmount = (Double) (query.getSingleResult());

			if (null != repository.findByFromSaDaIdAndBankIdAndToSaDaId(dtos.getFromSaDaId(), dtos.getBankId(),
					dtos.getToSaDaId())) {
				LoadBalancerHA loadBalancerHA = repository.findByFromSaDaIdAndBankIdAndToSaDaId(dtos.getFromSaDaId(),
						dtos.getBankId(), dtos.getToSaDaId());
				loadBalancerHA.setToSaDaName(dtos.getToSaDaName());
				loadBalancerHA.setToSaDaId(dtos.getToSaDaId());
				loadBalancerHA
						.setTotalChallansTrnf(loadBalancerHA.getTotalChallansTrnf() + dtos.getTotalChallansTrnf());
				loadBalancerHA.setTotalAmountTrnf(loadBalancerHA.getTotalAmount() - totalAmount);
				convertor.toDTO(repository.save(loadBalancerHA));
			} else {
				try {
					dtos.setReferenceDt(LocalDateTime.now());
					dtos.setReferenceNo(getTransactionNo());
					dtos.setTransferDt(new Date());
					dtos.setTotalAmountTrnf(totalAmount);
					dtos.setTotalAmount(dtos.getTotalAmount());
					convertor.toDTO(repository.save(convertor.toEntity(dtos)));
					load.add(dtos);
				} catch (CustomException e) {
					e.printStackTrace();
				}
			}
		});
		return "Distributed successfully!";
	}

	private List<Long> updateSaDaMapping(LoadBalancerHADto dtos) {
		List<Long> list = new ArrayList<>();

		List<SADAChallanMapping> yan = mappingRepository.findByfileProcessIdAndBankIdAndSaDaId(dtos.getFileProcessId(),
				dtos.getBankId(), dtos.getFromSaDaId());

		if (yan.size() >= dtos.getTotalChallansTrnf()) {
			for (int i = 0; i < dtos.getTotalChallansTrnf(); i++) {
				list.add(yan.get(i).getRbiFileTranxnId());
				yan.get(i).setSaDaId(dtos.getToSaDaId());
				mappingRepository.save(yan.get(i));
			}
		}

		return list;

	}

	private String getTransactionNo() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();

		map.put(Constant.TRN_SCREEN, LoadBalancerHA.TRN_SCREEN_LBHA);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

}

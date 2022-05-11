package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPMsBankEntity;
import gov.ifms.edp.repository.EDPMsBankRepository;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.controller.SadaDto;
import gov.ifms.gst.controller.ScrollDto;
import gov.ifms.gst.converter.LoadBalancerHAConvertor;
import gov.ifms.gst.dto.LoadBalancerHADto;
import gov.ifms.gst.entity.LoadBalancerHA;
import gov.ifms.gst.entity.SADAChallanMapping;
import gov.ifms.gst.repository.LoadBalancerHARepository;
import gov.ifms.gst.repository.SADAChallanMappingRepository;

@TestInstance(Lifecycle.PER_CLASS)
class GstLoadBalancerHATest {
	@InjectMocks
	private LoadBalancerHAServiceImpl serviceImpl;
	@InjectMocks
	private ChallanDistrubutionServiceImpl serviceImplS;

	@Mock
	private LoadBalancerHAConvertor convertor;

	@Mock
	private LoadBalancerHARepository repository;
	@Mock
	private LoadBalancerHA entity;
	@Mock
	private LoadBalancerHADto basePostDto;
	@Mock
	private SearchParam searchParam;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private PageRequest pageRequest;
	@Mock
	private PageDetails pageDetail;
	@Mock
	private Page<LoadBalancerHA> dtlPage;
	@Mock
	private SpecificationImpl<LoadBalancerHA> dtlSpec;
	@Mock
	private EntityManager entityManager;
	@Mock
	private CriteriaBuilder criteriaBuilder;
	@Mock
	private Predicate predicate;
	@Mock
	private List<Predicate> predi;
	@Mock
	private CriteriaQuery<LoadBalancerHA> cb;
	@Mock
	private Root<LoadBalancerHA> root;
	@Mock
	private SADAChallanMappingRepository mappingRepository;
	@Mock
	private Query querys;
	@Mock
	private Query query;
	@Mock
	private SadaDto sadaDto;
	@Mock
	private ScrollDto scrolls;
	@Mock
	private EDPMsBankRepository bankRepository;
	@Mock
	private EDPMsBankEntity edpMsBankEntity;
	@Mock
	private Query query2;
	@Mock
	private Query query3;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test challan")
	void testDoDistributed() {
		List<LoadBalancerHADto> list = new ArrayList<>();
		LoadBalancerHADto distributeDto = new LoadBalancerHADto();
		distributeDto.setBankId(1L);
		distributeDto.setFileProcessId(1l);
		distributeDto.setBankName("State bank Of India");
		distributeDto.setTotalChallans((short) 1);
		distributeDto.setBankId(1l);
		distributeDto.setToSaDaId(1l);
		distributeDto.setFromSaDaId(1l);
		distributeDto.setToSaDaName("Test");
		distributeDto.setTotalChallansTrnf(1);
		list.add(distributeDto);
		List<LoadBalancerHADto> lists = new ArrayList<>();
		list.forEach(challans -> {
			List<Long> mapping = updateSaDaMapping(challans);
			when(entityManager.createNativeQuery(serviceImplS.QUERY_TYPE)).thenReturn(querys);
			querys = entityManager.createNativeQuery(serviceImplS.QUERY_TYPE);
			querys.setParameter("mapping", mapping);
			Double totalAmount = (Double) (querys.getSingleResult());
			if (null != repository.findByFromSaDaIdAndBankIdAndToSaDaId(distributeDto.getFromSaDaId(),
					distributeDto.getBankId(), distributeDto.getToSaDaId())) {
				LoadBalancerHA loadBalancerHA = repository.findByFromSaDaIdAndBankIdAndToSaDaId(
						distributeDto.getFromSaDaId(), distributeDto.getBankId(), distributeDto.getToSaDaId());
				loadBalancerHA.setToSaDaName(distributeDto.getToSaDaName());
				loadBalancerHA.setToSaDaId(distributeDto.getToSaDaId());
				loadBalancerHA.setTotalChallansTrnf(
						loadBalancerHA.getTotalChallansTrnf() + distributeDto.getTotalChallansTrnf());
				loadBalancerHA.setTotalAmountTrnf(loadBalancerHA.getTotalAmount() - totalAmount);
				convertor.toDTO(repository.save(loadBalancerHA));
			} else {
				distributeDto.setReferenceDt(LocalDateTime.now());
				Map<String, Object> argMap = new HashMap<>();
				argMap.put(Constant.TRN_SCREEN, LoadBalancerHA.TRN_SCREEN_LBHA);
				when(repository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
						.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.MML_REF_NO));
				distributeDto.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.MML_REF_NO));
				distributeDto.setTransferDt(new Date());
				distributeDto.setTotalAmountTrnf(totalAmount);
				distributeDto.setTotalAmount(distributeDto.getTotalAmount());
				convertor.toDTO(repository.save(convertor.toEntity(distributeDto)));
				lists.add(distributeDto);
			}
		});
		assertNotNull(serviceImpl.doDistributeHa(lists));
	}

	private List<Long> updateSaDaMapping(LoadBalancerHADto dtos) {
		List<Long> list = new ArrayList<>();

		List<SADAChallanMapping> yan = new ArrayList<>();
		when(mappingRepository.findByfileProcessIdAndBankIdAndSaDaId(dtos.getFileProcessId(), dtos.getBankId(),
				dtos.getFromSaDaId())).thenReturn(yan);
		SADAChallanMapping challanMapping = new SADAChallanMapping();
		challanMapping.setBankId(1l);
		yan.add(challanMapping);

		if (yan.size() >= dtos.getTotalChallansTrnf()) {
			for (int i = 0; i < dtos.getTotalChallansTrnf(); i++) {
				list.add(yan.get(i).getRbiFileTranxnId());
				yan.get(i).setSaDaId(dtos.getToSaDaId());
				mappingRepository.save(yan.get(i));
			}
		}

		return list;

	}

	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Test  Get All success.")
	void getAll() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageRequest);
		List<SearchParam> searchParams = new ArrayList<>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(searchCriteria.getSpecificationDetails(dtlSpec, searchParams)).thenReturn(dtlSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class)))
				.thenReturn(dtlPage);
		when(dtlPage.getSize()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(dtlPage.getTotalPages()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(dtlPage.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);
		List<LoadBalancerHA> dtlEntities = new ArrayList<>();
		dtlEntities.add(entity);
		List<LoadBalancerHADto> dtos = new ArrayList<>();
		dtos.add(basePostDto);
		when(convertor.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAll(pageDetail));
	}

	@Test
	@DisplayName("Test Search")
	void testSearchs() {
		basePostDto = new LoadBalancerHADto();
		basePostDto.setBankName("test");
		basePostDto.setToSaDaName("test");
		basePostDto.setFromSaDaName("test");
		basePostDto.setTotalChallans(1);
		basePostDto.setTotalChallansTrnf(1);
		basePostDto.setTotalAmount(2.00);
		basePostDto.setTotalAmountTrnf(2.00);
		when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		when(criteriaBuilder.createQuery(LoadBalancerHA.class)).thenReturn(cb);
		when(cb.from(LoadBalancerHA.class)).thenReturn(root);
		List<Predicate> predicates = new ArrayList<>();

		if (0 != basePostDto.getTotalChallans()) {
			Path<String> exp = root.get("totalChallans");
			when(criteriaBuilder.equal(exp, basePostDto.getTotalChallans())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (0 != basePostDto.getTotalChallansTrnf()) {
			Path<String> exp = root.get("totalChallansTrnf");
			when(criteriaBuilder.equal(exp, basePostDto.getTotalChallansTrnf())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getTotalAmount()) {
			Path<String> exp = root.get("totalAmount");
			when(criteriaBuilder.equal(exp, basePostDto.getTotalAmount())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (0 != basePostDto.getTotalAmountTrnf()) {
			Path<String> exp = root.get("totalAmountTrnf");
			when(criteriaBuilder.equal(exp, basePostDto.getTotalAmountTrnf())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getBankName()) {
			Path<String> exp = root.get("distributeStatus");
			when(criteriaBuilder.equal(exp, basePostDto.getBankName())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getFromSaDaName() && isNotEmpty(basePostDto.getFromSaDaName())) {
			Path<String> exp = root.get("fromSaDaName");
			when(criteriaBuilder.equal(exp, basePostDto.getFromSaDaName())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getToSaDaName() && isNotEmpty(basePostDto.getToSaDaName())) {
			Path<String> exp = root.get("toSaDaName");
			when(criteriaBuilder.equal(exp, basePostDto.getToSaDaName())).thenReturn(predicate);
			predicates.add(predicate);
		}

		/**
		 * when(criteriaBuilder.and(predicates.toArray(new
		 * Predicate[predicates.size()]))).thenReturn(predicate);
		 * cb.select(root).where(predicate);
		 * convertor.toDTO(entityManager.createQuery(cb).getResultList());
		 **/
		assertNotNull(serviceImpl.getSearch(0,0, basePostDto));
	}

	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

	public static boolean isEmpty(String value) {
		return (value == null || value.trim().length() == 0);
	}
}

package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import gov.ifms.gst.converter.ChallanDistrubutionConvertor;
import gov.ifms.gst.dto.BankDto;
import gov.ifms.gst.dto.ChallanDistributionSADADto;
import gov.ifms.gst.dto.LoadBalancerHADto;
import gov.ifms.gst.entity.ChallanDistributionSADA;
import gov.ifms.gst.entity.SADAChallanMapping;
import gov.ifms.gst.repository.ChallanDistruSADARepository;
import gov.ifms.gst.repository.SADAChallanMappingRepository;

@TestInstance(Lifecycle.PER_CLASS)
class GstChallanDistributionTests {
	@InjectMocks
	private ChallanDistrubutionServiceImpl serviceImpl;

	@Mock
	private ChallanDistrubutionConvertor convertor;

	@Mock
	private ChallanDistruSADARepository repository;

	@Mock
	private ChallanDistributionSADA entity;
	@Mock
	private LoadBalancerHADto dto;
	@Mock
	private ChallanDistributionSADADto basePostDto;
	@Mock
	private EntityManager entityManager;
	@Mock
	private CriteriaBuilder criteriaBuilder;
	@Mock
	private SearchParam searchParam;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private PageRequest pageRequest;
	@Mock
	private PageDetails pageDetail;
	@Mock
	private Page<ChallanDistributionSADA> dtlPage;
	@Mock
	private SpecificationImpl<ChallanDistributionSADA> dtlSpec;
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
	@Mock
	private Predicate predicate;
	@Mock
	private List<Predicate> predi;
	@Mock
	private CriteriaQuery<ChallanDistributionSADA> cb;
	@Mock
	private Root<ChallanDistributionSADA> root;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test challan")
	void testDoDistributed() throws CustomException {
		List<ChallanDistributionSADADto> list = new ArrayList<>();
		ChallanDistributionSADADto distributeDto = new ChallanDistributionSADADto();
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.TRN_SCREEN, ChallanDistributionSADA.TRN_SCREEN_RASB);
		when(repository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
				.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.MML_REF_NO));
		distributeDto.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.MML_REF_NO));
		distributeDto.setBankId(1L);
		distributeDto.setSaDaId(1l);
		distributeDto.setFileProcessId(1l);
		distributeDto.setBankName("State bank Of India");
		distributeDto.setTotalChallans((short) 1);
		distributeDto.setToBeDitributed((short) 1);
		distributeDto.setSaDaName("TEST");
		distributeDto.setBankCd("SBI");
		distributeDto.setBankId(1l);
		distributeDto.setTotalDitributed((short) 1);
		distributeDto.setHaId(1l);
		list.add(distributeDto);
		list.forEach(challans -> {
			List<Long> mapping = updateSaDaMapping(challans);
			when(entityManager.createNativeQuery(serviceImpl.QUERY_TYPE)).thenReturn(querys);
			querys = entityManager.createNativeQuery(serviceImpl.QUERY_TYPE);
			querys.setParameter("mapping", mapping);
			Double totalAmount = (Double) (querys.getSingleResult());
			if (!repository.findByBankIdAndSaDaIdAndFileProcessId(challans.getBankId(), challans.getSaDaId(),
					challans.getFileProcessId()).isPresent()) {

				distributeDto.setReferenceDt(LocalDateTime.now());
				distributeDto.setDistributeDt(LocalDateTime.now());
				distributeDto.setFileProcessId(challans.getFileProcessId());
				distributeDto.setBankName(challans.getBankName());
				distributeDto
						.setAvailableChallans((short) (challans.getTotalChallans() - challans.getToBeDitributed()));
				distributeDto.setSaDaName(challans.getSaDaName());
				distributeDto.setBankCd(challans.getBankCd());
				distributeDto.setBankId(challans.getBankId());
				distributeDto.setToBeDitributed(challans.getToBeDitributed());
				distributeDto.setTotalDitributed(challans.getTotalDitributed());
				distributeDto.setTotalChallans(challans.getTotalChallans());
				distributeDto.setSaDaId(challans.getSaDaId());
				distributeDto.setTotChallanAmt(totalAmount);
				distributeDto.setDistributeStatus("Distributed");
				distributeDto.setReferenceNo(distributeDto.getReferenceNo());
				convertor.toDTO(repository.save(convertor.toEntity(distributeDto)));
			} else {
				when(repository.findByBankIdAndSaDaIdAndFileProcessId(challans.getBankId(), challans.getSaDaId(),
						challans.getFileProcessId())).thenReturn(Optional.of(entity));
				entity.setTotChallanAmt(entity.getTotChallanAmt() + totalAmount);
				entity.setToBeDitributed((short) (entity.getToBeDitributed() + challans.getToBeDitributed()));
				entity.setAvailableChallans((short) (entity.getAvailableChallans() - challans.getToBeDitributed()));
				repository.save(entity);
			}

		});
		assertNotNull(serviceImpl.doDistribute(list));
	}
	

	private List<Long> updateSaDaMapping(ChallanDistributionSADADto dtos) {
		List<Long> list = new ArrayList<>();

		List<SADAChallanMapping> yan = new ArrayList<>();
		when(mappingRepository.findByfileProcessIdAndBankIdAndSaDaId(dtos.getFileProcessId(), dtos.getBankId(),
				dtos.getHaId())).thenReturn(yan);
		SADAChallanMapping challanMapping = new SADAChallanMapping();
		challanMapping.setBankId(1l);
		yan.add(challanMapping);
		if (yan.size() >= dtos.getToBeDitributed()) {
			for (int i = 0; i < dtos.getToBeDitributed(); i++) {
				list.add(yan.get(i).getRbiFileTranxnId());
				yan.get(i).setSaDaId(dtos.getSaDaId());
				mappingRepository.save(yan.get(i));
			}
		}

		return list;
	}

	@Test
	@DisplayName("Test challan Search")
	void testSearch() {
		ScrollDto scrolls = new ScrollDto();
		basePostDto = new ChallanDistributionSADADto();
		List<ChallanDistributionSADADto> challanEntitie = new ArrayList<>();
		List<SadaDto> sada = new ArrayList<>();
		List<BankDto> bankDto = new ArrayList<>();
		basePostDto.setFromDate(LocalDateTime.now());
		basePostDto.setToDate(LocalDateTime.now());
		List<String> branch = new ArrayList<>();
		String banc = "test";
		branch.add(banc);
		basePostDto.setBranchId(branch);
		when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_BANK_NAME)).thenReturn(querys);
		querys = entityManager.createNativeQuery(serviceImpl.QUERY_FOR_BANK_NAME);
		Object[] args = { "1", "State BAnk India", "1", "1", "SBI" };
		List<Object[]> arraString = new ArrayList<>();
		arraString.add(args);
		when(querys.getResultList()).thenReturn(arraString);
		arraString.forEach(mappings -> {
			ChallanDistributionSADADto mapping = new ChallanDistributionSADADto();
			mapping.setBankName((String) mappings[1]);
			mapping.setTotalChallans(Short.parseShort((String) mappings[0]));
			mapping.setAvailableChallans((short) (mapping.getTotalChallans() - mapping.getTotalDitributed()));
			mapping.setFileProcessId(Long.parseLong(String.valueOf(mappings[2])));
			mapping.setBankId(Long.parseLong(String.valueOf(mappings[3])));
			mapping.setBankCd((String) mappings[4]);

		});
		when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SA_DA)).thenReturn(query);
		query = entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SA_DA);
		query.setParameter("branchId", basePostDto.getBranchId());
		Object[] arg = { "1", "Test" };
		List<Object[]> arrString = new ArrayList<>();
		arrString.add(arg);
		when(querys.getResultList()).thenReturn(arraString);
		arraString.forEach(saDa -> {
			SadaDto e = new SadaDto();
			e.setSadaName((String) saDa[1]);
			e.setSadaId(Long.parseLong(String.valueOf(saDa[0])));
			sada.add(e);
		});
		arraString.forEach(challan -> {
			ChallanDistributionSADADto e = new ChallanDistributionSADADto();
			ChallanDistributionSADA challanEntity = new ChallanDistributionSADA();
			List<ChallanDistributionSADA> challanEntities = new ArrayList<>();
			when(repository.findByFileProcessIdAndBankName(challanEntity.getFileProcessId(),
					challanEntity.getBankName())).thenReturn(challanEntities);
			challanEntity.setFileProcessId(1l);
			challanEntity.setBankName("State Bank");
			challanEntity.setTotalChallans(Short.parseShort("1"));
			challanEntity.setAvailableChallans(Short.parseShort("1"));
			challanEntity.setToBeDitributed(Short.parseShort("1"));
			challanEntity.setTotalDitributed(Short.parseShort("1"));
			challanEntities.add(challanEntity);
			if (challanEntities.isEmpty()) {
				e.setBankName(challanEntity.getBankName());
				e.setTotalChallans(challanEntity.getTotalChallans());
				e.setAvailableChallans(e.getTotalChallans());
				e.setFileProcessId(challanEntity.getFileProcessId());
			} else {
				challanEntities.forEach(challandd -> {
					if (null != repository.findByFileProcessIdAndBankName(challanEntity.getFileProcessId(),
							challanEntity.getBankName())) {
						e.setBankName(challanEntity.getBankName());
						e.setTotalChallans(challanEntity.getTotalChallans());
						e.setToBeDitributed((short) (e.getToBeDitributed() + challandd.getToBeDitributed()));
						e.setTotalDitributed(challandd.getTotalDitributed());
						e.setAvailableChallans((short) (challanEntity.getTotalChallans() - e.getToBeDitributed()));
						e.setFileProcessId(challanEntity.getFileProcessId());
					} else {
						e.setBankName(challanEntity.getBankName());
						e.setTotalChallans(challanEntity.getTotalChallans());
						e.setAvailableChallans(
								(short) (challandd.getAvailableChallans() - challanEntity.getAvailableChallans()));
						e.setFileProcessId(challanEntity.getFileProcessId());
					}

				});
			}
			challanEntitie.add(e);
		});
		challanEntitie.forEach(bankName -> {
			BankDto bank = new BankDto();
			bank.setBankName(bankName.getBankName());
			bank.setBankId(bankName.getBankId());
			bank.setBankCd(bankName.getBankCd());
			bankDto.add(bank);
		});
		scrolls.setSadaName(sada);
		scrolls.setBankNames(bankDto);
		scrolls.setChallan(challanEntitie);
		assertNotNull(serviceImpl.searchsScroll(basePostDto));

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
		List<ChallanDistributionSADA> dtlEntities = new ArrayList<>();
		dtlEntities.add(entity);
		List<ChallanDistributionSADADto> dtos = new ArrayList<>();
		dtos.add(basePostDto);
		when(convertor.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAll(pageDetail));
	}

	@Test
	@DisplayName("Test Get ALL BankList.")
	void bankList() {
		basePostDto = new ChallanDistributionSADADto();
		List<String> branch = new ArrayList<>();
		String banc = "1";
		branch.add(banc);
		basePostDto.setBranchId(branch);
		ScrollDto bankList = new ScrollDto();
		List<BankDto> bankLists = new ArrayList<>();
		List<EDPMsBankEntity> bank = new ArrayList<>();
		when(bankRepository.findAll()).thenReturn(bank);
		EDPMsBankEntity msBankEntity = new EDPMsBankEntity();
		msBankEntity.setBankName("StateBank");
		msBankEntity.setBankId(1l);
		bank.add(msBankEntity);
		bank.forEach(banks -> {
			BankDto bankDto = new BankDto();
			bankDto.setBankName(banks.getBankName());
			bankDto.setBankId(banks.getBankId());
			bankLists.add(bankDto);
		});

		when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SA_DA)).thenReturn(query);
		query = entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SA_DA);
		query.setParameter("branchId", basePostDto.getBranchId());
		Object[] arg = { "1", "Test" };
		List<Object[]> arrString = new ArrayList<>();
		arrString.add(arg);
		when(querys.getResultList()).thenReturn(arrString);
		List<SadaDto> sada = new ArrayList<>();
		arrString.forEach(saDa -> {
			SadaDto e = new SadaDto();
			e.setSadaName((String) saDa[1]);
			e.setSadaId(Long.parseLong(String.valueOf(saDa[0])));
			sada.add(e);
		});
		bankList.setSadaName(sada);
		bankList.setBankNames(bankLists);
		assertNotNull(serviceImpl.bankList(basePostDto));
	}

	@Test
	@DisplayName("Test search Load.")
	void searchScroll() {
		dto = new LoadBalancerHADto();
		dto.setBankName("StateBank");
		ScrollDto scrolls = new ScrollDto();
		List<String> branch = new ArrayList<>();
		List<SadaDto> sada = new ArrayList<>();
		if (dto.getBankName().isEmpty()) {
			when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SEARCH.concat(serviceImpl.QUERY_FOR_SEARCH2)))
					.thenReturn(query2);
			query2 = entityManager
					.createNativeQuery(serviceImpl.QUERY_FOR_SEARCH.concat(serviceImpl.QUERY_FOR_SEARCH2));
			query2.setParameter("fromDate", dto.getFromDate());
			query2.setParameter("toDate", dto.getToDate());
		} else {
			when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SEARCH.concat(serviceImpl.QUERY_FOR_SEARCH1)
					.concat(serviceImpl.QUERY_FOR_SEARCH2))).thenReturn(query2);
			query2 = entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SEARCH.concat(serviceImpl.QUERY_FOR_SEARCH1)
					.concat(serviceImpl.QUERY_FOR_SEARCH2));
			query2.setParameter("fromDate", dto.getFromDate());
			query2.setParameter("toDate", dto.getToDate());
			query2.setParameter("bankName", dto.getBankName());
		}
		Object[] arg = { "State Bank", "Test", "1", "1.00", "1", "1", "1" };
		List<Object[]> arrString = new ArrayList<>();
		LoadBalancerHADto loads = new LoadBalancerHADto();
		loads.setBankName("State Bank");
		loads.setBankId(1l);
		loads.setFromSaDaName("Test");
		loads.setTotalChallans(1);
		loads.setTotalAmount(1.00);
		loads.setFileProcessId(1l);
		loads.setFromSaDaId(1l);
		arrString.add(arg);
		when(query2.getResultList()).thenReturn(arrString);
		arrString.forEach(load -> {
			LoadBalancerHADto e = new LoadBalancerHADto();
			e.setBankName((String) load[0]);
			e.setFromSaDaName((String) load[1]);
			e.setTotalAmount((Double.parseDouble(String.valueOf(load[3]))));
			e.setTotalChallans(Short.parseShort(String.valueOf(load[2])));
			e.setFileProcessId(Long.parseLong(String.valueOf(load[5])));
			e.setFromSaDaId(Long.parseLong(String.valueOf(load[4])));
			e.setBankId(Long.parseLong(String.valueOf(load[6])));
		});
		when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SA_DA)).thenReturn(query);
		query = entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SA_DA);
		query.setParameter("branchId", basePostDto.getBranchId());
		Object[] args = { "1", "Test" };
		List<Object[]> arraString = new ArrayList<>();
		arraString.add(args);
		when(querys.getResultList()).thenReturn(arraString);
		arraString.forEach(saDa -> {
			SadaDto e = new SadaDto();
			e.setSadaName((String) saDa[1]);
			e.setSadaId(Long.parseLong(String.valueOf(saDa[0])));
			sada.add(e);
		});

		assertNotNull(serviceImpl.searchScroll(dto));
	}
	@Test
	@DisplayName("Test search Load with if condition.")
	void searchScroll1() {
		dto = new LoadBalancerHADto();
		dto.setBankName("");
		ScrollDto scrolls = new ScrollDto();
		List<String> branch = new ArrayList<>();
		List<SadaDto> sada = new ArrayList<>();
		if (dto.getBankName().isEmpty()) {
			when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SEARCH.concat(serviceImpl.QUERY_FOR_SEARCH2)))
					.thenReturn(query2);
			query2 = entityManager
					.createNativeQuery(serviceImpl.QUERY_FOR_SEARCH.concat(serviceImpl.QUERY_FOR_SEARCH2));
			query2.setParameter("fromDate", dto.getFromDate());
			query2.setParameter("toDate", dto.getToDate());
		} else {
			when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SEARCH.concat(serviceImpl.QUERY_FOR_SEARCH1)
					.concat(serviceImpl.QUERY_FOR_SEARCH2))).thenReturn(query2);
			query2 = entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SEARCH.concat(serviceImpl.QUERY_FOR_SEARCH1)
					.concat(serviceImpl.QUERY_FOR_SEARCH2));
			query2.setParameter("fromDate", dto.getFromDate());
			query2.setParameter("toDate", dto.getToDate());
			query2.setParameter("bankName", dto.getBankName());
		}
		Object[] arg = { "State Bank", "Test", "1", "1.00", "1", "1", "1" };
		List<Object[]> arrString = new ArrayList<>();
		LoadBalancerHADto loads = new LoadBalancerHADto();
		loads.setBankName("State Bank");
		loads.setBankId(1l);
		loads.setFromSaDaName("Test");
		loads.setTotalChallans(1);
		loads.setTotalAmount(1.00);
		loads.setFileProcessId(1l);
		loads.setFromSaDaId(1l);
		arrString.add(arg);
		when(query2.getResultList()).thenReturn(arrString);
		arrString.forEach(load -> {
			LoadBalancerHADto e = new LoadBalancerHADto();
			e.setBankName((String) load[0]);
			e.setFromSaDaName((String) load[1]);
			e.setTotalAmount((Double.parseDouble(String.valueOf(load[3]))));
			e.setTotalChallans(Short.parseShort(String.valueOf(load[2])));
			e.setFileProcessId(Long.parseLong(String.valueOf(load[5])));
			e.setFromSaDaId(Long.parseLong(String.valueOf(load[4])));
			e.setBankId(Long.parseLong(String.valueOf(load[6])));
		});
		when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SA_DA)).thenReturn(query);
		query = entityManager.createNativeQuery(serviceImpl.QUERY_FOR_SA_DA);
		query.setParameter("branchId", basePostDto.getBranchId());
		Object[] args = { "1", "Test" };
		List<Object[]> arraString = new ArrayList<>();
		arraString.add(args);
		when(querys.getResultList()).thenReturn(arraString);
		arraString.forEach(saDa -> {
			SadaDto e = new SadaDto();
			e.setSadaName((String) saDa[1]);
			e.setSadaId(Long.parseLong(String.valueOf(saDa[0])));
			sada.add(e);
		});

		assertNotNull(serviceImpl.searchScroll(dto));
	}

	@Test
	@DisplayName("Test Search")
	void testSearchs() {
		basePostDto = new ChallanDistributionSADADto();
		basePostDto.setDistributeDt(LocalDateTime.now());
		basePostDto.setBankName("test");
		basePostDto.setSaDaName("Distributed");
		when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		when(criteriaBuilder.createQuery(ChallanDistributionSADA.class)).thenReturn(cb);
		when(cb.from(ChallanDistributionSADA.class)).thenReturn(root);
		List<Predicate> predicates = new ArrayList<>();
		if (null != basePostDto.getDistributeDt()) {
			LocalDateTime startDate = basePostDto.getDistributeDt().toLocalDate().atTime(java.time.LocalTime.MIDNIGHT);
			LocalDateTime endDate = basePostDto.getDistributeDt().toLocalDate().atTime(java.time.LocalTime.MAX);
			if (null != startDate) {
				Path<LocalDateTime> exp = root.get("distributeDt");
				when(criteriaBuilder.greaterThanOrEqualTo(exp, startDate)).thenReturn(predicate);
				predicates.add(predicate);
			}
			if (null != endDate) {
				Path<LocalDateTime> exp = root.get("distributeDt");
				when(criteriaBuilder.lessThan(exp, endDate)).thenReturn(predicate);
				predicates.add(predicate);
			}
		}
		if (null != basePostDto.getSaDaName()) {
			Path<String> exp = root.get("branchName");
			when(criteriaBuilder.equal(exp, basePostDto.getSaDaName())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getBankName()) {
			Path<String> exp = root.get("distributeStatus");
			when(criteriaBuilder.equal(exp, basePostDto.getBankName())).thenReturn(predicate);
			predicates.add(predicate);
		}

		/**
		 * when(criteriaBuilder.and(predicates.toArray(new
		 * Predicate[predicates.size()]))).thenReturn(predicate);
		 * cb.select(root).where(predicate);
		 * convertor.toDTO(entityManager.createQuery(cb).getResultList());
		 **/
		assertNotNull(serviceImpl.search(0,0,basePostDto));
	}
}

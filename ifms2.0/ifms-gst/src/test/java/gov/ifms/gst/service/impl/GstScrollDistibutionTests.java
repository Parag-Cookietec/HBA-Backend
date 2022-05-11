package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.ScrollDistributionConvertor;
import gov.ifms.gst.dto.ScrollDistributeDto;
import gov.ifms.gst.entity.GSTFileProcess;
import gov.ifms.gst.entity.RBIAccStmtHdr;
import gov.ifms.gst.entity.RBIFileHdr;
import gov.ifms.gst.entity.RBIFileTranxn;
import gov.ifms.gst.entity.SADAChallanMapping;
import gov.ifms.gst.entity.ScrollDistribute;
import gov.ifms.gst.repository.GSTFileProcessRepository;
import gov.ifms.gst.repository.RBIAccStmtHdrRepository;
import gov.ifms.gst.repository.RBIFileHdrRepository;
import gov.ifms.gst.repository.RBIFileTranxnRepository;
import gov.ifms.gst.repository.SADAChallanMappingRepository;
import gov.ifms.gst.repository.ScrollDistributeRepository;

@TestInstance(Lifecycle.PER_CLASS)
class GstScrollDistibutionTests {
	@InjectMocks
	private ScrollDistributionServiceImpl serviceImpl;

	@Mock
	private ScrollDistributionConvertor convertor;

	@Mock
	private ScrollDistributeRepository repository;
	@Mock
	private GSTFileProcessRepository fileProcesRepository;
	@Mock
	private RBIAccStmtHdrRepository stmtRepository;

	@Mock
	private RBIFileHdrRepository fileHdrRepository;
	@Mock
	private EntityManager entityManager;
	@Mock
	private CriteriaBuilder criteriaBuilder;
	@Mock
	private Query querys;
	@Mock
	private Query query;
	@Mock
	private ScrollDistribute entity;
	@Mock
	private SADAChallanMappingRepository mappingRepository;
	@Mock
	private ScrollDistributeDto basePostDto;
	@Mock
	private SearchParam searchParam;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private PageRequest pageRequest;
	@Mock
	private PageDetails pageDetail;
	@Mock
	private GSTFileProcess fileProcess;
	@Mock
	private Predicate predicate;
	@Mock
	private List<Predicate> predi;
	@Mock
	private CriteriaQuery<ScrollDistribute> cb;

	@Mock
	private RBIAccStmtHdr accStmtHdr;

	@Mock
	private RBIFileHdr fileHdr;

	@Mock
	private RBIFileTranxnRepository fileTranxnRepository;

	@Mock
	private Root<ScrollDistribute> root;

	@Mock
	private Page<ScrollDistribute> dtlPage;
	@Mock
	private SpecificationImpl<ScrollDistribute> dtlSpec;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test scroll Search")
	void testScrollSearch() {
		List<ScrollDistributeDto> scroll = new ArrayList<>();
		basePostDto = new ScrollDistributeDto();
		basePostDto.setScrollDt(
				LocalDateTime.parse("2021-09-07 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		List<RBIFileHdr> fileHdrsEntities = new ArrayList<>();
		RBIFileHdr hdr = new RBIFileHdr();
		hdr.setId(1l);
		hdr.setFileRecvDt(LocalDateTime.now());
		hdr.setFileName("test");
		fileHdrsEntities.add(hdr);
		when(fileHdrRepository.findByFileRecvDt(basePostDto.getScrollDt())).thenReturn(fileHdrsEntities);
		fileHdrsEntities.forEach(file -> {
			if (!(repository.findByScrollNo(file.getFileName()).isPresent())) {
				ScrollDistributeDto scrolls = new ScrollDistributeDto();
				List<RBIFileTranxn> rbiFileTranxn = new ArrayList<>();
				RBIFileTranxn trn = new RBIFileTranxn();
				trn.setTotalTransAmt(12.00);
				rbiFileTranxn.add(trn);
				when(fileTranxnRepository.findByRbiFileHdrId(file.getId())).thenReturn(rbiFileTranxn);
				rbiFileTranxn.forEach(files -> {
					scrolls.setTotChallanAmt(scrolls.getTotChallanAmt() + files.getTotalTransAmt());
					scrolls.setNoOfChallans((short) (scrolls.getNoOfChallans() + 1));
					scrolls.setScrollNo(file.getFileName());
					scrolls.setDistributeStatus("PENDING");
					scrolls.setDistributionDt(file.getFileRecvDt());
					scrolls.setFileHdrId(file.getId());
					scrolls.setFileProcessId(file.getId());
				});
				scroll.add(scrolls);
			}
		});
		assertNotNull(serviceImpl.searchScroll(basePostDto));

	}

	@Test
	@DisplayName("Test Search Report")
	void testSearchReport() {
		basePostDto = new ScrollDistributeDto();
		assertNotNull(serviceImpl.scrollReport(basePostDto));

	}

	@Test
	@DisplayName("Test Scroll Verify")
	void testScrollVerify() {
		basePostDto = new ScrollDistributeDto();
		basePostDto.setScrollDt(LocalDateTime.now());
		basePostDto.setFileHdrId((long) 18);
		String string = "";
		when(stmtRepository.findByFileRecvDt(basePostDto.getScrollDt())).thenReturn(Optional.of(accStmtHdr));
		when(fileHdrRepository.findById(basePostDto.getFileHdrId())).thenReturn(Optional.of(fileHdr));
		if (accStmtHdr.getTotCdtEntrySum().equals(fileHdr.getTotEntrySum())) {
			string = "Scroll Verified!!!";
		} else {
			string = "Scroll Not verified return Back to Verification To RBI";
		}
		assertNotNull(serviceImpl.scrollVerify(basePostDto));

	}

	@Test
	@DisplayName("Test Scroll Verify Else Condition")
	void testScrollVerify1() {
		basePostDto = new ScrollDistributeDto();
		basePostDto.setScrollDt(LocalDateTime.now());
		basePostDto.setFileHdrId((long) 18);

		String string = "";
		RBIAccStmtHdr accStmtHdrs = new RBIAccStmtHdr();
		RBIFileHdr fileHdrs = new RBIFileHdr();
		when(stmtRepository.findByFileRecvDt(basePostDto.getScrollDt())).thenReturn(Optional.of(accStmtHdrs));
		accStmtHdrs.setTotCdtEntrySum(2.00);
		fileHdrs.setTotEntrySum(1.00);
		when(fileHdrRepository.findById(basePostDto.getFileHdrId())).thenReturn(Optional.of(fileHdrs));
		if (accStmtHdrs.getTotCdtEntrySum().equals(fileHdrs.getTotEntrySum())) {
			string = "Scroll Verified!!!";
		} else {
			string = "Scroll Not verified return Back to Verification To RBI";
		}
		assertNotNull(serviceImpl.scrollVerify(basePostDto));

	}

	@Test
	@DisplayName("do distributed")
	void testDoDistributed() throws CustomException {
		List<ScrollDistributeDto> list = new ArrayList<>();
		ScrollDistributeDto distributeDto = new ScrollDistributeDto();
		distributeDto.setBranchId(1l);
		distributeDto.setScrollNo("test");
		distributeDto.setFileProcessId(1l);
		list.add(distributeDto);
		list.forEach(scroll -> {

			if (!repository.findByScrollNo(distributeDto.getScrollNo()).isPresent()) {
				distributeDto.setReferenceDt(LocalDateTime.now());
				distributeDto.setDistributeStatus("Distributed");
				when(fileProcesRepository.findByFileName(distributeDto.getScrollNo()))
						.thenReturn(Optional.of(fileProcess));
				distributeDto.setFileProcessId(fileProcess.getId());
				Map<String, Object> argMap = new HashMap<>();
				argMap.put(Constant.TRN_SCREEN, ScrollDistribute.TRN_SCREEN_LBAO);
				when(repository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
						.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.MML_REF_NO));
				distributeDto.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.MML_REF_NO));
				distributeDto.setScrollDt(LocalDateTime.now());
				when(fileProcesRepository.findById(distributeDto.getFileProcessId()))
						.thenReturn(Optional.of(fileProcess));
				distributeDto.setChallanDt(fileProcess.getFileRecvDt());
				repository.save(convertor.toEntity(distributeDto));
				insertSADAMapping(distributeDto);
			}

		});
		assertNotNull(serviceImpl.create(list));
	}

	private void insertSADAMapping(ScrollDistributeDto dto) {
		when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_HA)).thenReturn(querys);
		querys = entityManager.createNativeQuery(serviceImpl.QUERY_FOR_HA);
		querys.setParameter("branchId", dto.getBranchId());
		List<Object> arraStrings = new ArrayList<>();
		arraStrings.add("1");
		when(querys.getResultList()).thenReturn(arraStrings);
		when(entityManager.createNativeQuery(serviceImpl.QUERY)).thenReturn(query);
		query = entityManager.createNativeQuery(serviceImpl.QUERY);
		Object[] args = { "1", "1", "25" };
		List<Object[]> arraString = new ArrayList<>();
		arraString.add(args);
		when(query.getResultList()).thenReturn(arraString);
		arraString.forEach(mappings -> {
			SADAChallanMapping mapping = new SADAChallanMapping();
			mapping.setBankId(Long.parseLong(String.valueOf(mappings[2])));
			mapping.setFileProcessId(Long.valueOf(String.valueOf(mappings[0])));
			mapping.setRbiFileTranxnId(Long.valueOf(String.valueOf(mappings[1])));
			mapping.setSaDaId(Long.valueOf(String.valueOf((arraStrings.get(0)))));
			mappingRepository.save(mapping);
		});
	}

	@Test
	@DisplayName("Test Search")
	void testSearch() {
		basePostDto = new ScrollDistributeDto();
		basePostDto.setFromDate(new Date());
		basePostDto.setToDate(new Date());
		basePostDto.setBranchName("test");
		basePostDto.setDistributeStatus("Distributed");
		basePostDto.setScrollNo("test");
		when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		when(criteriaBuilder.createQuery(ScrollDistribute.class)).thenReturn(cb);
		when(cb.from(ScrollDistribute.class)).thenReturn(root);
		List<Predicate> predicates = new ArrayList<>();
		if (null != basePostDto.getFromDate()) {
			Path<Date> exp = root.get("challanDt");
			when(criteriaBuilder.greaterThanOrEqualTo(exp, basePostDto.getFromDate())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getToDate()) {
			Path<Date> exp = root.get("challanDt");
			when(criteriaBuilder.greaterThanOrEqualTo(exp, basePostDto.getFromDate())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getBranchName()) {
			Path<String> exp = root.get("branchName");
			when(criteriaBuilder.equal(exp, basePostDto.getBranchName())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getDistributeStatus()) {
			Path<String> exp = root.get("distributeStatus");
			when(criteriaBuilder.equal(exp, basePostDto.getDistributeStatus())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (null != basePostDto.getScrollNo()) {
			Path<String> exp = root.get("scrollNo");
			when(criteriaBuilder.like(criteriaBuilder.upper(exp), "%" + basePostDto.getScrollNo() + "%"))
					.thenReturn(predicate);
			predicates.add(predicate);
		}

		/**
		 * when(criteriaBuilder.and(predicates.toArray(new
		 * Predicate[predicates.size()]))).thenReturn(predicate);
		 * cb.select(root).where(predicate);
		 * convertor.toDTO(entityManager.createQuery(cb).getResultList());
		 **/
		assertNotNull(serviceImpl.search(0,0, basePostDto));
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
		List<ScrollDistribute> dtlEntities = new ArrayList<>();
		dtlEntities.add(entity);
		List<ScrollDistributeDto> dtos = new ArrayList<>();
		dtos.add(basePostDto);
		when(convertor.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAll(pageDetail));
	}

}

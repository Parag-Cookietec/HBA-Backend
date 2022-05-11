package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.FileAccountingProcessedConvertor;
import gov.ifms.gst.dto.CreditHeadDto;
import gov.ifms.gst.dto.Dtos;
import gov.ifms.gst.dto.FileAccountingProcessedDto;
import gov.ifms.gst.dto.FileDto;
import gov.ifms.gst.dto.VoucherDto;
import gov.ifms.gst.entity.EODCINFileData;
import gov.ifms.gst.entity.FileAccountingProcessed;
import gov.ifms.gst.entity.GSTFileProcess;
import gov.ifms.gst.entity.GSTFileSummery;
import gov.ifms.gst.repository.FileAccountingProcessedRepository;
import gov.ifms.gst.repository.GSTCINFileDataRepository;
import gov.ifms.gst.repository.GSTFileProcessRepository;
import gov.ifms.gst.repository.GSTFileSummeryRepository;
import gov.ifms.gst.util.DateUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class GstFileAccountingtest {
	@InjectMocks
	private FileAccountingProcessedServiceImpl serviceImpl;

	@Mock
	private FileAccountingProcessedConvertor convertor;

	@Mock
	private FileAccountingProcessedRepository repository;

	@Mock
	private FileAccountingProcessed entity;

	@Mock
	private FileAccountingProcessedDto basePostDto;
	@Mock
	private GSTFileProcessRepository fileRepository;
	@Mock
	private GSTFileSummeryRepository summeryRepository;
	@Mock
	private GSTFileProcess processEntity;
	@Mock
	private GSTFileSummery fileSummery;
	@Mock
	private PageDetails pageDetail;
	@Mock
	private SearchParam searchParam;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private PageRequest pageRequest;
	@Mock
	private Page<FileAccountingProcessed> dtlPage;
	@Mock
	private EODCINFileData eodCinFile;
	@Mock
	private SpecificationImpl<FileAccountingProcessed> dtlSpec;
	@Mock
	private EntityManager entityManager;
	@Mock
	private CriteriaBuilder criteriaBuilder;
	@Mock
	private GSTCINFileDataRepository cinrepository;
	@Mock
	private CriteriaQuery<FileAccountingProcessed> cb;
	@Mock
	private Root<FileAccountingProcessed> root;
	@Mock
	private Predicate predicate;

	@Mock
	private VoucherDto voucherDto;
	@Mock
	private VoucherDto fileDtos;

	@Mock
	private Query query;
	@Mock
	private Query querys;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
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
		List<FileAccountingProcessed> dtlEntities = new ArrayList<>();
		dtlEntities.add(entity);
		List<FileAccountingProcessedDto> dtos = new ArrayList<>();
		dtos.add(basePostDto);
		when(convertor.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAll(pageDetail));
	}

	@Test
	@DisplayName("Test Update GSTFile")
	void testUpdate() {
		basePostDto = new FileAccountingProcessedDto();
		basePostDto.setChallanDt(new Date());
		basePostDto.setFileName("gty");
		basePostDto.setId(1l);
		GSTFileProcess gstFileProcess = new GSTFileProcess();
		gstFileProcess.setFileRecvDt(new Date());
		FileAccountingProcessed accountingProcessed = new FileAccountingProcessed();
		when(fileRepository.findByFileName(basePostDto.getFileName())).thenReturn(Optional.of(gstFileProcess));
		if (Optional.of(gstFileProcess).isPresent()) {
			when(repository.findById(basePostDto.getId())).thenReturn(Optional.of(accountingProcessed));
			if (Optional.of(gstFileProcess).isPresent()) {
				accountingProcessed.setFileProcessId(gstFileProcess);
				accountingProcessed.setChallanDt(gstFileProcess.getFileRecvDt());
				when(entityManager.createNativeQuery(serviceImpl.QUERY)).thenReturn(query);
				accountingProcessed.setChallanDt(new Date());
				query.setParameter("cpinDt", accountingProcessed.getChallanDt());
				Object[] object = { "1", "1.00" };
				when(query.getSingleResult()).thenReturn(object);
				accountingProcessed.setNoOfChallans(Short.parseShort(String.valueOf(object[0])));
				accountingProcessed.setTotChallanAmt(Double.parseDouble(String.valueOf(object[1])));
			}
		}
		try {
			basePostDto.setMenuId(1l);
			assertNotNull(serviceImpl.update(basePostDto));
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Test search by voucherNo GSTFile")
	void search() {
		entity = new FileAccountingProcessed();
		entity.setChallanDt(new Date());
		entity.setVoucherNo("test");
		VoucherDto voucherDto = new VoucherDto();
		voucherDto.setTotalAmount(1.00);
		List<Dtos> dum = new ArrayList<>();
		List<FileDto> fileDtos = new ArrayList<>();
		List<CreditHeadDto> credithead = new ArrayList<>();
		Date fromDate = DateUtil.setTimeToZero(entity.getChallanDt());
		Date toDate = DateUtil.addDays(DateUtil.setTimeToZero(entity.getChallanDt()), 0);
		CreditHeadDto creditheads = new CreditHeadDto();
		FileAccountingProcessed vouchers = new FileAccountingProcessed();
		GSTFileProcess process = new GSTFileProcess();
		process.setId(18l);
		process.setFileName("Test");
		process.setStateCd((short) 1);
		process.setFileTypeCd("CIN");
		FileDto fileDto = new FileDto();
		FileAccountingProcessed fileProcess = new FileAccountingProcessed();
		fileProcess.setVoucherNo("Test");
		fileProcess.setFileProcessId(process);
		fileProcess.setReferenceNo("REF");
		fileProcess.setReferenceDt(new Date());
		when(repository.findByVoucherNo(entity.getVoucherNo())).thenReturn(Optional.of(fileProcess));
		if (Optional.of(fileProcess).isPresent()) {
			voucherDto.setVoucherNo(fileProcess.getVoucherNo());
			voucherDto.setRefrenceNo(fileProcess.getReferenceNo());
			voucherDto.setFileName(fileProcess.getFileProcessId().getFileName());
			voucherDto.setStateCd(fileProcess.getFileProcessId().getStateCd());
			voucherDto.setRefrenceDt(fileProcess.getReferenceDt());
			voucherDto.setFileTypeCd(fileProcess.getFileProcessId().getFileTypeCd());
			when(summeryRepository.findByFileName(voucherDto.getFileName())).thenReturn(Optional.of(fileSummery));
			if (Optional.of(fileSummery).isPresent()) {
				GSTFileSummery file = new GSTFileSummery();
				file.setFileName("Test");
				file.setTotAmt(2.00);
				file.setTotRecCnt(1);
				file.setFileDate(new Date());
				fileDto.setFileName(file.getFileName());
				fileDto.setTotalAmount(file.getTotAmt());
				fileDto.setNoOfTransaction((short) file.getTotRecCnt());
				fileDto.setFileDt(file.getFileDate());
				fileDtos.add(fileDto);
				creditheads.setDescription("STATE GOODS AND SERVICES TAX(SGST) TAX");
				creditheads.setAmount(file.getTotAmt());
				creditheads.setNoOfTransaction((short) 1);
				creditheads.setCreditHead("8658-00-138-01-04-0000");
				credithead.add(creditheads);
			}

		}
		List<EODCINFileData> r = new ArrayList<>();
		when(cinrepository.findByFileTypeCdAndCpinDtBetween(voucherDto.getFileTypeCd(), fromDate)).thenReturn(r);
		EODCINFileData eodcinFileData = new EODCINFileData();
		eodcinFileData.setBankCd("SBIN");
		eodcinFileData.setTotalAmt(1.00);
		r.add(eodcinFileData);
		r.forEach(d -> {
			Dtos dums = new Dtos();
			when(entityManager.createNativeQuery(serviceImpl.QUERY_FOR_BANK_NAME)).thenReturn(querys);
			querys.setParameter("bankCd", d.getBankCd());
			dums.setDescription((String) (query.getSingleResult()));
			dums.setNoOfTransaction(cinrepository.countByBankCd(d.getBankCd()));
			dums.setDebitedHead("8658-00-138-01-04-0000");
			dums.setAmount(d.getTotalAmt());
			voucherDto.setTotalAmount(voucherDto.getTotalAmount() + dums.getAmount());
			dum.add(dums);
		});

		voucherDto.setCreditHead(credithead);
		voucherDto.setDtos(dum);
		voucherDto.setFileDto(fileDtos);
		assertNotNull(serviceImpl.search(entity));
	}

	@Test
	@DisplayName("Test Search")
	void testSearch() {
		basePostDto = new FileAccountingProcessedDto();
		basePostDto.setFromDate(new Date());
		basePostDto.setToDate(new Date());
		basePostDto.setReferenceNo("test");
		basePostDto.setFileName("Distributed");
		when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		when(criteriaBuilder.createQuery(FileAccountingProcessed.class)).thenReturn(cb);
		when(cb.from(FileAccountingProcessed.class)).thenReturn(root);
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
		if (null != basePostDto.getReferenceNo()) {
			Path<String> exp = root.get("referenceNo");
			when(criteriaBuilder.equal(exp, basePostDto.getReferenceNo())).thenReturn(predicate);
			predicates.add(predicate);
		}
		GSTFileProcess process = new GSTFileProcess();
		process.setId(1l);
		if (basePostDto.getFileName() != "")
			when(fileRepository.findByFileNameContains(basePostDto.getFileName())).thenReturn(Optional.of(process));
		if (Optional.of(process).isPresent()) {
			if (!(Objects.isNull(process.getId()))) {
				Path<String> exp = root.get("fileProcessId");
				when(criteriaBuilder.equal(exp, process.getId())).thenReturn(predicate);
				predicates.add(predicate);
			}
		}

		
		/**
		 * when(criteriaBuilder.and(predicates.toArray(new
		 * Predicate[predicates.size()]))).thenReturn(predicate);
		 * cb.select(root).where(predicate);
		 * convertor.toDTO(entityManager.createQuery(cb).getResultList());
		 **/
		assertNotNull(serviceImpl.getSearch(0,0, basePostDto));
	}

}

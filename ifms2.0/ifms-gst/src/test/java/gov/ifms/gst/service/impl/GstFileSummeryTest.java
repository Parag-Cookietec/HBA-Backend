package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
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

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.GSTFileSummeryConvertor;
import gov.ifms.gst.dto.DifferenceDto;
import gov.ifms.gst.dto.GSTFileSummeryDto;
import gov.ifms.gst.dto.GSTNDto;
import gov.ifms.gst.entity.EODCINFileData;
import gov.ifms.gst.entity.GSTFileSummery;
import gov.ifms.gst.repository.GSTFileSummeryRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class GstFileSummeryTest {
	@InjectMocks
	private GSTFileSummeryServiceImpl serviceImpl;

	@Mock
	private GSTFileSummeryConvertor convertor;

	@Mock
	private GSTFileSummeryRepository repository;

	@Mock
	private GSTFileSummery entity;

	@Mock
	private GSTNDto dtos;

	@Mock
	private GSTFileSummeryDto basePostDto;
	@Mock
	private SearchParam searchParam;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private PageRequest pageRequest;
	@Mock
	private Page<GSTFileSummery> dtlPage;
	@Mock
	private EODCINFileData eodCinFile;
	@Mock
	private SpecificationImpl<GSTFileSummery> dtlSpec;
	@Mock
	private PageDetails pageDetail;
	@Mock
	private EntityManager entityManager;
	@Mock
	private CriteriaBuilder criteriaBuilder;
	@Mock
	private Predicate predicate;
	@Mock
	private List<Predicate> predi;
	@Mock
	private CriteriaQuery<GSTFileSummery> cb;
	@Mock
	private Root<GSTFileSummery> root;
	@Mock
	private IdDto idDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Search By File Names")
	void testSearchByFileNames() {
		GSTFileSummeryDto basePostDto = new GSTFileSummeryDto();
		List<GSTFileSummery> dtos = new ArrayList<>();
		List<String> fileNames = new ArrayList<>();
		fileNames.add("ABC");
		fileNames.add("DEF");
		basePostDto.setFileNames(fileNames);
		GSTFileSummery entity = new GSTFileSummery();
		entity.setFileName("Test");
		entity.setFileType("CIN");
		entity.setCessAmt(1.00);
		entity.setCgstAmt(1.00);
		dtos.add(entity);
		List<GSTFileSummeryDto> dto = new ArrayList<>();
		when(repository.findByFileNameIn(basePostDto.getFileNames())).thenReturn(dtos);
		dtos.forEach(fileSummery -> {
			GSTFileSummeryDto fileSummeryDto = convertor.toDTO(fileSummery);
			dto.add(fileSummeryDto);
		});
		assertNotNull(serviceImpl.serachBy(basePostDto));

	}

	@Test
	@DisplayName("Search By File Names")
	void searchByDateThroughGstn() throws ParseException {
		GSTNDto dtos = new GSTNDto();
		dtos.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
		List<GSTNDto> dto = new ArrayList<>();
		if (dtos.getFileDt().equals(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")))) {
			GSTNDto gstn = new GSTNDto();
			gstn.setCgstAmt(300.00);
			gstn.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
			gstn.setStateCd(25);
			gstn.setIgstAmt(52.22);
			gstn.setFileCnt(3);
			gstn.setRecCnt(200);
			gstn.setFileType("CPIN");
			gstn.setCessAmt(400.00);
			gstn.setIgstAmt(400.00);
			gstn.setSgstAmt(300.00);
			gstn.setTotalAmt(1400.00);
			gstn.setFileName("RUGIEFNHREU453893");
			dto.add(gstn);
			GSTNDto gstn1 = new GSTNDto();
			gstn1.setCgstAmt(300.00);
			gstn1.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
			gstn1.setStateCd(25);
			gstn1.setIgstAmt(52.22);
			gstn1.setFileCnt(3);
			gstn1.setRecCnt(200);
			gstn1.setFileType("CIN");
			gstn1.setCessAmt(400.00);
			gstn1.setIgstAmt(400.00);
			gstn1.setSgstAmt(300.00);
			gstn1.setTotalAmt(1400.00);
			gstn1.setFileName("RUGIEFNHREU453896");
			dto.add(gstn1);
		} else {
			GSTNDto gstn = new GSTNDto();
			gstn.setCgstAmt(300.00);
			gstn.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
			gstn.setStateCd(25);
			gstn.setIgstAmt(52.22);
			gstn.setFileCnt(3);
			gstn.setRecCnt(200);
			gstn.setFileType("CPIN");
			gstn.setCessAmt(400.00);
			gstn.setIgstAmt(400.00);
			gstn.setSgstAmt(300.00);
			gstn.setTotalAmt(1400.00);
			gstn.setFileName("RUGIEFNHREU453893");
			dto.add(gstn);
			GSTNDto gstn1 = new GSTNDto();
			gstn1.setCgstAmt(300.00);
			gstn1.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
			gstn1.setStateCd(25);
			gstn1.setIgstAmt(52.22);
			gstn1.setFileCnt(3);
			gstn1.setRecCnt(200);
			gstn1.setFileType("CIN");
			gstn1.setCessAmt(400.00);
			gstn1.setIgstAmt(400.00);
			gstn1.setSgstAmt(300.00);
			gstn1.setTotalAmt(1400.00);
			gstn1.setFileName("RUGIEFNHREU453896");
			dto.add(gstn1);
		}
		assertNotNull(serviceImpl.searchByDateThroughGstn(dtos));
	}

	@Test
	@DisplayName("Search elsepart")
	void searchByDateThroughGstn1() throws ParseException {
		GSTNDto dtos = new GSTNDto();
		dtos.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
		List<GSTNDto> dto = new ArrayList<>();
		if (dtos.getFileDt().equals(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")))) {
			GSTNDto gstn = new GSTNDto();
			gstn.setCgstAmt(300.00);
			gstn.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
			gstn.setStateCd(25);
			gstn.setIgstAmt(52.22);
			gstn.setFileCnt(3);
			gstn.setRecCnt(200);
			gstn.setFileType("CPIN");
			gstn.setCessAmt(400.00);
			gstn.setIgstAmt(400.00);
			gstn.setSgstAmt(300.00);
			gstn.setTotalAmt(1400.00);
			gstn.setFileName("RUGIEFNHREU453893");
			dto.add(gstn);
			GSTNDto gstn1 = new GSTNDto();
			gstn1.setCgstAmt(300.00);
			gstn1.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
			gstn1.setStateCd(25);
			gstn1.setIgstAmt(52.22);
			gstn1.setFileCnt(3);
			gstn1.setRecCnt(200);
			gstn1.setFileType("CIN");
			gstn1.setCessAmt(400.00);
			gstn1.setIgstAmt(400.00);
			gstn1.setSgstAmt(300.00);
			gstn1.setTotalAmt(1400.00);
			gstn1.setFileName("RUGIEFNHREU453896");
			dto.add(gstn1);
		} else {
			GSTNDto gstn = new GSTNDto();
			gstn.setCgstAmt(300.00);
			gstn.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
			gstn.setStateCd(25);
			gstn.setIgstAmt(52.22);
			gstn.setFileCnt(3);
			gstn.setRecCnt(200);
			gstn.setFileType("CPIN");
			gstn.setCessAmt(400.00);
			gstn.setIgstAmt(400.00);
			gstn.setSgstAmt(300.00);
			gstn.setTotalAmt(1400.00);
			gstn.setFileName("RUGIEFNHREU453893");
			dto.add(gstn);
			GSTNDto gstn1 = new GSTNDto();
			gstn1.setCgstAmt(300.00);
			gstn1.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
			gstn1.setStateCd(25);
			gstn1.setIgstAmt(52.22);
			gstn1.setFileCnt(3);
			gstn1.setRecCnt(200);
			gstn1.setFileType("CIN");
			gstn1.setCessAmt(400.00);
			gstn1.setIgstAmt(400.00);
			gstn1.setSgstAmt(300.00);
			gstn1.setTotalAmt(1400.00);
			gstn1.setFileName("RUGIEFNHREU453896");
			dto.add(gstn1);
		}
		assertNotNull(serviceImpl.searchByDateThroughGstn(dtos));
	}

	@Test
	@DisplayName("Search diffrence")
	void diffrence() throws ParseException {
		GSTNDto dtos = new GSTNDto();
		DifferenceDto diffrenceDto = new DifferenceDto();
		List<GSTNDto> gstnDto = new ArrayList<>();
		List<GSTFileSummeryDto> readFiles = new ArrayList<>();
		dtos.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
		List<GSTNDto> dto = searchByDateThrough(dtos);
		dto.forEach(Gstn -> {
			GSTNDto gstn = new GSTNDto();
			GSTFileSummeryDto readFile = new GSTFileSummeryDto();
			GSTFileSummery entitys = new GSTFileSummery();
			when(repository.findByFileDateAndFileType(Gstn.getFileDt(), Gstn.getFileType()))
					.thenReturn(Optional.of(entitys));
			if (Optional.of(entity).isPresent()) {
				when(repository.findByFileDateAndFileType(Gstn.getFileDt(), Gstn.getFileType()))
						.thenReturn(Optional.of(entitys));
				entitys.setTotFileCnt(1);
				entitys.setCgstAmt(1.00);
				entitys.setCessAmt(1.00);
				entitys.setSgstAmt(1.00);
				entitys.setIgstAmt(1.00);
				entitys.setTotAmt(4.00);
				entitys.setFileName("Test");
				entitys.setFileType("CIN");
				entitys.setStateCd((short) 25);
				entitys.setFileDate(new Date());
				GSTFileSummery r = Optional.of(entitys).get();
				if (!(Gstn.getFileCnt() == (r.getTotFileCnt()))) {
					gstn.setCessAmt(Gstn.getCessAmt() - r.getCessAmt());
					gstn.setIgstAmt(Gstn.getIgstAmt() - r.getIgstAmt());
					gstn.setCgstAmt(Gstn.getCgstAmt() - r.getCgstAmt());
					gstn.setSgstAmt(Gstn.getSgstAmt() - r.getSgstAmt());
					gstn.setFileCnt(Gstn.getFileCnt() - r.getTotFileCnt());
					gstn.setRecCnt(Gstn.getRecCnt());
					gstn.setFileDt(r.getFileDate());
					gstn.setStateCd(r.getStateCd());
					gstn.setFileType(r.getFileType());
					gstn.setFileName(r.getFileName());
					readFile.setCessAmt(r.getCessAmt());
					readFile.setCgstAmt(r.getSgstAmt());
					readFile.setIgstAmt(r.getIgstAmt());
					readFile.setFileDate(r.getFileDate());
					readFile.setFileName(r.getFileName());
					readFile.setFileType(r.getFileType());
					readFile.setSgstAmt(r.getSgstAmt());
					readFile.setTotFileCnt(r.getTotFileCnt());
					readFile.setTotRecCnt(Gstn.getRecCnt());
					readFile.setStateCd(r.getStateCd());
					readFile.setTotAmt(r.getTotAmt());
					gstn.setTotalAmt(Gstn.getTotalAmt() - readFile.getTotAmt());
					readFiles.add(readFile);
				}
			} else {
				gstn.setCessAmt(Gstn.getCessAmt());
				gstn.setIgstAmt(Gstn.getIgstAmt());
				gstn.setCgstAmt(Gstn.getCgstAmt());
				gstn.setSgstAmt(Gstn.getSgstAmt());
				gstn.setTotalAmt(Gstn.getTotalAmt());
				gstn.setFileCnt(Gstn.getFileCnt());
				gstn.setRecCnt(Gstn.getRecCnt());
				gstn.setFileDt(Gstn.getFileDt());
				gstn.setStateCd(Gstn.getStateCd());
				gstn.setFileType(Gstn.getFileType());
				gstn.setFileName(Gstn.getFileName());
			}
			gstnDto.add(gstn);
		});
		diffrenceDto.setDiffrenceFile(gstnDto);
		diffrenceDto.setReadFile(readFiles);
		assertNotNull(serviceImpl.diffrence(dtos));
	}

	@Test
	@DisplayName("Search diffrence else Part")
	void diffrence1() throws ParseException {
		GSTNDto dtos = new GSTNDto();
		DifferenceDto diffrenceDto = new DifferenceDto();
		List<GSTNDto> gstnDto = new ArrayList<>();
		List<GSTFileSummeryDto> readFiles = new ArrayList<>();
		dtos.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
		List<GSTNDto> dto = searchByDateThrough1(dtos);
		dto.forEach(Gstn -> {
			GSTNDto gstn = new GSTNDto();
			GSTFileSummeryDto readFile = new GSTFileSummeryDto();
			GSTFileSummery entitys = new GSTFileSummery();
			when(repository.findByFileDateAndFileType(Gstn.getFileDt(), Gstn.getFileType()))
					.thenReturn(Optional.of(entitys));
			if (Optional.of(entity).isPresent()) {
				when(repository.findByFileDateAndFileType(Gstn.getFileDt(), Gstn.getFileType()))
						.thenReturn(Optional.of(entitys));
				entitys.setTotFileCnt(3);
				entitys.setCgstAmt(1.00);
				entitys.setCessAmt(1.00);
				entitys.setSgstAmt(1.00);
				entitys.setIgstAmt(1.00);
				entitys.setTotAmt(4.00);
				entitys.setFileName("Test");
				entitys.setFileType("CIN");
				entitys.setStateCd((short) 25);
				entitys.setFileDate(new Date());
				GSTFileSummery r = Optional.of(entitys).get();
				if (!(Gstn.getFileCnt() == (r.getTotFileCnt()))) {
					gstn.setCessAmt(Gstn.getCessAmt() - r.getCessAmt());
					gstn.setIgstAmt(Gstn.getIgstAmt() - r.getIgstAmt());
					gstn.setCgstAmt(Gstn.getCgstAmt() - r.getCgstAmt());
					gstn.setSgstAmt(Gstn.getSgstAmt() - r.getSgstAmt());
					gstn.setFileCnt(Gstn.getFileCnt() - r.getTotFileCnt());
					gstn.setRecCnt(Gstn.getRecCnt());
					gstn.setFileDt(r.getFileDate());
					gstn.setStateCd(r.getStateCd());
					gstn.setFileType(r.getFileType());
					gstn.setFileName(r.getFileName());
					readFile.setCessAmt(r.getCessAmt());
					readFile.setCgstAmt(r.getSgstAmt());
					readFile.setIgstAmt(r.getIgstAmt());
					readFile.setFileDate(r.getFileDate());
					readFile.setFileName(r.getFileName());
					readFile.setFileType(r.getFileType());
					readFile.setSgstAmt(r.getSgstAmt());
					readFile.setTotFileCnt(r.getTotFileCnt());
					readFile.setTotRecCnt(Gstn.getRecCnt());
					readFile.setStateCd(r.getStateCd());
					readFile.setTotAmt(r.getTotAmt());
					gstn.setTotalAmt(Gstn.getTotalAmt() - readFile.getTotAmt());
					readFiles.add(readFile);
				}
			} else {
				gstn.setCessAmt(Gstn.getCessAmt());
				gstn.setIgstAmt(Gstn.getIgstAmt());
				gstn.setCgstAmt(Gstn.getCgstAmt());
				gstn.setSgstAmt(Gstn.getSgstAmt());
				gstn.setTotalAmt(Gstn.getTotalAmt());
				gstn.setFileCnt(Gstn.getFileCnt());
				gstn.setRecCnt(Gstn.getRecCnt());
				gstn.setFileDt(Gstn.getFileDt());
				gstn.setStateCd(Gstn.getStateCd());
				gstn.setFileType(Gstn.getFileType());
				gstn.setFileName(Gstn.getFileName());
			}
			gstnDto.add(gstn);
		});
		diffrenceDto.setDiffrenceFile(gstnDto);
		diffrenceDto.setReadFile(readFiles);
		assertNotNull(serviceImpl.diffrence(dtos));
	}

	private List<GSTNDto> searchByDateThrough1(GSTNDto dtos2) {
		List<GSTNDto> dto = new ArrayList<>();
		if (dtos2.getFileDt().equals(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")))) {
			GSTNDto gstn = new GSTNDto();
			gstn.setCgstAmt(300.00);
			gstn.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
			gstn.setStateCd(25);
			gstn.setIgstAmt(52.22);
			gstn.setFileCnt(3);
			gstn.setRecCnt(200);
			gstn.setFileType("CPIN");
			gstn.setCessAmt(400.00);
			gstn.setIgstAmt(400.00);
			gstn.setSgstAmt(300.00);
			gstn.setTotalAmt(1400.00);
			gstn.setFileName("RUGIEFNHREU453893");
			dto.add(gstn);
			GSTNDto gstn1 = new GSTNDto();
			gstn1.setCgstAmt(300.00);
			gstn1.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
			gstn1.setStateCd(25);
			gstn1.setIgstAmt(52.22);
			gstn1.setFileCnt(3);
			gstn1.setRecCnt(200);
			gstn1.setFileType("CIN");
			gstn1.setCessAmt(400.00);
			gstn1.setIgstAmt(400.00);
			gstn1.setSgstAmt(300.00);
			gstn1.setTotalAmt(1400.00);
			gstn1.setFileName("RUGIEFNHREU453896");
			dto.add(gstn1);
		} else {
			GSTNDto gstn = new GSTNDto();
			gstn.setCgstAmt(300.00);
			gstn.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
			gstn.setStateCd(25);
			gstn.setIgstAmt(52.22);
			gstn.setFileCnt(3);
			gstn.setRecCnt(200);
			gstn.setFileType("CPIN");
			gstn.setCessAmt(400.00);
			gstn.setIgstAmt(400.00);
			gstn.setSgstAmt(300.00);
			gstn.setTotalAmt(1400.00);
			gstn.setFileName("RUGIEFNHREU453893");
			dto.add(gstn);
			GSTNDto gstn1 = new GSTNDto();
			gstn1.setCgstAmt(300.00);
			gstn1.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
			gstn1.setStateCd(25);
			gstn1.setIgstAmt(52.22);
			gstn1.setFileCnt(3);
			gstn1.setRecCnt(200);
			gstn1.setFileType("CIN");
			gstn1.setCessAmt(400.00);
			gstn1.setIgstAmt(400.00);
			gstn1.setSgstAmt(300.00);
			gstn1.setTotalAmt(1400.00);
			gstn1.setFileName("RUGIEFNHREU453896");
			dto.add(gstn1);
		}
		return dto;
	}

	private List<GSTNDto> searchByDateThrough(GSTNDto dtos2) {
		List<GSTNDto> dto = new ArrayList<>();
		if (dtos2.getFileDt().equals(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")))) {
			GSTNDto gstn = new GSTNDto();
			gstn.setCgstAmt(300.00);
			gstn.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
			gstn.setStateCd(25);
			gstn.setIgstAmt(52.22);
			gstn.setFileCnt(3);
			gstn.setRecCnt(200);
			gstn.setFileType("CPIN");
			gstn.setCessAmt(400.00);
			gstn.setIgstAmt(400.00);
			gstn.setSgstAmt(300.00);
			gstn.setTotalAmt(1400.00);
			gstn.setFileName("RUGIEFNHREU453893");
			dto.add(gstn);
			GSTNDto gstn1 = new GSTNDto();
			gstn1.setCgstAmt(300.00);
			gstn1.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-06")));
			gstn1.setStateCd(25);
			gstn1.setIgstAmt(52.22);
			gstn1.setFileCnt(3);
			gstn1.setRecCnt(200);
			gstn1.setFileType("CIN");
			gstn1.setCessAmt(400.00);
			gstn1.setIgstAmt(400.00);
			gstn1.setSgstAmt(300.00);
			gstn1.setTotalAmt(1400.00);
			gstn1.setFileName("RUGIEFNHREU453896");
			dto.add(gstn1);
		} else {
			GSTNDto gstn = new GSTNDto();
			gstn.setCgstAmt(300.00);
			gstn.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
			gstn.setStateCd(25);
			gstn.setIgstAmt(52.22);
			gstn.setFileCnt(3);
			gstn.setRecCnt(200);
			gstn.setFileType("CPIN");
			gstn.setCessAmt(400.00);
			gstn.setIgstAmt(400.00);
			gstn.setSgstAmt(300.00);
			gstn.setTotalAmt(1400.00);
			gstn.setFileName("RUGIEFNHREU453893");
			dto.add(gstn);
			GSTNDto gstn1 = new GSTNDto();
			gstn1.setCgstAmt(300.00);
			gstn1.setFileDt(java.sql.Date.valueOf(LocalDate.parse("2021-09-08")));
			gstn1.setStateCd(25);
			gstn1.setIgstAmt(52.22);
			gstn1.setFileCnt(3);
			gstn1.setRecCnt(200);
			gstn1.setFileType("CIN");
			gstn1.setCessAmt(400.00);
			gstn1.setIgstAmt(400.00);
			gstn1.setSgstAmt(300.00);
			gstn1.setTotalAmt(1400.00);
			gstn1.setFileName("RUGIEFNHREU453896");
			dto.add(gstn1);
		}
		return dto;
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
		List<GSTFileSummery> dtlEntities = new ArrayList<>();
		dtlEntities.add(entity);
		List<GSTFileSummeryDto> dtos = new ArrayList<>();
		dtos.add(basePostDto);
		when(convertor.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getFileSummerys(pageDetail));
	}

	@SuppressWarnings("static-access")
	@Test
	@DisplayName("Test Search")
	void testSearch() {
		basePostDto = new GSTFileSummeryDto();
		basePostDto.setFromDate(new Date());
		basePostDto.setToDate(new Date());
		basePostDto.setFileName("Test");
		Integer pageNumber = 1;
		when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		when(criteriaBuilder.createQuery(GSTFileSummery.class)).thenReturn(cb);
		when(cb.from(GSTFileSummery.class)).thenReturn(root);
		List<Predicate> predicates = new ArrayList<>();
		boolean fileName = null != basePostDto.getFileName() && isNotEmpty(basePostDto.getFileName());
		boolean fileFromDate = null != basePostDto.getFromDate();
		boolean fileToDate = null != basePostDto.getToDate();
		if (fileFromDate) {
			Path<Date> exp = root.get("fileDate");
			when(criteriaBuilder.greaterThanOrEqualTo(exp, basePostDto.getFromDate())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (fileToDate) {
			Path<Date> exp = root.get("fileDate");
			when(criteriaBuilder.greaterThanOrEqualTo(exp, basePostDto.getFromDate())).thenReturn(predicate);
			predicates.add(predicate);
		}
		if (fileName) {
			Path<String> exp = root.get("fileName");
			when(criteriaBuilder.like(criteriaBuilder.upper(exp), "%" + basePostDto.getFileName() + "%"))
					.thenReturn(predicate);
			predicates.add(predicate);
		}
		/**if (fileName || fileFromDate || fileToDate) {
			when(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).thenReturn(predicate);
			cb.select(root).where(predicate);
			convertor.toDTO(entityManager.createQuery(cb).setMaxResults(serviceImpl.PAGE_SIZE)
					.setFirstResult(pageNumber * serviceImpl.PAGE_SIZE).getResultList());
		}**/
		assertNotNull(serviceImpl.serachByName(0, basePostDto));
	}

	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

	public static boolean isEmpty(String value) {
		return (value == null || value.trim().length() == 0);
	}

}

package gov.ifms.gst.service.impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
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
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.gst.converter.GSTFileSummeryConvertor;
import gov.ifms.gst.dto.DifferenceDto;
import gov.ifms.gst.dto.GSTFileSummeryDto;
import gov.ifms.gst.dto.GSTNDto;
import gov.ifms.gst.entity.GSTFileSummery;
import gov.ifms.gst.repository.GSTFileSummeryRepository;

@Service
public class GSTFileSummeryServiceImpl {
	public static final int PAGE_SIZE = 5;
	@Autowired
	private GSTFileSummeryConvertor fileSummeryConvertor;

	@Autowired
	private GSTFileSummeryRepository fileSummeryRepository;

	@Autowired
	private EntityManager entityManager;
	
	public List<GSTFileSummeryDto> serachByName(Integer pageNumber, GSTFileSummeryDto dtos) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GSTFileSummery> query = cb.createQuery(GSTFileSummery.class);
		Root<GSTFileSummery> root = query.from(GSTFileSummery.class);
		List<Predicate> predicates = new ArrayList<>();
		List<GSTFileSummeryDto> list = new ArrayList<>();
		boolean fileName = StringUtils.isNotEmpty(dtos.getFileName());
		boolean fileFromDate = null != dtos.getFromDate();
		boolean fileToDate = null != dtos.getToDate();

		if (fileName) {
			Path<String> exp = root.get("fileName");
			predicates.add(cb.like(cb.upper(exp), "%" + dtos.getFileName() + "%"));
		}

		if (fileFromDate) {
			Path<Date> exp = root.get("fileDate");
			predicates.add(cb.greaterThanOrEqualTo(exp, dtos.getFromDate()));
		}

		if (fileToDate) {
			Path<Date> exp = root.get("fileDate");
			predicates.add(cb.lessThanOrEqualTo(exp, dtos.getToDate()));
		}
		if (fileName || fileFromDate || fileToDate) {
			query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
			list = fileSummeryConvertor.toDTO(entityManager.createQuery(query).setMaxResults(PAGE_SIZE)
					.setFirstResult(pageNumber * PAGE_SIZE).getResultList());
		}
		return list;
	}

	public List<GSTFileSummeryDto> serachBy(GSTFileSummeryDto dto) {
		List<GSTFileSummeryDto> dtos = new ArrayList<>();
		fileSummeryRepository.findByFileNameIn(dto.getFileNames()).forEach(f -> {
			GSTFileSummeryDto fileSummeryDto = fileSummeryConvertor.toDTO(f);
			dtos.add(fileSummeryDto);
		});
		return dtos;
	}

	public PagebleDTO<GSTFileSummeryDto> getFileSummerys(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<GSTFileSummery> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<GSTFileSummery> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<GSTFileSummery> page = fileSummeryRepository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					fileSummeryConvertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public List<GSTNDto> searchByDateThroughGstn(GSTNDto dtos) throws ParseException {
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
		return dto;
	}

	public DifferenceDto diffrence(GSTNDto dtos) throws ParseException {
		DifferenceDto diffrenceDto = new DifferenceDto();
		List<GSTNDto> gstnDto = new ArrayList<>();
		List<GSTFileSummeryDto> readFiles = new ArrayList<>();
		List<GSTNDto> dto = searchByDateThroughGstn(dtos);
		dto.forEach(Gstn -> {
			GSTNDto gstn = new GSTNDto();
			GSTFileSummeryDto readFile = new GSTFileSummeryDto();
			if (fileSummeryRepository.findByFileDateAndFileType(Gstn.getFileDt(), Gstn.getFileType()).isPresent()) {
				GSTFileSummery r = fileSummeryRepository.findByFileDateAndFileType(Gstn.getFileDt(), Gstn.getFileType())
						.get();
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
		return diffrenceDto;
	}
}

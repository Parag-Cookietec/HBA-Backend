package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUDeemedDateConverter;
import gov.ifms.pvu.dto.PVUDeemedDateDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUDeemedDateEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUDeemedDateRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUDeemedDateServiceImpl.
 */
@Service
public class PVUDeemedDateServiceImpl implements PVUDeemedDateService {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PVUDeemedDateServiceImpl.class.getName());

	/**
	 * The PVUDeemedDateRepository repository.
	 */
	@Autowired
	private PVUDeemedDateRepository repository;

	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	/**
	 * The PVUDeemedDateConverter converter.
	 */
	@Autowired
	private PVUDeemedDateConverter converter;

	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Autowired
	private PVYFacade pvuFacade;

	@Autowired
	private PVUCommonService pvuCommonService;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Autowired
	private OAuthService authService;

	/**
	 * The EDPMsDesignationRepository depRepository.
	 */
	@Autowired
	private PVUEmployeDepartmentRepository depRepository;

	@Autowired
	private PVUMsPayScaleRepository scaleRepository;

	@Autowired
	private PVUEmployeEventsRepository pvuEmployeEventsRepository;

	/**
	 * Retrieves an PVUDeemedDateEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUDeemedDateEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUDeemedDateEntity getPVUDeemedDate(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUDeemedDateEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUDeemedDateEntity
	 */

	@Trace
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUDeemedDateDto saveOrUpdatePVUDeemedDate(PVUDeemedDateDto dto) throws CustomException {
		PVUDeemedDateEntity entity = converter.toEntity(dto);
		if (dto.getStatusId() == 0) {
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(entity.getEmployee().getEmpId());
			entity.setStatus(this.eDPLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
		}
		entity = repository.save(entity);
		long empNo = dto.getEmployeeNo();
		dto = this.converter.toDTO(entity);
		dto.setEmployeeNo(empNo);
		return dto;
	}

	/**
	 * Fetch all the PVUDeemedDate items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUDeemedDateDto>
	 */
	@Override
	public PagebleDTO<PVUDeemedDateDto> getPVUDeemedDates(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUDeemedDateEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUDeemedDateEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUDeemedDateEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			LOGGER.error(ex.toString());
			throw new CustomException(HttpStatus.CONFLICT, "ERROR WHILE FETCHING ROW!");
		}
	}

	/*
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 *
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_PROMOTION_LOOKUPS_SP));
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupPromotionSp(procName);
		return lstPVUEmployeCreationDDLView.stream()
				.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
	}

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUDeemedDateDto insertDeemedItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		PVUDeemedDateDto pvuDeemedDateDto;
		Date approvedDate = new Date();
		PVUDeemedDateEntity pvuDeemedDateEntity = getPVUDeemedDate(pvuWFWrapperDto.getTrnId());
		EDPLuLookUpInfoEntity empApprovStatsLookupInfo = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.APPROVED);

		if (pvuDeemedDateEntity.getTrnNo() == null) {
			PVUEmployeeEventStatusEntity statusEntry = pvuEmployeeEventStatusService
					.inProgressAnyEvent(pvuDeemedDateEntity.getEmployee().getEmpId());
			pvuDeemedDateEntity.setRefDate(LocalDateTime.now());
			pvuDeemedDateEntity.setTrnNo(this.pvuCommonService.getTransactionNumber("DD"));
			repository.save(pvuDeemedDateEntity);
			pvuEmployeeEventStatusService.updateEventInfo(statusEntry, pvuDeemedDateEntity.getTrnNo());
		}

		if (pvuDeemedDateEntity.getStatus().getLookUpInfoId() == empApprovStatsLookupInfo.getLookUpInfoId()) {
			throw new CustomException(ErrorResponse.TRN_ALREADY_APPROVED);
		}
		boolean check = pvuFacade.callWorkFlowApis(pvuWFWrapperDto);
		if (check) {
			EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = eDPLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.SUBMIT);
			if (empSubmitStatusLookupInfo != null) {
				repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
						OAuthUtility.getCurrentUserUserId(), approvedDate);
			}
			pvuDeemedDateDto = converter.toDTO(pvuDeemedDateEntity);
			if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
				pvuDeemedDateEntity.setStatus(empApprovStatsLookupInfo);
				toEntityOfEmpEvent(pvuDeemedDateDto, pvuDeemedDateEntity.getEmployee(), pvuWFWrapperDto.getWfStatus());
				repository.updateStatusId(empApprovStatsLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
						OAuthUtility.getCurrentUserUserId(), approvedDate);
				reset(pvuDeemedDateEntity.getEmployee().getEmpId());
				insertDeemedDateAutoIncr(pvuDeemedDateEntity.getTrnNo());
			} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
				EDPLuLookUpInfoEntity empRejectStatsLookupInfo = eDPLuLookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.REJECTED);
				repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
						OAuthUtility.getCurrentUserUserId(), approvedDate);
				reset(pvuDeemedDateEntity.getEmployee().getEmpId());
			}
			insertDeemedDateInITRs(pvuWFWrapperDto);
		} else {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
		}

		return pvuDeemedDateDto;
	}

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public boolean deleteDeemedDateEventById(IdDto idDto) throws CustomException {
		Optional<PVUDeemedDateEntity> deemedDateEntity = repository.findById(idDto.getId());
		if (deemedDateEntity.isPresent()) {
			PVUDeemedDateEntity entity = deemedDateEntity.get();
			EDPLuLookUpInfoEntity saveAsDraft = eDPLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (entity.getStatus().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				if (entity.getEmployee() != null && entity.getEmployee().getEmpId() != 0) {
					pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(entity.getEmployee().getEmpId(),
							OAuthUtility.getCurrentUserLkPOUId());
				}
				repository.deleteDeemedDateEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						OAuthUtility.getCurrentUserUserId(), new Date());
				return Boolean.TRUE;
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}

	private void insertDeemedDateInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_EVENT_NAME, PvuConstant.EVENT_NAME_DEEMED);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_COMMON_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Lookup employee EOL creation sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupPromotionSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Update emp event status.
	 *
	 * @param empId the empId
	 */
	private void reset(Long empId) throws CustomException {
		PVUEmployeeEventStatusEntity employeeStatus = pvuEmployeeEventStatusService.findOneByEmpId(empId);
		employeeStatus.setDeemedDate(0);
		employeeStatus.setTransId(null);
		pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(employeeStatus);
	}

	public void toEntityOfEmpEvent(PVUDeemedDateDto dto, PVUEmployeEntity employee, String wfStatus) {

		try {
			PVUEmployeEventsEntity employeeEventsEntity = new PVUEmployeEventsEntity();

			Map<String, Object> map = new LinkedHashMap<>();
			map.put(Constant.IN_TRN_NO, dto.getTrnNo());
			map.put(Constant.IN_STATUS_ID, wfStatus);
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_APPROVE_DEEMED_DATE));
			repository.callStoredProcedure(procName, map);
			employeeEventsEntity.setTrnNo(dto.getTrnNo());
			employeeEventsEntity.setEmpBasicPay(dto.getBasicPay());
			employeeEventsEntity.setDepartmentCategoryId(dto.getDepartmentCategoryId());
			employeeEventsEntity.setEventDate(LocalDateTime.of(dto.getEventEffectiveDate(), LocalTime.MIN));
			employeeEventsEntity.setEventDate(LocalDateTime.of(dto.getEventEffectiveDate(), LocalTime.MIN));
			employeeEventsEntity.setEmpNextIncrDate(LocalDateTime.of(dto.getDateOfNextIncrement(), LocalTime.MIN));
			employeeEventsEntity.setEmpDesignation(dto.getDesignationId());
			employeeEventsEntity.setEmpOption(dto.getOptionAvailableId() == 2L ? 1L : 0L);
			employeeEventsEntity.setEmpOptionAvalDate(dto.getOptionAvailableDate());
			employeeEventsEntity.setPayCommission(dto.getPayCommId());
			employeeEventsEntity.setOfficeId(dto.getOfficeId());
			employeeEventsEntity.setEventType(PvuConstant.MANUAL);
			employeeEventsEntity.setEventId(PvuConstant.DEEMED_DATE_EVENT_ID);
			employeeEventsEntity.setSourceId(PvuConstant.DEEMED_DATE_EVENT_ID);
			employeeEventsEntity.setEmployeeClassId(dto.getEmployeeClassId());
			if (dto.getPayCommId() == 150) {
				employeeEventsEntity.setPayScale(dto.getPayScale());
			}

			if (dto.getPayCommId() == 151) {
				employeeEventsEntity.setEmpPayBand(dto.getPayBandId());
				employeeEventsEntity.setEmpGrdPay(dto.getGradePayId());
				employeeEventsEntity.setPayBandValue(dto.getPayBandValue());
			}
			if (dto.getPayCommId() == 152) {
				employeeEventsEntity.setCellId(dto.getCellId());
				employeeEventsEntity.setEmpPaylevel(dto.getPayLevelId());
			}
			employeeEventsEntity.setEventName(PvuConstant.EVENT_NAME_DEEMED_DATE);
			employeeEventsEntity.setEmpId(employee.getEmpId());
			employeeEventsEntity.setActiveStatus(dto.getActiveStatus());
			employeeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
			setRevisionNo(employeeEventsEntity);
			pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeeEventsEntity);
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
		}
	}

	@Override
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException {
		return generatePdf(dto);
	}

	public String generatePdf(IdDto dto) throws CustomException {
		String htmltoPdf = null;
		Map<String, Object> map = new HashMap<>();
		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		try {

			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Deemed Date Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			writer.write(generatePrint(dto).toString());
			
			map.put("content", writer.toString());
			htmltoPdf = pvuCommonService.htmlToPdfRequest(map);
			
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + PvuConstant.EVENT_CODE_DEEMED_DATE + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			LOGGER.info("PDF generated successfully");

			return htmltoPdf;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public StringWriter generatePrint(IdDto dto) {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();

		PVUDeemedDateEntity entity = this.getPVUDeemedDate(dto.getId());
		VelocityContext context = converter.populateVContext(entity);
		context.put("APPROVER_NAME", String.valueOf(authService.getOnlyIdAndName(entity.getUpdatedBy()).getName()));
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getUserDesgnationFromUserId(),
				map);
		context.put("APPROVER_DESIGNATION", String.valueOf(objects.get(0)[0]));
		PVUEmployeDepartmentEntity dep = depRepository
				.findFirstByPvuEmployeEntityEmpId(entity.getAgainstEmployee().getEmpId());
		context.put("J_DESIGNATION", dep.getDesignationId().getDesignationName());
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("PAYSCALE", this.scaleRepository.getOnlyIdAndName(entity.getPayScale()).getName());
			boolean status = PvuUtils.compareToLocalDate(entity.getEventEffectiveDate(),
					PvuUtils.getDateFromStringYMD(PvuConstant.EVENT_EFFICTED_DATE_5_PAY));
			if (status) {
				context.put("CIVIL", PvuConstant.G_CIVIL);
				context.put("CIVIL_SUB", PvuConstant.G_CIVIL_SUB);
				context.put("PRA_CIVIL",
						PvuConstant.G_PRA_CIVIL_OPTION + entity.getOptionAvailable().getLookUpInfoName());
			} else {
				context.put("CIVIL", PvuConstant.B_CIVIL);
				context.put("CIVIL_SUB", PvuConstant.B_CIVIL_SUB);
				context.put("PRA_CIVIL",
						PvuConstant.B_PRA_CIVIL_OPTION + entity.getOptionAvailable().getLookUpInfoName());
			}
			setIncreament(entity, context);
		}
		Template template = getPrintTemplate(entity);
		template.merge(context, writer);
		return writer;
	}

	public Template getPrintTemplate(PVUDeemedDateEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template tempName = new Template();
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/deemedDate/deemedDate7.vm");
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/deemedDate/deemedDate6.vm");
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/deemedDate/deemedDate5.vm");
		}
		return tempName;
	}

	@Override
	public String generateComparisionReport(IdDto dto) throws IOException, CustomException, DocumentException {
		return generateComparisionPdf(dto);
	}

	public String generateComparisionPdf(IdDto dto) throws CustomException {
		String htmltoPdf = null;
		Map<String, Object> map = new HashMap<>();
		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		try {

			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Deemed Date Event Comparision Report");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			writer.write(generateComparisionPrint(dto).toString());
			
			map.put("content", writer.toString());
			htmltoPdf = pvuCommonService.htmlToPdfRequest(map);
			
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + PvuConstant.EVENT_CODE_DEEMED_DATE + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			LOGGER.info("PDF generated successfully");

			return htmltoPdf;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}

	}

	public StringWriter generateComparisionPrint(IdDto dto) throws CustomException {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		PVUCommonApiDto pvuCommonApiDto = new PVUCommonApiDto();
		PVUEmployeDepartmentEntity dep = new PVUEmployeDepartmentEntity();
		PVUDeemedDateEntity entity = this.getPVUDeemedDate(dto.getId());

		if (!Utils.isEmpty(entity.getAgainstEmployee())) {
			Map<String, Object> map1 = new HashMap<>();
			map1.put("IN_PAGE_INDEX", 0);
			map1.put("IN_PAGE_SIZE", 10);
			map1.put("IN_EFFECTIVE_DATE", PvuUtils.getStrOfLocalDateInYMD(entity.getBenefitEffectiveDate()));
			map1.put("IN_PAY_COMM", entity.getPayComm().getLookUpInfoId());
			map1.put("IN_EVENT_ID", 0);
			map1.put("IN_EMPLOYEE_NO", entity.getAgainstEmployee().getEmployeeCode());
			map1.put("IN_OFFICE_ID", entity.getOffice().getOfficeId());
			pvuCommonApiDto = pvuCommonService.getCommonDetailsBasedOnEventDate(map1);

			dep = depRepository.findFirstByPvuEmployeEntityEmpId(entity.getAgainstEmployee().getEmpId());
		}

		PVUEmployeEventsEntity employeEventsEntity = pvuEmployeEventsService
				.findLatestEvent(entity.getEmployee().getEmpId());

		if (employeEventsEntity != null && entity.getLastPfDate() == null) {
			entity.setLastPfDate(employeEventsEntity.getEventDate().toLocalDate());
		}
		VelocityContext context = converter.comparisionReport(entity, pvuCommonApiDto);

		context.put("sr_last_pay_fixation_date",
				!Utils.isEmpty(entity.getLastPfDate()) ? PvuUtils.getStrOfLocalDateInDMY(entity.getLastPfDate()) : "");

		context.put("jn_emp_designation",
				!Utils.isEmpty(dep.getDesignationId()) ? dep.getDesignationId().getDesignationName() : "");

		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID
				&& !Utils.isEmpty(entity.getPayScale())) {
			context.put("sr_revised_pay_scale", this.scaleRepository.getOnlyIdAndName(entity.getPayScale()).getName());
		} else {
			context.put("sr_revised_pay_scale", "");
		}

		Map<String, Object> map = new HashMap<>();
		map.put("trnId", dto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getDeemedDateApproverRemarks(),
				map);
		if (objects != null && !objects.isEmpty() && objects.get(0) != null) {
			context.put("sr_other_details",
					(objects.get(0).length != 0 && String.valueOf(objects.get(0)[0]) != null)
							? String.valueOf(objects.get(0)[0])
							: "");
		} else {
			context.put("sr_other_details", "");
		}

		Template template = getComparisionPrintTemplate();
		template.merge(context, writer);
		return writer;
	}

	public Template getComparisionPrintTemplate() {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		return ve.getTemplate("templates/deemedDate/deemedDateComparision.vm");
	}

	public void insertDeemedDateAutoIncr(String trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_DEEMED_DATE);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

	private void setIncreament(PVUDeemedDateEntity entity, VelocityContext context) {
		List<PVUEmployeEventsEntity> entities = pvuEmployeEventsRepository
				.findAllByEmpIdAndPayCommissionAndActiveStatus(entity.getEmployee().getEmpId(),
						PvuConstant.FIFTH_COMMISSION_ID, 1);
		long total = entity.getcBasicPay();
		List<IdNameDto> list = new ArrayList<>();
		for (PVUEmployeEventsEntity entiti : entities) {
			if ("Auto Increment".equalsIgnoreCase(entiti.getEventName())
					|| "Notional Increment".equalsIgnoreCase(entiti.getEventName())) {
				IdNameDto pairDto = new IdNameDto();
				pairDto.setId(entiti.getEmpBasicPay() - entity.getBasicPay());
				pairDto.setName(PvuUtils.getStrOfLocalDateTimeInDDMMYYYY(entiti.getEmpNextIncrDate()));
				total = total + pairDto.getId();
				list.add(pairDto);
			}
		}
		context.put("events", list);
		context.put("Total", total);
	}

	/**
	 * Sets the revision no.
	 *
	 * @param employeeEventsEntity the new revision no
	 * @throws CustomException the custom exception
	 */
	private void setRevisionNo(PVUEmployeEventsEntity employeeEventsEntity) throws CustomException {
		try {
			employeeEventsEntity.setRevisionNo(pvuEmployeEventsService
					.getLatestRevisionNo(employeeEventsEntity.getEmpId(), employeeEventsEntity.getPayCommission()));
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}

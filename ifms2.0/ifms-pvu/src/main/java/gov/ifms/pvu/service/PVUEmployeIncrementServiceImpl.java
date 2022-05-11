package gov.ifms.pvu.service;

import com.ibm.db2.jcc.am.SqlException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUIncrementEmpSDConverter;
import gov.ifms.pvu.converter.PVUIncrementMainEventConverter;
import gov.ifms.pvu.converter.PVUIncrementSTPSDConverter;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUIncrementEmpEntity;
import gov.ifms.pvu.entity.PVUIncrementEmpSDEntity;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.entity.PVUIncrementSTPSDEntity;
import gov.ifms.pvu.repository.PVUIncrementEmpSDRepository;
import gov.ifms.pvu.repository.PVUIncrementEventRepository;
import gov.ifms.pvu.repository.PVUIncrementSTPSDRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * The Class PVUIncrementEventController.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 */
@Service
public class PVUEmployeIncrementServiceImpl implements PVUEmployeIncrementService {

    /**
	 * The logger.
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The PVUIncrementEventAsMethodName repository.
	 */
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private PVUIncrementEventRepository repository;

	/**
	 * The PVUIncrementEventAsMethodName helper.
	 */
	@Autowired
	private PVUIncrementMainEventConverter converter;

	@Autowired
	private PVUIncrementSTPSDConverter stopConverter;

	@Autowired
	private PVUIncrementSTPSDRepository stopRepo;

	@Autowired
	private PVUIncrementEmpSDService pvuIncrementEmpSDService;

	@Autowired
	private PVUEmployeIncrementEventSummaryService pvuIncSummaryService;

	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Autowired
	private PVYFacade pvuFacade;

	/**
	 * Lookup repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Autowired
	private PVUCommonService commonService;

	@Autowired
	private OAuthService authService;

	@Autowired
	private PVUIncrementEmpSDConverter pvuIncrementEmpSDConverter;

	@Autowired
	private PVUIncrementEmpSDRepository pvuIncrementEmpSDRepository;


	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName)
			throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = repository.storeProc(procName,
					PVUEmployeCreationDDLView.class);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	@Override
	public PVURegularIncrementListView getRegularEmployeeIncrementList(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = buildPageInMap(pageDetail, getPvuSearchFields());
		PVURegularIncrementListView objStorePro = getRegularEmployeeIncrementList(map, pageDetail);
		return objStorePro;
	}


	public PVURegularIncrementListView getRegularEmployeeIncrementList(PageDetails pageDetail,Map<String,Object> map) throws CustomException {
		//Map<String, Object> map = buildPageInMap(pageDetail, getPvuSearchFields());
		PVURegularIncrementListView objStorePro = getRegularEmployeeIncrementList(map, pageDetail);
		return objStorePro;
	}

	public PVURegularIncrementListView getRegularEmployeeIncrementList(Map<String, Object> map, PageDetails pageDetail)
			throws CustomException {
		try {
			PVURegularIncrementListView pvuRegularIncrementListView = callStoredProcedureWithMultipleOutput(map,
					pageDetail);
			return pvuRegularIncrementListView;
		} catch (PersistenceException ex) {
			Throwable th = ex.getCause();
			Throwable throwable = th.getCause();
			SqlException sqlException = (SqlException) (throwable);
			String sErro = sqlException.getSqlca().getSqlErrmc().toString();
			throw new CustomException(HttpStatus.NOT_FOUND, sErro);
		} catch (Exception ex) {
			throw new CustomException(HttpStatus.NOT_FOUND,
					((SqlException) ex.getCause()).getSqlca().getSqlErrmc().toString());
		}
	}

	public PVURegularIncrementListView callStoredProcedureWithMultipleOutput(Map<String, Object> attributesMap,
			PageDetails pageDetail) throws PersistenceException {
		try {
			String spName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_GET_REGLR_INCRMNT_LIST));
			Map<String, Object> obj = repository.callStoredProcedureMap(spName, attributesMap);
			List<PVURegularIncrementEligibleListView> eligibleListViews = (List<PVURegularIncrementEligibleListView>) obj
					.get(PvuConstant.RESULT_SET_1);
			List<PVURegularIncrementNonEligibleListView> nonEligibleListViews = (List<PVURegularIncrementNonEligibleListView>) obj
					.get(PvuConstant.RESULT_SET_2);
			List<PVURegularIncrementSmryView> pvuRegularIncrementSmryViews = (List<PVURegularIncrementSmryView>) obj
					.get(PvuConstant.RESULT_SET_3);
			PVURegularIncrementListView pvuRegularIncrementListView = new PVURegularIncrementListView();
			pvuRegularIncrementListView.setEligibleDto(
					new PagebleDTO<>(pageDetail.getPageElement(), 0, eligibleListViews.size(), eligibleListViews));
			pvuRegularIncrementListView.setNonEligibledtos(new PagebleDTO<>(pageDetail.getPageElement(), 0,
					nonEligibleListViews.size(), nonEligibleListViews));
			pvuRegularIncrementListView.setPvuRegularIncrementSmryView(pvuRegularIncrementSmryViews);
			return pvuRegularIncrementListView;
		} catch (NoResultException e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_CARDEX,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_DISTRICT,
				PVUSearchEnum.PVU_SEARCH_PAY_INCR_FOR, PVUSearchEnum.PVU_SEARCH_FIELD_FINANCIAL_YEAR_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_PAY_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_FIELD_In_CGP_NO_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_In_CGP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_DATE_NXT_INCR,
				PVUSearchEnum.PVU_SEARCH_FIELD_INCR_EFFECTIVE_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_LEVEL);
	}

	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPageInMap(PageDetails pageDetail, List<PVUSearchEnum> lstSearchEum) {
		IdDto idDto = new IdDto();
		idDto.setId(OAuthUtility.getCurrentUserUserId());
		List<IdDto> lst = new ArrayList<>();
		lst.add(idDto);

		StringBuilder stringBuilder = new StringBuilder();
		for (IdDto dto : lst) {
			stringBuilder.append((dto.getId().toString())).append(Constant.COMMA);
		}
		Map<String, String> collect = lstSearchEum.stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(stringBuilder, pageDetail, collect);
	}

	@Override
	public PVUIncrementEventEntity saveOrUpdateIncrementEvent(PVUIncrementEventEntity entity) throws CustomException {
		return repository.save(entity);
	}

	@Override
	public PVUIncrementMainEventDto saveOrUpdateIncrementEventEmpSummary(PVUIncrementMainEventDto dto)
			throws CustomException {
		List<PVUIncrementEmpSDDto> lstPVUIncrementEmpDtos = dto.getPvuIncrementEmpSDDtos();
		PVUIncrementEventEntity entity = null;/// done
		PVUIncrementEventEntity requestedEntity = null;/// done
		EDPLuLookUpInfoEntity statusId = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
		boolean oldTransaction = Utils.isOldTransaction(dto.getInEventId());
		requestedEntity = converter.toEntity(dto);
		if (oldTransaction) {
			entity = saveOrUpdateIncrementEvent(requestedEntity);
		} else {
			requestedEntity.setStatusId(statusId);
			entity = saveOrUpdateIncrementEvent(requestedEntity);
		}
		List<Long> empIds = new ArrayList<>();
		if (!Utils.isEmpty(lstPVUIncrementEmpDtos)) {
			final long eventId = entity.getInEventId();
			final long transactionStatus = entity.getStatusId().getLookUpInfoId();
			if (lstPVUIncrementEmpDtos.stream().anyMatch(e -> e.getIdEmpSDId() == 0)) {
				pvuIncrementEmpSDService.deleteIrrelevantEmployeeFromTransaction(entity.getInEventId());
			}
			lstPVUIncrementEmpDtos.forEach(e -> {
							// create employee list of stop increment
				e.setInEventId(eventId);
				e.setStatusId(transactionStatus);
				if (e.getReasonForExclusion() != null) {
					e.getReasonForExclusion().setInEventId(e.getInEventId());
					e.getReasonForExclusion().setEmpId(e.getEmpId());
					e.getReasonForExclusion().setStpStartDate(e.getRevEffDate());
					e.getReasonForExclusion().setStatusId(e.getStatusId());
				} else {
					if (!Utils.isEmpty(e.getIdEmpSDId())) {
						empIds.add(e.getIdEmpSDId());
					}
				}

			});
			lstPVUIncrementEmpDtos = pvuIncrementEmpSDService.saveOrUpdateIncrementEmpDto(lstPVUIncrementEmpDtos);
			if (empIds.size() > 0) {
				stopRepo.deleteAllByEmployeeSdid(empIds);
			}

		}
		dto = converter.toDTO(entity);
		dto.setPvuIncrementEmpSDDtos(lstPVUIncrementEmpDtos);
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.IN_TRN_ID, dto.getInEventId());
		map.put(PvuConstant.IN_CGP_NO_TYPE, dto.getCpfGpfPpan());
		map.put(PvuConstant.IN_CGP_NO, dto.getGpf());
		map.put(PvuConstant.IN_DESIGNATION_ID, dto.getDesignationId());
		map.put(PvuConstant.IN_CLASS_ID, dto.getClassId());
		map.put(PvuConstant.IN_EMPLOYEE_NO, dto.getEmpNo());
		List<PVURegularIncrementSmryView> pvuRegularIncrementSmryViews = getPVUEmployeeIncrementSummaryList(map);
		dto.setPvuRegularIncrementSmryViews(pvuRegularIncrementSmryViews);
		//dto.getPvuRegularIncrementSmryViews().get(arg0)
		/*
		 * Long total_count = 0L;
		 * System.out.println(pvuRegularIncrementSmryViews.size()); for(int i = 0;
		 * i<pvuRegularIncrementSmryViews.size();i++) { total_count +=
		 * pvuRegularIncrementSmryViews.get(i).getTotal(); }
		 */
		return dto;
	}
	@Override
	public String getEmployeeDataReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> attributesMap = buildPageInMap(pageDetail, getPvuSearchFields());
			String spName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_GET_REGLR_INCRMNT_LIST));
			Map<String, Object> obj = repository.callStoredProcedureMap(spName, attributesMap);
			List<PVURegularIncrementEligibleListView> eligibleListViews = (List<PVURegularIncrementEligibleListView>) obj
					.get(PvuConstant.RESULT_SET_1);
			List<PVURegularIncrementEligibleListView> nonEligibleListViews = (List<PVURegularIncrementEligibleListView>) obj
					.get(PvuConstant.RESULT_SET_2);

			if(eligibleListViews.size()>0) {
				eligibleListViews.addAll(nonEligibleListViews);
			}
//			objStorePro.addAll(nonEligibleListViews);
			int totColoumn = 1;
			Map<String, Object[]> data = new LinkedHashMap<>();
			String parameter = "";
			String rptName = PvuConstant.IN_VALID_SHEET;
			Long paycommisionid = Long.parseLong(attributesMap.get(PvuConstant.IN_INCR_FOR).toString());
			SimpleDateFormat formatter = new SimpleDateFormat(PvuConstant.DD_MMMM_YY);
			List<String> header = new ArrayList<>();
			// For Excelsheet header
			rptName = getPayCommisionName(rptName, paycommisionid, header);
			header.add(PvuConstant.PVU_BASIC_PAY);
			data.put(PvuConstant.PVU_MIS_HEADER, header.toArray());
			// For Excelsheet data
			itrationOfEmployeeDetalls(eligibleListViews, data, paycommisionid);

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY +OAuthUtility.getCurrentUserUserName(),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, eligibleListViews.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private void itrationOfEmployeeDetalls(List<PVURegularIncrementEligibleListView> eligibleListViews, Map<String, Object[]> data, Long paycommisionid) {
		for (int i = 0; i < eligibleListViews.size(); i++) {
			Map<String, Object> excelData = (Map<String, Object>) eligibleListViews.get(i);
			List<String> headerData = new ArrayList<>();
			headerData.add(String.valueOf(i + 1));
			headerData.add(String.valueOf(excelData.get(PvuConstant.EMP_NO)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.EMP_NAME)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.GPF)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.CLASS_NAME)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.DESIGNATION_NAME)));
			headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.DATE_OF_JOINING))
					? PvuUtils.getDateToStringDMYFormatValue(excelData.get(PvuConstant.DATE_OF_JOINING).toString()):"");
			setCurrentPayDataByCommisionId(paycommisionid, excelData, headerData);
			headerData.add(String.valueOf(excelData.get(PvuConstant.CUR_BASIC_PAY)));
			data.put(String.valueOf(i + 1), headerData.toArray());
		}
	}

	private void setCurrentPayDataByCommisionId(Long paycommisionid, Map<String, Object> excelData, List<String> headerData) {
		if ((PvuConstant.FIFTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			headerData.add(String.valueOf(excelData.get(PvuConstant.CUR_SCALE_VALUE)));
		}
		if ((PvuConstant.SIXTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			headerData.add(String.valueOf(excelData.get(PvuConstant.CUR_PAY_BAND_RANGE)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.CUR_PAY_BAND_VALUE)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.CUR_GRADE_PAYE_VALUE)));
		}
		if ((PvuConstant.SEVENTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			headerData.add(String.valueOf(excelData.get(PvuConstant.CUR_PAY_LEVEL_VALUE)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.CUR_CELL_ID_VALUE)));
		}
	}

	private String getPayCommisionName(String rptName, Long paycommisionid, List<String> header) {
		header.add(PvuConstant.PVU_MIS_SRNO);
		header.add(PvuConstant.PVU_MIS_EMPNO);
		header.add(PvuConstant.PVU_MIS_EMPNAME);
		header.add(PvuConstant.PVU_MIS_GPFPPAN);
		header.add(PvuConstant.PVU_MIS_CLASS);
		header.add(PvuConstant.PVU_MIS_DESIGNATION);
		header.add(PvuConstant.PVU_MIS_JOININGDATE);
		if ((PvuConstant.FIFTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAY_SCALE);
			rptName = PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME;
		}
		if ((PvuConstant.SIXTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAY_BAND);
			header.add(PvuConstant.PVU_MIS_PAY_BAND_VALUE);
			header.add(PvuConstant.PVU_MIS_GRADE_PAY);
			rptName = PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME;
		}
		if ((PvuConstant.SEVENTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAYLEVEL);
			header.add(PvuConstant.PVU_MIS_CELLID);
			rptName = PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME;
		}
		return rptName;
	}

	public String generateExcel(PageDetails pageDetail, String rptName, Map<String, Object[]> rptData, int listSize,
			int totCol, int[] colIndex) throws CustomException {

		try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			// Create a blank sheet
			XSSFSheet sheet = workbook.createSheet(rptName);
			// This data needs to be written (Object[])
			Map<String, Object[]> data = new LinkedHashMap<>();
			/*
			 * data.put(PvuConstant.PVU_MIS_OFFICE_NAME, new Object[] {
			 * PageDetails.getValue(pageDetail,
			 * PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey()) });
			 * data.put(PvuConstant.PVU_MIS_OFFICE_ADDRESS, new Object[] {
			 * PageDetails.getValue(pageDetail,
			 * PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey()) });
			 */
			/*
			 * data.put(PvuConstant.PVU_MIS_REPORT_NAME, new Object[] { rptName });
			 * data.put(PvuConstant.PVU_MIS_FILTER,
			 * rptData.get(PvuConstant.PVU_MIS_CONS_FILTER));
			 */
			data.put(PvuConstant.PVU_MIS_COLOUMN_HEADER, rptData.get(PvuConstant.PVU_MIS_HEADER));

			for (int i = 0; i < listSize; i++) {
				data.put(String.valueOf(i + 1), rptData.get(String.valueOf(i + 1)));
			}

			data.put(PvuConstant.PVU_MIS_EMPTY_ROW1, new Object[] { "" });
			data.put(PvuConstant.PVU_MIS_EMPTY_ROW2, new Object[] { "" });
			data.put(PvuConstant.PVU_MIS_USERNAME_DATETIME, rptData.get(PvuConstant.PVU_MIS_FOOTER));

			// If number of column < 8, than need to set date time in another row
			if (!Utils.isEmpty(rptData.get(PvuConstant.PVU_MIS_DATE_TIME))) {
				data.put(PvuConstant.PVU_MIS_DATETIME, rptData.get(PvuConstant.PVU_MIS_DATE_TIME));
			}

			this.iterateWorkbookData(workbook, sheet, data, totCol, colIndex);
			// Write the workbook in file system

			/* Set auto size column */
			for (int i = 0; i <= totCol; i++) {
				sheet.autoSizeColumn(i);
			}

			workbook.write(out);
			HttpHeaders header = new HttpHeaders();
			header.setContentLength(out.toByteArray().length);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					PvuConstant.PVU_MIS_ATT_FILENAME + rptName + PvuConstant.PVU_MIS_EX_XLS);
			return Base64.getEncoder().encodeToString(out.toByteArray());

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public void iterateWorkbookData(Workbook workbook, XSSFSheet sheet, Map<String, Object[]> data, int totColoumn,
			int[] colIndex) {

		CellStyle cs = workbook.createCellStyle();
		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				// border not set for this cell
				if (!key.contains("_NoBorder")) {
					cell.setCellStyle(cs);
				}
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		// set column Alignment Center for each column Index pass
		doCenterAlignColumn(workbook, sheet, colIndex, totColoumn);
		makeRowBold(workbook, sheet.getRow(0), 12, IndexedColors.GREY_25_PERCENT.getIndex());

	}

	public static void makeRowBold(Workbook wb, Row row, int fontSize, short color) {
		CellStyle style = wb.createCellStyle();// Create style
		XSSFFont font = (XSSFFont) wb.createFont();// Create font
		font.setFontHeightInPoints((short) fontSize);
		font.setBold(true);// Make font bold
		style.setFont(font);// set it to bold
		style.setFillForegroundColor(color);

		for (int i = 0; i < row.getLastCellNum(); i++) {// For each cell in the row
			row.getCell(i).setCellStyle(style);// Set the style
		}
	}

	public void doCenterAlignColumn(Workbook workbook, XSSFSheet sheet, int[] colIndex, int totColoumn) {
		int colSpace = 0;
		for (int i = 0; i < colIndex.length; i++) {

			Row rowCenter;
			CellStyle cen = workbook.createCellStyle();

			/* not set cellStyle for report which has column size < 8 */
			if (totColoumn < 8) {
				colSpace = 4;
			} else {
				colSpace = 3;
			}
			/* need to give border and center till report data only */
			for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum() - colSpace; rowIndex++) {
				rowCenter = sheet.getRow(rowIndex);
				if (rowCenter != null) {
					Cell cell = rowCenter.getCell(colIndex[i]);
					if (cell != null) {
						cell.setCellStyle(cen);
					}
				}
			}
		}
	}

	@Override
	public PagebleDTO<PVUEmployeeIncrementListView> getPVUEmployeeIncrementList(PageDetails pageDetail)
			throws CustomException {

		try {
			Map<String, Object> map = buildPageInMap(pageDetail, getPvuSearchFieldsListing());
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_INCRMNT_LIST));
			List<PVUEmployeeIncrementListView> objStorePro = repository.storeProc(procName, map,
					PVUEmployeeIncrementListView.class);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVURegularIncrementSmryView> getPVUEmployeeIncrementSummaryList(Map<String, Object> map)
			throws CustomException
	{
		try {
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SP_PVU_GET_INCR_SUMMARY_LIST));
			List<PVURegularIncrementSmryView> objStorePro = repository.storeProc(procName, map,
					PVURegularIncrementSmryView.class);
			return objStorePro;
		}
		catch (CustomException ex)
		{
			System.out.println(PvuConstant.ERROR +ex.getMessage());
			System.out.println(PvuConstant.ERROR +ex.getStackTrace());
		}
		catch (Exception ex)
		{
			System.out.println(PvuConstant.ERROR +ex.getMessage());
			System.out.println(PvuConstant.ERROR +ex.getStackTrace());
		}
	return  null;
	}

	public List<PVUSearchEnum> getPvuSearchFieldsListing() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_FIELD_FROM,
				PVUSearchEnum.PVU_SEARCH_FIELD_TO, PVUSearchEnum.PVU_SEARCH_FIELD_TRAN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PAY_TYPE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_STATUS, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_FINANCIAL_YEAR_ID, PVUSearchEnum.PVU_SEARCH_PAY_INC_FOR,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_In_REF_DATE);
	}
	@Override
	public PVUIncrementMainEventDto insertIncrementItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
			List<Long> lstEmpIncludeList = null;
			List<Long> lstEmpExcludeList = null;
			Date updatedDate = new Date();
			pvuWFWrapperDto.setUpdatedDate(updatedDate);

			PVUIncrementEventEntity pvuIncrementEventEntity = getIncrementEvent(pvuWFWrapperDto.getTrnId());
			List<PVUIncrementEmpSDDto> lstPVUIncrementEmpDtos = pvuIncrementEmpSDService
					.getIncrementEmpByEventId(pvuIncrementEventEntity.getInEventId());
			lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
					.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
					.map(PVUIncrementEmpSDDto::getEmpId).collect(Collectors.toList());

			lstEmpExcludeList = lstPVUIncrementEmpDtos.stream()
					.filter(emp -> (emp.getReasonForExclude() != Constant.LONG_ZERO_VALUE))
					.map(PVUIncrementEmpSDDto::getEmpId).collect(Collectors.toList());

			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = eDPLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			EDPLuLookUpInfoEntity rejectStatus = eDPLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);

			if (pvuIncrementEventEntity.getStatusId().getLookUpInfoId() == empApprovStatsLookupInfo.getLookUpInfoId()) {
				logger.error(MsgConstant.TRN_ALREADY_APPROVED);
				throw new CustomException(ErrorResponse.TRN_ALREADY_APPROVED);
			} else if (pvuIncrementEventEntity.getStatusId().getLookUpInfoId() == rejectStatus.getLookUpInfoId()) {
				logger.error(MsgConstant.TRN_ALREADY_REJECTED);
				throw new CustomException(ErrorResponse.TRN_ALREADY_REJECTED);
			}
			// insert from one table to another
		    long statusId=pvuIncrementEventEntity.getStatusId().getLookUpInfoId();
			insertInIncrementMainEmp(pvuWFWrapperDto,statusId);
			// employee lock validating
			validateNoInProgressEvent(lstPVUIncrementEmpDtos, pvuIncrementEventEntity.getTrnNo());

			// employee salary sync validating

			// transaction number generation if transaction number not generated
			if (Utils.isEmpty(pvuIncrementEventEntity.getTrnNo())) {
				pvuIncrementEventEntity.setRefDate(new Date());
				pvuIncrementEventEntity.setTrnNo(getTransactionNumber(Constant.INC));
				pvuIncrementEventEntity = saveOrUpdateIncrementEvent(pvuIncrementEventEntity);
			} else if (!Utils.isEmpty(lstEmpExcludeList)) {
				// if exclude list not empty then need to release previous locks
				pvuEmployeeEventStatusService.resetEmployeeIncEventStatus(pvuIncrementEventEntity.getTrnNo(),
						lstEmpExcludeList);
			}

			// Need to lock include employee with transaction no
			pvuEmployeeEventStatusService.updateEmployeeIncEventStatus(pvuIncrementEventEntity.getTrnNo(),
					lstEmpIncludeList);

			if (!pvuFacade.callWorkFlowApis(pvuWFWrapperDto)) {
				logger.error("Increment workflow entry failed.");
				throw new CustomException(ErrorResponse.WF_FAILED);
			} else {
				EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = eDPLuLookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.SUBMIT);
				if (!Utils.isEmpty(empSubmitStatusLookupInfo)) {
					repository.updateStatusIdForPVUIncrementEventEntity(empSubmitStatusLookupInfo.getLookUpInfoId(),
							pvuWFWrapperDto.getTrnId(), updatedDate, OAuthUtility.getCurrentUserUserId(),
							OAuthUtility.getCurrentUserLkPOUId());
				}
				insertIncrementInITRs(pvuWFWrapperDto);
				approveRejectIncrement(pvuWFWrapperDto, pvuIncrementEventEntity.getTrnNo());
				return getIncrementEventEmpSummary(pvuWFWrapperDto.getTrnId());
		}

	}

	@Override
	public PVUIncrementMainEventDto getIncrementEventEmpSummary(Long id) throws CustomException {
		PVUIncrementEventEntity pvuIncrementEventEntity = getIncrementEvent(id);
		PVUIncrementMainEventDto pvuIncrementEventDto = converter.toDTO(pvuIncrementEventEntity);
		// there is change service
		pvuIncrementEventDto.setPvuIncrementEmpSDDtos(pvuIncrementEmpSDService.getIncrementEmpByEventId(id));
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.IN_TRN_ID, pvuIncrementEventDto.getInEventId());
		map.put(PvuConstant.IN_CGP_NO_TYPE, pvuIncrementEventDto.getCpfGpfPpan());
		map.put(PvuConstant.IN_CGP_NO, pvuIncrementEventDto.getGpf());
		map.put(PvuConstant.IN_DESIGNATION_ID, pvuIncrementEventDto.getDesignationId());
		map.put(PvuConstant.IN_CLASS_ID, pvuIncrementEventDto.getClassId());
		map.put(PvuConstant.IN_EMPLOYEE_NO, pvuIncrementEventDto.getEmpNo());
		List<PVURegularIncrementSmryView> pvuRegularIncrementSmryViews = getPVUEmployeeIncrementSummaryList(map);
		pvuIncrementEventDto.setPvuRegularIncrementSmryViews(pvuRegularIncrementSmryViews);
		return pvuIncrementEventDto;
	}

	public void approveRejectIncrement(PvuWFWrapperDto pvuWFWrapperDto, String transNo) throws CustomException {
		if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)
				|| pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			approveRejectIncrementEvent(pvuWFWrapperDto);
			if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
				submitAutoIncrement(transNo);
			}
			pvuEmployeeEventStatusService.resetIncEmployeeEventStatus(pvuWFWrapperDto.getTrnId(),
					pvuWFWrapperDto.getUpdatedDate());
		}
	}

	public void submitAutoIncrement(String trnNo) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat("PVU_INCREMENT_AUTO_INCR"));
		Object getResult = repository.callUsingCallableStmt(procName, map);
		logger.info("Transaction no: {} for submit transaction ", trnNo);
		if (!getResult.equals(0l)) {
			logger.error("Increment Autoincrement procedure execution failed.");
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Boolean approveRejectIncrementEvent(final PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_STATUS_ID, pvuWFWrapperDto.getWfStatus());
		map.put(Constant.IN_UPDATED_BY, pvuWFWrapperDto.getUpdatedBy());
		map.put(Constant.IN_UPDATED_BY_POST, pvuWFWrapperDto.getUpdatedByPost());
		map.put(Constant.IN_UPDATED_DATE, pvuWFWrapperDto.getUpdatedDate());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_APPROVE_INCREMENT));
		try {
			repository.callStoredProcedure(procName, map);
			logger.info("Transaction no : {} approved and reject", pvuWFWrapperDto.getTrnId());
			return Boolean.TRUE;
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return Boolean.FALSE;
	}

	public Boolean insertInIncrementMainEmp(final PvuWFWrapperDto pvuWFWrapperDto,long statusid) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_ID, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_STATUS_ID, statusid);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_INCREMENT_MAINEMP));
		try {
			repository.callStoredProcedure(procName, map);
			return Boolean.TRUE;
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return Boolean.FALSE;
	}

	public void insertIncrementInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_WF_ROLE_ID, pvuWFWrapperDto.getAssignToWfRoleId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_INCREMENT_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	public void validateNoInProgressEvent(List<PVUIncrementEmpSDDto> lstPVUIncrementEmpDtos, String tranNo)
			throws CustomException {
		List<PVUEmployeeEventStatusDto> lstPVUEmployeeEventStatusDto = null;

		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpSDDto::getEmpId).collect(Collectors.toList());

		if (Utils.isEmpty(tranNo)) {
			lstPVUEmployeeEventStatusDto = pvuEmployeeEventStatusService
					.getEmployeeInProcessByEmpIds(lstEmpIncludeList);
		} else {
			lstPVUEmployeeEventStatusDto = pvuEmployeeEventStatusService
					.getEmployeeInProcessByEmpIdsInOtherTrans(lstEmpIncludeList, tranNo);
		}

		if (!Utils.isEmpty(lstPVUEmployeeEventStatusDto)) {
			StringBuilder errorMessage = new StringBuilder();
			for (PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto : lstPVUEmployeeEventStatusDto) {
				String message = MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
						pvuEmployeeEventStatusDto.getTransId(), pvuEmployeeEventStatusDto.getEmployeeCode());
				errorMessage.append(message).append(".\n");
			}
			logger.info("An exception occurred with message: {}", errorMessage);
			throw new CustomException(HttpStatus.CONFLICT, errorMessage.toString());
		}
	}

	public String getTransactionNumber(String eventName) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, eventName);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> nextSequanceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequanceNumber)) {
			return (String) nextSequanceNumber.get(0)[0];
		} else {
			logger.error(MsgConstant.TRN_GENERATION_FAILED);
			throw new CustomException(ErrorResponse.TRN_GENERATION_FAILED);
		}
	}

	@Override
	public PVUIncrementEventEntity getIncrementEvent(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
	}

	@Override
	public String getIneligibleEmployeeListExcel(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> attributesMap = buildPageInMap(pageDetail, getPvuSearchFields());
			String spName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_GET_REGLR_INCRMNT_LIST));
			Map<String, Object> obj = repository.callStoredProcedureMap(spName, attributesMap);
			List<PVURegularIncrementEligibleListView> ineligibleEmployeeList = (List<PVURegularIncrementEligibleListView>) obj
					.get(PvuConstant.RESULT_SET_2);

			int totColoumn = 1;
			Map<String, Object[]> data = new LinkedHashMap<>();
			String rptName = PvuConstant.IN_VALID_SHEET;
			Long paycommisionid = Long.parseLong(attributesMap.get(PvuConstant.IN_INCR_FOR).toString());
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
			List<String> header = new ArrayList<>();
			header.add(PvuConstant.PVU_MIS_SRNO);
			header.add(PvuConstant.PVU_MIS_EMPNO);
			header.add(PvuConstant.PVU_MIS_EMPNAME);
			header.add(PvuConstant.PVU_MIS_CLASS);
			header.add(PvuConstant.PVU_MIS_DESIGNATION);
			header.add(PvuConstant.PVU_MIS_JOININGDATE);

			// For Excelsheet header
			rptName = getNameOfCommision(rptName, paycommisionid, header);

			header.add(PvuConstant.PVU_BASIC_PAY);
			header.add(PvuConstant.PVU_INCREMENT_REASON_FOR_EXCLUDE);
			data.put(PvuConstant.PVU_MIS_HEADER, header.toArray());

			// For Excelsheet data
			ittrationIneligibleEmployeeList(ineligibleEmployeeList, data, paycommisionid);
			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + OAuthUtility.getCurrentUserUserName(),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, ineligibleEmployeeList.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private void ittrationIneligibleEmployeeList(List<PVURegularIncrementEligibleListView> ineligibleEmployeeList, Map<String, Object[]> data, Long paycommisionid) {
		for (int i = 0; i < ineligibleEmployeeList.size(); i++) {
			Date date;
			Map<String, Object> excelData = (Map<String, Object>) ineligibleEmployeeList.get(i);
			List<String> headerData = new ArrayList<>();
			headerData.add(String.valueOf(i + 1));
			headerData.add(String.valueOf(excelData.get(PvuConstant.EMP_NO)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.EMP_NAME)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.CLASS_NAME)));
			headerData.add(String.valueOf(excelData.get(PvuConstant.DESIGNATION_NAME)));
			headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.DATE_OF_JOINING))
					?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.DATE_OF_JOINING).toString()) :"");
			setCurrentPayDataByCommisionId(paycommisionid, excelData, headerData);
			headerData.add(String.valueOf(excelData.get(PvuConstant.CUR_BASIC_PAY)));
			headerData.add(String.valueOf(excelData.get("reasonForExcludeValue")));
			data.put(String.valueOf(i + 1), headerData.toArray());

		}
	}

	private String getNameOfCommision(String rptName, Long paycommisionid, List<String> header) {
		if ((PvuConstant.FIFTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAY_SCALE);
			rptName = PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME;
		}
		if ((PvuConstant.SIXTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAY_BAND);
			header.add(PvuConstant.PVU_MIS_PAY_BAND_VALUE);
			header.add(PvuConstant.PVU_MIS_GRADE_PAY);
			rptName = PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME;
		}
		if ((PvuConstant.SEVENTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAYLEVEL);
			header.add(PvuConstant.PVU_MIS_CELLID);
			rptName = PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME;
		}
		return rptName;
	}

	@Override
	public String getSuccessCountExcel(PageDetails pageDetail) throws CustomException {
		try {
			String processStatus = processStatus(pageDetail);
			Map<String, Object> attributesMap = buildPageInMap(pageDetail, getPvuSearchFields());
			String spName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SP_PVU_GET_SUCS_FAIL_INCRMNT_LIST));
			Map<String, Object> obj = repository.callStoredProcedureMap(spName, attributesMap);

			List<PVURegularIncrementEligibleListView2> objStorePro = new ArrayList<>();
			if(processStatus.equals("1")) {
				List<PVURegularIncrementEligibleListView2> successCountViews = (List<PVURegularIncrementEligibleListView2>) obj
						.get(PvuConstant.RESULT_SET_1);
				objStorePro.addAll(successCountViews);
			} else {
				List<PVURegularIncrementEligibleListView2> failureCountViews = (List<PVURegularIncrementEligibleListView2>) obj
						.get(PvuConstant.RESULT_SET_2);
				objStorePro.addAll(failureCountViews);
			}

			int totColoumn = 1;
			Map<String, Object[]> data = new LinkedHashMap<>();
			String output = "";
			String rptName = PvuConstant.IN_VALID_SHEET;
			Long paycommisionid = Long.parseLong(attributesMap.get(PvuConstant.IN_INCR_FOR).toString());
			List<String> header = new ArrayList<>();
			header.add(PvuConstant.PVU_MIS_SRNO);
			header.add(PvuConstant.PVU_MIS_EMPNO);
			header.add(PvuConstant.PVU_MIS_EMPNAME);
			header.add(PvuConstant.PVU_MIS_GPFPPAN);
			header.add(PvuConstant.PVU_MIS_CLASS);
			header.add(PvuConstant.PVU_MIS_DESIGNATION);
			header.add(PvuConstant.PVU_MIS_JOININGDATE);

			// For Excelsheet header
			rptName = setPayValueByPayCommision(rptName, paycommisionid, header);
			header.add(PvuConstant.PVU_EFFECTIVE_DATE);
			header.add(PvuConstant.PVU_DATE_NEXT_INCR);
			header.add(PvuConstant.PVU_DIFF_AMT);
			header.add(PvuConstant.PVU_INCREMENT_TYPE);
			header.add(PvuConstant.PVU_SUS_FROM_DATE);
			header.add(PvuConstant.PVU_SUS_TO_DATE);
			header.add(PvuConstant.PVU_EOL_FROM_DATE);
			header.add(PvuConstant.PVU_EOL_TO_DATE);
			header.add(PvuConstant.PVU_REMARKS);
			data.put(PvuConstant.PVU_MIS_HEADER, header.toArray());
			System.out.println("Row Header - " + header);
			output = "11Excel Header:-" + header.toString();


			for (int i = 0; i < objStorePro.size(); i++) {
				Map<String, Object> excelData = (Map<String, Object>) objStorePro.get(i);
				List<String> headerData = new ArrayList<>();
				headerData.add(String.valueOf(i + 1));
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.EMP_NO))
						? String.valueOf(excelData.get(PvuConstant.EMP_NO)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.EMP_NAME))
						? String.valueOf(excelData.get(PvuConstant.EMP_NAME)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.GPF))
						? String.valueOf(excelData.get(PvuConstant.GPF)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CLASS_NAME))
						? String.valueOf(excelData.get(PvuConstant.CLASS_NAME)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.DESIGNATION_NAME))
						? String.valueOf(excelData.get(PvuConstant.DESIGNATION_NAME)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.DATE_OF_JOINING))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.DATE_OF_JOINING).toString()) :"");

				if ((PvuConstant.FIFTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_SCALE_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_SCALE_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.CUR_BASIC_PAY)) :"");

					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_SCALE_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_SCALE_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.REV_BASIC_PAY)) :"");
				}
				if ((PvuConstant.SIXTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_PAY_BAND_RANGE))
							? String.valueOf(excelData.get(PvuConstant.CUR_PAY_BAND_RANGE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_PAY_BAND_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_PAY_BAND_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_GRADE_PAYE_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_GRADE_PAYE_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.CUR_BASIC_PAY)) :"");

					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_PAY_BAND_RANGE))
							? String.valueOf(excelData.get(PvuConstant.REV_PAY_BAND_RANGE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_PAY_BAND_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_PAY_BAND_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_GRADE_PAYE_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_GRADE_PAYE_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.REV_BASIC_PAY)) :"");
				}
				if ((PvuConstant.SEVENTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_PAY_LEVEL_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_PAY_LEVEL_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_CELL_ID_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_CELL_ID_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.CUR_BASIC_PAY)) :"");

					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_PAY_LEVEL_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_PAY_LEVEL_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_CELL_ID_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_CELL_ID_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.REV_BASIC_PAY)) :"");
				}
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REVEFFDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.REVEFFDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REVDATENEXINC))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.REVDATENEXINC).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.DIFFAMT))


						? String.valueOf(excelData.get(PvuConstant.DIFFAMT)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.INCREMENTTYPE))
						? String.valueOf(excelData.get(PvuConstant.INCREMENTTYPE)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.SUSSTARTDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.SUSSTARTDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.SUSENDDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.SUSENDDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.EOLSTARTDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.EOLSTARTDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.EOLENDDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.EOLENDDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REMARKS))
						? String.valueOf(excelData.get(PvuConstant.REMARKS)) :"");

				data.put(String.valueOf(i + 1), headerData.toArray());
				System.out.println("Row Data - " + headerData);
				output = output + "Excel Row Data:-" + headerData.toString();

			}
			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + OAuthUtility.getCurrentUserUserName(),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });
//			return output;
			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getProcessedEmployeeListExcel(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> attributesMap = buildPageInMap(pageDetail, getPvuSearchFields());
			String spName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SP_PVU_GET_SUCS_FAIL_INCRMNT_LIST));
			Map<String, Object> obj = repository.callStoredProcedureMap(spName, attributesMap);
			List<PVURegularIncrementEligibleListView2> eligibleListViews = (List<PVURegularIncrementEligibleListView2>) obj
					.get(PvuConstant.RESULT_SET_1);
			List<PVURegularIncrementEligibleListView2> failureCountViews = (List<PVURegularIncrementEligibleListView2>) obj
					.get(PvuConstant.RESULT_SET_2);
			List<PVURegularIncrementEligibleListView2> objStorePro = new ArrayList<>();
			if(eligibleListViews.size()>0) {
				objStorePro.addAll(eligibleListViews);
				objStorePro.addAll(failureCountViews);
			}
			int totColoumn = 1;
			Map<String, Object[]> data = new LinkedHashMap<>();

			String output = "";
			String rptName = PvuConstant.IN_VALID_SHEET;
			Long paycommisionid = Long.parseLong(attributesMap.get(PvuConstant.IN_INCR_FOR).toString());
			SimpleDateFormat formatter = new SimpleDateFormat(PvuConstant.DD_MMMM_YY);
			List<String> header = new ArrayList<>();
			header.add(PvuConstant.PVU_MIS_SRNO);
			header.add(PvuConstant.PVU_MIS_EMPNO);
			header.add(PvuConstant.PVU_MIS_EMPNAME);
			header.add(PvuConstant.PVU_MIS_GPFPPAN);
			header.add(PvuConstant.PVU_MIS_CLASS);
			header.add(PvuConstant.PVU_MIS_DESIGNATION);
			header.add(PvuConstant.PVU_MIS_JOININGDATE);

			// For Excelsheet header
			rptName = setPayValueByPayCommision(rptName, paycommisionid, header);

			header.add(PvuConstant.PVU_EFFECTIVE_DATE);
			header.add(PvuConstant.PVU_DATE_NEXT_INCR);
			header.add(PvuConstant.PVU_DIFF_AMT);
			header.add(PvuConstant.PVU_INCREMENT_TYPE);
			header.add(PvuConstant.PVU_SUS_FROM_DATE);
			header.add(PvuConstant.PVU_SUS_TO_DATE);
			header.add(PvuConstant.PVU_EOL_FROM_DATE);
			header.add(PvuConstant.PVU_EOL_TO_DATE);
			header.add(PvuConstant.PVU_REMARKS);
			header.add(PvuConstant.PVU_MIS_STATUS);
			data.put(PvuConstant.PVU_MIS_HEADER, header.toArray());
			System.out.println("Row Header - " + header);
			output = "11Excel Header:-" + header.toString();

			// For Excelsheet data
			String Joindate = "";
			for (int i = 0; i < objStorePro.size(); i++) {
				Map<String, Object> excelData = (Map<String, Object>) objStorePro.get(i);
				List<String> headerData = new ArrayList<>();
				headerData.add(String.valueOf(i + 1));
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.IN_EMP_NO))
						? String.valueOf(excelData.get(PvuConstant.IN_EMP_NO)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.EMP_NAME))
						? String.valueOf(excelData.get(PvuConstant.EMP_NAME)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.GPF))
						? String.valueOf(excelData.get(PvuConstant.GPF)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CLASS_NAME))
						? String.valueOf(excelData.get(PvuConstant.CLASS_NAME)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.DESIGNATION_NAME))
						? String.valueOf(excelData.get(PvuConstant.DESIGNATION_NAME)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.DATE_OF_JOINING))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.DATE_OF_JOINING).toString()) :"");

				if ((PvuConstant.FIFTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_SCALE_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_SCALE_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.CUR_BASIC_PAY)) :"");

					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_SCALE_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_SCALE_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.REV_BASIC_PAY)) :"");
				}
				if ((PvuConstant.SIXTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_PAY_BAND_RANGE))
							? String.valueOf(excelData.get(PvuConstant.CUR_PAY_BAND_RANGE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_PAY_BAND_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_PAY_BAND_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_GRADE_PAYE_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_GRADE_PAYE_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.CUR_BASIC_PAY)) :"");

					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_PAY_BAND_RANGE))
							? String.valueOf(excelData.get(PvuConstant.REV_PAY_BAND_RANGE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_PAY_BAND_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_PAY_BAND_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_GRADE_PAYE_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_GRADE_PAYE_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.REV_BASIC_PAY)) :"");
				}
				if ((PvuConstant.SEVENTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_PAY_LEVEL_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_PAY_LEVEL_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_CELL_ID_VALUE))
							? String.valueOf(excelData.get(PvuConstant.CUR_CELL_ID_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.CUR_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.CUR_BASIC_PAY)) :"");

					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_PAY_LEVEL_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_PAY_LEVEL_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_CELL_ID_VALUE))
							? String.valueOf(excelData.get(PvuConstant.REV_CELL_ID_VALUE)) :"");
					headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REV_BASIC_PAY))
							? String.valueOf(excelData.get(PvuConstant.REV_BASIC_PAY)) :"");
				}
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REVEFFDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.REVEFFDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REVDATENEXINC))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.REVDATENEXINC).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.DIFFAMT))
						? String.valueOf(excelData.get(PvuConstant.DIFFAMT)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.INCREMENTTYPE))
						? String.valueOf(excelData.get(PvuConstant.INCREMENTTYPE)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.SUSSTARTDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.SUSSTARTDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.SUSENDDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.SUSENDDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.EOLSTARTDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.EOLSTARTDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.EOLENDDATE))
						?PvuUtils.getDateToStringDMYFormatValueNew(excelData.get(PvuConstant.EOLENDDATE).toString())
						:"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.REMARKS))
						? String.valueOf(excelData.get(PvuConstant.REMARKS)) :"");
				headerData.add(!Utils.isEmpty(excelData.get(PvuConstant.PVU_MIS_STATUS))
						? String.valueOf(excelData.get(PvuConstant.PVU_MIS_STATUS)) :"");

				data.put(String.valueOf(i + 1), headerData.toArray());
				System.out.println("Row Data - " + headerData);
				output = output + "Excel Row Data:-" + headerData.toString();

			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY +OAuthUtility.getCurrentUserUserName(),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });
//			return output;
			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private String setPayValueByPayCommision(String rptName, Long paycommisionid, List<String> header) {
		if ((PvuConstant.FIFTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAY_SCALE);
			header.add(PvuConstant.PVU_BASIC_PAY);
			header.add(PvuConstant.PVU_MIS_PAY_SCALE_REVISED);
			header.add(PvuConstant.PVU_BASIC_PAY_REVISED);
			rptName = PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME;
		}
		if ((PvuConstant.SIXTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAY_BAND);
			header.add(PvuConstant.PVU_MIS_PAY_BAND_VALUE);
			header.add(PvuConstant.PVU_MIS_GRADE_PAY);
			header.add(PvuConstant.PVU_BASIC_PAY);
			header.add(PvuConstant.PVU_MIS_PAY_BAND_REVISED);
			header.add(PvuConstant.PVU_MIS_PAY_BAND_VALUE_REVISED);
			header.add(PvuConstant.PVU_MIS_GRADE_PAY_REVISED);
			header.add(PvuConstant.PVU_BASIC_PAY_REVISED);
			rptName = PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME;
		}
		if ((PvuConstant.SEVENTH_COMMISSION_ID).compareTo(paycommisionid) == 0) {
			header.add(PvuConstant.PVU_MIS_PAYLEVEL);
			header.add(PvuConstant.PVU_MIS_CELLID);
			header.add(PvuConstant.PVU_BASIC_PAY);
			header.add(PvuConstant.PVU_MIS_PAYLEVEL_REVISED);
			header.add(PvuConstant.PVU_MIS_CELLID_REVISED);
			header.add(PvuConstant.PVU_BASIC_PAY_REVISED);
			rptName = PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME;
		}
		return rptName;
	}

	@Override
	public Boolean validateIncrementSubmit(PVUIncrementMainEventDto dto) throws CustomException {
		validateAtLeastOneIncludeRecord(dto.getPvuIncrementEmpSDDtos());
		validateNoInProgressEvent(dto.getPvuIncrementEmpSDDtos(), dto.getTrnNo());
		// validateEmpSalaryInSync(dto);
		return Boolean.TRUE;
	}

	public void validateEmpSalaryInSync(PVUIncrementMainEventDto dto) throws CustomException {

		if (Utils.isEmpty(dto.getTrnNo())) {
			List<PVURegularIncrementEligibleListView> lstIncludeExclude = callStoredProcedureWithMultipleOutput(
					prepareIncExcReqestMap(dto));

			if (lstIncludeExclude.size() != dto.getPvuIncrementEmpSDDtos().size()) {
				logger.error(MsgConstant.TRANSACTION_OUT_OF_SYNCH);
				throw new CustomException(ErrorResponse.TRANSACTION_OUT_OF_SYNCH);
			}

			if (!isSalaryInSalaryInSynch(lstIncludeExclude, dto.getPvuIncrementEmpSDDtos())) {
				logger.error(MsgConstant.TRANSACTION_OUT_OF_SYNCH);
				throw new CustomException(ErrorResponse.TRANSACTION_OUT_OF_SYNCH);
			}
		}
	}

	public List<PVURegularIncrementEligibleListView> callStoredProcedureWithMultipleOutput(
			Map<String, Object> attributesMap) throws PersistenceException {

		String spName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_GET_REGLR_INCRMNT_LIST));
		Map<String, Object> obj = repository.callStoredProcedureMap(spName, attributesMap);
		List<PVURegularIncrementEligibleListView> eligibleListViews = (List<PVURegularIncrementEligibleListView>) obj
				.get(PvuConstant.RESULT_SET_1);
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = (List<PVURegularIncrementEligibleListView>) obj
				.get(PvuConstant.RESULT_SET_2);
		List<PVURegularIncrementEligibleListView> objStorePro = new ArrayList<>();
		if(eligibleListViews.size()>0) {
			objStorePro.addAll(eligibleListViews);
		}
		if(nonEligibleListViews.size()>0) {
			objStorePro.addAll(nonEligibleListViews);
		}
		return objStorePro;
	}

	public Map<String, Object> prepareIncExcReqestMap(PVUIncrementMainEventDto dto) {
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put(PvuConstant.IN_DDO_NO, dto.getDdoNo());
		requestMap.put(PvuConstant.IN_CARDEX_NO, dto.getCardexNo());
		requestMap.put(PvuConstant.IN_OFFICE, dto.getOfficeId());
		requestMap.put(PvuConstant.IN_DISTRICT_ID, dto.getDistrictId());
		requestMap.put(PvuConstant.IN_INCR_FOR, dto.getIncrementFor());
		requestMap.put(PvuConstant.IN_FY, dto.getFinancialYear());
		requestMap.put(PvuConstant.IN_EMP_PAY_TYPE, dto.getEmpPayType());
		requestMap.put(PvuConstant.IN_EMP_TYPE, dto.getEmpType());
		requestMap.put(PvuConstant.IN_CLASS_ID, dto.getClassId());
		requestMap.put(PvuConstant.IN_DESIGNATION_ID, dto.getDesignationId());
		requestMap.put(PvuConstant.IN_CGP_NO, dto.getGpf());
		requestMap.put(PvuConstant.IN_CGP_NO_TYPE1, dto.getCpfGpfPpan());
		requestMap.put(PvuConstant.IN_EMPLOYEE_NO, dto.getEmpNo());
		requestMap.put(PvuConstant.IN_DATE_NXT_INCR, Utils.getDateStr(dto.getDateNextInc()));
		requestMap.put(PvuConstant.IN_INCR_EFFECTIVE_DATE, Utils.getDateStr(dto.getIncrementEffDate()));
		requestMap.put(PvuConstant.IN_TRN_ID, dto.getTrnNo());
		requestMap.put(PvuConstant.IN_TRN_LEVEL, "view");
		requestMap.put(Constant.IN_PAGE_INDEX, 0);
		requestMap.put(Constant.IN_PAGE_SIZE, 250);
		requestMap.put(Constant.IN_USER_LIST, "1");
		return requestMap;
	}

	public boolean isSalaryInSalaryInSynch(List<PVURegularIncrementEligibleListView> lstIncIncludeExclude,
			List<PVUIncrementEmpSDDto> lstIncrementEmpDto) {
		Map<String, PVURegularIncrementEligibleListView> lstView = lstIncIncludeExclude.stream()
				.collect(Collectors.toMap(view -> view.getEmpId() + "_" + view.getIncrementType(), view -> view));
		Map<String, PVUIncrementEmpSDDto> lstDto = lstIncrementEmpDto.stream()
				.collect(Collectors.toMap(key -> key.getEmpId() + "_" + key.getIncrementType(), dto -> dto));
		PVURegularIncrementEligibleListView view = null;
		PVUIncrementEmpSDDto dto = null;

		for (Map.Entry<String, PVURegularIncrementEligibleListView> map : lstView.entrySet()) {
			view = lstView.get(map.getKey());
			dto = lstDto.get(map.getKey());

			if (view.getCurCellId() != dto.getCurCellId() || view.getCurGrade() != dto.getCurGrade()
					|| view.getCurScale() != dto.getCurScale() || view.getCurPayBand() != dto.getCurPayBand()
					|| view.getCurPayBandValue() != dto.getCurPayBandValue()
					|| view.getCurGradePay() != dto.getCurGradePay() || view.getCurBasicPay() != dto.getCurBasicPay()
					|| view.getClassId() != dto.getClassId() || view.getDesignationId() != dto.getDesignationId()) {
				return false;
			}
		}
		return true;
	}

	public void validateAtLeastOneIncludeRecord(List<PVUIncrementEmpSDDto> lstPVUIncrementEmpDtos)
			throws CustomException {
		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpSDDto::getEmpId).collect(Collectors.toList());
		if (Utils.isEmpty(lstEmpIncludeList)) {
			logger.error("Transaction can't created without include employee");
			throw new CustomException(ErrorResponse.TRN_WITHOUT_INCLUDE_FAILED);
		}
	}
	@Trace
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = {Exception.class, CustomException.class})
	public boolean deleteIncrementTrns(IdDto idDto) throws CustomException {
		Optional<PVUIncrementEventEntity> incrementEventEntity = repository.findById(idDto.getId());
		Date updatedDate = new Date();
		if (incrementEventEntity.isPresent()) {
			PVUIncrementEventEntity entity = incrementEventEntity.get();
			EDPLuLookUpInfoEntity saveAsDraft = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			EDPLuLookUpInfoEntity confirmAndProcess = lookUpInfoRepository.findByLookUpInfoNameAndEdpLuLookUpEntityLookUpNameAndActiveStatus(Constant.PROCESSED,Constant.LOOKUP_NAME_INCREMENT_STATUS,Constant.ACTIVE_STATUS);
			if (entity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId() ||
					entity.getStatusId().getLookUpInfoId() == confirmAndProcess.getLookUpInfoId()) {
				repository.deleteIncrementEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(), updatedDate,
						OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId());
				pvuIncrementEmpSDService.deleteIncrementEmpIdByEventId(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						updatedDate);
				/*pvuIncSummaryService.deleteIncrementSummaryIdByEventId(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						updatedDate);*/
				return Boolean.TRUE;
			} else {
				logger.error(MsgConstant.ERROR_WHILE_DELETE);
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}


	@Override
	public List<Object[]> pvuEmployeeIncrementConfirmAndProcess(PVUIncrementMainEventDto dto) throws CustomException {
		try {
			saveOrUpdateIncrementEventEmpSummary(dto );

			if (dto.getStatusId() != PvuConstant.SAVE_AS_DRAFT_ID) {
				Map<String,Object> jsonArr =new HashMap<>();
				jsonArr.put(PvuConstant.IN_DDO_NO, dto.getDdoNo());
				jsonArr.put(PvuConstant.IN_CARDEX_NO, dto.getCardexNo());
				jsonArr.put(PvuConstant.IN_OFFICE_ID, dto.getOfficeId());
				jsonArr.put(PvuConstant.IN_DISTRICT_ID, dto.getDistrictId());
				jsonArr.put(PvuConstant.IN_INCR_FOR, dto.getIncrementFor());
				jsonArr.put(PvuConstant.IN_FY, dto.getFinancialYear());
				jsonArr.put(PvuConstant.IN_EMP_PAY_TYPE, dto.getEmpPayType());
				jsonArr.put(PvuConstant.IN_EMP_TYPE, dto.getEmpType());
				jsonArr.put(PvuConstant.IN_CLASS_ID, dto.getClassId());
				jsonArr.put(PvuConstant.IN_DESIGNATION_ID, dto.getDesignationId());
				jsonArr.put(PvuConstant.IN_CGP_NO1, dto.getGpf());
				jsonArr.put(PvuConstant.IN_CGP_NO_TYPE1, dto.getCpfGpfPpan());
				jsonArr.put(PvuConstant.IN_EMPLOYEE_NO,!Utils.isEmpty(dto.getEmpNo())
						? Long.parseLong(dto.getEmpNo()) :0);
				jsonArr.put(PvuConstant.IN_DATE_NXT_INCR, Utils.getDateStr(dto.getDateNextInc()));
				jsonArr.put(PvuConstant.IN_INCR_EFFECTIVE_DATE, Utils.getDateStr(dto.getIncrementEffDate()));
				jsonArr.put(PvuConstant.IN_TRN_ID, dto.getInEventId());
				jsonArr.put(PvuConstant.IN_TRN_LEVEL,PvuConstant.REPROCESSED_STATUS);
				jsonArr.put(Constant.IN_PAGE_INDEX, 0);
				jsonArr.put(Constant.IN_PAGE_SIZE, 10000);
				jsonArr.put(Constant.IN_USER_LIST, "1");
				PageDetails pageDetail = new PageDetails();
				pageDetail.setPageElement(10000);
				pageDetail.setPageIndex(0);
				//pageDetail.setJsonArr(jsonArr);
				PVURegularIncrementListView data = getRegularEmployeeIncrementList(pageDetail,jsonArr);
			}
			String procName = null;
			if (dto.getIncrementFor() == PvuConstant.FIFTH_COMMISSION_ID) {
				procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SP_PVU_EMP_INC_CONF_PROC_5PAY));
			} else if (dto.getIncrementFor() == PvuConstant.SIXTH_COMMISSION_ID) {
				procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SP_PVU_EMP_INC_CONF_PROC_6PAY));
			} else if (dto.getIncrementFor() == PvuConstant.SEVENTH_COMMISSION_ID) {
				procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SP_PVU_EMP_INC_CONF_PROC_7PAY));
			}
			Map<String, Object> map = new HashMap<>();
			map.put(PvuConstant.IN_TRN_ID, dto.getInEventId());
			map.put(PvuConstant.IN_USER_ID, dto.getUpdatedBy());
			map.put(PvuConstant.IN_POST_ID, dto.getUpdatedByPost());
			List<Object[]> objStorePro = repository.callStoredProcedure(procName, map);
			
			Map<String, Object> mapSummary = new HashMap<>();
			mapSummary.put(PvuConstant.IN_TRN_ID, dto.getInEventId());
			mapSummary.put(PvuConstant.IN_CGP_NO_TYPE, dto.getCpfGpfPpan());
			mapSummary.put(PvuConstant.IN_CGP_NO, dto.getGpf());
			mapSummary.put(PvuConstant.IN_DESIGNATION_ID, dto.getDesignationId());
			mapSummary.put(PvuConstant.IN_CLASS_ID, dto.getClassId());
			mapSummary.put(PvuConstant.IN_EMPLOYEE_NO, dto.getEmpNo());
			List<PVURegularIncrementSmryView> pvuRegularIncrementSmryViews = getPVUEmployeeIncrementSummaryList(mapSummary);
			
			int totalPages = objStorePro.size();
			return objStorePro;
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<PVURegularIncrementEligibleListView2> getprocessStatus(PageDetails pageDetail) throws CustomException {
		try {
			String processStatus = processStatus(pageDetail);
			Map<String,Object> attributesMap = buildPageInMap(pageDetail,getPvuSearchFields());
			String spName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SP_PVU_GET_SUCS_FAIL_INCRMNT_LIST));
			Map<String,Object> obj = repository.callStoredProcedureMap(spName,attributesMap);
			List<PVURegularIncrementEligibleListView2> objStorePro = new ArrayList<>();
			if(processStatus.equals("1")) {
				List<PVURegularIncrementEligibleListView2> successCountViews = (List<PVURegularIncrementEligibleListView2>) obj
						.get(PvuConstant.RESULT_SET_1);
				objStorePro.addAll(successCountViews);
			} else {
				List<PVURegularIncrementEligibleListView2> failureCountViews = (List<PVURegularIncrementEligibleListView2>) obj
						.get(PvuConstant.RESULT_SET_2);
				objStorePro.addAll(failureCountViews);
			}
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(),0,totalPages,objStorePro);
		} catch(Exception ex) {
			logger.error(ex.getMessage(),ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	 private String  processStatus(PageDetails pageDetail) {
        String processStatus = null;
        List<SearchParam> searchParams = pageDetail.getJsonArr();
        if (searchParams != null && !searchParams.isEmpty()) {
            for (SearchParam param : searchParams)
                if ( param.getKey() != null && param.getKey().equals( "processStatus" ) ) {
                    {
                        processStatus = param.getValue();
                    }
                }
        }
        return  processStatus;
    }
	@Override
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException {
		return generatePdf(dto);
	}
	public String generatePdf(IdDto dto) throws CustomException {

		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		try {
			String htmltoPdf = null;
			Map<String, Object> map = new HashMap<>();
			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Increment Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			writer.write(generatePrint(dto).toString());

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			map.put("content", writer.toString());
			htmltoPdf = commonService.htmlToPdfRequest(map); // call this method for node js API for html to Base64
			return htmltoPdf;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}
	public StringWriter generatePrint(IdDto dto) {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();

		List<PVUIncrementEmpSDEntity> lsEntity = pvuIncrementEmpSDRepository.findAllByInEventIdInEventIdAndIsEligibleAndIsIncluded(dto.getId(),PvuConstant.ISELIGIBLE,PvuConstant.ISELIGIBLE);
		PVUIncrementEmpSDEntity entity = lsEntity.get(0);
		VelocityContext context = pvuIncrementEmpSDConverter.populateVContext(lsEntity);
		context.put("APPROVER_NAME", String.valueOf(authService.getOnlyIdAndName(entity.getUpdatedBy()).getName()));
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		setApprover(context, map);
		Template template = getPrintTemplate(entity);
		template.merge(context, writer);
		return writer;
	}
	private void setApprover(VelocityContext context, Map<String, Object> map) {
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getUserDesgnationFromUserId(),
				map);
		if (objects == null || objects.isEmpty()) {
			context.put("APPROVER_DESIGNATION", "");
		} else {
			context.put("APPROVER_DESIGNATION", String.valueOf(objects.get(0)[0]));
		}
	}

	public Template getPrintTemplate(PVUIncrementEmpSDEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template tempName = new Template();
		if (entity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/increment/increment7.vm");
		} else if (entity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/increment/increment6.vm");
		} else if (entity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/increment/increment5.vm");
		}
		return tempName;
	}


}

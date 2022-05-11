package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsStateEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsStateRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVURopPrintEndorsementConverter;
import gov.ifms.pvu.converter.PVURopPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.AnnexureDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeDetailsDto;
import gov.ifms.pvu.dto.PVURevisionOfPayAnnexureListView;
import gov.ifms.pvu.dto.PVURevisionOfPayAnnexureView;
import gov.ifms.pvu.dto.PVURopPrintEndorsementDto;
import gov.ifms.pvu.dto.PVURopPrintEndorsementView;
import gov.ifms.pvu.dto.PVURopView;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PrintStickerReportDto;
import gov.ifms.pvu.dto.StickerDTO;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVURopPrintEndorsementEntity;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.repository.PVURopPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVURopPrintEndorsementRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PVUPrintConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.util.QueryConstant;

/**
 * The Class PVURopPrintEndorsementController.
 * 
 * @version v- 1.0
 * @created 2020/04/06 16:00:01
 */

@Service
public class PVURopPrintEndorsementServiceImpl implements PVURopPrintEndorsementService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVURopPrintEndorsementAsMethodName repository. */
	@Autowired
	private PVURopPrintEndorsementRepository repository;

	/**
	 * The district repository.
	 */
	@Autowired
	private EDPMsDistrictRepository districtRepository;

	/**
	 * The district converter.
	 */
	@Autowired
	private EDPMsDistrictConverter districtConverter;

	/** The e DP ms designation repository. */
	@Autowired
	private EDPMsDesignationRepository eDPMsDesignationRepository;

	/** The e DP ms designation converter. */
	@Autowired
	private EDPMsDesignationConverter eDPMsDesignationConverter;

	/** The pvu facade. */
	@Autowired
	private PVYFacade pvuFacade;

	/** The converter. */
	@Autowired
	private PVURopPrintEndorsementConverter converter;

	/** The print itr converter. */
	@Autowired
	private PVURopPrintEndorsementItrConverter printItrConverter;

	/** The print itr repository. */
	@Autowired
	private PVURopPrintEndorsementItrRepository printItrRepository;

	/**
	 * The PVUEmployeRepository pvuEmployeRepository.
	 */
	@Autowired
	private PVUEmployeRepository pvuEmployeRepository;

	/** The pvu revision of pay service. */
	@Autowired
	private PVURevisionOfPayService pvuRevisionOfPayService;

	/** The edp ms state repository. */
	@Autowired
	private EDPMsStateRepository edpMsStateRepository;

	@Autowired
	private PVUMsPayCellRepository payCellRepository;

	@Autowired
	private PVUMsPayScaleRepository pvuMsPayScaleRepository;

	@Autowired
	private PVUMsPayBandRepository pvuMsPayBandRepository;

	/** The normal font. */
	private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Autowired
	private EDPMsOfficeRepository msOfficeRepository;

	@Autowired
	private PVUCommonService pvuCommonService;

	/**
	 * Retrieves an PVURopPrintEndorsementEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopPrintEndorsementEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVURopPrintEndorsementEntity getRopPrintEndorsement(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVURopPrintEndorsementEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURopPrintEndorsementEntity
	 */
	@Override
	public PVURopPrintEndorsementEntity saveOrUpdateRopPrintEndorsement(PVURopPrintEndorsementEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVURopPrintEndorsement items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopPrintEndorsementDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVURopPrintEndorsementView> getRopPrintEndorsements(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMP_RP_PRINT_ENDORSEMENT_LIST_WF).toString();
			List<PVURopPrintEndorsementView> objStorePro = this.storeProcPvu(procName, map,
					PVURopPrintEndorsementView.class);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPageInMap(PageDetails pageDetail) {
		Map<String, String> collect = getPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	@Override
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_AUTHORIZATION_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_AUTHORIZATION_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_PRINT_STATUS);
	}

	/**
	 * Store proc pvu.
	 *
	 * @param <T>      the generic type
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     the view
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();
	}

	/**
	 * Gets the inward lu look up info as map.
	 *
	 * @return the inward lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeDetailsDto getPELuLookUpDetails() throws CustomException {
		PVUEmployeDetailsDto pvuEmployeDetailsDto = new PVUEmployeDetailsDto();
		try {
			pvuEmployeDetailsDto.setLstLuLookUp(getPELookupSearch());
			pvuEmployeDetailsDto.setDistrict(districtConverter.toEDPSDTDto(
					districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
							EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC))));
			pvuEmployeDetailsDto.setDesignation(eDPMsDesignationConverter.toEDPSDTDto(eDPMsDesignationRepository
					.findByActiveStatusEquals(Constant.ACTIVE_STATUS, Sort.by(Sort.Direction.ASC, "designationName"))));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return pvuEmployeDetailsDto;
	}

	/**
	 * Gets the PE lookup search.
	 *
	 * @return the PE lookup search
	 * @throws CustomException the custom exception
	 */
	private Map<String, List<PVUEmployeCreationDDLView>> getPELookupSearch() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_EMP_ROP_INWARD_LK_SP).toString();
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.storeProcPvu(procName,
				Collections.emptyMap(), PVUEmployeCreationDDLView.class);
		resultMap = lstPVUEmployeCreationDDLView.stream()
				.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
		return resultMap;
	}

	/**
	 * Submit print endorsement.
	 *
	 * @param dto the dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVURopPrintEndorsementDto submitPrintEndorsement(PrintStickerReportDto dto) throws CustomException {
		PVURopView pvuRopView = pvuRevisionOfPayService.getRevisionOfPayView(dto.getStickerDTO().getId());
		return submitPEWF(dto, pvuRopView);
	}

	/**
	 * Submit PEWF.
	 *
	 * @param dto        the dto
	 * @param pvuRopView the pvu rop view
	 * @return the PVU rop print endorsement dto
	 * @throws CustomException the custom exception
	 */

	private PVURopPrintEndorsementDto submitPEWF(PrintStickerReportDto dto, PVURopView pvuRopView)
			throws CustomException {
		PVURopPrintEndorsementEntity printEntity = null;
		try {
			if (dto.getPrintEndorsementDto() != null) {
				printEntity = repository.findByIdAndActiveStatus(dto.getPrintEndorsementDto().getId(),
						Constant.ACTIVE_STATUS);
				if (printEntity != null) {
					dto.getPrintEndorsementDto().setReprintDate(new Date());
					dto.getPrintEndorsementDto().setPrintDate(printEntity.getPrintDate());
					dto.getPrintEndorsementDto().setPrintCnt(printEntity.getPrintCnt() + 1l);
				} else {
					/** For authorized case, and final reflection done by this */
					Boolean result = pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
					if (result.equals(Boolean.TRUE)) {
						/** Release Lock for employee, Other event can perform after this */
						pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(pvuRopView.getEmpId(),
								OAuthUtility.getCurrentUserLkPOUId());
						dto.getPrintEndorsementDto().setPrintCnt((dto.getPrintEndorsementDto().getPrintCnt() + 1l));
						dto.getPrintEndorsementDto().setPrintDate(new Date());
					}
				}
				printEntity = repository.save(converter.toEntity(dto.getPrintEndorsementDto()));
				printItrRepository.save(printItrConverter.toEntity(printEntity));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return printEntity != null ? converter.toDTO(printEntity) : null;
	}


	private String employeeName(Optional<PVUEmployeEntity> pvuEmployeEntity) {
		String employeeName = "";
		if (pvuEmployeEntity.isPresent()) {
			if (pvuEmployeEntity.get().getSalutation() != null) {
				employeeName = employeeName.concat(pvuEmployeEntity.get().getSalutation().getLookUpInfoName())
						.concat(" ");
			}

			if (pvuEmployeEntity.get().getEmployeeName() != null) {
				employeeName = employeeName.concat(pvuEmployeEntity.get().getEmployeeName());
			}

			if (pvuEmployeEntity.get().getEmployeeMiddleName() != null) {
				employeeName = employeeName.concat(" ").concat(pvuEmployeEntity.get().getEmployeeMiddleName());
			}

			if (pvuEmployeEntity.get().getEmployeeSurname() != null) {
				employeeName = employeeName.concat(" ").concat(pvuEmployeEntity.get().getEmployeeSurname());
			}
		}
		return employeeName;
	}

	/**
	 * Sets the office details.
	 *
	 * @param stringMap        the string map
	 * @param pvuEmployeEntity the pvu employe entity
	 * @return the string
	 */
	public String setOfficeDetails(Optional<PVUEmployeEntity> pvuEmployeEntity) {

		String officeName = PVUPrintConstant.EMPTY_STRING;
		if (pvuEmployeEntity.isPresent()) {
			officeName = pvuEmployeEntity.get().getOfficeId().getOfficeName();
			if (pvuEmployeEntity.get().getOfficeId().getLevelId() != null
					&& pvuEmployeEntity.get().getOfficeId().getLevelId() == 55) {
				Optional<EDPMsStateEntity> edpMsStateEntity = edpMsStateRepository
						.findById(pvuEmployeEntity.get().getOfficeId().getStateId());
				if (edpMsStateEntity.isPresent()) {
					officeName = officeName.concat(",").concat(edpMsStateEntity.get().getStateName());
				}
			} else if (pvuEmployeEntity.get().getOfficeId().getLevelId() != null
					&& pvuEmployeEntity.get().getOfficeId().getLevelId() == 56) {
				officeName = officeName.concat(",")
						.concat(pvuEmployeEntity.get().getOfficeId().getDistrictId().getDistrictName());
			} else if (pvuEmployeEntity.get().getOfficeId().getLevelId() != null
					&& pvuEmployeEntity.get().getOfficeId().getLevelId() == 58) {
				officeName = officeName.concat(",")
						.concat(pvuEmployeEntity.get().getOfficeId().getTalukaId().getTalukaName());
			}
		}
		return officeName;
	}

	/**
	 * Submit print history.
	 *
	 * @param dto        the dto
	 * @param pvuRopView
	 * @return the sticker DTO
	 * @throws CustomException the custom exception
	 */
	public StickerDTO submitPrintHistory(PrintStickerReportDto dto, PVURopView pvuRopView) throws CustomException {
		StickerDTO stickerDTO = dto.getStickerDTO();
		PVURopPrintEndorsementDto printEndorsementDto = submitPEWF(dto, pvuRopView);
		if (printEndorsementDto != null) {
			dto.setPrintEndorsementDto(printEndorsementDto);
			if (printEndorsementDto.getPrintDate() != null) {
				stickerDTO.setEndorsementPrintDate(printEndorsementDto.getPrintDate());
			}
			if (printEndorsementDto.getReprintDate() != null) {
				stickerDTO.setEndorsementReprintDate(printEndorsementDto.getReprintDate());
			}
			if (printEndorsementDto.getPrintCnt() != null) {
				stickerDTO.setRePrintCount(printEndorsementDto.getPrintCnt());
			}
			if (printEndorsementDto.getRemark() != null) {
				stickerDTO.setRePrintRemark(printEndorsementDto.getRemark());
			}
		}
		return stickerDTO;
	}

	private Template getPrintTemplate(Long ropType) {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		if (ropType == 412) {
			return velocityEngine.getTemplate("templates/rop/annexure6th.vm");
		} else {
			return velocityEngine.getTemplate("templates/rop/annexure7th.vm");
		}

	}

	private StringWriter generateAnnexurePdf(AnnexureDto dto) throws CustomException, ParseException {
		StringWriter writer = new StringWriter();

		Template template = getPrintTemplate(dto.getRopType());
		if (dto.getRopType() == 412) {
			VelocityContext context = populateVContext6thPay(dto);
			template.merge(context, writer);
		} else {
			VelocityContext context = populateVContext7thPay(dto);
			template.merge(context, writer);
		}
		return writer;
	}

	@Override
	public String generateAnnexure(AnnexureDto dto) {
		Document document = new Document();
		try {
			String htmltoPdf = null;
			Map<String, Object> map = new HashMap<>();
			StringWriter writer = new StringWriter();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Shetty Pay");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
			document.open();
			writer.write(generateAnnexurePdf(dto).toString());
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));
			document.newPage();
			document.close();
			map.put("content", writer.toString());
			htmltoPdf = pvuCommonService.htmlToPdfRequest(map);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			String fileName = String.valueOf(System.currentTimeMillis()).concat(".pdf");
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName); //
			header.setContentLength(baos.toByteArray().length);
			return htmltoPdf;
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		}
	}

	private VelocityContext populateVContext6thPay(AnnexureDto dto) throws ParseException, CustomException {
		VelocityContext context = new VelocityContext();
		SimpleDateFormat inputFormat1 = new SimpleDateFormat(PVUPrintConstant.DATE_YYYY_MM_DD);
		SimpleDateFormat outputFormat = new SimpleDateFormat(PVUPrintConstant.DATE_DD_MM_YYYY);

		PVURevisionOfPayAnnexureView annexureView = getPVURopAnnexure(dto);
		context.put(PVUPrintConstant.GOV_SERVANT_NAME, annexureView.getEmpName());
		context.put(PVUPrintConstant.GOV_SERVANT_DESIGNATION_2006, annexureView.getEmpDesignation());
		context.put(PVUPrintConstant.GOV_SERVANT_STATUS, annexureView.getEmpStatus());
		Optional<PVUMsPayScaleEntity> pvuMsPayScaleEntity = pvuMsPayScaleRepository.findById(dto.getPayScaleId());
		context.put(PVUPrintConstant.GOV_SERVANT_PRE_REVISED_SCALE,
				pvuMsPayScaleEntity.isPresent() ? pvuMsPayScaleEntity.get().getScaleValue() : "");

		context.put(PVUPrintConstant.EXISTING_EMOLUMENTS_2006, PVUPrintConstant.EMPTY_STRING);
		context.put(PVUPrintConstant.BASIC_PAY_2006, annexureView.getCurentBasicPay());

		context.put(PVUPrintConstant.DEARNESS_PAY_2006, annexureView.getDearnessPay());
		context.put(PVUPrintConstant.DEARNESS_ALLOWANCE_2006, annexureView.getDearnessAllowance());
		context.put(PVUPrintConstant.NPPA_2006, annexureView.getNpaAmount());
		context.put(PVUPrintConstant.TOTAL_EXISTING_EMOLUMENTS_2006, annexureView.gettExistingEmoluments());

		context.put(PVUPrintConstant.REVISED_PAY_BAND_GRADE_PAY_2006, annexureView.getPayBand());
		context.put(PVUPrintConstant.PAY_IN_PAY_BAND_2006, annexureView.getPayBandValue());
		context.put(PVUPrintConstant.GRADE_PAY_2009, annexureView.getGradePay());
		context.put(PVUPrintConstant.STEPPED_PAY_2006, PVUPrintConstant.EMPTY_STRING);

		context.put(PVUPrintConstant.REVISED_PAY_2006, PVUPrintConstant.EMPTY_STRING);
		context.put(PVUPrintConstant.PERSONAL_PAY_2006, PVUPrintConstant.EMPTY_STRING);
		context.put(PVUPrintConstant.REVISED_EMOLUMENTS_2006, PVUPrintConstant.EMPTY_STRING);
		context.put(PVUPrintConstant.REVISED_PAY_BAND_2006, annexureView.getPayBandValue());

		context.put(PVUPrintConstant.GRADE_PAY_2006, annexureView.getGradePay());
		context.put(PVUPrintConstant.ANY_OTHER_INFO, PVUPrintConstant.EMPTY_STRING);

		context.put(PVUPrintConstant.SPECIAL_PAY, PVUPrintConstant.EMPTY_STRING);

		context.put(PVUPrintConstant.PERSONAL_PAY_ADMISSIBLE, PVUPrintConstant.EMPTY_STRING);

		context.put(PVUPrintConstant.NON_PRACTICING_ALLOWANCE_2006, PVUPrintConstant.EMPTY_STRING);
		Date nextIncDate = inputFormat1.parse(annexureView.getDateOfNextIncr());
		context.put(PVUPrintConstant.DATE_OF_NEXT_INC_2006, outputFormat.format(nextIncDate));
		context.put("DATE", outputFormat.format(new Date()));
		ArrayList<LinkedHashMap<String, Object>> arrayList = new ArrayList<>();
		SimpleDateFormat inputFormat = new SimpleDateFormat(PVUPrintConstant.DATE_YYYY_MM_DD_HH_MM_SS);
		List<PVURevisionOfPayAnnexureListView> annexureListViews = getPVURopAnnexureList(dto);
		for (PVURevisionOfPayAnnexureListView pvuRevisionOfPayAnnexureListView : annexureListViews) {
			Date effectiveDate = inputFormat.parse(pvuRevisionOfPayAnnexureListView.getEvntDate());
			LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
			hashMap.put("PAY_AFTER_INC_TABLE", outputFormat.format(effectiveDate));
			hashMap.put(PVUPrintConstant.PAY_IN_PAY_BAND_SACLE_TABLE,
					pvuRevisionOfPayAnnexureListView.getPayBandValue());
			hashMap.put(PVUPrintConstant.GRADE_PAY_APPLICABLE, pvuRevisionOfPayAnnexureListView.getGradePayValue());
			arrayList.add(hashMap);
		}
		context.put("PAYHISTORY", arrayList);

		return context;
	}

	private VelocityContext populateVContext7thPay(AnnexureDto dto) throws ParseException, CustomException {
		VelocityContext context = new VelocityContext();
		SimpleDateFormat outputFormat = new SimpleDateFormat(PVUPrintConstant.DATE_DD_MM_YYYY);
		SimpleDateFormat inputFormat1 = new SimpleDateFormat(PVUPrintConstant.DATE_YYYY_MM_DD);
		PVURevisionOfPayAnnexureView annexureView = getPVURopAnnexure(dto);
		List<PVURevisionOfPayAnnexureListView> annexureListViews = getPVURopAnnexureList(dto);
		context.put(PVUPrintConstant.GOV_SERVANT_NAME, annexureView.getEmpName());
		context.put(PVUPrintConstant.GOV_SERVANT_DESIGNATION_2016, annexureView.getEmpDesignation());
		context.put(PVUPrintConstant.GOV_SERVANT_STATUS, annexureView.getEmpStatus());
		Optional<PVUMsPayBandEntity> pvuMsPayBandEntity = pvuMsPayBandRepository.findById(dto.getPayBand());
		context.put(PVUPrintConstant.PRE_REVISED_SCALE,
				pvuMsPayBandEntity.isPresent() ? String.valueOf(pvuMsPayBandEntity.get().getStartingValue()).concat("-")
						.concat(String.valueOf(pvuMsPayBandEntity.get().getEndingValue())) : "");
		context.put(PVUPrintConstant.HIGHER_PAY_SCALE, PVUPrintConstant.EMPTY_STRING);
		context.put(PVUPrintConstant.EXISTING_EMOLUMENTS_2016, PVUPrintConstant.EMPTY_STRING);
		context.put(PVUPrintConstant.BASIC_PAY_2016, annexureView.getCurentBasicPay());
		context.put(PVUPrintConstant.DEARNESS_ALLOWANCE_2016, annexureView.getDearnessAllowance());
		context.put(PVUPrintConstant.NPA_2016, annexureView.getNpaAmount());
		context.put(PVUPrintConstant.TOTAL_EXISTING_EMOLUMENTS_2016, annexureView.gettExistingEmoluments());
		context.put(PVUPrintConstant.BASIC_PAY_IF_APPLICABLE_2016, annexureView.getCurentBasicPay());
		context.put(PVUPrintConstant.APPLICATION_LEVEL, PVUPrintConstant.LEVEL+ annexureView.getPayLevel());
		context.put(PVUPrintConstant.REVISED_PAY_2016, PVUPrintConstant.EMPTY_STRING);
		context.put(PVUPrintConstant.ANY_OTHER_INFO, PVUPrintConstant.EMPTY_STRING);
		Double result = Double.valueOf(annexureView.getCurentBasicPay()) * 2.57;
		long value = (long) Math.ceil(result);
		context.put(PVUPrintConstant.AMOUNT_BASIC_PAY, String.valueOf(((value + 99) / 100) * 100));
		context.put(PVUPrintConstant.APPLICATION_CELL, PVUPrintConstant.CELL+annexureView.getCellIdValue());
		context.put(PVUPrintConstant.REVISED_BASIC_PAY_2016, annexureView.getrBasicPay());
		context.put(PVUPrintConstant.PERSONAL_PAY_2016, PVUPrintConstant.EMPTY_STRING);
		context.put(PVUPrintConstant.PERSONAL_PAY_ADMISSIBLE,
				annexureView.getPayBandValue() == null ? "" : annexureView.getPayBandValue());
		context.put(PVUPrintConstant.NON_PRACTICING_ALLOWANCE_2016,
				annexureView.getGradePay() == null ? "" : annexureView.getGradePay());
		context.put("DATE", outputFormat.format(new Date()));
		Date nextIncDate = inputFormat1.parse(annexureView.getDateOfNextIncr());
		context.put(PVUPrintConstant.DATE_OF_NEXT_INC_2016, outputFormat.format(nextIncDate));
		ArrayList<LinkedHashMap<String, Object>> arrayList = new ArrayList<>();
		SimpleDateFormat inputFormat = new SimpleDateFormat(PVUPrintConstant.DATE_YYYY_MM_DD_HH_MM_SS);
		for (PVURevisionOfPayAnnexureListView pvuRevisionOfPayAnnexureListView : annexureListViews) {
			Date effectiveDate = inputFormat.parse(pvuRevisionOfPayAnnexureListView.getEvntDate());
			LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
			hashMap.put("PAY_AFTER_INC_TABLE", outputFormat.format(effectiveDate));
			hashMap.put(PVUPrintConstant.PAY_IN_PAY_BAND_SACLE_TABLE, pvuRevisionOfPayAnnexureListView.getPayIn7th());
			arrayList.add(hashMap);
		}
		context.put("PAYHISTORY", arrayList);
		return context;
	}

	public static PdfPCell getCell(String str) {

		Font subtitleFont = FontFactory.getFont(PVUPrintConstant.TIMES_ROMAN, 12, BaseColor.BLACK);
		PdfPCell cell = new PdfPCell(new Phrase(str, subtitleFont));
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(5);
		cell.setPaddingRight(5);
		cell.setPaddingLeft(5);
		return cell;
	}

	public static PdfPCell getCellWithBorder(String str) {

		Font subtitleFont = FontFactory.getFont(PVUPrintConstant.TIMES_ROMAN, 12, BaseColor.BLACK);
		PdfPCell cell = new PdfPCell(new Phrase(str, subtitleFont));
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(5);
		cell.setPaddingRight(5);
		cell.setPaddingLeft(5);
		return cell;
	}

	public PVURevisionOfPayAnnexureView getPVURopAnnexure(AnnexureDto dto) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("IN_ROP_TYPE", dto.getRopType());
		map.put("IN_EMP_NO", dto.getEmployeeNo());
		map.put("IN_PAY_SCALE", dto.getPayScaleId());
		map.put("IN_PAY_BAND", dto.getPayBand());
		map.put("IN_PAY_BAND_VALUE", dto.getPayBandValue());
		map.put("IN_GRADE_PAY", dto.getGradePay());
		map.put("IN_BASIC_PAY", dto.getBasicPay());
		map.put("IN_EFF_DATE", dto.getEffectiveDate());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_ROP_PRINT_CALCULATION));
		List<Object[]> obj = repository.callStoredProcedure(procName, map);
		if (!obj.isEmpty())

			return NativeQueryResultsMapper.map(obj, PVURevisionOfPayAnnexureView.class).get(0);
		else
			return null;
	}

	public List<PVURevisionOfPayAnnexureListView> getPVURopAnnexureList(AnnexureDto dto) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("IN_ROP_TYPE", dto.getRopType());
		map.put("IN_EMP_NO", dto.getEmployeeNo());
		map.put("IN_EFF_DATE", dto.getEffectiveDate());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_ROP_PRINT_CALCULATION_LIST));
		return repository.storeProc(procName, map, PVURevisionOfPayAnnexureListView.class);
	}

	@Override
	public List<PrintEndorsementRemarkHistoryDto> getRopPrintEndorsementHistory(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("trnId", id);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getEndorsementHistory(), map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

	
	@Override
	public String generatePrintEndorsement(PrintStickerReportDto dto) throws CustomException {
		try {
			List<PrintStickerReportDto> list = new ArrayList<>();
			list.add(dto);
			return getFile(list);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);

		}
	}
	
	@Override
	public String generatePrintEndorsementList(List<PrintStickerReportDto> dto) throws CustomException {
		try {
			return getFile(dto);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private String getFile(List<PrintStickerReportDto> dto) throws CustomException {
		return generatePdf(dto);
	}
	
	private String generatePdf(List<PrintStickerReportDto> dto) throws CustomException {
		Document document = new Document();
		int count = 1;
		try {
			String htmltoPdf = null;
			Map<String, Object> map = new HashMap<>();
			StringWriter writer = new StringWriter();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Change of Scale");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
			document.open();
			for (PrintStickerReportDto printStickerReportDto : dto) {
				PVURopView pvuRopView = pvuRevisionOfPayService.getRevisionOfPayView(printStickerReportDto.getStickerDTO().getId());
				writer.write(generateROPPayPdf(printStickerReportDto, pvuRopView).toString());
				if (count < dto.size()) {
					writer.append("<p style=\"page-break-after: always;\">&nbsp;</p>");
				}
				count++;
				
				XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
				xmlWorkerHelper.getDefaultCssResolver(true);
				xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));
				document.newPage();
			}
			document.close();
			map.put("content", writer.toString());
			htmltoPdf = pvuCommonService.htmlToPdfRequest(map); // call this method for node js API for html to Base64
			
			logger.info("PDF generated successfully");
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			String fileName = String.valueOf(System.currentTimeMillis()).concat(".pdf");
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
			return htmltoPdf;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	private StringWriter generateROPPayPdf(PrintStickerReportDto dto, PVURopView pvuRopView) throws CustomException, ParseException {
		StickerDTO stickerDTO = null;
		String watermark = null;
		try {
			stickerDTO = submitPrintHistory(dto,pvuRopView);
			Optional<PVUEmployeEntity> pvuEmployeEntity = pvuEmployeRepository.findByEmpIdAndActiveStatus(pvuRopView.getEmpId(), Constant.ACTIVE_STATUS);
			VelocityContext context = ropVelocityConverter(pvuEmployeEntity);
			context = setStickerValues(pvuRopView, stickerDTO, context);
			if(pvuEmployeEntity.isPresent()) {
				watermark = ", Self PVU";
				if (pvuEmployeEntity.get().getOfficeId().getDistrictId() != null) {
					context.put(PVUPrintConstant.DISTRICT_NAME, pvuEmployeEntity.get().getOfficeId().getDistrictId().getDistrictName());
				}
				if (pvuEmployeEntity.get().getOfficeId().getOfficeId()
						.equals(pvuEmployeEntity.get().getOfficeId().getPvuId())
						&& pvuEmployeEntity.get().getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
					context.put(PVUPrintConstant.PVU_OFFICE_NAME_PRINT, pvuEmployeEntity.get().getOfficeId().getOfficeName());

					context.put(PVUPrintConstant.DEPARTMENT_NAME_PRINT,
							pvuEmployeEntity.get().getOfficeId().getDepartmentId() != null
									? pvuEmployeEntity.get().getOfficeId().getDepartmentId().getDepartmentName()
									: "");

					context.put(PVUPrintConstant.PVU_DISTRICT_NAME,
							pvuEmployeEntity.get().getOfficeId().getDistrictId() != null
									? pvuEmployeEntity.get().getOfficeId().getDistrictId().getDistrictName()
									: "");

				} else {
					watermark = ", PVU, Gandhinagar";
					context.put(PVUPrintConstant.PVU_OFFICE_NAME_PRINT, pvuEmployeEntity.get().getOfficeId().getOfficeName());
					Optional<EDPMsOfficeEntity> edpMsOfficeEntity = msOfficeRepository
							.findById(pvuEmployeEntity.get().getOfficeId().getPvuId());
					if (pvuEmployeEntity.get().getOfficeId().getPvuId() != null) {
						context.put(PVUPrintConstant.DEPARTMENT_NAME_PRINT,
								edpMsOfficeEntity.isPresent()
										? edpMsOfficeEntity.get().getDepartmentId().getDepartmentName()
										: "");
					} else {
						context.put(PVUPrintConstant.DEPARTMENT_NAME_PRINT, PVUPrintConstant.EMPTY_STRING);
					}

					if (pvuEmployeEntity.get().getOfficeId().getDistrictId() != null) {
						context.put(PVUPrintConstant.PVU_DISTRICT_NAME,
								edpMsOfficeEntity.isPresent()
										? edpMsOfficeEntity.get().getDistrictId().getDistrictName()
										: "");
					}
				}
			}
			String employeeName = employeeName(pvuEmployeEntity);
			context.put(PVUPrintConstant.EMPLOYEE_FULL_NAME, employeeName);
			Map<String, Object> map = new HashMap<>();
			map.put(PVUPrintConstant.ID, dto.getStickerDTO().getId());
			Object[] obj = repository.executeNativeSQLQuerySingleResult(QueryConstant.getAuthorizedUserName(), map);
			
			if (!Utils.isEmpty(obj)) {
				context.put(PVUPrintConstant.AUTHORIZED_BY_NAME, obj[0].toString());
			}
			
			context.put(PVUPrintConstant.DDO_OFFICE_NAME, setOfficeDetails(pvuEmployeEntity));
			
			StringWriter writer = new StringWriter();
			Template template = getPrintTemplate(pvuRopView);
			template.merge(context, writer);
			return writer;
		} catch (CustomException ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}
	
	
	public Template getPrintTemplate(PVURopView pvuRopView) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		Template t = new Template();
		if (!Utils.isEmpty(pvuRopView.getRopType())) {
			if (pvuRopView.getRopType() == 412l) {
				t = ve.getTemplate("templates/rop/Pay_Endorsement_6th.vm");
			} else if (pvuRopView.getRopType() == 413l) {
				t = ve.getTemplate("templates/rop/Pay_Endorsement_7th.vm");
			}
		}
		return t;
	}
	
	private VelocityContext ropVelocityConverter(Optional<PVUEmployeEntity> pvuEmployeEntity) {
		VelocityContext stringMap = new VelocityContext();
		if(pvuEmployeEntity.isPresent()) {
		stringMap.put(PVUPrintConstant.OFFICE_NAME_PRINT, pvuEmployeEntity.get().getOfficeId().getOfficeName());
		
		if (pvuEmployeEntity.get().getOfficeId().getAddrLine1() != null) {
			stringMap.put(PVUPrintConstant.OFFICE_ADDRESS, pvuEmployeEntity.get().getOfficeId().getAddrLine1());
		}
		
		}
		if (pvuEmployeEntity.isPresent() && pvuEmployeEntity.get().getOfficeId().getTalukaId() != null) {
			stringMap.put(PVUPrintConstant.TALUKA_PRINT, ",".concat(pvuEmployeEntity.get().getOfficeId().getTalukaId().getTalukaName()));
		}else {
			stringMap.put(PVUPrintConstant.TALUKA_PRINT,PVUPrintConstant.EMPTY_STRING);
		}
		if (pvuEmployeEntity.isPresent() &&  pvuEmployeEntity.get().getOfficeId().getPincode() != null) {
			stringMap.put(PVUPrintConstant.PINCODE_PRINT, pvuEmployeEntity.get().getOfficeId().getPincode());
		}else {
			stringMap.put(PVUPrintConstant.PINCODE_PRINT, PVUPrintConstant.EMPTY_STRING);
		}
		return stringMap;
	}
	
	private VelocityContext setStickerValues(PVURopView pvuRopView, StickerDTO stickerDTO, VelocityContext stringMap)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(PvuConstant.DATE_FORMATE_DDMMYYYY);
		stringMap.put(PVUPrintConstant.EMPLOYEE_NO, pvuRopView.getEmpNo().toString());
		stringMap.put(PVUPrintConstant.DESIGNATION_PRINT, pvuRopView.getDesignationName());
		stringMap.put(PVUPrintConstant.CLASS_NAME, pvuRopView.getClassName());
		SimpleDateFormat inputFormat = new SimpleDateFormat(PVUPrintConstant.DATE_YYYY_MM_DD_HH_MM_SS);
		SimpleDateFormat outputFormat = new SimpleDateFormat(PVUPrintConstant.DATE_DD_MM_YYYY);
		Date nxtIncDate = inputFormat.parse(pvuRopView.getRevNextIncrementDate());
		stringMap.put(PVUPrintConstant.EVENT_NAME_PRINT, pvuRopView.getRopTypeValue()); 
		stringMap.put(PVUPrintConstant.DATE_OF_NEXT_INCREMENT, outputFormat.format(nxtIncDate));
		stringMap.put(PVUPrintConstant.ENDORSEMENT_PRINT_DATE_PRINT, sdf.format(stickerDTO.getEndorsementPrintDate()));
		if(stickerDTO.getEndorsementReprintDate()!= null){
			stringMap.put(PVUPrintConstant.ENDORSEMENT_REPRINT_DATE_PRINT, PVUPrintConstant.REPRINT_DATE.concat(sdf.format(stickerDTO.getEndorsementReprintDate())));
			stringMap.put(PVUPrintConstant.NUMBER_OF_COUNT_REPRINTED, PVUPrintConstant.REPRINT_COUNT.concat(String.valueOf(stickerDTO.getRePrintCount() - 1)));
			stringMap.put(PVUPrintConstant.REPRINT_REMARK_PRINT, PVUPrintConstant.REPRINT_REMARKS.concat(stickerDTO.getRePrintRemark()));
		}else{
			stringMap.put(PVUPrintConstant.ENDORSEMENT_REPRINT_DATE_PRINT,PVUPrintConstant.EMPTY_STRING);
			stringMap.put(PVUPrintConstant.NUMBER_OF_COUNT_REPRINTED, PVUPrintConstant.EMPTY_STRING);
			stringMap.put(PVUPrintConstant.REPRINT_REMARK_PRINT, PVUPrintConstant.EMPTY_STRING);
		}
		
		if(pvuRopView.getClassTwoRemarks()!=null) {
			stringMap.put(PVUPrintConstant.REMARK_PRINT, pvuRopView.getClassTwoRemarks());
		}else {
			stringMap.put(PVUPrintConstant.REMARK_PRINT,PVUPrintConstant.EMPTY_STRING);
		}
		
		if (stickerDTO.getRopType() == 412) {
			stringMap.put(PVUPrintConstant.BASIC_LAST_PAY_SCALE, pvuRopView.getCurScaleName());
			stringMap.put(PVUPrintConstant.PAY_BASIC, pvuRopView.getCurBasicPay());
			stringMap.put(PVUPrintConstant.BASIC_PAY, pvuRopView.getRevBasicPay().toString());
			stringMap.put(PVUPrintConstant.REVISED_PAY_BAND_PRINT, pvuRopView.getRevPayBandName());
			
			if(pvuRopView.getRevPayBandValue()!=null) {
				stringMap.put(PVUPrintConstant.PAY_IN_THE_PAY_BAND, pvuRopView.getRevPayBandValue().toString());
				stringMap.put(PVUPrintConstant.GRADE_PAY, pvuRopView.getRevGradePayValue().toString());
			}
			
			Long basicPayTotal = 0L;
			if (pvuRopView.getRevBasicPay() != null) {
				basicPayTotal = pvuRopView.getRevBasicPay();
				if (pvuRopView.getRevGradePayValue() != null) {
					basicPayTotal = basicPayTotal + pvuRopView.getRevGradePayValue();
				}
			}
			stringMap.put(PVUPrintConstant.BASIC_PAY_TOTAL, basicPayTotal.toString());
		
		} else if (stickerDTO.getRopType() == 413) {
			stringMap.put(PVUPrintConstant.FINAL_PAY_BAND, pvuRopView.getCurPayBandName());
			stringMap.put(PVUPrintConstant.LAST_PAY_BAND_VALUE, pvuRopView.getCurPayBandValue().toString());
			stringMap.put(PVUPrintConstant.PAY_GRADE_PAY, pvuRopView.getCurGradePayValue());
			stringMap.put(PVUPrintConstant.PAY_IN_THE_LEVEL, pvuRopView.getRevBasicPay().toString());
			stringMap.put(PVUPrintConstant.LEVEL_ID, pvuRopView.getRevPayLevelValue());
			stringMap.put(PVUPrintConstant.CELL_ID, pvuRopView.getRevCellValue().toString());
			List<Long> minCellValue = payCellRepository.getMinCellValueByLevelId(pvuRopView.getRevPayLevel());
			List<Long> maxCellValue = payCellRepository.getMaxCellValueByLevelId(pvuRopView.getRevPayLevel());
			String minValue = minCellValue.get(0).toString();
			String maxValue = maxCellValue.get(0).toString();
			stringMap.put(PVUPrintConstant.VERTICAL_RANGE_OF_PAY_LEVEL, minValue.concat("-").concat(maxValue));
		}
		return stringMap;
	}

}

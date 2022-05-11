package gov.ifms.edp.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.filenet.api.core.Document;
import com.filenet.api.util.Id;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.FilenetUtility;
import gov.ifms.edp.converter.EDPBulkEmployeeCreationConverter;
import gov.ifms.edp.dto.EDPBulkEmpCreationBasicDto;
import gov.ifms.edp.dto.EDPBulkEmployeeCreationDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPBECUploadAttachEntity;
import gov.ifms.edp.entity.EDPBECUserEntity;
import gov.ifms.edp.entity.EDPBulkEmpCreationBasicEntity;
import gov.ifms.edp.entity.EDPBulkEmployeeCreationEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPBECBasicRepository;
import gov.ifms.edp.repository.EDPBECDataRepository;
import gov.ifms.edp.repository.EDPBECUploadAttachRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPUserCreationRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

@Service
public class EDPUserCreationServiceImpl implements EDPUserCreationService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private EDPUserCreationRepository repository;

	@Autowired
	private EDPBECBasicRepository edpBecBasicRepository;

	@Autowired
	private EDPBECDataRepository dataRepository;

	@Autowired
	private EDPBECUploadAttachRepository attachRepository;

	@Autowired
	private EDPMsOfficeServiceImpl edpMsOfficeService;

	@Autowired
	private EDPMsFinancialYearRepository edpMsFinancialYearRepository;

	@Autowired
	private EDPBulkEmployeeCreationConverter converter;

	@Autowired
	private EDPEmployeRepository employeRepository;

	@Autowired
	private EDPMsDistrictRepository districtRepository;

	@Autowired
	private EDPMsOfficeRepository officeRepository;

	@Autowired
	private EDPMsDesignationRepository designationRepository;

	@PersistenceContext
	private EntityManager em;

	private XSSFWorkbook workbook;

	@Value("${menus.hod}")
	private String hodMenus;

	@Value("${menus.ad}")
	private String adMenus;

	@Value("${menus.fd}")
	private String fdMenus;

	@Value("${menus.ddo}")
	private String ddoMenus;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EDPBulkEmployeeCreationEntity saveBulkEmployeeCreationTransaction(EDPBulkEmployeeCreationDto dto)
			throws CustomException {
		EDPBulkEmployeeCreationEntity entity = repository.save(converter.toEntity(dto));
		generateTranNo(entity.getBecId());
		return entity;
	}

	private void generateTranNo(Long headerId) {
		EDPMsFinancialYearEntity currentYear = edpMsFinancialYearRepository
				.findByIsCurrentYearLookUpInfoName(Constant.LOOKUP_YES);
		String refNo = currentYear.getFyShort() + EDPConstant.BULK_EMP_CREATION
				+ EDPUtility.getAddLendingZero(headerId.toString());
		repository.updateTrnNoByBulkEmpCreationId(headerId, refNo);
	}

	@Override
	public ByteArrayInputStream submitBulkEmployeeData(long trnId) throws CustomException {
		EDPBECUploadAttachEntity entity = attachRepository.findByTrnIdAndActiveStatus(trnId, Constant.ACTIVE_STATUS);
		if (entity == null) {
			throw new CustomException(ErrorResponse.PLEASE_UPLOAD_ATTACHMENT);
		}
		Id id = new Id(entity.getDocumentId());
		final Document document = FilenetUtility.retrieveDocument(id);
		InputStreamResource inputStreamResource = new InputStreamResource(document.accessContentStream(0));
		return readExcel(inputStreamResource);
	}

	/**
	 * Read excel.
	 *
	 * @param inputStreamResource      the ag upload hdr dto
	 * @param inputStreamResource the input stream resource
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("deprecation")
	public ByteArrayInputStream readExcel(InputStreamResource inputStreamResource) throws CustomException {
		try (Workbook wb = WorkbookFactory.create(inputStreamResource.getInputStream())) {
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			int rowIndex = 0;

			Map<String, EDPBulkEmpCreationBasicEntity> map = new HashMap<>();

			List<EDPBulkEmpCreationBasicDto> errorList = new ArrayList<EDPBulkEmpCreationBasicDto>();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (rowIndex == 0) {
					validateHeader(row);
				} else {
					saveUserDataByRowWise(row, map, errorList);
				}

				rowIndex++;
			}
			List<EDPBulkEmpCreationBasicEntity> oList = new ArrayList<EDPBulkEmpCreationBasicEntity>();
			List<EDPBECUserEntity> oListEntities = new ArrayList<EDPBECUserEntity>();

			for (Map.Entry<String, EDPBulkEmpCreationBasicEntity> entry : map.entrySet()) {
				oList.add(entry.getValue());
			}

			List<String> pans = oList.stream().map(m -> m.getPan()).collect(Collectors.toList());

			for (String pan : pans) {
				edpBecBasicRepository.updateByPan(pan);
			}
			for (EDPBulkEmpCreationBasicEntity o : oList) {
				createEmployee(o);

				em.clear();
				List<EDPBECUserEntity> entries = dataRepository.findByPanAndActiveStatus(o.getPan(), 1L);

				if (entries != null) {
					if (entries.size() > 0) {
						EDPBECUserEntity entity = entries.get(entries.size() - 1);
						updateErrorList(errorList, entity.getPan());
						oListEntities.add(entity);
						createUser(entity);
						assignMenu(entity);
					}
				}

			}

			return generateExcel(oListEntities, errorList);
		} catch (IOException e) {
			logger.error("Error occured while read BEC upload template");
			throw new CustomException(HttpStatus.CONFLICT, e.getMessage());
		} catch (Exception e) {
			throw new CustomException(HttpStatus.CONFLICT, e.getMessage());
		}
	}

	private void updateErrorList(List<EDPBulkEmpCreationBasicDto> errorList, String pan) {
		Optional<EDPBulkEmpCreationBasicEntity> entity = edpBecBasicRepository.findByPanAndIsCreateAndActiveStatus(pan,
				2, 1L);
		if (entity.isPresent()) {
			EDPBulkEmpCreationBasicDto dto = new EDPBulkEmpCreationBasicDto();
			BeanUtils.copyProperties(entity, dto);
			dto.setIssue("Designation_name");
			errorList.add(dto);
		}

	}

	private void createEmployee(EDPBulkEmpCreationBasicEntity entity) {
		edpBecBasicRepository.save(entity);
		repository.callStoredProcedure("EDP.BULK_EMP_CREATION_INTERNAL");
		repository.callStoredProcedure("EDP.BULK_EMP_CREATION");
	}

	private void createUser(EDPBECUserEntity entity) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(EDPConstant.IN_USER_DESC, entity.getFirstName());
		map.put(EDPConstant.IN_USER_CODE, entity.getEmpNo());
		map.put(EDPConstant.IN_DESIGNATION_ID, entity.getDesignationId());
		map.put(EDPConstant.BEC_IN_OFFICE_ID, entity.getOfficeId());
		map.put(EDPConstant.IN_IS_PRIMARY_POST, 2);

		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_NEW_BULK_USER_CREATION));
		try {
			repository.callStoredProcedure(procName, map, "RESULTMSG");
		} catch (Exception e) {
			logger.error(e.getMessage());

		}
	}

	private void assignMenu(EDPBECUserEntity entity) {

		Map<String, Object> map = new HashMap<>();
		map.put(EDPConstant.IN_USER_CODE, entity.getEmpNo() + "");

		StringBuilder menuIds = new StringBuilder();
		EDPMsOfficeDto edpMsOfficeDto = edpMsOfficeService.getMsOffice((long) entity.getOfficeId());
		if (edpMsOfficeDto.getOfficeTypeId() == 52L) {
			// menuIds.append("251,146,138,5,252,147,140,139,6,176");
			map.put(EDPConstant.IN_MENU_ID, this.adMenus);
		} else if (edpMsOfficeDto.getOfficeTypeId() == 54L) {
			// menuIds.append("46,147,152,5,6,138,139,151");
			map.put(EDPConstant.IN_MENU_ID, this.hodMenus);
		} else if (edpMsOfficeDto.getOfficeTypeId() == 71L) {
			// menuIds.append("5,6,146,147");
			map.put(EDPConstant.IN_MENU_ID, this.ddoMenus);
		}

		// map.put(EDPConstant.IN_MENU_ID, new String(menuIds));
		map.put(EDPConstant.IN_ROLE_PERM_ID, 7);
		StringBuilder sBuilder = new StringBuilder();

		if ("Creator".equalsIgnoreCase(entity.getWf1())) {
			sBuilder.append("1 ");
		}
		if ("Verifier".equalsIgnoreCase(entity.getWf2())) {
			sBuilder.append("2 ");
		}
		if ("Approver".equalsIgnoreCase(entity.getWf3())) {
			sBuilder.append("3 ");
		}
		String wf = (new String(sBuilder)).trim().replaceAll(" ", ",");
		map.put(EDPConstant.IN_WF_ROLE_ID, wf);

		String procName = Constant.BUDGET_MASTER_SCHEMA
				.concat(Constant.DOT.concat(EDPConstant.SP_NEW_ADD_MENU_TO_USER_BUDGET_GOG));
		try {
			repository.callStoredProcedure(procName, map, "RESULTMSG");
		} catch (Exception e) {
			logger.error(e.getMessage());

		}
	}

	@SuppressWarnings("deprecation")
	private void saveUserDataByRowWise(Row row, Map<String, EDPBulkEmpCreationBasicEntity> map,
			List<EDPBulkEmpCreationBasicDto> errorList) throws CustomException, ParseException {

		EDPBulkEmpCreationBasicDto dto = new EDPBulkEmpCreationBasicDto();

		String districtName = row.getCell(1) == null || StringUtils.isEmpty(row.getCell(1)) ? null
				: row.getCell(1).toString().trim();

		String ddoNo = null;
		BigDecimal bd = null;

		if (row.getCell(2) == null || StringUtils.isEmpty(row.getCell(2))
				|| (row.getCell(2).getCellTypeEnum() != CellType.NUMERIC)) {
			ddoNo = null;
		} else {
			bd = new BigDecimal(row.getCell(2).getNumericCellValue());
			ddoNo = String.valueOf(bd.longValue());
		}
		String cardexNo = null;
		if (row.getCell(3) == null || StringUtils.isEmpty(row.getCell(3))
				|| (row.getCell(3).getCellTypeEnum() != CellType.NUMERIC)) {
			cardexNo = null;
		} else {
			bd = new BigDecimal(row.getCell(3).getNumericCellValue());
			cardexNo = String.valueOf(bd.longValue());
		}

		String officeName = row.getCell(4) == null || StringUtils.isEmpty(row.getCell(4)) ? null
				: row.getCell(4).toString().trim();
		String roles = row.getCell(5) == null || StringUtils.isEmpty(row.getCell(5)) ? null
				: row.getCell(5).toString().trim();
		String salutation = row.getCell(6) == null || StringUtils.isEmpty(row.getCell(6)) ? null
				: row.getCell(6).getStringCellValue().trim();
		String firstName = row.getCell(7) == null || StringUtils.isEmpty(row.getCell(7)) ? null
				: row.getCell(7).toString().trim();
		String middleName = row.getCell(8) == null || StringUtils.isEmpty(row.getCell(8)) ? null
				: row.getCell(8).toString().trim();
		String lastName = row.getCell(9) == null || StringUtils.isEmpty(row.getCell(9)) ? null
				: row.getCell(9).toString().trim();
		String designation = row.getCell(10) == null || StringUtils.isEmpty(row.getCell(10)) ? null
				: row.getCell(10).toString().trim();

		String dob = (row.getCell(11) == null || StringUtils.isEmpty(row.getCell(11))) ? null
				: row.getCell(11).toString().trim();

		String pan = row.getCell(12) == null || StringUtils.isEmpty(row.getCell(12)) ? null
				: row.getCell(12).toString().trim();

		String mobileNo = null;
		System.out.println("###Cell type of mobile no. "+row.getCell(13).getCellTypeEnum());
		if (row.getCell(13) == null || StringUtils.isEmpty(row.getCell(13))
				|| (row.getCell(13).getCellTypeEnum() == CellType.NUMERIC)) {
			bd = new BigDecimal(row.getCell(13).getNumericCellValue());
			mobileNo = String.valueOf(bd.longValue());
		} else {
			mobileNo = row.getCell(13) == null || StringUtils.isEmpty(row.getCell(13)) ? null
					: row.getCell(13).toString().trim();
		}

		String caseNo = null;
		if (row.getCell(14) == null || StringUtils.isEmpty(row.getCell(14))
				|| (row.getCell(14).getCellTypeEnum() != CellType.NUMERIC)) {
			caseNo = null;
		} else {
			bd = new BigDecimal(row.getCell(14).getNumericCellValue());
			caseNo = String.valueOf(bd.longValue());
		}
		String wf1 = null;
		String wf2 = null;
		String wf3 = null;

		if ("Creator".equalsIgnoreCase(roles)) {
			wf1 = "Creator";
		} else if ("Verifier".equalsIgnoreCase(roles)) {
			wf2 = "Verifier";
		} else if ("Approver".equalsIgnoreCase(roles)) {
			wf3 = "Approver";
		}

		dto.setDistrictName(districtName);
		dto.setDdoNo(ddoNo);
		dto.setCardexNo(cardexNo);
		dto.setOfficeName(officeName);
		dto.setSaluation(salutation);
		dto.setFirstName(firstName);
		dto.setMiddelName(middleName);
		dto.setLastName(lastName);
		dto.setDesignation(designation);
		dto.setDob(dob == null || !isDateValid(dob) ? null : dob);
		dto.setPan(pan);
		dto.setCaseNo(caseNo);
		dto.setWorkflow1(wf1);
		dto.setWorkflow2(wf2);
		dto.setWorkflow3(wf3);
		dto.setActiveStatus(1l);
		dto.setMobileNoStr(mobileNo);

		if(validateData(dto)){
			EDPBulkEmpCreationBasicEntity entity;
			if (map.containsKey(pan)) {
				entity = map.get(pan);
			} else {
				entity = new EDPBulkEmpCreationBasicEntity();
				BeanUtils.copyProperties(dto, entity);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateObj = sdf.parse(entity.getDob());
			entity.setDob(simpleDateFormat.format(dateObj));
			System.out.println("####DOB Before inserting = "+simpleDateFormat.format(dateObj));
			map.put(pan, entity);
		}else{
			errorList.add(dto);
		}
	}

	private void validateHeader(Row row) throws CustomException {
		boolean isValid = true;
		String columnName = null;
		String invlidColumnName = null;
		if (row.getCell(0) == null || StringUtils.isEmpty(row.getCell(0))
				|| !(EDPConstant.BEC_SERIAL_NO).equals(row.getCell(0).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(0).toString().trim();
			columnName = EDPConstant.BEC_SERIAL_NO;
		} else if (row.getCell(1) == null || StringUtils.isEmpty(row.getCell(1))
				|| !(EDPConstant.BEC_DISTRICT_NAME).equals(row.getCell(1).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(1).toString().trim();
			columnName = EDPConstant.BEC_DISTRICT_NAME;
		} else if (row.getCell(2) == null || StringUtils.isEmpty(row.getCell(2))
				|| !(EDPConstant.BEC_DDO_NO).equals(row.getCell(2).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(2).toString().trim();
			columnName = EDPConstant.BEC_DDO_NO;
		} else if (row.getCell(3) == null || StringUtils.isEmpty(row.getCell(3))
				|| !(EDPConstant.BEC_CARDEX_NO).equals(row.getCell(3).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(3).toString().trim();
			columnName = EDPConstant.BEC_CARDEX_NO;
		} else if (row.getCell(4) == null || StringUtils.isEmpty(row.getCell(4))
				|| !(EDPConstant.BEC_OFFICE_NAME).equals(row.getCell(4).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(4).toString().trim();
			columnName = EDPConstant.BEC_OFFICE_NAME;
		} else if (row.getCell(5) == null || StringUtils.isEmpty(row.getCell(5))
				|| !(EDPConstant.BEC_ROLE).equals(row.getCell(5).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(5).toString().trim();
			columnName = EDPConstant.BEC_ROLE;
		} else if (row.getCell(6) == null || StringUtils.isEmpty(row.getCell(6))
				|| !(EDPConstant.BEC_SALUTATION).equals(row.getCell(6).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(6).toString().trim();
			columnName = EDPConstant.BEC_SALUTATION;
		} else if (row.getCell(7) == null || StringUtils.isEmpty(row.getCell(7))
				|| !(EDPConstant.BEC_FIRST_NAME).equals(row.getCell(7).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(7).toString().trim();
			columnName = EDPConstant.BEC_FIRST_NAME;
		} else if (row.getCell(8) == null || StringUtils.isEmpty(row.getCell(8))
				|| !(EDPConstant.BEC_MIDDLE_NAME).equals(row.getCell(8).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(8).toString().trim();
			columnName = EDPConstant.BEC_MIDDLE_NAME;
		} else if (row.getCell(9) == null || StringUtils.isEmpty(row.getCell(9))
				|| !(EDPConstant.BEC_LAST_NAME).equals(row.getCell(9).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(9).toString().trim();
			columnName = EDPConstant.BEC_LAST_NAME;
		} else if (row.getCell(10) == null || StringUtils.isEmpty(row.getCell(10))
				|| !(EDPConstant.BEC_DESIGNATION).equals(row.getCell(10).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(10).toString().trim();
			columnName = EDPConstant.BEC_DESIGNATION;
		} else if (row.getCell(11) == null || StringUtils.isEmpty(row.getCell(11))
				|| !(EDPConstant.BEC_DOB).equals(row.getCell(11).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(11).toString().trim();
			columnName = EDPConstant.BEC_DOB;
		} else if (row.getCell(12) == null || StringUtils.isEmpty(row.getCell(12))
				|| !(EDPConstant.BEC_PAN).equals(row.getCell(12).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(12).toString().trim();
			columnName = EDPConstant.BEC_PAN;
		} else if (row.getCell(13) == null || StringUtils.isEmpty(row.getCell(13))
				|| !(EDPConstant.BEC_CONTACT_NO).equals(row.getCell(13).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(13).toString().trim();
			columnName = EDPConstant.BEC_CONTACT_NO;
		} else if (row.getCell(14) == null || StringUtils.isEmpty(row.getCell(14))
				|| !(EDPConstant.BEC_PAY_FIXATION_CASE_NO).equals(row.getCell(14).toString().trim())) {
			isValid = false;
			invlidColumnName = row.getCell(14).toString().trim();
			columnName = EDPConstant.BEC_PAY_FIXATION_CASE_NO;
		}
		if (!isValid) {
			throwsException(invlidColumnName, columnName, true);
		}

	}

	/**
	 * Validate data.
	 *
	 * @param dto the row
	 * @throws CustomException the custom exception
	 */
	public boolean validateData(EDPBulkEmpCreationBasicDto dto) throws CustomException {

		long distId = 0;

		if(dto.getDistrictName()==null || StringUtils.isEmpty(dto.getDistrictName())){
			dto.setIssue("Please enter District Name.");
			return false;
		}else{
			Optional<EDPMsDistrictEntity> opDist = districtRepository.findByDistrictNameAndActiveStatus(dto.getDistrictName(),Constant.ACTIVE_STATUS);
			if(!opDist.isPresent()){
				dto.setIssue("District Name is Not Valid.");
				return false;
			}else{
				distId = opDist.get().getDistrictId();
			}
		}

		if (dto.getDdoNo() == null || StringUtils.isEmpty(dto.getDdoNo())) {
			dto.setIssue("Please Enter DDO No.");
			return false;
		}

		if (dto.getCardexNo() == null || StringUtils.isEmpty(dto.getCardexNo())) {
			dto.setIssue("Please Enter Cardex No.");
			return false;
		}

		Optional<EDPMsOfficeEntity> office = officeRepository.findOffByDdoNoCardexNoAndDist(dto.getDdoNo(),Long.parseLong(dto.getCardexNo()),distId,Constant.ACTIVE_STATUS,EDPConstant.STATUS_APPROVED_ID,EDPConstant.OFFICE_STATUS_ID);

		if(!office.isPresent()){
			dto.setIssue("Office is not found. Provided DDO No. or Cardex No. is not Valid.");
			return false;
		}

		if (dto.getFirstName() == null || StringUtils.isEmpty(dto.getFirstName())) {
			dto.setIssue("Please enter First Name.");
			return false;
		}

		if (dto.getLastName() == null || StringUtils.isEmpty(dto.getLastName())) {
			dto.setIssue("Please enter Last Name.");
			return false;
		}

		if (dto.getDesignation() == null || StringUtils.isEmpty(dto.getDesignation())) {
			dto.setIssue("Please enter Designation.");
			return false;
		}else{
			if(designationRepository.countByDesignationNameIgnoreCaseAndActiveStatus(dto.getDesignation(),Constant.ACTIVE_STATUS) == 0){
				dto.setIssue("Designation is not valid.");
				return false;
			}
		}



		if (dto.getDob() == null || StringUtils.isEmpty(dto.getDob())) {
			dto.setIssue("Please enter DOB in dd-mm-yyyy format.");
			return false;
		} else if (!isDateValid(dto.getDob())) {
			dto.setIssue("DOB is not in correct format. Please enter DOB in dd-mm-yyyy format.");
			return false;
		}

		String rx = "[A-Z]{3}([CHFATBLJGP])(?:(?<=P)" + dto.getLastName().charAt(0) + "|(?<!P)" + dto.getFirstName().charAt(0) + ")[0-9]{4}[A-Z]";
		if(!dto.getPan().matches(rx)){
			dto.setIssue("PAN Card No. is not in valid format.Please enter PAN CARD NO. in (ABCDF1234Z OR ABCPS1234Z) format.");
			return false;
		}

		Optional<EDPEmployeEntity> employeEntity =  employeRepository.findByPanNoAndActiveStatus(dto.getPan(),Constant.ACTIVE_STATUS);
		if (employeEntity.isPresent()){
			dto.setIssue("Employee Already Exist (Matched by Pan no.). Employee Code is "+employeEntity.get().getEmployeeCode());
			return false;
		}

		if(dto.getCaseNo()!=null && !StringUtils.isEmpty(dto.getCaseNo())){
			Optional<EDPEmployeEntity> employeEntityByCaseNo =  employeRepository.findByCaseNoAndActiveStatus(dto.getCaseNo(),Constant.ACTIVE_STATUS);
			if (employeEntityByCaseNo.isPresent()){
				dto.setIssue("Employee Already Exist (Matched by Case no.). Employee Code is "+employeEntityByCaseNo.get().getEmployeeCode());
				return false;
			}
		}

		if(dto.getMobileNoStr()!=null && !StringUtils.isEmpty(dto.getMobileNoStr())) {
			String mNoRegEx = "\\d{10}";
			if (!dto.getMobileNoStr().matches(mNoRegEx)) {
				dto.setIssue("Mobile No. is not Valid.");
				return false;
			}{
				dto.setMobileNo(Long.parseLong(dto.getMobileNoStr()));
			}
		}

		return true;
	}

	private void throwsException(String meg, String msg1, boolean isColumn) throws CustomException {
		if (isColumn) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.ERROR_BUD_INVALID_AG_UP_TEM_HDR, meg, msg1));
		} else {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.ERROR_BUD_INVALID_AG_UP_REC, meg, msg1));
		}
	}

	private boolean isDateValid(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			Date dateObj = sdf.parse( dateStr );
			System.out.println("####DOB = "+sdf.format(dateObj));
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	private ByteArrayInputStream generateExcel(List<EDPBECUserEntity> savedList,
			List<EDPBulkEmpCreationBasicDto> errorList) {

		workbook = new XSSFWorkbook();

		XSSFSheet createedEmpSheet = workbook.createSheet("Created Employees Data");
		XSSFSheet wrongEmpSheet = workbook.createSheet("Wrong Formate Data");
		createedEmpSheet.setDefaultColumnWidth(7000);
		for (int i = 0; i <= 15; i++) {
			if (i == 0 || i == 2 || i == 3 || i == 5) {
				createedEmpSheet.setColumnWidth(i, 3000);

			} else {
				createedEmpSheet.setColumnWidth(i, 5000);

			}
		}
		for (int i = 0; i <= 14; i++) {
			if (i == 0 || i == 2 || i == 3 || i == 5) {
				wrongEmpSheet.setColumnWidth(i, 3000);

			} else {
				wrongEmpSheet.setColumnWidth(i, 3000);

			}
		}
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		// style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setWrapText(true);

		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 12);
		// font.setBold(true);
		style.setFont(font);

		int rowNum1 = 0;
		int rowNum2 = 0;
		System.out.println("Creating excel");
		Row row1 = createedEmpSheet.createRow(rowNum1);
		writeBook(null, row1, rowNum1++, style, true);

		Row row2 = wrongEmpSheet.createRow(rowNum2);
		writeErrorBook(null, row2, rowNum2++, style, false);

		for (EDPBECUserEntity entity : savedList) {
			Row row = createedEmpSheet.createRow(rowNum1);
			writeBook(entity, row, rowNum1, style, true);
			rowNum1++;
		}
		for (EDPBulkEmpCreationBasicDto dto : errorList) {
			Row row = wrongEmpSheet.createRow(rowNum2);
			writeErrorBook(dto, row, rowNum2, style, false);
			rowNum2++;
		}
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			byte[] barray = bos.toByteArray();
			return new ByteArrayInputStream(barray);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		return null;
	}

	private void writeBook(EDPBECUserEntity entity, Row row, int count, CellStyle style, boolean type) {
		if (count == 0) {
			writeHeader(row, style, type);
		} else {
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(count);

			Cell cell1 = row.createCell(1);
			cell1.setCellValue(entity.getDistrictName() == null ? null : entity.getDistrictName());

			Cell cell2 = row.createCell(2);
			cell2.setCellValue(entity.getDdoNo() == null ? null : (int) Double.parseDouble(entity.getDdoNo()));

			Cell cell3 = row.createCell(3);
			cell3.setCellValue(entity.getCardexNo() == null ? null : (int) Double.parseDouble(entity.getCardexNo()));

			Cell cell4 = row.createCell(4);
			cell4.setCellValue(entity.getOfficeName() == null ? null : entity.getOfficeName());

			Cell cell5 = row.createCell(5);
			cell5.setCellValue("");

			Cell cell6 = row.createCell(6);
			cell6.setCellValue(entity.getSalutation() == null ? null : entity.getSalutation());

			Cell cell7 = row.createCell(7);
			cell7.setCellValue(entity.getFirstName() == null ? null : entity.getFirstName());

			Cell cell8 = row.createCell(8);
			cell8.setCellValue(entity.getMiddleName() == null ? null : entity.getMiddleName());

			Cell cell9 = row.createCell(9);
			cell9.setCellValue(entity.getLastName() == null ? null : entity.getLastName());

			Cell cell10 = row.createCell(10);
			cell10.setCellValue(entity.getDesignation() == null ? null : entity.getDesignation());

			Cell cell11 = row.createCell(11);
			cell11.setCellValue(entity.getDob() == null ? null : entity.getDob());

			Cell cell12 = row.createCell(12);
			cell12.setCellValue(entity.getPan() == null ? null : entity.getPan());

			Cell cell13 = row.createCell(13);
			if (entity.getMobileNo() != null) {
				cell13.setCellValue(entity.getMobileNo());
			}

			Cell cell14 = row.createCell(14);
			cell14.setCellValue(entity.getCaseNo() == null ? null : entity.getCaseNo());

			if (type) {
				Cell cell15 = row.createCell(15);
				if (entity.getEmpNo() != null) {
					cell15.setCellValue(entity.getEmpNo());
				}
			}

		}

	}

	private void writeErrorBook(EDPBulkEmpCreationBasicDto entity, Row row, int count, CellStyle style, boolean type) {
		if (count == 0) {
			writeHeader(row, style, type);
		} else {
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(count);

			Cell cell1 = row.createCell(1);
			cell1.setCellValue(entity.getDistrictName() == null ? null : entity.getDistrictName());
			try {
				Cell cell2 = row.createCell(2);
				cell2.setCellValue(entity.getDdoNo() == null ? null : (int) Double.parseDouble(entity.getDdoNo()));

				Cell cell3 = row.createCell(3);
				cell3.setCellValue(
						entity.getCardexNo() == null ? null : (int) Double.parseDouble(entity.getCardexNo()));
			} catch (Exception e) {
				Cell cell2 = row.createCell(2);
				cell2.setCellValue(entity.getDdoNo());

				Cell cell3 = row.createCell(3);
				cell3.setCellValue(
						entity.getCardexNo());
			}

			Cell cell4 = row.createCell(4);
			cell4.setCellValue(entity.getOfficeName() == null ? null : entity.getOfficeName());

			Cell cell5 = row.createCell(5);
			cell5.setCellValue("");

			Cell cell6 = row.createCell(6);
			cell6.setCellValue(entity.getSaluation() == null ? null : entity.getSaluation());

			Cell cell7 = row.createCell(7);
			cell7.setCellValue(entity.getFirstName() == null ? null : entity.getFirstName());

			Cell cell8 = row.createCell(8);
			cell8.setCellValue(entity.getMiddelName() == null ? null : entity.getMiddelName());

			Cell cell9 = row.createCell(9);
			cell9.setCellValue(entity.getLastName() == null ? null : entity.getLastName());

			Cell cell10 = row.createCell(10);
			cell10.setCellValue(entity.getDesignation() == null ? null : entity.getDesignation());

			Cell cell11 = row.createCell(11);
			cell11.setCellValue(entity.getDob() == null ? null : entity.getDob());

			Cell cell12 = row.createCell(12);
			cell12.setCellValue(entity.getPan() == null ? null : entity.getPan());

			Cell cell13 = row.createCell(13);
			if (entity.getMobileNoStr() != null) {
				cell13.setCellValue(entity.getMobileNoStr());
			}

			Cell cell14 = row.createCell(14);
			cell14.setCellValue(entity.getCaseNo() == null ? null : entity.getCaseNo());

			Cell cell15 = row.createCell(15);
			cell15.setCellValue(entity.getIssue() == null ? null : entity.getIssue());

		}

	}

	private void writeHeader(Row row, CellStyle style, boolean flag) {
		Object[] headers = { EDPConstant.BEC_SERIAL_NO, EDPConstant.BEC_DISTRICT_NAME, EDPConstant.BEC_DDO_NO,
				EDPConstant.BEC_CARDEX_NO, EDPConstant.BEC_OFFICE_NAME, EDPConstant.BEC_ROLE,
				EDPConstant.BEC_SALUTATION, EDPConstant.BEC_FIRST_NAME, EDPConstant.BEC_MIDDLE_NAME,
				EDPConstant.BEC_LAST_NAME, EDPConstant.BEC_DESIGNATION, EDPConstant.BEC_DOB, EDPConstant.BEC_PAN,
				EDPConstant.BEC_CONTACT_NO, EDPConstant.BEC_PAY_FIXATION_CASE_NO, EDPConstant.BEC_EMPLOYEE_NO };
		Object[] headersError = { EDPConstant.BEC_SERIAL_NO, EDPConstant.BEC_DISTRICT_NAME, EDPConstant.BEC_DDO_NO,
				EDPConstant.BEC_CARDEX_NO, EDPConstant.BEC_OFFICE_NAME, EDPConstant.BEC_ROLE,
				EDPConstant.BEC_SALUTATION, EDPConstant.BEC_FIRST_NAME, EDPConstant.BEC_MIDDLE_NAME,
				EDPConstant.BEC_LAST_NAME, EDPConstant.BEC_DESIGNATION, EDPConstant.BEC_DOB, EDPConstant.BEC_PAN,
				EDPConstant.BEC_CONTACT_NO, EDPConstant.BEC_PAY_FIXATION_CASE_NO, EDPConstant.BEC_ISSUES };
		int colNum = 0;

		for (Object field : (flag ? headers : headersError)) {
			Cell cell = row.createCell(colNum++);
			cell.setCellStyle(style);

			if (field instanceof String) {
				cell.setCellValue((String) field);
			} else if (field instanceof Integer) {
				cell.setCellValue((Integer) field);
			}
		}
	}

}

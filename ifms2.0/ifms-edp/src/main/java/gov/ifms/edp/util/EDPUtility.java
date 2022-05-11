package gov.ifms.edp.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.constants.AutoClassify;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.CheckinType;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Document;
import com.filenet.api.core.Domain;
import com.filenet.api.core.DynamicReferentialContainmentRelationship;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.UpdatingBatch;
import com.filenet.api.util.Id;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Constant.Regex;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.FilenetUtility;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPAddDesAttachmentDto;
import gov.ifms.edp.dto.EDPHeaderParam;
import gov.ifms.edp.dto.EDPOfficeAttachmentDto;
import gov.ifms.edp.dto.EDPPostAttachmentDto;
import gov.ifms.edp.dto.EDPReportPageDetails;
import gov.ifms.edp.dto.EDPReportSearchParamDto;
import gov.ifms.edp.dto.EDPTrnUpdDsgnAttachmentDto;
import gov.ifms.edp.dto.EDPTrnUserMpAttDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsAttDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;

/**
 * The Class EDPUtility.
 */
public class EDPUtility {

	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(EDPUtility.class.getName());
	
	/**
	 * Instantiates a new EDP utility.
	 */
	private EDPUtility() {
	}

	/**
	 * Gets the from object.
	 *
	 * @param lists the lists
	 * @return the from object
	 */
	public static List<ClueDto> getFromObject(List<Object[]> lists) {
		return lists.stream().map(listObject -> {
			ClueDto clueDto = new ClueDto();
			clueDto.setId((Long) listObject[0]);
			clueDto.setCode(listObject[1].toString());
			clueDto.setDescription(listObject[2] != null ? listObject[2].toString() : null);
			return clueDto;
		}).collect(Collectors.toList());

	}

	/**
	 * Gets the file sizein MB.
	 *
	 * @param file the file
	 * @return the file sizein MB
	 */
	public static final double getFileSizeinKB(MultipartFile file) {

		BigDecimal bDecimal = new BigDecimal(file.getSize());
		return bDecimal.divide(new BigDecimal(EDPConstant.BYTE_TO_KB)).setScale(4, RoundingMode.FLOOR).doubleValue();

	}

	/**
	 * Validate file extension.
	 *
	 * @param list the list
	 * @return the boolean
	 */
	public static final boolean validateFileExtensionGeneric(List<?> list) {
		for (Object obj : list) {
			String[] fileNames = null;
			BigDecimal fileSize;
			MultipartFile file;
			if (obj instanceof EDPPostAttachmentDto) {
				file = ((EDPPostAttachmentDto) obj).getFile();
			} else if (obj instanceof EDPTrnUpdDsgnAttachmentDto) {
				file = ((EDPTrnUpdDsgnAttachmentDto) obj).getFile();
			} else if (obj instanceof EDPAddDesAttachmentDto) {
				file = ((EDPAddDesAttachmentDto) obj).getFile();
			} else if (obj instanceof EDPUsrPoTrnsAttDto) {
				file = ((EDPUsrPoTrnsAttDto) obj).getFile();
			} else if (obj instanceof EDPTrnUserMpAttDto) {
				file = ((EDPTrnUserMpAttDto) obj).getFile();
			} else {
				file = ((EDPOfficeAttachmentDto) obj).getFile();
			}
			fileNames = file.getOriginalFilename().split(EDPConstant.DOT_SPILLTER);
			fileSize = BigDecimal.valueOf(file.getSize() / (EDPConstant.BYTE_TO_MB));
			if (!Constant.FILE_EXTENTIONS.contains(fileNames[fileNames.length - 1].toUpperCase())
					|| (fileSize.compareTo(new BigDecimal(EDPConstant.MAX_UPLOAD_FILE_SIZE)) > 0)) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Generate transaction no.
	 *
	 * @param fyShort    the fy short
	 * @param moduleName the module name
	 * @param menuShName the menu sh name
	 * @param sequenceNo the sequence no
	 * @return the string
	 */
	public static String generateTransactionNo(String fyShort, String moduleName, String menuShName,
			String sequenceNo) {
		if (StringUtils.isEmpty(sequenceNo)) {
			return fyShort + EDPConstant.SLASH + moduleName + EDPConstant.SLASH + menuShName + EDPConstant.SLASH
					+ EDPConstant.FRIST_SEQUENCE_NUMBER;
		} else {
			String[] trnNo = sequenceNo.split(EDPConstant.SLASH_SPILLTER);
			Long digit = Long.parseLong(trnNo[3]) + 1l;
			return fyShort + EDPConstant.SLASH + moduleName + EDPConstant.SLASH + menuShName + EDPConstant.SLASH
					+ String.format(EDPConstant.TRANSACTION_NO_FORMATE, digit);
		}
	}

	/**
	 * Generate transaction no long.
	 *
	 * @param fyShort the fy short
	 * @param moduleName the module name
	 * @param menuShName the menu sh name
	 * @param sequenceNo the sequence no
	 * @return the string
	 */
	public static String generateTransactionNoLong(String fyShort, String moduleName, String menuShName,
			Long sequenceNo) {
		if (sequenceNo == null) {
			return fyShort + EDPConstant.SLASH + moduleName + EDPConstant.SLASH + menuShName + EDPConstant.SLASH
					+ EDPConstant.FRIST_SEQUENCE_NUMBER;
		} else {
			Long digit = sequenceNo + 1l;
			return fyShort + EDPConstant.SLASH + moduleName + EDPConstant.SLASH + menuShName + EDPConstant.SLASH
					+ String.format(EDPConstant.TRANSACTION_NO_FORMATE, digit);
		}
	}

	/**
	 * Populate arguments post mapping list.
	 *
	 * @param pageDetail the page detail
	 * @param index      the index
	 * @return the map
	 */
	public static Map<String, Object> populateArgumentsWfList(PageDetails pageDetail, int index) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		argsMap.put(EDPConstant.IN_POU_ID_VALUE, OAuthUtility.getCurrentUserLkPOUId());
		argsMap.put(EDPConstant.IN_OFFICE_ID_VALUE, OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		argsMap.put(EDPConstant.IN_WF_ROLE_VALUE, 0);
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> {
				if (!search.getKey().equals(EDPConstant.MENU_ID)) {
					argsMap.put(EDPConstant.getSearchList(index).get(search.getKey()),
							StringUtils.isEmpty(search.getValue()) ? "" : search.getValue());
				} else {
					Set<Long> wfRole = OAuthUtility.getWfRoleOfMenuWithLinkMenuUsingMenuId(Long.valueOf(search.getValue()));
					String wfRoles = wfRole.stream().map(String::valueOf).collect(Collectors.joining(","));
					argsMap.replace(EDPConstant.IN_WF_ROLE_VALUE, wfRoles);
				}
			});
		} else {
			EDPConstant.getSearchList(index).forEach((k, v) -> argsMap.put(EDPConstant.getSearchList(index).get(k), 0));
		}
		return argsMap;
	}

	/**
	 * Gets the date value.
	 *
	 * @param dateInString the date in string
	 * @return the date value
	 */
	public static Date getDateValue(String dateInString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(EDPConstant.DATE_FORMATE);
			return dateInString != null ? sdf.parse(dateInString) : null;
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Gets the request user IP address.
	 *
	 * @return the request user IP address
	 */
	public static String getRequestUserIPAddress() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String ipAddress = request.getHeader(OAuthConstant.X_FORWARDED_FOR);
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

	/**
	 * Gets the request browser.
	 *
	 * @return the request browser
	 */
	public static String getRequestBrowser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request.getHeader(OAuthConstant.USER_AGENT);
	}

	/**
	 * Gets the mask email.
	 *
	 * @param emailId the email id
	 * @return the mask email
	 */
	public static String getMaskEmail(String emailId) {
		return emailId.replaceAll(Regex.MASKING_EMAIL_ID, Regex.MASKING_CONSTANT_REPLACE);
	}

	/**
	 * Gets the mask mobile no.
	 *
	 * @param mobileNo the mobile no
	 * @return the mask mobile no
	 */
	public static String getMaskMobileNo(String mobileNo) {
		return mobileNo.replaceAll(Regex.MASKING_MOBILE_NO, Regex.MASKING_CONSTANT_REPLACE);
	}

	/**
	 * Html 2 text.
	 *
	 * @param html the html
	 * @return the string
	 */
	public static String html2text(String html) {
		return html.replaceAll(Regex.MASKING_HTML_TEXT, Constant.BLANK);
	}

	/**
	 * Populate arguments.
	 *
	 * @param pageDetail the page detail
	 * @param index      the index
	 * @return the map
	 */
	public static Map<String, Object> populateArguments(PageDetails pageDetail, int index) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		argsMap.put(Constant.IN_USER_LIST, OAuthUtility.getCurrentUserLkPOUId());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> argsMap.put(EDPConstant.getSearchList(index).get(search.getKey()), search.getValue()));
		} else {
			EDPConstant.getSearchList(index).forEach((k, v) -> argsMap.put(EDPConstant.getSearchList(index).get(k), 0));
		}
		return argsMap;
	}

	/**
	 * Checks if is valid file.
	 *
	 * @param attachements the attachements
	 * @return the string
	 */
	public static String isValidFile(List<?> attachements) {
		if (attachements == null) {
			return MsgConstant.ATTACHMENT_NOT_FOUND;
		} else if (!EDPUtility.validateFileExtensionGeneric(attachements)) {
			return MsgConstant.FILESIZE_EXCEEDS_LIMIT;
		}
		return EDPConstant.EMPTY_STRING;
	}

	/**
	 * Checks if is multi space and camel case.
	 *
	 * @param name the name
	 * @return true, if is multi space and camel case
	 */
	public static String isMultiSpaceAndCamelCaseAndSpecialCharContine(String name) {
		try {
			Pattern camelPattern = Pattern.compile(Constant.Regex.VALIDATE_CAMELCASE);
			Pattern specialCharPattern = Pattern.compile(Constant.Regex.VALIDATE_SPECIAL_CHARACTERS);
			String[] nameArray = name.split(Constant.SINGLE_SPACE);
			for (int i = 0; i < nameArray.length; i++) {
				if (nameArray[i].isEmpty()) {
					return EDPConstant.EACH_WORD_SHOULD_BE_SINGLE_SPACE_SEPARATED;
				} else if (!specialCharPattern.matcher(nameArray[i]).matches()) {
					return EDPConstant.NAME_SHOULD_BE_NOT_ALLOWED_SPECIAL_CHAR;
				} else if (!camelPattern.matcher(nameArray[i]).matches()) {
					return EDPConstant.NAME_SHOULD_BE_IN_CAMEL_CASE;
				}
			}
			return null;
		} catch (Exception e) {
			return EDPConstant.NAME_SHOULD_BE_IN_CAMEL_CASE;
		}
	}

	/**
	 * Gets the adds the lending zero.
	 *
	 * @param number the number
	 * @return the adds the lending zero
	 */
	public static String getAddLendingZero(String number) {
		return org.apache.commons.lang.StringUtils.leftPad(number, 5, "0");
	}

	/**
	 * Gets the jpa sort.
	 *
	 * @param columnName the column name
	 * @param order      the order
	 * @return the jpa sort
	 */
	public static Sort getJpaSort(String columnName, int order) {
		return order == 1 ? Sort.by(Sort.Order.asc(columnName).ignoreCase())
				: Sort.by(Sort.Order.desc(columnName).ignoreCase());
	}

	/**
	 * Generate sub office no.
	 *
	 * @param districtCode the district code
	 * @param ddoNo          the ddo no
	 * @param cardexNo       the cardex no
	 * @param subofficeCount the suboffice count
	 * @return the string
	 */
	public static String generateSubOfficeNo(String districtCode, String ddoNo, Long cardexNo, Long subofficeCount) {
		Long nextOfficeCode = subofficeCount != null && subofficeCount > 0 ? subofficeCount + 1l : 1l;
		return districtCode + EDPConstant.SLASH + ddoNo + EDPConstant.SLASH + cardexNo + EDPConstant.SLASH
				+ String.format(EDPConstant.SUBOFFICE_NO_FORMATE, nextOfficeCode);
	}

	/**
	 * Convert filenet document into base 64 string.
	 *
	 * @param inoutStream the inout stream
	 * @return the string
	 * @throws IOException     Signals that an I/O exception has occurred.
	 * @throws CustomException the custom exception
	 */
	public static String convertFilenetDocumentIntoBase64String(InputStream inoutStream)
			throws IOException, CustomException {
		byte[] bytes = toByteArray(inoutStream);
		return Base64.getEncoder().encodeToString(bytes);
	}

	/**
	 * To byte array.
	 *
	 * @param in the in
	 * @return the byte[]
	 * @throws IOException     Signals that an I/O exception has occurred.
	 * @throws CustomException the custom exception
	 */
	public static byte[] toByteArray(InputStream in) throws IOException, CustomException {

		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[2000000];
			int len;

			// read bytes from the input stream and store them in buffer
			while ((len = in.read(buffer)) != -1) {
				// write bytes from the buffer into output stream
				os.write(buffer, 0, len);
			}
			return os.toByteArray();
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}

	/**
	 * Gets the employee name from employee entity.
	 *
	 * @param employeeEntity the employee entity
	 * @return the employee name from employee entity
	 */
	public static String getEmployeeNameFromEmployeeEntity(EDPEmployeEntity employeeEntity) {
		StringBuilder stringBuilder = new StringBuilder();
		if (employeeEntity.getSalutation() != null) {
			stringBuilder.append(employeeEntity.getSalutation().getLookUpInfoName());
			stringBuilder.append(Constant.SINGLE_SPACE);
		}
		if (employeeEntity.getEmployeeName() != null) {
			stringBuilder.append(employeeEntity.getEmployeeName());
			stringBuilder.append(Constant.SINGLE_SPACE);
		}
		if (employeeEntity.getEmployeeMiddleName() != null) {
			stringBuilder.append(employeeEntity.getEmployeeMiddleName());
			stringBuilder.append(Constant.SINGLE_SPACE);
		}
		if (employeeEntity.getEmployeeSurname() != null) {
			stringBuilder.append(employeeEntity.getEmployeeSurname());
		}
		return stringBuilder.toString();
	}

	/**
	 * Gets the long value.
	 *
	 * @param obj the obj
	 * @return the long value
	 */
	public static Long convertObjectToLong(Object obj) {
		try {
			if (obj == null || String.valueOf(obj).isEmpty())
				return 0l;
			else {
				return Long.parseLong(String.valueOf(obj));
			}
		} catch (Exception ex) {
			return 0l;
		}
	}

	/**
	 * Gets the string value.
	 *
	 * @param obj the obj
	 * @return the string value
	 */
	public static String convertObjectToString(Object obj) {
		try {
			if (obj == null || String.valueOf(obj).isEmpty())
				return "";
			else {
				return String.valueOf(obj);
			}
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * Convert object to int.
	 *
	 * @param obj the obj
	 * @return the int
	 */
	public static int convertObjectToInt(Object obj) {
		try {
			if (obj == null || String.valueOf(obj).isEmpty())
				return 1;
			else {
				return Integer.valueOf(String.valueOf(obj));
			}
		} catch (Exception ex) {
			return 1;
		}
	}

	/**
	 * Convert object to short.
	 *
	 * @param obj the obj
	 * @return the short
	 */
	public static Short convertObjectToShort(Object obj) {
		try {
			if (obj == null || String.valueOf(obj).isEmpty())
				return 1;
			else {
				return Integer.valueOf(String.valueOf(obj)).shortValue();
			}
		} catch (Exception ex) {
			return 1;
		}
	}

	/**
	 * Convert object to date.
	 *
	 * @param obj the obj
	 * @return the date
	 */
	public static Date convertObjectToDate(Object obj) {
		try {
			if (obj == null || String.valueOf(obj).isEmpty())
				return null;
			else {
				return (Date) obj;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Gets the dash with space.
	 *
	 * @return the dash with space
	 */
	public static String getDashWithSpace() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Constant.SINGLE_SPACE);
		stringBuilder.append(Constant.DASH);
		stringBuilder.append(Constant.SINGLE_SPACE);
		return stringBuilder.toString();
	}

	/**
	 * Gets the employee name from employee info.
	 *
	 * @param employeeInfo the employee info
	 * @return the employee name from employee info
	 */
	public static String getEmployeeNameFromEmployeeInfo(List<Object[]> employeeInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		if (!CollectionUtils.isEmpty(employeeInfo)) {
			if (null != employeeInfo.get(0)[0]) {
				stringBuilder.append(EDPUtility.convertObjectToString(employeeInfo.get(0)[0]));
				stringBuilder.append(Constant.SINGLE_SPACE);
			}
			if (null != employeeInfo.get(0)[1]) {
				stringBuilder.append(EDPUtility.convertObjectToString(employeeInfo.get(0)[1]));
				stringBuilder.append(Constant.SINGLE_SPACE);
			}
			if (null != employeeInfo.get(0)[1]) {
				stringBuilder.append(EDPUtility.convertObjectToString(employeeInfo.get(0)[2]));
				stringBuilder.append(Constant.SINGLE_SPACE);
			}
			if (null != employeeInfo.get(0)[1]) {
				stringBuilder.append(EDPUtility.convertObjectToString(employeeInfo.get(0)[3]));
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * Gets the WF header response.
	 *
	 * @param resultMap the result map
	 * @return the WF header response
	 */
	public static List<EDPHeaderParam> getWFHeaderResponse(Map<String, Object> resultMap) {
		List<EDPHeaderParam> response = new ArrayList<>();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<LinkedCaseInsensitiveMap> obj = (List<LinkedCaseInsensitiveMap>) resultMap.get("#result-set-1");
		if (!obj.isEmpty()) {
			@SuppressWarnings("rawtypes")
			LinkedCaseInsensitiveMap result = obj.get(0);
			for (Object entry : result.entrySet()) {
				@SuppressWarnings("unchecked")
				Entry<Object, Object> etry = (Entry<Object, Object>) entry;
				response.add(new EDPHeaderParam(String.valueOf(etry.getKey()), String.valueOf(etry.getValue())));
			}
		}
		return response;
	}
//	  EDP Report
	/**
	 * Report proc list.
	 *
	 * @return the map
	 */
	public static Map<Long,String> reportProcList(){
		Map<Long,String> procList = new HashMap<>();
		procList.put(EDPReportConstant.RIGHTS_MAPPING_REPORT_MENU_ID,EDPReportConstant.RIGHTS_MAPPING_REPORT_SP);
		procList.put(EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_MENU_ID,EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_SP);
		procList.put(EDPReportConstant.REPORT_POST_HISTORY_MENU_ID,EDPReportConstant.REPORT_POST_HISTORY_SP);
		procList.put(EDPReportConstant.OFFICE_SUMMARY_REPORT_MENU_ID,EDPReportConstant.OFFICE_SUMMARY_REPORT_SP);
		return procList;
	}
	
	/**
	 * Populate arguments for report.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	public static Map<String, Object> populateArgumentsForReport(EDPReportPageDetails pageDetail) throws CustomException {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<EDPReportSearchParamDto> searchParams = pageDetail.getJsonArr();
		Map<String, String> argMap = getReportSearchList(pageDetail.getMenuId());
		if (!CollectionUtils.isEmpty(searchParams)) {
			searchParams.forEach(search -> getReportArgument(argsMap, argMap, search));
		} else {
			argMap.forEach((k, v) -> argsMap.put(argMap.get(k), 0));
		}
		return argsMap;
	}

	/**
	 * Gets the report argument.
	 *
	 * @param argsMap the args map
	 * @param argMap the arg map
	 * @param search the search
	 * @return the report argument
	 */
	private static void getReportArgument(Map<String, Object> argsMap, Map<String, String> argMap,
			EDPReportSearchParamDto search) {
		if(argMap.containsKey(search.getKey())) {
			if(search.getKey().equals(EDPReportConstant.IN_PVU_ID_KEY) && !"0".equals(search.getValue())) {
				argsMap.put(argMap.get(search.getKey()),search.getValue().equals("1")?"1":"3");
			} else {
				argsMap.put(argMap.get(search.getKey()),StringUtils.isEmpty(search.getValue()) ? "" : search.getValue());
			}
		}
	}
	
	/**
	 * Gets the report search list.
	 *
	 * @param menuId the menu id
	 * @return the report search list
	 * @throws CustomException the custom exception
	 */
	public static Map<String, String> getReportSearchList(Long menuId) throws CustomException {
		if (menuId.equals(EDPReportConstant.RIGHTS_MAPPING_REPORT_MENU_ID))
			return EDPReportConstant.getRightsMappingReportMap();
		else if (menuId.equals(EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_MENU_ID))
		    return EDPReportConstant.getPostTransferSummaryReportMap();
		else if (menuId.equals(EDPReportConstant.REPORT_POST_HISTORY_MENU_ID))
			return EDPReportConstant.getReportPostHistoryReportMap();
		else if (menuId.equals(EDPReportConstant.OFFICE_SUMMARY_REPORT_MENU_ID))
			return EDPReportConstant.getOfficeCreationSummaryRptMap();
		throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
	}
	
	/**
	 * Gets the report name.
	 *
	 * @param menuId the menu id
	 * @return the report name
	 * @throws CustomException the custom exception
	 */
	public static String getReportName(Long menuId) throws CustomException {
		Map<Long,String> map = EDPReportConstant.getEdpReportNameMap();
		if(map.containsKey(menuId)) {
			return map.get(menuId);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	
	/**
	 * Gets the user search filter data.
	 *
	 * @param pageDetail the page detail
	 * @return the user search filter data
	 */
	public static String getUserSearchFilterData(EDPReportPageDetails pageDetail) {
		Map<String, String> labels = EDPReportConstant.getEdpReportLabels();
		List<EDPReportSearchParamDto> jsonArray = pageDetail.getJsonArr();
		List<String> reportString = jsonArray.stream().filter(parm->!StringUtils.isEmpty(parm.getPrintValue()) && !parm.getPrintValue().equals("0") && labels.containsKey(parm.getKey()))
				.map(parm-> labels.get(parm.getKey()) + EDPReportConstant.REPORT_STRING_COLON + parm.getPrintValue()).collect(Collectors.toList());
		return reportString.stream().collect(Collectors.joining(EDPReportConstant.REPORT_STRING_COMA));
	}
	
	/**
	 * Gets the report column names.
	 *
	 * @param menuId the menu id
	 * @return the report column names
	 * @throws CustomException the custom exception
	 */
	public static List<String> getReportColumnNamesList(Long menuId) throws CustomException{
		Map<Long, List<String>> reportCOlumnMap = EDPReportConstant.getReportColumnListMap();
		if(reportCOlumnMap.containsKey(menuId)) {
			return reportCOlumnMap.get(menuId);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Gets the report column names array.
	 *
	 * @param menuId the menu id
	 * @return the report column names array
	 * @throws CustomException the custom exception
	 */
	public static Object[] getReportColumnNamesArray(Long menuId) throws CustomException{
		Map<Long, Object[]> reportCOlumnMap = EDPReportConstant.getReportColumnArrayMap();
		if(reportCOlumnMap.containsKey(menuId)) {
			return reportCOlumnMap.get(menuId);
		} 
		throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
	}
	
	/**
	 * Convert byte to base 64 string.
	 *
	 * @param bs the bs
	 * @return the string
	 */
	public static String convertByteToBase64String(byte[] bs) {
		return Base64.getEncoder().encodeToString(bs);
	}

	/**
	 * Gets the user name for edp report.
	 *
	 * @return the user name for edp report
	 */
	public static String getUserNameForEdpReport() {
		return OAuthUtility.getCurrentUserUserName() + EDPReportConstant.REPORT_STRING_COMA_WITH_END_SPACE 
				+ OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostName() + EDPReportConstant.REPORT_STRING_COMA_WITH_END_SPACE  
				+ OAuthUtility.getCurrentUserLoginPostFromOauthToken().getOauthTokenPostDTO().getEdpMsDesignationDto().getDesignationName();
	}
	
	/**
	 * Gets the report file name.
	 *
	 * @param reportName the report name
	 * @param fileType the file type
	 * @return the report file name
	 */
	public static String getReportFileName(String reportName,String fileType) {
		LocalDateTime today=LocalDateTime.now();
		DateTimeFormatter formatTimeNow=DateTimeFormatter.ofPattern(EDPReportConstant.DD_MM_YYYY); 
		reportName = reportName.replace(Constant.SINGLE_SPACE, EDPReportConstant.UNDERSCORE);
		return reportName + EDPReportConstant.UNDERSCORE +  today.format(formatTimeNow) + fileType ;
	}
	
	/**
	 * Populate arguments br map.
	 *
	 * @param pageDetail the page detail
	 * @param index the index
	 * @return the map
	 */
	public static Map<String, Object> populateArgumentsBrMap(PageDetails pageDetail, int index) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		argsMap.put(Constant.IN_USER, OAuthUtility.getCurrentUserUserId());
		argsMap.put(Constant.IN_OFFICE_ID, OAuthUtility.getCurrentUserOfficeIdFromToken());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> {
				if(search.getKey().equals(EDPConstant.REQUEST_TYPE_KEY)) {
					argsMap.put(EDPConstant.getSearchList(index).get(search.getKey()),"0".equals(search.getValue()) ? "611,612": search.getValue());
				}else {
					 argsMap.put(EDPConstant.getSearchList(index).get(search.getKey()), search.getValue());
				}
			});
		} else {
			EDPConstant.getSearchList(index).forEach((k, v) -> argsMap.put(EDPConstant.getSearchList(index).get(k), 0));
		}
		return argsMap;
	}

	/**
	 * Check upload location exists.
	 */
	public static String checkUploadLocationExists(Long trnId, Long menuId) {
		String uploadLocation = Constant.BACK_SLASH + EDPConstant.FILE_NET_UPLOAD_DIRECTORY_PATH + Constant.BACK_SLASH
							   + menuId + Constant.BACK_SLASH + trnId ;
		Domain dom = FilenetUtility.getDomain(FilenetUtility.userId, FilenetUtility.password);
		ObjectStore os = FilenetUtility.getObjectStore(dom, FilenetUtility.objectStoreName);
		if (!FilenetUtility.isFolderExists(os, uploadLocation.substring(0, uploadLocation.lastIndexOf(Constant.BACK_SLASH)),
				uploadLocation.substring(uploadLocation.lastIndexOf(Constant.BACK_SLASH) + 1), true)) {
			FilenetUtility.buildUploadPath(uploadLocation, os);
		}
		return uploadLocation;
	}
	
	/**
	 * Upload attachment in file net.
	 *
	 * @param multiFile the multi file
	 * @param uploadLocation the upload location
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	public static ClueDto uploadAttachmentInFileNet(MultipartFile multiFile,String uploadLocation) throws IOException {
			
			Domain dom = FilenetUtility.getDomain(FilenetUtility.userId, FilenetUtility.password);
			ObjectStore os = FilenetUtility.getObjectStore(dom, FilenetUtility.objectStoreName);
			String fileName = multiFile.getOriginalFilename();
			String containmentName = fileName.substring(0, fileName.lastIndexOf(Constant.DOT));
			String fileType = fileName.substring(fileName.lastIndexOf(Constant.DOT) + 1);
			String contentType = FilenetUtility.getContentType(fileType);
			BufferedInputStream inputStream = new BufferedInputStream(multiFile.getInputStream());
			ContentTransfer ct = getContentTransfer(fileName, contentType, inputStream);
			ContentElementList cel = Factory.ContentElement.createList();
			cel.add(ct);
			
			Document doc = getDocumentFileNet(os, fileName, cel);
			/** Set the storage folder **/
			Folder folder = Factory.Folder.getInstance(os, null, uploadLocation);

			/** Store the actual object to store **/
			DynamicReferentialContainmentRelationship rcr = getDynamicReferentialContanct(os, containmentName, doc,folder);
            updateBatchOfFilenet(dom, doc, rcr);
			
            return getResponseClueDto(doc, getUploadedFilePath(uploadLocation,doc.get_Name()));
	}

	/**
	 * Gets the content transfer.
	 *
	 * @param fileName the file name
	 * @param contentType the content type
	 * @param inputStream the input stream
	 * @return the content transfer
	 */
	private static ContentTransfer getContentTransfer(String fileName, String contentType, BufferedInputStream inputStream) {
		ContentTransfer ct = Factory.ContentTransfer.createInstance();
		ct.setCaptureSource(inputStream);
		ct.set_RetrievalName(fileName);
		ct.set_ContentType(contentType);
		return ct;
	}

	/**
	 * Gets the document file net.
	 *
	 * @param os the os
	 * @param fileName the file name
	 * @param cel the cel
	 * @return the document file net
	 */
	private static Document getDocumentFileNet(ObjectStore os, String fileName, ContentElementList cel) {
		Document doc = Factory.Document.createInstance(os, null);
		doc.getProperties().putValue(Constant.DOCUMENT_TITLE, fileName);
		doc.set_ContentElements(cel);
		doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
		return doc;
	}

	/**
	 * Gets the dynamic referential contanct.
	 *
	 * @param os the os
	 * @param containmentName the containment name
	 * @param doc the doc
	 * @param folder the folder
	 * @return the dynamic referential contanct
	 */
	private static DynamicReferentialContainmentRelationship getDynamicReferentialContanct(ObjectStore os,
			String containmentName, Document doc, Folder folder) {
		DynamicReferentialContainmentRelationship rcr = Factory.DynamicReferentialContainmentRelationship
					.createInstance(os, null, AutoUniqueName.AUTO_UNIQUE,DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
		rcr.set_Tail(folder);
		rcr.set_Head(doc);
		rcr.set_ContainmentName(containmentName);
		return rcr;
	}

	/**
	 * Update batch of filenet.
	 *
	 * @param dom the dom
	 * @param doc the doc
	 * @param rcr the rcr
	 */
	private static void updateBatchOfFilenet(Domain dom, Document doc, DynamicReferentialContainmentRelationship rcr) {
		UpdatingBatch ub = UpdatingBatch.createUpdatingBatchInstance(dom, RefreshMode.REFRESH);
		ub.add(doc, null);
		ub.add(rcr, null);
		ub.updateBatch();
	}
	
	/**
	 * Gets the response clue dto.
	 *
	 * @param doc the doc
	 * @param uploadedFilePath the uploaded file path
	 * @return the response clue dto
	 */
	private static ClueDto getResponseClueDto(Document doc, String uploadedFilePath) {
		ClueDto response = new ClueDto();
		response.setDocumentId(doc.get_Id().toString());
		response.setDocumentUploadedFilePath(uploadedFilePath);
		return response;
	}
	
	/**
	 * Gets the uploaded file path.
	 *
	 * @param uploadLocation the upload location
	 * @param fileName the file name
	 * @return the uploaded file path
	 */
	public static String getUploadedFilePath(String uploadLocation,String fileName) {
		final StringBuilder uploadPathBuilder = new StringBuilder();
		uploadPathBuilder.append(uploadLocation);
		uploadPathBuilder.append(Constant.BACK_SLASH);
		uploadPathBuilder.append(fileName);
		return uploadPathBuilder.toString();
	}

	/**
	 * Download file net file.
	 *
	 * @param documentId the document id
	 * @return the resource
	 * @throws MalformedURLException 
	 * @throws CustomException 
	 */
	public static ClueDto downloadFileNetFile(String documentId, String fileName) throws CustomException {
		try { 
			Id id = new Id(documentId);
			final Document document = FilenetUtility.retrieveDocument(id);
			final InputStreamResource inputStreamResource = new InputStreamResource(document.accessContentStream(0));
			ClueDto dto = new ClueDto();
			dto.setDocument(inputStreamResource);
			dto.setName(fileName);
			return dto;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}
	
	/**
	 * Gets the file extension.
	 *
	 * @param fileName the file name
	 * @return the file extension
	 */
	public static String getFileExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf(EDPConstant.DOTE);
	    return (dotIndex == -1) ? EDPConstant.EMPTY_STRING : fileName.substring(dotIndex + 1);
	}
	
}

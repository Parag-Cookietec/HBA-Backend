package gov.ifms.pvu.service.test;

import com.ibm.db2.jcc.am.SqlException;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.converter.PVUIncrementMainEventConverter;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.repository.PVUIncrementEventRepository;
import gov.ifms.pvu.service.*;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * The Class PVUIncrementEventController.
 *
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 */

public class PVUEmployeIncrementServiceImplTest {

	@InjectMocks
	private PVUEmployeIncrementServiceImpl service;

	@Mock
	private PVUIncrementEventRepository repository;

	@Mock
	List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView;

	@Mock
	private PVUIncrementEmpSDService pvuIncrementEmpSDService;

	@Mock
	PVUIncrementEventEntity entity;

	@Mock
	EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Mock
	private PVUIncrementEmpSDDto pvuIncrementEmpDto;

	@Mock
	private PVUIncrementMainEventDto pvuIncrementMainEventDto;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUIncrementEventEntity pvuIncrementEventEntity;

	@Mock
	private PVUIncrementMainEventConverter converter;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntityStatusId;
	@Mock
	private List<PVURegularIncrementSmryView> pvuRegularIncrementSmryViews;
	@Mock
	private PVUIncrementEventEntity requestedEntity;
	@Mock
	List<PVUEmployeeIncrementListView> objStorePro;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntityEmpStatus;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	PVURegularIncrementListView objStorePro1;

	@Mock
	List<PVURegularIncrementEligibleListView> lstIncludeExclude;


	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	Map<String, Object> obj;


	@Test
	void testgetLookUpInfoAsMap() throws CustomException {
		when(repository.storeProc(PvuConstant.PVU_EMP_INC_LIST_LOOKUPS_SP, PVUEmployeCreationDDLView.class))
				.thenReturn(lstPVUEmployeCreationDDLView);
		assertNotNull(service.getLookUpInfoAsMap(PvuConstant.PVU_EMP_INC_LIST_LOOKUPS_SP));
	}

	@Test
	void testGetEmployeeDataReportExcel() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "152"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2020-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("dateOfJoining", "2020-01-01"));


		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getEmployeeDataReportExcel(pageDetail));
	}
	@Test
	void testGetEmployeeDataReportExcel_Sixth() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "151"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2020-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("dateOfJoining", "2020-01-01"));


		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getEmployeeDataReportExcel(pageDetail));
	}
	@Test
	void testGetEmployeeDataReportExcel_fifth() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "150"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2020-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("dateOfJoining", "2020-01-01"));


		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getEmployeeDataReportExcel(pageDetail));
	}

	@Test
	void testGetIneligibleEmployeeListExcel() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "152"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2020-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn(null);
		pageDetail.setSortOrder(null);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getIneligibleEmployeeListExcel(pageDetail));

	}
	@Test
	void testGetIneligibleEmployeeListExcelSixth() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "151"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2020-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn(null);
		pageDetail.setSortOrder(null);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getIneligibleEmployeeListExcel(pageDetail));

	}

	@Test
	void testGetIneligibleEmployeeListExcelFifth() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "150"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2020-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn(null);
		pageDetail.setSortOrder(null);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getIneligibleEmployeeListExcel(pageDetail));

	}


	@Test
	void testGetSuccessCountExcel() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "152"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2021-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("processStatus", "1"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getSuccessCountExcel(pageDetail));
	}
	@Test
	void testGetSuccessCountExcelProcesstatus() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "152"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2021-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("processStatus", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getSuccessCountExcel(pageDetail));
	}
	@Test
	void testGetSuccessCountExcel_commisionchange_Sixth() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "151"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2021-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("processStatus", "xyz"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getSuccessCountExcel(pageDetail));
	}
	@Test
	void testGetSuccessCountExcel_commisionchangeFifth() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "150"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2021-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("processStatus", "xyz"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getSuccessCountExcel(pageDetail));
	}


	@Test
	void testGetprocessStatus() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "150"));
		jsonArr.add(new SearchParam("financialYearId", "56"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2006-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2005-01-01"));
		jsonArr.add(new SearchParam("trnId", "501"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("processStatus", "1"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn(null);
		pageDetail.setSortOrder(null);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getprocessStatus(pageDetail));
	}
	@Test
	void testGetprocessStatusZero() throws CustomException {
		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "150"));
		jsonArr.add(new SearchParam("financialYearId", "56"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2006-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2005-01-01"));
		jsonArr.add(new SearchParam("trnId", "501"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));
		jsonArr.add(new SearchParam("processStatus", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn(null);
		pageDetail.setSortOrder(null);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getprocessStatus(pageDetail));
	}

	@Test
	void testDeleteIncrementTrns() throws CustomException {
		IdDto idDto = new IdDto(Constant.LONG_ONE_VALUE);
		Date updatedDate = new Date();
		entity.setStatusId(edpLuLookUpInfoEntity);
		when(entity.getStatusId()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);

		when(repository.findById(1l)).thenReturn(Optional.of(entity));

		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(edpLuLookUpInfoEntity);
		doNothing().when(repository).deleteIncrementEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(),
				updatedDate, Constant.LONG_ONE_VALUE, Constant.LONG_ONE_VALUE);
		doNothing().when(pvuIncrementEmpSDService).deleteIncrementEmpIdByEventId(Constant.IN_ACTIVE_STATUS,
				idDto.getId(), updatedDate);
		assertTrue(service.deleteIncrementTrns(idDto));

	}

	@Test
	void testApproveRejectIncrement() throws CustomException {
		Object[] objectArray = new Object[1];
		objectArray[0] = "";
		Object object = 0l;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(objectArray);

		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		pvuWFWrapperDto.setWfStatus(Constant.APPROVED);
		pvuWFWrapperDto.setTrnId(1l);
		pvuWFWrapperDto.setUpdatedDate(new Date());

		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		when(repository.callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(object);
		service.submitAutoIncrement(Constant.INC);
		verify(repository, times(1)).callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap());
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(pvuWFWrapperDto.getTrnId(),
				0l);
		service.approveRejectIncrement(pvuWFWrapperDto, Constant.TRN_SCREEN);
		pvuWFWrapperDto.setWfStatus(Constant.REJECTED);
		service.approveRejectIncrement(pvuWFWrapperDto, Constant.TRN_SCREEN);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testGetTransactionNumber() throws CustomException {
		Object[] object = new Object[1];

		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, "INC");
		when(repository.callStoredProcedure(
				Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TRANSACTION_NO_GENERATION)), map))
				.thenReturn(objects);
		assertNotNull(service.getTransactionNumber("INC"));
	}

	@Test
	void testInsertIncrementInITRs() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		service.insertIncrementInITRs(pvuWFWrapperDto);
		verify(repository, times(1)).callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testInsertInIncrementMainEmp() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		long statusid = 0l;
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		service.insertInIncrementMainEmp(pvuWFWrapperDto, statusid);
		verify(repository, times(1)).callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testSubmitAutoIncrement() throws CustomException {
		Object resObject = 0l;
		when(repository.callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(resObject);
		service.submitAutoIncrement(Constant.INC);
		verify(repository, times(1)).callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testValidateNoInProgressEventWithTransNo() throws CustomException {
		List<PVUEmployeeEventStatusDto> lstPVUEmployeeEventStatusDto = Collections.emptyList();
		String transNo = Constant.ROP;
		List<PVUIncrementEmpSDDto> lstPVUIncrementEmpDtos = new ArrayList<>();
		PVUIncrementEmpSDDto empDto = new PVUIncrementEmpSDDto();
		empDto.setEmpId(Constant.ROP_2009);
		empDto.setIncrementType(Constant.ROP_2009_EVENT);
		empDto.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		lstPVUIncrementEmpDtos.add(empDto);

		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpSDDto::getEmpId).collect(Collectors.toList());

		when(pvuEmployeeEventStatusService.getEmployeeInProcessByEmpIdsInOtherTrans(lstEmpIncludeList, transNo))
				.thenReturn(lstPVUEmployeeEventStatusDto);
		service.validateNoInProgressEvent(lstPVUIncrementEmpDtos, transNo);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testSaveOrUpdateIncrementEvent() throws CustomException { //
		when(repository.save(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventEntity);
		assertNotNull(service.saveOrUpdateIncrementEvent(pvuIncrementEventEntity));
	}

	@Test
	void testSaveOrUpdateIncrementEventEmpSummary() throws CustomException {
		List<PVUIncrementEmpSDDto> list = new ArrayList<>();

		list.add(pvuIncrementEmpDto);
		when(pvuIncrementEmpDto.getEmpId()).thenReturn(1l);
		when(converter.toEntity(pvuIncrementMainEventDto)).thenReturn(pvuIncrementEventEntity);
		when(repository.save(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventEntity);

		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT))
				.thenReturn(edpLuLookUpInfoEntityStatusId);

/*		when(pvuEmployeeEventStatusService.getEmployeeInProcessByEmpIds(lstEmpIncludeList))
				.thenReturn(pvuEmployeeEventStatusDtoList);*/
		when(pvuIncrementMainEventDto.getPvuIncrementEmpSDDtos()).thenReturn(list);
		when(pvuIncrementEventEntity.getInEventId()).thenReturn(0L);
		when(pvuIncrementEventEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);


		when(converter.toDTO(pvuIncrementEventEntity)).thenReturn(pvuIncrementMainEventDto);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		when(pvuIncrementMainEventDto.getPvuIncrementEmpSDDtos()).thenReturn(list);

		when(pvuIncrementMainEventDto.getPvuRegularIncrementSmryViews()).thenReturn(pvuRegularIncrementSmryViews);
/*		when(pvuEmployeeEventStatusRepository.findEmployeeInProgress(lstEmpIncludeList))
				.thenReturn(pvuEmployeeEventStatusDtoList);*/
		when(pvuIncrementEventEntity.getTrnNo()).thenReturn("SD");
		assertNotNull(service.saveOrUpdateIncrementEventEmpSummary(pvuIncrementMainEventDto));
	}

	@Test
	void testSaveOrUpdateIncrementEventEmpSummaryOldTransaction() throws CustomException {
		List<PVUIncrementEmpSDDto> list = new ArrayList<>();
		list.add(pvuIncrementEmpDto);
		when(pvuIncrementMainEventDto.getPvuIncrementEmpSDDtos()).thenReturn(list);
		when(pvuIncrementMainEventDto.getPvuRegularIncrementSmryViews()).thenReturn(pvuRegularIncrementSmryViews);
		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT))
				.thenReturn(edpLuLookUpInfoEntityStatusId);
		when(edpLuLookUpInfoEntityStatusId.getLookUpInfoId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);
		when(pvuIncrementMainEventDto.getInEventId()).thenReturn(Constant.ROP_2016);
		when(pvuIncrementMainEventDto.getStatusId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);
		when(converter.toEntity(pvuIncrementMainEventDto)).thenReturn(requestedEntity);
		when(repository.findById(Constant.ROP_2016)).thenReturn(Optional.of(pvuIncrementEventEntity));
		when(pvuIncrementEventEntity.getInEventId()).thenReturn(Constant.ROP_2009);
		when(pvuIncrementEventEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);
		when(edpLuLookUpInfoEntityStatusId.getLookUpInfoId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);
		when(requestedEntity.getInEventId()).thenReturn(Constant.ROP_2016);
		when(requestedEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);
		when(repository.save(requestedEntity)).thenReturn(requestedEntity);
		when(requestedEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);
		//doNothing().when(pvuIncrementEmpServiceImpl).deleteIrrelevantEmployeeFromTransaction(Constant.ROP_2009);
		when(converter.toDTO(requestedEntity)).thenReturn(pvuIncrementMainEventDto);
		assertNotNull(service.saveOrUpdateIncrementEventEmpSummary(pvuIncrementMainEventDto));
	}

	@Test
	void testGetPVUEmployeeIncrementList() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		when(repository.storeProc(PvuConstant.PVU_EMPLOYEE_INCRMNT_LIST, PVUEmployeeIncrementListView.class))
				.thenReturn(objStorePro);
		assertNotNull(service.getPVUEmployeeIncrementList(pageDetail));
	}

	@Test
	void testGetIncrementEventEmpSummary() throws CustomException {
		when(repository.findById(1l)).thenReturn(Optional.of(pvuIncrementEventEntity));
		when(converter.toDTO(pvuIncrementEventEntity)).thenReturn(pvuIncrementMainEventDto);
		assertNotNull(service.getIncrementEventEmpSummary(1l));
	}

	@Test
	void testValidateIncrementSubmit() throws CustomException {
		List<PVUEmployeeEventStatusDto> lstPVUEmployeeEventStatusDto = Collections.emptyList();
		List<PVUIncrementEmpSDDto> lstPVUIncrementEmpDtos = new ArrayList<>();
		PVUIncrementMainEventDto dto = new PVUIncrementMainEventDto();
		dto.setDateNextInc(new Date());
		dto.setIncrementEffDate(new Date());
		dto.setEmpNo(Constant.ROP);
		dto.setTrnNo(Constant.ROP);

		PVUIncrementEmpSDDto empDto = new PVUIncrementEmpSDDto();
		empDto.setEmpId(Constant.ROP_2009);
		empDto.setIncrementType(Constant.ROP_2009_EVENT);
		empDto.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		lstPVUIncrementEmpDtos.add(empDto);

		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpSDDto::getEmpId).collect(Collectors.toList());
		when(pvuEmployeeEventStatusService.getEmployeeInProcessByEmpIdsInOtherTrans(lstEmpIncludeList, dto.getTrnNo()))
				.thenReturn(lstPVUEmployeeEventStatusDto);

		List<PVUIncrementCreateListView> lstIncIncludeExclude = new ArrayList<>();
		List<PVUIncrementEmpSDDto> lstIncrementEmpDto = new ArrayList<>();
		String procName = Constant.PVU_SCHEMA
				.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_INCR_INCLUDE_EXCLUDE));

		PVUIncrementCreateListView view = new PVUIncrementCreateListView();
		view.setEmpId(Constant.ROP_2009);
		view.setIncrementType(Constant.ROP_2009_EVENT);

		lstIncIncludeExclude.add(view);
		lstIncrementEmpDto.add(empDto);
		dto.setPvuIncrementEmpSDDtos(lstIncrementEmpDto);

		Map<String, Object> map = new HashMap<>();
		map.put("IN_OFFICE_ID", String.valueOf(dto.getOfficeId()));
		map.put("IN_INCR_FOR", String.valueOf(dto.getIncrementFor()));
		map.put("IN_FY", String.valueOf(dto.getFinancialYear()));
		map.put("IN_EMP_TYPE", String.valueOf(dto.getEmpType()));
		map.put("IN_CLASS_ID", String.valueOf(dto.getClassId()));
		map.put("IN_EMP_PAY_TYPE", String.valueOf(dto.getEmpPayType()));
		map.put("IN_DESIGNATION_ID", String.valueOf(dto.getDesignationId()));
		map.put("IN_INCR_EFFECTIVE_DATE", Utils.getDateStr(dto.getIncrementEffDate()));
		map.put("IN_DATE_NXT_INCR", Utils.getDateStr(dto.getDateNextInc()));
		map.put("IN_EMPLOYEE_NO", String.valueOf(dto.getEmpNo().isEmpty() ? "0" : dto.getEmpNo()));
		map.put("IN_PPAN_NO", "");
		map.put(Constant.IN_PAGE_INDEX, 0);
		map.put(Constant.IN_PAGE_SIZE, 250);
		map.put(Constant.IN_USER_LIST, "1");

		when(repository.storeProc(procName, map, PVUIncrementCreateListView.class))
				.thenReturn(lstIncIncludeExclude);

		assertTrue(service.validateIncrementSubmit(dto));
	}

	@Test
	void testValidateAtLeastOneIncludeRecord() throws CustomException {
		List<PVUIncrementEmpSDDto> lstPVUIncrementEmpDtos = new ArrayList<>();
		PVUIncrementEmpSDDto empDto = new PVUIncrementEmpSDDto();
		empDto.setEmpId(Constant.ROP_2009);
		empDto.setIncrementType(Constant.ROP_2009_EVENT);
		empDto.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		lstPVUIncrementEmpDtos.add(empDto);
		service.validateAtLeastOneIncludeRecord(lstPVUIncrementEmpDtos);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testPrepareIncExcReqestMap() {
		PVUIncrementMainEventDto dto = new PVUIncrementMainEventDto();
		dto.setDateNextInc(new Date());
		dto.setIncrementEffDate(new Date());
		dto.setEmpNo("123");
		assertNotNull(service.prepareIncExcReqestMap(dto));
	}

	@Test
	void testInsertIncrementItrWithTrans() throws CustomException {
		Date updatedDate = new Date();
		pvuWFWrapperDto.setUpdatedDate(updatedDate);

		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findById(1l)).thenReturn(Optional.of(pvuIncrementEventEntity));

		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.STATUS_ID, Constant.ACTIVE_STATUS, Constant.APPROVED))
				.thenReturn(edpLuLookUpInfoEntityEmpStatus);
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.STATUS_ID, Constant.ACTIVE_STATUS, Constant.REJECTED))
				.thenReturn(edpLuLookUpInfoEntityEmpStatus);
		when(edpLuLookUpInfoEntityEmpStatus.getLookUpInfoId()).thenReturn(1l);
		when(pvuIncrementEventEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(3l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(pvuIncrementEventEntity)).thenReturn(pvuIncrementMainEventDto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.save(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventEntity);

		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);

		Object resObject = 0l;
		when(repository.callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(resObject);
		service.submitAutoIncrement(Constant.INC);
		verify(repository, times(1)).callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap());

		/*when(pvuIncrementEventSummaryService.getIncCountSummaryByInEventIdDto(1l))
				.thenReturn(pvuIncrementEventSummaryDto);*/
		when(pvuIncrementMainEventDto.getPvuRegularIncrementSmryViews()).thenReturn(pvuRegularIncrementSmryViews);
		assertNotNull(service.insertIncrementItr(pvuWFWrapperDto));
	}

	@Test
	void testGetIncrementEvents() throws CustomException {

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", ""));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("eventsId", ""));
		jsonArr.add(new SearchParam("designationId", ""));
		jsonArr.add(new SearchParam("gpfNo", ""));
		jsonArr.add(new SearchParam("pPan", ""));
		jsonArr.add(new SearchParam("retirementDate", ""));
		jsonArr.add(new SearchParam("empNo", ""));
		jsonArr.add(new SearchParam("empName", ""));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("classId", " "));
		jsonArr.add(new SearchParam("officeId", ""));
		jsonArr.add(new SearchParam("empType", ""));
		jsonArr.add(new SearchParam("statusId", " "));
		jsonArr.add(new SearchParam("workflowId", ""));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
/*		PVURegularIncrementListView data = service
				.getRegularEmployeeIncrementList(pageDetail);*/
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, "INC");
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(obj);
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		PVURegularIncrementEligibleListView p = new PVURegularIncrementEligibleListView();
		p.setClassId(123L);
		nonEligibleListViews.add(p);
		List<PVURegularIncrementEligibleListView> eligibleListViews = new ArrayList<>();
		p.setClassId(123L);
		eligibleListViews.add(p);

		List<PVURegularIncrementSmryView> pvuRegularIncrementSmryViews = new ArrayList<>();
		PVURegularIncrementSmryView s = new PVURegularIncrementSmryView();
		s.setClassId(1L);
		pvuRegularIncrementSmryViews.add(s);
		when(obj.get("#result-set-1")).thenReturn(eligibleListViews);
		when(obj.get("#result-set-2")).thenReturn(nonEligibleListViews);
		when(obj.get("#result-set-3")).thenReturn(pvuRegularIncrementSmryViews);


		/*	when(service.getRegularEmployeeIncrementList(pageDetail,map)).thenReturn(objStorePro1);*/
	/*	when(service
				.getRegularEmployeeIncrementList(pageDetail)).thenReturn(objStorePro1);*/
		assertNotNull(service
				.getRegularEmployeeIncrementList(pageDetail, map));
		assertNotNull(service
				.getRegularEmployeeIncrementList(pageDetail));
	}

	@Test
	void testGetProcessedEmployeeListExcel() throws CustomException {
		PVURegularIncrementEligibleListView2 p1 = new PVURegularIncrementEligibleListView2();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView2> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("ddoCode", "416"));
		jsonArr.add(new SearchParam("cardexNo", "1"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("incrementFor", "152"));
		jsonArr.add(new SearchParam("financialYearId", "71"));
		jsonArr.add(new SearchParam("empPayType", "156"));
		jsonArr.add(new SearchParam("empType", "0"));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("cgpNoType", "0"));
		jsonArr.add(new SearchParam("cgpNo", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("nextIncrDate", "2021-01-01"));
		jsonArr.add(new SearchParam("incrEffectiveDate", "2020-01-01"));
		jsonArr.add(new SearchParam("trnId", "0"));
		jsonArr.add(new SearchParam("trnLevel", "initial"));

		jsonArr.add(new SearchParam("incrementFor", "151"));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service
				.getProcessedEmployeeListExcel(pageDetail));
	}


	@Test
	void testIsSalaryInSalaryInSynch() {
		List<PVURegularIncrementEligibleListView> lstIncIncludeExclude = new ArrayList<>();
		List<PVUIncrementEmpSDDto> lstIncrementEmpDto = new ArrayList<>();

		PVURegularIncrementEligibleListView view = new PVURegularIncrementEligibleListView();
		PVUIncrementEmpSDDto dto = new PVUIncrementEmpSDDto();

		view.setEmpId(Constant.ROP_2009);
		view.setIncrementType(Constant.ROP_2009_EVENT);
		view.setCurCellId(12L);
		view.setCurGrade(1L);
		view.setCurScale(12L);
		view.setCurGradePay(1L);
		view.setCurPayBand(1L);
		view.setCurPayBandValue(1l);
        view.setCurBasicPay(1l);
        view.setClassId(1L);
		view.setDesignationId(1L);

		dto.setEmpId(Constant.ROP_2009);
		dto.setIncrementType(Constant.ROP_2009_EVENT);

		lstIncIncludeExclude.add(view);
		lstIncrementEmpDto.add(dto);

		assertFalse(service.isSalaryInSalaryInSynch(lstIncIncludeExclude, lstIncrementEmpDto));
	}

	@Test
	void testIsSalaryInSalaryInSynchFalse() {
		List<PVURegularIncrementEligibleListView> lstIncIncludeExclude = new ArrayList<>();
		List<PVUIncrementEmpSDDto> lstIncrementEmpDto = new ArrayList<>();

		PVURegularIncrementEligibleListView view = new PVURegularIncrementEligibleListView();
		PVUIncrementEmpSDDto dto = new PVUIncrementEmpSDDto();

		view.setEmpId(Constant.ROP_2009);
		view.setIncrementType(Constant.ROP_2009_EVENT);
		view.setClassId(12L);
		view.setCurCellId(12L);
		view.setCurGrade(1L);
		view.setCurScale(12L);
		view.setCurGradePay(1L);
		view.setCurPayBand(1L);
		view.setCurPayBandValue(1l);
		view.setCurBasicPay(1l);
		view.setClassId(1L);
		view.setDesignationId(1L);

		dto.setEmpId(Constant.ROP_2009);
		dto.setIncrementType(Constant.ROP_2009_EVENT);
		dto.setClassId(13);

		lstIncIncludeExclude.add(view);
		lstIncrementEmpDto.add(dto);

		assertFalse(service.isSalaryInSalaryInSynch(lstIncIncludeExclude, lstIncrementEmpDto));
	}

	@Test
	void validateEmpSalaryInSync() throws CustomException {
		List<PVURegularIncrementEligibleListView> lstIncIncludeExclude = new ArrayList<>();

		PVURegularIncrementEligibleListView view = new PVURegularIncrementEligibleListView();
		view.setEmpId(Constant.ROP_2009);
		view.setIncrementType(Constant.ROP_2009_EVENT);
		view.setCurCellId(1L);
		view.setCurGrade(1L);
		view.setCurScale(12L);
		view.setCurGradePay(1L);
		view.setCurPayBand(1L);
		view.setCurPayBandValue(1l);
		view.setCurBasicPay(1l);
		view.setClassId(1L);
		view.setDesignationId(1L);
		lstIncIncludeExclude.add(view);

		List<PVURegularIncrementEligibleListView> lstIncIncludeExclude1 = new ArrayList<>();

		PVURegularIncrementEligibleListView view1 = new PVURegularIncrementEligibleListView();
		view1.setEmpId(Constant.ROP_2016);
		view1.setIncrementType(Constant.ROP_2009_EVENT);
		view1.setCurCellId(1L);
		view1.setCurGrade(1L);
		view1.setCurScale(12L);
		view1.setCurGradePay(1L);
		view1.setCurPayBand(1L);
		view1.setCurPayBandValue(1l);
		view1.setCurBasicPay(1l);
		view1.setClassId(1L);
		view1.setDesignationId(1L);
		lstIncIncludeExclude1.add(view1);
		List<PVUIncrementEmpSDDto> lstIncrementEmpDto = new ArrayList<>();
		List<PVUIncrementEmpSDDto> lstIncrementEmpDto1 = new ArrayList<>();


		PVUIncrementEmpSDDto dto2 = new PVUIncrementEmpSDDto();
		dto2.setEmpId(Constant.ROP_2009);
		dto2.setIncrementType(Constant.ROP_2009_EVENT);

		dto2.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		dto2.setCurCellId(1L);
		dto2.setCurGrade(1L);
		dto2.setCurScale(12L);
		dto2.setCurGradePay(1L);
		dto2.setCurPayBand(1L);
		dto2.setCurPayBandValue(1l);
		dto2.setCurBasicPay(1l);
		dto2.setClassId(1L);
		dto2.setDesignationId(1L);


		PVUIncrementEmpSDDto dto = new PVUIncrementEmpSDDto();
		dto.setEmpId(Constant.ROP_2016);
		dto.setIncrementType(Constant.ROP_2009_EVENT);
		dto.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		dto.setCurCellId(1L);
		dto.setCurGrade(1L);
		dto.setCurScale(12L);
		dto.setCurGradePay(1L);
		dto.setCurPayBand(1L);
		dto.setCurPayBandValue(1l);
		dto.setCurBasicPay(1l);
		dto.setClassId(1L);
		dto.setDesignationId(1L);
		lstIncrementEmpDto.add(dto2);
		lstIncrementEmpDto1.add(dto);

		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", lstIncIncludeExclude);
		stringObjectMap.put("#result-set-2", lstIncIncludeExclude1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);
		PVUIncrementMainEventDto dto1=new PVUIncrementMainEventDto();
		dto1.setDateNextInc(new Date());
		dto1.setIncrementEffDate(new Date());
		dto1.setEmpNo("123");
		List<PVUIncrementEmpSDDto> lstIncrementEmpDto2 = new ArrayList<>();
		lstIncrementEmpDto2.add(dto);
		lstIncrementEmpDto2.add(dto2);
		dto1.setPvuIncrementEmpSDDtos(lstIncrementEmpDto2);
		service.validateEmpSalaryInSync(dto1);

	}

	@Test
	void testPVUEmployeeIncrementConfirmAndProcess() throws CustomException {

		PVURegularIncrementEligibleListView p1 = new PVURegularIncrementEligibleListView();
		p1.setClassId(123L);
		p1.setDateOfJoining(new Date());
		List<PVURegularIncrementEligibleListView> nonEligibleListViews = new ArrayList<>();
		LinkedHashMap<String, Object> abc = new LinkedHashMap<>();
		abc.put("0", p1);
		List<LinkedHashMap<String, Object>> abc1 = new ArrayList<>();
		abc1.add(abc);
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("#result-set-1", abc1);
		stringObjectMap.put("#result-set-2", abc1);
		when(repository.callStoredProcedureMap(Mockito.anyString(), Mockito.anyMap())).thenReturn(stringObjectMap);

		List<PVUIncrementEmpSDDto> list = new ArrayList<>();

		list.add(pvuIncrementEmpDto);
		when(pvuIncrementEmpDto.getEmpId()).thenReturn(1l);
		when(converter.toEntity(pvuIncrementMainEventDto)).thenReturn(pvuIncrementEventEntity);
		when(repository.save(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventEntity);

		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT))
				.thenReturn(edpLuLookUpInfoEntityStatusId);

/*		when(pvuEmployeeEventStatusService.getEmployeeInProcessByEmpIds(lstEmpIncludeList))
				.thenReturn(pvuEmployeeEventStatusDtoList);*/
		when(pvuIncrementMainEventDto.getPvuIncrementEmpSDDtos()).thenReturn(list);
		when(pvuIncrementEventEntity.getInEventId()).thenReturn(0L);
		when(pvuIncrementEventEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);


		when(converter.toDTO(pvuIncrementEventEntity)).thenReturn(pvuIncrementMainEventDto);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		when(pvuIncrementMainEventDto.getPvuIncrementEmpSDDtos()).thenReturn(list);

		when(pvuIncrementMainEventDto.getPvuRegularIncrementSmryViews()).thenReturn(pvuRegularIncrementSmryViews);
/*		when(pvuEmployeeEventStatusRepository.findEmployeeInProgress(lstEmpIncludeList))
				.thenReturn(pvuEmployeeEventStatusDtoList);*/
		when(pvuIncrementEventEntity.getTrnNo()).thenReturn("SD");
		when(pvuIncrementMainEventDto.getDateNextInc()).thenReturn(new Date());
		when(pvuIncrementMainEventDto.getIncrementEffDate()).thenReturn(new Date());
		when(pvuIncrementMainEventDto.getIncrementFor()).thenReturn(151L);

		assertNotNull(service.pvuEmployeeIncrementConfirmAndProcess(pvuIncrementMainEventDto));
	}

/*
@Test
	void testSetPayValueByPayCommision() throws CustomException {
		String rptName = PvuConstant.IN_VALID_SHEET;
		Long paycommisionid = Long.parseLong("150L");
		List<String> header = new ArrayList<>();
		header.add(PvuConstant.PVU_MIS_SRNO);

		assertNotNull(service
				.setPayValueByPayCommision(rptName, paycommisionid, header));
	}

*/


}
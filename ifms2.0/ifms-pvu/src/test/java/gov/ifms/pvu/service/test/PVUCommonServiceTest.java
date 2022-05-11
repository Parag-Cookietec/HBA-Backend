package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.entity.PVUMsCourseEntity;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeDeptExamDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployePayDetailService;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

class PVUCommonServiceTest {

	@InjectMocks
	PVUCommonService pvuCommonService;

	@Mock
	private PVUEmployeDepartmentEntity deptEntity;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	@Mock
	private PVUEmployeEntity pvuEmpEntity;

	@Mock
	private PVUEmployeEventsService eventsService;

	@Mock
	private PVUEmployeRepository repository;

	@Mock
	private PVUEmployeDeptExamDetailsRepository deptExamDetailsRepository;

	@Mock
	private PVUEmployeCCCExamDetailRepository cccExamDetailRepository;

	@Mock
	private PVUEmployeLangExamRepository langExamRepository;

	@Mock
	PVUEmployeDeptExamDetailsEntity exambody;

	@Mock
	PVUMsCourseEntity courseEntity;

	@Mock
	PVUEmployeCCCExamDetailEntity pvuEmployeCCCExamDetailEntity;

	@Mock
	PVUEmployeLangExamEntity langExamEntity;

	@Mock
	private PVUEmployePayDetailService empPayDetailService;

	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getRegularEmployeeCommonDetailsForSHP() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		SearchParam param1 = new SearchParam();
		param1.setKey(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey());
		param1.setValue("1");
		SearchParam param2 = new SearchParam();
		param2.setKey(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getKey());
		param2.setValue(PvuUtils.getStrOfLocalDateInYMD(LocalDate.now()));
		jsonArr.add(param1);
		jsonArr.add(param2);
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(PvuConstant.REGULAR_PAY_TYPE_ID);
		when(deptEntity.getEmpPayType()).thenReturn(edpLuLookUpInfoEntity);
		when(deptEntity.getEmpPayType().getLookUpInfoId()).thenReturn(PvuConstant.REGULAR_PAY_TYPE_ID);
		when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(Long.valueOf("1")))
				.thenReturn(Optional.of(deptEntity));
		when(pvuEmpEntity.getEmpId()).thenReturn(1l);
		when(deptEntity.getPvuEmployeEntity()).thenReturn(pvuEmpEntity);
		when(eventsService.findOneByEmpIdAndEventName(1l, PvuConstant.EVENT_CODE_EOL)).thenReturn(null);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(exambody.getExamBody()).thenReturn(edpLuLookUpInfoEntity);
		when(exambody.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);

		List<PVUEmployeDeptExamDetailsEntity> deptExam = new ArrayList<PVUEmployeDeptExamDetailsEntity>();
		deptExam.add(exambody);
		when(deptExamDetailsRepository.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(deptExam);

		List<PVUEmployeCCCExamDetailEntity> cccExam = new ArrayList<PVUEmployeCCCExamDetailEntity>();
		when(cccExamDetailRepository.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(cccExam);
		cccExam.add(pvuEmployeCCCExamDetailEntity);
		when(pvuEmployeCCCExamDetailEntity.getExamBody()).thenReturn(courseEntity);
		when(pvuEmployeCCCExamDetailEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);

		List<PVUEmployeLangExamEntity> lanExam = new ArrayList<PVUEmployeLangExamEntity>();
		when(langExamEntity.getExamBody()).thenReturn("");
		when(langExamEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);
		lanExam.add(langExamEntity);
		when(langExamRepository.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(lanExam);
		assertNotNull(pvuCommonService.getRegularEmployeeCommonDetailsForSHP(pageDetail));
	}

	@Test
	void getRegularEmployeeCommonDetails() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		SearchParam param1 = new SearchParam();
		param1.setKey(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey());
		param1.setValue("1");
		SearchParam param2 = new SearchParam();
		param2.setKey(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getKey());
		param2.setValue(PvuUtils.getStrOfLocalDateInYMD(LocalDate.now()));
		jsonArr.add(param1);
		jsonArr.add(param2);
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(PvuConstant.REGULAR_PAY_TYPE_ID);
		when(deptEntity.getEmpPayType()).thenReturn(edpLuLookUpInfoEntity);
		when(deptEntity.getEmpPayType().getLookUpInfoId()).thenReturn(PvuConstant.REGULAR_PAY_TYPE_ID);
		when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(Long.valueOf("1")))
				.thenReturn(Optional.of(deptEntity));
		when(pvuEmpEntity.getEmpId()).thenReturn(1l);
		when(deptEntity.getPvuEmployeEntity()).thenReturn(pvuEmpEntity);
		when(eventsService.findOneByEmpIdAndEventName(1l, PvuConstant.EVENT_CODE_EOL)).thenReturn(null);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(exambody.getExamBody()).thenReturn(edpLuLookUpInfoEntity);
		when(exambody.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);

		List<PVUEmployeDeptExamDetailsEntity> deptExam = new ArrayList<PVUEmployeDeptExamDetailsEntity>();
		deptExam.add(exambody);
		when(deptExamDetailsRepository.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(deptExam);

		List<PVUEmployeCCCExamDetailEntity> cccExam = new ArrayList<PVUEmployeCCCExamDetailEntity>();
		when(cccExamDetailRepository.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(cccExam);
		cccExam.add(pvuEmployeCCCExamDetailEntity);
		when(pvuEmployeCCCExamDetailEntity.getExamBody()).thenReturn(courseEntity);
		when(pvuEmployeCCCExamDetailEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);

		List<PVUEmployeLangExamEntity> lanExam = new ArrayList<PVUEmployeLangExamEntity>();
		when(langExamEntity.getExamBody()).thenReturn("");
		when(langExamEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);
		lanExam.add(langExamEntity);
		when(langExamRepository.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(lanExam);
		assertNotNull(pvuCommonService.getCommonDetailsOnEventDate(pageDetail));
	}

	@Test
	void getSearchCommonDetails() throws CustomException, ParseException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		SearchParam param1 = new SearchParam();
		param1.setKey(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey());
		param1.setValue("1");
		SearchParam param2 = new SearchParam();
		param2.setKey(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getKey());
		param2.setValue(PvuUtils.getStrOfLocalDateInYMD(LocalDate.now()));

		SearchParam param3 = new SearchParam();
		param3.setKey(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getKey());
		param3.setValue("151");

		jsonArr.add(param1);
		jsonArr.add(param2);
		jsonArr.add(param3);
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(PvuConstant.REGULAR_PAY_TYPE_ID);
		when(deptEntity.getEmpPayType()).thenReturn(edpLuLookUpInfoEntity);
		when(deptEntity.getDateOfJoiningGOG()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2006"));
		when(deptEntity.getEmpPayType().getLookUpInfoId()).thenReturn(PvuConstant.REGULAR_PAY_TYPE_ID);
		when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(Long.valueOf("1")))
				.thenReturn(Optional.of(deptEntity));
		when(pvuEmpEntity.getEmpId()).thenReturn(1l);
		when(deptEntity.getPvuEmployeEntity()).thenReturn(pvuEmpEntity);
		when(eventsService.findOneByEmpIdAndEventName(1l, PvuConstant.EVENT_CODE_EOL)).thenReturn(null);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(exambody.getExamBody()).thenReturn(edpLuLookUpInfoEntity);
		when(exambody.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);

		List<PVUEmployeDeptExamDetailsEntity> deptExam = new ArrayList<PVUEmployeDeptExamDetailsEntity>();
		deptExam.add(exambody);
		when(deptExamDetailsRepository.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(deptExam);

		List<PVUEmployeCCCExamDetailEntity> cccExam = new ArrayList<PVUEmployeCCCExamDetailEntity>();
		when(cccExamDetailRepository.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(cccExam);
		cccExam.add(pvuEmployeCCCExamDetailEntity);
		when(pvuEmployeCCCExamDetailEntity.getExamBody()).thenReturn(courseEntity);
		when(pvuEmployeCCCExamDetailEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);

		List<PVUEmployeLangExamEntity> lanExam = new ArrayList<PVUEmployeLangExamEntity>();
		doNothing().when(empPayDetailService).validatePayCommision(1l, new Date(), 151l,
				new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2006"));
		when(langExamEntity.getExamBody()).thenReturn("");
		when(langExamEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);
		lanExam.add(langExamEntity);
		when(langExamRepository.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				Constant.ACTIVE_STATUS)).thenReturn(lanExam);
		assertNotNull(pvuCommonService.getSearchCommonDetails(pageDetail));
	}

}

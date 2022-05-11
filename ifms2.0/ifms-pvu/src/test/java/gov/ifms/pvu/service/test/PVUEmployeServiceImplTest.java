package gov.ifms.pvu.service.test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.attachment.service.AttachmentService;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SearchDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.*;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.*;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.*;
import gov.ifms.edp.service.EDPLuLookUpInfoService;
import gov.ifms.edp.service.EDPMsDesignationService;
import gov.ifms.edp.service.EDPMsStateService;
import gov.ifms.edp.service.EDPMsUserService;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.converter.*;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.edp.EDPMsHeadDepartmentConverter;
import gov.ifms.pvu.edp.EDPMsHeadDepartmentDto;
import gov.ifms.pvu.edp.EDPMsHeadDepartmentEntity;
import gov.ifms.pvu.edp.EDPMsHeadDepartmentRepository;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.repository.*;
import gov.ifms.pvu.service.PVUEmployeDepartmentService;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeQualificationService;
import gov.ifms.pvu.service.PVUEmployeServiceImpl;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


/**
 * The Class PVUEmployeServiceImplTest.
 */
public class PVUEmployeServiceImplTest {
	
	/** The pvu employe service impl. */
	@InjectMocks
	private PVUEmployeServiceImpl pvuEmployeServiceImpl;

	/** The pvu employe events service. */
	@Mock
	PVUEmployeEventsService pvuEmployeEventsService;

	/** The pvu employe entity list. */
	@Mock
	List<PVUEmployeEntity> pvuEmployeEntityList;

	/** The edp ms designation service. */
	@Mock
	private EDPMsDesignationService edpMsDesignationService;

	/** The pvu employe repository. */
	@Mock
	private PVUEmployeRepository pvuEmployeRepository;

	/** The pvu employe entity. */
	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	/** The pvu employee DTO. */
	@Mock
	private PVUEmployeeDtos pvuEmployeeDTO;

	/** The pvu employe address repository. */
	@Mock
	private PVUEmployeAddressRepository pvuEmployeAddressRepository;

	/** The pvu employe nominee repository. */
	@Mock
	private PVUEmployeNomineeRepository pvuEmployeNomineeRepository;

	/** The pvu employe address entity. */
	@Mock
	private PVUEmployeAddressEntity pvuEmployeAddressEntity;
	
	/** The pvu employe nominee entity. */
	@Mock
	private PVUEmployeNomineeEntity pvuEmployeNomineeEntity;

	/** The list. */
	@Mock
	private List<PVUEmployeNomineeEntity> list;

	/** The nominee list. */
	@Mock
	private List<PVUEmployeNomineeEntity> nomineeList;

	/** The nominee list dto. */
	@Mock
	private List<PVUEmployeNomineeDto> nomineeListDto;

	/** The pvu employe converter. */
	@Mock
	private PVUEmployeConverter pvuEmployeConverter;

	/** The pvu employe address converter. */
	@Mock
	private PVUEmployeAddressConverter pvuEmployeAddressConverter;

	/** The pvu employe nominee converter. */
	@Mock
	private PVUEmployeNomineeConverter pvuEmployeNomineeConverter;

	/** The pvu employe dto. */
	@Mock
	private PVUEmployeDto pvuEmployeDto;

	/** The pvu employe address dto. */
	@Mock
	private PVUEmployeAddressDto pvuEmployeAddressDto;

	/** The pvu employe nominee dto. */
	@Mock
	private PVUEmployeNomineeDto pvuEmployeNomineeDto;

	/** The edp ms user service. */
	@Mock
	private EDPMsUserService edpMsUserService;

	/** The edp ms state service. */
	@Mock
	private EDPMsStateService edpMsStateService;

	/** The e DP ms financial year repository. */
	@Mock
	private EDPMsFinancialYearRepository eDPMsFinancialYearRepository;

	/** The department category repository. */
	@Mock
	private PVUDepartmentCategoryRepository pvuDeptCatRepository;

	/** The department category entity. */
	@Mock
	private List<PVUDepartmentCategoryEntity> pvuDepartmentCategoryEntityLst;

	/** The MS_OFFICE repository */
	@Mock
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/** MS_OFFICE entity */
	@Mock
	private EDPMsOfficeEntity edpMsOfficeEntity;

	/** MS_OFFICE entity List */
	@Mock
	private List<EDPMsOfficeEntity> edpMsOfficeEntityList;

	/** MS_OFFICE entity to dto converter */
	@Mock
	private EDPMsOfficeConverter edpMsOfficeConverter;

	/** The department category repository. */
	@Mock
	private EDPMsBankIfscRepository edpMsBankIfscRepository;

	/** The department category entity. */
	@Mock
	private List<EDPMsBankIfscEntity> edpMsBankIfscEntities;


	/** The lt. */
	@Mock
	private List<EDPSDTDto> lt;

	/** The finan list. */
	@Mock
	List<EDPMsFinancialYearEntity> finanList;

	/** The e DP ms financial year converter. */
	@Mock
	private EDPMsFinancialYearConverter eDPMsFinancialYearConverter;

	/** The e DP ms financial year converter. */
	@Mock
	private PVUDepartmentCategoryConverter pvuDepartmentCategoryConverter;

	/** The e DP ms financial year converter. */
	@Mock
	private EDPMsBankIfscConverter edpMsBankIfscConverter;

	/** The e DP lu look up repository. */
	@Mock
	private EDPLuLookUpRepository eDPLuLookUpRepository;

	/** The e DP lu look up entity. */
	@Mock
	private EDPLuLookUpEntity eDPLuLookUpEntity;

	/** The look entity. */
	@Mock
	private EDPLuLookUpInfoEntity lookEntity;

	/** The e DP lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	/** The lu lst. */
	@Mock
	private List<EDPLuLookUpInfoEntity> luLst;

	/** The emp nominee repository. */
	@Mock
	private PVUEmployeNomineeRepository empNomineeRepository;

	/** The events repository. */
	@Mock
	private PVUEmployeEventsRepository eventsRepository;

	/** The pvu employe events entity. */
	@Mock
	private PVUEmployeEventsEntity pvuEmployeEventsEntity;

	/** The exam repo. */
	@Mock
	private PVUEmployeDepartmentRepository examRepo;

	/** The department. */
	@Mock
	private PVUEmployeDepartmentEntity department;

	/** The dept exam details service. */
	@Mock
	private PVUEmployeQualificationService deptExamDetailsService;

	/** The dep exams. */
	@Mock
	private PVUEmployeeQualificationDtos depExams;

	/** The pvu employe lang exam dto. */
	@Mock
	private List<PVUEmployeLangExamDto> pvuEmployeLangExamDto;

	/** The pvu employe dept exam details dto. */
	@Mock
	private List<PVUEmployeDeptExamDetailsDto> pvuEmployeDeptExamDetailsDto;

	/** The edp entity. */
	@Mock
	private EDPMsDesignationEntity edpEntity;

	/** The ent. */
	@Mock
	private PVUMsPayBandEntity ent;

	/** The pvu employe CCC exam detail dto. */
	@Mock
	private List<PVUEmployeCCCExamDetailDto> pvuEmployeCCCExamDetailDto;

	/** The en. */
	@Mock
	private EDPLuLookUpInfoEntity en;

	/** The edp ms design. */
	@Mock
	private List<EDPMsDesignationEntity> edpMsDesign;

	/** The pvu emp. */
	@Mock
	private List<PVUEmployeCreationDDLView> pvuEmp;

	/** The pvu emp view. */
	@Mock
	private PVUEmployeCreationDDLView pvuEmpView;

	/** The enti. */
	@Mock
	private EDPMsOfficeEntity enti;

	/** The ed entity. */
	@Mock
	private EDPMsDesignationEntity edEntity;

	/** The edp ms district entity. */
	@Mock
	private EDPMsDistrictEntity edpMsDistrictEntity;

	/** The taluka entity. */
	@Mock
	private EDPMsTalukaEntity talukaEntity;

	/** The lst. */
	@Mock
	List<PVUEmployeCreationDDLView> lst;

	/** The edp lu look up info service. */
	@Mock
	private EDPLuLookUpInfoService edpLuLookUpInfoService;

	/** The look up info. */
	@Mock
	private PVUEmployeCreationDDLView lookUpInfo;

	/** The dto. */
	@Mock
	private IdDto dto;

	/** The master dto. */
	@Mock
	private AttachmentMasterDto masterDto;

	/** The attachment service. */
	@Mock
	private AttachmentService attachmentService;

	/** The upload attachment. */
	@Mock
	private List<FileUploadResponseDto> uploadAttachment;

	/** The pvu WF wrapper dto. */
	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	/** The pvu facade. */
	@Mock
	private PVYFacade pvuFacade;

	/** The emp status lookup info. */
	@Mock
	private EDPLuLookUpInfoEntity empStatusLookupInfo;

	/** The emp status lookup info 1. */
	@Mock
	private EDPLuLookUpInfoEntity empStatusLookupInfo1;

	/** The e DP ms department repository. */
	@Mock
	private EDPMsDepartmentRepository eDPMsDepartmentRepository;

	/** The att. */
	@Mock
	private AttachmentMasterDto att;

	/** The list en. */
	@Mock
	private List<EDPMsDepartmentEntity> listEn;

	/** The list dto. */
	@Mock
	private List<EDPSDTDto> listDto;

	/** The e DP ms head department repository. */
	@Mock
	private EDPMsHeadDepartmentRepository eDPMsHeadDepartmentRepository;

	/** The head en. */
	@Mock
	private List<EDPMsHeadDepartmentEntity> headEn;

	/** The head dto. */
	@Mock
	private List<EDPMsHeadDepartmentDto> headDto;

	/** The e DP ms department converter. */
	@Mock
	private EDPMsDepartmentConverter eDPMsDepartmentConverter;

	/** The e DP ms head department converter. */
	@Mock
	private EDPMsHeadDepartmentConverter eDPMsHeadDepartmentConverter;

	/** The findactiveedp ms designation. */
	@Mock
	List<EDPMsDesignationEntity> findactiveedpMsDesignation;

	/** The ms dto. */
	@Mock
	List<AttachmentMasterDto> msDto;

	/** The ms. */
	@Mock
	AttachmentMasterDto ms;

	/** The m part. */
	@Mock
	List<MultipartFile> mPart;

	/** The nom dto. */
	@Mock
	List<PVUEmployeNomineeDto> nomDto;

	/** The dt. */
	@Mock
	private FileUploadResponseDto dt;

	/** The course repository. */
	@Mock
	private PVUMsCourseRepository courseRepository;

	/** The pvu list. */
	@Mock
	List<PVUMsCourseEntity> pvuList;

	/** The course converter. */
	@Mock
	private PVUMsCourseConverter courseConverter;

	/** The emp nominee converter. */
	@Mock
	private PVUEmployeNomineeConverter empNomineeConverter;

	/** The lsar. */
	@Mock
	List<PVUEmployeCreationDDLView> lsar;

	/** The pvu employe department repository. */
	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	/** The mapper. */
	ObjectMapper mapper = new ObjectMapper();

	/** The o auth utility. */
	private OAuthUtility oAuthUtility;

	@Mock
	PVUEmployeDepartmentService pvuEmployeDepartmentService;

	@Mock
	EDPMsBankBranchConverter edpMsBankBranchConverter;

	@Mock
	EDPMsBankBranchRepository edpMsBankBranchRepository;

	@Mock
	EDPMsBankBranchEntity edpMsBankBranchEntity;

	@Mock
	private List<EDPMsBankBranchEntity> edpMsBankBranchEntities;

	@Mock
	SearchDto searchDto ;


	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Test get employe.
	 *
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	void testGetEmploye() throws JsonParseException, JsonMappingException, IOException {

		when(pvuEmployeRepository.getOne(1l)).thenReturn(pvuEmployeEntity);
		assertEquals(pvuEmployeEntity, pvuEmployeServiceImpl.getEmploye(1l));
		verify(pvuEmployeRepository, times(1)).getOne(1L);
	}

	/**
	 * Test save or update employe.
	 *
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveOrUpdateEmploye() throws JsonParseException, JsonMappingException, IOException, CustomException {
		List<AttachmentMasterDto> attachmentMasterDtoList = new ArrayList<>();
		attachmentMasterDtoList.add(masterDto);
		when(pvuEmployeRepository.save(pvuEmployeEntity)).thenReturn(pvuEmployeEntity);
		when(pvuEmployeeDTO.getPvuEmployeDto()).thenReturn(pvuEmployeDto);
		when(pvuEmployeDto.getPhotoAttachment()).thenReturn(attachmentMasterDtoList);
		when(masterDto.getAttachment()).thenReturn(mPart);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(masterDto.getTransactionId()).thenReturn(1l);
		when(pvuEmployeConverter.toDTO(pvuEmployeEntity)).thenReturn(pvuEmployeDto);
		when(pvuEmployeConverter.toEntity(pvuEmployeDto)).thenReturn(pvuEmployeEntity);
		List<FileUploadResponseDto> uploadAttachment = new ArrayList<>();
		uploadAttachment.add(dt);
		when(attachmentService.createPostAttachment(masterDto)).thenReturn(uploadAttachment);
		when(dt.getDocumentId()).thenReturn("123");
		when(dt.getFilename()).thenReturn("123");
		when(pvuEmployeeDTO.getPvuEmployeAddressDto()).thenReturn(pvuEmployeAddressDto);
		when(pvuEmployeAddressDto.getEmpId()).thenReturn(1l);
		when(pvuEmployeAddressConverter.toEntity(pvuEmployeAddressDto)).thenReturn(pvuEmployeAddressEntity);
		when(pvuEmployeAddressRepository.save(pvuEmployeAddressEntity)).thenReturn(pvuEmployeAddressEntity);
		List<PVUEmployeNomineeDto> listtt = new ArrayList<PVUEmployeNomineeDto>();
		listtt.add(pvuEmployeNomineeDto);
		when(pvuEmployeeDTO.getPvuEmployeNomineeDto()).thenReturn(listtt);
		when(pvuEmployeNomineeDto.getEmpId()).thenReturn(1l);
		when(empNomineeConverter.toEntity(pvuEmployeNomineeDto)).thenReturn(pvuEmployeNomineeEntity);
		when(empNomineeRepository.save(pvuEmployeNomineeEntity)).thenReturn(pvuEmployeNomineeEntity);
		when(pvuEmployeNomineeDto.getGenNomineePhotoAttachment()).thenReturn(masterDto);
		when(masterDto.getAttachment()).thenReturn(mPart);
		when(pvuEmployeNomineeEntity.getEmpNomineeId()).thenReturn(1l);
		when(pvuEmployeNomineeDto.getNomineePhotoAttachment()).thenReturn(masterDto);
		when(pvuEmployeNomineeDto.getNpsNomineePhotoAttachment()).thenReturn(masterDto);
		assertNotNull(pvuEmployeServiceImpl.saveOrUpdateEmploye(pvuEmployeeDTO));

	}

	/**
	 * Test get employes.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetEmployes() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("empNo", "1"));
		jsonArr.add(new SearchParam("empName", "V"));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("officeId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("transNo", " "));
		jsonArr.add(new SearchParam("workflowId", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		IdDto d = new IdDto();
		List<IdDto> lst = new ArrayList<IdDto>();
		d.setId(1l);
		lst.add(d);
		CurrentUserUserId();
		when(edpMsUserService.getDependentUerIdByUserId(1l)).thenReturn(lst);
		assertNotNull(pvuEmployeServiceImpl.getEmployes(pageDetail));

	}

	/**
	 * Teststore proc common emp.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void teststoreProcCommonEmp() throws CustomException {
		assertNotNull(pvuEmployeServiceImpl.storeProcCommonEmp("PVU_EMPLOYEE_SEARCH", new HashMap<String, Object>()));

	}

	/**
	 * Test get all employe events.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAllEmployeEvents() throws CustomException {

		PageDetails pageDetail = new PageDetails();
		IdDto d = new IdDto();
		List<IdDto> lst = new ArrayList<IdDto>();
		d.setId(1l);
		lst.add(d);
		CurrentUserUserId();
		when(edpMsUserService.getDependentUerIdByUserId(1l)).thenReturn(lst);
		pvuEmployeEventsService.getEmployeEventss(pageDetail);

	}

	/**
	 * Current user user id.
	 *
	 * @return the long
	 */
	@SuppressWarnings("static-access")
	Long CurrentUserUserId() {
		return oAuthUtility.getCurrentUserUserId();

	}

	/**
	 * Testget all common employe.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testgetAllCommonEmploye() throws CustomException {

		oAuthUtility = new OAuthUtility();

		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("empNo", "1"));
		jsonArr.add(new SearchParam("empType", "1"));
		jsonArr.add(new SearchParam("cpfNo", "1"));
		jsonArr.add(new SearchParam("classId", "1"));
		jsonArr.add(new SearchParam("officeId", "1"));
		jsonArr.add(new SearchParam("officeType", "1"));
		jsonArr.add(new SearchParam("retirementDate", "1"));
		jsonArr.add(new SearchParam("employeePayType", "1"));
		jsonArr.add(new SearchParam("designationId", "1"));
		jsonArr.add(new SearchParam("workflowId", "1"));
		jsonArr.add(new SearchParam("empName", " aashi"));
		jsonArr.add(new SearchParam("caseNo", "tca45 "));
		jsonArr.add(new SearchParam("startDate", " kxckjk"));
		jsonArr.add(new SearchParam("endDate", " 133r"));
		jsonArr.add(new SearchParam("pPan", " 09876544"));
		jsonArr.add(new SearchParam("gpfNo", " 1q2344"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		pageDetail.setSortByColumn("asc");
		pageDetail.setSortOrder("asc");
		IdDto d = new IdDto();
		List<IdDto> lst = new ArrayList<IdDto>();
		d.setId(1l);
		lst.add(d);
		CurrentUserUserId();
		when(edpMsUserService.getDependentUerIdByUserId(1l)).thenReturn(lst);
		assertNotNull(pvuEmployeServiceImpl.getAllCommonEmploye(pageDetail));

	}

	/**
	 * Test get all lu look up info as map.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		assertNotNull(pvuEmployeServiceImpl.getAllLuLookUpInfoAsMap());
	}

	/**
	 * Test get employee details.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetEmployeeDetails() throws Exception {
		when(pvuEmployeRepository.findByEmpIdAndActiveStatus(1l, 1)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeRepository.getOne(1l)).thenReturn(pvuEmployeEntity);
		when(pvuEmployeAddressRepository.findPVUEmployeAddressEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1))
				.thenReturn(pvuEmployeAddressEntity);
		when(pvuEmployeNomineeRepository.findPVUEmployeNomineeEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1))
				.thenReturn(list);
		when(pvuEmployeConverter.toDTO(pvuEmployeEntity)).thenReturn(pvuEmployeDto);
		when(pvuEmployeAddressConverter.toDTO(pvuEmployeAddressEntity)).thenReturn(pvuEmployeAddressDto);
		when(pvuEmployeNomineeConverter.toDTO(pvuEmployeNomineeEntity)).thenReturn(pvuEmployeNomineeDto);

		assertNotNull(pvuEmployeServiceImpl.getEmployeeDetails(1l));

	}

	/**
	 * Test get pvu lookup and master data.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetPvuLookupInfo() throws Exception {
		List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = new ArrayList<>();
		eDPLuLookUpInfoEntities.add(empStatusLookupInfo);
		//when(edpMsStateService.getSDTData()).thenReturn(lt);
		when(eDPMsFinancialYearRepository.findAll()).thenReturn(finanList);
		when(pvuDeptCatRepository.findByActiveStatus(Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(PvuConstant.DEPT_CATEGORY_NAME, EDPConstant.ORDER_ASC))).thenReturn(pvuDepartmentCategoryEntityLst);
		when(pvuDepartmentCategoryConverter.toEDPSDTDtos(pvuDepartmentCategoryEntityLst)).thenReturn(lt);
		Set<String> statusNameList = new HashSet<>();
		statusNameList.add(EDPConstant.LK_STATUS_VAL_APPROVED);
		statusNameList.add(EDPConstant.LK_STATUS_VAL_ACTIVE);
		List<EDPLuLookUpInfoEntity> approveLookUpInfo = eDPLuLookUpInfoRepository.findByLookUpInfoNameIn(statusNameList);
		Set<Short> statusIdList = approveLookUpInfo.stream().map(entity -> Short.valueOf(String.valueOf(entity.getLookUpInfoId()))).collect(Collectors.toSet());
		when(edpMsOfficeRepository.findAllHodOffice(statusIdList, 0L, EDPConstant.ACTIVE_STATUS_TRUE)).thenReturn(edpMsOfficeEntityList);
		when(edpMsOfficeConverter.toEDPSDTDtos(edpMsOfficeEntityList)).thenReturn(lt);

		when(edpMsBankIfscRepository.findByActiveStatus(Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(PvuConstant.IFSC_CODE, EDPConstant.ORDER_ASC))).thenReturn(edpMsBankIfscEntities);

		when(edpMsBankIfscConverter.toEDPSDTDto(edpMsBankIfscEntities)).thenReturn(lt);
		when(eDPMsFinancialYearRepository.findAll()).thenReturn(finanList);
		when(eDPMsFinancialYearConverter.toEDPSDTDto(finanList)).thenReturn(lt);
		when(eDPLuLookUpRepository.findByLookUpName("Course Category")).thenReturn(eDPLuLookUpEntity);
		when(eDPLuLookUpEntity.getLookUpId()).thenReturn(1l);
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(1l, Constant.ACTIVE_STATUS))
				.thenReturn(eDPLuLookUpInfoEntities);
		//when(eDPMsDepartmentRepository.findByActiveStatus(1)).thenReturn(listEn);
		when(eDPMsHeadDepartmentRepository.findByActiveStatus(1)).thenReturn(headEn);
		//when(eDPMsDepartmentConverter.toEDPSDTDto(listEn)).thenReturn(listDto);
		when(eDPMsHeadDepartmentConverter.toEDPSDTDto(headEn)).thenReturn(listDto);
		when(eDPLuLookUpEntity.getLookUpName()).thenReturn(PvuConstant.CCC_EXAM);
		when(empStatusLookupInfo.getLookUpInfoName()).thenReturn("CCC Exam");
		when(empStatusLookupInfo.getLookUpInfoId()).thenReturn(1l);
		when(courseRepository.findByCourseCategoryLookUpInfoIdAndActiveStatus(1l, 1)).thenReturn(pvuList);
		when(courseConverter.toEDPSDTDto(pvuList)).thenReturn(listDto);
		assertNotNull(pvuEmployeServiceImpl.getPvuLookupInfo());
		when(empStatusLookupInfo.getLookUpInfoName()).thenReturn("Course Name");
		assertNotNull(pvuEmployeServiceImpl.getPvuLookupInfo());
		when(empStatusLookupInfo.getLookUpInfoName()).thenReturn("School_Degree");
		assertNotNull(pvuEmployeServiceImpl.getPvuLookupInfo());
	}

	/**
	 * Testget employe look up info.
	 */
	@Test
	//Do not enter inline method otherwise it will give exption
	public void testgetEmployeLookUpInfo() {
		List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = new ArrayList<>();
		eDPLuLookUpInfoEntities.add(empStatusLookupInfo);
		when(edpMsStateService.getSDTData()).thenReturn(lt);
		when(eDPMsFinancialYearRepository.findAll()).thenReturn(finanList);
		when(eDPMsFinancialYearConverter.toEDPSDTDto(finanList)).thenReturn(lt);
		when(eDPLuLookUpRepository.findByLookUpName("Course Category")).thenReturn(eDPLuLookUpEntity);
		when(eDPLuLookUpEntity.getLookUpId()).thenReturn(1l);
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(1l, Constant.ACTIVE_STATUS)).thenReturn(eDPLuLookUpInfoEntities);
		when(edpMsBankBranchRepository.findByActiveStatus(Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(PvuConstant.IFSC_CODE, EDPConstant.ORDER_ASC))).thenReturn(edpMsBankBranchEntities);
		when(eDPMsDepartmentRepository.findByActiveStatus(1)).thenReturn(listEn);
		when(eDPMsHeadDepartmentRepository.findByActiveStatus(1)).thenReturn(headEn);
		when(eDPMsDepartmentConverter.toEDPSDTDto(listEn)).thenReturn(listDto);
		when(eDPMsHeadDepartmentConverter.toEDPSDTDto(headEn)).thenReturn(listDto);
		when(eDPLuLookUpEntity.getLookUpName()).thenReturn(PvuConstant.CCC_EXAM);
		when(empStatusLookupInfo.getLookUpInfoName()).thenReturn("CCC Exam");
		when(empStatusLookupInfo.getLookUpInfoId()).thenReturn(1l);
		when(courseRepository.findByCourseCategoryLookUpInfoIdAndActiveStatus(1l, 1)).thenReturn(pvuList);
		when(courseConverter.toEDPSDTDto(pvuList)).thenReturn(listDto);
		assertNotNull(pvuEmployeServiceImpl.getPvuLookupInfoDto());
		when(empStatusLookupInfo.getLookUpInfoName()).thenReturn("Course Name");
		assertNotNull(pvuEmployeServiceImpl.getPvuLookupInfoDto());
		when(empStatusLookupInfo.getLookUpInfoName()).thenReturn("School_Degree");
		assertNotNull(pvuEmployeServiceImpl.getPvuLookupInfoDto());
	}

	/**
	 * Test update active status.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	//Do not enter inline method otherwise it will give exption
	public void testUpdateActiveStatus() throws CustomException {
		when(empNomineeRepository.updateActiveStatusByNomineeId(1l, 1, 1, new Date(0))).thenReturn(1);
		pvuEmployeServiceImpl.updateActiveStatus(1l, 1);
	}

	/**
	 * Test get common response by id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	public void testGetCommonResponseById() throws CustomException {
		when(dto.getId()).thenReturn(1l);
		when(pvuEmployeRepository.findById(1l)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeRepository.findByEmployeeCodeAndActiveStatus(1l,1)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeEntity.getEmployeeName()).thenReturn("Anshul");
		when(pvuEmployeEntity.getSalutation()).thenReturn(en);
		when(en.getLookUpInfoName()).thenReturn("dsa");
		when(pvuEmployeEntity.getEmployeeMiddleName()).thenReturn("ba");
		when(pvuEmployeEntity.getEmployeeSurname()).thenReturn("Batra");
		when(pvuEmployeEntity.getGender()).thenReturn(en);
		when(pvuEmployeEntity.getEmailID()).thenReturn("dsa");
		when(pvuEmployeEntity.getMobileNo()).thenReturn("123");
		when(pvuEmployeEntity.getPanNo()).thenReturn("123");
		when(pvuEmployeEntity.getOfficeId()).thenReturn(enti);
		when(enti.getOfficeName()).thenReturn("HOD");
		when(enti.getCardexno()).thenReturn(1l);
		when(enti.getDdoNo()).thenReturn("dsa");
		when(enti.getAddrLine1()).thenReturn("dsa");
		when(examRepo.findOneByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(department.getDateOfJoiningGOG()).thenReturn(new Date(2019 - 12 - 26));
		when(department.getDesignationId()).thenReturn(edEntity);

		when(edEntity.getDesignationName()).thenReturn("DSA");
		when(department.getDateOfRetirement()).thenReturn(new Date(2019 - 12 - 26));
		when(department.getEmpClass()).thenReturn(en);
		when(en.getLookUpInfoName()).thenReturn("dsa");
		when(department.getDistrictId()).thenReturn(edpMsDistrictEntity);

		when(edpMsDistrictEntity.getDistrictName()).thenReturn("FASD");
		when(department.getStation()).thenReturn("DSA");
		when(department.getTaluka()).thenReturn(talukaEntity);

		when(talukaEntity.getTalukaName()).thenReturn("dsa");

		pvuEmployeServiceImpl.getCommonResponseById(dto);

	}

	/**
	 * Test get emp by emp number.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	public void testGetEmpByEmpNumber() throws CustomException {
		when(pvuEmployeRepository.findByEmployeeCodeAndActiveStatus(1l,1)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeEntity.getEmployeeName()).thenReturn("Anshul");
		when(pvuEmployeEntity.getSalutation()).thenReturn(en);
		when(en.getLookUpInfoName()).thenReturn("dsa");
		when(pvuEmployeEntity.getEmployeeMiddleName()).thenReturn("ba");
		when(pvuEmployeEntity.getEmployeeSurname()).thenReturn("Batra");
		when(pvuEmployeEntity.getGender()).thenReturn(en);
		when(pvuEmployeEntity.getEmailID()).thenReturn("dsa");
		when(pvuEmployeEntity.getMobileNo()).thenReturn("123");
		when(pvuEmployeEntity.getPanNo()).thenReturn("123");
		when(pvuEmployeEntity.getOfficeId()).thenReturn(enti);
		when(enti.getOfficeName()).thenReturn("HOD");
		when(enti.getCardexno()).thenReturn(1l);
		when(enti.getDdoNo()).thenReturn("dsa");
		when(enti.getAddrLine1()).thenReturn("dsa");
		when(examRepo.findOneByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(department.getDateOfJoiningGOG()).thenReturn(new Date(2019 - 12 - 26));
		when(department.getDesignationId()).thenReturn(edEntity);

		when(edEntity.getDesignationName()).thenReturn("DSA");
		when(department.getDateOfRetirement()).thenReturn(new Date(2019 - 12 - 26));
		when(department.getEmpClass()).thenReturn(en);
		when(en.getLookUpInfoName()).thenReturn("dsa");
		when(department.getDistrictId()).thenReturn(edpMsDistrictEntity);

		when(edpMsDistrictEntity.getDistrictName()).thenReturn("FASD");
		when(department.getStation()).thenReturn("DSA");
		when(department.getTaluka()).thenReturn(talukaEntity);

		when(talukaEntity.getTalukaName()).thenReturn("dsa");

		pvuEmployeServiceImpl.getEmpByEmpNumber(1l);
	}

	/**
	 * Test get DDL lu look up info as map.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	public void testGetDDLLuLookUpInfoAsMap() throws CustomException {

		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(edpMsDesignationService.findactiveedpMsDesignation()).thenReturn(edpMsDesign);

		when(lst.addAll(pvuEmp)).thenReturn(true);
		/** Designations are removed from api response
		List<EDPMsDesignationEntity> findactiveedpMsDesignation = new ArrayList<>();

		findactiveedpMsDesignation.add(edEntity);
		when(edpMsDesignationService.findactiveedpMsDesignation()).thenReturn(findactiveedpMsDesignation);
		*/
		assertNotNull(pvuEmployeServiceImpl.getDDLLuLookUpInfoAsMap());
	}

	/**
	 * Gets the office type by edp id.
	 *
	 * @return the office type by edp id
	 * @throws CustomException the custom exception
	 */
	@Test
	//Do not enter inline method otherwise it will give exeption
	public void getOfficeTypeByEdpId() throws CustomException {
		when(edpLuLookUpInfoService.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(1l)).thenReturn(luLst);
		when(en.getLookUpInfoId()).thenReturn(1l);
		when(en.getLookUpInfoName()).thenReturn("DSA");
		when(pvuEmployeEntity.getOfficeId()).thenReturn(enti);
		assertNotNull(pvuEmployeServiceImpl.getOfficeTypeByEdpId(1l));

	}

	/**
	 * Gets the duplicate pan no detail.
	 *
	 * @return the duplicate pan no detail
	 * @throws CustomException the custom exception
	 */
	@Test
	//Do not enter inline method otherwise it will give exption
	public void getDuplicatePanNoDetail() throws CustomException {
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(en);
		when(pvuEmployeRepository.findByPanNoIgnoreCaseAndStatusIdLookUpInfoId("DSA", 0))
				.thenReturn(pvuEmployeEntityList);

		when(pvuEmployeEntityList.get(0)).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeEntity.getOfficeId()).thenReturn(enti);
		when(enti.getOfficeName()).thenReturn("Ssfd");
		when(enti.getCardexno()).thenReturn(1l);
		when(enti.getDdoNo()).thenReturn("Dsa");
		when(enti.getAddrLine1()).thenReturn("FSD");

		assertNotNull(pvuEmployeServiceImpl.getDuplicatePanNoDetail("DSA"));

	}

	/**
	 * Gets the auto employee number.
	 *
	 * @return the auto employee number
	 * @throws CustomException the custom exception
	 */
	@Test
	public void getAutoEmployeeNumber() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		assertNotNull(pvuEmployeServiceImpl.getAutoEmployeeNumber(pvuWFWrapperDto));
	}

	/**
	 * Insert employee itr.
	 *
	 * @throws CustomException the custom exception
	 */
	//Do not enter inline method otherwise it will give exption
	@Test
	public void insertEmployeeItr() throws CustomException {
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,"Approved")).thenReturn(empStatusLookupInfo1);
		when(empStatusLookupInfo1.getLookUpInfoId()).thenReturn(1l);
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(pvuEmployeRepository.findById(1l)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeEntity.getStatusId()).thenReturn(empStatusLookupInfo);
		when(empStatusLookupInfo.getLookUpInfoId()).thenReturn(2l);
		when(pvuEmployeRepository.findByEmpIdAndActiveStatus(1l, 1)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeEntity.getOfficeId()).thenReturn(enti);
		when(enti.getOfficeName()).thenReturn("Ssfd");
		when(enti.getCardexno()).thenReturn(1l);
		when(enti.getDdoNo()).thenReturn("Dsa");
		when(enti.getAddrLine1()).thenReturn("FSD");
		when(department.getDesignationId()).thenReturn(edpEntity);
		when(department.getDesignationId()).thenReturn(edpEntity);
		when(department.getDistrictId()).thenReturn(edpMsDistrictEntity);
		when(department.getStation()).thenReturn("FSD");
		when(department.getTaluka()).thenReturn(talukaEntity);
		when(department.getPayCommissionJoiningTime()).thenReturn(lookEntity);
		when(department.getHodName()).thenReturn(edpMsOfficeEntity);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		pvuEmployeServiceImpl.insertEmployeeItr(pvuWFWrapperDto);
	}

	/**
	 * Gets the employee WF history by emp id.
	 *
	 * @return the employee WF history by emp id
	 * @throws CustomException the custom exception
	 */
	@Test
	public void getEmployeeWFHistoryByEmpId() throws CustomException {
		assertNotNull(pvuEmployeServiceImpl.getEmployeeWFHistoryByEmpId(1l));
	}

	/**
	 * Save file and get document id.
	 */
	@Test
	public void saveFileAndGetDocumentId() {
		assertNotNull(pvuEmployeServiceImpl.saveFileAndGetDocumentId(att, 1));
	}

	/**
	 * Validate pan number.
	 *
	 * @throws CustomException the custom exception
	 */
	//Do not enter inline method otherwise it will give exption
	@Test
	public void validatePanNumber() throws CustomException {
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(empStatusLookupInfo);
		when(empStatusLookupInfo.getLookUpInfoId()).thenReturn(1l);
		when(pvuEmployeRepository.findByPanNoIgnoreCaseAndStatusIdLookUpInfoId("s", 1l))
				.thenReturn(pvuEmployeEntityList);
		assertNotNull(pvuEmployeServiceImpl.validatePanNumber("s"));
	}
	

	@Test
	void getEntryPaySearchEmployes() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("deptCatId", " "));
		jsonArr.add(new SearchParam("payBandId", ""));
		jsonArr.add(new SearchParam("gradPayId", ""));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		IdDto d = new IdDto();
		List<IdDto> lst = new ArrayList<IdDto>();
		d.setId(1l);
		lst.add(d);
		CurrentUserUserId();
		assertNotNull(pvuEmployeServiceImpl.getEntryPaySearchEmployes(pageDetail));

	}
	
	
	@Test
	void testGetHistoryOfEmpAddressByEmpId() throws CustomException{
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpAddressByEmpId(idDtod,sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(pvuEmployeServiceImpl.getHistoryOfEmpAddressByEmpId(idDtod));
	}
	
	@Test
	void testGetHistoryOfEmpNominiByEmpId() throws CustomException{
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpAddressByEmpId(idDtod,sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(pvuEmployeServiceImpl.getHistoryOfEmpNominiByEmpId(idDtod));
	}
	
	
	@Test
	void testGetHistoryOfEmpDetailsByItrTabel() throws CustomException{
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpAddressByEmpId(idDtod,sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(pvuEmployeServiceImpl.getHistoryOfEmpDetailsByItrTabel(idDtod));
	}


	@Test
	void testEmployeUpdateAllfiled() throws CustomException{
		EmployeeChangeType type =new EmployeeChangeType();
		type.setEmpRole(1);
		type.setEmpNomitype(1);
		type.setEmpAddtype(1);
		type.setEmpId(1);
		PVUEmpDeptQualifiUpdate empUpdate = new  PVUEmpDeptQualifiUpdate();
		PVUEmployeeQualificationUpdateDtos q = new PVUEmployeeQualificationUpdateDtos();
		PVUEmployeDepartmentUpdateDtos d = new PVUEmployeDepartmentUpdateDtos();
		PVUEmployeDto eDto = new PVUEmployeDto();
		eDto.setEmpId(1L);
		eDto.setChangeType(1L);
		empUpdate.setQualificationDto(q);
		empUpdate.setDepartmentDto(d);
		empUpdate.setPvuEmployeDto(eDto);
		when(pvuEmployeRepository.findByEmpIdAndActiveStatus(1l, 1)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(deptExamDetailsService.editEmployeQualification(q, type)).thenReturn(q);
		when(pvuEmployeDepartmentService.editEmployeeDepartment(d,type)).thenReturn(d);
		when(attachmentService.createPostAttachment(masterDto)).thenReturn(uploadAttachment);
		when(dt.getDocumentId()).thenReturn("123");
		when(dt.getFilename()).thenReturn("123");
		when(pvuEmployeAddressDto.getEmpId()).thenReturn(1l);
		when(pvuEmployeAddressDto.getChangeType()).thenReturn(1l);
		when(pvuEmployeAddressConverter.toEntity(pvuEmployeAddressDto)).thenReturn(pvuEmployeAddressEntity);
		when(pvuEmployeAddressRepository.save(pvuEmployeAddressEntity)).thenReturn(pvuEmployeAddressEntity);
		List<PVUEmployeNomineeDto> nomineeList = new ArrayList<PVUEmployeNomineeDto>();
		nomineeList.add(pvuEmployeNomineeDto);
		when(pvuEmployeNomineeDto.getEmpId()).thenReturn(1l);
		when(pvuEmployeNomineeDto.getChangeType()).thenReturn(1l);
		when(empNomineeConverter.toEntity(pvuEmployeNomineeDto)).thenReturn(pvuEmployeNomineeEntity);
		when(empNomineeRepository.save(pvuEmployeNomineeEntity)).thenReturn(pvuEmployeNomineeEntity);
		when(pvuEmployeNomineeDto.getGenNomineePhotoAttachment()).thenReturn(masterDto);
		when(masterDto.getAttachment()).thenReturn(mPart);
		when(pvuEmployeNomineeEntity.getEmpNomineeId()).thenReturn(1l);
		when(pvuEmployeNomineeDto.getNomineePhotoAttachment()).thenReturn(masterDto);
		when(pvuEmployeNomineeDto.getNpsNomineePhotoAttachment()).thenReturn(masterDto);
		empUpdate.setPvuEmployeAddressDto(pvuEmployeAddressDto);
		nomineeList.add(pvuEmployeNomineeDto);
		empUpdate.setPvuEmployeNomineeDto(nomineeList);
		assertNotNull(pvuEmployeServiceImpl.employeUpdateAllfiled(empUpdate));
	}

	@Test
	void testGetOfficeNameByOfficeType() throws CustomException{
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getOfficeNameByOfficeType(idDtod,sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(pvuEmployeServiceImpl.getOfficeNameByOfficeType(idDtod));
	}


	//Do not enter inline method otherwise it will give exption
	@Test
	void testValidateAndSetNomineeDetailsForEditEmployee() throws CustomException{
		PVUEmployeNomineeDto nomineeDto = new PVUEmployeNomineeDto();

		AttachmentMasterDto attDto = new AttachmentMasterDto();
		attDto.setChangeType(3l);

		nomineeDto.setGenNomineePhotoAttachment(attDto);
		pvuEmployeServiceImpl.validateAndSetNomineeDetailsForEditEmployee(nomineeDto,pvuEmployeNomineeEntity);

		nomineeDto.setChangeType(3l);
		nomineeDto.setNpsNomineePhotoAttachment(attDto);
		pvuEmployeServiceImpl.validateAndSetNomineeDetailsForEditEmployee(nomineeDto,pvuEmployeNomineeEntity);

		nomineeDto.setChangeType(3l);
		nomineeDto.setNomineePhotoAttachment(attDto);
		pvuEmployeServiceImpl.validateAndSetNomineeDetailsForEditEmployee(nomineeDto,pvuEmployeNomineeEntity);


		AttachmentMasterDto attDto1 = new AttachmentMasterDto();
		attDto1.setAttachment(mPart);
		nomineeDto.setNomineePhotoAttachment(attDto1);
		pvuEmployeServiceImpl.validateAndSetNomineeDetailsForEditEmployee(nomineeDto,pvuEmployeNomineeEntity);

		attDto1.setAttachment(mPart);
		nomineeDto.setNpsNomineePhotoAttachment(attDto1);
		pvuEmployeServiceImpl.validateAndSetNomineeDetailsForEditEmployee(nomineeDto,pvuEmployeNomineeEntity);

		attDto1.setAttachment(mPart);
		nomineeDto.setGenNomineePhotoAttachment(attDto1);
		pvuEmployeServiceImpl.validateAndSetNomineeDetailsForEditEmployee(nomineeDto,pvuEmployeNomineeEntity);

	}

	//Do not enter inline method otherwise it will give exption
	@Test
	void testEditabelEmploye() throws CustomException{

		PVUEmpDeptQualifiUpdate dto = new PVUEmpDeptQualifiUpdate();
		EmployeeChangeType type = new EmployeeChangeType();
		type.setEmpRole(1);
		type.setEmpNomitype(1);
		type.setEmpAddtype(1);
		type.setEmpId(1);
		PVUEmployeDto empD = new PVUEmployeDto();
		empD.setEmpId(1l);
		empD.setChangeType(1l);
		when(pvuEmployeRepository.findByEmpIdAndActiveStatus(1l, 1)).thenReturn(Optional.of(pvuEmployeEntity));
		List<AttachmentMasterDto> attachList = new ArrayList<>();
		AttachmentMasterDto attachDto = new AttachmentMasterDto();
		attachDto.setMenuId(1l);
		attachDto.setAttachment(mPart);
		attachList.add(attachDto);
		empD.setPhotoAttachment(attachList);
		dto.setPvuEmployeDto(empD);
		pvuEmployeServiceImpl.editabelEmploye(dto,type);


		List<AttachmentMasterDto> attachList1 = new ArrayList<>();
		attachDto.setMenuId(1l);
		attachDto.setAttachment(null);
		attachDto.setChangeType(3l);
		attachList1.add(attachDto);
		empD.setPhotoAttachment(attachList1);
		dto.setPvuEmployeDto(empD);
		pvuEmployeServiceImpl.editabelEmploye(dto,type);

		List<AttachmentMasterDto> attachList3 = new ArrayList<>();
		attachDto.setMenuId(1l);
		attachDto.setAttachment(null);
		attachDto.setChangeType(0l);
		attachList3.add(attachDto);
		empD.setPhotoAttachment(attachList);
		dto.setPvuEmployeDto(empD);
		PVUEmployeAddressDto addressDto = new PVUEmployeAddressDto();
		addressDto.setChangeType(1l);
		addressDto.setEmpAddressId(1l);
		when(pvuEmployeAddressRepository.findPVUEmployeAddressEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1)).thenReturn(pvuEmployeAddressEntity);
		dto.setPvuEmployeAddressDto(addressDto);
		List<PVUEmployeNomineeDto> nomlist =new ArrayList<>();
		PVUEmployeNomineeDto nomineeDto = new PVUEmployeNomineeDto();
		nomineeDto.setEmpNomineeId(1l);
		nomineeDto.setChangeType(1);
		PVUEmployeNomineeDto nomineeDto1 = new PVUEmployeNomineeDto();
		PVUEmployeNomineeDto nomineeDtoNew = new PVUEmployeNomineeDto();
		nomineeDtoNew.setChangeType(2);
		when(empNomineeRepository.findOneByEmpNomineeIdAndActiveStatus(1l, 1)).thenReturn(Optional.of(pvuEmployeNomineeEntity));
		nomlist.add(nomineeDto);
		nomlist.add(nomineeDto1);
		nomlist.add(nomineeDtoNew);
		dto.setPvuEmployeNomineeDto(nomlist);
		pvuEmployeServiceImpl.editabelEmploye(dto,type);
	}


	@Test
	public void testDeleteEmployeePhotoByEmpId() {
		when(pvuEmployeRepository.findByEmpIdAndActiveStatus(1l, 1)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeEntity.getEmployeePhoto()).thenReturn("Photo");
		pvuEmployeServiceImpl.deleteEmployeePhotoByEmpId(1l);

	}



	@Test
	public void testgetEmpByEmpNo() throws CustomException {
		when(searchDto.getId()).thenReturn(1l);
		when(pvuEmployeRepository.findByEmployeeCodeAndActiveStatus(1l,1)).thenReturn(Optional.of(pvuEmployeEntity));
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeEntity.getEmployeeName()).thenReturn("test");

		when(pvuEmployeEntity.getOfficeId()).thenReturn(enti);
		when(enti.getOfficeName()).thenReturn("HOD");
		when(enti.getCardexno()).thenReturn(1l);
		when(enti.getDdoNo()).thenReturn("dsa");
		when(enti.getAddrLine1()).thenReturn("dsa");
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(department.getEmpPayType()).thenReturn(lookEntity);
		when(department.getDistrictId()).thenReturn(edpMsDistrictEntity);
		when(lookEntity.getLookUpInfoName()).thenReturn("test");
		pvuEmployeServiceImpl.getEmpByEmpNo(searchDto);

	}

	//Do not enter inline method otherwise it will give exption
	@Test
	void testdeleteNomineeAttachementsByNomineeId(){
		PvuCommonRequest pvuCommonRequest =  new PvuCommonRequest();
		Map<String, Long> nomineeData = new HashMap<>();
		nomineeData.put("trnId", 1l);
		pvuCommonRequest.setRequest(nomineeData);
		PVUEmployeNomineeDto nomineeDto = new PVUEmployeNomineeDto();
		AttachmentMasterDto attDto = new AttachmentMasterDto();
		when(empNomineeRepository.findOneByEmpNomineeIdAndActiveStatus(1l, 1)).thenReturn(Optional.of(pvuEmployeNomineeEntity));
		attDto.setChangeType(3l);
		nomineeData.put("GEN" , 1l);
		nomineeDto.setGenNomineePhotoAttachment(attDto);
		pvuEmployeServiceImpl.deleteNomineeAttachementsByNomineeId(pvuCommonRequest);


		nomineeData.remove("GEN");
		nomineeData.put("PHOTO" , 1l);
		nomineeDto.setChangeType(3l);
		nomineeDto.setNpsNomineePhotoAttachment(attDto);
		pvuEmployeServiceImpl.deleteNomineeAttachementsByNomineeId(pvuCommonRequest);


		nomineeData.remove("PHOTO");
		nomineeData.put("NPS" , 1l);
		nomineeDto.setChangeType(3l);
		nomineeDto.setNomineePhotoAttachment(attDto);
		pvuEmployeServiceImpl.deleteNomineeAttachementsByNomineeId(pvuCommonRequest);
	}


	@Test
	//Do not enter inline method otherwise it will give exption
	public void testupdateActiveStatusByEmpId() {
		when(pvuEmployeRepository.updateActiveStatusByEmpId(1l, 1, 1, new Date(0))).thenReturn(1);
		pvuEmployeServiceImpl.updateActiveStatusByEmpId(1l, 1);
	}



}

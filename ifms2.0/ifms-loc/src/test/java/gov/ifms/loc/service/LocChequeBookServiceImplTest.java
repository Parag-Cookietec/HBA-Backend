package gov.ifms.loc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.converter.LocChequeBookHdrConverter;
import gov.ifms.loc.converter.LocChequeBookSdConverter;
import gov.ifms.loc.dto.LocChequeBookHdrDto;
import gov.ifms.loc.dto.LocChequeBookSdDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocChqDtlDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocChequeBookDtlEntity;
import gov.ifms.loc.entity.LocChequeBookHdrEntity;
import gov.ifms.loc.entity.LocChequeBookSdEntity;
import gov.ifms.loc.entity.LocChequeBookWfEntity;
import gov.ifms.loc.entity.LocMsDivisonEntity;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.repository.LocChequeBookDtlRepository;
import gov.ifms.loc.repository.LocChequeBookHdrRepository;
import gov.ifms.loc.repository.LocChequeBookSdRepository;
import gov.ifms.loc.repository.LocChequeBookWfRepository;
import gov.ifms.loc.serviceimpl.LocChequeBookServiceImpl;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocChequeBookServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class LocChequeBookServiceImplTest {

	/**
	 * The service.
	 */
	@InjectMocks
	private LocChequeBookServiceImpl service;

	/**
	 * The hdr repo.
	 */
	@Mock
	private LocChequeBookHdrRepository hdrRepo;

	/**
	 * The hdr entity.
	 */
	@Mock
	private LocChequeBookHdrEntity hdrEntity;

	/**
	 * The sd entity.
	 */
	@Mock
	private LocChequeBookSdEntity sdEntity;

	/**
	 * The hdr dto.
	 */
	@Mock
	private LocChequeBookHdrDto hdrDto;

	/**
	 * The hdr converter.
	 */
	@Mock
	private LocChequeBookHdrConverter hdrConverter;

	/**
	 * The sd converter.
	 */
	@Mock
	private LocChequeBookSdConverter sdConverter;

	/**
	 * The wf repo.
	 */
	@Mock
	private LocChequeBookWfRepository wfRepo;

	/**
	 * The edit view dto.
	 */
	@Mock
	private LocChqBookEditViewDto editViewDto;

	/**
	 * The wf entity.
	 */
	@Mock
	private LocChequeBookWfEntity wfEntity;

	/**
	 * The wf user dto.
	 */
	@Mock
	private WfUserReqSDDto wfUserDto;

	/**
	 * The sd dto.
	 */
	@Mock
	private LocChequeBookSdDto sdDto;

	/**
	 * The sd repo.
	 */
	@Mock
	private LocChequeBookSdRepository sdRepo;

	/**
	 * The loc wf action config service.
	 */
	@Mock
	private LocWfActionConfigService locWfActionConfigService;

	/**
	 * The wf save dto.
	 */
	@Mock
	private LocSubmitWfDto wfSaveDto;

	/**
	 * The chq dtl dto.
	 */
	@Mock
	private LocChqDtlDto chqDtlDto;

	/**
	 * The dtl repo.
	 */
	@Mock
	private LocChequeBookDtlRepository dtlRepo;

	/**
	 * The dtl entity.
	 */
	@Mock
	private LocChequeBookDtlEntity dtlEntity;

	/**
	 * The pg detail.
	 */
	@Mock
	private PageDetails pgDetail;

	/**
	 * The search param.
	 */
	@Mock
	private SearchParam searchParam;

	/**
	 * The lu look up info repository.
	 */
	@Mock
	private EDPLuLookUpInfoRepository luLookUpInfoRepository;

	/**
	 * The e DP lu look up info entity.
	 */
	@Mock
	private EDPLuLookUpInfoEntity eDPLuLookUpInfoEntity;

	/**
	 * The div entity.
	 */
	@Mock
	private LocMsDivisonEntity divEntity;

	/**
	 * The bank entity.
	 */
	@Mock
	private EDPMsBankIfscEntity bankEntity;

	/**
	 * The id dto.
	 */
	@Mock
	private IdDto idDto;

	/** The look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Mock
	LocNotificationService notificationService;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get search param.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSearchParam() throws CustomException {
		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getSearchParam()).thenReturn(objects);
		assertNotNull(service.getSearchParam());
		when(hdrRepo.getSearchParam()).thenReturn(Collections.emptyList());
		assertNotNull(service.getSearchParam());
	}

	/**
	 * Testsave draft.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testsaveDraft() throws CustomException {
		List<WfUserReqSDDto> wfList = new ArrayList<>();
		List<Long> longList = new ArrayList<>();
		wfList.add(wfUserDto);
		List<LocChequeBookSdDto> sdDtoList = new ArrayList<>();
		sdDtoList.add(sdDto);
		when(hdrConverter.toEntity(hdrDto)).thenReturn(hdrEntity);
		when(hdrRepo.save(hdrEntity)).thenReturn(hdrEntity);
		when(hdrEntity.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrDto.getChequeBookSdDto()).thenReturn(sdDtoList);
		when(sdConverter.toEntity(sdDto)).thenReturn(sdEntity);
		when(sdRepo.save(sdEntity)).thenReturn(sdEntity);
		when(wfRepo.findByTrnIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(null);
		when(hdrDto.getWfUserReqDto()).thenReturn(wfList);
		when(locWfActionConfigService.saveWfActConfigTrn(wfUserDto)).thenReturn(1);
		when(hdrEntity.getDivId()).thenReturn(divEntity);
		when(divEntity.getDivCode()).thenReturn(JunitConstants.STRING_ABC);
		when(divEntity.getDivisionName()).thenReturn(JunitConstants.STRING_ABC);
		when(hdrEntity.getBankBranchId()).thenReturn(bankEntity);
		when(bankEntity.getBankName()).thenReturn(JunitConstants.STRING_ABC);
		testgetEditViewView();
		when(sdDto.getStartSeries()).thenReturn(JunitConstants.STRING_ABC);
		when(sdDto.getIsActive()).thenReturn(LocConstant.CHQ_IS_INACTIVE);
		when(hdrRepo.uesdChequeAdvicePrepTest(Mockito.anyString())).thenReturn(longList);
		when(hdrRepo.uesdChequeChqToChqTest(Mockito.anyString())).thenReturn(longList);
		assertNotNull(service.saveDraft(hdrDto));
		when(wfRepo.findByTrnIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(wfEntity);
		testgetEditViewView();
		assertNotNull(service.saveDraft(hdrDto));

	}

	/**
	 * Test submit data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmitData() throws CustomException {

		when(hdrRepo.findByIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(Optional.of(hdrEntity));
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyLong())).thenReturn(eDPLuLookUpInfoEntity);
		when(wfSaveDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getTrnStatus()).thenReturn(JunitConstants.STRING_ABC);
		when(wfSaveDto.getWfId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getAssignByWfRoleId()).thenReturn(JunitConstants.LONG_TYPE);
		service.submitData(wfSaveDto);
	}

	/**
	 * Test get cheque book data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetChequeBookData() throws CustomException {
		Object[] object = new Object[6];
		object[0] = JunitConstants.STRING_ABC;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		Object[] lookUpObject = new Object[2];
		lookUpObject[0] = JunitConstants.LONG_TYPE;
		lookUpObject[1] = JunitConstants.STRING_ABC;
		List<Object[]> lookUpObjects = new ArrayList<>();
		lookUpObjects.add(lookUpObject);
		when(chqDtlDto.getDeptId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqDtlDto.getCardexNo()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqDtlDto.getDdoNo()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqDtlDto.getOfficeNameId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.getChequeBookData(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(objects);
		when(hdrRepo.getLookupIdandName(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(lookUpObjects);
		assertNotNull(service.getChequeBookData(chqDtlDto));
	}

	/**
	 * Testget cheque book list req act.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testgetChequeBookListReqAct() throws CustomException {

		Object[] object = new Object[3];
		object[0] = JunitConstants.DATE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		Object[] chqObject = new Object[5];
		chqObject[0] = JunitConstants.DATE;
		chqObject[1] = JunitConstants.STRING_TYPE;
		chqObject[2] = JunitConstants.STRING_TYPE;
		chqObject[3] = JunitConstants.DATE;
		chqObject[4] = JunitConstants.DATE;
		List<Object[]> chqObjects = new ArrayList<>();
		chqObjects.add(chqObject);

		when(chqDtlDto.getReqTypeId()).thenReturn(JunitConstants.REQUEST_TYPE_ACTIVATE);
		when(chqDtlDto.getBankAccNo()).thenReturn(JunitConstants.STRING_ABC);
		when(chqDtlDto.getDivId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqDtlDto.getBankId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqDtlDto.getChequeTypeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.getChequeBookList(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn(objects);
		when(hdrRepo.getChqBookActInactList(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyString())).thenReturn(chqObjects);
		assertNotNull(service.getChequeBookList(chqDtlDto));
	}

	/**
	 * Testget cheque book list req inac.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testgetChequeBookListReqInac() throws CustomException {

		Object[] chqObject = new Object[5];
		chqObject[0] = JunitConstants.DATE;
		chqObject[1] = JunitConstants.STRING_TYPE;
		chqObject[2] = JunitConstants.STRING_TYPE;
		chqObject[3] = JunitConstants.DATE;
		chqObject[4] = JunitConstants.DATE;
		List<Object[]> chqObjects = new ArrayList<>();
		chqObjects.add(chqObject);

		when(chqDtlDto.getReqTypeId()).thenReturn(JunitConstants.REQUEST_TYPE_INACTIVATE);
		when(chqDtlDto.getBankAccNo()).thenReturn(JunitConstants.STRING_ABC);
		when(chqDtlDto.getDivId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqDtlDto.getBankId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqDtlDto.getChequeTypeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.getChqBookActInactList(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyString())).thenReturn(chqObjects);
		assertNotNull(service.getChequeBookList(chqDtlDto));
	}

	/**
	 * Testget edit view view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testgetEditViewView() throws CustomException {
		List<LocChequeBookDtlEntity> dtlEntityList = new ArrayList<>();
		dtlEntityList.add(dtlEntity);
		List<LocChequeBookSdDto> sdDtoList = new ArrayList<>();
		LocChequeBookSdDto sdDto1 = new LocChequeBookSdDto();
		sdDto1.setIsActive(LocConstant.CHQ_IS_ACTIVE);
		sdDto1.setInActiveDate(new Date());
		LocChequeBookSdDto sdDto2 = new LocChequeBookSdDto();
		sdDto2.setIsActive(LocConstant.CHQ_IS_INACTIVE);
		sdDto2.setInActiveDate(new Date());
		LocChequeBookSdDto sdDto3 = new LocChequeBookSdDto();
		sdDto3.setIsActive(null);
		sdDtoList.add(sdDto1);
		sdDtoList.add(sdDto2);
		sdDtoList.add(sdDto3);
		when(hdrRepo.findByActiveStatusAndId(Mockito.anyInt(), Mockito.anyLong())).thenReturn(hdrEntity);
		when(hdrConverter.toDTO(hdrEntity)).thenReturn(hdrDto);
		when(hdrEntity.getDivId()).thenReturn(divEntity);
		when(divEntity.getDivCode()).thenReturn(JunitConstants.STRING_ABC);
		when(divEntity.getDivisionName()).thenReturn(JunitConstants.STRING_ABC);
		when(hdrEntity.getBankBranchId()).thenReturn(bankEntity);
		when(bankEntity.getBankName()).thenReturn(JunitConstants.STRING_ABC);
		when(hdrDto.getChequeTypeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrDto.getReqTypeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(luLookUpInfoRepository.findBylookUpInfoId(Mockito.anyLong())).thenReturn(eDPLuLookUpInfoEntity);
		when(eDPLuLookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_ABC);
		when(editViewDto.getActionStatus()).thenReturn(0);
		when(dtlRepo.findByHdrIdIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(dtlEntityList);
		when(sdConverter.dtltoSdDTO(dtlEntityList)).thenReturn(sdDtoList);
		assertNotNull(service.getEditView(editViewDto));
	}

	/**
	 * Test get listing data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetListingData() throws CustomException {
		when(pgDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pgDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);

		when(searchParam.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(searchParam.getValue()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(service.getListingData(pgDetail));
		List<SearchParam> srchParam = new ArrayList<>();
		srchParam.add(searchParam);
		when(pgDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(service.getListingData(pgDetail));
	}

	/**
	 * Test get header info.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetHeaderInfo() throws CustomException {

		Object[] chqObject = new Object[8];
		chqObject[0] = JunitConstants.STRING_TYPE;
		chqObject[1] = JunitConstants.STRING_TYPE;
		chqObject[2] = JunitConstants.STRING_TYPE;
		chqObject[3] = JunitConstants.STRING_TYPE;
		chqObject[4] = JunitConstants.STRING_TYPE;
		chqObject[5] = JunitConstants.STRING_TYPE;
		chqObject[6] = JunitConstants.STRING_TYPE;
		chqObject[7] = JunitConstants.DATE;
		List<Object[]> object = new ArrayList<>();
		object.add(chqObject);
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.getHeaderInfo(Mockito.anyLong(), Mockito.anyInt())).thenReturn(object);
		assertNotNull(service.getHeaderInfo(idDto));
	}

	/**
	 * Test delete by id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteById() throws CustomException {
		List<LocChequeBookSdEntity> sdLst = new ArrayList<LocChequeBookSdEntity>();
		sdLst.add(sdEntity);
		when(hdrRepo.findByActiveStatusAndId(Mockito.anyInt(), Mockito.anyLong())).thenReturn(hdrEntity);
		when(sdRepo.findByHdrIdId(Mockito.anyLong())).thenReturn(sdLst);
		assertNotNull(service.deleteById(idDto));
	}

	/**
	 * Testget edit view view 2.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testgetEditViewView2() throws CustomException {
		Object[] obj = new Object[12];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.LONG_TYPE;
		obj[2] = JunitConstants.LONG_TYPE;
		obj[3] = JunitConstants.LONG_TYPE;
		obj[4] = JunitConstants.DATE;
		obj[5] = JunitConstants.STRING_ABC;
		obj[6] = JunitConstants.STRING_ABC;
		obj[7] = JunitConstants.STRING_ABC;
		obj[8] = JunitConstants.DATE;
		obj[9] = JunitConstants.DATE;
		obj[10] = JunitConstants.LONG_TYPE;
		obj[11] = JunitConstants.DATE;
		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		List<LocChequeBookDtlEntity> dtlEntityList = new ArrayList<>();
		dtlEntityList.add(dtlEntity);
		List<LocChequeBookSdDto> sdDtoList = new ArrayList<>();
		LocChequeBookSdDto sdDto1 = new LocChequeBookSdDto();
		sdDto1.setIsActive(LocConstant.CHQ_IS_ACTIVE);
		sdDto1.setInActiveDate(new Date());
		LocChequeBookSdDto sdDto2 = new LocChequeBookSdDto();
		sdDto2.setIsActive(LocConstant.CHQ_IS_INACTIVE);
		sdDto2.setInActiveDate(new Date());
		LocChequeBookSdDto sdDto3 = new LocChequeBookSdDto();
		sdDto3.setIsActive(null);
		sdDtoList.add(sdDto1);
		sdDtoList.add(sdDto2);
		sdDtoList.add(sdDto3);
		when(hdrRepo.findByActiveStatusAndId(Mockito.anyInt(), Mockito.anyLong())).thenReturn(hdrEntity);
		when(hdrConverter.toDTO(hdrEntity)).thenReturn(hdrDto);
		when(hdrEntity.getDivId()).thenReturn(divEntity);
		when(divEntity.getDivCode()).thenReturn(JunitConstants.STRING_ABC);
		when(divEntity.getDivisionName()).thenReturn(JunitConstants.STRING_ABC);
		when(hdrEntity.getBankBranchId()).thenReturn(bankEntity);
		when(bankEntity.getBankName()).thenReturn(JunitConstants.STRING_ABC);
		when(hdrDto.getChequeTypeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrDto.getReqTypeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(luLookUpInfoRepository.findBylookUpInfoId(Mockito.anyLong())).thenReturn(eDPLuLookUpInfoEntity);
		when(eDPLuLookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_ABC);
		when(editViewDto.getActionStatus()).thenReturn(0);
		when(dtlRepo.findByHdrIdIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(dtlEntityList);
		when(hdrRepo.getDtlData(Mockito.anyLong(), Mockito.anyInt())).thenReturn(objList);

		when(sdConverter.dtltoSdDTO(dtlEntityList)).thenReturn(sdDtoList);
		assertNotNull(service.getEditView(editViewDto));
	}

	/**
	 * Test submit data 2.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmitData2() throws CustomException {
		List<LocChequeBookDtlEntity> dtlEntityList = new ArrayList<LocChequeBookDtlEntity>();
		dtlEntityList.add(dtlEntity);
		List<LocChequeBookSdEntity> sdEntityList = new ArrayList<LocChequeBookSdEntity>();
		sdEntityList.add(sdEntity);
		List<Long> longList = new ArrayList<Long>();
		longList.add(JunitConstants.LONG_TYPE);

		when(hdrRepo.findByIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(Optional.of(hdrEntity));
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyLong())).thenReturn(eDPLuLookUpInfoEntity);
		when(wfSaveDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getTrnStatus()).thenReturn(JunitConstants.STRING_ABC);
		when(wfSaveDto.getWfId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getAssignByWfRoleId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getTrnStatus()).thenReturn(LocConstant.AUTHORIZED);
		when(dtlRepo.findByHdrIdIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(dtlEntityList);
		when(sdRepo.findByHdrIdIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(sdEntityList);
		when(dtlEntity.getIsActive()).thenReturn(LocConstant.CHQ_IS_ACTIVE);
		when(sdEntity.getIsActive()).thenReturn(LocConstant.CHQ_IS_ACTIVE);
		when(hdrRepo.getOldHdrId(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyString())).thenReturn(longList);
		when(dtlRepo.findByIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(dtlEntity);
		when(dtlEntity.getFlag()).thenReturn(LocConstant.LONG_ZERO);
		service.submitData(wfSaveDto);
		when(dtlEntity.getIsActive()).thenReturn(LocConstant.CHQ_IS_INACTIVE);
		when(sdEntity.getIsActive()).thenReturn(LocConstant.CHQ_IS_INACTIVE);
		when(dtlEntity.getFlag()).thenReturn(LocConstant.LONG_ONE);
		service.submitData(wfSaveDto);
	}
}

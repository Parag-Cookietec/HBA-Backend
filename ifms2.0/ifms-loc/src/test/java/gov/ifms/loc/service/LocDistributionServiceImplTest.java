package gov.ifms.loc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.converter.LocDistributionHeadDtlConverter;
import gov.ifms.loc.dto.LocDistributionHdrDto;
import gov.ifms.loc.dto.LocDistributionHdrViewDto;
import gov.ifms.loc.dto.LocDistributionHeadDtlDto;
import gov.ifms.loc.dto.LocDistributionSrchParamDto;
import gov.ifms.loc.dto.LocDistributionSubmitDto;
import gov.ifms.loc.entity.LocDistributionHdrEntity;
import gov.ifms.loc.entity.LocDistributionHeadDtlEntity;
import gov.ifms.loc.entity.LocMsDemandEntity;
import gov.ifms.loc.entity.LocMsDetailHeadEntity;
import gov.ifms.loc.entity.LocMsMajorHeadEntity;
import gov.ifms.loc.entity.LocMsMinorHeadEntity;
import gov.ifms.loc.entity.LocMsSubHeadEntity;
import gov.ifms.loc.entity.LocMsSubMajorHeadEntity;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.repository.LocDistributionHdrRepository;
import gov.ifms.loc.repository.LocDistributionHeadDtlRepository;
import gov.ifms.loc.repository.LocDistributionWfRepository;
import gov.ifms.loc.repository.LocMsOfficeRepository;
import gov.ifms.loc.serviceimpl.LocDistributionServiceImpl;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.util.LocURLConstant;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocDistributionServiceImplTest.
 */

@TestInstance(Lifecycle.PER_CLASS)
public class LocDistributionServiceImplTest {

	/**
	 * The service impl.
	 */
	@InjectMocks
	private LocDistributionServiceImpl service;

	/**
	 * The page detail.
	 */
	@Mock
	private PageDetails pageDetail;
	/**
	 * The hdr repo.
	 */
	@Mock
	private LocDistributionHdrRepository hdrRepo;

	/**
	 * The hdr entity.
	 */
	@Mock
	private LocDistributionHdrEntity hdrEntity;

	/**
	 * The id dto.
	 */
	@Mock
	private IdDto idDto;

	/**
	 * The office repo.
	 */
	@Mock
	private LocMsOfficeRepository officeRepo;

	/**
	 * The WF repo.
	 */
	@Mock
	private LocDistributionWfRepository wfRepo;

	/**
	 * The HeadDtl Convertor.
	 */
	@Mock
	private LocDistributionHeadDtlConverter dtlConvertor;

	/**
	 * The DtO Convertor.
	 */
	@Mock
	private LocDistributionHdrDto locDistributionHdrDto;

	/**
	 * The DtO Convertor.
	 */
	@Mock
	private LocDistributionHeadDtlRepository dtlRepo;

	/**
	 * The look up info repository.
	 */
	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The look up entity.
	 */
	@Mock
	private EDPLuLookUpInfoEntity lookUpEntity;

	/**
	 * The HeadDtlDto .
	 */
	@Mock
	private LocDistributionHeadDtlDto locDistributionHeadDtlDto;

	/**
	 * The SrchParamDto.
	 */
	@Mock
	private LocDistributionSrchParamDto locDistributionSrchParamDto;

	/**
	 * The wfUserReqSDDto.
	 */
	@Mock
	private WfUserReqSDDto wfUserReqSDDto;

	/**
	 * The submitwf dto.
	 */
	@Mock
	private LocDistributionSubmitDto submitwfDto;

	/**
	 * The wf action service.
	 */
	@Mock
	private LocWfActionConfigService wfActionService;

	@Mock
	private Map<String, Object> map;

	@Mock
	private LocMsDetailHeadEntity dtlHeadEntity;

	@Mock
	private LocMsSubHeadEntity subHeadEntity;

	@Mock
	private LocMsMinorHeadEntity minorHeadEntity;

	@Mock
	private LocMsSubMajorHeadEntity subMajorHeadEntity;

	@Mock
	private LocMsMajorHeadEntity majorHeadEntity;

	@Mock
	private LocMsDemandEntity demandEntity;
	@Mock
	private LocDistributionHeadDtlEntity dtlEntity;

	@Mock
	private LocPDFService pdfService;

	@Mock
	private LocDistributionHdrViewDto hdrViewDto;

	@Mock
	private LocNotificationService notificationService;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get search param.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSearchParam() throws CustomException {
		Object[] chqObject = new Object[13];
		chqObject[0] = JunitConstants.STRING_TYPE;
		chqObject[1] = JunitConstants.LONG_TYPE;
		chqObject[2] = JunitConstants.STRING_TYPE;
		chqObject[3] = JunitConstants.STRING_TYPE;
		chqObject[4] = JunitConstants.LONG_TYPE;
		chqObject[5] = JunitConstants.STRING_TYPE;
		chqObject[6] = JunitConstants.STRING_TYPE;
		chqObject[7] = JunitConstants.LONG_TYPE;
		chqObject[8] = JunitConstants.STRING_TYPE;
		chqObject[9] = JunitConstants.STRING_TYPE;
		chqObject[10] = JunitConstants.LONG_TYPE;
		chqObject[11] = JunitConstants.STRING_TYPE;
		chqObject[12] = JunitConstants.STRING_TYPE;
		List<Object[]> objectList = new ArrayList<>();
		objectList.add(chqObject);
		when(hdrRepo.getSrchParam()).thenReturn(objectList);
		assertNotNull(service.getSearchParam());

	}

	/**
	 * Test submit.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmit() throws CustomException {

		Object[] obj = new Object[1];
		obj[0] = JunitConstants.STRING_ABC;
		List<Object[]> objList = new ArrayList<Object[]>();
		objList.add(obj);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objList);
		when(hdrRepo.findByIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(hdrEntity);
		when(wfRepo.findByTrnIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(null);
		when(hdrRepo.updateLocDistribution(JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.DATE,
				JunitConstants.STRING_ABC, new Date(), JunitConstants.STRING_ABC, JunitConstants.STRING_ABC,
				JunitConstants.STRING_ABC, JunitConstants.DATE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.DATE, JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.INTEGER_TYPE);
		when(submitwfDto.getWfuserReqDto()).thenReturn(wfUserReqSDDto);
		when(hdrEntity.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrEntity.getRefNo()).thenReturn("");
		when(wfActionService.saveWfActConfigTrn(wfUserReqSDDto)).thenReturn(JunitConstants.INTEGER_TYPE);
		when(submitwfDto.getTrnStatus()).thenReturn("Authorized");
		List<LocDistributionHeadDtlEntity> dtlList = new ArrayList<>();
		dtlList.add(dtlEntity);
		when(dtlHeadEntity.getDetailHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(subHeadEntity.getSubHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(minorHeadEntity.getMinorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(subMajorHeadEntity.getSubMajorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(majorHeadEntity.getMajorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(demandEntity.getDemandId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dtlEntity.getDetailedHeadId()).thenReturn(dtlHeadEntity);
		when(dtlEntity.getSubHeadId()).thenReturn(subHeadEntity);
		when(dtlEntity.getMinorHeadId()).thenReturn(minorHeadEntity);
		when(dtlEntity.getSubMajorHeadId()).thenReturn(subMajorHeadEntity);
		when(dtlEntity.getMajorHeadId()).thenReturn(majorHeadEntity);
		when(dtlEntity.getDemandId()).thenReturn(demandEntity);
		when(submitwfDto.getDdoNo()).thenReturn("123");
		when(dtlRepo.findByHdrIdIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(dtlList);
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyLong())).thenReturn(lookUpEntity);
		doNothing().when(hdrRepo).updateFlagInAdviceHdr(JunitConstants.STRING_ABC, JunitConstants.STRING_ABC,
				JunitConstants.LONG_TYPE);

		assertNotNull(service.submit(submitwfDto));
	}

	/**
	 * Test get edit view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetEditView() throws CustomException {
		Object[] chqObject = new Object[24];
		chqObject[0] = JunitConstants.LONG_TYPE;
		chqObject[1] = JunitConstants.STRING_ABC;
		chqObject[2] = JunitConstants.STRING_TYPE;
		chqObject[3] = JunitConstants.STRING_TYPE;
		chqObject[4] = JunitConstants.DATE;
		chqObject[5] = JunitConstants.STRING_TYPE;
		chqObject[6] = JunitConstants.DATE;
		chqObject[7] = JunitConstants.DATE;
		chqObject[8] = JunitConstants.STRING_TYPE;
		chqObject[9] = JunitConstants.DATE;
		chqObject[10] = JunitConstants.STRING_TYPE;
		chqObject[11] = JunitConstants.STRING_ABC;
		chqObject[12] = JunitConstants.STRING_TYPE;
		chqObject[13] = JunitConstants.DATE;
		chqObject[14] = JunitConstants.STRING_ABC;
		chqObject[15] = JunitConstants.DATE;
		chqObject[16] = JunitConstants.DOUBLE_VAL;
		chqObject[17] = JunitConstants.DOUBLE_VAL;
		chqObject[18] = JunitConstants.STRING_TYPE;
		chqObject[19] = JunitConstants.STRING_TYPE;
		chqObject[20] = JunitConstants.LONG_TYPE;
		chqObject[21] = JunitConstants.STRING_ABC;
		chqObject[22] = JunitConstants.STRING_TYPE;
		chqObject[23] = JunitConstants.STRING_TYPE;
		List<Object[]> objList = new ArrayList<Object[]>();
		objList.add(chqObject);
		when(hdrRepo.getHdrEditView(Mockito.anyLong(), Mockito.anyInt())).thenReturn(objList);
		Object[] chqObject1 = new Object[16];
		chqObject1[0] = JunitConstants.LONG_TYPE;
		chqObject1[1] = JunitConstants.LONG_TYPE;
		chqObject1[2] = JunitConstants.STRING_TYPE;
		chqObject1[3] = JunitConstants.STRING_TYPE;
		chqObject1[4] = JunitConstants.LONG_TYPE;
		chqObject1[5] = JunitConstants.STRING_TYPE;
		chqObject1[6] = JunitConstants.STRING_TYPE;
		chqObject1[7] = JunitConstants.STRING_TYPE;
		chqObject1[8] = JunitConstants.STRING_TYPE;
		chqObject1[9] = JunitConstants.STRING_TYPE;
		chqObject1[10] = JunitConstants.STRING_TYPE;
		chqObject1[11] = JunitConstants.STRING_ABC;
		chqObject1[12] = JunitConstants.STRING_TYPE;
		chqObject1[13] = JunitConstants.STRING_TYPE;
		chqObject1[14] = JunitConstants.STRING_TYPE;
		chqObject1[15] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objList1 = new ArrayList<Object[]>();
		objList1.add(chqObject1);
		when(hdrRepo.getDtlEditView(Mockito.anyLong(), Mockito.anyInt())).thenReturn(objList1);
		assertNotNull(service.getEditView(idDto));
	}

	/**
	 * Test get listing data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetListingData() throws CustomException {
		Object[] chqObject = new Object[13];
		chqObject[0] = JunitConstants.STRING_TYPE;
		chqObject[1] = JunitConstants.LONG_TYPE;
		chqObject[2] = JunitConstants.STRING_TYPE;
		chqObject[3] = JunitConstants.STRING_TYPE;
		chqObject[4] = JunitConstants.LONG_TYPE;
		chqObject[5] = JunitConstants.STRING_TYPE;
		chqObject[6] = JunitConstants.STRING_TYPE;
		chqObject[7] = JunitConstants.LONG_TYPE;
		chqObject[8] = JunitConstants.STRING_TYPE;
		chqObject[9] = JunitConstants.STRING_TYPE;
		chqObject[10] = JunitConstants.LONG_TYPE;
		chqObject[11] = JunitConstants.STRING_TYPE;
		chqObject[12] = JunitConstants.STRING_TYPE;
		List<Object[]> objectList = new ArrayList<>();
		objectList.add(chqObject);

		Object[] grntObject = new Object[9];
		grntObject[0] = JunitConstants.LONG_TYPE;
		grntObject[1] = JunitConstants.STRING_ABC;
		grntObject[2] = JunitConstants.STRING_TYPE;
		grntObject[3] = JunitConstants.LONG_TYPE;
		grntObject[4] = JunitConstants.STRING_TYPE;
		grntObject[5] = JunitConstants.STRING_TYPE;
		grntObject[6] = JunitConstants.DOUBLE_VAL;
		grntObject[7] = JunitConstants.DATE;
		grntObject[8] = JunitConstants.STRING_TYPE;
		List<Object[]> grantOjectList = new ArrayList<>();
		grantOjectList.add(grntObject);
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		SearchParam mockSearch1 = Mockito.mock(SearchParam.class);
		SearchParam mockSearch2 = Mockito.mock(SearchParam.class);
		SearchParam mockSearch3 = Mockito.mock(SearchParam.class);
		SearchParam mockSearch4 = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch1.getKey()).thenReturn(LocDBConstants.CARDEX_NO);
		when(mockSearch1.getValue()).thenReturn(JunitConstants.STRING_TYPE);
		when(mockSearch2.getKey()).thenReturn(LocDBConstants.DDO_NO);
		when(mockSearch2.getValue()).thenReturn(JunitConstants.STRING_TYPE);
		when(mockSearch3.getKey()).thenReturn(LocDBConstants.OFFICE_ID);
		when(mockSearch3.getValue()).thenReturn(JunitConstants.STRING_TYPE);
		when(mockSearch4.getKey()).thenReturn(LocDBConstants.FIN_YR);
		when(mockSearch4.getValue()).thenReturn(JunitConstants.STRING_TYPE);
		when(mockSearch.getKey()).thenReturn(LocDBConstants.ISTO);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_TYPE);
		List<SearchParam> srchParam = new ArrayList<>();
		srchParam.add(mockSearch);
		srchParam.add(mockSearch1);
		srchParam.add(mockSearch2);
		srchParam.add(mockSearch3);
		srchParam.add(mockSearch4);
		when(pageDetail.getJsonArr()).thenReturn(srchParam);

		when(hdrRepo.getGrantDistributionList(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyLong())).thenReturn(grantOjectList);
		assertNotNull(service.getListingData(pageDetail));

	}

	/**
	 * Test get listing data for TO.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetListingDataTO() throws CustomException {
		Object[] chqObject = new Object[13];
		chqObject[0] = JunitConstants.STRING_TYPE;
		chqObject[1] = JunitConstants.LONG_TYPE;
		chqObject[2] = JunitConstants.STRING_TYPE;
		chqObject[3] = JunitConstants.STRING_TYPE;
		chqObject[4] = JunitConstants.LONG_TYPE;
		chqObject[5] = JunitConstants.STRING_TYPE;
		chqObject[6] = JunitConstants.STRING_TYPE;
		chqObject[7] = JunitConstants.LONG_TYPE;
		chqObject[8] = JunitConstants.STRING_TYPE;
		chqObject[9] = JunitConstants.STRING_TYPE;
		chqObject[10] = JunitConstants.LONG_TYPE;
		chqObject[11] = JunitConstants.STRING_TYPE;
		chqObject[12] = JunitConstants.STRING_TYPE;
		List<Object[]> objectList = new ArrayList<>();
		objectList.add(chqObject);

		Object[] grntObject = new Object[9];
		grntObject[0] = JunitConstants.LONG_TYPE;
		grntObject[1] = JunitConstants.STRING_ABC;
		grntObject[2] = JunitConstants.STRING_TYPE;
		grntObject[3] = JunitConstants.LONG_TYPE;
		grntObject[4] = JunitConstants.STRING_TYPE;
		grntObject[5] = JunitConstants.STRING_TYPE;
		grntObject[6] = JunitConstants.DOUBLE_VAL;
		grntObject[7] = JunitConstants.DATE;
		grntObject[8] = JunitConstants.STRING_TYPE;
		List<Object[]> grantOjectList = new ArrayList<>();
		grantOjectList.add(grntObject);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);

		List<SearchParam> srchParam = new ArrayList<>();

		when(pageDetail.getJsonArr()).thenReturn(srchParam);

		when(hdrRepo.getGrantDistributionList(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyLong())).thenReturn(grantOjectList);
		assertNotNull(service.getListingData(pageDetail));

	}

	@Test
	void testPrintFormBandFormA() throws CustomException {
		Object[] object = new Object[24];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = "wrferrtgrsedfeffweeffeeeffe";
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.DATE;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.DATE;
		object[7] = JunitConstants.DATE;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.DATE;
		object[10] = JunitConstants.STRING_ABC;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.STRING_ABC;
		object[13] = JunitConstants.DATE;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.DATE;
		object[16] = JunitConstants.DOUBLE_VAL;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.STRING_ABC;
		object[19] = JunitConstants.STRING_ABC;
		object[20] = JunitConstants.LONG_TYPE;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("header", hdrViewDto);
		inputMap.put("chqDtl", "abc");
		inputMap.put("pstDtl", "wer");
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.getHdrEditView(Mockito.anyLong(), Mockito.anyInt())).thenReturn(objects);
		when(pdfService.generatePDF(LocURLConstant.ADVICE_STATEMENT_FTL_FILE, inputMap,
				LocConstant.ADVICE_PDF_FILE_NAME + hdrViewDto.getLcNo())).thenReturn("wefwefsdfsd121dsdsdd");

		assertNotNull(service.printFormB(idDto));
		assertNotNull(service.printFormA(idDto));
	}

}

package gov.ifms.loc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.converter.LocAccountCloseReqHdrConverter;
import gov.ifms.loc.converter.LocAccountCloseReqSdConverter;
import gov.ifms.loc.dto.LocAccCloseReqHdrDto;
import gov.ifms.loc.dto.LocAccountCloseReqHdrDto;
import gov.ifms.loc.dto.LocAccountCloseReqSdDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocOpenReqListDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocAccountCloseReqHdrEntity;
import gov.ifms.loc.entity.LocAccountCloseReqSdEntity;
import gov.ifms.loc.entity.LocAccountOpenReqWfEntity;
import gov.ifms.loc.repository.LocAccountCloseReqHdrRepository;
import gov.ifms.loc.repository.LocAccountCloseReqSdRepository;
import gov.ifms.loc.repository.LocAccountCloseWfRepository;
import gov.ifms.loc.repository.LocAccountOpeningReqHdrRepository;
import gov.ifms.loc.serviceimpl.LocAccountCloseReqServiceImpl;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocAccountCloseReqServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class LocAccountCloseReqServiceImplTest {

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * The service impl.
	 */
	@InjectMocks
	private LocAccountCloseReqServiceImpl service;

	/**
	 * The hdr repo.
	 */
	@Mock
	private LocAccountOpeningReqHdrRepository openHdrRepo;

	/**
	 * The req dtl dto.
	 */
	@Mock
	private LocAccCloseReqHdrDto reqdHdrDto;

	/**
	 * The hdr convertor.
	 */
	@Mock
	private LocAccountCloseReqHdrConverter hdrConvertor;

	/**
	 * The hdr entity.
	 */
	@Mock
	private LocAccountCloseReqHdrEntity hdrEntity;

	/**
	 * The hdr dto.
	 */
	@Mock
	private LocAccountCloseReqHdrDto hdrDto;

	/**
	 * The hdr repo.
	 */
	@Mock
	private LocAccountCloseReqHdrRepository hdrRepo;

	/**
	 * The sd dto.
	 */
	@Mock
	private LocAccountCloseReqSdDto sdDto;

	/**
	 * The sd converter.
	 */
	@Mock
	private LocAccountCloseReqSdConverter sdConverter;

	/**
	 * The sd entity.
	 */
	@Mock
	private LocAccountCloseReqSdEntity sdEntity;

	/**
	 * The sd repo.
	 */
	@Mock
	private LocAccountCloseReqSdRepository sdRepo;

	/**
	 * The wf repo.
	 */
	@Mock
	private LocAccountCloseWfRepository wfRepo;

	/**
	 * The wf entity.
	 */
	@Mock
	private LocAccountOpenReqWfEntity wfEntity;

	/**
	 * The wfuser req sd dto.
	 */
	@Mock
	private WfUserReqSDDto wfuserReqSdDto;

	/**
	 * The wf action service.
	 */
	@Mock
	private LocWfActionConfigService wfActionService;

	/**
	 * The edit view dto.
	 */
	@Mock
	private LocChqBookEditViewDto editViewDto;

	/**
	 * The pg detail.
	 */
	@Mock
	private PageDetails pgDetail;

	/**
	 * The submitwf dto.
	 */
	@Mock
	private LocSubmitWfDto submitwfDto;

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
	 * The id dto.
	 */
	@Mock
	private IdDto idDto;

	/**
	 * The list dto.
	 */
	@Mock
	private LocOpenReqListDto listDto;

	/**
	 * The page detail.
	 */
	@Mock
	private PageDetails pageDetail;

	/**
	 * Test get account close req dtl.
	 * 
	 * @throws CustomException
	 */
	@Test
	void testGetAccountCloseReqDtl() throws CustomException {
		Object[] obj = new Object[22];

		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		when(openHdrRepo.getAccountCloseRequestData(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyLong())).thenReturn(objList);
		assertNotNull(service.getAccountCloseReqDtl(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyLong()));
	}

	/**
	 * Test create loc acc close req hdr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testCreateLocAccCloseReqHdr() throws CustomException {
		when(hdrConvertor.toEntity(hdrDto)).thenReturn(hdrEntity);
		when(hdrRepo.save(hdrEntity)).thenReturn(hdrEntity);
		when(hdrConvertor.toDTO(hdrEntity)).thenReturn(hdrDto);
		when(hdrDto.getLocAccountCloseReqSdDto()).thenReturn(sdDto);
		when(hdrEntity.getLcCloseReqHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrDto.getLcOpenRequestId()).thenReturn(JunitConstants.LONG_TYPE);
		when(sdConverter.toEntity(sdDto)).thenReturn(sdEntity);
		when(sdRepo.save(sdEntity)).thenReturn(sdEntity);
		when(sdConverter.toDTO(sdEntity)).thenReturn(sdDto);
		when(wfRepo.findByTrnIdIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(null);
		when(hdrDto.getWfUserReqSDDto()).thenReturn(wfuserReqSdDto);
		when(wfActionService.saveWfActConfigTrn(wfuserReqSdDto)).thenReturn(JunitConstants.INTEGER_TYPE);
		when(sdDto.getReferenceNo()).thenReturn(JunitConstants.STRING_ABC);
		when(hdrDto.getStatusId()).thenReturn(JunitConstants.STRING_ABC);
		assertNotNull(service.createLocAccCloseReqHdr(hdrDto));
	}

	/**
	 * Test get account close edit dtl.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAccountCloseEditDtl() throws CustomException {
		Object[] object = new Object[32];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.LONG_TYPE;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.LONG_TYPE;
		object[13] = JunitConstants.LONG_TYPE;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.STRING_ABC;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.LONG_TYPE;
		object[19] = JunitConstants.DATE;
		object[20] = JunitConstants.STRING_ABC;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.STRING_ABC;
		object[24] = JunitConstants.STRING_ABC;
		object[25] = JunitConstants.STRING_ABC;
		object[26] = JunitConstants.STRING_ABC;
		object[27] = JunitConstants.STRING_ABC;
		object[28] = JunitConstants.DATE;
		object[29] = JunitConstants.STRING_ABC;
		object[30] = JunitConstants.STRING_ABC;
		object[31] = JunitConstants.DATE;
		List<Object[]> objectList = new ArrayList<>();
		objectList.add(object);
		when(editViewDto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(editViewDto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objectList);
		assertNotNull(service.getAccountCloseEditDtl(editViewDto));
	}

	/**
	 * Test get closing listing data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetClosingListingData() throws CustomException {
		Object[] obj = new Object[21];
		obj[0] = JunitConstants.STRING_ABC;
		obj[1] = JunitConstants.DATE;
		obj[2] = JunitConstants.STRING_ABC;
		obj[3] = JunitConstants.LONG_TYPE;
		obj[4] = JunitConstants.LONG_TYPE;
		obj[5] = JunitConstants.STRING_ABC;
		obj[6] = JunitConstants.STRING_ABC;
		obj[7] = JunitConstants.LONG_TYPE;
		obj[8] = JunitConstants.STRING_ABC;
		obj[9] = JunitConstants.STRING_ABC;
		obj[10] = JunitConstants.LONG_TYPE;
		obj[11] = JunitConstants.LONG_TYPE;
		obj[12] = JunitConstants.STRING_ABC;
		obj[13] = JunitConstants.STRING_ABC;
		obj[14] = JunitConstants.STRING_ABC;
		obj[15] = JunitConstants.STRING_ABC;
		obj[16] = JunitConstants.STRING_ABC;
		obj[17] = JunitConstants.LONG_TYPE;
		obj[18] = JunitConstants.LONG_TYPE;
		obj[19] = JunitConstants.STRING_ABC;
		obj[20] = JunitConstants.STRING_ABC;
		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objList);
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pgDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pgDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		srchParam.add(mockSearch);
		when(pgDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(service.getClosingListingData(pgDetail));
	}

	/**
	 * Test get srch param.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSrchParam() throws CustomException {
		Object[] obj = new Object[9];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.STRING_ABC;
		obj[2] = JunitConstants.STRING_ABC;
		obj[3] = JunitConstants.LONG_TYPE;
		obj[4] = JunitConstants.STRING_ABC;
		obj[5] = JunitConstants.STRING_ABC;
		obj[6] = JunitConstants.LONG_TYPE;
		obj[7] = JunitConstants.STRING_ABC;
		obj[8] = JunitConstants.STRING_ABC;
		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		when(hdrRepo.getSrchParam()).thenReturn(objList);
		assertNotNull(service.getSrchParam());
	}

	/**
	 * Gets the delete by id.
	 *
	 * @return the delete by id
	 * @throws CustomException the custom exception
	 */
	@Test
	void getDeleteById() throws CustomException {
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.deleteById(idDto));
	}

	/**
	 * Test submit data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmitData() throws CustomException {
		Object[] obj2 = new Object[8];
		obj2[0] = JunitConstants.STRING_ABC;

		List<Object[]> test = new ArrayList<Object[]>();
		test.add(obj2);

		Object[] obj32 = new Object[3];
		obj32[0] = JunitConstants.LONG_TYPE;
		obj32[1] = JunitConstants.LONG_TYPE;
		obj32[2] = JunitConstants.LONG_TYPE;

		List<Object[]> objList32 = new ArrayList<>();
		objList32.add(obj32);
		when(hdrRepo.findByLcCloseReqHdrIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn(Optional.of(hdrEntity));
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyLong())).thenReturn(lookUpEntity);
		when(sdRepo.findByLcCloseReqHdrIdLcCloseReqHdrIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn(sdEntity);
		when(lookUpEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(submitwfDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(submitwfDto.getTrnStatus()).thenReturn("Pending");
		when(sdEntity.getReferenceNo()).thenReturn("");
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(test);
		when(submitwfDto.getTrnStatus()).thenReturn(LocConstant.AUTHORIZED);
		when(hdrRepo.getClosingReqOfficeData(Mockito.anyLong())).thenReturn(objList32);

		service.submitData(submitwfDto);
	}

}

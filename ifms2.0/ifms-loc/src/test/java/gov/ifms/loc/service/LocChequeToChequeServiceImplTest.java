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
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.converter.LocChequeToChequeDetailSdConverter;
import gov.ifms.loc.converter.LocChequeToChequeHDRConverter;
import gov.ifms.loc.dto.LocAdviceEpayChqDtlDto;
import gov.ifms.loc.dto.LocAdviceReqParamDto;
import gov.ifms.loc.dto.LocChequeToChequeDetailSdDto;
import gov.ifms.loc.dto.LocChequeToChequeEditViewDto;
import gov.ifms.loc.dto.LocChequeToChequeHDRDto;
import gov.ifms.loc.dto.LocChequeToChequeSrchData;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocChequeToChequeDetailEntity;
import gov.ifms.loc.entity.LocChequeToChequeDetailSdEntity;
import gov.ifms.loc.entity.LocChequeToChequeHDREntity;
import gov.ifms.loc.entity.LocMsDivisonEntity;
import gov.ifms.loc.repository.LocChequeToChequeDetailSdRepository;
import gov.ifms.loc.repository.LocChequeToChequeHDRRepository;
import gov.ifms.loc.repository.LocChequeToChequeWfRepository;
import gov.ifms.loc.serviceimpl.LocAdvicePrepServiceImpl;
import gov.ifms.loc.serviceimpl.LocChequeToChequeServiceImpl;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

@TestInstance(Lifecycle.PER_CLASS)
class LocChequeToChequeServiceImplTest {

	/** The service. */
	@InjectMocks
	private LocChequeToChequeServiceImpl service;

	/** The wf user dto. */
	@Mock
	private WfUserReqSDDto wfUserDto;

	/** The sd dto. */
	@Mock
	private LocChequeToChequeDetailSdDto sdDto;

	/** The sd entity. */
	@Mock
	private LocChequeToChequeDetailEntity sdEntity;

	/** The hdr converter. */
	@Mock
	private LocChequeToChequeHDRConverter hdrConverter;

	/** The hdr dto. */
	@Mock
	private LocChequeToChequeHDRDto hdrDto;

	/** The hdr entity. */
	@Mock
	private LocChequeToChequeHDREntity hdrEntity;

	/** The repository. */
	@Mock
	private LocChequeToChequeHDRRepository repository;

	/** The sd converter. */
	@Mock
	private LocChequeToChequeDetailSdConverter sdConverter;

	/** The sd repository. */
	@Mock
	private LocChequeToChequeDetailSdRepository sdRepository;

	/** The wf repo. */
	@Mock
	private LocChequeToChequeWfRepository wfRepo;

	/** The loc wf action config service. */
	@Mock
	private LocWfActionConfigService locWfActionConfigService;

	/** The div entity. */
	@Mock
	private LocMsDivisonEntity divEntity;

	/** The id dto. */
	@Mock
	private IdDto idDto;

	/** The wf save dto. */
	@Mock
	private LocSubmitWfDto wfSaveDto;

	/** The edit view dto. */
	@Mock
	private LocChequeToChequeEditViewDto editViewDto;

	/** The pg detail. */
	@Mock
	private PageDetails pgDetail;

	/** The sd data entity. */
	@Mock
	private LocChequeToChequeDetailSdEntity sdDataEntity;

	/** The sd datas entity. */
	@Mock
	private List<LocChequeToChequeDetailSdEntity> sdDatasEntity;

	/** The advice prep service. */
	@Mock
	private LocAdvicePrepServiceImpl advicePrepService;

	/** The chq srch data. */
	@Mock
	private LocChequeToChequeSrchData chqSrchData;

	/** The rec prm dto. */
	@Mock
	private LocAdviceReqParamDto recPrmDto;

	/** The epay chq dto. */
	@Mock
	private LocAdviceEpayChqDtlDto epayChqDto;

	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/**
	 * The search param.
	 */
	@Mock
	private SearchParam searchParam;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test save as draft.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	public void testSaveAsDraft() throws CustomException {
		Object[] object = new Object[1];
		object[0] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		List<WfUserReqSDDto> wfList = new ArrayList<>();
		wfList.add(wfUserDto);
		List<LocChequeToChequeDetailSdDto> sdDtoList = new ArrayList<>();
		sdDtoList.add(sdDto);
		List<LocChequeToChequeDetailEntity> sdEntityList = new ArrayList<LocChequeToChequeDetailEntity>();
		sdEntityList.add(sdEntity);
		when(hdrConverter.toEntity(hdrDto)).thenReturn(hdrEntity);
		when(hdrEntity.getReferanceNumber()).thenReturn(null);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(repository.save(hdrEntity)).thenReturn(hdrEntity);
		when(hdrEntity.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrDto.getChequeTochequeSdDto()).thenReturn(sdDtoList);
		when(sdConverter.toEntity(sdDto)).thenReturn(sdDataEntity);
		when(sdDataEntity.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(sdRepository.save(sdDataEntity)).thenReturn(sdDataEntity);
		when(wfRepo.findByIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(null);
		when(hdrDto.getWfUserReqDto()).thenReturn(wfUserDto);
		when(locWfActionConfigService.saveWfActConfigTrn(wfUserDto)).thenReturn(1);

		assertNotNull(service.saveAsDraft(hdrDto));

	}

	/**
	 * Test get check to check header info.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetCheckToCheckHeaderInfo() throws CustomException {
		Object[] object = new Object[12];
		object[0] = JunitConstants.STRING_TYPE;
		object[1] = JunitConstants.DATE;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.DOUBLE_VAL;
		object[4] = JunitConstants.DATE;
		object[5] = JunitConstants.STRING_TYPE;
		object[6] = JunitConstants.STRING_TYPE;
		object[7] = JunitConstants.DATE;
		object[8] = JunitConstants.LONG_TYPE;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.STRING_ABC;
		object[11] = JunitConstants.STRING_ABC;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.getHeaderChequeToChequeList(idDto.getId(), Constant.ACTIVE_STATUS)).thenReturn(objects);
		assertNotNull(service.getCheckToCheckHeaderInfo(idDto));

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
		when(repository.getSearchParam()).thenReturn(objects);
		assertNotNull(service.getSearchParam());
	}

	/**
	 * Test delete by id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteById() throws CustomException {
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByIdAndActiveStatus(idDto.getId(), Constant.ACTIVE_STATUS)).thenReturn(hdrEntity);
		assertNotNull(service.deleteById(idDto));
	}

	/**
	 * Test submit data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmitData() throws CustomException {

		when(repository.findByActiveStatusAndId(Constant.ACTIVE_STATUS, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(hdrEntity));
		when(wfSaveDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getTrnStatus()).thenReturn(JunitConstants.STRING_ABC);
		when(wfSaveDto.getWfId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getAssignByWfRoleId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(
				JunitConstants.STRING_ABC, Constant.ACTIVE_STATUS, Constant.STATUS_LOOKUP_ID))
						.thenReturn(edpLuLookUpInfoEntity);
		service.submitData(wfSaveDto);
	}

	/**
	 * Test get edit view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetEditView() throws CustomException {

		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.DOUBLE_VAL;
		object[4] = JunitConstants.DATE;
		object[5] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		Object[] object1 = new Object[17];
		object1[0] = JunitConstants.LONG_TYPE;
		object1[1] = JunitConstants.STRING_ABC;
		object1[2] = JunitConstants.STRING_ABC;
		object1[3] = JunitConstants.DOUBLE_VAL;
		object1[4] = JunitConstants.DATE;
		object1[5] = JunitConstants.STRING_ABC;
		object1[6] = JunitConstants.STRING_ABC;
		object1[7] = JunitConstants.LONG_TYPE;
		object1[8] = JunitConstants.STRING_ABC;
		object1[9] = JunitConstants.LONG_TYPE;
		object1[10] = JunitConstants.LONG_TYPE;
		object1[11] = JunitConstants.LONG_TYPE;
		object1[12] = JunitConstants.LONG_TYPE;
		object1[13] = JunitConstants.STRING_ABC;
		object1[14] = JunitConstants.STRING_ABC;
		object1[15] = JunitConstants.DATE;
		object1[16] = JunitConstants.LONG_TYPE;

		List<Object[]> objects1 = new ArrayList<>();
		objects1.add(object);

		Object[] object2 = new Object[13];
		object2[0] = JunitConstants.LONG_TYPE;
		object2[1] = JunitConstants.STRING_ABC;
		object2[2] = JunitConstants.STRING_ABC;
		object2[3] = JunitConstants.DOUBLE_VAL;
		object2[4] = JunitConstants.DATE;
		object2[5] = JunitConstants.STRING_ABC;
		object2[6] = JunitConstants.STRING_ABC;
		object2[7] = JunitConstants.LONG_TYPE;
		object2[8] = JunitConstants.LONG_TYPE;
		object2[9] = JunitConstants.LONG_TYPE;
		object2[10] = JunitConstants.LONG_TYPE;
		object2[11] = JunitConstants.LONG_TYPE;
		object2[12] = JunitConstants.LONG_TYPE;

		List<Object[]> objects2 = new ArrayList<>();
		objects2.add(object2);
		List<LocChequeToChequeDetailEntity> dtlEntityList = new ArrayList<LocChequeToChequeDetailEntity>();
		dtlEntityList.add(sdEntity);
		when(editViewDto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.getChqToChqHdr(editViewDto.getHdrId(), JunitConstants.ACTIVE_STATUS)).thenReturn(objects1);
		when(repository.getDtlData(editViewDto.getHdrId(), Constant.ACTIVE_STATUS)).thenReturn(objects);
		when(repository.getChqToChqSrchData(JunitConstants.STRING_ABC, Constant.ACTIVE_STATUS)).thenReturn(objects1);

		Object[] object11 = new Object[13];
		object11[0] = JunitConstants.LONG_TYPE;
		object11[1] = JunitConstants.STRING_ABC;
		object11[2] = JunitConstants.STRING_ABC;
		object11[3] = JunitConstants.DOUBLE_VAL;
		object11[4] = JunitConstants.DATE;
		object11[5] = JunitConstants.STRING_ABC;
		object11[6] = JunitConstants.STRING_ABC;
		object11[7] = JunitConstants.LONG_TYPE;
		object11[8] = JunitConstants.STRING_ABC;
		object11[9] = JunitConstants.LONG_TYPE;
		object11[10] = JunitConstants.LONG_TYPE;
		object11[11] = JunitConstants.LONG_TYPE;
		object11[12] = JunitConstants.LONG_TYPE;
		List<Object[]> objects11 = new ArrayList<>();
		objects11.add(object11);
		Object[] object21 = new Object[1];
		object21[0] = JunitConstants.LONG_TYPE;
		List<Object[]> objects21 = new ArrayList<>();
		objects21.add(object21);
		List<Object[]> objects3 = new ArrayList<>();
		when(hdrDto.getMissingChequeNo()).thenReturn(JunitConstants.STRING_ABC);
		when(repository.chqAuthStatus(JunitConstants.STRING_ABC, Constant.ACTIVE_STATUS)).thenReturn(objects21);
		when(repository.chqInProcess(JunitConstants.STRING_ABC, Constant.ACTIVE_STATUS, JunitConstants.LONG_TYPE))
				.thenReturn(objects3);

		when(repository.getChqToChqSrchData(JunitConstants.STRING_ABC, Constant.ACTIVE_STATUS)).thenReturn(objects11);
		when(advicePrepService.getChequeBookData(recPrmDto)).thenReturn(epayChqDto);
		service.getEditView(editViewDto);
	}

	@Test
	void testGetChequeToChequeListing() throws CustomException {

		when(pgDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pgDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);

		when(searchParam.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(searchParam.getValue()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(service.getChequeToChequeListing(pgDetail));
		List<SearchParam> srchParam = new ArrayList<>();
		srchParam.add(searchParam);
		when(pgDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(service.getChequeToChequeListing(pgDetail));

	}

	/**
	 * Test get cheque data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetChequeData() throws CustomException {
		Object[] object1 = new Object[13];
		object1[0] = JunitConstants.LONG_TYPE;
		object1[1] = JunitConstants.STRING_ABC;
		object1[2] = JunitConstants.STRING_ABC;
		object1[3] = JunitConstants.DOUBLE_VAL;
		object1[4] = JunitConstants.DATE;
		object1[5] = JunitConstants.STRING_ABC;
		object1[6] = JunitConstants.STRING_ABC;
		object1[7] = JunitConstants.LONG_TYPE;
		object1[8] = JunitConstants.STRING_ABC;
		object1[9] = JunitConstants.LONG_TYPE;
		object1[10] = JunitConstants.LONG_TYPE;
		object1[11] = JunitConstants.LONG_TYPE;
		object1[12] = JunitConstants.LONG_TYPE;
		List<Object[]> objects1 = new ArrayList<>();
		objects1.add(object1);
		Object[] object2 = new Object[1];
		object2[0] = JunitConstants.LONG_TYPE;
		List<Object[]> objects2 = new ArrayList<>();
		objects2.add(object2);
		List<Object[]> objects3 = new ArrayList<>();
		when(hdrDto.getMissingChequeNo()).thenReturn(JunitConstants.STRING_ABC);
		when(repository.chqAuthStatus(JunitConstants.STRING_ABC, Constant.ACTIVE_STATUS)).thenReturn(objects2);
		when(repository.chqInProcess(JunitConstants.STRING_ABC, Constant.ACTIVE_STATUS, JunitConstants.LONG_TYPE))
				.thenReturn(objects3);

		when(repository.getChqToChqSrchData(JunitConstants.STRING_ABC, Constant.ACTIVE_STATUS)).thenReturn(objects1);
		when(advicePrepService.getChequeBookData(recPrmDto)).thenReturn(epayChqDto);

		assertNotNull(service.getChequeData(hdrDto));
	}

}

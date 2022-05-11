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
import gov.ifms.loc.converter.LocAdviceHeadwiseDetailConverter;
import gov.ifms.loc.converter.LocChequeCancelDtlSdConverter;
import gov.ifms.loc.converter.LocChequeCancelHdrConverter;
import gov.ifms.loc.dto.LocAdviceHeadwiseDetailDto;
import gov.ifms.loc.dto.LocChequeCancelDtlSdDto;
import gov.ifms.loc.dto.LocChequeCancelHdrDto;
import gov.ifms.loc.dto.LocChequeCancelListDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocAdviceHeadwiseDetailEntity;
import gov.ifms.loc.entity.LocChequeCancelDtlEntity;
import gov.ifms.loc.entity.LocChequeCancelDtlSdEntity;
import gov.ifms.loc.entity.LocChequeCancelHdrEntity;
import gov.ifms.loc.entity.LocMsDivisonEntity;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.repository.LocAdviceHeadwiseDetailRepository;
import gov.ifms.loc.repository.LocChequeCancelDtlRepository;
import gov.ifms.loc.repository.LocChequeCancelDtlSdRepository;
import gov.ifms.loc.repository.LocChequeCancelHdrRepository;
import gov.ifms.loc.repository.LocChequeCancelWfRepository;
import gov.ifms.loc.serviceimpl.LocChequeCancelServiceImpl;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

@TestInstance(Lifecycle.PER_CLASS)
class LocChequeCancelServiceImplTest {

	@InjectMocks
	private LocChequeCancelServiceImpl service;

	@Mock
	private LocChequeCancelListDto chqLstDto;

	@Mock
	private LocChequeCancelHdrRepository repository;

	@Mock
	private LocAdviceHeadwiseDetailRepository adviceRepo;

	@Mock
	private LocAdviceHeadwiseDetailEntity adviceEntity;

	@Mock
	private LocAdviceHeadwiseDetailConverter adviceConverter;

	@Mock
	private LocAdviceHeadwiseDetailDto adviceDto;

	@Mock
	private LocChequeCancelHdrDto hdrDto;

	@Mock
	private IdDto idDto;

	@Mock
	private WfUserReqSDDto wfUserDto;

	@Mock
	private LocChequeCancelDtlSdDto sdDto;

	@Mock
	private LocChequeCancelHdrEntity hdrEntity;

	@Mock
	private LocChequeCancelHdrConverter hdrConverter;

	@Mock
	private LocChequeCancelDtlSdConverter sdConverter;

	@Mock
	private LocChequeCancelWfRepository wfRepo;

	@Mock
	private LocChequeCancelDtlSdEntity sdEntity;

	@Mock
	private LocWfActionConfigService locWfActionConfigService;

	@Mock
	private LocMsDivisonEntity divEntity;

	@Mock
	private LocChequeCancelDtlSdRepository sdRepository;

	@Mock
	private LocChqBookEditViewDto editViewDto;

	@Mock
	private LocChequeCancelDtlRepository dtlRepository;

	@Mock
	private LocChequeCancelDtlEntity dtlEntity;

	@Mock
	private LocSubmitWfDto wfSaveDto;

	@Mock
	private PageDetails pgDetail;

	/**
	 * The search param.
	 */
	@Mock
	private SearchParam searchParam;

	@Mock
	LocNotificationService notificationService;

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

	@BeforeAll
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetChequeSearchDetails() throws CustomException {
		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(chqLstDto.getChequeNO()).thenReturn(JunitConstants.STRING_ABC);
		when(repository.searchChequeDetail(chqLstDto.getChequeNO(), Constant.ACTIVE_STATUS)).thenReturn(objects);
		List<LocAdviceHeadwiseDetailEntity> adviceListEntity = new ArrayList<LocAdviceHeadwiseDetailEntity>();
		adviceListEntity.add(adviceEntity);

		when(adviceRepo.findByActiveStatusAndLcAdvice(Constant.ACTIVE_STATUS, JunitConstants.LONG_TYPE))
				.thenReturn(adviceListEntity);
		when(adviceConverter.toLstDTO(adviceEntity)).thenReturn(adviceDto);
		assertNotNull(service.getChequeSearchDetails(chqLstDto));
	}

	@Test
	void testGetCheckCancelHeaderInfo() throws CustomException {
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
		when(repository.getHeaderAdviceList(idDto.getId(), Constant.ACTIVE_STATUS)).thenReturn(objects);
		assertNotNull(service.getCheckCancelHeaderInfo(idDto));
	}

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
		List<LocChequeCancelDtlSdDto> sdDtoList = new ArrayList<>();
		sdDtoList.add(sdDto);
		List<LocChequeCancelDtlSdEntity> sdEntityList = new ArrayList<LocChequeCancelDtlSdEntity>();
		sdEntityList.add(sdEntity);
		when(hdrConverter.toEntity(hdrDto)).thenReturn(hdrEntity);
		when(hdrEntity.getRefNo()).thenReturn(null);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(repository.save(hdrEntity)).thenReturn(hdrEntity);
		when(hdrEntity.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrDto.getChequeCancelSdDto()).thenReturn(sdDtoList);
		when(sdConverter.toEntity(sdDto)).thenReturn(sdEntity);
		when(sdRepository.saveAll(sdEntityList)).thenReturn(sdEntityList);
		when(wfRepo.findByTrnIdHdrIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(null);
		when(hdrDto.getWfUserReqDto()).thenReturn(wfUserDto);
		when(locWfActionConfigService.saveWfActConfigTrn(wfUserDto)).thenReturn(1);
		// when(repository.get)
		when(hdrEntity.getDivId()).thenReturn(divEntity);
		when(divEntity.getDivCode()).thenReturn(JunitConstants.STRING_ABC);
		when(divEntity.getDivisionName()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(service.saveAsDraft(hdrDto));

	}

	@Test
	void testGetEditViewData() throws CustomException {
		Object[] object = new Object[14];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.DATE;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.DATE;
		object[6] = JunitConstants.DOUBLE_VAL;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.LONG_TYPE;
		object[12] = JunitConstants.STRING_ABC;
		object[13] = JunitConstants.STRING_ABC;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		List<LocChequeCancelDtlEntity> dtlEntityList = new ArrayList<LocChequeCancelDtlEntity>();
		dtlEntityList.add(dtlEntity);
		when(editViewDto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.getChqCnclHdrData(editViewDto.getHdrId(), Constant.ACTIVE_STATUS)).thenReturn(objects);
		when(editViewDto.getActionStatus()).thenReturn(LocConstant.VIEW_ACTION);

		when(dtlRepository.getChqCnclDtlData(editViewDto.getHdrId(), Constant.ACTIVE_STATUS)).thenReturn(objects);
		service.getEditViewData(editViewDto);
		when(editViewDto.getActionStatus()).thenReturn(LocConstant.EDIT_ACTION);

		when(sdRepository.getChqCnclSdData(editViewDto.getHdrId(), Constant.ACTIVE_STATUS)).thenReturn(objects);
		assertNotNull(service.getEditViewData(editViewDto));
	}

	@Test
	void testSubmitData() throws CustomException {

		when(repository.getOne(Mockito.anyLong())).thenReturn(hdrEntity);
		when(hdrEntity.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByActiveStatusAndHdrId(Constant.ACTIVE_STATUS, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(hdrEntity));
		when(wfSaveDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getTrnStatus()).thenReturn(JunitConstants.STRING_ABC);
		when(wfSaveDto.getWfId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getAssignByWfRoleId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfSaveDto.getTrnStatus()).thenReturn(JunitConstants.STRING_ABC);
		when(hdrEntity.getStatusId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyLong())).thenReturn(lookUpEntity);
		service.submitData(wfSaveDto);
	}

	@Test
	void testGetChequeCancelDivListing() throws CustomException {
		when(pgDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pgDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);

		when(searchParam.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(searchParam.getValue()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(service.getChequeCancelDivListing(pgDetail));
		List<SearchParam> srchParam = new ArrayList<>();
		srchParam.add(searchParam);
		when(pgDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(service.getChequeCancelDivListing(pgDetail));
	}

	@Test
	void testGetChequeCancelListing() throws CustomException {
		when(pgDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pgDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);

		when(searchParam.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(searchParam.getValue()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(service.getChequeCancelListing(pgDetail));
		List<SearchParam> srchParam = new ArrayList<>();
		srchParam.add(searchParam);
		when(pgDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(service.getChequeCancelListing(pgDetail));
	}

	@Test
	void testDeleteById() throws CustomException {
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByHdrIdAndActiveStatus(idDto.getId(), Constant.ACTIVE_STATUS)).thenReturn(hdrEntity);
		assertNotNull(service.deleteById(idDto));
	}
}

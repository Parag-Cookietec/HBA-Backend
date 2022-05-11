package gov.ifms.loc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.dao.GenericDaoImpl;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.converter.LocAccountOpenReqAgSdConverter;
import gov.ifms.loc.converter.LocAccountOpenReqBankSdConverter;
import gov.ifms.loc.converter.LocAccountOpenReqDivisionSdConverter;
import gov.ifms.loc.converter.LocAccountOpenReqDtlConverter;
import gov.ifms.loc.converter.LocAccountOpenReqHdrConverter;
import gov.ifms.loc.converter.LocAccountOpenReqItrConverter;
import gov.ifms.loc.converter.LocAccountOpenReqSdConverter;
import gov.ifms.loc.dto.LocAccOpenReqDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqAgDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqAgSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqBankSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqDivisionSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqHdrDto;
import gov.ifms.loc.dto.LocAccountOpenReqItrDto;
import gov.ifms.loc.dto.LocAccountOpenReqSdDto;
import gov.ifms.loc.dto.LocAgReqDtlDto;
import gov.ifms.loc.dto.LocBankReqDtlDto;
import gov.ifms.loc.dto.LocCircleDto;
import gov.ifms.loc.dto.LocDiviReqDtlDto;
import gov.ifms.loc.dto.LocIdNameDto;
import gov.ifms.loc.dto.LocMasterIdDto;
import gov.ifms.loc.dto.LocOpenReqSubmitDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.dto.LocTreasuryDto;
import gov.ifms.loc.dto.LocTreasuryParamDto;
import gov.ifms.loc.entity.LocAccountOpenReqAgSdEntity;
import gov.ifms.loc.entity.LocAccountOpenReqBankSdEntity;
import gov.ifms.loc.entity.LocAccountOpenReqDivisionSdEntity;
import gov.ifms.loc.entity.LocAccountOpenReqDtlEntity;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.entity.LocAccountOpenReqItrEntity;
import gov.ifms.loc.entity.LocAccountOpenReqSdEntity;
import gov.ifms.loc.entity.LocAccountOpenReqWfEntity;
import gov.ifms.loc.entity.LocMsDetailHeadEntity;
import gov.ifms.loc.entity.LocMsMajorHeadEntity;
import gov.ifms.loc.entity.LocMsMinorHeadEntity;
import gov.ifms.loc.entity.LocMsSubHeadEntity;
import gov.ifms.loc.entity.LocMsSubMajorHeadEntity;
import gov.ifms.loc.repository.LocAccountOpenReqAgDtlRepository;
import gov.ifms.loc.repository.LocAccountOpenReqAgSdRepository;
import gov.ifms.loc.repository.LocAccountOpenReqBankDtlRepository;
import gov.ifms.loc.repository.LocAccountOpenReqBankSdRepository;
import gov.ifms.loc.repository.LocAccountOpenReqDivisionDtlRepository;
import gov.ifms.loc.repository.LocAccountOpenReqDivisionSdRepository;
import gov.ifms.loc.repository.LocAccountOpenReqDtlRepository;
import gov.ifms.loc.repository.LocAccountOpenReqHdrRepository;
import gov.ifms.loc.repository.LocAccountOpenReqItrRepository;
import gov.ifms.loc.repository.LocAccountOpenReqSdRepository;
import gov.ifms.loc.repository.LocAccountOpenReqWfRepository;
import gov.ifms.loc.repository.LocChequeBookHdrRepository;
import gov.ifms.loc.repository.LocMsDetailHeadRepository;
import gov.ifms.loc.repository.LocMsMajorHeadRepository;
import gov.ifms.loc.repository.LocMsMinorHeadRepository;
import gov.ifms.loc.repository.LocMsSubHeadRepository;
import gov.ifms.loc.repository.LocMsSubMajorHeadRepository;
import gov.ifms.loc.serviceimpl.LocAccountOpenReqServiceImpl;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.util.LocURLConstant;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocAccountOpenReqServiceImplTest.
 */

@TestInstance(Lifecycle.PER_CLASS)
class LocAccountOpenReqServiceImplTest {

	/** The service. */
	@InjectMocks
	private LocAccountOpenReqServiceImpl serviceImpl;

	/** The hdr repo. */
	@Mock
	private LocAccountOpenReqHdrRepository hdrRepo;

	/** The LocAccountOpenReqSdAsMethodName repository. */
	@Mock
	private LocAccountOpenReqSdRepository sdRepo;

	/** The dtl repo. */
	@Mock
	private LocAccountOpenReqDtlRepository dtlRepo;

	/** The itr repo. */
	@Mock
	private LocAccountOpenReqItrRepository itrRepo;

	/** The ag sd repo. */
	@Mock
	private LocAccountOpenReqAgSdRepository agSdRepo;

	/** The ag dtl repo. */
	@Mock
	private LocAccountOpenReqAgDtlRepository agDtlRepo;

	/** The ms major head repo. */
	@Mock
	private LocMsMajorHeadRepository msMajorHeadRepo;

	/** The ms sub major head repo. */
	@Mock
	private LocMsSubMajorHeadRepository msSubMajorHeadRepo;

	/** The ms minor head repo. */
	@Mock
	private LocMsMinorHeadRepository msMinorHeadRepo;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The search param. */
	@Mock
	private SearchParam searchParam;

	/** The hdr dto. */
	@Mock
	private LocAccountOpenReqHdrDto hdrDto;

	/** The sd dto. */
	@Mock
	private LocAccountOpenReqSdDto sdDto;

	/** The dtl dto. */
	@Mock
	private LocAccountOpenReqDtlDto dtlDto;

	/** The itr dto. */
	@Mock
	private LocAccountOpenReqItrDto itrDto;

	/** The loc acc open req dtl dto. */
	@Mock
	private LocAccOpenReqDtlDto locAccOpenReqDtlDto;

	/** The loc ag req dtl dto. */
	@Mock
	private LocAgReqDtlDto locAgReqDtlDto;

	/** The hdr converter. */
	@Mock
	private LocAccountOpenReqHdrConverter hdrConverter;

	/** The sd converter. */
	@Mock
	private LocAccountOpenReqSdConverter sdConverter;

	/** The dtl converter. */
	@Mock
	private LocAccountOpenReqDtlConverter dtlConverter;

	/** The itr converter. */
	@Mock
	private LocAccountOpenReqItrConverter itrConverter;

	/** The hdr entity. */
	@Mock
	private LocAccountOpenReqHdrEntity hdrEntity;

	/** The sd entity. */
	@Mock
	private LocAccountOpenReqSdEntity sdEntity;

	/** The dtl entity. */
	@Mock
	private LocAccountOpenReqDtlEntity dtlEntity;

	/** The itr entity. */
	@Mock
	private LocAccountOpenReqItrEntity itrEntity;

	/** The hdr spec. */
	@Mock
	private SpecificationImpl<LocAccountOpenReqHdrEntity> hdrSpec;

	/** The sd spec. */
	@Mock
	private SpecificationImpl<LocAccountOpenReqSdEntity> sdSpec;

	/** The dtl spec. */
	@Mock
	private SpecificationImpl<LocAccountOpenReqDtlEntity> dtlSpec;

	/** The itr spec. */
	@Mock
	private SpecificationImpl<LocAccountOpenReqItrEntity> itrSpec;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The page. */
	@Mock
	private Page<LocAccountOpenReqHdrEntity> hdrPage;

	/** The sd page. */
	@Mock
	private Page<LocAccountOpenReqSdEntity> sdPage;

	/** The dtl page. */
	@Mock
	private Page<LocAccountOpenReqDtlEntity> dtlPage;

	/** The itr page. */
	@Mock
	private Page<LocAccountOpenReqItrEntity> itrPage;

	/** The page request. */
	@Mock
	private PageRequest pageRequest;

	/** The generic dao. */
	@Mock
	private GenericDaoImpl genericDao;

	/** The ms sub head repo. */
	@Mock
	private LocMsSubHeadRepository msSubHeadRepo;

	/** The ms detail head repo. */
	@Mock
	private LocMsDetailHeadRepository msDetailHeadRepo;

	/** The loc acc openreq divi repo. */
	@Mock
	private LocAccountOpenReqDivisionDtlRepository locAccOpenreqDiviRepo;

	/** The loc account open req division sd repository. */
	@Mock
	private LocAccountOpenReqDivisionSdRepository locAccountOpenReqDivisionSdRepository;

	/** The div req dto. */
	@Mock
	private LocDiviReqDtlDto divReqDto;

	/** The loc account open req division sd converter. */
	@Mock
	private LocAccountOpenReqDivisionSdConverter locAccountOpenReqDivisionSdConverter;

	/** The dto. */
	@Mock
	private LocAccountOpenReqDivisionSdDto dto;

	/** The loc account open req division sd entity. */
	@Mock
	private LocAccountOpenReqDivisionSdEntity locAccountOpenReqDivisionSdEntity;

	/** The loc account open req bank sd repository. */
	@Mock
	private LocAccountOpenReqBankSdRepository locAccountOpenReqBankSdRepository;

	/** The loc acc openreq bank repo. */
	@Mock
	private LocAccountOpenReqBankDtlRepository locAccOpenreqBankRepo;

	/** The bank req dtl dto. */
	@Mock
	private LocBankReqDtlDto bankReqDtlDto;

	/** The loc account open req bank sd entity. */
	@Mock
	private LocAccountOpenReqBankSdEntity locAccountOpenReqBankSdEntity;

	/** The bank sd dto. */
	@Mock
	private LocAccountOpenReqBankSdDto bankSdDto;

	/** The loc account open req bank sd converter. */
	@Mock
	private LocAccountOpenReqBankSdConverter locAccountOpenReqBankSdConverter;

	/** The loc acc open req ag sd repo. */
	@Mock
	private LocAccountOpenReqAgSdRepository locAccOpenReqAgSdRepo;

	/** The loc acc open req ag dtl repo. */
	@Mock
	private LocAccountOpenReqAgDtlRepository locAccOpenReqAgDtlRepo;

	/** The loc account open req ag sd entity. */
	@Mock
	LocAccountOpenReqAgSdEntity locAccountOpenReqAgSdEntity;

	/** The ag dtl dto. */
	@Mock
	private LocAccountOpenReqAgDtlDto agDtlDto;

	/** The submit wf dto. */
	@Mock
	private LocSubmitWfDto submitWfDto;

	/** The look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/** The loc acc openreq ag repo. */
	@Mock
	private LocAccountOpenReqAgDtlRepository locAccOpenreqAgRepo;

	/** The edp. */
	@Mock
	private EDPLuLookUpInfoEntity edp;

	/** The loc acc open req ag sd con. */
	@Mock
	private LocAccountOpenReqAgSdConverter locAccOpenReqAgSdCon;

	/** The major head entity. */
	@Mock
	private LocMsMajorHeadEntity majorHeadEntity;

	/** The minor head entity. */
	@Mock
	private LocMsMinorHeadEntity minorHeadEntity;

	/** The sub head entity. */
	@Mock
	private LocMsSubHeadEntity subHeadEntity;

	/** The sub major head entity. */
	@Mock
	private LocMsSubMajorHeadEntity subMajorHeadEntity;

	/** The loc circle dto. */
	@Mock
	private LocCircleDto locCircleDto;

	/** The master id dto. */
	@Mock
	private LocMasterIdDto masterIdDto;

	/** The detail head entity. */
	@Mock
	private LocMsDetailHeadEntity detailHeadEntity;

	/** The acc open req ag sd dto. */
	@Mock
	private LocAccountOpenReqAgSdDto accOpenReqAgSdDto;

	/** The loc account open req wf repository. */
	@Mock
	private LocAccountOpenReqWfRepository locAccountOpenReqWfRepository;

	/** The loc account open req wf entity. */
	@Mock
	private LocAccountOpenReqWfEntity locAccountOpenReqWfEntity;

	/** The wf user dto. */
	@Mock
	private WfUserReqSDDto wfUserDto;

	/** The loc wf action config service. */
	@Mock
	private LocWfActionConfigService locWfActionConfigService;

	/** The submit dto list. */
	@Mock
	private List<LocOpenReqSubmitDto> submitDtoList;

	/** The id dto. */
	@Mock
	private IdDto idDto;

	@Mock
	private LocChequeBookHdrRepository chqBookHdrRepo;

	@Mock
	private LocIdNameDto idNameDto;

	@Mock
	private LocPDFService pdfService;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get account open req hdr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAccountOpenReqHdr() throws CustomException {
		when(hdrRepo.getOne(JunitConstants.LONG_TYPE)).thenReturn(hdrEntity);
		assertNotNull(serviceImpl.getAccountOpenReqHdr(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test save or update account open req hdr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveOrUpdateAccountOpenReqHdr() throws CustomException {
		when(hdrRepo.save(hdrEntity)).thenReturn(hdrEntity);
		assertNotNull(serviceImpl.saveOrUpdateAccountOpenReqHdr(hdrEntity));
	}

	/**
	 * Test get account open req hdrs.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetAccountOpenReqHdrs() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageRequest);
		List<SearchParam> searchParams = new ArrayList<>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(searchCriteria.getSpecificationDetails(hdrSpec, searchParams)).thenReturn(hdrSpec);
		when(hdrRepo.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(hdrPage);
		when(hdrPage.getSize()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(hdrPage.getTotalPages()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(hdrPage.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);
		List<LocAccountOpenReqHdrEntity> entities = new ArrayList<>();
		entities.add(hdrEntity);
		when(hdrPage.getContent()).thenReturn(entities);
		List<LocAccountOpenReqHdrDto> dtos = new ArrayList<>();
		dtos.add(hdrDto);
		when(hdrConverter.toDTO(entities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAccountOpenReqHdrs(pageDetail));

	}

	/**
	 * Test get account open req sd.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAccountOpenReqSd() throws CustomException {
		when(sdRepo.getOne(JunitConstants.LONG_TYPE)).thenReturn(sdEntity);
		assertNotNull(serviceImpl.getAccountOpenReqSd(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test save or update account open req sd.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveOrUpdateAccountOpenReqSd() throws CustomException {
		when(sdRepo.save(sdEntity)).thenReturn(sdEntity);
		assertNotNull(serviceImpl.saveOrUpdateAccountOpenReqSd(sdEntity));
	}

	/**
	 * Test get account open req sds.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetAccountOpenReqSds() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageRequest);
		List<SearchParam> searchParams = new ArrayList<>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(searchCriteria.getSpecificationDetails(sdSpec, searchParams)).thenReturn(sdSpec);
		when(sdRepo.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(sdPage);
		when(sdPage.getSize()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(sdPage.getTotalPages()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(sdPage.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);
		List<LocAccountOpenReqSdEntity> sdEntities = new ArrayList<>();
		sdEntities.add(sdEntity);
		when(sdPage.getContent()).thenReturn(sdEntities);
		List<LocAccountOpenReqSdDto> dtos = new ArrayList<>();
		dtos.add(sdDto);
		when(sdConverter.toDTO(sdEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAccountOpenReqSds(pageDetail));
	}

	/**
	 * Gets the account open req dtls.
	 *
	 * @return the account open req dtls
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void getAccountOpenReqDtls() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageRequest);
		List<SearchParam> searchParams = new ArrayList<>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(searchCriteria.getSpecificationDetails(dtlSpec, searchParams)).thenReturn(dtlSpec);
		when(dtlRepo.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(dtlPage);
		when(dtlPage.getSize()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(dtlPage.getTotalPages()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(dtlPage.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);
		List<LocAccountOpenReqDtlEntity> dtlEntities = new ArrayList<>();
		dtlEntities.add(dtlEntity);
		List<LocAccountOpenReqDtlDto> dtos = new ArrayList<>();
		dtos.add(dtlDto);
		when(dtlConverter.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAccountOpenReqDtls(pageDetail));
	}

	/**
	 * Test get account open req itrs.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetAccountOpenReqItrs() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageRequest);
		List<SearchParam> searchParams = new ArrayList<>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(searchCriteria.getSpecificationDetails(itrSpec, searchParams)).thenReturn(itrSpec);
		when(itrRepo.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(itrPage);
		when(itrPage.getSize()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(itrPage.getTotalPages()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(itrPage.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);
		List<LocAccountOpenReqItrEntity> itrEntities = new ArrayList<>();
		itrEntities.add(itrEntity);
		List<LocAccountOpenReqItrDto> dtos = new ArrayList<>();
		dtos.add(itrDto);
		when(itrConverter.toDTO(itrEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAccountOpenReqItrs(pageDetail));
	}

	/**
	 * Test get all circle.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAllCircle() throws CustomException {
		Object[] chqObject = new Object[3];
		chqObject[0] = JunitConstants.LONG_TYPE;
		chqObject[1] = JunitConstants.STRING_TYPE;
		chqObject[2] = JunitConstants.STRING_TYPE;
		List<Object[]> objectList = new ArrayList<>();
		objectList.add(chqObject);
		when(hdrRepo.getAllCircle()).thenReturn(objectList);
		assertNotNull(serviceImpl.getAllCircle());
	}

	/**
	 * Test get treasury by district id and department id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetTreasuryByDistrictIdAndDepartmentId() throws CustomException {
		LocTreasuryDto locTreasuryDto = new LocTreasuryDto();
		locTreasuryDto.setOfficeId(JunitConstants.LONG_TYPE);
		LocTreasuryParamDto locTreasuryParamDto = new LocTreasuryParamDto();
		Map<String, Object> attributesMap = new HashMap<>();
		attributesMap.put("districtId", locTreasuryParamDto.getDistrictId());
		when(genericDao.executeSQLQuerySingle(LocDBConstants.getTreasuryByDistrictIdAndDepartmentId(), attributesMap,
				LocTreasuryDto.class)).thenReturn(locTreasuryDto);
		assertNotNull(serviceImpl.getTreasuryByDistrictIdAndDepartmentId(locTreasuryParamDto));
	}

	/**
	 * Test get major head.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetMajorHead() throws CustomException {
		List<LocMsMajorHeadEntity> locMsMajorHeadEntitys = new LinkedList<LocMsMajorHeadEntity>();
		locMsMajorHeadEntitys.add(majorHeadEntity);
		when(msMajorHeadRepo.getMajorHeadesByDemandId(Mockito.anyLong(), Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(locMsMajorHeadEntitys);
		when(majorHeadEntity.getMajorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(majorHeadEntity.getMajorHeadName()).thenReturn(JunitConstants.STRING_ABC);
		when(majorHeadEntity.getMajorHeadCode()).thenReturn(JunitConstants.STRING_ABC);
		when(majorHeadEntity.getMajorHeadDesc()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(serviceImpl.getMajorHead());
	}

	/**
	 * Test get sub major head.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSubMajorHead() throws CustomException {
		List<LocMsSubMajorHeadEntity> entityList = new LinkedList<>();
		entityList.add(subMajorHeadEntity);
		when(msSubMajorHeadRepo.findByDemandIdAndMajorHeadEntityMajorHeadIdAndActiveStatusOrderBySubMajorHeadCode(
				Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(entityList);
		when(subMajorHeadEntity.getSubMajorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(subMajorHeadEntity.getSubmajorHeadName()).thenReturn(JunitConstants.STRING_ABC);
		when(subMajorHeadEntity.getSubMajorHeadCode()).thenReturn(JunitConstants.STRING_ABC);
		when(subMajorHeadEntity.getSubMajorHeadDesc()).thenReturn(JunitConstants.STRING_ABC);
		when(subMajorHeadEntity.getSubMajorHeadCode()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(serviceImpl.getSubMajorHead(masterIdDto));
	}

	/**
	 * Test get minor head.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetMinorHead() throws CustomException {
		List<LocMsMinorHeadEntity> entityList = new LinkedList<>();
		entityList.add(minorHeadEntity);
		when(msMinorHeadRepo
				.findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndActiveStatusOrderByMinorHeadCode(
						Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt()))
								.thenReturn(entityList);
		when(minorHeadEntity.getMinorHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(minorHeadEntity.getMinorHeadName()).thenReturn(JunitConstants.STRING_ABC);
		when(minorHeadEntity.getMinorHeadCode()).thenReturn(JunitConstants.STRING_ABC);
		when(minorHeadEntity.getMinorHeadDesc()).thenReturn(JunitConstants.STRING_ABC);
		when(minorHeadEntity.getMinorHeadCode()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(serviceImpl.getMinorHead(masterIdDto));

	}

	/**
	 * Test get sub head.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSubHead() throws CustomException {
		List<LocMsSubHeadEntity> entityList = new LinkedList<>();
		entityList.add(subHeadEntity);
		when(msSubHeadRepo
				.findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndActiveStatusOrderBySubHeadCodeAsc(
						Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt()))
								.thenReturn(entityList);
		when(subHeadEntity.getSubHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(subHeadEntity.getSubHeadName()).thenReturn(JunitConstants.STRING_ABC);
		when(subHeadEntity.getSubHeadCode()).thenReturn(JunitConstants.STRING_ABC);
		when(subHeadEntity.getSubHeadDesc()).thenReturn(JunitConstants.STRING_ABC);
		when(subHeadEntity.getSubHeadCode()).thenReturn(JunitConstants.STRING_ABC);
		assertNotNull(serviceImpl.getSubHead(masterIdDto));
	}

	/**
	 * Test get detail head.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetDetailHead() throws CustomException {
		List<LocMsDetailHeadEntity> entityList = new LinkedList<>();
		entityList.add(detailHeadEntity);
		when(msDetailHeadRepo
				.findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndSubHeadEntitySubHeadIdAndAndActiveStatusOrderByDetailHeadCode(
						Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
						Mockito.anyInt())).thenReturn(entityList);
		when(detailHeadEntity.getDetailHeadId()).thenReturn(JunitConstants.LONG_TYPE);
		when(detailHeadEntity.getDetailHeadName()).thenReturn(JunitConstants.STRING_ABC);
		when(detailHeadEntity.getDetailHeadCode()).thenReturn(JunitConstants.STRING_ABC);
		when(detailHeadEntity.getDetailHeadDesc()).thenReturn(JunitConstants.STRING_ABC);
		when(detailHeadEntity.getDetailHeadCode()).thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(serviceImpl.getDetailHead(masterIdDto));
	}

	/**
	 * Test create ag office detail.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testCreateAgOfficeDetail() throws CustomException {

		when(agSdRepo
				.findByLcOpenReqHdrIdLcOpenReqHdrIdAndMajorHeadIdMajorHeadIdAndSubmajorheadIdSubMajorHeadIdAndSubheadIdSubHeadIdAndDetailheadIdDetailHeadIdAndMinorheadIdMinorHeadId(
						Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
						Mockito.anyLong())).thenReturn(locAccountOpenReqAgSdEntity);

		when(accOpenReqAgSdDto.getLcOpenReqAgId()).thenReturn(JunitConstants.LONG_TYPE);
		when(locAccOpenReqAgSdCon.toEntity(accOpenReqAgSdDto)).thenReturn(locAccountOpenReqAgSdEntity);
		when(agSdRepo.save(locAccountOpenReqAgSdEntity)).thenReturn(locAccountOpenReqAgSdEntity);
		when(locAccOpenReqAgSdCon.toDTO(locAccountOpenReqAgSdEntity)).thenReturn(accOpenReqAgSdDto);

		serviceImpl.createAgOfficeDetail(accOpenReqAgSdDto);

		when(agSdRepo
				.findByLcOpenReqHdrIdLcOpenReqHdrIdAndMajorHeadIdMajorHeadIdAndSubmajorheadIdSubMajorHeadIdAndSubheadIdSubHeadIdAndDetailheadIdDetailHeadIdAndMinorheadIdMinorHeadId(
						Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
						Mockito.anyLong())).thenReturn(null);

		when(accOpenReqAgSdDto.getLcOpenReqAgId()).thenReturn(JunitConstants.LONG_TYPE);
		serviceImpl.createAgOfficeDetail(accOpenReqAgSdDto);

	}

	/**
	 * Test get account open req dtl.
	 */
	@Test
	void testGetAccountOpenReqDtl() {
		when(sdRepo.getAccountOpenReqDtlByHdrIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(locAccOpenReqDtlDto);
		when(dtlRepo.getAccountOpenReqDtlByHdrIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(locAccOpenReqDtlDto);
		assertNotNull(serviceImpl.getAccountOpenReqDtl(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE));
		assertNotNull(serviceImpl.getAccountOpenReqDtl(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE_ZERO));
	}

	/**
	 * Test get ag office detail.
	 * 
	 * @throws CustomException
	 */
	@Test
	void testGetAgOfficeDetail1() throws CustomException {
		Object[] object = new Object[21];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.DATE;
		object[5] = JunitConstants.LONG_TYPE;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.LONG_TYPE;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.LONG_TYPE;
		object[10] = JunitConstants.STRING_ABC;
		object[11] = JunitConstants.LONG_TYPE;
		object[12] = JunitConstants.STRING_ABC;
		object[13] = JunitConstants.LONG_TYPE;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.LONG_TYPE;
		object[17] = JunitConstants.LONG_TYPE;
		object[18] = JunitConstants.LONG_TYPE;
		object[19] = JunitConstants.LONG_TYPE;
		object[20] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(agDtlRepo.getEditViewData(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(objects);

		serviceImpl.getAgOfficeDetail(JunitConstants.LONG_TYPE, 2);
//		  serviceImpl.getAgOfficeDetail(JunitConstants.LONG_TYPE,
//		  JunitConstants.INTEGER_TYPE_ZERO);

	}

	/**
	 * Test get ag office detail.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAgOfficeDetail() throws CustomException {
		Object[] object = new Object[21];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.DATE;
		object[5] = JunitConstants.LONG_TYPE;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.LONG_TYPE;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.LONG_TYPE;
		object[10] = JunitConstants.STRING_ABC;
		object[11] = JunitConstants.LONG_TYPE;
		object[12] = JunitConstants.STRING_ABC;
		object[13] = JunitConstants.LONG_TYPE;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.LONG_TYPE;
		object[17] = JunitConstants.LONG_TYPE;
		object[18] = JunitConstants.LONG_TYPE;
		object[19] = JunitConstants.LONG_TYPE;
		object[20] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(agSdRepo.getEditViewData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(objects);
		assertNotNull(serviceImpl.getAgOfficeDetail(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE));

	}

	/**
	 * Test get division office detail.
	 */
	@Test
	void testGetDivisionOfficeDetail() {
		when(locAccountOpenReqDivisionSdRepository.getDiviReqDtlByHdrIdAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(divReqDto);
		when(locAccOpenreqDiviRepo.getDiviReqDtlByHdrIdAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(divReqDto);
		assertNotNull(serviceImpl.getDivisionOfficeDetail(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE));
		assertNotNull(serviceImpl.getDivisionOfficeDetail(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE_ZERO));
	}

	/**
	 * Test create division office detail.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testCreateDivisionOfficeDetail() throws CustomException {
		when(hdrRepo.getDivCdFromLocSd(Mockito.anyLong(), Mockito.anyString(), Mockito.anyInt())).thenReturn(null);
		when(hdrRepo.getDivCdFromMsDiv(Mockito.anyLong(), Mockito.anyString(), Mockito.anyInt())).thenReturn(null);
		when(locAccountOpenReqDivisionSdRepository.save(locAccountOpenReqDivisionSdConverter.toEntity(dto)))
				.thenReturn(locAccountOpenReqDivisionSdEntity);
		when(locAccountOpenReqDivisionSdConverter.toDTO(locAccountOpenReqDivisionSdEntity)).thenReturn(dto);
		LocAccountOpenReqDivisionSdDto dto1 = new LocAccountOpenReqDivisionSdDto();
		dto1.setDivisionCd("dd");
		assertNotNull(serviceImpl.createDivisionOfficeDetail(dto1));
		when(hdrRepo.getDivCdFromLocSd(Mockito.anyLong(), Mockito.anyString(), Mockito.anyInt())).thenReturn(null);
		when(hdrRepo.getDivCdFromMsDiv(Mockito.anyLong(), Mockito.anyString(), Mockito.anyInt())).thenReturn(null);
		when(locAccountOpenReqDivisionSdRepository.save(locAccountOpenReqDivisionSdConverter.toEntity(dto)))
				.thenReturn(new LocAccountOpenReqDivisionSdEntity());
		serviceImpl.createDivisionOfficeDetail(dto1);
	}

	/**
	 * Test get bank office detail.
	 * 
	 * @throws CustomException
	 */
	@Test
	void testGetBankOfficeDetail() throws CustomException {
		when(locAccountOpenReqBankSdRepository.getBankReqDtlByHdrIdAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(bankReqDtlDto);
		when(locAccOpenreqBankRepo.getBankReqDtlByHdrIdAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(bankReqDtlDto);
		assertNotNull(serviceImpl.getBankOfficeDetail(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE));
		assertNotNull(serviceImpl.getBankOfficeDetail(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE_ZERO));

	}

	/**
	 * Test create bank office detail.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testCreateBankOfficeDetail() throws CustomException {
		when(locAccountOpenReqBankSdRepository.findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(
				JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE)).thenReturn(locAccountOpenReqBankSdEntity);
		when(locAccountOpenReqBankSdRepository.save(locAccountOpenReqBankSdConverter.toEntity(bankSdDto)))
				.thenReturn(locAccountOpenReqBankSdEntity);
		doNothing().when(locAccountOpenReqBankSdRepository).updateAccountOpenReqBankSd(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.STRING_TYPE);
		serviceImpl.createBankOfficeDetail(bankSdDto);
	}

	/**
	 * Test create bank office detail 1.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testCreateBankOfficeDetail1() throws CustomException {
		when(locAccountOpenReqBankSdRepository.findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(
				JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE)).thenReturn(locAccountOpenReqBankSdEntity);
		locAccountOpenReqBankSdEntity.setBankBranchId(JunitConstants.LONG_TYPE);
		doNothing().when(locAccountOpenReqBankSdRepository).updateAccountOpenReqBankSd(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.STRING_TYPE);
		LocAccountOpenReqBankSdDto bankSdDto = new LocAccountOpenReqBankSdDto();
		bankSdDto.setActiveStatus(JunitConstants.INTEGER_TYPE);
		bankSdDto.setLcOpenReqHdrId(JunitConstants.LONG_TYPE);
		assertNotNull(serviceImpl.createBankOfficeDetail(bankSdDto));
	}

	/**
	 * Test get all bank details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAllBankDetails() throws CustomException {
		Object[] obj = new Object[5];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.STRING_ABC;
		obj[2] = JunitConstants.LONG_TYPE;
		obj[3] = JunitConstants.STRING_ABC;
		obj[4] = JunitConstants.STRING_ABC;

		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		when(hdrRepo.getBankDetails(Mockito.anyLong(), Mockito.anyInt())).thenReturn(objList);
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(serviceImpl.getAllBankDetails(idDto));
	}

	/**
	 * Test validate ag office detail.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testValidateAgOfficeDetail() throws CustomException {
		when(locAccOpenReqAgSdRepo.findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(locAccountOpenReqAgSdEntity);
		assertNotNull(serviceImpl.validateAgOfficeDetail(agDtlDto));
	}

	/**
	 * Test get loc open req submit details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetLocOpenReqSubmitDetails() throws CustomException {
		Object[] object = new Object[18];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.LONG_TYPE;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.LONG_TYPE;
		object[13] = JunitConstants.LONG_TYPE;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.DATE;
		object[16] = JunitConstants.LONG_TYPE;
		object[17] = JunitConstants.LONG_TYPE;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(serviceImpl.getLocOpenReqSubmitDetails(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get loc open req view details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetLocOpenReqViewDetails() throws CustomException {
		Object[] object = new Object[11];
		object[0] = JunitConstants.STRING_ABC;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.LONG_TYPE;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.INT_TYPE;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(serviceImpl.getLocOpenReqViewDetails(pageDetail));

	}

	/**
	 * Test get loc open req ag view details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetLocOpenReqAgViewDetails() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(serviceImpl.getLocOpenReqAgViewDetails(pageDetail));

	}

	/**
	 * Test get loc open req bank view details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetLocOpenReqBankViewDetails() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(serviceImpl.getLocOpenReqBankViewDetails(pageDetail));

	}

	/**
	 * Test get loc open req divi view details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetLocOpenReqDiviViewDetails() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(serviceImpl.getLocOpenReqDiviViewDetails(pageDetail));

	}

	/**
	 * Test get open listing data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetOpenListingData() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		assertNotNull(serviceImpl.getOpenListingData(pageDetail));

	}

	/**
	 * Test get request param.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetRequestParam() throws CustomException {
		Object[] object = new Object[13];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.LONG_TYPE;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getOpenReqSrchPrm()).thenReturn(objects);
		assertNotNull(serviceImpl.getRequestParam());
	}

	/**
	 * Test submit data.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmitData() throws CustomException {

		Object[] obj = new Object[1];
		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		when(hdrRepo.callStoredProcedureWithNoResult(Mockito.anyString(), Mockito.anyMap())).thenReturn(objList);
		submitWfDto.setTrnStatus(JunitConstants.STATUS);
		when(submitWfDto.getIsAg()).thenReturn(JunitConstants.TRUE_V);
		when(submitWfDto.getIsTo()).thenReturn(JunitConstants.TRUE_V);
		when(submitWfDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(submitWfDto.getTrnStatus()).thenReturn("Authorized");
		when(submitWfDto.getWfId()).thenReturn(JunitConstants.LONG_TYPE);
		when(submitWfDto.getAssignByWfRoleId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyLong())).thenReturn(edp);
		when(edp.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		serviceImpl.submitData(submitWfDto);
		when(submitWfDto.getIsAg()).thenReturn(JunitConstants.FALSE_V);
		serviceImpl.submitData(submitWfDto);
		when(submitWfDto.getIsTo()).thenReturn(JunitConstants.FALSE_V);
		serviceImpl.submitData(submitWfDto);

	}

	/**
	 * Testcreate loc acc req hdr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testcreateLocAccReqHdr() throws CustomException {
		Object[] obj = new Object[0];
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyLong())).thenReturn(edp);
		when(hdrRepo.getDivsionIdFromOfficeId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString(),
				Mockito.anyLong(), Mockito.anyInt(), Mockito.anyShort(), Mockito.anyLong())).thenReturn(obj);
		when(hdrRepo
				.findByDeptIdReHdrDepartmentIdAndHodIdAndToOfficeIdOfficeIdAndDistrictIdReHdrDistrictIdAndActiveStatusAndStatusIdLookUpInfoIdNotIn(
						Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt(),
						Mockito.anySet())).thenReturn(hdrEntity);
		when(hdrConverter.toEntity(hdrDto)).thenReturn(hdrEntity);
		when(hdrRepo.save(hdrEntity)).thenReturn(hdrEntity);
		when(hdrDto.getLocAccountOpenReqSdDto()).thenReturn(sdDto);
		when(hdrEntity.getLcOpenReqHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(sdConverter.toEntity(sdDto)).thenReturn(sdEntity);
		when(sdRepo.save(sdEntity)).thenReturn(sdEntity);
		when(sdRepo.updateAccountOpenReqSd(Mockito.anyLong(), Mockito.anyString(), Mockito.anyLong(),
				Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(JunitConstants.INTEGER_TYPE);
		when(locAccountOpenReqWfRepository.findByTrnIdLcOpenReqHdrIdAndActiveStatus(Mockito.anyLong(),
				Mockito.anyInt())).thenReturn(locAccountOpenReqWfEntity);
		List<Long> listLong = new ArrayList<>();
		listLong.add(JunitConstants.LONG_TYPE);

		when(hdrRepo.getExistTrnId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(listLong);

		assertNotNull(serviceImpl.createLocAccReqHdr(hdrDto));

		when(hdrRepo
				.findByDeptIdReHdrDepartmentIdAndHodIdAndToOfficeIdOfficeIdAndDistrictIdReHdrDistrictIdAndActiveStatusAndStatusIdLookUpInfoIdNotIn(
						Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt(),
						Mockito.anySet())).thenReturn(null);
		when(locAccountOpenReqWfRepository.findByTrnIdLcOpenReqHdrIdAndActiveStatus(Mockito.anyLong(),
				Mockito.anyInt())).thenReturn(null);
		when(hdrDto.getWfUserReqSDDto()).thenReturn(wfUserDto);
		when(locWfActionConfigService.saveWfActConfigTrn(wfUserDto)).thenReturn(JunitConstants.INTEGER_TYPE);
		serviceImpl.createLocAccReqHdr(hdrDto);
	}
//
//	/**
//	 * Test get division validation.
//	 */
//	@Test
//	void testGetDivisionValidation() {
//		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
//				Mockito.anyInt(), Mockito.anyLong())).thenReturn(edp);
//		when(hdrRepo
//				.findByDeptIdReHdrDepartmentIdAndHodIdAndToOfficeIdOfficeIdAndDistrictIdReHdrDistrictIdAndActiveStatusAndStatusIdLookUpInfoIdNotIn(
//						Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt(),
//						Mockito.anySet())).thenReturn(hdrEntity);
//		assertNotNull(serviceImpl.getDivisionValidation(hdrDto));
//	}

	/**
	 * Test get circle by department.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetCircleByDepartment() throws CustomException {
		Object[] obj = new Object[3];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.STRING_ABC;
		obj[2] = JunitConstants.STRING_ABC;
		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		Object[] obj1 = new Object[3];
		obj1[0] = JunitConstants.LONG_TYPE;
		obj1[1] = JunitConstants.STRING_ABC;

		List<Object[]> objList1 = new ArrayList<>();
		objList1.add(obj1);

		when(hdrRepo.getCircleByDepartmentId(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(objList);
		when(chqBookHdrRepo.getLookupIdandName(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(objList1);
		when(idNameDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(idNameDto.getName()).thenReturn(JunitConstants.STRING_ABC);
		assertNotNull(serviceImpl.getCircleByDepartment(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test delete by id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteById() throws CustomException {
		assertNotNull(serviceImpl.deleteById(idDto));

	}

	@Test
	void testGenAuthLetter() throws CustomException {
		Object[] object = new Object[26];
		object[25] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("header", locAccOpenReqDtlDto);
		inputMap.put("chqDtl", "abc");
		inputMap.put("pstDtl", "wer");
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dtlRepo.getAccountOpenReqDtlByHdrIdAndActiveStatus(idDto.getId(), Constant.ACTIVE_STATUS))
				.thenReturn(locAccOpenReqDtlDto);

		when(locAccOpenReqAgDtlRepo.getEditViewData(idDto.getId(), Constant.ACTIVE_STATUS)).thenReturn(objects);

		when(pdfService.generatePDF(LocURLConstant.ADVICE_STATEMENT_FTL_FILE, inputMap,
				LocConstant.ADVICE_PDF_FILE_NAME + locAccOpenReqDtlDto.getRefNo()))
						.thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(serviceImpl.genAuthLetter(idDto));
	}

}

package gov.ifms.loc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.beans.BeanUtils;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.converter.LocAdvcPrepCheqPaySdConverter;
import gov.ifms.loc.converter.LocAdviceDeductionSdConverter;
import gov.ifms.loc.converter.LocAdvicePrepHdrConverter;
import gov.ifms.loc.converter.LocMsAdviceDtlConvertor;
import gov.ifms.loc.dto.LocActiveDeductionEditViewDto;
import gov.ifms.loc.dto.LocAdvcPrepCheqPaySdDto;
import gov.ifms.loc.dto.LocAdviceChqTypeListDto;
import gov.ifms.loc.dto.LocAdviceDeductionDto;
import gov.ifms.loc.dto.LocAdviceDeductionSdDto;
import gov.ifms.loc.dto.LocAdviceDtlEditViewDto;
import gov.ifms.loc.dto.LocAdvicePartHeadwisedetaisSdDto;
import gov.ifms.loc.dto.LocAdvicePostingHeadwisedetaisDto;
import gov.ifms.loc.dto.LocAdvicePrepDtlDto;
import gov.ifms.loc.dto.LocAdvicePrepHdrDto;
import gov.ifms.loc.dto.LocAdviceReqParamDto;
import gov.ifms.loc.dto.LocCheckPayEditViewDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocMsAdviceDtlDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocAdvcPrepCheqPaySdEntity;
import gov.ifms.loc.entity.LocAdviceDeductionDetailsEntity;
import gov.ifms.loc.entity.LocAdviceDeductionSdEntity;
import gov.ifms.loc.entity.LocAdvicePartHeadwiseSdEntity;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;
import gov.ifms.loc.entity.LocAdvicePrepWfEntity;
import gov.ifms.loc.entity.LocMsAdviceDtlEntity;
import gov.ifms.loc.entity.LocMsDivisonEntity;
import gov.ifms.loc.repository.LocAdvcPrepCheqPayDtlRepository;
import gov.ifms.loc.repository.LocAdvcPrepCheqPaySdRepository;
import gov.ifms.loc.repository.LocAdviceDeductionSdRepository;
import gov.ifms.loc.repository.LocAdvicePartHeadwiseSdRepository;
import gov.ifms.loc.repository.LocAdvicePartyDetaisRepository;
import gov.ifms.loc.repository.LocAdvicePrepHdrRepository;
import gov.ifms.loc.repository.LocAdvicePrepWfRepository;
import gov.ifms.loc.repository.LocAdvicedeductionDetailsRepository;
import gov.ifms.loc.repository.LocDistributionHeadDtlRepository;
import gov.ifms.loc.repository.LocMsAdviceEntityRepostory;
import gov.ifms.loc.serviceimpl.LocAdvicePrepServiceImpl;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocURLConstant;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocAdvicePrepServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class LocAdvicePrepServiceImplTest {

	/** The service. */
	@InjectMocks
	private LocAdvicePrepServiceImpl service;

	/** The loc acc close req param dto. */
	@Mock
	private LocAdviceReqParamDto locAccCloseReqParamDto;

	/** The hdr repo. */
	@Mock
	private LocAdvicePrepHdrRepository hdrRepo;

	/** The loc adv prep hdr dto. */
	@Mock
	private LocAdvicePrepHdrDto locAdvPrepHdrDto;

	/** The hdr converter. */
	@Mock
	private LocAdvicePrepHdrConverter hdrConverter;

	/** The hdr entity. */
	@Mock
	private LocAdvicePrepHdrEntity hdrEntity;

	/** The cheq pay sd dto. */
	@Mock
	private LocAdvcPrepCheqPaySdDto cheqPaySdDto;

	/** The sd converter. */
	@Mock
	private LocAdvcPrepCheqPaySdConverter sdConverter;

	/** The sd repository. */
	@Mock
	private LocAdvcPrepCheqPaySdRepository sdRepository;
	/**
	 * The check pay dtl repo.
	 */
	@Mock
	private LocAdvcPrepCheqPayDtlRepository checkPayDtlRepo;

	/** The wf repo. */
	@Mock
	private LocAdvicePrepWfRepository wfRepo;

	/** The wf entity. */
	@Mock
	private LocAdvicePrepWfEntity wfEntity;

	/** The ded sd dto. */
	@Mock
	private LocAdviceDeductionSdDto dedSdDto;

	/** The deduction dto. */
	@Mock
	private LocAdviceDeductionDto deductionDto;

	/** The ded sd entity. */
	@Mock
	private LocAdviceDeductionSdEntity dedSdEntity;

	/** The ded sd repo. */
	@Mock
	private LocAdviceDeductionSdRepository dedSdRepo;

	/** The hdr sd converter. */
	@Mock
	private LocAdviceDeductionSdConverter hdrSdConverter;

	/** The deduction edit view dto. */
	@Mock
	LocActiveDeductionEditViewDto deductionEditViewDto;

	/** The dtl repo. */
	@Mock
	private LocAdvicedeductionDetailsRepository dtlRepo;

	/** The hrd sd repository. */
	@Mock
	private LocAdviceDeductionSdRepository hrdSdRepository;

	/** The entity. */
	@Mock
	LocAdviceDeductionDetailsEntity entity;

	/** The deduction sd converter. */
	@Mock
	private LocAdviceDeductionSdConverter deductionSdConverter;

	/** The chq book edit viewdto. */
	@Mock
	private LocChqBookEditViewDto chqBookEditViewdto;

	/** The id dto. */
	@Mock
	private IdDto idDto;

	/** The advice repo. */
	@Mock
	private LocMsAdviceEntityRepostory adviceRepo;

	/** The advice type list. */
	@Mock
	private List<LocMsAdviceDtlEntity> adviceTypeList;

	/** The advice type convertor. */
	@Mock
	private LocMsAdviceDtlConvertor adviceTypeConvertor;

	/** The advice dto. */
	@Mock
	private List<LocMsAdviceDtlDto> adviceDto;

	/** The posting head wise dto. */
	@Mock
	private LocAdvicePostingHeadwisedetaisDto postingHeadWiseDto;

	/** The submit wf dto. */
	@Mock
	private LocSubmitWfDto submitWfDto;

	/** The wfsd dto. */
	@Mock
	private WfUserReqSDDto wfsdDto;

	/**
	 * The loc wf action config service.
	 */
	@Mock
	private LocWfActionConfigService locWfActionConfigService;

	/** The look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/** The edp. */
	@Mock
	private EDPLuLookUpInfoEntity edp;

	/** The district. */
	@Mock
	private EDPMsDistrictEntity district;

	/** The divison. */
	@Mock
	private LocMsDivisonEntity divison;

	/** The advice chq type dto. */
	@Mock
	private LocAdviceChqTypeListDto adviceChqTypeDto;

	/** The chek pay edit view dto. */
	@Mock
	private LocCheckPayEditViewDto chekPayEditViewDto;

	/**
	 * The distribution dtl repo.
	 */
	@Mock
	private LocDistributionHeadDtlRepository distributionDtlRepo;

	/**
	 * The party head wise repository.
	 */
	@Mock
	private LocAdvicePartHeadwiseSdRepository partyHeadWiseRepository;

	/** The party head wise sd entity. */
	@Mock
	LocAdvicePartHeadwiseSdEntity partyHeadWiseSdEntity;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The search param. */
	@Mock
	private SearchParam searchParam;

	/** The sd entity list. */
	@Mock
	List<LocAdvcPrepCheqPaySdEntity> sdEntityList;

	/** The sd entity. */
	@Mock
	LocAdvcPrepCheqPaySdEntity sdEntity;

	/** The cheq pay sd dto list. */
	@Mock
	List<LocAdvcPrepCheqPaySdDto> cheqPaySdDtoList;

	/** The advice hdr details. */
	@Mock
	LocAdviceDtlEditViewDto adviceHdrDetails;

	/** The pdf service. */
	@Mock
	private LocPDFService pdfService;

	@Mock
	private LocAdvicePrepDtlDto locAdvicePrepDtlDto;

	@Mock
	private LocAdvicePartyDetaisRepository partyDRepo;

	@Mock
	private LocAdvicedeductionDetailsRepository dtlRepos;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get advice dtl.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAdviceDtl() throws CustomException {
		List<Object[]> objLst = new ArrayList<>();
		Object[] obj = new Object[4];
		obj[0] = 1l;
		obj[1] = "Test";
		obj[2] = 1l;
		obj[3] = 1l;
		objLst.add(obj);
		List<Object[]> objLst1 = new ArrayList<>();
		Object[] obj1 = new Object[2];
		obj1[0] = 1l;
		obj1[1] = "Test";
		objLst1.add(obj1);
		when(locAccCloseReqParamDto.getCardexNo()).thenReturn(JunitConstants.LONG_TYPE);
		when(locAccCloseReqParamDto.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(locAccCloseReqParamDto.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(locAccCloseReqParamDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.getAdviceDtlBank(JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(objLst);
		when(hdrRepo.getAdviceDtlSubTreasuryTreas(JunitConstants.LONG_TYPE)).thenReturn(objLst1);
		assertNotNull(service.getAdviceDtl(locAccCloseReqParamDto));

	}

	/**
	 * Test advice dtl save wf.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testAdviceDtlSaveWf() throws CustomException {
		when(hdrRepo.save(hdrConverter.toEntity(locAdvPrepHdrDto))).thenReturn(hdrEntity);
		when(hdrEntity.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrConverter.toDTO(hdrEntity)).thenReturn(locAdvPrepHdrDto);
		when(sdConverter.toDTO(sdRepository.save(sdConverter.toEntity(cheqPaySdDto)))).thenReturn(cheqPaySdDto);
		when(locAdvPrepHdrDto.getWfUserReqSdDto()).thenReturn(wfsdDto);
		when(hdrRepo.getOne(JunitConstants.LONG_TYPE)).thenReturn(hdrEntity);
		when(locAdvPrepHdrDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(locAdvPrepHdrDto.getRaiseObjectionFlag()).thenReturn('C');
		when(locAdvPrepHdrDto.getRaiseObjectionRemarks()).thenReturn(JunitConstants.STRING_TYPE);
		when(hdrRepo.save(hdrEntity)).thenReturn(hdrEntity);
		when(wfRepo.findByTrnIdIdAndActiveStatus(hdrEntity.getId(), Constant.ACTIVE_STATUS)).thenReturn(null);

		assertNotNull(service.adviceDtlSave(locAdvPrepHdrDto));
	}

	/**
	 * Test deduction detailand update.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeductionDetailandUpdate() throws CustomException {
		when(deductionDto.getLocAdviceHrdId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.getOne(JunitConstants.LONG_TYPE)).thenReturn(hdrEntity);
		when(hdrEntity.getNetAmt()).thenReturn(JunitConstants.DOUBLE_VAL);
		when(hdrEntity.getGrossAmt()).thenReturn(JunitConstants.DOUBLE_VAL);
		when(hdrEntity.getClosingBalance()).thenReturn(JunitConstants.DOUBLE_VAL);
		when(hdrRepo.save(hdrEntity)).thenReturn(hdrEntity);
		BeanUtils.copyProperties(deductionDto, dedSdDto);
		when(hdrSdConverter.toDTO(dedSdEntity)).thenReturn(dedSdDto);
		when(hdrSdConverter.toDTO(dedSdRepo.save(hdrSdConverter.toEntity(dedSdDto)))).thenReturn(dedSdDto);
		assertNotNull(service.deductionDetailandUpdate(deductionDto));
	}

	/**
	 * Test get deduction dtl edit.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetDeductionDtlEdit() throws CustomException {

		when(deductionEditViewDto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(deductionEditViewDto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		deductionEditViewDto.setActionStatus(JunitConstants.INTEGER_TYPE);
		when(hrdSdRepository.findByLcAdviceIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(dedSdEntity);
		when(deductionSdConverter.toDTO(dedSdEntity)).thenReturn(dedSdDto);
		assertNotNull(service.getDeductionDtleditview(deductionEditViewDto));

	}

	/**
	 * Test get deduction dtl view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetDeductionDtlView() throws CustomException {

		when(deductionEditViewDto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(deductionEditViewDto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE_ZERO);
		when(dtlRepo.findByLcAdviceIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(entity);
		when(deductionSdConverter.dtlSdDto(entity)).thenReturn(dedSdDto);
		service.getDeductionDtleditview(deductionEditViewDto);

	}

	/**
	 * Test get advice dtl edit view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAdviceDtlEditView() throws CustomException {
		Object[] object = new Object[26];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.DATE;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.LONG_TYPE;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.LONG_TYPE;
		object[13] = JunitConstants.STRING_ABC;
		object[14] = JunitConstants.LONG_TYPE;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.LONG_TYPE;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.STRING_ABC;
		object[19] = JunitConstants.STRING_ABC;
		object[20] = JunitConstants.STRING_ABC;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.DATE;
		object[24] = JunitConstants.LONG_TYPE;
		object[25] = JunitConstants.LONG_TYPE;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getAdviceDtlEditData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(objects);
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		assertNotNull(service.getAdviceDtlEditView(chqBookEditViewdto));

	}

	/**
	 * Test get advice dtl edit view 1.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAdviceDtlEditView1() throws CustomException {
		Object[] object = new Object[26];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.DATE;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.LONG_TYPE;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.LONG_TYPE;
		object[13] = JunitConstants.STRING_ABC;
		object[14] = JunitConstants.LONG_TYPE;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.LONG_TYPE;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.STRING_ABC;
		object[19] = JunitConstants.STRING_ABC;
		object[20] = JunitConstants.STRING_ABC;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.DATE;
		object[24] = JunitConstants.LONG_TYPE;
		object[25] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getAdviceDtlViewData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(objects);
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE_ZERO);
		assertNotNull(service.getAdviceDtlEditView(chqBookEditViewdto));

	}

	/**
	 * Test delete.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDelete() throws CustomException {
		doNothing().when(hdrRepo).softDeleteById(JunitConstants.LONG_TYPE);
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.delete(idDto));

	}

	/**
	 * Test advice dtl save.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testAdviceDtlSave() throws CustomException {
		when(hdrRepo.save(hdrConverter.toEntity(locAdvPrepHdrDto))).thenReturn(hdrEntity);
		// when(locAdvPrepHdrDto.getLocAdvcSdDto()).thenReturn(cheqPaySdDto);
		when(hdrEntity.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrConverter.toDTO(hdrEntity)).thenReturn(locAdvPrepHdrDto);
		when(sdConverter.toDTO(sdRepository.save(sdConverter.toEntity(cheqPaySdDto)))).thenReturn(cheqPaySdDto);
		when(wfRepo.findByTrnIdIdAndActiveStatus(hdrEntity.getId(), Constant.ACTIVE_STATUS)).thenReturn(wfEntity);
		assertNotNull(service.adviceDtlSave(locAdvPrepHdrDto));
	}

	/**
	 * Test get advice cheque list type.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAdviceChequeListType() throws CustomException {
		Object[] object = new Object[2];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getLookupIdandName(LocConstant.LOC_PARENT_CHEQUE_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(objects);
		assertNotNull(service.getAdviceChequeListType());

	}

	/**
	 * Test get posting dtl advice type.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlAdviceType() throws CustomException {
		when(adviceRepo.findAll()).thenReturn(adviceTypeList);
		when(adviceTypeConvertor.toDTO(adviceTypeList)).thenReturn(adviceDto);
		assertNotNull(service.getPostingDtlAdviceType());
	}

	/**
	 * Test get posting dtls.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtls() throws CustomException {
		when(locAccCloseReqParamDto.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		Object[] object = new Object[25];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.LONG_TYPE;
		object[9] = JunitConstants.LONG_TYPE;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.STRING_ABC;
		object[13] = JunitConstants.STRING_ABC;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.STRING_ABC;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.STRING_ABC;
		object[19] = JunitConstants.STRING_ABC;
		object[20] = JunitConstants.STRING_ABC;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.STRING_ABC;
		object[24] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getAdvicePaymentDetails(JunitConstants.STRING_ABC, Constant.LU_APPROVED_LOOKUP_INFO_ID))
				.thenReturn(objects);
		assertNotNull(service.getPostingDtls(locAccCloseReqParamDto));
	}

	/**
	 * Test get posting dtls search lc.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlsSearchLc() throws CustomException {
		when(postingHeadWiseDto.getFundType()).thenReturn(LocConstant.PUBLIC_ACCOUNT);
		Object[] object = new Object[13];
		object[0] = JunitConstants.STRING_ABC;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.STRING_ABC;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getAdvicePaymentDetailsLCSearchPA(JunitConstants.STRING_ABC, Constant.LU_APPROVED_LOOKUP_INFO_ID,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE)).thenReturn(objects);
		assertNotNull(service.getPostingDtlsSearchLc(postingHeadWiseDto));
	}

	/**
	 * Test get posting dtls search lc 1.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlsSearchLc1() throws CustomException {
		when(postingHeadWiseDto.getEstimateType()).thenReturn("Standing");

		Object[] object = new Object[13];
		object[0] = JunitConstants.STRING_ABC;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.STRING_ABC;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(hdrRepo.getAdvicePaymentDetailsLCSearchSC(JunitConstants.STRING_ABC, Constant.LU_APPROVED_LOOKUP_INFO_ID,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.STRING_TYPE)).thenReturn(objects);
		assertNotNull(service.getPostingDtlsSearchLc(postingHeadWiseDto));
	}

	/**
	 * Test get posting dtls search lc 2.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlsSearchLc2() throws CustomException {
		when(postingHeadWiseDto.getEstimateType()).thenReturn(JunitConstants.STRING_TYPE);
		Object[] object = new Object[13];
		object[0] = JunitConstants.STRING_ABC;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.STRING_ABC;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(hdrRepo.getAdvicePaymentDetailsLCSearch(JunitConstants.STRING_ABC, Constant.LU_APPROVED_LOOKUP_INFO_ID,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.STRING_TYPE)).thenReturn(objects);
		assertNotNull(service.getPostingDtlsSearchLc(postingHeadWiseDto));
	}

	/**
	 * Test get posting dtl edit view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlEditView() throws CustomException {
		Object[] object = new Object[34];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
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
		object[13] = JunitConstants.STRING_ABC;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.STRING_ABC;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.STRING_ABC;
		object[19] = JunitConstants.STRING_ABC;
		object[20] = JunitConstants.LONG_TYPE;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.STRING_ABC;
		object[24] = JunitConstants.STRING_ABC;
		object[25] = JunitConstants.STRING_ABC;
		object[26] = JunitConstants.STRING_ABC;
		object[27] = JunitConstants.DOUBLE_VAL;
		object[28] = JunitConstants.DOUBLE_VAL;
		object[29] = JunitConstants.STRING_ABC;
		object[30] = JunitConstants.LONG_TYPE;
		object[31] = JunitConstants.STRING_ABC;
		object[32] = JunitConstants.LONG_TYPE;
		object[33] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(hdrRepo.getPostingDtlEditData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(objects);
		assertNotNull(service.getPostingDtlEditView(chqBookEditViewdto));

		List<Object[]> objects1 = new ArrayList<>();
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(hdrRepo.getPostingDtlEditData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(objects1);
		assertNotNull(service.getPostingDtlEditView(chqBookEditViewdto));

	}

	/**
	 * Test get posting dtls edit view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlsEditView() throws CustomException {

		Object[] object = new Object[34];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
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
		object[13] = JunitConstants.STRING_ABC;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.STRING_ABC;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.STRING_ABC;
		object[19] = JunitConstants.STRING_ABC;
		object[20] = JunitConstants.LONG_TYPE;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.STRING_ABC;
		object[24] = JunitConstants.STRING_ABC;
		object[25] = JunitConstants.STRING_ABC;
		object[26] = JunitConstants.STRING_ABC;
		object[27] = JunitConstants.DOUBLE_VAL;
		object[28] = JunitConstants.DOUBLE_VAL;
		object[29] = JunitConstants.STRING_ABC;
		object[30] = JunitConstants.LONG_TYPE;
		object[31] = JunitConstants.STRING_ABC;
		object[32] = JunitConstants.LONG_TYPE;
		object[33] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE_ZERO);
		when(hdrRepo.getPostingDtlViewData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(objects);
		assertNotNull(service.getPostingDtlEditView(chqBookEditViewdto));

	}

	/**
	 * Test submit.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmit() throws CustomException {
		Object[] obj = new Object[1];
		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		when(hdrRepo.callStoredProcedureWithNoResult(Mockito.anyString(), Mockito.anyMap())).thenReturn(objList);
		when(submitWfDto.getTrnStatus()).thenReturn(JunitConstants.STATUS);
		when(submitWfDto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyLong())).thenReturn(edp);
		when(hdrRepo.findByIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(hdrEntity);
		when(hdrEntity.getDistrictId()).thenReturn(district);
		when(hdrEntity.getDistrictId().getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrEntity.getDivId()).thenReturn(divison);
		when(hdrEntity.getDivId().getDivisonId()).thenReturn(JunitConstants.LONG_TYPE);
		obj[0] = JunitConstants.STRING_ABC;
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objList);
		doNothing().when(hdrRepo).updateFlaginAdvice(JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE);
		service.submit(submitWfDto);

	}

	/**
	 * Test get posting dtls map epaymnt.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlsMapEpaymnt() throws CustomException {

		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.DOUBLE_VAL;
		object[5] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getPostingDtlMapEpymntEdit(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(objects);
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		assertNotNull(service.getPostingDtlMapEpymt(chqBookEditViewdto));

		List<Object[]> objects1 = new ArrayList<>();
		when(hdrRepo.getPostingDtlMapEpymntEdit(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(objects1);
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		service.getPostingDtlMapEpymt(chqBookEditViewdto);

	}

	/**
	 * Test get posting dtl map epymt view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlMapEpymtView() throws CustomException {

		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.DOUBLE_VAL;
		object[5] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getPostingDtlMapEpymntView(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(objects);
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE_ZERO);
		assertNotNull(service.getPostingDtlMapEpymt(chqBookEditViewdto));

		List<Object[]> objects1 = new ArrayList<>();
		when(hdrRepo.getPostingDtlMapEpymntView(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(objects1);
		when(chqBookEditViewdto.getHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chqBookEditViewdto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE_ZERO);
		service.getPostingDtlMapEpymt(chqBookEditViewdto);

	}

	/**
	 * Test get cheque type listing employee.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetChequeTypeListingEmployee() throws CustomException {
		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.DOUBLE_VAL;
		object[5] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(adviceChqTypeDto.getChqListTypeId()).thenReturn(LocConstant.LOC_CHQ_TYPE_EMPLOYEE);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getChequeTypeLisiting(adviceChqTypeDto));
	}

	/**
	 * Test get cheque type listing.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetChequeTypeListing() throws CustomException {
		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.DOUBLE_VAL;
		object[5] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getChequeTypeLisiting(adviceChqTypeDto));
	}

	/**
	 * Test get cheque type search data employee.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetChequeTypeSearchDataEmployee() throws CustomException {
		Object[] object = new Object[2];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(adviceChqTypeDto.getChqListTypeId()).thenReturn(LocConstant.LOC_CHQ_TYPE_EMPLOYEE);
		when(hdrRepo.getLookupIdandName(LocConstant.LOC_DESIGNATION_ID, Constant.ACTIVE_STATUS)).thenReturn(objects);
		when(hdrRepo.getDesignationList(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(objects);
		assertNotNull(service.getChequeTypeSearchData(adviceChqTypeDto));

		when(adviceChqTypeDto.getChqListTypeId()).thenReturn(LocConstant.LOC_PARENT_CHEQUE_TYPE);
		when(hdrRepo.getLookupIdandName(LocConstant.LOC_PARENT_CHEQUE_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(objects);
		service.getChequeTypeSearchData(adviceChqTypeDto);
	}

	/**
	 * Test check pay delete.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testCheckPayDelete() throws CustomException {
		doNothing().when(sdRepository).softDeleteById(JunitConstants.LONG_TYPE);
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.checkPayDelete(idDto));
	}

	/**
	 * Test get chek pay edit.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetChekPayEdit() throws CustomException {
		Object[] object = new Object[9];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.DOUBLE_VAL;
		object[6] = JunitConstants.DATE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(chekPayEditViewDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chekPayEditViewDto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(sdRepository.getPostingDtlViewData(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(objects);
		assertNotNull(service.getCheckPayEditView(chekPayEditViewDto));

		List<Object[]> objects1 = new ArrayList<>();
		when(chekPayEditViewDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chekPayEditViewDto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(sdRepository.getPostingDtlViewData(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(objects1);
		assertNotNull(service.getCheckPayEditView(chekPayEditViewDto));
	}

	/**
	 * Test get chek pay view.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetChekPayView() throws CustomException {
		Object[] object = new Object[9];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.DOUBLE_VAL;
		object[6] = JunitConstants.DATE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(chekPayEditViewDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chekPayEditViewDto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE_ZERO);
		when(checkPayDtlRepo.getPostingDtlEditData(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(objects);
		assertNotNull(service.getCheckPayEditView(chekPayEditViewDto));

		List<Object[]> objects1 = new ArrayList<>();
		when(chekPayEditViewDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(chekPayEditViewDto.getActionStatus()).thenReturn(JunitConstants.INTEGER_TYPE_ZERO);
		when(checkPayDtlRepo.getPostingDtlEditData(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(objects1);
		assertNotNull(service.getCheckPayEditView(chekPayEditViewDto));
	}

	/**
	 * Test get header info.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetHeaderInfo() throws CustomException {
		Object[] object = new Object[9];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.DATE;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.LONG_TYPE;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getHeaderAdviceList(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE)).thenReturn(objects);
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.getHeaderInfo(idDto));
	}

	/**
	 * Test get all demand list.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAllDemandList() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(distributionDtlRepo.getDemandList(JunitConstants.STRING_ABC, JunitConstants.STRING_ABC,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, LocConstant.LOC_AUTHORIZED_ID))
						.thenReturn(objects);
		assertNotNull(service.getAllDemandList(postingHeadWiseDto));
	}

	/**
	 * Test get major head list PA.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetMajorHeadListPA() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(postingHeadWiseDto.getFundType()).thenReturn(LocConstant.PUBLIC_ACCOUNT);
		when(distributionDtlRepo.getMajorHeadListPA(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getMajorHeadList(postingHeadWiseDto));
	}

	/**
	 * Test get major head list.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetMajorHeadList() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(postingHeadWiseDto.getFundType()).thenReturn(JunitConstants.STRING_TYPE);
		when(distributionDtlRepo.getMajorHeadList(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE,
				LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getMajorHeadList(postingHeadWiseDto));
	}

	/**
	 * Test get sub major head list PA.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSubMajorHeadListPA() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(postingHeadWiseDto.getFundType()).thenReturn(LocConstant.PUBLIC_ACCOUNT);
		when(distributionDtlRepo.getSubMajorHeadListPA(JunitConstants.STRING_ABC, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getSubMajorHeadList(postingHeadWiseDto));
	}

	/**
	 * Test get sub major head list.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSubMajorHeadList() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(postingHeadWiseDto.getFundType()).thenReturn(JunitConstants.STRING_TYPE);
		when(distributionDtlRepo.getSubMajorHeadList(JunitConstants.STRING_ABC, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getSubMajorHeadList(postingHeadWiseDto));
	}

	/**
	 * Test get fund type.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetFundType() throws CustomException {
		Object[] object = new Object[2];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getLookupIdandName(LocConstant.FUND_TYPE_PARENT_LOOK_UP_ID, Constant.ACTIVE_STATUS))
				.thenReturn(objects);
		assertNotNull(service.getFundType());
		List<Object[]> objects1 = new ArrayList<>();
		when(hdrRepo.getLookupIdandName(LocConstant.FUND_TYPE_PARENT_LOOK_UP_ID, Constant.ACTIVE_STATUS))
				.thenReturn(objects1);
		service.getFundType();

	}

	/**
	 * Test get charged voted.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetChargedVoted() throws CustomException {
		Object[] object = new Object[2];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getLookupIdandName(LocConstant.CHARGED_VOTED_PARENT_LOOK_UP_ID, Constant.ACTIVE_STATUS))
				.thenReturn(objects);
		assertNotNull(service.getChargedVoted());
		List<Object[]> objects1 = new ArrayList<>();
		when(hdrRepo.getLookupIdandName(LocConstant.CHARGED_VOTED_PARENT_LOOK_UP_ID, Constant.ACTIVE_STATUS))
				.thenReturn(objects1);
		service.getChargedVoted();

	}

	/**
	 * Test get budget type.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetBudgetType() throws CustomException {
		Object[] object = new Object[2];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.getLookupIdandNameBudgetType(LocConstant.BUDGET_TYPE_PARENT_LOOK_UP_ID, Constant.ACTIVE_STATUS))
				.thenReturn(objects);
		assertNotNull(service.getBudgetType());
		List<Object[]> objects1 = new ArrayList<>();
		when(hdrRepo.getLookupIdandNameBudgetType(LocConstant.BUDGET_TYPE_PARENT_LOOK_UP_ID, Constant.ACTIVE_STATUS))
				.thenReturn(objects1);
		service.getBudgetType();

	}

	/**
	 * Test get minor head list PA.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetMinorHeadListPA() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(postingHeadWiseDto.getFundType()).thenReturn(LocConstant.PUBLIC_ACCOUNT);
		when(distributionDtlRepo.getMinorHeadListPA(JunitConstants.STRING_TYPE, JunitConstants.STRING_ABC,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getMinorHeadList(postingHeadWiseDto));
	}

	/**
	 * Test get minor head list.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetMinorHeadList() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(postingHeadWiseDto.getFundType()).thenReturn(JunitConstants.STRING_TYPE);
		when(distributionDtlRepo.getMinorHeadList(JunitConstants.STRING_ABC, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getMinorHeadList(postingHeadWiseDto));
	}

	/**
	 * Test get sub head list PA.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSubHeadListPA() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(postingHeadWiseDto.getFundType()).thenReturn(LocConstant.PUBLIC_ACCOUNT);
		when(distributionDtlRepo.getSubHeadListPA(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getSubHeadList(postingHeadWiseDto));
	}

	/**
	 * Test get sub head list.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSubHeadList() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(postingHeadWiseDto.getFundType()).thenReturn(JunitConstants.STRING_TYPE);
		when(distributionDtlRepo.getSubHeadList(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getSubHeadList(postingHeadWiseDto));
	}

	/**
	 * Test get detail head list PA.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetDetailHeadListPA() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(postingHeadWiseDto.getFundType()).thenReturn(LocConstant.PUBLIC_ACCOUNT);
		when(distributionDtlRepo.getDetailHeadListPA(JunitConstants.STRING_TYPE, JunitConstants.STRING_ABC,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getDetailHeadList(postingHeadWiseDto));

	}

	/**
	 * Test get detail head list.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetDetailHeadList() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(postingHeadWiseDto.getFundType()).thenReturn(JunitConstants.STRING_TYPE);
		when(distributionDtlRepo.getDetailHeadList(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);

		assertNotNull(service.getDetailHeadList(postingHeadWiseDto));

	}

	/**
	 * Test get item name list.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetItemNameList() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(distributionDtlRepo.getItemNameList(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);

		assertNotNull(service.getItemNameList(postingHeadWiseDto));

	}

	/**
	 * Test get estimate list PA.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetEstimateListPA() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(postingHeadWiseDto.getFundType()).thenReturn(LocConstant.PUBLIC_ACCOUNT);
		when(distributionDtlRepo.getBudgetEstimateTypeListPA(JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);

		assertNotNull(service.getBudgetEstimateTypeList(postingHeadWiseDto));

	}

	/**
	 * Test get estimate list.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetEstimateList() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(postingHeadWiseDto.getFundType()).thenReturn(JunitConstants.STRING_TYPE);
		when(distributionDtlRepo.getBudgetEstimateTypeList(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getBudgetEstimateTypeList(postingHeadWiseDto));

	}

	/**
	 * Test get object class.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetObjectClass() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(distributionDtlRepo.getObjectClassList(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, LocConstant.LOC_AUTHORIZED_ID)).thenReturn(objects);
		assertNotNull(service.getObjectClass(postingHeadWiseDto));

	}

	/**
	 * Test posting delete.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testPostingDelete() throws CustomException {
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(partyHeadWiseRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(partyHeadWiseSdEntity);
		when(partyHeadWiseSdEntity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE_ZERO);
		when(partyHeadWiseRepository.save(partyHeadWiseSdEntity)).thenReturn(partyHeadWiseSdEntity);
		assertNotNull(service.postingDtlsDelete(idDto));
	}

	/**
	 * Test get opening new balance.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetOpeningNewBalance() throws CustomException {
		Object[] object = new Object[2];
		object[0] = JunitConstants.DOUBLE_VAL;
		object[1] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(locAccCloseReqParamDto.getCardexNo()).thenReturn(JunitConstants.LONG_TYPE);
		when(locAccCloseReqParamDto.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(locAccCloseReqParamDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getOpeningNewBalance(locAccCloseReqParamDto));
		List<Object[]> objects1 = new ArrayList<>();
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects1);
		service.getOpeningNewBalance(locAccCloseReqParamDto);
	}

	/**
	 * Test get advice prep listing.
	 *
	 * @throws CustomException the custom exception
	 * @throws ParseException
	 */
	@Test
	void testGetAdvicePrepListing() throws CustomException, ParseException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		Object[] object = new Object[19];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.DATE;
		object[4] = JunitConstants.DATE;
		object[5] = JunitConstants.DATE;
		object[6] = JunitConstants.STRING_ABC;
		object[7] = JunitConstants.DATE;
		object[8] = JunitConstants.DOUBLE_VAL;
		object[9] = JunitConstants.DOUBLE_VAL;
		object[10] = JunitConstants.DATE;
		object[11] = JunitConstants.DATE;
		object[12] = JunitConstants.STRING_ABC;
		object[13] = JunitConstants.STRING_ABC;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.STRING_ABC;
		object[17] = JunitConstants.LONG_TYPE;
		object[18] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getAdvicePrepListing(pageDetail));

	}

	/**
	 * Test posting dtls add.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testPostingDtlsAdd() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		Object[] object = new Object[34];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
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
		object[13] = JunitConstants.STRING_ABC;
		object[14] = JunitConstants.STRING_ABC;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.STRING_ABC;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.STRING_ABC;
		object[19] = JunitConstants.STRING_ABC;
		object[20] = JunitConstants.LONG_TYPE;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.STRING_ABC;
		object[24] = JunitConstants.STRING_ABC;
		object[25] = JunitConstants.STRING_ABC;
		object[26] = JunitConstants.STRING_ABC;
		object[27] = JunitConstants.DOUBLE_VAL;
		object[28] = JunitConstants.DOUBLE_VAL;
		object[29] = JunitConstants.STRING_ABC;
		object[30] = JunitConstants.LONG_TYPE;
		object[31] = JunitConstants.STRING_ABC;
		object[32] = JunitConstants.LONG_TYPE;
		object[33] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.postingDtlsAdd(pageDetail));

	}

	/**
	 * Test cheque epay save.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testChequeEpaySave() throws CustomException {
		List<LocAdvcPrepCheqPaySdDto> cheqPaySdDtoList = new ArrayList<LocAdvcPrepCheqPaySdDto>();
		LocAdvcPrepCheqPaySdDto cheqPaySdDto2 = new LocAdvcPrepCheqPaySdDto();
		cheqPaySdDto2.setActiveStatus(JunitConstants.INTEGER_TYPE);
		cheqPaySdDto2.setSdId(JunitConstants.LONG_TYPE);
		LocAdvcPrepCheqPaySdDto cheqPaySdDto1 = new LocAdvcPrepCheqPaySdDto();
		cheqPaySdDto1.setActiveStatus(JunitConstants.INTEGER_TYPE);
		cheqPaySdDto1.setSdId(JunitConstants.LONG_TYPE);
		cheqPaySdDtoList.add(cheqPaySdDto);
		when(cheqPaySdDto.getChequeDt()).thenReturn(JunitConstants.DATE);
		when(cheqPaySdDto.getChequeAmnt()).thenReturn(JunitConstants.DOUBLE_VAL);
		sdEntityList.add(sdConverter.toEntity(cheqPaySdDto2));
		when(sdRepository.saveAll(sdEntityList)).thenReturn(sdEntityList);
		when(sdConverter.toDTO(sdEntityList)).thenReturn(cheqPaySdDtoList);
		assertNotNull(service.chequeEpaySave(cheqPaySdDtoList));

	}

	/**
	 * Test get posting dtls save.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPostingDtlsSave() throws CustomException {
		List<LocAdvicePartHeadwisedetaisSdDto> postingDtlsList = new ArrayList<LocAdvicePartHeadwisedetaisSdDto>();
		LocAdvicePartHeadwisedetaisSdDto sdDto = new LocAdvicePartHeadwisedetaisSdDto();
		sdDto.setActiveStatus(JunitConstants.INTEGER_TYPE);
		sdDto.setId(JunitConstants.LONG_TYPE);
		LocAdvicePartHeadwisedetaisSdDto sdDto1 = new LocAdvicePartHeadwisedetaisSdDto();
		sdDto1.setActiveStatus(JunitConstants.INTEGER_TYPE);
		sdDto1.setId(JunitConstants.LONG_TYPE);
		postingDtlsList.add(sdDto1);
		postingDtlsList.add(sdDto);
		when(partyHeadWiseRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(partyHeadWiseSdEntity);
		when(partyHeadWiseSdEntity.getExpenditureAmt()).thenReturn(JunitConstants.DOUBLE_VAL);
		when(partyHeadWiseSdEntity.getHeadwiseAvailableAmt()).thenReturn(JunitConstants.DOUBLE_VAL);
		when(partyHeadWiseSdEntity.getLcNo()).thenReturn(JunitConstants.STRING_ABC);
		when(partyHeadWiseRepository.save(partyHeadWiseSdEntity)).thenReturn(partyHeadWiseSdEntity);

		chqBookEditViewdto.setHdrId(JunitConstants.LONG_TYPE);
		chekPayEditViewDto.setActionStatus(JunitConstants.INTEGER_TYPE);
		assertNotNull(service.postingDtlsSave(postingDtlsList));
	}

	/**
	 * Test posting dtl map epayment.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testPostingDtlMapEpayment() throws CustomException {
		List<LocAdvcPrepCheqPaySdDto> sdList = new ArrayList<LocAdvcPrepCheqPaySdDto>();
		LocAdvcPrepCheqPaySdDto sdDto = new LocAdvcPrepCheqPaySdDto();
		sdDto.setSdId(JunitConstants.LONG_TYPE);
		sdList.add(sdDto);
		when(sdRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(sdEntity);
		when(sdEntity.getEpayAmnt()).thenReturn(JunitConstants.DOUBLE_VAL);
		when(sdEntity.getUpdatedBy()).thenReturn(JunitConstants.LONG_TYPE);
		when(sdEntity.getUpdatedByPost()).thenReturn(JunitConstants.LONG_TYPE);
		when(sdEntity.getUpdatedDate()).thenReturn(JunitConstants.DATE);
		when(sdRepository.save(sdEntity)).thenReturn(sdEntity);
		when(sdConverter.toDTO(sdEntity)).thenReturn(cheqPaySdDto);
		sdList.add(sdDto);
		assertNotNull(service.getPostingDtlUpdtEpymntAmnt(sdList));
	}

	/**
	 * Test get srch param.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSearchParam() throws CustomException {
		Object[] obj = new Object[3];
		obj[0] = JunitConstants.STRING_ABC;
		obj[1] = JunitConstants.LONG_TYPE;
		obj[2] = JunitConstants.STRING_ABC;
		List<Object[]> objList = new ArrayList<>();
		objList.add(obj);
		when(hdrRepo.getSearchParam()).thenReturn(objList);
		assertNotNull(service.getSearchParam());
	}

	/**
	 * Test get cheque book data.
	 *
	 * @throws CustomException the custom exception
	 */
//	@Test
//	void testGetChequeBookData() throws CustomException {
//		Object[] obj = new Object[5];
//		obj[0] = JunitConstants.STRING_ABC;
//		obj[1] = JunitConstants.STRING_ABC;
//		obj[2] = JunitConstants.STRING_ABC;
//		obj[3] = JunitConstants.STRING_ABC;
//		obj[4] = new ArrayList<LocAdviceEpayChqDtlDto>();
//		List<Object[]> objList = new ArrayList<>();
//		objList.add(obj);
//		List<String> stringList = new ArrayList<String>();
//		stringList.add(JunitConstants.STRING_ABC);
//		when(locAccCloseReqParamDto.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
//		when(locAccCloseReqParamDto.getCardexNo()).thenReturn(JunitConstants.LONG_TYPE);
//		when(locAccCloseReqParamDto.getDdoNo()).thenReturn(JunitConstants.STRING_ABC);
//
//		when(hdrRepo.getChqSeriesFromChqActInactive(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
//				JunitConstants.STRING_ABC, JunitConstants.INTEGER_TYPE)).thenReturn(objList);
//		when(hdrRepo.getLocAdviceChqList(locAccCloseReqParamDto.getDistrictId(), locAccCloseReqParamDto.getCardexNo(),
//				locAccCloseReqParamDto.getDdoNo(), Constant.ACTIVE_STATUS)).thenReturn(objList);
//		when(hdrRepo.getLatestChq(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.STRING_ABC,
//				JunitConstants.INTEGER_TYPE)).thenReturn(stringList);
//		assertNotNull(service.getChequeBookData(locAccCloseReqParamDto));
//		List<String> stringList1 = new ArrayList<String>();
//		when(hdrRepo.getLatestChq(locAccCloseReqParamDto.getDistrictId(), locAccCloseReqParamDto.getCardexNo(),
//				locAccCloseReqParamDto.getDdoNo(), Constant.ACTIVE_STATUS)).thenReturn(stringList1);
//		service.getChequeBookData(locAccCloseReqParamDto);
//
//	}

	/**
	 * Test on receive.
	 */
	@Test
	void testOnReceive() {
		List<LocAdviceReqParamDto> dtoList = new ArrayList<>();
		LocAdviceReqParamDto dto = new LocAdviceReqParamDto();
		dto.setHdrId(JunitConstants.LONG_TYPE);
		dtoList.add(dto);
		when(hdrRepo.getOne(JunitConstants.LONG_TYPE)).thenReturn(hdrEntity);
		when(hdrEntity.getVirtualTokenNo()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(hdrEntity.getVirtualTokenDate()).thenReturn(JunitConstants.DATE);
		when(hdrEntity.getUpdatedBy()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrEntity.getUpdatedByPost()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrEntity.getUpdatedDate()).thenReturn(JunitConstants.DATE);
		when(hdrRepo.save(hdrEntity)).thenReturn(hdrEntity);
		assertNotNull(service.onReceive(dtoList));
	}

	/**
	 * Test get advice inward listing.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testAdviceInwardListing() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		Object[] object = new Object[18];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_TYPE;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.DATE;
		object[4] = JunitConstants.STRING_TYPE;
		object[5] = JunitConstants.DATE;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_TYPE;
		object[8] = JunitConstants.STRING_TYPE;
		object[9] = JunitConstants.STRING_TYPE;
		object[10] = JunitConstants.STRING_TYPE;
		object[11] = JunitConstants.STRING_TYPE;
		object[12] = JunitConstants.LONG_TYPE;
		object[13] = JunitConstants.STRING_TYPE;
		object[14] = JunitConstants.DOUBLE_VAL;
		object[15] = JunitConstants.DOUBLE_VAL;
		object[16] = JunitConstants.DOUBLE_VAL;
		object[17] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getAdviceInwardListing(pageDetail));

	}

	/**
	 * Test get advice cardex verification listing.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testAdviceCardexVerificationListing() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		Object[] object = new Object[23];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_TYPE;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.STRING_TYPE;
		object[4] = JunitConstants.STRING_TYPE;
		object[5] = JunitConstants.STRING_TYPE;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_TYPE;
		object[8] = JunitConstants.DATE;
		object[9] = JunitConstants.DATE;
		object[10] = JunitConstants.DOUBLE_VAL;
		object[11] = JunitConstants.STRING_TYPE;
		object[12] = JunitConstants.STRING_TYPE;
		object[13] = JunitConstants.DATE;
		object[14] = JunitConstants.DOUBLE_VAL;
		object[15] = JunitConstants.DOUBLE_VAL;
		object[16] = JunitConstants.DATE;
		object[17] = JunitConstants.DATE;
		object[18] = JunitConstants.STRING_TYPE;
		object[19] = JunitConstants.STRING_TYPE;
		object[20] = JunitConstants.STRING_TYPE;
		object[21] = JunitConstants.LONG_TYPE;
		object[22] = JunitConstants.LONG_TYPE;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getAdviceCardexVerificationListing(pageDetail));

	}

	/**
	 * Test get advice Verification listing.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAdviceVerificationListing() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		Object[] object = new Object[22];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.DATE;
		object[3] = JunitConstants.STRING_TYPE;
		object[4] = JunitConstants.DATE;
		object[5] = JunitConstants.STRING_TYPE;
		object[6] = JunitConstants.STRING_TYPE;
		object[7] = JunitConstants.STRING_TYPE;
		object[8] = JunitConstants.DOUBLE_VAL;
		object[9] = JunitConstants.DOUBLE_VAL;
		object[10] = JunitConstants.DOUBLE_VAL;
		object[11] = JunitConstants.STRING_TYPE;
		object[12] = JunitConstants.STRING_TYPE;
		object[13] = JunitConstants.DATE;
		object[14] = JunitConstants.STRING_TYPE;
		object[15] = JunitConstants.DATE;
		object[16] = JunitConstants.STRING_TYPE;
		object[17] = JunitConstants.STRING_TYPE;
		object[18] = JunitConstants.STRING_TYPE;
		object[19] = JunitConstants.DATE;
		object[20] = JunitConstants.LONG_TYPE;
		object[21] = JunitConstants.LONG_TYPE;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getAdviceVerficationListing(pageDetail));

	}

	/**
	 * Test get advice authorization listing.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAdviceAuthorizationListing() throws CustomException {
		SearchParam mockSearch = Mockito.mock(SearchParam.class);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INT_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INT_TYPE);
		when(mockSearch.getKey()).thenReturn(JunitConstants.STRING_ABC);
		when(mockSearch.getValue()).thenReturn(JunitConstants.STRING_ABC);
		List<SearchParam> srchParam = new ArrayList<>();
		when(pageDetail.getJsonArr()).thenReturn(srchParam);
		Object[] object = new Object[21];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.DATE;
		object[3] = JunitConstants.STRING_TYPE;
		object[4] = JunitConstants.DATE;
		object[5] = JunitConstants.STRING_TYPE;
		object[6] = JunitConstants.STRING_TYPE;
		object[7] = JunitConstants.STRING_TYPE;
		object[8] = JunitConstants.DOUBLE_VAL;
		object[9] = JunitConstants.DOUBLE_VAL;
		object[10] = JunitConstants.DOUBLE_VAL;
		object[11] = JunitConstants.STRING_TYPE;
		object[12] = JunitConstants.DATE;
		object[13] = JunitConstants.STRING_TYPE;
		object[14] = JunitConstants.DATE;
		object[15] = JunitConstants.STRING_TYPE;
		object[16] = JunitConstants.STRING_TYPE;
		object[17] = JunitConstants.STRING_TYPE;
		object[18] = JunitConstants.DATE;
		object[19] = JunitConstants.LONG_TYPE;
		object[20] = JunitConstants.LONG_TYPE;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(hdrRepo.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getAdviceAuthorizationListing(pageDetail));

	}

	@Test
	void testLcAdviceStatementPdf() throws CustomException {
		Object[] object = new Object[31];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = "wetetetetetsuusdhdughsedf";
		object[2] = JunitConstants.DATE;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.LONG_TYPE;
		object[9] = JunitConstants.STRING_ABC;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.LONG_TYPE;
		object[13] = JunitConstants.STRING_ABC;
		object[14] = JunitConstants.LONG_TYPE;
		object[15] = JunitConstants.STRING_ABC;
		object[16] = JunitConstants.LONG_TYPE;
		object[17] = JunitConstants.STRING_ABC;
		object[18] = JunitConstants.STRING_ABC;
		object[19] = JunitConstants.STRING_ABC;
		object[20] = JunitConstants.STRING_ABC;
		object[21] = JunitConstants.STRING_ABC;
		object[22] = JunitConstants.STRING_ABC;
		object[23] = JunitConstants.DATE;
		object[24] = JunitConstants.LONG_TYPE;
		object[25] = JunitConstants.STRING_ABC;
		object[26] = JunitConstants.DOUBLE_VAL;
		object[27] = JunitConstants.DOUBLE_VAL;
		object[28] = JunitConstants.DOUBLE_VAL;
		object[29] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		Object[] object1 = new Object[9];
		object1[0] = JunitConstants.LONG_TYPE;
		object1[1] = JunitConstants.LONG_TYPE;
		object1[2] = JunitConstants.STRING_ABC;
		object1[3] = JunitConstants.LONG_TYPE;
		object1[4] = JunitConstants.STRING_ABC;
		object1[5] = JunitConstants.DOUBLE_VAL;
		object1[6] = JunitConstants.DATE;
		object1[7] = JunitConstants.STRING_ABC;
		object1[8] = JunitConstants.DOUBLE_VAL;
		List<Object[]> objects1 = new ArrayList<>();
		objects1.add(object1);

		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("header", adviceHdrDetails);
		inputMap.put("chqDtl", "abc");
		inputMap.put("pstDtl", "wer");
		when(adviceHdrDetails.getAdviceNo()).thenReturn("qwqweeeedfwefdwefwefwefw");

		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(hdrRepo.getAdviceDtlViewData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(objects);
		when(checkPayDtlRepo.getPostingDtlEditData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
				.thenReturn(objects1);
		when(hdrRepo.getPostingDtlViewData(JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(objects);
		when(hrdSdRepository.findByLcAdviceIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(dedSdEntity);
		when(pdfService.generatePDF(LocURLConstant.ADVICE_STATEMENT_FTL_FILE, inputMap,
				LocConstant.ADVICE_PDF_FILE_NAME + adviceHdrDetails.getAdviceNo())).thenReturn("wewewewewewewewewe");

		assertNotNull(service.lcAdviceStatementPdf(idDto));
	}

	/**
	 * Test get advice verify auth search param.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAdviceVerifyAuthSearchParam() throws CustomException {
		Object[] object = new Object[13];
		object[0] = JunitConstants.STRING_ABC;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.STRING_ABC;

		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.STRING_ABC;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.STRING_ABC;
		object[8] = JunitConstants.STRING_ABC;
		object[9] = JunitConstants.LONG_TYPE;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_ABC;
		object[12] = JunitConstants.STRING_ABC;
		List<Object[]> listObj = new ArrayList<>();
		listObj.add(object);
		when(hdrRepo.getAdviceVerifyAuthSearchParam()).thenReturn(listObj);
		assertNotNull(service.getAdviceVerifyAuthSearchParam());
	}

	/**
	 * Test get inward cardex search param.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetInwardCardexSearchParam() throws CustomException {
		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_ABC;
		object[2] = JunitConstants.STRING_ABC;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.STRING_ABC;
		object[5] = JunitConstants.STRING_ABC;
		List<Object[]> listObj = new ArrayList<>();
		listObj.add(object);
		when(hdrRepo.getInwardCardexSearchParam()).thenReturn(listObj);
		assertNotNull(service.getInwardCardexSearchParam());
	}

	/**
	 * Test get multiple.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetMultiple() throws CustomException {
		Object[] object = new Object[3];
		object[0] = JunitConstants.STRING_ABC;
		object[1] = JunitConstants.DOUBLE_VAL;
		object[2] = JunitConstants.DOUBLE_VAL;
		List<Object[]> listObj = new ArrayList<>();
		listObj.add(object);
		when(hdrRepo.getMultipleList(Mockito.anyLong(), Mockito.anyInt())).thenReturn(listObj);
		assertNotNull(service.getMultiple(idDto));
	}

	/**
	 * Test get advice inward generate token no listing.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGenerateTokenNo() {
		List<LocAdviceReqParamDto> paramDtoList = new ArrayList<>();
		LocAdviceReqParamDto paramDto = new LocAdviceReqParamDto();
		paramDto.setCardexNo(JunitConstants.LONG_TYPE);
		paramDto.setDdoNo(JunitConstants.STRING_TYPE);
		paramDto.setDistrictId(JunitConstants.LONG_TYPE);
		paramDtoList.add(paramDto);
		LocAdviceReqParamDto paramDto1 = new LocAdviceReqParamDto();
		paramDto1.setCardexNo(JunitConstants.LONG_TYPE);
		paramDto1.setDdoNo(JunitConstants.STRING_TYPE);
		paramDto1.setDistrictId(JunitConstants.LONG_TYPE);
		paramDtoList.add(paramDto1);
		when(hdrRepo.findMaxTokenNoByCardexNoAndDdoNoAndDistrictIdAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
						.thenReturn(JunitConstants.INTEGER_TYPE);
		assertNotNull(service.generateTokenNo(paramDtoList));
	}

	@Test
	void testGenAuthLetter() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.STRING_ABC;
		object[1] = JunitConstants.DATE;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.STRING_ABC;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("header", locAdvicePrepDtlDto);
		inputMap.put("chqDtl", "abc");
		inputMap.put("pstDtl", "wer");
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(partyDRepo.getAdvicePrepHdrDtoByHdrIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn(locAdvicePrepDtlDto);

		when(dtlRepo.getEditViewData(Mockito.anyLong(), Mockito.anyInt())).thenReturn(objects);

		when(pdfService.generatePDF(LocURLConstant.ADVICE_STATEMENT_FTL_FILE, inputMap,
				LocConstant.ADVICE_PDF_FILE_NAME + locAdvicePrepDtlDto.getChequeDate()))
						.thenReturn(JunitConstants.STRING_ABC);

		assertNotNull(service.genAuthLetter(idDto));
	}
}